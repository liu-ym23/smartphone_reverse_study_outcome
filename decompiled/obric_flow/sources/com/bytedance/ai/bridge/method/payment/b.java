package com.bytedance.ai.bridge.method.payment;

import a3.f;
import com.bytedance.ai.bridge.method.payment.bean.RequestOrderRequest;
import com.bytedance.ai.bridge.method.payment.bean.RequestOrderResponse;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f1884a = null;

    static {
        f1884a = LazyKt.lazy(new f(4));
    }

    public static RequestOrderResponse a(RequestOrderRequest r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
    L6:
        e = move-exception;
        String r10 = e.getMessage();
        if (r10 != null) goto L16;
        r10 = "";
    L16:
        return new RequestOrderResponse(null, "", 13000, r10);
    L10:
        e = move-exception;
        String r11 = "requestOrder error: " + e.getMessage();
        Intrinsics.checkNotNullParameter("AppletPaymentRemoteDataSource", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L21;
        r12.i("AppletPaymentRemoteDataSource", r11);
    L21:
        return new RequestOrderResponse(null, e.traceCode, 10401, "internal error");
    L4:
        if (f1884a.getValue() != null) goto L9;
        throw null;     // Catch: Exception -> L6
    L9:
        throw new ClassCastException();     // Catch: Exception -> L6 CronetIOException -> L10
    }
}
