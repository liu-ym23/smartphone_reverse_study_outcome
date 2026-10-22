package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.i;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import q5.d;
import q5.f;
import q5.j;
import q5.k;

/* JADX INFO: loaded from: classes.dex */
public class a extends Drawable implements i.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @StyleRes
    private static final int f2997s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @AttrRes
    private static final int f2998t = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final WeakReference<Context> f2999c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    private final MaterialShapeDrawable f3000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    private final i f3001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    private final Rect f3002i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    private final BadgeState f3003j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f3004k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f3005l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f3006m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f3007n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f3008o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f3009p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private WeakReference<View> f3010q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private WeakReference<FrameLayout> f3011r;

    /* JADX INFO: renamed from: com.google.android.material.badge.a$a, reason: collision with other inner class name */
    class RunnableC0076a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f3012c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ FrameLayout f3013g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f3014h;

        RunnableC0076a(a r10, View r11, FrameLayout r12) {
            this.f3014h = r10;
            this.f3012c = r11;
            this.f3013g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3014h.A(this.f3012c, this.f3013g);
        }
    }

    static {
        f2997s = k.Widget_MaterialComponents_Badge;
        f2998t = q5.b.badgeStyle;
    }

    private a(@NonNull Context r10, @XmlRes int r11, @AttrRes int r12, @StyleRes int r13, @Nullable BadgeState.State r14) {
        this.f2999c = new WeakReference(r10);
        com.google.android.material.internal.k.c(r10);
        this.f3002i = new Rect();
        this.f3000g = new MaterialShapeDrawable();
        i r15 = new i(this);
        this.f3001h = r15;
        r15.e().setTextAlign(Paint.Align.CENTER);
        x(k.TextAppearance_MaterialComponents_Badge);
        this.f3003j = new BadgeState(r10, r11, r12, r13, r14);
        v();
    }

    private void B() {
        Context r10 = this.f2999c.get();
        WeakReference<View> r11 = this.f3010q;
        FrameLayout r12 = null;
        if (r11 == null) goto L5;
        View r13 = r11.get();
    L6:
        if (r10 == null) goto L22;
        if (r13 == null) goto L24;
        Rect r14 = new Rect();
        r14.set(this.f3002i);
        Rect r15 = new Rect();
        r13.getDrawingRect(r15);
        WeakReference<FrameLayout> r16 = this.f3011r;
        if (r16 == null) goto L12;
        r12 = r16.get();
    L12:
        if (r12 == null) goto L14;
    L15:
        if (r12 != null) goto L17;
        r12 = (ViewGroup) r13.getParent();
    L17:
        r12.offsetDescendantRectToMyCoords(r13, r15);
    L18:
        a(r10, r15, r13);
        b.f(this.f3002i, this.f3004k, this.f3005l, this.f3008o, this.f3009p);
        this.f3000g.setCornerSize(this.f3007n);
        if (r14.equals(this.f3002i) == true) goto L23;
        this.f3000g.setBounds(this.f3002i);
        return;
    L23:
        return;
    L14:
        if (b.f3015a == false) goto L18;
    L24:
        return;
    L22:
        return;
    L5:
        r13 = null;
        goto L6
    }

    private void C() {
        this.f3006m = ((int) Math.pow(10.0d, ((double) i()) - 1.0d)) - 1;
    }

    private void a(@NonNull Context r10, @NonNull Rect r11, @NonNull View r12) {
        int r13 = m();
        int r14 = this.f3003j.f();
        if (r14 != 8388691) goto L5;
    L8:
        int r15 = r11.bottom - r13;
    L7:
        this.f3005l = r15;
        if (j() <= 9) goto L12;
        float r16 = this.f3003j.f2995d;
        this.f3007n = r16;
        this.f3009p = r16;
        float r17 = (this.f3001h.f(e()) / 2.0f) + this.f3003j.f2996e;
    L17:
        this.f3008o = r17;
        Resources r18 = r10.getResources();
        if (n() == false) goto L20;
        int r19 = d.mtrl_badge_text_horizontal_edge_offset;
    L21:
        int r20 = r18.getDimensionPixelSize(r19);
        int r21 = l();
        int r22 = this.f3003j.f();
        if (r22 == 8388659) goto L28;
        if (r22 == 8388691) goto L28;
        if (ViewCompat.getLayoutDirection(r12) == 0) goto L30;
    L29:
        float r23 = ((r11.left - this.f3008o) + r20) + r21;
    L31:
        this.f3004k = r23;
        return;
    L30:
        r23 = ((r11.right + this.f3008o) - r20) - r21;
    L28:
        if (ViewCompat.getLayoutDirection(r12) != 0) goto L30;
    L20:
        r19 = d.mtrl_badge_horizontal_edge_offset;
        goto L21
    L12:
        if (n() == true) goto L14;
        r17 = this.f3003j.f2994c;
    L15:
        this.f3007n = r17;
        this.f3009p = r17;
        goto L17
    L14:
        r17 = this.f3003j.f2995d;
        goto L15
    L5:
        if (r14 == 8388693) goto L8;
        r15 = r11.top + r13;
        goto L7
    }

    @NonNull
    public static a b(@NonNull Context r10) {
        return new a(r10, 0, f2998t, f2997s, null);
    }

    @NonNull
    static a c(@NonNull Context r10, @NonNull BadgeState.State r11) {
        return new a(r10, 0, f2998t, f2997s, r11);
    }

    private void d(Canvas r10) {
        Rect r11 = new Rect();
        String r12 = e();
        this.f3001h.e().getTextBounds(r12, 0, r12.length(), r11);
        r10.drawText(r12, this.f3004k, this.f3005l + (r11.height() / 2), this.f3001h.e());
    }

    @NonNull
    private String e() {
        if (j() <= this.f3006m) goto L5;
        Context r10 = this.f2999c.get();
        if (r10 != null) goto L11;
        return "";
    L11:
        return String.format(this.f3003j.o(), r10.getString(j.mtrl_exceed_max_badge_number_suffix), new Object[]{Integer.valueOf(this.f3006m), "+"});
    L5:
        return NumberFormat.getInstance(this.f3003j.o()).format(j());
    }

    private int l() {
        if (n() == false) goto L5;
        int r10 = this.f3003j.k();
    L7:
        return r10 + this.f3003j.b();
    L5:
        r10 = this.f3003j.l();
        goto L7
    }

    private int m() {
        if (n() == false) goto L5;
        int r10 = this.f3003j.q();
    L7:
        return r10 + this.f3003j.c();
    L5:
        r10 = this.f3003j.r();
        goto L7
    }

    private void o() {
        this.f3001h.e().setAlpha(getAlpha());
        invalidateSelf();
    }

    private void p() {
        ColorStateList r10 = ColorStateList.valueOf(this.f3003j.e());
        if (this.f3000g.getFillColor() == r10) goto L6;
        this.f3000g.setFillColor(r10);
        invalidateSelf();
        return;
    }

    private void q() {
        WeakReference<View> r10 = this.f3010q;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.get() == null) goto L13;
        View r11 = this.f3010q.get();
        WeakReference<FrameLayout> r12 = this.f3011r;
        if (r12 == null) goto L9;
        FrameLayout r13 = r12.get();
    L10:
        A(r11, r13);
        return;
    L9:
        r13 = null;
        goto L10
    }

    private void r() {
        this.f3001h.e().setColor(this.f3003j.g());
        invalidateSelf();
    }

    private void s() {
        C();
        this.f3001h.i(true);
        B();
        invalidateSelf();
    }

    private void t() {
        this.f3001h.i(true);
        B();
        invalidateSelf();
    }

    private void u() {
        boolean r10 = this.f3003j.t();
        setVisible(r10, false);
        if (b.f3015a == true) goto L5;
        return;
    L5:
        if (g() == null) goto L10;
        if (r10 == true) goto L11;
        ((ViewGroup) g().getParent()).invalidate();
        return;
    L11:
        return;
    }

    private void v() {
        s();
        t();
        o();
        p();
        r();
        q();
        B();
        u();
    }

    private void w(@Nullable TextAppearance r10) {
        if (this.f3001h.d() != r10) goto L5;
        return;
    L5:
        Context r11 = this.f2999c.get();
        if (r11 != null) goto L8;
        return;
    L8:
        this.f3001h.h(r10, r11);
        B();
    }

    private void x(@StyleRes int r10) {
        Context r11 = this.f2999c.get();
        if (r11 != null) goto L5;
        return;
    L5:
        w(new TextAppearance(r11, r10));
    }

    private void y(View r10) {
        ViewGroup r11 = (ViewGroup) r10.getParent();
        if (r11 != null) goto L5;
    L6:
        WeakReference<FrameLayout> r12 = this.f3011r;
        if (r12 != null) goto L9;
    L11:
        z(r10);
        FrameLayout r13 = new FrameLayout(r10.getContext());
        r13.setId(f.mtrl_anchor_parent);
        r13.setClipChildren(false);
        r13.setClipToPadding(false);
        r13.setLayoutParams(r10.getLayoutParams());
        r13.setMinimumWidth(r10.getWidth());
        r13.setMinimumHeight(r10.getHeight());
        int r14 = r11.indexOfChild(r10);
        r11.removeViewAt(r14);
        r10.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r13.addView(r10);
        r11.addView(r13, r14);
        this.f3011r = new WeakReference(r13);
        r13.post(new RunnableC0076a(this, r10, r13));
        return;
    L9:
        if (r12.get() != r11) goto L11;
        return;
    L5:
        if (r11.getId() != f.mtrl_anchor_parent) goto L6;
    }

    private static void z(View r10) {
        ViewGroup r11 = (ViewGroup) r10.getParent();
        r11.setClipChildren(false);
        r11.setClipToPadding(false);
    }

    public void A(@NonNull View r10, @Nullable FrameLayout r11) {
        this.f3010q = new WeakReference(r10);
        boolean r12 = b.f3015a;
        if (r12 == false) goto L6;
        if (r11 != null) goto L6;
        y(r10);
    L7:
        if (r12 == true) goto L9;
        z(r10);
    L9:
        B();
        invalidateSelf();
        return;
    L6:
        this.f3011r = new WeakReference(r11);
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r10) {
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        if (getAlpha() != 0) goto L7;
        return;
    L7:
        if (isVisible() == false) goto L16;
        this.f3000g.draw(r10);
        if (n() == false) goto L15;
        d(r10);
        return;
    L15:
        return;
    }

    @Nullable
    public CharSequence f() {
        if (isVisible() == true) goto L6;
        return null;
    L6:
        if (n() == false) goto L20;
        if (this.f3003j.j() == 0) goto L18;
        Context r10 = this.f2999c.get();
        if (r10 != null) goto L13;
        return null;
    L13:
        if (j() > this.f3006m) goto L17;
        return r10.getResources().getQuantityString(this.f3003j.j(), j(), new Object[]{Integer.valueOf(j())});
    L17:
        return r10.getString(this.f3003j.h(), new Object[]{Integer.valueOf(this.f3006m)});
    L18:
        return null;
    L20:
        return this.f3003j.i();
    }

    @Nullable
    public FrameLayout g() {
        WeakReference<FrameLayout> r10 = this.f3011r;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.get();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f3003j.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f3002i.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f3002i.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int h() {
        return this.f3003j.l();
    }

    public int i() {
        return this.f3003j.m();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public int j() {
        if (n() == true) goto L7;
        return 0;
    L7:
        return this.f3003j.n();
    }

    @NonNull
    BadgeState.State k() {
        return this.f3003j.p();
    }

    public boolean n() {
        return this.f3003j.s();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.i.b
    public boolean onStateChange(int[] r10) {
        return super.onStateChange(r10);
    }

    @Override // com.google.android.material.internal.i.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.f3003j.v(r10);
        o();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
    }
}
