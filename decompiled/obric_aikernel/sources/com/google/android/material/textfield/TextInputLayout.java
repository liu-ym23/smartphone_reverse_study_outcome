package com.google.android.material.textfield;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.ttnet.org.chromium.net.NetError;
import java.util.Iterator;
import java.util.LinkedHashSet;
import q5.j;
import q5.k;

/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    private static final int N0 = 0;
    private int A;
    private ColorStateList A0;

    @Nullable
    private Fade B;

    @ColorInt
    private int B0;

    @Nullable
    private Fade C;

    @ColorInt
    private int C0;

    @Nullable
    private ColorStateList D;

    @ColorInt
    private int D0;

    @Nullable
    private ColorStateList E;

    @ColorInt
    private int E0;

    @Nullable
    private CharSequence F;

    @ColorInt
    private int F0;

    @NonNull
    private final TextView G;
    private boolean G0;
    private boolean H;
    final com.google.android.material.internal.b H0;
    private CharSequence I;
    private boolean I0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f3904J;
    private boolean J0;

    @Nullable
    private MaterialShapeDrawable K;
    private ValueAnimator K0;

    @Nullable
    private MaterialShapeDrawable L;
    private boolean L0;

    @Nullable
    private MaterialShapeDrawable M;
    private boolean M0;

    @NonNull
    private l N;
    private boolean O;
    private final int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;

    @ColorInt
    private int V;

    @ColorInt
    private int W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final Rect f3905a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final Rect f3906b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final FrameLayout f3907c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private final RectF f3908c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private Typeface f3909d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    @Nullable
    private Drawable f3910e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f3911f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    private final h f3912g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final LinkedHashSet<e> f3913g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    private final LinearLayout f3914h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private int f3915h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    private final FrameLayout f3916i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private final SparseArray<com.google.android.material.textfield.c> f3917i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    EditText f3918j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    @NonNull
    private final CheckableImageButton f3919j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f3920k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final LinkedHashSet<f> f3921k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f3922l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private ColorStateList f3923l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f3924m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private PorterDuff.Mode f3925m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f3926n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    @Nullable
    private Drawable f3927n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f3928o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f3929o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final com.google.android.material.textfield.e f3930p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private Drawable f3931p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f3932q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private View.OnLongClickListener f3933q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f3934r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private View.OnLongClickListener f3935r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f3936s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    @NonNull
    private final CheckableImageButton f3937s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private TextView f3938t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private ColorStateList f3939t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f3940u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private PorterDuff.Mode f3941u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f3942v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private ColorStateList f3943v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private CharSequence f3944w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private ColorStateList f3945w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f3946x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    @ColorInt
    private int f3947x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private TextView f3948y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    @ColorInt
    private int f3949y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    private ColorStateList f3950z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    @ColorInt
    private int f3951z0;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final TextInputLayout layout;

        public AccessibilityDelegate(@NonNull TextInputLayout r10) {
            this.layout = r10;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull View r13, @NonNull AccessibilityNodeInfoCompat r14) {
            super.onInitializeAccessibilityNodeInfo(r13, r14);
            EditText r15 = this.layout.getEditText();
            if (r15 == null) goto L5;
            CharSequence r16 = r15.getText();
        L6:
            CharSequence r10 = this.layout.getHint();
            CharSequence r11 = this.layout.getError();
            CharSequence r12 = this.layout.getPlaceholderText();
            int r17 = this.layout.getCounterMaxLength();
            CharSequence r18 = this.layout.getCounterOverflowDescription();
            boolean r19 = !TextUtils.isEmpty(r16);
            boolean r20 = !TextUtils.isEmpty(r10);
            boolean r21 = !this.layout.N();
            boolean r22 = !TextUtils.isEmpty(r11);
            if (r22 == false) goto L9;
        L12:
            boolean r110 = true;
        L13:
            if (r20 == false) goto L15;
            String r23 = r10.toString();
        L16:
            TextInputLayout.e(this.layout).v(r14);
            if (r19 == false) goto L20;
            r14.setText(r16);
        L28:
            if (TextUtils.isEmpty(r23) == false) goto L30;
        L36:
            if (r16 != null) goto L38;
        L40:
            r17 = -1;
        L41:
            r14.setMaxTextLength(r17);
            if (r110 == false) goto L48;
            if (r22 == true) goto L46;
            r11 = r18;
        L46:
            r14.setError(r11);
        L48:
            if (Build.VERSION.SDK_INT < 17) goto L53;
            View r111 = TextInputLayout.f(this.layout).s();
            if (r111 == null) goto L54;
            r14.setLabelFor(r111);
            return;
        L54:
            return;
        L53:
            return;
        L38:
            if (r16.length() != r17) goto L40;
        L30:
            if (Build.VERSION.SDK_INT < 26) goto L32;
            r14.setHintText(r23);
        L35:
            r14.setShowingHintText(!r19);
            goto L36
        L32:
            if (r19 == false) goto L34;
            r23 = r16 + ", " + r23;
        L34:
            r14.setText(r23);
            goto L35
        L20:
            if (TextUtils.isEmpty(r23) == true) goto L25;
            r14.setText(r23);
            if (r21 == false) goto L28;
            if (r12 == null) goto L28;
            r12 = r23 + ", " + r12;
        L26:
            r14.setText(r12);
            goto L28
        L25:
            if (r12 == null) goto L28;
        L15:
            r23 = "";
            goto L16
        L9:
            if (TextUtils.isEmpty(r18) == false) goto L12;
            r110 = false;
            goto L13
        L5:
            r16 = null;
            goto L6
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        @Nullable
        CharSequence error;

        @Nullable
        CharSequence helperText;

        @Nullable
        CharSequence hintText;
        boolean isEndIconChecked;

        @Nullable
        CharSequence placeholderText;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Nullable
            public SavedState a(@NonNull Parcel r10) {
                return new SavedState(r10, null);
            }

            @NonNull
            public SavedState b(@NonNull Parcel r10, ClassLoader r11) {
                return new SavedState(r10, r11);
            }

            @NonNull
            public SavedState[] c(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public /* bridge */ /* synthetic */ Object createFromParcel(@NonNull Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public /* bridge */ /* synthetic */ SavedState createFromParcel(@NonNull Parcel r10, ClassLoader r11) {
                return b(r10, r11);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return c(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        SavedState(@NonNull Parcel r10, ClassLoader r11) {
            super(r10, r11);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r10);
            boolean r12 = true;
            if (r10.readInt() == 1) goto L6;
            r12 = false;
        L6:
            this.isEndIconChecked = r12;
            this.hintText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r10);
            this.helperText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r10);
            this.placeholderText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r10);
        }

        SavedState(Parcelable r10) {
            super(r10);
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + " hint=" + this.hintText + " helperText=" + this.helperText + " placeholderText=" + this.placeholderText + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            TextUtils.writeToParcel(this.error, r10, r11);
            r10.writeInt(this.isEndIconChecked ? 1 : 0);
            TextUtils.writeToParcel(this.hintText, r10, r11);
            TextUtils.writeToParcel(this.helperText, r10, r11);
            TextUtils.writeToParcel(this.placeholderText, r10, r11);
        }
    }

    class a implements TextWatcher {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f3952c;

        a(TextInputLayout r10) {
            this.f3952c = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable r10) {
            TextInputLayout r11 = this.f3952c;
            r11.w0(!TextInputLayout.a(r11));
            TextInputLayout r12 = this.f3952c;
            if (r12.f3932q == false) goto L6;
            r12.m0(r10.length());
        L6:
            if (TextInputLayout.b(this.f3952c) == false) goto L9;
            TextInputLayout.c(this.f3952c, r10.length());
            return;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f3953c;

        b(TextInputLayout r10) {
            this.f3953c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.d(this.f3953c).performClick();
            TextInputLayout.d(this.f3953c).jumpDrawablesToCurrentState();
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f3954c;

        c(TextInputLayout r10) {
            this.f3954c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3954c.f3918j.requestLayout();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f3955c;

        d(TextInputLayout r10) {
            this.f3955c = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r10) {
            this.f3955c.H0.u0(((Float) r10.getAnimatedValue()).floatValue());
        }
    }

    public interface e {
        void a(@NonNull TextInputLayout r10);
    }

    public interface f {
        void a(@NonNull TextInputLayout r10, int r11);
    }

    static {
        N0 = k.Widget_Design_TextInputLayout;
    }

    public TextInputLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public TextInputLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.textInputStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v109 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50, types: [boolean, int] */
    public TextInputLayout(@NonNull Context r27, @Nullable AttributeSet r28, int r29) {
        int r10 = N0;
        super(b6.a.c(r27, r28, r29, r10), r28, r29);
        this.f3922l = -1;
        this.f3924m = -1;
        this.f3926n = -1;
        this.f3928o = -1;
        this.f3930p = new com.google.android.material.textfield.e(this);
        this.f3905a0 = new Rect();
        this.f3906b0 = new Rect();
        this.f3908c0 = new RectF();
        this.f3913g0 = new LinkedHashSet();
        this.f3915h0 = 0;
        SparseArray<com.google.android.material.textfield.c> r12 = new SparseArray();
        this.f3917i0 = r12;
        this.f3921k0 = new LinkedHashSet();
        com.google.android.material.internal.b r11 = new com.google.android.material.internal.b(this);
        this.H0 = r11;
        Context r13 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout r15 = new FrameLayout(r13);
        this.f3907c = r15;
        FrameLayout r14 = new FrameLayout(r13);
        this.f3916i = r14;
        LinearLayout r16 = new LinearLayout(r13);
        this.f3914h = r16;
        AppCompatTextView r17 = new AppCompatTextView(r13);
        this.G = r17;
        r16.setVisibility(8);
        r14.setVisibility(8);
        r17.setVisibility(8);
        LayoutInflater r18 = LayoutInflater.from(r13);
        int r19 = q5.h.design_text_input_end_icon;
        CheckableImageButton r110 = (CheckableImageButton) r18.inflate(r19, r16, false);
        this.f3937s0 = r110;
        CheckableImageButton r20 = (CheckableImageButton) r18.inflate(r19, r14, false);
        this.f3919j0 = r20;
        r15.setAddStatesFromChildren(true);
        r16.setOrientation(0);
        r16.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        r14.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator r21 = r5.a.f12673a;
        r11.G0(r21);
        r11.C0(r21);
        r11.g0(MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START);
        int[] r22 = q5.l.TextInputLayout;
        int r23 = q5.l.TextInputLayout_counterTextAppearance;
        int r24 = q5.l.TextInputLayout_counterOverflowTextAppearance;
        int r111 = q5.l.TextInputLayout_errorTextAppearance;
        int r112 = q5.l.TextInputLayout_helperTextTextAppearance;
        int r113 = q5.l.TextInputLayout_hintTextAppearance;
        TintTypedArray r25 = com.google.android.material.internal.k.i(r13, r28, r22, r29, r10, new int[]{r23, r24, r111, r112, r113});
        h r26 = new h(this, r25);
        this.f3912g = r26;
        this.H = r25.getBoolean(q5.l.TextInputLayout_hintEnabled, true);
        setHint(r25.getText(q5.l.TextInputLayout_android_hint));
        this.J0 = r25.getBoolean(q5.l.TextInputLayout_hintAnimationEnabled, true);
        this.I0 = r25.getBoolean(q5.l.TextInputLayout_expandedHintEnabled, true);
        int r30 = q5.l.TextInputLayout_android_minEms;
        if (r25.hasValue(r30) == false) goto L5;
        int r31 = -1;
        setMinEms(r25.getInt(r30, -1));
    L8:
        int r32 = q5.l.TextInputLayout_android_maxEms;
        if (r25.hasValue(r32) == false) goto L11;
        setMaxEms(r25.getInt(r32, r31));
    L14:
        this.N = l.e(r13, r28, r29, r10).m();
        this.P = r13.getResources().getDimensionPixelOffset(q5.d.mtrl_textinput_box_label_cutout_padding);
        this.R = r25.getDimensionPixelOffset(q5.l.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.T = r25.getDimensionPixelSize(q5.l.TextInputLayout_boxStrokeWidth, r13.getResources().getDimensionPixelSize(q5.d.mtrl_textinput_box_stroke_width_default));
        this.U = r25.getDimensionPixelSize(q5.l.TextInputLayout_boxStrokeWidthFocused, r13.getResources().getDimensionPixelSize(q5.d.mtrl_textinput_box_stroke_width_focused));
        this.S = this.T;
        float r33 = r25.getDimension(q5.l.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float r34 = r25.getDimension(q5.l.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float r35 = r25.getDimension(q5.l.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float r36 = r25.getDimension(q5.l.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        l.b r37 = this.N.v();
        if (r33 < 0.0f) goto L18;
        r37.E(r33);
    L18:
        if (r34 < 0.0f) goto L21;
        r37.I(r34);
    L21:
        if (r35 < 0.0f) goto L24;
        r37.z(r35);
    L24:
        if (r36 < 0.0f) goto L26;
        r37.v(r36);
    L26:
        this.N = r37.m();
        ColorStateList r38 = com.google.android.material.resources.c.b(r13, r25, q5.l.TextInputLayout_boxBackgroundColor);
        if (r38 == null) goto L33;
        int r39 = r38.getDefaultColor();
        this.B0 = r39;
        this.W = r39;
        if (r38.isStateful() == false) goto L31;
        this.C0 = r38.getColorForState(new int[]{-16842910}, -1);
        this.D0 = r38.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        int r40 = r38.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
    L32:
        this.E0 = r40;
    L34:
        int r41 = q5.l.TextInputLayout_android_textColorHint;
        if (r25.hasValue(r41) == false) goto L37;
        ColorStateList r42 = r25.getColorStateList(r41);
        this.f3945w0 = r42;
        this.f3943v0 = r42;
    L37:
        int r43 = q5.l.TextInputLayout_boxStrokeColor;
        ColorStateList r44 = com.google.android.material.resources.c.b(r13, r25, r43);
        this.f3951z0 = r25.getColor(r43, 0);
        this.f3947x0 = ContextCompat.getColor(r13, q5.c.mtrl_textinput_default_box_stroke_color);
        this.F0 = ContextCompat.getColor(r13, q5.c.mtrl_textinput_disabled_color);
        this.f3949y0 = ContextCompat.getColor(r13, q5.c.mtrl_textinput_hovered_box_stroke_color);
        if (r44 == null) goto L40;
        setBoxStrokeColorStateList(r44);
    L40:
        int r45 = q5.l.TextInputLayout_boxStrokeErrorColor;
        if (r25.hasValue(r45) == false) goto L44;
        setBoxStrokeErrorColor(com.google.android.material.resources.c.b(r13, r25, r45));
    L44:
        if (r25.getResourceId(r113, -1) == (-1)) goto L46;
        ?? r46 = 0;
        setHintTextAppearance(r25.getResourceId(r113, 0));
    L47:
        int r47 = r25.getResourceId(r111, r46);
        CharSequence r48 = r25.getText(q5.l.TextInputLayout_errorContentDescription);
        boolean r49 = r25.getBoolean(q5.l.TextInputLayout_errorEnabled, r46);
        r110.setId(q5.f.text_input_error_icon);
        if (com.google.android.material.resources.c.i(r13) == false) goto L50;
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) r110.getLayoutParams(), r46);
    L50:
        int r50 = q5.l.TextInputLayout_errorIconTint;
        if (r25.hasValue(r50) == false) goto L53;
        this.f3939t0 = com.google.android.material.resources.c.b(r13, r25, r50);
    L53:
        int r51 = q5.l.TextInputLayout_errorIconTintMode;
        if (r25.hasValue(r51) == false) goto L56;
        this.f3941u0 = ViewUtils.j(r25.getInt(r51, -1), null);
    L56:
        int r52 = q5.l.TextInputLayout_errorIconDrawable;
        if (r25.hasValue(r52) == false) goto L59;
        setErrorIconDrawable(r25.getDrawable(r52));
    L59:
        r110.setContentDescription(getResources().getText(j.error_icon_content_description));
        ViewCompat.setImportantForAccessibility(r110, 2);
        r110.setClickable(false);
        r110.setPressable(false);
        r110.setFocusable(false);
        int r53 = r25.getResourceId(r112, 0);
        boolean r54 = r25.getBoolean(q5.l.TextInputLayout_helperTextEnabled, false);
        CharSequence r114 = r25.getText(q5.l.TextInputLayout_helperText);
        int r115 = r25.getResourceId(q5.l.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence r116 = r25.getText(q5.l.TextInputLayout_placeholderText);
        int r117 = r25.getResourceId(q5.l.TextInputLayout_suffixTextAppearance, 0);
        CharSequence r55 = r25.getText(q5.l.TextInputLayout_suffixText);
        boolean r56 = r25.getBoolean(q5.l.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(r25.getInt(q5.l.TextInputLayout_counterMaxLength, -1));
        this.f3942v = r25.getResourceId(r23, 0);
        this.f3940u = r25.getResourceId(r24, 0);
        setBoxBackgroundMode(r25.getInt(q5.l.TextInputLayout_boxBackgroundMode, 0));
        if (com.google.android.material.resources.c.i(r13) == false) goto L62;
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) r20.getLayoutParams(), 0);
    L62:
        int r57 = r25.getResourceId(q5.l.TextInputLayout_endIconDrawable, 0);
        r12.append(-1, new com.google.android.material.textfield.b(this, r57));
        r12.append(0, new com.google.android.material.textfield.f(this));
        if (r57 != 0) goto L65;
        int r58 = r25.getResourceId(q5.l.TextInputLayout_passwordToggleDrawable, 0);
    L66:
        r12.append(1, new g(this, r58));
        r12.append(2, new com.google.android.material.textfield.a(this, r57));
        r12.append(3, new DropdownMenuEndIconDelegate(this, r57));
        int r59 = q5.l.TextInputLayout_passwordToggleEnabled;
        if (r25.hasValue(r59) == true) goto L74;
        int r60 = q5.l.TextInputLayout_endIconTint;
        if (r25.hasValue(r60) == false) goto L71;
        this.f3923l0 = com.google.android.material.resources.c.b(r13, r25, r60);
    L71:
        int r61 = q5.l.TextInputLayout_endIconTintMode;
        if (r25.hasValue(r61) == false) goto L74;
        this.f3925m0 = ViewUtils.j(r25.getInt(r61, -1), null);
    L74:
        int r62 = q5.l.TextInputLayout_endIconMode;
        if (r25.hasValue(r62) == false) goto L81;
        setEndIconMode(r25.getInt(r62, 0));
        int r63 = q5.l.TextInputLayout_endIconContentDescription;
        if (r25.hasValue(r63) == false) goto L79;
        setEndIconContentDescription(r25.getText(r63));
    L79:
        setEndIconCheckable(r25.getBoolean(q5.l.TextInputLayout_endIconCheckable, true));
    L89:
        r17.setId(q5.f.textinput_suffix_text);
        r17.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        ViewCompat.setAccessibilityLiveRegion(r17, 1);
        setErrorContentDescription(r48);
        setCounterOverflowTextAppearance(this.f3940u);
        setHelperTextTextAppearance(r53);
        setErrorTextAppearance(r47);
        setCounterTextAppearance(this.f3942v);
        setPlaceholderText(r116);
        setPlaceholderTextAppearance(r115);
        setSuffixTextAppearance(r117);
        int r64 = q5.l.TextInputLayout_errorTextColor;
        if (r25.hasValue(r64) == false) goto L92;
        setErrorTextColor(r25.getColorStateList(r64));
    L92:
        int r65 = q5.l.TextInputLayout_helperTextTextColor;
        if (r25.hasValue(r65) == false) goto L95;
        setHelperTextColor(r25.getColorStateList(r65));
    L95:
        int r66 = q5.l.TextInputLayout_hintTextColor;
        if (r25.hasValue(r66) == false) goto L98;
        setHintTextColor(r25.getColorStateList(r66));
    L98:
        int r67 = q5.l.TextInputLayout_counterTextColor;
        if (r25.hasValue(r67) == false) goto L101;
        setCounterTextColor(r25.getColorStateList(r67));
    L101:
        int r68 = q5.l.TextInputLayout_counterOverflowTextColor;
        if (r25.hasValue(r68) == false) goto L104;
        setCounterOverflowTextColor(r25.getColorStateList(r68));
    L104:
        int r69 = q5.l.TextInputLayout_placeholderTextColor;
        if (r25.hasValue(r69) == false) goto L107;
        setPlaceholderTextColor(r25.getColorStateList(r69));
    L107:
        int r70 = q5.l.TextInputLayout_suffixTextColor;
        if (r25.hasValue(r70) == false) goto L110;
        setSuffixTextColor(r25.getColorStateList(r70));
    L110:
        setEnabled(r25.getBoolean(q5.l.TextInputLayout_android_enabled, true));
        r25.recycle();
        ViewCompat.setImportantForAccessibility(this, 2);
        if (Build.VERSION.SDK_INT < 26) goto L113;
        ViewCompat.setImportantForAutofill(this, 1);
    L113:
        r14.addView(r20);
        r16.addView(r17);
        r16.addView(r110);
        r16.addView(r14);
        r15.addView(r26);
        r15.addView(r16);
        addView(r15);
        setHelperTextEnabled(r54);
        setErrorEnabled(r49);
        setCounterEnabled(r56);
        setHelperText(r114);
        setSuffixText(r55);
        return;
    L81:
        if (r25.hasValue(r59) == false) goto L89;
        int r71 = q5.l.TextInputLayout_passwordToggleTint;
        if (r25.hasValue(r71) == false) goto L85;
        this.f3923l0 = com.google.android.material.resources.c.b(r13, r25, r71);
    L85:
        int r72 = q5.l.TextInputLayout_passwordToggleTintMode;
        if (r25.hasValue(r72) == false) goto L88;
        this.f3925m0 = ViewUtils.j(r25.getInt(r72, -1), null);
    L88:
        setEndIconMode(r25.getBoolean(r59, false) ? 1 : 0);
        setEndIconContentDescription(r25.getText(q5.l.TextInputLayout_passwordToggleContentDescription));
        goto L89
    L65:
        r58 = r57;
        goto L66
    L46:
        r46 = 0;
        goto L47
    L31:
        this.D0 = this.B0;
        ColorStateList r73 = AppCompatResources.getColorStateList(r13, q5.c.mtrl_filled_background_color);
        this.C0 = r73.getColorForState(new int[]{-16842910}, -1);
        r40 = r73.getColorForState(new int[]{R.attr.state_hovered}, -1);
        goto L32
    L33:
        this.W = 0;
        this.B0 = 0;
        this.C0 = 0;
        this.D0 = 0;
        this.E0 = 0;
        goto L34
    L11:
        int r74 = q5.l.TextInputLayout_android_maxWidth;
        if (r25.hasValue(r74) == false) goto L14;
        setMaxWidth(r25.getDimensionPixelSize(r74, r31));
        goto L14
    L5:
        r31 = -1;
        int r75 = q5.l.TextInputLayout_android_minWidth;
        if (r25.hasValue(r75) == false) goto L8;
        setMinWidth(r25.getDimensionPixelSize(r75, -1));
        goto L8
    }

    private boolean A() {
        if (this.H == true) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(this.I) == true) goto L9;
        if ((this.K instanceof CutoutDrawable) == false) goto L9;
        return true;
    }

    private void A0(int r10) {
        if (r10 == 0) goto L4;
    L6:
        J();
        return;
    L4:
        if (this.G0 == true) goto L6;
        h0();
    }

    private void B() {
        Iterator<e> r10 = this.f3913g0.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().a(this);
        goto L4
    }

    private void B0(boolean r10, boolean r11) {
        int r12 = this.A0.getDefaultColor();
        int r13 = this.A0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, r12);
        int r14 = this.A0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, r12);
        if (r10 == false) goto L5;
        this.V = r14;
        return;
    L5:
        if (r11 == false) goto L7;
        this.V = r13;
        return;
    L7:
        this.V = r12;
    }

    private void C(int r10) {
        Iterator<f> r11 = this.f3921k0.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().a(this, r10);
        goto L4
    }

    private void C0() {
        if (this.f3918j != null) goto L6;
        return;
    L6:
        if (K() == false) goto L8;
    L11:
        int r10 = 0;
    L12:
        ViewCompat.setPaddingRelative(this.G, getContext().getResources().getDimensionPixelSize(q5.d.material_input_text_to_prefix_suffix_padding), this.f3918j.getPaddingTop(), r10, this.f3918j.getPaddingBottom());
        return;
    L8:
        if (L() == true) goto L11;
        r10 = ViewCompat.getPaddingEnd(this.f3918j);
        goto L12
    }

    private void D(Canvas r10) {
        if (this.M == null) goto L10;
        MaterialShapeDrawable r11 = this.L;
        if (r11 == null) goto L11;
        r11.draw(r10);
        if (this.f3918j.isFocused() == false) goto L12;
        Rect r12 = this.M.getBounds();
        Rect r13 = this.L.getBounds();
        float r14 = this.H0.D();
        int r15 = r13.centerX();
        r12.left = r5.a.c(r15, r13.left, r14);
        r12.right = r5.a.c(r15, r13.right, r14);
        this.M.draw(r10);
        return;
    L12:
        return;
    L11:
        return;
    }

    private void D0() {
        int r10 = this.G.getVisibility();
        boolean r11 = false;
        if (this.F != null) goto L5;
    L7:
        int r12 = 8;
    L8:
        if (r10 == r12) goto L13;
        com.google.android.material.textfield.c r13 = getEndIconDelegate();
        if (r12 != 0) goto L12;
        r11 = true;
    L12:
        r13.c(r11);
    L13:
        t0();
        this.G.setVisibility(r12);
        q0();
        return;
    L5:
        if (N() == true) goto L7;
        r12 = 0;
        goto L8
    }

    private void E(@NonNull Canvas r10) {
        if (this.H == false) goto L6;
        this.H0.l(r10);
        return;
    }

    private void F(boolean r10) {
        ValueAnimator r11 = this.K0;
        if (r11 == null) goto L8;
        if (r11.isRunning() == false) goto L8;
        this.K0.cancel();
    L8:
        if (r10 == true) goto L10;
    L12:
        this.H0.u0(0.0f);
    L14:
        if (A() == true) goto L16;
    L18:
        this.G0 = true;
        J();
        this.f3912g.i(true);
        D0();
        return;
    L16:
        if (((CutoutDrawable) this.K).hasCutout() == false) goto L18;
        x();
        goto L18
    L10:
        if (this.J0 == false) goto L12;
        k(0.0f);
        goto L14
    }

    private int G(int r10, boolean r11) {
        int r12 = r10 + this.f3918j.getCompoundPaddingLeft();
        if (getPrefixText() == null) goto L7;
        if (r11 == false) goto L6;
        return r12;
    L6:
        return (r12 - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
    L7:
        return r12;
    }

    private int H(int r10, boolean r11) {
        int r12 = r10 - this.f3918j.getCompoundPaddingRight();
        if (getPrefixText() == null) goto L7;
        if (r11 == true) goto L6;
        return r12;
    L6:
        return r12 + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
    L7:
        return r12;
    }

    private boolean I() {
        if (this.f3915h0 == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void J() {
        TextView r10 = this.f3948y;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f3946x == false) goto L9;
        r10.setText(null);
        TransitionManager.beginDelayedTransition(this.f3907c, this.C);
        this.f3948y.setVisibility(4);
        return;
    }

    private boolean L() {
        if (this.f3937s0.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean P() {
        if (this.Q == 1) goto L5;
    L9:
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 16) goto L7;
        return true;
    L7:
        if (this.f3918j.getMinLines() > 1) goto L9;
        return true;
    }

    private void Q() {
        o();
        Z();
        E0();
        j0();
        j();
        if (this.Q == 0) goto L6;
        v0();
        return;
    }

    private void R() {
        if (A() == true) goto L5;
        return;
    L5:
        RectF r10 = this.f3908c0;
        this.H0.o(r10, this.f3918j.getWidth(), this.f3918j.getGravity());
        n(r10);
        r10.offset(-getPaddingLeft(), ((-getPaddingTop()) - (r10.height() / 2.0f)) + this.S);
        ((CutoutDrawable) this.K).setCutout(r10);
    }

    private void S() {
        if (A() == true) goto L5;
        return;
    L5:
        if (this.G0 == true) goto L9;
        x();
        R();
        return;
    }

    private static void T(@NonNull ViewGroup r10, boolean r11) {
        int r12 = r10.getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        View r14 = r10.getChildAt(r13);
        r14.setEnabled(r11);
        if ((r14 instanceof ViewGroup) == false) goto L7;
        T((ViewGroup) r14, r11);
    L7:
        r13 = r13 + 1;
        goto L3
    }

    private void X() {
        TextView r10 = this.f3948y;
        if (r10 == null) goto L6;
        r10.setVisibility(8);
        return;
    }

    private void Z() {
        if (g0() == false) goto L6;
        ViewCompat.setBackground(this.f3918j, this.K);
        return;
    }

    static /* synthetic */ boolean a(TextInputLayout r10) {
        return r10.M0;
    }

    private static void a0(@NonNull CheckableImageButton r10, @Nullable View.OnLongClickListener r11) {
        boolean r12 = ViewCompat.hasOnClickListeners(r10);
        boolean r13 = false;
        int r14 = 1;
        if (r11 == null) goto L5;
        boolean r15 = true;
    L6:
        if (r12 == true) goto L8;
        if (r15 == true) goto L8;
    L9:
        r10.setFocusable(r13);
        r10.setClickable(r12);
        r10.setPressable(r12);
        r10.setLongClickable(r15);
        if (r13 == true) goto L13;
        r14 = 2;
    L13:
        ViewCompat.setImportantForAccessibility(r10, r14);
        return;
    L8:
        r13 = true;
        goto L9
    L5:
        r15 = false;
        goto L6
    }

    static /* synthetic */ boolean b(TextInputLayout r10) {
        return r10.f3946x;
    }

    private static void b0(@NonNull CheckableImageButton r10, @Nullable View.OnClickListener r11, @Nullable View.OnLongClickListener r12) {
        r10.setOnClickListener(r11);
        a0(r10, r12);
    }

    static /* synthetic */ void c(TextInputLayout r10, int r11) {
        r10.A0(r11);
    }

    private static void c0(@NonNull CheckableImageButton r10, @Nullable View.OnLongClickListener r11) {
        r10.setOnLongClickListener(r11);
        a0(r10, r11);
    }

    static /* synthetic */ CheckableImageButton d(TextInputLayout r10) {
        return r10.f3919j0;
    }

    static /* synthetic */ h e(TextInputLayout r10) {
        return r10.f3912g;
    }

    private boolean e0() {
        if (this.f3937s0.getVisibility() == 0) goto L11;
        if (I() == false) goto L9;
        if (K() == true) goto L11;
    L9:
        if (this.F != null) goto L11;
    L13:
        return false;
    L11:
        if (this.f3914h.getMeasuredWidth() <= 0) goto L13;
        return true;
    }

    static /* synthetic */ com.google.android.material.textfield.e f(TextInputLayout r10) {
        return r10.f3930p;
    }

    private boolean f0() {
        if (getStartIconDrawable() != null) goto L9;
        if (getPrefixText() != null) goto L7;
    L11:
        return false;
    L7:
        if (getPrefixTextView().getVisibility() != 0) goto L11;
    L9:
        if (this.f3912g.getMeasuredWidth() <= 0) goto L11;
        return true;
    }

    private boolean g0() {
        EditText r10 = this.f3918j;
        if (r10 != null) goto L5;
    L11:
        return false;
    L5:
        if (this.K == null) goto L11;
        if (r10.getBackground() != null) goto L11;
        if (this.Q == 0) goto L11;
        return true;
    }

    private com.google.android.material.textfield.c getEndIconDelegate() {
        com.google.android.material.textfield.c r10 = this.f3917i0.get(this.f3915h0);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.f3917i0.get(0);
    }

    @Nullable
    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.f3937s0.getVisibility() != 0) goto L7;
        return this.f3937s0;
    L7:
        if (I() == true) goto L9;
        return null;
    L9:
        if (K() == true) goto L11;
        return null;
    L11:
        return this.f3919j0;
    }

    private void h0() {
        if (this.f3948y != null) goto L5;
        return;
    L5:
        if (this.f3946x == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.f3944w) == true) goto L14;
        this.f3948y.setText(this.f3944w);
        TransitionManager.beginDelayedTransition(this.f3907c, this.B);
        this.f3948y.setVisibility(0);
        this.f3948y.bringToFront();
        if (Build.VERSION.SDK_INT < 16) goto L15;
        announceForAccessibility(this.f3944w);
        return;
    L15:
        return;
    }

    private void i() {
        TextView r10 = this.f3948y;
        if (r10 == null) goto L6;
        this.f3907c.addView(r10);
        this.f3948y.setVisibility(0);
        return;
    }

    private void i0(boolean r10) {
        if (r10 == true) goto L4;
    L6:
        com.google.android.material.textfield.d.a(this, this.f3919j0, this.f3923l0, this.f3925m0);
        return;
    L4:
        if (getEndIconDrawable() == null) goto L6;
        Drawable r11 = DrawableCompat.wrap(getEndIconDrawable()).mutate();
        DrawableCompat.setTint(r11, this.f3930p.p());
        this.f3919j0.setImageDrawable(r11);
    }

    private void j() {
        if (this.f3918j != null) goto L5;
        return;
    L5:
        if (this.Q == 1) goto L8;
        return;
    L8:
        if (com.google.android.material.resources.c.j(getContext()) == false) goto L12;
        EditText r10 = this.f3918j;
        int r11 = ViewCompat.getPaddingStart(r10);
        int r12 = getResources().getDimensionPixelSize(q5.d.material_filled_edittext_font_2_0_padding_top);
        int r13 = ViewCompat.getPaddingEnd(this.f3918j);
        Resources r14 = getResources();
        int r15 = q5.d.material_filled_edittext_font_2_0_padding_bottom;
    L10:
        ViewCompat.setPaddingRelative(r10, r11, r12, r13, r14.getDimensionPixelSize(r15));
        return;
    L12:
        if (com.google.android.material.resources.c.i(getContext()) == false) goto L16;
        r10 = this.f3918j;
        r11 = ViewCompat.getPaddingStart(r10);
        r12 = getResources().getDimensionPixelSize(q5.d.material_filled_edittext_font_1_3_padding_top);
        r13 = ViewCompat.getPaddingEnd(this.f3918j);
        r14 = getResources();
        r15 = q5.d.material_filled_edittext_font_1_3_padding_bottom;
        goto L10
    }

    private void j0() {
        if (this.Q == 1) goto L5;
        return;
    L5:
        if (com.google.android.material.resources.c.j(getContext()) == false) goto L9;
        Resources r10 = getResources();
        int r11 = q5.d.material_font_2_0_box_collapsed_padding_top;
    L7:
        this.R = r10.getDimensionPixelSize(r11);
        return;
    L9:
        if (com.google.android.material.resources.c.i(getContext()) == false) goto L13;
        r10 = getResources();
        r11 = q5.d.material_font_1_3_box_collapsed_padding_top;
        goto L7
    }

    private void k0(@NonNull Rect r10) {
        MaterialShapeDrawable r11 = this.L;
        if (r11 == null) goto L5;
        int r12 = r10.bottom;
        int r13 = r12 - this.T;
        r11.setBounds(r10.left, r13, r10.right, r12);
    L5:
        MaterialShapeDrawable r14 = this.M;
        if (r14 == null) goto L9;
        int r15 = r10.bottom;
        int r16 = r15 - this.U;
        r14.setBounds(r10.left, r16, r10.right, r15);
        return;
    }

    private void l() {
        MaterialShapeDrawable r10 = this.K;
        if (r10 != null) goto L5;
        return;
    L5:
        l r11 = r10.getShapeAppearanceModel();
        l r12 = this.N;
        if (r11 == r12) goto L9;
        this.K.setShapeAppearanceModel(r12);
        p0();
    L9:
        if (v() == false) goto L11;
        this.K.setStroke(this.S, this.V);
    L11:
        int r13 = p();
        this.W = r13;
        this.K.setFillColor(ColorStateList.valueOf(r13));
        if (this.f3915h0 != 3) goto L14;
        this.f3918j.getBackground().invalidateSelf();
    L14:
        m();
        invalidate();
    }

    private void l0() {
        if (this.f3938t == null) goto L10;
        EditText r10 = this.f3918j;
        if (r10 != null) goto L7;
        int r11 = 0;
    L8:
        m0(r11);
        return;
    L7:
        r11 = r10.getText().length();
        goto L8
    }

    private void m() {
        if (this.L != null) goto L5;
        return;
    L5:
        if (this.M != null) goto L8;
        return;
    L8:
        if (w() == false) goto L14;
        MaterialShapeDrawable r10 = this.L;
        if (this.f3918j.isFocused() == false) goto L12;
        int r11 = this.f3947x0;
    L13:
        r10.setFillColor(ColorStateList.valueOf(r11));
        this.M.setFillColor(ColorStateList.valueOf(this.V));
        goto L14
    L12:
        r11 = this.V;
    L14:
        invalidate();
    }

    private void n(@NonNull RectF r10) {
        float r11 = r10.left;
        int r12 = this.P;
        r10.left = r11 - r12;
        r10.right += r12;
    }

    private static void n0(@NonNull Context r10, @NonNull TextView r11, int r12, int r13, boolean r14) {
        if (r14 == false) goto L4;
        int r15 = j.character_counter_overflowed_content_description;
    L5:
        r11.setContentDescription(r10.getString(r15, new Object[]{Integer.valueOf(r12), Integer.valueOf(r13)}));
        return;
    L4:
        r15 = j.character_counter_content_description;
        goto L5
    }

    private void o() {
        int r10 = this.Q;
        if (r10 != 0) goto L5;
        this.K = null;
    L19:
        this.L = null;
        this.M = null;
        return;
    L5:
        if (r10 != 1) goto L7;
        this.K = new MaterialShapeDrawable(this.N);
        this.L = new MaterialShapeDrawable();
        this.M = new MaterialShapeDrawable();
        return;
    L7:
        if (r10 != 2) goto L16;
        if (this.H == true) goto L11;
    L13:
        MaterialShapeDrawable r11 = new MaterialShapeDrawable(this.N);
    L14:
        this.K = r11;
        goto L19
    L11:
        if ((this.K instanceof CutoutDrawable) == true) goto L13;
        r11 = new CutoutDrawable(this.N);
        goto L14
    L16:
        throw new IllegalArgumentException(this.Q + " is illegal; only @BoxBackgroundMode constants are supported.");
    }

    private void o0() {
        TextView r10 = this.f3938t;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f3936s == false) goto L7;
        int r11 = this.f3940u;
    L8:
        d0(r10, r11);
        if (this.f3936s == true) goto L14;
        ColorStateList r12 = this.D;
        if (r12 == null) goto L14;
        this.f3938t.setTextColor(r12);
    L14:
        if (this.f3936s == false) goto L20;
        ColorStateList r13 = this.E;
        if (r13 == null) goto L21;
        this.f3938t.setTextColor(r13);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r11 = this.f3942v;
        goto L8
    }

    private int p() {
        int r10 = this.W;
        if (this.Q == 1) goto L5;
        return r10;
    L5:
        return t5.a.g(t5.a.e(this, q5.b.colorSurface, 0), this.W);
    }

    private void p0() {
        if (this.f3915h0 == 3) goto L5;
        return;
    L5:
        if (this.Q != 2) goto L9;
        ((DropdownMenuEndIconDelegate) this.f3917i0.get(3)).J((AutoCompleteTextView) this.f3918j);
        return;
    }

    @NonNull
    private Rect q(@NonNull Rect r10) {
        if (this.f3918j == null) goto L15;
        Rect r11 = this.f3906b0;
        boolean r12 = ViewUtils.i(this);
        r11.bottom = r10.bottom;
        int r13 = this.Q;
        if (r13 != 1) goto L7;
        r11.left = G(r10.left, r12);
        r11.top = r10.top + this.R;
        r11.right = H(r10.right, r12);
        return r11;
    L7:
        if (r13 == 2) goto L10;
        r11.left = G(r10.left, r12);
        r11.top = getPaddingTop();
        r11.right = H(r10.right, r12);
        return r11;
    L10:
        r11.left = r10.left + this.f3918j.getPaddingLeft();
        r11.top = r10.top - u();
        r11.right = r10.right - this.f3918j.getPaddingRight();
        return r11;
    L15:
        throw new IllegalStateException();
    }

    private int r(@NonNull Rect r10, @NonNull Rect r11, float r12) {
        if (P() == false) goto L7;
        return (int) (r11.top + r12);
    L7:
        return r10.bottom - this.f3918j.getCompoundPaddingBottom();
    }

    private int s(@NonNull Rect r10, float r11) {
        if (P() == false) goto L7;
        return (int) (r10.centerY() - (r11 / 2.0f));
    L7:
        return r10.top + this.f3918j.getCompoundPaddingTop();
    }

    private boolean s0() {
        if (this.f3918j != null) goto L5;
        return false;
    L5:
        int r10 = Math.max(this.f3914h.getMeasuredHeight(), this.f3912g.getMeasuredHeight());
        if (this.f3918j.getMeasuredHeight() >= r10) goto L9;
        this.f3918j.setMinimumHeight(r10);
        return true;
    L9:
        return false;
    }

    private void setEditText(EditText r10) {
        if (this.f3918j != null) goto L38;
        if (this.f3915h0 != 3) goto L7;
    L9:
        this.f3918j = r10;
        int r11 = this.f3922l;
        if (r11 == (-1)) goto L12;
        setMinEms(r11);
    L13:
        int r12 = this.f3924m;
        if (r12 == (-1)) goto L16;
        setMaxEms(r12);
    L17:
        Q();
        setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
        this.H0.H0(this.f3918j.getTypeface());
        this.H0.r0(this.f3918j.getTextSize());
        if (Build.VERSION.SDK_INT < 21) goto L20;
        this.H0.m0(this.f3918j.getLetterSpacing());
    L20:
        int r13 = this.f3918j.getGravity();
        this.H0.g0((r13 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 48);
        this.H0.q0(r13);
        this.f3918j.addTextChangedListener(new a(this));
        if (this.f3943v0 != null) goto L24;
        this.f3943v0 = this.f3918j.getHintTextColors();
    L24:
        if (this.H == false) goto L30;
        if (TextUtils.isEmpty(this.I) == false) goto L28;
        CharSequence r14 = this.f3918j.getHint();
        this.f3920k = r14;
        setHint(r14);
        this.f3918j.setHint(null);
    L28:
        this.f3904J = true;
    L30:
        if (this.f3938t == null) goto L32;
        m0(this.f3918j.getText().length());
    L32:
        r0();
        this.f3930p.f();
        this.f3912g.bringToFront();
        this.f3914h.bringToFront();
        this.f3916i.bringToFront();
        this.f3937s0.bringToFront();
        B();
        C0();
        if (isEnabled() == true) goto L35;
        r10.setEnabled(false);
    L35:
        x0(false, true);
        return;
    L16:
        setMaxWidth(this.f3928o);
        goto L17
    L12:
        setMinWidth(this.f3926n);
        goto L13
    L7:
        if ((r10 instanceof TextInputEditText) == true) goto L9;
        Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        goto L9
    L38:
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence r10) {
        if (TextUtils.equals(r10, this.I) == true) goto L8;
        this.I = r10;
        this.H0.F0(r10);
        if (this.G0 == true) goto L9;
        R();
        return;
    L9:
        return;
    }

    private void setPlaceholderTextEnabled(boolean r10) {
        if (this.f3946x != r10) goto L5;
        return;
    L5:
        if (r10 == false) goto L7;
        i();
    L8:
        this.f3946x = r10;
        return;
    L7:
        X();
        this.f3948y = null;
        goto L8
    }

    @NonNull
    private Rect t(@NonNull Rect r10) {
        if (this.f3918j == null) goto L7;
        Rect r11 = this.f3906b0;
        float r12 = this.H0.B();
        r11.left = r10.left + this.f3918j.getCompoundPaddingLeft();
        r11.top = s(r10, r12);
        r11.right = r10.right - this.f3918j.getCompoundPaddingRight();
        r11.bottom = r(r10, r11, r12);
        return r11;
    L7:
        throw new IllegalStateException();
    }

    private void t0() {
        FrameLayout r10 = this.f3916i;
        int r11 = 8;
        if (this.f3919j0.getVisibility() == 0) goto L5;
    L7:
        int r12 = 8;
    L8:
        r10.setVisibility(r12);
        if (this.F != null) goto L11;
    L13:
        char r13 = '\b';
    L15:
        if (K() == false) goto L17;
    L21:
        boolean r14 = true;
    L22:
        LinearLayout r15 = this.f3914h;
        if (r14 == false) goto L25;
        r11 = 0;
    L25:
        r15.setVisibility(r11);
        return;
    L17:
        if (L() == true) goto L21;
        if (r13 == 0) goto L21;
        r14 = false;
        goto L22
    L11:
        if (N() == true) goto L13;
        r13 = 0;
        goto L15
    L5:
        if (L() == true) goto L7;
        r12 = 0;
        goto L8
    }

    private int u() {
        if (this.H == true) goto L5;
        return 0;
    L5:
        int r10 = this.Q;
        if (r10 != 0) goto L8;
        float r11 = this.H0.r();
    L12:
        return (int) r11;
    L8:
        if (r10 == 2) goto L10;
        return 0;
    L10:
        r11 = this.H0.r() / 2.0f;
        goto L12
    }

    private void u0() {
        int r10 = 0;
        if (getErrorIconDrawable() != null) goto L5;
    L9:
        boolean r11 = false;
    L10:
        CheckableImageButton r12 = this.f3937s0;
        if (r11 == true) goto L14;
        r10 = 8;
    L14:
        r12.setVisibility(r10);
        t0();
        C0();
        if (I() == true) goto L18;
        q0();
        return;
    L18:
        return;
    L5:
        if (this.f3930p.z() == false) goto L9;
        if (this.f3930p.l() == false) goto L9;
        r11 = true;
        goto L10
    }

    private boolean v() {
        if (this.Q == 2) goto L5;
    L7:
        return false;
    L5:
        if (w() == false) goto L7;
        return true;
    }

    private void v0() {
        if (this.Q == 1) goto L8;
        LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) this.f3907c.getLayoutParams();
        int r11 = u();
        if (r11 == r10.topMargin) goto L9;
        r10.topMargin = r11;
        this.f3907c.requestLayout();
        return;
    L9:
        return;
    }

    private boolean w() {
        if (this.S > (-1)) goto L5;
    L7:
        return false;
    L5:
        if (this.V == 0) goto L7;
        return true;
    }

    private void x() {
        if (A() == false) goto L6;
        ((CutoutDrawable) this.K).removeCutout();
        return;
    }

    private void x0(boolean r10, boolean r11) {
        boolean r12 = isEnabled();
        EditText r13 = this.f3918j;
        if (r13 != null) goto L5;
    L7:
        boolean r14 = false;
    L8:
        EditText r15 = this.f3918j;
        if (r15 != null) goto L11;
    L13:
        boolean r16 = false;
    L14:
        boolean r17 = this.f3930p.l();
        ColorStateList r18 = this.f3943v0;
        if (r18 == null) goto L17;
        this.H0.f0(r18);
        this.H0.p0(this.f3943v0);
    L17:
        if (r12 == true) goto L23;
        ColorStateList r19 = this.f3943v0;
        if (r19 == null) goto L21;
        int r20 = r19.getColorForState(new int[]{-16842910}, this.F0);
    L22:
        this.H0.f0(ColorStateList.valueOf(r20));
        this.H0.p0(ColorStateList.valueOf(r20));
    L35:
        if (r14 == false) goto L37;
    L46:
        if (r11 == false) goto L48;
    L49:
        y(r10);
        return;
    L48:
        if (this.G0 == true) goto L49;
        return;
    L37:
        if (this.I0 == false) goto L46;
        if (isEnabled() == false) goto L42;
        if (r16 == true) goto L46;
    L42:
        if (r11 == false) goto L44;
    L45:
        F(r10);
        return;
    L44:
        if (this.G0 == false) goto L45;
        return;
    L21:
        r20 = this.F0;
        goto L22
    L23:
        if (r17 == false) goto L26;
        this.H0.f0(this.f3930p.q());
        goto L35
    L26:
        if (this.f3936s == false) goto L31;
        TextView r21 = this.f3938t;
        if (r21 == null) goto L31;
        com.google.android.material.internal.b r22 = this.H0;
        ColorStateList r23 = r21.getTextColors();
    L30:
        r22.f0(r23);
    L31:
        if (r16 == false) goto L35;
        r23 = this.f3945w0;
        if (r23 == null) goto L35;
        r22 = this.H0;
        goto L30
    L11:
        if (r15.hasFocus() == false) goto L13;
        r16 = true;
        goto L14
    L5:
        if (TextUtils.isEmpty(r13.getText()) == true) goto L7;
        r14 = true;
        goto L8
    }

    private void y(boolean r10) {
        ValueAnimator r11 = this.K0;
        if (r11 == null) goto L8;
        if (r11.isRunning() == false) goto L8;
        this.K0.cancel();
    L8:
        if (r10 == true) goto L10;
    L12:
        this.H0.u0(1.0f);
    L13:
        this.G0 = false;
        if (A() == false) goto L16;
        R();
    L16:
        z0();
        this.f3912g.i(false);
        D0();
        return;
    L10:
        if (this.J0 == false) goto L12;
        k(1.0f);
        goto L13
    }

    private void y0() {
        if (this.f3948y == null) goto L8;
        EditText r10 = this.f3918j;
        if (r10 == null) goto L9;
        int r11 = r10.getGravity();
        this.f3948y.setGravity(r11);
        this.f3948y.setPadding(this.f3918j.getCompoundPaddingLeft(), this.f3918j.getCompoundPaddingTop(), this.f3918j.getCompoundPaddingRight(), this.f3918j.getCompoundPaddingBottom());
        return;
    L9:
        return;
    }

    private Fade z() {
        Fade r10 = new Fade();
        r10.setDuration(87);
        r10.setInterpolator(r5.a.f12673a);
        return r10;
    }

    private void z0() {
        EditText r10 = this.f3918j;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        A0(r11);
        return;
    L5:
        r11 = r10.getText().length();
        goto L6
    }

    void E0() {
        if (this.K != null) goto L5;
        return;
    L5:
        if (this.Q == 0) goto L75;
        boolean r10 = false;
        if (isFocused() == true) goto L15;
        EditText r11 = this.f3918j;
        if (r11 != null) goto L12;
    L14:
        boolean r12 = false;
    L17:
        if (isHovered() == true) goto L22;
        EditText r13 = this.f3918j;
        if (r13 == null) goto L24;
        if (r13.isHovered() == true) goto L22;
    L24:
        if (isEnabled() == true) goto L28;
        int r14 = this.F0;
    L26:
        this.V = r14;
    L46:
        u0();
        V();
        W();
        U();
        if (getEndIconDelegate().d() == false) goto L50;
        i0(this.f3930p.l());
    L50:
        if (this.Q != 2) goto L61;
        int r15 = this.S;
        if (r12 == true) goto L54;
    L56:
        int r16 = this.T;
    L57:
        this.S = r16;
        if (this.S == r15) goto L61;
        S();
        goto L61
    L54:
        if (isEnabled() == false) goto L56;
        r16 = this.U;
    L61:
        if (this.Q == 1) goto L63;
    L72:
        l();
        return;
    L63:
        if (isEnabled() == true) goto L66;
        int r17 = this.C0;
    L65:
        this.W = r17;
        goto L72
    L66:
        if (r10 == false) goto L69;
        if (r12 == true) goto L69;
        r17 = this.E0;
    L69:
        if (r12 == false) goto L71;
        r17 = this.D0;
        goto L65
    L71:
        r17 = this.B0;
        goto L65
    L28:
        if (this.f3930p.l() == false) goto L34;
        if (this.A0 == null) goto L32;
    L31:
        B0(r12, r10);
        goto L46
    L32:
        r14 = this.f3930p.p();
        goto L26
    L34:
        if (this.f3936s == false) goto L41;
        TextView r18 = this.f3938t;
        if (r18 == null) goto L41;
        if (this.A0 != null) goto L31;
        r14 = r18.getCurrentTextColor();
    L41:
        if (r12 == false) goto L43;
        r14 = this.f3951z0;
        goto L26
    L43:
        if (r10 == false) goto L45;
        r14 = this.f3949y0;
        goto L26
    L45:
        r14 = this.f3947x0;
    L22:
        r10 = true;
        goto L24
    L12:
        if (r11.hasFocus() == false) goto L14;
    L15:
        r12 = true;
        goto L17
    }

    public boolean K() {
        if (this.f3916i.getVisibility() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f3919j0.getVisibility() != 0) goto L7;
        return true;
    }

    public boolean M() {
        return this.f3930p.A();
    }

    final boolean N() {
        return this.G0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean O() {
        return this.f3904J;
    }

    public void U() {
        com.google.android.material.textfield.d.c(this, this.f3919j0, this.f3923l0);
    }

    public void V() {
        com.google.android.material.textfield.d.c(this, this.f3937s0, this.f3939t0);
    }

    public void W() {
        this.f3912g.j();
    }

    public void Y(float r10, float r11, float r12, float r13) {
        boolean r14 = ViewUtils.i(this);
        this.O = r14;
        if (r14 == false) goto L5;
        float r15 = r11;
    L6:
        if (r14 == true) goto L9;
        r10 = r11;
    L9:
        if (r14 == false) goto L11;
        float r16 = r13;
    L12:
        if (r14 == true) goto L15;
        r12 = r13;
    L15:
        MaterialShapeDrawable r17 = this.K;
        if (r17 != null) goto L18;
    L25:
        this.N = this.N.v().E(r15).I(r10).v(r16).z(r12).m();
        l();
        return;
    L18:
        if (r17.getTopLeftCornerResolvedSize() != r15) goto L25;
        if (this.K.getTopRightCornerResolvedSize() != r10) goto L25;
        if (this.K.getBottomLeftCornerResolvedSize() != r16) goto L25;
        if (this.K.getBottomRightCornerResolvedSize() != r12) goto L25;
        return;
    L11:
        r16 = r12;
        goto L12
    L5:
        r15 = r10;
        goto L6
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View r10, int r11, @NonNull ViewGroup.LayoutParams r12) {
        if ((r10 instanceof EditText) == false) goto L5;
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(r12);
        r13.gravity = (r13.gravity & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 16;
        this.f3907c.addView(r10, r13);
        this.f3907c.setLayoutParams(r12);
        v0();
        setEditText((EditText) r10);
        return;
    L5:
        super.addView(r10, r11, r12);
    }

    void d0(@NonNull TextView r10, @StyleRes int r11) {
        boolean r12 = true;
        TextViewCompat.setTextAppearance(r10, r11);     // Catch: Exception -> L13
        if (Build.VERSION.SDK_INT < 23) goto L9;
        if (r10.getTextColors().getDefaultColor() == (-65281)) goto L10;
    L9:
        r12 = false;
    L10:
        if (r12 == false) goto L16;
        TextViewCompat.setTextAppearance(r10, k.TextAppearance_AppCompat_Caption);
        r10.setTextColor(ContextCompat.getColor(getContext(), q5.c.design_error));
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure r10, int r11) {
        EditText r12 = this.f3918j;
        if (r12 != null) goto L6;
        super.dispatchProvideAutofillStructure(r10, r11);
        return;
    L6:
        int r13 = 0;
        if (this.f3920k == null) goto L14;
        boolean r14 = this.f3904J;
        this.f3904J = false;
        CharSequence r15 = r12.getHint();
        this.f3918j.setHint(this.f3920k);
        super.dispatchProvideAutofillStructure(r10, r11);     // Catch: Throwable -> L11
        this.f3918j.setHint(r15);
        this.f3904J = r14;
        return;
    L11:
        th = move-exception;
        this.f3918j.setHint(r15);
        this.f3904J = r14;
        throw th;
    L14:
        r10.setAutofillId(getAutofillId());
        onProvideAutofillStructure(r10, r11);
        onProvideAutofillVirtualStructure(r10, r11);
        r10.setChildCount(this.f3907c.getChildCount());
    L16:
        if (r13 >= this.f3907c.getChildCount()) goto L27;
        View r16 = this.f3907c.getChildAt(r13);
        ViewStructure r17 = r10.newChild(r13);
        r16.dispatchProvideAutofillStructure(r17, r11);
        if (r16 != this.f3918j) goto L20;
        r17.setHint(getHint());
    L20:
        r13 = r13 + 1;
        goto L16
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> r10) {
        this.M0 = true;
        super.dispatchRestoreInstanceState(r10);
        this.M0 = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r10) {
        super.draw(r10);
        E(r10);
        D(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.L0 == false) goto L5;
        return;
    L5:
        boolean r10 = true;
        this.L0 = true;
        super.drawableStateChanged();
        int[] r11 = getDrawableState();
        com.google.android.material.internal.b r12 = this.H0;
        if (r12 == null) goto L8;
        boolean r13 = r12.E0(r11) | false;
    L10:
        if (this.f3918j != null) goto L12;
    L18:
        r0();
        E0();
        if (r13 == false) goto L21;
        invalidate();
    L21:
        this.L0 = false;
        return;
    L12:
        if (ViewCompat.isLaidOut(this) == true) goto L14;
    L16:
        r10 = false;
    L17:
        w0(r10);
        goto L18
    L14:
        if (isEnabled() == false) goto L16;
    L8:
        r13 = false;
        goto L10
    }

    public void g(@NonNull e r10) {
        this.f3913g0.add(r10);
        if (this.f3918j == null) goto L6;
        r10.a(this);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText r10 = this.f3918j;
        if (r10 == null) goto L7;
        return (r10.getBaseline() + getPaddingTop()) + u();
    L7:
        return super.getBaseline();
    }

    @NonNull
    MaterialShapeDrawable getBoxBackground() {
        int r10 = this.Q;
        if (r10 == 1) goto L10;
        if (r10 == 2) goto L10;
        throw new IllegalStateException();
    L10:
        return this.K;
    }

    public int getBoxBackgroundColor() {
        return this.W;
    }

    public int getBoxBackgroundMode() {
        return this.Q;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.R;
    }

    public float getBoxCornerRadiusBottomEnd() {
        if (ViewUtils.i(this) == false) goto L5;
        com.google.android.material.shape.c r10 = this.N.j();
    L7:
        return r10.a(this.f3908c0);
    L5:
        r10 = this.N.l();
        goto L7
    }

    public float getBoxCornerRadiusBottomStart() {
        if (ViewUtils.i(this) == false) goto L5;
        com.google.android.material.shape.c r10 = this.N.l();
    L7:
        return r10.a(this.f3908c0);
    L5:
        r10 = this.N.j();
        goto L7
    }

    public float getBoxCornerRadiusTopEnd() {
        if (ViewUtils.i(this) == false) goto L5;
        com.google.android.material.shape.c r10 = this.N.r();
    L7:
        return r10.a(this.f3908c0);
    L5:
        r10 = this.N.t();
        goto L7
    }

    public float getBoxCornerRadiusTopStart() {
        if (ViewUtils.i(this) == false) goto L5;
        com.google.android.material.shape.c r10 = this.N.t();
    L7:
        return r10.a(this.f3908c0);
    L5:
        r10 = this.N.r();
        goto L7
    }

    public int getBoxStrokeColor() {
        return this.f3951z0;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.A0;
    }

    public int getBoxStrokeWidth() {
        return this.T;
    }

    public int getBoxStrokeWidthFocused() {
        return this.U;
    }

    public int getCounterMaxLength() {
        return this.f3934r;
    }

    @Nullable
    CharSequence getCounterOverflowDescription() {
        if (this.f3932q == true) goto L5;
        return null;
    L5:
        if (this.f3936s == false) goto L12;
        TextView r10 = this.f3938t;
        if (r10 != null) goto L9;
        return null;
    L9:
        return r10.getContentDescription();
    L12:
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.D;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.D;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.f3943v0;
    }

    @Nullable
    public EditText getEditText() {
        return this.f3918j;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.f3919j0.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.f3919j0.getDrawable();
    }

    public int getEndIconMode() {
        return this.f3915h0;
    }

    @NonNull
    CheckableImageButton getEndIconView() {
        return this.f3919j0;
    }

    @Nullable
    public CharSequence getError() {
        if (this.f3930p.z() == true) goto L7;
        return null;
    L7:
        return this.f3930p.o();
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.f3930p.n();
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.f3930p.p();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.f3937s0.getDrawable();
    }

    @VisibleForTesting
    final int getErrorTextCurrentColor() {
        return this.f3930p.p();
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.f3930p.A() == true) goto L7;
        return null;
    L7:
        return this.f3930p.r();
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        return this.f3930p.t();
    }

    @Nullable
    public CharSequence getHint() {
        if (this.H == true) goto L7;
        return null;
    L7:
        return this.I;
    }

    @VisibleForTesting
    final float getHintCollapsedTextHeight() {
        return this.H0.r();
    }

    @VisibleForTesting
    final int getHintCurrentCollapsedTextColor() {
        return this.H0.v();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.f3945w0;
    }

    public int getMaxEms() {
        return this.f3924m;
    }

    @Px
    public int getMaxWidth() {
        return this.f3928o;
    }

    public int getMinEms() {
        return this.f3922l;
    }

    @Px
    public int getMinWidth() {
        return this.f3926n;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f3919j0.getContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f3919j0.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.f3946x == true) goto L7;
        return null;
    L7:
        return this.f3944w;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.A;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.f3950z;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.f3912g.a();
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.f3912g.b();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.f3912g.c();
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.f3912g.d();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.f3912g.e();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.F;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.G.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.G;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.f3909d0;
    }

    public void h(@NonNull f r10) {
        this.f3921k0.add(r10);
    }

    @VisibleForTesting
    void k(float r10) {
        if (this.H0.D() != r10) goto L6;
        return;
    L6:
        if (this.K0 != null) goto L8;
        ValueAnimator r11 = new ValueAnimator();
        this.K0 = r11;
        r11.setInterpolator(r5.a.f12674b);
        this.K0.setDuration(167);
        this.K0.addUpdateListener(new d(this));
    L8:
        this.K0.setFloatValues(new float[]{this.H0.D(), r10});
        this.K0.start();
    }

    void m0(int r10) {
        boolean r11 = this.f3936s;
        int r12 = this.f3934r;
        if (r12 != (-1)) goto L6;
        this.f3938t.setText(String.valueOf(r10));
        this.f3938t.setContentDescription(null);
        this.f3936s = false;
    L14:
        if (this.f3918j != null) goto L16;
        return;
    L16:
        if (r11 == this.f3936s) goto L20;
        w0(false);
        E0();
        r0();
        return;
    L20:
        return;
    L6:
        if (r10 <= r12) goto L8;
        boolean r13 = true;
    L9:
        this.f3936s = r13;
        n0(getContext(), this.f3938t, r10, this.f3934r, this.f3936s);
        if (r11 == this.f3936s) goto L12;
        o0();
    L12:
        this.f3938t.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(j.character_counter_pattern, new Object[]{Integer.valueOf(r10), Integer.valueOf(this.f3934r)})));
        goto L14
    L8:
        r13 = false;
        goto L9
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@NonNull Configuration r10) {
        super.onConfigurationChanged(r10);
        this.H0.V(r10);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        EditText r15 = this.f3918j;
        if (r15 == null) goto L12;
        Rect r16 = this.f3905a0;
        com.google.android.material.internal.d.a(this, r15, r16);
        k0(r16);
        if (this.H == false) goto L13;
        this.H0.r0(this.f3918j.getTextSize());
        int r17 = this.f3918j.getGravity();
        this.H0.g0((r17 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 48);
        this.H0.q0(r17);
        this.H0.c0(q(r16));
        this.H0.l0(t(r16));
        this.H0.Y();
        if (A() == true) goto L9;
        return;
    L9:
        if (this.G0 == true) goto L15;
        R();
        return;
    L15:
        return;
    L13:
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        boolean r12 = s0();
        boolean r13 = q0();
        if (r12 == true) goto L5;
        if (r13 == true) goto L5;
    L6:
        y0();
        C0();
        return;
    L5:
        this.f3918j.post(new c(this));
        goto L6
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        setError(r11.error);
        if (r11.isEndIconChecked == false) goto L9;
        this.f3919j0.post(new b(this));
    L9:
        setHint(r11.hintText);
        setHelperText(r11.helperText);
        setPlaceholderText(r11.placeholderText);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int r10) {
        super.onRtlPropertiesChanged(r10);
        boolean r11 = false;
        if (r10 != 1) goto L5;
        boolean r12 = true;
    L6:
        boolean r13 = this.O;
        if (r12 == r13) goto L24;
        if (r12 == false) goto L11;
        if (r13 == true) goto L11;
        r11 = true;
    L11:
        float r14 = this.N.r().a(this.f3908c0);
        float r15 = this.N.t().a(this.f3908c0);
        float r16 = this.N.j().a(this.f3908c0);
        float r17 = this.N.l().a(this.f3908c0);
        if (r11 == false) goto L14;
        float r18 = r14;
    L15:
        if (r11 == false) goto L17;
        r14 = r15;
    L17:
        if (r11 == false) goto L19;
        float r19 = r16;
    L20:
        if (r11 == false) goto L22;
        r16 = r17;
    L22:
        Y(r18, r14, r19, r16);
        return;
    L19:
        r19 = r17;
        goto L20
    L14:
        r18 = r15;
        goto L15
    L24:
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        if (this.f3930p.l() == false) goto L6;
        r10.error = getError();
    L6:
        if (I() == true) goto L8;
    L10:
        boolean r11 = false;
    L11:
        r10.isEndIconChecked = r11;
        r10.hintText = getHint();
        r10.helperText = getHelperText();
        r10.placeholderText = getPlaceholderText();
        return r10;
    L8:
        if (this.f3919j0.isChecked() == false) goto L10;
        r11 = true;
        goto L11
    }

    boolean q0() {
        if (this.f3918j != null) goto L5;
        return false;
    L5:
        boolean r10 = true;
        if (f0() == false) goto L16;
        int r11 = this.f3912g.getMeasuredWidth() - this.f3918j.getPaddingLeft();
        if (this.f3910e0 != null) goto L10;
    L11:
        ColorDrawable r12 = new ColorDrawable();
        this.f3910e0 = r12;
        this.f3911f0 = r11;
        r12.setBounds(0, 0, r11, 1);
    L12:
        Drawable[] r13 = TextViewCompat.getCompoundDrawablesRelative(this.f3918j);
        Drawable r14 = r13[0];
        Drawable r15 = this.f3910e0;
        if (r14 == r15) goto L19;
        TextViewCompat.setCompoundDrawablesRelative(this.f3918j, r15, r13[1], r13[2], r13[3]);
    L18:
        boolean r16 = true;
    L21:
        if (e0() == false) goto L37;
        int r17 = this.G.getMeasuredWidth() - this.f3918j.getPaddingRight();
        CheckableImageButton r18 = getEndIconToUpdateDummyDrawable();
        if (r18 == null) goto L25;
        r17 = (r17 + r18.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r18.getLayoutParams());
    L25:
        Drawable[] r19 = TextViewCompat.getCompoundDrawablesRelative(this.f3918j);
        Drawable r20 = this.f3927n0;
        if (r20 != null) goto L28;
    L30:
        if (r20 != null) goto L32;
        ColorDrawable r21 = new ColorDrawable();
        this.f3927n0 = r21;
        this.f3929o0 = r17;
        r21.setBounds(0, 0, r17, 1);
    L32:
        Drawable r22 = r19[2];
        Drawable r23 = this.f3927n0;
        if (r22 == r23) goto L35;
        this.f3931p0 = r19[2];
        TextViewCompat.setCompoundDrawablesRelative(this.f3918j, r19[0], r19[1], r23, r19[3]);
    L44:
        return r10;
    L35:
        r10 = r16;
        goto L44
    L28:
        if (this.f3929o0 == r17) goto L30;
        this.f3929o0 = r17;
        r20.setBounds(0, 0, r17, 1);
        TextViewCompat.setCompoundDrawablesRelative(this.f3918j, r19[0], r19[1], this.f3927n0, r19[3]);
        goto L44
    L37:
        if (this.f3927n0 == null) goto L45;
        Drawable[] r24 = TextViewCompat.getCompoundDrawablesRelative(this.f3918j);
        if (r24[2] != this.f3927n0) goto L41;
        TextViewCompat.setCompoundDrawablesRelative(this.f3918j, r24[0], r24[1], this.f3931p0, r24[3]);
    L42:
        this.f3927n0 = null;
        goto L44
    L41:
        r10 = r16;
        goto L42
    L45:
        return r16;
    L19:
        r16 = false;
        goto L21
    L10:
        if (this.f3911f0 == r11) goto L12;
    L16:
        if (this.f3910e0 == null) goto L19;
        Drawable[] r25 = TextViewCompat.getCompoundDrawablesRelative(this.f3918j);
        TextViewCompat.setCompoundDrawablesRelative(this.f3918j, null, r25[1], r25[2], r25[3]);
        this.f3910e0 = null;
        goto L18
    }

    void r0() {
        EditText r10 = this.f3918j;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.Q != 0) goto L26;
        Drawable r11 = r10.getBackground();
        if (r11 != null) goto L11;
        return;
    L11:
        if (DrawableUtils.canSafelyMutateDrawable(r11) == false) goto L14;
        r11 = r11.mutate();
    L14:
        if (this.f3930p.l() == false) goto L18;
        int r12 = this.f3930p.p();
    L16:
        r11.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(r12, PorterDuff.Mode.SRC_IN));
        return;
    L18:
        if (this.f3936s == false) goto L22;
        TextView r13 = this.f3938t;
        if (r13 == null) goto L22;
        r12 = r13.getCurrentTextColor();
    L22:
        DrawableCompat.clearColorFilter(r11);
        this.f3918j.refreshDrawableState();
        return;
    }

    public void setBoxBackgroundColor(@ColorInt int r10) {
        if (this.W == r10) goto L6;
        this.W = r10;
        this.B0 = r10;
        this.D0 = r10;
        this.E0 = r10;
        l();
        return;
    }

    public void setBoxBackgroundColorResource(@ColorRes int r10) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), r10));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList r10) {
        int r11 = r10.getDefaultColor();
        this.B0 = r11;
        this.W = r11;
        this.C0 = r10.getColorForState(new int[]{-16842910}, -1);
        this.D0 = r10.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.E0 = r10.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        l();
    }

    public void setBoxBackgroundMode(int r10) {
        if (r10 != this.Q) goto L5;
        return;
    L5:
        this.Q = r10;
        if (this.f3918j == null) goto L9;
        Q();
        return;
    }

    public void setBoxCollapsedPaddingTop(int r10) {
        this.R = r10;
    }

    public void setBoxStrokeColor(@ColorInt int r10) {
        if (this.f3951z0 == r10) goto L6;
        this.f3951z0 = r10;
        E0();
        return;
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList r10) {
        if (r10.isStateful() == false) goto L7;
        this.f3947x0 = r10.getDefaultColor();
        this.F0 = r10.getColorForState(new int[]{-16842910}, -1);
        this.f3949y0 = r10.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        int r11 = r10.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
    L5:
        this.f3951z0 = r11;
    L9:
        E0();
        return;
    L7:
        if (this.f3951z0 == r10.getDefaultColor()) goto L9;
        r11 = r10.getDefaultColor();
        goto L5
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList r10) {
        if (this.A0 == r10) goto L6;
        this.A0 = r10;
        E0();
        return;
    }

    public void setBoxStrokeWidth(int r10) {
        this.T = r10;
        E0();
    }

    public void setBoxStrokeWidthFocused(int r10) {
        this.U = r10;
        E0();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int r10) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(r10));
    }

    public void setBoxStrokeWidthResource(@DimenRes int r10) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(r10));
    }

    public void setCounterEnabled(boolean r10) {
        if (this.f3932q != r10) goto L5;
        return;
    L5:
        if (r10 == false) goto L10;
        AppCompatTextView r11 = new AppCompatTextView(getContext());
        this.f3938t = r11;
        r11.setId(q5.f.textinput_counter);
        Typeface r12 = this.f3909d0;
        if (r12 == null) goto L9;
        this.f3938t.setTypeface(r12);
    L9:
        this.f3938t.setMaxLines(1);
        this.f3930p.e(this.f3938t, 2);
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.f3938t.getLayoutParams(), getResources().getDimensionPixelOffset(q5.d.mtrl_textinput_counter_margin_start));
        o0();
        l0();
    L11:
        this.f3932q = r10;
        return;
    L10:
        this.f3930p.B(this.f3938t, 2);
        this.f3938t = null;
        goto L11
    }

    public void setCounterMaxLength(int r10) {
        if (this.f3934r == r10) goto L11;
        if (r10 > 0) goto L7;
        r10 = -1;
    L7:
        this.f3934r = r10;
        if (this.f3932q == false) goto L12;
        l0();
        return;
    L12:
        return;
    }

    public void setCounterOverflowTextAppearance(int r10) {
        if (this.f3940u == r10) goto L6;
        this.f3940u = r10;
        o0();
        return;
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList r10) {
        if (this.E == r10) goto L6;
        this.E = r10;
        o0();
        return;
    }

    public void setCounterTextAppearance(int r10) {
        if (this.f3942v == r10) goto L6;
        this.f3942v = r10;
        o0();
        return;
    }

    public void setCounterTextColor(@Nullable ColorStateList r10) {
        if (this.D == r10) goto L6;
        this.D = r10;
        o0();
        return;
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList r10) {
        this.f3943v0 = r10;
        this.f3945w0 = r10;
        if (this.f3918j == null) goto L6;
        w0(false);
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        T(this, r10);
        super.setEnabled(r10);
    }

    public void setEndIconActivated(boolean r10) {
        this.f3919j0.setActivated(r10);
    }

    public void setEndIconCheckable(boolean r10) {
        this.f3919j0.setCheckable(r10);
    }

    public void setEndIconContentDescription(@StringRes int r10) {
        if (r10 == 0) goto L4;
        CharSequence r11 = getResources().getText(r10);
    L5:
        setEndIconContentDescription(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setEndIconContentDescription(@Nullable CharSequence r10) {
        if (getEndIconContentDescription() == r10) goto L6;
        this.f3919j0.setContentDescription(r10);
        return;
    }

    public void setEndIconDrawable(@DrawableRes int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = AppCompatResources.getDrawable(getContext(), r10);
    L5:
        setEndIconDrawable(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setEndIconDrawable(@Nullable Drawable r10) {
        this.f3919j0.setImageDrawable(r10);
        if (r10 == null) goto L6;
        com.google.android.material.textfield.d.a(this, this.f3919j0, this.f3923l0, this.f3925m0);
        U();
        return;
    }

    public void setEndIconMode(int r10) {
        int r11 = this.f3915h0;
        if (r11 != r10) goto L5;
        return;
    L5:
        this.f3915h0 = r10;
        C(r11);
        if (r10 == 0) goto L8;
        boolean r12 = true;
    L9:
        setEndIconVisible(r12);
        if (getEndIconDelegate().b(this.Q) == false) goto L14;
        getEndIconDelegate().a();
        com.google.android.material.textfield.d.a(this, this.f3919j0, this.f3923l0, this.f3925m0);
        return;
    L14:
        throw new IllegalStateException("The current box background mode " + this.Q + " is not supported by the end icon mode " + r10);
    L8:
        r12 = false;
        goto L9
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener r10) {
        b0(this.f3919j0, r10, this.f3933q0);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener r10) {
        this.f3933q0 = r10;
        c0(this.f3919j0, r10);
    }

    public void setEndIconTintList(@Nullable ColorStateList r10) {
        if (this.f3923l0 == r10) goto L6;
        this.f3923l0 = r10;
        com.google.android.material.textfield.d.a(this, this.f3919j0, r10, this.f3925m0);
        return;
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode r10) {
        if (this.f3925m0 == r10) goto L6;
        this.f3925m0 = r10;
        com.google.android.material.textfield.d.a(this, this.f3919j0, this.f3923l0, r10);
        return;
    }

    public void setEndIconVisible(boolean r10) {
        if (K() == r10) goto L10;
        CheckableImageButton r11 = this.f3919j0;
        if (r10 == false) goto L7;
        int r12 = 0;
    L8:
        r11.setVisibility(r12);
        t0();
        C0();
        q0();
        return;
    L7:
        r12 = 8;
        goto L8
    }

    public void setError(@Nullable CharSequence r10) {
        if (this.f3930p.z() == false) goto L5;
    L8:
        boolean r11 = TextUtils.isEmpty(r10);
        com.google.android.material.textfield.e r12 = this.f3930p;
        if (r11 == true) goto L11;
        r12.O(r10);
        return;
    L11:
        r12.v();
        return;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return;
    L7:
        setErrorEnabled(true);
        goto L8
    }

    public void setErrorContentDescription(@Nullable CharSequence r10) {
        this.f3930p.D(r10);
    }

    public void setErrorEnabled(boolean r10) {
        this.f3930p.E(r10);
    }

    public void setErrorIconDrawable(@DrawableRes int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = AppCompatResources.getDrawable(getContext(), r10);
    L5:
        setErrorIconDrawable(r11);
        V();
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setErrorIconDrawable(@Nullable Drawable r10) {
        this.f3937s0.setImageDrawable(r10);
        u0();
        com.google.android.material.textfield.d.a(this, this.f3937s0, this.f3939t0, this.f3941u0);
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener r10) {
        b0(this.f3937s0, r10, this.f3935r0);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener r10) {
        this.f3935r0 = r10;
        c0(this.f3937s0, r10);
    }

    public void setErrorIconTintList(@Nullable ColorStateList r10) {
        if (this.f3939t0 == r10) goto L6;
        this.f3939t0 = r10;
        com.google.android.material.textfield.d.a(this, this.f3937s0, r10, this.f3941u0);
        return;
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode r10) {
        if (this.f3941u0 == r10) goto L6;
        this.f3941u0 = r10;
        com.google.android.material.textfield.d.a(this, this.f3937s0, this.f3939t0, r10);
        return;
    }

    public void setErrorTextAppearance(@StyleRes int r10) {
        this.f3930p.F(r10);
    }

    public void setErrorTextColor(@Nullable ColorStateList r10) {
        this.f3930p.G(r10);
    }

    public void setExpandedHintEnabled(boolean r10) {
        if (this.I0 == r10) goto L6;
        this.I0 = r10;
        w0(false);
        return;
    }

    public void setHelperText(@Nullable CharSequence r10) {
        if (TextUtils.isEmpty(r10) == false) goto L8;
        if (M() == false) goto L12;
        setHelperTextEnabled(false);
        return;
    L12:
        return;
    L8:
        if (M() == true) goto L10;
        setHelperTextEnabled(true);
    L10:
        this.f3930p.P(r10);
    }

    public void setHelperTextColor(@Nullable ColorStateList r10) {
        this.f3930p.J(r10);
    }

    public void setHelperTextEnabled(boolean r10) {
        this.f3930p.I(r10);
    }

    public void setHelperTextTextAppearance(@StyleRes int r10) {
        this.f3930p.H(r10);
    }

    public void setHint(@StringRes int r10) {
        if (r10 == 0) goto L4;
        CharSequence r11 = getResources().getText(r10);
    L5:
        setHint(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setHint(@Nullable CharSequence r10) {
        if (this.H == false) goto L6;
        setHintInternal(r10);
        sendAccessibilityEvent(2048);
        return;
    }

    public void setHintAnimationEnabled(boolean r10) {
        this.J0 = r10;
    }

    public void setHintEnabled(boolean r10) {
        if (r10 == this.H) goto L23;
        this.H = r10;
        if (r10 == true) goto L12;
        this.f3904J = false;
        if (TextUtils.isEmpty(this.I) == false) goto L9;
    L11:
        setHintInternal(null);
    L20:
        if (this.f3918j == null) goto L24;
        v0();
        return;
    L24:
        return;
    L9:
        if (TextUtils.isEmpty(this.f3918j.getHint()) == false) goto L11;
        this.f3918j.setHint(this.I);
        goto L11
    L12:
        CharSequence r11 = this.f3918j.getHint();
        if (TextUtils.isEmpty(r11) == false) goto L15;
    L18:
        this.f3904J = true;
        goto L20
    L15:
        if (TextUtils.isEmpty(this.I) == false) goto L17;
        setHint(r11);
    L17:
        this.f3918j.setHint(null);
        goto L18
    }

    public void setHintTextAppearance(@StyleRes int r10) {
        this.H0.d0(r10);
        this.f3945w0 = this.H0.p();
        if (this.f3918j == null) goto L6;
        w0(false);
        v0();
        return;
    }

    public void setHintTextColor(@Nullable ColorStateList r10) {
        if (this.f3945w0 != r10) goto L5;
        return;
    L5:
        if (this.f3943v0 != null) goto L7;
        this.H0.f0(r10);
    L7:
        this.f3945w0 = r10;
        if (this.f3918j == null) goto L12;
        w0(false);
        return;
    }

    public void setMaxEms(int r10) {
        this.f3924m = r10;
        EditText r11 = this.f3918j;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10 == (-1)) goto L9;
        r11.setMaxEms(r10);
        return;
    }

    public void setMaxWidth(@Px int r10) {
        this.f3928o = r10;
        EditText r11 = this.f3918j;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10 == (-1)) goto L9;
        r11.setMaxWidth(r10);
        return;
    }

    public void setMaxWidthResource(@DimenRes int r10) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(r10));
    }

    public void setMinEms(int r10) {
        this.f3922l = r10;
        EditText r11 = this.f3918j;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10 == (-1)) goto L9;
        r11.setMinEms(r10);
        return;
    }

    public void setMinWidth(@Px int r10) {
        this.f3926n = r10;
        EditText r11 = this.f3918j;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10 == (-1)) goto L9;
        r11.setMinWidth(r10);
        return;
    }

    public void setMinWidthResource(@DimenRes int r10) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(r10));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int r10) {
        if (r10 == 0) goto L4;
        CharSequence r11 = getResources().getText(r10);
    L5:
        setPasswordVisibilityToggleContentDescription(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence r10) {
        this.f3919j0.setContentDescription(r10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = AppCompatResources.getDrawable(getContext(), r10);
    L5:
        setPasswordVisibilityToggleDrawable(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable r10) {
        this.f3919j0.setImageDrawable(r10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean r10) {
        if (r10 == true) goto L4;
    L6:
        if (r10 == true) goto L10;
        setEndIconMode(0);
        return;
    L10:
        return;
    L4:
        if (this.f3915h0 == 1) goto L6;
        setEndIconMode(1);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList r10) {
        this.f3923l0 = r10;
        com.google.android.material.textfield.d.a(this, this.f3919j0, r10, this.f3925m0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode r10) {
        this.f3925m0 = r10;
        com.google.android.material.textfield.d.a(this, this.f3919j0, this.f3923l0, r10);
    }

    public void setPlaceholderText(@Nullable CharSequence r10) {
        if (this.f3948y != null) goto L6;
        AppCompatTextView r11 = new AppCompatTextView(getContext());
        this.f3948y = r11;
        r11.setId(q5.f.textinput_placeholder);
        ViewCompat.setImportantForAccessibility(this.f3948y, 2);
        Fade r12 = z();
        this.B = r12;
        r12.setStartDelay(67);
        this.C = z();
        setPlaceholderTextAppearance(this.A);
        setPlaceholderTextColor(this.f3950z);
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L9;
        setPlaceholderTextEnabled(false);
    L12:
        z0();
        return;
    L9:
        if (this.f3946x == true) goto L11;
        setPlaceholderTextEnabled(true);
    L11:
        this.f3944w = r10;
        goto L12
    }

    public void setPlaceholderTextAppearance(@StyleRes int r10) {
        this.A = r10;
        TextView r11 = this.f3948y;
        if (r11 == null) goto L6;
        TextViewCompat.setTextAppearance(r11, r10);
        return;
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList r10) {
        if (this.f3950z == r10) goto L9;
        this.f3950z = r10;
        TextView r11 = this.f3948y;
        if (r11 == null) goto L10;
        if (r10 == null) goto L11;
        r11.setTextColor(r10);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setPrefixText(@Nullable CharSequence r10) {
        this.f3912g.k(r10);
    }

    public void setPrefixTextAppearance(@StyleRes int r10) {
        this.f3912g.l(r10);
    }

    public void setPrefixTextColor(@NonNull ColorStateList r10) {
        this.f3912g.m(r10);
    }

    public void setStartIconCheckable(boolean r10) {
        this.f3912g.n(r10);
    }

    public void setStartIconContentDescription(@StringRes int r10) {
        if (r10 == 0) goto L4;
        CharSequence r11 = getResources().getText(r10);
    L5:
        setStartIconContentDescription(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setStartIconContentDescription(@Nullable CharSequence r10) {
        this.f3912g.o(r10);
    }

    public void setStartIconDrawable(@DrawableRes int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = AppCompatResources.getDrawable(getContext(), r10);
    L5:
        setStartIconDrawable(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setStartIconDrawable(@Nullable Drawable r10) {
        this.f3912g.p(r10);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener r10) {
        this.f3912g.q(r10);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener r10) {
        this.f3912g.r(r10);
    }

    public void setStartIconTintList(@Nullable ColorStateList r10) {
        this.f3912g.s(r10);
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode r10) {
        this.f3912g.t(r10);
    }

    public void setStartIconVisible(boolean r10) {
        this.f3912g.u(r10);
    }

    public void setSuffixText(@Nullable CharSequence r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        CharSequence r11 = null;
    L6:
        this.F = r11;
        this.G.setText(r10);
        D0();
        return;
    L5:
        r11 = r10;
        goto L6
    }

    public void setSuffixTextAppearance(@StyleRes int r10) {
        TextViewCompat.setTextAppearance(this.G, r10);
    }

    public void setSuffixTextColor(@NonNull ColorStateList r10) {
        this.G.setTextColor(r10);
    }

    public void setTextInputAccessibilityDelegate(@Nullable AccessibilityDelegate r10) {
        EditText r11 = this.f3918j;
        if (r11 == null) goto L6;
        ViewCompat.setAccessibilityDelegate(r11, r10);
        return;
    }

    public void setTypeface(@Nullable Typeface r10) {
        if (r10 == this.f3909d0) goto L8;
        this.f3909d0 = r10;
        this.H0.H0(r10);
        this.f3930p.L(r10);
        TextView r11 = this.f3938t;
        if (r11 == null) goto L9;
        r11.setTypeface(r10);
        return;
    L9:
        return;
    }

    void w0(boolean r10) {
        x0(r10, false);
    }
}
