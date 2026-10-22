package com.larus.voicecall.impl.component.denoise;

import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class DenoiseNetUtil {
    public static final DenoiseNetUtil a = null;

    static {
        a = new DenoiseNetUtil();
    }

    public DenoiseNetUtil() {
    }

    public final Object a(e0 r14, Continuation<? super f> r15) {
        if ((r15 instanceof DenoiseNetUtil$reportDenoiseStatus$1) == false) goto L7;
        DenoiseNetUtil$reportDenoiseStatus$1 r0 = (DenoiseNetUtil$reportDenoiseStatus$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        DenoiseNetUtil$reportDenoiseStatus$1 r11 = r0;
        Object r16 = r11.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r11.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L17:
        com.larus.network.http.f r17 = (com.larus.network.http.a) r16;
        if ((r17 instanceof com.larus.network.http.f) == false) goto L21;
        FLogger.a.e("DenoiseNetUtil", "reportDenoiseStatus err=" + r17.d);
        return null;
    L21:
        return (f) ((com.larus.network.http.a) r17).b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        r14.getClass();
        JSONObject r4 = new JSONObject();
        r4.put("denoise_status", r14.a.getValue());
        r4.put("bot_id", r14.b);
        r4.put("room_id", r14.c);
        r11.label = 1;
        r16 = HttpExtKt.k("Audio", f.class, "/alice/call/report_denoise_status", r4, null, null, false, null, null, null, r11, 1008);
        if (r16 != r2) goto L17;
        return r2;
    L7:
        r0 = new DenoiseNetUtil$reportDenoiseStatus$1(this, r15);
        goto L8
    }
}
