package com.ss.android.lark.feed.shared.page;

import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.shared.hitpoint.FeedHitPointNew;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "event", "Lcom/larksuite/arch/jack/Event;", "Lcom/ss/android/lark/feed/app/entity/FeedFolder;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.feed.shared.page.FeedItemsFragment$initSubscribers$1$3", f = "FeedItemsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FeedItemsFragment$initSubscribers$1$3 extends SuspendLambda implements Function2<com.larksuite.arch.jack.d<? extends FeedFolder>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedItemsFragment this$0;

    public FeedItemsFragment$initSubscribers$1$3(FeedItemsFragment r1, Continuation<? super FeedItemsFragment$initSubscribers$1$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FeedItemsFragment$initSubscribers$1$3 r0 = new FeedItemsFragment$initSubscribers$1$3(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(com.larksuite.arch.jack.d<FeedFolder> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.larksuite.arch.jack.d) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r6);
        com.larksuite.arch.jack.d r7 = (com.larksuite.arch.jack.d) this.L$0;
        if (r7 == null) goto L21;
        FeedFolder r8 = (FeedFolder) r7.a();
        if (r8 == null) goto L21;
        FeedItemsFragment r0 = this.this$0;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r8, "filter");
        q r2 = r0.n;
        if (r2 == null) goto L11;
        r8.getId();
        FeedFolder r9 = r2.b();
    L12:
        if (r9 != null) goto L21;
        com.larksuite.component.ui.dialog.d r3 = new com.larksuite.component.ui.dialog.d(r0.getActivity());
        r3.c.message(2131891198);
        r3.a(2131378551, 2131890715, new h(r0, r9));
        r3.a(2131378550, 2131890714, i.a);
        r3.i();
        int r10 = com.ss.android.lark.feed.shared.hitpoint.a.a;
        Statistics.sendEvent("feed_delayed_popup_view");     // Catch: Throwable -> L17
    L19:
        int r11 = FeedHitPointNew.a;
        Statistics.sendEvent("feed_delayed_popup_view");
    L17:
        th = move-exception;
        Log.e("FeedHitPoint", th.getMessage());
        goto L19
    L11:
        r9 = null;
    L21:
        return Unit.INSTANCE;
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
