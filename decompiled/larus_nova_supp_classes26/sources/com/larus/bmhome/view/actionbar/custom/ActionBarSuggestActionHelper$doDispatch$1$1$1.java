package com.larus.bmhome.view.actionbar.custom;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.instruction.suggest.IPromptSelectActionDispatcherService;
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
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.ActionBarSuggestActionHelper$doDispatch$1$1$1", f = "ActionBarSuggestActionHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ActionBarSuggestActionHelper$doDispatch$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PromptContent.SuggestV2ExtraForMultiAction $it;
    int label;
    final /* synthetic */ o this$0;

    public ActionBarSuggestActionHelper$doDispatch$1$1$1(o r1, PromptContent.SuggestV2ExtraForMultiAction r2, Continuation<? super ActionBarSuggestActionHelper$doDispatch$1$1$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ActionBarSuggestActionHelper$doDispatch$1$1$1(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        IPromptSelectActionDispatcherService.a r5 = IPromptSelectActionDispatcherService.a;
        Fragment r0 = this.this$0.a;
        PromptContent.SuggestV2ExtraForMultiAction r1 = this.$it;
        r5.getClass();
        IPromptSelectActionDispatcherService.a.a(r0, r1, "click_spring_greeting_2025_action_bar", "spring_greeting_2025_action_bar");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
