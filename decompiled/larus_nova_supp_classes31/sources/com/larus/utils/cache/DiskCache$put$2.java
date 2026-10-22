package com.larus.utils.cache;

import android.graphics.Bitmap;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import dvc.e;
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
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.utils.cache.DiskCache$put$2", f = "DiskCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DiskCache$put$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $data;
    final /* synthetic */ String $key;
    int label;
    final /* synthetic */ DiskCache this$0;

    public DiskCache$put$2(String r1, DiskCache r2, Bitmap r3, Continuation<? super DiskCache$put$2> r4) {
        this.$key = r1;
        this.this$0 = r2;
        this.$data = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DiskCache$put$2(this.$key, this.this$0, this.$data, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r9);
        if (this.$key.length() != 0) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == true) goto L10;
        DiskCache r11 = this.this$0;
        String r2 = this.$key;
        Bitmap r3 = this.$data;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L26
        ExecutorCoroutineDispatcher r5 = DiskCache.d;     // Catch: Throwable -> L26
        r11.getClass();     // Catch: Throwable -> L26
        String r6 = DiskCache.a(r2);     // Catch: Throwable -> L26
        e.b r12 = ((e) r11.c.getValue()).d(r6, -1);     // Catch: Throwable -> L26
        if (r12 == null) goto L15;
        BufferedSink r1 = Okio.buffer(r12.d(0));     // Catch: Throwable -> L26
        r3.compress(Bitmap.CompressFormat.PNG, 100, r1.outputStream());     // Catch: Throwable -> L21
        r1.flush();     // Catch: Throwable -> L21
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L19:
        CloseableKt.closeFinally(r1, null);     // Catch: Throwable -> L26
        r12.b();     // Catch: Throwable -> L26
        FLogger.a.d("DiskCache", "put bitmap " + r2 + " -> " + r6);     // Catch: Throwable -> L26
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L29:
        return Unit.INSTANCE;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L15:
        return Unit.INSTANCE;
    L26:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L10:
        return Unit.INSTANCE;
    L7:
        r10 = false;
        goto L8
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
