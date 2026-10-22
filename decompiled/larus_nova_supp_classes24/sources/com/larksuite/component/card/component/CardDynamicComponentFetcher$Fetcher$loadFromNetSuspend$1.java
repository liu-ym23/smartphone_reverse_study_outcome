package com.larksuite.component.card.component;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.component.card.component.CardDynamicComponentFetcher$Fetcher", f = "CardDynamicComponentFetcher.kt", i = {}, l = {86}, m = "loadFromNetSuspend-gIAlu-s", n = {}, s = {})
final class CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CardDynamicComponentFetcher.a this$0;

    public CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$1(CardDynamicComponentFetcher.a r1, Continuation<? super CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        Object r3 = CardDynamicComponentFetcher.a.c(this.this$0, null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
