package com.bytedance.android.live.openplatform.impl.minigameanchor.panel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformMgClient;
import com.bytedance.android.live.openplatform.impl.minigameanchor.api.MiniGameAnchorApi;
import com.bytedance.android.live.openplatform.impl.minigameanchor.explaincard.AnchorExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.mount.LiveMgMountContextService;
import com.bytedance.live.datacontext.n;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\rR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\rR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/panel/LiveMiniGameFeaturePanelViewModel;", "Landroidx/lifecycle/ViewModel;", "", "fetchLiveData", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "initData", "setExplainCard", "deleteExplainCard", "exitMount", "Landroidx/lifecycle/MutableLiveData;", "", "_enableExplain", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "enableExplain", "Landroidx/lifecycle/LiveData;", "getEnableExplain", "()Landroidx/lifecycle/LiveData;", "_explainStatus", "explainStatus", "getExplainStatus", "_exitMountStatus", "exitMountStatus", "getExitMountStatus", "Lyq0/d;", "_realTimeData", "realTimeData", "getRealTimeData", "Lyq0/e;", "_lotteryConfig", "lotteryConfig", "getLotteryConfig", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "Lcom/bytedance/android/live/openplatform/impl/minigameanchor/explaincard/AnchorExplainCardContextService;", "explainCardService", "Lcom/bytedance/android/live/openplatform/impl/minigameanchor/explaincard/AnchorExplainCardContextService;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMiniGameFeaturePanelViewModel extends ViewModel {
    private final MutableLiveData<Boolean> _enableExplain;
    private final MutableLiveData<Boolean> _exitMountStatus;
    private final MutableLiveData<Boolean> _explainStatus;
    private final MutableLiveData<yq0.e> _lotteryConfig;
    private final MutableLiveData<yq0.d> _realTimeData;
    private final LiveData<Boolean> enableExplain;
    private final LiveData<Boolean> exitMountStatus;
    private AnchorExplainCardContextService explainCardService;
    private final LiveData<Boolean> explainStatus;
    private final LiveData<yq0.e> lotteryConfig;
    private OpenPlatformContext openPlatformContext;
    private final LiveData<yq0.d> realTimeData;

    public final void deleteExplainCard() {
        AnchorExplainCardContextService r0 = this.explainCardService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardService");
    L5:
        r0.f(new AnonymousClass1(this));
    }

    public final void exitMount() {
        OpenPlatformContext r0 = this.openPlatformContext;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("openPlatformContext");
    L5:
        ((LiveMgMountContextService) r0.getService(LiveMgMountContextService.class)).n(new C03391(this));
    }

    public final void setExplainCard() {
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r0 = AnchorMiniGameDataContext.a.a();
        if (r0 == null) goto L15;
        n<OpenPlatformMgInfoModel> r1 = r0.getOpenPlatformMg();
        if (r1 == null) goto L16;
        OpenPlatformMgInfoModel r2 = (OpenPlatformMgInfoModel) r1.getValue();
        if (r2 == null) goto L17;
        String r3 = r2.getTaskId();
        if (r3 == null) goto L18;
        AnchorExplainCardContextService r4 = this.explainCardService;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardService");
    L13:
        r4.g(r3, new LiveMiniGameFeaturePanelViewModel$setExplainCard$$inlined$let$lambda$1(this));
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public LiveMiniGameFeaturePanelViewModel() {
        MutableLiveData<Boolean> r0 = new MutableLiveData();
        this._enableExplain = r0;
        this.enableExplain = r0;
        MutableLiveData<Boolean> r1 = new MutableLiveData();
        this._explainStatus = r1;
        this.explainStatus = r1;
        MutableLiveData<Boolean> r2 = new MutableLiveData();
        this._exitMountStatus = r2;
        this.exitMountStatus = r2;
        MutableLiveData<yq0.d> r3 = new MutableLiveData();
        this._realTimeData = r3;
        this.realTimeData = r3;
        MutableLiveData<yq0.e> r4 = new MutableLiveData();
        this._lotteryConfig = r4;
        this.lotteryConfig = r4;
    }

    private final void fetchLiveData() {
        final long r0 = System.currentTimeMillis();
        OpenPlatformContext r2 = this.openPlatformContext;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("openPlatformContext");
    L5:
        LiveMgMountContextService r3 = (LiveMgMountContextService) r2.getService(LiveMgMountContextService.class);
        Function1<yq0.d, Unit> r4 = new C03401(this, r0);
        Function1<String, Unit> r5 = new AnonymousClass2(this, r0);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "onSuccess");
        Intrinsics.checkNotNullParameter(r5, "onFail");
        Lazy r1 = LiveOpenPlatformMgClient.c;
        r3.autoDispose(((MiniGameAnchorApi) LiveOpenPlatformMgClient.a.a().a(MiniGameAnchorApi.class)).getRealTimeData(r3.getOpenPlatformContext().getRoomId(), r3.a).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.openplatform.impl.minigameanchor.mount.c(r4), new com.bytedance.android.live.openplatform.impl.minigameanchor.mount.d(r5)));
        OpenPlatformContext r6 = this.openPlatformContext;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("openPlatformContext");
    L8:
        ((LiveMgMountContextService) r6.getService(LiveMgMountContextService.class)).m(new AnonymousClass3(this), AnonymousClass4.INSTANCE);
    }

    public final LiveData<Boolean> getEnableExplain() {
        return this.enableExplain;
    }

    public final LiveData<Boolean> getExitMountStatus() {
        return this.exitMountStatus;
    }

    public final LiveData<Boolean> getExplainStatus() {
        return this.explainStatus;
    }

    public final LiveData<yq0.e> getLotteryConfig() {
        return this.lotteryConfig;
    }

    public final LiveData<yq0.d> getRealTimeData() {
        return this.realTimeData;
    }

    public static final /* synthetic */ AnchorExplainCardContextService access$getExplainCardService$p(LiveMiniGameFeaturePanelViewModel r1) {
        AnchorExplainCardContextService r2 = r1.explainCardService;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardService");
    L5:
        return r2;
    }

    public static final /* synthetic */ OpenPlatformContext access$getOpenPlatformContext$p(LiveMiniGameFeaturePanelViewModel r1) {
        OpenPlatformContext r2 = r1.openPlatformContext;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("openPlatformContext");
    L5:
        return r2;
    }

    public static final /* synthetic */ MutableLiveData access$get_exitMountStatus$p(LiveMiniGameFeaturePanelViewModel r0) {
        return r0._exitMountStatus;
    }

    public static final /* synthetic */ MutableLiveData access$get_explainStatus$p(LiveMiniGameFeaturePanelViewModel r0) {
        return r0._explainStatus;
    }

    public static final /* synthetic */ MutableLiveData access$get_lotteryConfig$p(LiveMiniGameFeaturePanelViewModel r0) {
        return r0._lotteryConfig;
    }

    public static final /* synthetic */ MutableLiveData access$get_realTimeData$p(LiveMiniGameFeaturePanelViewModel r0) {
        return r0._realTimeData;
    }

    public final void initData(OpenPlatformContext r3) {
        Intrinsics.checkNotNullParameter(r3, "openPlatformContext");
        this.openPlatformContext = r3;
        this.explainCardService = (AnchorExplainCardContextService) r3.getService(AnchorExplainCardContextService.class);
        this._enableExplain.postValue(Boolean.TRUE);
        MutableLiveData<Boolean> r4 = this._explainStatus;
        AnchorExplainCardContextService r0 = this.explainCardService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardService");
    L5:
        r4.postValue(Boolean.valueOf(r0.b));
        fetchLiveData();
    }

    public static final /* synthetic */ void access$setExplainCardService$p(LiveMiniGameFeaturePanelViewModel r0, AnchorExplainCardContextService r1) {
        r0.explainCardService = r1;
    }

    public static final /* synthetic */ void access$setOpenPlatformContext$p(LiveMiniGameFeaturePanelViewModel r0, OpenPlatformContext r1) {
        r0.openPlatformContext = r1;
    }
}
