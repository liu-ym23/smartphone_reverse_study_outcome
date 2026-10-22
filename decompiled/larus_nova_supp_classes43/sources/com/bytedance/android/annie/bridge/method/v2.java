package com.bytedance.android.annie.bridge.method;

import android.os.Vibrator;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "vibrate")
public final class v2 extends com.bytedance.ies.web.jsbridge2.f<Object, Object> {

    public static final class a {
    }

    static {
    }

    public final void onTerminate() {
    }

    public v2() {
    }

    public final void invoke(Object r10, CallContext r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        Object r12 = r11.getContext().getSystemService("vibrator");
        JSONObject r1 = null;
        if ((r12 instanceof Vibrator) == false) goto L5;
        Vibrator r13 = (Vibrator) r12;
    L26:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        if ((r10 instanceof JSONObject) == false) goto L10;
        r1 = (JSONObject) r10;     // Catch: Throwable -> L15
    L10:
        if (r1 == null) goto L12;
        long r14 = r1.optLong(com.bytedance.android.ec.core.event.a.KEY_DURATION);     // Catch: Throwable -> L15
    L13:
        Object r15 = Result.constructor-impl(Long.valueOf(r14));     // Catch: Throwable -> L15
    L17:
        long r16 = 50;
        if (Result.isSuccess-impl(r15) == false) goto L22;
        long r17 = ((Number) r15).longValue();
        if (r17 <= 0) goto L22;
        r16 = r17;
    L22:
        if (r13 == null) goto L24;
        r13.vibrate(r16);
    L24:
        JSONObject r18 = new JSONObject();
        r18.put("code", 1);
        r18.put(MessageIndication.MESSAGE_TYPE_MSG, "SUCCESS");
        finishWithResult(r18);
        return;
    L12:
        r14 = 0;
    L15:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L5:
        r13 = null;
        goto L26
    }
}
