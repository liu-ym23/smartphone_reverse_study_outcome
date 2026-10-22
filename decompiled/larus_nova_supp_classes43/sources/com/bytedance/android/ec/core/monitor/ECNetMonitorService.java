package com.bytedance.android.ec.core.monitor;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.adapter.api.net.IECNetMonitorService;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.Json;
import com.bytedance.android.ec.core.utils.k0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECNetMonitorService implements IECNetMonitorService {
    public final Lazy a;

    @Override // com.bytedance.android.ec.adapter.api.net.IECNetMonitorService
    public final Object netMonitorInterceptor() {
        return null;
    }

    @Override // com.bytedance.android.ec.adapter.api.net.IECNetMonitorService
    public final List<Object> interceptors() {
        return (List) this.a.getValue();
    }

    @Override // com.bytedance.android.ec.adapter.api.net.IECNetMonitorService
    public final void preloadMonitorInterceptors() {
        List r0 = (List) this.a.getValue();
    }

    public ECNetMonitorService() {
        this.a = LazyKt.lazy(AnonymousClass2.INSTANCE);
    }

    @Override // com.bytedance.android.ec.adapter.api.net.IECNetMonitorService
    public final boolean canRecord() {
        return ECSettingKeys.c();
    }

    @Override // com.bytedance.android.ec.adapter.api.net.IECNetMonitorService
    public final JSONObject netReportParams(String r10, Long r11) {
        Intrinsics.checkNotNullParameter(r10, "info");
        int r1 = k0.a;
        Intrinsics.checkNotNullParameter(r10, "info");
        di.d r12 = k0.a(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return k0.i(r12);
    }

    @Override // com.bytedance.android.ec.adapter.api.net.IECNetMonitorService
    public final void reportECCommonNetRequestEvent(boolean r10, int r11, String r12, int r13, String r14, long r15, je.a r16, String r17) {
        Intrinsics.checkNotNullParameter(r12, "path");
        JSONObject r0 = new JSONObject();
        r0.put("ttnet_code", String.valueOf(r11));
        r0.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, r13);
        r0.put("path", r12);
        if (r14 != null) goto L5;
        r14 = "";
    L5:
        r0.put(MessageIndication.MESSAGE_TYPE_MSG, r14);
        if (r17 != null) goto L8;
        r17 = "";
    L8:
        r0.put("logId", r17);
        int r18 = i.a;
        if (r12 == null) goto L18;
        Lazy r19 = Json.a;
        List<String> r20 = ((ECPathWhiteLists) GsonProtectorUtils.fromJson((Gson) Json.a.getValue(), ECSettingKeys.m(), ECPathWhiteLists.class)).getPaths();
        if (r20 == null) goto L18;
        Iterator<String> r21 = r20.iterator();
    L14:
        if (r21.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(r12, r21.next()) == false) goto L14;
        boolean r22 = true;
    L20:
        if (r22 == false) goto L22;
        JSONObject r23 = new JSONObject();
        r23.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, r15);
        JSONObject r24 = new JSONObject();
        int r25 = ECMonitorService.b;
        ECMonitorService.a.a("ec_sdk_net_request", r0, r23, r24);
    L27:
        if (r10 == true) goto L35;
        dm.a.a("ECNetMonitorService").w("ec net failed: category:" + r0, null);
        return;
    L35:
        return;
    L22:
        r0.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, r15);
        com.bytedance.android.ec.sdk.helper.g.a.logV3("ec_sdk_net_request", r0);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        dm.a.a("ECNetMonitorService").w("post event failed: ec_sdk_net_request, exp: " + th, null);
        ECExceptionMonitor.e(th);
    L18:
        r22 = false;
        goto L20
    }
}
