package com.larus.uaigc.createpage.component.instruction;

import com.larus.uaigc.createpage.CreationHalfChatFragment;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$observerInstructionEditor$9", f = "CreationEditorComponent.kt", i = {}, l = {2941}, m = "invokeSuspend", n = {}, s = {})
final class CreationEditorComponent$observerInstructionEditor$9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationEditorComponent a;

        public a(CreationEditorComponent r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.uaigc.createpage.component.instruction.p, java.lang.Runnable] */
        public final Object emit(Object r4, Continuation r5) {
            boolean r6 = ((Boolean) r4).booleanValue();
            FLogger.a.d("CreationEditorComponent", "instructionFeatureDialogDismiss = " + r6);
            final CreationEditorComponent r7 = this.a;
            int r8 = CreationEditorComponent.g2;
            r7.getClass();
            Intrinsics.checkNotNullParameter(r7, "<this>");
            CreationHalfChatFragment r9 = com.larus.ui.arch.component.internal.attach.a.b(r7, r7);
            if ((r9 instanceof CreationHalfChatFragment) == false) goto L5;
            final CreationHalfChatFragment r10 = r9;
        L7:
            if (r10 != null) goto L9;
            r7.F2().postDelayed(new e(r7), 200);
        L14:
            return Unit.INSTANCE;
        L9:
            r7.C3();
            if (r10.n == true) goto L14;
            ?? r2 = new p(r7, r10);
            r7.h1 = r2;
            r7.F2().postDelayed(r2, 200);
            goto L14
        L5:
            r10 = null;
            goto L7
        }
    }

    public CreationEditorComponent$observerInstructionEditor$9(CreationEditorComponent r1, Continuation<? super CreationEditorComponent$observerInstructionEditor$9> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationEditorComponent$observerInstructionEditor$9(this.this$0, r3);
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
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CreationEditorComponent r6 = this.this$0;
        int r2 = CreationEditorComponent.g2;
        kotlinx.coroutines.flow.d1 r7 = r6.i4().getInstructionFeatureDialogDismiss();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
