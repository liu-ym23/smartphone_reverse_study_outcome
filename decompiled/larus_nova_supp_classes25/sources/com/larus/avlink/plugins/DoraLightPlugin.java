package com.larus.avlink.plugins;

import com.larus.dora.api.IDoraService;
import com.larus.dora.api.LightEffectBrightness;
import com.larus.dora.api.LightEffectStatus;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraLightPlugin extends c<n4> implements r4 {

    public static final class a extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ DoraLightPlugin b;

        public final String g() {
            return this.a;
        }

        public a(DoraLightPlugin r1) {
            this.b = r1;
            r1.getClass();
            this.a = "DoraLightPlugin";
        }

        public final void n(com.larus.im.service.audio.z0.a r5) {
            Intrinsics.checkNotNullParameter(r5, "event");
            if ((r5 instanceof pf9.z) == false) goto L18;
            DoraLightPlugin r6 = this.b;
            if (Intrinsics.areEqual(((n4) r6.getContext()).params().k.o, "dora_si") == false) goto L7;
        L9:
            boolean r7 = false;
        L10:
            if (r7 == true) goto L12;
            return;
        L12:
            if (this.b.k0() == false) goto L31;
            LightEffectStatus r8 = ia8.p.a;
            LightEffectStatus r9 = ia8.p.a;
            LightEffectStatus r0 = LightEffectStatus.SLOWLY_FLASHING;
            if (r9 == r0) goto L16;
            this.b.getClass();
            com.larus.avlink.n1.d("DoraLightPlugin", "current light status is " + r9);
            this.b.N2(r0, LightEffectBrightness.NORMAL, "onLLMQueryBegin");
            return;
        L16:
            this.b.getClass();
            com.larus.avlink.n1.d("DoraLightPlugin", "current light status is slow, not repeat sync in onLLMQueryBegin");
            return;
        L31:
            return;
        L7:
            if (v88.a.c(Integer.valueOf(((n4) r6.getContext()).q())) == true) goto L9;
            r7 = true;
            goto L10
        L18:
            if ((r5 instanceof pf9.a0) == false) goto L21;
            this.b.getClass();
            com.larus.avlink.n1.d("DoraLightPlugin", "FlowLLMQueryEndEvent: noContent is " + ((pf9.a0) r5).c);
            this.b.N2(LightEffectStatus.TURN_ON, LightEffectBrightness.NORMAL, "onLLMQueryEnd");
            return;
        L21:
            if ((r5 instanceof pf9.e0) == false) goto L35;
            this.b.getClass();
            StringBuilder r1 = new StringBuilder("FlowLLMReplyEndEvent: noContent is ");
            pf9.e0 r10 = (pf9.e0) r5;
            r1.append(r10.a);
            r1.append(", noReplay is ");
            r1.append(r10.b);
            com.larus.avlink.n1.d("DoraLightPlugin", r1.toString());
            if (r10.a == true) goto L27;
            if (r10.b == true) goto L27;
            return;
        L27:
            if (v88.a.c(Integer.valueOf(((n4) this.b.getContext()).q())) == false) goto L37;
            this.b.N2(LightEffectStatus.SLOWLY_FLASHING, LightEffectBrightness.LOW, "onLLMReplyEnd_No_Content");
            return;
        L37:
            return;
        }
    }

    public final String T2() {
        return "DoraLightPlugin";
    }

    @Override // com.larus.avlink.plugins.c, com.larus.avlink.plugins.o4
    public final void i0(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "caller");
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new a(this);
    }

    @Override // com.larus.avlink.plugins.r4
    public final boolean k0() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        if (r1.a0() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void e3() {
        super.e3();
        LightEffectStatus r0 = ia8.p.a;
        ia8.p.a = null;
    }

    public final void g3() {
        super.g3();
        com.larus.avlink.n1.d("DoraLightPlugin", "isStop set true");
    }

    public DoraLightPlugin(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // com.larus.avlink.plugins.c, com.larus.avlink.plugins.o4
    public final void Q0(int r3) {
        N2(LightEffectStatus.TURN_OFF, LightEffectBrightness.LOW, "conversation end");
    }

    @Override // com.larus.avlink.plugins.r4
    public final void N2(LightEffectStatus r17, LightEffectBrightness r18, String r19) {
        Intrinsics.checkNotNullParameter(r17, "status");
        Intrinsics.checkNotNullParameter(r18, "brightness");
        Intrinsics.checkNotNullParameter(r19, "source");
        if (Intrinsics.areEqual(((n4) getContext()).params().k.o, "dora_si") == false) goto L15;
        if (k0() == false) goto L12;
        LightEffectStatus r3 = ia8.p.a;
        LightEffectStatus r4 = ia8.p.a;
        LightEffectStatus r9 = LightEffectStatus.TURN_OFF;
        if (r4 == r9) goto L12;
        CoroutineScope r10 = ((n4) getContext()).r();
        if (r10 == null) goto L11;
        BuildersKt.launch$default(r10, null, null, new DoraLightPlugin$syncLightEffectEvent$1(r18, null), 3, null);
    L11:
        com.larus.avlink.n1.d("DoraLightPlugin", "no light in si, syncLightEffectEvent: " + r9 + ", brightness: " + r18 + ", source: " + r19 + ", previous status: " + ia8.p.a);
        ia8.p.a = r9;
        return;
    L12:
        com.larus.avlink.n1.d("DoraLightPlugin", "no light in si, syncLightEffectEvent: " + r17 + ", brightness: " + r18 + ", source: " + r19);
        return;
    L15:
        if (k0() == false) goto L20;
        CoroutineScope r11 = ((n4) getContext()).r();
        if (r11 == null) goto L19;
        BuildersKt.launch$default(r11, null, null, new DoraLightPlugin$syncLightEffectEvent$2(r17, r18, null), 3, null);
    L19:
        LightEffectStatus r5 = ia8.p.a;
        ia8.p.a = r17;
        com.larus.avlink.n1.d("DoraLightPlugin", "syncLightEffectEvent: " + r17 + ", brightness: " + r18 + ", source: " + r19);
        return;
    L20:
        com.larus.avlink.n1.d("DoraLightPlugin", "syncLightEffectEvent: " + r17 + ", brightness: " + r18 + ", source: " + r19 + ", not support");
    }
}
