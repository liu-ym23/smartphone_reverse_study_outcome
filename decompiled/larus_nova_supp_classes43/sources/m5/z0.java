package m5;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z0 {
    public boolean a;
    public String b;
    public String c;
    public final Map<String, Object> d;

    public z0() {
        this.b = "init";
        this.c = "";
        this.d = new LinkedHashMap();
    }

    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.b = r10;
    }
}
