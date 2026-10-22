package com.ss.android.lark.feed.molten.cache.user;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.feed.molten.cache.user.FeedUserHolderLocalCache$restoreLatestFeedItems$2", f = "FeedUserHolderLocalCache.kt", i = {0, 0}, l = {180}, m = "invokeSuspend", n = {"$this$runBlocking", "mark$iv$iv"}, s = {"L$0", "J$0"})
public final class FeedUserHolderLocalCache$restoreLatestFeedItems$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends UIFeedCard>>, Object> {
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedUserHolderLocalCache this$0;

    public FeedUserHolderLocalCache$restoreLatestFeedItems$2(FeedUserHolderLocalCache r1, Continuation<? super FeedUserHolderLocalCache$restoreLatestFeedItems$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FeedUserHolderLocalCache$restoreLatestFeedItems$2 r0 = new FeedUserHolderLocalCache$restoreLatestFeedItems$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<? extends UIFeedCard>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r2 = this.J$0;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r10);
    L12:
        TimedValue r4 = new TimedValue((List) r10, TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(r2), null);
        geb.c.c("FeedUserHolderLocalCache", "restoreLatestFeedItems runBlocking await cost " + Duration.toString-impl(r4.getDuration-UwyO8pc()));
        List r11 = (List) r4.getValue();
        if (r11 != null) goto L16;
        geb.c.c("FeedUserHolderLocalCache", "restoreLatestFeedItems await timeout");
        return CollectionsKt.emptyList();
    L16:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        FeedUserHolderLocalCache r5 = this.this$0;
        long r6 = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
        FeedUserHolderLocalCache$restoreLatestFeedItems$2$1$1 r7 = new FeedUserHolderLocalCache$restoreLatestFeedItems$2$1$1(r5, null);
        this.L$0 = r12;
        this.J$0 = r6;
        this.label = 1;
        r10 = TimeoutKt.c(1000, r7, this);
        if (r10 != r0) goto L11;
        return r0;
    L11:
        r2 = r6;
        goto L12
    }
}
