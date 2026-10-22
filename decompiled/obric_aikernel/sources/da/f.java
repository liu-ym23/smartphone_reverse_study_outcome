package da;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.ColorInt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import o9.p;
import o9.q;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f8522a = null;

    static {
        f8522a = new f();
    }

    private f() {
    }

    @JvmStatic
    @ColorInt
    public static final int a(@ColorInt int r10, float r11) {
        if (r11 != 1.0f) goto L5;
        return r10;
    L5:
        float r12 = RangesKt.coerceIn(r11, 0.0f, 1.0f);
        return Color.argb((int) (Color.alpha(r10) * r12), Color.red(r10), Color.green(r10), Color.blue(r10));
    }

    private final void e(TypedArray r10, p r11, int r12, int r13, int r14, int r15, int r16) {
        if (r11 != null) goto L4;
        return;
    L4:
        r11.h(r10.getColor(r12, Color.parseColor("#00000000")));
        r11.k(r10.getDimension(r13, 0.0f));
        r11.i(r10.getDimension(r14, 0.0f));
        r11.j(r10.getDimension(r15, 0.0f));
        r11.l(r10.getDimension(r16, 0.0f));
    }

    @JvmStatic
    public static final void g(View r10, Function1<? super View, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "visitor");
        if (r10 != null) goto L6;
        return;
    L6:
        if ((r10 instanceof ViewGroup) == false) goto L13;
        int r12 = 0;
        ViewGroup r13 = (ViewGroup) r10;
        int r14 = r13.getChildCount();
    L8:
        if (r12 >= r14) goto L17;
        View r15 = r13.getChildAt(r12);
        if (r15 == null) goto L12;
        r11.invoke(r15);
    L12:
        r12 = r12 + 1;
        goto L8
    L17:
        return;
    }

    public final void b(Context r10, int r11, p r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "baseShadow");
        TypedArray r13 = r10.obtainStyledAttributes(r11, l.OUILayout);
        Intrinsics.checkNotNullExpressionValue(r13, "context.obtainStyledAttr…s, R.styleable.OUILayout)");
        e(r13, r12, l.OUILayout_oui_firstShadowColor, l.OUILayout_oui_firstShadowBlur, l.OUILayout_oui_firstOffsetX, l.OUILayout_oui_firstOffsetY, l.OUILayout_oui_firstShadowSpread);
        r13.recycle();
    }

    public final void c(Canvas r10, p r11, RectF r12, float r13) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        Intrinsics.checkNotNullParameter(r11, "shadow");
        Intrinsics.checkNotNullParameter(r12, "rect");
        float r14 = 0;
        if (r11.b() <= r14) goto L5;
        r13 = r11.b();
    L5:
        Path r15 = new Path();
        q.f11614e.a(r15, r12, r13);
        int r16 = r10.save();
        RectF r17 = new RectF(r12);
        r17.offset(r11.c(), r11.d());
        r17.inset(-r11.g(), -r11.g());
        r10.clipOutPath(r15);
        r11.e().setColor(r11.a());
        if (r11.f() <= r14) goto L8;
        r11.e().setMaskFilter(new BlurMaskFilter(r11.f(), BlurMaskFilter.Blur.NORMAL));
    L8:
        q.i(r10, r17, r13, r11.e());
        r10.restoreToCount(r16);
    }

    public final ViewGroup d(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, "activity");
        Window r11 = r10.getWindow();     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r11, "activity.window");     // Catch: Exception -> L5
        return (ViewGroup) r11.getDecorView().findViewById(R.id.content);
    L5:
        e = move-exception;
        ea.b.c("ViewUtil", "getActivityContentView, error", e);
        return null;
    }

    public final boolean f(View r10, MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$isEventOutsideView");
        Intrinsics.checkNotNullParameter(r11, "ev");
        float r12 = r11.getRawX();
        float r13 = r11.getRawY();
        int[] r14 = new int[2];
        r10.getLocationOnScreen(r14);
        if (r12 < r14[0]) goto L11;
        if (r13 < r14[1]) goto L11;
        if (r12 > (r14[0] + r10.getWidth())) goto L11;
        if (r13 > (r14[1] + r10.getHeight())) goto L11;
        return false;
    L11:
        return true;
    }
}
