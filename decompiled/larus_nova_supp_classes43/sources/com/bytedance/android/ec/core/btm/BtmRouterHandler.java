package com.bytedance.android.ec.core.btm;

import android.content.Context;
import android.net.Uri;
import bf.d;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BtmRouterHandler implements d {
    public final Lazy a;

    public BtmRouterHandler() {
        this.a = LazyKt.lazy(BtmRouterHandler$eventService$2.INSTANCE);
    }

    @Override // bf.d
    public final void a(Context r10, Uri r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        if (BtmSDK.INSTANCE.enableRouterMonitor() == true) goto L17;
        return;
    L17:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L11
        if (r11 == null) goto L8;
        String r12 = r11.toString();     // Catch: Exception -> L11
    L9:
        r0.put(com.bytedance.android.ec.core.event.a.KEY_URL, r12);     // Catch: Exception -> L11
        r0.put("sourceVC", r10.getClass().getName());     // Catch: Exception -> L11
    L13:
        xi.a r13 = (xi.a) this.a.getValue();
        if (r13 == null) goto L19;
        r13.logV3("IESEC_Router_Monitor", r0);
        return;
    L19:
        return;
    L8:
        r12 = null;
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r0 = new JSONObject();
        goto L13
    }
}
