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
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
        Drawable getThemeUpIndicator();

        void setActionBarDescription(int r1);

        void setActionBarUpIndicator(Drawable r1, int r2);
    }

    @Deprecated
    public interface DelegateProvider {
        Delegate getDrawerToggleDelegate();
    }

    private static class SetIndicatorInfo {
        Method mSetHomeActionContentDescription;
        Method mSetHomeAsUpIndicator;
        ImageView mUpIndicatorView;

        SetIndicatorInfo(Activity r8) {
            Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.memorydata.plugin");
            this.mSetHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});     // Catch: NoSuchMethodException -> L5
            this.mSetHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            View r10 = r9.findViewById(16908332);
            if (r10 != null) goto L8;
            return;
        L8:
            ViewGroup r11 = (ViewGroup) ZeusTransformUtils.preCheckCast(r10.getParent(), ViewGroup.class, "com.obric.memorydata.plugin");
            if (r11.getChildCount() == 2) goto L11;
            return;
        L11:
            View r0 = r11.getChildAt(0);
            View r12 = r11.getChildAt(1);
            if (r0.getId() != 16908332) goto L15;
            r0 = r12;
        L15:
            if (ZeusTransformUtils.instanceOf(r0, ImageView.class) == false) goto L20;
            this.mUpIndicatorView = (ImageView) ZeusTransformUtils.preCheckCast(r0, ImageView.class, "com.obric.memorydata.plugin");
            return;
        }
    }

    private class SlideDrawable extends InsetDrawable implements Drawable.Callback {
        private final boolean mHasMirroring;
        private float mOffset;
        private float mPosition;
        private final Rect mTmpRect;
        final /* synthetic */ ActionBarDrawerToggle this$0;

        SlideDrawable(ActionBarDrawerToggle r2, Drawable r3) {
            this.this$0 = r2;
            boolean r4 = false;
            super(r3, 0);
            if (Build.VERSION.SDK_INT <= 18) goto L5;
            r4 = true;
        L5:
            this.mHasMirroring = r4;
            this.mTmpRect = new Rect();
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas r6) {
            copyBounds(this.mTmpRect);
            r6.save();
            int r1 = 1;
            if (ViewCompat.getLayoutDirection(ZeusTransformUtils.getWindow(this.this$0.mActivity, "com.obric.memorydata.plugin").getDecorView()) != 1) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            r1 = -1;
        L8:
            float r2 = this.mTmpRect.width();
            r6.translate((((-this.mOffset) * r2) * this.mPosition) * r1, 0.0f);
            if (r0 == true) goto L11;
        L13:
            super.draw(r6);
            r6.restore();
            return;
        L11:
            if (this.mHasMirroring == true) goto L13;
            r6.translate(r2, 0.0f);
            r6.scale(-1.0f, 1.0f);
            goto L13
        L5:
            r0 = false;
            goto L6
        }

        public float getPosition() {
            return this.mPosition;
        }

        public void setOffset(float r1) {
            this.mOffset = r1;
            invalidateSelf();
        }

        public void setPosition(float r1) {
            this.mPosition = r1;
            invalidateSelf();
        }
    }

    static {
        THEME_ATTRS = new int[]{R.attr.homeAsUpIndicator};
    }

    public ActionBarDrawerToggle(Activity r8, DrawerLayout r9, int r10, int r11, int r12) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.memorydata.plugin");
        this(r1, r9, !assumeMaterial(r1), r10, r11, r12);
    }

    public ActionBarDrawerToggle(Activity r3, DrawerLayout r4, boolean r5, int r6, int r7, int r8) {
        Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        this.mDrawerIndicatorEnabled = true;
        this.mActivity = ZeusTransformUtils.wrapperContext2Activity(r9, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, DelegateProvider.class) == false) goto L5;
        Delegate r0 = ((DelegateProvider) ZeusTransformUtils.preCheckCast(r9, DelegateProvider.class, "com.obric.memorydata.plugin")).getDrawerToggleDelegate();
    L6:
        this.mActivityImpl = r0;
        this.mDrawerLayout = r4;
        this.mDrawerImageResource = r6;
        this.mOpenDrawerContentDescRes = r7;
        this.mCloseDrawerContentDescRes = r8;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mDrawerImage = ContextCompat.getDrawable(r9, r6);
        SlideDrawable r10 = new SlideDrawable(this, this.mDrawerImage);
        this.mSlider = r10;
        if (r5 == false) goto L9;
        float r2 = TOGGLE_DRAWABLE_OFFSET;
    L10:
        r10.setOffset(r2);
        return;
    L9:
        r2 = 0.0f;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    private static boolean assumeMaterial(Context r2) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getApplicationInfo().targetSdkVersion >= 21) goto L5;
    L7:
        return false;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return true;
    }

    private Drawable getThemeUpIndicator() {
        Delegate r0 = this.mActivityImpl;
        if (r0 == null) goto L7;
        return r0.getThemeUpIndicator();
    L7:
        if (Build.VERSION.SDK_INT < 18) goto L15;
        ActionBar r1 = this.mActivity.getActionBar();
        if (r1 == null) goto L11;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getThemedContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L12:
        TypedArray r5 = r4.obtainStyledAttributes(null, THEME_ATTRS, R.attr.actionBarStyle, 0);
    L13:
        Drawable r2 = r5.getDrawable(0);
        r5.recycle();
        return r2;
    L11:
        r4 = this.mActivity;
        goto L12
    L15:
        r5 = this.mActivity.obtainStyledAttributes(THEME_ATTRS);
        goto L13
    }

    private void setActionBarDescription(int r4) {
        Delegate r0 = this.mActivityImpl;
        if (r0 == null) goto L7;
        r0.setActionBarDescription(r4);
        return;
    L7:
        if (Build.VERSION.SDK_INT < 18) goto L12;
        ActionBar r3 = this.mActivity.getActionBar();
        if (r3 == null) goto L23;
        r3.setHomeActionContentDescription(r4);
        return;
    L23:
        return;
    L12:
        if (this.mSetIndicatorInfo != null) goto L15;
        this.mSetIndicatorInfo = new SetIndicatorInfo(this.mActivity);
    L15:
        if (this.mSetIndicatorInfo.mSetHomeAsUpIndicator == null) goto L25;
        ActionBar r1 = this.mActivity.getActionBar();     // Catch: Exception -> L18
        this.mSetIndicatorInfo.mSetHomeActionContentDescription.invoke(r1, new Object[]{Integer.valueOf(r4)});     // Catch: Exception -> L18
        r1.setSubtitle(r1.getSubtitle());     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        Log.w(TAG, "Couldn't set content description via JB-MR2 API", e);
        return;
    }

    private void setActionBarUpIndicator(Drawable r7, int r8) {
        Delegate r0 = this.mActivityImpl;
        if (r0 == null) goto L7;
        r0.setActionBarUpIndicator(r7, r8);
        return;
    L7:
        if (Build.VERSION.SDK_INT < 18) goto L12;
        ActionBar r6 = this.mActivity.getActionBar();
        if (r6 == null) goto L27;
        r6.setHomeAsUpIndicator(r7);
        r6.setHomeActionContentDescription(r8);
        return;
    L27:
        return;
    L12:
        if (this.mSetIndicatorInfo != null) goto L15;
        this.mSetIndicatorInfo = new SetIndicatorInfo(this.mActivity);
    L15:
        if (this.mSetIndicatorInfo.mSetHomeAsUpIndicator == null) goto L21;
        ActionBar r1 = this.mActivity.getActionBar();     // Catch: Exception -> L18
        this.mSetIndicatorInfo.mSetHomeAsUpIndicator.invoke(r1, new Object[]{r7});     // Catch: Exception -> L18
        this.mSetIndicatorInfo.mSetHomeActionContentDescription.invoke(r1, new Object[]{Integer.valueOf(r8)});     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        Log.w(TAG, "Couldn't set home-as-up indicator via JB-MR2 API", e);
        return;
    L21:
        if (this.mSetIndicatorInfo.mUpIndicatorView == null) goto L23;
        this.mSetIndicatorInfo.mUpIndicatorView.setImageDrawable(r7);
        return;
    L23:
        Log.w(TAG, "Couldn't set home-as-up indicator");
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(Configuration r2) {
        if (this.mHasCustomUpIndicator == true) goto L5;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
    L5:
        this.mDrawerImage = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View r2) {
        this.mSlider.setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mOpenDrawerContentDescRes);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View r2) {
        this.mSlider.setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mCloseDrawerContentDescRes);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View r4, float r5) {
        float r6 = this.mSlider.getPosition();
        if (r5 <= 0.5f) goto L5;
        float r7 = Math.max(r6, Math.max(0.0f, r5 - 0.5f) * 2.0f);
    L6:
        this.mSlider.setPosition(r7);
        return;
    L5:
        r7 = Math.min(r6, r5 * 2.0f);
        goto L6
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
        if (this.mDrawerIndicatorEnabled == false) goto L18;
        boolean r5 = this.mDrawerLayout.isDrawerVisible(GravityCompat.START);
        DrawerLayout r2 = this.mDrawerLayout;
        if (r5 == false) goto L11;
        r2.closeDrawer(GravityCompat.START);
        return true;
    L11:
        r2.openDrawer(GravityCompat.START);
        return true;
    L18:
        return false;
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

    public void setHomeAsUpIndicator(int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = ContextCompat.getDrawable(this.mActivity, r2);
    L5:
        setHomeAsUpIndicator(r3);
        return;
    L4:
        r3 = null;
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

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L5;
        SlideDrawable r0 = this.mSlider;
        float r2 = 1.0f;
    L6:
        r0.setPosition(r2);
        if (this.mDrawerIndicatorEnabled == false) goto L14;
        SlideDrawable r1 = this.mSlider;
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L11;
        int r3 = this.mCloseDrawerContentDescRes;
    L12:
        setActionBarUpIndicator(r1, r3);
        return;
    L11:
        r3 = this.mOpenDrawerContentDescRes;
        goto L12
    L14:
        return;
    L5:
        r0 = this.mSlider;
        r2 = 0.0f;
        goto L6
    }
}
