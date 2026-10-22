package com.bytedance.android.live.revlink.impl.behavior;

import com.airbnb.lottie.LottieAnimationView;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0 {
    public LottieAnimationView a;
    public final d b;
    public final k c;

    public final a a() {
        LottieAnimationView r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return new a(r0);
    }

    public final void b() {
        a r0 = a();
        if (r0 == null) goto L6;
        r0.h();
        return;
    }

    public final void c(float r2) {
        a r0 = a();
        if (r0 == null) goto L6;
        r0.j(r2);
        return;
    }

    public final void d(float r2) {
        this.b.j(r2);
    }

    public d0(d r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "mainButton");
        Intrinsics.checkNotNullParameter(r3, "helper");
        this.b = r2;
        this.c = r3;
    }

    public final Disposable e(e r4, IvPkId r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "iconRes");
        Intrinsics.checkNotNullParameter(r5, "ivPkId");
        if (r6 == false) goto L34;
        if (r5 != IvPkId.BAK) goto L21;
        a0 r7 = new a0(this);
        IconResMode r8 = r4.a;
        if (r8 != IconResMode.IMAGE_MODEL) goto L14;
        py.k r1 = r4.b;
        if (r1 == null) goto L14;
        a r9 = a();
        if (r9 != null) goto L63;
        return null;
    L63:
        return r9.o(r1, r7);
    L14:
        if (r8 != IconResMode.DRAWABLE) goto L64;
        Integer r10 = r4.c;
        if (r10 == null) goto L20;
        int r12 = r10.intValue();
        a r13 = a();
        if (r13 == null) goto L20;
        r13.s(r12);
    L20:
        r7.a();
        r7.c();
        return null;
    L64:
        return null;
    L21:
        b0 r14 = new b0(this);
        IconResMode r15 = r4.a;
        if (r15 != IconResMode.IMAGE_MODEL) goto L27;
        py.k r2 = r4.b;
        if (r2 == null) goto L27;
        return this.b.o(r2, r14);
    L27:
        if (r15 != IconResMode.DRAWABLE) goto L67;
        Integer r16 = r4.c;
        if (r16 == null) goto L31;
        int r17 = r16.intValue();
        this.b.s(r17);
    L31:
        r14.a();
        r14.c();
        return null;
    L67:
        return null;
    L34:
        if (r5 != IvPkId.BAK) goto L50;
        IconResMode r18 = r4.a;
        if (r18 != IconResMode.IMAGE_MODEL) goto L43;
        py.k r19 = r4.b;
        if (r19 == null) goto L43;
        a r3 = a();
        if (r3 == null) goto L43;
        r3.f(r19);
    L43:
        if (r18 != IconResMode.DRAWABLE) goto L49;
        Integer r20 = r4.c;
        if (r20 == null) goto L49;
        int r22 = r20.intValue();
        a r23 = a();
        if (r23 == null) goto L49;
        r23.s(r22);
    L49:
        c(1.0f);
        this.b.h();
    L61:
        return null;
    L50:
        IconResMode r24 = r4.a;
        if (r24 != IconResMode.IMAGE_MODEL) goto L56;
        py.k r25 = r4.b;
        if (r25 == null) goto L56;
        this.b.f(r25);
    L56:
        if (r24 != IconResMode.DRAWABLE) goto L60;
        Integer r26 = r4.c;
        if (r26 == null) goto L60;
        int r27 = r26.intValue();
        this.b.s(r27);
    L60:
        d(1.0f);
        b();
        goto L61
    }
}
