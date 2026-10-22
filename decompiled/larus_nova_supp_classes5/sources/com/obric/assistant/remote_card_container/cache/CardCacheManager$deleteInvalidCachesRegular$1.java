package com.obric.assistant.remote_card_container.cache;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.cache.CardCacheManager$deleteInvalidCachesRegular$1", f = "CardCacheManager.kt", i = {}, l = {46, 49}, m = "invokeSuspend", n = {}, s = {})
public final class CardCacheManager$deleteInvalidCachesRegular$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public CardCacheManager$deleteInvalidCachesRegular$1(Continuation<? super CardCacheManager$deleteInvalidCachesRegular$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new CardCacheManager$deleteInvalidCachesRegular$1(r2);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L13:
        CardCacheManager r10 = CardCacheManager.a;
        CardCacheManager.b(new a());
        long r5 = TimeUnit.DAYS.toMillis(1);
        this.label = 2;
        if (DelayKt.delay(r5, this) != r0) goto L13;
        return r0;
    L10:
        ResultKt.throwOnFailure(r9);
        long r6 = TimeUnit.MINUTES.toMillis(1);
        this.label = 1;
        if (DelayKt.delay(r6, this) != r0) goto L13;
        return r0;
    }
}
