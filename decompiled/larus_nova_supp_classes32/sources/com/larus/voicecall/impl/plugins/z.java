package com.larus.voicecall.impl.plugins;

import android.os.SystemClock;
import com.larus.audio.call.arch.c;
import com.larus.im.service.audio.DataType;
import com.larus.tts.UserSettingRepoDelegate;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class z<C extends com.larus.audio.call.arch.c> extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements com.larus.audio.call.plugins.r0 {
    public final Function0<com.larus.im.service.audio.s> f;
    public final String g;
    public final b78.b h;
    public boolean i;
    public final a0 j;

    public static final class a implements com.larus.im.service.audio.x {
        public final String a;
        public final DataType b;
        public final /* synthetic */ z<C> c;

        public final String getName() {
            return this.a;
        }

        public DataType getType() {
            return this.b;
        }

        public a(z<C> r1) {
            this.c = r1;
            this.a = r1.g;
            this.b = DataType.PLAYER;
        }

        public final void a(com.larus.im.service.audio.l r5) {
            Intrinsics.checkNotNullParameter(r5, "frame");
            FLogger.a.i(this.c.g, "onReceive frame " + r5.a.length + ", silent=" + r5.d + "， extra=" + r5.b());
            if (UserSettingRepoDelegate.a.b() != 0) goto L8;
            if (com.larus.platform.service.z2.a.A2().getForcePlay() == true) goto L8;
            return;
        L8:
            if (r5.d == true) goto L11;
            z.j3(this.c, r5);
            return;
        }
    }

    public final com.larus.im.service.audio.x Q2() {
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

    public final com.larus.im.service.audio.z0 S2() {
        return this.j;
    }

    public final String T2() {
        return this.g;
    }

    public final void cancel(String r3) {
        Intrinsics.checkNotNullParameter(r3, "caller");
        this.h.b(false, r3);
    }

    public z(com.larus.audio.call.arch.c r2, com.larus.audio.call.arch.n r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "postProcessor");
        super(r2);
        this.f = r3;
        this.g = "CommonAudioFrameReceiver";
        this.h = new b78.b("CommonAudioFrameReceiver");
        this.i = true;
        this.j = new a0(this, r2);
    }

    public static final void j3(z r9, Object r10) {
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
        if ((r10 instanceof com.larus.im.service.audio.l) == false) goto L19;
        long r0 = SystemClock.elapsedRealtime();
        com.larus.im.service.audio.l r11 = ((com.larus.im.service.audio.s) r9.f.invoke()).a((com.larus.im.service.audio.l) r10);
        long r2 = SystemClock.elapsedRealtime();
        com.larus.audio.call.arch.b.a(r9.getContext()).p0(new com.larus.audio.call.play.h.a(r11.a, r11.d(), r11.c(), r11.b()));
        long r3 = r2 - r0;
        if (r3 <= 12) goto L20;
        long r4 = SystemClock.elapsedRealtime() - r0;
        FLogger.a.e(r9.g, "[handleData] process " + r3 + "ms, all " + r4 + "ms.");
        return;
    L20:
        return;
    }
}
