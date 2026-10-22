package com.ss.android.lark.feed.shared.page;

import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.log.Log;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "entities", "Lcom/ss/android/lark/feed/shared/data/UpdateRecord;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.feed.shared.page.FeedItemsFragment$initSubscribers$1$9", f = "FeedItemsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FeedItemsFragment$initSubscribers$1$9 extends SuspendLambda implements Function2<UpdateRecord, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedItemsFragment this$0;

    public FeedItemsFragment$initSubscribers$1$9(FeedItemsFragment r1, Continuation<? super FeedItemsFragment$initSubscribers$1$9> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FeedItemsFragment$initSubscribers$1$9 r0 = new FeedItemsFragment$initSubscribers$1$9(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(UpdateRecord r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((UpdateRecord) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r4);
        UpdateRecord r5 = (UpdateRecord) this.L$0;
        if (r5 == null) goto L7;
        FeedItemsFragment r0 = this.this$0;
        FeedItemsFragment.UpdateSource r1 = FeedItemsFragment.UpdateSource.CACHE_UPDATE;
        cfb.a r2 = FeedItemsFragment.Q;
        r0.Z90(r5, r1);
    L9:
        return Unit.INSTANCE;
    L7:
        Log.e("FeedSharedModule_FeedItemsFragment", "receive feedItemEntities changed, update inbox data failed, data is null");
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
