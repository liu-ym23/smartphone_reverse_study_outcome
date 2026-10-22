package h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: loaded from: classes.dex */
public class e extends b implements Menu {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0.a f7862d;

    public e(Context r8, c0.a r10) {
        super(r8);
        if (r10 == null) goto L7;
        this.f7862d = r10;
        return;
    L7:
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public final MenuItem add(int r8) {
        return c(this.f7862d.add(r8));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int r13, int r14, int r15, ComponentName r16, Intent[] r17, Intent r18, int r19, MenuItem[] r20) {
        if (r20 == null) goto L5;
        MenuItem[] r8 = new MenuItem[r20.length];
    L6:
        int r10 = this.f7862d.addIntentOptions(r13, r14, r15, r16, r17, r18, r19, r8);
        if (r8 == null) goto L11;
        int r11 = r8.length;
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L11;
        r20[r12] = c(r8[r12]);
        r12 = r12 + 1;
    L11:
        return r10;
    L5:
        r8 = null;
        goto L6
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int r8) {
        return d(this.f7862d.addSubMenu(r8));
    }

    @Override // android.view.Menu
    public final void clear() {
        e();
        this.f7862d.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.f7862d.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int r8) {
        return c(this.f7862d.findItem(r8));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int r8) {
        return c(this.f7862d.getItem(r8));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.f7862d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int r8, KeyEvent r10) {
        return this.f7862d.isShortcutKey(r8, r10);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int r8, int r10) {
        return this.f7862d.performIdentifierAction(r8, r10);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int r8, KeyEvent r10, int r11) {
        return this.f7862d.performShortcut(r8, r10, r11);
    }

    @Override // android.view.Menu
    public final void removeGroup(int r8) {
        f(r8);
        this.f7862d.removeGroup(r8);
    }

    @Override // android.view.Menu
    public final void removeItem(int r8) {
        g(r8);
        this.f7862d.removeItem(r8);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int r8, boolean r10, boolean r11) {
        this.f7862d.setGroupCheckable(r8, r10, r11);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int r8, boolean r10) {
        this.f7862d.setGroupEnabled(r8, r10);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int r8, boolean r10) {
        this.f7862d.setGroupVisible(r8, r10);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean r8) {
        this.f7862d.setQwertyMode(r8);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f7862d.size();
    }

    @Override // android.view.Menu
    public final MenuItem add(int r8, int r10, int r11, int r12) {
        return c(this.f7862d.add(r8, r10, r11, r12));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int r8, int r10, int r11, int r12) {
        return d(this.f7862d.addSubMenu(r8, r10, r11, r12));
    }

    @Override // android.view.Menu
    public final MenuItem add(int r8, int r10, int r11, CharSequence r12) {
        return c(this.f7862d.add(r8, r10, r11, r12));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int r8, int r10, int r11, CharSequence r12) {
        return d(this.f7862d.addSubMenu(r8, r10, r11, r12));
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence r8) {
        return c(this.f7862d.add(r8));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence r8) {
        return d(this.f7862d.addSubMenu(r8));
    }
}
