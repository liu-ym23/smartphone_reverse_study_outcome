package com.bytedance.android.live.revlink.impl.pk.dialog.vm;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.b0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.control.dialog.LinkRevPanelDataContext;
import com.bytedance.android.live.revlink.impl.control.dialog.e;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.p;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.live.revlink.impl.utils.x;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.IPanelArea;
import com.bytedance.android.livesdk.link.model.IPkSubTabKey;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.i8;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.s2;
import com.bytedance.android.livesdk.link.model.y7;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.m;
import com.bytedance.revenue.platform.api.core.rx.f;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\t\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u001e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\u0006J\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0010R\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR#\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001a8\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR#\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001f0\u001a8\u0006¢\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001eR\"\u0010&\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0019\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010*R\u0016\u0010\u0012\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010+R\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0019¨\u0006."}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/vm/RevLinkAnchorSubViewModel;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/vm/RevLinkAnchorBaseViewModel;", "Lkotlin/Pair;", "", "Lcom/bytedance/android/live/revlink/impl/control/dialog/e;", Constants.Keys.DATA, "", "onDateLoadSuccess", "Lcom/bytedance/android/live/revlink/impl/control/dialog/f;", "onDataLoadFail", "pair", "onDataLoaded", "source", "", "checkDataNeedNotify", "getTag", "", "loadType", "activityId", "enableRank", "setArgument", "initData", "actType", "reqAction", "loadFlag", "Z", "Landroidx/lifecycle/MutableLiveData;", "loading", "Landroidx/lifecycle/MutableLiveData;", "getLoading", "()Landroidx/lifecycle/MutableLiveData;", "", "", "listData", "getListData", "Lcom/bytedance/android/livesdk/link/model/IPanelArea;", "actAreaData", "getActAreaData", "isAct", "()Z", "setAct", "(Z)V", "I", "Ljava/lang/String;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkAnchorSubViewModel extends RevLinkAnchorBaseViewModel {
    private final MutableLiveData<List<IPanelArea>> actAreaData;
    private String activityId;
    private boolean enableRank;
    private boolean isAct;
    private final MutableLiveData<List<Object>> listData;
    private boolean loadFlag;
    private int loadType;
    private final MutableLiveData<Boolean> loading;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ RevLinkAnchorSubViewModel a;
        public final /* synthetic */ String b;

        public a(RevLinkAnchorSubViewModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            ExtraResponse r5 = (ExtraResponse) r4;
            this.a.getActAreaData().setValue(((i8) r5.data).getAreas());
            com.bytedance.android.live.revlink.impl.control.dialog.b r0 = this.a.getLoader();
            if (r0 == null) goto L19;
            String r1 = this.b;
            String r6 = ((i8) r5.data).getTrackingInfo();
            if (r6 != null) goto L7;
            r6 = "";
        L7:
            Intrinsics.checkNotNullParameter(r1, "activityId");
            Intrinsics.checkNotNullParameter(r6, "trackingInfo");
            Pair<String, e> r2 = r0.e(IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal(), r1);
            if (r2 == null) goto L20;
            e r3 = (e) r2.getSecond();
            if (r3 == null) goto L21;
            Map<String, String> r7 = JsonUtil.jsonObjectToMap(new JSONObject(r6));     // Catch: Exception -> L13
        L14:
            if (r7 == null) goto L22;
            r3.f = r7;
            return;
        L22:
            return;
        L13:
            r7 = null;
            goto L14
        L21:
            return;
        L20:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RevLinkAnchorSubViewModel a;

        public b(RevLinkAnchorSubViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            String r0 = this.a.getTag();
            t.b(r0, (Throwable) r2);
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.vm.RevLinkAnchorBaseViewModel
    public String getTag() {
        return "RevLinkAnchorSubViewModel";
    }

    public final void initData() {
        LinkRevPanelDataContext r0 = LinkRevPanelDataContext.Companion.getContext();
        if (r0 == null) goto L9;
        if (this.enableRank == false) goto L7;
        f.a(b0.b(r0.getLoadCompleteRankEvent(), new RevLinkAnchorSubViewModel$initData$1$1(this)), getCd());
        f.a(b0.b(r0.getLoadFailRankEvent(), new RevLinkAnchorSubViewModel$initData$1$2(this)), getCd());
        goto L9
    L7:
        PublishSubject r1 = r0.getLoadCompleteEvent().onEvent();
        final RevLinkAnchorSubViewModel$initData$1$3 r2 = new RevLinkAnchorSubViewModel$initData$1$3(this);
        f.a(r1.subscribe(new c(r2)), getCd());
        PublishSubject r3 = r0.getLoadFailEvent().onEvent();
        final RevLinkAnchorSubViewModel$initData$1$4 r4 = new RevLinkAnchorSubViewModel$initData$1$4(this);
        f.a(r3.subscribe(new c(r4)), getCd());
    L9:
        if (this.enableRank == true) goto L22;
        com.bytedance.android.live.revlink.impl.control.dialog.b r5 = getLoader();
        if (r5 == null) goto L13;
        final Pair<String, e> r6 = r5.e(this.loadType, this.activityId);
    L14:
        if (r6 == null) goto L16;
        lazyTask(this.loadType, new AnonymousClass2(this, r6));
        return;
    L16:
        com.bytedance.android.live.revlink.impl.control.dialog.b r7 = getLoader();
        if (r7 != null) goto L19;
    L20:
        this.loading.setValue(Boolean.TRUE);
        this.loadFlag = false;
        RevLinkAnchorBaseViewModel.fetchPiece$default(this, this.loadType, "init", this.activityId, null, 8, null);
        return;
    L19:
        if (r7.i(this.loadType, this.activityId) != true) goto L20;
        return;
    L13:
        r6 = null;
        goto L14
    }

    public RevLinkAnchorSubViewModel() {
        this.loading = new MutableLiveData();
        this.listData = new MutableLiveData();
        this.actAreaData = new MutableLiveData();
        this.activityId = DataType.FALSE;
    }

    public final MutableLiveData<List<IPanelArea>> getActAreaData() {
        return this.actAreaData;
    }

    public final MutableLiveData<List<Object>> getListData() {
        return this.listData;
    }

    public final MutableLiveData<Boolean> getLoading() {
        return this.loading;
    }

    public final boolean isAct() {
        return this.isAct;
    }

    private final boolean checkDataNeedNotify(String r7) {
        if (this.loadFlag == true) goto L6;
        return true;
    L6:
        if (this.loadType != IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal()) goto L15;
        if ((!Intrinsics.areEqual(r7, "init")) == true) goto L10;
    L12:
        return false;
    L10:
        if ((!Intrinsics.areEqual(r7, "cache")) == false) goto L12;
        return true;
    L15:
        if ((!Intrinsics.areEqual(r7, "init")) == true) goto L17;
    L21:
        return false;
    L17:
        if ((!Intrinsics.areEqual(r7, "cache")) == false) goto L21;
        if ((!Intrinsics.areEqual(r7, "timer")) == false) goto L21;
        return true;
    }

    private final void onDataLoadFail(Pair<String, com.bytedance.android.live.revlink.impl.control.dialog.f> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        String r0 = (String) r4.getFirst();
        int r1 = ((com.bytedance.android.live.revlink.impl.control.dialog.f) r4.getSecond()).a;
        String r5 = ((com.bytedance.android.live.revlink.impl.control.dialog.f) r4.getSecond()).b;
        if (Intrinsics.areEqual(r0, "init") == false) goto L18;
        IRivalRankRecommendResponse.LoadType r2 = IRivalRankRecommendResponse.LoadType.OnlyCommonPanel;
        if (r1 != r2.ordinal()) goto L13;
        if (r1 != this.loadType) goto L13;
        if (Intrinsics.areEqual(r5, this.activityId) == false) goto L13;
    L16:
        this.loading.setValue(Boolean.FALSE);
        return;
    L13:
        if (r1 != r2.ordinal()) goto L15;
        return;
    L15:
        if (r1 == this.loadType) goto L16;
        return;
    }

    private final void onDataLoaded(Pair<String, e> r9) {
        this.loadFlag = true;
        if (this.isAct == false) goto L22;
        List r10 = ((e) r9.getSecond()).c.getSubTabs();
        y7 r0 = null;
        Object r1 = null;
        if (r10 == null) goto L19;
        Iterator r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L18;
        Object r2 = r12.next();
        y7 r3 = (y7) r2;
        if (r3 == null) goto L14;
        IPkSubTabKey r4 = r3.getKey();
        if (r4 == null) goto L14;
        String r5 = r4.getActivityId();
    L16:
        if (Intrinsics.areEqual(r5, this.activityId) == false) goto L8;
        r1 = r2;
    L14:
        r5 = null;
    L18:
        r0 = (y7) r1;
    L19:
        if (r0 == null) goto L50;
        this.actAreaData.setValue(r0.getAreas());
        return;
    L50:
        return;
    L22:
        if (this.loadType != IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal()) goto L41;
        s2 r6 = ((e) r9.getSecond()).c.getTabRivals();
        if (r6 == null) goto L41;
        Map r7 = r6.getGroupRivals();
        if (r7 == null) goto L41;
        IGroupRivals r8 = (IGroupRivals) r7.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedRecommend.ordinal()));
        if (r8 == null) goto L41;
        List<? extends m2> r13 = r8.getRivals();
        if (r13 == null) goto L41;
        LinkRevPanelDataContext r14 = getDataContext();
        if (r14 == null) goto L36;
        m<String> r15 = r14.getRecImplId();
        if (r15 == null) goto L36;
        r15.setValue(r8.getImprId());
    L36:
        LinkRevPanelDataContext r16 = getDataContext();
        if (r16 == null) goto L39;
        r16.setSelectType(r8.getSelectType());
    L39:
        this.listData.setValue(createRecItemList(r13, r8.getImprId(), ((e) r9.getSecond()).c.getSkinType(), (String) r9.getFirst()));
    L41:
        if (getReporter() == null) goto L43;
        p.c((String) r9.getFirst(), this.loadType, ((e) r9.getSecond()).d);
    L43:
        com.bytedance.android.live.revlink.impl.control.dialog.b r17 = getLoader();
        if (r17 == null) goto L52;
        com.bytedance.android.live.revlink.impl.control.dialog.b.l(r17, (String) r9.getFirst(), this.loadType);
        return;
    }

    private final void onDateLoadSuccess(Pair<String, e> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        String r0 = (String) r5.getFirst();
        int r1 = ((e) r5.getSecond()).a;
        if (Intrinsics.areEqual(((e) r5.getSecond()).b, this.activityId) == false) goto L9;
        if (this.isAct == false) goto L9;
    L15:
        if (checkDataNeedNotify(r0) == false) goto L20;
        onDataLoaded(r5);
        return;
    L20:
        return;
    L9:
        if (this.enableRank == true) goto L15;
        if (r1 != IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal()) goto L13;
        return;
    L13:
        if (r1 == this.loadType) goto L15;
    }

    public final void setAct(boolean r1) {
        this.isAct = r1;
    }

    public static final /* synthetic */ void access$onDataLoadFail(RevLinkAnchorSubViewModel r0, Pair r1) {
        r0.onDataLoadFail(r1);
    }

    public static final /* synthetic */ void access$onDataLoaded(RevLinkAnchorSubViewModel r0, Pair r1) {
        r0.onDataLoaded(r1);
    }

    public static final /* synthetic */ void access$onDateLoadSuccess(RevLinkAnchorSubViewModel r0, Pair r1) {
        r0.onDateLoadSuccess(r1);
    }

    public final void reqAction(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "activityId");
        Observable<ExtraResponse<i8, Extra>> r4 = r31.b.a(r31.a.a).j(r2, r3);
        if (r4 == null) goto L10;
        Observable r5 = r4.compose(RxUtil.rxSchedulerHelper());
        if (r5 == null) goto L11;
        Disposable r6 = r5.subscribe(new a(this, r2), new b(this));
        if (r6 == null) goto L12;
        f.a(r6, getCd());
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setArgument(int r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "activityId");
        this.loadType = r2;
        this.activityId = r3;
        this.isAct = x.a(r3, r2);
        this.enableRank = r4;
    }
}
