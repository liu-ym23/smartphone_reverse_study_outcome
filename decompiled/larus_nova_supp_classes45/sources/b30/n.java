package b30;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n {
    public final boolean a;
    public final List<String> b;
    public final String c;
    public final String d;

    public n(boolean r2, List<String> r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "logExtra");
        Intrinsics.checkNotNullParameter(r5, "logReflowExtra");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
