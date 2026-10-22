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

    public StandaloneActionMode(Context r5, ActionBarContextView r10, ActionMode.Callback r11, boolean r12) {
        this.mContext = r5;
        this.mContextView = r10;
        this.mCallback = r11;
        MenuBuilder r13 = new MenuBuilder(r10.getContext()).setDefaultShowAsAction(1);
        this.mMenu = r13;
        r13.setCallback(this);
        this.mFocusable = r12;
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
        WeakReference<View> r5 = this.mCustomView;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.get();
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

    public void onCloseMenu(MenuBuilder r5, boolean r10) {
    }

    public void onCloseSubMenu(SubMenuBuilder r5) {
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(@NonNull MenuBuilder r5, @NonNull MenuItem r10) {
        return this.mCallback.onActionItemClicked(this, r10);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(@NonNull MenuBuilder r5) {
        invalidate();
        this.mContextView.showOverflowMenu();
    }

    public boolean onSubMenuSelected(SubMenuBuilder r5) {
        if (r5.hasVisibleItems() == true) goto L5;
        return true;
    L5:
        new MenuPopupHelper(this.mContextView.getContext(), r5).show();
        return true;
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setCustomView(View r5) {
        this.mContextView.setCustomView(r5);
        if (r5 == null) goto L5;
        WeakReference<View> r10 = new WeakReference(r5);
    L6:
        this.mCustomView = r10;
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setSubtitle(CharSequence r5) {
        this.mContextView.setSubtitle(r5);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitle(CharSequence r5) {
        this.mContextView.setTitle(r5);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitleOptionalHint(boolean r5) {
        super.setTitleOptionalHint(r5);
        this.mContextView.setTitleOptional(r5);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setSubtitle(int r5) {
        setSubtitle(this.mContext.getString(r5));
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitle(int r5) {
        setTitle(this.mContext.getString(r5));
    }
}
