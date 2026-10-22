package com.obric.audio.continuous_talk.session.impl.plugin;

import com.larus.im.service.audio.z0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import pf9.a0;
import pf9.d0;
import pf9.e0;
import pf9.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d extends z0 {
    public final String a;
    public final /* synthetic */ c b;
    public final /* synthetic */ com.obric.audio.continuous_talk.session.impl.a c;

    public final String g() {
        return this.a;
    }

    public final void n(z0.a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof a0) == false) goto L6;
        c r4 = this.b;
        r4.i = true;
        r4.h.b(true, "QueryEnd");
        com.larus.audio.call.arch.b.a(this.c).R1("QueryEnd");
        return;
    L6:
        if ((r3 instanceof d0) == false) goto L9;
        this.b.h.b(true, "ReplyBegin");
        this.b.i = true;
        return;
    L9:
        if ((r3 instanceof f0) == false) goto L20;
        f0 r5 = (f0) r3;
        if (pf9.i.j(r5) == false) goto L25;
        c r0 = this.b;
        if (r0.i == false) goto L26;
        r0.i = false;
        pf9.m r6 = r5.c;
        if (r6 == null) goto L17;
        Map r7 = r6.a;
    L18:
        c.j3(r0, new com.larus.audio.call.play.h.c(r7));
        return;
    L17:
        r7 = null;
        goto L18
    L26:
        return;
    L25:
        return;
    L20:
        if ((r3 instanceof e0) == false) goto L28;
        c.j3(this.b, com.larus.audio.call.play.h.b.a);
        this.b.i = true;
        return;
    }

    public d(c r1, com.obric.audio.continuous_talk.session.impl.a r2) {
        this.b = r1;
        this.c = r2;
        this.a = r1.g;
    }
}
