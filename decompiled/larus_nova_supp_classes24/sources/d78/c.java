package d78;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public static final boolean a(d r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        List r2 = r1.b();
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        return !r3;
    L5:
        if (r2.isEmpty() == true) goto L8;
        r3 = false;
        goto L10
    }
}
