package com.bytedance.ai.jsb;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.utils.g;
import com.bytedance.android.ec.core.utils.FontWeight;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/jsb/AISetIsNeedAliveMethod;", "Lcom/bytedance/ai/jsb/AISetIsNeedAliveMethodIDL;", "<init>", "()V", "defaultAliveTime", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/jsb/AISetIsNeedAliveMethodIDL$SetIsNeedAliveParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/jsb/AISetIsNeedAliveMethodIDL$AISetIsNeedAliveResultModal;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AISetIsNeedAliveMethod extends AISetIsNeedAliveMethodIDL {
    public final int b;

    public AISetIsNeedAliveMethod() {
        this.b = FontWeight.WEIGHT_600;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AISetIsNeedAliveMethodIDL.b r13 = (AISetIsNeedAliveMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g.a.d("AISetIsNeedAliveMethod", "set alive time is : " + r13.getTime());
        Integer r0 = r13.getTime();
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        int r14 = this.b;
        if (r1 <= r14) goto L9;
        r1 = r14;
    L9:
        a0 r15 = r10.getContainerContext();
        if (r15 == null) goto L12;
        String r16 = r15.getAppletId();
    L13:
        AppletRuntimeManager.INSTANCE.getClass();
        if (AppletRuntimeManager.i(null, null, r16) != null) goto L35;
        h.a.a(r12, r16 + " is not running", null, null, 14);
        return;
    L35:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L26
        a0 r18 = r10.getContainerContext();     // Catch: Throwable -> L26
        if (r18 == null) goto L19;
        String r19 = r18.getAppletId();     // Catch: Throwable -> L26
    L20:
        AppletRuntime r20 = AppletRuntimeManager.i(null, null, r19);     // Catch: Throwable -> L26
        if (r20 == null) goto L23;
        r20.F(r13.isNeedAlive(), r1);     // Catch: Throwable -> L26
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L24:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L26
    L29:
        if (Result.isSuccess-impl(r22) == false) goto L32;
        Unit r23 = (Unit) r22;
        Intrinsics.checkNotNullParameter(AISetIsNeedAliveMethodIDL.a.class, "<this>");
        BaseModel r24 = c.a(AISetIsNeedAliveMethodIDL.a.class);
        ((AISetIsNeedAliveMethodIDL.a) r24).setTime(r1);
        r12.b((ResultModel) r24, "");
    L32:
        if (Result.exceptionOrNull-impl(r22) == null) goto L38;
        h.a.a(r12, null, null, null, 15);
        return;
    L38:
        return;
    L23:
        r21 = null;
        goto L24
    L19:
        r19 = null;
    L26:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L12:
        r16 = null;
        goto L13
    L5:
        r1 = this.b;
        goto L6
    }
}
