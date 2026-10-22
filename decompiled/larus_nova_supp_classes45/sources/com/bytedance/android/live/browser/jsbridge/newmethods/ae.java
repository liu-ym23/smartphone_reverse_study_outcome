package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.os.Vibrator;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "vibrate")
public final class ae extends com.bytedance.ies.web.jsbridge2.f<Object, Object> {

    public static final class a {
    }

    static {
    }

    public final void onTerminate() {
    }

    public ae() {
    }

    public final void invoke(Object r7, CallContext r8) {
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        Object r9 = r8.getContext().getSystemService("vibrator");
        if ((r9 instanceof Vibrator) == true) goto L5;
        r9 = null;
    L5:
        Vibrator r11 = (Vibrator) r9;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        if ((r7 instanceof JSONObject) == true) goto L9;
        r7 = null;
    L9:
        JSONObject r12 = (JSONObject) r7;     // Catch: Throwable -> L15
        if (r12 == null) goto L12;
        long r1 = r12.optLong("duration");     // Catch: Throwable -> L15
    L13:
        Object r13 = Result.constructor-impl(Long.valueOf(r1));     // Catch: Throwable -> L15
    L17:
        long r4 = 50;
        if (Result.isSuccess-impl(r13) == false) goto L22;
        long r2 = ((Number) r13).longValue();
        if (r2 <= 0) goto L22;
        r4 = r2;
    L22:
        if (r11 == null) goto L24;
        r11.vibrate(r4);
    L24:
        JSONObject r14 = new JSONObject();
        r14.put("code", 1);
        r14.put("msg", "SUCCESS");
        finishWithResult(r14);
        return;
    L12:
        r1 = 0;
    L15:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
