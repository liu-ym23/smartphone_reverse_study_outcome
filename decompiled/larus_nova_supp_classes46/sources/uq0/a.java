package uq0;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final String a;
    public String b;
    public Map<String, String> c;

    public a(String r2, String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "path");
        Intrinsics.checkNotNullParameter(r4, "query");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
