package o5;

import com.bytedance.ai.resource.core.bean.OpenPlatformBaseResponse;
import com.bytedance.ai.resource.core.net.AIRealDeviceDebugVerifyRequestBody;
import com.bytedance.retrofit2.SsResponse;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    static {
    }

    public static OpenPlatformBaseResponse a(String r15, String r16, String r17) {
        Intrinsics.checkNotNullParameter(r15, "debugToken");
        Intrinsics.checkNotNullParameter(r16, "encryptedDebugPayload");
        Intrinsics.checkNotNullParameter(r17, "xToken");
        if (StringsKt.isBlank(r17) == true) goto L5;
        SsResponse r0 = j.a().verifyDebugChannel(r17, 2, "application/json", new AIRealDeviceDebugVerifyRequestBody(0, r15, r16, 1, null)).execute();
        if (r0.isSuccessful() == false) goto L12;
        OpenPlatformBaseResponse r1 = (OpenPlatformBaseResponse) r0.body();
        if (r1 == null) goto L14;
        return r1;
    L14:
        return new OpenPlatformBaseResponse(-1, "empty response body", null, null, 12, null);
    L12:
        return new OpenPlatformBaseResponse(r0.code(), r0.message(), null, null, 8, null);
    L5:
        return new OpenPlatformBaseResponse(-1, "x-tt-token is empty", null, null, 12, null);
    }
}
