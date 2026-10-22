package g5;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f7671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f7672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f7673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f7674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f7675g;

    public n(String r8, String r10, Boolean r11, Long r12, Long r13, Integer r14, Long r15) {
        this.f7669a = r8;
        this.f7670b = r10;
        this.f7671c = r11;
        this.f7672d = r12;
        this.f7673e = r13;
        this.f7674f = r14;
        this.f7675g = r15;
    }

    public static n a(String r15) {
        if (TextUtils.isEmpty(r15) == false) goto L30;
        return null;
    L30:
        JSONObject r8 = new JSONObject(r15);     // Catch: JSONException -> L27
        String r10 = r8.optString("id", null);     // Catch: JSONException -> L27
        String r11 = r8.optString("req_id", null);     // Catch: JSONException -> L27
        if (r8.has("is_track_limited") == false) goto L8;
        Boolean r12 = Boolean.valueOf(r8.optBoolean("is_track_limited"));     // Catch: JSONException -> L27
    L10:
        if (r8.has("take_ms") == false) goto L12;
        Long r16 = Long.valueOf(r8.optLong("take_ms", -1));     // Catch: JSONException -> L27
    L14:
        if (r8.has("time") == false) goto L16;
        Long r13 = Long.valueOf(r8.optLong("time", -1));     // Catch: JSONException -> L27
    L18:
        if (r8.has("query_times") == false) goto L20;
        Integer r14 = Integer.valueOf(r8.optInt("query_times", -1));     // Catch: JSONException -> L27
    L22:
        if (r8.has("hw_id_version_code") == false) goto L24;
        Long r17 = Long.valueOf(r8.optLong("hw_id_version_code", -1));     // Catch: JSONException -> L27
    L25:
        return new n(r10, r11, r12, r16, r13, r14, r17);
    L24:
        r17 = null;
        goto L25
    L20:
        r14 = null;
        goto L22
    L16:
        r13 = null;
        goto L18
    L12:
        r16 = null;
        goto L14
    L8:
        r12 = null;
    L27:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final JSONObject b() {
        JSONObject r8 = new JSONObject();
        k.d(r8, "id", this.f7669a);
        k.d(r8, "req_id", this.f7670b);
        k.d(r8, "is_track_limited", this.f7671c);
        k.d(r8, "take_ms", this.f7672d);
        k.d(r8, "time", this.f7673e);
        k.d(r8, "query_times", this.f7674f);
        k.d(r8, "hw_id_version_code", this.f7675g);
        return r8;
    }

    public final String toString() {
        return b().toString();
    }
}
