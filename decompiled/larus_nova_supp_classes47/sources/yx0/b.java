package yx0;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements d {
    public final wx0.b a;
    public final wx0.a b;

    public b() {
        this.a = new wx0.b();
        this.b = new wx0.a();
    }

    @Override // yx0.d
    public final tx0.a a(rx0.a r13) {
        Intrinsics.checkNotNullParameter(r13, "client");
        Object r0 = r13.a();
        if ((r0 instanceof sx0.b) == true) goto L5;
        return null;
    L5:
        sx0.b r1 = (sx0.b) r0;
        wx0.b r2 = this.a;
        int r3 = r13.getContainerWidth();
        int r4 = r13.l();
        r2.a = Float.valueOf(r3);
        r2.b = Float.valueOf(r4);
        wx0.b r5 = this.a;
        sx0.a r6 = r13.a();
        float r7 = c.a(r13, r1.a());
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "rule");
        if ((r6 instanceof sx0.a.C0316a) == false) goto L9;
        sx0.a.C0316a r8 = (sx0.a.C0316a) r6;
        RectF r9 = r5.a(r8.b, r8.c, r7);
    L30:
        if (r9 != null) goto L32;
        return null;
    L32:
        wx0.a r10 = this.b;
        sx0.a r12 = r13.a();
        Intrinsics.checkNotNullParameter(r13, "$this$containerRatioWH");
        float r14 = r13.getContainerWidth() / r13.l();
        float r15 = c.a(r13, r1.a());
        r1.a();
        RectF r16 = r13.b();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r12, "rule");
        Intrinsics.checkNotNullParameter(r16, "grid");
        RectF r17 = r10.a;
        if ((r12 instanceof sx0.a.C0316a) == false) goto L36;
        RectF r18 = wx0.a.a(((sx0.a.C0316a) r12).c, r14, r15, r16);
    L48:
        r17.set(r18);
        wx0.a r19 = this.b;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r9, "visibleArea");
        RectF r110 = r19.a;
        float r20 = r9.width() / r110.width();
        float r22 = r9.height() / r110.height();
        float r23 = r110.left * r20;
        float r111 = r110.top * r22;
        float r24 = r9.left - r23;
        float r25 = r9.top - r111;
        RectF r112 = new RectF(r24, r25, r20 + r24, r22 + r25);
        RectF r26 = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
        Matrix r27 = new Matrix();
        r27.postTranslate(r112.left - r26.left, r112.top - r26.top);
        r27.postScale(r112.width() / r26.width(), r112.height() / r26.height(), r112.left, r112.top);
        return new tx0.a(r9, r112, r27);
    L36:
        if ((r12 instanceof sx0.a.b) == false) goto L39;
        r18 = new RectF(r16);
        goto L48
    L39:
        if ((r12 instanceof sx0.a.c) == false) goto L42;
        r18 = wx0.a.a(1.0f, r14, r15, r16);
        goto L48
    L42:
        if ((r12 instanceof sx0.a.d) == false) goto L45;
        r18 = wx0.a.b(r14, r15, r16);
        goto L48
    L45:
        if ((r12 instanceof sx0.a.f) == false) goto L47;
        r18 = wx0.a.b(r14, r15, r16);
        goto L48
    L47:
        r18 = new RectF();
        goto L48
    L9:
        if ((r6 instanceof sx0.a.b) == false) goto L14;
        int r28 = ((sx0.a.b) r6).b;
        Float r29 = r5.a;
        if (r29 == null) goto L29;
        float r30 = r29.floatValue() * 1.0f;
        float r32 = r28;
        r9 = new RectF(0.0f, r32, r30, (r30 / r7) + r32);
    L29:
        r9 = null;
        goto L30
    L14:
        if ((r6 instanceof sx0.a.c) == false) goto L17;
        r9 = r5.a(0, 1.0f, r7);
        goto L30
    L17:
        if ((r6 instanceof sx0.a.d) == false) goto L20;
        r9 = r5.b(r7);
        goto L30
    L20:
        if ((r6 instanceof sx0.a.f) == false) goto L29;
        Float r33 = r5.a;
        if (r33 == null) goto L29;
        float r34 = r33.floatValue();
        Float r35 = r5.b;
        if (r35 == null) goto L29;
        float r36 = r35.floatValue();
        float r37 = r34 * 1.0f;
        float r38 = r37 / r7;
        float r113 = (r36 - r38) / 2;
        if (r38 >= r36) goto L28;
        r9 = r5.b(r7);
        goto L30
    L28:
        r9 = new RectF(0.0f, r113, r37, r38 + r113);
        goto L30
    }
}
