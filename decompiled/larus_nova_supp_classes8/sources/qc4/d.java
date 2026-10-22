package qc4;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public final Map<String, Object> a;
    public final int b;
    public final String c;

    public final String toString() {
        return "CheckResult(code=" + this.b + ", msg='" + this.c + "', needAbnormalHandler=false, intercept=false, extraMap=" + this.a + ')';
    }

    public d() {
        this.b = 0;
        this.c = "";
        this.a = new LinkedHashMap();
    }
}
