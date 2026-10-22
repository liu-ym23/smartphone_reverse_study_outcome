package w22;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Map<String, String> e;

    public a(String r3, String r4, String r5, String r6, Map r7, int r8) {
        if ((r8 & 4) == 0) goto L6;
        r5 = null;
    L6:
        if ((r8 & 8) == 0) goto L9;
        r6 = null;
    L9:
        if ((r8 & 16) == 0) goto L11;
        r7 = null;
    L11:
        Intrinsics.checkNotNullParameter(r3, "itemId");
        Intrinsics.checkNotNullParameter(r4, "itemType");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }
}
