package com.larus.voicecall.impl.plugins;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a0 extends com.larus.im.service.audio.z0 {
    public final String a;
    public final /* synthetic */ z<com.larus.audio.call.arch.c> b;
    public final /* synthetic */ com.larus.audio.call.arch.c c;

    public final String g() {
        return this.a;
    }

    public final void n(com.larus.im.service.audio.z0.a r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r5, "event");
        if ((r5 instanceof pf9.z) == false) goto L5;
        this.b.h.b(false, "QueryBegin");
        this.b.i = true;
        return;
    L5:
        boolean r0 = r5 instanceof pf9.a0;
        if (r0 == false) goto L8;
    L27:
        z<com.larus.audio.call.arch.c> r6 = this.b;
        r6.i = true;
        if (r0 == false) goto L30;
        String r1 = "QueryEnd";
    L31:
        r6.h.b(true, r1);
        com.larus.audio.call.arch.b.a(this.c).R1(r1);
        return;
    L30:
        r1 = "SceneSwitched";
        goto L31
    L8:
        if ((r5 instanceof pf9.i0) == true) goto L27;
        if ((r5 instanceof pf9.d0) == false) goto L14;
        this.b.h.b(true, "ReplyBegin");
        this.b.i = true;
        return;
    L14:
        if ((r5 instanceof pf9.f0) == false) goto L25;
        pf9.f0 r7 = (pf9.f0) r5;
        if (pf9.i.j(r7) == false) goto L35;
        z<com.larus.audio.call.arch.c> r2 = this.b;
        if (r2.i == false) goto L36;
        r2.i = false;
        pf9.m r8 = r7.c;
        if (r8 == null) goto L22;
        Map r9 = r8.a;
    L23:
        z.j3(r2, new com.larus.audio.call.play.h.c(r9));
        return;
    L22:
        r9 = null;
        goto L23
    L36:
        return;
    L35:
        return;
    L25:
        if ((r5 instanceof pf9.e0) == false) goto L38;
        z.j3(this.b, com.larus.audio.call.play.h.b.a);
        this.b.i = true;
        return;
    }

    public a0(z<com.larus.audio.call.arch.c> r1, com.larus.audio.call.arch.c r2) {
        this.b = r1;
        this.c = r2;
        this.a = r1.g;
    }
}
