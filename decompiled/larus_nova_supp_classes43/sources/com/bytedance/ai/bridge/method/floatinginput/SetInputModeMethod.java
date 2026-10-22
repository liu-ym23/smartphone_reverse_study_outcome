package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.objects.PageType;
import d3.a0;
import f3.h;
import k2.j;
import k2.t;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/SetInputModeMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetInputModeMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetInputModeMethodIDL$SetInputModeParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetInputModeMethodIDL$SetInputModeResultModal;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetInputModeMethod extends AbsSetInputModeMethodIDL {
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public SetInputModeMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, h r12) {
        AbsSetInputModeMethodIDL.a r13 = (AbsSetInputModeMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r0 = r10.getContainerContext();
        if (r0 == null) goto L5;
        ContainerType r1 = r0.getContainerType();
    L7:
        if (r1 != ContainerType.PAGE) goto L31;
        j r14 = (j) r10.d(j.class);
        if (r14 != null) goto L12;
        h.a.a(r12, "aicontainer is null", null, null, 14);
        return;
    L12:
        if (r14.getPageInfo().getPageType() != PageType.FULL_PAGE) goto L14;
    L37:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L19
        InputMode.a r16 = InputMode.Companion;     // Catch: Throwable -> L19
        String r17 = r13.getMode();     // Catch: Throwable -> L19
        r16.getClass();     // Catch: Throwable -> L19
        Object r18 = Result.constructor-impl(InputMode.a.a(r17));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r18) == false) goto L24;
        r18 = null;
    L24:
        InputMode r19 = (InputMode) r18;
        if (r19 == null) goto L30;
        t r20 = r14.getFloatingSpeakerController();
        if (r20 == null) goto L29;
        r20.o(r19);
        Intrinsics.checkNotNullParameter(AbsSetInputModeMethodIDL.b.class, "<this>");
        r12.b((ResultModel) k3.c.a(AbsSetInputModeMethodIDL.b.class), "");
        return;
    L29:
        h.a.a(r12, "floating speaker controller is null", null, null, 14);
        return;
    L30:
        h.a.a(r12, "unsupported input mode " + r13.getMode(), null, null, 14);
        return;
    L19:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L14:
        if (r14.getPageInfo().getPageType() == PageType.POPUP_PAGE) goto L37;
        h.a.a(r12, "unsupported page type " + r14.getPageInfo().getPageType(), null, null, 14);
        return;
    L31:
        StringBuilder r22 = new StringBuilder("unsupported container type ");
        a0 r23 = r10.getContainerContext();
        if (r23 == null) goto L34;
        ContainerType r24 = r23.getContainerType();
    L35:
        r22.append(r24);
        h.a.a(r12, r22.toString(), null, null, 14);
        return;
    L34:
        r24 = null;
        goto L35
    L5:
        r1 = null;
        goto L7
    }
}
