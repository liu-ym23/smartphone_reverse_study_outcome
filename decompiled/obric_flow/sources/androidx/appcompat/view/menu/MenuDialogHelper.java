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

    public MenuDialogHelper(MenuBuilder r5) {
        this.mMenu = r5;
    }

    public void dismiss() {
        AlertDialog r5 = this.mDialog;
        if (r5 == null) goto L6;
        r5.dismiss();
        return;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r5, int r10) {
        this.mMenu.performItemAction((MenuItemImpl) this.mPresenter.getAdapter().getItem(r10), 0);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void onCloseMenu(@NonNull MenuBuilder r5, boolean r10) {
        if (r10 == false) goto L4;
    L5:
        dismiss();
    L6:
        MenuPresenter.Callback r11 = this.mPresenterCallback;
        if (r11 == null) goto L10;
        r11.onCloseMenu(r5, r10);
        return;
    L10:
        return;
    L4:
        if (r5 != this.mMenu) goto L6;
        goto L5
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r5) {
        this.mPresenter.onCloseMenu(this.mMenu, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface r5, int r10, KeyEvent r11) {
        if (r10 == 82) goto L7;
        if (r10 == 4) goto L7;
    L33:
        return this.mMenu.performShortcut(r10, r11, 0);
    L7:
        if (r11.getAction() != 0) goto L19;
        if (r11.getRepeatCount() != 0) goto L19;
        Window r12 = this.mDialog.getWindow();
        if (r12 == null) goto L33;
        View r13 = r12.getDecorView();
        if (r13 == null) goto L33;
        KeyEvent.DispatcherState r14 = r13.getKeyDispatcherState();
        if (r14 == null) goto L33;
        r14.startTracking(r11, this);
        return true;
    L19:
        if (r11.getAction() != 1) goto L33;
        if (r11.isCanceled() == true) goto L33;
        Window r15 = this.mDialog.getWindow();
        if (r15 == null) goto L33;
        View r16 = r15.getDecorView();
        if (r16 == null) goto L33;
        KeyEvent.DispatcherState r17 = r16.getKeyDispatcherState();
        if (r17 == null) goto L33;
        if (r17.isTracking(r11) == false) goto L33;
        this.mMenu.close(true);
        r5.dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(@NonNull MenuBuilder r5) {
        MenuPresenter.Callback r10 = this.mPresenterCallback;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.onOpenSubMenu(r5);
    }

    public void setPresenterCallback(MenuPresenter.Callback r5) {
        this.mPresenterCallback = r5;
    }

    public void show(IBinder r10) {
        MenuBuilder r5 = this.mMenu;
        AlertDialog.Builder r11 = new AlertDialog.Builder(r5.getContext());
        ListMenuPresenter r12 = new ListMenuPresenter(r11.getContext(), R.layout.abc_list_menu_item_layout);
        this.mPresenter = r12;
        r12.setCallback(this);
        this.mMenu.addMenuPresenter(this.mPresenter);
        r11.setAdapter(this.mPresenter.getAdapter(), this);
        View r13 = r5.getHeaderView();
        if (r13 == null) goto L5;
        r11.setCustomTitle(r13);
    L6:
        r11.setOnKeyListener(this);
        AlertDialog r14 = r11.create();
        this.mDialog = r14;
        r14.setOnDismissListener(this);
        WindowManager.LayoutParams r15 = this.mDialog.getWindow().getAttributes();
        r15.type = PointerIconCompat.TYPE_HELP;
        if (r10 == null) goto L9;
        r15.token = r10;
    L9:
        r15.flags |= 131072;
        this.mDialog.show();
        return;
    L5:
        r11.setIcon(r5.getHeaderIcon()).setTitle(r5.getHeaderTitle());
        goto L6
    }
}
