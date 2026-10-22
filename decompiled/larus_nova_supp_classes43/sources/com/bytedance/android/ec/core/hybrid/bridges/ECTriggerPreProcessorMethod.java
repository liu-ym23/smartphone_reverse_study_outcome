package com.bytedance.android.ec.core.hybrid.bridges;

import bolts.Task;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECTriggerPreProcessorMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTriggerPreProcessorMethod extends ECBaseBridgeMethod {
    public final String getName() {
        return "ec.triggerPreProcessor";
    }

    public ECTriggerPreProcessorMethod() {
    }

    public static void d(Integer r10, ECBaseBridgeMethod.a r11) {
        boolean r0 = false;
        if (r10 != null) goto L6;
    L8:
        JSONObject r1 = new JSONObject();
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L21
        JSONObject r13 = null;
        if (r10 != null) goto L12;
    L19:
        Result.constructor-impl(r13);     // Catch: Throwable -> L21
    L23:
        Unit r14 = Unit.INSTANCE;
        r11.a(r1);
        return;
    L12:
        if (r10.intValue() <= 0) goto L14;
        r0 = true;
    L14:
        if (r0 == true) goto L17;
        r10 = null;
    L17:
        if (r10 == null) goto L19;
        r13 = r1.putOpt("sub_code", Integer.valueOf(r10.intValue()));     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L6:
        if (r10.intValue() != (-100)) goto L8;
        r11.onFailed(0, "url is empty");
    }

    public final void c(JSONObject r10, final ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        int r0 = r10.optInt("optimization");
        JSONObject r12 = r10.optJSONObject("data");
        Integer r1 = null;
        if (r12 == null) goto L5;
        String r13 = r12.optString("template_url");
    L6:
        if (r12 == null) goto L8;
        String r14 = r12.optString("na_prefetch_cert");
    L9:
        if (r12 == null) goto L11;
        r1 = Integer.valueOf(r12.optInt("thread_strategy", 0));
    L11:
        bh.b r15 = new bh.b(r0);
        r15.a = r13;
        r15.b = r14;
        if (r1 != null) goto L15;
    L17:
        if (r1 != null) goto L20;
    L22:
        d(r15.b(), r11);
        return;
    L20:
        if (r1.intValue() != 1) goto L22;
        Function1<Integer, Unit> r16 = new ECTriggerPreProcessorMethod$handle$1(this, r11);
        Intrinsics.checkNotNullParameter(r16, "callback");
        Task.callInBackground(new bh.a(r15, r16));
        return;
    L15:
        if (r1.intValue() != 0) goto L17;
        d(r15.b(), r11);
        return;
    L8:
        r14 = null;
        goto L9
    L5:
        r13 = null;
        goto L6
    }
}
