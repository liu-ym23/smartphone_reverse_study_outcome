package com.larus.utils.cache;

import com.tencent.open.log.TraceLevel;
import dvc.e;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.utils.cache.DiskCache$getCacheFile$2", f = "DiskCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DiskCache$getCacheFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $key;
    int label;
    final /* synthetic */ DiskCache this$0;

    public DiskCache$getCacheFile$2(String r1, DiskCache r2, Continuation<? super DiskCache$getCacheFile$2> r3) {
        this.$key = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DiskCache$getCacheFile$2(this.$key, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L36;
        ResultKt.throwOnFailure(r6);
        if (this.$key.length() != 0) goto L7;
        boolean r7 = true;
    L9:
        if (r7 == false) goto L11;
        return "";
    L11:
        DiskCache r8 = this.this$0;
        String r2 = this.$key;
        Object r3 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L24
        ExecutorCoroutineDispatcher r5 = DiskCache.d;     // Catch: Throwable -> L24
        r8.getClass();     // Catch: Throwable -> L24
        String r9 = DiskCache.a(r2);     // Catch: Throwable -> L24
        e.d r10 = ((e) r8.c.getValue()).f(r9);     // Catch: Throwable -> L24
        if (r10 != null) goto L15;
        return "";
    L15:
        Closeable r0 = r10.c[0];     // Catch: Throwable -> L24
        String r11 = ((e) r8.c.getValue()).b + '/' + r9 + ".0";     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r0, null);     // Catch: Throwable -> L24
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r12) == true) goto L30;
        r3 = r12;
    L30:
        String r13 = (String) r3;
        if (r13 != null) goto L34;
        return "";
    L34:
        return r13;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L7:
        r7 = false;
        goto L9
    L36:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
