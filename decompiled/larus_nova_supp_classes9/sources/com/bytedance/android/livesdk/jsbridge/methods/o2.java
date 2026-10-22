package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "openByteCert")
public final class o2 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public final CompositeDisposable a;

    public final void onTerminate() {
        this.a.clear();
    }

    public o2() {
        this.a = new CompositeDisposable();
    }

    public final void invoke(Object r8, CallContext r9) {
        JSONObject r10 = (JSONObject) r8;
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r9, "context");
        Context r11 = r9.getContext();
        if ((r11 instanceof Activity) == false) goto L78;
        Iterator<String> r0 = r10.keys();
        HashMap r1 = new HashMap();
        v80.b.a r2 = new v80.b.a();
        r2.a = r11;
    L6:
        if (r0.hasNext() == false) goto L43;
        String r13 = r0.next();
        if (r13 == null) goto L6;
        Object r3 = r10.get(r13);
        if (r3 == null) goto L6;
        if ((!Intrinsics.areEqual(r13, "h5_query_params")) == false) goto L17;
        r1.put(r13, r3.toString());
    L17:
        switch(r13.hashCode()) {
            case -873960692: goto L40;
            case 3357091: goto L37;
            case 109254796: goto L34;
            case 530136847: goto L20;
            default: goto L6;
        };
    L20:
        if (r13.equals("h5_query_params") == false) goto L6;
        if ((r3 instanceof JSONObject) == false) goto L6;
        JSONObject r4 = (JSONObject) r3;
        Iterator<String> r14 = r4.keys();
    L25:
        if (r14.hasNext() == false) goto L6;
        String r5 = r14.next();
        if (r5 == null) goto L25;
        Object r6 = r4.get(r5);
        if (r6 == null) goto L25;
        r1.put("h5-params-".concat(r5), r6.toString());
        goto L25
    L34:
        if (r13.equals("scene") == false) goto L6;
        r2.b = r3.toString();
        goto L6
    L37:
        if (r13.equals("mode") == false) goto L6;
        r2.d = r3.toString();
        goto L6
    L40:
        if (r13.equals("ticket") == false) goto L6;
        r2.c = r3.toString();
        goto L6
    L43:
        if (r1.containsKey("use_new_api") == true) goto L45;
        r1.put("use_new_api", "true");
    L45:
        x80.b r15 = x80.c.a(2);
        r2.f = r1;
        r2.e = new n2(this);
        r15.a.a(new v80.b(r2));
        return;
    }
}
