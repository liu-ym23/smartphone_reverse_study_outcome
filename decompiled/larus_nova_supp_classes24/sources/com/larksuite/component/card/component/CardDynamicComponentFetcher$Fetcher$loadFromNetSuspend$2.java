package com.larksuite.component.card.component;

import com.larksuite.component.card.utils.NetUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.component.card.component.CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$2", f = "CardDynamicComponentFetcher.kt", i = {0}, l = {88}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
final class CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends byte[]>>, Object> {
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;

    public CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$2(String r1, Continuation<? super CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$2> r2) {
        this.$url = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$2 r0 = new CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$2(this.$url, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<byte[]>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L9;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L24
    L14:
        Response r6 = (Response) r5;     // Catch: Throwable -> L24
        if (r6.isSuccessful() == false) goto L22;
        ResponseBody r7 = r6.body();     // Catch: Throwable -> L24
        if (r7 == null) goto L21;
        byte[] r8 = r7.bytes();     // Catch: Throwable -> L24
        if (r8 == null) goto L21;
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L24
    L27:
        return Result.box-impl(r9);
    L21:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L24
        r9 = Result.constructor-impl(ResultKt.createFailure(new RuntimeException("response body is null")));     // Catch: Throwable -> L24
        goto L27
    L22:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L24
        r9 = Result.constructor-impl(ResultKt.createFailure(new RuntimeException("response is not successful, code: " + r6.code())));     // Catch: Throwable -> L24
        goto L27
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r5);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        int r12 = NetUtils.a;     // Catch: Throwable -> L24
        String r13 = this.$url;     // Catch: Throwable -> L24
        this.L$0 = r11;     // Catch: Throwable -> L24
        this.label = 1;     // Catch: Throwable -> L24
        r5 = NetUtils.a(r13, this);     // Catch: Throwable -> L24
        if (r5 != r1) goto L14;
        return r1;
    L24:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }
}
