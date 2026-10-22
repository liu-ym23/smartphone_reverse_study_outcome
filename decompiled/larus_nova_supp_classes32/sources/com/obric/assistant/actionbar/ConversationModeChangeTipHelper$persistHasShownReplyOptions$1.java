package com.obric.assistant.actionbar;

import com.bytedance.keva.Keva;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.actionbar.ConversationModeChangeTipHelper$persistHasShownReplyOptions$1", f = "ConversationModeChangeTipHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConversationModeChangeTipHelper$persistHasShownReplyOptions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ Set<String> $modeIds;
    int label;

    public ConversationModeChangeTipHelper$persistHasShownReplyOptions$1(String r1, Set<String> r2, Continuation<? super ConversationModeChangeTipHelper$persistHasShownReplyOptions$1> r3) {
        this.$key = r1;
        this.$modeIds = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ConversationModeChangeTipHelper$persistHasShownReplyOptions$1(this.$key, this.$modeIds, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        ((Keva) ConversationModeChangeTipHelper.b.getValue()).storeStringSet(this.$key, this.$modeIds);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
