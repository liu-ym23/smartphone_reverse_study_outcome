package com.obric.aikernel.multiproc;

import android.app.ActivityManager;
import android.os.Bundle;
import android.os.Process;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.aikernel.runtime.RuntimeConfigBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f4707a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4708b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f4709c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f4710d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Void f4711e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map<String, AIInferRuntime.d.C0119d> f4712f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map<String, AIInferRuntime.d.C0119d> f4713g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Map<String, AIInferRuntime.d.C0119d> f4714h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f4715i;

    public static final class a implements AIInferRuntime.d.b {
        a() {
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.d.b
        public Bundle a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "proc");
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
            com.obric.aikernel.a r12 = com.obric.aikernel.a.AbstractBinderC0095a.U0(SubProcessManager.f4700a.b(AppContext.INSTANCE.getContext(), r10));     // Catch: Throwable -> L5
            Bundle r13 = new Bundle();     // Catch: Throwable -> L5
            r13.putString(IdlKeys.MethodName, IdlKeys.Method_QuerySubProc);     // Catch: Throwable -> L5
            Object r14 = Result.m32constructorimpl(r12.Z0(r13));     // Catch: Throwable -> L5
        L7:
            Throwable r15 = Result.m35exceptionOrNullimpl(r14);
            if (r15 == null) goto L11;
            AIKLog.INSTANCE.e("PythonRuntimeService", "getSubProcProxyInfo transact failed: " + r15);
        L11:
            if (Result.m38isFailureimpl(r14) == false) goto L13;
            r14 = null;
        L13:
            Bundle r16 = (Bundle) r14;
            if (r16 == null) goto L16;
            return r16;
        L16:
            return com.obric.aikernel.request.b.f4839c.a();
        L5:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r14 = Result.m32constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.d.b
        public boolean b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "proc");
            return SubProcessManager.f4700a.d(r10);
        }
    }

    public static final class b implements AIInferRuntime.d.a {
        b() {
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.d.a
        public Object a(Set<String> r10, Continuation<? super Unit> r11) {
            Iterator<T> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L16;
            String r13 = (String) r12.next();
            SubProcessManager r14 = SubProcessManager.f4700a;
            if (r14.d(r13) == false) goto L4;
            AIKLog.INSTANCE.i("PythonRuntimeService", "scheduleRestartProcess " + r13);
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L10
            com.obric.aikernel.a r16 = com.obric.aikernel.a.AbstractBinderC0095a.U0(r14.b(AppContext.INSTANCE.getContext(), r13));     // Catch: Throwable -> L10
            Bundle r17 = new Bundle();     // Catch: Throwable -> L10
            r17.putString(IdlKeys.MethodName, IdlKeys.Method_SubProcRestart);     // Catch: Throwable -> L10
            Object r18 = Result.m32constructorimpl(r16.Z0(r17));     // Catch: Throwable -> L10
        L12:
            Throwable r19 = Result.m35exceptionOrNullimpl(r18);
            if (r19 == null) goto L4;
            AIKLog.INSTANCE.e("PythonRuntimeService", "scheduleRestartProcess transact failed: " + r19);
        L10:
            th = move-exception;
            Result.Companion r20 = Result.Companion;
            r18 = Result.m32constructorimpl(ResultKt.createFailure(th));
            goto L12
        L16:
            return Unit.INSTANCE;
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.d.a
        public void b(Set<String> r12) {
            Intrinsics.checkNotNullParameter(r12, "procs");
            AIKLog.INSTANCE.w("PythonRuntimeService", "restart process " + CollectionsKt.joinToString$default(r12, null, null, null, 0, null, null, 63, null) + " by pushDebugDistribute");
            Object r11 = AppContext.INSTANCE.getContext().getSystemService("activity");
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.app.ActivityManager");
            List<ActivityManager.RunningAppProcessInfo> r13 = ((ActivityManager) r11).getRunningAppProcesses();
            if (r13 != null) goto L5;
            r13 = CollectionsKt.emptyList();
        L5:
            Iterator<T> r14 = r13.iterator();
        L7:
            if (r14.hasNext() == false) goto L17;
            ActivityManager.RunningAppProcessInfo r15 = (ActivityManager.RunningAppProcessInfo) r14.next();
            String r10 = r15.processName;
            int r16 = r15.pid;
            d r17 = d.f4707a;
            if (Intrinsics.areEqual(r10, r17.c()) == true) goto L18;
            if (Intrinsics.areEqual(r10, r17.d()) == false) goto L7;
        L18:
            Process.sendSignal(r16, 15);     // Catch: Exception -> L15
        L15:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        f4707a = new d();
        AppContext r10 = AppContext.INSTANCE;
        String r11 = r10.getPackageName();
        f4708b = r11;
        String r12 = r10.getPackageName() + ":infer";
        f4709c = r12;
        String r13 = r10.getPackageName() + ":llm";
        f4710d = r13;
        int r14 = 2;
        f4712f = MapsKt.mapOf(new Pair[]{TuplesKt.to(r11, new AIInferRuntime.d.C0119d(SetsKt.emptySet(), null, r14, 0 == true ? 1 : 0)), TuplesKt.to(r12, new AIInferRuntime.d.C0119d(0 == true ? 1 : 0, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0))});
        Map<String, AIInferRuntime.d.C0119d> r15 = MapsKt.mapOf(new Pair[]{TuplesKt.to(r11, new AIInferRuntime.d.C0119d(SetsKt.emptySet(), 0 == true ? 1 : 0, r14, 0 == true ? 1 : 0)), TuplesKt.to(r12, new AIInferRuntime.d.C0119d(0 == true ? 1 : 0, SetsKt.setOf("vlm_local"), 1, 0 == true ? 1 : 0)), TuplesKt.to(r13, new AIInferRuntime.d.C0119d(SetsKt.setOf("vlm_local"), 0 == true ? 1 : 0, r14, 0 == true ? 1 : 0))});
        f4713g = r15;
        f4714h = r15;
    }

    private d() {
    }

    public final void a(RuntimeConfigBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.t(f4714h);
        r10.D(new a());
        r10.x(new b());
    }

    public final Map<String, AIInferRuntime.d.C0119d> b() {
        return f4714h;
    }

    public final String c() {
        return f4709c;
    }

    public final String d() {
        return f4710d;
    }

    public final Void e() {
        return f4711e;
    }

    public final boolean f() {
        return f4715i;
    }

    public final void g(boolean r10) {
        f4715i = r10;
    }
}
