package com.larus.chat.gallery.impl.preview;

import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.OriginalImagePreloader$awaitReady$result$1", f = "OriginalImagePreloader.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
public final class OriginalImagePreloader$awaitReady$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $bizTag;
    final /* synthetic */ String $rawImagePath;
    private /* synthetic */ Object L$0;
    int label;

    public OriginalImagePreloader$awaitReady$result$1(String r1, String r2, Continuation<? super OriginalImagePreloader$awaitReady$result$1> r3) {
        this.$rawImagePath = r1;
        this.$bizTag = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        OriginalImagePreloader$awaitReady$result$1 r0 = new OriginalImagePreloader$awaitReady$result$1(this.$rawImagePath, this.$bizTag, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L15
    L13:
        Object r6 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) r5).booleanValue()));     // Catch: Throwable -> L15
    L17:
        Throwable r2 = Result.exceptionOrNull-impl(r6);
        if (r2 == null) goto L20;
        FLogger.a.e("OriginalImagePreloader", "awaitReady: prefetch raw image failed", r2);
    L20:
        Boolean r3 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r6) == true) goto L23;
        return r6;
    L23:
        return r3;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        String r8 = this.$rawImagePath;
        String r4 = this.$bizTag;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L15
        OriginalImagePreloader r10 = OriginalImagePreloader.a;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r5 = OriginalImagePreloader.a(r10, r8, r4, this);     // Catch: Throwable -> L15
        if (r5 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
