package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxView;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o0 implements com.bytedance.platform.aio.channel.js.a {
    public final wy0.e a;
    public final Function0<LynxView> b;

    public final void a(String r2, com.bytedance.platform.aio.channel.js.c r3) {
        Intrinsics.checkNotNullParameter(r2, "methodName");
        Intrinsics.checkNotNullParameter(r3, "method");
    }

    public final void b(com.bytedance.platform.aio.channel.js.model.e r5) {
        Intrinsics.checkNotNullParameter("rpcChannelMessage", "eventName");
        Intrinsics.checkNotNullParameter(r5, Constants.Keys.DATA);
        Object r3 = null;
        if (((Boolean) e0.b.getValue(null, e0.a[0])).booleanValue() == true) goto L17;
    L15:
        this.a.sendJsEvent("rpcChannelMessage", r5);
        return;
    L17:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        Object r1 = Result.constructor-impl(new JSONObject(GsonHelper.get().toJson(r5)));     // Catch: Throwable -> L6
    L9:
        if (Result.isFailure-impl(r1) == true) goto L12;
        r3 = r1;
    L12:
        com.bytedance.platform.aio.channel.js.model.e r4 = (JSONObject) r3;
        if (r4 == null) goto L15;
        r5 = r4;
    L6:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public final void d(JavaOnlyMap r5) {
        Intrinsics.checkNotNullParameter("rpcChannelMessageV2", "eventName");
        Intrinsics.checkNotNullParameter(r5, Constants.Keys.DATA);
        LynxView r0 = (LynxView) this.b.invoke();
        if (r0 == null) goto L5;
        r0.sendGlobalEvent("rpcChannelMessageV2", JavaOnlyArray.of(new Object[]{r5}));
        return;
    L5:
        jy0.b.c("RpcAioBridgeImpl", "cannot get lynx view, data: " + r5, null, 4);
    }

    public o0(wy0.e r2, Function0<? extends LynxView> r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        Intrinsics.checkNotNullParameter(r3, "getLynxView");
        this.a = r2;
        this.b = r3;
    }

    public final void c(String r3, com.bytedance.platform.aio.channel.js.c r4) {
        Intrinsics.checkNotNullParameter(r3, "methodName");
        Intrinsics.checkNotNullParameter(r4, "method");
        this.a.registerMethod(r3, new n0(r4));
    }
}
