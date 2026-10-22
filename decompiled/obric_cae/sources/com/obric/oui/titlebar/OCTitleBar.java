package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.cae.R;
import com.obric.oui.button.OButton;
import ha.t;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public class OCTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f6588z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f6589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f6590b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FrameLayout f6591m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FrameLayout f6592n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f6593o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f6594p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f6595q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f6596r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f6597s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public OButton f6598t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6599u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6600v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f6601w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f6602x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public a f6603y;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6604a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f6605b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ a[] f6606m = null;

        static {
            a r8 = new a("FIXED_CENTER", 0, 0);
            f6604a = r8;
            a r10 = new a("FLOW_WITH_ACTION", 1, 1);
            a r11 = new a("LEFT_IN_ACTION", 2, 2);
            f6605b = r11;
            f6606m = new a[]{r8, r10, r11};
        }

        public a(String r8, int r10, int r11) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f6606m.clone();
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OCTitleBar f6607a;

        public b(OCTitleBar r8) {
            this.f6607a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r8 = OCTitleBar.f6588z;
            this.f6607a.a();
        }
    }

    public OCTitleBar(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
        this.f6599u = android.aimedia.a.a("Resources.getSystem()", 1, 70);
        this.f6600v = true;
        this.f6603y = a.f6604a;
        FrameLayout.inflate(r8, R.layout.o_title_bar_container, this);
        View r11 = findViewById(R.id.center_title);
        i.e(r11, "findViewById(R.id.center_title)");
        this.f6594p = (TextView) r11;
        View r12 = findViewById(R.id.left_title);
        i.e(r12, "findViewById(R.id.left_title)");
        this.f6595q = (TextView) r12;
        View r13 = findViewById(R.id.ll_left_action_container);
        i.e(r13, "findViewById(R.id.ll_left_action_container)");
        this.f6589a = (LinearLayout) r13;
        View r14 = findViewById(R.id.ll_right_action_container);
        i.e(r14, "findViewById(R.id.ll_right_action_container)");
        this.f6590b = (LinearLayout) r14;
        View r15 = findViewById(R.id.fl_center_action_container);
        i.e(r15, "findViewById(R.id.fl_center_action_container)");
        this.f6591m = (FrameLayout) r15;
        View r16 = findViewById(R.id.fl_fixed_center_action_container);
        i.e(r16, "findViewById(R.id.fl_fix…_center_action_container)");
        this.f6592n = (FrameLayout) r16;
        View r17 = findViewById(R.id.fixed_center_title);
        i.e(r17, "findViewById(R.id.fixed_center_title)");
        this.f6596r = (TextView) r17;
        View r18 = findViewById(R.id.left_action_back);
        i.e(r18, "findViewById(R.id.left_action_back)");
        this.f6598t = (OButton) r18;
        View r19 = findViewById(R.id.fixed_center_sub_title);
        i.e(r19, "findViewById(R.id.fixed_center_sub_title)");
        this.f6597s = (TextView) r19;
        View r20 = findViewById(R.id.fixed_center_title_container);
        i.e(r20, "findViewById(R.id.fixed_center_title_container)");
        this.f6593o = (ViewGroup) r20;
        if (r10 == null) goto L10;
        Context r21 = getContext();
        i.e(r21, "context");
        TypedArray r22 = r21.getTheme().obtainStyledAttributes(r10, nb.a.f9491e, 0, 0);
        setMTitlePosition(a.values()[r22.getInt(3, 0)]);     // Catch: Throwable -> L7
        setTitleText(r22.getString(4));     // Catch: Throwable -> L7
        setShowLeftBack(r22.getBoolean(5, true));     // Catch: Throwable -> L7
        setSubTitleText(r22.getString(1));     // Catch: Throwable -> L7
        r22.recycle();
        return;
    L7:
        th = move-exception;
        r22.recycle();
        throw th;
    }

    public final void a() {
        a r8 = this.f6603y;
        if (r8 != a.f6605b) goto L10;
        TextView r10 = this.f6595q;
        if (r10 == null) goto L7;
        r10.requestLayout();
        return;
    L7:
        i.j("mLeftTitleView");
        throw null;
    L10:
        if (r8 != a.f6604a) goto L25;
        TextView r11 = this.f6596r;
        if (r11 == null) goto L22;
        r11.requestLayout();
        TextView r12 = this.f6597s;
        if (r12 == null) goto L20;
        r12.requestLayout();
        FrameLayout r13 = this.f6592n;
        if (r13 == null) goto L18;
        r13.requestLayout();
        return;
    L18:
        i.j("mFixedCenterContainer");
        throw null;
    L20:
        i.j("mFixedCenterSubTitleView");
        throw null;
    L22:
        i.j("mFixedCenterTitleView");
        throw null;
    }

    public final ViewGroup getFixedCenterTitleContainer() {
        ViewGroup r8 = this.f6593o;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("fixedCenterTitleContainer");
        throw null;
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r8 = this.f6591m;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mCenterContainer");
        throw null;
    }

    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r8 = this.f6592n;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mFixedCenterContainer");
        throw null;
    }

    public final OButton getMLeftActionBack() {
        OButton r8 = this.f6598t;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mLeftActionBack");
        throw null;
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r8 = this.f6589a;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mLeftContainer");
        throw null;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r8 = this.f6590b;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mRightContainer");
        throw null;
    }

    public final a getMTitlePosition() {
        return this.f6603y;
    }

    public final TextView getMTitleView() {
        int r8 = this.f6603y.ordinal();
        if (r8 != 0) goto L5;
        TextView r10 = this.f6596r;
        if (r10 == null) goto L23;
    L22:
        return r10;
    L23:
        i.j("mFixedCenterTitleView");
        throw null;
    L5:
        if (r8 != 1) goto L7;
        r10 = this.f6594p;
        if (r10 != null) goto L22;
        i.j("mCenterTitleView");
        throw null;
    L7:
        if (r8 != 2) goto L14;
        r10 = this.f6595q;
        if (r10 != null) goto L22;
        i.j("mLeftTitleView");
        throw null;
    L14:
        throw new t();
    }

    public final boolean getShowLeftBack() {
        return this.f6600v;
    }

    public final String getSubTitleText() {
        return this.f6601w;
    }

    public final String getTitleText() {
        return this.f6602x;
    }

    public final TextView getTitleView() {
        return getMTitleView();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
        a r11 = this.f6603y;
        int r12 = 0;
        if (r11 != a.f6605b) goto L51;
        TextView r13 = this.f6595q;
        if (r13 == null) goto L48;
        int r14 = getMeasuredWidth();
        LinearLayout r15 = this.f6590b;
        if (r15 == null) goto L46;
        int r16 = r14 - r15.getMeasuredWidth();
        LinearLayout r17 = this.f6589a;
        if (r17 == null) goto L44;
        int r18 = r16 - r17.getPaddingLeft();
        LinearLayout r19 = this.f6589a;
        if (r19 == null) goto L42;
        int r20 = r18 - r19.getPaddingRight();
        TextView r21 = this.f6595q;
        if (r21 == null) goto L40;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if ((r22 instanceof ViewGroup.MarginLayoutParams) == true) goto L17;
        r22 = null;
    L17:
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
        if (r23 == null) goto L20;
        int r24 = r23.rightMargin;
    L21:
        int r25 = r20 - r24;
        TextView r26 = this.f6595q;
        if (r26 == null) goto L38;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        if ((r27 instanceof ViewGroup.MarginLayoutParams) == true) goto L26;
        r27 = null;
    L26:
        ViewGroup.MarginLayoutParams r28 = (ViewGroup.MarginLayoutParams) r27;
        if (r28 == null) goto L29;
        r12 = r28.rightMargin;
    L29:
        int r29 = r25 - r12;
        TextView r30 = this.f6595q;
        if (r30 == null) goto L36;
        int r31 = r29 - r30.getPaddingLeft();
        TextView r32 = this.f6595q;
        if (r32 == null) goto L34;
        r13.setMaxWidth(r31 - r32.getPaddingRight());
        return;
    L34:
        i.j("mLeftTitleView");
        throw null;
    L36:
        i.j("mLeftTitleView");
        throw null;
    L38:
        i.j("mLeftTitleView");
        throw null;
    L20:
        r24 = 0;
        goto L21
    L40:
        i.j("mLeftTitleView");
        throw null;
    L42:
        i.j("mLeftContainer");
        throw null;
    L44:
        i.j("mLeftContainer");
        throw null;
    L46:
        i.j("mRightContainer");
        throw null;
    L48:
        i.j("mLeftTitleView");
        throw null;
    L51:
        if (r11 != a.f6604a) goto L149;
        LinearLayout r33 = this.f6589a;
        if (r33 != null) goto L55;
        i.j("mLeftContainer");
        throw null;
    L55:
        if (r33.getVisibility() != 0) goto L72;
        LinearLayout r34 = this.f6589a;
        if (r34 == null) goto L70;
        int r35 = r34.getMeasuredWidth();
        LinearLayout r36 = this.f6589a;
        if (r36 == null) goto L68;
        ViewGroup.LayoutParams r37 = r36.getLayoutParams();
        if ((r37 instanceof ViewGroup.MarginLayoutParams) == true) goto L63;
        r37 = null;
    L63:
        ViewGroup.MarginLayoutParams r38 = (ViewGroup.MarginLayoutParams) r37;
        if (r38 == null) goto L66;
        int r39 = r38.leftMargin;
    L67:
        int r40 = r35 + r39;
    L73:
        LinearLayout r41 = this.f6590b;
        if (r41 != null) goto L76;
        i.j("mRightContainer");
        throw null;
    L76:
        if (r41.getVisibility() != 0) goto L93;
        LinearLayout r42 = this.f6590b;
        if (r42 == null) goto L91;
        int r43 = r42.getMeasuredWidth();
        LinearLayout r44 = this.f6590b;
        if (r44 == null) goto L89;
        ViewGroup.LayoutParams r45 = r44.getLayoutParams();
        if ((r45 instanceof ViewGroup.MarginLayoutParams) == true) goto L84;
        r45 = null;
    L84:
        ViewGroup.MarginLayoutParams r46 = (ViewGroup.MarginLayoutParams) r45;
        if (r46 == null) goto L87;
        int r47 = r46.rightMargin;
    L88:
        int r48 = r43 + r47;
    L94:
        int r49 = Math.max(r40, r48);
        FrameLayout r50 = this.f6592n;
        if (r50 != null) goto L97;
        i.j("mFixedCenterContainer");
        throw null;
    L97:
        if (r50.getVisibility() != 0) goto L150;
        FrameLayout r51 = this.f6592n;
        if (r51 == null) goto L140;
        ViewGroup.LayoutParams r52 = r51.getLayoutParams();
        if ((r52 instanceof ViewGroup.MarginLayoutParams) == true) goto L103;
        r52 = null;
    L103:
        ViewGroup.MarginLayoutParams r53 = (ViewGroup.MarginLayoutParams) r52;
        if (r53 == null) goto L106;
        int r54 = r53.leftMargin;
    L107:
        FrameLayout r55 = this.f6592n;
        if (r55 == null) goto L138;
        ViewGroup.LayoutParams r56 = r55.getLayoutParams();
        if ((r56 instanceof ViewGroup.MarginLayoutParams) == true) goto L112;
        r56 = null;
    L112:
        ViewGroup.MarginLayoutParams r57 = (ViewGroup.MarginLayoutParams) r56;
        if (r57 == null) goto L115;
        r12 = r57.rightMargin;
    L115:
        int r58 = Math.max((getMeasuredWidth() - (r49 * 2)) - (r54 + r12), this.f6599u);
        TextView r59 = this.f6596r;
        if (r59 == null) goto L136;
        if (r59 == null) goto L134;
        int r60 = r59.getPaddingLeft() + r58;
        TextView r61 = this.f6596r;
        if (r61 == null) goto L132;
        r59.setMaxWidth(r61.getPaddingRight() + r60);
        TextView r62 = this.f6597s;
        if (r62 == null) goto L130;
        if (r62 == null) goto L128;
        int r63 = r62.getPaddingLeft() + r58;
        TextView r64 = this.f6597s;
        if (r64 == null) goto L126;
        r62.setMaxWidth(r64.getPaddingRight() + r63);
        return;
    L126:
        i.j("mFixedCenterSubTitleView");
        throw null;
    L128:
        i.j("mFixedCenterSubTitleView");
        throw null;
    L130:
        i.j("mFixedCenterSubTitleView");
        throw null;
    L132:
        i.j("mFixedCenterTitleView");
        throw null;
    L134:
        i.j("mFixedCenterTitleView");
        throw null;
    L136:
        i.j("mFixedCenterTitleView");
        throw null;
    L138:
        i.j("mFixedCenterContainer");
        throw null;
    L106:
        r54 = 0;
        goto L107
    L140:
        i.j("mFixedCenterContainer");
        throw null;
    L150:
        return;
    L87:
        r47 = 0;
        goto L88
    L89:
        i.j("mRightContainer");
        throw null;
    L91:
        i.j("mRightContainer");
        throw null;
    L93:
        r48 = 0;
        goto L94
    L66:
        r39 = 0;
        goto L67
    L68:
        i.j("mLeftContainer");
        throw null;
    L70:
        i.j("mLeftContainer");
        throw null;
    L72:
        r40 = 0;
        goto L73
    }

    public final void setCenterText(int r8) {
        String r10 = getResources().getString(r8);
        i.e(r10, "resources.getString(resId)");
        setTitleText(r10);
    }

    public final void setFixedCenterTitleContainer(ViewGroup r8) {
        i.f(r8, "<set-?>");
        this.f6593o = r8;
    }

    public final void setMCenterContainer(FrameLayout r8) {
        i.f(r8, "<set-?>");
        this.f6591m = r8;
    }

    public final void setMFixedCenterContainer(FrameLayout r8) {
        i.f(r8, "<set-?>");
        this.f6592n = r8;
    }

    public final void setMLeftActionBack(OButton r8) {
        i.f(r8, "<set-?>");
        this.f6598t = r8;
    }

    public final void setMLeftContainer(LinearLayout r8) {
        i.f(r8, "<set-?>");
        this.f6589a = r8;
    }

    public final void setMRightContainer(LinearLayout r8) {
        i.f(r8, "<set-?>");
        this.f6590b = r8;
    }

    public final void setMTitlePosition(a r8) {
        i.f(r8, "value");
        this.f6603y = r8;
        int r10 = r8.ordinal();
        if (r10 != 0) goto L5;
        TextView r11 = this.f6596r;
        if (r11 == null) goto L48;
        r11.setVisibility(0);
        TextView r12 = this.f6594p;
        if (r12 == null) goto L46;
        r12.setVisibility(8);
        TextView r13 = this.f6595q;
        if (r13 == null) goto L44;
    L41:
        r13.setVisibility(8);
    L42:
        getMTitleView().setText(this.f6602x);
        return;
    L44:
        i.j("mLeftTitleView");
        throw null;
    L46:
        i.j("mCenterTitleView");
        throw null;
    L48:
        i.j("mFixedCenterTitleView");
        throw null;
    L5:
        if (r10 != 1) goto L7;
        TextView r14 = this.f6596r;
        if (r14 == null) goto L33;
        r14.setVisibility(8);
        TextView r15 = this.f6594p;
        if (r15 == null) goto L31;
        r15.setVisibility(0);
        r13 = this.f6595q;
        if (r13 != null) goto L41;
        i.j("mLeftTitleView");
        throw null;
    L31:
        i.j("mCenterTitleView");
        throw null;
    L33:
        i.j("mFixedCenterTitleView");
        throw null;
    L7:
        if (r10 != 2) goto L42;
        TextView r16 = this.f6596r;
        if (r16 == null) goto L20;
        r16.setVisibility(8);
        TextView r17 = this.f6594p;
        if (r17 == null) goto L18;
        r17.setVisibility(8);
        TextView r18 = this.f6595q;
        if (r18 == null) goto L16;
        r18.setVisibility(0);
        setShowLeftBack(false);
        goto L42
    L16:
        i.j("mLeftTitleView");
        throw null;
    L18:
        i.j("mCenterTitleView");
        throw null;
    L20:
        i.j("mFixedCenterTitleView");
        throw null;
    }

    public final void setMinCenterTitleWidth(int r8) {
        this.f6599u = android.aimedia.a.a("Resources.getSystem()", 1, r8);
        post(new b(this));
    }

    public final void setShowLeftBack(boolean r8) {
        this.f6600v = r8;
        OButton r10 = this.f6598t;
        if (r10 != null) goto L5;
        i.j("mLeftActionBack");
        throw null;
    L5:
        if (r8 == false) goto L7;
        int r11 = 0;
    L8:
        r10.setVisibility(r11);
        if (this.f6603y != a.f6605b) goto L15;
        OButton r12 = this.f6598t;
        if (r12 == null) goto L13;
        r12.setVisibility(8);
        return;
    L13:
        i.j("mLeftActionBack");
        throw null;
    L15:
        return;
    L7:
        r11 = 8;
        goto L8
    }

    public final void setSubTitleText(String r8) {
        this.f6601w = r8;
        if (r8 != null) goto L9;
        TextView r10 = this.f6597s;
        if (r10 == null) goto L7;
        r10.setVisibility(8);
        return;
    L7:
        i.j("mFixedCenterSubTitleView");
        throw null;
    L9:
        TextView r11 = this.f6597s;
        if (r11 == null) goto L28;
        r11.setVisibility(0);
        TextView r12 = this.f6597s;
        if (r12 == null) goto L26;
        r12.setText(r8);
        Resources r13 = getResources();
        i.e(r13, "resources");
        if (r13.getConfiguration().fontScale <= 1.0f) goto L24;
        TextView r14 = this.f6596r;
        if (r14 == null) goto L22;
        r14.setTextSize(1, 16.0f);
        TextView r15 = this.f6597s;
        if (r15 == null) goto L20;
        r15.setTextSize(1, 12.0f);
        goto L24
    L20:
        i.j("mFixedCenterSubTitleView");
        throw null;
    L22:
        i.j("mFixedCenterTitleView");
        throw null;
    L24:
        a();
        return;
    L26:
        i.j("mFixedCenterSubTitleView");
        throw null;
    L28:
        i.j("mFixedCenterSubTitleView");
        throw null;
    }

    public final void setTitleText(String r8) {
        this.f6602x = r8;
        if (r8 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r8);
        a();
    }

    public final void setCenterText(String r8) {
        i.f(r8, "title");
        setTitleText(r8);
    }
}
