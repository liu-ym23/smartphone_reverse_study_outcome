package com.larus.bmhome.chat.helper;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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
@DebugMetadata(c = "com.larus.bmhome.chat.helper.ConversationClickHelper$handleConversationClick$4", f = "ConversationClickHelper.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
public final class ConversationClickHelper$handleConversationClick$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $argPosition;
    final /* synthetic */ wh8.a $data;
    final /* synthetic */ String $recommendFromString;
    int label;
    final /* synthetic */ ConversationClickHelper this$0;

    public ConversationClickHelper$handleConversationClick$4(ConversationClickHelper r1, wh8.a r2, String r3, String r4, Continuation<? super ConversationClickHelper$handleConversationClick$4> r5) {
        this.this$0 = r1;
        this.$data = r2;
        this.$argPosition = r3;
        this.$recommendFromString = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ConversationClickHelper$handleConversationClick$4(this.this$0, this.$data, this.$argPosition, this.$recommendFromString, r8);
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
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ConversationClickHelper r7 = this.this$0;
        wh8.a r2 = this.$data;
        String r3 = this.$argPosition;
        String r4 = this.$recommendFromString;
        this.label = 1;
        if (ConversationClickHelper.a(r7, r2, r3, r4, this) != r0) goto L12;
        return r0;
    }
}
