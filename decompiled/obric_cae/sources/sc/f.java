package sc;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.cae.R;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import ha.t;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f12089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f12090b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FrameLayout f12091m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FrameLayout f12092n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f12093o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f12094p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f12095q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f12096r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public FrameLayout f12097s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public OTextView f12098t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public OButton f12099u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f12100v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f12101w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f12102x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f12103y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a f12104z;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12105a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f12106b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ a[] f12107m = null;

        static {
            a r8 = new a("FIXED_CENTER", 0, 0);
            f12105a = r8;
            a r10 = new a("FLOW_WITH_ACTION", 1, 1);
            a r11 = new a("LEFT_IN_ACTION", 2, 2);
            f12106b = r11;
            f12107m = new a[]{r8, r10, r11};
        }

        public a(String r8, int r10, int r11) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f12107m.clone();
        }
    }

    public f(Context r8) {
        i.f(r8, "context");
        super(r8, null, 0);
        this.f12100v = true;
        this.f12104z = a.f12105a;
        FrameLayout.inflate(r8, R.layout.o_sheet_title_bar_container, this);
        View r10 = findViewById(R.id.center_title);
        i.e(r10, "findViewById(R.id.center_title)");
        this.f12093o = (TextView) r10;
        View r11 = findViewById(R.id.left_title);
        i.e(r11, "findViewById(R.id.left_title)");
        this.f12094p = (TextView) r11;
        View r12 = findViewById(R.id.ll_left_action_container);
        i.e(r12, "findViewById(R.id.ll_left_action_container)");
        this.f12089a = (LinearLayout) r12;
        View r13 = findViewById(R.id.ll_right_action_container);
        i.e(r13, "findViewById(R.id.ll_right_action_container)");
        this.f12090b = (LinearLayout) r13;
        View r14 = findViewById(R.id.fl_center_action_container);
        i.e(r14, "findViewById(R.id.fl_center_action_container)");
        this.f12091m = (FrameLayout) r14;
        View r15 = findViewById(R.id.fl_fixed_center_action_container);
        i.e(r15, "findViewById(R.id.fl_fix…_center_action_container)");
        this.f12092n = (FrameLayout) r15;
        View r16 = findViewById(R.id.fixed_center_title);
        i.e(r16, "findViewById(R.id.fixed_center_title)");
        this.f12095q = (TextView) r16;
        View r17 = findViewById(R.id.left_action_back);
        i.e(r17, "findViewById(R.id.left_action_back)");
        this.f12099u = (OButton) r17;
        View r18 = findViewById(R.id.fixed_center_sub_title);
        i.e(r18, "findViewById(R.id.fixed_center_sub_title)");
        this.f12096r = (TextView) r18;
        View r19 = findViewById(R.id.sheet_title_bar_des);
        i.e(r19, "findViewById(R.id.sheet_title_bar_des)");
        this.f12097s = (FrameLayout) r19;
        View r20 = findViewById(R.id.sheet_title_bar_des_text);
        i.e(r20, "findViewById(R.id.sheet_title_bar_des_text)");
        OTextView r21 = (OTextView) r20;
        this.f12098t = r21;
        r21.setEnableAutoAlignLeft(true);
    }

    public final String getDesText() {
        return this.f12103y;
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r8 = this.f12091m;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mCenterContainer");
        throw null;
    }

    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r8 = this.f12092n;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mFixedCenterContainer");
        throw null;
    }

    public final OButton getMLeftActionBack() {
        OButton r8 = this.f12099u;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mLeftActionBack");
        throw null;
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r8 = this.f12089a;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mLeftContainer");
        throw null;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r8 = this.f12090b;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mRightContainer");
        throw null;
    }

    public final a getMTitlePosition() {
        return this.f12104z;
    }

    public final TextView getMTitleView() {
        int r8 = this.f12104z.ordinal();
        if (r8 != 0) goto L5;
        TextView r10 = this.f12095q;
        if (r10 == null) goto L23;
    L22:
        return r10;
    L23:
        i.j("mFixedCenterTitleView");
        throw null;
    L5:
        if (r8 != 1) goto L7;
        r10 = this.f12093o;
        if (r10 != null) goto L22;
        i.j("mCenterTitleView");
        throw null;
    L7:
        if (r8 != 2) goto L14;
        r10 = this.f12094p;
        if (r10 != null) goto L22;
        i.j("mLeftTitleView");
        throw null;
    L14:
        throw new t();
    }

    public final boolean getShowLeftBack() {
        return this.f12100v;
    }

    public final String getSubTitleText() {
        return this.f12101w;
    }

    public final String getTitleText() {
        return this.f12102x;
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
    }

    public final void setCenterText(int r8) {
        String r10 = getResources().getString(r8);
        i.e(r10, "resources.getString(resId)");
        setTitleText(r10);
    }

    public final void setDesText(String r8) {
        this.f12103y = r8;
        if (r8 != null) goto L5;
    L8:
        boolean r10 = true;
    L10:
        if (r10 == false) goto L16;
        FrameLayout r11 = this.f12097s;
        if (r11 == null) goto L14;
        r11.setVisibility(8);
        return;
    L14:
        i.j("mDesContainerView");
        throw null;
    L16:
        FrameLayout r12 = this.f12097s;
        if (r12 == null) goto L24;
        r12.setVisibility(0);
        OTextView r13 = this.f12098t;
        if (r13 == null) goto L22;
        r13.setText(r8);
        return;
    L22:
        i.j("mDesTextView");
        throw null;
    L24:
        i.j("mDesContainerView");
        throw null;
    L5:
        if (r8.length() == 0) goto L8;
        r10 = false;
        goto L10
    }

    public final void setMCenterContainer(FrameLayout r8) {
        i.f(r8, "<set-?>");
        this.f12091m = r8;
    }

    public final void setMFixedCenterContainer(FrameLayout r8) {
        i.f(r8, "<set-?>");
        this.f12092n = r8;
    }

    public final void setMLeftActionBack(OButton r8) {
        i.f(r8, "<set-?>");
        this.f12099u = r8;
    }

    public final void setMLeftContainer(LinearLayout r8) {
        i.f(r8, "<set-?>");
        this.f12089a = r8;
    }

    public final void setMRightContainer(LinearLayout r8) {
        i.f(r8, "<set-?>");
        this.f12090b = r8;
    }

    public final void setMTitlePosition(a r8) {
        i.f(r8, "value");
        this.f12104z = r8;
        int r10 = r8.ordinal();
        if (r10 != 0) goto L5;
        TextView r11 = this.f12095q;
        if (r11 == null) goto L48;
        r11.setVisibility(0);
        TextView r12 = this.f12093o;
        if (r12 == null) goto L46;
        r12.setVisibility(8);
        TextView r13 = this.f12094p;
        if (r13 == null) goto L44;
    L41:
        r13.setVisibility(8);
    L42:
        getMTitleView().setText(this.f12102x);
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
        TextView r14 = this.f12095q;
        if (r14 == null) goto L33;
        r14.setVisibility(8);
        TextView r15 = this.f12093o;
        if (r15 == null) goto L31;
        r15.setVisibility(0);
        r13 = this.f12094p;
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
        TextView r16 = this.f12095q;
        if (r16 == null) goto L20;
        r16.setVisibility(8);
        TextView r17 = this.f12093o;
        if (r17 == null) goto L18;
        r17.setVisibility(8);
        TextView r18 = this.f12094p;
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

    public final void setShowLeftBack(boolean r8) {
        this.f12100v = r8;
        OButton r10 = this.f12099u;
        if (r10 != null) goto L5;
        i.j("mLeftActionBack");
        throw null;
    L5:
        if (r8 == false) goto L7;
        int r11 = 0;
    L8:
        r10.setVisibility(r11);
        if (this.f12104z != a.f12106b) goto L15;
        OButton r12 = this.f12099u;
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
        this.f12101w = r8;
        if (r8 != null) goto L9;
        TextView r10 = this.f12096r;
        if (r10 == null) goto L7;
        r10.setVisibility(8);
        return;
    L7:
        i.j("mFixedCenterSubTitleView");
        throw null;
    L9:
        TextView r11 = this.f12096r;
        if (r11 == null) goto L17;
        r11.setVisibility(0);
        TextView r12 = this.f12096r;
        if (r12 == null) goto L15;
        r12.setText(r8);
        return;
    L15:
        i.j("mFixedCenterSubTitleView");
        throw null;
    L17:
        i.j("mFixedCenterSubTitleView");
        throw null;
    }

    public final void setTitleText(String r8) {
        this.f12102x = r8;
        if (r8 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r8);
    }

    public final void setCenterText(String r8) {
        i.f(r8, "title");
        setTitleText(r8);
    }
}
