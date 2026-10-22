package com.bytedance.android.live.browser.jsbridge.method;

import android.content.Context;
import android.view.View;
import com.bytedance.android.annie.xbridge.mix.IJavaMethod2Annie;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import e30.d;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m16.b;
import n56.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openLive")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/method/OpenLiveMethodV3;", "Lcom/bytedance/android/annie/xbridge/mix/IJavaMethod2Annie;", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenLiveMethodV3 extends IJavaMethod2Annie {
    public final String getName() {
        return "openLive";
    }

    public OpenLiveMethodV3(b r2) {
        Intrinsics.checkNotNullParameter(r2, "contextProviderFactory");
        super(r2);
    }

    public final c c(b r5) {
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
        ue7.c r6 = (ue7.c) r5.c(ue7.c.class);
        HybridLogger r0 = HybridLogger.a;
        StringBuilder r1 = new StringBuilder("containerInstance?.context() = ");
        View r2 = null;
        if (r6 == null) goto L5;
        Context r3 = r6.context();
    L6:
        r1.append(r3);
        HybridLogger.m("OpenLiveMethodV3", r1.toString(), null, null, 12);
        if (r6 == null) goto L9;
        Context r4 = r6.context();
    L10:
        WeakReference r7 = new WeakReference(r4);
        if (r6 == null) goto L14;
        r2 = r6.i();
    L14:
        return new d(r7, new WeakReference(r2));
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
