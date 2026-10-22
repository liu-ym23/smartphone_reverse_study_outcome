package com.ss.android.lark.feed.molten.cache.user;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.feed.molten.cache.user.FeedUserHolderLocalCache$restoreLatestFeedItemsActual$2$readResults$1$1", f = "FeedUserHolderLocalCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FeedUserHolderLocalCache$restoreLatestFeedItemsActual$2$readResults$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends UIFeedCard>>, Object> {
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ FeedUserHolderLocalCache this$0;

    public FeedUserHolderLocalCache$restoreLatestFeedItemsActual$2$readResults$1$1(String r1, FeedUserHolderLocalCache r2, Continuation<? super FeedUserHolderLocalCache$restoreLatestFeedItemsActual$2$readResults$1$1> r3) {
        this.$id = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FeedUserHolderLocalCache$restoreLatestFeedItemsActual$2$readResults$1$1(this.$id, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Pair<String, ? extends UIFeedCard>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L34;
        ResultKt.throwOnFailure(r9);
        String r10 = this.$id;
        FeedUserHolderLocalCache r0 = this.this$0;
        int r1 = FeedUserHolderLocalCache.p;
        r0.getClass();
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(r0.e().getString("item:v2:" + r10, null));     // Catch: Throwable -> L7
    L9:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L13;
        geb.c.a("FeedUserHolderLocalCache", "readItemFromStorage getString failed, id:" + r10 + ", error:" + r5);
    L13:
        if (Result.isFailure-impl(r4) == false) goto L15;
        r4 = null;
    L15:
        String r6 = (String) r4;
        if (r6 != null) goto L37;
        UIFeedCard r7 = null;
    L21:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L18
    L24:
        Throwable r11 = Result.exceptionOrNull-impl(r8);
        if (r11 == null) goto L28;
        geb.c.a("FeedUserHolderLocalCache", "readItemFromStorage fromJson failed, id:" + r10 + ", error:" + r11);
    L28:
        if (Result.isFailure-impl(r8) == true) goto L32;
        r2 = r8;
    L32:
        return TuplesKt.to(r10, (UIFeedCard) r2);
    L18:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L37:
        r7 = (UIFeedCard) r0.b.fromJson(r6, new a().getType());     // Catch: Throwable -> L18
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
