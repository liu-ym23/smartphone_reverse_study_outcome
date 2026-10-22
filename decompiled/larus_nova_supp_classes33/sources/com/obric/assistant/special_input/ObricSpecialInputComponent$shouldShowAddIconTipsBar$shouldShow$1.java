package com.obric.assistant.special_input;

import com.obric.aiagent.assistant.idl.IAgentTaskAppIDL;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.ObricSpecialInputComponent$shouldShowAddIconTipsBar$shouldShow$1", f = "ObricSpecialInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricSpecialInputComponent$shouldShowAddIconTipsBar$shouldShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public ObricSpecialInputComponent$shouldShowAddIconTipsBar$shouldShow$1(Continuation<? super ObricSpecialInputComponent$shouldShowAddIconTipsBar$shouldShow$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        ObricSpecialInputComponent$shouldShowAddIconTipsBar$shouldShow$1 r0 = new ObricSpecialInputComponent$shouldShowAddIconTipsBar$shouldShow$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r3);
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        IAgentTaskAppIDL r1 = com.obric.aiagent.assistant.idl.s.a(Reflection.getOrCreateKotlinClass(IAgentTaskAppIDL.class));     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        boolean r2 = r1.shouldShowAddTaskManagerIconGuide();     // Catch: Throwable -> L11
    L9:
        Object r5 = Result.constructor-impl(Boxing.boxBoolean(r2));     // Catch: Throwable -> L11
    L13:
        Boolean r6 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r5) == true) goto L16;
        return r5;
    L16:
        return r6;
    L8:
        r2 = false;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
