package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.internal.view.SupportMenu;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class MenuWrapperICS extends BaseMenuWrapper implements Menu {
    private final SupportMenu mWrappedObject;

    public MenuWrapperICS(Context r3, SupportMenu r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        SupportMenu r6 = (SupportMenu) ZeusTransformUtils.wrapperContextForParams(r4, SupportMenu.class, "com.obric.memorydata.plugin");
        super(r5);
        if (r6 == null) goto L7;
        this.mWrappedObject = r6;
        return;
    L7:
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public MenuItem add(int r2) {
        return getMenuItemWrapper(this.mWrappedObject.add(r2));
    }

    @Override // android.view.Menu
    public MenuItem add(int r2, int r3, int r4, int r5) {
        return getMenuItemWrapper(this.mWrappedObject.add(r2, r3, r4, r5));
    }

    @Override // android.view.Menu
    public MenuItem add(int r3, int r4, int r5, CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        return getMenuItemWrapper(this.mWrappedObject.add(r3, r4, r5, r7));
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        return getMenuItemWrapper(this.mWrappedObject.add(r4));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int r13, int r14, int r15, ComponentName r16, Intent[] r17, Intent r18, int r19, MenuItem[] r20) {
        if (r20 == null) goto L5;
        MenuItem[] r2 = new MenuItem[r20.length];
    L6:
        int r3 = this.mWrappedObject.addIntentOptions(r13, r14, r15, r16, r17, r18, r19, r2);
        if (r2 == null) goto L11;
        int r4 = 0;
        int r5 = r2.length;
    L9:
        if (r4 >= r5) goto L11;
        r20[r4] = getMenuItemWrapper(r2[r4]);
        r4 = r4 + 1;
    L11:
        return r3;
    L5:
        r2 = null;
        goto L6
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r2) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r2));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r2, int r3, int r4, int r5) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r2, r3, r4, r5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r3, int r4, int r5, CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r3, r4, r5, r7));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r4));
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
    public MenuItem findItem(int r2) {
        return getMenuItemWrapper(this.mWrappedObject.findItem(r2));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int r2) {
        return getMenuItemWrapper(this.mWrappedObject.getItem(r2));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.mWrappedObject.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int r1, KeyEvent r2) {
        return this.mWrappedObject.isShortcutKey(r1, r2);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int r1, int r2) {
        return this.mWrappedObject.performIdentifierAction(r1, r2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int r1, KeyEvent r2, int r3) {
        return this.mWrappedObject.performShortcut(r1, r2, r3);
    }

    @Override // android.view.Menu
    public void removeGroup(int r1) {
        internalRemoveGroup(r1);
        this.mWrappedObject.removeGroup(r1);
    }

    @Override // android.view.Menu
    public void removeItem(int r1) {
        internalRemoveItem(r1);
        this.mWrappedObject.removeItem(r1);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int r1, boolean r2, boolean r3) {
        this.mWrappedObject.setGroupCheckable(r1, r2, r3);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int r1, boolean r2) {
        this.mWrappedObject.setGroupEnabled(r1, r2);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int r1, boolean r2) {
        this.mWrappedObject.setGroupVisible(r1, r2);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean r1) {
        this.mWrappedObject.setQwertyMode(r1);
    }

    @Override // android.view.Menu
    public int size() {
        return this.mWrappedObject.size();
    }
}
