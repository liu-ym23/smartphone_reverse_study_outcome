package com.larus.bmhome.chat.component.showcase;

import android.content.Context;
import com.larus.bmhome.chat.bean.ChatPassThroughParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.helper.ChatRouterHelper;
import ic8.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import s1a.d;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.showcase.ChatCaseMessageComponent$startCreateConversation$1$1$1", f = "ChatCaseMessageComponent.kt", i = {}, l = {299}, m = "invokeSuspend", n = {}, s = {})
final class ChatCaseMessageComponent$startCreateConversation$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $conv;
    final /* synthetic */ String $cvsId;
    int label;
    final /* synthetic */ ChatCaseMessageComponent this$0;

    public ChatCaseMessageComponent$startCreateConversation$1$1$1(String r1, ChatCaseMessageComponent r2, e r3, Continuation<? super ChatCaseMessageComponent$startCreateConversation$1$1$1> r4) {
        this.$cvsId = r1;
        this.this$0 = r2;
        this.$conv = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatCaseMessageComponent$startCreateConversation$1$1$1(this.$cvsId, this.this$0, this.$conv, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r31) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r31);
        Object r4 = r31;
    L11:
        String r5 = (String) CollectionsKt.firstOrNull((List) r4);
        if (r5 != null) goto L14;
    L17:
        if (r3 == true) goto L24;
        ChatRouterHelper r6 = ChatRouterHelper.a;
        Context r7 = s1a.a.c(this.this$0).getContext();
        if (r7 == null) goto L21;
        ChatPassThroughParams r23 = (ChatPassThroughParams) d.a(this.this$0).a(ChatPassThroughParams.class);
        ChatRouterHelper.h(r7, r5, this.$conv, null, null, "case", null, null, null, null, null, null, null, false, true, true, false, null, null, r23, null, null, false, null, null, 32849880);
        goto L24
    L21:
        return Unit.INSTANCE;
    L24:
        return Unit.INSTANCE;
    L14:
        if (StringsKt.isBlank(r5) == true) goto L17;
        r3 = false;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r31);
        String r8 = this.$cvsId;
        this.label = 1;
        r4 = n.b(r8, this);
        if (r4 != r1) goto L11;
        return r1;
    }
}
