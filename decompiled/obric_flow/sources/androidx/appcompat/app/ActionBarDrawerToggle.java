package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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

        void setActionBarDescription(@StringRes int r5);

        void setActionBarUpIndicator(Drawable r5, @StringRes int r10);
    }

    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    public static class FrameworkActionBarDelegate implements Delegate {
        private final Activity mActivity;
        private ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;

        @RequiresApi(18)
        public static class Api18Impl {
            private Api18Impl() {
            }

            @DoNotInline
            public static void setHomeActionContentDescription(android.app.ActionBar r5, int r10) {
                r5.setHomeActionContentDescription(r10);
            }

            @DoNotInline
            public static void setHomeAsUpIndicator(android.app.ActionBar r5, Drawable r10) {
                r5.setHomeAsUpIndicator(r10);
            }
        }

        public FrameworkActionBarDelegate(Activity r5) {
            this.mActivity = r5;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            android.app.ActionBar r5 = this.mActivity.getActionBar();
            if (r5 == null) goto L7;
            return r5.getThemedContext();
        L7:
            return this.mActivity;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TypedArray r5 = getActionBarThemedContext().obtainStyledAttributes(null, new int[]{R.attr.homeAsUpIndicator}, R.attr.actionBarStyle, 0);
            Drawable r10 = r5.getDrawable(0);
            r5.recycle();
            return r10;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            android.app.ActionBar r5 = this.mActivity.getActionBar();
            if (r5 != null) goto L5;
        L7:
            return false;
        L5:
            if ((r5.getDisplayOptions() & 4) == 0) goto L7;
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int r5) {
            android.app.ActionBar r10 = this.mActivity.getActionBar();
            if (r10 == null) goto L6;
            Api18Impl.setHomeActionContentDescription(r10, r5);
            return;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable r5, int r10) {
            android.app.ActionBar r11 = this.mActivity.getActionBar();
            if (r11 == null) goto L6;
            Api18Impl.setHomeAsUpIndicator(r11, r5);
            Api18Impl.setHomeActionContentDescription(r11, r10);
            return;
        }
    }

    public static class ToolbarCompatDelegate implements Delegate {
        final CharSequence mDefaultContentDescription;
        final Drawable mDefaultUpIndicator;
        final Toolbar mToolbar;

        public ToolbarCompatDelegate(Toolbar r5) {
            this.mToolbar = r5;
            this.mDefaultUpIndicator = r5.getNavigationIcon();
            this.mDefaultContentDescription = r5.getNavigationContentDescription();
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
        public void setActionBarDescription(@StringRes int r5) {
            if (r5 != 0) goto L4;
            this.mToolbar.setNavigationContentDescription(this.mDefaultContentDescription);
            return;
        L4:
            this.mToolbar.setNavigationContentDescription(r5);
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable r5, @StringRes int r10) {
            this.mToolbar.setNavigationIcon(r5);
            setActionBarDescription(r10);
        }
    }

    public ActionBarDrawerToggle(Activity r10, DrawerLayout r11, @StringRes int r12, @StringRes int r13) {
        this(r10, null, r11, null, r12, r13);
    }

    private void setPosition(float r5) {
        if (r5 != 1.0f) goto L6;
        this.mSlider.setVerticalMirror(true);
    L8:
        this.mSlider.setProgress(r5);
        return;
    L6:
        if (r5 != 0.0f) goto L8;
        this.mSlider.setVerticalMirror(false);
        goto L8
    }

    @NonNull
    public DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.mSlider;
    }

    public Drawable getThemeUpIndicator() {
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

    public void onConfigurationChanged(Configuration r5) {
        if (this.mHasCustomUpIndicator == true) goto L5;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
    L5:
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View r5) {
        setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mOpenDrawerContentDescRes);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View r5) {
        setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mCloseDrawerContentDescRes);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View r5, float r10) {
        if (this.mDrawerSlideAnimationEnabled == false) goto L5;
        setPosition(Math.min(1.0f, Math.max(0.0f, r10)));
        return;
    L5:
        setPosition(0.0f);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int r5) {
    }

    public boolean onOptionsItemSelected(MenuItem r5) {
        if (r5 != null) goto L4;
        return false;
    L4:
        if (r5.getItemId() == 16908332) goto L6;
        return false;
    L6:
        if (this.mDrawerIndicatorEnabled == false) goto L12;
        toggle();
        return true;
    L12:
        return false;
    }

    public void setActionBarDescription(int r5) {
        this.mActivityImpl.setActionBarDescription(r5);
    }

    public void setActionBarUpIndicator(Drawable r5, int r10) {
        if (this.mWarnedForDisplayHomeAsUp == false) goto L5;
    L7:
        this.mActivityImpl.setActionBarUpIndicator(r5, r10);
        return;
    L5:
        if (this.mActivityImpl.isNavigationVisible() == true) goto L7;
        Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
        this.mWarnedForDisplayHomeAsUp = true;
        goto L7
    }

    public void setDrawerArrowDrawable(@NonNull DrawerArrowDrawable r5) {
        this.mSlider = r5;
        syncState();
    }

    public void setDrawerIndicatorEnabled(boolean r5) {
        if (r5 == this.mDrawerIndicatorEnabled) goto L13;
        if (r5 == false) goto L10;
        DrawerArrowDrawable r10 = this.mSlider;
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L8;
        int r11 = this.mCloseDrawerContentDescRes;
    L9:
        setActionBarUpIndicator(r10, r11);
    L11:
        this.mDrawerIndicatorEnabled = r5;
        return;
    L8:
        r11 = this.mOpenDrawerContentDescRes;
        goto L9
    L10:
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        goto L11
    }

    public void setDrawerSlideAnimationEnabled(boolean r5) {
        this.mDrawerSlideAnimationEnabled = r5;
        if (r5 == true) goto L6;
        setPosition(0.0f);
        return;
    }

    public void setHomeAsUpIndicator(Drawable r5) {
        if (r5 != null) goto L5;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mHasCustomUpIndicator = false;
    L7:
        if (this.mDrawerIndicatorEnabled == true) goto L10;
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        return;
    L10:
        return;
    L5:
        this.mHomeAsUpIndicator = r5;
        this.mHasCustomUpIndicator = true;
        goto L7
    }

    public void setToolbarNavigationClickListener(View.OnClickListener r5) {
        this.mToolbarNavigationClickListener = r5;
    }

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L5;
        setPosition(1.0f);
    L7:
        if (this.mDrawerIndicatorEnabled == false) goto L14;
        DrawerArrowDrawable r5 = this.mSlider;
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L11;
        int r10 = this.mCloseDrawerContentDescRes;
    L12:
        setActionBarUpIndicator(r5, r10);
        return;
    L11:
        r10 = this.mOpenDrawerContentDescRes;
        goto L12
    L14:
        return;
    L5:
        setPosition(0.0f);
        goto L7
    }

    public void toggle() {
        int r5 = this.mDrawerLayout.getDrawerLockMode(GravityCompat.START);
        if (this.mDrawerLayout.isDrawerVisible(GravityCompat.START) == false) goto L8;
        if (r5 == 2) goto L8;
        this.mDrawerLayout.closeDrawer(GravityCompat.START);
        return;
    L8:
        if (r5 == 1) goto L12;
        this.mDrawerLayout.openDrawer(GravityCompat.START);
        return;
    }

    public ActionBarDrawerToggle(Activity r10, DrawerLayout r11, Toolbar r12, @StringRes int r13, @StringRes int r14) {
        this(r10, r12, r11, null, r13, r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionBarDrawerToggle(Activity r5, Toolbar r10, DrawerLayout r11, DrawerArrowDrawable r12, @StringRes int r13, @StringRes int r14) {
        this.mDrawerSlideAnimationEnabled = true;
        this.mDrawerIndicatorEnabled = true;
        this.mWarnedForDisplayHomeAsUp = false;
        if (r10 == null) goto L6;
        this.mActivityImpl = new ToolbarCompatDelegate(r10);
        r10.setNavigationOnClickListener(new AnonymousClass1(this));
    L9:
        this.mDrawerLayout = r11;
        this.mOpenDrawerContentDescRes = r13;
        this.mCloseDrawerContentDescRes = r14;
        if (r12 != null) goto L12;
        this.mSlider = new DrawerArrowDrawable(this.mActivityImpl.getActionBarThemedContext());
    L13:
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        return;
    L12:
        this.mSlider = r12;
        goto L13
    L6:
        if ((r5 instanceof DelegateProvider) == false) goto L8;
        this.mActivityImpl = ((DelegateProvider) r5).getDrawerToggleDelegate();
        goto L9
    L8:
        this.mActivityImpl = new FrameworkActionBarDelegate(r5);
        goto L9
    }

    public void setHomeAsUpIndicator(int r5) {
        if (r5 == 0) goto L4;
        Drawable r10 = this.mDrawerLayout.getResources().getDrawable(r5);
    L5:
        setHomeAsUpIndicator(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }
}
