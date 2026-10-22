package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.cae.R;
import com.obric.common.oea.foundation.blur.NativeReflect;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import ge.l;
import he.i;
import he.j;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class OFloatingTitleBar extends FrameLayout {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f6608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OButtonGroup f6609b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OTextView f6610m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OTextView f6611n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public FrameLayout f6612o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OButtonGroup f6613p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FrameLayout f6614q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public OTextView f6615r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public OTextView f6616s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public LinearLayout f6617t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public OButtonGroup f6618u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public OButtonGroup f6619v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f6620w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f6621x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6622y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6623z;

    public static final class a extends j implements l<Integer, xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OFloatingTitleBar f6624a;

        public a(OFloatingTitleBar r8) {
            this.f6624a = r8;
            super(1);
        }

        @Override // ge.l
        public final xd.j invoke(Integer r8) {
            int r10 = r8.intValue();
            int r11 = OFloatingTitleBar.A;
            OFloatingTitleBar r12 = this.f6624a;
            r12.getClass();
            OButtonGroup r13 = r12.f6613p;
            if (r13 == null) goto L6;
            OFloatingTitleBar.a(r12, r13, r10);
            return xd.j.f13877a;
        L6:
            i.j("centerButtonGroup");
            throw null;
        }
    }

    public static final class b extends j implements l<Integer, xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OFloatingTitleBar f6625a;

        public b(OFloatingTitleBar r8) {
            this.f6625a = r8;
            super(1);
        }

        @Override // ge.l
        public final xd.j invoke(Integer r8) {
            int r10 = r8.intValue();
            OFloatingTitleBar r11 = this.f6625a;
            r11.f6623z = r10;
            OButtonGroup r12 = r11.f6619v;
            if (r12 == null) goto L6;
            OFloatingTitleBar.a(r11, r12, r10);
            return xd.j.f13877a;
        L6:
            i.j("endButtonGroup");
            throw null;
        }
    }

    public static final class c extends j implements l<Integer, xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OFloatingTitleBar f6626a;

        public c(OFloatingTitleBar r8) {
            this.f6626a = r8;
            super(1);
        }

        @Override // ge.l
        public final xd.j invoke(Integer r8) {
            int r10 = r8.intValue();
            OFloatingTitleBar r11 = this.f6626a;
            r11.f6622y = r10;
            OButtonGroup r12 = r11.f6609b;
            if (r12 == null) goto L6;
            OFloatingTitleBar.a(r11, r12, r10);
            return xd.j.f13877a;
        L6:
            i.j("startButtonGroup");
            throw null;
        }
    }

    public static final class d extends j implements l<Integer, xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OFloatingTitleBar f6627a;

        public d(OFloatingTitleBar r8) {
            this.f6627a = r8;
            super(1);
        }

        @Override // ge.l
        public final xd.j invoke(Integer r8) {
            int r10 = r8.intValue();
            int r11 = OFloatingTitleBar.A;
            OFloatingTitleBar r12 = this.f6627a;
            r12.getClass();
            OButtonGroup r13 = r12.f6618u;
            if (r13 == null) goto L6;
            OFloatingTitleBar.a(r12, r13, r10);
            return xd.j.f13877a;
        L6:
            i.j("endSubButtonGroup");
            throw null;
        }
    }

    public OFloatingTitleBar(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
        LayoutInflater.from(r8).inflate(R.layout.o_floating_title_bar_layout, this, true);
        setClipChildren(false);
        setClipToPadding(false);
        View r11 = findViewById(R.id.start_container);
        i.e(r11, "findViewById(R.id.start_container)");
        this.f6608a = (FrameLayout) r11;
        View r12 = findViewById(R.id.start_button_group);
        i.e(r12, "findViewById(R.id.start_button_group)");
        this.f6609b = (OButtonGroup) r12;
        View r13 = findViewById(R.id.start_title_container);
        i.e(r13, "findViewById(R.id.start_title_container)");
        LinearLayout r14 = (LinearLayout) r13;
        View r15 = findViewById(R.id.start_title);
        i.e(r15, "findViewById(R.id.start_title)");
        this.f6610m = (OTextView) r15;
        View r16 = findViewById(R.id.start_sub_title);
        i.e(r16, "findViewById(R.id.start_sub_title)");
        this.f6611n = (OTextView) r16;
        View r17 = findViewById(R.id.center_container);
        i.e(r17, "findViewById(R.id.center_container)");
        this.f6612o = (FrameLayout) r17;
        View r18 = findViewById(R.id.center_button_group);
        i.e(r18, "findViewById(R.id.center_button_group)");
        this.f6613p = (OButtonGroup) r18;
        View r19 = findViewById(R.id.center_custom_container);
        i.e(r19, "findViewById(R.id.center_custom_container)");
        this.f6614q = (FrameLayout) r19;
        View r20 = findViewById(R.id.center_title_container);
        i.e(r20, "findViewById(R.id.center_title_container)");
        LinearLayout r21 = (LinearLayout) r20;
        View r22 = findViewById(R.id.center_title);
        i.e(r22, "findViewById(R.id.center_title)");
        this.f6615r = (OTextView) r22;
        View r23 = findViewById(R.id.center_sub_title);
        i.e(r23, "findViewById(R.id.center_sub_title)");
        this.f6616s = (OTextView) r23;
        View r24 = findViewById(R.id.end_container);
        i.e(r24, "findViewById(R.id.end_container)");
        this.f6617t = (LinearLayout) r24;
        View r25 = findViewById(R.id.end_sub_button_group);
        i.e(r25, "findViewById(R.id.end_sub_button_group)");
        this.f6618u = (OButtonGroup) r25;
        View r26 = findViewById(R.id.end_button_group);
        i.e(r26, "findViewById(R.id.end_button_group)");
        this.f6619v = (OButtonGroup) r26;
        View r27 = findViewById(R.id.mask);
        i.e(r27, "findViewById(R.id.mask)");
        this.f6620w = r27;
        View r28 = findViewById(R.id.title_bar_container);
        i.e(r28, "findViewById(R.id.title_bar_container)");
        this.f6621x = r28;
        if (r10 == null) goto L53;
        Context r29 = getContext();
        i.e(r29, "context");
        TypedArray r30 = r29.getTheme().obtainStyledAttributes(r10, nb.a.f9497k, 0, 0);
        if (r30.hasValue(16) == false) goto L8;
        setTitleType(r30.getInt(16, 0));
    L8:
        if (r30.hasValue(13) == false) goto L11;
        setStartTitle(r30.getString(13));
    L11:
        if (r30.hasValue(14) == false) goto L14;
        setStartTitleColor(r30.getColor(14, R.color.oui_basic_text_1));
    L14:
        if (r30.hasValue(11) == false) goto L17;
        setStartSubtitle(r30.getString(11));
    L17:
        if (r30.hasValue(12) == false) goto L20;
        setStartSubTitleColor(r30.getColor(12, R.color.oui_basic_text_3));
    L20:
        if (r30.hasValue(3) == false) goto L23;
        setCenterTitle(r30.getString(3));
    L23:
        if (r30.hasValue(4) == false) goto L26;
        setCenterTitleColor(r30.getColor(4, R.color.oui_basic_text_1));
    L26:
        if (r30.hasValue(1) == false) goto L29;
        setCenterSubtitle(r30.getString(1));
    L29:
        if (r30.hasValue(2) == false) goto L31;
        setCenterSubTitleColor(r30.getColor(2, R.color.oui_basic_text_3));
    L31:
        setStartButtonGroupStyle(r30.getResourceId(10, R.style.OFloatingTitleBar_Action_Standard));
        setCenterButtonGroupStyle(r30.getResourceId(0, R.style.OFloatingTitleBar_Action_Standard));
        setSubEndButtonGroupStyle(r30.getResourceId(7, R.style.OFloatingTitleBar_Action_Standard));
        setEndButtonGroupStyle(r30.getResourceId(6, R.style.OFloatingTitleBar_Action_Standard));
        if (r30.hasValue(8) == false) goto L39;
        Drawable r31 = r30.getDrawable(8);
        if (r31 != null) goto L37;
        r31 = new ColorDrawable(r30.getColor(8, 0));
    L37:
        setMaskBackground(r31);
    L39:
        if (r30.hasValue(5) == false) goto L44;
        if (r30.getBoolean(5, false) == false) goto L44;
        Drawable r32 = getResources().getDrawable(R.drawable.o_floating_title_bar_default_mask_bg);
        i.e(r32, "resources.getDrawable(R.…itle_bar_default_mask_bg)");
        setMaskBackground(r32);
    L44:
        if (r30.hasValue(9) == false) goto L47;
        setMaskBlurRadius(r30.getFloat(9, 0.0f));
    L47:
        if (r30.hasValue(15) == true) goto L49;
    L51:
        r30.recycle();
        return;
    L49:
        if (r30.getBoolean(15, false) == false) goto L51;
        setOnApplyWindowInsetsListener(new uc.a(this));
        goto L51
    }

    public static final void a(OFloatingTitleBar r8, OButtonGroup r10, int r11) {
        r8.getClass();
        int r12 = r10.getItemCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        LinearLayout r14 = r10.A;
        if (r14 == null) goto L7;
        View r15 = r14.getChildAt(r13);
    L8:
        e(r15, r11);
        r13 = r13 + 1;
        goto L3
    L7:
        r15 = null;
        goto L8
    }

    public static void d(OTextView r8) {
        CharSequence r10 = r8.getText();
        int r11 = 0;
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L10:
        if ((!r12) == true) goto L13;
        r11 = 8;
    L13:
        r8.setVisibility(r11);
        return;
    L5:
        if (r10.length() == 0) goto L8;
        r12 = false;
        goto L10
    }

    public static void e(View r8, int r10) {
        if ((r8 instanceof ViewGroup) == false) goto L8;
        ViewGroup r11 = (ViewGroup) r8;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L17;
        e(r11.getChildAt(r13), r10);
        r13 = r13 + 1;
        goto L5
    L17:
        return;
    L8:
        if ((r8 instanceof ImageView) == false) goto L11;
        ((ImageView) r8).setColorFilter(r10);
        return;
    L11:
        if ((r8 instanceof TextView) == false) goto L16;
        ((TextView) r8).setTextColor(r10);
        return;
    }

    public final void b(OButtonGroup r8, int r10, l<? super Integer, xd.j> r11) {
        if (r10 != 0) goto L4;
        return;
    L4:
        TypedArray r12 = getContext().obtainStyledAttributes(r10, nb.a.f9505s);
        i.e(r12, "context.obtainStyledAttr…R.styleable.OShadowFrame)");
        int r13 = r12.getColor(0, 0);
        int r14 = r12.getColor(7, 0);
        int r15 = r12.getColor(1, 0);
        int r16 = r12.getColor(15, 0);
        r12.recycle();
        if (r13 == 0) goto L10;
        if (r15 != 0) goto L9;
        r15 = r13;
    L9:
        r8.f13089s = r13;
        r8.f13090t = r15;
        r8.j(r8.isEnabled());
    L10:
        if (r14 == 0) goto L12;
        r8.setPressColor(r14);
    L12:
        if (r16 == 0) goto L15;
        r11.invoke(Integer.valueOf(r16));
        return;
    }

    public final OUIFrameLayout c(int r8, int r10) {
        Context r11 = getContext();
        i.e(r11, "context");
        OUIFrameLayout r12 = new OUIFrameLayout(r11, null, 0, 14);
        r12.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        float r13 = 7;
        int r14 = android.aimedia.a.a("Resources.getSystem()", 1, r13);
        int r15 = android.aimedia.a.a("Resources.getSystem()", 1, r13);
        int r16 = android.aimedia.a.a("Resources.getSystem()", 1, r13);
        Resources r17 = Resources.getSystem();
        i.e(r17, "Resources.getSystem()");
        r12.setPadding(r14, r15, r16, l6.a.I0(TypedValue.applyDimension(1, r13, r17.getDisplayMetrics())));
        r12.setClickable(true);
        Resources r18 = Resources.getSystem();
        i.e(r18, "Resources.getSystem()");
        r12.setRadius(l6.a.I0(TypedValue.applyDimension(1, 99, r18.getDisplayMetrics())));
        ImageView r19 = new ImageView(r12.getContext());
        r19.setImageResource(r8);
        if (r10 == 0) goto L5;
        r19.setColorFilter(r10);
    L5:
        float r20 = 22;
        FrameLayout.LayoutParams r21 = new FrameLayout.LayoutParams(android.aimedia.a.a("Resources.getSystem()", 1, r20), android.aimedia.a.a("Resources.getSystem()", 1, r20));
        r21.gravity = 17;
        xd.j r22 = xd.j.f13877a;
        r12.addView(r19, r21);
        return r12;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r19, int r20) {
        OTextView r8 = this.f6615r;
        if (r8 == null) goto L179;
        r8.setMaxWidth(Integer.MAX_VALUE);
        OTextView r10 = this.f6616s;
        if (r10 == null) goto L177;
        r10.setMaxWidth(Integer.MAX_VALUE);
        OTextView r11 = this.f6610m;
        if (r11 == null) goto L175;
        r11.setMaxWidth(Integer.MAX_VALUE);
        OTextView r12 = this.f6611n;
        if (r12 == null) goto L173;
        r12.setMaxWidth(Integer.MAX_VALUE);
        super.onMeasure(r19, r20);
        OButtonGroup r13 = this.f6609b;
        if (r13 != null) goto L13;
        i.j("startButtonGroup");
        throw null;
    L13:
        if (r13.getVisibility() != 0) goto L15;
        boolean r14 = true;
    L16:
        if (r14 == true) goto L37;
        OTextView r15 = this.f6610m;
        if (r15 != null) goto L20;
        i.j("startTitleView");
        throw null;
    L20:
        if (r15.getVisibility() != 0) goto L22;
        boolean r16 = true;
    L23:
        if (r16 == true) goto L37;
        OTextView r17 = this.f6611n;
        if (r17 != null) goto L27;
        i.j("startSubtitleView");
        throw null;
    L27:
        if (r17.getVisibility() != 0) goto L29;
        boolean r18 = true;
    L30:
        if (r18 == true) goto L37;
        boolean r21 = false;
    L38:
        OButtonGroup r22 = this.f6613p;
        if (r22 != null) goto L41;
        i.j("centerButtonGroup");
        throw null;
    L41:
        if (r22.getVisibility() != 0) goto L43;
        boolean r23 = true;
    L44:
        if (r23 == true) goto L74;
        OTextView r24 = this.f6615r;
        if (r24 != null) goto L48;
        i.j("centerTitleView");
        throw null;
    L48:
        if (r24.getVisibility() != 0) goto L50;
        boolean r25 = true;
    L51:
        if (r25 == true) goto L74;
        OTextView r26 = this.f6616s;
        if (r26 != null) goto L55;
        i.j("centerSubtitleView");
        throw null;
    L55:
        if (r26.getVisibility() != 0) goto L57;
        boolean r27 = true;
    L58:
        if (r27 == true) goto L74;
        FrameLayout r28 = this.f6614q;
        if (r28 != null) goto L62;
        i.j("centerCustomContainer");
        throw null;
    L62:
        if (r28.getVisibility() != 0) goto L64;
        boolean r29 = true;
    L65:
        if (r29 == true) goto L74;
        boolean r30 = false;
    L75:
        OButtonGroup r31 = this.f6619v;
        if (r31 != null) goto L78;
        i.j("endButtonGroup");
        throw null;
    L78:
        if (r31.getVisibility() != 0) goto L80;
        boolean r32 = true;
    L81:
        if (r32 == true) goto L93;
        OButtonGroup r33 = this.f6618u;
        if (r33 != null) goto L85;
        i.j("endSubButtonGroup");
        throw null;
    L85:
        if (r33.getVisibility() != 0) goto L87;
        boolean r34 = true;
    L88:
        if (r34 == true) goto L93;
        boolean r35 = false;
    L94:
        int r110 = getMeasuredWidth();
        View r111 = this.f6621x;
        if (r111 == null) goto L165;
        int r112 = r111.getPaddingLeft();
        View r113 = this.f6621x;
        if (r113 == null) goto L163;
        int r114 = r113.getPaddingRight();
        int r36 = android.aimedia.a.a("Resources.getSystem()", 1, 8);
        if (r30 == false) goto L105;
        int r115 = r110 / 2;
        FrameLayout r37 = this.f6612o;
        if (r37 == null) goto L103;
        int r116 = (r115 - (r37.getMeasuredWidth() / 2)) - r36;
    L113:
        if (r21 == false) goto L119;
        int r117 = (r110 / 2) - r112;
        FrameLayout r118 = this.f6608a;
        if (r118 == null) goto L117;
        int r119 = (r117 - r118.getMeasuredWidth()) - r36;
    L120:
        int r120 = (r110 / 2) - r114;
        if (r35 == false) goto L127;
        LinearLayout r38 = this.f6617t;
        if (r38 == null) goto L125;
        r120 = (r120 - r38.getMeasuredWidth()) - r36;
        goto L127
    L125:
        i.j("endContainer");
        throw null;
    L127:
        if (r21 == false) goto L143;
        int r39 = Math.max(0, r116 - r112);
        FrameLayout r40 = this.f6608a;
        if (r40 != null) goto L131;
        i.j("startContainer");
        throw null;
    L131:
        if (r40.getMeasuredWidth() <= r39) goto L143;
        OTextView r41 = this.f6610m;
        if (r41 == null) goto L139;
        r41.setMaxWidth(r39);
        OTextView r42 = this.f6611n;
        if (r42 == null) goto L137;
        r42.setMaxWidth(r39);
        boolean r43 = true;
    L144:
        if (r30 == false) goto L160;
        int r44 = Math.max(0, Math.min(r119 * 2, r120 * 2));
        FrameLayout r45 = this.f6612o;
        if (r45 != null) goto L148;
        i.j("centerContainer");
        throw null;
    L148:
        if (r45.getMeasuredWidth() <= r44) goto L160;
        OTextView r46 = this.f6615r;
        if (r46 == null) goto L156;
        r46.setMaxWidth(r44);
        OTextView r47 = this.f6616s;
        if (r47 == null) goto L154;
        r47.setMaxWidth(r44);
        r43 = true;
        goto L160
    L154:
        i.j("centerSubtitleView");
        throw null;
    L156:
        i.j("centerTitleView");
        throw null;
    L160:
        if (r43 == false) goto L181;
        super.onMeasure(r19, r20);
        return;
    L181:
        return;
    L137:
        i.j("startSubtitleView");
        throw null;
    L139:
        i.j("startTitleView");
        throw null;
    L143:
        r43 = false;
        goto L144
    L117:
        i.j("startContainer");
        throw null;
    L119:
        r119 = (r110 / 2) - r112;
        goto L120
    L103:
        i.j("centerContainer");
        throw null;
    L105:
        if (r35 == false) goto L111;
        int r48 = r110 - r114;
        LinearLayout r121 = this.f6617t;
        if (r121 == null) goto L109;
        r116 = (r48 - r121.getMeasuredWidth()) - r36;
        goto L113
    L109:
        i.j("endContainer");
        throw null;
    L111:
        r116 = r110 - r114;
        goto L113
    L163:
        i.j("titleBarContainer");
        throw null;
    L165:
        i.j("titleBarContainer");
        throw null;
    L87:
        r34 = false;
    L93:
        r35 = true;
        goto L94
    L80:
        r32 = false;
        goto L81
    L64:
        r29 = false;
        goto L65
    L57:
        r27 = false;
        goto L58
    L50:
        r25 = false;
    L74:
        r30 = true;
        goto L75
    L43:
        r23 = false;
        goto L44
    L29:
        r18 = false;
        goto L30
    L22:
        r16 = false;
    L37:
        r21 = true;
        goto L38
    L15:
        r14 = false;
        goto L16
    L173:
        i.j("startSubtitleView");
        throw null;
    L175:
        i.j("startTitleView");
        throw null;
    L177:
        i.j("centerSubtitleView");
        throw null;
    L179:
        i.j("centerTitleView");
        throw null;
    }

    public final void setCenterButtonGroupStyle(int r8) {
        OButtonGroup r10 = this.f6613p;
        if (r10 == null) goto L6;
        b(r10, r8, new a(this));
        return;
    L6:
        i.j("centerButtonGroup");
        throw null;
    }

    public final void setCenterCustomView(View r8) {
        i.f(r8, "view");
        FrameLayout r10 = this.f6614q;
        if (r10 == null) goto L14;
        r10.removeAllViews();
        FrameLayout r11 = this.f6614q;
        if (r11 == null) goto L12;
        r11.addView(r8);
        FrameLayout r12 = this.f6614q;
        if (r12 == null) goto L10;
        r12.setVisibility(0);
        return;
    L10:
        i.j("centerCustomContainer");
        throw null;
    L12:
        i.j("centerCustomContainer");
        throw null;
    L14:
        i.j("centerCustomContainer");
        throw null;
    }

    public final void setCenterSubTitle(int r8) {
        setCenterSubtitle(getResources().getString(r8));
    }

    public final void setCenterSubTitleColor(int r8) {
        OTextView r10 = this.f6616s;
        if (r10 == null) goto L6;
        r10.setTextColor(r8);
        return;
    L6:
        i.j("centerSubtitleView");
        throw null;
    }

    public final void setCenterSubtitle(String r8) {
        OTextView r10 = this.f6616s;
        if (r10 == null) goto L10;
        r10.setText(r8);
        OTextView r11 = this.f6616s;
        if (r11 == null) goto L8;
        d(r11);
        return;
    L8:
        i.j("centerSubtitleView");
        throw null;
    L10:
        i.j("centerSubtitleView");
        throw null;
    }

    public final void setCenterTitle(int r8) {
        setCenterTitle(getResources().getString(r8));
    }

    public final void setCenterTitleColor(int r8) {
        OTextView r10 = this.f6615r;
        if (r10 == null) goto L6;
        r10.setTextColor(r8);
        return;
    L6:
        i.j("centerTitleView");
        throw null;
    }

    public final void setEndButtonGroupStyle(int r8) {
        OButtonGroup r10 = this.f6619v;
        if (r10 == null) goto L6;
        b(r10, r8, new b(this));
        return;
    L6:
        i.j("endButtonGroup");
        throw null;
    }

    public final void setMaskBackground(Drawable r8) {
        i.f(r8, "drawable");
        View r10 = this.f6620w;
        if (r10 == null) goto L10;
        r10.setBackground(r8);
        View r11 = this.f6620w;
        if (r11 == null) goto L8;
        r11.setVisibility(0);
        return;
    L8:
        i.j("mask");
        throw null;
    L10:
        i.j("mask");
        throw null;
    }

    public final void setMaskBlurRadius(float r12) {
        View r8 = this.f6620w;
        if (r8 == null) goto L28;
        jb.a.EnumC0105a[] r10 = jb.a.EnumC0105a.f8817a;
        HashMap<String, Method> r11 = jb.a.f8816a;
        Method r13 = r11.get("setBackdropBlurEffect");
        int r14 = 0;
        boolean r15 = true;
        if (r13 == null) goto L30;
    L9:
        r13.invoke(r8, new Object[]{1, Float.valueOf(r12)});     // Catch: InvocationTargetException -> L11 Throwable -> L13 Throwable -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L11:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (r12 != 0.0f) goto L19;
        r15 = false;
    L19:
        View r16 = this.f6620w;
        if (r16 == null) goto L26;
        if (r15 == true) goto L24;
        r14 = 8;
    L24:
        r16.setVisibility(r14);
        return;
    L26:
        i.j("mask");
        throw null;
    L30:
        Class[] r17 = {Integer.TYPE, Float.TYPE};     // Catch: InvocationTargetException -> L11 Throwable -> L13
        int r18 = NativeReflect.f6092a;     // Catch: InvocationTargetException -> L11 Throwable -> L13
        r13 = View.class.getDeclaredMethod("setBackdropBlurEffect", r17);     // Catch: InvocationTargetException -> L11 Throwable -> L13 Throwable -> L13
        r13.setAccessible(true);     // Catch: InvocationTargetException -> L11 Throwable -> L13 Throwable -> L13
        r11.put("setBackdropBlurEffect", r13);     // Catch: InvocationTargetException -> L11 Throwable -> L13 Throwable -> L13
        goto L9
    L28:
        i.j("mask");
        throw null;
    }

    public final void setStartButtonGroupStyle(int r8) {
        OButtonGroup r10 = this.f6609b;
        if (r10 == null) goto L6;
        b(r10, r8, new c(this));
        return;
    L6:
        i.j("startButtonGroup");
        throw null;
    }

    public final void setStartSubTitleColor(int r8) {
        OTextView r10 = this.f6611n;
        if (r10 == null) goto L6;
        r10.setTextColor(r8);
        return;
    L6:
        i.j("startSubtitleView");
        throw null;
    }

    public final void setStartSubtitle(int r8) {
        setStartSubtitle(getResources().getString(r8));
    }

    public final void setStartTitle(int r8) {
        setStartTitle(getResources().getString(r8));
    }

    public final void setStartTitleColor(int r8) {
        OTextView r10 = this.f6610m;
        if (r10 == null) goto L6;
        r10.setTextColor(r8);
        return;
    L6:
        i.j("startTitleView");
        throw null;
    }

    public final void setSubEndButtonGroupStyle(int r8) {
        OButtonGroup r10 = this.f6618u;
        if (r10 == null) goto L6;
        b(r10, r8, new d(this));
        return;
    L6:
        i.j("endSubButtonGroup");
        throw null;
    }

    public final void setTitleType(int r8) {
        if (r8 != 0) goto L13;
        View r10 = this.f6621x;
        if (r10 == null) goto L11;
        Resources r11 = Resources.getSystem();
        i.e(r11, "Resources.getSystem()");
        r10.setMinimumHeight(l6.a.I0(TypedValue.applyDimension(1, 56, r11.getDisplayMetrics())));
        View r12 = this.f6621x;
        if (r12 == null) goto L9;
        float r13 = 12;
        int r14 = android.aimedia.a.a("Resources.getSystem()", 1, r13);
        float r15 = 8;
        int r16 = android.aimedia.a.a("Resources.getSystem()", 1, r15);
        int r17 = android.aimedia.a.a("Resources.getSystem()", 1, r13);
    L19:
        Resources r18 = Resources.getSystem();
        i.e(r18, "Resources.getSystem()");
        r12.setPadding(r14, r16, r17, l6.a.I0(TypedValue.applyDimension(1, r15, r18.getDisplayMetrics())));
        return;
    L9:
        i.j("titleBarContainer");
        throw null;
    L11:
        i.j("titleBarContainer");
        throw null;
    L13:
        if (r8 != 1) goto L24;
        View r19 = this.f6621x;
        if (r19 == null) goto L22;
        Resources r20 = Resources.getSystem();
        i.e(r20, "Resources.getSystem()");
        r19.setMinimumHeight(l6.a.I0(TypedValue.applyDimension(1, 64, r20.getDisplayMetrics())));
        r12 = this.f6621x;
        if (r12 == null) goto L20;
        float r21 = 16;
        r14 = android.aimedia.a.a("Resources.getSystem()", 1, r21);
        r16 = android.aimedia.a.a("Resources.getSystem()", 1, r21);
        r17 = android.aimedia.a.a("Resources.getSystem()", 1, r21);
        r15 = 8;
        goto L19
    L20:
        i.j("titleBarContainer");
        throw null;
    L22:
        i.j("titleBarContainer");
        throw null;
    }

    public final void setCenterTitle(String r8) {
        OTextView r10 = this.f6615r;
        if (r10 == null) goto L10;
        r10.setText(r8);
        OTextView r11 = this.f6615r;
        if (r11 == null) goto L8;
        d(r11);
        return;
    L8:
        i.j("centerTitleView");
        throw null;
    L10:
        i.j("centerTitleView");
        throw null;
    }

    public final void setStartSubtitle(String r8) {
        OTextView r10 = this.f6611n;
        if (r10 == null) goto L10;
        r10.setText(r8);
        OTextView r11 = this.f6611n;
        if (r11 == null) goto L8;
        d(r11);
        return;
    L8:
        i.j("startSubtitleView");
        throw null;
    L10:
        i.j("startSubtitleView");
        throw null;
    }

    public final void setStartTitle(String r8) {
        OTextView r10 = this.f6610m;
        if (r10 == null) goto L10;
        r10.setText(r8);
        OTextView r11 = this.f6610m;
        if (r11 == null) goto L8;
        d(r11);
        return;
    L8:
        i.j("startTitleView");
        throw null;
    L10:
        i.j("startTitleView");
        throw null;
    }
}
