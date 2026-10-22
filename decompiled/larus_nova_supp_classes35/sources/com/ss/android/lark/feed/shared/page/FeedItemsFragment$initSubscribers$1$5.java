package com.ss.android.lark.feed.shared.page;

import com.larksuite.component.universe_design.toast.UDToast;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "event", "Lcom/larksuite/arch/jack/Event;", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.feed.shared.page.FeedItemsFragment$initSubscribers$1$5", f = "FeedItemsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FeedItemsFragment$initSubscribers$1$5 extends SuspendLambda implements Function2<com.larksuite.arch.jack.d<? extends String>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedItemsFragment this$0;

    public FeedItemsFragment$initSubscribers$1$5(FeedItemsFragment r1, Continuation<? super FeedItemsFragment$initSubscribers$1$5> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FeedItemsFragment$initSubscribers$1$5 r0 = new FeedItemsFragment$initSubscribers$1$5(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(com.larksuite.arch.jack.d<String> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.larksuite.arch.jack.d) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r3);
        com.larksuite.arch.jack.d r4 = (com.larksuite.arch.jack.d) this.L$0;
        if (r4 == null) goto L18;
        String r5 = (String) r4.a();
        if (r5 == null) goto L18;
        FeedItemsFragment r0 = this.this$0;
        cfb.a r1 = FeedItemsFragment.Q;
        r0.getClass();
        if (r5.length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == true) goto L15;
        r5 = null;
    L15:
        if (r5 == null) goto L18;
        UDToast.show(r0.requireContext(), r5);
        goto L18
    L11:
        r2 = false;
    L18:
        return Unit.INSTANCE;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
