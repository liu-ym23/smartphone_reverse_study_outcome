package com.bytedance.android.anniex.worker;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.sdk.xbridge.cn.protocol.BDXBridge;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.worker.JsWorker;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class JSWorkerBDXBridge extends BDXBridge<ReadableMap, ReadableMap> implements ue7.d {
    public c k;
    public final Lazy l;
    public final g m;

    public static final class a implements com.bytedance.sdk.xbridge.cn.protocol.e<ReadableMap, ReadableMap> {
        public a() {
        }

        public final void a(le7.a r10, me7.d r11) {
            Intrinsics.checkNotNullParameter(r10, "call");
            Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        }
    }

    public final com.bytedance.sdk.xbridge.cn.protocol.e<ReadableMap, ReadableMap> i() {
        return new a();
    }

    public final com.bytedance.sdk.xbridge.cn.protocol.c j() {
        return (k) this.l.getValue();
    }

    public final void u() {
        this.m.b();
    }

    public final IDLXBridgeMethod.XBridgeThreadType n(le7.a<ReadableMap> r10) {
        Intrinsics.checkNotNullParameter(r10, "call");
        return IDLXBridgeMethod.XBridgeThreadType.ASYNC_THREAD;
    }

    public JSWorkerBDXBridge(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "containerID");
        super(r10, r11);
        this.l = LazyKt.lazy(JSWorkerBDXBridge$bridgeHandler$2.INSTANCE);
        this.m = new g(r11, new View(r10), r10, this);
    }

    public final void a(String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        c r1 = this.k;
        if (r1 == null) goto L14;
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Gson r0 = new Gson();     // Catch: Exception -> L9
        JsonObject r12 = new JsonObject();     // Catch: Exception -> L9
        r12.addProperty("event_name", r10);     // Catch: Exception -> L9
        r12.add("data", r0.toJsonTree(r11));     // Catch: Exception -> L9
        String r13 = r0.toJson(r12);     // Catch: Exception -> L9
        JsWorker r14 = r1.b;     // Catch: Exception -> L9
        if (r14 == null) goto L15;
        r14.postMessage(r13);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L9:
        e = move-exception;
        HybridLogger r15 = HybridLogger.a;
        HybridLogger.i("AnnieXJSWorker", "postMessage: " + e, null, 12);
        return;
    }
}
