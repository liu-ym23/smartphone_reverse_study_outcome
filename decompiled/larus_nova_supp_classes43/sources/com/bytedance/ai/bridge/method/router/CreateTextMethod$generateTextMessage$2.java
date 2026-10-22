package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.model.AppletRuntime;
import com.google.gson.JsonElement;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.router.CreateTextMethod$generateTextMessage$2", f = "CreateTextMethod.kt", i = {}, l = {135, 142}, m = "invokeSuspend", n = {}, s = {})
final class CreateTextMethod$generateTextMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppletRuntime $appletRuntime;
    final /* synthetic */ String $botId;
    final /* synthetic */ f3.h<AbsCreateTextMethodIDL.b> $callback;
    final /* synthetic */ String $content;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Map<String, String> $extra;
    final /* synthetic */ AbsCreateTextMethodIDL.a $params;
    final /* synthetic */ List<String> $suggests;
    final /* synthetic */ List<String> $suggestsV2;
    int label;
    final /* synthetic */ CreateTextMethod this$0;

    public CreateTextMethod$generateTextMessage$2(AbsCreateTextMethodIDL.a r1, f3.h<AbsCreateTextMethodIDL.b> r10, CreateTextMethod r11, AppletRuntime r12, String r13, List<String> r14, String r15, String r16, Map<String, String> r17, List<String> r18, Continuation<? super CreateTextMethod$generateTextMessage$2> r19) {
        this.$params = r1;
        this.$callback = r10;
        this.this$0 = r11;
        this.$appletRuntime = r12;
        this.$content = r13;
        this.$suggests = r14;
        this.$botId = r15;
        this.$conversationId = r16;
        this.$extra = r17;
        this.$suggestsV2 = r18;
        super(2, r19);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new CreateTextMethod$generateTextMessage$2(this.$params, this.$callback, this.this$0, this.$appletRuntime, this.$content, this.$suggests, this.$botId, this.$conversationId, this.$extra, this.$suggestsV2, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r10 = false;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r13);
    L52:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
    L39:
        String r14 = (String) r13;
    L41:
        if (r14 != null) goto L43;
    L44:
        r10 = true;
    L45:
        if (r10 == false) goto L48;
        com.bytedance.ai.utils.g.a.e("CreateTextMethod", "CreateText error, questionId is empty.");
        f3.h.a.a(this.$callback, "CreateText error, questionId is empty.", null, null, 14);
        return Unit.INSTANCE;
    L48:
        String r11 = r14;
        CreateTextMethod r12 = this.this$0;
        AppletRuntime r15 = this.$appletRuntime;
        String r16 = this.$content;
        List<String> r17 = this.$suggests;
        String r18 = this.$botId;
        String r19 = this.$conversationId;
        Map<String, String> r20 = this.$extra;
        List<String> r21 = this.$suggestsV2;
        f3.h<AbsCreateTextMethodIDL.b> r110 = this.$callback;
        this.label = 2;
        if (CreateTextMethod.b(r12, r15, r11, r16, r17, r18, r19, r20, r21, r110, this) != r0) goto L52;
        return r0;
    L43:
        if (r14.length() != 0) goto L45;
    L10:
        ResultKt.throwOnFailure(r13);
        JsonElement r111 = this.$params.getContext().get("questionId");
        if (r111 == null) goto L13;
        r14 = r111.getAsString();
    L14:
        if (r14 != null) goto L16;
    L19:
        boolean r22 = true;
    L20:
        if (r22 == false) goto L48;
        JsonElement r112 = this.$params.getContext().get("msgId");
        if (r112 == null) goto L24;
        String r113 = r112.getAsString();
    L25:
        if (r113 != null) goto L27;
    L30:
        boolean r23 = true;
    L31:
        if (r23 == false) goto L34;
        com.bytedance.ai.utils.g.a.e("CreateTextMethod", "CreateText error, msgId is empty.");
        f3.h.a.a(this.$callback, "CreateText error, msgId is empty.", null, null, 14);
        return Unit.INSTANCE;
    L34:
        r4.h r24 = r4.a.l;
        if (r24 == null) goto L40;
        this.label = 1;
        r13 = r24.e(r113, this);
        if (r13 != r0) goto L39;
        return r0;
    L40:
        r14 = null;
        goto L41
    L27:
        if (r113.length() == 0) goto L30;
        r23 = false;
        goto L31
    L24:
        r113 = null;
        goto L25
    L16:
        if (r14.length() == 0) goto L19;
        r22 = false;
        goto L20
    L13:
        r14 = null;
        goto L14
    }
}
