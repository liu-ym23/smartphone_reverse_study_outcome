package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AlertDialog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class MenuDialogHelper implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, MenuPresenter.Callback {
    private AlertDialog mDialog;
    private MenuBuilder mMenu;
    ListMenuPresenter mPresenter;
    private MenuPresenter.Callback mPresenterCallback;

    public MenuDialogHelper(MenuBuilder r1) {
        this.mMenu = r1;
    }

    public void dismiss() {
        AlertDialog r0 = this.mDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r3, int r4) {
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        this.mMenu.performItemAction((MenuItemImpl) ZeusTransformUtils.preCheckCast(this.mPresenter.getAdapter().getItem(r4), MenuItemImpl.class, "com.obric.memorydata.plugin"), 0);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void onCloseMenu(MenuBuilder r2, boolean r3) {
        if (r3 == false) goto L4;
    L5:
        dismiss();
    L6:
        MenuPresenter.Callback r1 = this.mPresenterCallback;
        if (r1 == null) goto L10;
        r1.onCloseMenu(r2, r3);
        return;
    L10:
        return;
    L4:
        if (r2 != this.mMenu) goto L6;
        goto L5
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        this.mPresenter.onCloseMenu(this.mMenu, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface r3, int r4, KeyEvent r5) {
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        if (r4 == 82) goto L7;
        if (r4 == 4) goto L7;
    L33:
        return this.mMenu.performShortcut(r4, r5, 0);
    L7:
        if (r5.getAction() != 0) goto L19;
        if (r5.getRepeatCount() != 0) goto L19;
        Window r7 = this.mDialog.getWindow();
        if (r7 == null) goto L33;
        View r8 = r7.getDecorView();
        if (r8 == null) goto L33;
        KeyEvent.DispatcherState r9 = r8.getKeyDispatcherState();
        if (r9 == null) goto L33;
        r9.startTracking(r5, this);
        return true;
    L19:
        if (r5.getAction() != 1) goto L33;
        if (r5.isCanceled() == true) goto L33;
        Window r0 = this.mDialog.getWindow();
        if (r0 == null) goto L33;
        View r1 = r0.getDecorView();
        if (r1 == null) goto L33;
        KeyEvent.DispatcherState r2 = r1.getKeyDispatcherState();
        if (r2 == null) goto L33;
        if (r2.isTracking(r5) == false) goto L33;
        this.mMenu.close(true);
        r6.dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(MenuBuilder r1) {
        MenuPresenter.Callback r0 = this.mPresenterCallback;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.onOpenSubMenu(r1);
    }

    public void setPresenterCallback(MenuPresenter.Callback r3) {
        this.mPresenterCallback = (MenuPresenter.Callback) ZeusTransformUtils.wrapperContextForParams(r3, MenuPresenter.Callback.class, "com.obric.memorydata.plugin");
    }

    public void show(IBinder r8) {
        IBinder r9 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r8, IBinder.class, "com.obric.memorydata.plugin");
        MenuBuilder r0 = this.mMenu;
        AlertDialog.Builder r2 = new AlertDialog.Builder((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        ListMenuPresenter r3 = new ListMenuPresenter((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.abc_list_menu_item_layout, "layout", "abc_list_menu_item_layout"));
        this.mPresenter = r3;
        r3.setCallback(this);
        this.mMenu.addMenuPresenter(this.mPresenter);
        r2.setAdapter(this.mPresenter.getAdapter(), this);
        View r1 = r0.getHeaderView();
        if (r1 == null) goto L5;
        r2.setCustomTitle(r1);
    L6:
        r2.setOnKeyListener(this);
        AlertDialog r4 = r2.create();
        this.mDialog = r4;
        r4.setOnDismissListener(this);
        WindowManager.LayoutParams r5 = this.mDialog.getWindow().getAttributes();
        r5.type = 1003;
        if (r9 == null) goto L9;
        r5.token = r9;
    L9:
        r5.flags |= 131072;
        this.mDialog.show();
        return;
    L5:
        r2.setIcon(r0.getHeaderIcon()).setTitle(r0.getHeaderTitle());
        goto L6
    }
}
