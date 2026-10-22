package com.larus.bmhome.music;

import com.larus.platform.service.k3;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class TTCNPAHelper {
    public static final TTCNPAHelper a = null;
    public static final MutexImpl b = null;
    public static CompletableDeferred<Unit> c;

    public TTCNPAHelper() {
    }

    static {
        a = new TTCNPAHelper();
        b = kotlinx.coroutines.sync.b.a();
    }

    public final Object a(Continuation<? super Unit> r11) {
        if ((r11 instanceof TTCNPAHelper$initTTCNPA$1) == false) goto L7;
        TTCNPAHelper$initTTCNPA$1 r0 = (TTCNPAHelper$initTTCNPA$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r12);
    L27:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L31:
        final Deferred r13 = c;     // Catch: Throwable -> L28
        if (r13 != null) goto L23;
        r13 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);     // Catch: Throwable -> L28
        c = r13;     // Catch: Throwable -> L28
        k3.a.a("001191110102MACQD9K64010000", "", new a(), new b(r13));     // Catch: Throwable -> L28
    L23:
        r4.unlock(null);
        r0.L$0 = null;
        r0.label = 2;
        if (r13.await(r0) != r2) goto L27;
        return r2;
    L28:
        th = move-exception;
        r4.unlock(null);
        throw th;
    L16:
        ResultKt.throwOnFailure(r12);
        r4 = b;
        r0.L$0 = r4;
        r0.label = 1;
        if (r4.a(null, r0) != r2) goto L31;
        return r2;
    L7:
        r0 = new TTCNPAHelper$initTTCNPA$1(this, r11);
        goto L8
    }
}
