package uzb;

import android.content.DialogInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k implements DialogInterface.OnClickListener {
    public final /* synthetic */ DialogInterface.OnClickListener a;

    public k() {
        this.a = null;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        DialogInterface.OnClickListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onClick(r2, r3);
        return;
    }
}
