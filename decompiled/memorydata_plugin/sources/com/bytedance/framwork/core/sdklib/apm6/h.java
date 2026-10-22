package com.bytedance.framwork.core.sdklib.apm6;

import android.text.TextUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f2604b;
    private int c;
    private String d;
    private Boolean e;

    /* JADX INFO: renamed from: com.bytedance.framwork.core.sdklib.apm6.h$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static h f2605a;

        static {
            f2605a = new h(null);
        }

        static /* synthetic */ h a() {
            return f2605a;
        }
    }

    private h() {
        this.d = null;
    }

    /* synthetic */ h(AnonymousClass1 r1) {
        this();
    }

    public static h a() {
        return a.a();
    }

    private com.bytedance.services.apm.api.c a(String r7, byte[] r8) {
        HashMap r6 = new HashMap();
        HashMap r0 = new HashMap(j.b());
        byte[] r1 = com.bytedance.framwork.core.sdkmonitor.f.a(r8, r6);     // Catch: Exception -> L5
    L6:
        if (r1 != null) goto L8;
        r1 = r8;
    L8:
        r6.put(NetConst.KEY_CONTENT_TYPE, "application/json; charset=utf-8");
        if (LogReportController.getInstance().isEncrypt() == false) goto L19;
        r1 = com.bytedance.frameworks.core.encrypt.b.a(r1, r1.length);
        if (r1 == null) goto L19;
        r0.put("tt_data", "a");
        String r9 = UrlUtils.addParamsToURL(r7, r0);
        r6.put(NetConst.KEY_CONTENT_TYPE, "application/octet-stream;tt-data=a");
        if (j.d() == false) goto L15;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "before encrypt url:" + r9);
    L15:
        LinkedList r2 = new LinkedList();
        String r10 = com.bytedance.frameworks.core.encrypt.a.a(r9, r2);
        if (j.d() == false) goto L18;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "after encrypt url:" + r10);
    L18:
        r6.putAll(ListUtils.listToMap(r2));
    L20:
        r6.put(NetConst.KEY_REQUSET_VERISON_CODE, "1");
        if (r1 == null) goto L25;
        r8 = r1;
    L25:
        if (j.d() == false) goto L28;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "http request:url:" + r10 + " headers:" + r6);
    L28:
        return j.a(r10, r6, r8);
    L19:
        r10 = UrlUtils.addParamsToURL(r7, r0);
    L5:
        r1 = null;
        goto L6
    }

    private JSONObject a(com.bytedance.services.apm.api.c r2) {
        JSONObject r1 = new JSONObject(new String(r2.b()));     // Catch: Exception -> L9
        String r3 = r1.optString("data");     // Catch: Throwable -> L7
        if (r3.isEmpty() == true) goto L15;
        return new JSONObject(new String(r3.getBytes()));
    L15:
        return r1;
    L7:
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L9
        r4.put("message", "success");     // Catch: Exception -> L9
        return r4;
    L9:
        return null;
    }

    private String b() {
        List<String> r0 = LogReportController.getInstance().getReportList();
        if (TextUtils.isEmpty(this.f2603a) == true) goto L13;
        if (r0 != null) goto L7;
    L11:
        return null;
    L7:
        if (r0.size() <= 0) goto L11;
        return ReportConsts.HTTPS + this.f2603a + new URL((String) ZeusTransformUtils.preCheckCast(r0.get(0), String.class, "com.obric.memorydata.plugin")).getPath();
    L13:
        if (TextUtils.isEmpty(this.d) == true) goto L17;
        return this.d;
    L17:
        if (this.f2604b == false) goto L19;
        this.c++;
    L19:
        int r1 = r0.size();
        int r4 = this.c;
        if (r1 <= r4) goto L23;
        if (r4 < 0) goto L23;
        String r5 = r0.get(r4);
    L25:
        return (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
    L23:
        this.c = 0;
        r5 = r0.get(0);
        goto L25
    }

    boolean a(byte[] r9) {
        if (r9 != null) goto L5;
    L60:
        return false;
    L5:
        if (r9.length == 0) goto L60;
        String r2 = b();     // Catch: Throwable -> L58
        com.bytedance.services.apm.api.c r10 = a(r2, r9);     // Catch: Throwable -> L58
        if (j.d() == false) goto L14;
        StringBuilder r3 = new StringBuilder().append("http result:");     // Catch: Throwable -> L58
        if (r10 != null) goto L12;
        Object r4 = -1;     // Catch: Throwable -> L58
    L13:
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", r3.append(r4).toString());     // Catch: Throwable -> L58
        goto L14
    L12:
        r4 = r10.a() + " header:" + r10.c();     // Catch: Throwable -> L58
    L14:
        this.f2603a = null;     // Catch: Throwable -> L58
        this.d = null;     // Catch: Throwable -> L58
        boolean r5 = true;
        if (r10 != null) goto L17;
    L51:
        this.f2604b = true;     // Catch: Throwable -> L58
        Boolean r11 = this.e;     // Catch: Throwable -> L58
        if (r11 != null) goto L54;
    L56:
        this.e = true;     // Catch: Throwable -> L58
        return false;
    L54:
        if (r11.booleanValue() == false) goto L56;
        LogReportController.getInstance().shortBackOff();     // Catch: Throwable -> L58
        goto L56
    L17:
        if (r10.a() <= 0) goto L51;
        this.f2604b = false;     // Catch: Throwable -> L58
        if (500 <= r10.a()) goto L22;
    L30:
        JSONObject r6 = a(r10);     // Catch: Throwable -> L58
        if (r6 != null) goto L33;
    L49:
        this.e = true;     // Catch: Throwable -> L58
        return false;
    L33:
        if (r10.a() != 200) goto L49;
        String r12 = r6.optString("message");     // Catch: Throwable -> L58
        String r7 = r6.optString("redirect");     // Catch: Throwable -> L58
        long r8 = r6.optLong("delay");     // Catch: Throwable -> L58
        if ("success".equals(r12) == false) goto L38;
        LogReportController.getInstance().restore();     // Catch: Throwable -> L58
        this.d = r2;     // Catch: Throwable -> L58
        this.e = false;     // Catch: Throwable -> L58
        boolean r13 = false;
    L42:
        this.f2603a = r7;     // Catch: Throwable -> L58
        if (r8 <= 0) goto L45;
        LogReportController.getInstance().delayReport(r8);     // Catch: Throwable -> L58
    L45:
        if (r13 == false) goto L47;
        LogReportController.getInstance().dropData();     // Catch: Throwable -> L58
    L48:
        return r5;
    L47:
        LogReportController.getInstance().recoveryFromDropData();     // Catch: Throwable -> L58
        goto L48
    L38:
        this.e = true;     // Catch: Throwable -> L58
        r13 = "drop data".equals(r12);     // Catch: Throwable -> L58
        if (j.d() == false) goto L41;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "responseMessage:" + r12);     // Catch: Throwable -> L58
    L41:
        r5 = false;
        goto L42
    L22:
        if (r10.a() > 600) goto L30;
        Boolean r14 = this.e;     // Catch: Throwable -> L58
        if (r14 != null) goto L26;
    L28:
        this.e = true;     // Catch: Throwable -> L58
        return false;
    L26:
        if (r14.booleanValue() == false) goto L28;
        LogReportController.getInstance().longBackOff();     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "sendLog failed.", th);
        goto L60
    }
}
