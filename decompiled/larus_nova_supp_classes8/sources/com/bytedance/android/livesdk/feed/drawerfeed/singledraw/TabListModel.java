package com.bytedance.android.livesdk.feed.drawerfeed.singledraw;

import androidx.lifecycle.ViewModel;
import bw1.e;
import com.bytedance.android.live.base.model.banner.OperationCard;
import com.bytedance.android.live.base.model.banner.OperationMultipleRoom;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livesdk.feed.IFeedRepository;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.OperationSingleDrawViewHolder;
import com.bytedance.android.livesdk.feed.x0;
import com.bytedance.android.livesdk.viewmodel.SingleDrawViewModel;
import com.bytedance.android.livesdk.viewmodel.j;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import cw1.c;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 L2\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\bJ\u0010KJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J&\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\f\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0010\u001a\u00020\u0004R;\u0010\u0013\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u000e0\u000e \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\b0\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00103\u001a\u0004\b9\u00105\"\u0004\b:\u00107R'\u0010=\u001a\u0012\u0012\u0004\u0012\u00020!0;j\b\u0012\u0004\u0012\u00020!`<8\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010C\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\"\u0010E\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010B\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006N"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/singledraw/TabListModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/viewmodel/SingleDrawViewModel;", "viewModel", "", "init", "", "tabId", "", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "feedList", "", "feedAction", "onDataUpdata", "Lcom/bytedance/android/livesdk/feed/feed/e;", "getFeedTabItem", "onDialogClose", "", "kotlin.jvm.PlatformType", "tabList", "Ljava/util/List;", "getTabList", "()Ljava/util/List;", "", "isMultiTab", "Z", "()Z", "defaultTab", "Lcom/bytedance/android/livesdk/feed/feed/e;", "getDefaultTab", "()Lcom/bytedance/android/livesdk/feed/feed/e;", "setDefaultTab", "(Lcom/bytedance/android/livesdk/feed/feed/e;)V", "Lbw1/e;", "currentTabModel", "Lbw1/e;", "getCurrentTabModel", "()Lbw1/e;", "setCurrentTabModel", "(Lbw1/e;)V", "chosenTab", "getChosenTab", "setChosenTab", "Lio/reactivex/disposables/Disposable;", "updateDisposable", "Lio/reactivex/disposables/Disposable;", "getUpdateDisposable", "()Lio/reactivex/disposables/Disposable;", "setUpdateDisposable", "(Lio/reactivex/disposables/Disposable;)V", "tagId", "J", "getTagId", "()J", "setTagId", "(J)V", "tabType", "getTabType", "setTabType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tabItemModelList", "Ljava/util/ArrayList;", "getTabItemModelList", "()Ljava/util/ArrayList;", "tabSize", "I", "singleDrawViewModel", "Lcom/bytedance/android/livesdk/viewmodel/SingleDrawViewModel;", "currentStatus", "getCurrentStatus", "()I", "setCurrentStatus", "(I)V", "<init>", "()V", "Companion", "a", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabListModel extends ViewModel {
    public static final a Companion = null;
    private static final String NEW_REQ_FROM_ENTER_AUTO = null;
    private static final String REQ_FROM_ENTER_AUTO = null;
    private static final String REQ_FROM_FEED_LOAD_MORE = null;
    private static final long TIME_REFRESH = 0;
    private e chosenTab;
    private int currentStatus;
    private e currentTabModel;
    private com.bytedance.android.livesdk.feed.feed.e defaultTab;
    private final boolean isMultiTab;
    private SingleDrawViewModel singleDrawViewModel;
    private final ArrayList<e> tabItemModelList;
    private final List<com.bytedance.android.livesdk.feed.feed.e> tabList;
    private final int tabSize;
    private long tabType;
    private long tagId;
    private Disposable updateDisposable;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ TabListModel a;

        public b(TabListModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.getTabItemModelList().clear();
            Disposable r4 = this.a.getUpdateDisposable();
            if (r4 == null) goto L5;
            r4.dispose();
        L5:
            this.a.setUpdateDisposable(null);
        }
    }

    static {
        Companion = new a();
        REQ_FROM_ENTER_AUTO = "enter_auto";
        REQ_FROM_FEED_LOAD_MORE = "feed_loadmore";
        NEW_REQ_FROM_ENTER_AUTO = "enter_auto_from_room";
        TIME_REFRESH = 5;
    }

    public final com.bytedance.android.livesdk.feed.feed.e getFeedTabItem() {
        List<com.bytedance.android.livesdk.feed.feed.e> r0 = this.tabList;
        Object r1 = null;
        if (r0 == null) goto L20;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L14;
        Object r3 = r2.next();
        boolean r4 = true;
        if (((com.bytedance.android.livesdk.feed.feed.e) r3).getType() == 1) goto L11;
        r4 = false;
    L11:
        if (r4 == false) goto L6;
        r1 = r3;
    L14:
        return (com.bytedance.android.livesdk.feed.feed.e) r1;
    L20:
        return null;
    }

    public final void onDialogClose() {
        Observable r0 = Observable.timer(TIME_REFRESH, TimeUnit.MINUTES);
        if (r0 == null) goto L5;
        Disposable r1 = r0.subscribe(new b(this));
    L6:
        this.updateDisposable = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public TabListModel() {
        boolean r0 = x0.d;
        List<com.bytedance.android.livesdk.feed.feed.e> r1 = x0.a.a().c();
        this.tabList = r1;
        this.isMultiTab = k.n(IHostFeed.class).shouldDrawerMultiTab();
        this.tagId = -1;
        this.tabType = -1;
        this.tabItemModelList = new ArrayList();
        this.tabSize = r1.size();
        this.currentStatus = -1;
    }

    public static final /* synthetic */ String access$getNEW_REQ_FROM_ENTER_AUTO$cp() {
        return NEW_REQ_FROM_ENTER_AUTO;
    }

    public static final /* synthetic */ String access$getREQ_FROM_ENTER_AUTO$cp() {
        return REQ_FROM_ENTER_AUTO;
    }

    public static final /* synthetic */ String access$getREQ_FROM_FEED_LOAD_MORE$cp() {
        return REQ_FROM_FEED_LOAD_MORE;
    }

    public static final /* synthetic */ long access$getTIME_REFRESH$cp() {
        return TIME_REFRESH;
    }

    public final e getChosenTab() {
        return this.chosenTab;
    }

    public final int getCurrentStatus() {
        return this.currentStatus;
    }

    public final e getCurrentTabModel() {
        return this.currentTabModel;
    }

    public final com.bytedance.android.livesdk.feed.feed.e getDefaultTab() {
        return this.defaultTab;
    }

    public final ArrayList<e> getTabItemModelList() {
        return this.tabItemModelList;
    }

    public final List<com.bytedance.android.livesdk.feed.feed.e> getTabList() {
        return this.tabList;
    }

    public final long getTabType() {
        return this.tabType;
    }

    public final long getTagId() {
        return this.tagId;
    }

    public final Disposable getUpdateDisposable() {
        return this.updateDisposable;
    }

    public final boolean isMultiTab() {
        return this.isMultiTab;
    }

    public final void init(SingleDrawViewModel r4) {
        this.singleDrawViewModel = r4;
        Disposable r5 = this.updateDisposable;
        if (r5 == null) goto L5;
        r5.dispose();
    L5:
        this.updateDisposable = null;
        if (this.tabItemModelList.size() <= 0) goto L9;
        return;
    L9:
        if (this.isMultiTab == false) goto L17;
        List<com.bytedance.android.livesdk.feed.feed.e> r6 = this.tabList;
        if (r6 == null) goto L21;
        Iterator<T> r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L23;
        com.bytedance.android.livesdk.feed.feed.e r0 = (com.bytedance.android.livesdk.feed.feed.e) r7.next();
        this.tabItemModelList.add(new cw1.a(r0, this));
        goto L14
    L23:
        return;
    L21:
        return;
    L17:
        if (this.tabSize <= 0) goto L22;
        this.tabItemModelList.add(new c((com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(this.tabList, 0), this));
        return;
    }

    public final void setChosenTab(e r1) {
        this.chosenTab = r1;
    }

    public final void setCurrentStatus(int r1) {
        this.currentStatus = r1;
    }

    public final void setCurrentTabModel(e r1) {
        this.currentTabModel = r1;
    }

    public final void setDefaultTab(com.bytedance.android.livesdk.feed.feed.e r1) {
        this.defaultTab = r1;
    }

    public final void setTabType(long r1) {
        this.tabType = r1;
    }

    public final void setTagId(long r1) {
        this.tagId = r1;
    }

    public final void setUpdateDisposable(Disposable r1) {
        this.updateDisposable = r1;
    }

    public final void onDataUpdata(long r10, List<? extends FeedItem> r12, @IFeedRepository.FEED_ACTION int r13) {
        Intrinsics.checkNotNullParameter(r12, "feedList");
        ArrayList r0 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L3:
        boolean r2 = true;
        boolean r3 = false;
        Object r4 = null;
        Integer r5 = null;
        if (r14.hasNext() == false) goto L45;
        Object r1 = r14.next();
        FeedItem r6 = (FeedItem) r1;
        if (r6.type != 24) goto L27;
        OperationCard r7 = r6.operationCard;
        if (r7 == null) goto L10;
        Integer r8 = r7.type;
    L11:
        int r9 = OperationSingleDrawViewHolder.x;
        if (r8 == null) goto L27;
        if (r8.intValue() != 3) goto L27;
        OperationCard r11 = r6.operationCard;
        if (r11 == null) goto L23;
        OperationMultipleRoom r15 = r11.operationMultipleRoom;
        if (r15 == null) goto L23;
        List r16 = r15.rooms;
        if (r16 == null) goto L23;
        int r17 = r16.size();
    L25:
        if (r17 >= 4) goto L27;
        boolean r18 = false;
    L29:
        if (r6.type != 24) goto L39;
        OperationCard r19 = r6.operationCard;
        if (r19 == null) goto L33;
        r5 = r19.type;
    L33:
        int r20 = OperationSingleDrawViewHolder.x;
        if (r5 == null) goto L39;
        if (r5.intValue() != 1) goto L39;
        r18 = false;
    L39:
        SingleDrawFeedAdapter.a r21 = SingleDrawFeedAdapter.h;
        int r22 = r6.type;
        r21.getClass();
        if (SingleDrawFeedAdapter.a.a(r22) == 2131566000) goto L43;
        r3 = r18;
    L43:
        if (r3 == false) goto L3;
        r0.add(r1);
    L23:
        r17 = 0;
        goto L25
    L10:
        r8 = null;
    L27:
        r18 = true;
        goto L29
    L45:
        Iterator<T> r110 = this.tabItemModelList.iterator();
    L47:
        if (r110.hasNext() == false) goto L54;
        Object r23 = r110.next();
        if (((e) r23).f.f() != r10) goto L51;
        boolean r24 = true;
    L52:
        if (r24 == false) goto L47;
        r4 = r23;
        goto L54
    L51:
        r24 = false;
    L54:
        e r25 = (e) r4;
        if (r13 == 0) goto L65;
        if (r13 == 1) goto L65;
        if (r13 != 2) goto L64;
        if (r25 == null) goto L64;
        LinkedList<FeedItem> r111 = r25.b;
        if (r111 == null) goto L64;
        r111.addAll(r0);
    L64:
        r2 = false;
    L74:
        if (this.currentStatus != r13) goto L92;
        SingleDrawViewModel r112 = this.singleDrawViewModel;
        if (r112 == null) goto L80;
        NextLiveData r113 = r112.getItemsUpdate();
        if (r113 == null) goto L80;
        r113.postValue(new j(r0, r2));
    L80:
        this.currentStatus = -1;
        return;
    L92:
        return;
    L65:
        if (r25 == null) goto L69;
        LinkedList<FeedItem> r114 = r25.b;
        if (r114 == null) goto L69;
        r114.clear();
    L69:
        if (r25 == null) goto L74;
        LinkedList<FeedItem> r115 = r25.b;
        if (r115 == null) goto L74;
        r115.addAll(r0);
        goto L74
    }
}
