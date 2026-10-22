package com.obric.memorydata.memory.ui.list;

import androidx.lifecycle.ViewModel;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010J\b\u0010\u0012\u001a\u00020\u0007H\u0014J\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/ScreenObservationTipsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "screenObservationBuildMemoryTipsHelper", "Lcom/obric/memorydata/memory/ui/list/ScreenObservationBuildMemoryTipsHelper;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "date", "Ljava/time/LocalDate;", "isObservationMemoryEnabled", "", "scope", "Lcom/obric/memorydata/memory/ui/list/ObservationBuildMemoryTipsScope;", "init$memory_obricRelease", "getPendingBuildObservationMemoryState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/obric/memorydata/memory/ui/list/TipsData;", "onCleared", "tryRefreshBuildMemoryTips", "setObservationMemoryEnabled", "isEnable", "setCellularEnable", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenObservationTipsViewModel extends ViewModel {
    private final be screenObservationBuildMemoryTipsHelper;

    public ScreenObservationTipsViewModel() {
        this.screenObservationBuildMemoryTipsHelper = new be();
    }

    public static /* synthetic */ void init$memory_obricRelease$default(ScreenObservationTipsViewModel r0, LocalDate r1, boolean r2, ObservationBuildMemoryTipsScope r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = ObservationBuildMemoryTipsScope.SCREEN_OBSERVATION;
    L5:
        r0.init$memory_obricRelease(r1, r2, r3);
    }

    public final kotlinx.coroutines.flow.ar<bl> getPendingBuildObservationMemoryState() {
        return this.screenObservationBuildMemoryTipsHelper.a();
    }

    public final void init$memory_obricRelease(LocalDate r3, boolean r4, ObservationBuildMemoryTipsScope r5) {
        Intrinsics.checkNotNullParameter(r3, "date");
        Intrinsics.checkNotNullParameter(r5, "scope");
        this.screenObservationBuildMemoryTipsHelper.b(r4);
        this.screenObservationBuildMemoryTipsHelper.a(r3, (ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.screenObservationBuildMemoryTipsHelper.b();
    }

    public final void setCellularEnable(boolean r1) {
        this.screenObservationBuildMemoryTipsHelper.a(r1);
    }

    public final void setObservationMemoryEnabled(boolean r1) {
        this.screenObservationBuildMemoryTipsHelper.b(r1);
    }

    public final void tryRefreshBuildMemoryTips() {
        this.screenObservationBuildMemoryTipsHelper.c();
    }
}
