package com.bytedance.awemeopen.infra.base.net;

import android.app.Application;
import com.bytedance.awemeopen.infra.base.net.mime.d;
import com.bytedance.awemeopen.infra.base.net.request.b;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import q64.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AoNet {
    public static Function0<String> a;
    public static Function0<String> b;
    public static final Lazy c = null;

    public AoNet() {
    }

    static {
        a = AoNet$accessToken$1.INSTANCE;
        b = AoNet$openId$1.INSTANCE;
        c = LazyKt.lazy(AoNet$baseContext$2.INSTANCE);
    }

    public static String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        AoNetResponse r3 = a(r2, null);
        if (r3.isSuccessful() == true) goto L5;
    L9:
        return null;
    L5:
        if (r3.getBody() == null) goto L9;
        return r3.stringBody();
    }

    public static Pair c(String r2) {
        Map r0 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r0, "headerMap");
        AoNetResponse r3 = a(r2, r0);
        String r1 = r3.getHeaderString("x-tt-logid");
        if (r3.isSuccessful() == false) goto L9;
        if (r3.getBody() == null) goto L9;
        return new Pair(r3.stringBody(), r1);
    L9:
        return new Pair(null, r1);
    }

    public static b64.a d(AoNetRequest r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        ConcurrentHashMap<Integer, b> r1 = com.bytedance.awemeopen.infra.base.net.request.a.a;
        Application r2 = (Application) c.getValue();
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "request");
        return new b64.a(r2, r3);
    }

    public static AoNetResponse a(String r24, Map r25) {
        Intrinsics.checkNotNullParameter(r24, "url");
        if (r25 != null) goto L5;
        AoFromSource r0 = AoFromSource.f0default;
        Intrinsics.checkNotNullParameter(r24, "url");
        Intrinsics.checkNotNullParameter(r0, "fromSource");
        Intrinsics.checkNotNullParameter(r24, "httpUrl");
        Intrinsics.checkNotNullParameter(r0, "fromSource");
        ArrayList r9 = new ArrayList();
        AoRequestType r11 = AoRequestType.HOST;
        HashMap r1 = new HashMap();
        Intrinsics.checkNotNullParameter("GET", "method");
        return d(new AoNetRequest(r24, "GET", r0, false, true, false, false, false, new c(r9), true, r11, null, 60000, 60000, 60000, true, null, false, r1)).execute();
    L5:
        AoFromSource r3 = AoFromSource.f0default;
        Intrinsics.checkNotNullParameter(r24, "url");
        Intrinsics.checkNotNullParameter(r3, "fromSource");
        Intrinsics.checkNotNullParameter(r25, "headers");
        AoNetRequest.a r2 = new AoNetRequest.a(r24, r3);
        r2.c(r25);
        r2.g = false;
        Intrinsics.checkNotNullParameter("GET", "method");
        r2.b = "GET";
        r2.o = null;
        return d(r2.a()).execute();
    }

    public static AoNetResponse e(String r1, Map r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r1, "url");
        Intrinsics.checkNotNullParameter(r2, "headers");
        Intrinsics.checkNotNullParameter(r3, "jsonParams");
        return h(r1, AoFromSource.f0default, r3, r2);
    }

    public static AoNetResponse f(String r2, AoFromSource r3, Map r4) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "fromSource");
        Intrinsics.checkNotNullParameter(r4, "headers");
        com.bytedance.awemeopen.infra.base.net.mime.c r0 = new com.bytedance.awemeopen.infra.base.net.mime.c();
        AoNetRequest.a r1 = new AoNetRequest.a(r2, r3);
        r1.c(r4);
        r1.b(r0);
        return d(r1.a()).execute();
    }

    public static AoNetResponse g(String r24, AoFromSource r25, JSONObject r26) {
        Intrinsics.checkNotNullParameter(r24, "url");
        Intrinsics.checkNotNullParameter(r25, "fromSource");
        Intrinsics.checkNotNullParameter(r26, "data");
        d r12 = new d(r26);
        Intrinsics.checkNotNullParameter(r24, "httpUrl");
        Intrinsics.checkNotNullParameter(r25, "fromSource");
        ArrayList r0 = new ArrayList();
        AoRequestType r11 = AoRequestType.HOST;
        HashMap r22 = new HashMap();
        Intrinsics.checkNotNullParameter(r12, "body");
        Intrinsics.checkNotNullParameter("POST", "method");
        return d(new AoNetRequest(r24, "POST", r25, false, true, false, false, false, new c(r0), true, r11, r12, 60000, 60000, 60000, true, null, false, r22)).execute();
    }

    public static AoNetResponse i(String r7, Map r8, Map r9) {
        Intrinsics.checkNotNullParameter(r7, "url");
        Intrinsics.checkNotNullParameter(r8, "headers");
        Intrinsics.checkNotNullParameter(r9, "params");
        AoFromSource r2 = AoFromSource.f0default;
        Intrinsics.checkNotNullParameter(r7, "url");
        Intrinsics.checkNotNullParameter(r2, "fromSource");
        Intrinsics.checkNotNullParameter(r8, "headers");
        com.bytedance.awemeopen.infra.base.net.mime.b r0 = new com.bytedance.awemeopen.infra.base.net.mime.b();
        if (r9 == null) goto L16;
        Intrinsics.checkNotNullParameter(r9, "map");
        Iterator r10 = r9.entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L16;
        Map.Entry r1 = (Map.Entry) r10.next();
        String r3 = (String) r1.getKey();
        String r4 = (String) r1.getValue();
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "value");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "value");
        if (r0.a.size() <= 0) goto L18;
        r0.a.write(38);
    L18:
        String r5 = URLEncoder.encode(r3, "UTF-8");     // Catch: IOException -> L13
        String r6 = URLEncoder.encode(r4, "UTF-8");     // Catch: IOException -> L13
        r0.a.write(r5.getBytes(Charset.forName("UTF-8")));     // Catch: IOException -> L13
        r0.a.write(61);     // Catch: IOException -> L13
        r0.a.write(r6.getBytes(Charset.forName("UTF-8")));     // Catch: IOException -> L13
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    L16:
        AoNetRequest.a r11 = new AoNetRequest.a(r7, r2);
        r11.b(r0);
        r11.c(r8);
        return d(r11.a()).execute();
    }

    public static AoNetResponse h(String r1, AoFromSource r2, JSONObject r3, Map r4) {
        Intrinsics.checkNotNullParameter(r1, "url");
        Intrinsics.checkNotNullParameter(r2, "fromSource");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "headers");
        d r0 = new d(r3);
        AoNetRequest.a r5 = new AoNetRequest.a(r1, r2);
        r5.b(r0);
        r5.c(r4);
        return d(r5.a()).execute();
    }
}
