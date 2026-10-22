package kta;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class p {
    public final String a;
    public final String b;
    public final Boolean c;
    public final Long d;
    public final Long e;
    public final Integer f;
    public final Long g;

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        s.c(r0, "id", this.a);
        s.c(r0, "req_id", this.b);
        s.c(r0, "is_track_limited", this.c);
        s.c(r0, "take_ms", this.d);
        s.c(r0, "time", this.e);
        s.c(r0, "query_times", this.f);
        s.c(r0, "hw_id_version_code", this.g);
        return r0;
    }

    public final String toString() {
        return a().toString();
    }

    public p(String r1, String r2, Boolean r3, Long r4, Long r5, Integer r6, Long r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
