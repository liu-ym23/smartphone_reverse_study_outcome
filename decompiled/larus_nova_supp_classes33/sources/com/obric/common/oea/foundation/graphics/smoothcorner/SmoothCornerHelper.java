package com.obric.common.oea.foundation.graphics.smoothcorner;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import lja.c;
import lja.d;
import lja.f;
import lja.g;
import lja.h;
import mja.b;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SmoothCornerHelper {
    public static final List<Integer> b = null;
    public d a;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerHelper$Companion$CurveType;", "", "QUADRATIC", "SKETCH", "FIGMA", "BASIC", "QUADRATIC_CAPSULE", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum CurveType extends Enum<CurveType> {
            public static final CurveType BASIC = null;
            public static final CurveType FIGMA = null;
            public static final CurveType QUADRATIC = null;
            public static final CurveType QUADRATIC_CAPSULE = null;
            public static final CurveType SKETCH = null;
            public static final /* synthetic */ CurveType[] a = null;

            static {
                CurveType r1 = new CurveType("QUADRATIC", 0);
                QUADRATIC = r1;
                CurveType r2 = new CurveType("SKETCH", 1);
                SKETCH = r2;
                CurveType r3 = new CurveType("FIGMA", 2);
                FIGMA = r3;
                CurveType r4 = new CurveType("BASIC", 3);
                BASIC = r4;
                CurveType r5 = new CurveType("QUADRATIC_CAPSULE", 4);
                QUADRATIC_CAPSULE = r5;
                a = new CurveType[]{r1, r2, r3, r4, r5};
            }

            public static CurveType valueOf(String r1) {
                return (CurveType) a.a(CurveType.class, r1);
            }

            public static CurveType[] values() {
                return (CurveType[]) a.clone();
            }

            public CurveType(String r1, int r2) {
                super(r1, r2);
            }
        }
    }

    static {
        b = CollectionsKt.toList(RangesKt.step(new IntRange(8, 48), 2));
    }

    public SmoothCornerHelper() {
        new b();
        this.a = new g();
    }

    public final void b(Companion.CurveType r3) {
        Intrinsics.checkNotNullParameter(r3, "curveType");
        Intrinsics.checkNotNullParameter(r3, "curveType");
        mja.a.C0063a r0 = mja.a.a;
        mja.a.a("SmoothCornerHelper", "setCurveType: " + r3);
        int r4 = kja.a.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        d r5 = new lja.a();
    L22:
        this.a = r5;
        return;
    L5:
        if (r4 == 2) goto L18;
        if (r4 != 3) goto L9;
        r5 = new h();
        goto L22
    L9:
        if (r4 != 4) goto L11;
        r5 = new c();
        goto L22
    L11:
        if (r4 != 5) goto L14;
        r5 = new f();
        goto L22
    L14:
        throw new NoWhenBranchMatchedException();
    L18:
        if ((-1.0f) <= 0) goto L20;
        r5 = new g(-1.0f);
        goto L22
    L20:
        r5 = new g();
        goto L22
    }

    public final void a(Canvas r14, Paint r15, float r16, float r17, float r18, float r19, float r20) {
        Intrinsics.checkNotNullParameter(r14, "canvas");
        Intrinsics.checkNotNullParameter(r15, "paint");
        float r10 = 0.0f;
        if (r20 >= 0.0f) goto L5;
        mja.a.C0063a r11 = mja.a.a;
        mja.a.b("SmoothCornerHelper", "invalid radius: " + r20);
    L7:
        if (r10 <= (Math.min(r18 - r16, r19 - r17) / 2)) goto L9;
        d r1 = this.a;
        int r12 = d.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r14, "canvas");
        Intrinsics.checkNotNullParameter(r15, "paint");
        r1.a.set(r16, r17, r18, r19);
        r14.drawRoundRect(r1.a, r10, r10, r15);
        return;
    L9:
        this.a.d(r14, r15, r16, r17, r18, r19, r10);
        return;
    L5:
        r10 = r20;
        goto L7
    }
}
