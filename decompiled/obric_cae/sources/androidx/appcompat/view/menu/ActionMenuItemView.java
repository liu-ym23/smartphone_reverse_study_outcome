package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.y;
import androidx.appcompat.widget.y0;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends y implements k.a, View.OnClickListener, ActionMenuView.a {
    public final int A;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public h f738q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f739r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Drawable f740s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public f.b f741t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public a f742u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b f743v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f744w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f745x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f746y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f747z;

    public class a extends g0 {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final /* synthetic */ ActionMenuItemView f748t;

        public a(ActionMenuItemView r8) {
            this.f748t = r8;
            super(r8);
        }

        @Override // androidx.appcompat.widget.g0
        public final h.f b() {
            b r8 = this.f748t.f743v;
            if (r8 == null) goto L8;
            ActionMenuPresenter.a r10 = ((ActionMenuPresenter.b) r8).f948a.D;
            if (r10 != null) goto L7;
            return null;
        L7:
            return r10.b();
        L8:
            return null;
        }

        @Override // androidx.appcompat.widget.g0
        public final boolean c() {
            ActionMenuItemView r8 = this.f748t;
            f.b r10 = r8.f741t;
            if (r10 != null) goto L5;
            return false;
        L5:
            if (r10.b(r8.f738q) == false) goto L13;
            h.f r11 = b();
            if (r11 != null) goto L9;
            return false;
        L9:
            if (r11.isShowing() == false) goto L15;
            return true;
        L15:
            return false;
        L13:
            return false;
        }
    }

    public static abstract class b {
    }

    public ActionMenuItemView(Context r8, AttributeSet r10) {
        super(r8, r10, 0);
        Resources r11 = r8.getResources();
        this.f744w = q();
        TypedArray r12 = r8.obtainStyledAttributes(r10, c.a.f3217c, 0, 0);
        this.f746y = r12.getDimensionPixelSize(0, 0);
        r12.recycle();
        this.A = (int) ((r11.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f747z = -1;
        setSaveEnabled(false);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public final boolean a() {
        return p();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public final boolean b() {
        if (p() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f738q.getIcon() != null) goto L7;
        return true;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public final void c(h r8) {
        this.f738q = r8;
        setIcon(r8.getIcon());
        setTitle(r8.getTitleCondensed());
        setId(r8.f843a);
        if (r8.isVisible() == false) goto L5;
        int r10 = 0;
    L6:
        setVisibility(r10);
        setEnabled(r8.isEnabled());
        if (r8.hasSubMenu() == true) goto L9;
        return;
    L9:
        if (this.f742u != null) goto L13;
        this.f742u = new a(this);
        return;
    L13:
        return;
    L5:
        r10 = 8;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.k.a
    public h getItemData() {
        return this.f738q;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        f.b r10 = this.f741t;
        if (r10 == null) goto L6;
        r10.b(this.f738q);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration r8) {
        super.onConfigurationChanged(r8);
        this.f744w = q();
        r();
    }

    @Override // androidx.appcompat.widget.y, android.widget.TextView, android.view.View
    public final void onMeasure(int r8, int r10) {
        boolean r11 = p();
        if (r11 == false) goto L7;
        int r12 = this.f747z;
        if (r12 < 0) goto L7;
        super.setPadding(r12, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    L7:
        super.onMeasure(r8, r10);
        int r13 = View.MeasureSpec.getMode(r8);
        int r14 = View.MeasureSpec.getSize(r8);
        int r15 = getMeasuredWidth();
        int r16 = this.f746y;
        if (r13 != Integer.MIN_VALUE) goto L10;
        int r17 = Math.min(r14, r16);
    L12:
        if (r13 == 1073741824) goto L16;
        if (r16 <= 0) goto L16;
        if (r15 >= r17) goto L16;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r17, 1073741824), r10);
    L16:
        if (r11 == false) goto L18;
        return;
    L18:
        if (this.f740s == null) goto L22;
        super.setPadding((getMeasuredWidth() - this.f740s.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        return;
    L22:
        return;
    L10:
        r17 = r16;
        goto L12
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        if (this.f738q.hasSubMenu() == false) goto L11;
        a r10 = this.f742u;
        if (r10 == null) goto L11;
        if (r10.onTouch(this, r8) == false) goto L11;
        return true;
    L11:
        return super.onTouchEvent(r8);
    }

    public final boolean p() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean q() {
        Configuration r8 = getContext().getResources().getConfiguration();
        int r10 = r8.screenWidthDp;
        int r11 = r8.screenHeightDp;
        if (r10 < 480) goto L5;
    L11:
        return true;
    L5:
        if (r10 < 640) goto L8;
        if (r11 >= 480) goto L11;
    L8:
        if (r8.orientation == 2) goto L11;
        return false;
    }

    public final void r() {
        boolean r8 = true;
        boolean r10 = !TextUtils.isEmpty(this.f739r);
        if (this.f740s != null) goto L5;
    L15:
        boolean r11 = r10 & r8;
        CharSequence r12 = null;
        if (r11 == false) goto L18;
        CharSequence r13 = this.f739r;
    L19:
        setText(r13);
        CharSequence r14 = this.f738q.f859q;
        if (TextUtils.isEmpty(r14) == false) goto L24;
        if (r11 == false) goto L23;
        r14 = null;
        goto L24
    L23:
        r14 = this.f738q.f847e;
    L24:
        setContentDescription(r14);
        CharSequence r15 = this.f738q.f860r;
        if (TextUtils.isEmpty(r15) == false) goto L30;
        if (r11 == true) goto L29;
        r12 = this.f738q.f847e;
    L29:
        y0.a(this, r12);
        return;
    L30:
        y0.a(this, r15);
        return;
    L18:
        r13 = null;
        goto L19
    L5:
        if ((this.f738q.f867y & 4) != 4) goto L7;
        boolean r16 = true;
    L8:
        if (r16 == true) goto L10;
    L14:
        r8 = false;
        goto L15
    L10:
        if (this.f744w == true) goto L15;
        if (this.f745x == false) goto L14;
    L7:
        r16 = false;
        goto L8
    }

    public void setCheckable(boolean r8) {
    }

    public void setChecked(boolean r8) {
    }

    public void setExpandedFormat(boolean r8) {
        if (this.f745x == r8) goto L8;
        this.f745x = r8;
        h r10 = this.f738q;
        if (r10 == null) goto L9;
        f r11 = r10.f856n;
        r11.f825k = true;
        r11.q(true);
        return;
    L9:
        return;
    }

    public void setIcon(Drawable r8) {
        this.f740s = r8;
        if (r8 == null) goto L11;
        int r10 = r8.getIntrinsicWidth();
        int r11 = r8.getIntrinsicHeight();
        int r12 = this.A;
        if (r10 <= r12) goto L7;
        r11 = (int) (r11 * (r12 / r10));
        r10 = r12;
    L7:
        if (r11 <= r12) goto L9;
        r10 = (int) (r10 * (r12 / r11));
    L10:
        r8.setBounds(0, 0, r10, r12);
        goto L11
    L9:
        r12 = r11;
    L11:
        setCompoundDrawables(r8, null, null, null);
        r();
    }

    public void setItemInvoker(f.b r8) {
        this.f741t = r8;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int r8, int r10, int r11, int r12) {
        this.f747z = r8;
        super.setPadding(r8, r10, r11, r12);
    }

    public void setPopupCallback(b r8) {
        this.f743v = r8;
    }

    public void setTitle(CharSequence r8) {
        this.f739r = r8;
        r();
    }
}
