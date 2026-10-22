package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.FragmentTransaction;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionBar {
    public static final int DISPLAY_HOME_AS_UP = 4;
    public static final int DISPLAY_SHOW_CUSTOM = 16;
    public static final int DISPLAY_SHOW_HOME = 2;
    public static final int DISPLAY_SHOW_TITLE = 8;
    public static final int DISPLAY_USE_LOGO = 1;

    @Deprecated
    public static final int NAVIGATION_MODE_LIST = 1;

    @Deprecated
    public static final int NAVIGATION_MODE_STANDARD = 0;

    @Deprecated
    public static final int NAVIGATION_MODE_TABS = 2;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface DisplayOptions {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;

        public LayoutParams(int r10) {
            this(-2, -1, r10);
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.gravity = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int r10, int r11, int r12) {
            super(r10, r11);
            this.gravity = 0;
            this.gravity = r12;
        }

        public LayoutParams(@NonNull Context r10, AttributeSet r11) {
            super(r10, r11);
            this.gravity = 0;
            TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.ActionBarLayout);
            this.gravity = r12.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            r12.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.gravity = 0;
        }

        public LayoutParams(LayoutParams r10) {
            super(r10);
            this.gravity = 0;
            this.gravity = r10.gravity;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NavigationMode {
    }

    public interface OnMenuVisibilityListener {
        void onMenuVisibilityChanged(boolean r10);
    }

    @Deprecated
    public interface OnNavigationListener {
        boolean onNavigationItemSelected(int r10, long r11);
    }

    @Deprecated
    public static abstract class Tab {
        public static final int INVALID_POSITION = -1;

        public Tab() {
        }

        public abstract CharSequence getContentDescription();

        public abstract View getCustomView();

        public abstract Drawable getIcon();

        public abstract int getPosition();

        public abstract Object getTag();

        public abstract CharSequence getText();

        public abstract void select();

        public abstract Tab setContentDescription(@StringRes int r10);

        public abstract Tab setContentDescription(CharSequence r10);

        public abstract Tab setCustomView(int r10);

        public abstract Tab setCustomView(View r10);

        public abstract Tab setIcon(@DrawableRes int r10);

        public abstract Tab setIcon(Drawable r10);

        public abstract Tab setTabListener(TabListener r10);

        public abstract Tab setTag(Object r10);

        public abstract Tab setText(int r10);

        public abstract Tab setText(CharSequence r10);
    }

    @Deprecated
    public interface TabListener {
        void onTabReselected(Tab r10, FragmentTransaction r11);

        void onTabSelected(Tab r10, FragmentTransaction r11);

        void onTabUnselected(Tab r10, FragmentTransaction r11);
    }

    public ActionBar() {
    }

    public abstract void addOnMenuVisibilityListener(OnMenuVisibilityListener r10);

    @Deprecated
    public abstract void addTab(Tab r10);

    @Deprecated
    public abstract void addTab(Tab r10, int r11);

    @Deprecated
    public abstract void addTab(Tab r10, int r11, boolean r12);

    @Deprecated
    public abstract void addTab(Tab r10, boolean r11);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean closeOptionsMenu() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean collapseActionView() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void dispatchMenuVisibilityChanged(boolean r10) {
    }

    public abstract View getCustomView();

    public abstract int getDisplayOptions();

    public float getElevation() {
        return 0.0f;
    }

    public abstract int getHeight();

    public int getHideOffset() {
        return 0;
    }

    @Deprecated
    public abstract int getNavigationItemCount();

    @Deprecated
    public abstract int getNavigationMode();

    @Deprecated
    public abstract int getSelectedNavigationIndex();

    @Nullable
    @Deprecated
    public abstract Tab getSelectedTab();

    @Nullable
    public abstract CharSequence getSubtitle();

    @Deprecated
    public abstract Tab getTabAt(int r10);

    @Deprecated
    public abstract int getTabCount();

    public Context getThemedContext() {
        return null;
    }

    @Nullable
    public abstract CharSequence getTitle();

    public abstract void hide();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean invalidateOptionsMenu() {
        return false;
    }

    public boolean isHideOnContentScrollEnabled() {
        return false;
    }

    public abstract boolean isShowing();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isTitleTruncated() {
        return false;
    }

    @Deprecated
    public abstract Tab newTab();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onConfigurationChanged(Configuration r10) {
    }

    void onDestroy() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean onKeyShortcut(int r10, KeyEvent r11) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean onMenuKeyEvent(KeyEvent r10) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean openOptionsMenu() {
        return false;
    }

    @Deprecated
    public abstract void removeAllTabs();

    public abstract void removeOnMenuVisibilityListener(OnMenuVisibilityListener r10);

    @Deprecated
    public abstract void removeTab(Tab r10);

    @Deprecated
    public abstract void removeTabAt(int r10);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    boolean requestFocus() {
        return false;
    }

    @Deprecated
    public abstract void selectTab(Tab r10);

    public abstract void setBackgroundDrawable(@Nullable Drawable r10);

    public abstract void setCustomView(int r10);

    public abstract void setCustomView(View r10);

    public abstract void setCustomView(View r10, LayoutParams r11);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDefaultDisplayHomeAsUpEnabled(boolean r10) {
    }

    public abstract void setDisplayHomeAsUpEnabled(boolean r10);

    public abstract void setDisplayOptions(int r10);

    public abstract void setDisplayOptions(int r10, int r11);

    public abstract void setDisplayShowCustomEnabled(boolean r10);

    public abstract void setDisplayShowHomeEnabled(boolean r10);

    public abstract void setDisplayShowTitleEnabled(boolean r10);

    public abstract void setDisplayUseLogoEnabled(boolean r10);

    public void setElevation(float r10) {
        if (r10 != 0.0f) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
    }

    public void setHideOffset(int r10) {
        if (r10 != 0) goto L5;
        return;
    L5:
        throw new UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
    }

    public void setHideOnContentScrollEnabled(boolean r10) {
        if (r10 == true) goto L5;
        return;
    L5:
        throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }

    public void setHomeActionContentDescription(@StringRes int r10) {
    }

    public void setHomeActionContentDescription(@Nullable CharSequence r10) {
    }

    public void setHomeAsUpIndicator(@DrawableRes int r10) {
    }

    public void setHomeAsUpIndicator(@Nullable Drawable r10) {
    }

    public void setHomeButtonEnabled(boolean r10) {
    }

    public abstract void setIcon(@DrawableRes int r10);

    public abstract void setIcon(Drawable r10);

    @Deprecated
    public abstract void setListNavigationCallbacks(SpinnerAdapter r10, OnNavigationListener r11);

    public abstract void setLogo(@DrawableRes int r10);

    public abstract void setLogo(Drawable r10);

    @Deprecated
    public abstract void setNavigationMode(int r10);

    @Deprecated
    public abstract void setSelectedNavigationItem(int r10);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setShowHideAnimationEnabled(boolean r10) {
    }

    public void setSplitBackgroundDrawable(Drawable r10) {
    }

    public void setStackedBackgroundDrawable(Drawable r10) {
    }

    public abstract void setSubtitle(int r10);

    public abstract void setSubtitle(CharSequence r10);

    public abstract void setTitle(@StringRes int r10);

    public abstract void setTitle(CharSequence r10);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setWindowTitle(CharSequence r10) {
    }

    public abstract void show();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ActionMode startActionMode(ActionMode.Callback r10) {
        return null;
    }
}
