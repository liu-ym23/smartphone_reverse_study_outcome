package com.bytedance.sdk.account.utils;

import android.text.TextUtils;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f3163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3164b;

    public e() {
        this.f3163a = new LinkedHashMap();
        this.f3164b = null;
    }

    public e(String r2) {
        this.f3163a = new LinkedHashMap();
        this.f3164b = r2;
    }

    public static String a(Map<String, String> r6, String r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        Iterator r9 = r8.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L17;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = b((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), r7);
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L8;
        String r5 = b(r4, r7);
    L10:
        if (TextUtils.isEmpty(r5) == true) goto L13;
        r5 = r5.replace(Marker.ANY_NON_NULL_MARKER, "%20");
    L13:
        if (r0.length() <= 0) goto L15;
        r0.append("&");
    L15:
        r0.append(r3);
        r0.append("=");
        r0.append(r5);
        goto L4
    L8:
        r5 = "";
        goto L10
    L17:
        return r0.toString();
    }

    private static String b(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public String a() {
        if (this.f3163a.isEmpty() == true) goto L5;
        String r0 = a(this.f3163a, RpcUtils.CHARSET_UTF8);
        String r1 = this.f3164b;
        if (r1 != null) goto L9;
    L17:
        return r0;
    L9:
        if (r1.length() == 0) goto L17;
        if (this.f3164b.indexOf(63) < 0) goto L16;
        StringBuilder r3 = new StringBuilder().append(this.f3164b);
        String r2 = "&";
    L15:
        return r3.append(r2).append(r0).toString();
    L16:
        r3 = new StringBuilder().append(this.f3164b);
        r2 = "?";
        goto L15
    L5:
        return this.f3164b;
    }

    public void a(String r1, int r2) {
        this.f3163a.put(r1, String.valueOf(r2));
    }

    public void a(String r1, String r2) {
        this.f3163a.put(r1, r2);
    }

    public String toString() {
        return a();
    }
}
