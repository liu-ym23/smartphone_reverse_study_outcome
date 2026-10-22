package dv0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public final long a;
    public final List<d> b;
    public final long c;

    public l(String r2, long r3, List r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "miniAppId");
        Intrinsics.checkNotNullParameter(r5, "players");
        this.a = r3;
        this.b = r5;
        this.c = r6;
    }
}
