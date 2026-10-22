package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    private static final int DEF_STYLE_RES = 0;
    public static final int TITLE_COLLAPSE_MODE_FADE = 1;
    public static final int TITLE_COLLAPSE_MODE_SCALE = 0;

    @NonNull
    final CollapsingTextHelper collapsingTextHelper;
    private boolean collapsingTitleEnabled;

    @Nullable
    private Drawable contentScrim;
    int currentOffset;
    private boolean drawCollapsingTitle;
    private View dummyView;

    @NonNull
    final ElevationOverlayProvider elevationOverlayProvider;
    private int expandedMarginBottom;
    private int expandedMarginEnd;
    private int expandedMarginStart;
    private int expandedMarginTop;
    private int extraMultilineHeight;
    private boolean extraMultilineHeightEnabled;
    private boolean forceApplySystemWindowInsetTop;

    @Nullable
    WindowInsetsCompat lastInsets;
    private AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
    private boolean refreshToolbar;
    private int scrimAlpha;
    private long scrimAnimationDuration;
    private final TimeInterpolator scrimAnimationFadeInInterpolator;
    private final TimeInterpolator scrimAnimationFadeOutInterpolator;
    private ValueAnimator scrimAnimator;
    private int scrimVisibleHeightTrigger;
    private boolean scrimsAreShown;

    @Nullable
    Drawable statusBarScrim;
    private int titleCollapseMode;
    private final Rect tmpRect;

    @Nullable
    private ViewGroup toolbar;

    @Nullable
    private View toolbarDirectChild;
    private int toolbarId;
    private int topInsetApplied;

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        int collapseMode;
        float parallaxMult;

        public LayoutParams(Context r5, AttributeSet r10) {
            super(r5, r10);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
            TypedArray r11 = r5.obtainStyledAttributes(r10, R.styleable.CollapsingToolbarLayout_Layout);
            this.collapseMode = r11.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            setParallaxMultiplier(r11.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            r11.recycle();
        }

        public int getCollapseMode() {
            return this.collapseMode;
        }

        public float getParallaxMultiplier() {
            return this.parallaxMult;
        }

        public void setCollapseMode(int r5) {
            this.collapseMode = r5;
        }

        public void setParallaxMultiplier(float r5) {
            this.parallaxMult = r5;
        }

        public LayoutParams(int r5, int r10) {
            super(r5, r10);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(int r5, int r10, int r11) {
            super(r5, r10, r11);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams r5) {
            super(r5);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams r5) {
            super(r5);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull FrameLayout.LayoutParams r5) {
            super(r5);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull LayoutParams r5) {
            super(r5);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
            this.collapseMode = r5.collapseMode;
            this.parallaxMult = r5.parallaxMult;
        }
    }

    public class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        final /* synthetic */ CollapsingToolbarLayout this$0;

        public OffsetUpdateListener(CollapsingToolbarLayout r5) {
            this.this$0 = r5;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout r10, int r11) {
            CollapsingToolbarLayout r12 = this.this$0;
            r12.currentOffset = r11;
            WindowInsetsCompat r13 = r12.lastInsets;
            if (r13 == null) goto L5;
            int r14 = r13.getSystemWindowInsetTop();
        L6:
            int r5 = this.this$0.getChildCount();
            int r15 = 0;
        L7:
            if (r15 >= r5) goto L16;
            View r16 = this.this$0.getChildAt(r15);
            LayoutParams r17 = (LayoutParams) r16.getLayoutParams();
            ViewOffsetHelper r18 = CollapsingToolbarLayout.getViewOffsetHelper(r16);
            int r19 = r17.collapseMode;
            if (r19 != 1) goto L11;
            r18.setTopAndBottomOffset(MathUtils.clamp(-r11, 0, this.this$0.getMaxOffsetForPinChild(r16)));
        L15:
            r15 = r15 + 1;
            goto L7
        L11:
            if (r19 != 2) goto L15;
            r18.setTopAndBottomOffset(Math.round((-r11) * r17.parallaxMult));
            goto L15
        L16:
            this.this$0.updateScrimVisibility();
            CollapsingToolbarLayout r20 = this.this$0;
            if (r20.statusBarScrim == null) goto L20;
            if (r14 <= 0) goto L20;
            ViewCompat.postInvalidateOnAnimation(r20);
        L20:
            int r21 = this.this$0.getHeight();
            int r22 = (r21 - ViewCompat.getMinimumHeight(this.this$0)) - r14;
            float r23 = r22;
            this.this$0.collapsingTextHelper.setFadeModeStartFraction(Math.min(1.0f, (r21 - this.this$0.getScrimVisibleHeightTrigger()) / r23));
            CollapsingToolbarLayout r24 = this.this$0;
            r24.collapsingTextHelper.setCurrentOffsetY(r24.currentOffset + r22);
            this.this$0.collapsingTextHelper.setExpansionFraction(Math.abs(r11) / r23);
            return;
        L5:
            r14 = 0;
            goto L6
        }
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface StaticLayoutBuilderConfigurer extends com.google.android.material.internal.StaticLayoutBuilderConfigurer {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TitleCollapseMode {
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_CollapsingToolbar;
    }

    public CollapsingToolbarLayout(@NonNull Context r5) {
        this(r5, null);
    }

    private void animateScrim(int r5) {
        ensureToolbar();
        ValueAnimator r10 = this.scrimAnimator;
        if (r10 != null) goto L10;
        ValueAnimator r11 = new ValueAnimator();
        this.scrimAnimator = r11;
        if (r5 <= this.scrimAlpha) goto L7;
        TimeInterpolator r12 = this.scrimAnimationFadeInInterpolator;
    L8:
        r11.setInterpolator(r12);
        this.scrimAnimator.addUpdateListener(new AnonymousClass2(this));
    L12:
        this.scrimAnimator.setDuration(this.scrimAnimationDuration);
        this.scrimAnimator.setIntValues(new int[]{this.scrimAlpha, r5});
        this.scrimAnimator.start();
        return;
    L7:
        r12 = this.scrimAnimationFadeOutInterpolator;
        goto L8
    L10:
        if (r10.isRunning() == false) goto L12;
        this.scrimAnimator.cancel();
        goto L12
    }

    private TextUtils.TruncateAt convertEllipsizeToTruncateAt(int r5) {
        if (r5 == 0) goto L14;
        if (r5 == 1) goto L12;
        if (r5 == 3) goto L10;
        return TextUtils.TruncateAt.END;
    L10:
        return TextUtils.TruncateAt.MARQUEE;
    L12:
        return TextUtils.TruncateAt.MIDDLE;
    L14:
        return TextUtils.TruncateAt.START;
    }

    private void disableLiftOnScrollIfNeeded(AppBarLayout r5) {
        if (isTitleCollapseFadeMode() == false) goto L6;
        r5.setLiftOnScroll(false);
        return;
    }

    private void ensureToolbar() {
        if (this.refreshToolbar == true) goto L5;
        return;
    L5:
        ViewGroup r5 = null;
        this.toolbar = null;
        this.toolbarDirectChild = null;
        int r10 = this.toolbarId;
        if (r10 == (-1)) goto L11;
        ViewGroup r11 = (ViewGroup) findViewById(r10);
        this.toolbar = r11;
        if (r11 == null) goto L11;
        this.toolbarDirectChild = findDirectChild(r11);
    L11:
        if (this.toolbar != null) goto L19;
        int r12 = getChildCount();
        int r13 = 0;
    L13:
        if (r13 >= r12) goto L18;
        View r14 = getChildAt(r13);
        if (isToolbar(r14) == true) goto L16;
        r13 = r13 + 1;
        goto L13
    L16:
        r5 = (ViewGroup) r14;
    L18:
        this.toolbar = r5;
    L19:
        updateDummyView();
        this.refreshToolbar = false;
    }

    @NonNull
    private View findDirectChild(@NonNull View r5) {
        ViewParent r10 = r5.getParent();
    L3:
        if (r10 == this) goto L9;
        if (r10 == null) goto L9;
        if ((r10 instanceof View) == false) goto L8;
        r5 = r10;
    L8:
        r10 = r10.getParent();
    L9:
        return r5;
    }

    @ColorInt
    private int getDefaultContentScrimColorForTitleCollapseFadeMode() {
        ColorStateList r5 = MaterialColors.getColorStateListOrNull(getContext(), R.attr.colorSurfaceContainer);
        if (r5 != null) goto L5;
        float r10 = getResources().getDimension(R.dimen.design_appbar_elevation);
        return this.elevationOverlayProvider.compositeOverlayWithThemeSurfaceColorIfNeeded(r10);
    L5:
        return r5.getDefaultColor();
    }

    private static int getHeightWithMargins(@NonNull View r5) {
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
        return (r5.getMeasuredHeight() + r11.topMargin) + r11.bottomMargin;
    L7:
        return r5.getMeasuredHeight();
    }

    private static CharSequence getToolbarTitle(View r5) {
        if ((r5 instanceof Toolbar) == false) goto L7;
        return ((Toolbar) r5).getTitle();
    L7:
        if ((r5 instanceof android.widget.Toolbar) == true) goto L9;
        return null;
    L9:
        return ((android.widget.Toolbar) r5).getTitle();
    }

    @NonNull
    public static ViewOffsetHelper getViewOffsetHelper(@NonNull View r5) {
        ViewOffsetHelper r10 = (ViewOffsetHelper) r5.getTag(R.id.view_offset_helper);
        if (r10 != null) goto L6;
        ViewOffsetHelper r11 = new ViewOffsetHelper(r5);
        r5.setTag(R.id.view_offset_helper, r11);
        return r11;
    L6:
        return r10;
    }

    private boolean isTitleCollapseFadeMode() {
        if (this.titleCollapseMode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static boolean isToolbar(View r5) {
        if ((r5 instanceof Toolbar) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r5 instanceof android.widget.Toolbar) == true) goto L8;
        return false;
    }

    private boolean isToolbarChild(View r5) {
        View r10 = this.toolbarDirectChild;
        if (r10 == null) goto L9;
        if (r10 == this) goto L9;
        if (r5 == r10) goto L12;
        return false;
    L12:
        return true;
    L9:
        if (r5 == this.toolbar) goto L12;
        return false;
    }

    private void updateCollapsedBounds(boolean r10) {
        View r5 = this.toolbarDirectChild;
        if (r5 != null) goto L6;
        r5 = this.toolbar;
    L6:
        int r11 = getMaxOffsetForPinChild(r5);
        DescendantOffsetUtils.getDescendantRect(this, this.dummyView, this.tmpRect);
        ViewGroup r12 = this.toolbar;
        if ((r12 instanceof Toolbar) == false) goto L10;
        Toolbar r13 = (Toolbar) r12;
        int r14 = r13.getTitleMarginStart();
        int r15 = r13.getTitleMarginEnd();
        int r16 = r13.getTitleMarginTop();
        int r17 = r13.getTitleMarginBottom();
    L13:
        CollapsingTextHelper r18 = this.collapsingTextHelper;
        Rect r19 = this.tmpRect;
        int r20 = r19.left;
        if (r10 == false) goto L16;
        int r21 = r15;
    L17:
        int r22 = r20 + r21;
        int r23 = (r19.top + r11) + r16;
        int r24 = r19.right;
        if (r10 == true) goto L21;
        r14 = r15;
    L21:
        r18.setCollapsedBounds(r22, r23, r24 - r14, (r19.bottom + r11) - r17);
        return;
    L16:
        r21 = r14;
        goto L17
    L10:
        if ((r12 instanceof android.widget.Toolbar) == false) goto L12;
        android.widget.Toolbar r25 = (android.widget.Toolbar) r12;
        r14 = r25.getTitleMarginStart();
        r15 = r25.getTitleMarginEnd();
        r16 = r25.getTitleMarginTop();
        r17 = r25.getTitleMarginBottom();
        goto L13
    L12:
        r14 = 0;
        r17 = 0;
        r15 = 0;
        r16 = 0;
        goto L13
    }

    private void updateContentDescriptionFromTitle() {
        setContentDescription(getTitle());
    }

    private void updateContentScrimBounds(@NonNull Drawable r5, int r10, int r11) {
        updateContentScrimBounds(r5, this.toolbar, r10, r11);
    }

    private void updateDummyView() {
        if (this.collapsingTitleEnabled == true) goto L10;
        View r5 = this.dummyView;
        if (r5 == null) goto L10;
        ViewParent r10 = r5.getParent();
        if ((r10 instanceof ViewGroup) == false) goto L10;
        ((ViewGroup) r10).removeView(this.dummyView);
    L10:
        if (this.collapsingTitleEnabled == true) goto L12;
        return;
    L12:
        if (this.toolbar != null) goto L14;
        return;
    L14:
        if (this.dummyView != null) goto L17;
        this.dummyView = new View(getContext());
    L17:
        if (this.dummyView.getParent() != null) goto L22;
        this.toolbar.addView(this.dummyView, -1, -1);
        return;
    }

    private void updateTextBounds(int r10, int r11, int r12, int r13, boolean r14) {
        if (this.collapsingTitleEnabled == false) goto L28;
        View r5 = this.dummyView;
        if (r5 == null) goto L29;
        boolean r15 = false;
        if (ViewCompat.isAttachedToWindow(r5) == true) goto L9;
    L11:
        boolean r16 = false;
    L12:
        this.drawCollapsingTitle = r16;
        if (r16 == true) goto L16;
        if (r14 == true) goto L16;
        return;
    L16:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L18;
        r15 = true;
    L18:
        updateCollapsedBounds(r15);
        CollapsingTextHelper r17 = this.collapsingTextHelper;
        if (r15 == false) goto L21;
        int r18 = this.expandedMarginEnd;
    L22:
        int r19 = this.tmpRect.top + this.expandedMarginTop;
        int r20 = r12 - r10;
        if (r15 == false) goto L25;
        int r21 = this.expandedMarginStart;
    L26:
        r17.setExpandedBounds(r18, r19, r20 - r21, (r13 - r11) - this.expandedMarginBottom);
        this.collapsingTextHelper.recalculate(r14);
        return;
    L25:
        r21 = this.expandedMarginEnd;
        goto L26
    L21:
        r18 = this.expandedMarginStart;
        goto L22
    L9:
        if (this.dummyView.getVisibility() != 0) goto L11;
        r16 = true;
        goto L12
    L29:
        return;
    }

    private void updateTitleFromToolbarIfNeeded() {
        if (this.toolbar != null) goto L5;
        return;
    L5:
        if (this.collapsingTitleEnabled == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.collapsingTextHelper.getText()) == false) goto L12;
        setTitle(getToolbarTitle(this.toolbar));
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r5) {
        return r5 instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r10) {
        super.draw(r10);
        ensureToolbar();
        if (this.toolbar != null) goto L10;
        Drawable r5 = this.contentScrim;
        if (r5 == null) goto L10;
        if (this.scrimAlpha <= 0) goto L10;
        r5.mutate().setAlpha(this.scrimAlpha);
        this.contentScrim.draw(r10);
    L10:
        if (this.collapsingTitleEnabled == false) goto L26;
        if (this.drawCollapsingTitle == false) goto L26;
        if (this.toolbar != null) goto L16;
    L24:
        this.collapsingTextHelper.draw(r10);
        goto L26
    L16:
        if (this.contentScrim == null) goto L24;
        if (this.scrimAlpha <= 0) goto L24;
        if (isTitleCollapseFadeMode() == false) goto L24;
        if (this.collapsingTextHelper.getExpansionFraction() >= this.collapsingTextHelper.getFadeModeThresholdFraction()) goto L24;
        int r11 = r10.save();
        r10.clipRect(this.contentScrim.getBounds(), Region.Op.DIFFERENCE);
        this.collapsingTextHelper.draw(r10);
        r10.restoreToCount(r11);
    L26:
        if (this.statusBarScrim != null) goto L28;
        return;
    L28:
        if (this.scrimAlpha <= 0) goto L37;
        WindowInsetsCompat r12 = this.lastInsets;
        if (r12 == null) goto L32;
        int r13 = r12.getSystemWindowInsetTop();
    L33:
        if (r13 <= 0) goto L38;
        this.statusBarScrim.setBounds(0, -this.currentOffset, getWidth(), r13 - this.currentOffset);
        this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
        this.statusBarScrim.draw(r10);
        return;
    L38:
        return;
    L32:
        r13 = 0;
        goto L33
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r10, View r11, long r12) {
        if (this.contentScrim != null) goto L5;
    L9:
        boolean r5 = false;
    L11:
        if (super.drawChild(r10, r11, r12) == true) goto L16;
        if (r5 == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return true;
    L5:
        if (this.scrimAlpha <= 0) goto L9;
        if (isToolbarChild(r11) == false) goto L9;
        updateContentScrimBounds(this.contentScrim, r11, getWidth(), getHeight());
        this.contentScrim.mutate().setAlpha(this.scrimAlpha);
        this.contentScrim.draw(r10);
        r5 = true;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r5 = getDrawableState();
        Drawable r10 = this.statusBarScrim;
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        Drawable r12 = this.contentScrim;
        if (r12 != null) goto L11;
    L13:
        CollapsingTextHelper r13 = this.collapsingTextHelper;
        if (r13 == null) goto L16;
        r11 = r11 | r13.setState(r5);
    L16:
        if (r11 == false) goto L19;
        invalidate();
        return;
    L19:
        return;
    L11:
        if (r12.isStateful() == false) goto L13;
        r11 = r11 | r12.setState(r5);
        goto L13
    L5:
        if (r10.isStateful() == false) goto L7;
        r11 = r10.setState(r5);
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return generateLayoutParams(r5);
    }

    public int getCollapsedTitleGravity() {
        return this.collapsingTextHelper.getCollapsedTextGravity();
    }

    public float getCollapsedTitleTextSize() {
        return this.collapsingTextHelper.getCollapsedTextSize();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.collapsingTextHelper.getCollapsedTypeface();
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.contentScrim;
    }

    public int getExpandedTitleGravity() {
        return this.collapsingTextHelper.getExpandedTextGravity();
    }

    public int getExpandedTitleMarginBottom() {
        return this.expandedMarginBottom;
    }

    public int getExpandedTitleMarginEnd() {
        return this.expandedMarginEnd;
    }

    public int getExpandedTitleMarginStart() {
        return this.expandedMarginStart;
    }

    public int getExpandedTitleMarginTop() {
        return this.expandedMarginTop;
    }

    public float getExpandedTitleTextSize() {
        return this.collapsingTextHelper.getExpandedTextSize();
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.collapsingTextHelper.getExpandedTypeface();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getHyphenationFrequency() {
        return this.collapsingTextHelper.getHyphenationFrequency();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLineCount() {
        return this.collapsingTextHelper.getLineCount();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingAdd() {
        return this.collapsingTextHelper.getLineSpacingAdd();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingMultiplier() {
        return this.collapsingTextHelper.getLineSpacingMultiplier();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.collapsingTextHelper.getMaxLines();
    }

    public final int getMaxOffsetForPinChild(@NonNull View r5) {
        ViewOffsetHelper r10 = getViewOffsetHelper(r5);
        LayoutParams r11 = (LayoutParams) r5.getLayoutParams();
        return ((getHeight() - r10.getLayoutTop()) - r5.getHeight()) - ((FrameLayout.LayoutParams) r11).bottomMargin;
    }

    public int getScrimAlpha() {
        return this.scrimAlpha;
    }

    public long getScrimAnimationDuration() {
        return this.scrimAnimationDuration;
    }

    public int getScrimVisibleHeightTrigger() {
        int r5 = this.scrimVisibleHeightTrigger;
        if (r5 >= 0) goto L5;
        WindowInsetsCompat r10 = this.lastInsets;
        if (r10 == null) goto L9;
        int r11 = r10.getSystemWindowInsetTop();
    L10:
        int r12 = ViewCompat.getMinimumHeight(this);
        if (r12 <= 0) goto L15;
        return Math.min((r12 * 2) + r11, getHeight());
    L15:
        return getHeight() / 3;
    L9:
        r11 = 0;
        goto L10
    L5:
        return (r5 + this.topInsetApplied) + this.extraMultilineHeight;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.statusBarScrim;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.collapsingTitleEnabled == true) goto L7;
        return null;
    L7:
        return this.collapsingTextHelper.getText();
    }

    public int getTitleCollapseMode() {
        return this.titleCollapseMode;
    }

    @Nullable
    public TimeInterpolator getTitlePositionInterpolator() {
        return this.collapsingTextHelper.getPositionInterpolator();
    }

    @NonNull
    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.collapsingTextHelper.getTitleTextEllipsize();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isExtraMultilineHeightEnabled() {
        return this.extraMultilineHeightEnabled;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isForceApplySystemWindowInsetTop() {
        return this.forceApplySystemWindowInsetTop;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.collapsingTextHelper.isRtlTextDirectionHeuristicsEnabled();
    }

    public boolean isTitleEnabled() {
        return this.collapsingTitleEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r5 = getParent();
        if ((r5 instanceof AppBarLayout) == false) goto L9;
        AppBarLayout r10 = (AppBarLayout) r5;
        disableLiftOnScrollIfNeeded(r10);
        ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows(r10));
        if (this.onOffsetChangedListener != null) goto L7;
        this.onOffsetChangedListener = new OffsetUpdateListener(this);
    L7:
        r10.addOnOffsetChangedListener(this.onOffsetChangedListener);
        ViewCompat.requestApplyInsets(this);
        return;
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NonNull Configuration r5) {
        super.onConfigurationChanged(r5);
        this.collapsingTextHelper.maybeUpdateFontWeightAdjustment(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewParent r5 = getParent();
        AppBarLayout.OnOffsetChangedListener r10 = this.onOffsetChangedListener;
        if (r10 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if ((r5 instanceof AppBarLayout) == false) goto L7;
        ((AppBarLayout) r5).removeOnOffsetChangedListener(r10);
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        WindowInsetsCompat r15 = this.lastInsets;
        int r5 = 0;
        if (r15 == null) goto L12;
        int r16 = r15.getSystemWindowInsetTop();
        int r17 = getChildCount();
        int r18 = 0;
    L5:
        if (r18 >= r17) goto L12;
        View r19 = getChildAt(r18);
        if (ViewCompat.getFitsSystemWindows(r19) == true) goto L11;
        if (r19.getTop() >= r16) goto L11;
        ViewCompat.offsetTopAndBottom(r19, r16);
    L11:
        r18 = r18 + 1;
    L12:
        int r20 = getChildCount();
        int r21 = 0;
    L13:
        if (r21 >= r20) goto L15;
        getViewOffsetHelper(getChildAt(r21)).onViewLayout();
        r21 = r21 + 1;
        goto L13
    L15:
        updateTextBounds(r11, r12, r13, r14, false);
        updateTitleFromToolbarIfNeeded();
        updateScrimVisibility();
        int r22 = getChildCount();
    L16:
        if (r5 >= r22) goto L18;
        getViewOffsetHelper(getChildAt(r5)).applyOffsets();
        r5 = r5 + 1;
        goto L16
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        ensureToolbar();
        super.onMeasure(r10, r11);
        int r12 = View.MeasureSpec.getMode(r11);
        WindowInsetsCompat r5 = this.lastInsets;
        if (r5 == null) goto L5;
        int r13 = r5.getSystemWindowInsetTop();
    L7:
        if (r12 != 0) goto L9;
    L10:
        if (r13 <= 0) goto L13;
        this.topInsetApplied = r13;
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + r13, BasicMeasure.EXACTLY));
    L13:
        if (this.extraMultilineHeightEnabled == true) goto L15;
    L19:
        ViewGroup r14 = this.toolbar;
        if (r14 == null) goto L28;
        View r15 = this.toolbarDirectChild;
        if (r15 == null) goto L26;
        if (r15 == this) goto L26;
        setMinimumHeight(getHeightWithMargins(r15));
        return;
    L26:
        setMinimumHeight(getHeightWithMargins(r14));
        return;
    L28:
        return;
    L15:
        if (this.collapsingTextHelper.getMaxLines() <= 1) goto L19;
        updateTitleFromToolbarIfNeeded();
        updateTextBounds(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
        int r16 = this.collapsingTextHelper.getExpandedLineCount();
        if (r16 <= 1) goto L19;
        int r17 = r16 - 1;
        this.extraMultilineHeight = r17 * Math.round(this.collapsingTextHelper.getExpandedTextFullHeight());
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.extraMultilineHeight, BasicMeasure.EXACTLY));
        goto L19
    L9:
        if (this.forceApplySystemWindowInsetTop == false) goto L13;
    L5:
        r13 = 0;
        goto L7
    }

    @Override // android.view.View
    public void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        Drawable r13 = this.contentScrim;
        if (r13 == null) goto L6;
        updateContentScrimBounds(r13, r5, r10);
        return;
    }

    public WindowInsetsCompat onWindowInsetChanged(@NonNull WindowInsetsCompat r5) {
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L5;
        WindowInsetsCompat r10 = r5;
    L7:
        if (ObjectsCompat.equals(this.lastInsets, r10) == true) goto L10;
        this.lastInsets = r10;
        requestLayout();
    L10:
        return r5.consumeSystemWindowInsets();
    L5:
        r10 = null;
        goto L7
    }

    public void setCollapsedTitleGravity(int r5) {
        this.collapsingTextHelper.setCollapsedTextGravity(r5);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int r5) {
        this.collapsingTextHelper.setCollapsedTextAppearance(r5);
    }

    public void setCollapsedTitleTextColor(@ColorInt int r5) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(r5));
    }

    public void setCollapsedTitleTextSize(float r5) {
        this.collapsingTextHelper.setCollapsedTextSize(r5);
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface r5) {
        this.collapsingTextHelper.setCollapsedTypeface(r5);
    }

    public void setContentScrim(@Nullable Drawable r5) {
        Drawable r10 = this.contentScrim;
        if (r10 == r5) goto L14;
        Drawable r11 = null;
        if (r10 == null) goto L7;
        r10.setCallback(null);
    L7:
        if (r5 == null) goto L9;
        r11 = r5.mutate();
    L9:
        this.contentScrim = r11;
        if (r11 == null) goto L12;
        updateContentScrimBounds(r11, getWidth(), getHeight());
        this.contentScrim.setCallback(this);
        this.contentScrim.setAlpha(this.scrimAlpha);
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public void setContentScrimColor(@ColorInt int r5) {
        setContentScrim(new ColorDrawable(r5));
    }

    public void setContentScrimResource(@DrawableRes int r5) {
        setContentScrim(ContextCompat.getDrawable(getContext(), r5));
    }

    public void setExpandedTitleColor(@ColorInt int r5) {
        setExpandedTitleTextColor(ColorStateList.valueOf(r5));
    }

    public void setExpandedTitleGravity(int r5) {
        this.collapsingTextHelper.setExpandedTextGravity(r5);
    }

    public void setExpandedTitleMargin(int r5, int r10, int r11, int r12) {
        this.expandedMarginStart = r5;
        this.expandedMarginTop = r10;
        this.expandedMarginEnd = r11;
        this.expandedMarginBottom = r12;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int r5) {
        this.expandedMarginBottom = r5;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int r5) {
        this.expandedMarginEnd = r5;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int r5) {
        this.expandedMarginStart = r5;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int r5) {
        this.expandedMarginTop = r5;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int r5) {
        this.collapsingTextHelper.setExpandedTextAppearance(r5);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList r5) {
        this.collapsingTextHelper.setExpandedTextColor(r5);
    }

    public void setExpandedTitleTextSize(float r5) {
        this.collapsingTextHelper.setExpandedTextSize(r5);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface r5) {
        this.collapsingTextHelper.setExpandedTypeface(r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraMultilineHeightEnabled(boolean r5) {
        this.extraMultilineHeightEnabled = r5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean r5) {
        this.forceApplySystemWindowInsetTop = r5;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHyphenationFrequency(int r5) {
        this.collapsingTextHelper.setHyphenationFrequency(r5);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingAdd(float r5) {
        this.collapsingTextHelper.setLineSpacingAdd(r5);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float r5) {
        this.collapsingTextHelper.setLineSpacingMultiplier(r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int r5) {
        this.collapsingTextHelper.setMaxLines(r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean r5) {
        this.collapsingTextHelper.setRtlTextDirectionHeuristicsEnabled(r5);
    }

    public void setScrimAlpha(int r5) {
        if (r5 != this.scrimAlpha) goto L5;
        return;
    L5:
        if (this.contentScrim == null) goto L9;
        ViewGroup r10 = this.toolbar;
        if (r10 == null) goto L9;
        ViewCompat.postInvalidateOnAnimation(r10);
    L9:
        this.scrimAlpha = r5;
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long r5) {
        this.scrimAnimationDuration = r5;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int r5) {
        if (this.scrimVisibleHeightTrigger == r5) goto L6;
        this.scrimVisibleHeightTrigger = r5;
        updateScrimVisibility();
        return;
    }

    public void setScrimsShown(boolean r5) {
        if (ViewCompat.isLaidOut(this) == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        setScrimsShown(r5, r10);
        return;
    L5:
        if (isInEditMode() == true) goto L7;
        r10 = true;
        goto L8
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStaticLayoutBuilderConfigurer(@Nullable StaticLayoutBuilderConfigurer r5) {
        this.collapsingTextHelper.setStaticLayoutBuilderConfigurer(r5);
    }

    public void setStatusBarScrim(@Nullable Drawable r5) {
        Drawable r10 = this.statusBarScrim;
        if (r10 == r5) goto L21;
        Drawable r11 = null;
        if (r10 == null) goto L7;
        r10.setCallback(null);
    L7:
        if (r5 == null) goto L9;
        r11 = r5.mutate();
    L9:
        this.statusBarScrim = r11;
        if (r11 != null) goto L12;
    L19:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L12:
        if (r11.isStateful() == false) goto L14;
        this.statusBarScrim.setState(getDrawableState());
    L14:
        DrawableCompat.setLayoutDirection(this.statusBarScrim, ViewCompat.getLayoutDirection(this));
        Drawable r12 = this.statusBarScrim;
        if (getVisibility() != 0) goto L17;
        boolean r13 = true;
    L18:
        r12.setVisible(r13, false);
        this.statusBarScrim.setCallback(this);
        this.statusBarScrim.setAlpha(this.scrimAlpha);
        goto L19
    L17:
        r13 = false;
        goto L18
    }

    public void setStatusBarScrimColor(@ColorInt int r5) {
        setStatusBarScrim(new ColorDrawable(r5));
    }

    public void setStatusBarScrimResource(@DrawableRes int r5) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), r5));
    }

    public void setTitle(@Nullable CharSequence r5) {
        this.collapsingTextHelper.setText(r5);
        updateContentDescriptionFromTitle();
    }

    public void setTitleCollapseMode(int r5) {
        this.titleCollapseMode = r5;
        boolean r10 = isTitleCollapseFadeMode();
        this.collapsingTextHelper.setFadeModeEnabled(r10);
        ViewParent r11 = getParent();
        if ((r11 instanceof AppBarLayout) == false) goto L5;
        disableLiftOnScrollIfNeeded((AppBarLayout) r11);
    L5:
        if (r10 == true) goto L7;
        return;
    L7:
        if (this.contentScrim != null) goto L11;
        setContentScrimColor(getDefaultContentScrimColorForTitleCollapseFadeMode());
        return;
    }

    public void setTitleEllipsize(@NonNull TextUtils.TruncateAt r5) {
        this.collapsingTextHelper.setTitleTextEllipsize(r5);
    }

    public void setTitleEnabled(boolean r5) {
        if (r5 == this.collapsingTitleEnabled) goto L6;
        this.collapsingTitleEnabled = r5;
        updateContentDescriptionFromTitle();
        updateDummyView();
        requestLayout();
        return;
    }

    public void setTitlePositionInterpolator(@Nullable TimeInterpolator r5) {
        this.collapsingTextHelper.setPositionInterpolator(r5);
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
        super.setVisibility(r5);
        if (r5 != 0) goto L5;
        boolean r10 = true;
    L6:
        Drawable r11 = this.statusBarScrim;
        if (r11 != null) goto L9;
    L11:
        Drawable r12 = this.contentScrim;
        if (r12 != null) goto L14;
        return;
    L14:
        if (r12.isVisible() == r10) goto L18;
        this.contentScrim.setVisible(r10, false);
        return;
    L18:
        return;
    L9:
        if (r11.isVisible() == r10) goto L11;
        this.statusBarScrim.setVisible(r10, false);
        goto L11
    L5:
        r10 = false;
        goto L6
    }

    public final void updateScrimVisibility() {
        if (this.contentScrim != null) goto L7;
        if (this.statusBarScrim != null) goto L7;
        return;
    L7:
        if ((getHeight() + this.currentOffset) >= getScrimVisibleHeightTrigger()) goto L9;
        boolean r5 = true;
    L10:
        setScrimsShown(r5);
        return;
    L9:
        r5 = false;
        goto L10
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable r5) {
        if (super.verifyDrawable(r5) == false) goto L5;
    L10:
        return true;
    L5:
        if (r5 == this.contentScrim) goto L10;
        if (r5 == this.statusBarScrim) goto L10;
        return false;
    }

    public CollapsingToolbarLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.collapsingToolbarLayoutStyle);
    }

    private void updateContentScrimBounds(@NonNull Drawable r5, @Nullable View r10, int r11, int r12) {
        if (isTitleCollapseFadeMode() == false) goto L8;
        if (r10 == null) goto L8;
        if (this.collapsingTitleEnabled == false) goto L8;
        r12 = r10.getBottom();
    L8:
        r5.setBounds(0, 0, r11, r12);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return generateLayoutParams(r5);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList r5) {
        this.collapsingTextHelper.setCollapsedTextColor(r5);
    }

    public void setScrimsShown(boolean r5, boolean r10) {
        if (this.scrimsAreShown == r5) goto L14;
        int r11 = 0;
        if (r10 == false) goto L9;
        if (r5 == false) goto L8;
        r11 = 255;
    L8:
        animateScrim(r11);
    L12:
        this.scrimsAreShown = r5;
        return;
    L9:
        if (r5 == false) goto L11;
        r11 = 255;
    L11:
        setScrimAlpha(r11);
        goto L12
    }

    public CollapsingToolbarLayout(@NonNull Context r11, @Nullable AttributeSet r12, int r13) {
        int r5 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r11, r12, r13, r5), r12, r13);
        this.refreshToolbar = true;
        this.tmpRect = new Rect();
        this.scrimVisibleHeightTrigger = -1;
        this.topInsetApplied = 0;
        this.extraMultilineHeight = 0;
        Context r10 = getContext();
        CollapsingTextHelper r14 = new CollapsingTextHelper(this);
        this.collapsingTextHelper = r14;
        r14.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
        r14.setRtlTextDirectionHeuristicsEnabled(false);
        this.elevationOverlayProvider = new ElevationOverlayProvider(r10);
        TypedArray r15 = ThemeEnforcement.obtainStyledAttributes(r10, r12, R.styleable.CollapsingToolbarLayout, r13, r5, new int[0]);
        r14.setExpandedTextGravity(r15.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        r14.setCollapsedTextGravity(r15.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int r16 = r15.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.expandedMarginBottom = r16;
        this.expandedMarginEnd = r16;
        this.expandedMarginTop = r16;
        this.expandedMarginStart = r16;
        if (r15.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart) == false) goto L6;
        this.expandedMarginStart = r15.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
    L6:
        if (r15.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd) == false) goto L9;
        this.expandedMarginEnd = r15.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
    L9:
        if (r15.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop) == false) goto L12;
        this.expandedMarginTop = r15.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
    L12:
        if (r15.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom) == false) goto L14;
        this.expandedMarginBottom = r15.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
    L14:
        this.collapsingTitleEnabled = r15.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(r15.getText(R.styleable.CollapsingToolbarLayout_title));
        r14.setExpandedTextAppearance(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        r14.setCollapsedTextAppearance(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (r15.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance) == false) goto L18;
        r14.setExpandedTextAppearance(r15.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
    L18:
        if (r15.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance) == false) goto L21;
        r14.setCollapsedTextAppearance(r15.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
    L21:
        if (r15.hasValue(R.styleable.CollapsingToolbarLayout_titleTextEllipsize) == false) goto L24;
        setTitleEllipsize(convertEllipsizeToTruncateAt(r15.getInt(R.styleable.CollapsingToolbarLayout_titleTextEllipsize, -1)));
    L24:
        if (r15.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextColor) == false) goto L27;
        r14.setExpandedTextColor(MaterialResources.getColorStateList(r10, r15, R.styleable.CollapsingToolbarLayout_expandedTitleTextColor));
    L27:
        if (r15.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextColor) == false) goto L29;
        r14.setCollapsedTextColor(MaterialResources.getColorStateList(r10, r15, R.styleable.CollapsingToolbarLayout_collapsedTitleTextColor));
    L29:
        this.scrimVisibleHeightTrigger = r15.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        if (r15.hasValue(R.styleable.CollapsingToolbarLayout_maxLines) == false) goto L33;
        r14.setMaxLines(r15.getInt(R.styleable.CollapsingToolbarLayout_maxLines, 1));
    L33:
        if (r15.hasValue(R.styleable.CollapsingToolbarLayout_titlePositionInterpolator) == false) goto L35;
        r14.setPositionInterpolator(android.view.animation.AnimationUtils.loadInterpolator(r10, r15.getResourceId(R.styleable.CollapsingToolbarLayout_titlePositionInterpolator, 0)));
    L35:
        this.scrimAnimationDuration = r15.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, DEFAULT_SCRIM_ANIMATION_DURATION);
        this.scrimAnimationFadeInInterpolator = MotionUtils.resolveThemeInterpolator(r10, R.attr.motionEasingStandardInterpolator, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        this.scrimAnimationFadeOutInterpolator = MotionUtils.resolveThemeInterpolator(r10, R.attr.motionEasingStandardInterpolator, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        setContentScrim(r15.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(r15.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        setTitleCollapseMode(r15.getInt(R.styleable.CollapsingToolbarLayout_titleCollapseMode, 0));
        this.toolbarId = r15.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        this.forceApplySystemWindowInsetTop = r15.getBoolean(R.styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
        this.extraMultilineHeightEnabled = r15.getBoolean(R.styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
        r15.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r5) {
        return new LayoutParams(getContext(), r5);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return new LayoutParams(r5);
    }
}
