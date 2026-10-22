package com.bytedance.android.live.room.share.jsbridge;

import android.content.Context;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.xbridge.mix.IJavaMethod2Annie;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@XBridgeMethod(biz = "webcast", name = "share")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/room/share/jsbridge/ShareMethodV3;", "Lcom/bytedance/android/annie/xbridge/mix/IJavaMethod2Annie;", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShareMethodV3 extends IJavaMethod2Annie {
    public final String getName() {
        return "share";
    }

    public ShareMethodV3(m16.b r2) {
        Intrinsics.checkNotNullParameter(r2, "contextProviderFactory");
        super(r2);
    }

    public final n56.c c(m16.b r5) {
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
        ue7.c r0 = (ue7.c) r5.c(ue7.c.class);
        JSBridgeManager r6 = (JSBridgeManager) r5.c(JSBridgeManager.class);
        com.bytedance.android.annie.card.g r3 = null;
        if (r0 == null) goto L5;
        Context r1 = r0.context();
    L6:
        WeakReference r2 = new WeakReference(r1);
        if (r6 == null) goto L10;
        r3 = r6.t;
    L10:
        return new i(r2, r3);
    L5:
        r1 = null;
        goto L6
    }
}
