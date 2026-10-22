package com.obric.assistant.omnidetailpage.localmedia;

import android.os.Process;
import com.larus.utils.logger.FLogger;
import com.obric.capabilitykit.common.ErrorCode;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.localmedia.OmniDetailInputFileCache$scheduleCleanupIfNeeded$1", f = "OmniDetailInputFileCache.kt", i = {}, l = {ErrorCode.PARAMETER_ERROR}, m = "invokeSuspend", n = {}, s = {})
public final class OmniDetailInputFileCache$scheduleCleanupIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public OmniDetailInputFileCache$scheduleCleanupIfNeeded$1(Continuation<? super OmniDetailInputFileCache$scheduleCleanupIfNeeded$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new OmniDetailInputFileCache$scheduleCleanupIfNeeded$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = this.label;
        boolean r6 = true;
        if (r4 == 0) goto L9;
        if (r4 != 1) goto L8;
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L57
    L13:
        OmniDetailInputFileCache r1 = OmniDetailInputFileCache.a;     // Catch: Throwable -> L57
        int r5 = Process.myTid();     // Catch: Throwable -> L57
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        Object r3 = Result.constructor-impl(Boxing.boxInt(Process.getThreadPriority(r5)));     // Catch: Throwable -> L16
    L18:
        Integer r9 = null;
        if (Result.isFailure-impl(r3) == false) goto L21;
        r3 = null;
    L21:
        Integer r8 = (Integer) r3;     // Catch: Throwable -> L57
        Process.setThreadPriority(10);     // Catch: Throwable -> L25
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L64:
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L47
        OmniDetailInputFileCache r7 = OmniDetailInputFileCache.a;     // Catch: Throwable -> L47
        r7.getClass();     // Catch: Throwable -> L47
        long r15 = OmniDetailInputFileCache.d().getLong("__o_omni_detail_page_file_cache_last_cleanup_started_at", 0);     // Catch: Throwable -> L47
        if (r15 > 0) goto L30;
    L35:
        if (r6 == true) goto L37;
        OmniDetailInputFileCache.e = r15 + 432000000;     // Catch: Throwable -> L47
    L38:
        if (r8 != null) goto L74;
    L45:
        if (r9 == null) goto L59;
        FLogger.a.i("OmniDetailInputFileCache", "cleanup finished, cleanedCount=" + r9);     // Catch: Throwable -> L57
    L59:
        OmniDetailInputFileCache.d.set(false);
        return Unit.INSTANCE;
    L74:
        Process.setThreadPriority(r5, r8.intValue());     // Catch: Throwable -> L42
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L42
    L44:
        Result.box-impl(r11);     // Catch: Throwable -> L57
        goto L45
    L42:
        th = move-exception;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L57
        r11 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L44
    L37:
        OmniDetailInputFileCache.d().storeLong("__o_omni_detail_page_file_cache_last_cleanup_started_at", r10);     // Catch: Throwable -> L47
        OmniDetailInputFileCache.e = r10 + 432000000;     // Catch: Throwable -> L47
        r9 = Boxing.boxInt(OmniDetailInputFileCache.a(r7));     // Catch: Throwable -> L47
        goto L38
    L30:
        if (r10 < r15) goto L35;
        if ((r10 - r15) >= 432000000) goto L35;
        r6 = false;
    L47:
        th = move-exception;
        if (r8 == null) goto L76;
        int r13 = r8.intValue();     // Catch: Throwable -> L57
        OmniDetailInputFileCache r14 = OmniDetailInputFileCache.a;     // Catch: Throwable -> L57
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L53
        Process.setThreadPriority(r5, r13);     // Catch: Throwable -> L53
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L53
    L55:
        Result.box-impl(r17);     // Catch: Throwable -> L57
        throw th;     // Catch: Throwable -> L57
    L53:
        th = move-exception;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L57
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L55
    L76:
        throw th;     // Catch: Throwable -> L57
    L25:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L57
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L64
    L16:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L57
        r3 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L18
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r20);
        this.label = 1;     // Catch: Throwable -> L57
        if (DelayKt.delay(5000, this) != r0) goto L13;
        return r0;
    L57:
        th = move-exception;
        FLogger.a.e("OmniDetailInputFileCache", "cleanup failed", th);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        OmniDetailInputFileCache.d.set(false);
        throw th;
    }
}
