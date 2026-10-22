package h9b;

import android.util.Pair;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static HashMap a(Pair... r5) {
        Intrinsics.checkNotNullParameter(r5, "pairs");
        HashMap r0 = new HashMap();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Pair r3 = r5[r2];
        r0.put(r3.first, r3.second);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }
}
