package com.ss.android.deviceregister.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f15145a;

    q(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        SharedPreferences r0 = r4.getSharedPreferences("device_register_oaid_refine", 0);
        this.f15145a = r0;
        a(r4, r0);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        com.ss.android.deviceregister.l.c(com.ss.android.deviceregister.l.f15219a, "OaidSp#constructor", e);
    }

    private static p a(SharedPreferences r13) {
        SharedPreferences r14 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r13, SharedPreferences.class, "com.obric.memorydata.plugin");
        String r0 = r14.getString("lastSuccessQueryOaid", null);
        Integer r8 = Integer.valueOf(r14.getInt("queryHmsTimes", -1));
        if (TextUtils.isEmpty(r0) == true) goto L11;
        JSONObject r15 = new JSONObject(r0);     // Catch: JSONException -> L6
        String r3 = r15.optString(OaidModel.KEY_ID);     // Catch: JSONException -> L6
        String r1 = r15.optString(OaidModel.KEY_IS_TRACK_LIMITED);     // Catch: JSONException -> L6
        String r2 = r15.optString(OaidModel.KEY_TAKE_MS);     // Catch: JSONException -> L6
        String r4 = r15.optString(OaidModel.KEY_TIME);     // Catch: JSONException -> L6
        String r5 = r15.optString("req_id");     // Catch: JSONException -> L6
        String r16 = r15.optString(OaidModel.KEY_HW_ID_VERSION_CODE);     // Catch: JSONException -> L6
        return new p(r3, r5, Boolean.valueOf(Boolean.parseBoolean(r1)), Long.valueOf(s.a(r2, -1)), Long.valueOf(s.a(r4, -1)), r8, Long.valueOf(s.a(r16, -1)));
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L11:
        return null;
    }

    private void a(Context r5, SharedPreferences r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        SharedPreferences r7 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r6, SharedPreferences.class, "com.obric.memorydata.plugin");
        if (r7.getBoolean("migrated", false) == false) goto L5;
        return;
    L5:
        com.ss.android.deviceregister.l.c(com.ss.android.deviceregister.l.f15219a, "OaidSp#migrateDeprecatedSp");
        r7.edit().putBoolean("migrated", true).apply();
        p r8 = null;
        SharedPreferences r1 = r4.getSharedPreferences("device-register-oaid", 0);
        if (r1.contains("lastSuccessQueryOaid") == false) goto L8;
        p r9 = a(r1);
        com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "OaidSp#migrateDeprecatedSp spHw");
        r1.edit().clear().apply();
    L12:
        com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "OaidSp#migrateDeprecatedSp oaidModel=" + r9);
        if (r9 == null) goto L16;
        r7.edit().putString(Oaid.KEY_OAID_ID, r9.b().toString()).apply();
        return;
    L16:
        return;
    L8:
        SharedPreferences r10 = r4.getSharedPreferences("device-register-oaid-xiaomi", 0);
        if (r10.contains("lastSuccessQueryOaid") == false) goto L11;
        r8 = b(r10);
        com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "OaidSp#migrateDeprecatedSp spXm");
    L11:
        r10.edit().clear().apply();
        r9 = r8;
        goto L12
    }

    private static p b(SharedPreferences r13) {
        SharedPreferences r14 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r13, SharedPreferences.class, "com.obric.memorydata.plugin");
        String r0 = r14.getString("lastSuccessQueryOaid", null);
        Integer r8 = Integer.valueOf(r14.getInt("queryXiaomiTimes", -1));
        if (TextUtils.isEmpty(r0) == true) goto L11;
        JSONObject r15 = new JSONObject(r0);     // Catch: JSONException -> L6
        String r3 = r15.optString(Oaid.KEY_OAID_ID);     // Catch: JSONException -> L6
        String r4 = r15.optString("req_id");     // Catch: JSONException -> L6
        String r1 = r15.optString("last_success_query_oaid_time");     // Catch: JSONException -> L6
        return new p(r3, r4, null, Long.valueOf(s.a(r15.optString(OaidModel.KEY_TAKE_MS), -1)), Long.valueOf(s.a(r1, -1)), r8, null);
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L11:
        return null;
    }

    p a() {
        return p.a(this.f15145a.getString(Oaid.KEY_OAID_ID, ""));
    }

    void a(p r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.f15145a.edit().putString(Oaid.KEY_OAID_ID, r2.b().toString()).apply();
    }
}
