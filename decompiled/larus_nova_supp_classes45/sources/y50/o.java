package y50;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o {
    public static l a(Throwable r4) {
        l r0 = new l();
        r0.a = -1;
        if ((r4 instanceof CustomApiServerException) == false) goto L6;
        CustomApiServerException r5 = (CustomApiServerException) r4;
        r0.a = r5.getErrorCode();
        r0.b = r5.getXTtLogId();
        r0.c = "CustomApiServerException(" + r5.getErrorMsg() + ")";
    L19:
        return r0;
    L6:
        if ((r4 instanceof ApiServerException) == false) goto L9;
        ApiServerException r6 = (ApiServerException) r4;
        r0.c = "ApiServerException(" + r6.getErrorMsg() + ")";
        r0.a = r6.getErrorCode();
        goto L19
    L9:
        if ((r4 instanceof ApiException) == false) goto L12;
        ApiException r7 = (ApiException) r4;
        r0.a = r7.getErrorCode();
        r0.c = "ApiException(" + r7.getMessage() + ")";
        goto L19
    L12:
        if ((r4 instanceof NetworkErrorException) == false) goto L15;
        NetworkErrorException r8 = (NetworkErrorException) r4;
        r0.a = r8.getStatusCode();
        r0.c = "NetworkErrorException(" + r8.getMessage() + ")";
        goto L19
    L15:
        if ((r4 instanceof IOException) == false) goto L17;
        r0.a = 103;
        r0.c = "IOException(" + r4.getMessage() + ")";
        goto L19
    L17:
        if (r4 == null) goto L19;
        r0.c = r4.getMessage();
        goto L19
    }
}
