package com.larus.uaigc.createpage.component.helper;

import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.helper.AlbumHelperKt$launchSafely$1", f = "AlbumHelper.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
public final class AlbumHelperKt$launchSafely$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    public AlbumHelperKt$launchSafely$1(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super AlbumHelperKt$launchSafely$1> r2) {
        this.$block = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        AlbumHelperKt$launchSafely$1 r0 = new AlbumHelperKt$launchSafely$1(this.$block, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L15
    L13:
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L21;
        FLogger.a.e("AlbumHelper", "[launchSafely] failed, cause=".concat(r7.getClass().getSimpleName()));
        g.a.ensureNotReachHere(r7);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        Function2<CoroutineScope, Continuation<? super Unit>, Object> r2 = this.$block;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (r2.invoke(r8, this) != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
