package ek0;

import android.content.DialogInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements DialogInterface.OnClickListener {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
        r1.dismiss();
    }
}
