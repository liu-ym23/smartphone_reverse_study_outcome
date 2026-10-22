package wia;

import android.net.Uri;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class y {
    public final Uri a;
    public final IUriFileReceiver b;
    public final String c;

    public y(Uri r2, IUriFileReceiver r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "uriToOpen");
        Intrinsics.checkNotNullParameter(r3, "forReceiver");
        Intrinsics.checkNotNullParameter(r4, "receiverPackage");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
