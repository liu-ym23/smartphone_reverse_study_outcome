package com.obric.audio.continuous_talk.session.impl.plugin;

import android.os.SystemClock;
import com.larus.audio.call.plugins.r0;
import com.larus.im.service.audio.DataType;
import com.larus.im.service.audio.s;
import com.larus.im.service.audio.x;
import com.larus.im.service.audio.z0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c extends com.larus.audio.call.arch.a<com.obric.audio.continuous_talk.session.impl.a> implements r0 {
    public final Function0<s> f;
    public final String g;
    public final b78.b h;
    public boolean i;
    public final d j;

    public static final class a implements x {
        public final String a;
        public final DataType b;
        public final /* synthetic */ c c;

        public final String getName() {
            return this.a;
        }

        public DataType getType() {
            return this.b;
        }

        public a(c r1) {
            this.c = r1;
            this.a = r1.g;
            this.b = DataType.PLAYER;
        }

        public final void a(com.larus.im.service.audio.l r5) {
            Intrinsics.checkNotNullParameter(r5, "frame");
            com.larus.audio.call.util.e.a.i(this.c.g, "[CALL] onReceiveFrame，frame: " + r5.b);
            c.j3(this.c, r5);
        }
    }

    public final x Q2() {
        return new a(this);
    }

    public final void X2() {
        cancel("Interrupt");
    }

    public final void e3() {
        this.h.b(true, "onStart");
        super.e3();
    }

    public final void g3() {
        cancel("onStop");
        super.g3();
    }

    public final z0 S2() {
        return this.j;
    }

    public final String T2() {
        return this.g;
    }

    public final void cancel(String r3) {
        Intrinsics.checkNotNullParameter(r3, "caller");
        this.h.b(false, r3);
    }

    public c(com.obric.audio.continuous_talk.session.impl.a r2, com.larus.audio.call.arch.n r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "postProcessor");
        super(r2);
        this.f = r3;
        this.g = "ObricConstTalkAudioFrameReceiver";
        this.h = new b78.b("ObricConstTalkAudioFrameReceiver");
        this.i = true;
        this.j = new d(this, r2);
    }

    public static final void j3(c r9, Object r10) {
        if (r9.h.a() == true) goto L6;
        return;
    L6:
        if ((r10 instanceof com.larus.audio.call.play.h.c) == false) goto L9;
        com.larus.audio.call.arch.b.a(r9.getContext()).p0((com.larus.audio.call.play.h) r10);
        return;
    L9:
        if ((r10 instanceof com.larus.audio.call.play.h.b) == false) goto L12;
        com.larus.audio.call.arch.b.a(r9.getContext()).p0((com.larus.audio.call.play.h) r10);
        return;
    L12:
        if ((r10 instanceof com.larus.im.service.audio.l) == false) goto L22;
        long r0 = SystemClock.elapsedRealtime();
        com.larus.im.service.audio.l r11 = ((s) r9.f.invoke()).a((com.larus.im.service.audio.l) r10);
        long r2 = SystemClock.elapsedRealtime();
        if (r11.d == true) goto L16;
        com.larus.audio.call.arch.b.a(r9.getContext()).p0(new com.larus.audio.call.play.h.a(r11.a, r11.d(), r11.c(), r11.b()));
    L16:
        long r4 = SystemClock.elapsedRealtime() - r0;
        long r3 = r2 - r0;
        if (r3 <= 12) goto L23;
        com.larus.audio.call.util.e.a.e(r9.g, "[handleData] process " + r3 + "ms, all " + r4 + "ms.");
        return;
    L23:
        return;
    }
}
