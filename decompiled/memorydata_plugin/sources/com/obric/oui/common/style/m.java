package com.obric.oui.common.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import com.obric.common.oea.foundation.graphics.smoothcorner.SmoothCornerHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J.\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0014H\u0002J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0012H\u0002J0\u0010 \u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014H\u0002J(\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0007J@\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0007J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0012H\u0002J(\u0010'\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014H\u0002J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/oui/common/style/SmoothCornerH;", "", "()V", "TAG", "", "isDeviceSupport", "", "roundCornerHelper", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerHelper;", "smoothCornerHelper0", "smoothCornerHelper1", "smoothCornerHelper2", "useSystemSmoothCorner", "addRoundRect", "", "path", "Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "radius", "", "radii", "", "dir", "Landroid/graphics/Path$Direction;", "buildPath", "left", "top", "right", "bottom", "decideImpl", "minDimension", "decideValidCornerRadius", "rectF", "drawRoundRect", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "getMinDimension", "setUseSystemSmoothCorner", "use", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f13498a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f13499b = false;
    private static final SmoothCornerHelper c = null;
    private static final SmoothCornerHelper d = null;
    private static final SmoothCornerHelper e = null;
    private static final SmoothCornerHelper f = null;
    private static boolean g;

    static {
        f13498a = new m();
        c = new SmoothCornerHelper();
        SmoothCornerHelper r0 = new SmoothCornerHelper();
        r0.a(SmoothCornerHelper.Companion.CurveType.BASIC);
        d = r0;
        SmoothCornerHelper r1 = new SmoothCornerHelper();
        r1.a(SmoothCornerHelper.Companion.CurveType.SKETCH);
        e = r1;
        SmoothCornerHelper r2 = new SmoothCornerHelper();
        r2.a(SmoothCornerHelper.Companion.CurveType.QUADRATIC_CAPSULE);
        f = r2;
        f13499b = !TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast("HUAWEI", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(Build.BRAND, CharSequence.class, "com.obric.memorydata.plugin"));
        g = true;
    }

    private m() {
    }

    private final float a(float r1, float r2, float r3, float r4) {
        return Math.min(Math.abs(r3 - r1), Math.abs(r4 - r2));
    }

    private final float a(float r3, RectF r4) {
        if (r4.isEmpty() == false) goto L7;
        com.obric.oui.c.a.b.e("SmoothCornerH", "decideValidCornerRadius: rectF is empty");
        return 0.0f;
    L7:
        return RangesKt.coerceAtLeast(Math.min(r3, a(r4) / 2.0f), 0.0f);
    }

    private final float a(RectF r1) {
        return Math.min(r1.width(), r1.height());
    }

    private final SmoothCornerHelper a(float r2, float r3) {
        if (g == true) goto L5;
        SmoothCornerHelper r1 = c;
        if (r1.a(r2, r3) == true) goto L14;
        SmoothCornerHelper r4 = e;
        if (r4.a(r2, r3) == false) goto L13;
        return r4;
    L13:
        return f;
    L14:
        return r1;
    L5:
        return d;
    }

    @JvmStatic
    public static final void a(Canvas r9, float r10, float r11, float r12, float r13, float r14, Paint r15) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        Intrinsics.checkNotNullParameter(r15, "paint");
        m r0 = f13498a;
        float r8 = r0.b(r14, r10, r11, r12, r13);
        r0.a(r8, r0.a(r10, r11, r12, r13)).a(r9, r15, r10, r11, r12, r13, r8);
    }

    @JvmStatic
    public static final void a(Canvas r2, RectF r3, float r4, Paint r5) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        Intrinsics.checkNotNullParameter(r3, "rectF");
        Intrinsics.checkNotNullParameter(r5, "paint");
        m r0 = f13498a;
        float r6 = r0.a(r4, r3);
        r0.a(r6, r0.a(r3)).a(r2, r3, r6, r5);
    }

    private final float b(float r1, float r2, float r3, float r4, float r5) {
        return RangesKt.coerceAtLeast(Math.min(r1, a(r2, r3, r4, r5) / 2.0f), 0.0f);
    }

    public final Path a(float r8, float r9, float r10, float r11, float r12) {
        float r6 = b(r12, r8, r9, r10, r11);
        return a(r6, a(r8, r9, r10, r11)).a(r8, r9, r10, r11, r6);
    }

    public final Path a(RectF r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "rect");
        float r4 = a(r3, r2);
        SmoothCornerHelper r1 = a(r4, a(r2));
        Rect r0 = new Rect();
        r2.roundOut(r0);
        return r1.a(r0, r4);
    }

    public final void a(Path r2, RectF r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "rect");
        r2.addPath(a(r3, r4));
    }

    public final void a(Path r2, RectF r3, float[] r4, Path.Direction r5) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "rect");
        Intrinsics.checkNotNullParameter(r4, "radii");
        Intrinsics.checkNotNullParameter(r5, "dir");
        if (n.a(r4) == false) goto L5;
        r2.addPath(a(r3, r4[0]));
        return;
    L5:
        r2.addRoundRect(r3, r4, r5);
    }
}
