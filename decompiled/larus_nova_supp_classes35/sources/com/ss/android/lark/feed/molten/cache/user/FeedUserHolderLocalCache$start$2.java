package com.ss.android.lark.feed.molten.cache.user;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.feed.molten.cache.user.FeedUserHolderLocalCache$start$2", f = "FeedUserHolderLocalCache.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
public final class FeedUserHolderLocalCache$start$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FeedUserHolderLocalCache this$0;

    public FeedUserHolderLocalCache$start$2(FeedUserHolderLocalCache r1, Continuation<? super FeedUserHolderLocalCache$start$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new FeedUserHolderLocalCache$start$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L35:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        FeedUserHolderLocalCache r10 = this.this$0;
        int r2 = FeedUserHolderLocalCache.p;
        r10.getClass();
        Object r3 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L19
        String r5 = r10.e().getString("human_sidebar:snapshot:v1", null);     // Catch: Throwable -> L19
        if (r5 == null) goto L16;
        com.ss.android.lark.feed.molten.cache.a r6 = (com.ss.android.lark.feed.molten.cache.a) r10.b.fromJson(r5, new c().getType());     // Catch: Throwable -> L19
        List<UIFeedCard> r7 = r6.a;     // Catch: Throwable -> L19
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));     // Catch: Throwable -> L19
        Iterator<T> r11 = r7.iterator();     // Catch: Throwable -> L19
    L13:
        if (r11.hasNext() == false) goto L15;
        UIFeedCard r12 = (UIFeedCard) r11.next();     // Catch: Throwable -> L19
        r12.setFlowDisplayType(UIFeedCard.FlowDisplayType.KV_STORAGE);     // Catch: Throwable -> L19
        r8.add(r12);     // Catch: Throwable -> L19
        goto L13
    L15:
        boolean r13 = r6.b;     // Catch: Throwable -> L19
        long r14 = r6.c;     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r8, "items");     // Catch: Throwable -> L19
        com.ss.android.lark.feed.molten.cache.a r15 = new com.ss.android.lark.feed.molten.cache.a(r8, r13, r14);     // Catch: Throwable -> L19
    L17:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L19
    L21:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L25;
        geb.c.b("FeedUserHolderLocalCache", "restoreHumanSidebarFeedItems failed", r17);
    L25:
        if (Result.isFailure-impl(r16) == true) goto L28;
        r3 = r16;
    L28:
        com.ss.android.lark.feed.molten.cache.a r18 = (com.ss.android.lark.feed.molten.cache.a) r3;
        r10.o = r18;
        if (r10.n.isCompleted() == true) goto L31;
        r10.n.complete(r18);
    L31:
        FeedUserHolderLocalCache r19 = this.this$0;
        this.label = 1;
        if (FeedUserHolderLocalCache.a(r19, this) != r0) goto L35;
        return r0;
    L16:
        r15 = null;
    L19:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }
}
