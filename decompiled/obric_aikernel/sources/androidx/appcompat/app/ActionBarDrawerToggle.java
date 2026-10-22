package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mDrawerSlideAnimationEnabled;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private DrawerArrowDrawable mSlider;
    View.OnClickListener mToolbarNavigationClickListener;
    private boolean mWarnedForDisplayHomeAsUp;

    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(@StringRes int r10);

        void setActionBarUpIndicator(Drawable r10, @StringRes int r11);
    }

    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    private static class FrameworkActionBarDelegate implements Delegate {
        private final Activity mActivity;
        private ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;

        @RequiresApi(18)
        static class Api18Impl {
            private Api18Impl() {
            }

            @DoNotInline
            static void setHomeActionContentDescription(android.app.ActionBar r10, int r11) {
                r10.setHomeActionContentDescription(r11);
            }

            @DoNotInline
            static void setHomeAsUpIndicator(android.app.ActionBar r10, Drawable r11) {
                r10.setHomeAsUpIndicator(r11);
            }
        }

        FrameworkActionBarDelegate(Activity r10) {
            this.mActivity = r10;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            android.app.ActionBar r10 = this.mActivity.getActionBar();
            if (r10 == null) goto L7;
            return r10.getThemedContext();
        L7:
            return this.mActivity;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            if (Build.VERSION.SDK_INT < 18) goto L7;
            TypedArray r10 = getActionBarThemedContext().obtainStyledAttributes(null, new int[]{R.attr.homeAsUpIndicator}, R.attr.actionBarStyle, 0);
            Drawable r11 = r10.getDrawable(0);
            r10.recycle();
            return r11;
        L7:
            return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.mActivity);
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            android.app.ActionBar r10 = this.mActivity.getActionBar();
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if ((r10.getDisplayOptions() & 4) == 0) goto L7;
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int r10) {
            if (Build.VERSION.SDK_INT < 18) goto L7;
            android.app.ActionBar r11 = this.mActivity.getActionBar();
            if (r11 == null) goto L9;
            Api18Impl.setHomeActionContentDescription(r11, r10);
            return;
        L9:
            return;
        L7:
            this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, r10);
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable r10, int r11) {
            android.app.ActionBar r12 = this.mActivity.getActionBar();
            if (r12 != null) goto L5;
            return;
        L5:
            if (Build.VERSION.SDK_INT < 18) goto L7;
            Api18Impl.setHomeAsUpIndicator(r12, r10);
            Api18Impl.setHomeActionContentDescription(r12, r11);
            return;
        L7:
            r12.setDisplayShowHomeEnabled(true);
            this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(this.mActivity, r10, r11);
            r12.setDisplayShowHomeEnabled(false);
        }
    }

    static class ToolbarCompatDelegate implements Delegate {
        final CharSequence mDefaultContentDescription;
        final Drawable mDefaultUpIndicator;
        final Toolbar mToolbar;

        ToolbarCompatDelegate(Toolbar r10) {
            this.mToolbar = r10;
            this.mDefaultUpIndicator = r10.getNavigationIcon();
            this.mDefaultContentDescription = r10.getNavigationContentDescription();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return this.mToolbar.getContext();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            return this.mDefaultUpIndicator;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(@StringRes int r10) {
            if (r10 != 0) goto L4;
            this.mToolbar.setNavigationContentDescription(this.mDefaultContentDescription);
            return;
        L4:
            this.mToolbar.setNavigationContentDescription(r10);
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable r10, @StringRes int r11) {
            this.mToolbar.setNavigationIcon(r10);
            setActionBarDescription(r11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    ActionBarDrawerToggle(Activity r10, Toolbar r11, DrawerLayout r12, DrawerArrowDrawable r13, @StringRes int r14, @StringRes int r15) {
        this.mDrawerSlideAnimationEnabled = true;
        this.mDrawerIndicatorEnabled = true;
        this.mWarnedForDisplayHomeAsUp = false;
        if (r11 == null) goto L6;
        this.mActivityImpl = new ToolbarCompatDelegate(r11);
        r11.setNavigationOnClickListener(new AnonymousClass1(this));
    L9:
        this.mDrawerLayout = r12;
        this.mOpenDrawerContentDescRes = r14;
        this.mCloseDrawerContentDescRes = r15;
        if (r13 != null) goto L12;
        this.mSlider = new DrawerArrowDrawable(this.mActivityImpl.getActionBarThemedContext());
    L13:
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        return;
    L12:
        this.mSlider = r13;
        goto L13
    L6:
        if ((r10 instanceof DelegateProvider) == false) goto L8;
        this.mActivityImpl = ((DelegateProvider) r10).getDrawerToggleDelegate();
        goto L9
    L8:
        this.mActivityImpl = new FrameworkActionBarDelegate(r10);
        goto L9
    }

    public ActionBarDrawerToggle(Activity r10, DrawerLayout r11, @StringRes int r12, @StringRes int r13) {
        this(r10, null, r11, null, r12, r13);
    }

    public ActionBarDrawerToggle(Activity r10, DrawerLayout r11, Toolbar r12, @StringRes int r13, @StringRes int r14) {
        this(r10, r12, r11, null, r13, r14);
    }

    private void setPosition(float r10) {
        if (r10 != 1.0f) goto L7;
        DrawerArrowDrawable r11 = this.mSlider;
        boolean r12 = true;
    L5:
        r11.setVerticalMirror(r12);
    L9:
        this.mSlider.setProgress(r10);
        return;
    L7:
        if (r10 != 0.0f) goto L9;
        r11 = this.mSlider;
        r12 = false;
        goto L5
    }

    @NonNull
    public DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.mSlider;
    }

    Drawable getThemeUpIndicator() {
        return this.mActivityImpl.getThemeUpIndicator();
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        return this.mToolbarNavigationClickListener;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public boolean isDrawerSlideAnimationEnabled() {
        return this.mDrawerSlideAnimationEnabled;
    }

    public void onConfigurationChanged(Configuration r10) {
        if (this.mHasCustomUpIndicator == true) goto L5;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
    L5:
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View r10) {
        setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mOpenDrawerContentDescRes);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View r10) {
        setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mCloseDrawerContentDescRes);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View r10, float r11) {
        if (this.mDrawerSlideAnimationEnabled == false) goto L5;
        setPosition(Math.min(1.0f, Math.max(0.0f, r11)));
        return;
    L5:
        setPosition(0.0f);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int r10) {
    }

    public boolean onOptionsItemSelected(MenuItem r10) {
        if (r10 != null) goto L4;
        return false;
    L4:
        if (r10.getItemId() == 16908332) goto L6;
        return false;
    L6:
        if (this.mDrawerIndicatorEnabled == false) goto L12;
        toggle();
        return true;
    L12:
        return false;
    }

    void setActionBarDescription(int r10) {
        this.mActivityImpl.setActionBarDescription(r10);
    }

    void setActionBarUpIndicator(Drawable r10, int r11) {
        if (this.mWarnedForDisplayHomeAsUp == false) goto L5;
    L7:
        this.mActivityImpl.setActionBarUpIndicator(r10, r11);
        return;
    L5:
        if (this.mActivityImpl.isNavigationVisible() == true) goto L7;
        Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
        this.mWarnedForDisplayHomeAsUp = true;
        goto L7
    }

    public void setDrawerArrowDrawable(@NonNull DrawerArrowDrawable r10) {
        this.mSlider = r10;
        syncState();
    }

    public void setDrawerIndicatorEnabled(boolean r10) {
        if (r10 == this.mDrawerIndicatorEnabled) goto L12;
        if (r10 == false) goto L9;
        Drawable r11 = this.mSlider;
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L8;
        int r12 = this.mCloseDrawerContentDescRes;
    L10:
        setActionBarUpIndicator(r11, r12);
        this.mDrawerIndicatorEnabled = r10;
        return;
    L8:
        r12 = this.mOpenDrawerContentDescRes;
        goto L10
    L9:
        r11 = this.mHomeAsUpIndicator;
        r12 = 0;
        goto L10
    }

    public void setDrawerSlideAnimationEnabled(boolean r10) {
        this.mDrawerSlideAnimationEnabled = r10;
        if (r10 == true) goto L6;
        setPosition(0.0f);
        return;
    }

    public void setHomeAsUpIndicator(int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = this.mDrawerLayout.getResources().getDrawable(r10);
    L5:
        setHomeAsUpIndicator(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setHomeAsUpIndicator(Drawable r10) {
        if (r10 != null) goto L5;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mHasCustomUpIndicator = false;
    L7:
        if (this.mDrawerIndicatorEnabled == true) goto L10;
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        return;
    L10:
        return;
    L5:
        this.mHomeAsUpIndicator = r10;
        this.mHasCustomUpIndicator = true;
        goto L7
    }

    public void setToolbarNavigationClickListener(View.OnClickListener r10) {
        this.mToolbarNavigationClickListener = r10;
    }

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L5;
        float r10 = 1.0f;
    L6:
        setPosition(r10);
        if (this.mDrawerIndicatorEnabled == false) goto L14;
        DrawerArrowDrawable r11 = this.mSlider;
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L11;
        int r12 = this.mCloseDrawerContentDescRes;
    L12:
        setActionBarUpIndicator(r11, r12);
        return;
    L11:
        r12 = this.mOpenDrawerContentDescRes;
        goto L12
    L14:
        return;
    L5:
        r10 = 0.0f;
        goto L6
    }

    void toggle() {
        int r10 = this.mDrawerLayout.getDrawerLockMode(GravityCompat.START);
        if (this.mDrawerLayout.isDrawerVisible(GravityCompat.START) == false) goto L8;
        if (r10 == 2) goto L8;
        this.mDrawerLayout.closeDrawer(GravityCompat.START);
        return;
    L8:
        if (r10 == 1) goto L12;
        this.mDrawerLayout.openDrawer(GravityCompat.START);
        return;
    }
}
