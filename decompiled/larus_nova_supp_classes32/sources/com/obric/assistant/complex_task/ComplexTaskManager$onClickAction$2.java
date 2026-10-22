package com.obric.assistant.complex_task;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.complex_task.ComplexTaskManager$onClickAction$2", f = "ComplexTaskManager.kt", i = {}, l = {587}, m = "invokeSuspend", n = {}, s = {})
final class ComplexTaskManager$onClickAction$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ laa.c $chatListAbility;
    final /* synthetic */ String $messageId;
    final /* synthetic */ DMTaskState $newState;
    int label;

    public ComplexTaskManager$onClickAction$2(String r1, laa.c r2, DMTaskState r3, Continuation<? super ComplexTaskManager$onClickAction$2> r4) {
        this.$messageId = r1;
        this.$chatListAbility = r2;
        this.$newState = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ComplexTaskManager$onClickAction$2(this.$messageId, this.$chatListAbility, this.$newState, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = false;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L22:
        if (((Boolean) r5).booleanValue() != true) goto L24;
    L23:
        r2 = true;
    L24:
        FLogger.a.i("ComplexTaskManager", "onClickAction, messageId = " + this.$messageId + ", canShow = " + r2);
        if (r2 == false) goto L27;
        t r6 = ComplexTaskManager.a;
        ComplexTaskManager.e(this.$newState);
    L29:
        return Unit.INSTANCE;
    L27:
        final DMTaskState r7 = this.$newState;
        com.obric.assistant.spi.keyguard.a.a(new m(r7), new n(), null, true, 20);
        goto L29
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        String r8 = this.$messageId;
        if (r8 != null) goto L11;
    L14:
        boolean r9 = true;
    L15:
        if (r9 == true) goto L23;
        laa.c r10 = this.$chatListAbility;
        if (r10 == null) goto L24;
        String r3 = this.$messageId;
        this.label = 1;
        r5 = r10.Dp(r3, this);
        if (r5 != r0) goto L22;
        return r0;
    L11:
        if (r8.length() == 0) goto L14;
        r9 = false;
        goto L15
    }
}
