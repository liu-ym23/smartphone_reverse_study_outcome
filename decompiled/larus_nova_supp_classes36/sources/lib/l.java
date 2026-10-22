package lib;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements DialogInterface.OnClickListener {
    public final /* synthetic */ jib.b a;
    public final /* synthetic */ Runnable b;

    public l(jib.b r1, g r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        jib.a r3 = this.a.c;
        if (r3 != null) goto L5;
    L7:
        r1.dismiss();
        this.b.run();
        return;
    L5:
        if (((com.ss.android.lark.forwardv2.impl.view.m) r3).a.t == true) goto L7;
    }
}
