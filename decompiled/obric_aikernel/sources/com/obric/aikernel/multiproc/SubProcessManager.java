package com.obric.aikernel.multiproc;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
public final class SubProcessManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SubProcessManager f4700a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, a> f4701b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, Lazy<Boolean>> f4702c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f4703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f4704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f4705c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private volatile IBinder f4706d;

        public a(Context r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "proc");
            Intrinsics.checkNotNullParameter(r12, "auth");
            this.f4703a = r10;
            this.f4704b = r11;
            this.f4705c = r12;
        }

        public final IBinder a() {
            IBinder r10 = this.f4706d;
            Unit r11 = null;
            if (r10 != null) goto L5;
        L7:
            r10 = null;
        L8:
            if (r10 == null) goto L10;
            return r10;
        L10:
            KClass r12 = Reflection.getOrCreateKotlinClass(SubProcessManager.class);
            monitor-enter(r12);
            IBinder r13 = this.f4706d;     // Catch: Throwable -> L36
            boolean r14 = true;
            if (r13 != null) goto L15;
        L17:
            r14 = false;
        L18:
            if (r14 == false) goto L41;
        L33:
            monitor-exit(r12);
            return this.f4706d;
        L41:
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L27
            Bundle r16 = this.f4703a.getContentResolver().call(this.f4705c, IdlKeys.Method_QuerySubProc, null, null);     // Catch: Throwable -> L27
            if (r16 == null) goto L25;
            IBinder r17 = r16.getBinder(IdlKeys.Args_InferBinder);     // Catch: Throwable -> L27
            if (r17 == null) goto L25;
            this.f4706d = r17;     // Catch: Throwable -> L27
            r11 = Unit.INSTANCE;     // Catch: Throwable -> L27
        L25:
            Object r18 = Result.m32constructorimpl(r11);     // Catch: Throwable -> L27
        L29:
            Throwable r19 = Result.m35exceptionOrNullimpl(r18);     // Catch: Throwable -> L36
            if (r19 == null) goto L32;
            AIKLog.INSTANCE.w("SubProcessManager", "connect " + this.f4704b + " failed by " + r19);     // Catch: Throwable -> L36
        L32:
            Result.m31boximpl(r18);     // Catch: Throwable -> L36
            goto L33
        L27:
            th = move-exception;
            Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L36
            r18 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L36
            goto L29
        L15:
            if (r13.pingBinder() != true) goto L17;
        L36:
            th = move-exception;
            throw th;
        L5:
            if (r10.pingBinder() == false) goto L7;
            goto L7
        }

        public final boolean b() {
            IBinder r10 = this.f4706d;
            if (r10 == null) goto L8;
            if (r10.isBinderAlive() != true) goto L8;
            return true;
        L8:
            return false;
        }
    }

    static {
        f4700a = new SubProcessManager();
        f4701b = new ConcurrentHashMap();
        f4702c = new ConcurrentHashMap();
    }

    private SubProcessManager() {
    }

    public static final /* synthetic */ boolean a(SubProcessManager r10, String r11) {
        return r10.e(r11);
    }

    private final String c(String r10) {
        if (Intrinsics.areEqual(r10, AppContext.INSTANCE.getPackageName() + ":llm") == false) goto L5;
        return "aikernel.inner.infer.llm";
    L5:
        return "aikernel.inner.infer.general";
    }

    private final boolean e(String r10) {
        Object r11 = AppContext.INSTANCE.getContext().getSystemService("activity");
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> r12 = ((ActivityManager) r11).getRunningAppProcesses();
        Intrinsics.checkNotNullExpressionValue(r12, "AppContext.getContext().…ager).runningAppProcesses");
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((ActivityManager.RunningAppProcessInfo) r13.next()).processName, r10) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final IBinder b(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "proc");
    L3:
        Map<String, a> r12 = f4701b;
        a r13 = r12.get(r11);
        if (r13 != null) goto L15;
        monitor-enter(this);
        a r14 = r12.get(r11);     // Catch: Throwable -> L12
        if (r14 != null) goto L9;
        AIKLog.INSTANCE.v("SubProcessManager", "connect " + r11 + " new connect task");     // Catch: Throwable -> L12
        r14 = new a(r10, r11, f4700a.c(r11));     // Catch: Throwable -> L12
        r12.put(r11, r14);     // Catch: Throwable -> L12
    L9:
        r13 = r14;     // Catch: Throwable -> L12
        monitor-exit(this);
    L12:
        th = move-exception;
        throw th;
    L15:
        IBinder r15 = r13.a();
        if (r15 == null) goto L3;
        return r15;
    }

    public final boolean d(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "proc");
        Map<String, a> r11 = f4701b;
        a r12 = r11.get(r10);
        if (r12 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L10;
        return true;
    L10:
        if (r11.containsKey(r10) == true) goto L15;
        Map<String, Lazy<Boolean>> r14 = f4702c;
        Lazy<Boolean> r15 = r14.get(r10);
        if (r15 != null) goto L14;
        r15 = LazyKt.lazy(new SubProcessManager$isAlive$1$1(r10));
        r14.put(r10, r15);
    L14:
        boolean r16 = r15.getValue().booleanValue();
    L16:
        if (r16 == false) goto L19;
        return true;
    L19:
        return false;
    L15:
        r16 = false;
        goto L16
    L5:
        if (r12.b() != true) goto L7;
        r13 = true;
        goto L8
    }

    public final void f() {
        b(AppContext.INSTANCE.getContext(), d.f4707a.c());
    }
}
