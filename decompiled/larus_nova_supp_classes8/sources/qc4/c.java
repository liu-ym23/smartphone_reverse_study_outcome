package qc4;

import com.bytedance.bpea.basics.Cert;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public final int a;
    public final Integer b;
    public final String[] c;
    public final String d;
    public final Cert e;
    public final Map<String, Object> f;

    public final String toString() {
        StringBuilder r0 = new StringBuilder("CertContext(cert=");
        r0.append(this.e);
        r0.append(", entryToken=");
        r0.append(this.d);
        r0.append(", api_id=");
        r0.append(this.a);
        r0.append(", entryDataTypes=");
        String[] r1 = this.c;
        if (r1 == null) goto L5;
        String r2 = Arrays.toString(r1);
    L6:
        r0.append(r2);
        r0.append(", entryCategory=");
        r0.append(this.b);
        r0.append(", entryExtraInfo=");
        r0.append(this.f);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public c(Cert r2, String r3, String[] r4, Integer r5) {
        this.a = -1;
        this.f = new LinkedHashMap();
        this.e = r2;
        this.d = r3;
        this.c = r4;
        this.b = r5;
    }

    public c(Cert r2, String r3, int r4, String[] r5, Integer r6) {
        this.a = -1;
        this.f = new LinkedHashMap();
        this.e = r2;
        this.d = r3;
        this.a = r4;
        this.c = r5;
        this.b = r6;
    }

    public c(Cert r2, String r3, String[] r4, Integer r5, int r6) {
        this.a = -1;
        this.f = new LinkedHashMap();
        this.e = r2;
        this.d = r3;
        this.a = r6;
        this.c = r4;
        this.b = r5;
    }
}
