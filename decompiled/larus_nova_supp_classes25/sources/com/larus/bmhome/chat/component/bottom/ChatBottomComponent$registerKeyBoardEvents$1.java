package com.larus.bmhome.chat.component.bottom;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.common_ui.utils.ViewExtKt;
import gd8.f;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.ChatBottomComponent$registerKeyBoardEvents$1", f = "ChatBottomComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatBottomComponent$registerKeyBoardEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatBottomComponent this$0;

    public ChatBottomComponent$registerKeyBoardEvents$1(ChatBottomComponent r1, Continuation<? super ChatBottomComponent$registerKeyBoardEvents$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatBottomComponent$registerKeyBoardEvents$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r5);
        ChatBottomComponent r6 = this.this$0;
        int r0 = ChatBottomComponent.L0;
        f r7 = r6.G3();
        if (r7 == null) goto L10;
        final LarusPageChatBinding r8 = r7.e();
        if (r8 == null) goto L10;
        final ChatBottomComponent r1 = this.this$0;
        ViewExtKt.j(r8.i, new d1(r1, r8), new e1(r1, r8), 2);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
