package t4a;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class c {
    public final Map<String, Object> a;

    public c(Map<String, Object> r1) {
        this.a = r1;
    }

    public final float a(String r2) {
        Object r3 = this.a.get(r2);
        if ((r3 instanceof Number) == true) goto L7;
        return -1.0f;
    L7:
        return ((Number) r3).floatValue();
    }
}
