package com.larus.audio.call.plugins;

import android.os.SystemClock;
import com.larus.audio.call.arch.c;
import com.larus.im.service.audio.DataType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class e<C extends com.larus.audio.call.arch.c> extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements r0 {
    public final Function0<com.larus.im.service.audio.s> f;
    public final String g;
    public final Lazy h;
    public final b78.b i;
    public boolean j;
    public final f k;

    public static final class a implements com.larus.im.service.audio.x {
        public final String a;
        public final DataType b;
        public final /* synthetic */ e<C> c;

        public final String getName() {
            return this.a;
        }

        public DataType getType() {
            return this.b;
        }

        public a(e<C> r1) {
            this.c = r1;
            this.a = r1.g;
            this.b = DataType.PLAYER;
        }

        public final void a(com.larus.im.service.audio.l r5) {
            Intrinsics.checkNotNullParameter(r5, "frame");
            e<C> r0 = this.c;
            r0.getClass();
            String r1 = com.larus.audio.call.util.m.b(r5.b(), "src_channel");
            if (Intrinsics.areEqual(r0.getContext().params().k.o, "dora_si") == false) goto L5;
            boolean r2 = Intrinsics.areEqual(r1, "1");
        L6:
            if (r2 == false) goto L8;
            com.larus.audio.call.util.e.a.i(this.c.g, "[CALL] onReceiveFrame，frame silent: " + r5.d + " extra: " + r5.b);
            this.c.j3(r5);
            return;
        L8:
            com.larus.audio.call.util.e.a.i(this.c.g, "zchhhhh, audio scrChannel is 0");
            return;
        L5:
            r2 = true;
            goto L6
        }
    }

    @Override // com.larus.audio.call.arch.a
    public com.larus.im.service.audio.x Q2() {
        return new a(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final void X2() {
        cancel("Interrupt");
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        this.i.b(true, "onStart");
        super.e3();
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        cancel("onStop");
        super.g3();
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.z0 S2() {
        return this.k;
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.g;
    }

    public void R1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "caller");
        com.larus.audio.call.arch.b.a(getContext()).R1(r2);
    }

    @Override // com.larus.audio.call.plugins.r0
    public final void cancel(String r3) {
        Intrinsics.checkNotNullParameter(r3, "caller");
        this.i.b(false, r3);
    }

    public void j3(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "input");
        if (this.i.a() == true) goto L6;
        return;
    L6:
        if ((r10 instanceof com.larus.audio.call.play.h.c) == false) goto L9;
        com.larus.audio.call.arch.b.a(getContext()).p0((com.larus.audio.call.play.h) r10);
        return;
    L9:
        if ((r10 instanceof com.larus.audio.call.play.h.b) == false) goto L12;
        com.larus.audio.call.arch.b.a(getContext()).p0((com.larus.audio.call.play.h) r10);
        return;
    L12:
        if ((r10 instanceof com.larus.im.service.audio.l) == false) goto L22;
        long r0 = SystemClock.elapsedRealtime();
        com.larus.im.service.audio.l r11 = (com.larus.im.service.audio.l) r10;
        com.larus.im.service.audio.l r2 = ((com.larus.im.service.audio.s) this.f.invoke()).a(r11);
        long r3 = SystemClock.elapsedRealtime();
        if (r11.d == true) goto L16;
        com.larus.audio.call.arch.b.a(getContext()).p0(new com.larus.audio.call.play.h.a(r2.a, r2.d(), r2.c(), r2.b()));
    L16:
        long r5 = SystemClock.elapsedRealtime() - r0;
        long r4 = r3 - r0;
        if (r4 <= 12) goto L23;
        com.larus.audio.call.util.e.a.e(this.g, "[handleData] process " + r4 + "ms, all " + r5 + "ms.");
        return;
    L23:
        return;
    }

    public e(com.larus.audio.call.arch.c r2, com.larus.audio.call.arch.n r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "postProcessor");
        super(r2);
        this.f = r3;
        this.g = "CommonAudioFrameReceiver";
        this.h = LazyKt.lazy(new d());
        this.i = new b78.b("CommonAudioFrameReceiver");
        this.j = true;
        this.k = new f(this);
    }
}
