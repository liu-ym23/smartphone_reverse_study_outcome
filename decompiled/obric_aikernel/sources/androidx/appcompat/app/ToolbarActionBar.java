package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ToolbarActionBar extends ActionBar {
    final DecorToolbar mDecorToolbar;
    private boolean mLastMenuVisibility;
    final AppCompatDelegateImpl.ActionBarMenuCallback mMenuCallback;
    private boolean mMenuCallbackSet;
    private final Toolbar.OnMenuItemClickListener mMenuClicker;
    private final Runnable mMenuInvalidator;
    private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners;
    boolean mToolbarMenuPrepared;
    final Window.Callback mWindowCallback;

    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        private boolean mClosingActionMenu;
        final /* synthetic */ ToolbarActionBar this$0;

        ActionMenuPresenterCallback(ToolbarActionBar r10) {
            this.this$0 = r10;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder r10, boolean r11) {
            if (this.mClosingActionMenu == false) goto L5;
            return;
        L5:
            this.mClosingActionMenu = true;
            this.this$0.mDecorToolbar.dismissPopupMenus();
            this.this$0.mWindowCallback.onPanelClosed(108, r10);
            this.mClosingActionMenu = false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder r10) {
            this.this$0.mWindowCallback.onMenuOpened(108, r10);
            return true;
        }
    }

    private final class MenuBuilderCallback implements MenuBuilder.Callback {
        final /* synthetic */ ToolbarActionBar this$0;

        MenuBuilderCallback(ToolbarActionBar r10) {
            this.this$0 = r10;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(@NonNull MenuBuilder r10, @NonNull MenuItem r11) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(@NonNull MenuBuilder r10) {
            if (this.this$0.mDecorToolbar.isOverflowMenuShowing() == false) goto L6;
            this.this$0.mWindowCallback.onPanelClosed(108, r10);
            return;
        L6:
            if (this.this$0.mWindowCallback.onPreparePanel(0, null, r10) == false) goto L10;
            this.this$0.mWindowCallback.onMenuOpened(108, r10);
            return;
        }
    }

    private class ToolbarMenuCallback implements AppCompatDelegateImpl.ActionBarMenuCallback {
        final /* synthetic */ ToolbarActionBar this$0;

        ToolbarMenuCallback(ToolbarActionBar r10) {
            this.this$0 = r10;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.ActionBarMenuCallback
        public View onCreatePanelView(int r10) {
            if (r10 == 0) goto L4;
            return null;
        L4:
            return new View(this.this$0.mDecorToolbar.getContext());
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.ActionBarMenuCallback
        public boolean onPreparePanel(int r10) {
            if (r10 != 0) goto L8;
            ToolbarActionBar r11 = this.this$0;
            if (r11.mToolbarMenuPrepared == true) goto L9;
            r11.mDecorToolbar.setMenuPrepared();
            this.this$0.mToolbarMenuPrepared = true;
            return false;
        L9:
            return false;
        L8:
            return false;
        }
    }

    ToolbarActionBar(@NonNull Toolbar r10, @Nullable CharSequence r11, @NonNull Window.Callback r12) {
        this.mMenuVisibilityListeners = new ArrayList();
        this.mMenuInvalidator = new AnonymousClass1(this);
        Toolbar.OnMenuItemClickListener r13 = new AnonymousClass2(this);
        this.mMenuClicker = r13;
        Preconditions.checkNotNull(r10);
        ToolbarWidgetWrapper r14 = new ToolbarWidgetWrapper(r10, false);
        this.mDecorToolbar = r14;
        this.mWindowCallback = (Window.Callback) Preconditions.checkNotNull(r12);
        r14.setWindowCallback(r12);
        r10.setOnMenuItemClickListener(r13);
        r14.setWindowTitle(r11);
        this.mMenuCallback = new ToolbarMenuCallback(this);
    }

    private Menu getMenu() {
        if (this.mMenuCallbackSet == true) goto L6;
        this.mDecorToolbar.setMenuCallbacks(new ActionMenuPresenterCallback(this), new MenuBuilderCallback(this));
        this.mMenuCallbackSet = true;
    L6:
        return this.mDecorToolbar.getMenu();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener r10) {
        this.mMenuVisibilityListeners.add(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r10) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r10, int r11) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r10, int r11, boolean r12) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r10, boolean r11) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean closeOptionsMenu() {
        return this.mDecorToolbar.hideOverflowMenu();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean collapseActionView() {
        if (this.mDecorToolbar.hasExpandedActionView() == false) goto L6;
        this.mDecorToolbar.collapseActionView();
        return true;
    L6:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean r10) {
        if (r10 != this.mLastMenuVisibility) goto L5;
        return;
    L5:
        this.mLastMenuVisibility = r10;
        int r11 = this.mMenuVisibilityListeners.size();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L8;
        this.mMenuVisibilityListeners.get(r12).onMenuVisibilityChanged(r10);
        r12 = r12 + 1;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    @Override // androidx.appcompat.app.ActionBar
    public float getElevation() {
        return ViewCompat.getElevation(this.mDecorToolbar.getViewGroup());
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHeight() {
        return this.mDecorToolbar.getHeight();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationItemCount() {
        return 0;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationMode() {
        return 0;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getSelectedNavigationIndex() {
        return -1;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getTabAt(int r10) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getTabCount() {
        return 0;
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context getThemedContext() {
        return this.mDecorToolbar.getContext();
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void hide() {
        this.mDecorToolbar.setVisibility(8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean invalidateOptionsMenu() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
        ViewCompat.postOnAnimation(this.mDecorToolbar.getViewGroup(), this.mMenuInvalidator);
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isShowing() {
        if (this.mDecorToolbar.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    void onDestroy() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onKeyShortcut(int r10, KeyEvent r11) {
        Menu r12 = getMenu();
        if (r12 == null) goto L13;
        if (r11 == null) goto L6;
        int r13 = r11.getDeviceId();
    L7:
        boolean r14 = true;
        if (KeyCharacterMap.load(r13).getKeyboardType() != 1) goto L11;
        r14 = false;
    L11:
        r12.setQwertyMode(r14);
        return r12.performShortcut(r10, r11, 0);
    L6:
        r13 = -1;
        goto L7
    L13:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onMenuKeyEvent(KeyEvent r10) {
        if (r10.getAction() != 1) goto L5;
        openOptionsMenu();
    L5:
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean openOptionsMenu() {
        return this.mDecorToolbar.showOverflowMenu();
    }

    void populateOptionsMenu() {
        Menu r10 = getMenu();
        if ((r10 instanceof MenuBuilder) == false) goto L5;
        MenuBuilder r11 = (MenuBuilder) r10;
    L6:
        if (r11 == null) goto L20;
        r11.stopDispatchingItemsChanged();
    L20:
        r10.clear();     // Catch: Throwable -> L16
        if (this.mWindowCallback.onCreatePanelMenu(0, r10) == true) goto L11;
    L12:
        r10.clear();     // Catch: Throwable -> L16
    L13:
        if (r11 == null) goto L22;
        r11.startDispatchingItemsChanged();
        return;
    L22:
        return;
    L11:
        if (this.mWindowCallback.onPreparePanel(0, null, r10) == true) goto L13;
    L16:
        th = move-exception;
        if (r11 == null) goto L19;
        r11.startDispatchingItemsChanged();
    L19:
        throw th;
    L5:
        r11 = null;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener r10) {
        this.mMenuVisibilityListeners.remove(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTab(ActionBar.Tab r10) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTabAt(int r10) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean requestFocus() {
        ViewGroup r10 = this.mDecorToolbar.getViewGroup();
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.hasFocus() == true) goto L10;
        r10.requestFocus();
        return true;
    L10:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void selectTab(ActionBar.Tab r10) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setBackgroundDrawable(@Nullable Drawable r10) {
        this.mDecorToolbar.setBackgroundDrawable(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(int r10) {
        setCustomView(LayoutInflater.from(this.mDecorToolbar.getContext()).inflate(r10, this.mDecorToolbar.getViewGroup(), false));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View r10) {
        setCustomView(r10, new ActionBar.LayoutParams(-2, -2));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View r10, ActionBar.LayoutParams r11) {
        if (r10 == null) goto L4;
        r10.setLayoutParams(r11);
    L4:
        this.mDecorToolbar.setCustomView(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean r10) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean r10) {
        if (r10 == false) goto L5;
        int r11 = 4;
    L6:
        setDisplayOptions(r11, 4);
        return;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    @SuppressLint({"WrongConstant"})
    public void setDisplayOptions(int r10) {
        setDisplayOptions(r10, -1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int r10, int r11) {
        int r12 = this.mDecorToolbar.getDisplayOptions();
        this.mDecorToolbar.setDisplayOptions((r10 & r11) | ((~r11) & r12));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean r10) {
        if (r10 == false) goto L5;
        int r11 = 16;
    L6:
        setDisplayOptions(r11, 16);
        return;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean r10) {
        if (r10 == false) goto L5;
        int r11 = 2;
    L6:
        setDisplayOptions(r11, 2);
        return;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean r10) {
        if (r10 == false) goto L5;
        int r11 = 8;
    L6:
        setDisplayOptions(r11, 8);
        return;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean r10) {
        setDisplayOptions(r10 ? 1 : 0, 1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setElevation(float r10) {
        ViewCompat.setElevation(this.mDecorToolbar.getViewGroup(), r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(int r10) {
        this.mDecorToolbar.setNavigationContentDescription(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(CharSequence r10) {
        this.mDecorToolbar.setNavigationContentDescription(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(int r10) {
        this.mDecorToolbar.setNavigationIcon(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(Drawable r10) {
        this.mDecorToolbar.setNavigationIcon(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeButtonEnabled(boolean r10) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(int r10) {
        this.mDecorToolbar.setIcon(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(Drawable r10) {
        this.mDecorToolbar.setIcon(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter r10, ActionBar.OnNavigationListener r11) {
        this.mDecorToolbar.setDropdownParams(r10, new NavItemSelectedListener(r11));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(int r10) {
        this.mDecorToolbar.setLogo(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(Drawable r10) {
        this.mDecorToolbar.setLogo(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setNavigationMode(int r10) {
        if (r10 == 2) goto L7;
        this.mDecorToolbar.setNavigationMode(r10);
        return;
    L7:
        throw new IllegalArgumentException("Tabs not supported in this configuration");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSelectedNavigationItem(int r10) {
        if (this.mDecorToolbar.getNavigationMode() != 1) goto L7;
        this.mDecorToolbar.setDropdownSelectedPosition(r10);
        return;
    L7:
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setShowHideAnimationEnabled(boolean r10) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable r10) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable r10) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(int r10) {
        DecorToolbar r11 = this.mDecorToolbar;
        if (r10 == 0) goto L5;
        CharSequence r12 = r11.getContext().getText(r10);
    L6:
        r11.setSubtitle(r12);
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(CharSequence r10) {
        this.mDecorToolbar.setSubtitle(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(int r10) {
        DecorToolbar r11 = this.mDecorToolbar;
        if (r10 == 0) goto L5;
        CharSequence r12 = r11.getContext().getText(r10);
    L6:
        r11.setTitle(r12);
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(CharSequence r10) {
        this.mDecorToolbar.setTitle(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setWindowTitle(CharSequence r10) {
        this.mDecorToolbar.setWindowTitle(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void show() {
        this.mDecorToolbar.setVisibility(0);
    }
}
