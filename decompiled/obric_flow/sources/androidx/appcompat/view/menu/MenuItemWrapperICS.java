package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
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

    public class ActionProviderWrapper extends ActionProvider {
        final android.view.ActionProvider mInner;
        final /* synthetic */ MenuItemWrapperICS this$0;

        public ActionProviderWrapper(MenuItemWrapperICS r5, Context r10, android.view.ActionProvider r11) {
            this.this$0 = r5;
            super(r10);
            this.mInner = r11;
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
        public void onPrepareSubMenu(SubMenu r5) {
            this.mInner.onPrepareSubMenu(this.this$0.getSubMenuWrapper(r5));
        }
    }

    @RequiresApi(16)
    public class ActionProviderWrapperJB extends ActionProviderWrapper implements android.view.ActionProvider.VisibilityListener {
        private ActionProvider.VisibilityListener mListener;
        final /* synthetic */ MenuItemWrapperICS this$0;

        public ActionProviderWrapperJB(MenuItemWrapperICS r5, Context r10, android.view.ActionProvider r11) {
            this.this$0 = r5;
            super(r5, r10, r11);
        }

        @Override // androidx.core.view.ActionProvider
        public boolean isVisible() {
            return this.mInner.isVisible();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean r5) {
            ActionProvider.VisibilityListener r10 = this.mListener;
            if (r10 == null) goto L6;
            r10.onActionProviderVisibilityChanged(r5);
            return;
        }

        @Override // androidx.core.view.ActionProvider
        public View onCreateActionView(MenuItem r5) {
            return this.mInner.onCreateActionView(r5);
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
        public void setVisibilityListener(ActionProvider.VisibilityListener r5) {
            this.mListener = r5;
            android.view.ActionProvider r10 = this.mInner;
            if (r5 != null) goto L6;
            ActionProviderWrapperJB this = null;
        L6:
            r10.setVisibilityListener(this);
        }
    }

    public static class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {
        final android.view.CollapsibleActionView mWrappedView;

        /* JADX WARN: Multi-variable type inference failed */
        public CollapsibleActionViewWrapper(View r5) {
            super(r5.getContext());
            this.mWrappedView = (android.view.CollapsibleActionView) r5;
            addView(r5);
        }

        public View getWrappedView() {
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

    public class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {
        private final MenuItem.OnActionExpandListener mObject;
        final /* synthetic */ MenuItemWrapperICS this$0;

        public OnActionExpandListenerWrapper(MenuItemWrapperICS r5, MenuItem.OnActionExpandListener r10) {
            this.this$0 = r5;
            this.mObject = r10;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem r5) {
            return this.mObject.onMenuItemActionCollapse(this.this$0.getMenuItemWrapper(r5));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem r5) {
            return this.mObject.onMenuItemActionExpand(this.this$0.getMenuItemWrapper(r5));
        }
    }

    public class OnMenuItemClickListenerWrapper implements MenuItem.OnMenuItemClickListener {
        private final MenuItem.OnMenuItemClickListener mObject;
        final /* synthetic */ MenuItemWrapperICS this$0;

        public OnMenuItemClickListenerWrapper(MenuItemWrapperICS r5, MenuItem.OnMenuItemClickListener r10) {
            this.this$0 = r5;
            this.mObject = r10;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r5) {
            return this.mObject.onMenuItemClick(this.this$0.getMenuItemWrapper(r5));
        }
    }

    public MenuItemWrapperICS(Context r5, SupportMenuItem r10) {
        super(r5);
        if (r10 == null) goto L7;
        this.mWrappedObject = r10;
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
        ActionProvider r5 = this.mWrappedObject.getSupportActionProvider();
        if ((r5 instanceof ActionProviderWrapper) == true) goto L5;
        return null;
    L5:
        return ((ActionProviderWrapper) r5).mInner;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View r5 = this.mWrappedObject.getActionView();
        if ((r5 instanceof CollapsibleActionViewWrapper) == true) goto L5;
        return r5;
    L5:
        return ((CollapsibleActionViewWrapper) r5).getWrappedView();
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
    public MenuItem setActionProvider(android.view.ActionProvider r5) {
        ActionProviderWrapperJB r10 = new ActionProviderWrapperJB(this, this.mContext, r5);
        SupportMenuItem r11 = this.mWrappedObject;
        if (r5 != null) goto L6;
        r10 = null;
    L6:
        r11.setSupportActionProvider(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View r5) {
        if ((r5 instanceof android.view.CollapsibleActionView) == false) goto L5;
        r5 = new CollapsibleActionViewWrapper(r5);
    L5:
        this.mWrappedObject.setActionView(r5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r5) {
        this.mWrappedObject.setAlphabeticShortcut(r5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean r5) {
        this.mWrappedObject.setCheckable(r5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean r5) {
        this.mWrappedObject.setChecked(r5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence r5) {
        this.mWrappedObject.setContentDescription(r5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean r5) {
        this.mWrappedObject.setEnabled(r5);
        return this;
    }

    public void setExclusiveCheckable(boolean r5) {
    L5:
        e = move-exception;
        Log.w(LOG_TAG, "Error while calling setExclusiveCheckable", e);
        return;
    L3:
        if (this.mSetExclusiveCheckableMethod != null) goto L7;
        this.mSetExclusiveCheckableMethod = this.mWrappedObject.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});     // Catch: Exception -> L5
    L7:
        this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, new Object[]{Boolean.valueOf(r5)});     // Catch: Exception -> L5
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable r5) {
        this.mWrappedObject.setIcon(r5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList r5) {
        this.mWrappedObject.setIconTintList(r5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode r5) {
        this.mWrappedObject.setIconTintMode(r5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent r5) {
        this.mWrappedObject.setIntent(r5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char r5) {
        this.mWrappedObject.setNumericShortcut(r5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener r5) {
        SupportMenuItem r10 = this.mWrappedObject;
        if (r5 == null) goto L5;
        OnActionExpandListenerWrapper r11 = new OnActionExpandListenerWrapper(this, r5);
    L6:
        r10.setOnActionExpandListener(r11);
        return this;
    L5:
        r11 = null;
        goto L6
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener r5) {
        SupportMenuItem r10 = this.mWrappedObject;
        if (r5 == null) goto L5;
        OnMenuItemClickListenerWrapper r11 = new OnMenuItemClickListenerWrapper(this, r5);
    L6:
        r10.setOnMenuItemClickListener(r11);
        return this;
    L5:
        r11 = null;
        goto L6
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char r5, char r10) {
        this.mWrappedObject.setShortcut(r5, r10);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int r5) {
        this.mWrappedObject.setShowAsAction(r5);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int r5) {
        this.mWrappedObject.setShowAsActionFlags(r5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence r5) {
        this.mWrappedObject.setTitle(r5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence r5) {
        this.mWrappedObject.setTitleCondensed(r5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence r5) {
        this.mWrappedObject.setTooltipText(r5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean r5) {
        return this.mWrappedObject.setVisible(r5);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r5, int r10) {
        this.mWrappedObject.setAlphabeticShortcut(r5, r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int r5) {
        this.mWrappedObject.setIcon(r5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char r5, int r10) {
        this.mWrappedObject.setNumericShortcut(r5, r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char r5, char r10, int r11, int r12) {
        this.mWrappedObject.setShortcut(r5, r10, r11, r12);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int r5) {
        this.mWrappedObject.setTitle(r5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int r5) {
        this.mWrappedObject.setActionView(r5);
        View r10 = this.mWrappedObject.getActionView();
        if ((r10 instanceof android.view.CollapsibleActionView) == false) goto L5;
        this.mWrappedObject.setActionView(new CollapsibleActionViewWrapper(r10));
    L5:
        return this;
    }
}
