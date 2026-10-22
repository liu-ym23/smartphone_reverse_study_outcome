package com.obric.common.oea.foundation.graphics.smoothcorner;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import r8.a;
import s8.d;
import s8.e;
import s8.f;
import s8.g;
import s8.h;
import t8.b;
import t8.c;

/* JADX INFO: loaded from: classes2.dex */
public final class SmoothCornerHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Integer> f5788b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f5789a;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerHelper$Companion$CurveType;", "", "<init>", "(Ljava/lang/String;I)V", "QUADRATIC", "SKETCH", "FIGMA", "BASIC", "QUADRATIC_CAPSULE", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum CurveType extends Enum<CurveType> {
            private static final /* synthetic */ CurveType[] $VALUES = null;
            public static final CurveType BASIC = null;
            public static final CurveType FIGMA = null;
            public static final CurveType QUADRATIC = null;
            public static final CurveType QUADRATIC_CAPSULE = null;
            public static final CurveType SKETCH = null;

            static {
                CurveType r10 = new CurveType("QUADRATIC", 0);
                QUADRATIC = r10;
                CurveType r11 = new CurveType("SKETCH", 1);
                SKETCH = r11;
                CurveType r12 = new CurveType("FIGMA", 2);
                FIGMA = r12;
                CurveType r13 = new CurveType("BASIC", 3);
                BASIC = r13;
                CurveType r14 = new CurveType("QUADRATIC_CAPSULE", 4);
                QUADRATIC_CAPSULE = r14;
                $VALUES = new CurveType[]{r10, r11, r12, r13, r14};
            }

            private CurveType(String r10, int r11) {
                super(r10, r11);
            }

            public static CurveType valueOf(String r10) {
                return (CurveType) Enum.valueOf(CurveType.class, r10);
            }

            public static CurveType[] values() {
                return (CurveType[]) $VALUES.clone();
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new Companion(null);
        f5788b = CollectionsKt.toList(RangesKt.step(new IntRange(8, 48), 2));
    }

    public SmoothCornerHelper() {
        new c();
        this.f5789a = new g(0.0f, 1, null);
    }

    private final e f(float r10, float r11, float r12, float r13) {
        float r14 = r10 - r11;
        float r15 = r12 - r13;
        return new e(((r11 + r10) / 2.0f) - (r14 / 2.0f), ((r13 + r12) / 2.0f) - (r15 / 2.0f));
    }

    public final Path a(float r10, float r11, float r12, float r13, float r14) {
        return this.f5789a.a(r10, r11, r12, r13, r14);
    }

    public final Path b(Rect r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "rect");
        return a(r10.left, r10.top, r10.right, r10.bottom, r11);
    }

    public final boolean c(float r10, float r11) {
        return this.f5789a.c(r10, r11);
    }

    public final void d(Canvas r19, Paint r20, float r21, float r22, float r23, float r24, float r25) {
        Intrinsics.checkNotNullParameter(r19, "canvas");
        Intrinsics.checkNotNullParameter(r20, "paint");
        if (r25 >= 0.0f) goto L5;
        b.c(b.f12973c, "SmoothCornerHelper", "invalid radius: " + r25, null, 4, null);
        float r10 = 0.0f;
    L6:
        e r11 = f(r23, r21, r24, r22);
        float r12 = r11.a();
        float r13 = r11.b();
        float r14 = Math.min(r23 - r21, r24 - r22) / 2;
        d r15 = this.f5789a;
        if (r10 <= r14) goto L9;
        d.e(r15, r19, r20, r12, r13, r21, r22, r23, r24, r10, false, false, false, false, 7680, null);
        return;
    L9:
        r15.f(r19, r20, r21, r22, r23, r24, r10);
        return;
    L5:
        r10 = r25;
        goto L6
    }

    public final void e(Canvas r10, RectF r11, float r12, Paint r13) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        Intrinsics.checkNotNullParameter(r11, "rect");
        Intrinsics.checkNotNullParameter(r13, "paint");
        if (r11.isEmpty() == false) goto L6;
        b.c(b.f12973c, "SmoothCornerHelper", "empty rect: " + r11, null, 4, null);
        return;
    L6:
        d(r10, r13, r11.left, r11.top, r11.right, r11.bottom, r12);
    }

    public final void g(Companion.CurveType r10) {
        Intrinsics.checkNotNullParameter(r10, "curveType");
        h(r10, -1.0f);
    }

    public final void h(Companion.CurveType r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "curveType");
        b.f12973c.a("SmoothCornerHelper", "setCurveType: " + r10);
        int r12 = a.f12701a[r10.ordinal()];
        if (r12 != 1) goto L5;
        d r13 = new s8.a();
    L24:
        this.f5789a = r13;
        return;
    L5:
        if (r12 == 2) goto L18;
        if (r12 != 3) goto L9;
        r13 = new h();
        goto L24
    L9:
        if (r12 != 4) goto L11;
        r13 = new s8.c();
        goto L24
    L11:
        if (r12 != 5) goto L14;
        r13 = new f();
        goto L24
    L14:
        throw new NoWhenBranchMatchedException();
    L18:
        if (r11 > 0) goto L20;
    L22:
        r13 = new g(0.0f, 1, null);
        goto L24
    L20:
        if (r11 > 0.5f) goto L22;
        r13 = new g(r11);
        goto L24
    }
}
