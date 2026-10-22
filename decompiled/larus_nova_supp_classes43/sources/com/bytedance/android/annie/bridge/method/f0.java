package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.GetSettingsResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "getSettings")
public final class f0 extends com.bytedance.android.annie.bridge.c<com.bytedance.android.annie.bridge.m, GetSettingsResultModel> {
    public f0() {
    }

    public final void invoke(Object r10, CallContext r11) {
        com.bytedance.android.annie.bridge.m r12 = (com.bytedance.android.annie.bridge.m) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        List<com.bytedance.android.annie.bridge.m.a> r13 = r12.a();
        ArrayList r0 = new ArrayList();
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator<T> r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L12;
        com.bytedance.android.annie.bridge.m.a r15 = (com.bytedance.android.annie.bridge.m.a) r14.next();
        String r16 = r15.b();
        String r17 = r15.a();
        if (r16.length() <= 0) goto L8;
        boolean r18 = true;
    L9:
        if (r18 == false) goto L4;
        com.bytedance.android.annie.bridge.m.a r19 = new com.bytedance.android.annie.bridge.m.a();
        r19.d(r16);
        r19.c(r17);
        r0.add(r19);
        r1.add(r16);
        goto L4
    L8:
        r18 = false;
        goto L9
    L12:
        if (r0.isEmpty() == false) goto L15;
        GetSettingsResultModel r20 = new GetSettingsResultModel();
        r20.a(GetSettingsResultModel.Code.InvalidParam);
        r20.b("empty key or unsupported key type in params");
        finishWithResult(r20);
        return;
    L15:
        if (r1.size() >= r0.size()) goto L25;
        GetSettingsResultModel r21 = new GetSettingsResultModel();
        r21.a(GetSettingsResultModel.Code.InvalidParam);
        r21.b("duplicate keys in params");
        finishWithResult(r21);
        return;
    L25:
        List r22 = ((a9.f) Annie.getService(a9.f.class, r11.a())).getSettings();     // Catch: Exception -> L23
        GetSettingsResultModel r23 = new GetSettingsResultModel();     // Catch: Exception -> L23
        r23.a(GetSettingsResultModel.Code.Success);     // Catch: Exception -> L23
        LinkedHashMap r24 = new LinkedHashMap();     // Catch: Exception -> L23
        Iterator r25 = r22.iterator();     // Catch: Exception -> L23
    L19:
        if (r25.hasNext() == false) goto L21;
        ((i2) r25.next()).getClass();     // Catch: Exception -> L23
        r24.put(null, null);     // Catch: Exception -> L23
        goto L19
    L21:
        r23.c(r24);     // Catch: Exception -> L23
        finishWithResult(r23);     // Catch: Exception -> L23
        return;
    L23:
        GetSettingsResultModel r26 = new GetSettingsResultModel();
        r26.a(GetSettingsResultModel.Code.Failed);
        r26.b("getSettings not implemented in host");
        finishWithResult(r26);
    }
}
