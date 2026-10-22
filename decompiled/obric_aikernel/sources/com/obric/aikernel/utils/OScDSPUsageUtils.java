package com.obric.aikernel.utils;

import android.util.Log;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes2.dex */
public final class OScDSPUsageUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OScDSPUsageUtils f5582a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static RandomAccessFile f5583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReference<v1> f5584c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f5585d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f5586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ReentrantLock f5587f = null;

    static {
        f5582a = new OScDSPUsageUtils();
        new ReentrantLock();
        Object r10 = null;
        f5584c = new AtomicReference(null);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.m32constructorimpl(new RandomAccessFile("/sys/qcom_sleep_stats/cdsp", "r"));     // Catch: Throwable -> L5
    L8:
        if (Result.m38isFailureimpl(r12) == true) goto L11;
        r10 = r12;
    L11:
        if (r10 == null) goto L13;
        boolean r13 = true;
    L14:
        f5585d = r13;
        f5587f = new ReentrantLock();
        return;
    L13:
        r13 = false;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private OScDSPUsageUtils() {
    }

    public static /* synthetic */ v1 a(v1 r10) {
        return i(r10);
    }

    public static final /* synthetic */ AtomicReference b() {
        return f5584c;
    }

    public static final /* synthetic */ long c(OScDSPUsageUtils r10) {
        return r10.f();
    }

    public static final /* synthetic */ void d(OScDSPUsageUtils r10) {
        r10.j();
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.String] */
    private final long f() {
        ReentrantLock r10 = f5587f;
        r10.lock();
        long r11 = -1;
    L35:
        th = move-exception;
        f5587f.unlock();
        throw th;
    L37:
        e = move-exception;
        Log.e("OScDSPUsageUtils", "Read file /sys/qcom_sleep_stats/cdsp failed", e);     // Catch: Throwable -> L35
    L9:
        f5587f.unlock();
        return r11;
    L4:
        if (f5583b == null) goto L45;
    L11:
        RandomAccessFile r12 = f5583b;     // Catch: Throwable -> L35 Exception -> L37
        if (r12 != null) goto L16;
        r10.unlock();
        return -1;
    L16:
        r12.seek(0);     // Catch: Throwable -> L35 Exception -> L37
        r12.getChannel().position(0);     // Catch: Throwable -> L35 Exception -> L37
        Ref.ObjectRef r13 = new Ref.ObjectRef();     // Catch: Throwable -> L35 Exception -> L37
    L17:
        ?? r14 = r12.readLine();     // Catch: Throwable -> L35 Exception -> L37
        r13.element = r14;     // Catch: Throwable -> L35 Exception -> L37
        if (r14 == 0) goto L31;
        String r15 = (String) r14;     // Catch: Throwable -> L35 Exception -> L37
        if (r15 == null) goto L17;
        if (StringsKt.startsWith$default(StringsKt.trim(r15).toString(), "Accumulated Duration", false, 2, null) == false) goto L17;
        List<String> r16 = new Regex("=").split(r15, 2);     // Catch: Throwable -> L35 Exception -> L37
        if (r16.size() != 2) goto L17;
        String r17 = StringsKt.trim(r16.get(1)).toString();     // Catch: Throwable -> L35 Exception -> L37
        long r18 = Long.parseLong(r17) / ((long) 19200);     // Catch: NumberFormatException -> L29 Throwable -> L35 Exception -> L37
    L33:
        if (r18 == (-1)) goto L9;
        r11 = r18;
    L29:
        e = move-exception;
        Log.e("OScDSPUsageUtils", "Invalid number format: " + r17, e);     // Catch: Throwable -> L35 Exception -> L37
    L31:
        r18 = -1;
        goto L33
    L45:
        f5583b = new RandomAccessFile("/sys/qcom_sleep_stats/cdsp", "r");     // Catch: Throwable -> L35 Exception -> L37
    L7:
        e = move-exception;
        Log.e("OScDSPUsageUtils", "Open file /sys/qcom_sleep_stats/cdsp failed", e);     // Catch: Throwable -> L35 Exception -> L37
        goto L9
    }

    private final void h() {
        f5584c.getAndUpdate(l.f5602a);
        Log.d("OScDSPUsageUtils", "Track job started");
    }

    private static final v1 i(v1 r10) {
        if (r10 == null) goto L6;
        v1.a.a(r10, null, 1, null);
    L6:
        return kotlinx.coroutines.h.d(c.f5588a.a(), null, null, new OScDSPUsageUtils$startTrackJob$1$1(null), 3, null);
    }

    private final void j() {
        kotlinx.coroutines.h.d(c.f5588a.a(), null, null, new OScDSPUsageUtils$trackAccumulatedDuration$1(null), 3, null);
    }

    public final long e() {
        return f5586e;
    }

    public final synchronized void g(long r10) {
        monitor-enter(this);
        f5586e = r10;     // Catch: Throwable -> L14
        if (f5585d == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        v1 r11 = f5584c.get();     // Catch: Throwable -> L14
        if (r11 != null) goto L10;
    L11:
        h();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L10:
        if (r11.isActive() == true) goto L12;
    L14:
        th = move-exception;
        throw th;
    }
}
