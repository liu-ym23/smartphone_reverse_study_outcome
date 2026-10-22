package i2c;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final LifecycleOwner a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof LifecycleOwner) == false) goto L6;
        return (LifecycleOwner) r2;
    L6:
        if ((r2 instanceof ContextWrapper) == false) goto L11;
        Context r3 = ((ContextWrapper) r2).getBaseContext();
        if (r3 == null) goto L11;
        return a(r3);
    L11:
        return null;
    }
}
