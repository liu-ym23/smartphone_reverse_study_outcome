package com.bytedance.awemeopen.infra.plugs.applog;

import android.accounts.NetworkErrorException;
import com.bytedance.awemeopen.servicesapi.network.AoNetworkService;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.bdinstall.g0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class NetworkClientForApplog implements g0 {
    public static final NetworkClientForApplog a = null;
    public static final Lazy b = null;

    public NetworkClientForApplog() {
    }

    static {
        a = new NetworkClientForApplog();
        b = LazyKt.lazy(NetworkClientForApplog$netService$2.INSTANCE);
    }

    public final String get(String r20, Map<String, String> r21) throws RangersHttpException {
        Intrinsics.checkNotNullParameter(r20, "url");
        Intrinsics.checkNotNullParameter(r21, "requestHeaders");
        AoNetworkService r13 = (AoNetworkService) b.getValue();     // Catch: Exception -> L22
        ArrayList r2 = new ArrayList();     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r21, "map");     // Catch: Exception -> L22
        Iterator r1 = ((HashMap) r21).entrySet().iterator();     // Catch: Exception -> L22
    L5:
        if (r1.hasNext() == false) goto L7;
        Map.Entry r7 = (Map.Entry) r1.next();     // Catch: Exception -> L22
        r2.add(new q64.c.C0256c((String) r7.getKey(), (String) r7.getValue()));     // Catch: Exception -> L22
        goto L5
    L7:
        q64.b r0 = r13.s2(new q64.a(r20, "GET", false, true, false, new q64.c(r2), null, 60000, 60000, 60000)).execute();     // Catch: Exception -> L22
        int r3 = r0.a;     // Catch: Exception -> L22
        if (200 <= r3) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L20;
        q64.e r5 = r0.e;     // Catch: Exception -> L22
        if (r5 == null) goto L18;
        String r6 = r5.f();     // Catch: Exception -> L22
        if (r6 == null) goto L18;
        return r6;
    L18:
        return "";
    L20:
        f.a("NetworkClientForApplog", "get failed ".concat(r20));     // Catch: Exception -> L22
        throw new NetworkErrorException("event network error");     // Catch: Exception -> L22
    L10:
        if (r3 >= 300) goto L12;
        r4 = true;
    L22:
        e = move-exception;
        throw e;
    }

    public final String post(String r21, byte[] r22, Map<String, String> r23) throws RangersHttpException {
        Intrinsics.checkNotNullParameter(r21, "url");
        Intrinsics.checkNotNullParameter(r22, "data");
        Intrinsics.checkNotNullParameter(r23, "requestHeaders");
        AoNetworkService r13 = (AoNetworkService) b.getValue();     // Catch: Exception -> L22
        ArrayList r7 = new ArrayList();     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r23, "map");     // Catch: Exception -> L22
        Iterator r2 = ((HashMap) r23).entrySet().iterator();     // Catch: Exception -> L22
    L5:
        if (r2.hasNext() == false) goto L7;
        Map.Entry r8 = (Map.Entry) r2.next();     // Catch: Exception -> L22
        r7.add(new q64.c.C0256c((String) r8.getKey(), (String) r8.getValue()));     // Catch: Exception -> L22
        goto L5
    L7:
        q64.b r0 = r13.s2(new q64.a(r21, "POST", false, true, false, new q64.c(r7), new b(r22), 60000, 60000, 60000)).execute();     // Catch: Exception -> L22
        int r1 = r0.a;     // Catch: Exception -> L22
        if (200 <= r1) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L20;
        q64.e r4 = r0.e;     // Catch: Exception -> L22
        if (r4 == null) goto L18;
        String r5 = r4.f();     // Catch: Exception -> L22
        if (r5 == null) goto L18;
        return r5;
    L18:
        return "";
    L20:
        f.a("NetworkClientForApplog", "post failed ".concat(r21));     // Catch: Exception -> L22
        throw new NetworkErrorException("event network error");     // Catch: Exception -> L22
    L10:
        if (r1 >= 300) goto L12;
        r3 = true;
    L22:
        e = move-exception;
        throw e;
    }

    public final byte[] postStream(String r21, byte[] r22, Map<String, String> r23) throws RangersHttpException {
        Intrinsics.checkNotNullParameter(r21, "url");
        Intrinsics.checkNotNullParameter(r22, "data");
        Intrinsics.checkNotNullParameter(r23, "requestHeaders");
        AoNetworkService r13 = (AoNetworkService) b.getValue();     // Catch: Exception -> L22
        ArrayList r7 = new ArrayList();     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r23, "map");     // Catch: Exception -> L22
        Iterator r2 = ((HashMap) r23).entrySet().iterator();     // Catch: Exception -> L22
    L5:
        if (r2.hasNext() == false) goto L7;
        Map.Entry r8 = (Map.Entry) r2.next();     // Catch: Exception -> L22
        r7.add(new q64.c.C0256c((String) r8.getKey(), (String) r8.getValue()));     // Catch: Exception -> L22
        goto L5
    L7:
        q64.b r0 = r13.s2(new q64.a(r21, "POST", false, true, false, new q64.c(r7), new b(r22), 60000, 60000, 60000)).execute();     // Catch: Exception -> L22
        int r1 = r0.a;     // Catch: Exception -> L22
        if (200 <= r1) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L20;
        q64.e r4 = r0.e;     // Catch: Exception -> L22
        if (r4 == null) goto L19;
        byte[] r5 = r4.a();     // Catch: Exception -> L22
        if (r5 == null) goto L19;
        return r5;
    L19:
        return new byte[0];
    L20:
        f.a("NetworkClientForApplog", "post failed ".concat(r21));     // Catch: Exception -> L22
        throw new NetworkErrorException("event network error");     // Catch: Exception -> L22
    L10:
        if (r1 >= 300) goto L12;
        r3 = true;
    L22:
        e = move-exception;
        throw e;
    }
}
