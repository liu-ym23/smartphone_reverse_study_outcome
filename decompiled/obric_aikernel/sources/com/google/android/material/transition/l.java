package com.google.android.material.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.PathParser;
import androidx.transition.PathMotion;
import androidx.transition.PatternPathMotion;
import androidx.transition.Transition;

/* JADX INFO: loaded from: classes2.dex */
class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final RectF f4184a = null;

    class a implements com.google.android.material.shape.l.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RectF f4185a;

        a(RectF r10) {
            this.f4185a = r10;
        }

        @Override // com.google.android.material.shape.l.c
        @NonNull
        public com.google.android.material.shape.c a(@NonNull com.google.android.material.shape.c r10) {
            if ((r10 instanceof com.google.android.material.shape.j) == false) goto L6;
            return r10;
        L6:
            return new com.google.android.material.shape.j(r10.a(this.f4185a) / this.f4185a.height());
        }
    }

    class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RectF f4186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ RectF f4187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f4188c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f4189d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f4190e;

        b(RectF r10, RectF r11, float r12, float r13, float r14) {
            this.f4186a = r10;
            this.f4187b = r11;
            this.f4188c = r12;
            this.f4189d = r13;
            this.f4190e = r14;
        }

        @Override // com.google.android.material.transition.l.d
        @NonNull
        public com.google.android.material.shape.c a(@NonNull com.google.android.material.shape.c r10, @NonNull com.google.android.material.shape.c r11) {
            return new com.google.android.material.shape.a(l.k(r10.a(this.f4186a), r11.a(this.f4187b), this.f4188c, this.f4189d, this.f4190e));
        }
    }

    interface c {
        void a(Canvas r10);
    }

    interface d {
        @NonNull
        com.google.android.material.shape.c a(@NonNull com.google.android.material.shape.c r10, @NonNull com.google.android.material.shape.c r11);
    }

    static {
        f4184a = new RectF();
    }

    static float a(@NonNull RectF r10) {
        return r10.width() * r10.height();
    }

    static com.google.android.material.shape.l b(com.google.android.material.shape.l r10, RectF r11) {
        return r10.y(new a(r11));
    }

    static Shader c(@ColorInt int r10) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, r10, r10, Shader.TileMode.CLAMP);
    }

    @NonNull
    static <T> T d(@Nullable T r10, @NonNull T r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        return r11;
    }

    static View e(View r10, @IdRes int r11) {
        String r12 = r10.getResources().getResourceName(r11);
    L3:
        if (r10 == null) goto L11;
        if (r10.getId() == r11) goto L6;
        Object r13 = r10.getParent();
        if ((r13 instanceof View) == false) goto L11;
        r10 = (View) r13;
        goto L3
    L6:
        return r10;
    L11:
        throw new IllegalArgumentException(r12 + " is not a valid ancestor");
    }

    static View f(View r10, @IdRes int r11) {
        View r12 = r10.findViewById(r11);
        if (r12 == null) goto L6;
        return r12;
    L6:
        return e(r10, r11);
    }

    static RectF g(View r10) {
        int[] r11 = new int[2];
        r10.getLocationOnScreen(r11);
        int r12 = r11[0];
        int r13 = r11[1];
        return new RectF(r12, r13, r10.getWidth() + r12, r10.getHeight() + r13);
    }

    static RectF h(View r10) {
        return new RectF(r10.getLeft(), r10.getTop(), r10.getRight(), r10.getBottom());
    }

    private static boolean i(com.google.android.material.shape.l r10, RectF r11) {
        if (r10.r().a(r11) == 0.0f) goto L5;
    L12:
        return true;
    L5:
        if (r10.t().a(r11) != 0.0f) goto L12;
        if (r10.l().a(r11) != 0.0f) goto L12;
        if (r10.j().a(r11) != 0.0f) goto L12;
        return false;
    }

    static float j(float r10, float r11, float r12) {
        return r10 + (r12 * (r11 - r10));
    }

    static float k(float r10, float r11, @FloatRange(from = 0.0d, to = 1.0d) float r12, @FloatRange(from = 0.0d, to = 1.0d) float r13, @FloatRange(from = 0.0d, to = 1.0d) float r14) {
        return l(r10, r11, r12, r13, r14, false);
    }

    static float l(float r10, float r11, @FloatRange(from = 0.0d, to = 1.0d) float r12, @FloatRange(from = 0.0d, to = 1.0d) float r13, @FloatRange(from = 0.0d) float r14, boolean r15) {
        if (r15 == false) goto L10;
        if (r14 < 0.0f) goto L8;
        if (r14 <= 1.0f) goto L10;
    L8:
        return j(r10, r11, r14);
    L10:
        if (r14 >= r12) goto L13;
        return r10;
    L13:
        if (r14 <= r13) goto L16;
        return r11;
    L16:
        return j(r10, r11, (r14 - r12) / (r13 - r12));
    }

    static int m(int r10, int r11, @FloatRange(from = 0.0d, to = 1.0d) float r12, @FloatRange(from = 0.0d, to = 1.0d) float r13, @FloatRange(from = 0.0d, to = 1.0d) float r14) {
        if (r14 >= r12) goto L6;
        return r10;
    L6:
        if (r14 <= r13) goto L9;
        return r11;
    L9:
        return (int) j(r10, r11, (r14 - r12) / (r13 - r12));
    }

    static com.google.android.material.shape.l n(com.google.android.material.shape.l r10, com.google.android.material.shape.l r11, RectF r12, RectF r13, @FloatRange(from = 0.0d, to = 1.0d) float r14, @FloatRange(from = 0.0d, to = 1.0d) float r15, @FloatRange(from = 0.0d, to = 1.0d) float r16) {
        if (r16 >= r14) goto L6;
        return r10;
    L6:
        if (r16 <= r15) goto L9;
        return r11;
    L9:
        return u(r10, r11, r12, new b(r12, r13, r14, r15, r16));
    }

    static boolean o(Transition r10, Context r11, @AttrRes int r12) {
        if (r12 != 0) goto L4;
        return false;
    L4:
        if (r10.getDuration() != (-1)) goto L11;
        int r13 = z5.a.d(r11, r12, -1);
        if (r13 == (-1)) goto L12;
        r10.setDuration(r13);
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    static boolean p(Transition r10, Context r11, @AttrRes int r12, TimeInterpolator r13) {
        if (r12 != 0) goto L4;
        return false;
    L4:
        if (r10.getInterpolator() != null) goto L9;
        r10.setInterpolator(z5.a.e(r11, r12, r13));
        return true;
    L9:
        return false;
    }

    static boolean q(Transition r10, Context r11, @AttrRes int r12) {
        if (r12 == 0) goto L7;
        PathMotion r13 = r(r11, r12);
        if (r13 == null) goto L9;
        r10.setPathMotion(r13);
        return true;
    L9:
        return false;
    L7:
        return false;
    }

    @Nullable
    static PathMotion r(Context r10, @AttrRes int r11) {
        TypedValue r12 = new TypedValue();
        if (r10.getTheme().resolveAttribute(r11, r12, true) == false) goto L20;
        int r13 = r12.type;
        if (r13 != 16) goto L15;
        int r14 = r12.data;
        if (r14 != 0) goto L9;
        return null;
    L9:
        if (r14 != 1) goto L13;
        return new MaterialArcMotion();
    L13:
        throw new IllegalArgumentException("Invalid motion path type: " + r14);
    L15:
        if (r13 != 3) goto L19;
        return new PatternPathMotion(PathParser.createPathFromPathData(String.valueOf(r12.string)));
    L19:
        throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
    L20:
        return null;
    }

    private static int s(Canvas r10, Rect r11, int r12) {
        RectF r13 = f4184a;
        r13.set(r11);
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return r10.saveLayerAlpha(r13, r12);
    L7:
        return r10.saveLayerAlpha(r13.left, r13.top, r13.right, r13.bottom, r12, 31);
    }

    static void t(Canvas r10, Rect r11, float r12, float r13, float r14, int r15, c r16) {
        if (r15 > 0) goto L4;
        return;
    L4:
        int r17 = r10.save();
        r10.translate(r12, r13);
        r10.scale(r14, r14);
        if (r15 >= 255) goto L7;
        s(r10, r11, r15);
    L7:
        r16.a(r10);
        r10.restoreToCount(r17);
    }

    static com.google.android.material.shape.l u(com.google.android.material.shape.l r10, com.google.android.material.shape.l r11, RectF r12, d r13) {
        if (i(r10, r12) == false) goto L5;
        com.google.android.material.shape.l r14 = r10;
    L7:
        return r14.v().F(r13.a(r10.r(), r11.r())).J(r13.a(r10.t(), r11.t())).w(r13.a(r10.j(), r11.j())).A(r13.a(r10.l(), r11.l())).m();
    L5:
        r14 = r11;
        goto L7
    }
}
