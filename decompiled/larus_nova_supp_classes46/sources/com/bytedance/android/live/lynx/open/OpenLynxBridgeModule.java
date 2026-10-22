package com.bytedance.android.live.lynx.open;

import android.content.Context;
import com.bytedance.ies.web.jsbridge2.c0;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/lynx/open/OpenLynxBridgeModule;", "Lcom/lynx/jsbridge/LynxModule;", "", "func", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "", "call", "Lorg/json/JSONObject;", "data", "Lcom/bytedance/ies/web/jsbridge2/c0;", "invokeCallback$livehybrid_impl_saasRelease", "(Lorg/json/JSONObject;Lcom/bytedance/ies/web/jsbridge2/c0;)V", "invokeCallback", "Ljava/util/concurrent/ConcurrentHashMap;", "callRegistry", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/android/live/lynx/open/a;", "bridgeImpl", "Lcom/bytedance/android/live/lynx/open/a;", "Landroid/content/Context;", "context", "", "param", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenLynxBridgeModule extends LynxModule {
    private final a bridgeImpl;
    private final ConcurrentHashMap<c0, Callback> callRegistry;

    public OpenLynxBridgeModule(Context r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "param");
        super(r2);
        this.callRegistry = new ConcurrentHashMap();
        if ((r3 instanceof a) == true) goto L5;
        r3 = null;
    L5:
        a r4 = (a) r3;
        this.bridgeImpl = r4;
        if (r4 == null) goto L9;
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r4.n = this;
        return;
    }

    public final void invokeCallback$livehybrid_impl_saasRelease(JSONObject r7, c0 r8) {
        Intrinsics.checkNotNullParameter(r7, "data");
        Intrinsics.checkNotNullParameter(r8, "call");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        Callback r9 = this.callRegistry.remove(r8);     // Catch: Throwable -> L14
        if (r9 == null) goto L11;
        Object[] r3 = new Object[1];     // Catch: Throwable -> L14
        Object r4 = r7.remove("__params");     // Catch: Throwable -> L14
        if (r4 != null) goto L8;
    L10:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L14
        r3[0] = kl0.b.d(r7);     // Catch: Throwable -> L14
        r9.invoke(r3);     // Catch: Throwable -> L14
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        Result.constructor-impl(r10);     // Catch: Throwable -> L14
        return;
    L8:
        if ((r4 instanceof JSONObject) == false) goto L10;
        ((JSONObject) r4).remove("__data");     // Catch: Throwable -> L14
        ((JSONObject) r4).remove("__msg_type");     // Catch: Throwable -> L14
        ((JSONObject) r4).remove("__callback_id");     // Catch: Throwable -> L14
        r7.put("code", ((JSONObject) r4).remove("code"));     // Catch: Throwable -> L14
        r7.put("data", r4);     // Catch: Throwable -> L14
        goto L10
    L11:
        r10 = null;
    L14:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @LynxMethod
    public final void call(String r6, ReadableMap r7, Callback r8) {
        Intrinsics.checkNotNullParameter(r6, "func");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        JSONObject r9 = kl0.b.b(r7);     // Catch: Throwable -> L14
        a r1 = this.bridgeImpl;     // Catch: Throwable -> L14
        if (r1 == null) goto L11;
        JSONObject r2 = r9.optJSONObject("data");     // Catch: Throwable -> L14
        if (r2 == null) goto L9;
        String r3 = r2.toString();     // Catch: Throwable -> L14
        if (r3 == null) goto L9;
    L10:
        c0 r10 = r1.r(r6, r3, r9.optString("namespace", "webcast"), r9.optString("eventId", "lynx"));     // Catch: Throwable -> L14
        this.callRegistry.put(r10, r8);     // Catch: Throwable -> L14
    L12:
        Result.constructor-impl(r10);     // Catch: Throwable -> L14
        return;
    L9:
        r3 = "{}";
        goto L10
    L11:
        r10 = null;
    L14:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
