package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuItemWrapperICS extends BaseMenuWrapper implements MenuItem {
    static final String LOG_TAG = "MenuItemWrapper";
    private Method mSetExclusiveCheckableMethod;
    private final SupportMenuItem mWrappedObject;

    private class ActionProviderWrapper extends ActionProvider {
        final android.view.ActionProvider mInner;
        final /* synthetic */ MenuItemWrapperICS this$0;

        ActionProviderWrapper(MenuItemWrapperICS r10, Context r11, android.view.ActionProvider r12) {
            this.this$0 = r10;
            super(r11);
            this.mInner = r12;
        }

        @Override // androidx.core.view.ActionProvider
        public boolean hasSubMenu() {
            return this.mInner.hasSubMenu();
        }

        @Override // androidx.core.view.ActionProvider
        public View onCreateActionView() {
            return this.mInner.onCreateActionView();
        }

        @Override // androidx.core.view.ActionProvider
        public boolean onPerformDefaultAction() {
            return this.mInner.onPerformDefaultAction();
        }

        @Override // androidx.core.view.ActionProvider
        public void onPrepareSubMenu(SubMenu r10) {
            this.mInner.onPrepareSubMenu(this.this$0.getSubMenuWrapper(r10));
        }
    }

    @RequiresApi(16)
    private class ActionProviderWrapperJB extends ActionProviderWrapper implements android.view.ActionProvider.VisibilityListener {
        private ActionProvider.VisibilityListener mListener;
        final /* synthetic */ MenuItemWrapperICS this$0;

        ActionProviderWrapperJB(MenuItemWrapperICS r10, Context r11, android.view.ActionProvider r12) {
            this.this$0 = r10;
            super(r10, r11, r12);
        }

        @Override // androidx.core.view.ActionProvider
        public boolean isVisible() {
            return this.mInner.isVisible();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean r10) {
            ActionProvider.VisibilityListener r11 = this.mListener;
            if (r11 == null) goto L6;
            r11.onActionProviderVisibilityChanged(r10);
            return;
        }

        @Override // androidx.core.view.ActionProvider
        public View onCreateActionView(MenuItem r10) {
            return this.mInner.onCreateActionView(r10);
        }

        @Override // androidx.core.view.ActionProvider
        public boolean overridesItemVisibility() {
            return this.mInner.overridesItemVisibility();
        }

        @Override // androidx.core.view.ActionProvider
        public void refreshVisibility() {
            this.mInner.refreshVisibility();
        }

        @Override // androidx.core.view.ActionProvider
        public void setVisibilityListener(ActionProvider.VisibilityListener r10) {
            this.mListener = r10;
            android.view.ActionProvider r11 = this.mInner;
            if (r10 != null) goto L6;
            ActionProviderWrapperJB this = null;
        L6:
            r11.setVisibilityListener(this);
        }
    }

    static class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {
        final android.view.CollapsibleActionView mWrappedView;

        /* JADX WARN: Multi-variable type inference failed */
        CollapsibleActionViewWrapper(View r10) {
            super(r10.getContext());
            this.mWrappedView = (android.view.CollapsibleActionView) r10;
            addView(r10);
        }

        View getWrappedView() {
            return (View) this.mWrappedView;
        }

        @Override // androidx.appcompat.view.CollapsibleActionView
        public void onActionViewCollapsed() {
            this.mWrappedView.onActionViewCollapsed();
        }

        @Override // androidx.appcompat.view.CollapsibleActionView
        public void onActionViewExpanded() {
            this.mWrappedView.onActionViewExpanded();
        }
    }

    private class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {
        private final MenuItem.OnActionExpandListener mObject;
        final /* synthetic */ MenuItemWrapperICS this$0;

        OnActionExpandListenerWrapper(MenuItemWrapperICS r10, MenuItem.OnActionExpandListener r11) {
            this.this$0 = r10;
            this.mObject = r11;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem r10) {
            return this.mObject.onMenuItemActionCollapse(this.this$0.getMenuItemWrapper(r10));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem r10) {
            return this.mObject.onMenuItemActionExpand(this.this$0.getMenuItemWrapper(r10));
        }
    }

    private class OnMenuItemClickListenerWrapper implements MenuItem.OnMenuItemClickListener {
        private final MenuItem.OnMenuItemClickListener mObject;
        final /* synthetic */ MenuItemWrapperICS this$0;

        OnMenuItemClickListenerWrapper(MenuItemWrapperICS r10, MenuItem.OnMenuItemClickListener r11) {
            this.this$0 = r10;
            this.mObject = r11;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r10) {
            return this.mObject.onMenuItemClick(this.this$0.getMenuItemWrapper(r10));
        }
    }

    public MenuItemWrapperICS(Context r10, SupportMenuItem r11) {
        super(r10);
        if (r11 == null) goto L7;
        this.mWrappedObject = r11;
        return;
    L7:
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.mWrappedObject.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.mWrappedObject.expandActionView();
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        ActionProvider r10 = this.mWrappedObject.getSupportActionProvider();
        if ((r10 instanceof ActionProviderWrapper) == true) goto L5;
        return null;
    L5:
        return ((ActionProviderWrapper) r10).mInner;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View r10 = this.mWrappedObject.getActionView();
        if ((r10 instanceof CollapsibleActionViewWrapper) == true) goto L5;
        return r10;
    L5:
        return ((CollapsibleActionViewWrapper) r10).getWrappedView();
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.mWrappedObject.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.mWrappedObject.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.mWrappedObject.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.mWrappedObject.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.mWrappedObject.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.mWrappedObject.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.mWrappedObject.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.mWrappedObject.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.mWrappedObject.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mWrappedObject.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.mWrappedObject.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.mWrappedObject.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.mWrappedObject.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return getSubMenuWrapper(this.mWrappedObject.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.mWrappedObject.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.mWrappedObject.getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.mWrappedObject.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.mWrappedObject.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.mWrappedObject.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.mWrappedObject.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.mWrappedObject.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.mWrappedObject.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider r10) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        ActionProvider r11 = new ActionProviderWrapperJB(this, this.mContext, r10);
    L6:
        SupportMenuItem r12 = this.mWrappedObject;
        if (r10 != null) goto L10;
        r11 = null;
    L10:
        r12.setSupportActionProvider(r11);
        return this;
    L5:
        r11 = new ActionProviderWrapper(this, this.mContext, r10);
        goto L6
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int r10) {
        this.mWrappedObject.setActionView(r10);
        View r11 = this.mWrappedObject.getActionView();
        if ((r11 instanceof android.view.CollapsibleActionView) == false) goto L5;
        this.mWrappedObject.setActionView(new CollapsibleActionViewWrapper(r11));
    L5:
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View r10) {
        if ((r10 instanceof android.view.CollapsibleActionView) == false) goto L5;
        r10 = new CollapsibleActionViewWrapper(r10);
    L5:
        this.mWrappedObject.setActionView(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r10) {
        this.mWrappedObject.setAlphabeticShortcut(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r10, int r11) {
        this.mWrappedObject.setAlphabeticShortcut(r10, r11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean r10) {
        this.mWrappedObject.setCheckable(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean r10) {
        this.mWrappedObject.setChecked(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence r10) {
        this.mWrappedObject.setContentDescription(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean r10) {
        this.mWrappedObject.setEnabled(r10);
        return this;
    }

    public void setExclusiveCheckable(boolean r10) {
    L7:
        e = move-exception;
        Log.w(LOG_TAG, "Error while calling setExclusiveCheckable", e);
        return;
    L3:
        if (this.mSetExclusiveCheckableMethod != null) goto L5;
        this.mSetExclusiveCheckableMethod = this.mWrappedObject.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});     // Catch: Exception -> L7
    L5:
        this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, new Object[]{Boolean.valueOf(r10)});     // Catch: Exception -> L7
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int r10) {
        this.mWrappedObject.setIcon(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable r10) {
        this.mWrappedObject.setIcon(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList r10) {
        this.mWrappedObject.setIconTintList(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode r10) {
        this.mWrappedObject.setIconTintMode(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent r10) {
        this.mWrappedObject.setIntent(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char r10) {
        this.mWrappedObject.setNumericShortcut(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char r10, int r11) {
        this.mWrappedObject.setNumericShortcut(r10, r11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener r10) {
        SupportMenuItem r11 = this.mWrappedObject;
        if (r10 == null) goto L5;
        OnActionExpandListenerWrapper r12 = new OnActionExpandListenerWrapper(this, r10);
    L6:
        r11.setOnActionExpandListener(r12);
        return this;
    L5:
        r12 = null;
        goto L6
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener r10) {
        SupportMenuItem r11 = this.mWrappedObject;
        if (r10 == null) goto L5;
        OnMenuItemClickListenerWrapper r12 = new OnMenuItemClickListenerWrapper(this, r10);
    L6:
        r11.setOnMenuItemClickListener(r12);
        return this;
    L5:
        r12 = null;
        goto L6
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char r10, char r11) {
        this.mWrappedObject.setShortcut(r10, r11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char r10, char r11, int r12, int r13) {
        this.mWrappedObject.setShortcut(r10, r11, r12, r13);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int r10) {
        this.mWrappedObject.setShowAsAction(r10);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int r10) {
        this.mWrappedObject.setShowAsActionFlags(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int r10) {
        this.mWrappedObject.setTitle(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence r10) {
        this.mWrappedObject.setTitle(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence r10) {
        this.mWrappedObject.setTitleCondensed(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence r10) {
        this.mWrappedObject.setTooltipText(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean r10) {
        return this.mWrappedObject.setVisible(r10);
    }
}
