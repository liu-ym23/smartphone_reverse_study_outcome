package com.google.android.material.textfield;

import android.animation.ValueAnimator;
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
import android.text.TextUtils;
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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
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
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.k;
import com.google.android.material.internal.r;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.obric.memorydata.plugin.R;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public class TextInputLayout extends LinearLayout {
    private static final int d = 0;
    private ColorStateList A;
    private ColorStateList B;
    private CharSequence C;
    private final TextView D;
    private boolean E;
    private CharSequence F;
    private boolean G;
    private MaterialShapeDrawable H;
    private MaterialShapeDrawable I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private MaterialShapeDrawable f4133J;
    private l K;
    private boolean L;
    private final int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private final Rect U;
    private final Rect V;
    private final RectF W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    EditText f4134a;
    private int aA;
    private int aB;
    private int aC;
    private boolean aD;
    private boolean aE;
    private boolean aF;
    private ValueAnimator aG;
    private boolean aH;
    private boolean aI;
    private Typeface aa;
    private Drawable ab;
    private int ac;
    private final LinkedHashSet<a> ad;
    private int ae;
    private final SparseArray<d> af;
    private final CheckableImageButton ag;
    private final LinkedHashSet<b> ah;
    private ColorStateList ai;
    private PorterDuff.Mode aj;
    private Drawable ak;
    private int al;
    private Drawable am;
    private View.OnLongClickListener an;
    private View.OnLongClickListener ao;
    private final CheckableImageButton ap;
    private ColorStateList aq;
    private PorterDuff.Mode ar;
    private ColorStateList as;
    private ColorStateList at;
    private int au;
    private int av;
    private int aw;
    private ColorStateList ax;
    private int ay;
    private int az;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f4135b;
    final com.google.android.material.internal.b c;
    private final FrameLayout e;
    private final i f;
    private final LinearLayout g;
    private final FrameLayout h;
    private CharSequence i;
    private int j;
    private int k;
    private int l;
    private int m;
    private final f n;
    private int o;
    private boolean p;
    private TextView q;
    private int r;
    private int s;
    private CharSequence t;
    private boolean u;
    private TextView v;
    private ColorStateList w;
    private int x;
    private Fade y;
    private Fade z;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final TextInputLayout layout;

        public AccessibilityDelegate(TextInputLayout r1) {
            this.layout = r1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r13, AccessibilityNodeInfoCompat r14) {
            super.onInitializeAccessibilityNodeInfo(r13, r14);
            EditText r15 = this.layout.getEditText();
            if (r15 == null) goto L5;
            CharSequence r16 = r15.getText();
        L6:
            CharSequence r0 = this.layout.getHint();
            CharSequence r1 = this.layout.getError();
            CharSequence r2 = this.layout.getPlaceholderText();
            int r3 = this.layout.getCounterMaxLength();
            CharSequence r4 = this.layout.getCounterOverflowDescription();
            boolean r5 = !TextUtils.isEmpty(r16);
            boolean r7 = !TextUtils.isEmpty(r0);
            boolean r8 = !this.layout.j();
            boolean r9 = !TextUtils.isEmpty(r1);
            if (r9 == false) goto L9;
        L12:
            boolean r10 = true;
        L13:
            if (r7 == false) goto L15;
            String r6 = r0.toString();
        L16:
            TextInputLayout.d(this.layout).a(r14);
            if (r5 == false) goto L20;
            r14.setText(r16);
        L28:
            if (TextUtils.isEmpty(r6) == false) goto L30;
        L36:
            if (r16 != null) goto L38;
        L40:
            r3 = -1;
        L41:
            r14.setMaxTextLength(r3);
            if (r10 == false) goto L48;
            if (r9 == true) goto L46;
            r1 = r4;
        L46:
            r14.setError(r1);
        L48:
            if (Build.VERSION.SDK_INT < 17) goto L53;
            View r12 = TextInputLayout.e(this.layout).g();
            if (r12 == null) goto L54;
            r14.setLabelFor(r12);
            return;
        L54:
            return;
        L53:
            return;
        L38:
            if (r16.length() != r3) goto L40;
        L30:
            if (Build.VERSION.SDK_INT < 26) goto L32;
            r14.setHintText(r6);
        L35:
            r14.setShowingHintText(!r5);
            goto L36
        L32:
            if (r5 == false) goto L34;
            r6 = r16 + ", " + r6;
        L34:
            r14.setText(r6);
            goto L35
        L20:
            if (TextUtils.isEmpty(r6) == true) goto L25;
            r14.setText(r6);
            if (r8 == false) goto L28;
            if (r2 == null) goto L28;
            r2 = r6 + ", " + r2;
        L26:
            r14.setText(r2);
            goto L28
        L25:
            if (r2 == null) goto L28;
        L15:
            r6 = "";
            goto L16
        L9:
            if (TextUtils.isEmpty(r4) == false) goto L12;
            r10 = false;
            goto L13
        L5:
            r16 = null;
            goto L6
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        CharSequence error;
        CharSequence helperText;
        CharSequence hintText;
        boolean isEndIconChecked;
        CharSequence placeholderText;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r3, ClassLoader r4) {
            super(r3, r4);
            this.error = (CharSequence) ZeusTransformUtils.preCheckCast(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r3), CharSequence.class, "com.obric.memorydata.plugin");
            boolean r0 = true;
            if (r3.readInt() == 1) goto L6;
            r0 = false;
        L6:
            this.isEndIconChecked = r0;
            this.hintText = (CharSequence) ZeusTransformUtils.preCheckCast(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r3), CharSequence.class, "com.obric.memorydata.plugin");
            this.helperText = (CharSequence) ZeusTransformUtils.preCheckCast(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r3), CharSequence.class, "com.obric.memorydata.plugin");
            this.placeholderText = (CharSequence) ZeusTransformUtils.preCheckCast(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r3), CharSequence.class, "com.obric.memorydata.plugin");
        }

        SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + " hint=" + this.hintText + " helperText=" + this.helperText + " placeholderText=" + this.placeholderText + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            TextUtils.writeToParcel(this.error, r2, r3);
            r2.writeInt(this.isEndIconChecked ? 1 : 0);
            TextUtils.writeToParcel(this.hintText, r2, r3);
            TextUtils.writeToParcel(this.helperText, r2, r3);
            TextUtils.writeToParcel(this.placeholderText, r2, r3);
        }
    }

    public interface a {
        void a(TextInputLayout r1);
    }

    public interface b {
        void a(TextInputLayout r1, int r2);
    }

    static {
        d = ZeusTransformUtils.mapRes(R.style.Widget_Design_TextInputLayout, "style", "Widget_Design_TextInputLayout");
    }

    public TextInputLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public TextInputLayout(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.textInputStyle, "attr", "textInputStyle"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v61 */
    public TextInputLayout(Context r30, AttributeSet r31, int r32) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r30, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r31, AttributeSet.class, "com.obric.memorydata.plugin");
        int r10 = d;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r1, r9, r32, r10), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r9, r32);
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = new f(this);
        this.U = new Rect();
        this.V = new Rect();
        this.W = new RectF();
        this.ad = new LinkedHashSet();
        this.ae = 0;
        SparseArray<d> r13 = new SparseArray();
        this.af = r13;
        this.ah = new LinkedHashSet();
        com.google.android.material.internal.b r2 = new com.google.android.material.internal.b(this);
        this.c = r2;
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout r6 = new FrameLayout(r14);
        this.e = r6;
        FrameLayout r5 = new FrameLayout(r14);
        this.h = r5;
        LinearLayout r4 = new LinearLayout(r14);
        this.g = r4;
        AppCompatTextView r3 = new AppCompatTextView(r14);
        this.D = r3;
        r4.setVisibility(8);
        r5.setVisibility(8);
        r3.setVisibility(8);
        LayoutInflater r7 = LayoutInflater.from(r14);
        CheckableImageButton r11 = (CheckableImageButton) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(r7, ZeusTransformUtils.mapRes(R.layout.design_text_input_end_icon, "layout", "design_text_input_end_icon"), r4, false, "com.obric.memorydata.plugin"), CheckableImageButton.class, "com.obric.memorydata.plugin");
        this.ap = r11;
        CheckableImageButton r15 = (CheckableImageButton) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(r7, ZeusTransformUtils.mapRes(R.layout.design_text_input_end_icon, "layout", "design_text_input_end_icon"), r5, false, "com.obric.memorydata.plugin"), CheckableImageButton.class, "com.obric.memorydata.plugin");
        this.ag = r15;
        r6.setAddStatesFromChildren(true);
        r4.setOrientation(0);
        r4.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        r5.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        r2.a(com.google.android.material.a.a.f3741a);
        r2.b(com.google.android.material.a.a.f3741a);
        r2.c(MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START);
        TintTypedArray r8 = k.b(r14, r9, R.styleable.TextInputLayout, r32, r10, new int[]{ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_counterTextAppearance, "styleable", "TextInputLayout_counterTextAppearance"), ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_counterOverflowTextAppearance, "styleable", "TextInputLayout_counterOverflowTextAppearance"), ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_errorTextAppearance, "styleable", "TextInputLayout_errorTextAppearance"), ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_helperTextTextAppearance, "styleable", "TextInputLayout_helperTextTextAppearance"), ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_hintTextAppearance, "styleable", "TextInputLayout_hintTextAppearance")});
        i r12 = new i(this, r8);
        this.f = r12;
        this.E = r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_hintEnabled, "styleable", "TextInputLayout_hintEnabled"), true);
        setHint(r8.getText(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_android_hint, "styleable", "TextInputLayout_android_hint")));
        this.aF = r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_hintAnimationEnabled, "styleable", "TextInputLayout_hintAnimationEnabled"), true);
        this.aE = r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_expandedHintEnabled, "styleable", "TextInputLayout_expandedHintEnabled"), true);
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_android_minEms, "styleable", "TextInputLayout_android_minEms")) == false) goto L6;
        setMinEms(r8.getInt(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_android_minEms, "styleable", "TextInputLayout_android_minEms"), -1));
    L9:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_android_maxEms, "styleable", "TextInputLayout_android_maxEms")) == false) goto L12;
        setMaxEms(r8.getInt(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_android_maxEms, "styleable", "TextInputLayout_android_maxEms"), -1));
    L14:
        this.K = l.a(r14, r9, r32, r10).a();
        this.M = ZeusTransformUtils.getResources(r14, "com.obric.memorydata.plugin").getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.mtrl_textinput_box_label_cutout_padding, "dimen", "mtrl_textinput_box_label_cutout_padding"));
        this.O = r8.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_boxCollapsedPaddingTop, "styleable", "TextInputLayout_boxCollapsedPaddingTop"), 0);
        this.Q = r8.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_boxStrokeWidth, "styleable", "TextInputLayout_boxStrokeWidth"), ZeusTransformUtils.getResources(r14, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_textinput_box_stroke_width_default, "dimen", "mtrl_textinput_box_stroke_width_default")));
        this.R = r8.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_boxStrokeWidthFocused, "styleable", "TextInputLayout_boxStrokeWidthFocused"), ZeusTransformUtils.getResources(r14, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_textinput_box_stroke_width_focused, "dimen", "mtrl_textinput_box_stroke_width_focused")));
        this.P = this.Q;
        float r16 = r8.getDimension(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_boxCornerRadiusTopStart, "styleable", "TextInputLayout_boxCornerRadiusTopStart"), -1.0f);
        float r17 = r8.getDimension(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_boxCornerRadiusTopEnd, "styleable", "TextInputLayout_boxCornerRadiusTopEnd"), -1.0f);
        float r18 = r8.getDimension(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, "styleable", "TextInputLayout_boxCornerRadiusBottomEnd"), -1.0f);
        float r19 = r8.getDimension(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_boxCornerRadiusBottomStart, "styleable", "TextInputLayout_boxCornerRadiusBottomStart"), -1.0f);
        l.a r20 = this.K.n();
        if (r16 < 0.0f) goto L18;
        r20.b(r16);
    L18:
        if (r17 < 0.0f) goto L21;
        r20.c(r17);
    L21:
        if (r18 < 0.0f) goto L24;
        r20.d(r18);
    L24:
        if (r19 < 0.0f) goto L26;
        r20.e(r19);
    L26:
        this.K = r20.a();
        ColorStateList r21 = com.google.android.material.resources.c.a(r14, r8, ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_boxBackgroundColor, "styleable", "TextInputLayout_boxBackgroundColor"));
        if (r21 == null) goto L33;
        int r22 = r21.getDefaultColor();
        this.ay = r22;
        this.T = r22;
        if (r21.isStateful() == false) goto L31;
        this.az = r21.getColorForState(new int[]{-16842910}, -1);
        this.aA = r21.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        int r23 = r21.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
    L32:
        this.aB = r23;
    L35:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_android_textColorHint, "styleable", "TextInputLayout_android_textColorHint")) == false) goto L37;
        ColorStateList r24 = r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_android_textColorHint, "styleable", "TextInputLayout_android_textColorHint"));
        this.at = r24;
        this.as = r24;
    L37:
        ColorStateList r25 = com.google.android.material.resources.c.a(r14, r8, ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_boxStrokeColor, "styleable", "TextInputLayout_boxStrokeColor"));
        this.aw = r8.getColor(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_boxStrokeColor, "styleable", "TextInputLayout_boxStrokeColor"), 0);
        this.au = ContextCompat.getColor(r14, ZeusTransformUtils.mapRes(R.color.mtrl_textinput_default_box_stroke_color, TypedValues.Custom.S_COLOR, "mtrl_textinput_default_box_stroke_color"));
        this.aC = ContextCompat.getColor(r14, ZeusTransformUtils.mapRes(R.color.mtrl_textinput_disabled_color, TypedValues.Custom.S_COLOR, "mtrl_textinput_disabled_color"));
        this.av = ContextCompat.getColor(r14, ZeusTransformUtils.mapRes(R.color.mtrl_textinput_hovered_box_stroke_color, TypedValues.Custom.S_COLOR, "mtrl_textinput_hovered_box_stroke_color"));
        if (r25 == null) goto L41;
        setBoxStrokeColorStateList(r25);
    L41:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_boxStrokeErrorColor, "styleable", "TextInputLayout_boxStrokeErrorColor")) == false) goto L44;
        setBoxStrokeErrorColor(com.google.android.material.resources.c.a(r14, r8, ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_boxStrokeErrorColor, "styleable", "TextInputLayout_boxStrokeErrorColor")));
    L44:
        if (r8.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_hintTextAppearance, "styleable", "TextInputLayout_hintTextAppearance"), -1) == (-1)) goto L46;
        ?? r26 = 0;
        setHintTextAppearance(r8.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_hintTextAppearance, "styleable", "TextInputLayout_hintTextAppearance"), 0));
    L47:
        int r27 = r8.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_errorTextAppearance, "styleable", "TextInputLayout_errorTextAppearance"), r26);
        CharSequence r28 = r8.getText(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_errorContentDescription, "styleable", "TextInputLayout_errorContentDescription"));
        boolean r29 = r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_errorEnabled, "styleable", "TextInputLayout_errorEnabled"), r26);
        r11.setId(ZeusTransformUtils.mapRes(R.id.text_input_error_icon, OaidModel.KEY_ID, "text_input_error_icon"));
        if (com.google.android.material.resources.c.a(r14) == false) goto L51;
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r11.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), 0);
    L51:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_errorIconTint, "styleable", "TextInputLayout_errorIconTint")) == false) goto L54;
        this.aq = com.google.android.material.resources.c.a(r14, r8, ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_errorIconTint, "styleable", "TextInputLayout_errorIconTint"));
    L54:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_errorIconTintMode, "styleable", "TextInputLayout_errorIconTintMode")) == false) goto L57;
        this.ar = r.a(r8.getInt(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_errorIconTintMode, "styleable", "TextInputLayout_errorIconTintMode"), -1), null);
    L57:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_errorIconDrawable, "styleable", "TextInputLayout_errorIconDrawable")) == false) goto L59;
        setErrorIconDrawable(r8.getDrawable(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_errorIconDrawable, "styleable", "TextInputLayout_errorIconDrawable")));
    L59:
        r11.setContentDescription(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getText(ZeusTransformUtils.mapRes(R.string.error_icon_content_description, TypedValues.Custom.S_STRING, "error_icon_content_description")));
        ViewCompat.setImportantForAccessibility(r11, 2);
        r11.setClickable(false);
        r11.setPressable(false);
        r11.setFocusable(false);
        int r33 = r8.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_helperTextTextAppearance, "styleable", "TextInputLayout_helperTextTextAppearance"), 0);
        boolean r110 = r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_helperTextEnabled, "styleable", "TextInputLayout_helperTextEnabled"), false);
        CharSequence r111 = r8.getText(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_helperText, "styleable", "TextInputLayout_helperText"));
        int r34 = r8.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_placeholderTextAppearance, "styleable", "TextInputLayout_placeholderTextAppearance"), 0);
        CharSequence r35 = r8.getText(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_placeholderText, "styleable", "TextInputLayout_placeholderText"));
        int r112 = r8.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_suffixTextAppearance, "styleable", "TextInputLayout_suffixTextAppearance"), 0);
        CharSequence r36 = r8.getText(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_suffixText, "styleable", "TextInputLayout_suffixText"));
        boolean r37 = r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_counterEnabled, "styleable", "TextInputLayout_counterEnabled"), false);
        setCounterMaxLength(r8.getInt(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_counterMaxLength, "styleable", "TextInputLayout_counterMaxLength"), -1));
        this.s = r8.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_counterTextAppearance, "styleable", "TextInputLayout_counterTextAppearance"), 0);
        this.r = r8.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_counterOverflowTextAppearance, "styleable", "TextInputLayout_counterOverflowTextAppearance"), 0);
        setBoxBackgroundMode(r8.getInt(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_boxBackgroundMode, "styleable", "TextInputLayout_boxBackgroundMode"), 0));
        if (com.google.android.material.resources.c.a(r14) == false) goto L62;
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r15.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), 0);
    L62:
        int r38 = r8.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_endIconDrawable, "styleable", "TextInputLayout_endIconDrawable"), 0);
        r13.append(-1, new com.google.android.material.textfield.b(this, r38));
        r13.append(0, new g(this));
        if (r38 != 0) goto L65;
        int r39 = r8.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_passwordToggleDrawable, "styleable", "TextInputLayout_passwordToggleDrawable"), 0);
    L66:
        r13.append(1, new h(this, r39));
        r13.append(2, new com.google.android.material.textfield.a(this, r38));
        r13.append(3, new c(this, r38));
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_passwordToggleEnabled, "styleable", "TextInputLayout_passwordToggleEnabled")) == true) goto L75;
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_endIconTint, "styleable", "TextInputLayout_endIconTint")) == false) goto L72;
        this.ai = com.google.android.material.resources.c.a(r14, r8, ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_endIconTint, "styleable", "TextInputLayout_endIconTint"));
    L72:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_endIconTintMode, "styleable", "TextInputLayout_endIconTintMode")) == false) goto L75;
        this.aj = r.a(r8.getInt(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_endIconTintMode, "styleable", "TextInputLayout_endIconTintMode"), -1), null);
    L75:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_endIconMode, "styleable", "TextInputLayout_endIconMode")) == false) goto L81;
        setEndIconMode(r8.getInt(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_endIconMode, "styleable", "TextInputLayout_endIconMode"), 0));
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_endIconContentDescription, "styleable", "TextInputLayout_endIconContentDescription")) == false) goto L79;
        setEndIconContentDescription(r8.getText(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_endIconContentDescription, "styleable", "TextInputLayout_endIconContentDescription")));
    L79:
        setEndIconCheckable(r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_endIconCheckable, "styleable", "TextInputLayout_endIconCheckable"), true));
    L89:
        r3.setId(ZeusTransformUtils.mapRes(R.id.textinput_suffix_text, OaidModel.KEY_ID, "textinput_suffix_text"));
        r3.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        ViewCompat.setAccessibilityLiveRegion(r3, 1);
        setErrorContentDescription(r28);
        setCounterOverflowTextAppearance(this.r);
        setHelperTextTextAppearance(r33);
        setErrorTextAppearance(r27);
        setCounterTextAppearance(this.s);
        setPlaceholderText(r35);
        setPlaceholderTextAppearance(r34);
        setSuffixTextAppearance(r112);
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_errorTextColor, "styleable", "TextInputLayout_errorTextColor")) == false) goto L93;
        setErrorTextColor(r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_errorTextColor, "styleable", "TextInputLayout_errorTextColor")));
    L93:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_helperTextTextColor, "styleable", "TextInputLayout_helperTextTextColor")) == false) goto L96;
        setHelperTextColor(r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_helperTextTextColor, "styleable", "TextInputLayout_helperTextTextColor")));
    L96:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_hintTextColor, "styleable", "TextInputLayout_hintTextColor")) == false) goto L99;
        setHintTextColor(r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_hintTextColor, "styleable", "TextInputLayout_hintTextColor")));
    L99:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_counterTextColor, "styleable", "TextInputLayout_counterTextColor")) == false) goto L102;
        setCounterTextColor(r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_counterTextColor, "styleable", "TextInputLayout_counterTextColor")));
    L102:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_counterOverflowTextColor, "styleable", "TextInputLayout_counterOverflowTextColor")) == false) goto L105;
        setCounterOverflowTextColor(r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_counterOverflowTextColor, "styleable", "TextInputLayout_counterOverflowTextColor")));
    L105:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_placeholderTextColor, "styleable", "TextInputLayout_placeholderTextColor")) == false) goto L108;
        setPlaceholderTextColor(r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_placeholderTextColor, "styleable", "TextInputLayout_placeholderTextColor")));
    L108:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_suffixTextColor, "styleable", "TextInputLayout_suffixTextColor")) == false) goto L110;
        setSuffixTextColor(r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_suffixTextColor, "styleable", "TextInputLayout_suffixTextColor")));
    L110:
        setEnabled(r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_android_enabled, "styleable", "TextInputLayout_android_enabled"), true));
        r8.recycle();
        ViewCompat.setImportantForAccessibility(this, 2);
        if (Build.VERSION.SDK_INT < 26) goto L113;
        ViewCompat.setImportantForAutofill(this, 1);
    L113:
        r5.addView(r15);
        r4.addView(r3);
        r4.addView(r11);
        r4.addView(r5);
        r6.addView(r12);
        r6.addView(r4);
        addView(r6);
        setHelperTextEnabled(r110);
        setErrorEnabled(r29);
        setCounterEnabled(r37);
        setHelperText(r111);
        setSuffixText(r36);
        return;
    L81:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_passwordToggleEnabled, "styleable", "TextInputLayout_passwordToggleEnabled")) == false) goto L89;
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_passwordToggleTint, "styleable", "TextInputLayout_passwordToggleTint")) == false) goto L86;
        this.ai = com.google.android.material.resources.c.a(r14, r8, ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_passwordToggleTint, "styleable", "TextInputLayout_passwordToggleTint"));
    L86:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_passwordToggleTintMode, "styleable", "TextInputLayout_passwordToggleTintMode")) == false) goto L88;
        this.aj = r.a(r8.getInt(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_passwordToggleTintMode, "styleable", "TextInputLayout_passwordToggleTintMode"), -1), null);
    L88:
        setEndIconMode(r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_passwordToggleEnabled, "styleable", "TextInputLayout_passwordToggleEnabled"), false) ? 1 : 0);
        setEndIconContentDescription(r8.getText(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_passwordToggleContentDescription, "styleable", "TextInputLayout_passwordToggleContentDescription")));
        goto L89
    L65:
        r39 = r38;
        goto L66
    L46:
        r26 = 0;
        goto L47
    L31:
        this.aA = this.ay;
        ColorStateList r40 = AppCompatResources.getColorStateList(r14, ZeusTransformUtils.mapRes(R.color.mtrl_filled_background_color, TypedValues.Custom.S_COLOR, "mtrl_filled_background_color"));
        this.az = r40.getColorForState(new int[]{-16842910}, -1);
        r23 = r40.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
        goto L32
    L33:
        this.T = 0;
        this.ay = 0;
        this.az = 0;
        this.aA = 0;
        this.aB = 0;
        goto L35
    L12:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_android_maxWidth, "styleable", "TextInputLayout_android_maxWidth")) == false) goto L14;
        setMaxWidth(r8.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_android_maxWidth, "styleable", "TextInputLayout_android_maxWidth"), -1));
        goto L14
    L6:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_android_minWidth, "styleable", "TextInputLayout_android_minWidth")) == false) goto L9;
        setMinWidth(r8.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_android_minWidth, "styleable", "TextInputLayout_android_minWidth"), -1));
        goto L9
    }

    private void A() {
        TextView r0 = this.q;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.p == false) goto L7;
        int r1 = this.r;
    L8:
        a(r0, r1);
        if (this.p == true) goto L14;
        ColorStateList r2 = this.A;
        if (r2 == null) goto L14;
        this.q.setTextColor(r2);
    L14:
        if (this.p == false) goto L20;
        ColorStateList r3 = this.B;
        if (r3 == null) goto L21;
        this.q.setTextColor(r3);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r1 = this.s;
        goto L8
    }

    private int B() {
        if (this.E == true) goto L5;
        return 0;
    L5:
        int r0 = this.N;
        if (r0 != 0) goto L8;
        float r3 = this.c.d();
    L12:
        return (int) r3;
    L8:
        if (r0 == 2) goto L10;
        return 0;
    L10:
        r3 = this.c.d() / 2.0f;
        goto L12
    }

    private boolean C() {
        if (this.N == 1) goto L5;
    L9:
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 16) goto L7;
        return true;
    L7:
        if (this.f4134a.getMinLines() > 1) goto L9;
        return true;
    }

    private int D() {
        int r0 = this.T;
        if (this.N == 1) goto L5;
        return r0;
    L5:
        return com.google.android.material.c.a.a(com.google.android.material.c.a.a(this, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"), 0), this.T);
    }

    private void E() {
        MaterialShapeDrawable r0 = this.H;
        if (r0 != null) goto L5;
        return;
    L5:
        l r1 = r0.getShapeAppearanceModel();
        l r2 = this.K;
        if (r1 == r2) goto L9;
        this.H.setShapeAppearanceModel(r2);
        I();
    L9:
        if (G() == false) goto L11;
        this.H.setStroke(this.P, this.S);
    L11:
        int r3 = D();
        this.T = r3;
        this.H.setFillColor(ColorStateList.valueOf(r3));
        if (this.ae != 3) goto L14;
        this.f4134a.getBackground().invalidateSelf();
    L14:
        F();
        invalidate();
    }

    private void F() {
        if (this.I != null) goto L5;
        return;
    L5:
        if (this.f4133J != null) goto L8;
        return;
    L8:
        if (H() == false) goto L14;
        MaterialShapeDrawable r0 = this.I;
        if (this.f4134a.isFocused() == false) goto L12;
        int r1 = this.au;
    L13:
        r0.setFillColor(ColorStateList.valueOf(r1));
        this.f4133J.setFillColor(ColorStateList.valueOf(this.S));
        goto L14
    L12:
        r1 = this.S;
    L14:
        invalidate();
    }

    private boolean G() {
        if (this.N == 2) goto L5;
    L7:
        return false;
    L5:
        if (H() == false) goto L7;
        return true;
    }

    private boolean H() {
        if (this.P > (-1)) goto L5;
    L7:
        return false;
    L5:
        if (this.S == 0) goto L7;
        return true;
    }

    private void I() {
        if (this.ae == 3) goto L5;
        return;
    L5:
        if (this.N != 2) goto L9;
        ((c) ZeusTransformUtils.preCheckCast(this.af.get(3), c.class, "com.obric.memorydata.plugin")).a((AutoCompleteTextView) ZeusTransformUtils.preCheckCast(this.f4134a, AutoCompleteTextView.class, "com.obric.memorydata.plugin"));
        return;
    }

    private boolean J() {
        if (this.f4134a != null) goto L5;
        return false;
    L5:
        int r0 = Math.max(this.g.getMeasuredHeight(), this.f.getMeasuredHeight());
        if (this.f4134a.getMeasuredHeight() >= r0) goto L9;
        this.f4134a.setMinimumHeight(r0);
        return true;
    L9:
        return false;
    }

    private void K() {
        if (this.v == null) goto L8;
        EditText r0 = this.f4134a;
        if (r0 == null) goto L9;
        int r1 = r0.getGravity();
        this.v.setGravity(r1);
        this.v.setPadding(this.f4134a.getCompoundPaddingLeft(), this.f4134a.getCompoundPaddingTop(), this.f4134a.getCompoundPaddingRight(), this.f4134a.getCompoundPaddingBottom());
        return;
    L9:
        return;
    }

    private void L() {
        FrameLayout r0 = this.h;
        int r2 = 8;
        if (this.ag.getVisibility() == 0) goto L5;
    L7:
        int r1 = 8;
    L8:
        r0.setVisibility(r1);
        if (this.C != null) goto L11;
    L13:
        char r3 = '\b';
    L15:
        if (f() == false) goto L17;
    L21:
        boolean r4 = true;
    L22:
        LinearLayout r5 = this.g;
        if (r4 == false) goto L25;
        r2 = 0;
    L25:
        r5.setVisibility(r2);
        return;
    L17:
        if (V() == true) goto L21;
        if (r3 == 0) goto L21;
        r4 = false;
        goto L22
    L11:
        if (j() == true) goto L13;
        r3 = 0;
        goto L15
    L5:
        if (V() == true) goto L7;
        r1 = 0;
        goto L8
    }

    private void M() {
        Iterator<a> r0 = this.ad.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin")).a(this);
        goto L4
    }

    private boolean N() {
        if (this.ae == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean O() {
        if (getStartIconDrawable() != null) goto L9;
        if (getPrefixText() != null) goto L7;
    L11:
        return false;
    L7:
        if (getPrefixTextView().getVisibility() != 0) goto L11;
    L9:
        if (this.f.getMeasuredWidth() <= 0) goto L11;
        return true;
    }

    private boolean P() {
        if (this.ap.getVisibility() == 0) goto L11;
        if (N() == false) goto L9;
        if (f() == true) goto L11;
    L9:
        if (this.C != null) goto L11;
    L13:
        return false;
    L11:
        if (this.g.getMeasuredWidth() <= 0) goto L13;
        return true;
    }

    private boolean Q() {
        if (this.E == true) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(this.F) == true) goto L9;
        if (ZeusTransformUtils.instanceOf(this.H, CutoutDrawable.class) == false) goto L9;
        return true;
    }

    private void R() {
        if (Q() == true) goto L5;
        return;
    L5:
        RectF r0 = this.W;
        this.c.a(r0, this.f4134a.getWidth(), this.f4134a.getGravity());
        a(r0);
        r0.offset(-getPaddingLeft(), ((-getPaddingTop()) - (r0.height() / 2.0f)) + this.P);
        ((CutoutDrawable) ZeusTransformUtils.preCheckCast(this.H, CutoutDrawable.class, "com.obric.memorydata.plugin")).setCutout(r0);
    }

    private void S() {
        if (Q() == true) goto L5;
        return;
    L5:
        if (this.aD == true) goto L9;
        T();
        R();
        return;
    }

    private void T() {
        if (Q() == false) goto L6;
        ((CutoutDrawable) ZeusTransformUtils.preCheckCast(this.H, CutoutDrawable.class, "com.obric.memorydata.plugin")).removeCutout();
        return;
    }

    private void U() {
        int r1 = 0;
        if (getErrorIconDrawable() != null) goto L5;
    L9:
        boolean r0 = false;
    L10:
        CheckableImageButton r2 = this.ap;
        if (r0 == true) goto L14;
        r1 = 8;
    L14:
        r2.setVisibility(r1);
        L();
        z();
        if (N() == true) goto L18;
        h();
        return;
    L18:
        return;
    L5:
        if (this.n.e() == false) goto L9;
        if (this.n.h() == false) goto L9;
        r0 = true;
        goto L10
    }

    private boolean V() {
        if (this.ap.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private int a(int r2, boolean r3) {
        int r4 = r2 + this.f4134a.getCompoundPaddingLeft();
        if (getPrefixText() == null) goto L7;
        if (r3 == false) goto L6;
        return r4;
    L6:
        return (r4 - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
    L7:
        return r4;
    }

    private int a(Rect r2, float r3) {
        if (C() == false) goto L7;
        return (int) (r2.centerY() - (r3 / 2.0f));
    L7:
        return r2.top + this.f4134a.getCompoundPaddingTop();
    }

    private int a(Rect r2, Rect r3, float r4) {
        if (C() == false) goto L7;
        return (int) (r3.top + r4);
    L7:
        return r2.bottom - this.f4134a.getCompoundPaddingBottom();
    }

    private Rect a(Rect r5) {
        if (this.f4134a == null) goto L15;
        Rect r0 = this.V;
        boolean r1 = r.a(this);
        r0.bottom = r5.bottom;
        int r2 = this.N;
        if (r2 != 1) goto L7;
        r0.left = a(r5.left, r1);
        r0.top = r5.top + this.O;
        r0.right = b(r5.right, r1);
        return r0;
    L7:
        if (r2 == 2) goto L10;
        r0.left = a(r5.left, r1);
        r0.top = getPaddingTop();
        r0.right = b(r5.right, r1);
        return r0;
    L10:
        r0.left = r5.left + this.f4134a.getPaddingLeft();
        r0.top = r5.top - B();
        r0.right = r5.right - this.f4134a.getPaddingRight();
        return r0;
    L15:
        throw new IllegalStateException();
    }

    private static void a(Context r2, TextView r3, int r4, int r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r6 == false) goto L5;
        int r8 = R.string.character_counter_overflowed_content_description;
        String r1 = "character_counter_overflowed_content_description";
    L6:
        r3.setContentDescription(r7.getString(ZeusTransformUtils.mapRes(r8, TypedValues.Custom.S_STRING, r1), new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)}));
        return;
    L5:
        r8 = R.string.character_counter_content_description;
        r1 = "character_counter_content_description";
        goto L6
    }

    private void a(Canvas r2) {
        if (this.E == false) goto L6;
        this.c.a(r2);
        return;
    }

    private void a(RectF r3) {
        r3.left -= this.M;
        r3.right += this.M;
    }

    private static void a(ViewGroup r5, boolean r6) {
        int r0 = r5.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        View r2 = r5.getChildAt(r1);
        r2.setEnabled(r6);
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L7;
        a((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin"), r6);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    private static void a(CheckableImageButton r2, View.OnClickListener r3, View.OnLongClickListener r4) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        View.OnLongClickListener r6 = (View.OnLongClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnLongClickListener.class, "com.obric.memorydata.plugin");
        r2.setOnClickListener(r5);
        b(r2, r6);
    }

    private static void a(CheckableImageButton r2, View.OnLongClickListener r3) {
        View.OnLongClickListener r4 = (View.OnLongClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnLongClickListener.class, "com.obric.memorydata.plugin");
        r2.setOnLongClickListener(r4);
        b(r2, r4);
    }

    static /* synthetic */ void a(TextInputLayout r0, int r1) {
        r0.b(r1);
    }

    private void a(boolean r9, boolean r10) {
        boolean r0 = isEnabled();
        EditText r1 = this.f4134a;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        EditText r4 = this.f4134a;
        if (r4 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        boolean r6 = this.n.h();
        ColorStateList r7 = this.as;
        if (r7 == null) goto L17;
        this.c.a(r7);
        this.c.b(this.as);
    L17:
        if (r0 == true) goto L23;
        ColorStateList r3 = this.as;
        if (r3 == null) goto L21;
        int r8 = r3.getColorForState(new int[]{-16842910}, this.aC);
    L22:
        this.c.a(ColorStateList.valueOf(r8));
        this.c.b(ColorStateList.valueOf(r8));
    L35:
        if (r2 == false) goto L37;
    L46:
        if (r10 == false) goto L48;
    L49:
        c(r9);
        return;
    L48:
        if (this.aD == true) goto L49;
        return;
    L37:
        if (this.aE == false) goto L46;
        if (isEnabled() == false) goto L42;
        if (r5 == true) goto L46;
    L42:
        if (r10 == false) goto L44;
    L45:
        d(r9);
        return;
    L44:
        if (this.aD == false) goto L45;
        return;
    L21:
        r8 = this.aC;
        goto L22
    L23:
        if (r6 == false) goto L26;
        this.c.a(this.n.l());
        goto L35
    L26:
        if (this.p == false) goto L31;
        TextView r11 = this.q;
        if (r11 == null) goto L31;
        com.google.android.material.internal.b r12 = this.c;
        ColorStateList r13 = r11.getTextColors();
    L30:
        r12.a(r13);
    L31:
        if (r5 == false) goto L35;
        r13 = this.at;
        if (r13 == null) goto L35;
        r12 = this.c;
        goto L30
    L11:
        if (r4.hasFocus() == false) goto L13;
        r5 = true;
        goto L14
    L5:
        if (TextUtils.isEmpty(r1.getText()) == true) goto L7;
        r2 = true;
        goto L8
    }

    static /* synthetic */ boolean a(TextInputLayout r0) {
        return r0.aI;
    }

    private int b(int r2, boolean r3) {
        int r4 = r2 - this.f4134a.getCompoundPaddingRight();
        if (getPrefixText() == null) goto L7;
        if (r3 == true) goto L6;
        return r4;
    L6:
        return r4 + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
    L7:
        return r4;
    }

    private Rect b(Rect r5) {
        if (this.f4134a == null) goto L7;
        Rect r0 = this.V;
        float r1 = this.c.b();
        r0.left = r5.left + this.f4134a.getCompoundPaddingLeft();
        r0.top = a(r5, r1);
        r0.right = r5.right - this.f4134a.getCompoundPaddingRight();
        r0.bottom = a(r5, r0, r1);
        return r0;
    L7:
        throw new IllegalStateException();
    }

    private void b(int r1) {
        if (r1 == 0) goto L4;
    L6:
        v();
        return;
    L4:
        if (this.aD == true) goto L6;
        u();
    }

    private void b(Canvas r6) {
        if (this.f4133J == null) goto L10;
        MaterialShapeDrawable r0 = this.I;
        if (r0 == null) goto L11;
        r0.draw(r6);
        if (this.f4134a.isFocused() == false) goto L12;
        Rect r1 = this.f4133J.getBounds();
        Rect r2 = this.I.getBounds();
        float r3 = this.c.l();
        int r4 = r2.centerX();
        r1.left = com.google.android.material.a.a.a(r4, r2.left, r3);
        r1.right = com.google.android.material.a.a.a(r4, r2.right, r3);
        this.f4133J.draw(r6);
        return;
    L12:
        return;
    L11:
        return;
    }

    private static void b(CheckableImageButton r3, View.OnLongClickListener r4) {
        View.OnLongClickListener r5 = (View.OnLongClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnLongClickListener.class, "com.obric.memorydata.plugin");
        boolean r0 = ViewCompat.hasOnClickListeners(r3);
        boolean r1 = false;
        int r2 = 1;
        if (r5 == null) goto L5;
        boolean r6 = true;
    L6:
        if (r0 == true) goto L8;
        if (r6 == true) goto L8;
    L9:
        r3.setFocusable(r1);
        r3.setClickable(r0);
        r3.setPressable(r0);
        r3.setLongClickable(r6);
        if (r1 == true) goto L13;
        r2 = 2;
    L13:
        ViewCompat.setImportantForAccessibility(r3, r2);
        return;
    L8:
        r1 = true;
        goto L9
    L5:
        r6 = false;
        goto L6
    }

    private void b(boolean r3) {
        if (r3 == true) goto L4;
    L6:
        e.a(this, this.ag, this.ai, this.aj);
        return;
    L4:
        if (getEndIconDrawable() == null) goto L6;
        Drawable r4 = DrawableCompat.wrap(getEndIconDrawable()).mutate();
        DrawableCompat.setTint(r4, this.n.k());
        this.ag.setImageDrawable(r4);
    }

    private void b(boolean r5, boolean r6) {
        int r0 = this.ax.getDefaultColor();
        int r1 = this.ax.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, r0);
        int r2 = this.ax.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, r0);
        if (r5 == false) goto L5;
        this.S = r2;
        return;
    L5:
        if (r6 == false) goto L7;
        this.S = r1;
        return;
    L7:
        this.S = r0;
    }

    static /* synthetic */ boolean b(TextInputLayout r0) {
        return r0.u;
    }

    static /* synthetic */ CheckableImageButton c(TextInputLayout r0) {
        return r0.ag;
    }

    private void c(int r5) {
        Iterator<b> r0 = this.ah.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin")).a(this, r5);
        goto L4
    }

    private void c(Rect r6) {
        if (this.I == null) goto L6;
        int r0 = r6.bottom - this.Q;
        this.I.setBounds(r6.left, r0, r6.right, r6.bottom);
    L6:
        if (this.f4133J == null) goto L9;
        int r1 = r6.bottom - this.R;
        this.f4133J.setBounds(r6.left, r1, r6.right, r6.bottom);
        return;
    }

    private void c(boolean r2) {
        ValueAnimator r0 = this.aG;
        if (r0 == null) goto L8;
        if (r0.isRunning() == false) goto L8;
        this.aG.cancel();
    L8:
        if (r2 == true) goto L10;
    L12:
        this.c.d(1.0f);
    L13:
        this.aD = false;
        if (Q() == false) goto L16;
        R();
    L16:
        t();
        this.f.c(false);
        y();
        return;
    L10:
        if (this.aF == false) goto L12;
        a(1.0f);
        goto L13
    }

    static /* synthetic */ i d(TextInputLayout r0) {
        return r0.f;
    }

    private void d(boolean r3) {
        ValueAnimator r0 = this.aG;
        if (r0 == null) goto L8;
        if (r0.isRunning() == false) goto L8;
        this.aG.cancel();
    L8:
        if (r3 == true) goto L10;
    L12:
        this.c.d(0.0f);
    L14:
        if (Q() == true) goto L16;
    L18:
        this.aD = true;
        v();
        this.f.c(true);
        y();
        return;
    L16:
        if (((CutoutDrawable) ZeusTransformUtils.preCheckCast(this.H, CutoutDrawable.class, "com.obric.memorydata.plugin")).hasCutout() == false) goto L18;
        T();
        goto L18
    L10:
        if (this.aF == false) goto L12;
        a(0.0f);
        goto L14
    }

    static /* synthetic */ f e(TextInputLayout r0) {
        return r0.n;
    }

    private d getEndIconDelegate() {
        d r0 = (d) ZeusTransformUtils.preCheckCast(this.af.get(this.ae), d.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        return (d) ZeusTransformUtils.preCheckCast(this.af.get(0), d.class, "com.obric.memorydata.plugin");
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.ap.getVisibility() != 0) goto L7;
        return this.ap;
    L7:
        if (N() == true) goto L9;
        return null;
    L9:
        if (f() == true) goto L11;
        return null;
    L11:
        return this.ag;
    }

    private void k() {
        l();
        m();
        i();
        o();
        p();
        if (this.N == 0) goto L6;
        q();
        return;
    }

    private void l() {
        int r0 = this.N;
        if (r0 != 0) goto L5;
        this.H = null;
    L19:
        this.I = null;
        this.f4133J = null;
        return;
    L5:
        if (r0 != 1) goto L7;
        this.H = new MaterialShapeDrawable(this.K);
        this.I = new MaterialShapeDrawable();
        this.f4133J = new MaterialShapeDrawable();
        return;
    L7:
        if (r0 != 2) goto L16;
        if (this.E == true) goto L11;
    L13:
        MaterialShapeDrawable r1 = new MaterialShapeDrawable(this.K);
    L14:
        this.H = r1;
        goto L19
    L11:
        if (ZeusTransformUtils.instanceOf(this.H, CutoutDrawable.class) == true) goto L13;
        r1 = new CutoutDrawable(this.K);
        goto L14
    L16:
        throw new IllegalArgumentException(this.N + " is illegal; only @BoxBackgroundMode constants are supported.");
    }

    private void m() {
        if (n() == false) goto L6;
        ViewCompat.setBackground(this.f4134a, this.H);
        return;
    }

    private boolean n() {
        EditText r0 = this.f4134a;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (this.H == null) goto L11;
        if (r0.getBackground() != null) goto L11;
        if (this.N == 0) goto L11;
        return true;
    }

    private void o() {
        if (this.N == 1) goto L5;
        return;
    L5:
        if (com.google.android.material.resources.c.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L9;
        Resources r0 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        int r1 = R.dimen.material_font_2_0_box_collapsed_padding_top;
        String r3 = "material_font_2_0_box_collapsed_padding_top";
    L7:
        this.O = r0.getDimensionPixelSize(ZeusTransformUtils.mapRes(r1, "dimen", r3));
        return;
    L9:
        if (com.google.android.material.resources.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L13;
        r0 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        r1 = R.dimen.material_font_1_3_box_collapsed_padding_top;
        r3 = "material_font_1_3_box_collapsed_padding_top";
        goto L7
    }

    private void p() {
        if (this.f4134a != null) goto L5;
        return;
    L5:
        if (this.N == 1) goto L8;
        return;
    L8:
        if (com.google.android.material.resources.c.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L12;
        EditText r0 = this.f4134a;
        int r3 = ViewCompat.getPaddingStart(r0);
        int r4 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_filled_edittext_font_2_0_padding_top, "dimen", "material_filled_edittext_font_2_0_padding_top"));
        int r5 = ViewCompat.getPaddingEnd(this.f4134a);
        Resources r7 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        int r1 = R.dimen.material_filled_edittext_font_2_0_padding_bottom;
        String r6 = "material_filled_edittext_font_2_0_padding_bottom";
    L10:
        ViewCompat.setPaddingRelative(r0, r3, r4, r5, r7.getDimensionPixelSize(ZeusTransformUtils.mapRes(r1, "dimen", r6)));
        return;
    L12:
        if (com.google.android.material.resources.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L16;
        r0 = this.f4134a;
        r3 = ViewCompat.getPaddingStart(r0);
        r4 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_filled_edittext_font_1_3_padding_top, "dimen", "material_filled_edittext_font_1_3_padding_top"));
        r5 = ViewCompat.getPaddingEnd(this.f4134a);
        r7 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        r1 = R.dimen.material_filled_edittext_font_1_3_padding_bottom;
        r6 = "material_filled_edittext_font_1_3_padding_bottom";
        goto L10
    }

    private void q() {
        if (this.N == 1) goto L8;
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(this.e.getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        int r1 = B();
        if (r1 == r0.topMargin) goto L9;
        r0.topMargin = r1;
        this.e.requestLayout();
        return;
    L9:
        return;
    }

    private void r() {
        if (this.q == null) goto L10;
        EditText r0 = this.f4134a;
        if (r0 != null) goto L7;
        int r1 = 0;
    L8:
        a(r1);
        return;
    L7:
        r1 = r0.getText().length();
        goto L8
    }

    private Fade s() {
        Fade r2 = new Fade();
        r2.setDuration(87);
        r2.setInterpolator(com.google.android.material.a.a.f3741a);
        return r2;
    }

    private void setEditText(EditText r4) {
        if (this.f4134a != null) goto L38;
        if (this.ae != 3) goto L7;
    L9:
        this.f4134a = r4;
        int r0 = this.j;
        if (r0 == (-1)) goto L12;
        setMinEms(r0);
    L13:
        int r1 = this.k;
        if (r1 == (-1)) goto L16;
        setMaxEms(r1);
    L17:
        k();
        setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
        this.c.c(this.f4134a.getTypeface());
        this.c.a(this.f4134a.getTextSize());
        if (Build.VERSION.SDK_INT < 21) goto L20;
        this.c.b(this.f4134a.getLetterSpacing());
    L20:
        int r2 = this.f4134a.getGravity();
        this.c.c((r2 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 48);
        this.c.b(r2);
        this.f4134a.addTextChangedListener(new AnonymousClass1(this));
        if (this.as != null) goto L24;
        this.as = this.f4134a.getHintTextColors();
    L24:
        if (this.E == false) goto L30;
        if (TextUtils.isEmpty(this.F) == false) goto L28;
        CharSequence r3 = this.f4134a.getHint();
        this.i = r3;
        setHint(r3);
        this.f4134a.setHint(null);
    L28:
        this.G = true;
    L30:
        if (this.q == null) goto L32;
        a(this.f4134a.getText().length());
    L32:
        c();
        this.n.d();
        this.f.bringToFront();
        this.g.bringToFront();
        this.h.bringToFront();
        this.ap.bringToFront();
        M();
        z();
        if (isEnabled() == true) goto L35;
        r4.setEnabled(false);
    L35:
        a(false, true);
        return;
    L16:
        setMaxWidth(this.m);
        goto L17
    L12:
        setMinWidth(this.l);
        goto L13
    L7:
        if (ZeusTransformUtils.instanceOf(r4, TextInputEditText.class) == true) goto L9;
        Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        goto L9
    L38:
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (TextUtils.equals(r4, this.F) == true) goto L8;
        this.F = r4;
        this.c.a(r4);
        if (this.aD == true) goto L9;
        R();
        return;
    L9:
        return;
    }

    private void setPlaceholderTextEnabled(boolean r2) {
        if (this.u != r2) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        w();
    L8:
        this.u = r2;
        return;
    L7:
        x();
        this.v = null;
        goto L8
    }

    private void t() {
        EditText r0 = this.f4134a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        b(r1);
        return;
    L5:
        r1 = r0.getText().length();
        goto L6
    }

    private void u() {
        if (this.v != null) goto L5;
        return;
    L5:
        if (this.u == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.t) == true) goto L14;
        this.v.setText(this.t);
        TransitionManager.beginDelayedTransition(this.e, this.y);
        this.v.setVisibility(0);
        this.v.bringToFront();
        if (Build.VERSION.SDK_INT < 16) goto L15;
        announceForAccessibility(this.t);
        return;
    L15:
        return;
    }

    private void v() {
        TextView r0 = this.v;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.u == false) goto L9;
        r0.setText(null);
        TransitionManager.beginDelayedTransition(this.e, this.z);
        this.v.setVisibility(4);
        return;
    }

    private void w() {
        TextView r0 = this.v;
        if (r0 == null) goto L6;
        this.e.addView(r0);
        this.v.setVisibility(0);
        return;
    }

    private void x() {
        TextView r1 = this.v;
        if (r1 == null) goto L6;
        r1.setVisibility(8);
        return;
    }

    private void y() {
        int r0 = this.D.getVisibility();
        boolean r2 = false;
        if (this.C != null) goto L5;
    L7:
        int r1 = 8;
    L8:
        if (r0 == r1) goto L13;
        d r3 = getEndIconDelegate();
        if (r1 != 0) goto L12;
        r2 = true;
    L12:
        r3.a(r2);
    L13:
        L();
        this.D.setVisibility(r1);
        h();
        return;
    L5:
        if (j() == true) goto L7;
        r1 = 0;
        goto L8
    }

    private void z() {
        if (this.f4134a != null) goto L6;
        return;
    L6:
        if (f() == false) goto L8;
    L11:
        int r0 = 0;
    L12:
        ViewCompat.setPaddingRelative(this.D, ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_input_text_to_prefix_suffix_padding, "dimen", "material_input_text_to_prefix_suffix_padding")), this.f4134a.getPaddingTop(), r0, this.f4134a.getPaddingBottom());
        return;
    L8:
        if (V() == true) goto L11;
        r0 = ViewCompat.getPaddingEnd(this.f4134a);
        goto L12
    }

    void a(float r5) {
        if (this.c.l() != r5) goto L6;
        return;
    L6:
        if (this.aG != null) goto L8;
        ValueAnimator r0 = new ValueAnimator();
        this.aG = r0;
        r0.setInterpolator(com.google.android.material.a.a.f3742b);
        this.aG.setDuration(167);
        this.aG.addUpdateListener(new AnonymousClass4(this));
    L8:
        this.aG.setFloatValues(new float[]{this.c.l(), r5});
        this.aG.start();
    }

    public void a(float r3, float r4, float r5, float r6) {
        boolean r0 = r.a(this);
        this.L = r0;
        if (r0 == false) goto L5;
        float r1 = r4;
    L6:
        if (r0 == true) goto L9;
        r3 = r4;
    L9:
        if (r0 == false) goto L11;
        float r7 = r6;
    L12:
        if (r0 == true) goto L15;
        r5 = r6;
    L15:
        MaterialShapeDrawable r8 = this.H;
        if (r8 != null) goto L18;
    L25:
        this.K = this.K.n().b(r1).c(r3).e(r7).d(r5).a();
        E();
        return;
    L18:
        if (r8.getTopLeftCornerResolvedSize() != r1) goto L25;
        if (this.H.getTopRightCornerResolvedSize() != r3) goto L25;
        if (this.H.getBottomLeftCornerResolvedSize() != r7) goto L25;
        if (this.H.getBottomRightCornerResolvedSize() != r5) goto L25;
        return;
    L11:
        r7 = r5;
        goto L12
    L5:
        r1 = r3;
        goto L6
    }

    void a(int r10) {
        boolean r0 = this.p;
        int r1 = this.o;
        if (r1 != (-1)) goto L6;
        this.q.setText(String.valueOf(r10));
        this.q.setContentDescription(null);
        this.p = false;
    L14:
        if (this.f4134a != null) goto L16;
        return;
    L16:
        if (r0 == this.p) goto L20;
        a(false);
        i();
        c();
        return;
    L20:
        return;
    L6:
        if (r10 <= r1) goto L8;
        boolean r2 = true;
    L9:
        this.p = r2;
        a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.q, r10, this.o, this.p);
        if (r0 == this.p) goto L12;
        A();
    L12:
        this.q.setText(BidiFormatter.getInstance().unicodeWrap(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.character_counter_pattern, TypedValues.Custom.S_STRING, "character_counter_pattern"), new Object[]{Integer.valueOf(r10), Integer.valueOf(this.o)})));
        goto L14
    L8:
        r2 = false;
        goto L9
    }

    void a(TextView r3, int r4) {
        boolean r0 = true;
        TextViewCompat.setTextAppearance(r3, r4);     // Catch: Exception -> L13
        if (Build.VERSION.SDK_INT < 23) goto L9;
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L10;
    L9:
        r0 = false;
    L10:
        if (r0 == false) goto L16;
        TextViewCompat.setTextAppearance(r3, ZeusTransformUtils.mapRes(R.style.TextAppearance_AppCompat_Caption, "style", "TextAppearance_AppCompat_Caption"));
        r3.setTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.design_error, TypedValues.Custom.S_COLOR, "design_error")));
        return;
    }

    public void a(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.ad.add(r4);
        if (this.f4134a == null) goto L6;
        r4.a(this);
        return;
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        this.ah.add(r4);
    }

    void a(boolean r2) {
        a(r2, false);
    }

    public boolean a() {
        return this.G;
    }

    @Override // android.view.ViewGroup
    public void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        if (ZeusTransformUtils.instanceOf(r2, EditText.class) == false) goto L5;
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(r4);
        r5.gravity = (r5.gravity & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 16;
        this.e.addView(r2, r5);
        this.e.setLayoutParams(r4);
        q();
        setEditText((EditText) ZeusTransformUtils.preCheckCast(r2, EditText.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        super.addView(r2, r3, r4);
    }

    public boolean b() {
        return this.n.f();
    }

    void c() {
        EditText r0 = this.f4134a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.N != 0) goto L26;
        Drawable r1 = r0.getBackground();
        if (r1 != null) goto L11;
        return;
    L11:
        if (DrawableUtils.canSafelyMutateDrawable(r1) == false) goto L14;
        r1 = r1.mutate();
    L14:
        if (this.n.h() == false) goto L18;
        int r2 = this.n.k();
    L16:
        r1.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(r2, PorterDuff.Mode.SRC_IN));
        return;
    L18:
        if (this.p == false) goto L22;
        TextView r3 = this.q;
        if (r3 == null) goto L22;
        r2 = r3.getCurrentTextColor();
    L22:
        DrawableCompat.clearColorFilter(r1);
        this.f4134a.refreshDrawableState();
        return;
    }

    public void d() {
        this.f.f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure r5, int r6) {
        EditText r0 = this.f4134a;
        if (r0 != null) goto L6;
        super.dispatchProvideAutofillStructure(r5, r6);
        return;
    L6:
        int r2 = 0;
        if (this.i == null) goto L14;
        boolean r1 = this.G;
        this.G = false;
        CharSequence r3 = r0.getHint();
        this.f4134a.setHint(this.i);
        super.dispatchProvideAutofillStructure(r5, r6);     // Catch: Throwable -> L11
        this.f4134a.setHint(r3);
        this.G = r1;
        return;
    L11:
        th = move-exception;
        this.f4134a.setHint(r3);
        this.G = r1;
        throw th;
    L14:
        r5.setAutofillId(getAutofillId());
        onProvideAutofillStructure(r5, r6);
        onProvideAutofillVirtualStructure(r5, r6);
        r5.setChildCount(this.e.getChildCount());
    L16:
        if (r2 >= this.e.getChildCount()) goto L27;
        View r4 = this.e.getChildAt(r2);
        ViewStructure r7 = r5.newChild(r2);
        r4.dispatchProvideAutofillStructure(r7, r6);
        if (r4 != this.f4134a) goto L20;
        r7.setHint(getHint());
    L20:
        r2 = r2 + 1;
        goto L16
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> r2) {
        this.aI = true;
        super.dispatchRestoreInstanceState(r2);
        this.aI = false;
    }

    @Override // android.view.View
    public void draw(Canvas r1) {
        super.draw(r1);
        a(r1);
        b(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.aH == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        this.aH = true;
        super.drawableStateChanged();
        int[] r1 = getDrawableState();
        com.google.android.material.internal.b r2 = this.c;
        if (r2 == null) goto L8;
        boolean r3 = r2.a(r1) | false;
    L10:
        if (this.f4134a != null) goto L12;
    L18:
        c();
        i();
        if (r3 == false) goto L21;
        invalidate();
    L21:
        this.aH = false;
        return;
    L12:
        if (ViewCompat.isLaidOut(this) == true) goto L14;
    L16:
        r0 = false;
    L17:
        a(r0);
        goto L18
    L14:
        if (isEnabled() == false) goto L16;
    L8:
        r3 = false;
        goto L10
    }

    public void e() {
        e.a(this, this.ap, this.aq);
    }

    public boolean f() {
        if (this.h.getVisibility() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.ag.getVisibility() != 0) goto L7;
        return true;
    }

    public void g() {
        e.a(this, this.ag, this.ai);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText r0 = this.f4134a;
        if (r0 == null) goto L7;
        return (r0.getBaseline() + getPaddingTop()) + B();
    L7:
        return super.getBaseline();
    }

    MaterialShapeDrawable getBoxBackground() {
        int r0 = this.N;
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L10;
        throw new IllegalStateException();
    L10:
        return this.H;
    }

    public int getBoxBackgroundColor() {
        return this.T;
    }

    public int getBoxBackgroundMode() {
        return this.N;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.O;
    }

    public float getBoxCornerRadiusBottomEnd() {
        if (r.a(this) == false) goto L5;
        com.google.android.material.shape.c r0 = this.K.i();
    L7:
        return r0.a(this.W);
    L5:
        r0 = this.K.h();
        goto L7
    }

    public float getBoxCornerRadiusBottomStart() {
        if (r.a(this) == false) goto L5;
        com.google.android.material.shape.c r0 = this.K.h();
    L7:
        return r0.a(this.W);
    L5:
        r0 = this.K.i();
        goto L7
    }

    public float getBoxCornerRadiusTopEnd() {
        if (r.a(this) == false) goto L5;
        com.google.android.material.shape.c r0 = this.K.f();
    L7:
        return r0.a(this.W);
    L5:
        r0 = this.K.g();
        goto L7
    }

    public float getBoxCornerRadiusTopStart() {
        if (r.a(this) == false) goto L5;
        com.google.android.material.shape.c r0 = this.K.g();
    L7:
        return r0.a(this.W);
    L5:
        r0 = this.K.f();
        goto L7
    }

    public int getBoxStrokeColor() {
        return this.aw;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.ax;
    }

    public int getBoxStrokeWidth() {
        return this.Q;
    }

    public int getBoxStrokeWidthFocused() {
        return this.R;
    }

    public int getCounterMaxLength() {
        return this.o;
    }

    CharSequence getCounterOverflowDescription() {
        if (this.f4135b == true) goto L5;
        return null;
    L5:
        if (this.p == false) goto L12;
        TextView r1 = this.q;
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getContentDescription();
    L12:
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.A;
    }

    public ColorStateList getCounterTextColor() {
        return this.A;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.as;
    }

    public EditText getEditText() {
        return this.f4134a;
    }

    public CharSequence getEndIconContentDescription() {
        return this.ag.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.ag.getDrawable();
    }

    public int getEndIconMode() {
        return this.ae;
    }

    CheckableImageButton getEndIconView() {
        return this.ag;
    }

    public CharSequence getError() {
        if (this.n.e() == true) goto L7;
        return null;
    L7:
        return this.n.i();
    }

    public CharSequence getErrorContentDescription() {
        return this.n.m();
    }

    public int getErrorCurrentTextColors() {
        return this.n.k();
    }

    public Drawable getErrorIconDrawable() {
        return this.ap.getDrawable();
    }

    final int getErrorTextCurrentColor() {
        return this.n.k();
    }

    public CharSequence getHelperText() {
        if (this.n.f() == true) goto L7;
        return null;
    L7:
        return this.n.j();
    }

    public int getHelperTextCurrentTextColor() {
        return this.n.n();
    }

    public CharSequence getHint() {
        if (this.E == true) goto L7;
        return null;
    L7:
        return this.F;
    }

    final float getHintCollapsedTextHeight() {
        return this.c.d();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.c.m();
    }

    public ColorStateList getHintTextColor() {
        return this.at;
    }

    public int getMaxEms() {
        return this.k;
    }

    public int getMaxWidth() {
        return this.m;
    }

    public int getMinEms() {
        return this.j;
    }

    public int getMinWidth() {
        return this.l;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.ag.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.ag.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.u == true) goto L7;
        return null;
    L7:
        return this.t;
    }

    public int getPlaceholderTextAppearance() {
        return this.x;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.w;
    }

    public CharSequence getPrefixText() {
        return this.f.b();
    }

    public ColorStateList getPrefixTextColor() {
        return this.f.c();
    }

    public TextView getPrefixTextView() {
        return this.f.a();
    }

    public CharSequence getStartIconContentDescription() {
        return this.f.g();
    }

    public Drawable getStartIconDrawable() {
        return this.f.d();
    }

    public CharSequence getSuffixText() {
        return this.C;
    }

    public ColorStateList getSuffixTextColor() {
        return this.D.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.D;
    }

    public Typeface getTypeface() {
        return this.aa;
    }

    boolean h() {
        if (this.f4134a != null) goto L5;
        return false;
    L5:
        boolean r5 = true;
        if (O() == false) goto L16;
        int r0 = this.f.getMeasuredWidth() - this.f4134a.getPaddingLeft();
        if (this.ab != null) goto L10;
    L11:
        ColorDrawable r6 = new ColorDrawable();
        this.ab = r6;
        this.ac = r0;
        r6.setBounds(0, 0, r0, 1);
    L12:
        Drawable[] r1 = TextViewCompat.getCompoundDrawablesRelative(this.f4134a);
        Drawable r7 = r1[0];
        Drawable r8 = this.ab;
        if (r7 == r8) goto L19;
        TextViewCompat.setCompoundDrawablesRelative(this.f4134a, r8, r1[1], r1[2], r1[3]);
    L18:
        boolean r2 = true;
    L21:
        if (P() == false) goto L37;
        int r3 = this.D.getMeasuredWidth() - this.f4134a.getPaddingRight();
        CheckableImageButton r9 = getEndIconToUpdateDummyDrawable();
        if (r9 == null) goto L25;
        r3 = (r3 + r9.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"));
    L25:
        Drawable[] r10 = TextViewCompat.getCompoundDrawablesRelative(this.f4134a);
        Drawable r11 = this.ak;
        if (r11 != null) goto L28;
    L30:
        if (r11 != null) goto L32;
        ColorDrawable r12 = new ColorDrawable();
        this.ak = r12;
        this.al = r3;
        r12.setBounds(0, 0, r3, 1);
    L32:
        Drawable r4 = r10[2];
        Drawable r13 = this.ak;
        if (r4 == r13) goto L35;
        this.am = r10[2];
        TextViewCompat.setCompoundDrawablesRelative(this.f4134a, r10[0], r10[1], r13, r10[3]);
    L44:
        return r5;
    L35:
        r5 = r2;
        goto L44
    L28:
        if (this.al == r3) goto L30;
        this.al = r3;
        r11.setBounds(0, 0, r3, 1);
        TextViewCompat.setCompoundDrawablesRelative(this.f4134a, r10[0], r10[1], this.ak, r10[3]);
        goto L44
    L37:
        if (this.ak == null) goto L45;
        Drawable[] r14 = TextViewCompat.getCompoundDrawablesRelative(this.f4134a);
        if (r14[2] != this.ak) goto L41;
        TextViewCompat.setCompoundDrawablesRelative(this.f4134a, r14[0], r14[1], this.am, r14[3]);
    L42:
        this.ak = null;
        goto L44
    L41:
        r5 = r2;
        goto L42
    L45:
        return r2;
    L19:
        r2 = false;
        goto L21
    L10:
        if (this.ac == r0) goto L12;
    L16:
        if (this.ab == null) goto L19;
        Drawable[] r15 = TextViewCompat.getCompoundDrawablesRelative(this.f4134a);
        TextViewCompat.setCompoundDrawablesRelative(this.f4134a, null, r15[1], r15[2], r15[3]);
        this.ab = null;
        goto L18
    }

    void i() {
        if (this.H != null) goto L5;
        return;
    L5:
        if (this.N == 0) goto L75;
        boolean r1 = false;
        if (isFocused() == true) goto L15;
        EditText r0 = this.f4134a;
        if (r0 != null) goto L12;
    L14:
        boolean r2 = false;
    L17:
        if (isHovered() == true) goto L22;
        EditText r3 = this.f4134a;
        if (r3 == null) goto L24;
        if (r3.isHovered() == true) goto L22;
    L24:
        if (isEnabled() == true) goto L28;
        int r4 = this.aC;
    L26:
        this.S = r4;
    L46:
        U();
        e();
        d();
        g();
        if (getEndIconDelegate().b() == false) goto L50;
        b(this.n.h());
    L50:
        if (this.N != 2) goto L61;
        int r5 = this.P;
        if (r2 == true) goto L54;
    L56:
        int r6 = this.Q;
    L57:
        this.P = r6;
        if (this.P == r5) goto L61;
        S();
        goto L61
    L54:
        if (isEnabled() == false) goto L56;
        r6 = this.R;
    L61:
        if (this.N == 1) goto L63;
    L72:
        E();
        return;
    L63:
        if (isEnabled() == true) goto L66;
        int r7 = this.az;
    L65:
        this.T = r7;
        goto L72
    L66:
        if (r1 == false) goto L69;
        if (r2 == true) goto L69;
        r7 = this.aB;
    L69:
        if (r2 == false) goto L71;
        r7 = this.aA;
        goto L65
    L71:
        r7 = this.ay;
        goto L65
    L28:
        if (this.n.h() == false) goto L34;
        if (this.ax == null) goto L32;
    L31:
        b(r2, r1);
        goto L46
    L32:
        r4 = this.n.k();
        goto L26
    L34:
        if (this.p == false) goto L41;
        TextView r8 = this.q;
        if (r8 == null) goto L41;
        if (this.ax != null) goto L31;
        r4 = r8.getCurrentTextColor();
    L41:
        if (r2 == false) goto L43;
        r4 = this.aw;
        goto L26
    L43:
        if (r1 == false) goto L45;
        r4 = this.av;
        goto L26
    L45:
        r4 = this.au;
    L22:
        r1 = true;
        goto L24
    L12:
        if (r0.hasFocus() == false) goto L14;
    L15:
        r2 = true;
        goto L17
    }

    final boolean j() {
        return this.aD;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        this.c.a(r1);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        EditText r6 = this.f4134a;
        if (r6 == null) goto L12;
        Rect r7 = this.U;
        com.google.android.material.internal.d.b(this, r6, r7);
        c(r7);
        if (this.E == false) goto L13;
        this.c.a(this.f4134a.getTextSize());
        int r8 = this.f4134a.getGravity();
        this.c.c((r8 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 48);
        this.c.b(r8);
        this.c.b(a(r7));
        this.c.a(b(r7));
        this.c.n();
        if (Q() == true) goto L9;
        return;
    L9:
        if (this.aD == true) goto L15;
        R();
        return;
    L15:
        return;
    L13:
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        boolean r3 = J();
        boolean r4 = h();
        if (r3 == true) goto L5;
        if (r4 == true) goto L5;
    L6:
        K();
        z();
        return;
    L5:
        this.f4134a.post(new AnonymousClass3(this));
        goto L6
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.memorydata.plugin");
        super.onRestoreInstanceState(r5.getSuperState());
        setError(r5.error);
        if (r5.isEndIconChecked == false) goto L9;
        this.ag.post(new AnonymousClass2(this));
    L9:
        setHint(r5.hintText);
        setHelperText(r5.helperText);
        setPlaceholderText(r5.placeholderText);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int r6) {
        super.onRtlPropertiesChanged(r6);
        boolean r0 = false;
        if (r6 != 1) goto L5;
        boolean r7 = true;
    L6:
        boolean r2 = this.L;
        if (r7 == r2) goto L24;
        if (r7 == false) goto L11;
        if (r2 == true) goto L11;
        r0 = true;
    L11:
        float r8 = this.K.f().a(this.W);
        float r1 = this.K.g().a(this.W);
        float r3 = this.K.i().a(this.W);
        float r4 = this.K.h().a(this.W);
        if (r0 == false) goto L14;
        float r5 = r8;
    L15:
        if (r0 == false) goto L17;
        r8 = r1;
    L17:
        if (r0 == false) goto L19;
        float r9 = r3;
    L20:
        if (r0 == false) goto L22;
        r3 = r4;
    L22:
        a(r5, r8, r9, r3);
        return;
    L19:
        r9 = r4;
        goto L20
    L14:
        r5 = r1;
        goto L15
    L24:
        return;
    L5:
        r7 = false;
        goto L6
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        if (this.n.h() == false) goto L6;
        r1.error = getError();
    L6:
        if (N() == true) goto L8;
    L10:
        boolean r0 = false;
    L11:
        r1.isEndIconChecked = r0;
        r1.hintText = getHint();
        r1.helperText = getHelperText();
        r1.placeholderText = getPlaceholderText();
        return r1;
    L8:
        if (this.ag.isChecked() == false) goto L10;
        r0 = true;
        goto L11
    }

    public void setBoxBackgroundColor(int r2) {
        if (this.T == r2) goto L6;
        this.T = r2;
        this.ay = r2;
        this.aA = r2;
        this.aB = r2;
        E();
        return;
    }

    public void setBoxBackgroundColorResource(int r4) {
        setBoxBackgroundColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    public void setBoxBackgroundColorStateList(ColorStateList r4) {
        int r0 = r4.getDefaultColor();
        this.ay = r0;
        this.T = r0;
        this.az = r4.getColorForState(new int[]{-16842910}, -1);
        this.aA = r4.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.aB = r4.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        E();
    }

    public void setBoxBackgroundMode(int r2) {
        if (r2 != this.N) goto L5;
        return;
    L5:
        this.N = r2;
        if (this.f4134a == null) goto L9;
        k();
        return;
    }

    public void setBoxCollapsedPaddingTop(int r1) {
        this.O = r1;
    }

    public void setBoxStrokeColor(int r2) {
        if (this.aw == r2) goto L6;
        this.aw = r2;
        i();
        return;
    }

    public void setBoxStrokeColorStateList(ColorStateList r4) {
        if (r4.isStateful() == false) goto L7;
        this.au = r4.getDefaultColor();
        this.aC = r4.getColorForState(new int[]{-16842910}, -1);
        this.av = r4.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        int r5 = r4.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
    L5:
        this.aw = r5;
    L9:
        i();
        return;
    L7:
        if (this.aw == r4.getDefaultColor()) goto L9;
        r5 = r4.getDefaultColor();
        goto L5
    }

    public void setBoxStrokeErrorColor(ColorStateList r2) {
        if (this.ax == r2) goto L6;
        this.ax = r2;
        i();
        return;
    }

    public void setBoxStrokeWidth(int r1) {
        this.Q = r1;
        i();
    }

    public void setBoxStrokeWidthFocused(int r1) {
        this.R = r1;
        i();
    }

    public void setBoxStrokeWidthFocusedResource(int r2) {
        setBoxStrokeWidthFocused(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(r2));
    }

    public void setBoxStrokeWidthResource(int r2) {
        setBoxStrokeWidth(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(r2));
    }

    public void setCounterEnabled(boolean r7) {
        if (this.f4135b != r7) goto L5;
        return;
    L5:
        if (r7 == false) goto L10;
        AppCompatTextView r1 = new AppCompatTextView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.q = r1;
        r1.setId(ZeusTransformUtils.mapRes(R.id.textinput_counter, OaidModel.KEY_ID, "textinput_counter"));
        Typeface r2 = this.aa;
        if (r2 == null) goto L9;
        this.q.setTypeface(r2);
    L9:
        this.q.setMaxLines(1);
        this.n.a(this.q, 2);
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(this.q.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.mtrl_textinput_counter_margin_start, "dimen", "mtrl_textinput_counter_margin_start")));
        A();
        r();
    L11:
        this.f4135b = r7;
        return;
    L10:
        this.n.b(this.q, 2);
        this.q = null;
        goto L11
    }

    public void setCounterMaxLength(int r2) {
        if (this.o == r2) goto L11;
        if (r2 > 0) goto L7;
        r2 = -1;
    L7:
        this.o = r2;
        if (this.f4135b == false) goto L12;
        r();
        return;
    L12:
        return;
    }

    public void setCounterOverflowTextAppearance(int r2) {
        if (this.r == r2) goto L6;
        this.r = r2;
        A();
        return;
    }

    public void setCounterOverflowTextColor(ColorStateList r2) {
        if (this.B == r2) goto L6;
        this.B = r2;
        A();
        return;
    }

    public void setCounterTextAppearance(int r2) {
        if (this.s == r2) goto L6;
        this.s = r2;
        A();
        return;
    }

    public void setCounterTextColor(ColorStateList r2) {
        if (this.A == r2) goto L6;
        this.A = r2;
        A();
        return;
    }

    public void setDefaultHintTextColor(ColorStateList r1) {
        this.as = r1;
        this.at = r1;
        if (this.f4134a == null) goto L6;
        a(false);
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        a(this, r1);
        super.setEnabled(r1);
    }

    public void setEndIconActivated(boolean r1) {
        this.ag.setActivated(r1);
    }

    public void setEndIconCheckable(boolean r1) {
        this.ag.setCheckable(r1);
    }

    public void setEndIconContentDescription(int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getText(r2);
    L5:
        setEndIconContentDescription(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setEndIconContentDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (getEndIconContentDescription() == r4) goto L6;
        this.ag.setContentDescription(r4);
        return;
    }

    public void setEndIconDrawable(int r4) {
        if (r4 == 0) goto L4;
        Drawable r5 = AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    L5:
        setEndIconDrawable(r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    public void setEndIconDrawable(Drawable r3) {
        this.ag.setImageDrawable(r3);
        if (r3 == null) goto L6;
        e.a(this, this.ag, this.ai, this.aj);
        g();
        return;
    }

    public void setEndIconMode(int r4) {
        int r0 = this.ae;
        if (r0 != r4) goto L5;
        return;
    L5:
        this.ae = r4;
        c(r0);
        if (r4 == 0) goto L8;
        boolean r1 = true;
    L9:
        setEndIconVisible(r1);
        if (getEndIconDelegate().a(this.N) == false) goto L14;
        getEndIconDelegate().a();
        e.a(this, this.ag, this.ai, this.aj);
        return;
    L14:
        throw new IllegalStateException("The current box background mode " + this.N + " is not supported by the end icon mode " + r4);
    L8:
        r1 = false;
        goto L9
    }

    public void setEndIconOnClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        a(this.ag, r4, this.an);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener r3) {
        View.OnLongClickListener r4 = (View.OnLongClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnLongClickListener.class, "com.obric.memorydata.plugin");
        this.an = r4;
        a(this.ag, r4);
    }

    public void setEndIconTintList(ColorStateList r3) {
        if (this.ai == r3) goto L6;
        this.ai = r3;
        e.a(this, this.ag, r3, this.aj);
        return;
    }

    public void setEndIconTintMode(PorterDuff.Mode r3) {
        if (this.aj == r3) goto L6;
        this.aj = r3;
        e.a(this, this.ag, this.ai, r3);
        return;
    }

    public void setEndIconVisible(boolean r2) {
        if (f() == r2) goto L10;
        CheckableImageButton r0 = this.ag;
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        L();
        z();
        h();
        return;
    L7:
        r3 = 8;
        goto L8
    }

    public void setError(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.n.e() == false) goto L5;
    L8:
        boolean r0 = TextUtils.isEmpty(r4);
        f r2 = this.n;
        if (r0 == true) goto L11;
        r2.b(r4);
        return;
    L11:
        r2.b();
        return;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return;
    L7:
        setErrorEnabled(true);
        goto L8
    }

    public void setErrorContentDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.n.c(r4);
    }

    public void setErrorEnabled(boolean r1) {
        this.n.a(r1);
    }

    public void setErrorIconDrawable(int r4) {
        if (r4 == 0) goto L4;
        Drawable r5 = AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    L5:
        setErrorIconDrawable(r5);
        e();
        return;
    L4:
        r5 = null;
        goto L5
    }

    public void setErrorIconDrawable(Drawable r3) {
        this.ap.setImageDrawable(r3);
        U();
        e.a(this, this.ap, this.aq, this.ar);
    }

    public void setErrorIconOnClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        a(this.ap, r4, this.ao);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener r3) {
        View.OnLongClickListener r4 = (View.OnLongClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnLongClickListener.class, "com.obric.memorydata.plugin");
        this.ao = r4;
        a(this.ap, r4);
    }

    public void setErrorIconTintList(ColorStateList r3) {
        if (this.aq == r3) goto L6;
        this.aq = r3;
        e.a(this, this.ap, r3, this.ar);
        return;
    }

    public void setErrorIconTintMode(PorterDuff.Mode r3) {
        if (this.ar == r3) goto L6;
        this.ar = r3;
        e.a(this, this.ap, this.aq, r3);
        return;
    }

    public void setErrorTextAppearance(int r1) {
        this.n.b(r1);
    }

    public void setErrorTextColor(ColorStateList r1) {
        this.n.a(r1);
    }

    public void setExpandedHintEnabled(boolean r2) {
        if (this.aE == r2) goto L6;
        this.aE = r2;
        a(false);
        return;
    }

    public void setHelperText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r4) == false) goto L8;
        if (b() == false) goto L12;
        setHelperTextEnabled(false);
        return;
    L12:
        return;
    L8:
        if (b() == true) goto L10;
        setHelperTextEnabled(true);
    L10:
        this.n.a(r4);
    }

    public void setHelperTextColor(ColorStateList r1) {
        this.n.b(r1);
    }

    public void setHelperTextEnabled(boolean r1) {
        this.n.b(r1);
    }

    public void setHelperTextTextAppearance(int r1) {
        this.n.c(r1);
    }

    public void setHint(int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getText(r2);
    L5:
        setHint(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setHint(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.E == false) goto L6;
        setHintInternal(r4);
        sendAccessibilityEvent(2048);
        return;
    }

    public void setHintAnimationEnabled(boolean r1) {
        this.aF = r1;
    }

    public void setHintEnabled(boolean r3) {
        if (r3 == this.E) goto L23;
        this.E = r3;
        if (r3 == true) goto L12;
        this.G = false;
        if (TextUtils.isEmpty(this.F) == false) goto L9;
    L11:
        setHintInternal(null);
    L20:
        if (this.f4134a == null) goto L24;
        q();
        return;
    L24:
        return;
    L9:
        if (TextUtils.isEmpty(this.f4134a.getHint()) == false) goto L11;
        this.f4134a.setHint(this.F);
        goto L11
    L12:
        CharSequence r4 = this.f4134a.getHint();
        if (TextUtils.isEmpty(r4) == false) goto L15;
    L18:
        this.G = true;
        goto L20
    L15:
        if (TextUtils.isEmpty(this.F) == false) goto L17;
        setHint(r4);
    L17:
        this.f4134a.setHint(null);
        goto L18
    }

    public void setHintTextAppearance(int r2) {
        this.c.d(r2);
        this.at = this.c.v();
        if (this.f4134a == null) goto L6;
        a(false);
        q();
        return;
    }

    public void setHintTextColor(ColorStateList r2) {
        if (this.at != r2) goto L5;
        return;
    L5:
        if (this.as != null) goto L7;
        this.c.a(r2);
    L7:
        this.at = r2;
        if (this.f4134a == null) goto L12;
        a(false);
        return;
    }

    public void setMaxEms(int r2) {
        this.k = r2;
        EditText r1 = this.f4134a;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 == (-1)) goto L9;
        r1.setMaxEms(r2);
        return;
    }

    public void setMaxWidth(int r2) {
        this.m = r2;
        EditText r1 = this.f4134a;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 == (-1)) goto L9;
        r1.setMaxWidth(r2);
        return;
    }

    public void setMaxWidthResource(int r4) {
        setMaxWidth(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(r4));
    }

    public void setMinEms(int r2) {
        this.j = r2;
        EditText r1 = this.f4134a;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 == (-1)) goto L9;
        r1.setMinEms(r2);
        return;
    }

    public void setMinWidth(int r2) {
        this.l = r2;
        EditText r1 = this.f4134a;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 == (-1)) goto L9;
        r1.setMinWidth(r2);
        return;
    }

    public void setMinWidthResource(int r4) {
        setMinWidth(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(r4));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getText(r2);
    L5:
        setPasswordVisibilityToggleContentDescription(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.ag.setContentDescription(r4);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int r4) {
        if (r4 == 0) goto L4;
        Drawable r5 = AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    L5:
        setPasswordVisibilityToggleDrawable(r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable r1) {
        this.ag.setImageDrawable(r1);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean r3) {
        if (r3 == true) goto L4;
    L6:
        if (r3 == true) goto L10;
        setEndIconMode(0);
        return;
    L10:
        return;
    L4:
        if (this.ae == 1) goto L6;
        setEndIconMode(1);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList r3) {
        this.ai = r3;
        e.a(this, this.ag, r3, this.aj);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode r3) {
        this.aj = r3;
        e.a(this, this.ag, this.ai, r3);
    }

    public void setPlaceholderText(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.v != null) goto L6;
        AppCompatTextView r0 = new AppCompatTextView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.v = r0;
        r0.setId(ZeusTransformUtils.mapRes(R.id.textinput_placeholder, OaidModel.KEY_ID, "textinput_placeholder"));
        ViewCompat.setImportantForAccessibility(this.v, 2);
        Fade r1 = s();
        this.y = r1;
        r1.setStartDelay(67);
        this.z = s();
        setPlaceholderTextAppearance(this.x);
        setPlaceholderTextColor(this.w);
    L6:
        if (TextUtils.isEmpty(r6) == false) goto L9;
        setPlaceholderTextEnabled(false);
    L12:
        t();
        return;
    L9:
        if (this.u == true) goto L11;
        setPlaceholderTextEnabled(true);
    L11:
        this.t = r6;
        goto L12
    }

    public void setPlaceholderTextAppearance(int r1) {
        this.x = r1;
        TextView r0 = this.v;
        if (r0 == null) goto L6;
        TextViewCompat.setTextAppearance(r0, r1);
        return;
    }

    public void setPlaceholderTextColor(ColorStateList r2) {
        if (this.w == r2) goto L9;
        this.w = r2;
        TextView r1 = this.v;
        if (r1 == null) goto L10;
        if (r2 == null) goto L11;
        r1.setTextColor(r2);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setPrefixText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.f.a(r4);
    }

    public void setPrefixTextAppearance(int r1) {
        this.f.a(r1);
    }

    public void setPrefixTextColor(ColorStateList r1) {
        this.f.a(r1);
    }

    public void setStartIconCheckable(boolean r1) {
        this.f.b(r1);
    }

    public void setStartIconContentDescription(int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getText(r2);
    L5:
        setStartIconContentDescription(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setStartIconContentDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.f.b(r4);
    }

    public void setStartIconDrawable(int r4) {
        if (r4 == 0) goto L4;
        Drawable r5 = AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    L5:
        setStartIconDrawable(r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    public void setStartIconDrawable(Drawable r1) {
        this.f.a(r1);
    }

    public void setStartIconOnClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        this.f.a(r4);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener r3) {
        View.OnLongClickListener r4 = (View.OnLongClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnLongClickListener.class, "com.obric.memorydata.plugin");
        this.f.a(r4);
    }

    public void setStartIconTintList(ColorStateList r1) {
        this.f.b(r1);
    }

    public void setStartIconTintMode(PorterDuff.Mode r1) {
        this.f.a(r1);
    }

    public void setStartIconVisible(boolean r1) {
        this.f.a(r1);
    }

    public void setSuffixText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r4) == false) goto L5;
        CharSequence r0 = null;
    L6:
        this.C = r0;
        this.D.setText(r4);
        y();
        return;
    L5:
        r0 = r4;
        goto L6
    }

    public void setSuffixTextAppearance(int r1) {
        TextViewCompat.setTextAppearance(this.D, r1);
    }

    public void setSuffixTextColor(ColorStateList r1) {
        this.D.setTextColor(r1);
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate r1) {
        EditText r0 = this.f4134a;
        if (r0 == null) goto L6;
        ViewCompat.setAccessibilityDelegate(r0, r1);
        return;
    }

    public void setTypeface(Typeface r2) {
        if (r2 == this.aa) goto L8;
        this.aa = r2;
        this.c.c(r2);
        this.n.a(r2);
        TextView r1 = this.q;
        if (r1 == null) goto L9;
        r1.setTypeface(r2);
        return;
    L9:
        return;
    }
}
