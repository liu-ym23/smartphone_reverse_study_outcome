package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d0 implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ String a;
    public final /* synthetic */ Map.Entry b;
    public final /* synthetic */ IJsBridgeManager c;
    public final /* synthetic */ int d;

    public static final class a extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
        public final /* synthetic */ d0 a;

        public final void onTerminate() {
            ((com.bytedance.ies.xbridge.n) this.a.b.getValue()).a().release();
        }

        public a(d0 r1) {
            this.a = r1;
        }

        public final void invoke(Object r4, CallContext r5) {
            JSONObject r6 = (JSONObject) r4;
            Intrinsics.checkNotNullParameter(r6, "params");
            Intrinsics.checkNotNullParameter(r5, "context");
            Logger.d("XbridgeManager", "xbridge start,fun name:" + this.a.a);
            if ((((com.bytedance.ies.xbridge.n) this.a.b.getValue()).a() instanceof XCoreBridgeMethod) == false) goto L11;
            XCoreBridgeMethod r0 = ((com.bytedance.ies.xbridge.n) this.a.b.getValue()).a();
            if (r0 == null) goto L10;
            g66.c r1 = r0.getContextProviderFactory();
            if (r1 == null) goto L11;
            r1.f(CallContext.class, r5);
            goto L11
        L10:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod");
        L11:
            r6.put("func", this.a.a);
            XBridgeMethod r7 = ((com.bytedance.ies.xbridge.n) this.a.b.getValue()).a();
            m30.g r2 = new m30.g(r6);
            c0 r8 = new c0(this);
            if (this.a.d != 2) goto L14;
            XBridgePlatformType r3 = XBridgePlatformType.LYNX;
        L15:
            r7.handle(r2, r8, r3);
            return;
        L14:
            r3 = XBridgePlatformType.WEB;
            goto L15
        }
    }

    public d0(String r1, Map.Entry r2, IJsBridgeManager r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new a(this);
    }
}
