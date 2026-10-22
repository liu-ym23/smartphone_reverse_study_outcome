package r20;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public boolean a;
    public final Uri b;
    public final Uri c;

    public final String toString() {
        return this.c.toString();
    }

    public a(Uri r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "originUri");
        Intrinsics.checkNotNullParameter(r3, "finalUri");
        this.b = r2;
        this.c = r3;
    }
}
