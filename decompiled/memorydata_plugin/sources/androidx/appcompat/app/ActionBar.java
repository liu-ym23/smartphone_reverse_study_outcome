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
import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.FragmentTransaction;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    public @interface DisplayOptions {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;

        public LayoutParams(int r3) {
            this(-2, -1, r3);
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.gravity = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int r1, int r2, int r3) {
            super(r1, r2);
            this.gravity = 0;
            this.gravity = r3;
        }

        public LayoutParams(Context r4, AttributeSet r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
            super(r6, r7);
            this.gravity = 0;
            TypedArray r8 = r6.obtainStyledAttributes(r7, R.styleable.ActionBarLayout);
            this.gravity = r8.getInt(ZeusTransformUtils.mapRes(R.styleable.ActionBarLayout_android_layout_gravity, "styleable", "ActionBarLayout_android_layout_gravity"), 0);
            r8.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.gravity = 0;
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.gravity = 0;
            this.gravity = r2.gravity;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NavigationMode {
    }

    public interface OnMenuVisibilityListener {
        void onMenuVisibilityChanged(boolean r1);
    }

    @Deprecated
    public interface OnNavigationListener {
        boolean onNavigationItemSelected(int r1, long r2);
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

        public abstract Tab setContentDescription(int r1);

        public abstract Tab setContentDescription(CharSequence r1);

        public abstract Tab setCustomView(int r1);

        public abstract Tab setCustomView(View r1);

        public abstract Tab setIcon(int r1);

        public abstract Tab setIcon(Drawable r1);

        public abstract Tab setTabListener(TabListener r1);

        public abstract Tab setTag(Object r1);

        public abstract Tab setText(int r1);

        public abstract Tab setText(CharSequence r1);
    }

    @Deprecated
    public interface TabListener {
        void onTabReselected(Tab r1, FragmentTransaction r2);

        void onTabSelected(Tab r1, FragmentTransaction r2);

        void onTabUnselected(Tab r1, FragmentTransaction r2);
    }

    public ActionBar() {
    }

    public abstract void addOnMenuVisibilityListener(OnMenuVisibilityListener r1);

    @Deprecated
    public abstract void addTab(Tab r1);

    @Deprecated
    public abstract void addTab(Tab r1, int r2);

    @Deprecated
    public abstract void addTab(Tab r1, int r2, boolean r3);

    @Deprecated
    public abstract void addTab(Tab r1, boolean r2);

    public boolean closeOptionsMenu() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public void dispatchMenuVisibilityChanged(boolean r1) {
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

    @Deprecated
    public abstract Tab getSelectedTab();

    public abstract CharSequence getSubtitle();

    @Deprecated
    public abstract Tab getTabAt(int r1);

    @Deprecated
    public abstract int getTabCount();

    public Context getThemedContext() {
        return null;
    }

    public abstract CharSequence getTitle();

    public abstract void hide();

    public boolean invalidateOptionsMenu() {
        return false;
    }

    public boolean isHideOnContentScrollEnabled() {
        return false;
    }

    public abstract boolean isShowing();

    public boolean isTitleTruncated() {
        return false;
    }

    @Deprecated
    public abstract Tab newTab();

    public void onConfigurationChanged(Configuration r1) {
    }

    void onDestroy() {
    }

    public boolean onKeyShortcut(int r1, KeyEvent r2) {
        return false;
    }

    public boolean onMenuKeyEvent(KeyEvent r1) {
        return false;
    }

    public boolean openOptionsMenu() {
        return false;
    }

    @Deprecated
    public abstract void removeAllTabs();

    public abstract void removeOnMenuVisibilityListener(OnMenuVisibilityListener r1);

    @Deprecated
    public abstract void removeTab(Tab r1);

    @Deprecated
    public abstract void removeTabAt(int r1);

    boolean requestFocus() {
        return false;
    }

    @Deprecated
    public abstract void selectTab(Tab r1);

    public abstract void setBackgroundDrawable(Drawable r1);

    public abstract void setCustomView(int r1);

    public abstract void setCustomView(View r1);

    public abstract void setCustomView(View r1, LayoutParams r2);

    public void setDefaultDisplayHomeAsUpEnabled(boolean r1) {
    }

    public abstract void setDisplayHomeAsUpEnabled(boolean r1);

    public abstract void setDisplayOptions(int r1);

    public abstract void setDisplayOptions(int r1, int r2);

    public abstract void setDisplayShowCustomEnabled(boolean r1);

    public abstract void setDisplayShowHomeEnabled(boolean r1);

    public abstract void setDisplayShowTitleEnabled(boolean r1);

    public abstract void setDisplayUseLogoEnabled(boolean r1);

    public void setElevation(float r1) {
        if (r1 != 0.0f) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
    }

    public void setHideOffset(int r1) {
        if (r1 != 0) goto L5;
        return;
    L5:
        throw new UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
    }

    public void setHideOnContentScrollEnabled(boolean r1) {
        if (r1 == true) goto L5;
        return;
    L5:
        throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }

    public void setHomeActionContentDescription(int r1) {
    }

    public void setHomeActionContentDescription(CharSequence r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public void setHomeAsUpIndicator(int r1) {
    }

    public void setHomeAsUpIndicator(Drawable r1) {
    }

    public void setHomeButtonEnabled(boolean r1) {
    }

    public abstract void setIcon(int r1);

    public abstract void setIcon(Drawable r1);

    @Deprecated
    public abstract void setListNavigationCallbacks(SpinnerAdapter r1, OnNavigationListener r2);

    public abstract void setLogo(int r1);

    public abstract void setLogo(Drawable r1);

    @Deprecated
    public abstract void setNavigationMode(int r1);

    @Deprecated
    public abstract void setSelectedNavigationItem(int r1);

    public void setShowHideAnimationEnabled(boolean r1) {
    }

    public void setSplitBackgroundDrawable(Drawable r1) {
    }

    public void setStackedBackgroundDrawable(Drawable r1) {
    }

    public abstract void setSubtitle(int r1);

    public abstract void setSubtitle(CharSequence r1);

    public abstract void setTitle(int r1);

    public abstract void setTitle(CharSequence r1);

    public void setWindowTitle(CharSequence r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public abstract void show();

    public ActionMode startActionMode(ActionMode.Callback r2) {
        ActionMode.Callback r1 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r2, ActionMode.Callback.class, "com.obric.memorydata.plugin");
        return null;
    }
}
