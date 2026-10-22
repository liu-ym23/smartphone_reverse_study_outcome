package hob;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class b {
    public final String a;
    public Map<String, String> b;
    public final Map<String, Object> c;

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "href");
        this.a = r2;
        this.c = new HashMap(0);
    }
}
