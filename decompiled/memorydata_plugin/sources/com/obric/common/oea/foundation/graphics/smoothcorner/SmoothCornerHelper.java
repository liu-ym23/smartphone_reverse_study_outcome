package com.obric.common.oea.foundation.graphics.smoothcorner;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.loc.o;
import com.obric.common.oea.foundation.a.b;
import com.obric.common.oea.foundation.a.c;
import com.obric.common.oea.foundation.graphics.smoothcorner.a.d;
import com.obric.common.oea.foundation.graphics.smoothcorner.a.e;
import com.obric.common.oea.foundation.graphics.smoothcorner.a.f;
import com.obric.common.oea.foundation.graphics.smoothcorner.a.g;
import com.obric.common.oea.foundation.graphics.smoothcorner.a.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0004J.\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004J\u0016\u0010\"\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J>\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004J&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)J\u0018\u0010*\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J(\u0010+\u001a\u00020,2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\u000e\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020/J\u0016\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0004J\u0016\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerHelper;", "", "()V", "rectHeight", "", "getRectHeight", "()F", "setRectHeight", "(F)V", "rectWidth", "getRectWidth", "setRectWidth", "roundBl", "", "roundBr", "roundRadius", "getRoundRadius", "setRoundRadius", "roundTl", "roundTr", "sdkInit", "Lcom/obric/common/oea/foundation/util/SdkInit;", "smoothCornerImpl", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/ISmoothCornerImpl;", "buildPath", "Landroid/graphics/Path;", "rect", "Landroid/graphics/Rect;", "radius", "Landroid/graphics/RectF;", "left", "top", "right", "bottom", "canDraw", "minDimension", "drawRoundRect", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawRoundRectInternal", "getPosXY", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/Point;", "setCurveType", "curveType", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerHelper$Companion$CurveType;", "safeRadiusFactor", "updateRectSize", "w", o.g, "Companion", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class SmoothCornerHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f7755a = null;
    private static final List<Integer> k = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f7756b;
    private d c;
    private float d;
    private float e;
    private float f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0001¢\u0006\u0002\b\rJ\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0007J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0007J\u0014\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerHelper$Companion;", "", "()V", "TAG", "", "validSmoothCornerRadius", "", "", "getValidSmoothCornerRadius", "()Ljava/util/List;", "findClosestValue", TypedValues.AttributesType.S_TARGET, "arr", "findClosestValue$foundation_standardRelease", "getDrawableRes", "cornerRadius", "getHorizontalCapsuleDrawableRes", "fillWithColor", "", "Landroid/graphics/drawable/Drawable;", TypedValues.Custom.S_COLOR, "CurveType", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerHelper$Companion$CurveType;", "", "(Ljava/lang/String;I)V", "QUADRATIC", "SKETCH", "FIGMA", "BASIC", "QUADRATIC_CAPSULE", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum CurveType extends Enum<CurveType> {
            private static final /* synthetic */ CurveType[] $VALUES = null;
            public static final CurveType BASIC = null;
            public static final CurveType FIGMA = null;
            public static final CurveType QUADRATIC = null;
            public static final CurveType QUADRATIC_CAPSULE = null;
            public static final CurveType SKETCH = null;

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
                $VALUES = new CurveType[]{r1, r2, r3, r4, r5};
            }

            private CurveType(String r1, int r2) {
                super(r1, r2);
            }

            public static CurveType valueOf(String r2) {
                return (CurveType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CurveType.class, r2), CurveType.class, "com.obric.memorydata.plugin");
            }

            public static CurveType[] values() {
                return (CurveType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CurveType[].class, "com.obric.memorydata.plugin");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f7755a = new Companion(null);
        k = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(RangesKt.step((IntProgression) ZeusTransformUtils.preCheckCast(new IntRange(8, 48), IntProgression.class, "com.obric.memorydata.plugin"), 2), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public SmoothCornerHelper() {
        this.f7756b = new c();
        this.c = (d) ZeusTransformUtils.preCheckCast(new g(0.0f, 1, null), d.class, "com.obric.memorydata.plugin");
        this.d = -1.0f;
        this.e = -1.0f;
        this.f = -1.0f;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = true;
    }

    private final e a(float r2, float r3, float r4, float r5) {
        float r1 = r2 - r3;
        float r0 = r4 - r5;
        return new e(((r3 + r2) / 2.0f) - (r1 / 2.0f), ((r5 + r4) / 2.0f) - (r0 / 2.0f));
    }

    public final Path a(float r7, float r8, float r9, float r10, float r11) {
        return this.c.a(r7, r8, r9, r10, r11);
    }

    public final Path a(Rect r8, float r9) {
        Intrinsics.checkNotNullParameter(r8, "rect");
        return a(r8.left, r8.top, r8.right, r8.bottom, r9);
    }

    public final void a(Canvas r19, Paint r20, float r21, float r22, float r23, float r24, float r25) {
        Intrinsics.checkNotNullParameter(r19, "canvas");
        Intrinsics.checkNotNullParameter(r20, "paint");
        if (r25 >= 0.0f) goto L5;
        b.a(b.f7661a, "SmoothCornerHelper", "invalid radius: " + r25, null, 4, null);
        float r9 = 0.0f;
    L6:
        e r1 = a(r23, r21, r24, r22);
        float r10 = r1.c();
        float r11 = r1.d();
        float r2 = Math.min(r23 - r21, r24 - r22) / 2;
        d r0 = this.c;
        if (r9 <= r2) goto L9;
        d.a(r0, r19, r20, r10, r11, r21, r22, r23, r24, r9, false, false, false, false, 7680, null);
        return;
    L9:
        r0.a(r19, r20, r21, r22, r23, r24, r9);
        return;
    L5:
        r9 = r25;
        goto L6
    }

    public final void a(Canvas r11, RectF r12, float r13, Paint r14) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        Intrinsics.checkNotNullParameter(r12, "rect");
        Intrinsics.checkNotNullParameter(r14, "paint");
        if (r12.isEmpty() == false) goto L6;
        b.a(b.f7661a, "SmoothCornerHelper", "empty rect: " + r12, null, 4, null);
        return;
    L6:
        a(r11, r14, r12.left, r12.top, r12.right, r12.bottom, r13);
    }

    public final void a(Companion.CurveType r2) {
        Intrinsics.checkNotNullParameter(r2, "curveType");
        a(r2, -1.0f);
    }

    public final void a(Companion.CurveType r4, float r5) {
        Intrinsics.checkNotNullParameter(r4, "curveType");
        b.f7661a.b("SmoothCornerHelper", "setCurveType: " + r4);
        int r6 = a.f7757a[r4.ordinal()];
        if (r6 != 1) goto L5;
        Object r7 = new com.obric.common.oea.foundation.graphics.smoothcorner.a.a();
    L24:
        this.c = (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.memorydata.plugin");
        return;
    L5:
        if (r6 == 2) goto L18;
        if (r6 != 3) goto L9;
        r7 = new h();
        goto L24
    L9:
        if (r6 != 4) goto L11;
        r7 = new com.obric.common.oea.foundation.graphics.smoothcorner.a.c();
        goto L24
    L11:
        if (r6 != 5) goto L14;
        r7 = new f();
        goto L24
    L14:
        throw new NoWhenBranchMatchedException();
    L18:
        if (r5 > 0) goto L20;
    L22:
        r7 = new g(0.0f, 1, null);
        goto L24
    L20:
        if (r5 > 0.5f) goto L22;
        r7 = new g(r5);
        goto L24
    }

    public final boolean a(float r1, float r2) {
        return this.c.a(r1, r2);
    }
}
