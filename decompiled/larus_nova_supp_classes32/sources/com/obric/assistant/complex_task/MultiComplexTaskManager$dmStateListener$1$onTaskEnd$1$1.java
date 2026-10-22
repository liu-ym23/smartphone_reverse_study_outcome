package com.obric.assistant.complex_task;

import com.larus.multitask_management.api.CancelFrom;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import java.util.Map;
import kl9.u;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.complex_task.MultiComplexTaskManager$dmStateListener$1$onTaskEnd$1$1", f = "MultiComplexTaskManager.kt", i = {}, l = {79, 83}, m = "invokeSuspend", n = {}, s = {})
public final class MultiComplexTaskManager$dmStateListener$1$onTaskEnd$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $endedOmniTaskId;
    final /* synthetic */ String $targetTaskId;
    int label;

    public MultiComplexTaskManager$dmStateListener$1$onTaskEnd$1$1(String r1, String r2, Continuation<? super MultiComplexTaskManager$dmStateListener$1$onTaskEnd$1$1> r3) {
        this.$endedOmniTaskId = r1;
        this.$targetTaskId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MultiComplexTaskManager$dmStateListener$1$onTaskEnd$1$1(this.$endedOmniTaskId, this.$targetTaskId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L28:
        Boolean r8 = (Boolean) r7;
    L30:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        pd6.b r9 = pd6.c.a;
        il9.a r10 = pd6.c.a(Reflection.getOrCreateKotlinClass(il9.a.class));
        if (r10 == null) goto L20;
        u r11 = r10.J0(this.$targetTaskId);
        if (r11 == null) goto L20;
        Map r12 = r11.s;
        if (r12 == null) goto L20;
        String r13 = (String) r12.get("biz_scene");
    L21:
        FLogger r2 = FLogger.a;
        Map r4 = MultiComplexTaskManager.a;
        r2.i("MultiComplexTaskManager", "onTaskEnd, remove omni task:" + this.$endedOmniTaskId + " with " + r13);
        if (MultiComplexTaskManager.a(r13) == true) goto L30;
        il9.a r14 = pd6.c.a(Reflection.getOrCreateKotlinClass(il9.a.class));
        if (r14 == null) goto L30;
        String r3 = this.$targetTaskId;
        CancelFrom r5 = CancelFrom.MANUAL;
        this.label = 2;
        r7 = r14.a1(r3, r5, this);
        if (r7 != r0) goto L28;
        return r0;
    L20:
        r13 = null;
        goto L21
    L10:
        ResultKt.throwOnFailure(r7);
        FLogger r15 = FLogger.a;
        Map r6 = MultiComplexTaskManager.a;
        r15.i("MultiComplexTaskManager", "onTaskEnd, ready to remove omni task:" + this.$endedOmniTaskId);
        this.label = 1;
        if (DelayKt.delay(AutoEndConversationTime.AFTER_10_SECONDS, this) != r0) goto L13;
        return r0;
    }
}
