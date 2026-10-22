package com.obric.oui.orecyclerview.widget;

import androidx.core.os.TraceCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements Runnable {
    public static final ThreadLocal e = null;
    public static final m f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f13870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f13871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f13872c;
    public ArrayList d;

    static {
        e = new ThreadLocal();
        f = new m();
    }

    public static x0 c(RecyclerView r5, int r10, long r11) {
        int r12 = r5.e.s();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        x0 r14 = RecyclerView.F(r5.e.r(r13));
        if (r14.mPosition != r10) goto L10;
        if (r14.isInvalid() == true) goto L10;
        return null;
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        q0 r15 = r5.f13728b;
        r5.K();     // Catch: Throwable -> L19
        x0 r16 = r15.j(r10, r11);     // Catch: Throwable -> L19
        if (r16 != null) goto L15;
    L22:
        r5.L(false);
        return r16;
    L15:
        if (r16.isBound() == true) goto L17;
    L21:
        r15.a(r16, false);     // Catch: Throwable -> L19
        goto L22
    L17:
        if (r16.isInvalid() == true) goto L21;
        r15.g(r16.itemView);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r5.L(false);
        throw th;
    }

    public final void a(RecyclerView r5, int r10, int r11) {
        if (r5.f13753r == true) goto L5;
    L14:
        com.airbnb.lottie.parser.moshi.c r12 = r5.f13727a0;
        r12.f1313a = r10;
        r12.f1314b = r11;
        return;
    L5:
        if (RecyclerView.f13723x0 == false) goto L12;
        if (this.f13870a.contains(r5) == true) goto L12;
        throw new IllegalStateException("attempting to post unregistered view!");
    L12:
        if (this.f13871b != 0) goto L14;
        this.f13871b = r5.getNanoTime();
        r5.post(this);
        goto L14
    }

    public final void b(long r16) {
        ArrayList r5 = this.f13870a;
        int r10 = r5.size();
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L8;
        RecyclerView r13 = (RecyclerView) r5.get(r11);
        if (r13.getWindowVisibility() != 0) goto L7;
        com.airbnb.lottie.parser.moshi.c r14 = r13.f13727a0;
        r14.h(r13, false);
        r12 = r12 + r14.f1315c;
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        ArrayList r15 = this.d;
        r15.ensureCapacity(r12);
        int r17 = 0;
        int r18 = 0;
    L10:
        if (r17 >= r10) goto L27;
        RecyclerView r19 = (RecyclerView) r5.get(r17);
        if (r19.getWindowVisibility() != 0) goto L26;
        com.airbnb.lottie.parser.moshi.c r20 = r19.f13727a0;
        int r110 = Math.abs(r20.f1314b) + Math.abs(r20.f1313a);
        int r21 = 0;
    L16:
        if (r21 >= (r20.f1315c * 2)) goto L26;
        if (r18 < r15.size()) goto L20;
        n r111 = new n();
        r15.add(r111);
    L21:
        int[] r112 = (int[]) r20.d;
        int r113 = r112[r21 + 1];
        if (r113 > r110) goto L24;
        boolean r114 = true;
    L25:
        r111.f13867a = r114;
        r111.f13868b = r110;
        r111.f13869c = r113;
        r111.d = r19;
        r111.e = r112[r21];
        r18 = r18 + 1;
        r21 = r21 + 2;
        goto L16
    L24:
        r114 = false;
        goto L25
    L20:
        r111 = (n) r15.get(r18);
    L26:
        r17 = r17 + 1;
        goto L10
    L27:
        Collections.sort(r15, f);
        int r22 = 0;
    L29:
        if (r22 >= r15.size()) goto L73;
        n r23 = (n) r15.get(r22);
        RecyclerView r24 = r23.d;
        if (r24 == null) goto L89;
        if (r23.f13867a == false) goto L36;
        long r25 = Long.MAX_VALUE;
    L37:
        x0 r26 = c(r24, r23.e, r25);
        if (r26 == null) goto L72;
        if (r26.mNestedRecyclerView == null) goto L72;
        if (r26.isBound() == false) goto L72;
        if (r26.isInvalid() == true) goto L72;
        RecyclerView r27 = r26.mNestedRecyclerView.get();
        if (r27 == null) goto L72;
        if (r27.B == true) goto L51;
    L59:
        com.airbnb.lottie.parser.moshi.c r28 = r27.f13727a0;
        r28.h(r27, true);
        if (r28.f1315c == 0) goto L72;
        TraceCompat.beginSection("RV Nested Prefetch");     // Catch: Throwable -> L66
        u0 r29 = r27.f13729b0;     // Catch: Throwable -> L66
        a0 r30 = r27.f13742l;     // Catch: Throwable -> L66
        r29.f13913c = 1;     // Catch: Throwable -> L66
        r29.d = r30.getItemCount();     // Catch: Throwable -> L66
        r29.f = false;     // Catch: Throwable -> L66
        r29.g = false;     // Catch: Throwable -> L66
        r29.f13914h = false;     // Catch: Throwable -> L66
        int r31 = 0;
    L63:
        if (r31 >= (r28.f1315c * 2)) goto L68;
        c(r27, ((int[]) r28.d)[r31], r16);     // Catch: Throwable -> L66
        r31 = r31 + 2;
        goto L63
    L68:
        TraceCompat.endSection();
    L66:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    L51:
        if (r27.e.s() == 0) goto L59;
        g0 r32 = r27.H;
        if (r32 == null) goto L55;
        r32.e();
    L55:
        k0 r33 = r27.f13743m;
        q0 r34 = r27.f13728b;
        if (r33 == null) goto L58;
        r33.M(r34);
        r27.f13743m.N(r34);
    L58:
        r34.f13885a.clear();
        r34.e();
    L72:
        r23.f13867a = false;
        r23.f13868b = 0;
        r23.f13869c = 0;
        r23.d = null;
        r23.e = 0;
        r22 = r22 + 1;
        goto L29
    L36:
        r25 = r16;
        goto L37
    L89:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TraceCompat.beginSection("RV Prefetch");     // Catch: Throwable -> L14
        ArrayList r5 = this.f13870a;
        if (r5.isEmpty() == false) goto L9;
    L7:
        this.f13871b = 0;
        TraceCompat.endSection();
        return;
    L9:
        int r10 = r5.size();     // Catch: Throwable -> L14
        int r11 = 0;
        long r12 = 0;
    L10:
        if (r11 >= r10) goto L18;
        RecyclerView r13 = (RecyclerView) r5.get(r11);     // Catch: Throwable -> L14
        if (r13.getWindowVisibility() != 0) goto L16;
        r12 = Math.max(r13.getDrawingTime(), r12);     // Catch: Throwable -> L14
    L16:
        r11 = r11 + 1;     // Catch: Throwable -> L14
        goto L10
    L18:
        if (r12 == 0) goto L7;
        b(TimeUnit.MILLISECONDS.toNanos(r12) + this.f13872c);     // Catch: Throwable -> L14
        this.f13871b = 0;
        TraceCompat.endSection();
        return;
    L14:
        th = move-exception;
        this.f13871b = 0;
        TraceCompat.endSection();
        throw th;
    }
}
