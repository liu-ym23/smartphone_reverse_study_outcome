package com.larus.bmhome.instruction;

import com.larus.platform.kmp.chat.TemplateInfo;
import com.larus.uaigc.bean.chat.template.TemplateChooseState;
import com.larus.uaigc.bean.chat.template.TemplateViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$observeTemplateChoose$1", f = "InstructionInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class InstructionInputComponent$observeTemplateChoose$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.ui.arch.vm.internal.l<TemplateViewModel, TemplateChooseState> $activityFragmentVM$delegate;
    int label;
    final /* synthetic */ InstructionInputComponent this$0;

    public InstructionInputComponent$observeTemplateChoose$1(InstructionInputComponent r1, com.larus.ui.arch.vm.internal.l<TemplateViewModel, TemplateChooseState> r2, Continuation<? super InstructionInputComponent$observeTemplateChoose$1> r3) {
        this.this$0 = r1;
        this.$activityFragmentVM$delegate = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new InstructionInputComponent$observeTemplateChoose$1(this.this$0, this.$activityFragmentVM$delegate, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        final InstructionInputComponent r3 = this.this$0;
        Function1<? super TemplateInfo.TemplateInfo, Unit> r0 = new q1(r3);
        r3.o = r0;
        ((TemplateViewModel) this.$activityFragmentVM$delegate.getValue()).listenToImageTemplate(r0);
        final InstructionInputComponent r4 = this.this$0;
        Function1<? super bq8.a, Unit> r1 = new r1(r4);
        r4.p = r1;
        ((TemplateViewModel) this.$activityFragmentVM$delegate.getValue()).listenToMusicTemplate(r1);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
