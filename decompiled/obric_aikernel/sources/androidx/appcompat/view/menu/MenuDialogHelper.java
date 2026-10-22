package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.PointerIconCompat;

/* JADX INFO: loaded from: classes.dex */
class MenuDialogHelper implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.Callback {
    private AlertDialog mDialog;
    private MenuBuilder mMenu;
    ListMenuPresenter mPresenter;
    private MenuPresenter.Callback mPresenterCallback;

    public MenuDialogHelper(MenuBuilder r10) {
        this.mMenu = r10;
    }

    public void dismiss() {
        AlertDialog r10 = this.mDialog;
        if (r10 == null) goto L6;
        r10.dismiss();
        return;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r10, int r11) {
        this.mMenu.performItemAction((MenuItemImpl) this.mPresenter.getAdapter().getItem(r11), 0);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void onCloseMenu(@NonNull MenuBuilder r10, boolean r11) {
        if (r11 == false) goto L4;
    L5:
        dismiss();
    L6:
        MenuPresenter.Callback r12 = this.mPresenterCallback;
        if (r12 == null) goto L10;
        r12.onCloseMenu(r10, r11);
        return;
    L10:
        return;
    L4:
        if (r10 != this.mMenu) goto L6;
        goto L5
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r10) {
        this.mPresenter.onCloseMenu(this.mMenu, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface r10, int r11, KeyEvent r12) {
        if (r11 == 82) goto L7;
        if (r11 == 4) goto L7;
    L33:
        return this.mMenu.performShortcut(r11, r12, 0);
    L7:
        if (r12.getAction() != 0) goto L19;
        if (r12.getRepeatCount() != 0) goto L19;
        Window r13 = this.mDialog.getWindow();
        if (r13 == null) goto L33;
        View r14 = r13.getDecorView();
        if (r14 == null) goto L33;
        KeyEvent.DispatcherState r15 = r14.getKeyDispatcherState();
        if (r15 == null) goto L33;
        r15.startTracking(r12, this);
        return true;
    L19:
        if (r12.getAction() != 1) goto L33;
        if (r12.isCanceled() == true) goto L33;
        Window r16 = this.mDialog.getWindow();
        if (r16 == null) goto L33;
        View r17 = r16.getDecorView();
        if (r17 == null) goto L33;
        KeyEvent.DispatcherState r18 = r17.getKeyDispatcherState();
        if (r18 == null) goto L33;
        if (r18.isTracking(r12) == false) goto L33;
        this.mMenu.close(true);
        r10.dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(@NonNull MenuBuilder r10) {
        MenuPresenter.Callback r11 = this.mPresenterCallback;
        if (r11 != null) goto L5;
        return false;
    L5:
        return r11.onOpenSubMenu(r10);
    }

    public void setPresenterCallback(MenuPresenter.Callback r10) {
        this.mPresenterCallback = r10;
    }

    public void show(IBinder r10) {
        MenuBuilder r11 = this.mMenu;
        AlertDialog.Builder r12 = new AlertDialog.Builder(r11.getContext());
        ListMenuPresenter r13 = new ListMenuPresenter(r12.getContext(), R.layout.abc_list_menu_item_layout);
        this.mPresenter = r13;
        r13.setCallback(this);
        this.mMenu.addMenuPresenter(this.mPresenter);
        r12.setAdapter(this.mPresenter.getAdapter(), this);
        View r14 = r11.getHeaderView();
        if (r14 == null) goto L5;
        r12.setCustomTitle(r14);
    L6:
        r12.setOnKeyListener(this);
        AlertDialog r15 = r12.create();
        this.mDialog = r15;
        r15.setOnDismissListener(this);
        WindowManager.LayoutParams r16 = this.mDialog.getWindow().getAttributes();
        r16.type = PointerIconCompat.TYPE_HELP;
        if (r10 == null) goto L9;
        r16.token = r10;
    L9:
        r16.flags |= 131072;
        this.mDialog.show();
        return;
    L5:
        r12.setIcon(r11.getHeaderIcon()).setTitle(r11.getHeaderTitle());
        goto L6
    }
}
