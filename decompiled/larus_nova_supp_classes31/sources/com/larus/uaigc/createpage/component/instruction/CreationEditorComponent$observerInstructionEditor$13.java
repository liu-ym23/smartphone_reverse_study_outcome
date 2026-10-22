package com.larus.uaigc.createpage.component.instruction;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$observerInstructionEditor$13", f = "CreationEditorComponent.kt", i = {}, l = {2970}, m = "invokeSuspend", n = {}, s = {})
final class CreationEditorComponent$observerInstructionEditor$13 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationEditorComponent a;

        public a(CreationEditorComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r7, Continuation r8) {
            String r9 = (String) r7;
            if (r9 == null) goto L14;
            CreationEditorComponent r10 = this.a;
            r10.k0 = r9;
            ICoreInputAbility r0 = r10.a4();
            if (r0 == null) goto L14;
            boolean r1 = true;
            r0.tw(r9, true);
            if (r9.length() > 0) goto L10;
            r1 = false;
        L10:
            if (r1 == false) goto L12;
            r10.j6(3);
        L12:
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r10), null, null, new CreationEditorComponent$observerInstructionEditor$13$1$1$1$1(r10, null), 3, null);
        L14:
            return Unit.INSTANCE;
        }
    }

    public CreationEditorComponent$observerInstructionEditor$13(CreationEditorComponent r1, Continuation<? super CreationEditorComponent$observerInstructionEditor$13> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationEditorComponent$observerInstructionEditor$13(this.this$0, r3);
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
        kotlinx.coroutines.flow.d1 r7 = r6.i4().getInstructionVideoTemplatePrompt();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
