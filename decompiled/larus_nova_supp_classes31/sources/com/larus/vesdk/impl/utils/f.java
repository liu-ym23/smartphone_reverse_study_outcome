package com.larus.vesdk.impl.utils;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.vesdk.VERecorder;
import com.ss.android.vesdk.lens.VEBaseRecorderLensParams;
import com.ss.android.vesdk.lens.VELumaDetectParams;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public final VERecorder a;
    public final Function0<Boolean> b;
    public final AtomicBoolean c;
    public final Handler d;
    public Boolean e;
    public final CopyOnWriteArrayList<pq9.c> f;
    public final boolean g;
    public final i h;

    public static final class a {
    }

    public final class b implements Runnable {
        public int a;
        public int b;
        public boolean c;
        public final /* synthetic */ f d;

        public static final class a implements VERecorder.VERecorderLensCallback {
            public final /* synthetic */ b a;
            public final /* synthetic */ long b;
            public final /* synthetic */ f c;

            public final void onInfo(int r1, int r2, int r3, String r4) {
            }

            public a(b r1, long r2, f r4) {
                this.a = r1;
                this.b = r2;
                this.c = r4;
            }

            public final void onError(int r2, int r3, String r4) {
                b r5 = this.a;
                if (r5.c == false) goto L5;
                return;
            L5:
                r5.c = true;
                FLogger.a.e("VeLumaDetector", "onError, msg:" + r4);
                this.c.h.onResult(false);
                this.a.b();
            }

            /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.vesdk.impl.utils.g] */
            public final void onSuccess(int r6, float r7, int r8) {
                final b r9 = this.a;
                if (r9.c == false) goto L5;
                return;
            L5:
                final long r0 = this.b;
                final f r10 = this.c;
                ?? r2 = new g(r9, r0, r10);
                r9.a++;
                if (Math.abs(((double) r7) - 1.0d) <= 1.0E-5d) goto L8;
                boolean r11 = true;
            L9:
                if (r11 == false) goto L14;
                int r12 = r9.b + 1;
                r9.b = r12;
                if (r12 < 5) goto L14;
                r2.invoke(Boolean.TRUE);
                return;
            L14:
                if (r9.a < 10) goto L18;
                r2.invoke(Boolean.FALSE);
                return;
            L18:
                return;
            L8:
                r11 = false;
                goto L9
            }
        }

        public final void a() {
            if (((Boolean) this.d.b.invoke()).booleanValue() == true) goto L6;
            FLogger.a.i("VeLumaDetector", "camera is not previewing, no support detect");
            this.d.h.onResult(false);
            b();
            return;
        L6:
            long r3 = System.currentTimeMillis();
            VELumaDetectParams r0 = new VELumaDetectParams();
            ((VEBaseRecorderLensParams) r0).algorithmFlag = 27;
            r0.detectFrames = 10;
            f r5 = this.d;
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L9
            r5.a.setLensParams(r0, new a(this, r3, r5));     // Catch: Throwable -> L9
            Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        L11:
            f r4 = this.d;
            Throwable r2 = Result.exceptionOrNull-impl(r1);
            if (r2 != null) goto L14;
            return;
        L14:
            if (this.c == false) goto L16;
            return;
        L16:
            this.c = true;
            FLogger.a.e("VeLumaDetector", "setLensParams failed", r2);
            r4.h.onResult(false);
            b();
            return;
        L9:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L11
        }

        public final void b() {
            this.d.d.removeCallbacksAndMessages(null);
            if ((!this.d.f.isEmpty()) == true) goto L5;
        L7:
            this.d.b();
            return;
        L5:
            if (((Boolean) this.d.b.invoke()).booleanValue() == false) goto L7;
            f r0 = this.d;
            r0.d.postDelayed(new b(r0), 1000);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(f r1) {
            this.d = r1;
        }
    }

    static {
    }

    public final void b() {
        this.e = null;
        this.f.clear();
        this.c.set(false);
        this.d.removeCallbacksAndMessages(null);
        FLogger.a.i("VeLumaDetector", "release detect");
    }

    public final void a(pq9.c r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.f.add(r3);
        if (this.c.getAndSet(true) == true) goto L6;
        this.d.post(new b(this));
        FLogger.a.i("VeLumaDetector", "start detect");
        return;
    }

    public f(VERecorder r2, com.larus.vesdk.impl.camera.j r3) {
        Intrinsics.checkNotNullParameter(r2, "recorder");
        Intrinsics.checkNotNullParameter(r3, "isPreviewing");
        this.a = r2;
        this.b = r3;
        this.c = new AtomicBoolean(false);
        this.d = new Handler(Looper.getMainLooper());
        this.f = new CopyOnWriteArrayList();
        this.g = z2.a.enableCameraLumaDetectOpt();
        this.h = new i(this);
    }
}
