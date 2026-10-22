package zs1;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements DialogInterface.OnDismissListener {
    public final /* synthetic */ g a;

    public h(g r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        this.a.g = null;
    }
}
