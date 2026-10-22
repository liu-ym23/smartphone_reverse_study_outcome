package com.larus.voicecall.impl.component.vlm;

import com.larus.audio.call.RealtimeCallParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k2 implements w3a.i {
    public final /* synthetic */ RealtimeVideoComponent a;

    public k2(RealtimeVideoComponent r1) {
        this.a = r1;
    }

    @Override // w3a.i
    public final void a(w3a.h r11) {
        Intrinsics.checkNotNullParameter(r11, "event");
        if ((r11 instanceof w3a.j) == false) goto L8;
        if (this.a.D5() == false) goto L18;
        int r0 = com.larus.voicecall.impl.util.x0.a;
        com.larus.voicecall.impl.util.x0.c(this.a.Q3().a(), this.a.B3(), ((w3a.j) r11).a, false, Boolean.valueOf(Intrinsics.areEqual(this.a.N.b.getValue(), Boolean.TRUE)), "microphone", null, null, 200);
        return;
    L18:
        return;
    L8:
        if ((r11 instanceof w3a.m) == false) goto L13;
        if (this.a.D5() == false) goto L20;
        int r1 = com.larus.voicecall.impl.util.x0.a;
        RealtimeCallParam r2 = this.a.Q3().a();
        e3a.a r3 = this.a.B3();
        boolean r4 = ((h88.b) this.a.Q3()).m;
        boolean r5 = Intrinsics.areEqual(this.a.N.b.getValue(), Boolean.TRUE);
        com.larus.voicecall.impl.util.x0.c(r2, r3, r4, ((w3a.m) r11).a, Boolean.valueOf(r5), "subtitle", null, null, 192);
        return;
    L20:
        return;
    L13:
        if ((r11 instanceof w3a.n) == true) goto L15;
        return;
    L15:
        if (this.a.D5() == false) goto L23;
        int r12 = com.larus.voicecall.impl.util.x0.a;
        com.larus.voicecall.impl.util.x0.c(this.a.Q3().a(), this.a.B3(), ((h88.b) this.a.Q3()).m, false, Boolean.valueOf(Intrinsics.areEqual(this.a.N.b.getValue(), Boolean.TRUE)), "break", null, null, 200);
        return;
    }
}
