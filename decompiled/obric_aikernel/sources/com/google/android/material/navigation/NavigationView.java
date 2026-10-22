package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
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
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
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
import com.google.android.material.internal.c;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.h;
import com.google.android.material.shape.m;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int[] f3472x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int[] f3473y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f3474z = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    private final NavigationMenu f3475k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final NavigationMenuPresenter f3476l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    b f3477m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f3478n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int[] f3479o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private MenuInflater f3480p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f3481q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f3482r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f3483s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f3484t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Px
    private int f3485u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private Path f3486v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final RectF f3487w;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        @Nullable
        public Bundle menuState;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Nullable
            public SavedState a(@NonNull Parcel r10) {
                return new SavedState(r10, null);
            }

            @NonNull
            public SavedState b(@NonNull Parcel r10, ClassLoader r11) {
                return new SavedState(r10, r11);
            }

            @NonNull
            public SavedState[] c(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public /* bridge */ /* synthetic */ Object createFromParcel(@NonNull Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public /* bridge */ /* synthetic */ SavedState createFromParcel(@NonNull Parcel r10, ClassLoader r11) {
                return b(r10, r11);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return c(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(@NonNull Parcel r10, @Nullable ClassLoader r11) {
            super(r10, r11);
            this.menuState = r10.readBundle(r11);
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeBundle(this.menuState);
        }
    }

    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ NavigationView f3488c;

        a(NavigationView r10) {
            this.f3488c = r10;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NavigationView r10 = this.f3488c;
            r10.getLocationOnScreen(NavigationView.b(r10));
            boolean r11 = true;
            if (NavigationView.b(this.f3488c)[1] != 0) goto L5;
            boolean r12 = true;
        L6:
            NavigationView.c(this.f3488c).setBehindStatusBar(r12);
            NavigationView r13 = this.f3488c;
            if (r12 == true) goto L9;
        L11:
            boolean r14 = false;
        L12:
            r13.setDrawTopInsetForeground(r14);
            Activity r15 = c.a(this.f3488c.getContext());
            if (r15 != null) goto L15;
            return;
        L15:
            if (Build.VERSION.SDK_INT >= 21) goto L17;
            return;
        L17:
            if (r15.findViewById(R.id.content).getHeight() != this.f3488c.getHeight()) goto L19;
            boolean r16 = true;
        L21:
            if (Color.alpha(r15.getWindow().getNavigationBarColor()) == 0) goto L23;
            boolean r17 = true;
        L24:
            NavigationView r18 = this.f3488c;
            if (r16 == false) goto L30;
            if (r17 == false) goto L30;
            if (r18.j() == false) goto L30;
        L31:
            r18.setDrawBottomInsetForeground(r11);
            return;
        L30:
            r11 = false;
            goto L31
        L23:
            r17 = false;
            goto L24
        L19:
            r16 = false;
            goto L21
        L9:
            if (r13.k() == false) goto L11;
            r14 = true;
            goto L12
        L5:
            r12 = false;
            goto L6
        }
    }

    public interface b {
        boolean a(@NonNull MenuItem r10);
    }

    static {
        f3472x = new int[]{R.attr.state_checked};
        f3473y = new int[]{-16842910};
        f3474z = k.Widget_Design_NavigationView;
    }

    public NavigationView(@NonNull Context r10) {
        this(r10, null);
    }

    public NavigationView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.navigationViewStyle);
    }

    public NavigationView(@NonNull Context r17, @Nullable AttributeSet r18, int r19) {
        int r10 = f3474z;
        super(b6.a.c(r17, r18, r19, r10), r18, r19);
        NavigationMenuPresenter r11 = new NavigationMenuPresenter();
        this.f3476l = r11;
        this.f3479o = new int[2];
        this.f3482r = true;
        this.f3483s = true;
        this.f3484t = 0;
        this.f3485u = 0;
        this.f3487w = new RectF();
        Context r13 = getContext();
        NavigationMenu r14 = new NavigationMenu(r13);
        this.f3475k = r14;
        TintTypedArray r12 = com.google.android.material.internal.k.i(r13, r18, l.NavigationView, r19, r10, new int[0]);
        int r15 = l.NavigationView_android_background;
        if (r12.hasValue(r15) == false) goto L5;
        ViewCompat.setBackground(this, r12.getDrawable(r15));
    L5:
        this.f3485u = r12.getDimensionPixelSize(l.NavigationView_drawerLayoutCornerSize, 0);
        this.f3484t = r12.getInt(l.NavigationView_android_layout_gravity, 0);
        if (getBackground() != null) goto L8;
    L9:
        com.google.android.material.shape.l r16 = com.google.android.material.shape.l.e(r13, r18, r19, r10).m();
        Drawable r20 = getBackground();
        MaterialShapeDrawable r21 = new MaterialShapeDrawable(r16);
        if ((r20 instanceof ColorDrawable) == false) goto L12;
        r21.setFillColor(ColorStateList.valueOf(((ColorDrawable) r20).getColor()));
    L12:
        r21.initializeElevationOverlay(r13);
        ViewCompat.setBackground(this, r21);
    L13:
        int r22 = l.NavigationView_elevation;
        if (r12.hasValue(r22) == false) goto L16;
        setElevation(r12.getDimensionPixelSize(r22, 0));
    L16:
        setFitsSystemWindows(r12.getBoolean(l.NavigationView_android_fitsSystemWindows, false));
        this.f3478n = r12.getDimensionPixelSize(l.NavigationView_android_maxWidth, 0);
        int r23 = l.NavigationView_subheaderColor;
        if (r12.hasValue(r23) == false) goto L19;
        ColorStateList r24 = r12.getColorStateList(r23);
    L20:
        int r25 = l.NavigationView_subheaderTextAppearance;
        if (r12.hasValue(r25) == false) goto L23;
        int r26 = r12.getResourceId(r25, 0);
    L25:
        if (r26 != 0) goto L28;
        if (r24 != null) goto L28;
        r24 = d(R.attr.textColorSecondary);
    L28:
        int r27 = l.NavigationView_itemIconTint;
        if (r12.hasValue(r27) == false) goto L31;
        ColorStateList r28 = r12.getColorStateList(r27);
    L32:
        int r29 = l.NavigationView_itemTextAppearance;
        if (r12.hasValue(r29) == false) goto L35;
        int r30 = r12.getResourceId(r29, 0);
    L36:
        int r31 = l.NavigationView_itemIconSize;
        if (r12.hasValue(r31) == false) goto L39;
        setItemIconSize(r12.getDimensionPixelSize(r31, 0));
    L39:
        int r32 = l.NavigationView_itemTextColor;
        if (r12.hasValue(r32) == false) goto L42;
        ColorStateList r33 = r12.getColorStateList(r32);
    L43:
        if (r30 != 0) goto L46;
        if (r33 != null) goto L46;
        r33 = d(R.attr.textColorPrimary);
    L46:
        Drawable r34 = r12.getDrawable(l.NavigationView_itemBackground);
        if (r34 == null) goto L49;
    L54:
        int r35 = l.NavigationView_itemHorizontalPadding;
        if (r12.hasValue(r35) == false) goto L57;
        setItemHorizontalPadding(r12.getDimensionPixelSize(r35, 0));
    L57:
        int r36 = l.NavigationView_itemVerticalPadding;
        if (r12.hasValue(r36) == false) goto L60;
        setItemVerticalPadding(r12.getDimensionPixelSize(r36, 0));
    L60:
        setDividerInsetStart(r12.getDimensionPixelSize(l.NavigationView_dividerInsetStart, 0));
        setDividerInsetEnd(r12.getDimensionPixelSize(l.NavigationView_dividerInsetEnd, 0));
        setSubheaderInsetStart(r12.getDimensionPixelSize(l.NavigationView_subheaderInsetStart, 0));
        setSubheaderInsetEnd(r12.getDimensionPixelSize(l.NavigationView_subheaderInsetEnd, 0));
        setTopInsetScrimEnabled(r12.getBoolean(l.NavigationView_topInsetScrimEnabled, this.f3482r));
        setBottomInsetScrimEnabled(r12.getBoolean(l.NavigationView_bottomInsetScrimEnabled, this.f3483s));
        int r37 = r12.getDimensionPixelSize(l.NavigationView_itemIconPadding, 0);
        setItemMaxLines(r12.getInt(l.NavigationView_itemMaxLines, 1));
        r14.setCallback(new AnonymousClass1(this));
        r11.setId(1);
        r11.initForMenu(r13, r14);
        if (r26 == 0) goto L63;
        r11.setSubheaderTextAppearance(r26);
    L63:
        r11.setSubheaderColor(r24);
        r11.setItemIconTintList(r28);
        r11.setOverScrollMode(getOverScrollMode());
        if (r30 == 0) goto L66;
        r11.setItemTextAppearance(r30);
    L66:
        r11.setItemTextColor(r33);
        r11.setItemBackground(r34);
        r11.setItemIconPadding(r37);
        r14.addMenuPresenter(r11);
        addView((View) r11.getMenuView(this));
        int r38 = l.NavigationView_menu;
        if (r12.hasValue(r38) == false) goto L69;
        i(r12.getResourceId(r38, 0));
    L69:
        int r39 = l.NavigationView_headerLayout;
        if (r12.hasValue(r39) == false) goto L72;
        h(r12.getResourceId(r39, 0));
    L72:
        r12.recycle();
        m();
        return;
    L49:
        if (g(r12) == false) goto L54;
        r34 = e(r12);
        ColorStateList r40 = com.google.android.material.resources.c.b(r13, r12, l.NavigationView_itemRippleColor);
        if (Build.VERSION.SDK_INT < 21) goto L54;
        if (r40 == null) goto L54;
        r11.setItemForeground(new RippleDrawable(com.google.android.material.ripple.a.d(r40), null, f(r12, null)));
        goto L54
    L42:
        r33 = null;
        goto L43
    L35:
        r30 = 0;
        goto L36
    L31:
        r28 = d(R.attr.textColorSecondary);
        goto L32
    L23:
        r26 = 0;
        goto L25
    L19:
        r24 = null;
        goto L20
    L8:
        if ((getBackground() instanceof ColorDrawable) == false) goto L13;
        goto L9
    }

    static /* synthetic */ int[] b(NavigationView r10) {
        return r10.f3479o;
    }

    static /* synthetic */ NavigationMenuPresenter c(NavigationView r10) {
        return r10.f3476l;
    }

    @Nullable
    private ColorStateList d(int r10) {
        TypedValue r11 = new TypedValue();
        if (getContext().getTheme().resolveAttribute(r10, r11, true) == true) goto L5;
        return null;
    L5:
        ColorStateList r12 = AppCompatResources.getColorStateList(getContext(), r11.resourceId);
        if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, r11, true) == true) goto L8;
        return null;
    L8:
        int r13 = r11.data;
        int r14 = r12.getDefaultColor();
        int[] r15 = f3473y;
        return new ColorStateList(new int[][]{r15, f3472x, FrameLayout.EMPTY_STATE_SET}, new int[]{r12.getColorForState(r15, r14), r13, r14});
    }

    @NonNull
    private Drawable e(@NonNull TintTypedArray r10) {
        return f(r10, com.google.android.material.resources.c.b(getContext(), r10, l.NavigationView_itemShapeFillColor));
    }

    @NonNull
    private Drawable f(@NonNull TintTypedArray r10, @Nullable ColorStateList r11) {
        int r12 = r10.getResourceId(l.NavigationView_itemShapeAppearance, 0);
        int r13 = r10.getResourceId(l.NavigationView_itemShapeAppearanceOverlay, 0);
        MaterialShapeDrawable r14 = new MaterialShapeDrawable(com.google.android.material.shape.l.b(getContext(), r12, r13).m());
        r14.setFillColor(r11);
        return new InsetDrawable(r14, r10.getDimensionPixelSize(l.NavigationView_itemShapeInsetStart, 0), r10.getDimensionPixelSize(l.NavigationView_itemShapeInsetTop, 0), r10.getDimensionPixelSize(l.NavigationView_itemShapeInsetEnd, 0), r10.getDimensionPixelSize(l.NavigationView_itemShapeInsetBottom, 0));
    }

    private boolean g(@NonNull TintTypedArray r10) {
        if (r10.hasValue(l.NavigationView_itemShapeAppearance) == false) goto L5;
    L8:
        return true;
    L5:
        if (r10.hasValue(l.NavigationView_itemShapeAppearanceOverlay) == true) goto L8;
        return false;
    }

    private MenuInflater getMenuInflater() {
        if (this.f3480p != null) goto L6;
        this.f3480p = new SupportMenuInflater(getContext());
    L6:
        return this.f3480p;
    }

    private void l(@Px int r10, @Px int r11) {
        if ((getParent() instanceof DrawerLayout) == true) goto L5;
    L16:
        this.f3486v = null;
        this.f3487w.setEmpty();
        return;
    L5:
        if (this.f3485u <= 0) goto L16;
        if ((getBackground() instanceof MaterialShapeDrawable) == false) goto L16;
        MaterialShapeDrawable r12 = (MaterialShapeDrawable) getBackground();
        com.google.android.material.shape.l.b r13 = r12.getShapeAppearanceModel().v();
        if (GravityCompat.getAbsoluteGravity(this.f3484t, ViewCompat.getLayoutDirection(this)) != 3) goto L11;
        r13.I(this.f3485u);
        r13.z(this.f3485u);
    L12:
        r12.setShapeAppearanceModel(r13.m());
        if (this.f3486v != null) goto L15;
        this.f3486v = new Path();
    L15:
        this.f3486v.reset();
        this.f3487w.set(0.0f, 0.0f, r10, r11);
        m.k().d(r12.getShapeAppearanceModel(), r12.getInterpolation(), this.f3487w, this.f3486v);
        invalidate();
        return;
    L11:
        r13.E(this.f3485u);
        r13.v(this.f3485u);
        goto L12
    }

    private void m() {
        this.f3481q = new a(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.f3481q);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void a(@NonNull WindowInsetsCompat r10) {
        this.f3476l.dispatchApplyWindowInsets(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NonNull Canvas r10) {
        if (this.f3486v != null) goto L6;
        super.dispatchDraw(r10);
        return;
    L6:
        int r11 = r10.save();
        r10.clipPath(this.f3486v);
        super.dispatchDraw(r10);
        r10.restoreToCount(r11);
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.f3476l.getCheckedItem();
    }

    @Px
    public int getDividerInsetEnd() {
        return this.f3476l.getDividerInsetEnd();
    }

    @Px
    public int getDividerInsetStart() {
        return this.f3476l.getDividerInsetStart();
    }

    public int getHeaderCount() {
        return this.f3476l.getHeaderCount();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f3476l.getItemBackground();
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.f3476l.getItemHorizontalPadding();
    }

    @Dimension
    public int getItemIconPadding() {
        return this.f3476l.getItemIconPadding();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f3476l.getItemTintList();
    }

    public int getItemMaxLines() {
        return this.f3476l.getItemMaxLines();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f3476l.getItemTextColor();
    }

    @Px
    public int getItemVerticalPadding() {
        return this.f3476l.getItemVerticalPadding();
    }

    @NonNull
    public Menu getMenu() {
        return this.f3475k;
    }

    @Px
    public int getSubheaderInsetEnd() {
        return this.f3476l.getSubheaderInsetEnd();
    }

    @Px
    public int getSubheaderInsetStart() {
        return this.f3476l.getSubheaderInsetStart();
    }

    public View h(@LayoutRes int r10) {
        return this.f3476l.inflateHeaderView(r10);
    }

    public void i(int r10) {
        this.f3476l.setUpdateSuspended(true);
        getMenuInflater().inflate(r10, this.f3475k);
        this.f3476l.setUpdateSuspended(false);
        this.f3476l.updateMenuView(false);
    }

    public boolean j() {
        return this.f3483s;
    }

    public boolean k() {
        return this.f3482r;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        getViewTreeObserver().removeGlobalOnLayoutListener(this.f3481q);
        return;
    L5:
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f3481q);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r10);
        if (r12 == Integer.MIN_VALUE) goto L7;
        if (r12 != 0) goto L9;
        int r13 = this.f3478n;
    L8:
        r10 = View.MeasureSpec.makeMeasureSpec(r13, 1073741824);
    L9:
        super.onMeasure(r10, r11);
        return;
    L7:
        r13 = Math.min(View.MeasureSpec.getSize(r10), this.f3478n);
        goto L8
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        this.f3475k.restorePresenterStates(r11.menuState);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        Bundle r11 = new Bundle();
        r10.menuState = r11;
        this.f3475k.savePresenterStates(r11);
        return r10;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        l(r10, r11);
    }

    public void setBottomInsetScrimEnabled(boolean r10) {
        this.f3483s = r10;
    }

    public void setCheckedItem(@IdRes int r10) {
        MenuItem r11 = this.f3475k.findItem(r10);
        if (r11 == null) goto L6;
        this.f3476l.setCheckedItem((MenuItemImpl) r11);
        return;
    }

    public void setCheckedItem(@NonNull MenuItem r10) {
        MenuItem r11 = this.f3475k.findItem(r10.getItemId());
        if (r11 == null) goto L7;
        this.f3476l.setCheckedItem((MenuItemImpl) r11);
        return;
    L7:
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public void setDividerInsetEnd(@Px int r10) {
        this.f3476l.setDividerInsetEnd(r10);
    }

    public void setDividerInsetStart(@Px int r10) {
        this.f3476l.setDividerInsetStart(r10);
    }

    @Override // android.view.View
    public void setElevation(float r10) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        super.setElevation(r10);
    L5:
        h.d(this, r10);
    }

    public void setItemBackground(@Nullable Drawable r10) {
        this.f3476l.setItemBackground(r10);
    }

    public void setItemBackgroundResource(@DrawableRes int r10) {
        setItemBackground(ContextCompat.getDrawable(getContext(), r10));
    }

    public void setItemHorizontalPadding(@Dimension int r10) {
        this.f3476l.setItemHorizontalPadding(r10);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int r10) {
        this.f3476l.setItemHorizontalPadding(getResources().getDimensionPixelSize(r10));
    }

    public void setItemIconPadding(@Dimension int r10) {
        this.f3476l.setItemIconPadding(r10);
    }

    public void setItemIconPaddingResource(int r10) {
        this.f3476l.setItemIconPadding(getResources().getDimensionPixelSize(r10));
    }

    public void setItemIconSize(@Dimension int r10) {
        this.f3476l.setItemIconSize(r10);
    }

    public void setItemIconTintList(@Nullable ColorStateList r10) {
        this.f3476l.setItemIconTintList(r10);
    }

    public void setItemMaxLines(int r10) {
        this.f3476l.setItemMaxLines(r10);
    }

    public void setItemTextAppearance(@StyleRes int r10) {
        this.f3476l.setItemTextAppearance(r10);
    }

    public void setItemTextColor(@Nullable ColorStateList r10) {
        this.f3476l.setItemTextColor(r10);
    }

    public void setItemVerticalPadding(@Px int r10) {
        this.f3476l.setItemVerticalPadding(r10);
    }

    public void setItemVerticalPaddingResource(@DimenRes int r10) {
        this.f3476l.setItemVerticalPadding(getResources().getDimensionPixelSize(r10));
    }

    public void setNavigationItemSelectedListener(@Nullable b r10) {
        this.f3477m = r10;
    }

    @Override // android.view.View
    public void setOverScrollMode(int r10) {
        super.setOverScrollMode(r10);
        NavigationMenuPresenter r11 = this.f3476l;
        if (r11 == null) goto L6;
        r11.setOverScrollMode(r10);
        return;
    }

    public void setSubheaderInsetEnd(@Px int r10) {
        this.f3476l.setSubheaderInsetStart(r10);
    }

    public void setSubheaderInsetStart(@Px int r10) {
        this.f3476l.setSubheaderInsetStart(r10);
    }

    public void setTopInsetScrimEnabled(boolean r10) {
        this.f3482r = r10;
    }
}
