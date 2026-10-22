package com.larus.security.api;

import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
final /* synthetic */ class TTCNPAHelper$initIfNeeded$2$3 extends FunctionReferenceImpl implements Function0<Unit> {
    public TTCNPAHelper$initIfNeeded$2$3(Object r8) {
        super(0, r8, TTCNPAHelper.class, "resumeInitSuccess", "resumeInitSuccess()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m70invoke() {
        TTCNPAHelper r0 = (TTCNPAHelper) ((CallableReference) this).receiver;
        TTCNPAHelper r1 = TTCNPAHelper.a;
        monitor-enter(r0);
        TTCNPAHelper.c = true;     // Catch: Throwable -> L14
        List<kotlinx.coroutines.i<Unit>> r2 = TTCNPAHelper.d;     // Catch: Throwable -> L14
        List r3 = CollectionsKt.toList(r2);     // Catch: Throwable -> L14
        ((ArrayList) r2).clear();     // Catch: Throwable -> L14
        monitor-exit(r0);
        Iterator r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        kotlinx.coroutines.i r5 = (kotlinx.coroutines.i) r4.next();
        if (r5.isActive() == false) goto L9;
        Result.Companion r6 = Result.Companion;
        r5.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        goto L9
    L13:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m70invoke();
        return Unit.INSTANCE;
    }
}
