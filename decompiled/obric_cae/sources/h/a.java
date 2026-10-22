package h;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class a implements c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f7832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f7833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Intent f7834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public char f7835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public char f7837f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7838g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f7839h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f7840i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f7841j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f7842k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f7843l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f7844m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f7845n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7846o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f7847p;

    public a(Context r8, CharSequence r10) {
        this.f7836e = 4096;
        this.f7838g = 4096;
        this.f7843l = null;
        this.f7844m = null;
        this.f7845n = false;
        this.f7846o = false;
        this.f7847p = 16;
        this.f7840i = r8;
        this.f7832a = r10;
    }

    @Override // c0.b
    public final c0.b a(j0.b r8) {
        throw new UnsupportedOperationException();
    }

    @Override // c0.b
    public final j0.b b() {
        return null;
    }

    public final void c() {
        Drawable r8 = this.f7839h;
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.f7845n == false) goto L7;
    L8:
        this.f7839h = r8;
        Drawable r10 = r8.mutate();
        this.f7839h = r10;
        if (this.f7845n == false) goto L12;
        b0.a.b.h(r10, this.f7843l);
    L12:
        if (this.f7846o == false) goto L17;
        b0.a.b.i(this.f7839h, this.f7844m);
        return;
    L17:
        return;
    L7:
        if (this.f7846o == true) goto L8;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // c0.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f7838g;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f7837f;
    }

    @Override // c0.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f7841j;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f7839h;
    }

    @Override // c0.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f7843l;
    }

    @Override // c0.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f7844m;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f7834c;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return R.id.home;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // c0.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f7836e;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f7835d;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f7832a;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence r8 = this.f7833b;
        if (r8 == null) goto L6;
        return r8;
    L6:
        return this.f7832a;
    }

    @Override // c0.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f7842k;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        if ((this.f7847p & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        if ((this.f7847p & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        if ((this.f7847p & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        if ((this.f7847p & 8) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean requiresActionButton() {
        return true;
    }

    public final boolean requiresOverflow() {
        return false;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider r8) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int r8) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char r8) {
        this.f7837f = Character.toLowerCase(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean r8) {
        int r10 = this.f7847p & (-2);
        this.f7847p = (r8 ? 1 : 0) | r10;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean r8) {
        int r10 = this.f7847p & (-3);
        if (r8 == false) goto L5;
        int r11 = 2;
    L6:
        this.f7847p = r11 | r10;
        return this;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence r8) {
        this.f7841j = r8;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean r8) {
        int r10 = this.f7847p & (-17);
        if (r8 == false) goto L5;
        int r11 = 16;
    L6:
        this.f7847p = r11 | r10;
        return this;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int r8) {
        Object r10 = androidx.core.content.a.f1674a;
        this.f7839h = androidx.core.content.a.b.b(this.f7840i, r8);
        c();
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList r8) {
        this.f7843l = r8;
        this.f7845n = true;
        c();
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode r8) {
        this.f7844m = r8;
        this.f7846o = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent r8) {
        this.f7834c = r8;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char r8) {
        this.f7835d = r8;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener r8) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener r8) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char r8, char r10) {
        this.f7835d = r8;
        this.f7837f = Character.toLowerCase(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int r8) {
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int r8) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int r8) {
        this.f7832a = this.f7840i.getResources().getString(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence r8) {
        this.f7833b = r8;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence r8) {
        this.f7842k = r8;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean r8) {
        int r10 = 8;
        int r11 = this.f7847p & 8;
        if (r8 == false) goto L5;
        r10 = 0;
    L5:
        this.f7847p = r11 | r10;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View r8) {
        throw new UnsupportedOperationException();
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char r8, int r10) {
        this.f7837f = Character.toLowerCase(r8);
        this.f7838g = KeyEvent.normalizeMetaState(r10);
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final c0.b setContentDescription(CharSequence r8) {
        this.f7841j = r8;
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char r8, int r10) {
        this.f7835d = r8;
        this.f7836e = KeyEvent.normalizeMetaState(r10);
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setShortcut(char r8, char r10, int r11, int r12) {
        this.f7835d = r8;
        this.f7836e = KeyEvent.normalizeMetaState(r11);
        this.f7837f = Character.toLowerCase(r10);
        this.f7838g = KeyEvent.normalizeMetaState(r12);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence r8) {
        this.f7832a = r8;
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final c0.b setTooltipText(CharSequence r8) {
        this.f7842k = r8;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable r8) {
        this.f7839h = r8;
        c();
        return this;
    }
}
