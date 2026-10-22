package com.bytedance.ai.bridge.method.payment;

import com.bytedance.ai.bridge.method.payment.bean.GetOrderPaymentRequest;
import com.bytedance.ai.bridge.method.payment.bean.GetOrderPaymentResponse;
import com.bytedance.ai.bridge.method.payment.bean.GetOrderPaymentWithSignRequest;
import com.bytedance.ai.bridge.method.payment.bean.GetOrderPaymentWithSignResponse;
import com.bytedance.ai.bridge.method.payment.bean.GetSignPageDataRequest;
import com.bytedance.ai.bridge.method.payment.bean.GetSignPageDataResponse;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new a());
    }

    public static AppletPaymentApi c() {
        return (AppletPaymentApi) a.getValue();
    }

    public static GetOrderPaymentResponse a(GetOrderPaymentRequest r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        return (GetOrderPaymentResponse) c().getOrderPayment(r10).execute().body();
    L11:
        e = move-exception;
        com.bytedance.ai.utils.g.a.i("AppletPaymentRemoteDataSource", "getOrderPayment error: " + e.getMessage());
        return new GetOrderPaymentResponse(null, ((TTNetExceptionStorage) e).traceCode, 10401, "internal error");
    L5:
        e = move-exception;
        String r11 = e.getMessage();
        if (r11 != null) goto L10;
        r11 = "";
    L10:
        return new GetOrderPaymentResponse(null, "", 13000, r11);
    }

    public static GetOrderPaymentWithSignResponse b(GetOrderPaymentWithSignRequest r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        return (GetOrderPaymentWithSignResponse) c().getOrderPaymentWithSign(r10).execute().body();
    L11:
        e = move-exception;
        com.bytedance.ai.utils.g.a.i("AppletPaymentRemoteDataSource", "getOrderPaymentWithSign error: " + e.getMessage());
        return new GetOrderPaymentWithSignResponse(null, ((TTNetExceptionStorage) e).traceCode, 10401, "internal error");
    L5:
        e = move-exception;
        String r11 = e.getMessage();
        if (r11 != null) goto L10;
        r11 = "";
    L10:
        return new GetOrderPaymentWithSignResponse(null, "", 13000, r11);
    }

    public static GetSignPageDataResponse d(GetSignPageDataRequest r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        return (GetSignPageDataResponse) c().getSignPageData(r10).execute().body();
    L11:
        e = move-exception;
        com.bytedance.ai.utils.g.a.i("AppletPaymentRemoteDataSource", "getSignPageData error: " + e.getMessage());
        return new GetSignPageDataResponse(null, ((TTNetExceptionStorage) e).traceCode, 10401, "internal error");
    L5:
        e = move-exception;
        String r11 = e.getMessage();
        if (r11 != null) goto L10;
        r11 = "";
    L10:
        return new GetSignPageDataResponse(null, "", 13000, r11);
    }
}
