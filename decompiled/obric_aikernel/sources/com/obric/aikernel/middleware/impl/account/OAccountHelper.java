package com.obric.aikernel.middleware.impl.account;

import a9.d;
import android.app.Application;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class OAccountHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OAccountHelper f4551a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f4552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f4553c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final l0 f4554d = null;

    static {
        f4551a = new OAccountHelper();
        f4553c = new AtomicBoolean(false);
        f4554d = m0.a(z0.b());
    }

    private OAccountHelper() {
    }

    public static final /* synthetic */ AtomicBoolean a() {
        return f4553c;
    }

    public static final /* synthetic */ boolean b(OAccountHelper r10, Application r11, d r12, a9.a r13) {
        return r10.g(r11, r12, r13);
    }

    public static final /* synthetic */ boolean c() {
        return f4552b;
    }

    public static final /* synthetic */ void d(boolean r10) {
        f4552b = r10;
    }

    public static final /* synthetic */ boolean e(OAccountHelper r10, int r11) {
        return r10.i(r11);
    }

    private final boolean g(Application r10, d r11, a9.a r12) {
        AIKLog.INSTANCE.d("OAccountHelper", "init start");
        Ref.BooleanRef r13 = new Ref.BooleanRef();
        long r14 = System.currentTimeMillis();
        Boolean r15 = Boolean.FALSE;
        OAccountHelper$initOnce$usedTimeMs$1$1 r16 = OAccountHelper$initOnce$usedTimeMs$1$1.INSTANCE;
        OAccount.f5801a.n(r10, r11, r12);     // Catch: RuntimeException -> L5
        r15 = Boolean.TRUE;     // Catch: RuntimeException -> L5
    L10:
        r13.element = r15.booleanValue();
        long r17 = System.currentTimeMillis() - r14;
        AIKLog.INSTANCE.d("OAccountHelper", "init finished. success=" + r13.element + " used time " + r17 + " ms");
        return r13.element;
    L5:
        e = move-exception;
        if (com.obric.aikernel.runtime.utils.a.a(e) == false) goto L12;
        if (r16 == null) goto L10;
        r16.invoke(e);
        goto L10
    L12:
        throw e;
    }

    private final boolean i(int r10) {
        if (r10 >= 10) goto L5;
        return true;
    L5:
        return false;
    }

    public final void f(Application r10, d r11, a9.a r12) {
        Intrinsics.checkNotNullParameter(r10, "application");
        Intrinsics.checkNotNullParameter(r11, "logger");
        Intrinsics.checkNotNullParameter(r12, "bridge");
        if (f4552b == false) goto L5;
        return;
    L5:
        if (f4553c.compareAndSet(false, true) == false) goto L10;
        h.d(f4554d, null, null, new OAccountHelper$init$1(r10, r11, r12, null), 3, null);
        return;
    }

    public final boolean h() {
        return f4552b;
    }
}
