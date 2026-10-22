package lq9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f0 {
    public final boolean a;
    public final int b;
    public final List<String> c;

    public final boolean a(String r2) {
        int r3 = b(r2);
        if (this.a == true) goto L5;
    L9:
        return false;
    L5:
        if (r3 != 2) goto L7;
    L8:
        return true;
    L7:
        if (r3 != 3) goto L9;
        goto L8
    }

    public final int b(String r2) {
        if (this.c.isEmpty() == true) goto L19;
        if (r2 != null) goto L6;
    L9:
        boolean r0 = true;
    L10:
        if (r0 == true) goto L19;
        if (this.c.contains(r2) == true) goto L19;
        int r3 = this.b;
        if (r3 != 3) goto L20;
        return 2;
    L20:
        return r3;
    L6:
        if (r2.length() == 0) goto L9;
        r0 = false;
    L19:
        return this.b;
    }

    public f0(boolean r2, int r3, List r4) {
        Intrinsics.checkNotNullParameter(r4, "supportMixLanguage");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
