package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import com.bytedance.android.annie.xbridge.mix.IJavaMethod2Annie;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "copyToClipboard")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/ClipboardMethodV3;", "Lcom/bytedance/android/annie/xbridge/mix/IJavaMethod2Annie;", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClipboardMethodV3 extends IJavaMethod2Annie {
    public final String getName() {
        return "copyToClipboard";
    }

    public ClipboardMethodV3(m16.b r2) {
        Intrinsics.checkNotNullParameter(r2, "contextProviderFactory");
        super(r2);
    }

    public final n56.c c(m16.b r3) {
        Intrinsics.checkNotNullParameter(r3, "providerFactory");
        ue7.c r4 = (ue7.c) r3.c(ue7.c.class);
        if (r4 == null) goto L5;
        Context r5 = r4.context();
    L7:
        return new f0(new WeakReference(r5));
    L5:
        r5 = null;
        goto L7
    }
}
