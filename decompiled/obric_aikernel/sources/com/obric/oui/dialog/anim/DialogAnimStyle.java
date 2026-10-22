package com.obric.oui.dialog.anim;

import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.IdRes;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import da.c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import u8.f;

/* JADX INFO: loaded from: classes2.dex */
public final class DialogAnimStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DialogAnimStyle f6478a = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/oui/dialog/anim/DialogAnimStyle$HeightLevel;", "", "", "maxRatio", "F", "getMaxRatio", "()F", "<init>", "(Ljava/lang/String;IF)V", "SMALL", "MEDIUM", "LARGE", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum HeightLevel extends Enum<HeightLevel> {
        private static final /* synthetic */ HeightLevel[] $VALUES = null;
        public static final HeightLevel LARGE = null;
        public static final HeightLevel MEDIUM = null;
        public static final HeightLevel SMALL = null;
        private final float maxRatio;

        static {
            HeightLevel r10 = new HeightLevel("SMALL", 0, 0.4f);
            SMALL = r10;
            HeightLevel r11 = new HeightLevel("MEDIUM", 1, 0.8f);
            MEDIUM = r11;
            HeightLevel r12 = new HeightLevel("LARGE", 2, 1.0f);
            LARGE = r12;
            $VALUES = new HeightLevel[]{r10, r11, r12};
        }

        private HeightLevel(String r10, int r11, float r12) {
            super(r10, r11);
            this.maxRatio = r12;
        }

        public static HeightLevel valueOf(String r10) {
            return (HeightLevel) Enum.valueOf(HeightLevel.class, r10);
        }

        public static HeightLevel[] values() {
            return (HeightLevel[]) $VALUES.clone();
        }

        public final float getMaxRatio() {
            return this.maxRatio;
        }
    }

    static final class a implements i9.b.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f6479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f6480b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f6481c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f6482d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Window f6483e;

        a(float r10, float r11, float r12, float r13, Window r14, boolean r15, int r16) {
            this.f6479a = r10;
            this.f6480b = r11;
            this.f6481c = r12;
            this.f6482d = r13;
            this.f6483e = r14;
        }

        @Override // i9.b.q
        public final void a(i9.b<?> r10, float r11, float r12) {
            DialogAnimStyle.a(DialogAnimStyle.f6478a, this.f6483e, da.b.f8519a.a(r11, this.f6479a, this.f6480b), this.f6481c, this.f6482d);
        }
    }

    static final class b implements i9.b.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f6484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f6485b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Window f6486c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f6487d;

        b(float r10, float r11, Window r12, boolean r13, int r14, float r15) {
            this.f6484a = r10;
            this.f6485b = r11;
            this.f6486c = r12;
            this.f6487d = r15;
        }

        @Override // i9.b.q
        public final void a(i9.b<?> r10, float r11, float r12) {
            DialogAnimStyle.a(DialogAnimStyle.f6478a, this.f6486c, da.b.f8519a.a(r11, this.f6484a, this.f6485b), 0.0f, this.f6487d);
        }
    }

    static {
        f6478a = new DialogAnimStyle();
    }

    private DialogAnimStyle() {
    }

    public static final /* synthetic */ void a(DialogAnimStyle r10, Window r11, float r12, float r13, float r14) {
        r10.j(r11, r12, r13, r14);
    }

    private final HeightLevel c(View r10, int r11) {
        if (r11 <= 0) goto L4;
        float r12 = r10.getHeight() / r11;
        HeightLevel r13 = HeightLevel.SMALL;
        if (r12 < r13.getMaxRatio()) goto L13;
        HeightLevel r14 = HeightLevel.MEDIUM;
        if (r12 >= r14.getMaxRatio()) goto L12;
        return r14;
    L12:
        return HeightLevel.LARGE;
    L13:
        return r13;
    L4:
        return HeightLevel.MEDIUM;
    }

    private final Pair<Float, Float> d(boolean r10, HeightLevel r11, boolean r12) {
        Float r13 = Float.valueOf(1.0f);
        if (r10 == true) goto L7;
        return new Pair(r13, Float.valueOf(480.0f));
    L7:
        if (r12 == false) goto L18;
        int r14 = com.obric.oui.dialog.anim.a.f6488a[r11.ordinal()];
        if (r14 == 1) goto L31;
        if (r14 == 2) goto L30;
        if (r14 != 3) goto L15;
        return new Pair(r13, Float.valueOf(247.0f));
    L15:
        throw new NoWhenBranchMatchedException();
    L30:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(247.0f));
    L31:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(439.0f));
    L18:
        int r15 = com.obric.oui.dialog.anim.a.f6489b[r11.ordinal()];
        if (r15 == 1) goto L28;
        if (r15 == 2) goto L33;
        if (r15 != 3) goto L25;
        return new Pair(r13, Float.valueOf(322.0f));
    L25:
        throw new NoWhenBranchMatchedException();
    L33:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(322.0f));
    L28:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(632.0f));
    }

    public static /* synthetic */ ViewPropertySpringAnimator f(DialogAnimStyle r10, View r11, Window r12, boolean r13, boolean r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r12 = null;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r13 = true;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r14 = true;
    L12:
        return r10.e(r11, r12, r13, r14);
    }

    public static /* synthetic */ ViewPropertySpringAnimator h(DialogAnimStyle r10, View r11, Window r12, boolean r13, float r14, boolean r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        r12 = null;
    L5:
        Window r18 = r12;
        if ((r16 & 2) == 0) goto L8;
        boolean r19 = true;
    L10:
        if ((r16 & 4) == 0) goto L12;
        r14 = 0.6f;
    L12:
        float r20 = r14;
        if ((r16 & 8) == 0) goto L15;
        boolean r21 = true;
    L17:
        return r10.g(r11, r18, r19, r20, r21);
    L15:
        r21 = r15;
        goto L17
    L8:
        r19 = r13;
        goto L10
    }

    private final <T extends View> ViewPropertySpringAnimator<T> i(T r10, @IdRes int r11) {
        c r12 = c.f8520a;
        Object r13 = r10.getTag(r11);
        if (r13 != null) goto L6;
    L4:
        r13 = null;
    L7:
        ViewPropertySpringAnimator<T> r14 = (ViewPropertySpringAnimator) r13;
        if (r14 != null) goto L11;
        ViewPropertySpringAnimator<T> r15 = new ViewPropertySpringAnimator(r10);
        r10.setTag(r11, r15);
        return r15;
    L11:
        return r14;
    L6:
        if ((r13 instanceof ViewPropertySpringAnimator) == false) goto L4;
        goto L4
    }

    private final void j(Window r10, float r11, float r12, float r13) {
        r10.setDimAmount(r12 + ((r13 - r12) * RangesKt.coerceIn(r11, 0.0f, 1.0f)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w("DialogAnimStyle", "updateWindowDimWithAnim: " + e.getMessage());
    }

    public final void b(View r10) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        int r12 = MathKt.roundToInt(TypedValue.applyDimension(1, 10, r11.getDisplayMetrics()));
        ViewGroup.LayoutParams r13 = r10.getLayoutParams();
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
        if (r14.topMargin >= r12) goto L7;
        r14.topMargin = r12;
    L7:
        Unit r15 = Unit.INSTANCE;
        r10.setLayoutParams(r13);
    }

    public final ViewPropertySpringAnimator<View> e(View r12, Window r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r12, "$this$dialogBottomHide");
        Resources r10 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r10, "Resources.getSystem()");
        int r11 = r10.getDisplayMetrics().heightPixels;
        int r16 = r12.getHeight();
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        int r18 = r16 + MathKt.roundToInt(TypedValue.applyDimension(1, 32, r17.getDisplayMetrics()));
        Pair<Float, Float> r19 = d(r15, c(r12, r11), false);
        final float r20 = r19.component1().floatValue();
        final float r110 = r19.component2().floatValue();
        float r21 = r18;
        ViewPropertySpringAnimator<View> r111 = i(r12, f.o_dialog_anim_out).q(r21, new DialogAnimStyle$dialogBottomHide$spring$1(r20, r110));
        if (r13 == null) goto L10;
        if (r14 == false) goto L10;
        r13.addFlags(2);     // Catch: Exception -> L8
        r111.o(new a(0.0f, r21, r13.getAttributes().dimAmount, 0.0f, r13, r14, r18));     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Log.w("DialogAnimStyle", "dialogBottomHide, can't show dim anim: " + e.getMessage());
    L10:
        com.obric.oui.animation.style.a.b(r12);
        return r111;
    }

    public final ViewPropertySpringAnimator<View> g(View r10, Window r11, boolean r12, float r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "$this$dialogBottomShow");
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        int r16 = r15.getDisplayMetrics().heightPixels;
        int r17 = r10.getHeight();
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        final int r19 = r17 + MathKt.roundToInt(TypedValue.applyDimension(1, 32, r18.getDisplayMetrics()));
        r10.setAlpha(1.0f);
        Pair<Float, Float> r20 = d(r14, c(r10, r16), true);
        final float r21 = r20.component1().floatValue();
        final float r22 = r20.component2().floatValue();
        ViewPropertySpringAnimator<View> r23 = i(r10, f.o_dialog_anim_in).q(0.0f, new DialogAnimStyle$dialogBottomShow$1(r21, r22, r19));
        if (r11 == null) goto L10;
        if (r12 == false) goto L10;
        r11.addFlags(2);     // Catch: Exception -> L8
        r23.o(new b(r19, 0.0f, r11, r12, r19, r13));     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Log.w("DialogAnimStyle", "dialogBottomShow, can't show dim anim: " + e.getMessage());
    L10:
        return r23;
    }
}
