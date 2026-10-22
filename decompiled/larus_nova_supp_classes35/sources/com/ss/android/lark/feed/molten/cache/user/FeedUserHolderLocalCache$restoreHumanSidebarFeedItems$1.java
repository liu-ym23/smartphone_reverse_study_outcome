package com.ss.android.lark.feed.molten.cache.user;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/feed/molten/cache/HumanSidebarFeedCacheSnapshot;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.feed.molten.cache.user.FeedUserHolderLocalCache$restoreHumanSidebarFeedItems$1", f = "FeedUserHolderLocalCache.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
public final class FeedUserHolderLocalCache$restoreHumanSidebarFeedItems$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.ss.android.lark.feed.molten.cache.a>, Object> {
    int label;
    final /* synthetic */ FeedUserHolderLocalCache this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.cache.user.FeedUserHolderLocalCache$restoreHumanSidebarFeedItems$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/feed/molten/cache/HumanSidebarFeedCacheSnapshot;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.cache.user.FeedUserHolderLocalCache$restoreHumanSidebarFeedItems$1$1", f = "FeedUserHolderLocalCache.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.ss.android.lark.feed.molten.cache.a>, Object> {
        int label;
        final /* synthetic */ FeedUserHolderLocalCache this$0;

        public AnonymousClass1(FeedUserHolderLocalCache r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super com.ss.android.lark.feed.molten.cache.a> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            CompletableDeferred<com.ss.android.lark.feed.molten.cache.a> r5 = this.this$0.n;
            this.label = 1;
            r4 = r5.await(this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    public FeedUserHolderLocalCache$restoreHumanSidebarFeedItems$1(FeedUserHolderLocalCache r1, Continuation<? super FeedUserHolderLocalCache$restoreHumanSidebarFeedItems$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new FeedUserHolderLocalCache$restoreHumanSidebarFeedItems$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.ss.android.lark.feed.molten.cache.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        AnonymousClass1 r6 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        r5 = TimeoutKt.c(1000, r6, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
