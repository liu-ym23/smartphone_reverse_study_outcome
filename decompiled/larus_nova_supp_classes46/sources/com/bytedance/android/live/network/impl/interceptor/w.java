package com.bytedance.android.live.network.impl.interceptor;

import android.net.Uri;
import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w implements Interceptor {
    public final boolean a;

    public w(boolean r1) {
        this.a = r1;
    }

    public final SsResponse<?> intercept(Interceptor.Chain r4) {
        Intrinsics.checkNotNullParameter(r4, "chain");
        Request r0 = r4.request();
        SsResponse<?> r5 = r4.proceed(r0);     // Catch: Exception -> L5
        a(r0, r5);     // Catch: Exception -> L5
        return r5;
    L5:
        e = move-exception;
        Spm.Companion.getClass();
        Spm r1 = Spm.a.a("a100.b4000").result(100);
        String r2 = e.getMessage();
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        vw2.a.a(r1.reason(r2).addArg("path", r0.getPath()), "network");
        throw e;
    }

    public final void a(Request r8, SsResponse<?> r9) {
        Iterator r0 = r9.headers().iterator();
        String r1 = null;
    L4:
        if (r0.hasNext() == false) goto L8;
        Header r2 = (Header) r0.next();
        if (Intrinsics.areEqual(r2.getName(), "x-tt-logid") == false) goto L4;
        r1 = r2.getValue();
        goto L4
    L8:
        boolean r3 = true;
        if (this.a == true) goto L35;
    L20:
        String r4 = "-";
    L21:
        int r5 = 0;
        if (r1 != null) goto L24;
    L27:
        if (r3 == true) goto L43;
        Spm.Companion.getClass();
        Spm r6 = Spm.a.a("a100.b4000").result(r9.code()).addArg("logid", r1).addArg("param", r4).addArg("request_size", Integer.valueOf(r4.length()));
        Object r10 = r9.body();
        if (r10 == null) goto L33;
        String r11 = r10.toString();
        if (r11 == null) goto L33;
        r5 = r11.length();
    L33:
        vw2.a.a(r6.addArg("response_size", Integer.valueOf(r5)).addArg("path", r8.getPath()), "network");
        return;
    L43:
        return;
    L24:
        if (r1.length() == 0) goto L27;
        r3 = false;
        goto L27
    L35:
        Uri r7 = UriProtector.parse(r8.getUrl());     // Catch: Exception -> L18
        Set r12 = UriProtector.getQueryParameterNames(r7);     // Catch: Exception -> L18
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L18
        if ((!r12.isEmpty()) == false) goto L16;
        Iterator r14 = r12.iterator();     // Catch: Exception -> L18
    L14:
        if (r14.hasNext() == false) goto L16;
        String r15 = (String) r14.next();     // Catch: Exception -> L18
        r13.put(r15, UriProtector.getQueryParameter(r7, r15));     // Catch: Exception -> L18
    L16:
        r4 = r13.toString();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.getLocalizedMessage();
        goto L20
    }
}
