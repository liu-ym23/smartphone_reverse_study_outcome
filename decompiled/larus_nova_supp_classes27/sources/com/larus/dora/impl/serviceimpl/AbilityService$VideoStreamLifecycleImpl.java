package com.larus.dora.impl.serviceimpl;

import com.larus.dora.api.IDoraService;
import com.larus.dora.api.IDoraService$a$a;
import com.larus.dora.api.IDoraService$b;
import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AbilityService$VideoStreamLifecycleImpl implements IDoraService$a$a {
    public Job a;
    public final /* synthetic */ AbilityService b;

    @Override // com.larus.dora.api.IDoraService$a$a
    public final void a() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L5;
        AbilityService r1 = r0.o0();
    L6:
        Job r2 = this.a;
        this.a = null;
        boolean r3 = true;
        if (r2 == null) goto L10;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L10:
        if (r2 == null) goto L18;
        if (r1 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == true) goto L18;
        boolean r5 = true;
    L19:
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("finish ordinary P2P RTC, hasPrepareJob=");
        if (r2 != null) goto L23;
        r3 = false;
    L23:
        r7.append(r3);
        r7.append(", release=");
        r7.append(r5);
        r6.i("AbilityService", r7.toString());
        if (r5 == false) goto L28;
        if (r1 == null) goto L29;
        r1.a();
        return;
    L29:
        return;
    L28:
        return;
    L13:
        if (r1.j() != true) goto L15;
        r4 = true;
    L18:
        r5 = false;
        goto L19
    L5:
        r1 = null;
        goto L6
    }

    public AbilityService$VideoStreamLifecycleImpl(AbilityService r1) {
        this.b = r1;
    }

    @Override // com.larus.dora.api.IDoraService$a$a
    public final void b(int r11, boolean r12, boolean r13) {
        this.b.getClass();
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L5;
        DeviceService r1 = r0.device();
    L6:
        boolean r2 = false;
        if (r1 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == true) goto L14;
    L16:
        if (r2 == true) goto L18;
        return;
    L18:
        if (r11 == 32) goto L36;
        if (r12 == true) goto L22;
        if (r13 == true) goto L22;
        return;
    L22:
        IDoraService r14 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r14 == null) goto L37;
        AbilityService r15 = r14.o0();
        if (r15 != null) goto L28;
        return;
    L28:
        if (r15.k() == true) goto L30;
        return;
    L30:
        r15.e();
        IDoraService.B1.getClass();
        final Job r16 = BuildersKt.launch$default(IDoraService$b.b, null, CoroutineStart.LAZY, new AbilityService$VideoStreamLifecycleImpl$onVideoStreamConversationStart$job$1(r15, null), 1, null);
        Job r17 = this.a;
        if (r17 == null) goto L33;
        Job.DefaultImpls.cancel$default(r17, null, 1, null);
    L33:
        this.a = r16;
        r16.invokeOnCompletion(new c(this, r16));
        r16.start();
        return;
    L37:
        return;
    L36:
        return;
    L14:
        if (r1.n0(FlowProtocolAbility.FEATURE_P2P_BT_RTC) == false) goto L16;
        r2 = true;
        goto L16
    L9:
        if (r1.n0(FlowProtocolAbility.FEATURE_P2P_RTC) != true) goto L11;
        r4 = true;
        goto L12
    L5:
        r1 = null;
        goto L6
    }
}
