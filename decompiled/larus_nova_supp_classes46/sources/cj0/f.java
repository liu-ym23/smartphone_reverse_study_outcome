package cj0;

import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ Context a;

    public f(Context r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        Context r4 = this.a;
        if (h.a() == true) goto L5;
        h.b(r4, "");
    L5:
        r2.dismiss();
    }
}
