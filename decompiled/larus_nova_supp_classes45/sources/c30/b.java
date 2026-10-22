package c30;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements DialogInterface.OnClickListener {
    public final /* synthetic */ Context a;

    public b(Context r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        int r5 = c.a;     // Catch: Exception -> L4
        c.a(this.a);     // Catch: Exception -> L4
    L5:
        if (r3 == null) goto L10;
        r3.dismiss();
        return;
    L10:
        return;
    L4:
        this.a.startActivity(new Intent("android.settings.SETTINGS"));
        goto L5
    }
}
