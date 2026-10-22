package com.obric.aiagent.messenger;

import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.AppIntentScreenshotCacheUtils$putFile$3", f = "AppIntentScreenshotCacheUtils.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
public final class AppIntentScreenshotCacheUtils$putFile$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ParcelFileDescriptor $fd;
    final /* synthetic */ String $fdKey;
    final /* synthetic */ CompletableDeferred<AppIntentScreenshotCacheUtils.a> $pending;
    private /* synthetic */ Object L$0;
    int label;

    public AppIntentScreenshotCacheUtils$putFile$3(ParcelFileDescriptor r1, String r2, CompletableDeferred<AppIntentScreenshotCacheUtils.a> r3, Continuation<? super AppIntentScreenshotCacheUtils$putFile$3> r4) {
        this.$fd = r1;
        this.$fdKey = r2;
        this.$pending = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        AppIntentScreenshotCacheUtils$putFile$3 r0 = new AppIntentScreenshotCacheUtils$putFile$3(this.$fd, this.$fdKey, this.$pending, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = this.label;
        if (r4 == 0) goto L9;
        if (r4 != 1) goto L8;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L26
        Object r0 = r18;
    L19:
        Pair r1 = (Pair) r0;     // Catch: Throwable -> L26
        String r5 = (String) r1.component1();     // Catch: Throwable -> L26
        boolean r2 = ((Boolean) r1.component2()).booleanValue();     // Catch: Throwable -> L26
        if (r5 == null) goto L23;
        Object r6 = Result.constructor-impl(new AppIntentScreenshotCacheUtils.a(r5, r2));     // Catch: Throwable -> L26
    L28:
        CompletableDeferred<AppIntentScreenshotCacheUtils.a> r7 = this.$pending;
        String r8 = this.$fdKey;
        CompletableDeferred<AppIntentScreenshotCacheUtils.a> r9 = null;
        if (Result.isSuccess-impl(r6) == false) goto L44;
        AppIntentScreenshotCacheUtils.a r10 = (AppIntentScreenshotCacheUtils.a) r6;
        r7.complete(r10);
        Object r11 = AppIntentScreenshotCacheUtils.b;
        monitor-enter(r11);
        AppIntentScreenshotCacheUtils.a.getClass();     // Catch: Throwable -> L41
        AppIntentScreenshotCacheUtils.f();     // Catch: Throwable -> L41
        FLogger.a.i("AppIntentScreenshotCacheUtils", "put encrypted heif, fdKey=" + r8 + ", dataLength=" + r10.a.length());     // Catch: Throwable -> L41
        AppIntentScreenshotCacheUtils$cache$1 r12 = AppIntentScreenshotCacheUtils.h;     // Catch: Throwable -> L41
        AppIntentScreenshotCacheUtils.c r13 = (AppIntentScreenshotCacheUtils.c) r12.get(r8);     // Catch: Throwable -> L41
        if (r13 == null) goto L35;
        CompletableDeferred<AppIntentScreenshotCacheUtils.a> r14 = r13.c;     // Catch: Throwable -> L41
    L36:
        if (r14 != r7) goto L38;
        r12.put(r8, new AppIntentScreenshotCacheUtils.c(null, r10.a, null, r10.b, SystemClock.uptimeMillis(), 5));     // Catch: Throwable -> L41
    L38:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r11);
        goto L44
    L35:
        r14 = null;
    L41:
        th = move-exception;
        throw th;
    L44:
        String r16 = this.$fdKey;
        CompletableDeferred<AppIntentScreenshotCacheUtils.a> r17 = this.$pending;
        Throwable r19 = Result.exceptionOrNull-impl(r6);
        if (r19 == null) goto L60;
        FLogger.a.e("AppIntentScreenshotCacheUtils", "putFile, process heif failed, fdKey=" + r16, r19);
        r17.completeExceptionally(r19);
        Object r20 = AppIntentScreenshotCacheUtils.b;
        monitor-enter(r20);
        AppIntentScreenshotCacheUtils$cache$1 r21 = AppIntentScreenshotCacheUtils.h;     // Catch: Throwable -> L56
        AppIntentScreenshotCacheUtils.c r22 = (AppIntentScreenshotCacheUtils.c) r21.get(r16);     // Catch: Throwable -> L56
        if (r22 == null) goto L51;
        r9 = r22.c;     // Catch: Throwable -> L56
    L51:
        if (r9 != r17) goto L53;
        r21.remove(r16);     // Catch: Throwable -> L56
    L53:
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L56
        monitor-exit(r20);
    L56:
        th = move-exception;
        throw th;
    L60:
        return Unit.INSTANCE;
    L23:
        throw new IllegalStateException("encrypt heif screenshot failed".toString());     // Catch: Throwable -> L26
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r24 = (CoroutineScope) this.L$0;
        ParcelFileDescriptor r25 = this.$fd;
        String r26 = this.$fdKey;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L26
        AppIntentScreenshotCacheUtils r28 = AppIntentScreenshotCacheUtils.a;     // Catch: Throwable -> L26
        byte[] r29 = AppIntentScreenshotCacheUtils.a(r28, r25);     // Catch: Throwable -> L26
        FLogger.a.i("AppIntentScreenshotCacheUtils", "putFile, fdKey=" + r26 + ", byteLength=" + r29.length);     // Catch: Throwable -> L26
        if (r29.length != 0) goto L13;
        boolean r30 = true;
    L15:
        if ((!r30) == false) goto L25;
        this.label = 1;     // Catch: Throwable -> L26
        r0 = r28.b(r26, r29, this);     // Catch: Throwable -> L26
        if (r0 != r3) goto L19;
        return r3;
    L25:
        throw new IllegalStateException("heif fd is empty".toString());     // Catch: Throwable -> L26
    L13:
        r30 = false;
    L26:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }
}
