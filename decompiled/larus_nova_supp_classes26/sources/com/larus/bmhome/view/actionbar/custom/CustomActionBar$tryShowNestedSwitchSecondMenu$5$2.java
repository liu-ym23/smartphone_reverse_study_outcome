package com.larus.bmhome.view.actionbar.custom;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.thinkmode.BehaviorSource;
import com.larus.bmhome.chat.thinkmode.ConversationSource;
import com.larus.bmhome.chat.thinkmode.IThinkModeMemoryReportService;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBar$tryShowNestedSwitchSecondMenu$5$2", f = "CustomActionBar.kt", i = {}, l = {1214}, m = "invokeSuspend", n = {}, s = {})
final class CustomActionBar$tryShowNestedSwitchSecondMenu$5$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ ReplyOption $targetOption;
    int label;

    public CustomActionBar$tryShowNestedSwitchSecondMenu$5$2(ReplyOption r1, wc9.e r2, Continuation<? super CustomActionBar$tryShowNestedSwitchSecondMenu$5$2> r3) {
        this.$targetOption = r1;
        this.$conversation = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CustomActionBar$tryShowNestedSwitchSecondMenu$5$2(this.$targetOption, this.$conversation, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        IThinkModeMemoryReportService.Companion r2 = IThinkModeMemoryReportService.a;
        ReplyOption r9 = this.$targetOption;
        BehaviorSource r3 = BehaviorSource.ACTIONBAR;
        ConversationSource.a r4 = ConversationSource.Companion;
        boolean r5 = ic8.n.v(this.$conversation);
        boolean r6 = ic8.n.r(this.$conversation);
        r4.getClass();
        if (r5 == false) goto L11;
        ConversationSource r7 = ConversationSource.MAIN_CONVERSATION;
    L14:
        Object r10 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
        Integer r11 = Boxing.boxInt(com.larus.bmhome.view.actionbar.custom.cache.e.c(this.$targetOption));
        this.label = 1;
        if (r2.a(r9, r3, r7, r11, this) != r0) goto L18;
        return r0;
    L11:
        if (r6 == false) goto L13;
        r7 = ConversationSource.NEW_CONVERSATION;
        goto L14
    L13:
        r7 = ConversationSource.UNKNOWN;
        goto L14
    }
}
