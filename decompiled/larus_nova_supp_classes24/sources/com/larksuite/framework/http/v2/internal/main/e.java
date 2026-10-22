package com.larksuite.framework.http.v2.internal.main;

import com.ss.android.lark.log.Log;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements Interceptor {
    public e() {
    }

    public final Response intercept(Interceptor.Chain r4) {
        Intrinsics.checkNotNullParameter(r4, "chain");
        Request r0 = r4.request();
        Response r5 = r4.proceed(r0);     // Catch: Throwable -> L6 IOException -> L8
        Intrinsics.checkNotNull(r0);
        a(r0, r5, null);
        return r5;
    L8:
        IOException e = e;
        throw e;     // Catch: Throwable -> L10
    L10:
        Throwable th = th;
    L11:
        Intrinsics.checkNotNull(r0);
        a(r0, null, e);
        throw th;
    L6:
        th = move-exception;
        th = th;
        e = null;
        goto L11
    }

    public static void a(Request r5, Response r6, IOException r7) {
        StringBuilder r0 = new StringBuilder();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r1 = r5.header("X-BaseRequest-ID");
        if (r1 == null) goto L5;
        r0.append("[request_id:" + r1 + ']');
    L5:
        if (r6 == null) goto L7;
        r0.append("[status_code:" + r6.code() + ']');
    L7:
        r0.append(String.valueOf(r5));
        if (r7 == null) goto L11;
        r0.append(", Error{error='" + r7.getMessage() + "'}");
    L11:
        if (r7 == null) goto L13;
        Log.e("lark_http", r0.toString(), r7);
        return;
    L13:
        Log.i("lark_http", r0.toString());
    }
}
