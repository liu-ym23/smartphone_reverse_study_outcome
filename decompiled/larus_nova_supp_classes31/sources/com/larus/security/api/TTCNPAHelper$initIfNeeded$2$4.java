package com.larus.security.api;

import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
final /* synthetic */ class TTCNPAHelper$initIfNeeded$2$4 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    public TTCNPAHelper$initIfNeeded$2$4(Object r8) {
        super(1, r8, TTCNPAHelper.class, "resumeInitFailure", "resumeInitFailure(Ljava/lang/Throwable;)V", 0);
    }

    public final void invoke(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        TTCNPAHelper r0 = (TTCNPAHelper) ((CallableReference) this).receiver;
        TTCNPAHelper r1 = TTCNPAHelper.a;
        monitor-enter(r0);
        TTCNPAHelper.b = false;     // Catch: Throwable -> L14
        TTCNPAHelper.c = false;     // Catch: Throwable -> L14
        List<kotlinx.coroutines.i<Unit>> r2 = TTCNPAHelper.d;     // Catch: Throwable -> L14
        List r3 = CollectionsKt.toList(r2);     // Catch: Throwable -> L14
        ((ArrayList) r2).clear();     // Catch: Throwable -> L14
        monitor-exit(r0);
        Iterator r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        kotlinx.coroutines.i r6 = (kotlinx.coroutines.i) r5.next();
        if (r6.isActive() == false) goto L9;
        Result.Companion r7 = Result.Companion;
        r6.resumeWith(Result.constructor-impl(ResultKt.createFailure(r4)));
        goto L9
    L13:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Throwable) r1);
        return Unit.INSTANCE;
    }
}
