package com.obric.oui.forms;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.cae.R;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.text.OTextView;
import ge.l;
import he.i;
import ic.d;
import ic.e;
import ic.f;
import ic.g;
import ic.h;
import ic.j;
import ic.k;
import j0.b0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ClickableViewAccessibility"})
public class OInputView extends ConstraintLayout {

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final /* synthetic */ int f6291v0 = 0;
    public boolean A;
    public int B;
    public boolean C;
    public int D;
    public float E;
    public float F;
    public boolean G;
    public final boolean H;
    public final boolean I;
    public boolean J;
    public int K;
    public boolean L;
    public boolean M;
    public boolean N;
    public String O;
    public boolean P;
    public boolean Q;
    public Integer R;
    public String S;
    public int T;
    public String U;
    public String V;
    public final boolean W;
    public int X;
    public final OUIConstraintLayout Y;
    public final LinearLayout Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final OTextView f6292a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final ImageView f6293b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final OEditText f6294c0;
    public final FrameLayout d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final FrameLayout f6295e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final View f6296f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final View f6297g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final View f6298h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final ImageView f6299i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final View f6300j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final OTextView f6301k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final OTextView f6302l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final OTextView f6303m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final TextView f6304n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f6305o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public View.OnClickListener f6306p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f6307q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f6308r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f6309s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public ValueAnimator f6310t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public ValueAnimator f6311u0;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6312a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f6313b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f6314m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final /* synthetic */ a[] f6315n = null;

        static {
            a r8 = new a("REAL_LABEL_SHOW", 0);
            f6312a = r8;
            a r10 = new a("FAKE_LABEL_SHOW", 1);
            f6313b = r10;
            a r11 = new a("LABEL_NONE", 2);
            f6314m = r11;
            f6315n = new a[]{r8, r10, r11};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f6315n.clone();
        }
    }

    public interface b {
    }

    public interface c {
    }

    public OInputView(Context r13, AttributeSet r14) {
        i.f(r13, "context");
        super(r13, r14, 0);
        int r8 = 1;
        this.A = true;
        this.C = true;
        this.D = Integer.MAX_VALUE;
        this.H = true;
        this.I = true;
        this.K = -1;
        this.L = true;
        this.N = true;
        this.Q = true;
        this.X = android.aimedia.a.a("Resources.getSystem()", 1, 10);
        TypedArray r15 = r13.getTheme().obtainStyledAttributes(r14, nb.a.f9498l, 0, 0);
        this.G = r15.getBoolean(14, false);
        this.H = r15.getBoolean(8, true);
        this.I = r15.getBoolean(24, true);
        this.L = r15.getBoolean(20, true);
        this.M = r15.getBoolean(21, false);
        this.N = r15.getBoolean(22, true);
        this.O = r15.getString(15);
        this.U = r15.getString(11);
        this.V = r15.getString(10);
        boolean r10 = r15.getBoolean(19, false);
        this.W = r10;
        this.X = r15.getDimensionPixelSize(12, this.X);
        this.A = r15.getBoolean(9, true);
        this.B = r15.getInt(16, 0);
        this.C = r15.getBoolean(17, true);
        int r11 = r15.getDimensionPixelSize(13, 0);
        if (r11 <= 0) goto L5;
        this.R = Integer.valueOf(r11);
    L5:
        this.K = r15.getInt(18, -1);
        this.J = r15.getBoolean(23, false);
        CharSequence r12 = r15.getText(6);
        this.S = r15.getString(4);
        this.T = r15.getInt(7, 0);
        String r16 = r15.getString(3);
        this.Q = r15.getBoolean(0, true);
        this.D = r15.getInt(5, Integer.MAX_VALUE);
        r15.getInt(2, 0);
        int r17 = r15.getInt(1, 16);
        r15.recycle();
        LayoutInflater.from(r13).inflate(getContentViewRes(), this);
        View r18 = findViewById(R.id.o_input_border_container);
        i.e(r18, "findViewById(R.id.o_input_border_container)");
        OUIConstraintLayout r19 = (OUIConstraintLayout) r18;
        this.Y = r19;
        r19.setRadius(this.X);
        View r110 = findViewById(R.id.o_input_title_container);
        i.e(r110, "findViewById(R.id.o_input_title_container)");
        this.Z = (LinearLayout) r110;
        View r111 = findViewById(R.id.o_input_title);
        i.e(r111, "findViewById(R.id.o_input_title)");
        this.f6292a0 = (OTextView) r111;
        View r112 = findViewById(R.id.o_input_title_icon);
        i.e(r112, "findViewById(R.id.o_input_title_icon)");
        this.f6293b0 = (ImageView) r112;
        View r113 = findViewById(R.id.o_input);
        i.e(r113, "findViewById(R.id.o_input)");
        OEditText r114 = (OEditText) r113;
        this.f6294c0 = r114;
        r114.setVerticalScrollBarEnabled(false);
        View r20 = findViewById(R.id.o_input_left_view_container);
        i.e(r20, "findViewById(R.id.o_input_left_view_container)");
        this.d0 = (FrameLayout) r20;
        View r21 = findViewById(R.id.o_input_custom_action_container);
        i.e(r21, "findViewById(R.id.o_input_custom_action_container)");
        this.f6295e0 = (FrameLayout) r21;
        View r22 = findViewById(R.id.o_input_action_container);
        i.e(r22, "findViewById(R.id.o_input_action_container)");
        this.f6296f0 = r22;
        View r23 = findViewById(R.id.o_input_clear);
        i.e(r23, "findViewById(R.id.o_input_clear)");
        this.f6297g0 = r23;
        View r24 = findViewById(R.id.o_input_combo_arrow);
        i.e(r24, "findViewById(R.id.o_input_combo_arrow)");
        this.f6298h0 = r24;
        View r25 = findViewById(R.id.o_input_eyes_slash);
        i.e(r25, "findViewById(R.id.o_input_eyes_slash)");
        ImageView r26 = (ImageView) r25;
        this.f6299i0 = r26;
        View r27 = findViewById(R.id.o_input_resizer);
        i.e(r27, "findViewById(R.id.o_input_resizer)");
        this.f6300j0 = r27;
        View r28 = findViewById(R.id.o_input_error_tip);
        i.e(r28, "findViewById(R.id.o_input_error_tip)");
        OTextView r29 = (OTextView) r28;
        this.f6301k0 = r29;
        View r30 = findViewById(R.id.o_input_common_tip);
        i.e(r30, "findViewById(R.id.o_input_common_tip)");
        OTextView r31 = (OTextView) r30;
        this.f6302l0 = r31;
        View r115 = findViewById(R.id.o_input_limit_indicator);
        i.e(r115, "findViewById(R.id.o_input_limit_indicator)");
        this.f6303m0 = (OTextView) r115;
        this.f6304n0 = (TextView) findViewById(R.id.o_input_view_fake_label);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        if (r12 == null) goto L11;
        r114.setKeyListener(DigitsKeyListener.getInstance(String.valueOf(r12)));
        int r32 = this.T;
        if (r32 == 0) goto L10;
        r8 = r32;
    L10:
        this.T = r8;
    L11:
        r114.setGravity(r17);
        Integer r33 = this.R;
        if (r33 == null) goto L14;
        setInputHeight(r33.intValue());
    L14:
        r114.f6277o.f6281a = new ic.a(this);
        r114.f6278p.f6283a = new ic.b(this);
        ic.c r34 = new ic.c(this);
        OEditText.d r35 = r114.f6279q;
        r35.f6285a = r34;
        r35.f6286b = new d(this);
        r23.setOnClickListener(new e(this));
        setCommonTip(this.V);
        bc.a.d(r31, r10);
        setErrorTip(this.U);
        bc.a.d(r29, false);
        setComboInputEnabled(this.A);
        setLabel(this.O);
        setShowLabel(this.L);
        setShowLabelIcon(this.N);
        setLimitCount(this.K);
        setShowLimitIndicator(this.J);
        setSingleLine(this.C);
        setMaxLines(this.D);
        setHint(this.S);
        setText(r16);
        setInputMode(this.B);
        setEnabled(this.Q);
        A();
        z(r114.hasFocus());
        int r116 = this.T;
        if (r116 == 0) goto L17;
        setInputType(r116);
    L17:
        B();
        r26.setOnClickListener(new f(this));
        r19.setOnClickListener(new g(this));
        v("init");
    }

    private final float getFakeInputOffsetY() {
        LinearLayout r8 = this.Z;
        if (r8.getHeight() > 0) goto L5;
    L7:
        zc.b.h("OInputView", "getFakeInputOffsetY, use default offset, vTitleContainer.height: " + r8.getHeight() + ", height: " + getHeight());
        Resources r10 = Resources.getSystem();
        i.e(r10, "Resources.getSystem()");
        float r11 = TypedValue.applyDimension(1, -11.0f, r10.getDisplayMetrics());
    L8:
        zc.b.a("OInputView", "getFakeInputOffsetY, offsetY: " + r11);
        return r11;
    L5:
        if (getHeight() <= 0) goto L7;
        r11 = ((r8.getHeight() / 2.0f) + r8.getY()) - (getHeight() / 2.0f);
        goto L8
    }

    public static final /* synthetic */ int s(OInputView r8) {
        return r8.T;
    }

    public static final /* synthetic */ ImageView t(OInputView r8) {
        return r8.f6299i0;
    }

    public static final void u(OInputView r13, boolean r14) {
        if (r13.M == true) goto L6;
        return;
    L6:
        if (r13.L == true) goto L9;
        return;
    L9:
        if (r13.C == false) goto L64;
        TextView r8 = r13.f6304n0;
        if (r8 == null) goto L65;
        Editable r10 = r13.f6294c0.getText();
        if (r10 != null) goto L17;
    L20:
        boolean r11 = true;
    L21:
        if (r11 == true) goto L24;
        r13.C(a.f6312a, r8, "playLabelAnim, hasFocus: " + r14);
        return;
    L24:
        if (r14 == false) goto L41;
        ValueAnimator r15 = r13.f6311u0;
        if (r15 == null) goto L28;
        r15.cancel();
    L28:
        ValueAnimator r16 = r13.f6311u0;
        if (r16 == null) goto L31;
        r16.removeAllUpdateListeners();
    L31:
        ValueAnimator r17 = r13.f6311u0;
        if (r17 == null) goto L34;
        r17.removeAllListeners();
    L34:
        ValueAnimator r18 = r13.f6310t0;
        if (r18 != null) goto L37;
    L40:
        Context r19 = r13.getContext();
        Object r12 = androidx.core.content.a.f1674a;
        int r110 = androidx.core.content.a.c.a(r19, R.color.oui_text_3);
        int r20 = androidx.core.content.a.c.a(r13.getContext(), R.color.oui_text_4);
        float r21 = r13.getFakeInputOffsetY();
        float r111 = r13.w(r8);
        r8.setPivotX(0.0f);
        r8.setPivotY(-r21);
        ValueAnimator r112 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        i.e(r112, "animator");
        r112.setDuration(200);
        r112.setInterpolator(new DecelerateInterpolator());
        r112.addUpdateListener(new j(r13, r21, r20, r110, r111, r8));
        r112.addListener(new k(r13, r8));
        r13.f6310t0 = r112;
        r112.start();
        String r113 = "start label show anim";
    L58:
        zc.b.a("OInputView", r113);
        return;
    L37:
        if (r18.isRunning() != true) goto L40;
        String r114 = "label show anim is running, do nothing";
    L56:
        zc.b.h("OInputView", r114);
        return;
    L41:
        ValueAnimator r115 = r13.f6310t0;
        if (r115 == null) goto L44;
        r115.cancel();
    L44:
        ValueAnimator r116 = r13.f6310t0;
        if (r116 == null) goto L47;
        r116.removeAllUpdateListeners();
    L47:
        ValueAnimator r117 = r13.f6310t0;
        if (r117 == null) goto L50;
        r117.removeAllListeners();
    L50:
        ValueAnimator r118 = r13.f6311u0;
        if (r118 != null) goto L53;
    L57:
        Context r119 = r13.getContext();
        Object r22 = androidx.core.content.a.f1674a;
        int r120 = androidx.core.content.a.c.a(r119, R.color.oui_text_3);
        int r23 = androidx.core.content.a.c.a(r13.getContext(), R.color.oui_text_4);
        float r24 = r13.getFakeInputOffsetY();
        float r121 = r13.w(r8);
        r8.setPivotX(0.0f);
        r8.setPivotY(-r24);
        ValueAnimator r122 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        i.e(r122, "animator");
        r122.setDuration(200);
        r122.setInterpolator(new DecelerateInterpolator());
        r122.addUpdateListener(new h(r13, r24, r120, r23, r121, r8));
        r122.addListener(new ic.i(r13, r8));
        r13.f6311u0 = r122;
        r122.start();
        r113 = "start label hide anim";
        goto L58
    L53:
        if (r118.isRunning() != true) goto L57;
        r114 = "label hide anim is running, do nothing";
        goto L56
    L17:
        if (r10.length() == 0) goto L20;
        r11 = false;
        goto L21
    L65:
        return;
    }

    public final void A() {
        if (this.H == true) goto L5;
        return;
    L5:
        boolean r8 = true;
        if (x() == false) goto L8;
    L22:
        boolean r10 = false;
    L23:
        View r11 = this.f6297g0;
        bc.a.d(r11, r10);
        ImageView r12 = this.f6299i0;
        if (r10 == false) goto L27;
        bc.a.d(r12, false);
    L27:
        if (r11.getVisibility() != 0) goto L29;
        boolean r13 = true;
    L30:
        if (r13 == false) goto L32;
    L43:
        bc.a.d(this.f6296f0, r8);
        return;
    L32:
        if (r12.getVisibility() != 0) goto L34;
        boolean r14 = true;
    L35:
        if (r14 == true) goto L43;
        if (this.f6298h0.getVisibility() != 0) goto L39;
        boolean r15 = true;
    L40:
        if (r15 == true) goto L43;
        r8 = false;
        goto L43
    L39:
        r15 = false;
        goto L40
    L34:
        r14 = false;
        goto L35
    L29:
        r13 = false;
        goto L30
    L8:
        if (this.B != 0) goto L22;
        if (this.Q == false) goto L22;
        OEditText r16 = this.f6294c0;
        if (r16.hasFocus() == false) goto L22;
        Editable r17 = r16.getText();
        if (r17 != null) goto L16;
    L19:
        boolean r18 = true;
    L20:
        if (r18 == true) goto L22;
        r10 = true;
        goto L23
    L16:
        if (r17.length() == 0) goto L19;
        r18 = false;
        goto L20
    }

    public final void B() {
        boolean r8 = true;
        if (x() == true) goto L5;
    L17:
        boolean r10 = false;
    L18:
        ImageView r11 = this.f6299i0;
        bc.a.d(r11, r10);
        View r12 = this.f6297g0;
        if (r10 == false) goto L22;
        bc.a.d(r12, false);
    L22:
        if (r12.getVisibility() != 0) goto L24;
        boolean r13 = true;
    L25:
        if (r13 == false) goto L27;
    L38:
        bc.a.d(this.f6296f0, r8);
        return;
    L27:
        if (r11.getVisibility() != 0) goto L29;
        boolean r14 = true;
    L30:
        if (r14 == true) goto L38;
        if (this.f6298h0.getVisibility() != 0) goto L34;
        boolean r15 = true;
    L35:
        if (r15 == true) goto L38;
        r8 = false;
        goto L38
    L34:
        r15 = false;
        goto L35
    L29:
        r14 = false;
        goto L30
    L24:
        r13 = false;
        goto L25
    L5:
        if (this.Q == false) goto L17;
        Editable r16 = this.f6294c0.getText();
        if (r16 != null) goto L9;
    L12:
        boolean r17 = true;
    L13:
        if (r17 == true) goto L17;
        if (this.f6309s0 == true) goto L17;
        r10 = true;
        goto L18
    L9:
        if (r16.length() == 0) goto L12;
        r17 = false;
        goto L13
    }

    public final void C(a r8, TextView r10, String r11) {
        zc.b.a("OInputView", "updateLabelUIState, state: " + r8 + ", scene: [" + r11 + ']');
        int r12 = r8.ordinal();
        OEditText r13 = this.f6294c0;
        LinearLayout r14 = this.Z;
        if (r12 != 0) goto L5;
        r14.setVisibility(0);
        r10.setVisibility(8);
        r13.setAlpha(1.0f);
        return;
    L5:
        if (r12 != 1) goto L7;
        r14.setVisibility(4);
        r10.setVisibility(0);
        r13.setAlpha(0.0f);
        return;
    L7:
        if (r12 != 2) goto L15;
        r14.setVisibility(8);
        r10.setVisibility(8);
        r13.setAlpha(1.0f);
        return;
    }

    public final void D(String r8) {
        if (this.J == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        OTextView r11 = this.f6303m0;
        bc.a.d(r11, r10);
        if (this.J == true) goto L11;
        return;
    L11:
        if (this.K <= 0) goto L21;
        if (r8 == null) goto L14;
        int r12 = r8.length();
    L15:
        String r13 = getResources().getString(R.string.oui_form_counter, new Object[]{String.valueOf(r12), String.valueOf(this.K)});
        i.e(r13, "resources.getString(\n   ….toString()\n            )");
        SpannableString r14 = new SpannableString(r13);
        if (r12 <= this.K) goto L18;
        Context r15 = getContext();
        Object r16 = androidx.core.content.a.f1674a;
        r14.setSpan(new ForegroundColorSpan(androidx.core.content.a.c.a(r15, R.color.oui_functional_red_7)), 0, String.valueOf(r12).length(), 18);
    L18:
        r11.setText(r14, TextView.BufferType.SPANNABLE);
        return;
    L14:
        r12 = 0;
        goto L15
    L21:
        return;
    L5:
        if (this.K <= 0) goto L7;
        r10 = true;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r8) {
        if (r8 == null) goto L35;
        if (this.G == false) goto L35;
        float r10 = r8.getX();
        float r11 = r8.getY();
        int r12 = r8.getAction();
        if (r12 != 0) goto L8;
    L33:
        this.E = r11;
        goto L35
    L8:
        if (r12 != 1) goto L10;
    L32:
        super.requestDisallowInterceptTouchEvent(false);
        goto L35
    L10:
        if (r12 != 2) goto L12;
        float r13 = this.F;
        OEditText r14 = this.f6294c0;
        if (r10 <= r13) goto L19;
        if (r14.canScrollHorizontally(-1) == false) goto L19;
    L30:
        super.requestDisallowInterceptTouchEvent(true);
    L31:
        this.F = r10;
    L19:
        if (r10 >= this.F) goto L23;
        if (r14.canScrollHorizontally(1) == true) goto L30;
    L23:
        if (r11 >= this.E) goto L27;
        if (r14.canScrollVertically(1) == true) goto L30;
    L27:
        if (r11 <= this.E) goto L31;
        if (r14.canScrollVertically(-1) == false) goto L31;
    L12:
        if (r12 == 3) goto L32;
    L35:
        return super.dispatchTouchEvent(r8);
    }

    public final boolean getAutoHideSoftInputWhenLoseFocus() {
        return this.f6307q0;
    }

    public final OEditText.a getCommitCompletionListener() {
        this.f6294c0.getCommitCompletionListener();
        return null;
    }

    public int getContentViewRes() {
        return R.layout.o_input_view_layout_vertical;
    }

    public final int getInputType() {
        return this.T;
    }

    public final int getLimitCount() {
        return this.K;
    }

    @Override // android.view.View
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        return this.f6294c0.getOnFocusChangeListener();
    }

    public String getText() {
        Editable r8 = this.f6294c0.getText();
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.toString();
    }

    public final OEditText getVInput() {
        return this.f6294c0;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        if (r8 != null) goto L5;
    L13:
        if (r8 != null) goto L15;
    L22:
        return super.onInterceptTouchEvent(r8);
    L15:
        if (r8.getAction() == 1) goto L19;
        if (r8.getAction() != 3) goto L22;
    L19:
        if (this.f6305o0 == false) goto L22;
    L12:
        this.f6305o0 = false;
        goto L22
    L5:
        if (r8.getAction() != 0) goto L13;
        float r10 = r8.getX();
        OEditText r11 = this.f6294c0;
        int r12 = r11.getLeft();
        int r13 = r11.getRight();
        if (r10 < r12) goto L12;
        if (r10 > r13) goto L12;
        this.f6305o0 = true;
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        if (r8 == null) goto L12;
        if (this.f6305o0 == false) goto L12;
        MotionEvent r10 = MotionEvent.obtain(r8);
        OEditText r11 = this.f6294c0;
        r10.offsetLocation(-r11.getLeft(), -r11.getTop());
        boolean r12 = r11.dispatchTouchEvent(r10);
        r10.recycle();
        if (r8.getAction() != 1) goto L8;
    L9:
        this.f6305o0 = false;
    L10:
        return r12;
    L8:
        if (r8.getAction() != 3) goto L10;
    L12:
        return super.onTouchEvent(r8);
    }

    public final void setActionView(l<? super FrameLayout, xd.j> r8) {
        i.f(r8, "creator");
        FrameLayout r10 = this.f6295e0;
        r10.removeAllViews();
        r8.invoke(r10);
        if (r10.getChildCount() <= 0) goto L5;
        boolean r11 = true;
    L6:
        bc.a.d(r10, r11);
        return;
    L5:
        r11 = false;
        goto L6
    }

    public final void setAlwaysHideEye(boolean r8) {
        this.f6309s0 = r8;
        if (r8 == false) goto L6;
        bc.a.d(this.f6299i0, false);
        return;
    }

    public final void setAutoHideSoftInputWhenLoseFocus(boolean r8) {
        this.f6307q0 = r8;
    }

    public final void setBgResId(int r8) {
        this.f6308r0 = r8;
        y(true);
    }

    public final void setComboInputEnabled(boolean r8) {
        this.A = r8;
        OEditText r10 = this.f6294c0;
        r10.setFocusable(r8);
        r10.setFocusableInTouchMode(r8);
        View.OnClickListener r11 = this.f6306p0;
        if (r11 == null) goto L6;
        r10.setOnClickListener(r11);
        return;
    }

    public final void setCommitCompletionListener(OEditText.a r8) {
        i.f(r8, "commitCompletionListener");
        this.f6294c0.setCommitCompletionListener(r8);
    }

    public final void setCommonTip(String r8) {
        this.V = r8;
        this.f6302l0.setText(r8);
    }

    @Override // android.view.View
    public void setEnabled(boolean r8) {
        this.Q = r8;
        super.setEnabled(r8);
        Iterator<View> r10 = new b0(this).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().setEnabled(r8);
        goto L4
    L6:
        OEditText r11 = this.f6294c0;
        r11.setEnabled(r8);
        z(r11.hasFocus());
        y(false);
    }

    public final void setErrorState(boolean r8) {
        this.P = r8;
        z(this.f6294c0.hasFocus());
        y(false);
    }

    public final void setErrorTip(String r8) {
        this.U = r8;
        this.f6301k0.setText(r8);
    }

    public final void setHint(String r8) {
        this.S = r8;
        this.f6294c0.setHint(r8);
        v("setHint");
    }

    public final void setInputHeight(int r8) {
        this.R = Integer.valueOf(r8);
        OEditText r10 = this.f6294c0;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L7;
        ConstraintLayout.a r12 = (ConstraintLayout.a) r11;
        ((ViewGroup.MarginLayoutParams) r12).height = r8;
        r10.setLayoutParams(r12);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setInputMode(int r8) {
        this.B = r8;
        ImageView r10 = this.f6299i0;
        View r11 = this.f6297g0;
        View r12 = this.f6296f0;
        View r13 = this.f6298h0;
        boolean r14 = false;
        if (r8 == 0) goto L23;
        if (r8 != 1) goto L42;
        setSingleLine(true);
        bc.a.d(r13, true);
        if (r11.getVisibility() != 0) goto L9;
        boolean r15 = true;
    L10:
        if (r15 == false) goto L12;
    L21:
        r14 = true;
    L22:
        bc.a.d(r12, r14);
        setComboInputEnabled(this.A);
        return;
    L12:
        if (r10.getVisibility() != 0) goto L14;
        boolean r16 = true;
    L15:
        if (r16 == true) goto L21;
        if (r13.getVisibility() != 0) goto L19;
        boolean r17 = true;
    L20:
        if (r17 == false) goto L22;
    L19:
        r17 = false;
        goto L20
    L14:
        r16 = false;
        goto L15
    L9:
        r15 = false;
        goto L10
    L42:
        return;
    L23:
        bc.a.d(r13, false);
        if (r11.getVisibility() != 0) goto L26;
        boolean r18 = true;
    L27:
        if (r18 == false) goto L29;
    L38:
        r14 = true;
    L39:
        bc.a.d(r12, r14);
        OEditText r19 = this.f6294c0;
        r19.setFocusable(true);
        r19.setFocusableInTouchMode(true);
        return;
    L29:
        if (r10.getVisibility() != 0) goto L31;
        boolean r20 = true;
    L32:
        if (r20 == true) goto L38;
        if (r13.getVisibility() != 0) goto L36;
        boolean r21 = true;
    L37:
        if (r21 == false) goto L39;
    L36:
        r21 = false;
        goto L37
    L31:
        r20 = false;
        goto L32
    L26:
        r18 = false;
        goto L27
    }

    public final void setInputType(int r8) {
        if ((r8 & 1) == 0) goto L5;
    L11:
        this.T = r8;
        OEditText r10 = this.f6294c0;
        if (r8 != r10.getInputType()) goto L15;
        r10.getText();
        return;
    L15:
        r10.setInputType(this.T);
        B();
        r10.getText();
        return;
    L5:
        if ((r8 & 2) != 0) goto L11;
        if ((r8 & 3) != 0) goto L11;
        if ((r8 & 4) != 0) goto L11;
        r8 = r8 | 1;
        goto L11
    }

    public final void setIsInScrollableView(boolean r8) {
        this.G = r8;
    }

    public final void setKeyListener(KeyListener r8) {
        this.f6294c0.setKeyListener(r8);
    }

    public final void setLabel(String r8) {
        this.O = r8;
        this.f6292a0.setText(r8);
    }

    public final void setLeftView(l<? super FrameLayout, xd.j> r8) {
        i.f(r8, "creator");
        FrameLayout r10 = this.d0;
        r10.removeAllViews();
        r8.invoke(r10);
        if (r10.getChildCount() <= 0) goto L5;
        boolean r11 = true;
    L6:
        bc.a.d(r10, r11);
        return;
    L5:
        r11 = false;
        goto L6
    }

    public void setLimitCount(int r8) {
        setLimitCountValue(r8);
        OEditText r10 = this.f6294c0;
        Editable r11 = r10.getText();
        if (r11 == null) goto L5;
        String r12 = r11.toString();
    L6:
        D(r12);
        r10.getText();
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void setLimitCountValue(int r8) {
        this.K = r8;
    }

    public final void setMaxLines(int r8) {
        int r10 = 1;
        if (r8 >= 1) goto L5;
        r8 = Integer.MAX_VALUE;
    L5:
        this.D = r8;
        if (this.C == true) goto L9;
        r10 = r8;
    L9:
        this.f6294c0.setMaxLines(r10);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r8) {
        if (this.B == 1) goto L5;
    L7:
        super.setOnClickListener(r8);
        return;
    L5:
        if (this.A == true) goto L7;
        this.f6298h0.setOnClickListener(r8);
        this.f6294c0.setOnClickListener(r8);
        goto L7
    }

    public final void setOnComboArrowClickListener(View.OnClickListener r8) {
        this.f6306p0 = r8;
        this.f6298h0.setOnClickListener(r8);
        if (this.A == true) goto L8;
        View.OnClickListener r10 = this.f6306p0;
        if (r10 == null) goto L9;
        this.f6294c0.setOnClickListener(r10);
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener r8) {
        this.f6294c0.setOnFocusChangeListener(r8);
    }

    public final void setOnTextClearedListener(b r8) {
        i.f(r8, "listener");
    }

    public final void setOnTextExceedLengthListener(c r8) {
    }

    public final void setRadius(int r8) {
        if (r8 != this.X) goto L5;
        return;
    L5:
        this.X = r8;
        this.Y.setRadius(r8);
    }

    public final void setShowLabel(boolean r8) {
        this.L = r8;
        bc.a.d(this.Z, r8);
        OEditText r10 = this.f6294c0;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L11;
        ConstraintLayout.a r12 = (ConstraintLayout.a) r11;
        if (this.L == false) goto L7;
        int r13 = 16;
    L8:
        int r14 = android.aimedia.a.a("Resources.getSystem()", 1, r13);
        r12.f1396w = r14;
        r12.A = r14;
        r10.setLayoutParams(r12);
        v("setShowLabel");
        return;
    L7:
        r13 = 12;
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setShowLabelAnim(boolean r8) {
        this.M = r8;
        v("setShowLabelAnim");
    }

    public final void setShowLabelIcon(boolean r8) {
        this.N = r8;
        bc.a.d(this.f6293b0, r8);
    }

    public final void setShowLimitIndicator(boolean r8) {
        this.J = r8;
        Editable r10 = this.f6294c0.getText();
        if (r10 == null) goto L5;
        String r11 = r10.toString();
    L6:
        D(r11);
        return;
    L5:
        r11 = null;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void setSingleLine(boolean r15) {
        this.C = r15;
        int r8 = getResources().getDimensionPixelSize(R.dimen.o_input_view_space_top_bottom);
        FrameLayout r10 = this.d0;
        FrameLayout r11 = this.f6295e0;
        View r12 = this.f6296f0;
        View r13 = this.f6300j0;
        OEditText r14 = this.f6294c0;
        if (r15 == false) goto L39;
        bc.a.d(r13, false);
        r14.setMaxLines(1);
        r14.setSingleLine(true);
        ViewGroup.LayoutParams r16 = r14.getLayoutParams();
        if (r16 == null) goto L38;
        ConstraintLayout.a r17 = (ConstraintLayout.a) r16;
        ViewGroup.LayoutParams r18 = getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r18 = null;
    L9:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        if (r19 == null) goto L12;
        int r20 = r19.leftMargin;
    L13:
        ViewGroup.LayoutParams r110 = getLayoutParams();
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == true) goto L16;
        r110 = null;
    L16:
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        if (r111 == null) goto L19;
        int r112 = r111.rightMargin;
    L20:
        r17.setMargins(r20, 0, r112, r8);
        r17.f1397x = r8;
        if (this.L == false) goto L23;
        float r21 = 16;
    L24:
        int r22 = android.aimedia.a.a("Resources.getSystem()", 1, r21);
        r17.f1396w = r22;
        r17.A = r22;
        r14.setLayoutParams(r17);
        ViewGroup.LayoutParams r113 = r12.getLayoutParams();
        if (r113 == null) goto L36;
        ConstraintLayout.a r114 = (ConstraintLayout.a) r113;
        r114.f1373i = 0;
        r114.f1379l = 0;
        r12.setLayoutParams(r114);
        ViewGroup.LayoutParams r115 = r11.getLayoutParams();
        if (r115 == null) goto L34;
        ConstraintLayout.a r116 = (ConstraintLayout.a) r115;
        r116.f1373i = 0;
        r116.f1379l = 0;
        r11.setLayoutParams(r116);
        ViewGroup.LayoutParams r117 = r10.getLayoutParams();
        if (r117 == null) goto L32;
        ConstraintLayout.a r118 = (ConstraintLayout.a) r117;
        float r23 = 4;
        int r24 = android.aimedia.a.a("Resources.getSystem()", 1, r23);
        int r25 = android.aimedia.a.a("Resources.getSystem()", 1, r23);
        Resources r26 = Resources.getSystem();
        i.e(r26, "Resources.getSystem()");
        r118.setMargins(r24, r25, 0, l6.a.I0(TypedValue.applyDimension(1, r23, r26.getDisplayMetrics())));
        r118.f1373i = 0;
        r118.f1379l = 0;
    L87:
        r10.setLayoutParams(r118);
        v("setSingleLine");
        return;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L34:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L36:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L23:
        r21 = 12;
        goto L24
    L19:
        r112 = 0;
        goto L20
    L12:
        r20 = 0;
        goto L13
    L38:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L39:
        bc.a.d(r13, this.I);
        r14.setMaxLines(this.D);
        r14.setSingleLine(false);
        r14.setPadding(getPaddingLeft(), android.aimedia.a.a("Resources.getSystem()", 1, 2), getPaddingRight(), getPaddingBottom());
        r14.setGravity(48);
        ViewGroup.LayoutParams r119 = r14.getLayoutParams();
        if (r119 == null) goto L96;
        ConstraintLayout.a r120 = (ConstraintLayout.a) r119;
        ViewGroup.LayoutParams r27 = getLayoutParams();
        if ((r27 instanceof ViewGroup.MarginLayoutParams) == true) goto L44;
        r27 = null;
    L44:
        ViewGroup.MarginLayoutParams r28 = (ViewGroup.MarginLayoutParams) r27;
        if (r28 == null) goto L47;
        int r29 = r28.leftMargin;
    L48:
        ViewGroup.LayoutParams r30 = getLayoutParams();
        if ((r30 instanceof ViewGroup.MarginLayoutParams) == true) goto L51;
        r30 = null;
    L51:
        ViewGroup.MarginLayoutParams r31 = (ViewGroup.MarginLayoutParams) r30;
        if (r31 == null) goto L54;
        int r32 = r31.rightMargin;
    L55:
        float r121 = 8;
        Resources r122 = Resources.getSystem();
        i.e(r122, "Resources.getSystem()");
        r120.setMargins(r29, 0, r32, l6.a.I0(TypedValue.applyDimension(1, r121, r122.getDisplayMetrics())));
        Resources r33 = Resources.getSystem();
        i.e(r33, "Resources.getSystem()");
        r120.f1397x = l6.a.I0(TypedValue.applyDimension(1, r121, r33.getDisplayMetrics()));
        if (this.L == false) goto L58;
        float r34 = 16;
    L59:
        int r35 = android.aimedia.a.a("Resources.getSystem()", 1, r34);
        r120.f1396w = r35;
        r120.A = r35;
        r14.setLayoutParams(r120);
        ViewGroup.LayoutParams r123 = r12.getLayoutParams();
        if (r123 == null) goto L94;
        ConstraintLayout.a r124 = (ConstraintLayout.a) r123;
        r124.f1373i = 0;
        ViewGroup.LayoutParams r36 = getLayoutParams();
        if ((r36 instanceof ViewGroup.MarginLayoutParams) == true) goto L64;
        r36 = null;
    L64:
        ViewGroup.MarginLayoutParams r37 = (ViewGroup.MarginLayoutParams) r36;
        if (r37 == null) goto L67;
        int r38 = r37.leftMargin;
    L68:
        float r39 = 4;
        int r40 = android.aimedia.a.a("Resources.getSystem()", 1, r39);
        ViewGroup.LayoutParams r41 = getLayoutParams();
        if ((r41 instanceof ViewGroup.MarginLayoutParams) == true) goto L71;
        r41 = null;
    L71:
        ViewGroup.MarginLayoutParams r42 = (ViewGroup.MarginLayoutParams) r41;
        if (r42 == null) goto L74;
        int r43 = r42.rightMargin;
    L75:
        ViewGroup.LayoutParams r44 = getLayoutParams();
        if ((r44 instanceof ViewGroup.MarginLayoutParams) == true) goto L78;
        r44 = null;
    L78:
        ViewGroup.MarginLayoutParams r45 = (ViewGroup.MarginLayoutParams) r44;
        if (r45 == null) goto L81;
        int r46 = r45.bottomMargin;
    L82:
        r124.setMargins(r38, r40, r43, r46);
        r124.f1379l = -1;
        r12.setLayoutParams(r124);
        ViewGroup.LayoutParams r125 = r11.getLayoutParams();
        if (r125 == null) goto L92;
        ConstraintLayout.a r126 = (ConstraintLayout.a) r125;
        r126.f1373i = 0;
        r126.f1379l = 0;
        r11.setLayoutParams(r126);
        ViewGroup.LayoutParams r127 = r10.getLayoutParams();
        if (r127 == null) goto L90;
        r118 = (ConstraintLayout.a) r127;
        int r47 = android.aimedia.a.a("Resources.getSystem()", 1, r39);
        Resources r48 = Resources.getSystem();
        i.e(r48, "Resources.getSystem()");
        r118.setMargins(r47, l6.a.I0(TypedValue.applyDimension(1, r39, r48.getDisplayMetrics())), 0, 0);
        r118.f1373i = 0;
        r118.f1379l = -1;
        goto L87
    L90:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L92:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L81:
        r46 = 0;
        goto L82
    L74:
        r43 = 0;
        goto L75
    L67:
        r38 = 0;
        goto L68
    L94:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L58:
        r34 = 12;
        goto L59
    L54:
        r32 = 0;
        goto L55
    L47:
        r29 = 0;
        goto L48
    L96:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setText(String r8) {
        OEditText r10 = this.f6294c0;
        r10.setText(r8);
        v("setText");
        r10.getText();
    }

    public final void v(String r8) {
        if (this.M == true) goto L5;
        return;
    L5:
        TextView r10 = this.f6304n0;
        if (r10 == null) goto L28;
        boolean r11 = this.L;
        OEditText r12 = this.f6294c0;
        if (r11 == true) goto L11;
        r12.setHint(this.S);
        a r13 = a.f6314m;
        StringBuilder r14 = new StringBuilder("adjustInputViewAndLabel, ");
        r14.append(r8);
        String r15 = ", no label";
    L26:
        r14.append(r15);
        C(r13, r10, r14.toString());
        return;
    L11:
        if (this.C == true) goto L13;
        r12.setHint(this.S);
        r13 = a.f6312a;
        r14 = new StringBuilder("adjustInputViewAndLabel, ");
        r14.append(r8);
        r15 = ", can not show label anim";
        goto L26
    L13:
        r12.setHint("");
        r10.setText(this.O);
        Editable r16 = r12.getText();
        if (r16 != null) goto L16;
    L19:
        boolean r17 = true;
    L20:
        if (r17 == true) goto L22;
        r13 = a.f6312a;
        r14 = new StringBuilder("adjustInputViewAndLabel, ");
        r14.append(r8);
        r15 = ", can show label anim, vInput.text not empty";
        goto L26
    L22:
        if (r12.hasFocus() == false) goto L24;
        r13 = a.f6312a;
        r14 = new StringBuilder("adjustInputViewAndLabel, ");
        r14.append(r8);
        r15 = ", can show label anim, vInput.text empty, focused";
        goto L26
    L24:
        r13 = a.f6313b;
        r14 = new StringBuilder("adjustInputViewAndLabel, ");
        r14.append(r8);
        r15 = ", can show label anim, vInput.text empty, not focused";
        goto L26
    L16:
        if (r16.length() == 0) goto L19;
        r17 = false;
        goto L20
    }

    public final float w(TextView r8) {
        OTextView r10 = this.f6292a0;
        float r11 = 0;
        if (r10.getTextSize() > r11) goto L5;
    L7:
        zc.b.h("OInputView", "getScaleRatio, use default scale, vTitle.textSize: " + r10.getTextSize() + ", vFakeInput.textSize: " + r8.getTextSize());
        float r12 = 0.857143f;
    L8:
        zc.b.a("OInputView", "getScaleRatio, scale: " + r12);
        return r12;
    L5:
        if (r8.getTextSize() <= r11) goto L7;
        r12 = r10.getTextSize() / r8.getTextSize();
        goto L8
    }

    public final boolean x() {
        int r8 = this.T & 4095;
        if (r8 != 129) goto L5;
        boolean r10 = true;
    L7:
        if (r8 != 225) goto L9;
        boolean r11 = true;
    L11:
        if (r8 != 18) goto L13;
        boolean r12 = true;
    L14:
        if (r10 == true) goto L20;
        if (r11 == true) goto L21;
        if (r12 == false) goto L19;
        return true;
    L19:
        return false;
    L21:
        return true;
    L20:
        return true;
    L13:
        r12 = false;
        goto L14
    L9:
        r11 = false;
        goto L11
    L5:
        r10 = false;
        goto L7
    }

    public final void y(boolean r8) {
        int r10 = this.f6308r0;
        OUIConstraintLayout r11 = this.Y;
        if (r10 == 0) goto L6;
        r11.setBackgroundResource(r10);
        return;
    L6:
        boolean r12 = this.Q;
        int r13 = R.drawable.o_input_view_pressed_background;
        if (r12 == false) goto L15;
        if (r8 == true) goto L15;
        if (this.f6294c0.hasFocus() == false) goto L14;
        r13 = R.drawable.o_input_view_focused_background;
        goto L15
    L14:
        r13 = R.drawable.o_input_view_normal_background;
    L15:
        r11.setBackgroundResource(r13);
    }

    public final void z(boolean r8) {
        int r10 = 0;
        if (this.Q == false) goto L10;
        if (r8 == false) goto L8;
        float r11 = 2;
    L11:
        int r12 = android.aimedia.a.a("Resources.getSystem()", 1, r11);
        OUIConstraintLayout r13 = this.Y;
        r13.setBorderWidth(r12);
        if (this.Q == true) goto L15;
        r10 = android.aimedia.a.a("Resources.getSystem()", 1, 0);
    L19:
        if (r10 == 0) goto L22;
        Context r14 = getContext();
        Object r15 = androidx.core.content.a.f1674a;
        r13.setBorderColor(androidx.core.content.a.c.a(r14, r10));
        return;
    L22:
        return;
    L15:
        if (this.P == false) goto L17;
        r10 = R.color.oui_functional_red_7;
        goto L19
    L17:
        if (r8 == false) goto L19;
        r10 = R.color.oui_basic_line_3;
        goto L19
    L8:
        if (this.P == false) goto L10;
        r11 = (float) 1.2d;
    L10:
        r11 = 0;
        goto L11
    }
}
