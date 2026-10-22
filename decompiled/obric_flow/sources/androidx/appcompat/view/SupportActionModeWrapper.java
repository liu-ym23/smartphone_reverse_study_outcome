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

        public CallbackWrapper(Context r5, android.view.ActionMode.Callback r10) {
            this.mContext = r5;
            this.mWrappedCallback = r10;
            this.mActionModes = new ArrayList();
            this.mMenus = new SimpleArrayMap();
        }

        private Menu getMenuWrapper(Menu r5) {
            Menu r10 = this.mMenus.get(r5);
            if (r10 != null) goto L6;
            MenuWrapperICS r11 = new MenuWrapperICS(this.mContext, (SupportMenu) r5);
            this.mMenus.put(r5, r11);
            return r11;
        L6:
            return r10;
        }

        public android.view.ActionMode getActionModeWrapper(ActionMode r5) {
            int r10 = this.mActionModes.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L10;
            SupportActionModeWrapper r12 = this.mActionModes.get(r11);
            if (r12 == null) goto L9;
            if (r12.mWrappedObject != r5) goto L9;
            return r12;
        L9:
            r11 = r11 + 1;
            goto L3
        L10:
            SupportActionModeWrapper r13 = new SupportActionModeWrapper(this.mContext, r5);
            this.mActionModes.add(r13);
            return r13;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r5, MenuItem r10) {
            return this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(r5), new MenuItemWrapperICS(this.mContext, (SupportMenuItem) r10));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r5, Menu r10) {
            return this.mWrappedCallback.onCreateActionMode(getActionModeWrapper(r5), getMenuWrapper(r10));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r5) {
            this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(r5));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r5, Menu r10) {
            return this.mWrappedCallback.onPrepareActionMode(getActionModeWrapper(r5), getMenuWrapper(r10));
        }
    }

    public SupportActionModeWrapper(Context r5, ActionMode r10) {
        this.mContext = r5;
        this.mWrappedObject = r10;
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
    public void setCustomView(View r5) {
        this.mWrappedObject.setCustomView(r5);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence r5) {
        this.mWrappedObject.setSubtitle(r5);
    }

    @Override // android.view.ActionMode
    public void setTag(Object r5) {
        this.mWrappedObject.setTag(r5);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence r5) {
        this.mWrappedObject.setTitle(r5);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean r5) {
        this.mWrappedObject.setTitleOptionalHint(r5);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int r5) {
        this.mWrappedObject.setSubtitle(r5);
    }

    @Override // android.view.ActionMode
    public void setTitle(int r5) {
        this.mWrappedObject.setTitle(r5);
    }
}
