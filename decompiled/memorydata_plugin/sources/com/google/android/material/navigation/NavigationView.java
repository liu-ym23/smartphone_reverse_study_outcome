package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.k;
import com.google.android.material.resources.c;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.h;
import com.google.android.material.shape.l;
import com.google.android.material.shape.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] d = null;
    private static final int[] e = null;
    private static final int f = 0;
    a c;
    private final NavigationMenu g;
    private final NavigationMenuPresenter h;
    private final int i;
    private final int[] j;
    private MenuInflater k;
    private ViewTreeObserver.OnGlobalLayoutListener l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private Path q;
    private final RectF r;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public Bundle menuState;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.menuState = r1.readBundle(r2);
        }

        public SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeBundle(this.menuState);
        }
    }

    public interface a {
        boolean a(MenuItem r1);
    }

    static {
        d = new int[]{R.attr.state_checked};
        e = new int[]{-16842910};
        f = ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.style.Widget_Design_NavigationView, "style", "Widget_Design_NavigationView");
    }

    public NavigationView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public NavigationView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.navigationViewStyle, "attr", "navigationViewStyle"));
    }

    public NavigationView(Context r17, AttributeSet r18, int r19) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r18, AttributeSet.class, "com.obric.memorydata.plugin");
        int r10 = f;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r1, r9, r19, r10), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r9, r19);
        NavigationMenuPresenter r11 = new NavigationMenuPresenter();
        this.h = r11;
        this.j = new int[2];
        this.m = true;
        this.n = true;
        this.o = 0;
        this.p = 0;
        this.r = new RectF();
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        NavigationMenu r15 = new NavigationMenu(r14);
        this.g = r15;
        TintTypedArray r2 = k.b(r14, r9, com.obric.memorydata.plugin.R.styleable.NavigationView, r19, r10, new int[0]);
        if (r2.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_android_background, "styleable", "NavigationView_android_background")) == false) goto L5;
        ViewCompat.setBackground(this, r2.getDrawable(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_android_background, "styleable", "NavigationView_android_background")));
    L5:
        this.p = r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_drawerLayoutCornerSize, "styleable", "NavigationView_drawerLayoutCornerSize"), 0);
        this.o = r2.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_android_layout_gravity, "styleable", "NavigationView_android_layout_gravity"), 0);
        if (getBackground() != null) goto L8;
    L9:
        l r3 = l.a(r14, r9, r19, r10).a();
        Drawable r4 = getBackground();
        MaterialShapeDrawable r5 = new MaterialShapeDrawable(r3);
        if (ZeusTransformUtils.instanceOf(r4, ColorDrawable.class) == false) goto L12;
        r5.setFillColor(ColorStateList.valueOf(((ColorDrawable) ZeusTransformUtils.preCheckCast(r4, ColorDrawable.class, "com.obric.memorydata.plugin")).getColor()));
    L12:
        r5.initializeElevationOverlay(r14);
        ViewCompat.setBackground(this, r5);
    L14:
        if (r2.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_elevation, "styleable", "NavigationView_elevation")) == false) goto L16;
        setElevation(r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_elevation, "styleable", "NavigationView_elevation"), 0));
    L16:
        setFitsSystemWindows(r2.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_android_fitsSystemWindows, "styleable", "NavigationView_android_fitsSystemWindows"), false));
        this.i = r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_android_maxWidth, "styleable", "NavigationView_android_maxWidth"), 0);
        if (r2.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_subheaderColor, "styleable", "NavigationView_subheaderColor")) == false) goto L19;
        ColorStateList r6 = r2.getColorStateList(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_subheaderColor, "styleable", "NavigationView_subheaderColor"));
    L21:
        if (r2.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_subheaderTextAppearance, "styleable", "NavigationView_subheaderTextAppearance")) == false) goto L23;
        int r7 = r2.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_subheaderTextAppearance, "styleable", "NavigationView_subheaderTextAppearance"), 0);
    L25:
        if (r7 != 0) goto L29;
        if (r6 != null) goto L29;
        r6 = c(R.attr.textColorSecondary);
    L29:
        if (r2.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemIconTint, "styleable", "NavigationView_itemIconTint")) == false) goto L31;
        ColorStateList r8 = r2.getColorStateList(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemIconTint, "styleable", "NavigationView_itemIconTint"));
    L33:
        if (r2.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemTextAppearance, "styleable", "NavigationView_itemTextAppearance")) == false) goto L35;
        int r12 = r2.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemTextAppearance, "styleable", "NavigationView_itemTextAppearance"), 0);
    L37:
        if (r2.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemIconSize, "styleable", "NavigationView_itemIconSize")) == false) goto L40;
        setItemIconSize(r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemIconSize, "styleable", "NavigationView_itemIconSize"), 0));
    L40:
        if (r2.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemTextColor, "styleable", "NavigationView_itemTextColor")) == false) goto L42;
        ColorStateList r13 = r2.getColorStateList(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemTextColor, "styleable", "NavigationView_itemTextColor"));
    L43:
        if (r12 != 0) goto L46;
        if (r13 != null) goto L46;
        r13 = c(R.attr.textColorPrimary);
    L46:
        Drawable r16 = r2.getDrawable(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemBackground, "styleable", "NavigationView_itemBackground"));
        if (r16 != null) goto L57;
        if (a(r2) == false) goto L57;
        Drawable r110 = b(r2);
        ColorStateList r111 = c.a(r14, r2, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemRippleColor, "styleable", "NavigationView_itemRippleColor"));
        if (Build.VERSION.SDK_INT < 21) goto L55;
        if (r111 == null) goto L55;
        r11.setItemForeground(new RippleDrawable(com.google.android.material.ripple.a.b(r111), null, a(r2, null)));
    L55:
        r16 = r110;
    L57:
        if (r2.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemHorizontalPadding, "styleable", "NavigationView_itemHorizontalPadding")) == false) goto L59;
        int r112 = 0;
        setItemHorizontalPadding(r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemHorizontalPadding, "styleable", "NavigationView_itemHorizontalPadding"), 0));
    L61:
        if (r2.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemVerticalPadding, "styleable", "NavigationView_itemVerticalPadding")) == false) goto L63;
        setItemVerticalPadding(r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemVerticalPadding, "styleable", "NavigationView_itemVerticalPadding"), r112));
    L63:
        setDividerInsetStart(r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_dividerInsetStart, "styleable", "NavigationView_dividerInsetStart"), r112));
        setDividerInsetEnd(r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_dividerInsetEnd, "styleable", "NavigationView_dividerInsetEnd"), r112));
        setSubheaderInsetStart(r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_subheaderInsetStart, "styleable", "NavigationView_subheaderInsetStart"), r112));
        setSubheaderInsetEnd(r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_subheaderInsetEnd, "styleable", "NavigationView_subheaderInsetEnd"), r112));
        setTopInsetScrimEnabled(r2.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_topInsetScrimEnabled, "styleable", "NavigationView_topInsetScrimEnabled"), this.m));
        setBottomInsetScrimEnabled(r2.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_bottomInsetScrimEnabled, "styleable", "NavigationView_bottomInsetScrimEnabled"), this.n));
        int r20 = r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemIconPadding, "styleable", "NavigationView_itemIconPadding"), 0);
        setItemMaxLines(r2.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemMaxLines, "styleable", "NavigationView_itemMaxLines"), 1));
        r15.setCallback(new AnonymousClass1(this));
        r11.setId(1);
        r11.initForMenu(r14, r15);
        if (r7 == 0) goto L66;
        r11.setSubheaderTextAppearance(r7);
    L66:
        r11.setSubheaderColor(r6);
        r11.setItemIconTintList(r8);
        r11.setOverScrollMode(getOverScrollMode());
        if (r12 == 0) goto L69;
        r11.setItemTextAppearance(r12);
    L69:
        r11.setItemTextColor(r13);
        r11.setItemBackground(r16);
        r11.setItemIconPadding(r20);
        r15.addMenuPresenter(r11);
        addView((View) ZeusTransformUtils.preCheckCast(r11.getMenuView(this), View.class, "com.obric.memorydata.plugin"));
        if (r2.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_menu, "styleable", "NavigationView_menu")) == false) goto L72;
        int r21 = 0;
        a(r2.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_menu, "styleable", "NavigationView_menu"), 0));
    L74:
        if (r2.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_headerLayout, "styleable", "NavigationView_headerLayout")) == false) goto L76;
        b(r2.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_headerLayout, "styleable", "NavigationView_headerLayout"), r21));
    L76:
        r2.recycle();
        c();
        return;
    L72:
        r21 = 0;
        goto L74
    L59:
        r112 = 0;
        goto L61
    L42:
        r13 = null;
        goto L43
    L35:
        r12 = 0;
        goto L37
    L31:
        r8 = c(R.attr.textColorSecondary);
        goto L33
    L23:
        r7 = 0;
        goto L25
    L19:
        r6 = null;
        goto L21
    L8:
        if (ZeusTransformUtils.instanceOf(getBackground(), ColorDrawable.class) == false) goto L14;
        goto L9
    }

    private Drawable a(TintTypedArray r11, ColorStateList r12) {
        int r0 = r11.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemShapeAppearance, "styleable", "NavigationView_itemShapeAppearance"), 0);
        int r3 = r11.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemShapeAppearanceOverlay, "styleable", "NavigationView_itemShapeAppearanceOverlay"), 0);
        MaterialShapeDrawable r5 = new MaterialShapeDrawable(l.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r0, r3).a());
        r5.setFillColor(r12);
        return new InsetDrawable(r5, r11.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemShapeInsetStart, "styleable", "NavigationView_itemShapeInsetStart"), 0), r11.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemShapeInsetTop, "styleable", "NavigationView_itemShapeInsetTop"), 0), r11.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemShapeInsetEnd, "styleable", "NavigationView_itemShapeInsetEnd"), 0), r11.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemShapeInsetBottom, "styleable", "NavigationView_itemShapeInsetBottom"), 0));
    }

    private void a(int r5, int r6) {
        if (ZeusTransformUtils.instanceOf(getParent(), DrawerLayout.class) == true) goto L5;
    L16:
        this.q = null;
        this.r.setEmpty();
        return;
    L5:
        if (this.p <= 0) goto L16;
        if (ZeusTransformUtils.instanceOf(getBackground(), MaterialShapeDrawable.class) == false) goto L16;
        MaterialShapeDrawable r0 = (MaterialShapeDrawable) ZeusTransformUtils.preCheckCast(getBackground(), MaterialShapeDrawable.class, "com.obric.memorydata.plugin");
        l.a r1 = r0.getShapeAppearanceModel().n();
        if (GravityCompat.getAbsoluteGravity(this.o, ViewCompat.getLayoutDirection(this)) != 3) goto L11;
        r1.c(this.p);
        r1.d(this.p);
    L12:
        r0.setShapeAppearanceModel(r1.a());
        if (this.q != null) goto L15;
        this.q = new Path();
    L15:
        this.q.reset();
        this.r.set(0.0f, 0.0f, r5, r6);
        m.a().a(r0.getShapeAppearanceModel(), r0.getInterpolation(), this.r, this.q);
        invalidate();
        return;
    L11:
        r1.b(this.p);
        r1.e(this.p);
        goto L12
    }

    private boolean a(TintTypedArray r3) {
        if (r3.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemShapeAppearance, "styleable", "NavigationView_itemShapeAppearance")) == false) goto L5;
    L8:
        return true;
    L5:
        if (r3.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemShapeAppearanceOverlay, "styleable", "NavigationView_itemShapeAppearanceOverlay")) == true) goto L8;
        return false;
    }

    static /* synthetic */ int[] a(NavigationView r0) {
        return r0.j;
    }

    private Drawable b(TintTypedArray r5) {
        return a(r5, c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.NavigationView_itemShapeFillColor, "styleable", "NavigationView_itemShapeFillColor")));
    }

    static /* synthetic */ NavigationMenuPresenter b(NavigationView r0) {
        return r0.h;
    }

    private ColorStateList c(int r10) {
        TypedValue r0 = new TypedValue();
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().resolveAttribute(r10, r0, true) == true) goto L5;
        return null;
    L5:
        ColorStateList r11 = AppCompatResources.getColorStateList((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r0.resourceId);
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().resolveAttribute(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.colorPrimary, "attr", "colorPrimary"), r0, true) == true) goto L8;
        return null;
    L8:
        int r9 = r0.data;
        int r1 = r11.getDefaultColor();
        int[] r5 = e;
        return new ColorStateList(new int[][]{r5, d, EMPTY_STATE_SET}, new int[]{r11.getColorForState(r5, r1), r9, r1});
    }

    private void c() {
        this.l = new AnonymousClass2(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.l);
    }

    private MenuInflater getMenuInflater() {
        if (this.k != null) goto L6;
        this.k = new SupportMenuInflater((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L6:
        return this.k;
    }

    public void a(int r3) {
        this.h.setUpdateSuspended(true);
        getMenuInflater().inflate(r3, this.g);
        this.h.setUpdateSuspended(false);
        this.h.updateMenuView(false);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    public void a(WindowInsetsCompat r1) {
        this.h.dispatchApplyWindowInsets(r1);
    }

    public boolean a() {
        return this.m;
    }

    public View b(int r1) {
        return this.h.inflateHeaderView(r1);
    }

    public boolean b() {
        return this.n;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r3) {
        if (this.q != null) goto L6;
        super.dispatchDraw(r3);
        return;
    L6:
        int r0 = r3.save();
        r3.clipPath(this.q);
        super.dispatchDraw(r3);
        r3.restoreToCount(r0);
    }

    public MenuItem getCheckedItem() {
        return this.h.getCheckedItem();
    }

    public int getDividerInsetEnd() {
        return this.h.getDividerInsetEnd();
    }

    public int getDividerInsetStart() {
        return this.h.getDividerInsetStart();
    }

    public int getHeaderCount() {
        return this.h.getHeaderCount();
    }

    public Drawable getItemBackground() {
        return this.h.getItemBackground();
    }

    public int getItemHorizontalPadding() {
        return this.h.getItemHorizontalPadding();
    }

    public int getItemIconPadding() {
        return this.h.getItemIconPadding();
    }

    public ColorStateList getItemIconTintList() {
        return this.h.getItemTintList();
    }

    public int getItemMaxLines() {
        return this.h.getItemMaxLines();
    }

    public ColorStateList getItemTextColor() {
        return this.h.getItemTextColor();
    }

    public int getItemVerticalPadding() {
        return this.h.getItemVerticalPadding();
    }

    public Menu getMenu() {
        return this.g;
    }

    public int getSubheaderInsetEnd() {
        return this.h.getSubheaderInsetEnd();
    }

    public int getSubheaderInsetStart() {
        return this.h.getSubheaderInsetStart();
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.a(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        getViewTreeObserver().removeGlobalOnLayoutListener(this.l);
        return;
    L5:
        getViewTreeObserver().removeOnGlobalLayoutListener(this.l);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r4);
        if (r0 == Integer.MIN_VALUE) goto L7;
        if (r0 != 0) goto L9;
        int r6 = this.i;
    L8:
        r4 = View.MeasureSpec.makeMeasureSpec(r6, 1073741824);
    L9:
        super.onMeasure(r4, r5);
        return;
    L7:
        r6 = Math.min(View.MeasureSpec.getSize(r4), this.i);
        goto L8
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.memorydata.plugin");
        super.onRestoreInstanceState(r5.getSuperState());
        this.g.restorePresenterStates(r5.menuState);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.menuState = new Bundle();
        this.g.savePresenterStates(r1.menuState);
        return r1;
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        a(r1, r2);
    }

    public void setBottomInsetScrimEnabled(boolean r1) {
        this.n = r1;
    }

    public void setCheckedItem(int r3) {
        MenuItem r4 = this.g.findItem(r3);
        if (r4 == null) goto L6;
        this.h.setCheckedItem((MenuItemImpl) ZeusTransformUtils.preCheckCast(r4, MenuItemImpl.class, "com.obric.memorydata.plugin"));
        return;
    }

    public void setCheckedItem(MenuItem r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin");
        MenuItem r5 = this.g.findItem(r4.getItemId());
        if (r5 == null) goto L7;
        this.h.setCheckedItem((MenuItemImpl) ZeusTransformUtils.preCheckCast(r5, MenuItemImpl.class, "com.obric.memorydata.plugin"));
        return;
    L7:
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public void setDividerInsetEnd(int r1) {
        this.h.setDividerInsetEnd(r1);
    }

    public void setDividerInsetStart(int r1) {
        this.h.setDividerInsetStart(r1);
    }

    @Override // android.view.View
    public void setElevation(float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        super.setElevation(r3);
    L5:
        h.a(this, r3);
    }

    public void setItemBackground(Drawable r1) {
        this.h.setItemBackground(r1);
    }

    public void setItemBackgroundResource(int r4) {
        setItemBackground(ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    public void setItemHorizontalPadding(int r1) {
        this.h.setItemHorizontalPadding(r1);
    }

    public void setItemHorizontalPaddingResource(int r3) {
        this.h.setItemHorizontalPadding(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(r3));
    }

    public void setItemIconPadding(int r1) {
        this.h.setItemIconPadding(r1);
    }

    public void setItemIconPaddingResource(int r3) {
        this.h.setItemIconPadding(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(r3));
    }

    public void setItemIconSize(int r1) {
        this.h.setItemIconSize(r1);
    }

    public void setItemIconTintList(ColorStateList r1) {
        this.h.setItemIconTintList(r1);
    }

    public void setItemMaxLines(int r1) {
        this.h.setItemMaxLines(r1);
    }

    public void setItemTextAppearance(int r1) {
        this.h.setItemTextAppearance(r1);
    }

    public void setItemTextColor(ColorStateList r1) {
        this.h.setItemTextColor(r1);
    }

    public void setItemVerticalPadding(int r1) {
        this.h.setItemVerticalPadding(r1);
    }

    public void setItemVerticalPaddingResource(int r3) {
        this.h.setItemVerticalPadding(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(r3));
    }

    public void setNavigationItemSelectedListener(a r3) {
        this.c = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.View
    public void setOverScrollMode(int r1) {
        super.setOverScrollMode(r1);
        NavigationMenuPresenter r0 = this.h;
        if (r0 == null) goto L6;
        r0.setOverScrollMode(r1);
        return;
    }

    public void setSubheaderInsetEnd(int r1) {
        this.h.setSubheaderInsetStart(r1);
    }

    public void setSubheaderInsetStart(int r1) {
        this.h.setSubheaderInsetStart(r1);
    }

    public void setTopInsetScrimEnabled(boolean r1) {
        this.m = r1;
    }
}
