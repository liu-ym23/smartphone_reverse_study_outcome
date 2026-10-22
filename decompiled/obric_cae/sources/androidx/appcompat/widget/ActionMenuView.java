package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements androidx.appcompat.view.menu.f.b, androidx.appcompat.view.menu.k {
    public Context A;
    public int B;
    public boolean C;
    public ActionMenuPresenter D;
    public androidx.appcompat.view.menu.j.a E;
    public androidx.appcompat.view.menu.f.a F;
    public boolean G;
    public int H;
    public final int I;
    public final int J;
    public e K;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public androidx.appcompat.view.menu.f f955z;

    public interface a {
        boolean a();

        boolean b();
    }

    public static class b implements androidx.appcompat.view.menu.j.a {
        @Override // androidx.appcompat.view.menu.j.a
        public final void a(androidx.appcompat.view.menu.f r8, boolean r10) {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final boolean b(androidx.appcompat.view.menu.f r8) {
            return false;
        }
    }

    public static class c extends LinearLayoutCompat.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f959d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f960e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f961f;

        public c() {
            super(-2, -2);
            this.f956a = false;
        }

        public c(c r8) {
            super(r8);
            this.f956a = r8.f956a;
        }
    }

    public class d implements androidx.appcompat.view.menu.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f962a;

        public d(ActionMenuView r8) {
            this.f962a = r8;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final boolean a(androidx.appcompat.view.menu.f r8, MenuItem r10) {
            e r11 = this.f962a.K;
            if (r11 == null) goto L23;
            Toolbar r12 = ((Toolbar.a) r11).f1076a;
            Iterator<j0.k> r13 = r12.Q.f8390b.iterator();
        L6:
            if (r13.hasNext() == false) goto L10;
            if (r13.next().b() == false) goto L6;
            boolean r14 = true;
        L11:
            if (r14 == false) goto L13;
            boolean r15 = true;
        L17:
            if (r15 == true) goto L19;
            return false;
        L19:
            return true;
        L13:
            Toolbar.h r16 = r12.S;
            if (r16 == null) goto L16;
            r15 = ((androidx.appcompat.app.t.b) r16).f691a.f683b.onMenuItemSelected(0, r10);
            goto L17
        L16:
            r15 = false;
            goto L17
        L10:
            r14 = false;
            goto L11
        L23:
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final void b(androidx.appcompat.view.menu.f r8) {
            androidx.appcompat.view.menu.f.a r10 = this.f962a.F;
            if (r10 == null) goto L6;
            r10.b(r8);
            return;
        }
    }

    public interface e {
    }

    public ActionMenuView() {
        throw null;
    }

    public ActionMenuView(Context r8, AttributeSet r10) {
        super(r8, r10);
        setBaselineAligned(false);
        float r11 = r8.getResources().getDisplayMetrics().density;
        this.I = (int) (56.0f * r11);
        this.J = (int) (r11 * 4.0f);
        this.A = r8;
        this.B = 0;
    }

    public static c j(ViewGroup.LayoutParams r8) {
        if (r8 != null) goto L5;
        c r10 = new c();
        ((LinearLayout.LayoutParams) r10).gravity = 16;
        return r10;
    L5:
        if ((r8 instanceof c) == false) goto L7;
        c r11 = new c((c) r8);
    L9:
        if (((LinearLayout.LayoutParams) r11).gravity > 0) goto L11;
        ((LinearLayout.LayoutParams) r11).gravity = 16;
    L11:
        return r11;
    L7:
        r11 = new c(r8);
        goto L9
    }

    @Override // androidx.appcompat.view.menu.k
    public final void a(androidx.appcompat.view.menu.f r8) {
        this.f955z = r8;
    }

    @Override // androidx.appcompat.view.menu.f.b
    public final boolean b(androidx.appcompat.view.menu.h r8) {
        return this.f955z.s(r8, null, 0);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r8) {
        return r8 instanceof c;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r8) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    public final LinearLayoutCompat.a f() {
        c r8 = new c();
        ((LinearLayout.LayoutParams) r8).gravity = 16;
        return r8;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    public final LinearLayoutCompat.a g(AttributeSet r8) {
        return new c(getContext(), r8);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        c r8 = new c();
        ((LinearLayout.LayoutParams) r8).gravity = 16;
        return r8;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        return new c(getContext(), r8);
    }

    public Menu getMenu() {
        if (this.f955z != null) goto L10;
        Context r8 = getContext();
        androidx.appcompat.view.menu.f r10 = new androidx.appcompat.view.menu.f(r8);
        this.f955z = r10;
        r10.f819e = new d(this);
        ActionMenuPresenter r11 = new ActionMenuPresenter(r8);
        this.D = r11;
        r11.f941v = true;
        r11.f942w = true;
        androidx.appcompat.view.menu.j.a r12 = this.E;
        if (r12 != null) goto L8;
        r12 = new b();
    L8:
        r11.f771o = r12;
        this.f955z.c(r11, this.A);
        ActionMenuPresenter r13 = this.D;
        r13.f774r = this;
        this.f955z = r13.f769m;
    L10:
        return this.f955z;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        ActionMenuPresenter r8 = this.D;
        ActionMenuPresenter.d r10 = r8.f938s;
        if (r10 == null) goto L6;
        return r10.getDrawable();
    L6:
        if (r8.f940u == true) goto L11;
        return null;
    L11:
        return r8.f939t;
    }

    public int getPopupTheme() {
        return this.B;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    public final /* bridge */ /* synthetic */ LinearLayoutCompat.a h(ViewGroup.LayoutParams r8) {
        return j(r8);
    }

    public final boolean k(int r8) {
        boolean r10 = false;
        if (r8 != 0) goto L5;
        return false;
    L5:
        KeyEvent.Callback r11 = getChildAt(r8 - 1);
        KeyEvent.Callback r12 = getChildAt(r8);
        if (r8 < getChildCount()) goto L8;
    L10:
        if (r8 > 0) goto L12;
        return r10;
    L12:
        if ((r12 instanceof a) == true) goto L14;
        return r10;
    L14:
        return r10 | ((a) r12).b();
    L8:
        if ((r11 instanceof a) == false) goto L10;
        r10 = false | ((a) r11).a();
        goto L10
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r8) {
        super.onConfigurationChanged(r8);
        ActionMenuPresenter r10 = this.D;
        if (r10 == null) goto L8;
        r10.d();
        if (this.D.k() == false) goto L9;
        this.D.j();
        this.D.l();
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter r8 = this.D;
        if (r8 == null) goto L8;
        r8.j();
        ActionMenuPresenter.a r10 = r8.D;
        if (r10 == null) goto L9;
        r10.a();
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        if (this.G == true) goto L6;
        super.onLayout(r18, r19, r20, r21, r22);
        return;
    L6:
        int r8 = getChildCount();
        int r10 = (r22 - r20) / 2;
        int r11 = getDividerWidth();
        int r12 = r21 - r19;
        int r13 = (r12 - getPaddingRight()) - getPaddingLeft();
        boolean r14 = b1.a(this);
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
    L8:
        if (r15 >= r8) goto L24;
        View r110 = getChildAt(r15);
        if (r110.getVisibility() == 8) goto L23;
        c r111 = (c) r110.getLayoutParams();
        if (r111.f956a == false) goto L22;
        int r23 = r110.getMeasuredWidth();
        if (k(r15) == false) goto L17;
        r23 = r23 + r11;
    L17:
        int r112 = r110.getMeasuredHeight();
        if (r14 == false) goto L20;
        int r113 = getPaddingLeft() + ((LinearLayout.LayoutParams) r111).leftMargin;
        int r114 = r113 + r23;
    L21:
        int r24 = r10 - (r112 / 2);
        r110.layout(r113, r24, r114, r112 + r24);
        r13 = r13 - r23;
        r16 = 1;
        goto L23
    L20:
        r114 = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) r111).rightMargin;
        r113 = r114 - r23;
        goto L21
    L22:
        r13 = r13 - ((r110.getMeasuredWidth() + ((LinearLayout.LayoutParams) r111).leftMargin) + ((LinearLayout.LayoutParams) r111).rightMargin);
        k(r15);
        r17 = r17 + 1;
    L23:
        r15 = r15 + 1;
        goto L8
    L24:
        if (r8 != 1) goto L28;
        if (r16 != 0) goto L28;
        View r25 = getChildAt(0);
        int r26 = r25.getMeasuredWidth();
        int r27 = r25.getMeasuredHeight();
        int r28 = (r12 / 2) - (r26 / 2);
        int r29 = r10 - (r27 / 2);
        r25.layout(r28, r29, r26 + r28, r27 + r29);
        return;
    L28:
        int r115 = r17 - (r16 ^ 1);
        if (r115 <= 0) goto L31;
        int r30 = r13 / r115;
    L32:
        int r31 = Math.max(0, r30);
        if (r14 == false) goto L43;
        int r32 = getWidth() - getPaddingRight();
        int r33 = 0;
    L35:
        if (r33 >= r8) goto L52;
        View r34 = getChildAt(r33);
        c r35 = (c) r34.getLayoutParams();
        if (r34.getVisibility() == 8) goto L42;
        if (r35.f956a == true) goto L42;
        int r36 = r32 - ((LinearLayout.LayoutParams) r35).rightMargin;
        int r37 = r34.getMeasuredWidth();
        int r38 = r34.getMeasuredHeight();
        int r116 = r10 - (r38 / 2);
        r34.layout(r36 - r37, r116, r36, r38 + r116);
        r32 = r36 - ((r37 + ((LinearLayout.LayoutParams) r35).leftMargin) + r31);
    L42:
        r33 = r33 + 1;
        goto L35
    L52:
        return;
    L43:
        int r39 = getPaddingLeft();
        int r40 = 0;
    L44:
        if (r40 >= r8) goto L65;
        View r41 = getChildAt(r40);
        c r42 = (c) r41.getLayoutParams();
        if (r41.getVisibility() == 8) goto L51;
        if (r42.f956a == true) goto L51;
        int r43 = r39 + ((LinearLayout.LayoutParams) r42).leftMargin;
        int r44 = r41.getMeasuredWidth();
        int r45 = r41.getMeasuredHeight();
        int r117 = r10 - (r45 / 2);
        r41.layout(r43, r117, r43 + r44, r45 + r117);
        r39 = ((r44 + ((LinearLayout.LayoutParams) r42).rightMargin) + r31) + r43;
    L51:
        r40 = r40 + 1;
        goto L44
    L65:
        return;
    L31:
        r30 = 0;
        goto L32
    }

    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v36 */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int r32, int r33) {
        boolean r8 = this.G;
        if (View.MeasureSpec.getMode(r32) != 1073741824) goto L5;
        boolean r10 = true;
    L6:
        this.G = r10;
        if (r8 == r10) goto L9;
        this.H = 0;
    L9:
        int r11 = View.MeasureSpec.getSize(r32);
        if (this.G == false) goto L16;
        androidx.appcompat.view.menu.f r12 = this.f955z;
        if (r12 == null) goto L16;
        if (r11 == this.H) goto L16;
        this.H = r11;
        r12.q(true);
    L16:
        int r13 = getChildCount();
        if (this.G == false) goto L188;
        if (r13 <= 0) goto L188;
        int r14 = View.MeasureSpec.getMode(r33);
        int r15 = View.MeasureSpec.getSize(r32);
        int r16 = View.MeasureSpec.getSize(r33);
        int r17 = getPaddingRight() + getPaddingLeft();
        int r18 = getPaddingBottom() + getPaddingTop();
        int r19 = ViewGroup.getChildMeasureSpec(r33, r18, -2);
        int r20 = r15 - r17;
        int r21 = this.I;
        int r110 = r20 / r21;
        int r111 = r20 % r21;
        if (r110 != 0) goto L22;
        setMeasuredDimension(r20, 0);
        return;
    L22:
        int r112 = (r111 / r110) + r21;
        int r22 = getChildCount();
        int r23 = 0;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
        boolean r116 = false;
        int r117 = 0;
        long r118 = 0;
    L23:
        int r24 = this.J;
        if (r115 >= r22) goto L78;
        View r25 = getChildAt(r115);
        int r119 = r16;
        int r26 = r20;
        if (r25.getVisibility() == 8) goto L77;
        boolean r27 = r25 instanceof ActionMenuItemView;
        int r120 = r113 + 1;
        if (r27 == false) goto L31;
        r25.setPadding(r24, 0, r24, 0);
    L31:
        c r28 = (c) r25.getLayoutParams();
        r28.f961f = false;
        r28.f958c = 0;
        r28.f957b = 0;
        r28.f959d = false;
        ((LinearLayout.LayoutParams) r28).leftMargin = 0;
        ((LinearLayout.LayoutParams) r28).rightMargin = 0;
        if (r27 == true) goto L34;
    L36:
        boolean r29 = false;
    L37:
        r28.f960e = r29;
        if (r28.f956a == false) goto L40;
        int r30 = 1;
    L41:
        c r121 = (c) r25.getLayoutParams();
        int r31 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r19) - r18, View.MeasureSpec.getMode(r19));
        if (r27 == false) goto L44;
        ActionMenuItemView r34 = (ActionMenuItemView) r25;
    L45:
        if (r34 != null) goto L47;
    L49:
        boolean r35 = false;
    L50:
        if (r30 <= 0) goto L61;
        if (r35 == true) goto L53;
    L54:
        r25.measure(View.MeasureSpec.makeMeasureSpec(r30 * r112, Integer.MIN_VALUE), r31);
        int r36 = r25.getMeasuredWidth();
        int r37 = r36 / r112;
        if ((r36 % r112) == 0) goto L57;
        r37 = r37 + 1;
    L57:
        if (r35 == false) goto L63;
        if (r37 >= 2) goto L63;
        r37 = 2;
    L63:
        if (r121.f956a == true) goto L66;
        if (r35 == false) goto L66;
        boolean r38 = true;
    L67:
        r121.f959d = r38;
        r121.f957b = r37;
        r25.measure(View.MeasureSpec.makeMeasureSpec(r112 * r37, 1073741824), r31);
        r114 = Math.max(r114, r37);
        if (r28.f959d == false) goto L71;
        r117 = r117 + 1;
    L71:
        if (r28.f956a == false) goto L73;
        r116 = true;
    L73:
        r110 = r110 - r37;
        r23 = Math.max(r23, r25.getMeasuredHeight());
        if (r37 != 1) goto L76;
        r118 = r118 | ((long) (1 << r115));
    L76:
        r113 = r120;
    L66:
        r38 = false;
        goto L67
    L53:
        if (r30 >= 2) goto L54;
    L61:
        r37 = 0;
        goto L63
    L47:
        if (r34.p() == false) goto L49;
        r35 = true;
        goto L50
    L44:
        r34 = null;
        goto L45
    L40:
        r30 = r110;
        goto L41
    L34:
        if (((ActionMenuItemView) r25).p() == false) goto L36;
        r29 = true;
    L77:
        r115 = r115 + 1;
        r16 = r119;
        r20 = r26;
        r18 = r18;
        r14 = r14;
        goto L23
    L78:
        int r210 = r14;
        int r211 = r20;
        int r122 = r16;
        if (r116 == true) goto L81;
    L83:
        boolean r39 = false;
    L84:
        boolean r40 = false;
    L86:
        if (r117 <= 0) goto L119;
        if (r110 <= 0) goto L119;
        int r41 = Integer.MAX_VALUE;
        int r42 = 0;
        int r43 = 0;
        long r212 = 0;
    L89:
        if (r43 >= r22) goto L99;
        c r123 = (c) getChildAt(r43).getLayoutParams();
        boolean r213 = r40;
        if (r123.f959d == false) goto L98;
        int r44 = r123.f957b;
        if (r44 >= r41) goto L96;
        r212 = 1 << r43;
        r41 = r44;
        r42 = 1;
        goto L98
    L96:
        if (r44 != r41) goto L98;
        r212 = r212 | (1 << r43);
        r42 = r42 + 1;
    L98:
        r43 = r43 + 1;
        r40 = r213;
        goto L89
    L99:
        boolean r214 = r40;
        r118 = r118 | r212;
        if (r42 > r110) goto L101;
        int r45 = r41 + 1;
        int r46 = 0;
    L103:
        if (r46 >= r22) goto L118;
        View r47 = getChildAt(r46);
        c r48 = (c) r47.getLayoutParams();
        int r215 = r23;
        int r124 = r19;
        int r216 = r22;
        long r49 = 1 << r46;
        if ((r212 & r49) == 0) goto L107;
        if (r39 == true) goto L111;
    L115:
        ?? r50 = 1;
    L116:
        r48.f957b += r50;
        r48.f961f = r50;
        r110 = r110 - 1;
    L117:
        r46 = r46 + 1;
        r19 = r124;
        r23 = r215;
        r22 = r216;
        goto L103
    L111:
        if (r48.f960e == false) goto L115;
        r50 = 1;
        r50 = 1;
        if (r110 != 1) goto L116;
        r47.setPadding(r24 + r112, 0, r24, 0);
        goto L116
    L107:
        if (r48.f957b != r45) goto L117;
        r118 = r118 | r49;
        goto L117
    L118:
        r40 = true;
    L101:
        int r217 = r23;
        int r125 = r19;
        int r218 = r22;
        if (r116 == true) goto L124;
        if (r113 != 1) goto L124;
        boolean r51 = true;
    L125:
        if (r110 > 0) goto L127;
    L174:
        int r52 = r218;
        boolean r53 = r214;
    L175:
        if (r53 == false) goto L184;
        int r54 = 0;
    L177:
        if (r54 >= r52) goto L184;
        View r55 = getChildAt(r54);
        c r56 = (c) r55.getLayoutParams();
        if (r56.f961f == true) goto L181;
        int r57 = r125;
    L182:
        r54 = r54 + 1;
        r125 = r57;
        goto L177
    L181:
        r57 = r125;
        r55.measure(View.MeasureSpec.makeMeasureSpec((r56.f957b * r112) + r56.f958c, 1073741824), r57);
    L184:
        if (r210 == 1073741824) goto L186;
        int r58 = r217;
    L187:
        setMeasuredDimension(r211, r58);
        return;
    L186:
        r58 = r122;
        goto L187
    L127:
        if (r118 == 0) goto L174;
        if (r110 < (r113 - 1)) goto L132;
        if (r51 == true) goto L132;
        if (r114 <= 1) goto L174;
    L132:
        float r59 = Long.bitCount(r118);
        if (r51 == true) goto L145;
        if ((r118 & 1) != 0) goto L137;
    L139:
        int r60 = r218 - 1;
        if ((r118 & ((long) (1 << r60))) == 0) goto L145;
        if (((c) getChildAt(r60).getLayoutParams()).f960e == true) goto L145;
        r59 = r59 - 0.5f;
        goto L145
    L137:
        if (((c) getChildAt(0).getLayoutParams()).f960e == true) goto L139;
        r59 = r59 - 0.5f;
    L145:
        if (r59 <= 0.0f) goto L147;
        int r61 = (int) ((r110 * r112) / r59);
    L148:
        boolean r62 = r214;
        r52 = r218;
        int r63 = 0;
    L149:
        if (r63 >= r52) goto L173;
        if ((r118 & ((long) (1 << r63))) == 0) goto L172;
        View r64 = getChildAt(r63);
        c r65 = (c) r64.getLayoutParams();
        if ((r64 instanceof ActionMenuItemView) == false) goto L164;
        r65.f958c = r61;
        r65.f961f = true;
        if (r63 != 0) goto L161;
        if (r65.f960e == true) goto L161;
        ((LinearLayout.LayoutParams) r65).leftMargin = (-r61) / 2;
    L161:
        r62 = true;
        goto L172
    L164:
        if (r65.f956a == false) goto L167;
        r65.f958c = r61;
        r65.f961f = true;
        ((LinearLayout.LayoutParams) r65).rightMargin = (-r61) / 2;
        r62 = true;
        goto L172
    L167:
        if (r63 == 0) goto L170;
        ((LinearLayout.LayoutParams) r65).leftMargin = r61 / 2;
    L170:
        if (r63 == (r52 - 1)) goto L172;
        ((LinearLayout.LayoutParams) r65).rightMargin = r61 / 2;
    L172:
        r63 = r63 + 1;
        goto L149
    L173:
        r53 = r62;
        goto L175
    L147:
        r61 = 0;
    L124:
        r51 = false;
    L119:
        r214 = r40;
        goto L101
    L81:
        if (r113 != 2) goto L83;
        r39 = true;
    L188:
        int r66 = 0;
    L189:
        if (r66 >= r13) goto L191;
        c r67 = (c) getChildAt(r66).getLayoutParams();
        ((LinearLayout.LayoutParams) r67).rightMargin = 0;
        ((LinearLayout.LayoutParams) r67).leftMargin = 0;
        r66 = r66 + 1;
        goto L189
    L191:
        super.onMeasure(r32, r33);
        return;
    L5:
        r10 = false;
        goto L6
    }

    public void setExpandedActionViewsExclusive(boolean r8) {
        this.D.A = r8;
    }

    public void setOnMenuItemClickListener(e r8) {
        this.K = r8;
    }

    public void setOverflowIcon(Drawable r8) {
        getMenu();
        ActionMenuPresenter r10 = this.D;
        ActionMenuPresenter.d r11 = r10.f938s;
        if (r11 == null) goto L5;
        r11.setImageDrawable(r8);
        return;
    L5:
        r10.f940u = true;
        r10.f939t = r8;
    }

    public void setOverflowReserved(boolean r8) {
        this.C = r8;
    }

    public void setPopupTheme(int r8) {
        if (this.B == r8) goto L9;
        this.B = r8;
        if (r8 != 0) goto L7;
        this.A = getContext();
        return;
    L7:
        this.A = new ContextThemeWrapper(getContext(), r8);
        return;
    }

    public void setPresenter(ActionMenuPresenter r8) {
        this.D = r8;
        r8.f774r = this;
        this.f955z = r8.f769m;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r8) {
        return j(r8);
    }
}
