package com.bytedance.apm.a.a;

import android.text.TextUtils;
import com.bytedance.apm.util.q;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.c;
import com.bytedance.services.apm.api.g;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1076a = "https://mon.zijieapi.com/monitor/collect/c/logcollect";

    /* JADX INFO: renamed from: com.bytedance.apm.a.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0080a {
        void onSuccess(boolean r1, int r2, Exception r3, JSONObject r4);
    }

    static {
    }

    public static boolean a(String r8, String r9, String r10, List<String> r11, String r12, JSONObject r13, InterfaceC0080a r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        InterfaceC0080a r16 = (InterfaceC0080a) ZeusTransformUtils.wrapperContextForParams(r14, InterfaceC0080a.class, "com.obric.memorydata.plugin");
        IHttpService r4 = (IHttpService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(IHttpService.class), IHttpService.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L46 IOException -> L50
        HashMap r5 = new HashMap();     // Catch: Exception -> L46 IOException -> L50
        r5.put(MemoryInfoSectionEditActivity.KIND_SCENE, r12);     // Catch: Exception -> L46 IOException -> L50
        g r6 = r4.buildMultipartUpload(f1076a, RpcUtils.CHARSET_UTF8, false, r5);     // Catch: Exception -> L46 IOException -> L50
        r6.a("aid", r8);     // Catch: Exception -> L46 IOException -> L50
        r6.a(Constants.KEY_VERIFY_INFO, q.a());     // Catch: Exception -> L46 IOException -> L50
        r6.a("device_id", r9);     // Catch: Exception -> L46 IOException -> L50
        r6.a("os", LocationInfoConst.SYSTEM);     // Catch: Exception -> L46 IOException -> L50
        r6.a("process_name", r10);     // Catch: Exception -> L46 IOException -> L50
        Iterator r17 = r15.iterator();     // Catch: Exception -> L46 IOException -> L50
    L6:
        if (r17.hasNext() == false) goto L10;
        File r7 = new File((String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L46 IOException -> L50
        if (r7.exists() == false) goto L6;
        HashMap r18 = new HashMap();     // Catch: Exception -> L46 IOException -> L50
        r18.put("logtype", "alog");     // Catch: Exception -> L46 IOException -> L50
        r18.put(MemoryInfoSectionEditActivity.KIND_SCENE, r12);     // Catch: Exception -> L46 IOException -> L50
        r18.put("env", "params.txt");     // Catch: Exception -> L46 IOException -> L50
        r6.a(r7.getName(), r7, null, r18);     // Catch: Exception -> L46 IOException -> L50
        goto L6
    L10:
        HashMap r19 = new HashMap();     // Catch: Exception -> L46 IOException -> L50
        r19.put("filetype", "common_params");     // Catch: Exception -> L46 IOException -> L50
        r19.put("logtype", "env");     // Catch: Exception -> L46 IOException -> L50
        if (r13 != null) goto L13;
        String r20 = null;
    L15:
        if (TextUtils.isEmpty(r20) == false) goto L19;
        JSONObject r21 = new JSONObject();     // Catch: Exception -> L46 IOException -> L50
        r21.put("defaultData", "none commonParams");     // Catch: JSONException -> L54 Exception -> L46 IOException -> L50
    L18:
        r20 = r21.toString();     // Catch: Exception -> L46 IOException -> L50
    L19:
        r6.a("params.txt", r20, "text/plain", r19);     // Catch: Exception -> L46 IOException -> L50
        c r22 = r6.a();     // Catch: Exception -> L46 IOException -> L50
    L41:
        e = move-exception;
        if (r16 != null) goto L44;
    L53:
        return false;
    L44:
        r16.onSuccess(false, 7, e, null);     // Catch: Exception -> L46 IOException -> L50
        goto L53
    L21:
        if (r22.b() != null) goto L25;
        if (r16 == null) goto L24;
        JSONObject r23 = new JSONObject();     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
        r23.put("ALOG_UPLOAD_RESPONSE", "null");     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
        r23.put("ALOG_UPLOAD_STATUS", r22.a());     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
        r16.onSuccess(false, 11, null, r23);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
    L24:
        return false;
    L25:
        JSONObject r24 = new JSONObject(new String(r22.b()));     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
        if (r24.optInt("errno", -1) != 200) goto L38;
        String r25 = r24.optString("message");     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
        if ("long escape".equals(r25) == false) goto L30;
    L36:
        r16.onSuccess(false, 13, null, r24);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
        return false;
    L30:
        if ("drop data".equals(r25) == true) goto L36;
        if (r16 == null) goto L35;
        r16.onSuccess(true, -1, null, r24);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
    L35:
        return true;
    L38:
        if (r16 == null) goto L53;
        r16.onSuccess(false, 6, null, r24);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
        goto L53
    L13:
        r20 = r13.toString();     // Catch: Exception -> L46 IOException -> L50
    L50:
        e = e;
        if (r16 == null) goto L53;
        int r26 = 8;
    L49:
        r16.onSuccess(false, r26, e, null);
    L46:
        e = e;
        if (r16 == null) goto L53;
        r26 = 10;
        goto L49
    }
}
