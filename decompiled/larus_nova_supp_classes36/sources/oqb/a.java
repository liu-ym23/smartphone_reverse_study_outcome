package oqb;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final Activity a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof Activity) == false) goto L6;
        return (Activity) r2;
    L6:
        if ((r2 instanceof ContextWrapper) == false) goto L11;
        Context r3 = ((ContextWrapper) r2).getBaseContext();
        if (r3 == null) goto L11;
        return a(r3);
    L11:
        return null;
    }
}
