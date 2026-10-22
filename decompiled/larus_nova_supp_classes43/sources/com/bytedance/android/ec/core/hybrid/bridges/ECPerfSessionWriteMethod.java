package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.opt.session.ECPerfSessionManager;
import com.bytedance.android.ec.opt.session.model.StageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECPerfSessionWriteMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPerfSessionWriteMethod extends ECBaseBridgeMethod {
    public final String getName() {
        return "ec.writePerfSession";
    }

    public ECPerfSessionWriteMethod() {
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L26
        String r12 = r10.optString(com.bytedance.android.ec.core.event.a.KEY_SESSION_ID);     // Catch: Throwable -> L26
        String r13 = r10.optString("stage");     // Catch: Throwable -> L26
        if (StringsKt.isBlank(r12) == true) goto L39;
        if (StringsKt.isBlank(r13) == true) goto L39;
        String r14 = r10.optString("timestamp", "0");     // Catch: Throwable -> L26
        String r15 = r10.optString("stage_type");     // Catch: Throwable -> L26
        JSONObject r16 = r10.optJSONObject("stage_data");     // Catch: Throwable -> L26
        bm.b r17 = new bm.b(r13, r14);     // Catch: Throwable -> L26
        StageType.Companion.getClass();     // Catch: Throwable -> L26
        StageType r18 = StageType.a.a(r15);     // Catch: Throwable -> L26
        if (r18 != null) goto L11;
        r18 = StageType.NORMAL;     // Catch: Throwable -> L26
    L11:
        Intrinsics.checkNotNullParameter(r18, "<set-?>");     // Catch: Throwable -> L26
        r17.a = r18;     // Catch: Throwable -> L26
        if (r16 == null) goto L14;
        r17.update(z1.k(r16));     // Catch: Throwable -> L26
    L14:
        ECPerfSessionManager.d.d(r12, r13, r17);     // Catch: Throwable -> L26
        r11.a(new JSONObject());     // Catch: Throwable -> L17
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Object r19 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 != null) goto L36;
        return;
    L36:
        r11.onFailed(0, "write session fail: " + r20.getMessage());     // Catch: Throwable -> L33
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L17:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L26
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L26
    L39:
        r11.onFailed(0, "invalid id or stage");     // Catch: Throwable -> L23
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L43:
        return;
    L23:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L26
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }
}
