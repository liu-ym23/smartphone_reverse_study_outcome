package yx0;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements d {
    public final vx0.a a;

    public a() {
        this.a = new vx0.a();
    }

    @Override // yx0.d
    public final tx0.a a(rx0.a r8) {
        Intrinsics.checkNotNullParameter(r8, "client");
        sx0.a r0 = r8.a();
        if ((r0 instanceof sx0.a.e) == true) goto L6;
        return null;
    L6:
        RectF r1 = ((sx0.a.e) r0).a;
        vx0.a r2 = this.a;
        RectF r3 = r8.b();
        int r4 = r8.getContainerWidth();
        int r9 = r8.l();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "playerArea");
        Intrinsics.checkNotNullParameter(r3, "grid");
        float r5 = r1.width() * r3.left;
        float r6 = r1.height() * r3.top;
        float r7 = r1.width() * r3.width();
        float r10 = r1.height() * r3.height();
        float r12 = r1.left + r5;
        float r13 = r1.top + r6;
        float r14 = r7 + r12;
        float r15 = RangesKt.coerceAtLeast(r12, 0.0f);
        float r16 = RangesKt.coerceAtMost(r14, r4);
        RectF r17 = new RectF(r15, RangesKt.coerceAtLeast(r13, 0.0f), r16, RangesKt.coerceAtMost(r10 + r13, r9));
        RectF r18 = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
        Matrix r19 = new Matrix();
        r19.postTranslate(r1.left - r18.left, r1.top - r18.top);
        r19.postScale(r1.width() / r18.width(), r1.height() / r18.height(), r1.left, r1.top);
        return new tx0.a(r17, r1, r19);
    }
}
