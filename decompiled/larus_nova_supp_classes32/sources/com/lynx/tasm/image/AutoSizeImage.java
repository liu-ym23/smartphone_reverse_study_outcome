package com.lynx.tasm.image;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.group.d;
import y6a.h;
import y6a.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AutoSizeImage extends ShadowNode implements h {
    public Handler A;
    public a B;
    public String C;
    public final Object D;
    public boolean v;
    public boolean w;
    public int x;
    public int y;
    public boolean z;

    public class a implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ AutoSizeImage f;

        @Override // java.lang.Runnable
        public final void run() {
            AutoSizeImage.C(this.f, this.a, this.b, this.c, this.d, this.e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(AutoSizeImage r1, boolean r2, int r3, int r4, int r5, int r6) {
            this.f = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ AutoSizeImage f;

        @Override // java.lang.Runnable
        public final void run() {
            AutoSizeImage.C(this.f, this.a, this.b, this.c, this.d, this.e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(AutoSizeImage r1, boolean r2, int r3, int r4, int r5, int r6) {
            this.f = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public AutoSizeImage() {
        this.v = false;
        this.w = false;
        this.z = true;
        this.D = new Object();
        i(this);
    }

    @LynxProp(name = LynxError.LYNX_ERROR_KEY_RESOURCE_URL)
    public void setSrc(String r1) {
        this.C = r1;
    }

    public final void D(boolean r11, int r12, int r13, int r14, int r15) {
        Object r0 = this.D;
        monitor-enter(r0);
        Handler r1 = this.A;     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        this.B = new a(this, r11, r12, r13, r14, r15);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        r1.post(new b(this, r11, r12, r13, r14, r15));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // y6a.h
    public final long c(LayoutNode r8, float r9, MeasureMode r10, float r11, MeasureMode r12) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        String r13 = "AutoSizeImage Measure: " + r9 + ":" + r10.intValue() + " - " + r11 + ":" + r12.intValue() + " " + this.C;
        TraceEvent.beginSection(r13);
    L6:
        Object r1 = this.D;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.A != null) goto L15;
        Handler r2 = new Handler(Looper.myLooper());     // Catch: Throwable -> L13
        this.A = r2;     // Catch: Throwable -> L13
        a r3 = this.B;     // Catch: Throwable -> L13
        if (r3 == null) goto L15;
        r2.post(r3);     // Catch: Throwable -> L13
        this.B = null;     // Catch: Throwable -> L13
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L13
        MeasureMode r0 = MeasureMode.EXACTLY;
        boolean r4 = false;
        if (r10 != r0) goto L20;
        if (r12 != r0) goto L20;
        boolean r5 = true;
    L21:
        this.z = r5;
        if (r5 == true) goto L24;
        LynxContext r6 = this.m;
        if (r6 == null) goto L33;
        d r7 = r6.getRuntimeCacheManager();
        if (r7 == null) goto L33;
        r7.d();
    L33:
        int r14 = this.x;
        int r15 = this.y;
        if (r9 != 0.0f) goto L38;
        if (r10 == MeasureMode.UNDEFINED) goto L38;
    L41:
        r4 = true;
    L42:
        this.z = r4;
        if (this.v == false) goto L82;
        if (r14 <= 0) goto L82;
        if (r15 <= 0) goto L82;
        if (r4 == true) goto L82;
        if (r10 != r0) goto L57;
        float r16 = (r15 / r14) * r9;
        if (r12 != MeasureMode.AT_MOST) goto L55;
        if (r11 <= r16) goto L77;
    L56:
        r11 = r16;
    L77:
        if (TraceEvent.isTracingStarted() == false) goto L80;
        TraceEvent.endSection(r13);
    L80:
        return i.a(r9, r11);
    L55:
        if (r12 != MeasureMode.UNDEFINED) goto L77;
    L57:
        MeasureMode r17 = MeasureMode.UNDEFINED;
        if (r10 != r17) goto L60;
        r9 = 65535;
    L60:
        if (r12 != r17) goto L62;
        r11 = 65535;
    L62:
        float r18 = r14;
        if (r12 != r0) goto L68;
        float r19 = (r18 / r15) * r11;
        if (r9 <= r19) goto L77;
        r9 = r19;
        goto L77
    L68:
        if (r18 > r9) goto L72;
        float r110 = r15;
        if (r110 > r11) goto L72;
        r9 = r18;
        r11 = r110;
    L72:
        float r111 = r15 / r18;
        if ((r11 / r9) >= r111) goto L75;
        r9 = r11 / r111;
        goto L77
    L75:
        r11 = r111 * r9;
    L82:
        if (TraceEvent.isTracingStarted() == false) goto L84;
        TraceEvent.endSection(r13);
    L84:
        if (r10 == r0) goto L87;
        r9 = 0.0f;
    L87:
        if (r12 == r0) goto L91;
        r11 = 0.0f;
    L91:
        return i.a(r9, r11);
    L38:
        if (r11 != 0.0f) goto L42;
        if (r12 == MeasureMode.UNDEFINED) goto L42;
    L24:
        if (TraceEvent.isTracingStarted() == false) goto L26;
        TraceEvent.endSection(r13);
    L26:
        this.w = true;
        return i.a(r9, r11);
    L20:
        r5 = false;
        goto L21
    L5:
        r13 = null;
        goto L6
    }

    public static void C(AutoSizeImage r2, boolean r3, int r4, int r5, int r6, int r7) {
        boolean r0 = r2.v;
        r2.v = r3;
        r2.x = r4;
        r2.y = r5;
        if (r4 != 0) goto L6;
        if (r5 != 0) goto L6;
        return;
    L6:
        LynxContext r1 = r2.m;
        if (r1 != null) goto L9;
    L13:
        if (r0 == r3) goto L16;
        r2.q();
        return;
    L16:
        if (r2.z == true) goto L34;
        if (r3 == false) goto L28;
        if (r4 <= 0) goto L29;
        if (r5 <= 0) goto L30;
        if (r6 == 0) goto L25;
        if (r7 == 0) goto L25;
        if (Math.abs((r6 / r7) - (r4 / r5)) > 0.05d) goto L25;
        return;
    L25:
        r2.q();
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L34:
        return;
    L9:
        if (r1.isEmbeddedModeOn() == false) goto L13;
        if (r2.w == false) goto L13;
    }
}
