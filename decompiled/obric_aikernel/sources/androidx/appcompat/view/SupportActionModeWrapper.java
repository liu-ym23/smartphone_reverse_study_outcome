package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SupportActionModeWrapper extends android.view.ActionMode {
    final Context mContext;
    final ActionMode mWrappedObject;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class CallbackWrapper implements ActionMode.Callback {
        final ArrayList<SupportActionModeWrapper> mActionModes;
        final Context mContext;
        final SimpleArrayMap<Menu, Menu> mMenus;
        final android.view.ActionMode.Callback mWrappedCallback;

        public CallbackWrapper(Context r10, android.view.ActionMode.Callback r11) {
            this.mContext = r10;
            this.mWrappedCallback = r11;
            this.mActionModes = new ArrayList();
            this.mMenus = new SimpleArrayMap();
        }

        private Menu getMenuWrapper(Menu r10) {
            Menu r11 = this.mMenus.get(r10);
            if (r11 != null) goto L6;
            MenuWrapperICS r12 = new MenuWrapperICS(this.mContext, (SupportMenu) r10);
            this.mMenus.put(r10, r12);
            return r12;
        L6:
            return r11;
        }

        public android.view.ActionMode getActionModeWrapper(ActionMode r10) {
            int r11 = this.mActionModes.size();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L10;
            SupportActionModeWrapper r13 = this.mActionModes.get(r12);
            if (r13 == null) goto L9;
            if (r13.mWrappedObject != r10) goto L9;
            return r13;
        L9:
            r12 = r12 + 1;
            goto L3
        L10:
            SupportActionModeWrapper r14 = new SupportActionModeWrapper(this.mContext, r10);
            this.mActionModes.add(r14);
            return r14;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r10, MenuItem r11) {
            return this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(r10), new MenuItemWrapperICS(this.mContext, (SupportMenuItem) r11));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r10, Menu r11) {
            return this.mWrappedCallback.onCreateActionMode(getActionModeWrapper(r10), getMenuWrapper(r11));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r10) {
            this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(r10));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r10, Menu r11) {
            return this.mWrappedCallback.onPrepareActionMode(getActionModeWrapper(r10), getMenuWrapper(r11));
        }
    }

    public SupportActionModeWrapper(Context r10, ActionMode r11) {
        this.mContext = r10;
        this.mWrappedObject = r11;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.mWrappedObject.finish();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.mWrappedObject.getCustomView();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuWrapperICS(this.mContext, (SupportMenu) this.mWrappedObject.getMenu());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.mWrappedObject.getMenuInflater();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.mWrappedObject.getSubtitle();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.mWrappedObject.getTag();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.mWrappedObject.getTitleOptionalHint();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.mWrappedObject.invalidate();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.mWrappedObject.isTitleOptional();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View r10) {
        this.mWrappedObject.setCustomView(r10);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int r10) {
        this.mWrappedObject.setSubtitle(r10);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence r10) {
        this.mWrappedObject.setSubtitle(r10);
    }

    @Override // android.view.ActionMode
    public void setTag(Object r10) {
        this.mWrappedObject.setTag(r10);
    }

    @Override // android.view.ActionMode
    public void setTitle(int r10) {
        this.mWrappedObject.setTitle(r10);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence r10) {
        this.mWrappedObject.setTitle(r10);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean r10) {
        this.mWrappedObject.setTitleOptionalHint(r10);
    }
}
