package com.bytedance.android.live.revenue.common;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r0 {
    public static final int a(Throwable r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$errorCode");
        if ((r1 instanceof CustomApiServerException) == false) goto L6;
        return ((CustomApiServerException) r1).getErrorCode();
    L6:
        if ((r1 instanceof HttpResponseException) == false) goto L9;
        return ((HttpResponseException) r1).getStatusCode();
    L9:
        if ((r1 instanceof ApiException) == false) goto L12;
        return ((ApiException) r1).getErrorCode();
    L12:
        if ((r1 instanceof NetworkErrorException) == true) goto L19;
        return -1;
    L19:
        return ((NetworkErrorException) r1).statusCode;
    }
}
