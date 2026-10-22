package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuWrapperICS extends BaseMenuWrapper implements Menu {
    private final SupportMenu mWrappedObject;

    public MenuWrapperICS(Context r10, SupportMenu r11) {
        super(r10);
        if (r11 == null) goto L7;
        this.mWrappedObject = r11;
        return;
    L7:
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public MenuItem add(int r10) {
        return getMenuItemWrapper(this.mWrappedObject.add(r10));
    }

    @Override // android.view.Menu
    public MenuItem add(int r10, int r11, int r12, int r13) {
        return getMenuItemWrapper(this.mWrappedObject.add(r10, r11, r12, r13));
    }

    @Override // android.view.Menu
    public MenuItem add(int r10, int r11, int r12, CharSequence r13) {
        return getMenuItemWrapper(this.mWrappedObject.add(r10, r11, r12, r13));
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence r10) {
        return getMenuItemWrapper(this.mWrappedObject.add(r10));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int r13, int r14, int r15, ComponentName r16, Intent[] r17, Intent r18, int r19, MenuItem[] r20) {
        if (r20 == null) goto L5;
        MenuItem[] r10 = new MenuItem[r20.length];
    L6:
        int r11 = this.mWrappedObject.addIntentOptions(r13, r14, r15, r16, r17, r18, r19, r10);
        if (r10 == null) goto L11;
        int r12 = 0;
        int r21 = r10.length;
    L9:
        if (r12 >= r21) goto L11;
        r20[r12] = getMenuItemWrapper(r10[r12]);
        r12 = r12 + 1;
    L11:
        return r11;
    L5:
        r10 = null;
        goto L6
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r10) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r10, int r11, int r12, int r13) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r10, r11, r12, r13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r10, int r11, int r12, CharSequence r13) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r10, r11, r12, r13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence r10) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r10));
    }

    @Override // android.view.Menu
    public void clear() {
        internalClear();
        this.mWrappedObject.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.mWrappedObject.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int r10) {
        return getMenuItemWrapper(this.mWrappedObject.findItem(r10));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int r10) {
        return getMenuItemWrapper(this.mWrappedObject.getItem(r10));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.mWrappedObject.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int r10, KeyEvent r11) {
        return this.mWrappedObject.isShortcutKey(r10, r11);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int r10, int r11) {
        return this.mWrappedObject.performIdentifierAction(r10, r11);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int r10, KeyEvent r11, int r12) {
        return this.mWrappedObject.performShortcut(r10, r11, r12);
    }

    @Override // android.view.Menu
    public void removeGroup(int r10) {
        internalRemoveGroup(r10);
        this.mWrappedObject.removeGroup(r10);
    }

    @Override // android.view.Menu
    public void removeItem(int r10) {
        internalRemoveItem(r10);
        this.mWrappedObject.removeItem(r10);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int r10, boolean r11, boolean r12) {
        this.mWrappedObject.setGroupCheckable(r10, r11, r12);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int r10, boolean r11) {
        this.mWrappedObject.setGroupEnabled(r10, r11);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int r10, boolean r11) {
        this.mWrappedObject.setGroupVisible(r10, r11);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean r10) {
        this.mWrappedObject.setQwertyMode(r10);
    }

    @Override // android.view.Menu
    public int size() {
        return this.mWrappedObject.size();
    }
}
