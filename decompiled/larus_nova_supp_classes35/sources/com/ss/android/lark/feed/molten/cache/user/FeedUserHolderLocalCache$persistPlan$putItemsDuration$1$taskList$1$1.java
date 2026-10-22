package com.ss.android.lark.feed.molten.cache.user;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.feed.molten.cache.user.FeedUserHolderLocalCache$persistPlan$putItemsDuration$1$taskList$1$1", f = "FeedUserHolderLocalCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FeedUserHolderLocalCache$persistPlan$putItemsDuration$1$taskList$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ UIFeedCard $item;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedUserHolderLocalCache this$0;

    public FeedUserHolderLocalCache$persistPlan$putItemsDuration$1$taskList$1$1(FeedUserHolderLocalCache r1, String r2, UIFeedCard r3, Continuation<? super FeedUserHolderLocalCache$persistPlan$putItemsDuration$1$taskList$1$1> r4) {
        this.this$0 = r1;
        this.$id = r2;
        this.$item = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        FeedUserHolderLocalCache$persistPlan$putItemsDuration$1$taskList$1$1 r0 = new FeedUserHolderLocalCache$persistPlan$putItemsDuration$1$taskList$1$1(this.this$0, this.$id, this.$item, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        FeedUserHolderLocalCache r9 = this.this$0;
        String r0 = this.$id;
        int r1 = FeedUserHolderLocalCache.p;
        r9.getClass();
        String r10 = "item:v2:" + r0;
        FeedUserHolderLocalCache r2 = this.this$0;
        UIFeedCard r3 = this.$item;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
        Object r5 = Result.constructor-impl(r2.b.toJson(r3));     // Catch: Throwable -> L7
    L9:
        String r6 = this.$id;
        Throwable r11 = Result.exceptionOrNull-impl(r5);
        if (r11 == null) goto L13;
        geb.c.a("FeedUserHolderLocalCache", "persistPlan toJson failed, id:" + r6 + ", error:" + r11);
    L13:
        if (Result.isFailure-impl(r5) == false) goto L15;
        r5 = null;
    L15:
        String r12 = (String) r5;
        if (r12 != null) goto L19;
        geb.c.d("FeedUserHolderLocalCache", "persistPlan skip put because json is null, id:" + this.$id);
        return Unit.INSTANCE;
    L19:
        this.this$0.e().putString(r10, r12);
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
