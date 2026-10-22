package com.bytedance.apm.doctor;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.obric.memorydata.database.entity.ChatMessage;
import com.ss.android.common.b.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f1303a;

    static {
        f1303a = new AtomicInteger(0);
    }

    public static void a(String r6, JSONObject r7) {
        JSONObject r3 = r7.optJSONObject("DATA_DOCTOR");
        if (r3 != null) goto L14;
        r3 = new JSONObject();
    L14:
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        if (r3.optInt("DATA_ID", -1) != (-1)) goto L9;
        r3.put("DATA_ID", f1303a.incrementAndGet());     // Catch: Exception -> L11
    L9:
        r3.put("DATA_PROCESS", d.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")));     // Catch: Exception -> L11
        r3.put("DATA_TYPE", r6);     // Catch: Exception -> L11
        r3.put("DATA_AID", ApmContext.getAid());     // Catch: Exception -> L11
        r7.put("DATA_DOCTOR", r3);     // Catch: Exception -> L11
        JSONObject r8 = new JSONObject(r7.toString());     // Catch: Exception -> L11
        DoctorManager.getInstance().a("DATA_DOWNGRADE", r8);     // Catch: Exception -> L11
    }

    public static void a(String r6, JSONObject r7, boolean r8) {
        JSONObject r3 = r7.optJSONObject("DATA_DOCTOR");
        if (r3 != null) goto L14;
        r3 = new JSONObject();
    L14:
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        if (r3.optInt("DATA_ID", -1) != (-1)) goto L9;
        r3.put("DATA_ID", f1303a.incrementAndGet());     // Catch: Exception -> L11
    L9:
        r3.put("DATA_PROCESS", d.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")));     // Catch: Exception -> L11
        r3.put("DATA_TYPE", r6);     // Catch: Exception -> L11
        r3.put("DATA_SAMPLE", r8);     // Catch: Exception -> L11
        r3.put("DATA_AID", ApmContext.getAid());     // Catch: Exception -> L11
        r7.put("DATA_DOCTOR", r3);     // Catch: Exception -> L11
        JSONObject r9 = new JSONObject(r7.toString());     // Catch: Exception -> L11
        DoctorManager.getInstance().a("DATA_RECEIVE", r9);     // Catch: Exception -> L11
        DoctorManager.getInstance().a("DATA_CACHE", r9);     // Catch: Exception -> L11
    }

    public static void a(JSONObject r2) {
        if (r2 != null) goto L7;
        return;
    L7:
        JSONObject r0 = new JSONObject(r2.toString());     // Catch: Exception -> L6
        DoctorManager.getInstance().a("DATA_SAVE_TO_DB", r0);     // Catch: Exception -> L6
        return;
    }

    private static void a(JSONObject r1, String r2) {
        if (r1 != null) goto L7;
        return;
    L7:
        DoctorManager.getInstance().a(r2, r1);     // Catch: Exception -> L6
        return;
    }

    public static void a(byte[] r3) {
        List<JSONObject> r4 = d(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        Iterator<JSONObject> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        a((JSONObject) ZeusTransformUtils.preCheckCast(r5.next(), JSONObject.class, "com.obric.memorydata.plugin"), "DATA_SEND_BEGIN");
        goto L7
    }

    public static void a(byte[] r4, JSONObject r5) {
        Iterator<JSONObject> r6 = d(r4).iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        JSONObject r1 = (JSONObject) ZeusTransformUtils.preCheckCast(r6.next(), JSONObject.class, "com.obric.memorydata.plugin");
        JSONObject r2 = new JSONObject(r5.toString());     // Catch: JSONException -> L11
        JSONObject r3 = r1.optJSONObject("DATA_DOCTOR");     // Catch: JSONException -> L11
        if (r3 == null) goto L9;
        r2.put("DATA_DOCTOR", r3);     // Catch: JSONException -> L11
    L9:
        a(r2, "DATA_SEND_RESPONSE");     // Catch: JSONException -> L11
        a(r1.put(ChatMessage.TYPE_RESPONSE, r2), "DATA_SEND_RESPONSE_NEW");     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L4
    }

    public static void b(byte[] r4) {
        Iterator<JSONObject> r5 = d(r4).iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        JSONObject r0 = (JSONObject) ZeusTransformUtils.preCheckCast(r5.next(), JSONObject.class, "com.obric.memorydata.plugin");
        JSONObject r1 = r0.optJSONObject("DATA_DOCTOR");     // Catch: Exception -> L11
        if (r1 == null) goto L9;
        r1.put("DATA_SEND_RESULT", 200);     // Catch: Exception -> L11
    L9:
        a(r0, "DATA_SEND_SUCCESS");
        a(r0, "DATA_SEND_END");
        goto L4
    }

    public static void c(byte[] r3) {
        Iterator<JSONObject> r4 = d(r3).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        JSONObject r0 = (JSONObject) ZeusTransformUtils.preCheckCast(r4.next(), JSONObject.class, "com.obric.memorydata.plugin");
        a(r0, "DATA_SEND_FAIL");
        a(r0, "DATA_SEND_END");
        goto L4
    }

    private static List<JSONObject> d(byte[] r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        String r2 = new String(r7);
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return null;
    L8:
        ArrayList r8 = new ArrayList();
        JSONObject r3 = new JSONObject(r2);     // Catch: Exception -> L35
        int r5 = 0;
        if (r3.has(Constants.KEY_LIST) == false) goto L29;
        JSONArray r0 = r3.optJSONArray(Constants.KEY_LIST);     // Catch: Exception -> L35
        if (r0 != null) goto L15;
        return null;
    L15:
        int r1 = 0;
    L17:
        if (r1 >= r0.length()) goto L34;
        JSONObject r4 = r0.getJSONObject(r1);     // Catch: Exception -> L35
        if (r4 == null) goto L28;
        JSONArray r6 = r4.optJSONArray("data");     // Catch: Exception -> L35
        if (r6 == null) goto L28;
        int r9 = 0;
    L26:
        if (r9 >= r6.length()) goto L28;
        r8.add(r6.getJSONObject(r9));     // Catch: Exception -> L35
        r9 = r9 + 1;     // Catch: Exception -> L35
    L28:
        r1 = r1 + 1;     // Catch: Exception -> L35
        goto L17
    L29:
        JSONArray r10 = r3.optJSONArray("data");     // Catch: Exception -> L35
    L31:
        if (r5 >= r10.length()) goto L34;
        r8.add(r10.getJSONObject(r5));     // Catch: Exception -> L35
        r5 = r5 + 1;
    L34:
        return r8;
    }
}
