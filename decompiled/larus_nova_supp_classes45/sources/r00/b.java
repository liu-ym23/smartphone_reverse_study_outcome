package r00;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final s00.c a;
    public final ArrayList<a> b;

    public b(s00.c r2, ArrayList<a> r3) {
        Intrinsics.checkNotNullParameter(r2, "task");
        Intrinsics.checkNotNullParameter(r3, "dependsList");
        this.a = r2;
        this.b = r3;
    }
}
