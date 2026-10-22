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

        void setActionBarDescription(@StringRes int r5);

        void setActionBarUpIndicator(Drawable r5, @StringRes int r10);
    }

    @Deprecated
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    public static class SetIndicatorInfo {
        Method mSetHomeActionContentDescription;
        Method mSetHomeAsUpIndicator;
        ImageView mUpIndicatorView;

        public SetIndicatorInfo(Activity r5) {
            this.mSetHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});     // Catch: NoSuchMethodException -> L5
            this.mSetHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            View r10 = r5.findViewById(16908332);
            if (r10 != null) goto L8;
            return;
        L8:
            ViewGroup r11 = (ViewGroup) r10.getParent();
            if (r11.getChildCount() == 2) goto L11;
            return;
        L11:
            View r12 = r11.getChildAt(0);
            View r13 = r11.getChildAt(1);
            if (r12.getId() != 16908332) goto L15;
            r12 = r13;
        L15:
            if ((r12 instanceof ImageView) == false) goto L20;
            this.mUpIndicatorView = (ImageView) r12;
            return;
        }
    }

    public class SlideDrawable extends InsetDrawable implements Drawable.Callback {
        private final boolean mHasMirroring;
        private float mOffset;
        private float mPosition;
        private final Rect mTmpRect;
        final /* synthetic */ ActionBarDrawerToggle this$0;

        public SlideDrawable(ActionBarDrawerToggle r5, Drawable r10) {
            this.this$0 = r5;
            super(r10, 0);
            this.mHasMirroring = true;
            this.mTmpRect = new Rect();
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas r10) {
            copyBounds(this.mTmpRect);
            r10.save();
            int r5 = 1;
            if (ViewCompat.getLayoutDirection(this.this$0.mActivity.getWindow().getDecorView()) != 1) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L8;
            r5 = -1;
        L8:
            float r12 = this.mTmpRect.width();
            r10.translate((((-this.mOffset) * r12) * this.mPosition) * r5, 0.0f);
            if (r11 == true) goto L11;
        L13:
            super.draw(r10);
            r10.restore();
            return;
        L11:
            if (this.mHasMirroring == true) goto L13;
            r10.translate(r12, 0.0f);
            r10.scale(-1.0f, 1.0f);
            goto L13
        L5:
            r11 = false;
            goto L6
        }

        public float getPosition() {
            return this.mPosition;
        }

        public void setOffset(float r5) {
            this.mOffset = r5;
            invalidateSelf();
        }

        public void setPosition(float r5) {
            this.mPosition = r5;
            invalidateSelf();
        }
    }

    static {
        THEME_ATTRS = new int[]{R.attr.homeAsUpIndicator};
    }

    public ActionBarDrawerToggle(Activity r10, DrawerLayout r11, @DrawableRes int r12, @StringRes int r13, @StringRes int r14) {
        this(r10, r11, !assumeMaterial(r10), r12, r13, r14);
    }

    private static boolean assumeMaterial(Context r5) {
        if (r5.getApplicationInfo().targetSdkVersion < 21) goto L5;
        return true;
    L5:
        return false;
    }

    private Drawable getThemeUpIndicator() {
        Delegate r5 = this.mActivityImpl;
        if (r5 != null) goto L5;
        ActionBar r10 = this.mActivity.getActionBar();
        if (r10 == null) goto L9;
        Context r11 = r10.getThemedContext();
    L10:
        TypedArray r12 = r11.obtainStyledAttributes(null, THEME_ATTRS, R.attr.actionBarStyle, 0);
        Drawable r13 = r12.getDrawable(0);
        r12.recycle();
        return r13;
    L9:
        r11 = this.mActivity;
        goto L10
    L5:
        return r5.getThemeUpIndicator();
    }

    private void setActionBarDescription(int r5) {
        Delegate r10 = this.mActivityImpl;
        if (r10 == null) goto L6;
        r10.setActionBarDescription(r5);
        return;
    L6:
        ActionBar r11 = this.mActivity.getActionBar();
        if (r11 == null) goto L10;
        r11.setHomeActionContentDescription(r5);
        return;
    }

    private void setActionBarUpIndicator(Drawable r5, int r10) {
        Delegate r11 = this.mActivityImpl;
        if (r11 == null) goto L6;
        r11.setActionBarUpIndicator(r5, r10);
        return;
    L6:
        ActionBar r12 = this.mActivity.getActionBar();
        if (r12 == null) goto L10;
        r12.setHomeAsUpIndicator(r5);
        r12.setHomeActionContentDescription(r10);
        return;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(Configuration r5) {
        if (this.mHasCustomUpIndicator == true) goto L5;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
    L5:
        this.mDrawerImage = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View r5) {
        this.mSlider.setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mOpenDrawerContentDescRes);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View r5) {
        this.mSlider.setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mCloseDrawerContentDescRes);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View r5, float r10) {
        float r11 = this.mSlider.getPosition();
        if (r10 <= 0.5f) goto L5;
        float r12 = Math.max(r11, Math.max(0.0f, r10 - 0.5f) * 2.0f);
    L6:
        this.mSlider.setPosition(r12);
        return;
    L5:
        r12 = Math.min(r11, r10 * 2.0f);
        goto L6
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
        if (this.mDrawerIndicatorEnabled == true) goto L8;
        return false;
    L8:
        if (this.mDrawerLayout.isDrawerVisible(GravityCompat.START) == false) goto L10;
        this.mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    L10:
        this.mDrawerLayout.openDrawer(GravityCompat.START);
        return true;
    }

    public void setDrawerIndicatorEnabled(boolean r5) {
        if (r5 == this.mDrawerIndicatorEnabled) goto L13;
        if (r5 == false) goto L10;
        SlideDrawable r10 = this.mSlider;
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

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L5;
        this.mSlider.setPosition(1.0f);
    L7:
        if (this.mDrawerIndicatorEnabled == false) goto L14;
        SlideDrawable r5 = this.mSlider;
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
        this.mSlider.setPosition(0.0f);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionBarDrawerToggle(Activity r5, DrawerLayout r10, boolean r11, @DrawableRes int r12, @StringRes int r13, @StringRes int r14) {
        this.mDrawerIndicatorEnabled = true;
        this.mActivity = r5;
        if ((r5 instanceof DelegateProvider) == false) goto L5;
        this.mActivityImpl = ((DelegateProvider) r5).getDrawerToggleDelegate();
    L6:
        this.mDrawerLayout = r10;
        this.mDrawerImageResource = r12;
        this.mOpenDrawerContentDescRes = r13;
        this.mCloseDrawerContentDescRes = r14;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mDrawerImage = ContextCompat.getDrawable(r5, r12);
        SlideDrawable r15 = new SlideDrawable(this, this.mDrawerImage);
        this.mSlider = r15;
        if (r11 == false) goto L9;
        float r16 = TOGGLE_DRAWABLE_OFFSET;
    L10:
        r15.setOffset(r16);
        return;
    L9:
        r16 = 0.0f;
        goto L10
    L5:
        this.mActivityImpl = null;
        goto L6
    }

    public void setHomeAsUpIndicator(int r5) {
        if (r5 == 0) goto L4;
        Drawable r10 = ContextCompat.getDrawable(this.mActivity, r5);
    L5:
        setHomeAsUpIndicator(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }
}
