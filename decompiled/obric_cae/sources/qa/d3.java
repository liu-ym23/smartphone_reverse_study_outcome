package qa;

import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f10301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f10302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f10303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10306g;

    public d3() {
        this.f10300a = 0;
        this.f10301b = 0.0d;
        this.f10302c = 0.0d;
        this.f10303d = 0;
        this.f10304e = 0;
        this.f10305f = 63;
        this.f10306g = 0;
    }

    public final String a() {
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L4
        r8.put("time", this.f10303d);     // Catch: Throwable -> L4
        r8.put("lon", this.f10302c);     // Catch: Throwable -> L4
        r8.put("lat", this.f10301b);     // Catch: Throwable -> L4
        r8.put("radius", this.f10304e);     // Catch: Throwable -> L4
        r8.put("locationType", this.f10300a);     // Catch: Throwable -> L4
        r8.put("reType", this.f10305f);     // Catch: Throwable -> L4
        r8.put("reSubType", this.f10306g);     // Catch: Throwable -> L4
    L5:
        if (r8 != null) goto L9;
        return "";
    L9:
        return r8.toString();
    L4:
        r8 = null;
        goto L5
    }

    public final void b(JSONObject r8) {
        this.f10301b = r8.optDouble("lat", this.f10301b);     // Catch: Throwable -> L4
        this.f10302c = r8.optDouble("lon", this.f10302c);     // Catch: Throwable -> L4
        this.f10300a = r8.optInt("locationType", this.f10300a);     // Catch: Throwable -> L4
        this.f10305f = r8.optInt("reType", this.f10305f);     // Catch: Throwable -> L4
        this.f10306g = r8.optInt("reSubType", this.f10306g);     // Catch: Throwable -> L4
        this.f10304e = r8.optInt("radius", this.f10304e);     // Catch: Throwable -> L4
        this.f10303d = r8.optLong("time", this.f10303d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        t3.g("CoreUtil", "transformLocation", th);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L25:
        return false;
    L8:
        if (d3.class != r8.getClass()) goto L25;
        d3 r10 = (d3) r8;
        if (this.f10300a != r10.f10300a) goto L25;
        if (Double.compare(r10.f10301b, this.f10301b) != 0) goto L25;
        if (Double.compare(r10.f10302c, this.f10302c) != 0) goto L25;
        if (this.f10303d != r10.f10303d) goto L25;
        if (this.f10304e != r10.f10304e) goto L25;
        if (this.f10305f != r10.f10305f) goto L25;
        if (this.f10306g != r10.f10306g) goto L25;
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f10300a), Double.valueOf(this.f10301b), Double.valueOf(this.f10302c), Long.valueOf(this.f10303d), Integer.valueOf(this.f10304e), 0, Integer.valueOf(this.f10305f), Integer.valueOf(this.f10306g)});
    }
}
