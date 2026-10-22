package com.larus.bmhome.chat.helper;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.helper.ConversationFragmentAbilityImpl$startCreateConversation$1$1$1", f = "ConversationFragmentAbilityImpl.kt", i = {}, l = {MessageCellStateTransformerType.CROWD_TEST_SELECTION}, m = "invokeSuspend", n = {}, s = {})
public final class ConversationFragmentAbilityImpl$startCreateConversation$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ wc9.e $conv;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ by7.e $trackNode;
    int label;

    public ConversationFragmentAbilityImpl$startCreateConversation$1$1$1(String r1, Fragment r2, wc9.e r3, by7.e r4, Continuation<? super ConversationFragmentAbilityImpl$startCreateConversation$1$1$1> r5) {
        this.$cvsId = r1;
        this.$fragment = r2;
        this.$conv = r3;
        this.$trackNode = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ConversationFragmentAbilityImpl$startCreateConversation$1$1$1(this.$cvsId, this.$fragment, this.$conv, this.$trackNode, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r50) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r50);
        Object r4 = r50;
    L11:
        String r30 = (String) CollectionsKt.firstOrNull((List) r4);
        if (r30 != null) goto L14;
    L17:
        if (r3 == true) goto L20;
        ChatRouterHelper r5 = ChatRouterHelper.a;
        ChatRouterHelper.h(this.$fragment.requireContext(), r30, this.$conv, null, null, "chat_list", null, null, null, null, null, null, null, false, true, false, false, this.$trackNode, null, null, null, null, false, null, null, 33406936);
        tx9.k0.a(r30, "bot_list_plus", this.$cvsId, null, null, null, null, null, null, null, null, null, null, null, null, this.$trackNode, null, null, 983025);
    L20:
        return Unit.INSTANCE;
    L14:
        if (StringsKt.isBlank(r30) == true) goto L17;
        r3 = false;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r50);
        String r6 = this.$cvsId;
        this.label = 1;
        r4 = ic8.n.b(r6, this);
        if (r4 != r1) goto L11;
        return r1;
    }
}
