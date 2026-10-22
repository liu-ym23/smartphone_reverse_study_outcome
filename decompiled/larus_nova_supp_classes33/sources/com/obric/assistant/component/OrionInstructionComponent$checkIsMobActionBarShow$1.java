package com.obric.assistant.component;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.actionbar.service.ObricActionBarTrackServiceExtDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.OrionInstructionComponent$checkIsMobActionBarShow$1", f = "OrionInstructionComponent.kt", i = {}, l = {325}, m = "invokeSuspend", n = {}, s = {})
final class OrionInstructionComponent$checkIsMobActionBarShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OrionInstructionComponent this$0;

    public OrionInstructionComponent$checkIsMobActionBarShow$1(OrionInstructionComponent r1, Continuation<? super OrionInstructionComponent$checkIsMobActionBarShow$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OrionInstructionComponent$checkIsMobActionBarShow$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        OrionInstructionComponent r7 = this.this$0;
        int r2 = OrionInstructionComponent.p1;
        laa.b r8 = r7.X3();
        boolean r3 = false;
        if (r8 == null) goto L18;
        List r9 = r8.i30();
        if (r9 == null) goto L18;
        if ((!r9.isEmpty()) != true) goto L18;
        r3 = true;
    L18:
        if (r3 == false) goto L24;
        FLogger.a.i("OrionExtraComponent", "onSpeakerVisibleChanged mobChatActionBarShow");
        ObricActionBarTrackServiceExtDelegate r10 = ObricActionBarTrackServiceExtDelegate.b;
        laa.b r4 = this.this$0.X3();
        if (r4 == null) goto L22;
        List r5 = r4.i30();
    L23:
        r10.b(r5);
    L26:
        return Unit.INSTANCE;
    L22:
        r5 = null;
        goto L23
    L24:
        this.this$0.U = true;
        goto L26
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(300, this) != r0) goto L11;
        return r0;
    }
}
