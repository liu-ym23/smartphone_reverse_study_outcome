package com.bytedance.android.live.broadcastgame.api.openplatform;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.ss.android.http.legacy.client.HttpResponseException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
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

    public static final String b(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$prompt");
        if ((r3 instanceof CustomApiServerException) == false) goto L10;
        CustomApiServerException r4 = (CustomApiServerException) r3;
        String r0 = r4.getPrompt();
        if (r0 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r0)) == true) goto L9;
        return null;
    L9:
        return r4.getPrompt();
    L10:
        return null;
    }
}
