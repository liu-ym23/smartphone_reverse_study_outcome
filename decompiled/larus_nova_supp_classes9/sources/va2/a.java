package va2;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final HashMap<String, Integer> a;

    public a() {
        this.a = new HashMap();
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Integer r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        r0 = 0;
    L5:
        int r1 = r0.intValue();
        this.a.put(r3, Integer.valueOf(r1 + 1));
    }
}
