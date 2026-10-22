package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {
    private ActionMode.Callback mCallback;
    private Context mContext;
    private ActionBarContextView mContextView;
    private WeakReference<View> mCustomView;
    private boolean mFinished;
    private boolean mFocusable;
    private MenuBuilder mMenu;

    public StandaloneActionMode(Context r3, ActionBarContextView r4, ActionMode.Callback r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        ActionMode.Callback r8 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r5, ActionMode.Callback.class, "com.obric.memorydata.plugin");
        this.mContext = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.mContextView = r4;
        this.mCallback = r8;
        MenuBuilder r9 = new MenuBuilder((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).setDefaultShowAsAction(1);
        this.mMenu = r9;
        r9.setCallback(this);
        this.mFocusable = r6;
    }

    @Override // androidx.appcompat.view.ActionMode
    public void finish() {
        if (this.mFinished == false) goto L5;
        return;
    L5:
        this.mFinished = true;
        this.mCallback.onDestroyActionMode(this);
    }

    @Override // androidx.appcompat.view.ActionMode
    public View getCustomView() {
        WeakReference<View> r2 = this.mCustomView;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (View) ZeusTransformUtils.preCheckCast(r2.get(), View.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.view.ActionMode
    public Menu getMenu() {
        return this.mMenu;
    }

    @Override // androidx.appcompat.view.ActionMode
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mContextView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.view.ActionMode
    public CharSequence getSubtitle() {
        return this.mContextView.getSubtitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    public CharSequence getTitle() {
        return this.mContextView.getTitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    public void invalidate() {
        this.mCallback.onPrepareActionMode(this, this.mMenu);
    }

    @Override // androidx.appcompat.view.ActionMode
    public boolean isTitleOptional() {
        return this.mContextView.isTitleOptional();
    }

    @Override // androidx.appcompat.view.ActionMode
    public boolean isUiFocusable() {
        return this.mFocusable;
    }

    public void onCloseMenu(MenuBuilder r1, boolean r2) {
    }

    public void onCloseSubMenu(SubMenuBuilder r1) {
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder r2, MenuItem r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin");
        return this.mCallback.onActionItemClicked(this, r4);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder r1) {
        invalidate();
        this.mContextView.showOverflowMenu();
    }

    public boolean onSubMenuSelected(SubMenuBuilder r5) {
        if (r5.hasVisibleItems() == true) goto L5;
        return true;
    L5:
        new MenuPopupHelper((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mContextView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5).show();
        return true;
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setCustomView(View r2) {
        this.mContextView.setCustomView(r2);
        if (r2 == null) goto L5;
        WeakReference<View> r0 = new WeakReference(r2);
    L6:
        this.mCustomView = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setSubtitle(int r2) {
        setSubtitle(this.mContext.getString(r2));
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setSubtitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mContextView.setSubtitle(r4);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitle(int r2) {
        setTitle(this.mContext.getString(r2));
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mContextView.setTitle(r4);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitleOptionalHint(boolean r1) {
        super.setTitleOptionalHint(r1);
        this.mContextView.setTitleOptional(r1);
    }
}
