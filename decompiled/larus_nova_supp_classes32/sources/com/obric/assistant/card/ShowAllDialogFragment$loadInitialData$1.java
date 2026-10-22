package com.obric.assistant.card;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.card.ShowAllDialogFragment$loadInitialData$1", f = "ShowAllDialogFragment.kt", i = {}, l = {382}, m = "invokeSuspend", n = {}, s = {})
final class ShowAllDialogFragment$loadInitialData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ShowAllDialogFragment this$0;

    public ShowAllDialogFragment$loadInitialData$1(ShowAllDialogFragment r1, Continuation<? super ShowAllDialogFragment$loadInitialData$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ShowAllDialogFragment$loadInitialData$1(this.this$0, r3);
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
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L12;
        ResultKt.throwOnFailure(r6);     // Catch: Exception -> L7 CancellationException -> L9
    L17:
        Pair r7 = (Pair) r6;     // Catch: Exception -> L7 CancellationException -> L9
        ShowAllDialogFragment r2 = this.this$0;     // Catch: Exception -> L7 CancellationException -> L9
        MessageExtraForViewHolder r3 = (MessageExtraForViewHolder) r7.getFirst();     // Catch: Exception -> L7 CancellationException -> L9
        List<AppIntentCardData> r8 = (List) r7.getSecond();     // Catch: Exception -> L7 CancellationException -> L9
        int r4 = ShowAllDialogFragment.n;     // Catch: Exception -> L7 CancellationException -> L9
        r2.W90(r3, r8);     // Catch: Exception -> L7 CancellationException -> L9
        ShowAllDialogFragment.U90(this.this$0);     // Catch: Exception -> L7 CancellationException -> L9
        ShowAllDialogFragment.T90(this.this$0);     // Catch: Exception -> L7 CancellationException -> L9
    L21:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r6);
        CoroutineDispatcher r9 = Dispatchers.getIO();     // Catch: Exception -> L7 CancellationException -> L9
        ShowAllDialogFragment$loadInitialData$1$initialData$1 r5 = new ShowAllDialogFragment$loadInitialData$1$initialData$1(this.this$0, null);     // Catch: Exception -> L7 CancellationException -> L9
        this.label = 1;     // Catch: Exception -> L7 CancellationException -> L9
        r6 = BuildersKt.withContext(r9, r5, this);     // Catch: Exception -> L7 CancellationException -> L9
        if (r6 != r0) goto L17;
        return r0;
    L9:
        e = move-exception;
        throw e;
    L7:
        e = move-exception;
        FLogger.a.w("ShowAllDialogFragment", "failed: " + e.getMessage(), e);
        goto L21
    }
}
