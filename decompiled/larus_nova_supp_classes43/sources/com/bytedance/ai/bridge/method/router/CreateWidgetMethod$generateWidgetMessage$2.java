package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.PageInfo;
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
@DebugMetadata(c = "com.bytedance.ai.bridge.method.router.CreateWidgetMethod$generateWidgetMessage$2", f = "CreateWidgetMethod.kt", i = {}, l = {159, 166}, m = "invokeSuspend", n = {}, s = {})
final class CreateWidgetMethod$generateWidgetMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppletRuntime $appletRuntime;
    final /* synthetic */ f3.h<AbsCreateWidgetMethodIDL.b> $callback;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Map<String, String> $extra;
    final /* synthetic */ PageInfo $pageInfo;
    final /* synthetic */ AbsCreateWidgetMethodIDL.a $params;
    final /* synthetic */ List<String> $suggests;
    final /* synthetic */ List<String> $suggestsV2;
    int label;
    final /* synthetic */ CreateWidgetMethod this$0;

    public CreateWidgetMethod$generateWidgetMessage$2(AbsCreateWidgetMethodIDL.a r1, f3.h<AbsCreateWidgetMethodIDL.b> r10, CreateWidgetMethod r11, AppletRuntime r12, PageInfo r13, String r14, List<String> r15, Map<String, String> r16, List<String> r17, Continuation<? super CreateWidgetMethod$generateWidgetMessage$2> r18) {
        this.$params = r1;
        this.$callback = r10;
        this.this$0 = r11;
        this.$appletRuntime = r12;
        this.$pageInfo = r13;
        this.$conversationId = r14;
        this.$suggests = r15;
        this.$extra = r16;
        this.$suggestsV2 = r17;
        super(2, r18);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new CreateWidgetMethod$generateWidgetMessage$2(this.$params, this.$callback, this.this$0, this.$appletRuntime, this.$pageInfo, this.$conversationId, this.$suggests, this.$extra, this.$suggestsV2, r13);
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
        String r10 = "";
        boolean r11 = false;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L54:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L38:
        String r13 = (String) r12;
        if (r13 == null) goto L43;
        r10 = r13;
    L43:
        if (r10.length() != 0) goto L45;
        r11 = true;
    L45:
        if (r11 == false) goto L48;
        com.bytedance.ai.utils.g.a.e("CreateWidgetMethod", "CreateWidget error, questionId is empty");
        f3.h.a.a(this.$callback, "CreateWidget error, questionId is empty", null, null, 14);
        return Unit.INSTANCE;
    L48:
        String r14 = r10;
    L50:
        CreateWidgetMethod r15 = this.this$0;
        AppletRuntime r16 = this.$appletRuntime;
        PageInfo r17 = this.$pageInfo;
        String r18 = this.$conversationId;
        List<String> r19 = this.$suggests;
        Map<String, String> r20 = this.$extra;
        List<String> r21 = this.$suggestsV2;
        f3.h<AbsCreateWidgetMethodIDL.b> r22 = this.$callback;
        this.label = 2;
        if (CreateWidgetMethod.b(r15, r16, r14, r17, r18, r19, r20, r21, r22, this) != r0) goto L54;
        return r0;
    L10:
        ResultKt.throwOnFailure(r12);
        JsonElement r110 = this.$params.getContext().get("questionId");
        if (r110 == null) goto L13;
        String r111 = r110.getAsString();
    L14:
        if (r111 != null) goto L16;
    L19:
        boolean r23 = true;
    L20:
        if (r23 == false) goto L49;
        JsonElement r112 = this.$params.getContext().get("msgId");
        if (r112 == null) goto L25;
        String r113 = r112.getAsString();
        if (r113 == null) goto L25;
    L27:
        if (r113.length() != 0) goto L29;
        boolean r24 = true;
    L30:
        if (r24 == false) goto L33;
        com.bytedance.ai.utils.g.a.e("CreateWidgetMethod", "CreateWidget error, msgId is empty");
        f3.h.a.a(this.$callback, "CreateWidget error, msgId is empty", null, null, 14);
        return Unit.INSTANCE;
    L33:
        r4.h r25 = r4.a.l;
        if (r25 == null) goto L43;
        this.label = 1;
        r12 = r25.e(r113, this);
        if (r12 != r0) goto L38;
        return r0;
    L29:
        r24 = false;
    L25:
        r113 = "";
        goto L27
    L49:
        r14 = r111;
        goto L50
    L16:
        if (r111.length() == 0) goto L19;
        r23 = false;
        goto L20
    L13:
        r111 = null;
        goto L14
    }
}
