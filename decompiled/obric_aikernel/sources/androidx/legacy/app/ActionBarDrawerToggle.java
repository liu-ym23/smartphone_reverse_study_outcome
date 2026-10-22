package androidx.legacy.app;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    private static final int ID_HOME = 16908332;
    private static final String TAG = "ActionBarDrawerToggle";
    private static final int[] THEME_ATTRS = null;
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334f;
    final Activity mActivity;
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private SetIndicatorInfo mSetIndicatorInfo;
    private SlideDrawable mSlider;

    @Deprecated
    public interface Delegate {
        @Nullable
        Drawable getThemeUpIndicator();

        void setActionBarDescription(@StringRes int r10);

        void setActionBarUpIndicator(Drawable r10, @StringRes int r11);
    }

    @Deprecated
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    private static class SetIndicatorInfo {
        Method mSetHomeActionContentDescription;
        Method mSetHomeAsUpIndicator;
        ImageView mUpIndicatorView;

        SetIndicatorInfo(Activity r10) {
            this.mSetHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});     // Catch: NoSuchMethodException -> L5
            this.mSetHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            View r11 = r10.findViewById(16908332);
            if (r11 != null) goto L8;
            return;
        L8:
            ViewGroup r12 = (ViewGroup) r11.getParent();
            if (r12.getChildCount() == 2) goto L11;
            return;
        L11:
            View r13 = r12.getChildAt(0);
            View r14 = r12.getChildAt(1);
            if (r13.getId() != 16908332) goto L15;
            r13 = r14;
        L15:
            if ((r13 instanceof ImageView) == false) goto L20;
            this.mUpIndicatorView = (ImageView) r13;
            return;
        }
    }

    private class SlideDrawable extends InsetDrawable {
        private final boolean mHasMirroring;
        private float mOffset;
        private float mPosition;
        private final Rect mTmpRect;
        final /* synthetic */ ActionBarDrawerToggle this$0;

        SlideDrawable(ActionBarDrawerToggle r10, Drawable r11) {
            this.this$0 = r10;
            boolean r12 = false;
            super(r11, 0);
            if (Build.VERSION.SDK_INT <= 18) goto L5;
            r12 = true;
        L5:
            this.mHasMirroring = r12;
            this.mTmpRect = new Rect();
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas r10) {
            copyBounds(this.mTmpRect);
            r10.save();
            int r11 = 1;
            if (ViewCompat.getLayoutDirection(this.this$0.mActivity.getWindow().getDecorView()) != 1) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L8;
            r11 = -1;
        L8:
            float r13 = this.mTmpRect.width();
            r10.translate((((-this.mOffset) * r13) * this.mPosition) * r11, 0.0f);
            if (r12 == true) goto L11;
        L13:
            super.draw(r10);
            r10.restore();
            return;
        L11:
            if (this.mHasMirroring == true) goto L13;
            r10.translate(r13, 0.0f);
            r10.scale(-1.0f, 1.0f);
            goto L13
        L5:
            r12 = false;
            goto L6
        }

        public float getPosition() {
            return this.mPosition;
        }

        public void setOffset(float r10) {
            this.mOffset = r10;
            invalidateSelf();
        }

        public void setPosition(float r10) {
            this.mPosition = r10;
            invalidateSelf();
        }
    }

    static {
        THEME_ATTRS = new int[]{R.attr.homeAsUpIndicator};
    }

    public ActionBarDrawerToggle(Activity r10, DrawerLayout r11, @DrawableRes int r12, @StringRes int r13, @StringRes int r14) {
        this(r10, r11, !assumeMaterial(r10), r12, r13, r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionBarDrawerToggle(Activity r10, DrawerLayout r11, boolean r12, @DrawableRes int r13, @StringRes int r14, @StringRes int r15) {
        this.mDrawerIndicatorEnabled = true;
        this.mActivity = r10;
        if ((r10 instanceof DelegateProvider) == false) goto L5;
        Delegate r16 = ((DelegateProvider) r10).getDrawerToggleDelegate();
    L6:
        this.mActivityImpl = r16;
        this.mDrawerLayout = r11;
        this.mDrawerImageResource = r13;
        this.mOpenDrawerContentDescRes = r14;
        this.mCloseDrawerContentDescRes = r15;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mDrawerImage = ContextCompat.getDrawable(r10, r13);
        SlideDrawable r17 = new SlideDrawable(this, this.mDrawerImage);
        this.mSlider = r17;
        if (r12 == false) goto L9;
        float r18 = TOGGLE_DRAWABLE_OFFSET;
    L10:
        r17.setOffset(r18);
        return;
    L9:
        r18 = 0.0f;
        goto L10
    L5:
        r16 = null;
        goto L6
    }

    private static boolean assumeMaterial(Context r10) {
        if (r10.getApplicationInfo().targetSdkVersion >= 21) goto L5;
    L7:
        return false;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return true;
    }

    private Drawable getThemeUpIndicator() {
        Delegate r10 = this.mActivityImpl;
        if (r10 == null) goto L7;
        return r10.getThemeUpIndicator();
    L7:
        if (Build.VERSION.SDK_INT < 18) goto L15;
        ActionBar r11 = this.mActivity.getActionBar();
        if (r11 == null) goto L11;
        Context r12 = r11.getThemedContext();
    L12:
        TypedArray r13 = r12.obtainStyledAttributes(null, THEME_ATTRS, R.attr.actionBarStyle, 0);
    L13:
        Drawable r14 = r13.getDrawable(0);
        r13.recycle();
        return r14;
    L11:
        r12 = this.mActivity;
        goto L12
    L15:
        r13 = this.mActivity.obtainStyledAttributes(THEME_ATTRS);
        goto L13
    }

    private void setActionBarDescription(int r10) {
        Delegate r11 = this.mActivityImpl;
        if (r11 == null) goto L7;
        r11.setActionBarDescription(r10);
        return;
    L7:
        if (Build.VERSION.SDK_INT < 18) goto L12;
        ActionBar r12 = this.mActivity.getActionBar();
        if (r12 == null) goto L23;
        r12.setHomeActionContentDescription(r10);
        return;
    L23:
        return;
    L12:
        if (this.mSetIndicatorInfo != null) goto L15;
        this.mSetIndicatorInfo = new SetIndicatorInfo(this.mActivity);
    L15:
        if (this.mSetIndicatorInfo.mSetHomeAsUpIndicator == null) goto L25;
        ActionBar r13 = this.mActivity.getActionBar();     // Catch: Exception -> L18
        this.mSetIndicatorInfo.mSetHomeActionContentDescription.invoke(r13, new Object[]{Integer.valueOf(r10)});     // Catch: Exception -> L18
        r13.setSubtitle(r13.getSubtitle());     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        Log.w(TAG, "Couldn't set content description via JB-MR2 API", e);
        return;
    }

    private void setActionBarUpIndicator(Drawable r10, int r11) {
        Delegate r12 = this.mActivityImpl;
        if (r12 == null) goto L7;
        r12.setActionBarUpIndicator(r10, r11);
        return;
    L7:
        if (Build.VERSION.SDK_INT < 18) goto L12;
        ActionBar r13 = this.mActivity.getActionBar();
        if (r13 == null) goto L27;
        r13.setHomeAsUpIndicator(r10);
        r13.setHomeActionContentDescription(r11);
        return;
    L27:
        return;
    L12:
        if (this.mSetIndicatorInfo != null) goto L14;
        this.mSetIndicatorInfo = new SetIndicatorInfo(this.mActivity);
    L14:
        SetIndicatorInfo r14 = this.mSetIndicatorInfo;
        if (r14.mSetHomeAsUpIndicator != null) goto L25;
        ImageView r15 = r14.mUpIndicatorView;
        if (r15 == null) goto L23;
        r15.setImageDrawable(r10);
        return;
    L23:
        Log.w(TAG, "Couldn't set home-as-up indicator");
        return;
    L25:
        ActionBar r16 = this.mActivity.getActionBar();     // Catch: Exception -> L18
        this.mSetIndicatorInfo.mSetHomeAsUpIndicator.invoke(r16, new Object[]{r10});     // Catch: Exception -> L18
        this.mSetIndicatorInfo.mSetHomeActionContentDescription.invoke(r16, new Object[]{Integer.valueOf(r11)});     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        Log.w(TAG, "Couldn't set home-as-up indicator via JB-MR2 API", e);
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(Configuration r10) {
        if (this.mHasCustomUpIndicator == true) goto L5;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
    L5:
        this.mDrawerImage = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View r10) {
        this.mSlider.setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mOpenDrawerContentDescRes);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View r10) {
        this.mSlider.setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mCloseDrawerContentDescRes);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View r10, float r11) {
        float r12 = this.mSlider.getPosition();
        if (r11 <= 0.5f) goto L5;
        float r13 = Math.max(r12, Math.max(0.0f, r11 - 0.5f) * 2.0f);
    L6:
        this.mSlider.setPosition(r13);
        return;
    L5:
        r13 = Math.min(r12, r11 * 2.0f);
        goto L6
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
        if (this.mDrawerIndicatorEnabled == false) goto L17;
        boolean r11 = this.mDrawerLayout.isDrawerVisible(GravityCompat.START);
        DrawerLayout r12 = this.mDrawerLayout;
        if (r11 == false) goto L10;
        r12.closeDrawer(GravityCompat.START);
        return true;
    L10:
        r12.openDrawer(GravityCompat.START);
        return true;
    L17:
        return false;
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

    public void setHomeAsUpIndicator(int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = ContextCompat.getDrawable(this.mActivity, r10);
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

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L5;
        SlideDrawable r10 = this.mSlider;
        float r11 = 1.0f;
    L6:
        r10.setPosition(r11);
        if (this.mDrawerIndicatorEnabled == false) goto L14;
        SlideDrawable r12 = this.mSlider;
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L11;
        int r13 = this.mCloseDrawerContentDescRes;
    L12:
        setActionBarUpIndicator(r12, r13);
        return;
    L11:
        r13 = this.mOpenDrawerContentDescRes;
        goto L12
    L14:
        return;
    L5:
        r10 = this.mSlider;
        r11 = 0.0f;
        goto L6
    }
}
