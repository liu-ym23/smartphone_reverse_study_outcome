package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.xbridge.mix.StateMethodFinder;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.protocol.XBridge3MethodFinder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "canIUse")
public final class d extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public final JSBridgeManager a;
    public final m16.b b;

    public final void onTerminate() {
    }

    public d(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        this.b = r10;
    }

    public d(JSBridgeManager r1) {
        this.a = r1;
    }

    public final void invoke(Object r10, CallContext r11) {
        JSONObject r12 = (JSONObject) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r13 = r12.optString("method");
        JSONObject r14 = new JSONObject();
        JSBridgeManager r0 = this.a;
        int r1 = 1;
        if (r0 == null) goto L10;
        List r15 = CollectionsKt.toMutableList(r0.e);
        if (r15 != null) goto L7;
    L27:
        r1 = 0;
    L28:
        r14.put("isAvailable", r1);
        finishWithResult(r14);
        return;
    L7:
        if (r15.contains(r13) != true) goto L27;
    L10:
        if (this.b == null) goto L27;
        m16.b r16 = this.b;
        if (r16 == null) goto L27;
        s26.d r17 = s26.d.c;
        k16.b r18 = s26.d.c.d("default_bid", k16.b.class);
        if (r18 == null) goto L27;
        List r19 = r18.L(r16);
        if (r19 == null) goto L27;
        ArrayList r20 = new ArrayList();
        r20.add(new StateMethodFinder(r16));
        r20.addAll(r19);
        r20.add(new XBridge3MethodFinder());
        Iterator r21 = r20.iterator();
    L19:
        if (r21.hasNext() == false) goto L27;
        MethodFinder r22 = (MethodFinder) r21.next();
        if ((r22 instanceof StateMethodFinder) == false) goto L23;
        String r23 = "webcast";
    L25:
        if (r22.d(r23, r13) == null) goto L19;
    L23:
        r23 = "";
        goto L25
    }
}
