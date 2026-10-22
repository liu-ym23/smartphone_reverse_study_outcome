package swb;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h {
    public static final Activity a(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
    L4:
        if ((r1 instanceof ContextWrapper) == false) goto L10;
        if ((r1 instanceof Activity) == true) goto L8;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L4
    L8:
        return (Activity) r1;
    L10:
        return null;
    }
}
