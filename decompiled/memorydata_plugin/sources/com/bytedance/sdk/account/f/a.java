package com.bytedance.sdk.account.f;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sdk.account.a.a.b;
import com.bytedance.sdk.account.a.a.c;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.ss.android.account.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void a(String r0, String r1, String r2, b r3, com.bytedance.sdk.account.a.a.a r4) {
        if (r4 == null) goto L4;
        JSONObject r5 = r4.a(r0);
    L5:
        a(r0, r1, r2, r3, r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    public static void a(String r16, String r17, String r18, b r19, JSONObject r20) {
        if (r19 == null) goto L23;
        String r0 = r19.f;
        if (TextUtils.isEmpty(r0) == false) goto L7;
        r0 = r19.g;
    L7:
        String r7 = r0;
        if (r20 == null) goto L27;
        JSONObject r2 = r20;
    L25:
        r2.put("logid", r19.f3095a);     // Catch: JSONException -> L20
        if (ZeusTransformUtils.instanceOf(r19, c.class) == false) goto L22;
        String r1 = ((c) ZeusTransformUtils.preCheckCast(r19, c.class, "com.obric.memorydata.plugin")).j;     // Catch: JSONException -> L20
        if (TextUtils.isEmpty(r1) == true) goto L22;
        r2.put("logout_from", r1);     // Catch: JSONException -> L20
    L22:
        JSONObject r8 = r2;
        a(r16, r19.c, r17, r18, r19.f3096b, r19.e, r7, r8);
        return;
    L20:
        e = e;
    L21:
        e.printStackTrace();
        goto L22
    L27:
        r2 = new JSONObject();     // Catch: JSONException -> L11
    L11:
        e = e;
        r2 = r20;
        goto L21
    L23:
        a(r16, null, r17, r18, false, -1, null, r20);
    }

    public static void a(String r2, String r3, String r4, String r5, boolean r6) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L17
        if (TextUtils.isEmpty(r4) == true) goto L6;
        r0.put("logid", r4);     // Catch: JSONException -> L17
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L8;
        r0.put("urlpath", r3);     // Catch: JSONException -> L17
    L8:
        r0.put("sdkVersion", 2);     // Catch: JSONException -> L17
        if (TextUtils.isEmpty(r5) == true) goto L11;
        r0.put(WsConstants.KEY_EXTRA, r5);     // Catch: JSONException -> L17
    L11:
        r0.put("passport-sdk-version", 18);     // Catch: JSONException -> L17
        if (r6 == false) goto L14;
        String r7 = "1";
    L15:
        r0.put("user_was_login", r7);     // Catch: JSONException -> L17
        r0.put("result", 0);     // Catch: JSONException -> L17
        b(r2, r0);     // Catch: JSONException -> L17
        return;
    L14:
        r7 = "0";
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    public static void a(String r1, String r2, String r3, String r4, boolean r5, int r6, String r7, JSONObject r8) {
        if (r8 == null) goto L19;
    L4:
        r8.put(WsConstants.KEY_PLATFORM, r3);     // Catch: JSONException -> L16
        r8.put(MemoryInfoSectionEditActivity.KIND_SCENE, r4);     // Catch: JSONException -> L16
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r8.put("urlpath", r2);     // Catch: JSONException -> L16
    L8:
        if (r5 == true) goto L10;
        r8.put("result", 0);     // Catch: JSONException -> L16
        r8.put("errorCode", r6);     // Catch: JSONException -> L16
        if (r7 == null) goto L14;
        r8.put("errDesc", r7);     // Catch: JSONException -> L16
    L14:
        r8.put("passport-sdk-version", 18);     // Catch: JSONException -> L16
        r8.put("sdkVersion", 2);     // Catch: JSONException -> L16
        b(r1, r8);     // Catch: JSONException -> L16
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L10:
        r8.put("result", 1);     // Catch: JSONException -> L16
        goto L14
    L19:
        r8 = new JSONObject();     // Catch: JSONException -> L16
        goto L4
    }

    public static void a(String r2, Throwable r3, int r4) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put("urlpath", new URI(r2).getPath().toLowerCase());     // Catch: Exception -> L4
        r0.put("exception_stack_trace", Log.getStackTraceString(r3));     // Catch: Exception -> L4
        r0.put("exception_msg", r3.getMessage());     // Catch: Exception -> L4
        r0.put("errorCode", r4);     // Catch: Exception -> L4
        r0.put("passport-sdk-version", 18);     // Catch: Exception -> L4
        r0.put("sdkVersion", 2);     // Catch: Exception -> L4
        b("passport_net_err", r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void a(String r2, JSONObject r3) {
        if (r3 == null) goto L9;
    L4:
        r3.put("passport-sdk-version", 18);     // Catch: JSONException -> L6
        r3.put("result", 0);     // Catch: JSONException -> L6
        b(r2, r3);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        r3 = new JSONObject();     // Catch: JSONException -> L6
        goto L4
    }

    private static void b(String r3, JSONObject r4) {
        com.bytedance.sdk.account.utils.b r0 = d.a().f();
        if (r0 == null) goto L13;
        if (r4 != null) goto L11;
    L9:
        r0.a(r3, r4);
        return;
    L11:
        r4.put("params_for_special", "uc_login");     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }
}
