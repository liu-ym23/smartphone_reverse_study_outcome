package com.larksuite.component.card.component;

import android.webkit.URLUtil;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.component.card.component.CardDynamicComponentFetcher$Fetcher$loadComponent$1", f = "CardDynamicComponentFetcher.kt", i = {}, l = {70, 72}, m = "invokeSuspend", n = {}, s = {})
final class CardDynamicComponentFetcher$Fetcher$loadComponent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ k7a.a.a $handler;
    final /* synthetic */ String $url;
    int label;

    public CardDynamicComponentFetcher$Fetcher$loadComponent$1(String r1, k7a.a.a r2, Continuation<? super CardDynamicComponentFetcher$Fetcher$loadComponent$1> r3) {
        this.$url = r1;
        this.$handler = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CardDynamicComponentFetcher$Fetcher$loadComponent$1(this.$url, this.$handler, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 == 1) goto L6;
        if (r1 == 2) goto L6;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L6:
        ResultKt.throwOnFailure(r5);
        Object r6 = ((Result) r5).unbox-impl();
    L18:
        if (Result.isSuccess-impl(r6) == false) goto L23;
        Log.i("CardDynamicComponentFetcher", "load success");
        k7a.a.a r2 = this.$handler;
        if (Result.isFailure-impl(r6) == false) goto L22;
        r6 = null;
    L22:
        r2.a((byte[]) r6, null);
    L25:
        return Unit.INSTANCE;
    L23:
        Log.e("CardDynamicComponentFetcher", "load failed", Result.exceptionOrNull-impl(r6));
        this.$handler.a(null, Result.exceptionOrNull-impl(r6));
        goto L25
    L9:
        ResultKt.throwOnFailure(r5);
        if (URLUtil.isNetworkUrl(this.$url) == false) goto L14;
        CardDynamicComponentFetcher.a r7 = CardDynamicComponentFetcher.a;
        String r3 = this.$url;
        this.label = 1;
        r6 = CardDynamicComponentFetcher.a.c(r7, r3, this);
        if (r6 != r0) goto L18;
        return r0;
    L14:
        CardDynamicComponentFetcher.a r8 = CardDynamicComponentFetcher.a;
        String r4 = this.$url;
        this.label = 2;
        r6 = CardDynamicComponentFetcher.a.d(r8, r4, this);
        if (r6 != r0) goto L18;
        return r0;
    }
}
