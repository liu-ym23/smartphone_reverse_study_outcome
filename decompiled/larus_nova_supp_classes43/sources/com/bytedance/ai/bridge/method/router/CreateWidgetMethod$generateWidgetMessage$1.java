package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.PageInfo;
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
@DebugMetadata(c = "com.bytedance.ai.bridge.method.router.CreateWidgetMethod$generateWidgetMessage$1", f = "CreateWidgetMethod.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
final class CreateWidgetMethod$generateWidgetMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppletRuntime $appletRuntime;
    final /* synthetic */ f3.h<AbsCreateWidgetMethodIDL.b> $callback;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Map<String, String> $extra;
    final /* synthetic */ PageInfo $pageInfo;
    final /* synthetic */ String $questionId;
    final /* synthetic */ List<String> $suggests;
    final /* synthetic */ List<String> $suggestsV2;
    int label;
    final /* synthetic */ CreateWidgetMethod this$0;

    public CreateWidgetMethod$generateWidgetMessage$1(CreateWidgetMethod r1, AppletRuntime r10, String r11, PageInfo r12, String r13, List<String> r14, Map<String, String> r15, List<String> r16, f3.h<AbsCreateWidgetMethodIDL.b> r17, Continuation<? super CreateWidgetMethod$generateWidgetMessage$1> r18) {
        this.this$0 = r1;
        this.$appletRuntime = r10;
        this.$questionId = r11;
        this.$pageInfo = r12;
        this.$conversationId = r13;
        this.$suggests = r14;
        this.$extra = r15;
        this.$suggestsV2 = r16;
        this.$callback = r17;
        super(2, r18);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new CreateWidgetMethod$generateWidgetMessage$1(this.this$0, this.$appletRuntime, this.$questionId, this.$pageInfo, this.$conversationId, this.$suggests, this.$extra, this.$suggestsV2, this.$callback, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CreateWidgetMethod r10 = this.this$0;
        AppletRuntime r13 = this.$appletRuntime;
        String r11 = this.$questionId;
        PageInfo r14 = this.$pageInfo;
        String r15 = this.$conversationId;
        List<String> r16 = this.$suggests;
        Map<String, String> r17 = this.$extra;
        List<String> r18 = this.$suggestsV2;
        f3.h<AbsCreateWidgetMethodIDL.b> r19 = this.$callback;
        this.label = 1;
        if (CreateWidgetMethod.b(r10, r13, r11, r14, r15, r16, r17, r18, r19, this) != r0) goto L12;
        return r0;
    }
}
