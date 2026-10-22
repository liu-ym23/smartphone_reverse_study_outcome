package com.larus.audio.call.plugins;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f extends com.larus.im.service.audio.z0 {
    public final String a;
    public final /* synthetic */ e<com.larus.audio.call.arch.c> b;

    public final String g() {
        return this.a;
    }

    public f(e<com.larus.audio.call.arch.c> r1) {
        this.b = r1;
        this.a = r1.g;
    }

    public final void n(com.larus.im.service.audio.z0.a r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r5, "event");
        if ((r5 instanceof pf9.z) == false) goto L5;
        this.b.i.b(false, "QueryBegin");
        this.b.j = true;
        return;
    L5:
        boolean r0 = r5 instanceof pf9.a0;
        if (r0 == false) goto L8;
    L29:
        e<com.larus.audio.call.arch.c> r6 = this.b;
        r6.j = true;
        if (r0 == false) goto L32;
        String r1 = "QueryEnd";
    L33:
        r6.i.b(true, r1);
        this.b.R1(r1);
        return;
    L32:
        r1 = "SceneSwitched";
        goto L33
    L8:
        if ((r5 instanceof pf9.i0) == true) goto L29;
        if ((r5 instanceof pf9.d0) == false) goto L16;
        this.b.i.b(true, "ReplyBegin");
        if (((Boolean) this.b.h.getValue()).booleanValue() == false) goto L36;
        this.b.j = true;
        return;
    L36:
        return;
    L16:
        if ((r5 instanceof pf9.f0) == false) goto L27;
        pf9.f0 r7 = (pf9.f0) r5;
        if (pf9.i.j(r7) == false) goto L38;
        e<com.larus.audio.call.arch.c> r2 = this.b;
        if (r2.j == false) goto L39;
        r2.j = false;
        pf9.m r8 = r7.c;
        if (r8 == null) goto L24;
        Map r9 = r8.a;
    L25:
        r2.j3(new com.larus.audio.call.play.h.c(r9));
        return;
    L24:
        r9 = null;
        goto L25
    L39:
        return;
    L38:
        return;
    L27:
        if ((r5 instanceof pf9.e0) == false) goto L41;
        this.b.j3(com.larus.audio.call.play.h.b.a);
        this.b.j = true;
        return;
    }
}
