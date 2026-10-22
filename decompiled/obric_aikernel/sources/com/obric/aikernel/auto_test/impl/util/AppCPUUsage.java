package com.obric.aikernel.auto_test.impl.util;

import android.os.Process;
import android.os.SystemClock;
import com.obric.aikernel.middleware.api.log.AIKLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes2.dex */
public final class AppCPUUsage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppCPUUsage f4473a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f4474b = null;

    static {
        f4473a = new AppCPUUsage();
        f4474b = LazyKt.lazy(AppCPUUsage$clockTicksPerSecond$2.INSTANCE);
    }

    private AppCPUUsage() {
    }

    public static final /* synthetic */ Object a(AppCPUUsage r10, List r11, long r12, Continuation r13) {
        return r10.g(r11, r12, r13);
    }

    public static /* synthetic */ Object c(AppCPUUsage r10, long r11, Continuation r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 300;
    L6:
        return r10.b(r11, r12);
    }

    private final List<Integer> d() {
        int r13 = Process.myUid();
        ArrayList r10 = new ArrayList();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L41
        File[] r12 = new File("/proc").listFiles();     // Catch: Throwable -> L41
        Unit r14 = null;
        if (r12 == null) goto L39;
        Intrinsics.checkNotNullExpressionValue(r12, "listFiles()");     // Catch: Throwable -> L41
        int r15 = r12.length;     // Catch: Throwable -> L41
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L38;
        File r17 = r12[r16];     // Catch: Throwable -> L41
        String r18 = r17.getName();     // Catch: Exception -> L47 Throwable -> L41
        Intrinsics.checkNotNullExpressionValue(r18, "pidDir.name");     // Catch: Exception -> L47 Throwable -> L41
        Integer r19 = StringsKt.toIntOrNull(r18);     // Catch: Exception -> L47 Throwable -> L41
        if (r19 == null) goto L37;
        int r20 = r19.intValue();     // Catch: Exception -> L47 Throwable -> L41
        File r21 = new File(r17, "status");     // Catch: Exception -> L47 Throwable -> L41
        if (r21.exists() == false) goto L37;
        Reader r110 = new InputStreamReader(new FileInputStream(r21), Charsets.UTF_8);     // Catch: Exception -> L47 Throwable -> L41
        if ((r110 instanceof BufferedReader) == false) goto L16;
        BufferedReader r111 = (BufferedReader) r110;     // Catch: Exception -> L47 Throwable -> L41
    L50:
        Iterator<String> r22 = TextStreamsKt.lineSequence(r111).iterator();     // Catch: Throwable -> L32
    L19:
        if (r22.hasNext() == false) goto L23;
        String r23 = r22.next();     // Catch: Throwable -> L32
        if (StringsKt.startsWith$default(r23, "Uid:", false, 2, null) == false) goto L19;
    L24:
        String r24 = r23;     // Catch: Throwable -> L32
        if (r24 != null) goto L27;
    L30:
        CloseableKt.closeFinally(r111, null);     // Catch: Exception -> L47 Throwable -> L41
        goto L37
    L27:
        if (Integer.parseInt(new Regex("\\s+").split(r24, 0).get(1)) != r13) goto L29;
        r10.add(Integer.valueOf(r20));     // Catch: Throwable -> L32
    L29:
        Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L32
        goto L30
    L23:
        r23 = null;
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        CloseableKt.closeFinally(r111, th);     // Catch: Exception -> L47 Throwable -> L41
        throw th;     // Catch: Exception -> L47 Throwable -> L41
    L16:
        r111 = new BufferedReader(r110, 8192);     // Catch: Exception -> L47 Throwable -> L41
    L37:
        r16 = r16 + 1;
        goto L6
    L38:
        r14 = Unit.INSTANCE;     // Catch: Throwable -> L41
    L39:
        Object r112 = Result.m32constructorimpl(r14);     // Catch: Throwable -> L41
    L43:
        Throwable r113 = Result.m35exceptionOrNullimpl(r112);
        if (r113 == null) goto L46;
        AIKLog.INSTANCE.w("ProcessCPUUsage", "getAppProcessIds failed: " + r113.getMessage());
    L46:
        return r10;
    L41:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r112 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L43
    }

    private final long e() {
        return ((Number) f4474b.getValue()).longValue();
    }

    private final long f(int r10) {
        String r11 = "";
        BufferedReader r12 = new BufferedReader(new FileReader("/proc/" + r10 + "/stat"));     // Catch: NumberFormatException -> L21 IOException -> L25
        String r13 = r12.readLine();     // Catch: Throwable -> L16
        if (r13 == null) goto L13;
        List r14 = StringsKt.split$default(r13, new String[]{" "}, false, 0, 6, null);     // Catch: Throwable -> L16
        if (r14.size() < 17) goto L13;
        long r15 = Long.parseLong((String) r14.get(13)) + Long.parseLong((String) r14.get(14));
        CloseableKt.closeFinally(r12, null);     // Catch: NumberFormatException -> L21 IOException -> L25
        return r15;
    L13:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r12, null);     // Catch: NumberFormatException -> L21 IOException -> L25
        return -1;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: NumberFormatException -> L21 IOException -> L25
        throw th;     // Catch: NumberFormatException -> L21 IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        AIKLog r17 = AIKLog.INSTANCE;
        String r18 = e.getMessage();
        if (r18 == null) goto L30;
    L29:
        r11 = r18;
    L30:
        r17.w("ProcessCPUUsage", r11);
        return -1;
    L21:
        e = move-exception;
        e.printStackTrace();
        r17 = AIKLog.INSTANCE;
        r18 = e.getMessage();
        if (r18 != null) goto L29;
        goto L29
    }

    private final Object g(List<Integer> r19, long r20, Continuation<? super Float> r22) {
        AppCPUUsage r10 = this;
        if ((r22 instanceof AppCPUUsage$getProcessCPUUsage$1) == false) goto L7;
        AppCPUUsage$getProcessCPUUsage$1 r11 = (AppCPUUsage$getProcessCPUUsage$1) r22;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        long r16 = r11.J$0;
        int r17 = r11.I$0;
        Ref.LongRef r18 = (Ref.LongRef) r11.L$2;
        List<Integer> r110 = (List) r11.L$1;
        AppCPUUsage r21 = (AppCPUUsage) r11.L$0;
        ResultKt.throwOnFailure(r13);
        int r23 = r17;
        r10 = r21;
        Ref.LongRef r24 = r18;
        List<Integer> r25 = r110;
    L26:
        long r111 = SystemClock.elapsedRealtime();
        long r112 = 0;
        Iterator<T> r26 = r25.iterator();
    L28:
        if (r26.hasNext() == false) goto L31;
        r112 = r112 + f4473a.f(((Number) r26.next()).intValue());
        goto L28
    L31:
        if (r112 != (-1)) goto L34;
        AIKLog.INSTANCE.d("ProcessCPUUsage", "read cpuTime2 failed");
        return Boxing.boxFloat(-1.0f);
    L34:
        long r113 = r10.e();
        if (r113 != (-1)) goto L39;
        AIKLog.INSTANCE.d("ProcessCPUUsage", "read hz failed");
        return Boxing.boxFloat(-1.0f);
    L39:
        return Boxing.boxFloat(RangesKt.coerceAtMost(((((r112 - r24.element) * 1.0f) / r113) * 1000) / ((r111 - r16) * ((long) r23)), 1.0f));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r23 = Runtime.getRuntime().availableProcessors();
        long r114 = SystemClock.elapsedRealtime();
        Ref.LongRef r27 = new Ref.LongRef();
        Iterator<T> r115 = r19.iterator();
    L16:
        if (r115.hasNext() == false) goto L19;
        r27.element += f4473a.f(((Number) r115.next()).intValue());
        goto L16
    L19:
        if (r27.element != (-1)) goto L22;
        AIKLog.INSTANCE.d("ProcessCPUUsage", "read cpuTime1 failed");
        return Boxing.boxFloat(-1.0f);
    L22:
        long r116 = RangesKt.coerceAtLeast(r20, 1);
        r11.L$0 = r10;
        r25 = r19;
        r11.L$1 = r25;
        r11.L$2 = r27;
        r11.I$0 = r23;
        r11.J$0 = r114;
        r11.label = 1;
        if (DelayKt.b(r116, r11) != r14) goto L25;
        return r14;
    L25:
        r24 = r27;
        r16 = r114;
    L7:
        r11 = new AppCPUUsage$getProcessCPUUsage$1(r10, r22);
        goto L8
    }

    public final Object b(long r10, Continuation<? super Float> r11) {
        List<Integer> r12 = d();
        AIKLog.INSTANCE.d("ProcessCPUUsage", "getAppCpuUsage: pidList = " + r12);
        return g(r12, r10, r11);
    }
}
