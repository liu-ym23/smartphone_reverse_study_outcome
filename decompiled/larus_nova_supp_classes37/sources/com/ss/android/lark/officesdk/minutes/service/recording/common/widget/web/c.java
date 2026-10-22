package com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web;

import com.google.gson.Gson;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.WebProxyClientError;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.WebProxyErrorCode;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.WebProxyRequest;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.WebProxyResponse;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.utils.e0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(xwb.d r3, String r4, WebProxyErrorCode r5) {
        Status r0 = Status.FAILURE;
        Gson r1 = e0.a;
        WebProxyResponse.a r2 = WebProxyResponse.Companion;
        WebProxyClientError.Companion.getClass();
        WebProxyClientError r6 = WebProxyClientError.a.a(r5);
        r2.getClass();
        r3.a(r0, e0.c(WebProxyResponse.a.a(r4, r6)));
    }

    public static void a(CoroutineScope r12, String r13, xwb.d r14, com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.a r15) {
        Intrinsics.checkNotNullParameter(r12, "scope");
        Intrinsics.checkNotNullParameter(r14, "callback");
        Intrinsics.checkNotNullParameter(r15, "networkProxy");
        Gson r5 = e0.a;     // Catch: Exception -> L24
        WebProxyRequest r6 = (WebProxyRequest) e0.a(r13, WebProxyRequest.class);     // Catch: Exception -> L24
        if (r6 == null) goto L6;
        String r7 = r6.getProxyRequestId();     // Catch: Exception -> L24
    L7:
        boolean r8 = false;
        if (r7 != null) goto L10;
    L13:
        boolean r9 = true;
    L14:
        if (r9 == false) goto L16;
        lvb.a.b("RecordUX_D_WebProxyHandler", "[parseRequest] error: proxyRequestId is null or blank, data=" + r13);     // Catch: Exception -> L24
        b(r14, "unknown", WebProxyErrorCode.INVALID_REQUEST_FORMAT);     // Catch: Exception -> L24
    L26:
        r6 = null;
    L27:
        if (r6 != null) goto L29;
        return;
    L29:
        lvb.a.e("RecordUX_D_WebProxyHandler", "[handle] request=" + r6);
        BuildersKt.launch$default(r12, Dispatchers.getIO(), null, new MmWebNetworkProxyHandler$handle$1(r15, r6, r14, null), 2, null);
        return;
    L16:
        String r3 = r6.getRequestBase64();     // Catch: Exception -> L24
        if (r3 != null) goto L19;
    L20:
        r8 = true;
    L21:
        if (r8 == false) goto L27;
        lvb.a.b("RecordUX_D_WebProxyHandler", "[parseRequest] error: requestBase64 is null or blank, data=" + r13);     // Catch: Exception -> L24
        b(r14, r7, WebProxyErrorCode.INVALID_REQUEST_FORMAT);     // Catch: Exception -> L24
        goto L26
    L19:
        if (StringsKt.isBlank(r3) == false) goto L21;
    L10:
        if (StringsKt.isBlank(r7) == true) goto L13;
        r9 = false;
        goto L14
    L6:
        r7 = null;
    L24:
        e = move-exception;
        lvb.a.b("RecordUX_D_WebProxyHandler", "[parseRequest] error: data=" + r13 + ", failed: " + e.getMessage() + ", data=" + r13);
        b(r14, "unknown", WebProxyErrorCode.INVALID_REQUEST_FORMAT);
        goto L26
    }
}
