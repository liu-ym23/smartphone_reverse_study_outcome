package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.api.model.output.AIOutputContentType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.AppletRuntime;
import d3.z;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J|\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00182\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002Jz\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001d2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001d2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0082@¢\u0006\u0002\u0010\u001e¨\u0006 "}, d2 = {"Lcom/bytedance/ai/bridge/method/router/CreateTextMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsCreateTextMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/router/AbsCreateTextMethodIDL$CreateTextParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/router/AbsCreateTextMethodIDL$CreateTextResultModel;", "generateTextMessage", "runningInWorker", "content", "", "appletRuntime", "Lcom/bytedance/ai/model/AppletRuntime;", "botId", "conversationId", "suggests", "", "extra", "", "suggestsV2", "questionId", "", "(Lcom/bytedance/ai/model/AppletRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Lcom/bytedance/ai/bridge/core/CompletionBlock;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateTextMethod extends AbsCreateTextMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public CreateTextMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(final e3.d r10, ParamModel r11, final f3.h r12) {
        final AbsCreateTextMethodIDL.a r13 = (AbsCreateTextMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        z r0 = (z) r10.d(z.class);
        if (r0 != null) goto L5;
        com.bytedance.ai.utils.g.a.e("CreateTextMethod", "appletRuntimeProvider is null");
        f3.h.a.a(r12, "appletRuntimeProvider is null", null, null, 14);
        return;
    L5:
        r0.a(new com.bytedance.ai.bridge.method.router.a(r12, r13, r10, this));
    }

    public static final Object b(CreateTextMethod r17, AppletRuntime r18, String r19, String r20, List r21, String r22, String r23, Map r24, List r25, f3.h r26, Continuation r27) {
        r17.getClass();
        if ((r27 instanceof CreateTextMethod$generateTextMessage$3) == false) goto L7;
        CreateTextMethod$generateTextMessage$3 r1 = (CreateTextMethod$generateTextMessage$3) r27;
        int r10 = r1.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r1.label;
        if (r12 == 0) goto L14;
        if (r12 != 1) goto L13;
        f3.h r13 = (f3.h) r1.L$3;
        String r14 = (String) r1.L$2;
        String r15 = (String) r1.L$1;
        String r16 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        Object r28 = r0;
        String r29 = r16;
    L21:
        Boolean r30 = (Boolean) r28;
        com.bytedance.ai.utils.g.a.d("CreateTextMethod", "generateTextMessage result " + r30);
        if (Intrinsics.areEqual(r30, Boxing.boxBoolean(true)) == false) goto L25;
        Intrinsics.checkNotNullParameter(AbsCreateTextMethodIDL.b.class, "<this>");
        f3.h.a.b(r13, (ResultModel) k3.c.a(AbsCreateTextMethodIDL.b.class));
    L29:
        return Unit.INSTANCE;
    L25:
        if (r30 != null) goto L27;
        f3.h.a.a(r13, "SaveBotReplyRequest timeout, questionId: " + r29 + ", botId: " + r15 + ", convId: " + r14 + ", timeoutInterval: 10000", null, null, 14);
        goto L29
    L27:
        f3.h.a.a(r13, "SaveBotReplyRequest API failed, questionId: " + r29 + ", botId: " + r15 + ", convId: " + r14 + ", error: Http Error", null, null, 14);
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        r29 = r19;
        r1.L$0 = r29;
        r1.L$1 = r22;
        r1.L$2 = r23;
        r1.L$3 = r26;
        r1.label = 1;
        r18.getClass();
        r4.h r110 = r4.a.l;
        if (r110 == null) goto L17;
        r28 = r110.h(new j2.b(AIOutputContentType.TEXT, r20, r24, r22, r19, r23, true, r21, r25), r1);
    L18:
        if (r28 == r11) goto L30;
        r13 = r26;
        r15 = r22;
        r14 = r23;
        goto L21
    L30:
        return r11;
    L17:
        r28 = null;
    L7:
        r1 = new CreateTextMethod$generateTextMessage$3(r17, r27);
        goto L8
    }
}
