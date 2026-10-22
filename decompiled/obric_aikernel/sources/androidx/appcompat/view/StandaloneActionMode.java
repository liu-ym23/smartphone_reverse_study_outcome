package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {
    private ActionMode.Callback mCallback;
    private Context mContext;
    private ActionBarContextView mContextView;
    private WeakReference<View> mCustomView;
    private boolean mFinished;
    private boolean mFocusable;
    private MenuBuilder mMenu;

    public StandaloneActionMode(Context r10, ActionBarContextView r11, ActionMode.Callback r12, boolean r13) {
        this.mContext = r10;
        this.mContextView = r11;
        this.mCallback = r12;
        MenuBuilder r14 = new MenuBuilder(r11.getContext()).setDefaultShowAsAction(1);
        this.mMenu = r14;
        r14.setCallback(this);
        this.mFocusable = r13;
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
        WeakReference<View> r10 = this.mCustomView;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.get();
    }

    @Override // androidx.appcompat.view.ActionMode
    public Menu getMenu() {
        return this.mMenu;
    }

    @Override // androidx.appcompat.view.ActionMode
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContextView.getContext());
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

    public void onCloseMenu(MenuBuilder r10, boolean r11) {
    }

    public void onCloseSubMenu(SubMenuBuilder r10) {
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(@NonNull MenuBuilder r10, @NonNull MenuItem r11) {
        return this.mCallback.onActionItemClicked(this, r11);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(@NonNull MenuBuilder r10) {
        invalidate();
        this.mContextView.showOverflowMenu();
    }

    public boolean onSubMenuSelected(SubMenuBuilder r10) {
        if (r10.hasVisibleItems() == true) goto L5;
        return true;
    L5:
        new MenuPopupHelper(this.mContextView.getContext(), r10).show();
        return true;
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setCustomView(View r10) {
        this.mContextView.setCustomView(r10);
        if (r10 == null) goto L5;
        WeakReference<View> r11 = new WeakReference(r10);
    L6:
        this.mCustomView = r11;
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setSubtitle(int r10) {
        setSubtitle(this.mContext.getString(r10));
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setSubtitle(CharSequence r10) {
        this.mContextView.setSubtitle(r10);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitle(int r10) {
        setTitle(this.mContext.getString(r10));
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitle(CharSequence r10) {
        this.mContextView.setTitle(r10);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitleOptionalHint(boolean r10) {
        super.setTitleOptionalHint(r10);
        this.mContextView.setTitleOptional(r10);
    }
}
