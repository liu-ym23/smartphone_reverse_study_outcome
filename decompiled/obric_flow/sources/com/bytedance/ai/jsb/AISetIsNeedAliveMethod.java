package com.bytedance.ai.jsb;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.p;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import m1.j;
import n1.a;
import n1.c;
import o1.f;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/jsb/AISetIsNeedAliveMethod;", "Lcom/bytedance/ai/jsb/AISetIsNeedAliveMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/jsb/AISetIsNeedAliveMethodIDL$SetIsNeedAliveParam;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/jsb/AISetIsNeedAliveMethodIDL$AISetIsNeedAliveResultModal;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/jsb/AISetIsNeedAliveMethodIDL$SetIsNeedAliveParam;Lo1/f;)V", "", "defaultAliveTime", "I", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AISetIsNeedAliveMethod extends AISetIsNeedAliveMethodIDL {
    private final int defaultAliveTime;

    public AISetIsNeedAliveMethod() {
        this.defaultAliveTime = 600;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AISetIsNeedAliveMethodIDL.SetIsNeedAliveParam) r10, r11);
    }

    public void handle(c r5, AISetIsNeedAliveMethodIDL.SetIsNeedAliveParam r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        String r12 = "set alive time is : " + r10.getTime();
        Intrinsics.checkNotNullParameter("AISetIsNeedAliveMethod", "tag");
        d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L5;
        r13.d("AISetIsNeedAliveMethod", r12);
    L5:
        Integer r14 = r10.getTime();
        if (r14 == null) goto L8;
        int r15 = r14.intValue();
    L9:
        int r16 = this.defaultAliveTime;
        if (r15 <= r16) goto L12;
        r15 = r16;
    L12:
        j r17 = (j) ((a) r5).b(j.class);
        Unit r18 = null;
        if (r17 == null) goto L15;
        String r19 = r17.b();
    L17:
        if (p.a(null, null, r19) != null) goto L39;
        r11.a(r19 + " is not running");
        return;
    L39:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L23
        j r21 = (j) ((a) r5).b(j.class);     // Catch: Throwable -> L23
        if (r21 == null) goto L25;
        String r22 = r21.b();     // Catch: Throwable -> L23
    L26:
        AppletRuntime r23 = p.a(null, null, r22);     // Catch: Throwable -> L23
        if (r23 == null) goto L29;
        r23.l(r15, r10.isNeedAlive());     // Catch: Throwable -> L23
        r18 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L29:
        Object r24 = Result.m124constructorimpl(r18);     // Catch: Throwable -> L23
    L33:
        if (Result.m131isSuccessimpl(r24) == false) goto L36;
        Unit r25 = (Unit) r24;
        Intrinsics.checkNotNullParameter(AISetIsNeedAliveMethodIDL.AISetIsNeedAliveResultModal.class, "<this>");
        BaseModel r26 = e.c(AISetIsNeedAliveMethodIDL.AISetIsNeedAliveResultModal.class);
        ((AISetIsNeedAliveMethodIDL.AISetIsNeedAliveResultModal) r26).setTime(r15);
        r11.b((ResultModel) r26, "");
    L36:
        if (Result.m127exceptionOrNullimpl(r24) == null) goto L41;
        r11.a("");
        return;
    L41:
        return;
    L25:
        r22 = null;
    L23:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r24 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L33
    L15:
        r19 = null;
        goto L17
    L8:
        r15 = this.defaultAliveTime;
        goto L9
    }
}
