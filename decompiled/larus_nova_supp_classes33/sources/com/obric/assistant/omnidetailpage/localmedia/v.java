package com.obric.assistant.omnidetailpage.localmedia;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class v {
    public static final v a = null;
    public static MediaPlayer b;
    public static AudioManager c;
    public static String d;
    public static Function2<? super String, ? super q, Unit> e;
    public static Function0<Unit> f;
    public static boolean g;
    public static boolean h;
    public static final Handler i = null;
    public static final a j = null;
    public static final r k = null;

    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            v.a.getClass();     // Catch: Throwable -> L11
            v.c();     // Catch: Throwable -> L11
            MediaPlayer r0 = v.b;     // Catch: Throwable -> L11
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.isPlaying() != true) goto L7;
        L8:
            if (r1 == false) goto L14;
            v.i.postDelayed(this, 200);     // Catch: Throwable -> L11
            return;
        L14:
            return;
        L7:
            r1 = false;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }
    }

    public v() {
    }

    public final synchronized void d() {
        monitor-enter(this);
        String r0 = d;     // Catch: Throwable -> L19
        i.removeCallbacks(j);     // Catch: Throwable -> L19
        Function2<? super String, ? super q, Unit> r1 = e;     // Catch: Throwable -> L19
        if (r1 == null) goto L6;
        r1.invoke(r0, new q(0));     // Catch: Throwable -> L19
    L6:
        MediaPlayer r2 = b;     // Catch: Throwable -> L19
        if (r2 != null) goto L24;
    L13:
        b = null;     // Catch: Throwable -> L19
        AudioManager r3 = c;     // Catch: Throwable -> L19
        if (r3 == null) goto L16;
        r3.abandonAudioFocus(k);     // Catch: Throwable -> L19
    L16:
        c = null;     // Catch: Throwable -> L19
        d = null;     // Catch: Throwable -> L19
        e = null;     // Catch: Throwable -> L19
        f = null;     // Catch: Throwable -> L19
        g = false;     // Catch: Throwable -> L19
        h = false;     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L24:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L10
        r2.reset();     // Catch: Throwable -> L10
        r2.release();     // Catch: Throwable -> L10
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Result.box-impl(r5);     // Catch: Throwable -> L19
        goto L13
    L10:
        th = move-exception;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L19
        r5 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.obric.assistant.omnidetailpage.localmedia.r] */
    static {
        a = new v();
        i = new Handler(Looper.getMainLooper());
        j = new a();
        k = new r();
    }

    public static q b() {
        MediaPlayer r0 = b;
        Object r2 = 0;
        if (r0 == null) goto L5;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(Integer.valueOf(r0.getDuration()));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r3) == false) goto L13;
        r3 = r2;
    L13:
        int r4 = ((Number) r3).intValue();
        Object r5 = Result.constructor-impl(Integer.valueOf(r0.getCurrentPosition()));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r5) == true) goto L22;
        r2 = r5;
    L22:
        int r6 = ((Number) r2).intValue();
        Object r7 = Result.constructor-impl(Boolean.valueOf(r0.isPlaying()));     // Catch: Throwable -> L25
    L27:
        Boolean r8 = Boolean.FALSE;
        if (Result.isFailure-impl(r7) == false) goto L30;
        r7 = r8;
    L30:
        boolean r9 = ((Boolean) r7).booleanValue();
        if (r4 <= 0) goto L33;
        float r10 = r6 / r4;
    L35:
        return new q(r9, r10);
    L33:
        r10 = 0.0f;
    L25:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L16:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L5:
        return new q(0);
    }

    public static void c() {
        Function2<? super String, ? super q, Unit> r0 = e;
        if (r0 == null) goto L6;
        r0.invoke(d, b());
        return;
    }

    public static void a(MediaPlayer r1) {
        if (fna.g.d() == true) goto L6;
        r1.start();
        return;
    L6:
        r1.start();
        gna.a.c(r1.hashCode());
    }
}
