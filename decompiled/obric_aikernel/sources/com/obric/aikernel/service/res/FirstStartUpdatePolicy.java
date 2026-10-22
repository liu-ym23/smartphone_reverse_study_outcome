package com.obric.aikernel.service.res;

import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.res.update.UpdateResult;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class FirstStartUpdatePolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PythonRuntimeService f5464a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public FirstStartUpdatePolicy(PythonRuntimeService r10) {
        Intrinsics.checkNotNullParameter(r10, "service");
        this.f5464a = r10;
    }

    public static final /* synthetic */ Object a(FirstStartUpdatePolicy r10, Continuation r11) {
        return r10.b(r11);
    }

    private final Object b(Continuation<? super Unit> r15) {
        if ((r15 instanceof FirstStartUpdatePolicy$doUpdate$1) == false) goto L7;
        FirstStartUpdatePolicy$doUpdate$1 r10 = (FirstStartUpdatePolicy$doUpdate$1) r15;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r16 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r10.label;
        Object r14 = null;
        if (r13 == 0) goto L19;
        if (r13 == 1) goto L16;
        if (r13 != 2) goto L15;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L32
    L28:
        Object r17 = ((Map) r16).values();     // Catch: Throwable -> L32
    L30:
        Object r18 = Result.m32constructorimpl(r17);     // Catch: Throwable -> L32
    L35:
        if (Result.m39isSuccessimpl(r18) == false) goto L46;
        Collection r19 = (Collection) r18;
        Iterator r110 = r19.iterator();
    L38:
        if (r110.hasNext() == false) goto L42;
        Object r20 = r110.next();
        if ((!((UpdateResult) r20).getSuccess()) == false) goto L38;
        r14 = r20;
    L42:
        AIKLog r111 = AIKLog.INSTANCE;
        if (r14 != null) goto L45;
        r111.i("FirstStartUpdatePolicy", "doUpdate succeed");
        goto L46
    L45:
        r111.w("FirstStartUpdatePolicy", "doUpdate have task failed, status: " + CollectionsKt.joinToString$default(r19, null, null, null, 0, null, FirstStartUpdatePolicy$doUpdate$3$2.INSTANCE, 31, null));
    L46:
        Throwable r112 = Result.m35exceptionOrNullimpl(r18);
        if (r112 == null) goto L50;
        AIKLog.INSTANCE.e("FirstStartUpdatePolicy", "doUpdate error: " + ExceptionsKt.stackTraceToString(r112));
    L50:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        FirstStartUpdatePolicy this = (FirstStartUpdatePolicy) r10.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L32
    L24:
        if (h.a(this.f5464a.T()) == false) goto L29;
        PythonRuntimeService r21 = this.f5464a;     // Catch: Throwable -> L32
        r10.L$0 = null;     // Catch: Throwable -> L32
        r10.label = 2;     // Catch: Throwable -> L32
        r16 = PythonRuntimeService.Q(r21, ":init", false, r10, 2, null);     // Catch: Throwable -> L32
        if (r16 != r12) goto L28;
        return r12;
    L29:
        AIKLog.INSTANCE.i("FirstStartUpdatePolicy", "skip startup updateAll because useObricDownloader=false");     // Catch: Throwable -> L32
        r17 = CollectionsKt.emptyList();     // Catch: Throwable -> L32
        goto L30
    L19:
        ResultKt.throwOnFailure(r16);
        AIKLog.INSTANCE.d("FirstStartUpdatePolicy", "start doUpdate");
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L32
        PythonRuntimeService r22 = this.f5464a;     // Catch: Throwable -> L32
        r10.L$0 = this;     // Catch: Throwable -> L32
        r10.label = 1;     // Catch: Throwable -> L32
        if (PythonRuntimeService.S(r22, "aik_app", ":init", false, null, r10, 12, null) != r12) goto L24;
        return r12;
    L32:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r18 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L7:
        r10 = new FirstStartUpdatePolicy$doUpdate$1(this, r15);
        goto L8
    }

    public final void c() {
        kotlinx.coroutines.h.d(m0.a(z0.b()), null, null, new FirstStartUpdatePolicy$start$1(this, null), 3, null);
    }
}
