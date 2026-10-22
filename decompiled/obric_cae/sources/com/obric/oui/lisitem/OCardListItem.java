package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.obric.cae.R;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.checkbox.OCheckMark;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.text.OTextView;
import he.i;
import lc.b;
import lc.c;
import lc.d;
import lc.e;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OCardListItem extends FrameLayout {
    public static final /* synthetic */ int L = 0;
    public final ImageView A;
    public final View B;
    public final b C;
    public final int D;
    public final int E;
    public final OSwipeLayout F;
    public final FrameLayout G;
    public int H;
    public boolean I;
    public int J;
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f6348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6349b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6350m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final FrameLayout f6351n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final FrameLayout f6352o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final OUILinearLayout f6353p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final GradientDrawable f6354q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ColorStateList f6355r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final FrameLayout f6356s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ImageView f6357t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final LinearLayout f6358u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final OTextView f6359v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6360w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final OTextView f6361x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6362y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final FrameLayout f6363z;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OCardListItem f6364a;

        public a(OCardListItem r8) {
            this.f6364a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OCardListItem r8 = this.f6364a;
            int r10 = r8.D;
            int r11 = r8.E;
            ViewGroup.LayoutParams r12 = null;
            if (r10 == (-1)) goto L5;
            if (r11 == (-1)) goto L5;
        L42:
            ViewGroup.LayoutParams r13 = r8.B.getLayoutParams();
            if ((r13 instanceof ViewGroup.MarginLayoutParams) == false) goto L46;
            r12 = r13;
        L46:
            ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r12;
            if (r14 == null) goto L49;
            r14.setMargins(r10, r14.topMargin, r11, r14.bottomMargin);
        L49:
            r8.B.setLayoutParams(r14);
            return;
        L5:
            ViewGroup.LayoutParams r15 = r8.f6352o.getLayoutParams();
            if ((r15 instanceof ViewGroup.MarginLayoutParams) == true) goto L8;
            r15 = null;
        L8:
            ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
            boolean r17 = false;
            if (r16 == null) goto L11;
            int r18 = r16.leftMargin;
        L12:
            int r19 = r8.f6352o.getPaddingLeft();
            ViewGroup.LayoutParams r20 = r8.f6352o.getLayoutParams();
            if ((r20 instanceof ViewGroup.MarginLayoutParams) == true) goto L15;
            r20 = null;
        L15:
            ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r20;
            if (r21 == null) goto L18;
            int r22 = r21.rightMargin;
        L19:
            int r23 = r8.f6352o.getPaddingRight();
            r10 = r18 + r19;
            if (r8.f6356s.getVisibility() != 0) goto L22;
            boolean r24 = true;
        L23:
            if (r24 == false) goto L26;
            r10 = r10 + r8.f6356s.getWidth();
        L26:
            if (r8.f6357t.getVisibility() != 0) goto L28;
            boolean r25 = true;
        L29:
            if (r25 == false) goto L32;
            r10 = r10 + r8.f6357t.getWidth();
        L32:
            if (r8.f6356s.getVisibility() != 8) goto L34;
            boolean r26 = true;
        L35:
            if (r26 == true) goto L37;
        L41:
            Resources r27 = Resources.getSystem();
            i.e(r27, "Resources.getSystem()");
            r11 = l6.a.I0(TypedValue.applyDimension(1, 8, r27.getDisplayMetrics())) + (r22 + r23);
            goto L42
        L37:
            if (r8.f6357t.getVisibility() != 8) goto L39;
            r17 = true;
        L39:
            if (r17 == false) goto L41;
            r10 = r8.f6358u.getPaddingLeft() + r10;
            goto L41
        L34:
            r26 = false;
            goto L35
        L28:
            r25 = false;
            goto L29
        L22:
            r24 = false;
            goto L23
        L18:
            r22 = 0;
            goto L19
        L11:
            r18 = 0;
            goto L12
        }
    }

    public OCardListItem(Context r17, AttributeSet r18) {
        i.f(r17, "context");
        int r8 = 0;
        super(r17, r18, 0);
        boolean r10 = true;
        this.f6349b = true;
        this.f6350m = getResources().getColor(R.color.oui_fill_list_item_card);
        this.f6354q = new GradientDrawable();
        ColorStateList r11 = getResources().getColorStateList(R.color.o_card_list_item_content_bg_color);
        i.e(r11, "resources.getColorStateL…st_item_content_bg_color)");
        this.f6355r = r11;
        this.f6360w = getResources().getColor(R.color.oui_basic_text_1);
        this.f6362y = getResources().getColor(R.color.oui_basic_text_3);
        this.D = -1;
        this.E = -1;
        this.I = true;
        this.J = -1;
        this.K = 0;
        if (getLayoutParams() != null) goto L5;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    L5:
        View r12 = LayoutInflater.from(r17).inflate(R.layout.o_card_list_item_layout, this, true);
        if (r12 == null) goto L133;
        FrameLayout r13 = (FrameLayout) r12;
        View r14 = findViewById(R.id.card_list_item_root);
        i.e(r14, "findViewById(R.id.card_list_item_root)");
        this.f6351n = (FrameLayout) r14;
        View r15 = findViewById(R.id.card_container);
        i.e(r15, "findViewById(R.id.card_container)");
        FrameLayout r16 = (FrameLayout) r15;
        this.f6352o = r16;
        View r19 = findViewById(R.id.content_container);
        i.e(r19, "findViewById(R.id.content_container)");
        OUILinearLayout r20 = (OUILinearLayout) r19;
        this.f6353p = r20;
        r20.setChangeAlphaWhenPress(false);
        r20.setChangeAlphaWhenDisable(true);
        View r21 = findViewById(R.id.custom_start_container);
        i.e(r21, "findViewById(R.id.custom_start_container)");
        FrameLayout r22 = (FrameLayout) r21;
        this.f6356s = r22;
        View r110 = findViewById(R.id.icon);
        i.e(r110, "findViewById(R.id.icon)");
        ImageView r111 = (ImageView) r110;
        this.f6357t = r111;
        View r112 = findViewById(R.id.title_container);
        i.e(r112, "findViewById(R.id.title_container)");
        this.f6358u = (LinearLayout) r112;
        View r113 = findViewById(R.id.title);
        i.e(r113, "findViewById(R.id.title)");
        OTextView r114 = (OTextView) r113;
        this.f6359v = r114;
        View r115 = findViewById(R.id.sub_title);
        i.e(r115, "findViewById(R.id.sub_title)");
        OTextView r116 = (OTextView) r115;
        this.f6361x = r116;
        View r117 = findViewById(R.id.custom_end_container);
        i.e(r117, "findViewById(R.id.custom_end_container)");
        FrameLayout r118 = (FrameLayout) r117;
        this.f6363z = r118;
        View r119 = findViewById(R.id.tail_icon);
        i.e(r119, "findViewById(R.id.tail_icon)");
        ImageView r120 = (ImageView) r119;
        this.A = r120;
        View r121 = findViewById(R.id.card_divider);
        i.e(r121, "findViewById(R.id.card_divider)");
        this.B = r121;
        this.C = new b(this);
        View r23 = findViewById(R.id.swipe_layout);
        i.e(r23, "findViewById(R.id.swipe_layout)");
        OSwipeLayout r24 = (OSwipeLayout) r23;
        this.F = r24;
        r24.setChangeAlphaWhenDisable(false);
        r24.setSwipeEnabled(false);
        r24.f6560x.add(new c(this));
        View r25 = findViewById(R.id.swip_container);
        i.e(r25, "findViewById(R.id.swip_container)");
        this.G = (FrameLayout) r25;
        if (r18 == null) goto L130;
        TypedArray r26 = getContext().obtainStyledAttributes(r18, nb.a.f9492f);
        i.e(r26, "context.obtainStyledAttr…e.OCardListItemContainer)");
    L127:
        th = move-exception;
        r26.recycle();
        throw th;
    L11:
        if (r26.hasValue(11) == false) goto L13;
        this.f6349b = r26.getBoolean(11, true);     // Catch: Throwable -> L127
    L13:
        this.f6350m = r26.getColor(0, getResources().getColor(R.color.oui_fill_list_item_card));     // Catch: Throwable -> L127
        if (r26.hasValue(3) == false) goto L21;
        ColorStateList r27 = r26.getColorStateList(3);     // Catch: Throwable -> L127
        if (r27 != null) goto L19;
        r27 = getResources().getColorStateList(R.color.o_card_list_item_content_bg_color);     // Catch: Throwable -> L127
        i.e(r27, "resources.getColorStateL…st_item_content_bg_color)");     // Catch: Throwable -> L127
    L19:
        this.f6355r = r27;     // Catch: Throwable -> L127
    L21:
        if (r26.hasValue(2) == false) goto L24;
        this.K = r26.getInt(2, 0);     // Catch: Throwable -> L127
    L24:
        if (r26.hasValue(1) == false) goto L27;
        this.J = r26.getInt(1, 0);     // Catch: Throwable -> L127
    L27:
        if (r26.hasValue(5) == false) goto L30;
        setCustomStartView(r26.getResourceId(5, 0));     // Catch: Throwable -> L127
    L30:
        if (r26.hasValue(7) == false) goto L33;
        setDefaultCustomStartView(r26.getInt(7, 0));     // Catch: Throwable -> L127
    L33:
        if (r26.hasValue(10) == false) goto L36;
        setIcon(r26.getResourceId(10, 0));     // Catch: Throwable -> L127
    L36:
        if (r26.hasValue(22) == false) goto L38;
        setTitle(r26.getString(22));     // Catch: Throwable -> L127
    L38:
        this.f6360w = r26.getColor(23, getResources().getColor(R.color.oui_basic_text_1));     // Catch: Throwable -> L127
        if (r26.hasValue(19) == false) goto L41;
        setSubTitle(r26.getString(19));     // Catch: Throwable -> L127
    L41:
        this.f6362y = r26.getColor(20, getResources().getColor(R.color.oui_basic_text_3));     // Catch: Throwable -> L127
        if (r26.hasValue(4) == false) goto L45;
        setCustomEndView(r26.getResourceId(4, 0));     // Catch: Throwable -> L127
    L45:
        if (r26.hasValue(6) == false) goto L48;
        setDefaultCustomEndView(r26.getInt(6, 0));     // Catch: Throwable -> L127
    L48:
        if (r26.hasValue(9) == false) goto L51;
        setEndDetailText(r26.getString(9));     // Catch: Throwable -> L127
    L51:
        if (r26.hasValue(21) == false) goto L54;
        setTailIcon(r26.getResourceId(21, 0));     // Catch: Throwable -> L127
    L54:
        if (r26.hasValue(8) == false) goto L57;
        setDefaultTailIcon(r26.getInt(8, 0));     // Catch: Throwable -> L127
    L57:
        if (r26.hasValue(13) == false) goto L64;
        if (r26.getBoolean(13, false) == false) goto L61;
        int r28 = 0;
    L62:
        r22.setVisibility(r28);     // Catch: Throwable -> L127
        e();     // Catch: Throwable -> L127
        goto L64
    L61:
        r28 = 8;
    L64:
        if (r26.hasValue(15) == false) goto L71;
        if (r26.getBoolean(15, false) == false) goto L68;
        int r29 = 0;
    L69:
        r111.setVisibility(r29);     // Catch: Throwable -> L127
        e();     // Catch: Throwable -> L127
        goto L71
    L68:
        r29 = 8;
    L71:
        if (r26.hasValue(18) == false) goto L86;
        boolean r30 = r26.getBoolean(18, false);     // Catch: Throwable -> L127
        CharSequence r31 = getTitle();     // Catch: Throwable -> L127
        if (r31 != null) goto L75;
    L78:
        boolean r32 = true;
    L79:
        if (r32 == true) goto L84;
        if (r30 == false) goto L82;
        int r33 = 0;
    L83:
        r114.setVisibility(r33);     // Catch: Throwable -> L127
        goto L86
    L82:
        r33 = 8;
        goto L83
    L84:
        r114.setVisibility(8);     // Catch: Throwable -> L127
        goto L86
    L75:
        if (r31.length() == 0) goto L78;
        r32 = false;
    L86:
        if (r26.hasValue(16) == false) goto L100;
        boolean r34 = r26.getBoolean(16, false);     // Catch: Throwable -> L127
        CharSequence r35 = getSubTitle();     // Catch: Throwable -> L127
        if (r35 != null) goto L90;
    L93:
        if (r10 == true) goto L98;
        if (r34 == false) goto L96;
        int r36 = 0;
    L97:
        r116.setVisibility(r36);     // Catch: Throwable -> L127
        goto L100
    L96:
        r36 = 8;
        goto L97
    L98:
        r116.setVisibility(8);     // Catch: Throwable -> L127
        goto L100
    L90:
        if (r35.length() == 0) goto L93;
        r10 = false;
    L100:
        if (r26.hasValue(12) == false) goto L107;
        if (r26.getBoolean(12, false) == false) goto L104;
        int r37 = 0;
    L105:
        r118.setVisibility(r37);     // Catch: Throwable -> L127
        d();     // Catch: Throwable -> L127
        goto L107
    L104:
        r37 = 8;
    L107:
        if (r26.hasValue(17) == false) goto L114;
        if (r26.getBoolean(17, false) == false) goto L111;
        int r38 = 0;
    L112:
        r120.setVisibility(r38);     // Catch: Throwable -> L127
        d();     // Catch: Throwable -> L127
        goto L114
    L111:
        r38 = 8;
    L114:
        if (r26.hasValue(14) == false) goto L126;
        boolean r39 = r26.getBoolean(14, false);     // Catch: Throwable -> L127
        if (r39 == true) goto L119;
        r8 = 8;
    L119:
        r121.setVisibility(r8);     // Catch: Throwable -> L127
        if (r39 == false) goto L126;
        if (this.I == false) goto L124;
        float r40 = this.H;     // Catch: Throwable -> L127
    L125:
        r121.setTranslationX(r40);     // Catch: Throwable -> L127
        f();     // Catch: Throwable -> L127
        goto L126
    L124:
        r40 = 0.0f;
    L126:
        r26.recycle();
    L130:
        c();
        b();
        setCardType(this.K);
        int r41 = this.f6360w;
        int r42 = this.f6362y;
        this.f6360w = r41;
        this.f6362y = r42;
        r114.setTextColor(r41);
        r116.setTextColor(this.f6362y);
        this.f6348a = new e(r16, this.f6349b, this.f6350m, this.J);
        return;
    L133:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public static void a(View r8, boolean r10) {
        if ((r8 instanceof ViewGroup) == false) goto L7;
        ViewGroup r11 = (ViewGroup) r8;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        View r14 = r11.getChildAt(r13);
        i.e(r14, "child");
        r14.setEnabled(r10);
        a(r14, r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public final void b() {
        FrameLayout r8 = this.f6351n;
        ViewGroup.LayoutParams r10 = r8.getLayoutParams();
        ViewGroup.LayoutParams r11 = null;
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r10 = null;
    L5:
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r10;
        int r13 = 0;
        if (r12 != null) goto L8;
    L16:
        r8.setLayoutParams(r12);
        FrameLayout r14 = this.f6352o;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        r11 = r15;
    L20:
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r11;
        if (r16 != null) goto L23;
    L31:
        r14.setLayoutParams(r16);
        return;
    L23:
        if (this.f6349b == false) goto L25;
        int r17 = 0;
    L26:
        int r18 = r16.topMargin;
        if (this.f6349b == true) goto L30;
        r13 = android.aimedia.a.a("Resources.getSystem()", 1, 8);
    L30:
        r16.setMargins(r17, r18, r13, r16.bottomMargin);
        goto L31
    L25:
        r17 = android.aimedia.a.a("Resources.getSystem()", 1, 8);
        goto L26
    L8:
        if (this.f6349b == false) goto L10;
        int r19 = android.aimedia.a.a("Resources.getSystem()", 1, 12);
    L11:
        int r20 = r12.topMargin;
        if (this.f6349b == false) goto L14;
        int r21 = android.aimedia.a.a("Resources.getSystem()", 1, 12);
    L15:
        r12.setMargins(r19, r20, r21, r12.bottomMargin);
        goto L16
    L14:
        r21 = 0;
        goto L15
    L10:
        r19 = 0;
        goto L11
    }

    public final void c() {
        boolean r8 = true;
        if (this.f6349b == false) goto L5;
        int r10 = 12;
    L6:
        int r11 = android.aimedia.a.a("Resources.getSystem()", 1, r10);
        ColorStateList r12 = this.f6355r;
        GradientDrawable r13 = this.f6354q;
        r13.setColor(r12);
        r13.setCornerRadius(r11);
        this.f6353p.setBackground(r13);
        if (this.B.getVisibility() == 0) goto L10;
        r8 = false;
    L10:
        if (r8 == false) goto L13;
        f();
        return;
    L13:
        return;
    L5:
        r10 = 20;
        goto L6
    }

    public final void d() {
        if (this.f6363z.getVisibility() != 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L25;
        View r10 = getCustomEndView();
        if ((r10 instanceof OTextView) == false) goto L26;
        OTextView r11 = (OTextView) r10;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == true) goto L12;
        r12 = null;
    L12:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        if (r13 == null) goto L23;
        int r14 = r13.leftMargin;
        int r15 = r13.topMargin;
        if (this.A.getVisibility() != 0) goto L17;
        boolean r16 = true;
    L19:
        if (r16 == false) goto L21;
        float r17 = 0;
    L22:
        r13.setMargins(r14, r15, android.aimedia.a.a("Resources.getSystem()", 1, r17), r13.bottomMargin);
        goto L23
    L21:
        r17 = 6;
        goto L22
    L17:
        r16 = false;
    L23:
        r11.setLayoutParams(r13);
        return;
    L26:
        return;
    L25:
        return;
    L5:
        r8 = false;
        goto L6
    }

    public final void e() {
        boolean r8 = true;
        if (this.f6356s.getVisibility() != 8) goto L5;
        boolean r10 = true;
    L6:
        LinearLayout r11 = this.f6358u;
        if (r10 == true) goto L11;
        if ((getCustomStartView() instanceof OCheckBoxLayout) == true) goto L11;
    L16:
        r11.setPadding(0, r11.getPaddingTop(), r11.getPaddingRight(), r11.getPaddingBottom());
    L18:
        if (this.B.getVisibility() == 0) goto L21;
        r8 = false;
    L21:
        if (r8 == false) goto L23;
        f();
    L23:
        requestLayout();
        return;
    L11:
        if (this.f6357t.getVisibility() != 8) goto L13;
        boolean r12 = true;
    L14:
        if (r12 == false) goto L16;
        r11.setPadding(android.aimedia.a.a("Resources.getSystem()", 1, 12), r11.getPaddingTop(), r11.getPaddingRight(), r11.getPaddingBottom());
        goto L18
    L13:
        r12 = false;
        goto L14
    L5:
        r10 = false;
        goto L6
    }

    public final void f() {
        a r8 = new a(this);
        this.B.post(r8);
        requestLayout();
    }

    public final FrameLayout getCardContainer() {
        return this.f6352o;
    }

    public final int getCardPosition() {
        return this.J;
    }

    public final int getCardType() {
        return this.K;
    }

    public final OUILinearLayout getContentContainer() {
        return this.f6353p;
    }

    public final View getCustomEndView() {
        FrameLayout r8 = this.f6363z;
        if (r8.getChildCount() == 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
        return null;
    L8:
        return r8.getChildAt(0);
    L5:
        r10 = false;
        goto L6
    }

    public final View getCustomStartView() {
        FrameLayout r8 = this.f6356s;
        if (r8.getChildCount() == 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
        return null;
    L8:
        return r8.getChildAt(0);
    L5:
        r10 = false;
        goto L6
    }

    public final OCheckBoxLayout getEndCheckBox() {
        if ((getCustomEndView() instanceof OCheckBoxLayout) == false) goto L10;
        View r8 = getCustomEndView();
        if (r8 == null) goto L9;
        return (OCheckBoxLayout) r8;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
    L10:
        return null;
    }

    public final OTextView getEndDetail() {
        if ((getCustomEndView() instanceof OTextView) == false) goto L10;
        View r8 = getCustomEndView();
        if (r8 == null) goto L9;
        return (OTextView) r8;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    L10:
        return null;
    }

    public final OCheckMark getEndMark() {
        if ((getCustomEndView() instanceof OCheckMark) == false) goto L10;
        View r8 = getCustomEndView();
        if (r8 == null) goto L9;
        return (OCheckMark) r8;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckMark");
    L10:
        return null;
    }

    public final OSwitch getEndSwitch() {
        if ((getCustomEndView() instanceof OSwitch) == false) goto L10;
        View r8 = getCustomEndView();
        if (r8 == null) goto L9;
        return (OSwitch) r8;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.oswitch.OSwitch");
    L10:
        return null;
    }

    public final ImageView getIconView() {
        return this.f6357t;
    }

    public final boolean getShowCardBg() {
        return this.f6349b;
    }

    public final OCheckBoxLayout getStartCheckBox() {
        if ((getCustomStartView() instanceof OCheckBoxLayout) == false) goto L10;
        View r8 = getCustomStartView();
        if (r8 == null) goto L9;
        return (OCheckBoxLayout) r8;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
    L10:
        return null;
    }

    public final CharSequence getSubTitle() {
        return this.f6361x.getText();
    }

    public final OTextView getSubTitleView() {
        return this.f6361x;
    }

    public final OSwipeLayout getSwipeLayout() {
        return this.F;
    }

    public final View getSwipeView() {
        FrameLayout r8 = this.G;
        if (r8.getChildCount() != 0) goto L5;
        return null;
    L5:
        return r8.getChildAt(0);
    }

    public final ImageView getTailIconView() {
        return this.A;
    }

    public final CharSequence getTitle() {
        return this.f6359v.getText();
    }

    public final LinearLayout getTitleContainer() {
        return this.f6358u;
    }

    public final OTextView getTitleView() {
        return this.f6359v;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b r8 = this.C;
        this.f6356s.addOnLayoutChangeListener(r8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b r8 = this.C;
        this.f6356s.removeOnLayoutChangeListener(r8);
    }

    public final void setBgColor(int r8) {
        e r10 = this.f6348a;
        r10.f9215c = r8;
        boolean r11 = r10.f9214b;
        r10.a(r10.f9216d, r11);
    }

    public final void setCardPosition(int r8) {
        this.J = r8;
        e r10 = this.f6348a;
        r10.a(r8, r10.f9214b);
    }

    public final void setCardType(int r12) {
        this.K = r12;
        FrameLayout r8 = this.f6356s;
        LinearLayout r10 = this.f6358u;
        ImageView r11 = this.f6357t;
        OUILinearLayout r13 = this.f6353p;
        boolean r14 = false;
        if (r12 != 0) goto L9;
        Resources r15 = Resources.getSystem();
        i.e(r15, "Resources.getSystem()");
        r13.setPaddingRelative(0, 0, l6.a.I0(TypedValue.applyDimension(1, 4, r15.getDisplayMetrics())), 0);
        float r16 = 48;
        Resources r17 = Resources.getSystem();
        i.e(r17, "Resources.getSystem()");
        r13.setMinimumHeight(l6.a.I0(TypedValue.applyDimension(1, r16, r17.getDisplayMetrics())));
        r10.setVisibility(0);
        ViewGroup.LayoutParams r18 = r8.getLayoutParams();
        if (r18 == null) goto L8;
        LinearLayout.LayoutParams r19 = (LinearLayout.LayoutParams) r18;
        r19.width = -2;
        r19.weight = 0.0f;
        j r20 = j.f13877a;
        r8.setLayoutParams(r19);
        ViewGroup.LayoutParams r21 = r11.getLayoutParams();
        r21.width = android.aimedia.a.a("Resources.getSystem()", 1, r16);
        r21.height = android.aimedia.a.a("Resources.getSystem()", 1, r16);
        r11.setLayoutParams(r21);
        int r110 = 10;
    L13:
        float r111 = r110;
        int r22 = android.aimedia.a.a("Resources.getSystem()", 1, r111);
        int r23 = android.aimedia.a.a("Resources.getSystem()", 1, r111);
        int r24 = android.aimedia.a.a("Resources.getSystem()", 1, r111);
        Resources r25 = Resources.getSystem();
        i.e(r25, "Resources.getSystem()");
        r11.setPadding(r22, r23, r24, l6.a.I0(TypedValue.applyDimension(1, r111, r25.getDisplayMetrics())));
    L23:
        r11.setClipToOutline(true);
        r11.setOutlineProvider(new d(this));
        r11.invalidateOutline();
        if (this.B.getVisibility() != 0) goto L26;
        r14 = true;
    L26:
        if (r14 == false) goto L29;
        f();
        return;
    L29:
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L9:
        if (r12 != 1) goto L17;
        Resources r26 = Resources.getSystem();
        i.e(r26, "Resources.getSystem()");
        r13.setPaddingRelative(0, 0, l6.a.I0(TypedValue.applyDimension(1, 4, r26.getDisplayMetrics())), 0);
        float r112 = 60;
        Resources r27 = Resources.getSystem();
        i.e(r27, "Resources.getSystem()");
        r13.setMinimumHeight(l6.a.I0(TypedValue.applyDimension(1, r112, r27.getDisplayMetrics())));
        r10.setVisibility(0);
        ViewGroup.LayoutParams r28 = r8.getLayoutParams();
        if (r28 == null) goto L15;
        LinearLayout.LayoutParams r29 = (LinearLayout.LayoutParams) r28;
        r29.width = -2;
        r29.weight = 0.0f;
        j r30 = j.f13877a;
        r8.setLayoutParams(r29);
        ViewGroup.LayoutParams r31 = r11.getLayoutParams();
        r31.width = android.aimedia.a.a("Resources.getSystem()", 1, r112);
        r31.height = android.aimedia.a.a("Resources.getSystem()", 1, r112);
        r11.setLayoutParams(r31);
        r110 = 12;
        goto L13
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L17:
        if (r12 != 2) goto L23;
        r13.setPaddingRelative(0, 0, 0, 0);
        r13.setMinimumHeight(0);
        r10.setVisibility(8);
        ViewGroup.LayoutParams r113 = r8.getLayoutParams();
        if (r113 == null) goto L22;
        LinearLayout.LayoutParams r114 = (LinearLayout.LayoutParams) r113;
        r114.width = -1;
        r114.weight = 1.0f;
        j r32 = j.f13877a;
        r8.setLayoutParams(r114);
        r8.setVisibility(0);
        e();
        goto L23
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    public final void setContentChecked(boolean r8) {
        GradientDrawable r10 = this.f6354q;
        if (r8 == true) goto L5;
        r10.setColor(this.f6355r);
        return;
    L5:
        if (this.f6355r.isStateful() == false) goto L7;
        int r11 = this.f6355r.getColorForState(FrameLayout.PRESSED_STATE_SET, getResources().getColor(R.color.oui_state_overlay_pressed));
    L8:
        r10.setColor(r11);
        return;
    L7:
        r11 = getResources().getColor(R.color.oui_state_overlay_pressed);
        goto L8
    }

    public final void setContentColor(int r8) {
        ColorStateList r10 = ColorStateList.valueOf(r8);
        i.e(r10, "ColorStateList.valueOf(color)");
        this.f6355r = r10;
        this.f6354q.setColor(r8);
    }

    public final void setCustomEndView(int r8) {
        FrameLayout r10 = this.f6363z;
        r10.removeAllViews();
        if (r8 == 0) goto L9;
        FrameLayout.inflate(getContext(), r8, r10);     // Catch: Exception -> L6
        d();     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public final void setCustomStartView(int r8) {
        FrameLayout r10 = this.f6356s;
        r10.removeAllViews();
        if (r8 == 0) goto L6;
        FrameLayout.inflate(getContext(), r8, r10);     // Catch: Exception -> L12
    L6:
        if (this.B.getVisibility() != 0) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == false) goto L15;
        f();
        return;
    L15:
        return;
    L8:
        r11 = false;
        goto L9
    }

    public final void setDefaultCustomEndView(int r8) {
        this.f6363z.removeAllViews();
        if (r8 != 0) goto L7;
        int r10 = R.layout.o_card_list_item_custom_end_checkbox;
    L5:
        setCustomEndView(r10);
        return;
    L7:
        if (r8 != 1) goto L10;
        r10 = R.layout.o_card_list_item_custom_end_switch;
        goto L5
    L10:
        if (r8 != 2) goto L13;
        r10 = R.layout.o_card_list_item_custom_end_mark;
        goto L5
    L13:
        if (r8 != 3) goto L16;
        r10 = R.layout.o_card_list_item_custom_end_detail;
        goto L5
    }

    public final void setDefaultCustomStartView(int r8) {
        this.f6356s.removeAllViews();
        if (r8 != 0) goto L6;
        setCustomStartView(R.layout.o_card_list_item_custom_start_checkbox);
    L6:
        if (this.B.getVisibility() != 0) goto L8;
        boolean r10 = true;
    L9:
        if (r10 == false) goto L12;
        f();
        return;
    L12:
        return;
    L8:
        r10 = false;
        goto L9
    }

    public final void setDefaultTailIcon(int r8) {
        if (r8 != 0) goto L6;
        Resources r10 = getResources();
        int r11 = R.drawable.o_card_list_item_tail_icon_arrow;
    L4:
        setTailIcon(r10.getDrawable(r11));
        return;
    L6:
        if (r8 != 1) goto L9;
        r10 = getResources();
        r11 = R.drawable.o_card_list_item_tail_icon_chevron;
        goto L4
    }

    public final void setEnableSwipe(boolean r8) {
        this.F.setSwipeEnabled(r8);
        if (r8 == false) goto L5;
        int r10 = 0;
    L6:
        this.G.setVisibility(r10);
        return;
    L5:
        r10 = 8;
        goto L6
    }

    public final void setEnableSwipeDivider(boolean r8) {
        this.I = r8;
        View r10 = this.B;
        if (r10.getVisibility() != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L8;
        return;
    L8:
        if (this.I == false) goto L10;
        float r12 = this.H;
    L11:
        r10.setTranslationX(r12);
        return;
    L10:
        r12 = 0.0f;
        goto L11
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.view.View
    public void setEnabled(boolean r8) {
        super.setEnabled(r8);
        this.f6353p.setEnabled(r8);
        FrameLayout r10 = this.f6356s;
        r10.setEnabled(r8);
        ImageView r11 = this.f6357t;
        r11.setEnabled(r8);
        r11.setEnabled(r8);
        this.f6358u.setEnabled(r8);
        this.f6359v.setEnabled(r8);
        this.f6361x.setEnabled(r8);
        FrameLayout r12 = this.f6363z;
        r12.setEnabled(r8);
        this.A.setEnabled(r8);
        this.F.setEnabled(r8);
        a(r10, r8);
        a(r12, r8);
        a(this.G, r8);
    }

    public final void setEndDetailText(CharSequence r8) {
        setDefaultCustomEndView(3);
        if ((getCustomEndView() instanceof OTextView) == false) goto L9;
        View r10 = getCustomEndView();
        if (r10 == null) goto L8;
        ((OTextView) r10).setText(r8);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    }

    public final void setIcon(int r8) {
        ImageView r10 = this.f6357t;
        if (r8 == 0) goto L5;
        r10.setImageResource(r8);
    L7:
        if (this.B.getVisibility() != 0) goto L9;
        boolean r11 = true;
    L10:
        if (r11 == false) goto L13;
        f();
        return;
    L13:
        return;
    L9:
        r11 = false;
        goto L10
    L5:
        r10.setImageDrawable(null);
        goto L7
    }

    public final void setOnContentClickListener(View.OnClickListener r8) {
        this.f6353p.setOnClickListener(r8);
    }

    public final void setOnContentLongClickListener(View.OnLongClickListener r8) {
        this.f6353p.setOnLongClickListener(r8);
    }

    public final void setShowCardBg(boolean r8) {
        this.f6349b = r8;
        c();
        b();
        boolean r10 = this.f6349b;
        e r11 = this.f6348a;
        r11.a(r11.f9216d, r10);
    }

    public final void setSubTitle(CharSequence r8) {
        this.f6361x.setText(r8);
    }

    public final void setSwipeView(int r8) {
        FrameLayout r10 = this.G;
        r10.removeAllViews();
        if (r8 == 0) goto L9;
        FrameLayout.inflate(getContext(), r8, r10);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public final void setTailIcon(int r8) {
        ImageView r10 = this.A;
        if (r8 == 0) goto L5;
        r10.setImageResource(r8);
        return;
    L5:
        r10.setImageDrawable(null);
    }

    public final void setTitle(CharSequence r8) {
        this.f6359v.setText(r8);
    }

    public final void setContentColor(ColorStateList r8) {
        i.f(r8, "color");
        this.f6355r = r8;
        this.f6354q.setColor(r8);
    }

    public final void setCustomEndView(View r8) {
        FrameLayout r10 = this.f6363z;
        r10.removeAllViews();
        if (r8 == null) goto L6;
        r10.addView(r8);
        return;
    }

    public final void setCustomStartView(View r8) {
        FrameLayout r10 = this.f6356s;
        r10.removeAllViews();
        if (r8 == null) goto L6;
        r10.addView(r8);
    L6:
        if (this.B.getVisibility() != 0) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == false) goto L12;
        f();
        return;
    L12:
        return;
    L8:
        r11 = false;
        goto L9
    }

    public final void setIcon(Drawable r8) {
        if (r8 == null) goto L5;
        this.f6357t.setImageDrawable(r8);
    L5:
        if (this.B.getVisibility() != 0) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == false) goto L11;
        f();
        return;
    L11:
        return;
    L7:
        r10 = false;
        goto L8
    }

    public final void setSwipeView(View r8) {
        FrameLayout r10 = this.G;
        r10.removeAllViews();
        if (r8 == null) goto L6;
        r10.addView(r8);
        return;
    }

    public final void setTailIcon(Drawable r8) {
        if (r8 == null) goto L5;
        this.A.setImageDrawable(r8);
        return;
    }
}
