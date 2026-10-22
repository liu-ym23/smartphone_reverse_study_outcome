package o9;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import com.obric.common.oea.foundation.graphics.smoothcorner.SmoothCornerHelper;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SmoothCornerHelper f11610a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SmoothCornerHelper f11611b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SmoothCornerHelper f11612c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public static final boolean f11613d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final q f11614e = null;

    static {
        f11614e = new q();
        f11610a = new SmoothCornerHelper();
        SmoothCornerHelper r10 = new SmoothCornerHelper();
        r10.g(SmoothCornerHelper.Companion.CurveType.SKETCH);
        f11611b = r10;
        SmoothCornerHelper r11 = new SmoothCornerHelper();
        r11.g(SmoothCornerHelper.Companion.CurveType.QUADRATIC_CAPSULE);
        f11612c = r11;
        f11613d = !TextUtils.equals("HUAWEI", Build.BRAND);
    }

    private q() {
    }

    private final SmoothCornerHelper e(float r10, float r11) {
        SmoothCornerHelper r12 = f11610a;
        if (r12.c(r10, r11) == true) goto L10;
        SmoothCornerHelper r13 = f11611b;
        if (r13.c(r10, r11) == false) goto L9;
        return r13;
    L9:
        return f11612c;
    L10:
        return r12;
    }

    private final float f(float r10, float r11, float r12, float r13, float r14) {
        return RangesKt.coerceAtLeast(Math.min(r10, j(r11, r12, r13, r14) / 2.0f), 0.0f);
    }

    private final float g(float r10, RectF r11) {
        if (r11.isEmpty() == false) goto L7;
        ea.b.b("SmoothCornerH", "decideValidCornerRadius: rectF is empty");
        return 0.0f;
    L7:
        return RangesKt.coerceAtLeast(Math.min(r10, k(r11) / 2.0f), 0.0f);
    }

    @JvmStatic
    public static final void h(Canvas r10, float r11, float r12, float r13, float r14, float r15, Paint r16) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        Intrinsics.checkNotNullParameter(r16, "paint");
        q r17 = f11614e;
        float r18 = r17.f(r15, r11, r12, r13, r14);
        r17.e(r18, r17.j(r11, r12, r13, r14)).d(r10, r16, r11, r12, r13, r14, r18);
    }

    @JvmStatic
    public static final void i(Canvas r10, RectF r11, float r12, Paint r13) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        Intrinsics.checkNotNullParameter(r11, "rectF");
        Intrinsics.checkNotNullParameter(r13, "paint");
        q r14 = f11614e;
        float r15 = r14.g(r12, r11);
        r14.e(r15, r14.k(r11)).e(r10, r11, r15, r13);
    }

    private final float j(float r10, float r11, float r12, float r13) {
        return Math.min(Math.abs(r12 - r10), Math.abs(r13 - r11));
    }

    private final float k(RectF r10) {
        return Math.min(r10.width(), r10.height());
    }

    public final void a(Path r10, RectF r11, float r12) {
        Intrinsics.checkNotNullParameter(r10, "path");
        Intrinsics.checkNotNullParameter(r11, "rect");
        r10.addPath(d(r11, r12));
    }

    public final void b(Path r10, RectF r11, float[] r12, Path.Direction r13) {
        Intrinsics.checkNotNullParameter(r10, "path");
        Intrinsics.checkNotNullParameter(r11, "rect");
        Intrinsics.checkNotNullParameter(r12, "radii");
        Intrinsics.checkNotNullParameter(r13, "dir");
        if (r.a(r12) == false) goto L5;
        r10.addPath(d(r11, r12[0]));
        return;
    L5:
        r10.addRoundRect(r11, r12, r13);
    }

    public final Path c(float r10, float r11, float r12, float r13, float r14) {
        float r15 = f(r14, r10, r11, r12, r13);
        return e(r15, j(r10, r11, r12, r13)).a(r10, r11, r12, r13, r15);
    }

    public final Path d(RectF r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "rect");
        float r12 = g(r11, r10);
        SmoothCornerHelper r13 = e(r12, k(r10));
        Rect r14 = new Rect();
        r10.roundOut(r14);
        return r13.b(r14, r12);
    }
}
