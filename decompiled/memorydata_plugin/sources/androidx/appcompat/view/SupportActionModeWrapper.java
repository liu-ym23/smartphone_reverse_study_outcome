package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SupportActionModeWrapper extends android.view.ActionMode {
    final Context mContext;
    final ActionMode mWrappedObject;

    public static class CallbackWrapper implements ActionMode.Callback {
        final ArrayList<SupportActionModeWrapper> mActionModes;
        final Context mContext;
        final SimpleArrayMap<Menu, Menu> mMenus;
        final android.view.ActionMode.Callback mWrappedCallback;

        public CallbackWrapper(Context r3, android.view.ActionMode.Callback r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            android.view.ActionMode.Callback r6 = (android.view.ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r4, android.view.ActionMode.Callback.class, "com.obric.memorydata.plugin");
            this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
            this.mWrappedCallback = r6;
            this.mActionModes = new ArrayList();
            this.mMenus = new SimpleArrayMap();
        }

        private Menu getMenuWrapper(Menu r5) {
            Menu r6 = (Menu) ZeusTransformUtils.wrapperContextForParams(r5, Menu.class, "com.obric.memorydata.plugin");
            Menu r0 = (Menu) ZeusTransformUtils.preCheckCast(this.mMenus.get(r6), Menu.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L6;
            MenuWrapperICS r1 = new MenuWrapperICS(this.mContext, (SupportMenu) ZeusTransformUtils.preCheckCast(r6, SupportMenu.class, "com.obric.memorydata.plugin"));
            this.mMenus.put(r6, r1);
            return r1;
        L6:
            return r0;
        }

        public android.view.ActionMode getActionModeWrapper(ActionMode r6) {
            int r0 = this.mActionModes.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L10;
            SupportActionModeWrapper r2 = (SupportActionModeWrapper) ZeusTransformUtils.preCheckCast(this.mActionModes.get(r1), SupportActionModeWrapper.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L9;
            if (r2.mWrappedObject != r6) goto L9;
            return r2;
        L9:
            r1 = r1 + 1;
            goto L3
        L10:
            SupportActionModeWrapper r3 = new SupportActionModeWrapper(this.mContext, r6);
            this.mActionModes.add(r3);
            return r3;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r5, MenuItem r6) {
            MenuItem r7 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r6, MenuItem.class, "com.obric.memorydata.plugin");
            return this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(r5), new MenuItemWrapperICS(this.mContext, (SupportMenuItem) ZeusTransformUtils.preCheckCast(r7, SupportMenuItem.class, "com.obric.memorydata.plugin")));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
            return this.mWrappedCallback.onCreateActionMode(getActionModeWrapper(r3), getMenuWrapper(r5));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r2) {
            this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(r2));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
            return this.mWrappedCallback.onPrepareActionMode(getActionModeWrapper(r3), getMenuWrapper(r5));
        }
    }

    public SupportActionModeWrapper(Context r3, ActionMode r4) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mWrappedObject = r4;
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
        return new MenuWrapperICS(this.mContext, (SupportMenu) ZeusTransformUtils.preCheckCast(this.mWrappedObject.getMenu(), SupportMenu.class, "com.obric.memorydata.plugin"));
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
    public void setCustomView(View r1) {
        this.mWrappedObject.setCustomView(r1);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int r1) {
        this.mWrappedObject.setSubtitle(r1);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mWrappedObject.setSubtitle(r4);
    }

    @Override // android.view.ActionMode
    public void setTag(Object r1) {
        this.mWrappedObject.setTag(r1);
    }

    @Override // android.view.ActionMode
    public void setTitle(int r1) {
        this.mWrappedObject.setTitle(r1);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mWrappedObject.setTitle(r4);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean r1) {
        this.mWrappedObject.setTitleOptionalHint(r1);
    }
}
