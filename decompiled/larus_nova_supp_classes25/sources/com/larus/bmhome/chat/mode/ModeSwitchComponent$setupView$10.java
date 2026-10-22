package com.larus.bmhome.chat.mode;

import com.larus.bmhome.auth.ConversationMode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bmhome/auth/ConversationMode;", "Lcom/larus/bmhome/chat/model/api/ConversationMode;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.mode.ModeSwitchComponent$setupView$10", f = "ModeSwitchComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ModeSwitchComponent$setupView$10 extends SuspendLambda implements Function2<ConversationMode, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ModeSwitchComponent this$0;

    public ModeSwitchComponent$setupView$10(ModeSwitchComponent r1, Continuation<? super ModeSwitchComponent$setupView$10> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ModeSwitchComponent$setupView$10 r0 = new ModeSwitchComponent$setupView$10(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(ConversationMode r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ConversationMode) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r3);
        ConversationMode r4 = (ConversationMode) this.L$0;
        l0 r0 = this.this$0.u;
        if (r0 == null) goto L10;
        if (r4 == null) goto L8;
        String r1 = r4.a();
    L9:
        r0.setSelectedKey(r1);
        goto L10
    L8:
        r1 = null;
    L10:
        this.this$0.Q3(r4);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
