package com.obric.assistant.interaction.impl.performance;

import android.os.Process;
import android.util.Log;
import com.larus.utils.logger.FLogger;
import com.larus.utils.q0;
import com.obric.assistant.common.utils.FunctionsKt;
import com.obric.assistant.reporter.IObricReporter;
import gd9.i;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/interaction/impl/performance/BinderPerformanceReporter;", "", "<init>", "()V", "TAG", "", "SCENE_BINDER", "STAGE_MAIN_THREAD_TRANSACT", "KEY_TRACE", "KEY_BINDER_CLASS", "KEY_TRANSACTION_CODE", "KEY_FLAGS", "KEY_PID", "KEY_TID", "KEY_PROCESS_NAME", "report", "", "costMs", "", "binderClass", "transactionCode", "", BinderPerformanceReporter.KEY_FLAGS, BinderPerformanceReporter.KEY_TRACE, "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BinderPerformanceReporter {
    public static final BinderPerformanceReporter INSTANCE = null;
    private static final String KEY_BINDER_CLASS = "binder_class";
    private static final String KEY_FLAGS = "flags";
    private static final String KEY_PID = "pid";
    private static final String KEY_PROCESS_NAME = "process_name";
    private static final String KEY_TID = "tid";
    private static final String KEY_TRACE = "trace";
    private static final String KEY_TRANSACTION_CODE = "transaction_code";
    private static final String SCENE_BINDER = "binder";
    private static final String STAGE_MAIN_THREAD_TRANSACT = "main_thread_transact";
    private static final String TAG = "BinderPerformanceReporter";

    static {
        INSTANCE = new BinderPerformanceReporter();
    }

    private BinderPerformanceReporter() {
    }

    public static /* synthetic */ Unit a(long r0, String r2, int r3, int r4, int r5, int r6, Throwable r7) {
        return report$lambda$0(r0, r2, r3, r4, r5, r6, r7);
    }

    @JvmStatic
    public static final void report(final long r10, final String r12, final int r13, final int r14, final Throwable r15) {
        Intrinsics.checkNotNullParameter(r12, "binderClass");
        Intrinsics.checkNotNullParameter(r15, KEY_TRACE);
        final int r7 = Process.myPid();
        final int r8 = Process.myTid();
        FunctionsKt.a(new a(r10, r12, r13, r14, r7, r8, r15));
    }

    private static final Unit report$lambda$0(long r15, String r17, int r18, int r19, int r20, int r21, Throwable r22) {
        i r1 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r1);
        String r2 = q0.b(r1.getApplication());
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        FLogger.a.w(TAG, "slow main-thread Binder transaction, costMs=" + r15 + ", binderClass=" + r17 + ", transactionCode=" + r18 + ", flags=" + r19 + ", pid=" + r20 + ", tid=" + r21 + ", processName=" + r2, r22);
        IObricReporter.a.getClass();
        IObricReporter r3 = IObricReporter.a.a();
        if (r3 == null) goto L9;
        r3.h(SCENE_BINDER, STAGE_MAIN_THREAD_TRANSACT, r15, false, MapsKt.mapOf(new Pair[]{TuplesKt.to(KEY_TRACE, Log.getStackTraceString(r22)), TuplesKt.to(KEY_BINDER_CLASS, r17), TuplesKt.to(KEY_TRANSACTION_CODE, String.valueOf(r18)), TuplesKt.to(KEY_FLAGS, String.valueOf(r19)), TuplesKt.to(KEY_PID, String.valueOf(r20)), TuplesKt.to(KEY_TID, String.valueOf(r21)), TuplesKt.to(KEY_PROCESS_NAME, r2)}));
    L9:
        return Unit.INSTANCE;
    }
}
