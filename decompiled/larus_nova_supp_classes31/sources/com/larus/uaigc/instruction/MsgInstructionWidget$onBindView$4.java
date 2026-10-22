package com.larus.uaigc.instruction;

import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.instruction.MsgInstructionWidget$onBindView$4", f = "MsgInstructionWidget.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
final class MsgInstructionWidget$onBindView$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MsgInstructionWidget this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MsgInstructionWidget a;

        public a(MsgInstructionWidget r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            ArrayList r3 = (ArrayList) r1;
            u r4 = MsgInstructionWidget.k6(this.a);
            if (r4 == null) goto L5;
            int r5 = r4.m;
        L7:
            if (r3.contains(Boxing.boxInt(r5)) == true) goto L9;
            e1.x(this.a);
        L11:
            return Unit.INSTANCE;
        L9:
            e1.o(this.a);
            goto L11
        L5:
            r5 = 0;
            goto L7
        }
    }

    public MsgInstructionWidget$onBindView$4(MsgInstructionWidget r1, Continuation<? super MsgInstructionWidget$onBindView$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MsgInstructionWidget$onBindView$4(this.this$0, r3);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MsgInstructionWidget r6 = this.this$0;
        int r2 = MsgInstructionWidget.g;
        com.larus.bmhome.view.actionbar.edit.c r7 = r6.getViewModel();
        if (r7 == null) goto L18;
        i1 r8 = r7.getHideInstructionFlow();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
