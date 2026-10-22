package com.larksuite.component.card.component;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.log.Log;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.component.card.component.CardDynamicComponentFetcher$Fetcher$loadFromPathSuspend$2", f = "CardDynamicComponentFetcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CardDynamicComponentFetcher$Fetcher$loadFromPathSuspend$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends byte[]>>, Object> {
    final /* synthetic */ String $componentPath;
    int label;

    public CardDynamicComponentFetcher$Fetcher$loadFromPathSuspend$2(String r1, Continuation<? super CardDynamicComponentFetcher$Fetcher$loadFromPathSuspend$2> r2) {
        this.$componentPath = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CardDynamicComponentFetcher$Fetcher$loadFromPathSuspend$2(this.$componentPath, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<byte[]>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r9);
        Object r10 = CardDynamicComponentFetcher.b;
        String r3 = this.$componentPath;
        monitor-enter(r10);
        CardDynamicComponentFetcher.a r4 = CardDynamicComponentFetcher.a;     // Catch: Throwable -> L34
        r4.getClass();     // Catch: Throwable -> L34
        byte[] r5 = (byte[]) CardDynamicComponentFetcher.c.get(r3);     // Catch: Throwable -> L34
        if (r5 == null) goto L9;
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L34
    L11:
        if (Result.isSuccess-impl(r6) == false) goto L13;
        Log.i("CardDynamicComponentFetcher", "loaded from memCache");     // Catch: Throwable -> L34
    L31:
        Result r0 = Result.box-impl(r6);     // Catch: Throwable -> L34
        monitor-exit(r10);
        return r0;
    L13:
        StringBuilder r7 = new StringBuilder("missed memCache, reason: ");     // Catch: Throwable -> L34
        Throwable r2 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L34
        String r8 = null;
        if (r2 == null) goto L16;
        String r11 = r2.getMessage();     // Catch: Throwable -> L34
    L17:
        r7.append(r11);     // Catch: Throwable -> L34
        Log.i("CardDynamicComponentFetcher", r7.toString());     // Catch: Throwable -> L34
        Object r12 = CardDynamicComponentFetcher.a.b(r4, r3);     // Catch: Throwable -> L34
        if (Result.isSuccess-impl(r12) == false) goto L20;
        Log.i("CardDynamicComponentFetcher", "loaded from diskCache");     // Catch: Throwable -> L34
        r6 = r12;
        goto L31
    L20:
        StringBuilder r13 = new StringBuilder("missed diskCache, reason: ");     // Catch: Throwable -> L34
        Throwable r1 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L34
        if (r1 == null) goto L23;
        String r14 = r1.getMessage();     // Catch: Throwable -> L34
    L24:
        r13.append(r14);     // Catch: Throwable -> L34
        Log.i("CardDynamicComponentFetcher", r13.toString());     // Catch: Throwable -> L34
        Object r15 = CardDynamicComponentFetcher.a.a(r4, r3);     // Catch: Throwable -> L34
        if (Result.isSuccess-impl(r15) == false) goto L27;
        Log.i("CardDynamicComponentFetcher", "loaded from cdn");     // Catch: Throwable -> L34
        r6 = r15;
        goto L31
    L27:
        StringBuilder r16 = new StringBuilder("missed cdn, reason: ");     // Catch: Throwable -> L34
        Throwable r17 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L34
        if (r17 == null) goto L30;
        r8 = r17.getMessage();     // Catch: Throwable -> L34
    L30:
        r16.append(r8);     // Catch: Throwable -> L34
        Log.i("CardDynamicComponentFetcher", r16.toString());     // Catch: Throwable -> L34
        r6 = Result.constructor-impl(ResultKt.createFailure(new RuntimeException("load from path failed")));     // Catch: Throwable -> L34
        goto L31
    L23:
        r14 = null;
        goto L24
    L16:
        r11 = null;
        goto L17
    L9:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L34
        r6 = Result.constructor-impl(ResultKt.createFailure(new RuntimeException("file not in memCache")));     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
