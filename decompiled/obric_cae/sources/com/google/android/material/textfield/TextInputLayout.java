package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.v0;
import androidx.appcompat.widget.y;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.CheckableImageButton;
import com.ttnet.org.chromium.net.NetError;
import j0.h0;
import j0.w;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import pe.d0;

/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int[][] I0 = null;
    public int A;
    public boolean A0;
    public CharSequence B;
    public final com.google.android.material.internal.c B0;
    public boolean C;
    public boolean C0;
    public y D;
    public boolean D0;
    public ColorStateList E;
    public ValueAnimator E0;
    public int F;
    public boolean F0;
    public f1.d G;
    public boolean G0;
    public f1.d H;
    public boolean H0;
    public ColorStateList I;
    public ColorStateList J;
    public ColorStateList K;
    public ColorStateList L;
    public boolean M;
    public CharSequence N;
    public boolean O;
    public aa.f P;
    public aa.f Q;
    public StateListDrawable R;
    public boolean S;
    public aa.f T;
    public aa.f U;
    public aa.j V;
    public boolean W;
    public final int X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f4969a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f4970a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f4971b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f4972b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f4973c0;
    public int d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f4974e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final Rect f4975f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final Rect f4976g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final RectF f4977h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public Typeface f4978i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public ColorDrawable f4979j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f4980k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final LinkedHashSet<f> f4981l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final m f4982m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public ColorDrawable f4983m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public EditText f4984n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f4985n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f4986o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public Drawable f4987o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4988p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public ColorStateList f4989p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4990q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public ColorStateList f4991q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4992r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f4993r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f4994s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f4995s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final p f4996t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f4997t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f4998u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public ColorStateList f4999u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f5000v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f5001v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f5002w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f5003w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public e f5004x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f5005x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public y f5006y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f5007y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f5008z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f5009z0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public CharSequence f5010m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f5011n;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r8) {
                return new SavedState(r8, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r8) {
                return new SavedState[r8];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r8, ClassLoader r10) {
                return new SavedState(r8, r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r8, ClassLoader r10) {
            super(r8, r10);
            this.f5010m = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r8);
            boolean r11 = true;
            if (r8.readInt() == 1) goto L6;
            r11 = false;
        L6:
            this.f5011n = r11;
        }

        public final String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.f5010m + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeParcelable(this.f1731a, r10);
            TextUtils.writeToParcel(this.f5010m, r8, r10);
            r8.writeInt(this.f5011n ? 1 : 0);
        }
    }

    public class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f5012a;

        public a(TextInputLayout r8) {
            this.f5012a = r8;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r8) {
            TextInputLayout r10 = this.f5012a;
            r10.v(!r10.G0, false);
            if (r10.f4998u == false) goto L6;
            r10.o(r8);
        L6:
            if (r10.C == false) goto L9;
            r10.w(r8);
            return;
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r8, int r10, int r11, int r12) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r8, int r10, int r11, int r12) {
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f5013a;

        public b(TextInputLayout r8) {
            this.f5013a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CheckableImageButton r8 = this.f5013a.f4982m.f5055q;
            r8.performClick();
            r8.jumpDrawablesToCurrentState();
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f5014a;

        public c(TextInputLayout r8) {
            this.f5014a = r8;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r8) {
            this.f5014a.B0.k(((Float) r8.getAnimatedValue()).floatValue());
        }
    }

    public static class d extends j0.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextInputLayout f5015d;

        public d(TextInputLayout r8) {
            this.f5015d = r8;
        }

        @Override // j0.a
        public final void d(View r18, k0.f r19) {
            View.AccessibilityDelegate r8 = this.f8370a;
            AccessibilityNodeInfo r10 = r19.f8890a;
            r8.onInitializeAccessibilityNodeInfo(r18, r10);
            TextInputLayout r11 = this.f5015d;
            EditText r12 = r11.getEditText();
            if (r12 == null) goto L5;
            CharSequence r13 = r12.getText();
        L6:
            CharSequence r14 = r11.getHint();
            CharSequence r15 = r11.getError();
            CharSequence r16 = r11.getPlaceholderText();
            int r17 = r11.getCounterMaxLength();
            CharSequence r20 = r11.getCounterOverflowDescription();
            boolean r21 = !TextUtils.isEmpty(r13);
            boolean r110 = !TextUtils.isEmpty(r14);
            boolean r111 = !r11.A0;
            boolean r112 = !TextUtils.isEmpty(r15);
            if (r112 == false) goto L9;
        L12:
            boolean r113 = true;
        L13:
            if (r110 == false) goto L15;
            String r22 = r14.toString();
        L16:
            v r114 = r11.f4971b;
            y r115 = r114.f5124b;
            if (r115.getVisibility() != 0) goto L19;
            r10.setLabelFor(r115);
            r10.setTraversalAfter(r115);
        L20:
            if (r21 == false) goto L23;
            r19.k(r13);
        L31:
            if (TextUtils.isEmpty(r22) == true) goto L33;
            r10.setHintText(r22);
            r10.setShowingHintText(!r21);
        L33:
            if (r13 != null) goto L35;
        L37:
            r17 = -1;
        L38:
            r10.setMaxTextLength(r17);
            if (r113 == false) goto L44;
            if (r112 == true) goto L43;
            r15 = r20;
        L43:
            r10.setError(r15);
        L44:
            y r23 = r11.f4996t.f5100y;
            if (r23 == null) goto L47;
            r10.setLabelFor(r23);
        L47:
            r11.f4982m.b().n(r19);
            return;
        L35:
            if (r13.length() != r17) goto L37;
        L23:
            if (TextUtils.isEmpty(r22) == true) goto L28;
            r19.k(r22);
            if (r111 == false) goto L31;
            if (r16 == null) goto L31;
            r16 = r22 + ", " + r16;
        L29:
            r19.k(r16);
            goto L31
        L28:
            if (r16 == null) goto L31;
        L19:
            r10.setTraversalAfter(r114.f5126n);
            goto L20
        L15:
            r22 = "";
            goto L16
        L9:
            if (TextUtils.isEmpty(r20) == false) goto L12;
            r113 = false;
            goto L13
        L5:
            r13 = null;
            goto L6
        }

        @Override // j0.a
        public final void e(View r8, AccessibilityEvent r10) {
            super.e(r8, r10);
            this.f5015d.f4982m.b().o(r10);
        }
    }

    public interface e {
    }

    public interface f {
        void a(TextInputLayout r8);
    }

    public interface g {
        void a();
    }

    static {
        I0 = new int[][]{new int[]{R.attr.state_pressed}, new int[0]};
    }

    public TextInputLayout(Context r20, AttributeSet r21) {
        super(ea.a.a(r20, r21, com.obric.cae.R.attr.textInputStyle, com.obric.cae.R.style.Widget_Design_TextInputLayout), r21, com.obric.cae.R.attr.textInputStyle);
        this.f4988p = -1;
        this.f4990q = -1;
        this.f4992r = -1;
        this.f4994s = -1;
        this.f4996t = new p(this);
        this.f5004x = new o5.o(1);
        this.f4975f0 = new Rect();
        this.f4976g0 = new Rect();
        this.f4977h0 = new RectF();
        this.f4981l0 = new LinkedHashSet();
        com.google.android.material.internal.c r8 = new com.google.android.material.internal.c(this);
        this.B0 = r8;
        this.H0 = false;
        Context r13 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout r14 = new FrameLayout(r13);
        this.f4969a = r14;
        r14.setAddStatesFromChildren(true);
        LinearInterpolator r10 = h9.a.f7943a;
        r8.Q = r10;
        r8.h(false);
        r8.P = r10;
        r8.h(false);
        if (r8.f4836g == 8388659) goto L5;
        r8.f4836g = 8388659;
        r8.h(false);
    L5:
        int[] r15 = g9.a.B;
        com.google.android.material.internal.l.a(r13, r21, com.obric.cae.R.attr.textInputStyle, com.obric.cae.R.style.Widget_Design_TextInputLayout);
        com.google.android.material.internal.l.b(r13, r21, r15, com.obric.cae.R.attr.textInputStyle, com.obric.cae.R.style.Widget_Design_TextInputLayout, new int[]{22, 20, 40, 45, 49});
        TypedArray r11 = r13.obtainStyledAttributes(r21, r15, com.obric.cae.R.attr.textInputStyle, com.obric.cae.R.style.Widget_Design_TextInputLayout);
        v0 r12 = new v0(r13, r11);
        v r16 = new v(this, r12);
        this.f4971b = r16;
        this.M = r12.a(48, true);
        setHint(r12.k(4));
        this.D0 = r12.a(47, true);
        this.C0 = r12.a(42, true);
        if (r12.l(6) == false) goto L9;
        setMinEms(r12.h(6, -1));
    L12:
        if (r12.l(5) == false) goto L15;
        setMaxEms(r12.h(5, -1));
    L17:
        this.V = new aa.j(aa.j.b(r13, r21, com.obric.cae.R.attr.textInputStyle, com.obric.cae.R.style.Widget_Design_TextInputLayout));
        this.X = r13.getResources().getDimensionPixelOffset(com.obric.cae.R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.Z = r12.c(9, 0);
        this.f4972b0 = r12.d(16, r13.getResources().getDimensionPixelSize(com.obric.cae.R.dimen.mtrl_textinput_box_stroke_width_default));
        this.f4973c0 = r12.d(17, r13.getResources().getDimensionPixelSize(com.obric.cae.R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.f4970a0 = this.f4972b0;
        float r17 = r11.getDimension(13, -1.0f);
        float r18 = r11.getDimension(12, -1.0f);
        float r19 = r11.getDimension(10, -1.0f);
        float r22 = r11.getDimension(11, -1.0f);
        aa.j r23 = this.V;
        r23.getClass();
        aa.j.a r110 = new aa.j.a(r23);
        if (r17 < 0.0f) goto L21;
        r110.e(r17);
    L21:
        if (r18 < 0.0f) goto L24;
        r110.f(r18);
    L24:
        if (r19 < 0.0f) goto L27;
        r110.d(r19);
    L27:
        if (r22 < 0.0f) goto L29;
        r110.c(r22);
    L29:
        this.V = new aa.j(r110);
        ColorStateList r24 = x9.c.b(r13, r12, 7);
        if (r24 == null) goto L36;
        int r25 = r24.getDefaultColor();
        this.f5001v0 = r25;
        this.f4974e0 = r25;
        if (r24.isStateful() == false) goto L34;
        this.f5003w0 = r24.getColorForState(new int[]{-16842910}, -1);
        this.f5005x0 = r24.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        int r26 = r24.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
    L35:
        this.f5007y0 = r26;
    L38:
        if (r12.l(1) == false) goto L40;
        ColorStateList r27 = r12.b(1);
        this.f4991q0 = r27;
        this.f4989p0 = r27;
    L40:
        ColorStateList r28 = x9.c.b(r13, r12, 14);
        this.f4997t0 = r11.getColor(14, 0);
        Object r29 = androidx.core.content.a.f1674a;
        this.f4993r0 = androidx.core.content.a.c.a(r13, com.obric.cae.R.color.mtrl_textinput_default_box_stroke_color);
        this.f5009z0 = androidx.core.content.a.c.a(r13, com.obric.cae.R.color.mtrl_textinput_disabled_color);
        this.f4995s0 = androidx.core.content.a.c.a(r13, com.obric.cae.R.color.mtrl_textinput_hovered_box_stroke_color);
        if (r28 == null) goto L44;
        setBoxStrokeColorStateList(r28);
    L44:
        if (r12.l(15) == false) goto L47;
        setBoxStrokeErrorColor(x9.c.b(r13, r12, 15));
    L47:
        if (r12.i(49, -1) == (-1)) goto L49;
        setHintTextAppearance(r12.i(49, 0));
    L49:
        this.K = r12.b(24);
        this.L = r12.b(25);
        int r30 = r12.i(40, 0);
        CharSequence r31 = r12.k(35);
        int r32 = r12.h(34, 1);
        boolean r33 = r12.a(36, false);
        int r34 = r12.i(45, 0);
        boolean r35 = r12.a(44, false);
        CharSequence r111 = r12.k(43);
        int r112 = r12.i(57, 0);
        CharSequence r36 = r12.k(56);
        boolean r113 = r12.a(18, false);
        setCounterMaxLength(r12.h(19, -1));
        this.A = r12.i(22, 0);
        this.f5008z = r12.i(20, 0);
        setBoxBackgroundMode(r12.h(8, 0));
        setErrorContentDescription(r31);
        setErrorAccessibilityLiveRegion(r32);
        setCounterOverflowTextAppearance(this.f5008z);
        setHelperTextTextAppearance(r34);
        setErrorTextAppearance(r30);
        setCounterTextAppearance(this.A);
        setPlaceholderText(r36);
        setPlaceholderTextAppearance(r112);
        if (r12.l(41) == false) goto L53;
        setErrorTextColor(r12.b(41));
    L53:
        if (r12.l(46) == false) goto L56;
        setHelperTextColor(r12.b(46));
    L56:
        if (r12.l(50) == false) goto L59;
        setHintTextColor(r12.b(50));
    L59:
        if (r12.l(23) == false) goto L62;
        setCounterTextColor(r12.b(23));
    L62:
        if (r12.l(21) == false) goto L65;
        setCounterOverflowTextColor(r12.b(21));
    L65:
        if (r12.l(58) == false) goto L67;
        setPlaceholderTextColor(r12.b(58));
    L67:
        m r37 = new m(this, r12);
        this.f4982m = r37;
        boolean r38 = r12.a(0, true);
        r12.n();
        WeakHashMap<View, h0> r39 = w.f8437a;
        w.d.s(this, 2);
        w.k.l(this, 1);
        r14.addView(r16);
        r14.addView(r37);
        addView(r14);
        setEnabled(r38);
        setHelperTextEnabled(r35);
        setErrorEnabled(r33);
        setCounterEnabled(r113);
        setHelperText(r111);
        return;
    L34:
        this.f5005x0 = this.f5001v0;
        ColorStateList r40 = androidx.core.content.a.b(r13, com.obric.cae.R.color.mtrl_filled_background_color);
        this.f5003w0 = r40.getColorForState(new int[]{-16842910}, -1);
        r26 = r40.getColorForState(new int[]{R.attr.state_hovered}, -1);
        goto L35
    L36:
        this.f4974e0 = 0;
        this.f5001v0 = 0;
        this.f5003w0 = 0;
        this.f5005x0 = 0;
        this.f5007y0 = 0;
        goto L38
    L15:
        if (r12.l(2) == false) goto L17;
        setMaxWidth(r12.d(2, -1));
        goto L17
    L9:
        if (r12.l(3) == false) goto L12;
        setMinWidth(r12.d(3, -1));
        goto L12
    }

    public static /* synthetic */ int a(Editable r8) {
        if (r8 != null) goto L6;
        return 0;
    L6:
        return r8.length();
    }

    private Drawable getEditTextBoxBackground() {
        EditText r8 = this.f4984n;
        if ((r8 instanceof AutoCompleteTextView) == false) goto L24;
        if (r8.getInputType() == 0) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == true) goto L24;
        int r11 = t2.b.z(this.f4984n, com.obric.cae.R.attr.colorControlHighlight);
        int r12 = this.Y;
        int[][] r13 = I0;
        if (r12 != 2) goto L18;
        Context r14 = getContext();
        aa.f r15 = this.P;
        TypedValue r16 = x9.b.c(r14, com.obric.cae.R.attr.colorSurface, "TextInputLayout");
        int r17 = r16.resourceId;
        if (r17 == 0) goto L15;
        Object r18 = androidx.core.content.a.f1674a;
        int r19 = androidx.core.content.a.c.a(r14, r17);
    L16:
        aa.f r20 = new aa.f(r15.f139a.f156a);
        int r21 = t2.b.K(0.1f, r11, r19);
        r20.k(new ColorStateList(r13, new int[]{r21, 0}));
        r20.setTint(r19);
        ColorStateList r22 = new ColorStateList(r13, new int[]{r21, r19});
        aa.f r23 = new aa.f(r15.f139a.f156a);
        r23.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(r22, r20, r23), r15});
    L15:
        r19 = r16.data;
        goto L16
    L18:
        if (r12 != 1) goto L21;
        aa.f r24 = this.P;
        int r25 = this.f4974e0;
        return new RippleDrawable(new ColorStateList(r13, new int[]{t2.b.K(0.1f, r11, r25), r25}), r24, r24);
    L21:
        return null;
    L7:
        r10 = false;
    L24:
        return this.P;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.R != null) goto L6;
        StateListDrawable r8 = new StateListDrawable();
        this.R = r8;
        r8.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
        this.R.addState(new int[0], g(false));
    L6:
        return this.R;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.Q != null) goto L6;
        this.Q = g(true);
    L6:
        return this.Q;
    }

    public static void l(ViewGroup r8, boolean r10) {
        int r11 = r8.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        View r13 = r8.getChildAt(r12);
        r13.setEnabled(r10);
        if ((r13 instanceof ViewGroup) == false) goto L7;
        l((ViewGroup) r13, r10);
    L7:
        r12 = r12 + 1;
        goto L3
    }

    private void setEditText(EditText r8) {
        if (this.f4984n != null) goto L51;
        if (getEndIconMode() != 3) goto L7;
    L9:
        this.f4984n = r8;
        int r10 = this.f4988p;
        if (r10 == (-1)) goto L12;
        setMinEms(r10);
    L13:
        int r11 = this.f4990q;
        if (r11 == (-1)) goto L16;
        setMaxEms(r11);
    L17:
        this.S = false;
        j();
        setTextInputAccessibilityDelegate(new d(this));
        Typeface r12 = this.f4984n.getTypeface();
        com.google.android.material.internal.c r13 = this.B0;
        r13.m(r12);
        float r14 = this.f4984n.getTextSize();
        if (r13.f4837h == r14) goto L20;
        r13.f4837h = r14;
        r13.h(false);
    L20:
        float r15 = this.f4984n.getLetterSpacing();
        if (r13.W == r15) goto L23;
        r13.W = r15;
        r13.h(false);
    L23:
        int r16 = this.f4984n.getGravity();
        int r17 = (r16 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 48;
        if (r13.f4836g == r17) goto L27;
        r13.f4836g = r17;
        r13.h(false);
    L27:
        if (r13.f4834f == r16) goto L29;
        r13.f4834f = r16;
        r13.h(false);
    L29:
        this.f4984n.addTextChangedListener(new a(this));
        if (this.f4989p0 != null) goto L33;
        this.f4989p0 = this.f4984n.getHintTextColors();
    L33:
        if (this.M == true) goto L35;
    L38:
        q();
        if (this.f5006y == null) goto L41;
        o(this.f4984n.getText());
    L41:
        s();
        this.f4996t.b();
        this.f4971b.bringToFront();
        m r18 = this.f4982m;
        r18.bringToFront();
        Iterator<f> r19 = this.f4981l0.iterator();
    L43:
        if (r19.hasNext() == false) goto L45;
        r19.next().a(this);
        goto L43
    L45:
        r18.m();
        if (isEnabled() == true) goto L48;
        r8.setEnabled(false);
    L48:
        v(false, true);
        return;
    L35:
        if (TextUtils.isEmpty(this.N) == false) goto L37;
        CharSequence r20 = this.f4984n.getHint();
        this.f4986o = r20;
        setHint(r20);
        this.f4984n.setHint(null);
    L37:
        this.O = true;
        goto L38
    L16:
        setMaxWidth(this.f4994s);
        goto L17
    L12:
        setMinWidth(this.f4992r);
        goto L13
    L7:
        if ((r8 instanceof TextInputEditText) == true) goto L9;
        Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        goto L9
    L51:
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence r8) {
        if (TextUtils.equals(r8, this.N) == true) goto L16;
        this.N = r8;
        com.google.android.material.internal.c r10 = this.B0;
        if (r8 != null) goto L7;
    L8:
        r10.A = r8;
        r10.B = null;
        Bitmap r11 = r10.E;
        if (r11 == null) goto L11;
        r11.recycle();
        r10.E = null;
    L11:
        r10.h(false);
    L13:
        if (this.A0 == true) goto L17;
        k();
        return;
    L17:
        return;
    L7:
        if (TextUtils.equals(r10.A, r8) == true) goto L13;
    }

    private void setPlaceholderTextEnabled(boolean r8) {
        if (this.C != r8) goto L5;
        return;
    L5:
        if (r8 == false) goto L9;
        y r10 = this.D;
        if (r10 == null) goto L13;
        this.f4969a.addView(r10);
        this.D.setVisibility(0);
    L13:
        this.C = r8;
        return;
    L9:
        y r11 = this.D;
        if (r11 == null) goto L12;
        r11.setVisibility(8);
    L12:
        this.D = null;
        goto L13
    }

    @Override // android.view.ViewGroup
    public final void addView(View r8, int r10, ViewGroup.LayoutParams r11) {
        if ((r8 instanceof EditText) == false) goto L5;
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(r11);
        r12.gravity = (r12.gravity & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 16;
        FrameLayout r13 = this.f4969a;
        r13.addView(r8, r12);
        r13.setLayoutParams(r11);
        u();
        setEditText((EditText) r8);
        return;
    L5:
        super.addView(r8, r10, r11);
    }

    public final void b(float r8) {
        com.google.android.material.internal.c r10 = this.B0;
        if (r10.f4827b != r8) goto L6;
        return;
    L6:
        if (this.E0 != null) goto L8;
        ValueAnimator r11 = new ValueAnimator();
        this.E0 = r11;
        r11.setInterpolator(v9.d.d(getContext(), com.obric.cae.R.attr.motionEasingEmphasizedInterpolator, h9.a.f7944b));
        this.E0.setDuration(v9.d.c(getContext(), com.obric.cae.R.attr.motionDurationMedium4, 167));
        this.E0.addUpdateListener(new c(this));
    L8:
        this.E0.setFloatValues(new float[]{r10.f4827b, r8});
        this.E0.start();
    }

    public final void c() {
        aa.f r8 = this.P;
        if (r8 != null) goto L5;
        return;
    L5:
        aa.j r10 = r8.f139a.f156a;
        aa.j r11 = this.V;
        if (r10 == r11) goto L8;
        r8.setShapeAppearanceModel(r11);
    L8:
        boolean r12 = false;
        if (this.Y == 2) goto L11;
    L18:
        boolean r13 = false;
    L19:
        if (r13 == false) goto L23;
        aa.f r14 = this.P;
        float r15 = this.f4970a0;
        int r16 = this.d0;
        r14.f139a.f166k = r15;
        r14.invalidateSelf();
        ColorStateList r17 = ColorStateList.valueOf(r16);
        aa.f.b r18 = r14.f139a;
        if (r18.f159d == r17) goto L23;
        r18.f159d = r17;
        r14.onStateChange(r14.getState());
    L23:
        int r19 = this.f4974e0;
        if (this.Y != 1) goto L26;
        r19 = a0.a.c(this.f4974e0, t2.b.y(getContext(), com.obric.cae.R.attr.colorSurface, 0));
    L26:
        this.f4974e0 = r19;
        this.P.k(ColorStateList.valueOf(r19));
        aa.f r20 = this.T;
        if (r20 != null) goto L29;
    L43:
        t();
        return;
    L29:
        if (this.U == null) goto L43;
        if (this.f4970a0 > (-1)) goto L34;
    L36:
        if (r12 == true) goto L38;
    L42:
        invalidate();
        goto L43
    L38:
        if (this.f4984n.isFocused() == false) goto L40;
        int r21 = this.f4993r0;
    L41:
        r20.k(ColorStateList.valueOf(r21));
        this.U.k(ColorStateList.valueOf(this.d0));
        goto L42
    L40:
        r21 = this.d0;
        goto L41
    L34:
        if (this.d0 == 0) goto L36;
        r12 = true;
        goto L36
    L11:
        if (this.f4970a0 > (-1)) goto L13;
    L15:
        boolean r22 = false;
    L16:
        if (r22 == false) goto L18;
        r13 = true;
        goto L19
    L13:
        if (this.d0 == 0) goto L15;
        r22 = true;
        goto L16
    }

    public final int d() {
        if (this.M == true) goto L5;
        return 0;
    L5:
        int r8 = this.Y;
        com.google.android.material.internal.c r10 = this.B0;
        if (r8 != 0) goto L8;
        float r11 = r10.d();
    L12:
        return (int) r11;
    L8:
        if (r8 == 2) goto L10;
        return 0;
    L10:
        r11 = r10.d() / 2.0f;
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public final void dispatchProvideAutofillStructure(ViewStructure r8, int r10) {
        EditText r11 = this.f4984n;
        if (r11 != null) goto L6;
        super.dispatchProvideAutofillStructure(r8, r10);
        return;
    L6:
        int r12 = 0;
        if (this.f4986o == null) goto L14;
        boolean r13 = this.O;
        this.O = false;
        CharSequence r14 = r11.getHint();
        this.f4984n.setHint(this.f4986o);
        super.dispatchProvideAutofillStructure(r8, r10);     // Catch: Throwable -> L11
        this.f4984n.setHint(r14);
        this.O = r13;
        return;
    L11:
        th = move-exception;
        this.f4984n.setHint(r14);
        this.O = r13;
        throw th;
    L14:
        r8.setAutofillId(getAutofillId());
        onProvideAutofillStructure(r8, r10);
        onProvideAutofillVirtualStructure(r8, r10);
        FrameLayout r15 = this.f4969a;
        r8.setChildCount(r15.getChildCount());
    L16:
        if (r12 >= r15.getChildCount()) goto L27;
        View r16 = r15.getChildAt(r12);
        ViewStructure r17 = r8.newChild(r12);
        r16.dispatchProvideAutofillStructure(r17, r10);
        if (r16 != this.f4984n) goto L20;
        r17.setHint(getHint());
    L20:
        r12 = r12 + 1;
        goto L16
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> r8) {
        this.G0 = true;
        super.dispatchRestoreInstanceState(r8);
        this.G0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas r14) {
        super.draw(r14);
        boolean r8 = this.M;
        com.google.android.material.internal.c r10 = this.B0;
        if (r8 == false) goto L26;
        r10.getClass();
        int r11 = r14.save();
        if (r10.B == null) goto L26;
        RectF r12 = r10.f4832e;
        if (r12.width() <= 0.0f) goto L26;
        if (r12.height() <= 0.0f) goto L26;
        TextPaint r13 = r10.N;
        r13.setTextSize(r10.G);
        float r15 = r10.f4845p;
        float r16 = r10.f4846q;
        float r17 = r10.F;
        if (r17 == 1.0f) goto L13;
        r14.scale(r17, r17, r15, r16);
    L13:
        boolean r18 = true;
        if (r10.d0 > 1) goto L16;
    L17:
        r18 = false;
    L18:
        if (r18 == false) goto L23;
        float r19 = r10.f4845p - r10.Y.getLineStart(0);
        int r110 = r13.getAlpha();
        r14.translate(r19, r16);
        float r20 = r110;
        r13.setAlpha((int) (r10.f4828b0 * r20));
        float r21 = r10.H;
        float r22 = r10.I;
        float r23 = r10.J;
        int r24 = r10.K;
        r13.setShadowLayer(r21, r22, r23, a0.a.d(r24, (Color.alpha(r24) * r13.getAlpha()) / 255));
        r10.Y.draw(r14);
        r13.setAlpha((int) (r10.f4826a0 * r20));
        float r25 = r10.H;
        float r26 = r10.I;
        float r27 = r10.J;
        int r28 = r10.K;
        r13.setShadowLayer(r25, r26, r27, a0.a.d(r28, (Color.alpha(r28) * r13.getAlpha()) / 255));
        int r29 = r10.Y.getLineBaseline(0);
        CharSequence r30 = r10.f4830c0;
        float r111 = r29;
        r14.drawText(r30, 0, r30.length(), 0.0f, r111, r13);
        r13.setShadowLayer(r10.H, r10.I, r10.J, r10.K);
        String r31 = r10.f4830c0.toString().trim();
        if (r31.endsWith("…") == false) goto L22;
        r31 = r31.substring(0, r31.length() - 1);
    L22:
        String r32 = r31;
        r13.setAlpha(r110);
        r14.drawText(r32, 0, Math.min(r10.Y.getLineEnd(0), r32.length()), 0.0f, r111, r13);
    L24:
        r14.restoreToCount(r11);
        goto L26
    L23:
        r14.translate(r15, r16);
        r10.Y.draw(r14);
        goto L24
    L16:
        if (r10.C == false) goto L18;
    L26:
        if (this.U == null) goto L33;
        aa.f r33 = this.T;
        if (r33 == null) goto L34;
        r33.draw(r14);
        if (this.f4984n.isFocused() == false) goto L35;
        Rect r34 = this.U.getBounds();
        Rect r35 = this.T.getBounds();
        float r36 = r10.f4827b;
        int r37 = r35.centerX();
        int r38 = r35.left;
        LinearInterpolator r39 = h9.a.f7943a;
        r34.left = Math.round((r38 - r37) * r36) + r37;
        r34.right = Math.round(r36 * (r35.right - r37)) + r37;
        this.U.draw(r14);
        return;
    L35:
        return;
    L34:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.F0 == false) goto L5;
        return;
    L5:
        boolean r8 = true;
        this.F0 = true;
        super.drawableStateChanged();
        int[] r10 = getDrawableState();
        com.google.android.material.internal.c r11 = this.B0;
        if (r11 == null) goto L21;
        r11.L = r10;
        ColorStateList r12 = r11.f4840k;
        if (r12 != null) goto L10;
    L11:
        ColorStateList r13 = r11.f4839j;
        if (r13 != null) goto L14;
    L16:
        boolean r14 = false;
    L17:
        if (r14 == false) goto L19;
        r11.h(false);
        boolean r15 = true;
    L20:
        boolean r16 = r15 | false;
    L23:
        if (this.f4984n == null) goto L31;
        WeakHashMap<View, h0> r17 = w.f8437a;
        if (w.g.c(this) == true) goto L27;
    L29:
        r8 = false;
    L30:
        v(r8, false);
        goto L31
    L27:
        if (isEnabled() == false) goto L29;
    L31:
        s();
        y();
        if (r16 == false) goto L34;
        invalidate();
    L34:
        this.F0 = false;
        return;
    L19:
        r15 = false;
        goto L20
    L14:
        if (r13.isStateful() == false) goto L16;
    L15:
        r14 = true;
        goto L17
    L10:
        if (r12.isStateful() == true) goto L15;
    L21:
        r16 = false;
        goto L23
    }

    public final f1.d e() {
        f1.d r8 = new f1.d();
        r8.f7264m = v9.d.c(getContext(), com.obric.cae.R.attr.motionDurationShort2, 87);
        r8.f7265n = v9.d.d(getContext(), com.obric.cae.R.attr.motionEasingLinearInterpolator, h9.a.f7943a);
        return r8;
    }

    public final boolean f() {
        if (this.M == true) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(this.N) == true) goto L9;
        if ((this.P instanceof h) == false) goto L9;
        return true;
    }

    public final aa.f g(boolean r8) {
        float r10 = getResources().getDimensionPixelOffset(com.obric.cae.R.dimen.mtrl_shape_corner_size_small_component);
        if (r8 == false) goto L5;
        float r11 = r10;
    L6:
        EditText r12 = this.f4984n;
        if ((r12 instanceof s) == false) goto L9;
        float r13 = ((s) r12).getPopupElevation();
    L10:
        int r14 = getResources().getDimensionPixelOffset(com.obric.cae.R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        aa.j.a r15 = new aa.j.a();
        r15.e(r11);
        r15.f(r11);
        r15.c(r10);
        r15.d(r10);
        aa.j r16 = new aa.j(r15);
        EditText r17 = this.f4984n;
        if ((r17 instanceof s) == false) goto L13;
        ColorStateList r18 = ((s) r17).getDropDownBackgroundTintList();
    L14:
        Context r19 = getContext();
        if (r18 != null) goto L21;
        Paint r20 = aa.f.H;
        TypedValue r21 = x9.b.c(r19, com.obric.cae.R.attr.colorSurface, aa.f.class.getSimpleName());
        int r22 = r21.resourceId;
        if (r22 == 0) goto L19;
        Object r23 = androidx.core.content.a.f1674a;
        int r24 = androidx.core.content.a.c.a(r19, r22);
    L20:
        r18 = ColorStateList.valueOf(r24);
        goto L21
    L19:
        r24 = r21.data;
    L21:
        aa.f r25 = new aa.f();
        r25.i(r19);
        r25.k(r18);
        r25.j(r13);
        r25.setShapeAppearanceModel(r16);
        aa.f.b r26 = r25.f139a;
        if (r26.f163h != null) goto L24;
        r26.f163h = new Rect();
    L24:
        r25.f139a.f163h.set(0, r14, 0, r14);
        r25.invalidateSelf();
        return r25;
    L13:
        r18 = null;
        goto L14
    L9:
        r13 = getResources().getDimensionPixelOffset(com.obric.cae.R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        goto L10
    L5:
        r11 = 0.0f;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText r8 = this.f4984n;
        if (r8 == null) goto L7;
        int r10 = r8.getBaseline();
        int r11 = getPaddingTop() + r10;
        return d() + r11;
    L7:
        return super.getBaseline();
    }

    public aa.f getBoxBackground() {
        int r8 = this.Y;
        if (r8 == 1) goto L10;
        if (r8 == 2) goto L10;
        throw new IllegalStateException();
    L10:
        return this.P;
    }

    public int getBoxBackgroundColor() {
        return this.f4974e0;
    }

    public int getBoxBackgroundMode() {
        return this.Y;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.Z;
    }

    public float getBoxCornerRadiusBottomEnd() {
        boolean r8 = com.google.android.material.internal.q.a(this);
        RectF r10 = this.f4977h0;
        aa.j r11 = this.V;
        if (r8 == false) goto L5;
        aa.c r12 = r11.f187h;
    L7:
        return r12.a(r10);
    L5:
        r12 = r11.f186g;
        goto L7
    }

    public float getBoxCornerRadiusBottomStart() {
        boolean r8 = com.google.android.material.internal.q.a(this);
        RectF r10 = this.f4977h0;
        aa.j r11 = this.V;
        if (r8 == false) goto L5;
        aa.c r12 = r11.f186g;
    L7:
        return r12.a(r10);
    L5:
        r12 = r11.f187h;
        goto L7
    }

    public float getBoxCornerRadiusTopEnd() {
        boolean r8 = com.google.android.material.internal.q.a(this);
        RectF r10 = this.f4977h0;
        aa.j r11 = this.V;
        if (r8 == false) goto L5;
        aa.c r12 = r11.f184e;
    L7:
        return r12.a(r10);
    L5:
        r12 = r11.f185f;
        goto L7
    }

    public float getBoxCornerRadiusTopStart() {
        boolean r8 = com.google.android.material.internal.q.a(this);
        RectF r10 = this.f4977h0;
        aa.j r11 = this.V;
        if (r8 == false) goto L5;
        aa.c r12 = r11.f185f;
    L7:
        return r12.a(r10);
    L5:
        r12 = r11.f184e;
        goto L7
    }

    public int getBoxStrokeColor() {
        return this.f4997t0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f4999u0;
    }

    public int getBoxStrokeWidth() {
        return this.f4972b0;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f4973c0;
    }

    public int getCounterMaxLength() {
        return this.f5000v;
    }

    public CharSequence getCounterOverflowDescription() {
        if (this.f4998u == true) goto L5;
        return null;
    L5:
        if (this.f5002w == false) goto L12;
        y r8 = this.f5006y;
        if (r8 != null) goto L9;
        return null;
    L9:
        return r8.getContentDescription();
    L12:
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.J;
    }

    public ColorStateList getCounterTextColor() {
        return this.I;
    }

    public ColorStateList getCursorColor() {
        return this.K;
    }

    public ColorStateList getCursorErrorColor() {
        return this.L;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f4989p0;
    }

    public EditText getEditText() {
        return this.f4984n;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f4982m.f5055q.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f4982m.f5055q.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.f4982m.f5061w;
    }

    public int getEndIconMode() {
        return this.f4982m.f5057s;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f4982m.f5062x;
    }

    public CheckableImageButton getEndIconView() {
        return this.f4982m.f5055q;
    }

    public CharSequence getError() {
        p r8 = this.f4996t;
        if (r8.f5092q == true) goto L7;
        return null;
    L7:
        return r8.f5091p;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f4996t.f5095t;
    }

    public CharSequence getErrorContentDescription() {
        return this.f4996t.f5094s;
    }

    public int getErrorCurrentTextColors() {
        y r8 = this.f4996t.f5093r;
        if (r8 != null) goto L7;
        return -1;
    L7:
        return r8.getCurrentTextColor();
    }

    public Drawable getErrorIconDrawable() {
        return this.f4982m.f5051m.getDrawable();
    }

    public CharSequence getHelperText() {
        p r8 = this.f4996t;
        if (r8.f5099x == true) goto L7;
        return null;
    L7:
        return r8.f5098w;
    }

    public int getHelperTextCurrentTextColor() {
        y r8 = this.f4996t.f5100y;
        if (r8 != null) goto L7;
        return -1;
    L7:
        return r8.getCurrentTextColor();
    }

    public CharSequence getHint() {
        if (this.M == true) goto L7;
        return null;
    L7:
        return this.N;
    }

    public final float getHintCollapsedTextHeight() {
        return this.B0.d();
    }

    public final int getHintCurrentCollapsedTextColor() {
        com.google.android.material.internal.c r8 = this.B0;
        return r8.e(r8.f4840k);
    }

    public ColorStateList getHintTextColor() {
        return this.f4991q0;
    }

    public e getLengthCounter() {
        return this.f5004x;
    }

    public int getMaxEms() {
        return this.f4990q;
    }

    public int getMaxWidth() {
        return this.f4994s;
    }

    public int getMinEms() {
        return this.f4988p;
    }

    public int getMinWidth() {
        return this.f4992r;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f4982m.f5055q.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f4982m.f5055q.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.C == true) goto L7;
        return null;
    L7:
        return this.B;
    }

    public int getPlaceholderTextAppearance() {
        return this.F;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.E;
    }

    public CharSequence getPrefixText() {
        return this.f4971b.f5125m;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f4971b.f5124b.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f4971b.f5124b;
    }

    public aa.j getShapeAppearanceModel() {
        return this.V;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f4971b.f5126n.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.f4971b.f5126n.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f4971b.f5129q;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f4971b.f5130r;
    }

    public CharSequence getSuffixText() {
        return this.f4982m.f5064z;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f4982m.A.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f4982m.A;
    }

    public Typeface getTypeface() {
        return this.f4978i0;
    }

    public final int h(int r8, boolean r10) {
        if (r10 == false) goto L4;
    L8:
        if (r10 == true) goto L10;
    L12:
        int r11 = this.f4984n.getCompoundPaddingLeft();
    L7:
        return r11 + r8;
    L10:
        if (getSuffixText() == null) goto L12;
        r11 = this.f4982m.c();
        goto L7
    L4:
        if (getPrefixText() == null) goto L8;
        r11 = this.f4971b.a();
        goto L7
    }

    public final int i(int r8, boolean r10) {
        if (r10 == false) goto L4;
    L8:
        if (r10 == true) goto L10;
    L12:
        int r11 = this.f4984n.getCompoundPaddingRight();
    L7:
        return r8 - r11;
    L10:
        if (getPrefixText() == null) goto L12;
        r11 = this.f4971b.a();
        goto L7
    L4:
        if (getSuffixText() == null) goto L8;
        r11 = this.f4982m.c();
        goto L7
    }

    public final void j() {
        int r8 = this.Y;
        if (r8 == 0) goto L20;
        if (r8 == 1) goto L19;
        if (r8 != 2) goto L18;
        if (this.M == true) goto L9;
    L15:
        aa.f r10 = new aa.f(this.V);
    L16:
        this.P = r10;
    L21:
        this.T = null;
        this.U = null;
    L22:
        t();
        y();
        boolean r11 = false;
        if (this.Y != 1) goto L35;
        if (getContext().getResources().getConfiguration().fontScale < 2.0f) goto L27;
        boolean r12 = true;
    L28:
        if (r12 == false) goto L31;
        Resources r13 = getResources();
        int r14 = com.obric.cae.R.dimen.material_font_2_0_box_collapsed_padding_top;
    L33:
        this.Z = r13.getDimensionPixelSize(r14);
        goto L35
    L31:
        if (x9.c.d(getContext()) == false) goto L35;
        r13 = getResources();
        r14 = com.obric.cae.R.dimen.material_font_1_3_box_collapsed_padding_top;
        goto L33
    L27:
        r12 = false;
    L35:
        if (this.f4984n == null) goto L49;
        if (this.Y != 1) goto L49;
        if (getContext().getResources().getConfiguration().fontScale < 2.0f) goto L42;
        r11 = true;
    L42:
        if (r11 == false) goto L45;
        EditText r15 = this.f4984n;
        WeakHashMap<View, h0> r16 = w.f8437a;
        int r17 = w.e.f(r15);
        int r18 = getResources().getDimensionPixelSize(com.obric.cae.R.dimen.material_filled_edittext_font_2_0_padding_top);
        int r19 = w.e.e(this.f4984n);
        Resources r20 = getResources();
        int r21 = com.obric.cae.R.dimen.material_filled_edittext_font_2_0_padding_bottom;
    L47:
        w.e.k(r15, r17, r18, r19, r20.getDimensionPixelSize(r21));
        goto L49
    L45:
        if (x9.c.d(getContext()) == false) goto L49;
        r15 = this.f4984n;
        WeakHashMap<View, h0> r22 = w.f8437a;
        r17 = w.e.f(r15);
        r18 = getResources().getDimensionPixelSize(com.obric.cae.R.dimen.material_filled_edittext_font_1_3_padding_top);
        r19 = w.e.e(this.f4984n);
        r20 = getResources();
        r21 = com.obric.cae.R.dimen.material_filled_edittext_font_1_3_padding_bottom;
    L49:
        if (this.Y == 0) goto L51;
        u();
    L51:
        EditText r23 = this.f4984n;
        if ((r23 instanceof AutoCompleteTextView) == false) goto L65;
        AutoCompleteTextView r24 = (AutoCompleteTextView) r23;
        if (r24.getDropDownBackground() != null) goto L63;
        int r25 = this.Y;
        if (r25 != 2) goto L59;
        Drawable r26 = getOrCreateOutlinedDropDownMenuBackground();
    L61:
        r24.setDropDownBackgroundDrawable(r26);
        return;
    L59:
        if (r25 != 1) goto L64;
        r26 = getOrCreateFilledDropDownMenuBackground();
        goto L61
    L64:
        return;
    L63:
        return;
    L65:
        return;
    L9:
        if ((this.P instanceof h) == true) goto L15;
        aa.j r27 = this.V;
        int r28 = h.J;
        if (r27 != null) goto L14;
        r27 = new aa.j();
    L14:
        r10 = new h.b(new h.a(r27, new RectF()));
        goto L16
    L18:
        throw new IllegalArgumentException(android.aimedia.a.h(new StringBuilder(), this.Y, " is illegal; only @BoxBackgroundMode constants are supported."));
    L19:
        this.P = new aa.f(this.V);
        this.T = new aa.f();
        this.U = new aa.f();
        goto L22
    L20:
        this.P = null;
        goto L21
    }

    public final void k() {
        if (f() == true) goto L5;
        return;
    L5:
        int r8 = this.f4984n.getWidth();
        int r10 = this.f4984n.getGravity();
        com.google.android.material.internal.c r11 = this.B0;
        boolean r12 = r11.b(r11.A);
        r11.C = r12;
        Rect r13 = r11.f4831d;
        if (r10 != 17) goto L8;
    L20:
        float r14 = r8 / 2.0f;
        float r15 = r11.Z / 2.0f;
    L21:
        float r16 = r14 - r15;
    L22:
        float r17 = Math.max(r16, r13.left);
        RectF r18 = this.f4977h0;
        r18.left = r17;
        r18.top = r13.top;
        if (r10 != 17) goto L25;
    L40:
        float r19 = (r8 / 2.0f) + (r11.Z / 2.0f);
    L41:
        r18.right = Math.min(r19, r13.right);
        r18.bottom = r11.d() + r13.top;
        if (r18.width() > 0.0f) goto L44;
        return;
    L44:
        if (r18.height() <= 0.0f) goto L49;
        float r20 = r18.left;
        float r21 = this.X;
        r18.left = r20 - r21;
        r18.right += r21;
        r18.offset(-getPaddingLeft(), ((-getPaddingTop()) - (r18.height() / 2.0f)) + this.f4970a0);
        h r110 = (h) this.P;
        r110.getClass();
        r110.o(r18.left, r18.top, r18.right, r18.bottom);
        return;
    L49:
        return;
    L25:
        if ((r10 & 7) == 1) goto L40;
        if ((r10 & 8388613) == 8388613) goto L37;
        if ((r10 & 5) == 5) goto L37;
        if (r11.C == true) goto L39;
        r19 = r11.Z + r17;
    L39:
        r19 = r13.right;
    L37:
        if (r11.C == false) goto L39;
        r19 = r11.Z + r17;
        goto L41
    L8:
        if ((r10 & 7) == 1) goto L20;
        if ((r10 & 8388613) != 8388613) goto L13;
    L17:
        if (r12 == false) goto L19;
    L18:
        r16 = r13.left;
    L19:
        r14 = r13.right;
        r15 = r11.Z;
        goto L21
    L13:
        if ((r10 & 5) == 5) goto L17;
        if (r12 == false) goto L18;
        goto L18
    }

    public final void m(TextView r8, int r10) {
        boolean r11 = true;
        r8.setTextAppearance(r10);     // Catch: Exception -> L11
        if (r8.getTextColors().getDefaultColor() == (-65281)) goto L8;
        r11 = false;
    L8:
        if (r11 == false) goto L14;
        r8.setTextAppearance(com.obric.cae.R.style.TextAppearance_AppCompat_Caption);
        Context r12 = getContext();
        Object r13 = androidx.core.content.a.f1674a;
        r8.setTextColor(androidx.core.content.a.c.a(r12, com.obric.cae.R.color.design_error));
        return;
    }

    public final boolean n() {
        p r8 = this.f4996t;
        if (r8.f5090o == 1) goto L5;
    L9:
        return false;
    L5:
        if (r8.f5093r == null) goto L9;
        if (TextUtils.isEmpty(r8.f5091p) == true) goto L9;
        return true;
    }

    public final void o(Editable r10) {
        ((o5.o) this.f5004x).getClass();
        int r11 = a(r10);
        boolean r8 = this.f5002w;
        int r12 = this.f5000v;
        String r13 = null;
        if (r12 != (-1)) goto L5;
        this.f5006y.setText(String.valueOf(r11));
        this.f5006y.setContentDescription(null);
        this.f5002w = false;
    L21:
        if (this.f4984n != null) goto L23;
        return;
    L23:
        if (r8 == this.f5002w) goto L27;
        v(false, false);
        y();
        s();
        return;
    L27:
        return;
    L5:
        if (r11 <= r12) goto L7;
        boolean r14 = true;
    L8:
        this.f5002w = r14;
        Context r15 = getContext();
        y r16 = this.f5006y;
        int r17 = this.f5000v;
        if (this.f5002w == false) goto L11;
        int r18 = com.obric.cae.R.string.character_counter_overflowed_content_description;
    L12:
        r16.setContentDescription(r15.getString(r18, new Object[]{Integer.valueOf(r11), Integer.valueOf(r17)}));
        if (r8 == this.f5002w) goto L15;
        p();
    L15:
        h0.a r19 = h0.a.c();
        y r20 = this.f5006y;
        String r21 = getContext().getString(com.obric.cae.R.string.character_counter_pattern, new Object[]{Integer.valueOf(r11), Integer.valueOf(this.f5000v)});
        if (r21 != null) goto L18;
        r19.getClass();
    L19:
        r20.setText(r13);
        goto L21
    L18:
        r13 = r19.d(r21, r19.f7871c).toString();
        goto L19
    L11:
        r18 = com.obric.cae.R.string.character_counter_content_description;
        goto L12
    L7:
        r14 = false;
        goto L8
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r8) {
        super.onConfigurationChanged(r8);
        this.B0.g(r8);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        m r8 = this.f4982m;
        r8.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean r10 = false;
        this.H0 = false;
        if (this.f4984n == null) goto L8;
        int r11 = Math.max(r8.getMeasuredHeight(), this.f4971b.getMeasuredHeight());
        if (this.f4984n.getMeasuredHeight() >= r11) goto L8;
        this.f4984n.setMinimumHeight(r11);
        r10 = true;
    L8:
        boolean r12 = r();
        if (r10 == true) goto L11;
        if (r12 == true) goto L11;
        return;
    L11:
        this.f4984n.post(new androidx.activity.k(this, 12));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        EditText r14 = this.f4984n;
        if (r14 == null) goto L84;
        Rect r15 = this.f4975f0;
        com.google.android.material.internal.d.a(this, r14, r15);
        aa.f r16 = this.T;
        if (r16 == null) goto L7;
        int r17 = r15.bottom;
        r16.setBounds(r15.left, r17 - this.f4972b0, r15.right, r17);
    L7:
        aa.f r18 = this.U;
        if (r18 == null) goto L11;
        int r19 = r15.bottom;
        r18.setBounds(r15.left, r19 - this.f4973c0, r15.right, r19);
    L11:
        if (this.M == false) goto L85;
        float r20 = this.f4984n.getTextSize();
        com.google.android.material.internal.c r21 = this.B0;
        if (r21.f4837h == r20) goto L15;
        r21.f4837h = r20;
        r21.h(false);
    L15:
        int r22 = this.f4984n.getGravity();
        int r110 = (r22 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 48;
        if (r21.f4836g == r110) goto L19;
        r21.f4836g = r110;
        r21.h(false);
    L19:
        if (r21.f4834f == r22) goto L22;
        r21.f4834f = r22;
        r21.h(false);
    L22:
        if (this.f4984n == null) goto L83;
        boolean r23 = com.google.android.material.internal.q.a(this);
        int r111 = r15.bottom;
        Rect r24 = this.f4976g0;
        r24.bottom = r111;
        int r112 = this.Y;
        if (r112 != 1) goto L26;
        r24.left = h(r15.left, r23);
        int r113 = r15.top + this.Z;
    L30:
        r24.top = r113;
        int r25 = i(r15.right, r23);
    L31:
        r24.right = r25;
        int r114 = r24.left;
        int r26 = r24.top;
        int r27 = r24.bottom;
        Rect r28 = r21.f4831d;
        if (r28.left == r114) goto L34;
    L40:
        boolean r29 = false;
    L41:
        if (r29 == true) goto L44;
        r28.set(r114, r26, r25, r27);
        r21.M = true;
    L44:
        if (this.f4984n == null) goto L81;
        TextPaint r30 = r21.O;
        r30.setTextSize(r21.f4837h);
        r30.setTypeface(r21.f4850u);
        r30.setLetterSpacing(r21.W);
        float r31 = -r30.ascent();
        r24.left = this.f4984n.getCompoundPaddingLeft() + r15.left;
        if (this.Y == 1) goto L48;
    L50:
        boolean r115 = false;
    L51:
        if (r115 == false) goto L53;
        int r116 = (int) (r15.centerY() - (r31 / 2.0f));
    L54:
        r24.top = r116;
        r24.right = r15.right - this.f4984n.getCompoundPaddingRight();
        if (this.Y == 1) goto L57;
    L59:
        boolean r117 = false;
    L60:
        if (r117 == false) goto L62;
        int r32 = (int) (r24.top + r31);
    L63:
        r24.bottom = r32;
        int r33 = r24.left;
        int r118 = r24.top;
        int r34 = r24.right;
        Rect r35 = r21.f4829c;
        if (r35.left == r33) goto L66;
    L72:
        boolean r36 = false;
    L73:
        if (r36 == true) goto L75;
        r35.set(r33, r118, r34, r32);
        r21.M = true;
    L75:
        r21.h(false);
        if (f() == true) goto L78;
        return;
    L78:
        if (this.A0 == true) goto L87;
        k();
        return;
    L87:
        return;
    L66:
        if (r35.top != r118) goto L72;
        if (r35.right != r34) goto L72;
        if (r35.bottom != r32) goto L72;
        r36 = true;
        goto L73
    L62:
        r32 = r15.bottom - this.f4984n.getCompoundPaddingBottom();
        goto L63
    L57:
        if (this.f4984n.getMinLines() > 1) goto L59;
        r117 = true;
        goto L60
    L53:
        r116 = r15.top + this.f4984n.getCompoundPaddingTop();
        goto L54
    L48:
        if (this.f4984n.getMinLines() > 1) goto L50;
        r115 = true;
        goto L51
    L81:
        throw new IllegalStateException();
    L34:
        if (r28.top != r26) goto L40;
        if (r28.right != r25) goto L40;
        if (r28.bottom != r27) goto L40;
        r29 = true;
        goto L41
    L26:
        if (r112 == 2) goto L28;
        r24.left = h(r15.left, r23);
        r113 = getPaddingTop();
        goto L30
    L28:
        r24.left = this.f4984n.getPaddingLeft() + r15.left;
        r24.top = r15.top - d();
        r25 = r15.right - this.f4984n.getPaddingRight();
        goto L31
    L83:
        throw new IllegalStateException();
    L85:
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
        boolean r11 = this.H0;
        m r12 = this.f4982m;
        if (r11 == true) goto L6;
        r12.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.H0 = true;
    L6:
        if (this.D == null) goto L10;
        EditText r13 = this.f4984n;
        if (r13 == null) goto L10;
        int r14 = r13.getGravity();
        this.D.setGravity(r14);
        this.D.setPadding(this.f4984n.getCompoundPaddingLeft(), this.f4984n.getCompoundPaddingTop(), this.f4984n.getCompoundPaddingRight(), this.f4984n.getCompoundPaddingBottom());
    L10:
        r12.m();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        if ((r8 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r8);
        return;
    L6:
        SavedState r10 = (SavedState) r8;
        super.onRestoreInstanceState(r10.f1731a);
        setError(r10.f5010m);
        if (r10.f5011n == false) goto L9;
        post(new b(this));
    L9:
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int r11) {
        super.onRtlPropertiesChanged(r11);
        boolean r8 = true;
        if (r11 == 1) goto L7;
        r8 = false;
    L7:
        if (r8 == this.W) goto L22;
        aa.c r12 = this.V.f184e;
        RectF r10 = this.f4977h0;
        float r13 = r12.a(r10);
        float r14 = this.V.f185f.a(r10);
        float r15 = this.V.f187h.a(r10);
        float r16 = this.V.f186g.a(r10);
        aa.j r17 = this.V;
        d0 r18 = r17.f180a;
        aa.j.a r19 = new aa.j.a();
        d0 r20 = r17.f181b;
        r19.f192a = r20;
        float r21 = aa.j.a.b(r20);
        if (r21 == (-1.0f)) goto L11;
        r19.e(r21);
    L11:
        r19.f193b = r18;
        float r22 = aa.j.a.b(r18);
        if (r22 == (-1.0f)) goto L14;
        r19.f(r22);
    L14:
        d0 r23 = r17.f182c;
        r19.f195d = r23;
        float r24 = aa.j.a.b(r23);
        if (r24 == (-1.0f)) goto L17;
        r19.c(r24);
    L17:
        d0 r25 = r17.f183d;
        r19.f194c = r25;
        float r26 = aa.j.a.b(r25);
        if (r26 == (-1.0f)) goto L20;
        r19.d(r26);
    L20:
        r19.e(r14);
        r19.f(r13);
        r19.c(r16);
        r19.d(r15);
        aa.j r110 = new aa.j(r19);
        this.W = r8;
        setShapeAppearanceModel(r110);
        return;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r8 = new SavedState(super.onSaveInstanceState());
        if (n() == false) goto L5;
        r8.f5010m = getError();
    L5:
        m r10 = this.f4982m;
        boolean r11 = true;
        if (r10.f5057s == 0) goto L8;
        boolean r12 = true;
    L9:
        if (r12 == true) goto L11;
    L13:
        r11 = false;
    L14:
        r8.f5011n = r11;
        return r8;
    L11:
        if (r10.f5055q.isChecked() == false) goto L13;
    L8:
        r12 = false;
        goto L9
    }

    public final void p() {
        y r8 = this.f5006y;
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.f5002w == false) goto L7;
        int r10 = this.f5008z;
    L8:
        m(r8, r10);
        if (this.f5002w == true) goto L14;
        ColorStateList r11 = this.I;
        if (r11 == null) goto L14;
        this.f5006y.setTextColor(r11);
    L14:
        if (this.f5002w == false) goto L20;
        ColorStateList r12 = this.J;
        if (r12 == null) goto L21;
        this.f5006y.setTextColor(r12);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r10 = this.A;
        goto L8
    }

    public final void q() {
        ColorStateList r8 = this.K;
        if (r8 != null) goto L15;
        Context r10 = getContext();
        TypedValue r11 = x9.b.a(r10, com.obric.cae.R.attr.colorControlActivated);
        if (r11 == null) goto L14;
        int r12 = r11.resourceId;
        if (r12 == 0) goto L11;
        r8 = androidx.core.content.a.b(r10, r12);
        goto L15
    L11:
        int r13 = r11.data;
        if (r13 == 0) goto L14;
        r8 = ColorStateList.valueOf(r13);
    L14:
        r8 = null;
    L15:
        EditText r14 = this.f4984n;
        if (r14 != null) goto L18;
        return;
    L18:
        if (r14.getTextCursorDrawable() == null) goto L36;
        Drawable r15 = this.f4984n.getTextCursorDrawable().mutate();
        if (n() == false) goto L23;
    L28:
        boolean r16 = true;
    L29:
        if (r16 == false) goto L33;
        ColorStateList r17 = this.L;
        if (r17 == null) goto L33;
        r8 = r17;
    L33:
        b0.a.b.h(r15, r8);
        return;
    L23:
        if (this.f5006y != null) goto L25;
    L27:
        r16 = false;
        goto L29
    L25:
        if (this.f5002w == false) goto L27;
    }

    public final boolean r() {
        if (this.f4984n != null) goto L5;
        return false;
    L5:
        Drawable r8 = getStartIconDrawable();
        boolean r10 = true;
        v r11 = this.f4971b;
        if (r8 != null) goto L12;
        if (getPrefixText() != null) goto L10;
    L14:
        boolean r12 = false;
    L15:
        CheckableImageButton r13 = null;
        if (r12 == false) goto L26;
        int r14 = r11.getMeasuredWidth() - this.f4984n.getPaddingLeft();
        if (this.f4979j0 != null) goto L20;
    L21:
        ColorDrawable r15 = new ColorDrawable();
        this.f4979j0 = r15;
        this.f4980k0 = r14;
        r15.setBounds(0, 0, r14, 1);
    L22:
        Drawable[] r16 = androidx.core.widget.l.a(this.f4984n);
        Drawable r17 = r16[0];
        ColorDrawable r18 = this.f4979j0;
        if (r17 == r18) goto L29;
        androidx.core.widget.l.e(this.f4984n, r18, r16[1], r16[2], r16[3]);
    L28:
        boolean r19 = true;
    L30:
        m r20 = this.f4982m;
        if (r20.e() == true) goto L42;
        if (r20.f5057s == 0) goto L35;
        boolean r21 = true;
    L36:
        if (r21 == false) goto L40;
        if (r20.d() == true) goto L42;
    L40:
        if (r20.f5064z != null) goto L42;
    L44:
        boolean r22 = false;
    L45:
        if (r22 == false) goto L71;
        int r23 = r20.A.getMeasuredWidth() - this.f4984n.getPaddingRight();
        if (r20.e() == false) goto L50;
        r13 = r20.f5051m;
    L57:
        if (r13 == null) goto L59;
        r23 = j0.f.c((ViewGroup.MarginLayoutParams) r13.getLayoutParams()) + (r13.getMeasuredWidth() + r23);
    L59:
        Drawable[] r24 = androidx.core.widget.l.a(this.f4984n);
        ColorDrawable r25 = this.f4983m0;
        if (r25 != null) goto L62;
    L64:
        if (r25 != null) goto L66;
        ColorDrawable r26 = new ColorDrawable();
        this.f4983m0 = r26;
        this.f4985n0 = r23;
        r26.setBounds(0, 0, r23, 1);
    L66:
        Drawable r27 = r24[2];
        ColorDrawable r28 = this.f4983m0;
        if (r27 == r28) goto L69;
        this.f4987o0 = r27;
        androidx.core.widget.l.e(this.f4984n, r24[0], r24[1], r28, r24[3]);
    L78:
        return r10;
    L69:
        r10 = r19;
        goto L78
    L62:
        if (this.f4985n0 == r23) goto L64;
        this.f4985n0 = r23;
        r25.setBounds(0, 0, r23, 1);
        androidx.core.widget.l.e(this.f4984n, r24[0], r24[1], this.f4983m0, r24[3]);
        goto L78
    L50:
        if (r20.f5057s == 0) goto L52;
        boolean r29 = true;
    L53:
        if (r29 == false) goto L57;
        if (r20.d() == false) goto L57;
        r13 = r20.f5055q;
        goto L57
    L52:
        r29 = false;
        goto L53
    L71:
        if (this.f4983m0 == null) goto L79;
        Drawable[] r30 = androidx.core.widget.l.a(this.f4984n);
        if (r30[2] != this.f4983m0) goto L75;
        androidx.core.widget.l.e(this.f4984n, r30[0], r30[1], this.f4987o0, r30[3]);
    L76:
        this.f4983m0 = null;
        goto L78
    L75:
        r10 = r19;
        goto L76
    L79:
        return r19;
    L35:
        r21 = false;
    L42:
        if (r20.getMeasuredWidth() <= 0) goto L44;
        r22 = true;
    L29:
        r19 = false;
        goto L30
    L20:
        if (this.f4980k0 == r14) goto L22;
    L26:
        if (this.f4979j0 == null) goto L29;
        Drawable[] r31 = androidx.core.widget.l.a(this.f4984n);
        androidx.core.widget.l.e(this.f4984n, null, r31[1], r31[2], r31[3]);
        this.f4979j0 = null;
        goto L28
    L10:
        if (getPrefixTextView().getVisibility() != 0) goto L14;
    L12:
        if (r11.getMeasuredWidth() <= 0) goto L14;
        r12 = true;
        goto L15
    }

    public final void s() {
        EditText r8 = this.f4984n;
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.Y != 0) goto L23;
        Drawable r10 = r8.getBackground();
        if (r10 != null) goto L10;
        return;
    L10:
        Rect r11 = androidx.appcompat.widget.d0.f1115a;
        Drawable r12 = r10.mutate();
        if (n() == false) goto L14;
        int r13 = getErrorCurrentTextColors();
    L18:
        r12.setColorFilter(androidx.appcompat.widget.j.c(r13, PorterDuff.Mode.SRC_IN));
        return;
    L14:
        if (this.f5002w == false) goto L19;
        y r14 = this.f5006y;
        if (r14 == null) goto L19;
        r13 = r14.getCurrentTextColor();
    L19:
        r12.clearColorFilter();
        this.f4984n.refreshDrawableState();
        return;
    }

    public void setBoxBackgroundColor(int r8) {
        if (this.f4974e0 == r8) goto L6;
        this.f4974e0 = r8;
        this.f5001v0 = r8;
        this.f5005x0 = r8;
        this.f5007y0 = r8;
        c();
        return;
    }

    public void setBoxBackgroundColorResource(int r8) {
        Context r10 = getContext();
        Object r11 = androidx.core.content.a.f1674a;
        setBoxBackgroundColor(androidx.core.content.a.c.a(r10, r8));
    }

    public void setBoxBackgroundColorStateList(ColorStateList r8) {
        int r10 = r8.getDefaultColor();
        this.f5001v0 = r10;
        this.f4974e0 = r10;
        this.f5003w0 = r8.getColorForState(new int[]{-16842910}, -1);
        this.f5005x0 = r8.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f5007y0 = r8.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        c();
    }

    public void setBoxBackgroundMode(int r8) {
        if (r8 != this.Y) goto L5;
        return;
    L5:
        this.Y = r8;
        if (this.f4984n == null) goto L9;
        j();
        return;
    }

    public void setBoxCollapsedPaddingTop(int r8) {
        this.Z = r8;
    }

    public void setBoxCornerFamily(int r8) {
        aa.j r10 = this.V;
        r10.getClass();
        aa.j.a r11 = new aa.j.a(r10);
        aa.c r12 = this.V.f184e;
        d0 r13 = defpackage.c.C(r8);
        r11.f192a = r13;
        float r14 = aa.j.a.b(r13);
        if (r14 == (-1.0f)) goto L5;
        r11.e(r14);
    L5:
        r11.f196e = r12;
        aa.c r15 = this.V.f185f;
        d0 r16 = defpackage.c.C(r8);
        r11.f193b = r16;
        float r17 = aa.j.a.b(r16);
        if (r17 == (-1.0f)) goto L8;
        r11.f(r17);
    L8:
        r11.f197f = r15;
        aa.c r18 = this.V.f187h;
        d0 r19 = defpackage.c.C(r8);
        r11.f195d = r19;
        float r20 = aa.j.a.b(r19);
        if (r20 == (-1.0f)) goto L11;
        r11.c(r20);
    L11:
        r11.f199h = r18;
        aa.c r21 = this.V.f186g;
        d0 r22 = defpackage.c.C(r8);
        r11.f194c = r22;
        float r23 = aa.j.a.b(r22);
        if (r23 == (-1.0f)) goto L14;
        r11.d(r23);
    L14:
        r11.f198g = r21;
        this.V = new aa.j(r11);
        c();
    }

    public void setBoxStrokeColor(int r8) {
        if (this.f4997t0 == r8) goto L6;
        this.f4997t0 = r8;
        y();
        return;
    }

    public void setBoxStrokeColorStateList(ColorStateList r8) {
        if (r8.isStateful() == false) goto L7;
        this.f4993r0 = r8.getDefaultColor();
        this.f5009z0 = r8.getColorForState(new int[]{-16842910}, -1);
        this.f4995s0 = r8.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        int r10 = r8.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
    L5:
        this.f4997t0 = r10;
    L9:
        y();
        return;
    L7:
        if (this.f4997t0 == r8.getDefaultColor()) goto L9;
        r10 = r8.getDefaultColor();
        goto L5
    }

    public void setBoxStrokeErrorColor(ColorStateList r8) {
        if (this.f4999u0 == r8) goto L6;
        this.f4999u0 = r8;
        y();
        return;
    }

    public void setBoxStrokeWidth(int r8) {
        this.f4972b0 = r8;
        y();
    }

    public void setBoxStrokeWidthFocused(int r8) {
        this.f4973c0 = r8;
        y();
    }

    public void setBoxStrokeWidthFocusedResource(int r8) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(r8));
    }

    public void setBoxStrokeWidthResource(int r8) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(r8));
    }

    public void setCounterEnabled(boolean r8) {
        if (this.f4998u == r8) goto L19;
        Editable r10 = null;
        p r11 = this.f4996t;
        if (r8 == false) goto L16;
        y r12 = new y(getContext(), null);
        this.f5006y = r12;
        r12.setId(com.obric.cae.R.id.textinput_counter);
        Typeface r13 = this.f4978i0;
        if (r13 == null) goto L9;
        this.f5006y.setTypeface(r13);
    L9:
        this.f5006y.setMaxLines(1);
        r11.a(this.f5006y, 2);
        j0.f.h((ViewGroup.MarginLayoutParams) this.f5006y.getLayoutParams(), getResources().getDimensionPixelOffset(com.obric.cae.R.dimen.mtrl_textinput_counter_margin_start));
        p();
        if (this.f5006y == null) goto L17;
        EditText r14 = this.f4984n;
        if (r14 == null) goto L15;
        r10 = r14.getText();
    L15:
        o(r10);
    L17:
        this.f4998u = r8;
        return;
    L16:
        r11.g(this.f5006y, 2);
        this.f5006y = null;
        goto L17
    }

    public void setCounterMaxLength(int r8) {
        if (this.f5000v == r8) goto L17;
        if (r8 > 0) goto L7;
        r8 = -1;
    L7:
        this.f5000v = r8;
        if (this.f4998u == true) goto L10;
        return;
    L10:
        if (this.f5006y == null) goto L19;
        EditText r10 = this.f4984n;
        if (r10 != null) goto L14;
        Editable r11 = null;
    L15:
        o(r11);
        return;
    L14:
        r11 = r10.getText();
        goto L15
    L19:
        return;
    }

    public void setCounterOverflowTextAppearance(int r8) {
        if (this.f5008z == r8) goto L6;
        this.f5008z = r8;
        p();
        return;
    }

    public void setCounterOverflowTextColor(ColorStateList r8) {
        if (this.J == r8) goto L6;
        this.J = r8;
        p();
        return;
    }

    public void setCounterTextAppearance(int r8) {
        if (this.A == r8) goto L6;
        this.A = r8;
        p();
        return;
    }

    public void setCounterTextColor(ColorStateList r8) {
        if (this.I == r8) goto L6;
        this.I = r8;
        p();
        return;
    }

    public void setCursorColor(ColorStateList r8) {
        if (this.K == r8) goto L6;
        this.K = r8;
        q();
        return;
    }

    public void setCursorErrorColor(ColorStateList r8) {
        if (this.L == r8) goto L16;
        this.L = r8;
        if (n() == false) goto L7;
    L12:
        boolean r10 = true;
    L13:
        if (r10 == false) goto L17;
        q();
        return;
    L17:
        return;
    L7:
        if (this.f5006y != null) goto L9;
    L11:
        r10 = false;
        goto L13
    L9:
        if (this.f5002w == false) goto L11;
    }

    public void setDefaultHintTextColor(ColorStateList r8) {
        this.f4989p0 = r8;
        this.f4991q0 = r8;
        if (this.f4984n == null) goto L6;
        v(false, false);
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r8) {
        l(this, r8);
        super.setEnabled(r8);
    }

    public void setEndIconActivated(boolean r8) {
        this.f4982m.f5055q.setActivated(r8);
    }

    public void setEndIconCheckable(boolean r8) {
        this.f4982m.f5055q.setCheckable(r8);
    }

    public void setEndIconContentDescription(int r8) {
        m r10 = this.f4982m;
        if (r8 == 0) goto L5;
        CharSequence r11 = r10.getResources().getText(r8);
    L6:
        CheckableImageButton r12 = r10.f5055q;
        if (r12.getContentDescription() == r11) goto L10;
        r12.setContentDescription(r11);
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public void setEndIconDrawable(int r8) {
        m r10 = this.f4982m;
        if (r8 == 0) goto L5;
        Drawable r11 = d.a.a(r10.getContext(), r8);
    L6:
        CheckableImageButton r12 = r10.f5055q;
        r12.setImageDrawable(r11);
        if (r11 == null) goto L10;
        ColorStateList r13 = r10.f5059u;
        PorterDuff.Mode r14 = r10.f5060v;
        TextInputLayout r15 = r10.f5049a;
        o.a(r15, r12, r13, r14);
        o.c(r15, r12, r10.f5059u);
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public void setEndIconMinSize(int r8) {
        m r10 = this.f4982m;
        if (r8 >= 0) goto L5;
        r10.getClass();
        throw new IllegalArgumentException("endIconSize cannot be less than 0");
    L5:
        if (r8 == r10.f5061w) goto L10;
        r10.f5061w = r8;
        CheckableImageButton r11 = r10.f5055q;
        r11.setMinimumWidth(r8);
        r11.setMinimumHeight(r8);
        CheckableImageButton r12 = r10.f5051m;
        r12.setMinimumWidth(r8);
        r12.setMinimumHeight(r8);
        return;
    }

    public void setEndIconMode(int r8) {
        this.f4982m.g(r8);
    }

    public void setEndIconOnClickListener(View.OnClickListener r8) {
        m r10 = this.f4982m;
        View.OnLongClickListener r11 = r10.f5063y;
        CheckableImageButton r12 = r10.f5055q;
        r12.setOnClickListener(r8);
        o.d(r12, r11);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener r8) {
        m r10 = this.f4982m;
        r10.f5063y = r8;
        CheckableImageButton r11 = r10.f5055q;
        r11.setOnLongClickListener(r8);
        o.d(r11, r8);
    }

    public void setEndIconScaleType(ImageView.ScaleType r8) {
        m r10 = this.f4982m;
        r10.f5062x = r8;
        r10.f5055q.setScaleType(r8);
        r10.f5051m.setScaleType(r8);
    }

    public void setEndIconTintList(ColorStateList r8) {
        m r10 = this.f4982m;
        if (r10.f5059u == r8) goto L6;
        r10.f5059u = r8;
        PorterDuff.Mode r11 = r10.f5060v;
        o.a(r10.f5049a, r10.f5055q, r8, r11);
        return;
    }

    public void setEndIconTintMode(PorterDuff.Mode r8) {
        m r10 = this.f4982m;
        if (r10.f5060v == r8) goto L6;
        r10.f5060v = r8;
        ColorStateList r11 = r10.f5059u;
        o.a(r10.f5049a, r10.f5055q, r11, r8);
        return;
    }

    public void setEndIconVisible(boolean r8) {
        this.f4982m.h(r8);
    }

    public void setError(CharSequence r8) {
        p r10 = this.f4996t;
        if (r10.f5092q == true) goto L9;
        if (TextUtils.isEmpty(r8) == false) goto L7;
        return;
    L7:
        setErrorEnabled(true);
    L9:
        if (TextUtils.isEmpty(r8) == true) goto L14;
        r10.c();
        r10.f5091p = r8;
        r10.f5093r.setText(r8);
        int r11 = r10.f5089n;
        if (r11 == 1) goto L13;
        r10.f5090o = 1;
    L13:
        r10.i(r11, r10.f5090o, r10.h(r10.f5093r, r8));
        return;
    L14:
        r10.f();
    }

    public void setErrorAccessibilityLiveRegion(int r8) {
        p r10 = this.f4996t;
        r10.f5095t = r8;
        y r11 = r10.f5093r;
        if (r11 == null) goto L6;
        WeakHashMap<View, h0> r12 = w.f8437a;
        w.g.f(r11, r8);
        return;
    }

    public void setErrorContentDescription(CharSequence r8) {
        p r10 = this.f4996t;
        r10.f5094s = r8;
        y r11 = r10.f5093r;
        if (r11 == null) goto L6;
        r11.setContentDescription(r8);
        return;
    }

    public void setErrorEnabled(boolean r8) {
        p r10 = this.f4996t;
        if (r10.f5092q == r8) goto L27;
        r10.c();
        TextInputLayout r11 = r10.f5083h;
        if (r8 == false) goto L24;
        y r12 = new y(r10.f5082g, null);
        r10.f5093r = r12;
        r12.setId(com.obric.cae.R.id.textinput_error);
        r10.f5093r.setTextAlignment(5);
        Typeface r13 = r10.B;
        if (r13 == null) goto L10;
        r10.f5093r.setTypeface(r13);
    L10:
        int r14 = r10.f5096u;
        r10.f5096u = r14;
        y r15 = r10.f5093r;
        if (r15 == null) goto L13;
        r11.m(r15, r14);
    L13:
        ColorStateList r16 = r10.f5097v;
        r10.f5097v = r16;
        y r17 = r10.f5093r;
        if (r17 == null) goto L17;
        if (r16 == null) goto L17;
        r17.setTextColor(r16);
    L17:
        CharSequence r18 = r10.f5094s;
        r10.f5094s = r18;
        y r19 = r10.f5093r;
        if (r19 == null) goto L20;
        r19.setContentDescription(r18);
    L20:
        int r20 = r10.f5095t;
        r10.f5095t = r20;
        y r21 = r10.f5093r;
        if (r21 == null) goto L23;
        WeakHashMap<View, h0> r22 = w.f8437a;
        w.g.f(r21, r20);
    L23:
        r10.f5093r.setVisibility(4);
        r10.a(r10.f5093r, 0);
    L25:
        r10.f5092q = r8;
        return;
    L24:
        r10.f();
        r10.g(r10.f5093r, 0);
        r10.f5093r = null;
        r11.s();
        r11.y();
        goto L25
    }

    public void setErrorIconDrawable(int r8) {
        m r10 = this.f4982m;
        if (r8 == 0) goto L5;
        Drawable r11 = d.a.a(r10.getContext(), r8);
    L6:
        r10.i(r11);
        ColorStateList r12 = r10.f5052n;
        o.c(r10.f5049a, r10.f5051m, r12);
        return;
    L5:
        r11 = null;
        goto L6
    }

    public void setErrorIconOnClickListener(View.OnClickListener r8) {
        m r10 = this.f4982m;
        CheckableImageButton r11 = r10.f5051m;
        View.OnLongClickListener r12 = r10.f5054p;
        r11.setOnClickListener(r8);
        o.d(r11, r12);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener r8) {
        m r10 = this.f4982m;
        r10.f5054p = r8;
        CheckableImageButton r11 = r10.f5051m;
        r11.setOnLongClickListener(r8);
        o.d(r11, r8);
    }

    public void setErrorIconTintList(ColorStateList r8) {
        m r10 = this.f4982m;
        if (r10.f5052n == r8) goto L6;
        r10.f5052n = r8;
        PorterDuff.Mode r11 = r10.f5053o;
        o.a(r10.f5049a, r10.f5051m, r8, r11);
        return;
    }

    public void setErrorIconTintMode(PorterDuff.Mode r8) {
        m r10 = this.f4982m;
        if (r10.f5053o == r8) goto L6;
        r10.f5053o = r8;
        ColorStateList r11 = r10.f5052n;
        o.a(r10.f5049a, r10.f5051m, r11, r8);
        return;
    }

    public void setErrorTextAppearance(int r8) {
        p r10 = this.f4996t;
        r10.f5096u = r8;
        y r11 = r10.f5093r;
        if (r11 == null) goto L6;
        r10.f5083h.m(r11, r8);
        return;
    }

    public void setErrorTextColor(ColorStateList r8) {
        p r10 = this.f4996t;
        r10.f5097v = r8;
        y r11 = r10.f5093r;
        if (r11 == null) goto L7;
        if (r8 == null) goto L8;
        r11.setTextColor(r8);
        return;
    L8:
        return;
    }

    public void setExpandedHintEnabled(boolean r8) {
        if (this.C0 == r8) goto L6;
        this.C0 = r8;
        v(false, false);
        return;
    }

    public void setHelperText(CharSequence r8) {
        boolean r10 = TextUtils.isEmpty(r8);
        p r11 = this.f4996t;
        if (r10 == false) goto L8;
        if (r11.f5099x == false) goto L15;
        setHelperTextEnabled(false);
        return;
    L15:
        return;
    L8:
        if (r11.f5099x == true) goto L10;
        setHelperTextEnabled(true);
    L10:
        r11.c();
        r11.f5098w = r8;
        r11.f5100y.setText(r8);
        int r12 = r11.f5089n;
        if (r12 == 2) goto L13;
        r11.f5090o = 2;
    L13:
        r11.i(r12, r11.f5090o, r11.h(r11.f5100y, r8));
    }

    public void setHelperTextColor(ColorStateList r8) {
        p r10 = this.f4996t;
        r10.A = r8;
        y r11 = r10.f5100y;
        if (r11 == null) goto L7;
        if (r8 == null) goto L8;
        r11.setTextColor(r8);
        return;
    L8:
        return;
    }

    public void setHelperTextEnabled(boolean r8) {
        p r10 = this.f4996t;
        if (r10.f5099x == r8) goto L24;
        r10.c();
        if (r8 == false) goto L18;
        y r11 = new y(r10.f5082g, null);
        r10.f5100y = r11;
        r11.setId(com.obric.cae.R.id.textinput_helper_text);
        r10.f5100y.setTextAlignment(5);
        Typeface r12 = r10.B;
        if (r12 == null) goto L10;
        r10.f5100y.setTypeface(r12);
    L10:
        r10.f5100y.setVisibility(4);
        y r13 = r10.f5100y;
        WeakHashMap<View, h0> r14 = w.f8437a;
        w.g.f(r13, 1);
        int r15 = r10.f5101z;
        r10.f5101z = r15;
        y r16 = r10.f5100y;
        if (r16 == null) goto L13;
        r16.setTextAppearance(r15);
    L13:
        ColorStateList r17 = r10.A;
        r10.A = r17;
        y r18 = r10.f5100y;
        if (r18 == null) goto L17;
        if (r17 == null) goto L17;
        r18.setTextColor(r17);
    L17:
        r10.a(r10.f5100y, 1);
        r10.f5100y.setAccessibilityDelegate(new q(r10));
    L22:
        r10.f5099x = r8;
        return;
    L18:
        r10.c();
        int r19 = r10.f5089n;
        if (r19 != 2) goto L21;
        r10.f5090o = 0;
    L21:
        r10.i(r19, r10.f5090o, r10.h(r10.f5100y, ""));
        r10.g(r10.f5100y, 1);
        r10.f5100y = null;
        TextInputLayout r20 = r10.f5083h;
        r20.s();
        r20.y();
        goto L22
    }

    public void setHelperTextTextAppearance(int r8) {
        p r10 = this.f4996t;
        r10.f5101z = r8;
        y r11 = r10.f5100y;
        if (r11 == null) goto L6;
        r11.setTextAppearance(r8);
        return;
    }

    public void setHint(int r8) {
        if (r8 == 0) goto L4;
        CharSequence r10 = getResources().getText(r8);
    L5:
        setHint(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setHintAnimationEnabled(boolean r8) {
        this.D0 = r8;
    }

    public void setHintEnabled(boolean r8) {
        if (r8 == this.M) goto L23;
        this.M = r8;
        if (r8 == true) goto L12;
        this.O = false;
        if (TextUtils.isEmpty(this.N) == false) goto L9;
    L11:
        setHintInternal(null);
    L20:
        if (this.f4984n == null) goto L24;
        u();
        return;
    L24:
        return;
    L9:
        if (TextUtils.isEmpty(this.f4984n.getHint()) == false) goto L11;
        this.f4984n.setHint(this.N);
        goto L11
    L12:
        CharSequence r10 = this.f4984n.getHint();
        if (TextUtils.isEmpty(r10) == false) goto L15;
    L18:
        this.O = true;
        goto L20
    L15:
        if (TextUtils.isEmpty(this.N) == false) goto L17;
        setHint(r10);
    L17:
        this.f4984n.setHint(null);
        goto L18
    }

    public void setHintTextAppearance(int r8) {
        com.google.android.material.internal.c r10 = this.B0;
        View r11 = r10.f4825a;
        x9.d r12 = new x9.d(r11.getContext(), r8);
        ColorStateList r13 = r12.f13753j;
        if (r13 == null) goto L5;
        r10.f4840k = r13;
    L5:
        float r14 = r12.f13754k;
        if (r14 == 0.0f) goto L8;
        r10.f4838i = r14;
    L8:
        ColorStateList r15 = r12.f13744a;
        if (r15 == null) goto L11;
        r10.U = r15;
    L11:
        r10.S = r12.f13748e;
        r10.T = r12.f13749f;
        r10.R = r12.f13750g;
        r10.V = r12.f13752i;
        x9.a r16 = r10.f4854y;
        if (r16 == null) goto L14;
        r16.f13743e = true;
    L14:
        com.google.android.material.internal.b r17 = new com.google.android.material.internal.b(r10);
        r12.a();
        r10.f4854y = new x9.a(r17, r12.f13757n);
        r12.c(r11.getContext(), r10.f4854y);
        r10.h(false);
        this.f4991q0 = r10.f4840k;
        if (this.f4984n == null) goto L18;
        v(false, false);
        u();
        return;
    }

    public void setHintTextColor(ColorStateList r8) {
        if (this.f4991q0 != r8) goto L5;
        return;
    L5:
        if (this.f4989p0 != null) goto L9;
        com.google.android.material.internal.c r10 = this.B0;
        if (r10.f4840k == r8) goto L9;
        r10.f4840k = r8;
        r10.h(false);
    L9:
        this.f4991q0 = r8;
        if (this.f4984n == null) goto L14;
        v(false, false);
        return;
    }

    public void setLengthCounter(e r8) {
        this.f5004x = r8;
    }

    public void setMaxEms(int r8) {
        this.f4990q = r8;
        EditText r10 = this.f4984n;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r8 == (-1)) goto L9;
        r10.setMaxEms(r8);
        return;
    }

    public void setMaxWidth(int r8) {
        this.f4994s = r8;
        EditText r10 = this.f4984n;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r8 == (-1)) goto L9;
        r10.setMaxWidth(r8);
        return;
    }

    public void setMaxWidthResource(int r8) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(r8));
    }

    public void setMinEms(int r8) {
        this.f4988p = r8;
        EditText r10 = this.f4984n;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r8 == (-1)) goto L9;
        r10.setMinEms(r8);
        return;
    }

    public void setMinWidth(int r8) {
        this.f4992r = r8;
        EditText r10 = this.f4984n;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r8 == (-1)) goto L9;
        r10.setMinWidth(r8);
        return;
    }

    public void setMinWidthResource(int r8) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(r8));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int r8) {
        m r10 = this.f4982m;
        if (r8 == 0) goto L5;
        CharSequence r11 = r10.getResources().getText(r8);
    L6:
        r10.f5055q.setContentDescription(r11);
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int r8) {
        m r10 = this.f4982m;
        if (r8 == 0) goto L5;
        Drawable r11 = d.a.a(r10.getContext(), r8);
    L6:
        r10.f5055q.setImageDrawable(r11);
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean r8) {
        m r10 = this.f4982m;
        if (r8 == true) goto L5;
    L7:
        if (r8 == true) goto L9;
        r10.g(0);
        return;
    L9:
        r10.getClass();
        return;
    L5:
        if (r10.f5057s == 1) goto L7;
        r10.g(1);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList r8) {
        m r10 = this.f4982m;
        r10.f5059u = r8;
        PorterDuff.Mode r11 = r10.f5060v;
        o.a(r10.f5049a, r10.f5055q, r8, r11);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode r8) {
        m r10 = this.f4982m;
        r10.f5060v = r8;
        ColorStateList r11 = r10.f5059u;
        o.a(r10.f5049a, r10.f5055q, r11, r8);
    }

    public void setPlaceholderText(CharSequence r8) {
        Editable r10 = null;
        if (this.D != null) goto L6;
        y r11 = new y(getContext(), null);
        this.D = r11;
        r11.setId(com.obric.cae.R.id.textinput_placeholder);
        y r12 = this.D;
        WeakHashMap<View, h0> r13 = w.f8437a;
        w.d.s(r12, 2);
        f1.d r14 = e();
        this.G = r14;
        r14.f7263b = 67;
        this.H = e();
        setPlaceholderTextAppearance(this.F);
        setPlaceholderTextColor(this.E);
    L6:
        if (TextUtils.isEmpty(r8) == false) goto L9;
        setPlaceholderTextEnabled(false);
    L12:
        EditText r15 = this.f4984n;
        if (r15 == null) goto L16;
        r10 = r15.getText();
    L16:
        w(r10);
        return;
    L9:
        if (this.C == true) goto L11;
        setPlaceholderTextEnabled(true);
    L11:
        this.B = r8;
        goto L12
    }

    public void setPlaceholderTextAppearance(int r8) {
        this.F = r8;
        y r10 = this.D;
        if (r10 == null) goto L6;
        r10.setTextAppearance(r8);
        return;
    }

    public void setPlaceholderTextColor(ColorStateList r8) {
        if (this.E == r8) goto L9;
        this.E = r8;
        y r10 = this.D;
        if (r10 == null) goto L10;
        if (r8 == null) goto L11;
        r10.setTextColor(r8);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setPrefixText(CharSequence r8) {
        v r10 = this.f4971b;
        r10.getClass();
        if (TextUtils.isEmpty(r8) == false) goto L5;
        CharSequence r11 = null;
    L6:
        r10.f5125m = r11;
        r10.f5124b.setText(r8);
        r10.e();
        return;
    L5:
        r11 = r8;
        goto L6
    }

    public void setPrefixTextAppearance(int r8) {
        this.f4971b.f5124b.setTextAppearance(r8);
    }

    public void setPrefixTextColor(ColorStateList r8) {
        this.f4971b.f5124b.setTextColor(r8);
    }

    public void setShapeAppearanceModel(aa.j r8) {
        aa.f r10 = this.P;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.f139a.f156a == r8) goto L9;
        this.V = r8;
        c();
        return;
    }

    public void setStartIconCheckable(boolean r8) {
        this.f4971b.f5126n.setCheckable(r8);
    }

    public void setStartIconContentDescription(int r8) {
        if (r8 == 0) goto L4;
        CharSequence r10 = getResources().getText(r8);
    L5:
        setStartIconContentDescription(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setStartIconDrawable(int r8) {
        if (r8 == 0) goto L4;
        Drawable r10 = d.a.a(getContext(), r8);
    L5:
        setStartIconDrawable(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setStartIconMinSize(int r8) {
        v r10 = this.f4971b;
        if (r8 >= 0) goto L5;
        r10.getClass();
        throw new IllegalArgumentException("startIconSize cannot be less than 0");
    L5:
        if (r8 == r10.f5129q) goto L10;
        r10.f5129q = r8;
        CheckableImageButton r11 = r10.f5126n;
        r11.setMinimumWidth(r8);
        r11.setMinimumHeight(r8);
        return;
    }

    public void setStartIconOnClickListener(View.OnClickListener r8) {
        v r10 = this.f4971b;
        View.OnLongClickListener r11 = r10.f5131s;
        CheckableImageButton r12 = r10.f5126n;
        r12.setOnClickListener(r8);
        o.d(r12, r11);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener r8) {
        v r10 = this.f4971b;
        r10.f5131s = r8;
        CheckableImageButton r11 = r10.f5126n;
        r11.setOnLongClickListener(r8);
        o.d(r11, r8);
    }

    public void setStartIconScaleType(ImageView.ScaleType r8) {
        v r10 = this.f4971b;
        r10.f5130r = r8;
        r10.f5126n.setScaleType(r8);
    }

    public void setStartIconTintList(ColorStateList r8) {
        v r10 = this.f4971b;
        if (r10.f5127o == r8) goto L6;
        r10.f5127o = r8;
        PorterDuff.Mode r11 = r10.f5128p;
        o.a(r10.f5123a, r10.f5126n, r8, r11);
        return;
    }

    public void setStartIconTintMode(PorterDuff.Mode r8) {
        v r10 = this.f4971b;
        if (r10.f5128p == r8) goto L6;
        r10.f5128p = r8;
        ColorStateList r11 = r10.f5127o;
        o.a(r10.f5123a, r10.f5126n, r11, r8);
        return;
    }

    public void setStartIconVisible(boolean r8) {
        this.f4971b.c(r8);
    }

    public void setSuffixText(CharSequence r8) {
        m r10 = this.f4982m;
        r10.getClass();
        if (TextUtils.isEmpty(r8) == false) goto L5;
        CharSequence r11 = null;
    L6:
        r10.f5064z = r11;
        r10.A.setText(r8);
        r10.n();
        return;
    L5:
        r11 = r8;
        goto L6
    }

    public void setSuffixTextAppearance(int r8) {
        this.f4982m.A.setTextAppearance(r8);
    }

    public void setSuffixTextColor(ColorStateList r8) {
        this.f4982m.A.setTextColor(r8);
    }

    public void setTextInputAccessibilityDelegate(d r8) {
        EditText r10 = this.f4984n;
        if (r10 == null) goto L6;
        w.m(r10, r8);
        return;
    }

    public void setTypeface(Typeface r8) {
        if (r8 == this.f4978i0) goto L16;
        this.f4978i0 = r8;
        this.B0.m(r8);
        p r10 = this.f4996t;
        if (r8 == r10.B) goto L12;
        r10.B = r8;
        y r11 = r10.f5093r;
        if (r11 == null) goto L9;
        r11.setTypeface(r8);
    L9:
        y r12 = r10.f5100y;
        if (r12 == null) goto L12;
        r12.setTypeface(r8);
    L12:
        y r13 = this.f5006y;
        if (r13 == null) goto L17;
        r13.setTypeface(r8);
        return;
    L17:
        return;
    }

    public final void t() {
        EditText r8 = this.f4984n;
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.P != null) goto L7;
        return;
    L7:
        if (this.S == true) goto L11;
        if (r8.getBackground() == null) goto L11;
        return;
    L11:
        if (this.Y == 0) goto L18;
        Drawable r10 = getEditTextBoxBackground();
        EditText r11 = this.f4984n;
        WeakHashMap<View, h0> r12 = w.f8437a;
        w.d.q(r11, r10);
        this.S = true;
        return;
    }

    public final void u() {
        if (this.Y == 1) goto L8;
        FrameLayout r8 = this.f4969a;
        LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) r8.getLayoutParams();
        int r11 = d();
        if (r11 == r10.topMargin) goto L9;
        r10.topMargin = r11;
        r8.requestLayout();
        return;
    L9:
        return;
    }

    public final void v(boolean r10, boolean r11) {
        boolean r8 = isEnabled();
        EditText r12 = this.f4984n;
        if (r12 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        EditText r14 = this.f4984n;
        if (r14 != null) goto L11;
    L13:
        boolean r15 = false;
    L14:
        ColorStateList r16 = this.f4989p0;
        com.google.android.material.internal.c r17 = this.B0;
        if (r16 == null) goto L17;
        r17.i(r16);
    L17:
        Editable r18 = null;
        if (r8 == true) goto L25;
        ColorStateList r19 = this.f4989p0;
        if (r19 == null) goto L22;
        int r20 = r19.getColorForState(new int[]{-16842910}, this.f5009z0);
    L23:
        ColorStateList r21 = ColorStateList.valueOf(r20);
    L35:
        r17.i(r21);
    L42:
        m r22 = this.f4982m;
        v r23 = this.f4971b;
        if (r13 == false) goto L45;
    L77:
        if (r11 == false) goto L79;
    L80:
        ValueAnimator r110 = this.E0;
        if (r110 == null) goto L86;
        if (r110.isRunning() == false) goto L86;
        this.E0.cancel();
    L86:
        if (r10 == true) goto L88;
    L90:
        r17.k(1.0f);
    L91:
        this.A0 = false;
        if (f() == false) goto L94;
        k();
    L94:
        EditText r111 = this.f4984n;
        if (r111 == null) goto L98;
        r18 = r111.getText();
    L98:
        w(r18);
        r23.f5132t = false;
        r23.e();
        r22.B = false;
        r22.n();
        return;
    L88:
        if (this.D0 == false) goto L90;
        b(1.0f);
        goto L91
    L79:
        if (this.A0 == true) goto L80;
        return;
    L45:
        if (this.C0 == false) goto L77;
        if (isEnabled() == false) goto L50;
        if (r15 == true) goto L77;
    L50:
        if (r11 == false) goto L52;
    L53:
        ValueAnimator r112 = this.E0;
        if (r112 == null) goto L59;
        if (r112.isRunning() == false) goto L59;
        this.E0.cancel();
    L59:
        if (r10 == true) goto L61;
    L63:
        r17.k(0.0f);
    L65:
        if (f() == true) goto L67;
    L71:
        this.A0 = true;
        y r113 = this.D;
        if (r113 != null) goto L74;
    L76:
        r23.f5132t = true;
        r23.e();
        r22.B = true;
        r22.n();
        return;
    L74:
        if (this.C == false) goto L76;
        r113.setText(null);
        f1.l.a(this.f4969a, this.H);
        this.D.setVisibility(4);
        goto L76
    L67:
        if ((!((h) this.P).I.f5031v.isEmpty()) == false) goto L71;
        if (f() == false) goto L71;
        ((h) this.P).o(0.0f, 0.0f, 0.0f, 0.0f);
        goto L71
    L61:
        if (this.D0 == false) goto L63;
        b(0.0f);
        goto L65
    L52:
        if (this.A0 == false) goto L53;
        return;
    L22:
        r20 = this.f5009z0;
        goto L23
    L25:
        if (n() == false) goto L31;
        y r24 = this.f4996t.f5093r;
        if (r24 == null) goto L29;
        r21 = r24.getTextColors();
        goto L35
    L29:
        r21 = null;
        goto L35
    L31:
        if (this.f5002w == false) goto L36;
        y r25 = this.f5006y;
        if (r25 == null) goto L36;
        r21 = r25.getTextColors();
    L36:
        if (r15 == false) goto L42;
        ColorStateList r26 = this.f4991q0;
        if (r26 == null) goto L42;
        if (r17.f4840k == r26) goto L42;
        r17.f4840k = r26;
        r17.h(false);
        goto L42
    L11:
        if (r14.hasFocus() == false) goto L13;
        r15 = true;
        goto L14
    L5:
        if (TextUtils.isEmpty(r12.getText()) == true) goto L7;
        r13 = true;
        goto L8
    }

    public final void w(Editable r8) {
        ((o5.o) this.f5004x).getClass();
        int r10 = a(r8);
        FrameLayout r11 = this.f4969a;
        if (r10 == 0) goto L5;
    L13:
        y r12 = this.D;
        if (r12 != null) goto L16;
        return;
    L16:
        if (this.C == false) goto L24;
        r12.setText(null);
        f1.l.a(r11, this.H);
        this.D.setVisibility(4);
        return;
    L24:
        return;
    L5:
        if (this.A0 == true) goto L13;
        if (this.D != null) goto L9;
        return;
    L9:
        if (this.C == true) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(this.B) == true) goto L21;
        this.D.setText(this.B);
        f1.l.a(r11, this.G);
        this.D.setVisibility(0);
        this.D.bringToFront();
        announceForAccessibility(this.B);
        return;
    }

    public final void x(boolean r8, boolean r10) {
        int r11 = this.f4999u0.getDefaultColor();
        int r12 = this.f4999u0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, r11);
        int r13 = this.f4999u0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, r11);
        if (r8 == false) goto L5;
        this.d0 = r13;
        return;
    L5:
        if (r10 == false) goto L7;
        this.d0 = r12;
        return;
    L7:
        this.d0 = r11;
    }

    public final void y() {
        if (this.P != null) goto L5;
        return;
    L5:
        if (this.Y == 0) goto L87;
        boolean r8 = false;
        if (isFocused() == true) goto L15;
        EditText r10 = this.f4984n;
        if (r10 != null) goto L12;
    L14:
        boolean r11 = false;
    L17:
        if (isHovered() == true) goto L22;
        EditText r12 = this.f4984n;
        if (r12 == null) goto L24;
        if (r12.isHovered() == true) goto L22;
    L24:
        if (isEnabled() == true) goto L27;
        int r13 = this.f5009z0;
    L45:
        this.d0 = r13;
    L46:
        q();
        m r14 = this.f4982m;
        r14.l();
        CheckableImageButton r15 = r14.f5051m;
        ColorStateList r16 = r14.f5052n;
        TextInputLayout r17 = r14.f5049a;
        o.c(r17, r15, r16);
        ColorStateList r18 = r14.f5059u;
        CheckableImageButton r19 = r14.f5055q;
        o.c(r17, r19, r18);
        if ((r14.b() instanceof l) == true) goto L49;
    L54:
        v r20 = this.f4971b;
        o.c(r20.f5123a, r20.f5126n, r20.f5127o);
        if (this.Y != 2) goto L73;
        int r21 = this.f4970a0;
        if (r11 == true) goto L59;
    L61:
        int r22 = this.f4972b0;
    L62:
        this.f4970a0 = r22;
        if (r22 == r21) goto L73;
        if (f() == false) goto L73;
        if (this.A0 == true) goto L73;
        if (f() == false) goto L71;
        ((h) this.P).o(0.0f, 0.0f, 0.0f, 0.0f);
    L71:
        k();
        goto L73
    L59:
        if (isEnabled() == false) goto L61;
        r22 = this.f4973c0;
    L73:
        if (this.Y == 1) goto L75;
    L84:
        c();
        return;
    L75:
        if (isEnabled() == true) goto L77;
        int r23 = this.f5003w0;
    L83:
        this.f4974e0 = r23;
        goto L84
    L77:
        if (r8 == false) goto L80;
        if (r11 == true) goto L80;
        r23 = this.f5007y0;
    L80:
        if (r11 == false) goto L82;
        r23 = this.f5005x0;
        goto L83
    L82:
        r23 = this.f5001v0;
        goto L83
    L49:
        if (r17.n() == true) goto L51;
    L53:
        o.a(r17, r19, r14.f5059u, r14.f5060v);
        goto L54
    L51:
        if (r19.getDrawable() == null) goto L53;
        Drawable r24 = r19.getDrawable().mutate();
        b0.a.b.g(r24, r17.getErrorCurrentTextColors());
        r19.setImageDrawable(r24);
        goto L54
    L27:
        if (n() == false) goto L33;
        if (this.f4999u0 != null) goto L38;
        r13 = getErrorCurrentTextColors();
    L38:
        x(r11, r8);
        goto L46
    L33:
        if (this.f5002w == false) goto L40;
        y r25 = this.f5006y;
        if (r25 == null) goto L40;
        if (this.f4999u0 != null) goto L38;
        r13 = r25.getCurrentTextColor();
    L40:
        if (r11 == false) goto L42;
        r13 = this.f4997t0;
        goto L45
    L42:
        if (r8 == false) goto L44;
        r13 = this.f4995s0;
        goto L45
    L44:
        r13 = this.f4993r0;
    L22:
        r8 = true;
        goto L24
    L12:
        if (r10.hasFocus() == false) goto L14;
    L15:
        r11 = true;
        goto L17
    }

    public void setHint(CharSequence r8) {
        if (this.M == false) goto L6;
        setHintInternal(r8);
        sendAccessibilityEvent(2048);
        return;
    }

    public void setStartIconContentDescription(CharSequence r8) {
        CheckableImageButton r10 = this.f4971b.f5126n;
        if (r10.getContentDescription() == r8) goto L6;
        r10.setContentDescription(r8);
        return;
    }

    public void setStartIconDrawable(Drawable r8) {
        this.f4971b.b(r8);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence r8) {
        this.f4982m.f5055q.setContentDescription(r8);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable r8) {
        this.f4982m.f5055q.setImageDrawable(r8);
    }

    public void setErrorIconDrawable(Drawable r8) {
        this.f4982m.i(r8);
    }

    public void setEndIconContentDescription(CharSequence r8) {
        CheckableImageButton r10 = this.f4982m.f5055q;
        if (r10.getContentDescription() == r8) goto L6;
        r10.setContentDescription(r8);
        return;
    }

    public void setEndIconDrawable(Drawable r8) {
        m r10 = this.f4982m;
        CheckableImageButton r11 = r10.f5055q;
        r11.setImageDrawable(r8);
        if (r8 == null) goto L6;
        ColorStateList r12 = r10.f5059u;
        PorterDuff.Mode r13 = r10.f5060v;
        TextInputLayout r14 = r10.f5049a;
        o.a(r14, r11, r12, r13);
        o.c(r14, r11, r10.f5059u);
        return;
    }
}
