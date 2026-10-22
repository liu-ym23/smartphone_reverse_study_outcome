package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.PiaRenderingExecuteResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "pia.rendering.execute")
public final class g1 extends e7.p<e7.o0, PiaRenderingExecuteResultModel> {
    public final void onTerminate() {
    }

    public g1() {
    }

    public final void invoke(Object r10, CallContext r11) {
        e7.o0 r12 = (e7.o0) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r13 = r12.a();
        if (r13 != null) goto L5;
    L8:
        boolean r14 = true;
    L9:
        if (r14 == false) goto L11;
        finishWithFailure(new PiaMethod.Error("'url' can not be null!"));
        return;
    L11:
        Object r15 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L20
        JsonObject r16 = r12.getContext();     // Catch: Throwable -> L20
        if (r16 == null) goto L17;
        Object r17 = com.bytedance.android.annie.util.h.c.fromJson(r16, Map.class);     // Catch: Throwable -> L20
        if ((r17 instanceof Map) == false) goto L17;
        Map r18 = (Map) r17;     // Catch: Throwable -> L20
    L18:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r19) == true) goto L26;
        r15 = r19;
    L26:
        Map r20 = (Map) r15;
        c47.c r21 = com.bytedance.android.annie.pia.b.a;
        e1 r22 = new e1(this);
        f1 r23 = new f1(this);
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r22, "resolve");
        Intrinsics.checkNotNullParameter(r23, "reject");
        k47.d r1 = (k47.d) c47.b.b(k47.d.class);
        if (r1 != null) goto L30;
        r23.accept(new PiaMethod.Error("not implemented!"));
        return;
    L30:
        if (r20 != null) goto L32;
        Map r24 = new HashMap();
    L33:
        r1.a(r13, "annie", r24, r22, r23);
        return;
    L32:
        r24 = r20;
    L17:
        r18 = null;
    L20:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L5:
        if (StringsKt.isBlank(r13) == true) goto L8;
        r14 = false;
        goto L9
    }
}
