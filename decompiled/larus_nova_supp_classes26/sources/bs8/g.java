package bs8;

import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.model.PcDeviceUiState;
import com.larus.bmhome.taskskill.service.TaskModeService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public static final PcDeviceUiState b(PcDevice r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Boolean r0 = r2.r();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == true) goto L6;
        return PcDeviceUiState.OFFLINE;
    L6:
        if (TaskModeService.a.f(r2) == false) goto L9;
        return PcDeviceUiState.NEED_UPGRADE;
    L9:
        if (Intrinsics.areEqual(r2.g(), r1) == true) goto L12;
        return PcDeviceUiState.CONTROL_DISABLED;
    L12:
        if (Intrinsics.areEqual(r2.c(), r1) == true) goto L15;
        return PcDeviceUiState.UNAUTHORIZED_AVAILABLE;
    L15:
        return PcDeviceUiState.AUTHORIZED_AVAILABLE;
    }

    public static final PcDevice a(PcDevice r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        PcDevice r5 = PcDevice.a(r2, Boolean.valueOf(r3), null, null, 8183);
        r5.a = r4;
        return r5;
    }
}
