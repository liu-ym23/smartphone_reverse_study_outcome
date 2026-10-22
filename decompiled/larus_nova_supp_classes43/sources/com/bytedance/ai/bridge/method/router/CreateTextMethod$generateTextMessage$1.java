package com.bytedance.ai.bridge.method.router;

import com.byted.cast.sink.api.CastInfo;
import com.bytedance.ai.model.AppletRuntime;
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
@DebugMetadata(c = "com.bytedance.ai.bridge.method.router.CreateTextMethod$generateTextMessage$1", f = "CreateTextMethod.kt", i = {}, l = {CastInfo.TYPE_INFO}, m = "invokeSuspend", n = {}, s = {})
final class CreateTextMethod$generateTextMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppletRuntime $appletRuntime;
    final /* synthetic */ String $botId;
    final /* synthetic */ f3.h<AbsCreateTextMethodIDL.b> $callback;
    final /* synthetic */ String $content;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Map<String, String> $extra;
    final /* synthetic */ String $questionId;
    final /* synthetic */ List<String> $suggests;
    final /* synthetic */ List<String> $suggestsV2;
    int label;
    final /* synthetic */ CreateTextMethod this$0;

    public CreateTextMethod$generateTextMessage$1(CreateTextMethod r1, AppletRuntime r10, String r11, String r12, List<String> r13, String r14, String r15, Map<String, String> r16, List<String> r17, f3.h<AbsCreateTextMethodIDL.b> r18, Continuation<? super CreateTextMethod$generateTextMessage$1> r19) {
        this.this$0 = r1;
        this.$appletRuntime = r10;
        this.$questionId = r11;
        this.$content = r12;
        this.$suggests = r13;
        this.$botId = r14;
        this.$conversationId = r15;
        this.$extra = r16;
        this.$suggestsV2 = r17;
        this.$callback = r18;
        super(2, r19);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new CreateTextMethod$generateTextMessage$1(this.this$0, this.$appletRuntime, this.$questionId, this.$content, this.$suggests, this.$botId, this.$conversationId, this.$extra, this.$suggestsV2, this.$callback, r14);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        CreateTextMethod r10 = this.this$0;
        AppletRuntime r14 = this.$appletRuntime;
        String r11 = this.$questionId;
        String r12 = this.$content;
        List<String> r15 = this.$suggests;
        String r16 = this.$botId;
        String r17 = this.$conversationId;
        Map<String, String> r18 = this.$extra;
        List<String> r19 = this.$suggestsV2;
        f3.h<AbsCreateTextMethodIDL.b> r110 = this.$callback;
        this.label = 1;
        if (CreateTextMethod.b(r10, r14, r11, r12, r15, r16, r17, r18, r19, r110, this) != r0) goto L12;
        return r0;
    }
}
