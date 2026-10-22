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

    public MenuWrapperICS(Context r5, SupportMenu r10) {
        super(r5);
        if (r10 == null) goto L7;
        this.mWrappedObject = r10;
        return;
    L7:
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence r5) {
        return getMenuItemWrapper(this.mWrappedObject.add(r5));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int r13, int r14, int r15, ComponentName r16, Intent[] r17, Intent r18, int r19, MenuItem[] r20) {
        if (r20 == null) goto L5;
        MenuItem[] r5 = new MenuItem[r20.length];
    L6:
        int r10 = this.mWrappedObject.addIntentOptions(r13, r14, r15, r16, r17, r18, r19, r5);
        if (r5 == null) goto L11;
        int r11 = r5.length;
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L11;
        r20[r12] = getMenuItemWrapper(r5[r12]);
        r12 = r12 + 1;
    L11:
        return r10;
    L5:
        r5 = null;
        goto L6
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence r5) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r5));
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
    public MenuItem findItem(int r5) {
        return getMenuItemWrapper(this.mWrappedObject.findItem(r5));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int r5) {
        return getMenuItemWrapper(this.mWrappedObject.getItem(r5));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.mWrappedObject.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int r5, KeyEvent r10) {
        return this.mWrappedObject.isShortcutKey(r5, r10);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int r5, int r10) {
        return this.mWrappedObject.performIdentifierAction(r5, r10);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int r5, KeyEvent r10, int r11) {
        return this.mWrappedObject.performShortcut(r5, r10, r11);
    }

    @Override // android.view.Menu
    public void removeGroup(int r5) {
        internalRemoveGroup(r5);
        this.mWrappedObject.removeGroup(r5);
    }

    @Override // android.view.Menu
    public void removeItem(int r5) {
        internalRemoveItem(r5);
        this.mWrappedObject.removeItem(r5);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int r5, boolean r10, boolean r11) {
        this.mWrappedObject.setGroupCheckable(r5, r10, r11);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int r5, boolean r10) {
        this.mWrappedObject.setGroupEnabled(r5, r10);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int r5, boolean r10) {
        this.mWrappedObject.setGroupVisible(r5, r10);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean r5) {
        this.mWrappedObject.setQwertyMode(r5);
    }

    @Override // android.view.Menu
    public int size() {
        return this.mWrappedObject.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int r5) {
        return getMenuItemWrapper(this.mWrappedObject.add(r5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r5) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r5));
    }

    @Override // android.view.Menu
    public MenuItem add(int r5, int r10, int r11, CharSequence r12) {
        return getMenuItemWrapper(this.mWrappedObject.add(r5, r10, r11, r12));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r5, int r10, int r11, CharSequence r12) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r5, r10, r11, r12));
    }

    @Override // android.view.Menu
    public MenuItem add(int r5, int r10, int r11, int r12) {
        return getMenuItemWrapper(this.mWrappedObject.add(r5, r10, r11, r12));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r5, int r10, int r11, int r12) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r5, r10, r11, r12));
    }
}
