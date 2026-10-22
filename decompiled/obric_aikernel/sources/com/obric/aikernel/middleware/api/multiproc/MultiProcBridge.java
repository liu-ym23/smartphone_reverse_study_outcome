package com.obric.aikernel.middleware.api.multiproc;

import android.os.Bundle;
import com.bytedance.crash.event.EnsureReportData;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiProcBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MultiProcBridge f4548a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f4549b = null;

    static {
        f4548a = new MultiProcBridge();
        f4549b = LazyKt.lazy(MultiProcBridge$isMainProc$2.INSTANCE);
    }

    private MultiProcBridge() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(MultiProcBridge r10, String r11, String r12, Function0 r13, Function0 r14, Function1 r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L5;
        r15 = null;
    L5:
        r10.a(r11, r12, r13, r14, r15);
    }

    public final void a(String r10, String r11, Function0<Unit> r12, Function0<Bundle> r13, Function1<? super Bundle, Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "api");
        Intrinsics.checkNotNullParameter(r11, EnsureReportData.METHOD);
        Intrinsics.checkNotNullParameter(r12, "mainAct");
        Intrinsics.checkNotNullParameter(r13, "subProcAct");
        if (c() == false) goto L5;
        r12.invoke();
        return;
    L5:
        Bundle r15 = d(r10, r11, r13.invoke());
        if (r14 == null) goto L10;
        r14.invoke(r15);
        return;
    }

    public final boolean c() {
        return ((Boolean) f4549b.getValue()).booleanValue();
    }

    public final Bundle d(String r10, String r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "api");
        Intrinsics.checkNotNullParameter(r11, EnsureReportData.METHOD);
        Intrinsics.checkNotNullParameter(r12, "data");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L5
        Object r14 = Result.m32constructorimpl(AppContext.INSTANCE.getContext().getContentResolver().call("com.obric.aikernel.multiproc.main.handler", r10, r11, r12));     // Catch: Throwable -> L5
    L7:
        Throwable r15 = Result.m35exceptionOrNullimpl(r14);
        if (r15 == null) goto L11;
        AIKLog.INSTANCE.e("MultiProcBridge", "send failed " + r15);
    L11:
        if (Result.m38isFailureimpl(r14) == false) goto L14;
        r14 = null;
    L14:
        return (Bundle) r14;
    L5:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
