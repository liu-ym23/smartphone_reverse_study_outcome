package com.larus.avlink.e.mock;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements h49.d {
    public final h49.d a;
    public final j b;

    /* JADX INFO: renamed from: com.larus.avlink.e.mock.a$a, reason: collision with other inner class name */
    public static final class C0004a {
    }

    static {
    }

    public final void a(int r2) {
        j r0 = this.b;
        if (r0 == null) goto L5;
        r0.a(r2);
    L5:
        this.a.a(r2);
    }

    public final void d(b49.g r2) {
        j r0 = this.b;
        if (r0 == null) goto L5;
        r0.f(r2);
    L5:
        this.a.d(r2);
    }

    public final void w(b49.k r2) {
        Intrinsics.checkNotNullParameter(r2, "trackInfo");
        j r0 = this.b;
        if (r0 == null) goto L5;
        r0.c(r2);
    L5:
        this.a.w(r2);
    }

    public final void c(b49.h r2, b49.d r3) {
        Intrinsics.checkNotNullParameter(r2, "imageInfo");
        j r0 = this.b;
        if (r0 == null) goto L5;
        r0.d(r2, r3);
    L5:
        this.a.c(r2, r3);
    }

    public a(com.larus.avlink.e.l.a r3, g r4, f r5) {
        Intrinsics.checkNotNullParameter(r3, "originalListener");
        this.a = r3;
        this.b = r4;
        FLogger r6 = FLogger.a;
        StringBuilder r0 = new StringBuilder("CameraMockDecoratorListener initialized. Recorder=");
        boolean r1 = false;
        if (r4 == null) goto L5;
        boolean r7 = true;
    L6:
        r0.append(r7);
        r0.append(", Player=");
        if (r5 == null) goto L9;
        r1 = true;
    L9:
        r0.append(r1);
        r6.i("CameraMockDecoratorListener", r0.toString());
        return;
    L5:
        r7 = false;
        goto L6
    }

    public final void j(boolean r2, int r3, byte r4) {
        j r0 = this.b;
        if (r0 == null) goto L5;
        r0.e(r2, r3);
    L5:
        this.a.j(r2, r3, r4);
    }

    public final void b(int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33, int r34, int r35, int r36, long r37, int r39, int r40, int r41) {
        j r1 = this.b;
        if (r1 == null) goto L5;
        r1.b(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r39, r40, r41);
    L5:
        this.a.b(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r39, r40, r41);
    }
}
