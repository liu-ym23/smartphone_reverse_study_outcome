package com.obric.cae.cloud.applog;

import android.util.Pair;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.common.utility.CommonHttpException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class a implements INetworkClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.article.common.network.a f6937a;

    public a() {
        this.f6937a = new com.bytedance.article.common.network.a();
    }

    public static void a() {
        com.obric.cae.log.a.c("AppLogNetworkClient", "=== SSNetworkClient All Methods ===");     // Catch: Exception -> L13
        Method[] r2 = com.bytedance.article.common.network.a.class.getMethods();     // Catch: Exception -> L13
        int r3 = r2.length;     // Catch: Exception -> L13
        int r5 = 0;
    L4:
        if (r5 >= r3) goto L22;
        Method r6 = r2[r5];     // Catch: Exception -> L13
        StringBuilder r7 = new StringBuilder();     // Catch: Exception -> L13
        r7.append(Modifier.toString(r6.getModifiers()));     // Catch: Exception -> L13
        r7.append(" ");     // Catch: Exception -> L13
        r7.append(r6.getReturnType().getSimpleName());     // Catch: Exception -> L13
        r7.append(" ");     // Catch: Exception -> L13
        r7.append(r6.getName());     // Catch: Exception -> L13
        r7.append("(");     // Catch: Exception -> L13
        Class<?>[] r8 = r6.getParameterTypes();     // Catch: Exception -> L13
        int r9 = 0;
    L7:
        if (r9 >= r8.length) goto L11;
        if (r9 <= 0) goto L10;
        r7.append(", ");     // Catch: Exception -> L13
    L10:
        r7.append(r8[r9].getSimpleName());     // Catch: Exception -> L13
        r9 = r9 + 1;     // Catch: Exception -> L13
        goto L7
    L11:
        r7.append(")");     // Catch: Exception -> L13
        com.obric.cae.log.a.c("AppLogNetworkClient", r7.toString());     // Catch: Exception -> L13
        r5 = r5 + 1;
        goto L4
    L22:
        return;
    L13:
        e = move-exception;
        com.obric.cae.log.a.a("AppLogNetworkClient", "Failed to print SSNetworkClient methods: " + e.getMessage(), e);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String get(String r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        com.obric.cae.log.a.c("AppLogNetworkClient", "GET request to: " + r4);
        com.obric.cae.log.a.c("AppLogNetworkClient", "Using SSNetworkClient directly");
        a();     // Catch: Exception -> L5
        String r3 = this.f6937a.a(r4, r6, null);     // Catch: Exception -> L5
        com.obric.cae.log.a.c("AppLogNetworkClient", "GET response: " + r3);     // Catch: Exception -> L5
        return r3;
    L5:
        e = move-exception;
        com.obric.cae.log.a.a("AppLogNetworkClient", "GET failed: " + e.getMessage(), e);
        throw e;
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r5, List<Pair<String, String>> r6) {
        List<Pair<String, String>> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        com.obric.cae.log.a.c("AppLogNetworkClient", "POST request with params to: " + r5);
        StringBuilder r1 = new StringBuilder("POST params count: ");
        if (r7 == null) goto L5;
        int r3 = r7.size();
    L6:
        com.obric.cae.log.a.c("AppLogNetworkClient", r1.append(r3).toString());
        String r4 = this.f6937a.a(r5, r7);     // Catch: Exception -> L9
        com.obric.cae.log.a.c("AppLogNetworkClient", "POST response: " + r4);     // Catch: Exception -> L9
        return r4;
    L9:
        e = move-exception;
        com.obric.cae.log.a.a("AppLogNetworkClient", "POST failed: " + e.getMessage(), e);
        throw e;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r10, byte[] r11, String r12) {
        com.obric.cae.log.a.c("AppLogNetworkClient", "POST request to: " + r10 + " with content type: " + r12);
        StringBuilder r1 = new StringBuilder("POST data size: ");
        if (r11 == null) goto L5;
        int r3 = r11.length;
    L6:
        com.obric.cae.log.a.c("AppLogNetworkClient", r1.append(r3).append(" bytes").toString());
        String r9 = this.f6937a.a(r10, r11, true, r12, true);     // Catch: Exception -> L9
        com.obric.cae.log.a.c("AppLogNetworkClient", "POST response: " + r9);     // Catch: Exception -> L9
        return r9;
    L9:
        e = move-exception;
        com.obric.cae.log.a.a("AppLogNetworkClient", "POST failed: " + e.getMessage(), e);
        throw e;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r5, byte[] r6, Map<String, String> r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        com.obric.cae.log.a.c("AppLogNetworkClient", "POST request to: " + r5);
        StringBuilder r1 = new StringBuilder("POST data size: ");
        if (r6 == null) goto L5;
        int r3 = r6.length;
    L6:
        com.obric.cae.log.a.c("AppLogNetworkClient", r1.append(r3).append(" bytes").toString());
        String r4 = this.f6937a.a(r5, r6, r8, null);     // Catch: Exception -> L9
        com.obric.cae.log.a.c("AppLogNetworkClient", "POST response: " + r4);     // Catch: Exception -> L9
        return r4;
    L9:
        e = move-exception;
        com.obric.cae.log.a.a("AppLogNetworkClient", "POST failed: " + e.getMessage(), e);
        throw e;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public byte[] postStream(String r6, byte[] r7, Map<String, String> r8) {
        Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        com.obric.cae.log.a.c("AppLogNetworkClient", "POST stream request to: " + r6);     // Catch: CommonHttpException -> L9
        StringBuilder r2 = new StringBuilder("POST stream data size: ");     // Catch: CommonHttpException -> L9
        if (r7 == null) goto L6;
        int r1 = r7.length;     // Catch: CommonHttpException -> L9
    L7:
        com.obric.cae.log.a.c("AppLogNetworkClient", r2.append(r1).append(" bytes").toString());     // Catch: CommonHttpException -> L9
        return this.f6937a.b(r6, r7, r9, null);
    L6:
        r1 = 0;
    L9:
        e = move-exception;
        com.obric.cae.log.a.a("AppLogNetworkClient", "POST stream failed: " + e.getMessage(), e);
        e.printStackTrace();
        return null;
    }
}
