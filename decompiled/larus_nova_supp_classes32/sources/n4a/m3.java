package n4a;

import com.obric.aivoice.core.data.NameKeys;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m3 {
    public int a;
    public double b;
    public double c;
    public long d;
    public int e;
    public int f;
    public int g;

    public m3() {
        this.a = 0;
        this.b = 0.0d;
        this.c = 0.0d;
        this.d = 0;
        this.e = 0;
        this.f = 63;
        this.g = 0;
    }

    public final String a() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("time", this.d);     // Catch: Throwable -> L4
        r0.put("lon", this.c);     // Catch: Throwable -> L4
        r0.put("lat", this.b);     // Catch: Throwable -> L4
        r0.put("radius", this.e);     // Catch: Throwable -> L4
        r0.put("locationType", this.a);     // Catch: Throwable -> L4
        r0.put("reType", this.f);     // Catch: Throwable -> L4
        r0.put("reSubType", this.g);     // Catch: Throwable -> L4
    L5:
        if (r0 != null) goto L9;
        return NameKeys.UnloadStrategy_No_Strategy;
    L9:
        return r0.toString();
    L4:
        r0 = null;
        goto L5
    }

    public final void b(JSONObject r4) {
        this.b = r4.optDouble("lat", this.b);     // Catch: Throwable -> L4
        this.c = r4.optDouble("lon", this.c);     // Catch: Throwable -> L4
        this.a = r4.optInt("locationType", this.a);     // Catch: Throwable -> L4
        this.f = r4.optInt("reType", this.f);     // Catch: Throwable -> L4
        this.g = r4.optInt("reSubType", this.g);     // Catch: Throwable -> L4
        this.e = r4.optInt("radius", this.e);     // Catch: Throwable -> L4
        this.d = r4.optLong("time", this.d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c4.g(th, "CoreUtil", "transformLocation");
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L25:
        return false;
    L8:
        if (m3.class != r8.getClass()) goto L25;
        m3 r9 = (m3) r8;
        if (this.a != r9.a) goto L25;
        if (Double.compare(r9.b, this.b) != 0) goto L25;
        if (Double.compare(r9.c, this.c) != 0) goto L25;
        if (this.d != r9.d) goto L25;
        if (this.e != r9.e) goto L25;
        if (this.f != r9.f) goto L25;
        if (this.g != r9.g) goto L25;
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.a), Double.valueOf(this.b), Double.valueOf(this.c), Long.valueOf(this.d), Integer.valueOf(this.e), 0, Integer.valueOf(this.f), Integer.valueOf(this.g)});
    }
}
