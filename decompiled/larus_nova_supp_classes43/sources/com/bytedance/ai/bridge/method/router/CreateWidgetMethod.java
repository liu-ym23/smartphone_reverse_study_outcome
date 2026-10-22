package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.api.model.output.AIOutputContentType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.model.objects.WidgetInfo;
import d3.z;
import java.util.ArrayList;
import java.util.Iterator;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016Jt\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002Jr\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00172\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0082@¢\u0006\u0002\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/CreateWidgetMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsCreateWidgetMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/router/AbsCreateWidgetMethodIDL$CreateWidgetParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/router/AbsCreateWidgetMethodIDL$CreateWidgetResultModel;", "generateWidgetMessage", "appletRuntime", "Lcom/bytedance/ai/model/AppletRuntime;", "pageInfo", "Lcom/bytedance/ai/model/objects/PageInfo;", "conversationId", "", "suggests", "", "extra", "", "suggestsV2", "runningInWorker", "questionId", "(Lcom/bytedance/ai/model/AppletRuntime;Ljava/lang/String;Lcom/bytedance/ai/model/objects/PageInfo;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Lcom/bytedance/ai/bridge/core/CompletionBlock;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateWidgetMethod extends AbsCreateWidgetMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public CreateWidgetMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(final e3.d r10, ParamModel r11, final f3.h r12) {
        final AbsCreateWidgetMethodIDL.a r13 = (AbsCreateWidgetMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        z r0 = (z) r10.d(z.class);
        if (r0 != null) goto L5;
        com.bytedance.ai.utils.g.a.e("CreateWidgetMethod", "appletRuntimeProvider is null");
        f3.h.a.a(r12, "appletRuntimeProvider is null", null, null, 14);
        return;
    L5:
        r0.a(new c(r12, r13, r10, this));
    }

    public static final Object b(CreateWidgetMethod r34, AppletRuntime r35, String r36, PageInfo r37, String r38, List r39, Map r40, List r41, f3.h r42, Continuation r43) {
        r34.getClass();
        if ((r43 instanceof CreateWidgetMethod$generateWidgetMessage$3) == false) goto L7;
        CreateWidgetMethod$generateWidgetMessage$3 r10 = (CreateWidgetMethod$generateWidgetMessage$3) r43;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r1 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r10.label;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        f3.h r0 = (f3.h) r10.L$3;
        String r14 = (String) r10.L$2;
        PageInfo r15 = (PageInfo) r10.L$1;
        String r16 = (String) r10.L$0;
        ResultKt.throwOnFailure(r1);
        Object r17 = r1;
        String r18 = r16;
    L42:
        Boolean r19 = (Boolean) r17;
        com.bytedance.ai.utils.g.a.d("CreateWidgetMethod", "generateWidgetMessage result " + r19);
        if (Intrinsics.areEqual(r19, Boxing.boxBoolean(true)) == false) goto L46;
        Intrinsics.checkNotNullParameter(AbsCreateWidgetMethodIDL.b.class, "<this>");
        f3.h.a.b(r0, (ResultModel) k3.c.a(AbsCreateWidgetMethodIDL.b.class));
    L50:
        return Unit.INSTANCE;
    L46:
        if (r19 != null) goto L48;
        f3.h.a.a(r0, "SaveBotReplyRequest timeout, questionId: " + r18 + ", botId: " + r15.getBotId() + ", convId: " + r14 + ", timeoutInterval: 10000", null, null, 14);
        goto L50
    L48:
        f3.h.a.a(r0, "SaveBotReplyRequest API failed, questionId: " + r18 + ", botId: " + r15.getBotId() + ", convId: " + r14 + ", error: Http Error", null, null, 14);
        goto L50
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        r18 = r36;
        r10.L$0 = r18;
        r15 = r37;
        r10.L$1 = r15;
        r10.L$2 = r38;
        r10.L$3 = r42;
        r10.label = 1;
        ArrayList<Widget> r20 = r35.h.S;
        if (r20 == null) goto L28;
        Iterator<T> r21 = r20.iterator();
    L18:
        if (r21.hasNext() == false) goto L26;
        Object r22 = r21.next();
        Widget r23 = (Widget) r22;
        if (com.bytedance.ai.utils.f.g(r23.K) == false) goto L22;
        String r24 = r23.K;
    L24:
        if (Intrinsics.areEqual(r24, r37.getPageId()) == false) goto L18;
    L27:
        Widget r25 = (Widget) r22;
    L29:
        if (r25 == null) goto L31;
        int r26 = r25.P;
    L32:
        if (r25 == null) goto L34;
        Boolean r27 = Boxing.boxBoolean(r25.O);
    L35:
        r4.h r110 = r4.a.l;
        if (r110 == null) goto L38;
        Object r28 = r110.h(new j2.b(AIOutputContentType.WIDGET, new WidgetInfo(r35.h.o(), r37.getPageId(), r37.getPageData(), Boxing.boxInt(r26), r27, null, null, null, null, null, null, null, null, null, 16352, null), r40, r37.getBotId(), r36, r38, true, r39, r41), r10);
    L39:
        if (r28 == r12) goto L54;
        r14 = r38;
        r17 = r28;
        r0 = r42;
        goto L42
    L54:
        return r12;
    L38:
        r28 = null;
        goto L39
    L34:
        r27 = null;
        goto L35
    L31:
        r26 = 0;
        goto L32
    L22:
        r24 = r23.a;
        goto L24
    L26:
        r22 = null;
        goto L27
    L28:
        r25 = null;
    L7:
        r10 = new CreateWidgetMethod$generateWidgetMessage$3(r34, r43);
        goto L8
    }
}
