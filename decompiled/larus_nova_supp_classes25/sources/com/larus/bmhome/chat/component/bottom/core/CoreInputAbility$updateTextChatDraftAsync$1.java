package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputAbility$updateTextChatDraftAsync$1", f = "CoreInputAbility.kt", i = {}, l = {3400}, m = "invokeSuspend", n = {}, s = {})
final class CoreInputAbility$updateTextChatDraftAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $userEditedAt;
    int label;
    final /* synthetic */ CoreInputAbility<ComponentFeature> this$0;

    public CoreInputAbility$updateTextChatDraftAsync$1(CoreInputAbility<ComponentFeature> r1, long r2, Continuation<? super CoreInputAbility$updateTextChatDraftAsync$1> r4) {
        this.this$0 = r1;
        this.$userEditedAt = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CoreInputAbility$updateTextChatDraftAsync$1(this.this$0, this.$userEditedAt, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L16:
        String r10 = (String) r9;
        if (r10 != null) goto L19;
        r10 = "";
    L19:
        String r2 = r10;
        CoreInputAbility<ComponentFeature> r11 = this.this$0;
        String r3 = CoreInputAbility.U;
        com.larus.bmhome.chat.model.j1 r4 = r11.A().Y3();
        if (r4 == null) goto L27;
        com.larus.bmhome.instruction.h r12 = this.this$0.A().yJ();
        if (r12 == null) goto L24;
        String r13 = r12.S20();
    L25:
        Boxing.boxBoolean(com.larus.bmhome.chat.model.j1.a.c(r4, r2, r13, false, Boxing.boxLong(this.$userEditedAt), null, null, 52));
        goto L27
    L24:
        r13 = null;
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        if (this.this$0.g.isAdded() == false) goto L29;
        if (this.this$0.f.Mb() == true) goto L29;
        a9 r14 = this.this$0.f;
        this.label = 1;
        r9 = r14.KD(this);
        if (r9 != r0) goto L16;
        return r0;
    L29:
        return Unit.INSTANCE;
    }
}
