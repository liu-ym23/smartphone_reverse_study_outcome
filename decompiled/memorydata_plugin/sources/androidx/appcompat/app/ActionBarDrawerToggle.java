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
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

        void setActionBarDescription(int r1);

        void setActionBarUpIndicator(Drawable r1, int r2);
    }

    public interface DelegateProvider {
        Delegate getDrawerToggleDelegate();
    }

    private static class FrameworkActionBarDelegate implements Delegate {
        private final Activity mActivity;
        private ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;

        static class Api18Impl {
            private Api18Impl() {
            }

            static void setHomeActionContentDescription(android.app.ActionBar r0, int r1) {
                r0.setHomeActionContentDescription(r1);
            }

            static void setHomeAsUpIndicator(android.app.ActionBar r0, Drawable r1) {
                r0.setHomeAsUpIndicator(r1);
            }
        }

        FrameworkActionBarDelegate(Activity r3) {
            this.mActivity = ZeusTransformUtils.wrapperContext2Activity((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            android.app.ActionBar r0 = this.mActivity.getActionBar();
            if (r0 == null) goto L7;
            return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getThemedContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        L7:
            return this.mActivity;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            if (Build.VERSION.SDK_INT < 18) goto L7;
            TypedArray r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActionBarThemedContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(null, new int[]{R.attr.homeAsUpIndicator}, R.attr.actionBarStyle, 0);
            Drawable r0 = r4.getDrawable(0);
            r4.recycle();
            return r0;
        L7:
            return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.mActivity);
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            android.app.ActionBar r0 = this.mActivity.getActionBar();
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if ((r0.getDisplayOptions() & 4) == 0) goto L7;
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int r3) {
            if (Build.VERSION.SDK_INT < 18) goto L7;
            android.app.ActionBar r2 = this.mActivity.getActionBar();
            if (r2 == null) goto L9;
            Api18Impl.setHomeActionContentDescription(r2, r3);
            return;
        L9:
            return;
        L7:
            this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, r3);
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable r4, int r5) {
            android.app.ActionBar r0 = this.mActivity.getActionBar();
            if (r0 != null) goto L5;
            return;
        L5:
            if (Build.VERSION.SDK_INT < 18) goto L7;
            Api18Impl.setHomeAsUpIndicator(r0, r4);
            Api18Impl.setHomeActionContentDescription(r0, r5);
            return;
        L7:
            r0.setDisplayShowHomeEnabled(true);
            this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(this.mActivity, r4, r5);
            r0.setDisplayShowHomeEnabled(false);
        }
    }

    static class ToolbarCompatDelegate implements Delegate {
        final CharSequence mDefaultContentDescription;
        final Drawable mDefaultUpIndicator;
        final Toolbar mToolbar;

        ToolbarCompatDelegate(Toolbar r2) {
            this.mToolbar = r2;
            this.mDefaultUpIndicator = r2.getNavigationIcon();
            this.mDefaultContentDescription = r2.getNavigationContentDescription();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mToolbar.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
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
        public void setActionBarDescription(int r1) {
            if (r1 != 0) goto L4;
            this.mToolbar.setNavigationContentDescription(this.mDefaultContentDescription);
            return;
        L4:
            this.mToolbar.setNavigationContentDescription(r1);
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable r2, int r3) {
            this.mToolbar.setNavigationIcon(r2);
            setActionBarDescription(r3);
        }
    }

    ActionBarDrawerToggle(Activity r3, Toolbar r4, DrawerLayout r5, DrawerArrowDrawable r6, int r7, int r8) {
        Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        this.mDrawerSlideAnimationEnabled = true;
        this.mDrawerIndicatorEnabled = true;
        this.mWarnedForDisplayHomeAsUp = false;
        if (r4 == null) goto L6;
        this.mActivityImpl = new ToolbarCompatDelegate(r4);
        r4.setNavigationOnClickListener(new AnonymousClass1(this));
    L9:
        this.mDrawerLayout = r5;
        this.mOpenDrawerContentDescRes = r7;
        this.mCloseDrawerContentDescRes = r8;
        if (r6 != null) goto L12;
        this.mSlider = new DrawerArrowDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mActivityImpl.getActionBarThemedContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L13:
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        return;
    L12:
        this.mSlider = r6;
        goto L13
    L6:
        if (ZeusTransformUtils.instanceOf(r9, DelegateProvider.class) == false) goto L8;
        this.mActivityImpl = ((DelegateProvider) ZeusTransformUtils.preCheckCast(r9, DelegateProvider.class, "com.obric.memorydata.plugin")).getDrawerToggleDelegate();
        goto L9
    L8:
        this.mActivityImpl = new FrameworkActionBarDelegate(r9);
        goto L9
    }

    public ActionBarDrawerToggle(Activity r8, DrawerLayout r9, int r10, int r11) {
        this((Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.memorydata.plugin"), null, r9, null, r10, r11);
    }

    public ActionBarDrawerToggle(Activity r8, DrawerLayout r9, Toolbar r10, int r11, int r12) {
        this((Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.memorydata.plugin"), r10, r9, null, r11, r12);
    }

    private void setPosition(float r3) {
        if (r3 != 1.0f) goto L7;
        DrawerArrowDrawable r0 = this.mSlider;
        boolean r1 = true;
    L5:
        r0.setVerticalMirror(r1);
    L9:
        this.mSlider.setProgress(r3);
        return;
    L7:
        if (r3 != 0.0f) goto L9;
        r0 = this.mSlider;
        r1 = false;
        goto L5
    }

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

    public void onConfigurationChanged(Configuration r1) {
        if (this.mHasCustomUpIndicator == true) goto L5;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
    L5:
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View r1) {
        setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mOpenDrawerContentDescRes);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View r1) {
        setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mCloseDrawerContentDescRes);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View r2, float r3) {
        if (this.mDrawerSlideAnimationEnabled == false) goto L5;
        setPosition(Math.min(1.0f, Math.max(0.0f, r3)));
        return;
    L5:
        setPosition(0.0f);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int r1) {
    }

    public boolean onOptionsItemSelected(MenuItem r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.getItemId() == 16908332) goto L7;
        return false;
    L7:
        if (this.mDrawerIndicatorEnabled == false) goto L13;
        toggle();
        return true;
    L13:
        return false;
    }

    void setActionBarDescription(int r1) {
        this.mActivityImpl.setActionBarDescription(r1);
    }

    void setActionBarUpIndicator(Drawable r3, int r4) {
        if (this.mWarnedForDisplayHomeAsUp == false) goto L5;
    L7:
        this.mActivityImpl.setActionBarUpIndicator(r3, r4);
        return;
    L5:
        if (this.mActivityImpl.isNavigationVisible() == true) goto L7;
        Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
        this.mWarnedForDisplayHomeAsUp = true;
        goto L7
    }

    public void setDrawerArrowDrawable(DrawerArrowDrawable r1) {
        this.mSlider = r1;
        syncState();
    }

    public void setDrawerIndicatorEnabled(boolean r4) {
        if (r4 == this.mDrawerIndicatorEnabled) goto L12;
        if (r4 == false) goto L9;
        Drawable r0 = this.mSlider;
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L8;
        int r1 = this.mCloseDrawerContentDescRes;
    L10:
        setActionBarUpIndicator(r0, r1);
        this.mDrawerIndicatorEnabled = r4;
        return;
    L8:
        r1 = this.mOpenDrawerContentDescRes;
        goto L10
    L9:
        r0 = this.mHomeAsUpIndicator;
        r1 = 0;
        goto L10
    }

    public void setDrawerSlideAnimationEnabled(boolean r1) {
        this.mDrawerSlideAnimationEnabled = r1;
        if (r1 == true) goto L6;
        setPosition(0.0f);
        return;
    }

    public void setHomeAsUpIndicator(int r3) {
        if (r3 == 0) goto L4;
        Drawable r4 = ZeusTransformUtils.getResources(this.mDrawerLayout, "com.obric.memorydata.plugin").getDrawable(r3);
    L5:
        setHomeAsUpIndicator(r4);
        return;
    L4:
        r4 = null;
        goto L5
    }

    public void setHomeAsUpIndicator(Drawable r2) {
        if (r2 != null) goto L5;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mHasCustomUpIndicator = false;
    L7:
        if (this.mDrawerIndicatorEnabled == true) goto L10;
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        return;
    L10:
        return;
    L5:
        this.mHomeAsUpIndicator = r2;
        this.mHasCustomUpIndicator = true;
        goto L7
    }

    public void setToolbarNavigationClickListener(View.OnClickListener r3) {
        this.mToolbarNavigationClickListener = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
    }

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L5;
        float r0 = 1.0f;
    L6:
        setPosition(r0);
        if (this.mDrawerIndicatorEnabled == false) goto L14;
        DrawerArrowDrawable r1 = this.mSlider;
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L11;
        int r2 = this.mCloseDrawerContentDescRes;
    L12:
        setActionBarUpIndicator(r1, r2);
        return;
    L11:
        r2 = this.mOpenDrawerContentDescRes;
        goto L12
    L14:
        return;
    L5:
        r0 = 0.0f;
        goto L6
    }

    void toggle() {
        int r0 = this.mDrawerLayout.getDrawerLockMode(GravityCompat.START);
        if (this.mDrawerLayout.isDrawerVisible(GravityCompat.START) == false) goto L8;
        if (r0 == 2) goto L8;
        this.mDrawerLayout.closeDrawer(GravityCompat.START);
        return;
    L8:
        if (r0 == 1) goto L12;
        this.mDrawerLayout.openDrawer(GravityCompat.START);
        return;
    }
}
