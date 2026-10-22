package com.bytedance.ai.bridge.method.message;

import com.bytedance.ai.applet.db.WidgetContextHelper;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.message.AbsDispatchActionDirectiveMethodIDL;
import com.bytedance.ai.utils.g;
import com.google.gson.annotations.SerializedName;
import d3.a0;
import f3.h;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/message/DispatchActionDirectiveMethod;", "Lcom/bytedance/ai/bridge/message/AbsDispatchActionDirectiveMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/message/AbsDispatchActionDirectiveMethodIDL$ActionDirectiveModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/message/AbsDispatchActionDirectiveMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DispatchActionDirectiveMethod extends AbsDispatchActionDirectiveMethodIDL {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.message.DispatchActionDirectiveMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.message.DispatchActionDirectiveMethod$handle$1", f = "DispatchActionDirectiveMethod.kt", i = {0}, l = {28}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ h<AbsDispatchActionDirectiveMethodIDL.b> $callback;
        final /* synthetic */ AbsDispatchActionDirectiveMethodIDL.a $params;
        final /* synthetic */ String $xmlString;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(AbsDispatchActionDirectiveMethodIDL.a r1, h<AbsDispatchActionDirectiveMethodIDL.b> r10, String r11, Continuation<? super AnonymousClass1> r12) {
            this.$params = r1;
            this.$callback = r10;
            this.$xmlString = r11;
            super(2, r12);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$params, this.$callback, this.$xmlString, r11);
            r0.L$0 = r10;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r11 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            CoroutineScope r12 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r10);
        L11:
            String r13 = (String) r10;
            if (r13 == null) goto L18;
            if (r13.length() == 0) goto L18;
            r11 = false;
        L18:
            if (r11 == false) goto L21;
            g r14 = g.a;
            StringBuilder r15 = new StringBuilder("call failed, errNo=");
            f3.a r16 = f3.a.q;
            r15.append(r16.a);
            r15.append(", msg=conversationId is null");
            r14.e("AISDK_JSB_DispatchActionDirectiveMethod", r15.toString());
            h.a.a(this.$callback, "conversationId is null", r16, null, 10);
            return Unit.INSTANCE;
        L21:
            r4.h r17 = r4.a.l;
            if (r17 == null) goto L24;
            String r18 = this.$xmlString;
            h<AbsDispatchActionDirectiveMethodIDL.b> r19 = this.$callback;
            r17.l(r13, r18);
            g.a.i("AISDK_JSB_DispatchActionDirectiveMethod", "call success");
            Intrinsics.checkNotNullParameter(AbsDispatchActionDirectiveMethodIDL.b.class, "<this>");
            h.a.b(r19, (ResultModel) k3.c.a(AbsDispatchActionDirectiveMethodIDL.b.class));
        L26:
            return Unit.INSTANCE;
        L24:
            h<AbsDispatchActionDirectiveMethodIDL.b> r20 = this.$callback;
            g r21 = g.a;
            StringBuilder r22 = new StringBuilder("call failed, errNo=");
            f3.a r23 = f3.a.g;
            r22.append(r23.a);
            r22.append(", msg=hostMessageDepend is null");
            r21.e("AISDK_JSB_DispatchActionDirectiveMethod", r22.toString());
            h.a.a(r20, "hostMessageDepend is null", r23, null, 10);
            goto L26
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            CoroutineScope r24 = (CoroutineScope) this.L$0;
            WidgetContextHelper r25 = WidgetContextHelper.a;
            String r26 = this.$params.getWidgetInstanceId();
            this.L$0 = r24;
            this.label = 1;
            r10 = r25.d(r26, this);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    static {
    }

    public DispatchActionDirectiveMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r12, ParamModel r13, h r14) {
        AbsDispatchActionDirectiveMethodIDL.a r15 = (AbsDispatchActionDirectiveMethodIDL.a) r13;
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        XmlPullParserFactory r0 = com.bytedance.ai.bridge.method.message.a.a;
        StringWriter r1 = new StringWriter();
        XmlSerializer r10 = com.bytedance.ai.bridge.method.message.a.a.newSerializer();
        r10.setOutput(r1);
        r10.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        r10.startDocument("UTF-8", null);
        r10.startTag(null, "user_action");
        AbsDispatchActionDirectiveMethodIDL.ActionType r11 = r15.getActionType();
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L9
        SerializedName r17 = r11.getClass().getField(r11.name()).getAnnotation(SerializedName.class);     // Catch: Throwable -> L9
        if (r17 == null) goto L6;
        String r18 = r17.value();     // Catch: Throwable -> L9
    L7:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r19) == false) goto L14;
        r19 = null;
    L14:
        String r20 = (String) r19;
        if (r20 != null) goto L17;
        r20 = r11.name().toLowerCase(Locale.ROOT);
    L17:
        com.bytedance.ai.bridge.method.message.a.a(r10, com.bytedance.android.ec.core.event.a.KEY_ACTION_TYPE, r20);
        com.bytedance.ai.bridge.method.message.a.a(r10, "action_describe", r15.getActionDescribe());
        r10.endTag(null, "user_action");
        r10.startTag(null, "expected_execution");
        com.bytedance.ai.bridge.method.message.a.a(r10, "expected_action", r15.getExpectedAction());
        com.bytedance.ai.bridge.method.message.a.a(r10, "tool_name", r15.getToolName());
        r10.startTag(null, "tool_params");
        Map<String, String> r21 = r15.getToolParams();
        if (r21 == null) goto L28;
        Iterator<Map.Entry<String, String>> r22 = r21.entrySet().iterator();
    L21:
        if (r22.hasNext() == false) goto L28;
        Map.Entry<String, String> r23 = r22.next();
        String r24 = r23.getKey();
        String r25 = r23.getValue();
        if (r24.length() != 0) goto L25;
        boolean r26 = true;
    L26:
        if (r26 == true) goto L21;
        com.bytedance.ai.bridge.method.message.a.a(r10, r24, r25);
        goto L21
    L25:
        r26 = false;
    L28:
        r10.endTag(null, "tool_params");
        r10.endTag(null, "expected_execution");
        com.bytedance.ai.bridge.method.message.a.a(r10, "response_hint", r15.getResponseHint());
        r10.endDocument();
        String r27 = StringsKt.trimStart(StringsKt.substringAfter$default(r1.toString(), "?>", null, 2, null)).toString();
        g r28 = g.a;
        StringBuilder r29 = new StringBuilder("call start, actionType=");
        r29.append(r15.getActionType());
        r29.append(", widgetInstanceId=");
        r29.append(r15.getWidgetInstanceId());
        r29.append(", appletId=");
        a0 r110 = r12.getContainerContext();
        if (r110 == null) goto L31;
        String r111 = r110.getAppletId();
    L32:
        r29.append(r111);
        r28.i("AISDK_JSB_DispatchActionDirectiveMethod", r29.toString());
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r15, r14, r27, null), 3, null);
        return;
    L31:
        r111 = null;
        goto L32
    L6:
        r18 = null;
    L9:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
