package com.larus.uaigc.createpage.component.instruction;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$observerInstructionEditor$17", f = "CreationEditorComponent.kt", i = {}, l = {3206}, m = "invokeSuspend", n = {}, s = {})
final class CreationEditorComponent$observerInstructionEditor$17 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationEditorComponent a;

        public a(CreationEditorComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            boolean r6 = ((Boolean) r4).booleanValue();
            CreationEditorComponent r7 = this.a;
            int r0 = CreationEditorComponent.g2;
            r7.i4().markInputSendReadyState(r6);
            ICoreInputAbility r8 = this.a.a4();
            if (r8 == null) goto L26;
            CreationEditorComponent r1 = this.a;
            if (r6 == true) goto L7;
            if (r6 == true) goto L24;
            va8.o r9 = r1.X3();
            if (r9 == null) goto L14;
            String r10 = r9.u7();
        L15:
            if (r10 != null) goto L18;
            r10 = "";
        L18:
            if (StringsKt.isBlank(r10) == false) goto L26;
            if (r8.Rp() == 2) goto L22;
            r1.j6(1);
            goto L26
        L22:
            r1.j6(2);
            goto L26
        L14:
            r10 = null;
            goto L15
        L24:
            throw new NoWhenBranchMatchedException();
        L7:
            if (r8.Rp() != 2) goto L9;
            r1.j6(2);
            goto L26
        L9:
            r1.j6(3);
        L26:
            return Unit.INSTANCE;
        }
    }

    public CreationEditorComponent$observerInstructionEditor$17(CreationEditorComponent r1, Continuation<? super CreationEditorComponent$observerInstructionEditor$17> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationEditorComponent$observerInstructionEditor$17(this.this$0, r3);
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
        kotlinx.coroutines.flow.d1 r7 = r6.i4().getActionBarInstructionInputSendReady();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
