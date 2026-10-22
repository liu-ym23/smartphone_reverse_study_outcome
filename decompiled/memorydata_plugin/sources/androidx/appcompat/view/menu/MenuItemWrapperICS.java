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
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class MenuItemWrapperICS extends BaseMenuWrapper implements MenuItem {
    static final String LOG_TAG = "MenuItemWrapper";
    private Method mSetExclusiveCheckableMethod;
    private final SupportMenuItem mWrappedObject;

    private class ActionProviderWrapper extends ActionProvider {
        final android.view.ActionProvider mInner;
        final /* synthetic */ MenuItemWrapperICS this$0;

        ActionProviderWrapper(MenuItemWrapperICS r3, Context r4, android.view.ActionProvider r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r6);
            this.mInner = r5;
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
        public void onPrepareSubMenu(SubMenu r3) {
            SubMenu r4 = (SubMenu) ZeusTransformUtils.wrapperContextForParams(r3, SubMenu.class, "com.obric.memorydata.plugin");
            this.mInner.onPrepareSubMenu(this.this$0.getSubMenuWrapper(r4));
        }
    }

    private class ActionProviderWrapperJB extends ActionProviderWrapper implements android.view.ActionProvider.VisibilityListener {
        private ActionProvider.VisibilityListener mListener;
        final /* synthetic */ MenuItemWrapperICS this$0;

        ActionProviderWrapperJB(MenuItemWrapperICS r3, Context r4, android.view.ActionProvider r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r3, r6, r5);
        }

        @Override // androidx.core.view.ActionProvider
        public boolean isVisible() {
            return this.mInner.isVisible();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean r1) {
            ActionProvider.VisibilityListener r0 = this.mListener;
            if (r0 == null) goto L6;
            r0.onActionProviderVisibilityChanged(r1);
            return;
        }

        @Override // androidx.core.view.ActionProvider
        public View onCreateActionView(MenuItem r3) {
            MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin");
            return this.mInner.onCreateActionView(r4);
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
        public void setVisibilityListener(ActionProvider.VisibilityListener r3) {
            ActionProvider.VisibilityListener r4 = (ActionProvider.VisibilityListener) ZeusTransformUtils.wrapperContextForParams(r3, ActionProvider.VisibilityListener.class, "com.obric.memorydata.plugin");
            this.mListener = r4;
            android.view.ActionProvider r0 = this.mInner;
            if (r4 != null) goto L6;
            ActionProviderWrapperJB this = null;
        L6:
            r0.setVisibilityListener(this);
        }
    }

    static class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {
        final android.view.CollapsibleActionView mWrappedView;

        CollapsibleActionViewWrapper(View r4) {
            super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            this.mWrappedView = (android.view.CollapsibleActionView) ZeusTransformUtils.preCheckCast(r4, android.view.CollapsibleActionView.class, "com.obric.memorydata.plugin");
            addView(r4);
        }

        View getWrappedView() {
            return (View) ZeusTransformUtils.preCheckCast(this.mWrappedView, View.class, "com.obric.memorydata.plugin");
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

        OnActionExpandListenerWrapper(MenuItemWrapperICS r3, MenuItem.OnActionExpandListener r4) {
            MenuItem.OnActionExpandListener r5 = (MenuItem.OnActionExpandListener) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.OnActionExpandListener.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.mObject = r5;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem r3) {
            MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin");
            return this.mObject.onMenuItemActionCollapse(this.this$0.getMenuItemWrapper(r4));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem r3) {
            MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin");
            return this.mObject.onMenuItemActionExpand(this.this$0.getMenuItemWrapper(r4));
        }
    }

    private class OnMenuItemClickListenerWrapper implements MenuItem.OnMenuItemClickListener {
        private final MenuItem.OnMenuItemClickListener mObject;
        final /* synthetic */ MenuItemWrapperICS this$0;

        OnMenuItemClickListenerWrapper(MenuItemWrapperICS r3, MenuItem.OnMenuItemClickListener r4) {
            MenuItem.OnMenuItemClickListener r5 = (MenuItem.OnMenuItemClickListener) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.OnMenuItemClickListener.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.mObject = r5;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r3) {
            MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin");
            return this.mObject.onMenuItemClick(this.this$0.getMenuItemWrapper(r4));
        }
    }

    public MenuItemWrapperICS(Context r3, SupportMenuItem r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        SupportMenuItem r6 = (SupportMenuItem) ZeusTransformUtils.wrapperContextForParams(r4, SupportMenuItem.class, "com.obric.memorydata.plugin");
        super(r5);
        if (r6 == null) goto L7;
        this.mWrappedObject = r6;
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
        ActionProvider r2 = this.mWrappedObject.getSupportActionProvider();
        if (ZeusTransformUtils.instanceOf(r2, ActionProviderWrapper.class) == true) goto L5;
        return null;
    L5:
        return ((ActionProviderWrapper) ZeusTransformUtils.preCheckCast(r2, ActionProviderWrapper.class, "com.obric.memorydata.plugin")).mInner;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View r2 = this.mWrappedObject.getActionView();
        if (ZeusTransformUtils.instanceOf(r2, CollapsibleActionViewWrapper.class) == true) goto L5;
        return r2;
    L5:
        return ((CollapsibleActionViewWrapper) ZeusTransformUtils.preCheckCast(r2, CollapsibleActionViewWrapper.class, "com.obric.memorydata.plugin")).getWrappedView();
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
    public MenuItem setActionProvider(android.view.ActionProvider r3) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        ActionProvider r0 = new ActionProviderWrapperJB(this, this.mContext, r3);
    L6:
        SupportMenuItem r1 = this.mWrappedObject;
        if (r3 != null) goto L10;
        r0 = null;
    L10:
        r1.setSupportActionProvider(r0);
        return this;
    L5:
        r0 = new ActionProviderWrapper(this, this.mContext, r3);
        goto L6
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int r3) {
        this.mWrappedObject.setActionView(r3);
        View r4 = this.mWrappedObject.getActionView();
        if (ZeusTransformUtils.instanceOf(r4, android.view.CollapsibleActionView.class) == false) goto L5;
        this.mWrappedObject.setActionView(new CollapsibleActionViewWrapper(r4));
    L5:
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View r2) {
        if (ZeusTransformUtils.instanceOf(r2, android.view.CollapsibleActionView.class) == false) goto L5;
        r2 = new CollapsibleActionViewWrapper(r2);
    L5:
        this.mWrappedObject.setActionView(r2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r2) {
        this.mWrappedObject.setAlphabeticShortcut(r2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r2, int r3) {
        this.mWrappedObject.setAlphabeticShortcut(r2, r3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean r2) {
        this.mWrappedObject.setCheckable(r2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean r2) {
        this.mWrappedObject.setChecked(r2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mWrappedObject.setContentDescription(r4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean r2) {
        this.mWrappedObject.setEnabled(r2);
        return this;
    }

    public void setExclusiveCheckable(boolean r7) {
    L7:
        e = move-exception;
        Log.w(LOG_TAG, "Error while calling setExclusiveCheckable", e);
        return;
    L3:
        if (this.mSetExclusiveCheckableMethod != null) goto L5;
        this.mSetExclusiveCheckableMethod = this.mWrappedObject.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});     // Catch: Exception -> L7
    L5:
        this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, new Object[]{Boolean.valueOf(r7)});     // Catch: Exception -> L7
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int r2) {
        this.mWrappedObject.setIcon(r2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable r2) {
        this.mWrappedObject.setIcon(r2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList r2) {
        this.mWrappedObject.setIconTintList(r2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode r2) {
        this.mWrappedObject.setIconTintMode(r2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent r2) {
        this.mWrappedObject.setIntent(r2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char r2) {
        this.mWrappedObject.setNumericShortcut(r2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char r2, int r3) {
        this.mWrappedObject.setNumericShortcut(r2, r3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener r3) {
        MenuItem.OnActionExpandListener r4 = (MenuItem.OnActionExpandListener) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.OnActionExpandListener.class, "com.obric.memorydata.plugin");
        SupportMenuItem r0 = this.mWrappedObject;
        if (r4 == null) goto L5;
        OnActionExpandListenerWrapper r1 = new OnActionExpandListenerWrapper(this, r4);
    L6:
        r0.setOnActionExpandListener(r1);
        return this;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener r3) {
        MenuItem.OnMenuItemClickListener r4 = (MenuItem.OnMenuItemClickListener) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.OnMenuItemClickListener.class, "com.obric.memorydata.plugin");
        SupportMenuItem r0 = this.mWrappedObject;
        if (r4 == null) goto L5;
        OnMenuItemClickListenerWrapper r1 = new OnMenuItemClickListenerWrapper(this, r4);
    L6:
        r0.setOnMenuItemClickListener(r1);
        return this;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char r2, char r3) {
        this.mWrappedObject.setShortcut(r2, r3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char r2, char r3, int r4, int r5) {
        this.mWrappedObject.setShortcut(r2, r3, r4, r5);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int r1) {
        this.mWrappedObject.setShowAsAction(r1);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int r2) {
        this.mWrappedObject.setShowAsActionFlags(r2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int r2) {
        this.mWrappedObject.setTitle(r2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mWrappedObject.setTitle(r4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mWrappedObject.setTitleCondensed(r4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mWrappedObject.setTooltipText(r4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean r1) {
        return this.mWrappedObject.setVisible(r1);
    }
}
