package com.ss.android.lark.feed.shared.page;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "event", "Lcom/larksuite/arch/jack/Event;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.feed.shared.page.FeedItemsFragment$initSubscribers$1$1", f = "FeedItemsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FeedItemsFragment$initSubscribers$1$1 extends SuspendLambda implements Function2<com.larksuite.arch.jack.d<? extends Unit>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedItemsFragment this$0;

    public FeedItemsFragment$initSubscribers$1$1(FeedItemsFragment r1, Continuation<? super FeedItemsFragment$initSubscribers$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FeedItemsFragment$initSubscribers$1$1 r0 = new FeedItemsFragment$initSubscribers$1$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(com.larksuite.arch.jack.d<Unit> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.larksuite.arch.jack.d) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r2);
        com.larksuite.arch.jack.d r3 = (com.larksuite.arch.jack.d) this.L$0;
        if (r3 == null) goto L10;
        if (((Unit) r3.a()) == null) goto L10;
        this.this$0.So();
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
