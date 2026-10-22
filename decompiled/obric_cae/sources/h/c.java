package h;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.m;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class c extends h.b implements MenuItem {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0.b f7851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Method f7852e;

    public class a extends j0.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ActionProvider f7853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f7854c;

        public a(c r8, ActionProvider r10) {
            this.f7854c = r8;
            this.f7853b = r10;
        }

        @Override // j0.b
        public final boolean a() {
            return this.f7853b.hasSubMenu();
        }

        @Override // j0.b
        public final View c() {
            return this.f7853b.onCreateActionView();
        }

        @Override // j0.b
        public final boolean e() {
            return this.f7853b.onPerformDefaultAction();
        }

        @Override // j0.b
        public final void f(m r8) {
            SubMenu r10 = this.f7854c.d(r8);
            this.f7853b.onPrepareSubMenu(r10);
        }
    }

    public class b extends a implements ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public j0.b.a f7855d;

        @Override // j0.b
        public final boolean b() {
            return this.f7853b.isVisible();
        }

        @Override // j0.b
        public final View d(MenuItem r8) {
            return this.f7853b.onCreateActionView(r8);
        }

        @Override // j0.b
        public final boolean g() {
            return this.f7853b.overridesItemVisibility();
        }

        @Override // j0.b
        public final void h(h.a r8) {
            this.f7855d = r8;
            this.f7853b.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public final void onActionProviderVisibilityChanged(boolean r8) {
            j0.b.a r10 = this.f7855d;
            if (r10 == null) goto L6;
            androidx.appcompat.view.menu.f r11 = ((h.a) r10).f869a.f856n;
            r11.f822h = true;
            r11.q(true);
            return;
        }
    }

    /* JADX INFO: renamed from: h.c$c, reason: collision with other inner class name */
    public static class C0081c extends FrameLayout implements g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CollapsibleActionView f7856a;

        /* JADX WARN: Multi-variable type inference failed */
        public C0081c(View r8) {
            super(r8.getContext());
            this.f7856a = (CollapsibleActionView) r8;
            addView(r8);
        }

        @Override // g.c
        public final void onActionViewCollapsed() {
            this.f7856a.onActionViewCollapsed();
        }

        @Override // g.c
        public final void onActionViewExpanded() {
            this.f7856a.onActionViewExpanded();
        }
    }

    public class d implements MenuItem.OnActionExpandListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MenuItem.OnActionExpandListener f7857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f7858b;

        public d(c r8, MenuItem.OnActionExpandListener r10) {
            this.f7858b = r8;
            this.f7857a = r10;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public final boolean onMenuItemActionCollapse(MenuItem r8) {
            MenuItem r10 = this.f7858b.c(r8);
            return this.f7857a.onMenuItemActionCollapse(r10);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public final boolean onMenuItemActionExpand(MenuItem r8) {
            MenuItem r10 = this.f7858b.c(r8);
            return this.f7857a.onMenuItemActionExpand(r10);
        }
    }

    public class e implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MenuItem.OnMenuItemClickListener f7859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f7860b;

        public e(c r8, MenuItem.OnMenuItemClickListener r10) {
            this.f7860b = r8;
            this.f7859a = r10;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem r8) {
            MenuItem r10 = this.f7860b.c(r8);
            return this.f7859a.onMenuItemClick(r10);
        }
    }

    public c(Context r8, c0.b r10) {
        super(r8);
        if (r10 == null) goto L7;
        this.f7851d = r10;
        return;
    L7:
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return this.f7851d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return this.f7851d.expandActionView();
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        j0.b r8 = this.f7851d.b();
        if ((r8 instanceof a) == true) goto L5;
        return null;
    L5:
        return ((a) r8).f7853b;
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View r8 = this.f7851d.getActionView();
        if ((r8 instanceof C0081c) == true) goto L5;
        return r8;
    L5:
        return (View) ((C0081c) r8).f7856a;
    }

    @Override // android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f7851d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f7851d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f7851d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f7851d.getGroupId();
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f7851d.getIcon();
    }

    @Override // android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f7851d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f7851d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f7851d.getIntent();
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f7851d.getItemId();
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f7851d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f7851d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f7851d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f7851d.getOrder();
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return d(this.f7851d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f7851d.getTitle();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        return this.f7851d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f7851d.getTooltipText();
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f7851d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f7851d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return this.f7851d.isCheckable();
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return this.f7851d.isChecked();
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return this.f7851d.isEnabled();
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return this.f7851d.isVisible();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider r8) {
        b r10 = new b(this, r8);
        if (r8 != null) goto L6;
        r10 = null;
    L6:
        this.f7851d.a(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int r8) {
        c0.b r10 = this.f7851d;
        r10.setActionView(r8);
        View r11 = r10.getActionView();
        if ((r11 instanceof CollapsibleActionView) == false) goto L5;
        r10.setActionView(new C0081c(r11));
    L5:
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char r8) {
        this.f7851d.setAlphabeticShortcut(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean r8) {
        this.f7851d.setCheckable(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean r8) {
        this.f7851d.setChecked(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence r8) {
        this.f7851d.setContentDescription(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean r8) {
        this.f7851d.setEnabled(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int r8) {
        this.f7851d.setIcon(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList r8) {
        this.f7851d.setIconTintList(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode r8) {
        this.f7851d.setIconTintMode(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent r8) {
        this.f7851d.setIntent(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char r8) {
        this.f7851d.setNumericShortcut(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener r8) {
        if (r8 == null) goto L4;
        d r10 = new d(this, r8);
    L5:
        this.f7851d.setOnActionExpandListener(r10);
        return this;
    L4:
        r10 = null;
        goto L5
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener r8) {
        if (r8 == null) goto L4;
        e r10 = new e(this, r8);
    L5:
        this.f7851d.setOnMenuItemClickListener(r10);
        return this;
    L4:
        r10 = null;
        goto L5
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char r8, char r10) {
        this.f7851d.setShortcut(r8, r10);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int r8) {
        this.f7851d.setShowAsAction(r8);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int r8) {
        this.f7851d.setShowAsActionFlags(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int r8) {
        this.f7851d.setTitle(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence r8) {
        this.f7851d.setTitleCondensed(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence r8) {
        this.f7851d.setTooltipText(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean r8) {
        return this.f7851d.setVisible(r8);
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View r8) {
        if ((r8 instanceof CollapsibleActionView) == false) goto L5;
        r8 = new C0081c(r8);
    L5:
        this.f7851d.setActionView(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char r8, int r10) {
        this.f7851d.setAlphabeticShortcut(r8, r10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable r8) {
        this.f7851d.setIcon(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char r8, int r10) {
        this.f7851d.setNumericShortcut(r8, r10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char r8, char r10, int r11, int r12) {
        this.f7851d.setShortcut(r8, r10, r11, r12);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence r8) {
        this.f7851d.setTitle(r8);
        return this;
    }
}
