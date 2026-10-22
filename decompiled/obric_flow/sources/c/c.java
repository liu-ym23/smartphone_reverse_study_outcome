package c;

import android.content.DialogInterface;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public final class c implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DialogInterface.OnClickListener f1028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DialogInterface.OnDismissListener f1029b;

    public final void a(com.obric.oui.dialog.v2.alert.b r5) {
        Window r10 = r5.getWindow();     // Catch: Exception -> L6
        if (r10 == null) goto L11;
        r10.getDecorView().getViewTreeObserver().addOnWindowAttachListener(new b(this));     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        m.i(c.class.getSimpleName(), "clearOnDetach error. e= " + e.toString());
        e.printStackTrace();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r10) {
        DialogInterface.OnClickListener r11 = this.f1028a;
        if (r11 == null) goto L6;
        r11.onClick(r5, r10);
        return;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r5) {
        DialogInterface.OnDismissListener r10 = this.f1029b;
        if (r10 == null) goto L6;
        r10.onDismiss(r5);
        this.f1029b = null;
        return;
    }
}
