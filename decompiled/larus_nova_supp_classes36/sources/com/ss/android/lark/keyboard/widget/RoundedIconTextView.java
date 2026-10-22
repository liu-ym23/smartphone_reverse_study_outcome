package com.ss.android.lark.keyboard.widget;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.ImageViewCompat;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b!\u0018\u0000 o2\u00020\u0001:\u0001oB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010C\u001a\u00020DH\u0002J\u001a\u0010E\u001a\u00020D2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010F\u001a\u00020DH\u0002J\u0010\u0010G\u001a\u00020D2\u0006\u0010H\u001a\u00020IH\u0014J\u0006\u0010J\u001a\u00020\u001aJ\u0006\u0010K\u001a\u00020\u001cJ\u000e\u0010L\u001a\u00020D2\u0006\u0010M\u001a\u00020\u0007J\u0016\u0010L\u001a\u00020D2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020OJ\b\u0010Q\u001a\u00020DH\u0002J\u000e\u0010R\u001a\u00020D2\u0006\u0010S\u001a\u00020OJ\u000e\u0010T\u001a\u00020D2\u0006\u0010U\u001a\u00020!J\u000e\u0010V\u001a\u00020D2\u0006\u0010W\u001a\u00020!J\u0016\u0010V\u001a\u00020D2\u0006\u0010W\u001a\u00020!2\u0006\u0010X\u001a\u00020!J\u0006\u0010 \u001a\u00020!J&\u0010Y\u001a\u00020D2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u0007J\u000e\u0010\\\u001a\u00020D2\u0006\u0010]\u001a\u00020!J\u000e\u0010^\u001a\u00020D2\u0006\u0010_\u001a\u00020\u0007J\u000e\u0010`\u001a\u00020D2\u0006\u0010_\u001a\u00020\u0007J\u000e\u0010a\u001a\u00020D2\u0006\u0010_\u001a\u00020\u0007J\u000e\u0010b\u001a\u00020D2\u0006\u0010_\u001a\u00020\u0007J\u000e\u0010c\u001a\u00020D2\u0006\u0010_\u001a\u00020\u0007J\u000e\u0010d\u001a\u00020D2\u0006\u0010_\u001a\u00020\u0007J\u000e\u0010e\u001a\u00020D2\u0006\u0010f\u001a\u00020!J\u0012\u0010g\u001a\u00020D2\b\b\u0002\u0010h\u001a\u00020!H\u0002J\u0010\u0010i\u001a\u00020D2\u0006\u0010j\u001a\u00020\u000eH\u0002J\u0010\u0010k\u001a\u00020D2\u0006\u0010l\u001a\u00020\u000eH\u0002J\u0010\u0010m\u001a\u00020\u000e2\u0006\u0010n\u001a\u00020\u000eH\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u0012\u0010)\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u0012\u0010*\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u0012\u0010+\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00107\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b8\u00109R\u001b\u0010<\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010;\u001a\u0004\b=\u00109R\u000e\u0010?\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010@\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010;\u001a\u0004\bA\u00109¨\u0006p"}, d2 = {"Lcom/ss/android/lark/keyboard/widget/RoundedIconTextView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checkedCloseTintColor", "borderColor", "backgroundColor", "borderWidth", "", "cornerRadius", "contentPaddingLeft", "contentPaddingTop", "contentPaddingRight", "contentPaddingBottom", "backgroundPaint", "Landroid/graphics/Paint;", "borderPaint", "rect", "Landroid/graphics/RectF;", "iconView", "Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "closeView", "originTypeface", "Landroid/graphics/Typeface;", "isChecked", "", "uncheckedBackgroundColor", "uncheckedBorderColor", "uncheckedTextColor", "Ljava/lang/Integer;", "uncheckedIconTint", "Landroid/content/res/ColorStateList;", "checkedBackgroundColor", "checkedBorderColor", "checkedTextColor", "checkedIconTintColor", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "premultipliedArgbEvaluator", "Landroid/animation/TypeEvaluator;", "bgAnimator", "Landroid/animation/ValueAnimator;", "borderAnimator", "textAnimator", "tintAnimator", "closeAnimator", "closeIconProgress", "closeIconSizePx", "getCloseIconSizePx", "()I", "closeIconSizePx$delegate", "Lkotlin/Lazy;", "closeIconSpacingPx", "getCloseIconSpacingPx", "closeIconSpacingPx$delegate", "iconSize", "textStartMarginWithIconPx", "getTextStartMarginWithIconPx", "textStartMarginWithIconPx$delegate", "initContentView", "", "parseAttributes", "initPaints", "onDraw", "canvas", "Landroid/graphics/Canvas;", "getIconView", "getTextView", "setIcon", "resourceId", "resKey", "", "entityId", "updateTextStartMargin", "setText", "text", "setTextBold", "bold", "setChecked", "checked", "animate", "setCheckedStyle", "textColor", "iconTintColor", "setInputTopActionCheckedStyle", "isEnterpriseAccount", "setCheckedBackgroundColor", "color", "setCheckedBorderColor", "setCheckedTextColor", "setCheckedIconTintColor", "setBorderColor", "setCustomBackgroundColor", "setBoarderVisible", "isVisible", "applyCheckedStateIfNeed", "force", "animateCloseIconProgress", "target", "applyCloseIconProgress", "progress", "dpToPx", "dp", "Companion", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class RoundedIconTextView extends FrameLayout {
    public static final PathInterpolator F = null;
    public static final LinearInterpolator G = null;
    public ValueAnimator A;
    public float B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public int a;
    public int b;
    public int c;
    public float d;
    public final float e;
    public final Paint f;
    public final Paint g;
    public final RectF h;
    public ImageView i;
    public TextView j;
    public ImageView k;
    public boolean l;
    public int m;
    public int n;
    public final Integer o;
    public final ColorStateList p;
    public Integer q;
    public Integer r;
    public Integer s;
    public Integer t;
    public final ArgbEvaluator u;
    public final b v;
    public ValueAnimator w;
    public ValueAnimator x;
    public ValueAnimator y;
    public ValueAnimator z;

    public static final class a {
    }

    public static final class b<T> implements TypeEvaluator {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.animation.TypeEvaluator
        public final Object evaluate(float r8, Object r9, Object r10) {
            Integer r11 = (Integer) r9;
            Integer r12 = (Integer) r10;
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Int");
            int r13 = r11.intValue();
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Int");
            int r14 = r12.intValue();
            float r0 = Color.alpha(r13) / 255.0f;
            float r2 = Color.red(r13) / 255.0f;
            float r3 = Color.green(r13) / 255.0f;
            float r15 = Color.blue(r13) / 255.0f;
            float r4 = Color.alpha(r14) / 255.0f;
            float r5 = Color.red(r14) / 255.0f;
            float r6 = r2 * r0;
            float r7 = r3 * r0;
            float r16 = r15 * r0;
            float r17 = (Color.green(r14) / 255.0f) * r4;
            float r1 = r0 + ((r4 - r0) * r8);
            float r18 = r6 + (((r5 * r4) - r6) * r8);
            float r19 = r7 + ((r17 - r7) * r8);
            float r20 = r16 + ((((Color.blue(r14) / 255.0f) * r4) - r16) * r8);
            if (r1 > 0.0f) goto L6;
            return 0;
        L6:
            return Integer.valueOf(Color.argb(RangesKt.coerceIn((int) (r1 * 255.0f), 0, 255), RangesKt.coerceIn((int) (RangesKt.coerceIn(r18 / r1, 0.0f, 1.0f) * 255.0f), 0, 255), RangesKt.coerceIn((int) (RangesKt.coerceIn(r19 / r1, 0.0f, 1.0f) * 255.0f), 0, 255), RangesKt.coerceIn((int) (RangesKt.coerceIn(r20 / r1, 0.0f, 1.0f) * 255.0f), 0, 255)));
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ RoundedIconTextView a;

        public c(RoundedIconTextView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Object r3 = r2.getAnimatedValue();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Int");
            int r4 = ((Integer) r3).intValue();
            RoundedIconTextView r0 = this.a;
            r0.c = r4;
            r0.f.setColor(r4);
            this.a.invalidate();
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ RoundedIconTextView a;

        public d(RoundedIconTextView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Object r3 = r2.getAnimatedValue();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Int");
            int r4 = ((Integer) r3).intValue();
            RoundedIconTextView r0 = this.a;
            r0.b = r4;
            r0.g.setColor(r4);
            this.a.invalidate();
        }
    }

    public static final class e implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ RoundedIconTextView a;

        public e(RoundedIconTextView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            TextView r0 = this.a.j;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            r0 = null;
        L5:
            Object r4 = r3.getAnimatedValue();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
            r0.setTextColor(((Integer) r4).intValue());
        }
    }

    public static final class f implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ RoundedIconTextView a;

        public f(RoundedIconTextView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Object r3 = r2.getAnimatedValue();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Int");
            int r4 = ((Integer) r3).intValue();
            ImageView r0 = this.a.i;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
            r0 = null;
        L5:
            ImageViewCompat.setImageTintList(r0, ColorStateList.valueOf(r4));
        }
    }

    public RoundedIconTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RoundedIconTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        F = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
        G = new LinearInterpolator();
    }

    private final int getCloseIconSizePx() {
        return ((Number) this.C.getValue()).intValue();
    }

    private final int getCloseIconSpacingPx() {
        return ((Number) this.D.getValue()).intValue();
    }

    private final int getTextStartMarginWithIconPx() {
        return ((Number) this.E.getValue()).intValue();
    }

    public final void f() {
        TextView r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.i == null) goto L35;
        TextView r2 = null;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r0 = null;
    L10:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof LinearLayout.LayoutParams) == false) goto L13;
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r1;
    L14:
        if (r3 != null) goto L16;
        return;
    L16:
        ImageView r4 = this.i;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r4 = null;
    L19:
        int r5 = 0;
        if (r4.getVisibility() != 0) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == false) goto L26;
        r5 = getTextStartMarginWithIconPx();
    L26:
        if (r3.getMarginStart() != r5) goto L28;
        return;
    L28:
        r3.setMarginStart(r5);
        TextView r7 = this.j;
        if (r7 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L32:
        r2.setLayoutParams(r3);
        return;
    L31:
        r2 = r7;
        goto L32
    L22:
        r6 = false;
        goto L23
    L13:
        r3 = null;
        goto L14
    }

    public final ImageView getIconView() {
        ImageView r0 = this.i;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        return null;
    L6:
        return r0;
    }

    public final TextView getTextView() {
        TextView r0 = this.j;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        return null;
    L6:
        return r0;
    }

    public final void a(boolean r9) {
        if (this.j != null) goto L5;
        return;
    L5:
        if (this.i != null) goto L7;
        return;
    L7:
        if (this.k == null) goto L69;
        if (r9 == false) goto L11;
    L13:
        ImageView r3 = null;
        if (this.l == false) goto L47;
        Integer r10 = this.q;
        if (r10 == null) goto L18;
        int r11 = r10.intValue();
    L19:
        Integer r4 = this.r;
        if (r4 == null) goto L22;
        int r5 = r4.intValue();
    L23:
        Integer r6 = this.s;
        if (r6 == null) goto L26;
    L25:
        int r7 = r6.intValue();
    L33:
        Integer r8 = this.t;
        this.c = r11;
        this.f.setColor(r11);
        this.b = r5;
        this.g.setColor(r5);
        TextView r12 = this.j;
        if (r12 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r12 = null;
    L36:
        r12.setTextColor(r7);
        if (r8 == null) goto L42;
        ImageView r13 = this.i;
        if (r13 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r13 = null;
    L41:
        ImageViewCompat.setImageTintList(r13, ColorStateList.valueOf(r8.intValue()));
    L42:
        ImageView r14 = this.k;
        if (r14 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
    L46:
        ImageViewCompat.setImageTintList(r3, ColorStateList.valueOf(this.a));
    L62:
        if (this.l == false) goto L64;
        float r15 = 1.0f;
    L65:
        b(r15);
        invalidate();
        return;
    L64:
        r15 = 0.0f;
        goto L65
    L45:
        r3 = r14;
        goto L46
    L26:
        r6 = this.o;
        if (r6 != null) goto L25;
        TextView r16 = this.j;
        if (r16 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r16 = null;
    L32:
        r7 = r16.getCurrentTextColor();
        goto L33
    L22:
        r5 = this.n;
        goto L23
    L18:
        r11 = this.m;
        goto L19
    L47:
        int r17 = this.m;
        this.c = r17;
        this.f.setColor(r17);
        int r18 = this.n;
        this.b = r18;
        this.g.setColor(r18);
        Integer r19 = this.o;
        if (r19 == null) goto L53;
        int r20 = r19.intValue();
        TextView r21 = this.j;
        if (r21 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r21 = null;
    L52:
        r21.setTextColor(r20);
    L53:
        ImageView r22 = this.i;
        if (r22 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r22 = null;
    L56:
        ImageViewCompat.setImageTintList(r22, this.p);
        ImageView r23 = this.k;
        if (r23 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
    L60:
        ImageViewCompat.setImageTintList(r3, this.p);
        goto L62
    L59:
        r3 = r23;
        goto L60
    L11:
        if (this.l == true) goto L13;
        return;
    }

    public final void b(float r5) {
        this.B = RangesKt.coerceIn(r5, 0.0f, 1.0f);
        ImageView r6 = this.k;
        if (r6 != null) goto L5;
        return;
    L5:
        ImageView r1 = null;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
        r6 = null;
    L8:
        r6.setAlpha(this.B);
        ImageView r7 = this.k;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
        r7 = null;
    L11:
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if ((r8 instanceof LinearLayout.LayoutParams) == false) goto L14;
        LinearLayout.LayoutParams r9 = (LinearLayout.LayoutParams) r8;
    L15:
        if (r9 != null) goto L17;
        return;
    L17:
        r9.width = (int) (getCloseIconSizePx() * this.B);
        r9.setMarginStart((int) (getCloseIconSpacingPx() * this.B));
        ImageView r2 = this.k;
        if (r2 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
    L21:
        r1.setLayoutParams(r9);
        return;
    L20:
        r1 = r2;
        goto L21
    L14:
        r9 = null;
        goto L15
    }

    public final float c(float r3) {
        Resources r0 = getContext().getResources();
        return r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        super.onDraw(r8);
        RectF r0 = this.h;
        float r1 = this.d;
        float r2 = 2;
        r0.set(r1 / r2, r1 / r2, getWidth() - (this.d / r2), getHeight() - (this.d / r2));
        RectF r3 = this.h;
        float r4 = this.e;
        r8.drawRoundRect(r3, r4, r4, this.f);
        RectF r5 = this.h;
        float r6 = this.e;
        r8.drawRoundRect(r5, r6, r6, this.g);
    }

    public final void setBoarderVisible(boolean r2) {
        if (r2 == false) goto L4;
        float r3 = c(2.0f);
    L5:
        this.d = r3;
        this.g.setStrokeWidth(r3);
        invalidate();
        return;
    L4:
        r3 = 0.0f;
        goto L5
    }

    public final void setBorderColor(int r2) {
        this.n = r2;
        if (this.l == true) goto L6;
        this.b = r2;
        this.g.setColor(r2);
        invalidate();
        return;
    }

    public final void setChecked(boolean r2) {
        d(r2, false);
    }

    public final void setCheckedBackgroundColor(int r1) {
        this.q = Integer.valueOf(r1);
        a(true);
    }

    public final void setCheckedBorderColor(int r1) {
        this.r = Integer.valueOf(r1);
        a(true);
    }

    public final void setCheckedIconTintColor(int r1) {
        this.t = Integer.valueOf(r1);
        a(true);
    }

    public final void setCheckedTextColor(int r1) {
        this.s = Integer.valueOf(r1);
        a(true);
    }

    public final void setCustomBackgroundColor(int r2) {
        this.m = r2;
        if (this.l == true) goto L6;
        this.c = r2;
        this.f.setColor(r2);
        invalidate();
        return;
    }

    public final void setIcon(int r4) {
        ImageView r0 = this.i;
        ImageView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r0 = null;
    L5:
        r0.setImageResource(r4);
        ImageView r5 = this.i;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L9:
        r1.setVisibility(0);
        f();
        a(true);
        return;
    L8:
        r1 = r5;
        goto L9
    }

    public final void setInputTopActionCheckedStyle(boolean r5) {
        if (r5 == false) goto L4;
        this.a = UIUtils.getColor(getContext(), 2131102048);
        e(0, UIUtils.getColor(getContext(), 2131102040), UIUtils.getColor(getContext(), 2131102040), UIUtils.getColor(getContext(), 2131102040));
        return;
    L4:
        this.a = UIUtils.getColor(getContext(), 2131102059);
        e(UIUtils.getColor(getContext(), 2131102058), UIUtils.getColor(getContext(), 2131102055), UIUtils.getColor(getContext(), 2131102049), UIUtils.getColor(getContext(), 2131102049));
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        TextView r0 = this.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r0 = null;
    L5:
        r0.setText(r2);
        a(true);
    }

    public final void setTextBold(boolean r3) {
        TextView r0 = this.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r0 = null;
    L5:
        if (r3 == false) goto L7;
        int r4 = h18.e.a;
        Typeface r5 = h18.e.b(getContext(), 1);
    L8:
        r0.setTypeface(r5);
        return;
    L7:
        int r6 = h18.e.a;
        r5 = h18.e.b(getContext(), 0);
        goto L8
    }

    public final void d(boolean r18, boolean r19) {
        if (this.j != null) goto L5;
        return;
    L5:
        if (this.i != null) goto L7;
        return;
    L7:
        if (this.k != null) goto L10;
        return;
    L10:
        if (this.l != r18) goto L17;
        if (r19 == true) goto L17;
        if (r18 == false) goto L14;
        float r3 = 1.0f;
    L15:
        b(r3);
        return;
    L14:
        r3 = 0.0f;
    L17:
        ValueAnimator r2 = this.w;
        if (r2 == null) goto L20;
        r2.cancel();
    L20:
        ValueAnimator r4 = this.x;
        if (r4 == null) goto L23;
        r4.cancel();
    L23:
        ValueAnimator r5 = this.y;
        if (r5 == null) goto L26;
        r5.cancel();
    L26:
        ValueAnimator r6 = this.z;
        if (r6 == null) goto L29;
        r6.cancel();
    L29:
        ValueAnimator r7 = this.A;
        if (r7 == null) goto L32;
        r7.cancel();
    L32:
        int r8 = this.f.getColor();
        int r9 = this.g.getColor();
        TextView r10 = this.j;
        ImageView r11 = null;
        if (r10 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r10 = null;
    L35:
        int r12 = r10.getCurrentTextColor();
        ImageView r13 = this.i;
        if (r13 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r13 = null;
    L38:
        ColorStateList r14 = ImageViewCompat.getImageTintList(r13);
        if (r14 != null) goto L43;
        r14 = this.p;
        if (r14 != null) goto L43;
        int r15 = UDColorUtils.getColor(getContext(), 2131102040);
    L45:
        if (r18 == false) goto L49;
        Integer r16 = this.q;
        if (r16 == null) goto L49;
        int r17 = r16.intValue();
    L50:
        if (r18 == false) goto L54;
        Integer r110 = this.r;
        if (r110 == null) goto L54;
        int r111 = r110.intValue();
    L55:
        if (r18 == false) goto L66;
        Integer r112 = this.s;
        if (r112 != null) goto L68;
        r112 = this.o;
        if (r112 != null) goto L68;
        TextView r113 = this.j;
        if (r113 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r113 = null;
    L65:
        int r20 = r113.getCurrentTextColor();
    L73:
        if (r18 == false) goto L77;
        Integer r114 = this.t;
        if (r114 == null) goto L80;
        int r115 = r114.intValue();
    L81:
        if (r18 == false) goto L83;
        int r116 = this.a;
    L87:
        this.l = r18;
        if (r19 == true) goto L95;
        a(true);
        if (r18 == false) goto L92;
        float r21 = 1.0f;
    L93:
        b(r21);
        return;
    L92:
        r21 = 0.0f;
        goto L93
    L95:
        ImageView r117 = this.k;
        if (r117 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
    L99:
        ImageViewCompat.setImageTintList(r11, ColorStateList.valueOf(r116));
        ValueAnimator r22 = ValueAnimator.ofObject(this.v, new Object[]{Integer.valueOf(r8), Integer.valueOf(r17)});
        r22.setDuration(200);
        LinearInterpolator r118 = G;
        r22.setInterpolator(r118);
        r22.addUpdateListener(new c(this));
        r22.start();
        this.w = r22;
        ValueAnimator r23 = ValueAnimator.ofObject(this.v, new Object[]{Integer.valueOf(r9), Integer.valueOf(r111)});
        r23.setDuration(200);
        r23.setInterpolator(r118);
        r23.addUpdateListener(new d(this));
        r23.start();
        this.x = r23;
        ValueAnimator r24 = ValueAnimator.ofObject(this.u, new Object[]{Integer.valueOf(r12), Integer.valueOf(r20)});
        r24.setDuration(200);
        r24.setInterpolator(r118);
        r24.addUpdateListener(new e(this));
        r24.start();
        this.y = r24;
        ValueAnimator r25 = ValueAnimator.ofObject(this.u, new Object[]{Integer.valueOf(r15), Integer.valueOf(r115)});
        r25.setDuration(200);
        r25.setInterpolator(r118);
        r25.addUpdateListener(new f(this));
        r25.start();
        this.z = r25;
        if (r18 == false) goto L102;
        float r119 = 1.0f;
    L103:
        float r1 = this.B;
        if (r1 != r119) goto L106;
        boolean r26 = true;
    L107:
        if (r26 == true) goto L117;
        ValueAnimator r27 = this.A;
        if (r27 == null) goto L112;
        r27.cancel();
    L112:
        ValueAnimator r28 = ValueAnimator.ofFloat(new float[]{r1, r119});
        r28.setDuration(200);
        r28.setInterpolator(F);
        r28.addUpdateListener(new j(this));
        r28.addListener(new k(this, r119));
        r28.start();
        this.A = r28;
        return;
    L117:
        return;
    L106:
        r26 = false;
        goto L107
    L102:
        r119 = 0.0f;
        goto L103
    L98:
        r11 = r117;
        goto L99
    L83:
        ColorStateList r120 = this.p;
        if (r120 == null) goto L86;
        r116 = r120.getDefaultColor();
        goto L87
    L86:
        r116 = r15;
    L80:
        r115 = r15;
        goto L81
    L77:
        ColorStateList r121 = this.p;
        if (r121 == null) goto L80;
        r115 = r121.getDefaultColor();
    L68:
        r20 = r112.intValue();
        goto L73
    L66:
        r112 = this.o;
        if (r112 != null) goto L68;
        TextView r122 = this.j;
        if (r122 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r122 = null;
    L72:
        r20 = r122.getCurrentTextColor();
    L54:
        r111 = this.n;
    L49:
        r17 = this.m;
    L43:
        r15 = r14.getDefaultColor();
        goto L45
    }

    public RoundedIconTextView(final Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11);
        this.a = UIUtils.getColor(r9, 2131102059);
        this.b = UIUtils.getColor(r9, 2131102046);
        this.c = UIUtils.getColor(r9, 2131102028);
        this.d = 2.0f;
        this.e = c(8.0f);
        float r0 = c(12.0f);
        float r1 = c(8.0f);
        float r12 = c(12.0f);
        float r13 = c(8.0f);
        Paint r2 = new Paint(1);
        this.f = r2;
        Paint r4 = new Paint(1);
        this.g = r4;
        this.h = new RectF();
        this.m = this.c;
        this.n = this.b;
        this.u = new ArgbEvaluator();
        this.v = b.a;
        this.C = LazyKt.lazy(new RoundedIconTextView$closeIconSizePx$2(r9));
        this.D = LazyKt.lazy(new RoundedIconTextView$closeIconSpacingPx$2(r9));
        UIUtils.dp2px(r9, 14.0f);
        this.E = LazyKt.lazy(new RoundedIconTextView$textStartMarginWithIconPx$2(r9));
        LayoutInflater.from(getContext()).inflate(2131564287, this, true);
        this.i = (ImageView) findViewById(2131374808);
        this.j = (TextView) findViewById(2131388525);
        this.k = (ImageView) findViewById(2131367009);
        TextView r3 = this.j;
        LinearLayout.LayoutParams r5 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r3 = null;
    L5:
        r3.getTypeface();
        ImageView r6 = this.i;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r6 = null;
    L8:
        r6.setVisibility(8);
        f();
        ImageView r7 = this.k;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
        r7 = null;
    L11:
        r7.setImportantForAccessibility(2);
        r7.setClickable(false);
        r7.setFocusable(false);
        r7.setAlpha(0.0f);
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if ((r8 instanceof LinearLayout.LayoutParams) == false) goto L14;
        r5 = (LinearLayout.LayoutParams) r8;
    L14:
        if (r5 == null) goto L16;
        r5.width = 0;
        r5.setMarginStart(0);
    L16:
        setPadding((int) r0, (int) r1, (int) r12, (int) r13);
        setWillNotDraw(false);
        r2.setColor(this.c);
        r2.setStyle(Paint.Style.FILL);
        r4.setColor(this.b);
        r4.setStyle(Paint.Style.STROKE);
        r4.setStrokeWidth(this.d);
        this.m = this.c;
        this.n = this.b;
        this.o = Integer.valueOf(UIUtils.getColor(r9, 2131102040));
        this.p = ColorStateList.valueOf(UDColorUtils.getColor(r9, 2131102040));
    }

    public /* synthetic */ RoundedIconTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void e(int r1, int r2, int r3, int r4) {
        this.q = Integer.valueOf(r1);
        this.r = Integer.valueOf(r2);
        this.s = Integer.valueOf(r3);
        this.t = Integer.valueOf(r4);
        a(true);
    }
}
