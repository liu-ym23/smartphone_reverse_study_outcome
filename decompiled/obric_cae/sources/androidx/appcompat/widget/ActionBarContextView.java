package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.cae.R;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends androidx.appcompat.widget.a {
    public final int A;
    public final int B;
    public boolean C;
    public final int D;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f910s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CharSequence f911t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f912u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f913v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f914w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public LinearLayout f915x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TextView f916y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public TextView f917z;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.b f918a;

        public a(g.b r8) {
            this.f918a = r8;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            this.f918a.c();
        }
    }

    public ActionBarContextView(Context r8, AttributeSet r10) {
        super(r8, r10, R.attr.actionModeStyle);
        TypedArray r11 = r8.obtainStyledAttributes(r10, c.a.f3218d, R.attr.actionModeStyle, 0);
        v0 r12 = new v0(r8, r11);
        Drawable r13 = r12.e(0);
        WeakHashMap<View, j0.h0> r14 = j0.w.f8437a;
        j0.w.d.q(this, r13);
        this.A = r12.i(5, 0);
        this.B = r12.i(4, 0);
        this.f1092o = r11.getLayoutDimension(3, 0);
        this.D = r12.i(2, R.layout.abc_action_mode_close_item_material);
        r12.n();
    }

    public final void f(g.b r8) {
        View r10 = this.f912u;
        if (r10 != null) goto L6;
        View r11 = LayoutInflater.from(getContext()).inflate(this.D, this, false);
        this.f912u = r11;
    L8:
        addView(r11);
    L9:
        View r12 = this.f912u.findViewById(R.id.action_mode_close_button);
        this.f913v = r12;
        r12.setOnClickListener(new a(r8));
        androidx.appcompat.view.menu.f r13 = r8.e();
        ActionMenuPresenter r14 = this.f1091n;
        if (r14 == null) goto L14;
        r14.j();
        ActionMenuPresenter.a r15 = r14.D;
        if (r15 == null) goto L14;
        r15.a();
    L14:
        ActionMenuPresenter r16 = new ActionMenuPresenter(getContext());
        this.f1091n = r16;
        r16.f941v = true;
        r16.f942w = true;
        ViewGroup.LayoutParams r17 = new ViewGroup.LayoutParams(-2, -1);
        r13.c(this.f1091n, this.f1089b);
        ActionMenuPresenter r18 = this.f1091n;
        androidx.appcompat.view.menu.k r19 = r18.f774r;
        if (r19 != null) goto L17;
        androidx.appcompat.view.menu.k r20 = (androidx.appcompat.view.menu.k) r18.f770n.inflate(r18.f772p, this, false);
        r18.f774r = r20;
        r20.a(r18.f769m);
        r18.d();
    L17:
        androidx.appcompat.view.menu.k r21 = r18.f774r;
        if (r19 == r21) goto L20;
        ((ActionMenuView) r21).setPresenter(r18);
    L20:
        ActionMenuView r22 = (ActionMenuView) r21;
        this.f1090m = r22;
        WeakHashMap<View, j0.h0> r23 = j0.w.f8437a;
        j0.w.d.q(r22, null);
        addView(this.f1090m, r17);
        return;
    L6:
        if (r10.getParent() != null) goto L9;
        r11 = this.f912u;
        goto L8
    }

    public final void g() {
        if (this.f915x != null) goto L10;
        LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
        LinearLayout r8 = (LinearLayout) getChildAt(getChildCount() - 1);
        this.f915x = r8;
        this.f916y = (TextView) r8.findViewById(R.id.action_bar_title);
        this.f917z = (TextView) this.f915x.findViewById(R.id.action_bar_subtitle);
        int r10 = this.A;
        if (r10 == 0) goto L7;
        this.f916y.setTextAppearance(getContext(), r10);
    L7:
        int r11 = this.B;
        if (r11 == 0) goto L10;
        this.f917z.setTextAppearance(getContext(), r11);
    L10:
        this.f916y.setText(this.f910s);
        this.f917z.setText(this.f911t);
        boolean r12 = !TextUtils.isEmpty(this.f910s);
        boolean r13 = !TextUtils.isEmpty(this.f911t);
        TextView r14 = this.f917z;
        int r15 = 0;
        if (r13 == false) goto L13;
        int r16 = 0;
    L14:
        r14.setVisibility(r16);
        LinearLayout r17 = this.f915x;
        if (r12 == true) goto L19;
        if (r13 == true) goto L19;
        r15 = 8;
    L19:
        r17.setVisibility(r15);
        if (this.f915x.getParent() != null) goto L23;
        addView(this.f915x);
        return;
    L23:
        return;
    L13:
        r16 = 8;
        goto L14
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        return new ViewGroup.MarginLayoutParams(getContext(), r8);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f911t;
    }

    public CharSequence getTitle() {
        return this.f910s;
    }

    public final void h() {
        removeAllViews();
        this.f914w = null;
        this.f1090m = null;
        this.f1091n = null;
        View r8 = this.f913v;
        if (r8 == null) goto L6;
        r8.setOnClickListener(null);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter r8 = this.f1091n;
        if (r8 == null) goto L8;
        r8.j();
        ActionMenuPresenter.a r10 = this.f1091n.D;
        if (r10 == null) goto L9;
        r10.a();
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        boolean r14 = b1.a(this);
        if (r14 == false) goto L5;
        int r15 = (r12 - r10) - getPaddingRight();
    L6:
        int r16 = getPaddingTop();
        int r17 = ((r13 - r11) - getPaddingTop()) - getPaddingBottom();
        View r18 = this.f912u;
        if (r18 != null) goto L9;
    L25:
        LinearLayout r19 = this.f915x;
        if (r19 != null) goto L28;
    L32:
        View r20 = this.f914w;
        if (r20 == null) goto L35;
        androidx.appcompat.widget.a.d(r15, r16, r17, r20, r14);
    L35:
        if (r14 == false) goto L37;
        int r21 = getPaddingLeft();
    L38:
        ActionMenuView r22 = this.f1090m;
        if (r22 == null) goto L42;
        androidx.appcompat.widget.a.d(r21, r16, r17, r22, !r14);
        return;
    L42:
        return;
    L37:
        r21 = (r12 - r10) - getPaddingRight();
        goto L38
    L28:
        if (this.f914w != null) goto L32;
        if (r19.getVisibility() == 8) goto L32;
        r15 = r15 + androidx.appcompat.widget.a.d(r15, r16, r17, this.f915x, r14);
        goto L32
    L9:
        if (r18.getVisibility() == 8) goto L25;
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) this.f912u.getLayoutParams();
        if (r14 == false) goto L13;
        int r24 = r23.rightMargin;
    L14:
        if (r14 == false) goto L16;
        int r25 = r23.leftMargin;
    L17:
        if (r14 == false) goto L19;
        int r26 = r15 - r24;
    L20:
        int r27 = androidx.appcompat.widget.a.d(r26, r16, r17, this.f912u, r14) + r26;
        if (r14 == false) goto L23;
        int r28 = r27 - r25;
    L24:
        r15 = r28;
        goto L25
    L23:
        r28 = r27 + r25;
        goto L24
    L19:
        r26 = r15 + r24;
        goto L20
    L16:
        r25 = r23.rightMargin;
        goto L17
    L13:
        r24 = r23.leftMargin;
        goto L14
    L5:
        r15 = getPaddingLeft();
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r11, int r12) {
        int r8 = 1073741824;
        if (View.MeasureSpec.getMode(r11) != 1073741824) goto L64;
        if (View.MeasureSpec.getMode(r12) == 0) goto L62;
        int r13 = View.MeasureSpec.getSize(r11);
        int r10 = this.f1092o;
        if (r10 > 0) goto L10;
        r10 = View.MeasureSpec.getSize(r12);
    L10:
        int r14 = getPaddingBottom() + getPaddingTop();
        int r15 = (r13 - getPaddingLeft()) - getPaddingRight();
        int r16 = r10 - r14;
        int r17 = View.MeasureSpec.makeMeasureSpec(r16, Integer.MIN_VALUE);
        View r18 = this.f912u;
        if (r18 == null) goto L13;
        int r19 = androidx.appcompat.widget.a.c(r18, r15, r17);
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) this.f912u.getLayoutParams();
        r15 = r19 - (r20.leftMargin + r20.rightMargin);
    L13:
        ActionMenuView r21 = this.f1090m;
        if (r21 != null) goto L16;
    L18:
        LinearLayout r22 = this.f915x;
        int r23 = 0;
        if (r22 != null) goto L21;
    L36:
        View r24 = this.f914w;
        if (r24 == null) goto L52;
        ViewGroup.LayoutParams r25 = r24.getLayoutParams();
        int r26 = r25.width;
        if (r26 == (-2)) goto L41;
        int r27 = 1073741824;
    L42:
        if (r26 < 0) goto L44;
        r15 = Math.min(r26, r15);
    L44:
        int r28 = r25.height;
        if (r28 != (-2)) goto L48;
        r8 = Integer.MIN_VALUE;
    L48:
        if (r28 < 0) goto L50;
        r16 = Math.min(r28, r16);
    L50:
        this.f914w.measure(View.MeasureSpec.makeMeasureSpec(r15, r27), View.MeasureSpec.makeMeasureSpec(r16, r8));
        goto L52
    L41:
        r27 = Integer.MIN_VALUE;
    L52:
        if (this.f1092o > 0) goto L59;
        int r110 = getChildCount();
        r10 = 0;
    L54:
        if (r23 >= r110) goto L59;
        int r29 = getChildAt(r23).getMeasuredHeight() + r14;
        if (r29 <= r10) goto L58;
        r10 = r29;
    L58:
        r23 = r23 + 1;
    L59:
        setMeasuredDimension(r13, r10);
        return;
    L21:
        if (this.f914w != null) goto L36;
        if (this.C == false) goto L35;
        this.f915x.measure(View.MeasureSpec.makeMeasureSpec(0, 0), r17);
        int r30 = this.f915x.getMeasuredWidth();
        if (r30 > r15) goto L27;
        boolean r31 = true;
    L28:
        if (r31 == false) goto L30;
        r15 = r15 - r30;
    L30:
        LinearLayout r32 = this.f915x;
        if (r31 == false) goto L33;
        int r33 = 0;
    L34:
        r32.setVisibility(r33);
        goto L36
    L33:
        r33 = 8;
        goto L34
    L27:
        r31 = false;
        goto L28
    L35:
        r15 = androidx.appcompat.widget.a.c(r22, r15, r17);
        goto L36
    L16:
        if (r21.getParent() != this) goto L18;
        r15 = androidx.appcompat.widget.a.c(this.f1090m, r15, r17);
        goto L18
    L62:
        throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
    L64:
        throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int r8) {
        this.f1092o = r8;
    }

    public void setCustomView(View r8) {
        View r10 = this.f914w;
        if (r10 == null) goto L5;
        removeView(r10);
    L5:
        this.f914w = r8;
        if (r8 == null) goto L10;
        LinearLayout r11 = this.f915x;
        if (r11 == null) goto L10;
        removeView(r11);
        this.f915x = null;
    L10:
        if (r8 == null) goto L12;
        addView(r8);
    L12:
        requestLayout();
    }

    public void setSubtitle(CharSequence r8) {
        this.f911t = r8;
        g();
    }

    public void setTitle(CharSequence r8) {
        this.f910s = r8;
        g();
        j0.w.n(this, r8);
    }

    public void setTitleOptional(boolean r8) {
        if (r8 == this.C) goto L5;
        requestLayout();
    L5:
        this.C = r8;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int r8) {
        super.setVisibility(r8);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
