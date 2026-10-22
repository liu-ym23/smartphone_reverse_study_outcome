package com.ss.android.deviceregister.a;

import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.OaidModel;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f15143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f15144b;
    final Boolean c;
    final Long d;
    final Long e;
    final Integer f;
    final Long g;

    p(String r1, String r2, Boolean r3, Long r4, Long r5, Integer r6, Long r7) {
        this.f15143a = r1;
        this.f15144b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    static p a(String r15) {
        if (TextUtils.isEmpty(r15) == false) goto L30;
        return null;
    L30:
        JSONObject r5 = new JSONObject(r15);     // Catch: JSONException -> L27
        String r8 = r5.optString(OaidModel.KEY_ID, null);     // Catch: JSONException -> L27
        String r9 = r5.optString("req_id", null);     // Catch: JSONException -> L27
        if (r5.has(OaidModel.KEY_IS_TRACK_LIMITED) == false) goto L8;
        Boolean r10 = Boolean.valueOf(r5.optBoolean(OaidModel.KEY_IS_TRACK_LIMITED));     // Catch: JSONException -> L27
    L10:
        if (r5.has(OaidModel.KEY_TAKE_MS) == false) goto L12;
        Long r16 = Long.valueOf(r5.optLong(OaidModel.KEY_TAKE_MS, -1));     // Catch: JSONException -> L27
    L14:
        if (r5.has(OaidModel.KEY_TIME) == false) goto L16;
        Long r2 = Long.valueOf(r5.optLong(OaidModel.KEY_TIME, -1));     // Catch: JSONException -> L27
    L18:
        if (r5.has(OaidModel.KEY_QUERY_TIMES) == false) goto L20;
        Integer r13 = Integer.valueOf(r5.optInt(OaidModel.KEY_QUERY_TIMES, -1));     // Catch: JSONException -> L27
    L22:
        if (r5.has(OaidModel.KEY_HW_ID_VERSION_CODE) == false) goto L24;
        Long r14 = Long.valueOf(r5.optLong(OaidModel.KEY_HW_ID_VERSION_CODE, -1));     // Catch: JSONException -> L27
    L25:
        return new p(r8, r9, r10, r16, r2, r13, r14);
    L24:
        r14 = null;
        goto L25
    L20:
        r13 = null;
        goto L22
    L16:
        r2 = null;
        goto L18
    L12:
        r16 = null;
        goto L14
    L8:
        r10 = null;
    L27:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    Map<String, String> a() {
        HashMap r0 = new HashMap();
        s.a(r0, OaidModel.KEY_ID, this.f15143a);
        s.a(r0, "req_id", this.f15144b);
        s.a(r0, OaidModel.KEY_IS_TRACK_LIMITED, String.valueOf(this.c));
        s.a(r0, OaidModel.KEY_TAKE_MS, String.valueOf(this.d));
        s.a(r0, OaidModel.KEY_TIME, String.valueOf(this.e));
        s.a(r0, OaidModel.KEY_QUERY_TIMES, String.valueOf(this.f));
        s.a(r0, OaidModel.KEY_HW_ID_VERSION_CODE, String.valueOf(this.g));
        return r0;
    }

    JSONObject b() {
        JSONObject r0 = new JSONObject();
        s.a(r0, OaidModel.KEY_ID, this.f15143a);
        s.a(r0, "req_id", this.f15144b);
        s.a(r0, OaidModel.KEY_IS_TRACK_LIMITED, this.c);
        s.a(r0, OaidModel.KEY_TAKE_MS, this.d);
        s.a(r0, OaidModel.KEY_TIME, this.e);
        s.a(r0, OaidModel.KEY_QUERY_TIMES, this.f);
        s.a(r0, OaidModel.KEY_HW_ID_VERSION_CODE, this.g);
        return r0;
    }

    public String toString() {
        return b().toString();
    }
}
