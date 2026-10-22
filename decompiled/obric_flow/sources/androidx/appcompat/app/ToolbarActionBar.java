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

    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        private boolean mClosingActionMenu;
        final /* synthetic */ ToolbarActionBar this$0;

        public ActionMenuPresenterCallback(ToolbarActionBar r5) {
            this.this$0 = r5;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder r5, boolean r10) {
            if (this.mClosingActionMenu == false) goto L5;
            return;
        L5:
            this.mClosingActionMenu = true;
            this.this$0.mDecorToolbar.dismissPopupMenus();
            this.this$0.mWindowCallback.onPanelClosed(108, r5);
            this.mClosingActionMenu = false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder r5) {
            this.this$0.mWindowCallback.onMenuOpened(108, r5);
            return true;
        }
    }

    public final class MenuBuilderCallback implements MenuBuilder.Callback {
        final /* synthetic */ ToolbarActionBar this$0;

        public MenuBuilderCallback(ToolbarActionBar r5) {
            this.this$0 = r5;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(@NonNull MenuBuilder r5, @NonNull MenuItem r10) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(@NonNull MenuBuilder r5) {
            if (this.this$0.mDecorToolbar.isOverflowMenuShowing() == false) goto L6;
            this.this$0.mWindowCallback.onPanelClosed(108, r5);
            return;
        L6:
            if (this.this$0.mWindowCallback.onPreparePanel(0, null, r5) == false) goto L10;
            this.this$0.mWindowCallback.onMenuOpened(108, r5);
            return;
        }
    }

    public class ToolbarMenuCallback implements AppCompatDelegateImpl.ActionBarMenuCallback {
        final /* synthetic */ ToolbarActionBar this$0;

        public ToolbarMenuCallback(ToolbarActionBar r5) {
            this.this$0 = r5;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.ActionBarMenuCallback
        public View onCreatePanelView(int r5) {
            if (r5 == 0) goto L4;
            return null;
        L4:
            return new View(this.this$0.mDecorToolbar.getContext());
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.ActionBarMenuCallback
        public boolean onPreparePanel(int r5) {
            if (r5 != 0) goto L8;
            ToolbarActionBar r10 = this.this$0;
            if (r10.mToolbarMenuPrepared == true) goto L9;
            r10.mDecorToolbar.setMenuPrepared();
            this.this$0.mToolbarMenuPrepared = true;
            return false;
        L9:
            return false;
        L8:
            return false;
        }
    }

    public ToolbarActionBar(@NonNull Toolbar r5, @Nullable CharSequence r10, @NonNull Window.Callback r11) {
        this.mMenuVisibilityListeners = new ArrayList();
        this.mMenuInvalidator = new AnonymousClass1(this);
        Toolbar.OnMenuItemClickListener r12 = new AnonymousClass2(this);
        this.mMenuClicker = r12;
        Preconditions.checkNotNull(r5);
        ToolbarWidgetWrapper r13 = new ToolbarWidgetWrapper(r5, false);
        this.mDecorToolbar = r13;
        this.mWindowCallback = (Window.Callback) Preconditions.checkNotNull(r11);
        r13.setWindowCallback(r11);
        r5.setOnMenuItemClickListener(r12);
        r13.setWindowTitle(r10);
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
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener r5) {
        this.mMenuVisibilityListeners.add(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r5) {
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
    public void dispatchMenuVisibilityChanged(boolean r5) {
        if (r5 != this.mLastMenuVisibility) goto L5;
        return;
    L5:
        this.mLastMenuVisibility = r5;
        int r10 = this.mMenuVisibilityListeners.size();
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L8;
        this.mMenuVisibilityListeners.get(r11).onMenuVisibilityChanged(r5);
        r11 = r11 + 1;
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
    public ActionBar.Tab getTabAt(int r5) {
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
    public void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void onDestroy() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onKeyShortcut(int r5, KeyEvent r10) {
        Menu r11 = getMenu();
        if (r11 == null) goto L13;
        if (r10 == null) goto L6;
        int r12 = r10.getDeviceId();
    L7:
        boolean r13 = true;
        if (KeyCharacterMap.load(r12).getKeyboardType() != 1) goto L11;
        r13 = false;
    L11:
        r11.setQwertyMode(r13);
        return r11.performShortcut(r5, r10, 0);
    L6:
        r12 = -1;
        goto L7
    L13:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onMenuKeyEvent(KeyEvent r5) {
        if (r5.getAction() != 1) goto L5;
        openOptionsMenu();
    L5:
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean openOptionsMenu() {
        return this.mDecorToolbar.showOverflowMenu();
    }

    public void populateOptionsMenu() {
        Menu r5 = getMenu();
        if ((r5 instanceof MenuBuilder) == false) goto L5;
        MenuBuilder r10 = (MenuBuilder) r5;
    L6:
        if (r10 == null) goto L22;
        r10.stopDispatchingItemsChanged();
    L22:
        r5.clear();     // Catch: Throwable -> L13
        if (this.mWindowCallback.onCreatePanelMenu(0, r5) == true) goto L11;
    L15:
        r5.clear();     // Catch: Throwable -> L13
    L16:
        if (r10 == null) goto L24;
        r10.startDispatchingItemsChanged();
        return;
    L24:
        return;
    L11:
        if (this.mWindowCallback.onPreparePanel(0, null, r5) == true) goto L16;
    L13:
        th = move-exception;
        if (r10 == null) goto L21;
        r10.startDispatchingItemsChanged();
    L21:
        throw th;
    L5:
        r10 = null;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener r5) {
        this.mMenuVisibilityListeners.remove(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTab(ActionBar.Tab r5) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTabAt(int r5) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean requestFocus() {
        ViewGroup r5 = this.mDecorToolbar.getViewGroup();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.hasFocus() == true) goto L10;
        r5.requestFocus();
        return true;
    L10:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void selectTab(ActionBar.Tab r5) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setBackgroundDrawable(@Nullable Drawable r5) {
        this.mDecorToolbar.setBackgroundDrawable(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View r5) {
        setCustomView(r5, new ActionBar.LayoutParams(-2, -2));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean r5) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean r5) {
        if (r5 == false) goto L5;
        int r10 = 4;
    L6:
        setDisplayOptions(r10, 4);
        return;
    L5:
        r10 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    @SuppressLint({"WrongConstant"})
    public void setDisplayOptions(int r5) {
        setDisplayOptions(r5, -1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean r5) {
        if (r5 == false) goto L5;
        int r10 = 16;
    L6:
        setDisplayOptions(r10, 16);
        return;
    L5:
        r10 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean r5) {
        if (r5 == false) goto L5;
        int r10 = 2;
    L6:
        setDisplayOptions(r10, 2);
        return;
    L5:
        r10 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean r5) {
        if (r5 == false) goto L5;
        int r10 = 8;
    L6:
        setDisplayOptions(r10, 8);
        return;
    L5:
        r10 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean r5) {
        setDisplayOptions(r5 ? 1 : 0, 1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setElevation(float r5) {
        ViewCompat.setElevation(this.mDecorToolbar.getViewGroup(), r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(CharSequence r5) {
        this.mDecorToolbar.setNavigationContentDescription(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(Drawable r5) {
        this.mDecorToolbar.setNavigationIcon(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeButtonEnabled(boolean r5) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(int r5) {
        this.mDecorToolbar.setIcon(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter r5, ActionBar.OnNavigationListener r10) {
        this.mDecorToolbar.setDropdownParams(r5, new NavItemSelectedListener(r10));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(int r5) {
        this.mDecorToolbar.setLogo(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setNavigationMode(int r5) {
        if (r5 == 2) goto L7;
        this.mDecorToolbar.setNavigationMode(r5);
        return;
    L7:
        throw new IllegalArgumentException("Tabs not supported in this configuration");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSelectedNavigationItem(int r5) {
        if (this.mDecorToolbar.getNavigationMode() != 1) goto L7;
        this.mDecorToolbar.setDropdownSelectedPosition(r5);
        return;
    L7:
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setShowHideAnimationEnabled(boolean r5) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable r5) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable r5) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(CharSequence r5) {
        this.mDecorToolbar.setSubtitle(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(CharSequence r5) {
        this.mDecorToolbar.setTitle(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setWindowTitle(CharSequence r5) {
        this.mDecorToolbar.setWindowTitle(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void show() {
        this.mDecorToolbar.setVisibility(0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r5, boolean r10) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View r5, ActionBar.LayoutParams r10) {
        if (r5 == null) goto L4;
        r5.setLayoutParams(r10);
    L4:
        this.mDecorToolbar.setCustomView(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int r5, int r10) {
        int r11 = this.mDecorToolbar.getDisplayOptions();
        this.mDecorToolbar.setDisplayOptions((r5 & r10) | ((~r10) & r11));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(int r5) {
        this.mDecorToolbar.setNavigationContentDescription(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(int r5) {
        this.mDecorToolbar.setNavigationIcon(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(Drawable r5) {
        this.mDecorToolbar.setIcon(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(Drawable r5) {
        this.mDecorToolbar.setLogo(r5);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(int r5) {
        DecorToolbar r10 = this.mDecorToolbar;
        if (r5 == 0) goto L5;
        CharSequence r11 = r10.getContext().getText(r5);
    L6:
        r10.setSubtitle(r11);
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(int r5) {
        DecorToolbar r10 = this.mDecorToolbar;
        if (r5 == 0) goto L5;
        CharSequence r11 = r10.getContext().getText(r5);
    L6:
        r10.setTitle(r11);
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r5, int r10) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r5, int r10, boolean r11) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(int r5) {
        setCustomView(LayoutInflater.from(this.mDecorToolbar.getContext()).inflate(r5, this.mDecorToolbar.getViewGroup(), false));
    }
}
