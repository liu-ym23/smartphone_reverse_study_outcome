package com.bytedance.framwork.core.sdklib.apm6;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeInfo;
import com.bytedance.services.apm.api.IApmAgent;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import t4.k;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private t4.j f1939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private k f1940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f1941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f1942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f1944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Boolean f1945h;

    static /* synthetic */ class a {
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static h f1946a;

        static {
            f1946a = new h(null);
        }

        static /* synthetic */ h a() {
            return f1946a;
        }
    }

    private h() {
        this.f1944g = null;
    }

    /* synthetic */ h(a r10) {
        this();
    }

    private JSONObject a(t4.c r10) {
        JSONObject r11 = new JSONObject(new String(r10.b()));     // Catch: Exception -> L16
        String r12 = r11.optString("data");     // Catch: Throwable -> L9
        if (r12.isEmpty() == true) goto L20;
    L8:
        return new JSONObject(new String(r12.getBytes()));
    L20:
        return r11;
    L9:
        th = move-exception;
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L16
        r13.put("message", "success");     // Catch: Exception -> L16
        if ((th instanceof JSONException) == false) goto L15;
        IApmAgent r14 = (IApmAgent) c4.d.a(IApmAgent.class);     // Catch: Exception -> L16
        if (r14 == null) goto L15;
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L16
        r15.put("resp", r11.toString());     // Catch: Exception -> L16
        r14.monitorEvent("sdkm_resp_err", null, null, r15);     // Catch: Exception -> L16
    L15:
        return r13;
    L16:
        return null;
    }

    public static h b() {
        return b.a();
    }

    @Nullable
    private String c() {
        List<String> r10 = LogReportController.getInstance().getReportList();
        if (TextUtils.isEmpty(this.f1941d) == true) goto L12;
        if (r10 != null) goto L6;
    L10:
        return null;
    L6:
        if (r10.size() <= 0) goto L10;
        return ReportConsts.HTTPS + this.f1941d + new URL(r10.get(0)).getPath();
    L12:
        if (TextUtils.isEmpty(this.f1944g) == true) goto L16;
        return this.f1944g;
    L16:
        if (this.f1942e == false) goto L18;
        this.f1943f++;
    L18:
        if (r10 == null) goto L26;
        int r11 = r10.size();
        int r12 = this.f1943f;
        if (r11 <= r12) goto L23;
        if (r12 < 0) goto L23;
        String r13 = r10.get(r12);
    L25:
        return r13;
    L23:
        this.f1943f = 0;
        r13 = r10.get(0);
        goto L25
    L26:
        return null;
    }

    private t4.c d(String r11, byte[] r12) {
        HashMap r10 = new HashMap();
        HashMap r13 = new HashMap(j.b());
        r10.put(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);
        byte[] r14 = null;
        if (r12.length > 128) goto L5;
    L31:
        if (r14 != null) goto L33;
        r14 = r12;
    L33:
        r10.put(NetConst.KEY_CONTENT_TYPE, NetConst.CONTENT_TYPE);
        if (LogReportController.getInstance().isEncrypt() == false) goto L44;
        r14 = g3.b.a(r14, r14.length);
        if (r14 == null) goto L44;
        r13.put("tt_data", "a");
        String r15 = UrlUtils.addParamsToURL(r11, r13);
        r10.put(NetConst.KEY_CONTENT_TYPE, "application/octet-stream;tt-data=a");
        if (j.f() == false) goto L40;
        j3.c.a("APM-SDK", "before encrypt url:" + r15);
    L40:
        LinkedList r16 = new LinkedList();
        String r17 = g3.a.g(r15, r16);
        if (j.f() == false) goto L43;
        j3.c.a("APM-SDK", "after encrypt url:" + r17);
    L43:
        r10.putAll(ListUtils.listToMap(r16));
    L45:
        if (r14 == null) goto L49;
        r12 = r14;
    L49:
        if (j.f() == false) goto L52;
        j3.c.a("APM-SDK", "http request:url:" + r17 + " headers:" + r10);
    L52:
        return j.a(r17, r10, r12);
    L44:
        r17 = UrlUtils.addParamsToURL(r11, r13);
        goto L45
    L5:
        if (this.f1939b != null) goto L7;
        this.f1939b = (t4.j) c4.d.a(t4.j.class);
    L7:
        t4.j r18 = this.f1939b;
        if (r18 == null) goto L27;
        int r19 = this.f1938a;
        if (r19 != 1) goto L16;
        byte[] r110 = r18.a(r12, 15);
        if (r110 == null) goto L14;
        r10.put(NetConst.KEY_CONTENT_ENCODING, NetConst.TYPE_ZSTD);
        r10.put("Content-Encoding-Level", String.valueOf(15));
    L14:
        r14 = r110;
        goto L27
    L16:
        if (r19 != 2) goto L27;
        if (this.f1940c != null) goto L20;
        this.f1940c = (k) c4.d.a(k.class);
    L20:
        k r20 = this.f1940c;
        if (r20 == null) goto L25;
        byte[] r21 = r20.get();
        if (r21 == null) goto L25;
        r14 = this.f1939b.b(r12, r21, 15);
    L25:
        if (r14 == null) goto L27;
        r10.put(NetConst.KEY_CONTENT_ENCODING, NetConst.TYPE_ZSTD_DICT);
        r10.put("Content-Encoding-Level", String.valueOf(15));
    L27:
        if (r14 != null) goto L31;
        r14 = com.bytedance.framwork.core.sdkmonitor.f.a(r12, r10);     // Catch: Exception -> L53
        if (r14 == null) goto L31;
        r10.put(NetConst.KEY_CONTENT_ENCODING, NetConst.GZIP);     // Catch: Exception -> L53
        goto L31
    }

    boolean e(byte[] r11) {
        if (r11 != null) goto L5;
    L63:
        return false;
    L5:
        if (r11.length == 0) goto L63;
        String r10 = c();     // Catch: Throwable -> L61
        t4.c r12 = d(r10, r11);     // Catch: Throwable -> L61
        if (j.f() == false) goto L14;
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L61
        r13.append("http result:");     // Catch: Throwable -> L61
        if (r12 != null) goto L12;
        Object r14 = -1;     // Catch: Throwable -> L61
    L13:
        r13.append(r14);     // Catch: Throwable -> L61
        j3.c.a("APM-SDK", r13.toString());     // Catch: Throwable -> L61
        goto L14
    L12:
        r14 = r12.c() + " header:" + r12.a();     // Catch: Throwable -> L61
    L14:
        this.f1941d = null;     // Catch: Throwable -> L61
        this.f1944g = null;     // Catch: Throwable -> L61
        if (r12 != null) goto L17;
    L54:
        this.f1942e = true;     // Catch: Throwable -> L61
        Boolean r15 = this.f1945h;     // Catch: Throwable -> L61
        if (r15 != null) goto L57;
    L59:
        this.f1945h = Boolean.TRUE;     // Catch: Throwable -> L61
        return false;
    L57:
        if (r15.booleanValue() == false) goto L59;
        LogReportController.getInstance().shortBackOff();     // Catch: Throwable -> L61
        goto L59
    L17:
        if (r12.c() <= 0) goto L54;
        this.f1942e = false;     // Catch: Throwable -> L61
        if (500 <= r12.c()) goto L22;
    L30:
        JSONObject r16 = a(r12);     // Catch: Throwable -> L61
        if (r16 != null) goto L33;
    L52:
        this.f1945h = Boolean.TRUE;     // Catch: Throwable -> L61
        return false;
    L33:
        if (r12.c() != 200) goto L52;
        String r17 = r16.optString("message");     // Catch: Throwable -> L61
        String r18 = r16.optString("redirect");     // Catch: Throwable -> L61
        long r19 = r16.optLong("delay");     // Catch: Throwable -> L61
        if ("success".equals(r17) == false) goto L38;
        LogReportController.getInstance().restore();     // Catch: Throwable -> L61
        this.f1944g = r10;     // Catch: Throwable -> L61
        this.f1945h = Boolean.FALSE;     // Catch: Throwable -> L61
        boolean r20 = false;
        boolean r110 = true;
    L42:
        JSONObject r21 = r16.optJSONObject("downgrade_rule");     // Catch: Throwable -> L61
        if (r21 == null) goto L45;
        com.bytedance.framwork.core.sdklib.apm6.downgrade.a.a().c(DowngradeInfo.a(r21), true);     // Catch: Throwable -> L61
    L45:
        this.f1941d = r18;     // Catch: Throwable -> L61
        if (r19 <= 0) goto L48;
        LogReportController.getInstance().delayReport(r19);     // Catch: Throwable -> L61
    L48:
        if (r20 == false) goto L50;
        LogReportController.getInstance().dropData();     // Catch: Throwable -> L61
    L51:
        return r110;
    L50:
        LogReportController.getInstance().recoveryFromDropData();     // Catch: Throwable -> L61
        goto L51
    L38:
        this.f1945h = Boolean.TRUE;     // Catch: Throwable -> L61
        r20 = "drop data".equals(r17);     // Catch: Throwable -> L61
        if (j.f() == false) goto L41;
        j3.c.a("APM-SDK", "responseMessage:" + r17);     // Catch: Throwable -> L61
    L41:
        r110 = false;
        goto L42
    L22:
        if (r12.c() > 600) goto L30;
        Boolean r111 = this.f1945h;     // Catch: Throwable -> L61
        if (r111 != null) goto L26;
    L28:
        this.f1945h = Boolean.TRUE;     // Catch: Throwable -> L61
        return false;
    L26:
        if (r111.booleanValue() == false) goto L28;
        LogReportController.getInstance().longBackOff();     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        j3.c.c("APM-SDK", "sendLog failed.", th);
        goto L63
    }

    public void f(int r10) {
        this.f1938a = r10;
    }
}
