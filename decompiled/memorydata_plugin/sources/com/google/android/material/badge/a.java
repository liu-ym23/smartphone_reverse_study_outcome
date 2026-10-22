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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.internal.i;
import com.google.android.material.internal.k;
import com.google.android.material.resources.d;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Drawable implements i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f3777a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f3778b = 0;
    private final WeakReference<Context> c;
    private final MaterialShapeDrawable d;
    private final i e;
    private final Rect f;
    private final BadgeState g;
    private float h;
    private float i;
    private int j;
    private float k;
    private float l;
    private float m;
    private WeakReference<View> n;
    private WeakReference<FrameLayout> o;

    static {
        f3777a = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_Badge, "style", "Widget_MaterialComponents_Badge");
        f3778b = ZeusTransformUtils.mapRes(R.attr.badgeStyle, "attr", "badgeStyle");
    }

    private a(Context r7, int r8, int r9, int r10, BadgeState.State r11) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        this.c = new WeakReference(r1);
        k.b(r1);
        this.f = new Rect();
        this.d = new MaterialShapeDrawable();
        i r12 = new i(this);
        this.e = r12;
        r12.a().setTextAlign(Paint.Align.CENTER);
        a(ZeusTransformUtils.mapRes(R.style.TextAppearance_MaterialComponents_Badge, "style", "TextAppearance_MaterialComponents_Badge"));
        this.g = new BadgeState(r1, r8, r9, r10, r11);
        i();
    }

    public static a a(Context r6) {
        return new a((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"), 0, f3778b, f3777a, null);
    }

    static a a(Context r6, BadgeState.State r7) {
        return new a((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"), 0, f3778b, f3777a, r7);
    }

    private void a(int r4) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(this.c.get(), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        a(new d(r0, r4));
    }

    private void a(Context r6, Rect r7, View r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        int r0 = q();
        int r2 = this.g.i();
        if (r2 != 8388691) goto L5;
    L8:
        int r3 = r7.bottom - r0;
    L7:
        this.i = r3;
        if (d() <= 9) goto L12;
        float r1 = this.g.f3776b;
        this.k = r1;
        this.m = r1;
        float r4 = (this.e.a(s()) / 2.0f) + this.g.c;
    L17:
        this.l = r4;
        Resources r10 = ZeusTransformUtils.getResources(r9, "com.obric.memorydata.plugin");
        if (c() == false) goto L20;
        int r5 = R.dimen.mtrl_badge_text_horizontal_edge_offset;
        String r11 = "mtrl_badge_text_horizontal_edge_offset";
    L21:
        int r12 = r10.getDimensionPixelSize(ZeusTransformUtils.mapRes(r5, "dimen", r11));
        int r13 = r();
        int r14 = this.g.i();
        if (r14 == 8388659) goto L28;
        if (r14 == 8388691) goto L28;
        if (ViewCompat.getLayoutDirection(r8) == 0) goto L30;
    L29:
        float r15 = ((r7.left - this.l) + r12) + r13;
    L31:
        this.h = r15;
        return;
    L30:
        r15 = ((r7.right + this.l) - r12) - r13;
    L28:
        if (ViewCompat.getLayoutDirection(r8) != 0) goto L30;
    L20:
        r5 = R.dimen.mtrl_badge_horizontal_edge_offset;
        r11 = "mtrl_badge_horizontal_edge_offset";
        goto L21
    L12:
        if (c() == true) goto L14;
        r4 = this.g.f3775a;
    L15:
        this.k = r4;
        this.m = r4;
        goto L17
    L14:
        r4 = this.g.f3776b;
        goto L15
    L5:
        if (r2 == 8388693) goto L8;
        r3 = r7.top + r0;
        goto L7
    }

    private void a(Canvas r6) {
        Rect r0 = new Rect();
        String r1 = s();
        this.e.a().getTextBounds(r1, 0, r1.length(), r0);
        r6.drawText(r1, this.h, this.i + (r0.height() / 2), this.e.a());
    }

    private void a(final View r8) {
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r8.getParent(), ViewGroup.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L6:
        WeakReference<FrameLayout> r4 = this.o;
        if (r4 != null) goto L9;
    L11:
        b(r8);
        final FrameLayout r5 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r5.setId(ZeusTransformUtils.mapRes(R.id.mtrl_anchor_parent, OaidModel.KEY_ID, "mtrl_anchor_parent"));
        r5.setClipChildren(false);
        r5.setClipToPadding(false);
        r5.setLayoutParams(r8.getLayoutParams());
        r5.setMinimumWidth(r8.getWidth());
        r5.setMinimumHeight(r8.getHeight());
        int r1 = r0.indexOfChild(r8);
        r0.removeViewAt(r1);
        r8.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r5.addView(r8);
        r0.addView(r5, r1);
        this.o = new WeakReference(r5);
        r5.post(new AnonymousClass1(this, r8, r5));
        return;
    L9:
        if (r4.get() != r0) goto L11;
        return;
    L5:
        if (r0.getId() != ZeusTransformUtils.mapRes(R.id.mtrl_anchor_parent, OaidModel.KEY_ID, "mtrl_anchor_parent")) goto L6;
    }

    private void a(d r4) {
        if (this.e.b() != r4) goto L5;
        return;
    L5:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(this.c.get(), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        return;
    L8:
        this.e.a(r4, r0);
        p();
    }

    private static void b(View r2) {
        ViewGroup r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(r2.getParent(), ViewGroup.class, "com.obric.memorydata.plugin");
        r3.setClipChildren(false);
        r3.setClipToPadding(false);
    }

    private void h() {
        boolean r0 = this.g.b();
        setVisible(r0, false);
        if (b.f3781a == true) goto L5;
        return;
    L5:
        if (b() == null) goto L10;
        if (r0 == true) goto L11;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(b().getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).invalidate();
        return;
    L11:
        return;
    }

    private void i() {
        m();
        l();
        o();
        j();
        k();
        n();
        p();
        h();
    }

    private void j() {
        ColorStateList r0 = ColorStateList.valueOf(this.g.g());
        if (this.d.getFillColor() == r0) goto L6;
        this.d.setFillColor(r0);
        invalidateSelf();
        return;
    }

    private void k() {
        this.e.a().setColor(this.g.h());
        invalidateSelf();
    }

    private void l() {
        this.e.a(true);
        p();
        invalidateSelf();
    }

    private void m() {
        t();
        this.e.a(true);
        p();
        invalidateSelf();
    }

    private void n() {
        WeakReference<View> r0 = this.n;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.get() == null) goto L13;
        View r1 = (View) ZeusTransformUtils.preCheckCast(this.n.get(), View.class, "com.obric.memorydata.plugin");
        WeakReference<FrameLayout> r2 = this.o;
        if (r2 == null) goto L9;
        FrameLayout r3 = (FrameLayout) ZeusTransformUtils.preCheckCast(r2.get(), FrameLayout.class, "com.obric.memorydata.plugin");
    L10:
        a(r1, r3);
        return;
    L9:
        r3 = null;
        goto L10
    }

    private void o() {
        this.e.a().setAlpha(getAlpha());
        invalidateSelf();
    }

    private void p() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(this.c.get(), Context.class, "com.obric.memorydata.plugin");
        WeakReference<View> r1 = this.n;
        ViewGroup r3 = null;
        if (r1 == null) goto L5;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1.get(), View.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L22;
        if (r2 == null) goto L24;
        Rect r4 = new Rect();
        r4.set(this.f);
        Rect r5 = new Rect();
        r2.getDrawingRect(r5);
        WeakReference<FrameLayout> r6 = this.o;
        if (r6 == null) goto L12;
        r3 = (FrameLayout) ZeusTransformUtils.preCheckCast(r6.get(), FrameLayout.class, "com.obric.memorydata.plugin");
    L12:
        if (r3 == null) goto L14;
    L15:
        if (r3 != null) goto L17;
        r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(r2.getParent(), ViewGroup.class, "com.obric.memorydata.plugin");
    L17:
        r3.offsetDescendantRectToMyCoords(r2, r5);
    L18:
        a(r0, r5, r2);
        b.a(this.f, this.h, this.i, this.l, this.m);
        this.d.setCornerSize(this.k);
        if (r4.equals(this.f) == true) goto L23;
        this.d.setBounds(this.f);
        return;
    L23:
        return;
    L14:
        if (b.f3781a == false) goto L18;
    L24:
        return;
    L22:
        return;
    L5:
        r2 = null;
        goto L6
    }

    private int q() {
        if (c() == false) goto L5;
        int r0 = this.g.m();
    L7:
        return r0 + this.g.o();
    L5:
        r0 = this.g.k();
        goto L7
    }

    private int r() {
        if (c() == false) goto L5;
        int r0 = this.g.l();
    L7:
        return r0 + this.g.n();
    L5:
        r0 = this.g.j();
        goto L7
    }

    private String s() {
        if (d() <= this.j) goto L5;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(this.c.get(), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L11;
        return "";
    L11:
        return String.format(this.g.s(), r0.getString(ZeusTransformUtils.mapRes(R.string.mtrl_exceed_max_badge_number_suffix, TypedValues.Custom.S_STRING, "mtrl_exceed_max_badge_number_suffix")), new Object[]{Integer.valueOf(this.j), Marker.ANY_NON_NULL_MARKER});
    L5:
        return NumberFormat.getInstance(this.g.s()).format(d());
    }

    private void t() {
        this.j = ((int) Math.pow(10.0d, ((double) e()) - 1.0d)) - 1;
    }

    BadgeState.State a() {
        return this.g.a();
    }

    public void a(View r2, FrameLayout r3) {
        this.n = new WeakReference(r2);
        if (b.f3781a == false) goto L6;
        if (r3 != null) goto L6;
        a(r2);
    L8:
        if (b.f3781a == true) goto L10;
        b(r2);
    L10:
        p();
        invalidateSelf();
        return;
    L6:
        this.o = new WeakReference(r3);
        goto L8
    }

    public FrameLayout b() {
        WeakReference<FrameLayout> r2 = this.o;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (FrameLayout) ZeusTransformUtils.preCheckCast(r2.get(), FrameLayout.class, "com.obric.memorydata.plugin");
    }

    public boolean c() {
        return this.g.c();
    }

    public int d() {
        if (c() == true) goto L7;
        return 0;
    L7:
        return this.g.d();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        if (getAlpha() != 0) goto L7;
        return;
    L7:
        if (isVisible() == false) goto L16;
        this.d.draw(r2);
        if (c() == false) goto L15;
        a(r2);
        return;
    L15:
        return;
    }

    public int e() {
        return this.g.f();
    }

    public CharSequence f() {
        if (isVisible() == true) goto L6;
        return null;
    L6:
        if (c() == false) goto L20;
        if (this.g.q() == 0) goto L18;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(this.c.get(), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L13;
        return null;
    L13:
        if (d() > this.j) goto L17;
        return ZeusTransformUtils.getResources(r0, "com.obric.memorydata.plugin").getQuantityString(this.g.q(), d(), new Object[]{Integer.valueOf(d())});
    L17:
        return r0.getString(this.g.r(), new Object[]{Integer.valueOf(this.j)});
    L18:
        return null;
    L20:
        return this.g.p();
    }

    public int g() {
        return this.g.j();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.g.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.i.a
    public boolean onStateChange(int[] r1) {
        return super.onStateChange(r1);
    }

    @Override // com.google.android.material.internal.i.a
    public void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.g.a(r2);
        o();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }
}
