package com.larus.dora.obric.device_management.setting.common.auto_disconnect;

import androidx.lifecycle.ViewModel;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.device.ailab.config.AutoStopTimeConfig;
import com.larus.dora.impl.sysinfo.DoraSystemInfoManager;
import com.larus.dora.impl.util.b0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rJ\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/common/auto_disconnect/DoraObricDoubaoAutoDisconnectViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_autoStopTime", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "autoStopTime", "Lkotlinx/coroutines/flow/StateFlow;", "getAutoStopTime", "()Lkotlinx/coroutines/flow/StateFlow;", "autoStopTimeOptions", "", "Lcom/larus/dora/impl/device/ailab/config/AutoStopTimeConfig;", "refreshAutoStopTime", "", "updateAutoStopTime", "option", "reportAutoStopTimeConfigChange", "previous", "current", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricDoubaoAutoDisconnectViewModel extends ViewModel {
    private final z0<Integer> _autoStopTime;
    private final i1<Integer> autoStopTime;

    public final List<AutoStopTimeConfig> autoStopTimeOptions() {
        AutoStopTimeConfig.a r0 = AutoStopTimeConfig.Companion;
        b0.a.getClass();
        boolean r1 = b0.w();
        r0.getClass();
        return AutoStopTimeConfig.a.a(r1);
    }

    public final void refreshAutoStopTime() {
        z0<Integer> r0 = this._autoStopTime;
        b0.a.getClass();
        r0.setValue(Integer.valueOf(b0.c()));
    }

    public DoraObricDoubaoAutoDisconnectViewModel() {
        b0.a.getClass();
        StateFlowImpl r0 = j1.a(Integer.valueOf(b0.c()));
        this._autoStopTime = r0;
        this.autoStopTime = r0;
    }

    public final i1<Integer> getAutoStopTime() {
        return this.autoStopTime;
    }

    public final void updateAutoStopTime(AutoStopTimeConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "option");
        b0.a.getClass();
        reportAutoStopTimeConfigChange(b0.c(), r3.getValue());
        b0.H(r3.getValue());
        DoraSystemInfoManager r0 = DoraSystemInfoManager.a;
        DoraSystemInfoManager.f(CollectionsKt.listOf(TuplesKt.to("doubao_auto_hangup_timeout", String.valueOf(r3.getValue()))));
        refreshAutoStopTime();
    }

    private final void reportAutoStopTimeConfigChange(int r4, int r5) {
        DoraBuryPointManager.a.L("dm_auto_hangup_time_setting", MapsKt.mapOf(new Pair[]{TuplesKt.to("previous", Integer.valueOf(r4)), TuplesKt.to("current", Integer.valueOf(r5))}));
    }
}
