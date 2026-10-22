package com.google.android.material.search;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import cn.nubia.neopush.commons.Constant;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class SearchBar extends Toolbar {
    private static final int DEFAULT_SCROLL_FLAGS = 53;
    private static final int DEF_STYLE_RES = 0;
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";

    @Nullable
    private final AccessibilityManager accessibilityManager;
    private MaterialShapeDrawable backgroundShape;

    @Nullable
    private View centerView;
    private final boolean defaultMarginsEnabled;
    private final Drawable defaultNavigationIcon;
    private boolean defaultScrollFlagsEnabled;
    private final boolean forceDefaultNavigationOnClickListener;
    private final boolean layoutInflated;
    private int menuResId;

    @Nullable
    private Integer navigationIconTint;

    @Nullable
    private Drawable originalNavigationIconBackground;
    private final SearchBarAnimationHelper searchBarAnimationHelper;
    private final TextView textView;
    private final boolean tintNavigationIcon;
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    public static abstract class OnLoadAnimationCallback {
        public OnLoadAnimationCallback() {
        }

        public void onAnimationEnd() {
        }

        public void onAnimationStart() {
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        String text;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r5) {
            this(r5, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeString(this.text);
        }

        public SavedState(Parcel r5, @Nullable ClassLoader r10) {
            super(r5, r10);
            this.text = r5.readString();
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }
    }

    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        private boolean initialized;

        public ScrollingViewBehavior() {
            this.initialized = false;
        }

        private void setAppBarLayoutTransparent(AppBarLayout r5) {
            r5.setBackgroundColor(0);
            r5.setTargetElevation(0.0f);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout r5, @NonNull View r10, @NonNull View r11) {
            boolean r12 = super.onDependentViewChanged(r5, r10, r11);
            if (this.initialized == false) goto L5;
        L7:
            return r12;
        L5:
            if ((r11 instanceof AppBarLayout) == false) goto L7;
            this.initialized = true;
            setAppBarLayoutTransparent((AppBarLayout) r11);
            goto L7
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public boolean shouldHeaderOverlapScrollingChild() {
            return true;
        }

        public ScrollingViewBehavior(@NonNull Context r5, @Nullable AttributeSet r10) {
            super(r5, r10);
            this.initialized = false;
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Material3_SearchBar;
    }

    public SearchBar(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ void a(SearchBar r5, boolean r10) {
        r5.lambda$new$0(r10);
    }

    public static /* synthetic */ AccessibilityManager access$000(SearchBar r5) {
        return r5.accessibilityManager;
    }

    public static /* synthetic */ AccessibilityManagerCompat.TouchExplorationStateChangeListener access$100(SearchBar r5) {
        return r5.touchExplorationStateChangeListener;
    }

    public static /* synthetic */ void b(SearchBar r5) {
        r5.lambda$startOnLoadAnimation$1();
    }

    private int defaultIfZero(int r5, int r10) {
        if (r5 == 0) goto L4;
        return r5;
    L4:
        return r10;
    }

    private ColorStateList getCompatBackgroundColorStateList(@ColorInt int r5, @ColorInt int r10) {
        int[][] r11 = {new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_focused}, new int[0]};
        int r12 = MaterialColors.layer(r5, r10);
        return new ColorStateList(r11, new int[]{r12, r12, r5});
    }

    private void initBackground(ShapeAppearanceModel r5, @ColorInt int r10, float r11, float r12, @ColorInt int r13) {
        MaterialShapeDrawable r14 = new MaterialShapeDrawable(r5);
        this.backgroundShape = r14;
        r14.initializeElevationOverlay(getContext());
        this.backgroundShape.setElevation(r11);
        if (r12 < 0.0f) goto L5;
        this.backgroundShape.setStroke(r12, r13);
    L5:
        int r15 = MaterialColors.getColor(this, R.attr.colorControlHighlight);
        this.backgroundShape.setFillColor(ColorStateList.valueOf(r10));
        ColorStateList r16 = ColorStateList.valueOf(r15);
        MaterialShapeDrawable r17 = this.backgroundShape;
        ViewCompat.setBackground(this, new RippleDrawable(r16, r17, r17));
    }

    private void initNavigationIcon() {
        if (getNavigationIcon() != null) goto L5;
        Drawable r5 = this.defaultNavigationIcon;
    L6:
        setNavigationIcon(r5);
        setNavigationIconDecorative(true);
        return;
    L5:
        r5 = getNavigationIcon();
        goto L6
    }

    private void initTextView(@StyleRes int r5, String r10, String r11) {
        if (r5 == (-1)) goto L5;
        TextViewCompat.setTextAppearance(this.textView, r5);
    L5:
        setText(r10);
        setHint(r11);
        if (getNavigationIcon() != null) goto L9;
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.textView.getLayoutParams(), getResources().getDimensionPixelSize(R.dimen.m3_searchbar_text_margin_start_no_navigation_icon));
        return;
    }

    private /* synthetic */ void lambda$new$0(boolean r5) {
        setFocusableInTouchMode(r5);
    }

    private /* synthetic */ void lambda$startOnLoadAnimation$1() {
        this.searchBarAnimationHelper.startOnLoadAnimation(this);
    }

    private void layoutCenterView() {
        View r5 = this.centerView;
        if (r5 != null) goto L5;
        return;
    L5:
        int r10 = r5.getMeasuredWidth();
        int r11 = (getMeasuredWidth() / 2) - (r10 / 2);
        int r12 = r11 + r10;
        int r13 = this.centerView.getMeasuredHeight();
        int r14 = (getMeasuredHeight() / 2) - (r13 / 2);
        View r15 = this.centerView;
        layoutChild(r15, r11, r14, r12, r14 + r13);
    }

    private void layoutChild(View r5, int r10, int r11, int r12, int r13) {
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        r5.layout(getMeasuredWidth() - r12, r11, getMeasuredWidth() - r10, r13);
        return;
    L5:
        r5.layout(r10, r11, r12, r13);
    }

    @Nullable
    private Drawable maybeTintNavigationIcon(@Nullable Drawable r5) {
        if (this.tintNavigationIcon == false) goto L16;
        if (r5 == null) goto L17;
        Integer r10 = this.navigationIconTint;
        if (r10 == null) goto L10;
        int r11 = r10.intValue();
    L14:
        Drawable r12 = DrawableCompat.wrap(r5.mutate());
        DrawableCompat.setTint(r12, r11);
        return r12;
    L10:
        if (r5 != this.defaultNavigationIcon) goto L12;
        int r13 = R.attr.colorOnSurfaceVariant;
    L13:
        r11 = MaterialColors.getColor(this, r13);
        goto L14
    L12:
        r13 = R.attr.colorOnSurface;
        goto L13
    L17:
        return r5;
    L16:
        return r5;
    }

    private void measureCenterView(int r5, int r10) {
        View r11 = this.centerView;
        if (r11 == null) goto L6;
        r11.measure(r5, r10);
        return;
    }

    private void setDefaultMargins() {
        if (this.defaultMarginsEnabled == true) goto L5;
        return;
    L5:
        if ((getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        Resources r5 = getResources();
        int r10 = r5.getDimensionPixelSize(R.dimen.m3_searchbar_margin_horizontal);
        int r11 = r5.getDimensionPixelSize(getDefaultMarginVerticalResource());
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) getLayoutParams();
        r12.leftMargin = defaultIfZero(r12.leftMargin, r10);
        r12.topMargin = defaultIfZero(r12.topMargin, r11);
        r12.rightMargin = defaultIfZero(r12.rightMargin, r10);
        r12.bottomMargin = defaultIfZero(r12.bottomMargin, r11);
        return;
    }

    private void setHandwritingBoundsInsets() {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return;
    L5:
        boolean r5 = true;
        int r10 = 0;
        if (getLayoutDirection() == 1) goto L9;
        r5 = false;
    L9:
        ImageButton r11 = ToolbarUtils.getNavigationIconButton(this);
        if (r11 != null) goto L12;
    L16:
        int r12 = 0;
    L17:
        ActionMenuView r13 = ToolbarUtils.getActionMenuView(this);
        if (r13 == null) goto L22;
        if (r5 == false) goto L21;
        r10 = r13.getRight();
        goto L22
    L21:
        r10 = getWidth() - r13.getLeft();
    L22:
        if (r5 == false) goto L24;
        int r14 = r10;
    L25:
        float r15 = -r14;
        if (r5 == true) goto L29;
        r12 = r10;
    L29:
        androidx.room.b.j(this, r15, -r12);
        return;
    L24:
        r14 = r12;
        goto L25
    L12:
        if (r11.isClickable() == false) goto L16;
        if (r5 == false) goto L15;
        r12 = getWidth() - r11.getLeft();
        goto L17
    L15:
        r12 = r11.getRight();
        goto L17
    }

    private void setNavigationIconDecorative(boolean r5) {
        ImageButton r10 = ToolbarUtils.getNavigationIconButton(this);
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setClickable(!r5);
        r10.setFocusable(!r5);
        Drawable r11 = r10.getBackground();
        if (r11 == null) goto L8;
        this.originalNavigationIconBackground = r11;
    L8:
        if (r5 == false) goto L10;
        Drawable r12 = null;
    L11:
        r10.setBackgroundDrawable(r12);
        setHandwritingBoundsInsets();
        return;
    L10:
        r12 = this.originalNavigationIconBackground;
        goto L11
    }

    private void setOrClearDefaultScrollFlags() {
        if ((getLayoutParams() instanceof AppBarLayout.LayoutParams) == false) goto L13;
        AppBarLayout.LayoutParams r5 = (AppBarLayout.LayoutParams) getLayoutParams();
        if (this.defaultScrollFlagsEnabled == false) goto L10;
        if (r5.getScrollFlags() != 0) goto L14;
        r5.setScrollFlags(53);
        return;
    L14:
        return;
    L10:
        if (r5.getScrollFlags() != 53) goto L16;
        r5.setScrollFlags(0);
        return;
    L16:
        return;
    }

    private void setupTouchExplorationStateChangeListener() {
        AccessibilityManager r5 = this.accessibilityManager;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEnabled() == true) goto L7;
    L9:
        addOnAttachStateChangeListener(new AnonymousClass1(this));
        return;
    L7:
        if (this.accessibilityManager.isTouchExplorationEnabled() == false) goto L9;
        setFocusableInTouchMode(true);
        goto L9
    }

    private void validateAttributes(@Nullable AttributeSet r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getAttributeValue(NAMESPACE_APP, Constant.TITLE) != null) goto L12;
        if (r5.getAttributeValue(NAMESPACE_APP, "subtitle") != null) goto L10;
        return;
    L10:
        throw new UnsupportedOperationException("SearchBar does not support subtitle. Use hint or text instead.");
    L12:
        throw new UnsupportedOperationException("SearchBar does not support title. Use hint or text instead.");
    }

    public void addCollapseAnimationListener(@NonNull AnimatorListenerAdapter r5) {
        this.searchBarAnimationHelper.addCollapseAnimationListener(r5);
    }

    public void addExpandAnimationListener(@NonNull AnimatorListenerAdapter r5) {
        this.searchBarAnimationHelper.addExpandAnimationListener(r5);
    }

    public void addOnLoadAnimationCallback(@NonNull OnLoadAnimationCallback r5) {
        this.searchBarAnimationHelper.addOnLoadAnimationCallback(r5);
    }

    @Override // android.view.ViewGroup
    public void addView(View r5, int r10, ViewGroup.LayoutParams r11) {
        if (this.layoutInflated == true) goto L5;
    L9:
        super.addView(r5, r10, r11);
        return;
    L5:
        if (this.centerView != null) goto L9;
        if ((r5 instanceof ActionMenuView) == true) goto L9;
        this.centerView = r5;
        r5.setAlpha(0.0f);
        goto L9
    }

    public void clearText() {
        this.textView.setText("");
    }

    public boolean collapse(@NonNull View r5) {
        return collapse(r5, null);
    }

    public boolean expand(@NonNull View r5) {
        return expand(r5, null);
    }

    @Nullable
    public View getCenterView() {
        return this.centerView;
    }

    public float getCompatElevation() {
        MaterialShapeDrawable r5 = this.backgroundShape;
        if (r5 == null) goto L6;
        return r5.getElevation();
    L6:
        return ViewCompat.getElevation(this);
    }

    public float getCornerSize() {
        return this.backgroundShape.getTopLeftCornerResolvedSize();
    }

    @DimenRes
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getDefaultMarginVerticalResource() {
        return R.dimen.m3_searchbar_margin_vertical;
    }

    @DrawableRes
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getDefaultNavigationIconResource() {
        return R.drawable.ic_search_black_24;
    }

    @Nullable
    public CharSequence getHint() {
        return this.textView.getHint();
    }

    public int getMenuResId() {
        return this.menuResId;
    }

    @ColorInt
    public int getStrokeColor() {
        return this.backgroundShape.getStrokeColor().getDefaultColor();
    }

    @Dimension
    public float getStrokeWidth() {
        return this.backgroundShape.getStrokeWidth();
    }

    @NonNull
    public CharSequence getText() {
        return this.textView.getText();
    }

    @NonNull
    public TextView getTextView() {
        return this.textView;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(@MenuRes int r5) {
        Menu r10 = getMenu();
        boolean r11 = r10 instanceof MenuBuilder;
        if (r11 == false) goto L5;
        ((MenuBuilder) r10).stopDispatchingItemsChanged();
    L5:
        super.inflateMenu(r5);
        this.menuResId = r5;
        if (r11 == false) goto L9;
        ((MenuBuilder) r10).startDispatchingItemsChanged();
        return;
    }

    public boolean isCollapsing() {
        return this.searchBarAnimationHelper.isCollapsing();
    }

    public boolean isDefaultScrollFlagsEnabled() {
        return this.defaultScrollFlagsEnabled;
    }

    public boolean isExpanding() {
        return this.searchBarAnimationHelper.isExpanding();
    }

    public boolean isOnLoadAnimationFadeInEnabled() {
        return this.searchBarAnimationHelper.isOnLoadAnimationFadeInEnabled();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.backgroundShape);
        setDefaultMargins();
        setOrClearDefaultScrollFlags();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        r5.setClassName(EditText.class.getCanonicalName());
        r5.setEditable(isEnabled());
        CharSequence r10 = getText();
        boolean r11 = TextUtils.isEmpty(r10);
        r5.setHintText(getHint());
        r5.setShowingHintText(r11);
        if (r11 == false) goto L5;
        r10 = getHint();
    L5:
        r5.setText(r10);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        layoutCenterView();
        setHandwritingBoundsInsets();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        measureCenterView(r5, r10);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        setText(r10.text);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        CharSequence r10 = getText();
        if (r10 != null) goto L5;
        String r11 = null;
    L6:
        r5.text = r11;
        return r5;
    L5:
        r11 = r10.toString();
        goto L6
    }

    public boolean removeCollapseAnimationListener(@NonNull AnimatorListenerAdapter r5) {
        return this.searchBarAnimationHelper.removeCollapseAnimationListener(r5);
    }

    public boolean removeExpandAnimationListener(@NonNull AnimatorListenerAdapter r5) {
        return this.searchBarAnimationHelper.removeExpandAnimationListener(r5);
    }

    public boolean removeOnLoadAnimationCallback(@NonNull OnLoadAnimationCallback r5) {
        return this.searchBarAnimationHelper.removeOnLoadAnimationCallback(r5);
    }

    public void setCenterView(@Nullable View r5) {
        View r10 = this.centerView;
        if (r10 == null) goto L5;
        removeView(r10);
        this.centerView = null;
    L5:
        if (r5 == null) goto L8;
        addView(r5);
        return;
    }

    public void setDefaultScrollFlagsEnabled(boolean r5) {
        this.defaultScrollFlagsEnabled = r5;
        setOrClearDefaultScrollFlags();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r5) {
        super.setElevation(r5);
        MaterialShapeDrawable r10 = this.backgroundShape;
        if (r10 == null) goto L6;
        r10.setElevation(r5);
        return;
    }

    public void setHint(@Nullable CharSequence r5) {
        this.textView.setHint(r5);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable r5) {
        super.setNavigationIcon(maybeTintNavigationIcon(r5));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener r5) {
        if (this.forceDefaultNavigationOnClickListener == false) goto L5;
        return;
    L5:
        super.setNavigationOnClickListener(r5);
        if (r5 != null) goto L8;
        boolean r10 = true;
    L9:
        setNavigationIconDecorative(r10);
        return;
    L8:
        r10 = false;
        goto L9
    }

    public void setOnLoadAnimationFadeInEnabled(boolean r5) {
        this.searchBarAnimationHelper.setOnLoadAnimationFadeInEnabled(r5);
    }

    public void setStrokeColor(@ColorInt int r5) {
        if (getStrokeColor() == r5) goto L6;
        this.backgroundShape.setStrokeColor(ColorStateList.valueOf(r5));
        return;
    }

    public void setStrokeWidth(@Dimension float r5) {
        if (getStrokeWidth() == r5) goto L6;
        this.backgroundShape.setStrokeWidth(r5);
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence r5) {
    }

    public void setText(@Nullable CharSequence r5) {
        this.textView.setText(r5);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence r5) {
    }

    public void startOnLoadAnimation() {
        post(new m(this, 2));
    }

    public void stopOnLoadAnimation() {
        this.searchBarAnimationHelper.stopOnLoadAnimation(this);
    }

    public SearchBar(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.materialSearchBarStyle);
    }

    public boolean collapse(@NonNull View r5, @Nullable AppBarLayout r10) {
        return collapse(r5, r10, false);
    }

    public boolean expand(@NonNull View r5, @Nullable AppBarLayout r10) {
        return expand(r5, r10, false);
    }

    public void setHint(@StringRes int r5) {
        this.textView.setHint(r5);
    }

    public void setText(@StringRes int r5) {
        this.textView.setText(r5);
    }

    public SearchBar(@NonNull Context r11, @Nullable AttributeSet r12, int r13) {
        int r10 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r11, r12, r13, r10), r12, r13);
        this.menuResId = -1;
        this.touchExplorationStateChangeListener = new a(this);
        Context r14 = getContext();
        validateAttributes(r12);
        this.defaultNavigationIcon = AppCompatResources.getDrawable(r14, getDefaultNavigationIconResource());
        this.searchBarAnimationHelper = new SearchBarAnimationHelper();
        TypedArray r5 = ThemeEnforcement.obtainStyledAttributes(r14, r12, R.styleable.SearchBar, r13, r10, new int[0]);
        ShapeAppearanceModel r15 = ShapeAppearanceModel.builder(r14, r12, r13, r10).build();
        int r16 = r5.getColor(R.styleable.SearchBar_backgroundTint, 0);
        float r17 = r5.getDimension(R.styleable.SearchBar_elevation, 0.0f);
        this.defaultMarginsEnabled = r5.getBoolean(R.styleable.SearchBar_defaultMarginsEnabled, true);
        this.defaultScrollFlagsEnabled = r5.getBoolean(R.styleable.SearchBar_defaultScrollFlagsEnabled, true);
        boolean r18 = r5.getBoolean(R.styleable.SearchBar_hideNavigationIcon, false);
        this.forceDefaultNavigationOnClickListener = r5.getBoolean(R.styleable.SearchBar_forceDefaultNavigationOnClickListener, false);
        this.tintNavigationIcon = r5.getBoolean(R.styleable.SearchBar_tintNavigationIcon, true);
        if (r5.hasValue(R.styleable.SearchBar_navigationIconTint) == false) goto L5;
        this.navigationIconTint = Integer.valueOf(r5.getColor(R.styleable.SearchBar_navigationIconTint, -1));
    L5:
        int r19 = r5.getResourceId(R.styleable.SearchBar_android_textAppearance, -1);
        String r20 = r5.getString(R.styleable.SearchBar_android_text);
        String r21 = r5.getString(R.styleable.SearchBar_android_hint);
        float r22 = r5.getDimension(R.styleable.SearchBar_strokeWidth, -1.0f);
        int r23 = r5.getColor(R.styleable.SearchBar_strokeColor, 0);
        r5.recycle();
        if (r18 == true) goto L8;
        initNavigationIcon();
    L8:
        setClickable(true);
        setFocusable(true);
        LayoutInflater.from(r14).inflate(R.layout.mtrl_search_bar, this);
        this.layoutInflated = true;
        this.textView = (TextView) findViewById(R.id.open_search_bar_text_view);
        ViewCompat.setElevation(this, r17);
        initTextView(r19, r20, r21);
        initBackground(r15, r16, r17, r22, r23);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setupTouchExplorationStateChangeListener();
    }

    public boolean collapse(@NonNull View r5, @Nullable AppBarLayout r10, boolean r11) {
        if (r5.getVisibility() != 0) goto L7;
        if (isCollapsing() == true) goto L7;
    L8:
        this.searchBarAnimationHelper.startCollapseAnimation(this, r5, r10, r11);
        return true;
    L7:
        if (isExpanding() == true) goto L8;
        return false;
    }

    public boolean expand(@NonNull View r5, @Nullable AppBarLayout r10, boolean r11) {
        if (r5.getVisibility() == 0) goto L7;
        if (isExpanding() == true) goto L7;
    L8:
        this.searchBarAnimationHelper.startExpandAnimation(this, r5, r10, r11);
        return true;
    L7:
        if (isCollapsing() == true) goto L8;
        return false;
    }
}
