package com.larus.canvas.feature.component.logic;

import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$handleEraseClickEvent$1", f = "GenImagePlannerComponent.kt", i = {}, l = {1220}, m = "invokeSuspend", n = {}, s = {})
final class GenImagePlannerComponent$handleEraseClickEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ky8.h $curTask;
    final /* synthetic */ InstructionTab $instructionTab;
    final /* synthetic */ OptionItem $optionItem;
    int label;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public GenImagePlannerComponent$handleEraseClickEvent$1(GenImagePlannerComponent r1, ky8.h r2, InstructionTab r3, OptionItem r4, Continuation<? super GenImagePlannerComponent$handleEraseClickEvent$1> r5) {
        this.this$0 = r1;
        this.$curTask = r2;
        this.$instructionTab = r3;
        this.$optionItem = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new GenImagePlannerComponent$handleEraseClickEvent$1(this.this$0, this.$curTask, this.$instructionTab, this.$optionItem, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        MediaAttachment r5 = (MediaAttachment) r4;
        if (r5 == null) goto L17;
        GenImagePlannerComponent r2 = this.this$0;
        InstructionTab r3 = this.$instructionTab;
        OptionItem r6 = this.$optionItem;
        com.larus.canvas.feature.component.input.b0 r7 = (com.larus.canvas.feature.component.input.b0) r2.u.getValue();
        if (r7 == null) goto L17;
        r7.h80(r5, r3, r6);
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        GenImagePlannerComponent r8 = this.this$0;
        ky8.h r9 = this.$curTask;
        this.label = 1;
        r4 = r8.a4(r9, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
