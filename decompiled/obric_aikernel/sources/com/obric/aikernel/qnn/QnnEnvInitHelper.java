package com.obric.aikernel.qnn;

import android.content.SharedPreferences;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.utils.JniUtils;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class QnnEnvInitHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final QnnEnvInitHelper f4829a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4830b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f4831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static v1 f4832d;

    static {
        f4829a = new QnnEnvInitHelper();
        f4830b = new File(AppContext.INSTANCE.getContext().getFilesDir(), "hexagon").getAbsolutePath();
        f4831c = new AtomicBoolean(false);
    }

    private QnnEnvInitHelper() {
    }

    public final v1 a() {
        AtomicBoolean r10 = f4831c;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f4831c.get() == false) goto L7;
    L10:
        v1 r11 = f4832d;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r10);
        return r11;
    L7:
        if (f4832d != null) goto L10;
        r11 = h.d(n1.f10613c, z0.b(), null, new QnnEnvInitHelper$init$1$1(null), 2, null);     // Catch: Throwable -> L13
        f4832d = r11;     // Catch: Throwable -> L13
        goto L11
    }

    public final void b() {
        SharedPreferences r10 = AppContext.INSTANCE.getContext().getSharedPreferences("qnn_env", 0);
        if (Intrinsics.areEqual(r10.getString("HEXAGON_LIB_VER", ""), "4") == true) goto L18;
        AIKLog.INSTANCE.d("QnnEnvInitHelper", "extractHexagonLib");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L7
        a r12 = a.f4833a;     // Catch: Throwable -> L7
        String r13 = f4830b;     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r13, "SD_LIBRARY_PATH");     // Catch: Throwable -> L7
        r12.b(r13);     // Catch: Throwable -> L7
        Object r14 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L10:
        if (Result.m39isSuccessimpl(r14) == false) goto L12;
        Unit r15 = (Unit) r14;
        AIKLog.INSTANCE.w("QnnEnvInitHelper", "extractHexagonLib succeed");
        r10.edit().putString("HEXAGON_LIB_VER", "4").apply();
    L12:
        Throwable r16 = Result.m35exceptionOrNullimpl(r14);
        if (r16 == null) goto L19;
        AIKLog.INSTANCE.w("QnnEnvInitHelper", "extractHexagonLib failed: " + r16.getMessage(), r16);
        return;
    L19:
        return;
    L7:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r14 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void c() {
        AIKLog r10 = AIKLog.INSTANCE;
        StringBuilder r11 = new StringBuilder();
        r11.append("DSP_LIBRARY_PATH = ");
        String r12 = f4830b;
        r11.append(r12);
        r10.d("QnnEnvInitHelper", r11.toString());
        String r13 = System.getenv("DSP_LIBRARY_PATH");
        r10.d("QnnEnvInitHelper", "GET  = " + r13);
        if (r13 != null) goto L5;
    L8:
        boolean r14 = true;
    L9:
        if (r14 == false) goto L11;
        JniUtils r15 = JniUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r12, "SD_LIBRARY_PATH");
        r15.setEnv("DSP_LIBRARY_PATH", r12);
    L12:
        r10.d("QnnEnvInitHelper", "GET after = " + System.getenv("DSP_LIBRARY_PATH"));
        return;
    L11:
        JniUtils.INSTANCE.setEnv("DSP_LIBRARY_PATH", r13 + ';' + r12);
        goto L12
    L5:
        if (r13.length() == 0) goto L8;
        r14 = false;
        goto L9
    }

    public final void d() {
        b();     // Catch: Exception -> L11
        c();     // Catch: Exception -> L11
        AtomicBoolean r10 = f4831c;     // Catch: Exception -> L11
        monitor-enter(r10);     // Catch: Exception -> L11
        f4832d = null;     // Catch: Throwable -> L8
        f4831c.set(true);     // Catch: Throwable -> L8
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Exception -> L11
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Exception -> L11
    L11:
        e = move-exception;
        AIKLog.INSTANCE.e("QnnEnvInitHelper", "initRun failed", e);
        monitor-enter(f4831c);
        f4832d = null;     // Catch: Throwable -> L17
        f4831c.set(false);     // Catch: Throwable -> L17
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public final Object e(Continuation<? super Unit> r10) {
        if ((r10 instanceof QnnEnvInitHelper$waitInit$1) == false) goto L7;
        QnnEnvInitHelper$waitInit$1 r11 = (QnnEnvInitHelper$waitInit$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L19:
        AIKLog.INSTANCE.d("QnnEnvInitHelper", "waitForInit finish");
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        AIKLog.INSTANCE.d("QnnEnvInitHelper", "waitForInit start");
        v1 r16 = a();
        if (r16 == null) goto L19;
        r11.label = 1;
        if (r16.l(r11) != r14) goto L19;
        return r14;
    L7:
        r11 = new QnnEnvInitHelper$waitInit$1(this, r10);
        goto L8
    }
}
