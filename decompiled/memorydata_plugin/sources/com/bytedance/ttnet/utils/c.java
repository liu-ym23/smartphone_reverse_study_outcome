package com.bytedance.ttnet.utils;

import com.bytedance.common.utility.h;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f3331a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f3332b = null;
    private static volatile boolean c = true;

    public interface a {
        void a(String r1, com.bytedance.ttnet.b.b r2);
    }

    public interface b {
        void a(String r1, String r2, int r3, boolean r4, JSONObject r5);

        void a(String r1, String r2, String r3, com.bytedance.ttnet.b.b r4);
    }

    static {
    }

    public static b a() {
        return f3331a;
    }

    public static void a(b r2) {
        f3331a = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
    }

    public static void a(String r6, String r7, int r8, boolean r9, JSONObject r10) {
        b r0 = f3331a;
        if (r0 == null) goto L6;
        r0.a(r6, r7, r8, r9, r10);
        return;
    }

    public static void a(String r1, String r2, String r3, com.bytedance.ttnet.b.b r4) {
        b r0 = f3331a;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3, r4);
        return;
    }

    public static void a(String r2, List<Header> r3, RetrofitMetrics r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (c == true) goto L5;
        return;
    L5:
        r4.genReqTicketStart();
        String r0 = null;
        if (i.a(r2).getHost().endsWith(com.bytedance.ttnet.b.a()) == false) goto L10;
        r0 = String.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L14
    L10:
        if (h.a(r0) == true) goto L12;
        r5.add(new Header("X-SS-REQ-TICKET", r0));     // Catch: Throwable -> L14
    L12:
        r4.genReqTicketEnd();
    }

    public static void a(boolean r0) {
        c = r0;
    }

    public static a b() {
        return f3332b;
    }
}
