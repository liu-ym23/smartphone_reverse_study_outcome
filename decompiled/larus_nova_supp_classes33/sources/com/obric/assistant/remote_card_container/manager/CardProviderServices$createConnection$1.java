package com.obric.assistant.remote_card_container.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.manager.CardProviderServices", f = "CardProviderServices.kt", i = {0}, l = {198}, m = "createConnection", n = {"connectingJob"}, s = {"L$0"})
final class CardProviderServices$createConnection$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CardProviderServices this$0;

    public CardProviderServices$createConnection$1(CardProviderServices r1, Continuation<? super CardProviderServices$createConnection$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CardProviderServices.b(this.this$0, null, null, this);
    }
}
