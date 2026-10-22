package com.bytedance.android.livesdk.feed.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.utils.rxutils.RxViewModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.feed.IFeedRepository;
import com.bytedance.android.livesdk.feed.setting.LiveFeedSettings;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveFeedViewModel extends RxViewModel {
    public static final String DOUBLE_FEED_WITH_BANNER = "5";
    private final IFeedRepository feedRepository;
    private String feedUrl;
    private com.bytedance.android.livesdk.feed.feed.d itemFilter;
    private final List<com.bytedance.android.livesdk.feed.feed.e> itemTab;
    private boolean mSupportDrawerSkyLight;
    private boolean mSupportSubTab;
    private boolean newFeedStyle;
    private com.bytedance.android.livesdk.feed.f.a removeListener;
    private final MutableLiveData<Integer> tabItemPos;

    public static /* synthetic */ void Mo(LiveFeedViewModel r0, String r1) {
        r0.handDataRemove(r1);
    }

    public static /* synthetic */ void yo(LiveFeedViewModel r0, String r1, List r2, FeedExtra r3, boolean r4) {
        r0.handleData(r1, r2, r3, r4);
    }

    public void onCleared() {
        this.feedRepository.Bf().f(this.itemFilter);
        this.feedRepository.Bf().b(this.removeListener);
        this.itemFilter = null;
        super.onCleared();
    }

    public void setup() {
        if (this.itemFilter == null) goto L5;
        return;
    L5:
        this.itemFilter = new u(this);
        this.removeListener = new v(this);
        this.feedRepository.Bf().c(this.itemFilter);
        this.feedRepository.Bf().i(this.removeListener);
    }

    public LiveData<Integer> getTabItemPos() {
        return this.tabItemPos;
    }

    private void handDataRemove(String r6) {
        if (TextUtils.isEmpty(this.feedUrl) == false) goto L32;
        return;
    L32:
        String r7 = UriProtector.getQueryParameter(UriProtector.parse(this.feedUrl), "style");     // Catch: Exception -> L6
    L8:
        if (DOUBLE_FEED_WITH_BANNER.equals(r7) == false) goto L37;
        List<FeedItem> r8 = this.feedRepository.getFeedItems();
        if (CollectionUtils.isEmpty(r8) == true) goto L38;
        int r1 = 0;
        boolean r2 = true;
    L13:
        if (r1 >= r8.size()) goto L39;
        if (((FeedItem) ListProtector.get(r8, r1)).type != 6) goto L30;
        if ((r1 % 2) != 1) goto L23;
        if (r2 == true) goto L20;
    L29:
        r2 = !r2;
        goto L30
    L20:
        if (r1 >= (r8.size() - 1)) goto L22;
        int r3 = r1 + 1;
        Collections.swap(r8, r1, r3);
    L27:
        r1 = r3;
        goto L29
    L22:
        Collections.swap(r8, r1, r1 - 1);
        goto L29
    L23:
        if (r2 == true) goto L29;
        if (r1 >= (r8.size() - 1)) goto L28;
        r3 = r1 + 1;
        Collections.swap(r8, r1, r3);
        goto L27
    L28:
        Collections.swap(r8, r1, r1 - 1);
    L30:
        r1 = r1 + 1;
        goto L13
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L6:
        r7 = null;
        goto L8
    }

    public void setNewFeedStyle(boolean r2) {
        this.newFeedStyle = r2;
        this.feedRepository.I60(r2);
    }

    public void setStartUrl(String r1) {
        this.feedUrl = r1;
    }

    public LiveFeedViewModel(IFeedRepository r3, List<com.bytedance.android.livesdk.feed.feed.e> r4) {
        this.tabItemPos = new MutableLiveData();
        this.newFeedStyle = false;
        this.feedUrl = null;
        this.mSupportSubTab = true;
        this.mSupportDrawerSkyLight = false;
        this.feedRepository = r3;
        this.itemTab = r4;
    }

    public LiveFeedViewModel(IFeedRepository r3, List<com.bytedance.android.livesdk.feed.feed.e> r4, boolean r5) {
        this.tabItemPos = new MutableLiveData();
        this.newFeedStyle = false;
        this.feedUrl = null;
        this.mSupportDrawerSkyLight = false;
        this.feedRepository = r3;
        this.itemTab = r4;
        this.mSupportSubTab = r5;
    }

    private void handleData(String r17, List<FeedItem> r18, FeedExtra r19, boolean r20) {
        if (Lists.isEmpty(r18) == true) goto L117;
        if (r19 == null) goto L161;
        this.feedUrl = r17;
        if (TextUtils.isEmpty(r17) == false) goto L118;
    L11:
        String r3 = null;
    L13:
        if (r20 == false) goto L92;
        ListIterator<FeedItem> r7 = r18.listIterator();
    L16:
        if (r7.hasNext() == false) goto L23;
        int r8 = r7.next().type;
        if (r8 == 1001) goto L22;
        if (r8 == 1002) goto L22;
        if (r8 != 1003) goto L16;
    L22:
        r7.remove();
        goto L16
    L23:
        Iterator<FeedItem> r9 = r18.iterator();
    L25:
        if (r9.hasNext() == false) goto L35;
        FeedItem r10 = r9.next();
        if (r10.type != 6) goto L25;
        com.bytedance.android.live.base.model.banner.b r11 = r10.bannerContainer;
        if (r11 == null) goto L34;
        if (CollectionUtils.isEmpty(r11.a()) == true) goto L34;
        r10.banners = r10.bannerContainer.a();
    L34:
        r9.remove();
        goto L25
    L35:
        int r4 = r18.size();
        if (((Integer) LiveFeedSettings.FEED_LIVE_BANNER_POSITION.getValue()).intValue() != 0) goto L51;
        com.bytedance.android.live.base.model.banner.b r12 = r19.bannerContainer;
        if (r12 == null) goto L51;
        if (Lists.notEmpty(r12.a()) == false) goto L51;
        if (DOUBLE_FEED_WITH_BANNER.equals(r3) == true) goto L51;
        FeedItem r13 = new FeedItem();
        r13.type = BubbleId.PadCastForVs;
        r13.banners = r19.bannerContainer.a();
        if (r18.size() > 0) goto L46;
    L48:
        int r14 = 0;
    L49:
        ListProtector.add(r18, r14, r13);
        goto L51
    L46:
        if (((FeedItem) ListProtector.get(r18, 0)).type != 1004) goto L48;
        r14 = 1;
    L51:
        if (this.mSupportSubTab == true) goto L53;
    L61:
        boolean r15 = false;
    L63:
        if (this.mSupportDrawerSkyLight == true) goto L79;
        ArrayList r16 = new ArrayList();
        Iterator<FeedItem> r110 = r18.iterator();
    L66:
        if (r110.hasNext() == false) goto L72;
        FeedItem r111 = r110.next();
        if (r111.type != 2) goto L66;
        r16.add(r111);
        r110.remove();
        goto L66
    L72:
        if (Lists.isEmpty(r16) == true) goto L79;
        if (this.newFeedStyle == true) goto L79;
        com.bytedance.android.livesdk.feed.feed.c r112 = new com.bytedance.android.livesdk.feed.feed.c(r16);
        ((FeedItem) r112).type = BubbleId.LiveAdmin;
        ((FeedItem) r112).resId = "";
        r112.setItem(null);
        ListProtector.add(r18, 0, r112);
        if (r15 == false) goto L79;
        this.tabItemPos.postValue(1);
    L79:
        if (((Integer) LiveFeedSettings.FEED_LIVE_BANNER_POSITION.getValue()).intValue() != 1) goto L104;
        com.bytedance.android.live.base.model.banner.b r5 = r19.bannerContainer;
        if (r5 == null) goto L104;
        if (r5.a() == null) goto L104;
        if (r19.bannerContainer.a().size() <= 0) goto L104;
        if (DOUBLE_FEED_WITH_BANNER.equals(r3) == true) goto L104;
        FeedItem r6 = new FeedItem();
        r6.type = BubbleId.PadCastForVs;
        r6.banners = r19.bannerContainer.a();
        if ((r4 % 2) != 0) goto L91;
        r18.add(r6);
        goto L104
    L91:
        ListProtector.add(r18, r18.size() - 1, r6);
    L104:
        Iterator<FeedItem> r1 = r18.iterator();
        RoomContext r2 = RoomContext.getShared();
    L106:
        if (r1.hasNext() == false) goto L162;
        FeedItem r21 = r1.next();
        if (r2 == null) goto L106;
        if (r2.isVSRoom() == false) goto L106;
        if (r2.isVSSpecialDrawer() == false) goto L106;
        int r22 = r21.type;
        if (r22 == 27) goto L106;
        if (r22 == 1) goto L106;
        r1.remove();
        goto L106
    L162:
        return;
    L53:
        if (this.newFeedStyle == true) goto L61;
        List<com.bytedance.android.livesdk.feed.feed.e> r23 = this.itemTab;
        if (r23 == null) goto L61;
        if (Lists.isEmpty(r23) == true) goto L61;
        if (this.itemTab.size() <= 1) goto L61;
        FeedItem r24 = new FeedItem();
        r24.type = BubbleId.AudiencePublicScreenConfig;
        com.bytedance.android.livesdk.feed.feed.h r25 = new com.bytedance.android.livesdk.feed.feed.h();
        r25.a = this.itemTab;
        r24.setItem(r25);
        ListProtector.add(r18, 0, r24);
        this.tabItemPos.postValue(0);
        r15 = true;
        goto L63
    L92:
        Iterator<FeedItem> r26 = r18.iterator();
    L94:
        if (r26.hasNext() == false) goto L104;
        FeedItem r27 = r26.next();
        if (r27.type != 6) goto L94;
        com.bytedance.android.live.base.model.banner.b r28 = r27.bannerContainer;
        if (r28 == null) goto L103;
        if (CollectionUtils.isEmpty(r28.a()) == true) goto L103;
        r27.banners = r27.bannerContainer.a();
    L103:
        r26.remove();
        goto L94
    L118:
        r3 = UriProtector.getQueryParameter(UriProtector.parse(r17), "style");     // Catch: Exception -> L10
    L161:
        return;
    }
}
