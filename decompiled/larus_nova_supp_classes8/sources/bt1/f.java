package bt1;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements DialogInterface.OnDismissListener {
    public final /* synthetic */ b a;

    public f(b r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        this.a.i = null;
    }
}
