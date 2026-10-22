package vw1;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.banner.b;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.feed.feed.c;
import com.bytedance.android.livesdk.feed.feed.d;
import com.bytedance.android.livesdk.feed.setting.LiveFeedSettings;
import com.bytedance.android.livesdk.feed.viewmodel.LiveFeedViewModel;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements d {
    public a() {
        new MutableLiveData();
    }

    @Override // com.bytedance.android.livesdk.feed.feed.d
    public final void a(String r17, List<FeedItem> r18, FeedExtra r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r18, "items");
        if (Lists.isEmpty(r18) == true) goto L125;
        if (r19 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r17) == false) goto L126;
    L11:
        String r2 = null;
    L13:
        if (r20 == false) goto L107;
        ArrayList r5 = (ArrayList) r18;
        ListIterator r6 = r5.listIterator();
    L16:
        if (r6.hasNext() == false) goto L28;
        FeedItem r7 = (FeedItem) r6.next();
        if (r7 != null) goto L20;
    L21:
        if (r7 != null) goto L23;
    L24:
        if (r7 == null) goto L16;
        if (r7.type != 1003) goto L16;
    L27:
        r6.remove();
        goto L16
    L23:
        if (r7.type == 1002) goto L27;
    L20:
        if (r7.type == 1001) goto L27;
    L28:
        Iterator r8 = r5.iterator();
    L30:
        if (r8.hasNext() == false) goto L46;
        FeedItem r9 = (FeedItem) r8.next();
        if (r9 == null) goto L30;
        if (r9.type != 6) goto L30;
        b r10 = r9.bannerContainer;
        if (r10 == null) goto L45;
        if (CollectionUtils.isEmpty(r10.b()) == true) goto L45;
        b r11 = r9.bannerContainer;
        if (r11 == null) goto L43;
        List r12 = r11.b();
    L44:
        r9.banners = r12;
        goto L30
    L43:
        r12 = null;
    L45:
        r8.remove();
        goto L30
    L46:
        int r4 = r5.size();
        Integer r13 = (Integer) LiveFeedSettings.FEED_LIVE_BANNER_POSITION.getValue();
        int r14 = 0;
        if (r13 != null) goto L50;
    L70:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r5.iterator();
    L72:
        if (r16.hasNext() == false) goto L79;
        FeedItem r110 = (FeedItem) r16.next();
        if (r110 == null) goto L72;
        if (r110.type != 2) goto L72;
        r15.add(r110);
        r16.remove();
        goto L72
    L79:
        if (Lists.isEmpty(r15) == true) goto L81;
        c r111 = new c(r15);
        ((FeedItem) r111).type = BubbleId.LiveAdmin;
        ((FeedItem) r111).resId = "";
        r111.setItem(null);
        ListProtector.add(r18, 0, r111);
    L81:
        Integer r3 = (Integer) LiveFeedSettings.FEED_LIVE_BANNER_POSITION.getValue();
        if (r3 != null) goto L85;
        return;
    L85:
        if (r3.intValue() != 1) goto L166;
        b r21 = r19.bannerContainer;
        if (r21 != null) goto L89;
        return;
    L89:
        if (r21.b() == null) goto L168;
        b r22 = r19.bannerContainer;
        if (r22 == null) goto L95;
        List r23 = r22.b();
        if (r23 == null) goto L95;
        r14 = r23.size();
    L95:
        if (r14 > 0) goto L97;
        return;
    L97:
        if ((!Intrinsics.areEqual(LiveFeedViewModel.DOUBLE_FEED_WITH_BANNER, r2)) == false) goto L170;
        FeedItem r24 = new FeedItem();
        r24.type = BubbleId.PadCastForVs;
        b r1 = r19.bannerContainer;
        if (r1 == null) goto L102;
        List r25 = r1.b();
        if (r25 == null) goto L102;
    L103:
        r24.banners = r25;
        if ((r4 % 2) != 0) goto L106;
        r5.add(r24);
        return;
    L106:
        ListProtector.add(r18, r5.size() - 1, r24);
        return;
    L102:
        r25 = CollectionsKt.emptyList();
        goto L103
    L170:
        return;
    L168:
        return;
    L166:
        return;
    L50:
        if (r13.intValue() != 0) goto L70;
        b r26 = r19.bannerContainer;
        if (r26 == null) goto L70;
        if (Lists.notEmpty(r26.b()) == false) goto L70;
        if ((!Intrinsics.areEqual(LiveFeedViewModel.DOUBLE_FEED_WITH_BANNER, r2)) == false) goto L70;
        FeedItem r27 = new FeedItem();
        r27.type = BubbleId.PadCastForVs;
        b r112 = r19.bannerContainer;
        if (r112 == null) goto L60;
        List r113 = r112.b();
    L61:
        r27.banners = r113;
        if (r5.size() <= 0) goto L68;
        FeedItem r114 = (FeedItem) ListProtector.get(r18, 0);
        if (r114 == null) goto L68;
        if (r114.type != 1004) goto L68;
        int r115 = 1;
    L69:
        ListProtector.add(r18, r115, r27);
    L68:
        r115 = 0;
        goto L69
    L60:
        r113 = null;
        goto L61
    L107:
        Iterator r0 = ((ArrayList) r18).iterator();
    L109:
        if (r0.hasNext() == false) goto L175;
        FeedItem r28 = (FeedItem) r0.next();
        if (r28 == null) goto L109;
        if (r28.type != 6) goto L109;
        b r29 = r28.bannerContainer;
        if (r29 == null) goto L124;
        if (CollectionUtils.isEmpty(r29.b()) == true) goto L124;
        b r30 = r28.bannerContainer;
        if (r30 == null) goto L122;
        List r31 = r30.b();
    L123:
        r28.banners = r31;
        goto L109
    L122:
        r31 = null;
    L124:
        r0.remove();
        goto L109
    L175:
        return;
    L126:
        r2 = UriProtector.getQueryParameter(UriProtector.parse(r17), "style");     // Catch: Exception -> L10
    }
}
