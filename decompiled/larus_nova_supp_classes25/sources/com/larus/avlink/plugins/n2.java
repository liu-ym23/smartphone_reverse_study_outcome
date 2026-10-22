package com.larus.avlink.plugins;

import com.larus.avlink.DoraWakeupResponseManager;
import com.larus.avlink.DoraWakeupSoundController;
import com.larus.avlink.model.TimerScene;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n2 extends com.larus.audio.call.arch.a<n4> implements o4 {
    public final String f;

    public static final class a extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ n2 b;

        public final String g() {
            return this.a;
        }

        public a(n2 r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void n(com.larus.im.service.audio.z0.a r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            boolean r1 = true;
            if ((r4 instanceof pf9.z) == false) goto L15;
            IDoraService r5 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r5 == null) goto L11;
            DeviceService r6 = r5.device();
            if (r6 == null) goto L11;
            if (r6.M() != true) goto L11;
        L12:
            if (r1 == false) goto L34;
            DoraWakeupResponseManager r7 = DoraWakeupResponseManager.a;
            DoraWakeupResponseManager.g(new com.larus.avlink.a1());
            return;
        L34:
            return;
        L11:
            r1 = false;
            goto L12
        L15:
            if ((r4 instanceof pf9.r) == false) goto L36;
            pf9.r r8 = (pf9.r) r4;
            if (r8.getType() != TriggerMode.WAKE_UP_REJECT) goto L23;
            if (((n4) this.b.getContext()).e() == false) goto L21;
            Lazy r9 = DoraWakeupSoundController.a;
            DoraWakeupSoundController.d();
        L21:
            com.larus.avlink.n1.d(this.b.f, "receive WAKE_UP_REJECT, stopVUI silently");
            ((n4) this.b.getContext()).d(true, 2, 45);
            return;
        L23:
            if (r8.getType() != TriggerMode.WAKE_UP_SUCCESS) goto L38;
            com.larus.avlink.n1.d(this.b.f, "receive WAKE_UP_SUCCESS, restart normal countdown");
            x3 r10 = (x3) this.b.getContext().c(Reflection.getOrCreateKotlinClass(x3.class), null);
            if (r10 == null) goto L27;
            r10.g1("wakeup success");
        L27:
            x3 r11 = (x3) this.b.getContext().c(Reflection.getOrCreateKotlinClass(x3.class), null);
            if (r11 == null) goto L30;
            r11.G(TimerScene.NaturalWakeupConfirmed);
        L30:
            id9.d r12 = ((n4) this.b.getContext()).j();
            if (r12 == null) goto L39;
            r12.t();
            return;
        L39:
            return;
        L38:
            return;
        }
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new a(this);
    }

    public final String T2() {
        return this.f;
    }

    public n2(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "DoraNaturalConversation";
    }

    @Override // com.larus.avlink.plugins.o4
    public final void Q0(int r3) {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.M() != true) goto L9;
    L10:
        if (r2 == false) goto L12;
        DoraWakeupResponseManager r4 = DoraWakeupResponseManager.a;
        String r5 = "onConversationEnd reason=" + r3;
        Intrinsics.checkNotNullParameter(r5, "reason");
        DoraWakeupResponseManager.g(new com.larus.avlink.z0(r5));
    L12:
        Lazy r6 = DoraWakeupSoundController.a;
        DoraWakeupSoundController.e(r3);
        return;
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.larus.avlink.plugins.o4
    public final void i0(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "caller");
        Intrinsics.checkNotNullParameter(r1, "caller");
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L9;
        DeviceService r5 = r4.device();
        if (r5 == null) goto L9;
        boolean r6 = true;
        if (r5.M() != true) goto L9;
    L10:
        if (r6 == false) goto L13;
        DoraWakeupResponseManager r7 = DoraWakeupResponseManager.a;
        DoraWakeupResponseManager.g(new com.larus.avlink.b1(r2));
        return;
    L13:
        return;
    L9:
        r6 = false;
        goto L10
    }
}
