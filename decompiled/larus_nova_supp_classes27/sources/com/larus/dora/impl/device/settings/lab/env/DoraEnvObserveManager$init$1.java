package com.larus.dora.impl.device.settings.lab.env;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.dora.impl.device.settings.lab.env.override.EnvObserveOverrideChangeReason;
import com.larus.dora.impl.util.t0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraEnvObserveManager$init$1 extends t0 {
    public DoraEnvObserveManager$init$1() {
    }

    public final void onDoraLinkStateChanged(DoraDevice r10, int r11, int r12) {
        g49.d.d("DoraEnvObserveManager", " connect link change: " + r12);
        Job r13 = DoraEnvObserveManager.f;
        if (r13 == null) goto L6;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);
    L6:
        if (r12 == (-1)) goto L10;
        if (r12 == 0) goto L10;
        if (r12 == 2) goto L10;
    L17:
        if (r12 != 2) goto L19;
        DoraEnvObserveManager.f = BuildersKt.launch$default(DoraEnvObserveManager.d, null, null, new DoraEnvObserveManager$init$1$onDoraLinkStateChanged$2(null), 3, null);
        DoraEnvObserveNetwork.a();
        return;
    L19:
        DoraEnvObserveManager.f = BuildersKt.launch$default(DoraEnvObserveManager.d, null, null, new DoraEnvObserveManager$init$1$onDoraLinkStateChanged$3(r12, null), 3, null);
        DoraEnvObserveManager r14 = DoraEnvObserveManager.a;
        EnvObserveChangeReason r15 = EnvObserveChangeReason.CONNECT_CHANGE;
        r14.getClass();
        DoraEnvObserveManager.i(false, r15, 100);
        DoraEnvObserveManager.g = false;
        return;
    L10:
        DoraEnvObserveManager r16 = DoraEnvObserveManager.a;
        if (r10 == null) goto L14;
        r16.getClass();
        String r17 = r10.mac;
        if (r17 == null) goto L14;
    L15:
        if (r17 == null) goto L17;
        DoraEnvObserveManager.f().a(r17, EnvObserveOverrideChangeReason.CONNECTION);
    L14:
        r16.getClass();
        r17 = DoraEnvObserveManager.e();
        goto L15
    }
}
