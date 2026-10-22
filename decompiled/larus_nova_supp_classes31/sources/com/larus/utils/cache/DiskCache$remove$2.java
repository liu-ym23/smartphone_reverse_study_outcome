package com.larus.utils.cache;

import com.tencent.open.log.TraceLevel;
import dvc.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.utils.cache.DiskCache$remove$2", f = "DiskCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DiskCache$remove$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $key;
    int label;
    final /* synthetic */ DiskCache this$0;

    public DiskCache$remove$2(DiskCache r1, String r2, Continuation<? super DiskCache$remove$2> r3) {
        this.this$0 = r1;
        this.$key = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DiskCache$remove$2(this.this$0, this.$key, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r3);
        DiskCache r4 = this.this$0;
        String r0 = this.$key;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r5 = Result.constructor-impl(Boxing.boxBoolean(((e) r4.c.getValue()).m(r0)));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r5) == false) goto L12;
        r5 = null;
    L12:
        Boolean r6 = (Boolean) r5;
        if (r6 == null) goto L15;
        boolean r7 = r6.booleanValue();
    L17:
        return Boxing.boxBoolean(r7);
    L15:
        r7 = false;
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
