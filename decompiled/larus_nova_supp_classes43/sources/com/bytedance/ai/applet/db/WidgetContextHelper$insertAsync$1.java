package com.bytedance.ai.applet.db;

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
@DebugMetadata(c = "com.bytedance.ai.applet.db.WidgetContextHelper$insertAsync$1", f = "WidgetContextHelper.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
public final class WidgetContextHelper$insertAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $cardId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $messageId;
    int label;

    public WidgetContextHelper$insertAsync$1(String r1, String r10, String r11, String r12, Continuation<? super WidgetContextHelper$insertAsync$1> r13) {
        this.$cardId = r1;
        this.$messageId = r10;
        this.$conversationId = r11;
        this.$botId = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new WidgetContextHelper$insertAsync$1(this.$cardId, this.$messageId, this.$conversationId, this.$botId, r11);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        WidgetContextHelper r11 = WidgetContextHelper.a;
        String r12 = this.$cardId;
        String r13 = this.$messageId;
        String r14 = this.$conversationId;
        String r15 = this.$botId;
        this.label = 1;
        if (r11.insert(r12, r13, r14, r15, this) != r0) goto L12;
        return r0;
    }
}
