package t7;

import android.content.DialogInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements DialogInterface.OnShowListener {
    public final WeakReference<DialogInterface.OnShowListener> a;

    public b(DialogInterface.OnShowListener r10) {
        if (r10 == null) goto L6;
        this.a = new WeakReference(r10);
        return;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r10) {
        if (r10 == null) goto L9;
        WeakReference<DialogInterface.OnShowListener> r0 = this.a;
        if (r0 == null) goto L10;
        DialogInterface.OnShowListener r1 = r0.get();
        if (r1 == null) goto L11;
        r1.onShow(r10);
        return;
    L11:
        return;
    L10:
        return;
    }
}
