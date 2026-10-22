package com.larus.bmhome.social.page.datasource;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [T, Key] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/social/page/datasource/PagingResult;", "T", "Key", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.LoadStateHolder$checkLoad$result$1", f = "FlowPagingManager.kt", i = {}, l = {234, 236}, m = "invokeSuspend", n = {}, s = {})
public final class LoadStateHolder$checkLoad$result$1<Key, T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g<T, Key>>, Object> {
    final /* synthetic */ com.larus.bmhome.social.page.datasource.event.e.a $operation;
    final /* synthetic */ e<Key> $request;
    int label;
    final /* synthetic */ LoadStateHolder<T, Key> this$0;

    public LoadStateHolder$checkLoad$result$1(com.larus.bmhome.social.page.datasource.event.e.a r1, LoadStateHolder<T, Key> r2, e<Key> r3, Continuation<? super LoadStateHolder$checkLoad$result$1> r4) {
        this.$operation = r1;
        this.this$0 = r2;
        this.$request = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new LoadStateHolder$checkLoad$result$1(this.$operation, this.this$0, this.$request, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super g<T, Key>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L24
    L29:
        return (g) r5;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L24
    L28:
        return (g) r5;
    L12:
        ResultKt.throwOnFailure(r5);
        if ((this.$operation instanceof com.larus.bmhome.social.page.datasource.event.e.a.C0035a) == false) goto L19;
        f<T, Key> r6 = this.this$0.a;     // Catch: Throwable -> L24
        this.label = 1;     // Catch: Throwable -> L24
        r5 = r6.a();     // Catch: Throwable -> L24
        if (r5 != r0) goto L28;
        return r0;
    L19:
        f<T, Key> r7 = this.this$0.a;     // Catch: Throwable -> L24
        this.label = 2;     // Catch: Throwable -> L24
        r5 = r7.b();     // Catch: Throwable -> L24
        if (r5 != r0) goto L29;
        return r0;
    L24:
        th = move-exception;
        int r2 = g.b;
        return new g.c(th);
    }
}
