package com.larus.dora.impl.log.g;

import android.app.Application;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.log.GLogType;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.util.s0;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import t19.s;
import t39.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraGLogManager extends s0 {
    public static final DoraGLogManager a = null;
    public static int b;
    public static GLogType c;
    public static long d;
    public static final AtomicLong e = null;
    public static byte f;
    public static long g;
    public static String h;
    public static PolarisFileWrapper i;
    public static final AtomicBoolean j = null;
    public static v k;
    public static final ScheduledExecutorService l = null;
    public static ScheduledFuture<?> m;
    public static final Lazy n = null;

    public static final class a implements v {
        public a() {
        }

        @Override // t39.v
        public final void a(boolean r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "msg");
            g49.d.d("DoraGLogManager", "upload log result success:" + r3 + " msg:" + r4);
            if (r3 == false) goto L5;
            s r5 = s.a;
            Application r6 = AppHost.a.getApplication();
            r5.getClass();
            s.p(r6, "upload log success");
            return;
        L5:
            s r7 = s.a;
            Application r8 = AppHost.a.getApplication();
            r7.getClass();
            s.c(r8, "upload log failed");
        }
    }

    static {
        a = new DoraGLogManager();
        c = GLogType.SYSLOG;
        e = new AtomicLong(0);
        h = "";
        j = new AtomicBoolean(false);
        l = PThreadExecutorsUtils.newScheduledThreadPool(1, new DefaultThreadFactory("DoraGLogManager"));
        n = LazyKt.lazy(new b());
    }

    public static long l() {
        return e.get();
    }

    public final String o() {
        return AppHost.a.getApplication().getApplicationContext().getFilesDir() + "/DoraSDK/DoraGLog/";
    }

    public final void s() {
        h = "";
        d = 0;
        e.set(0);
        g = 0;
        i = null;
        t(c, l());
        u(c, d);
    }

    public static String m() {
        DoraDevice r0 = kj4.a.g().c();
        if (r0 == null) goto L6;
        String r1 = r0.sn;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public DoraGLogManager() {
    }

    public final void v(boolean r2) {
        j.set(r2);
    }

    public final void k(GLogType r4, byte r5) {
        String r0 = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
        String r6 = r4.getType();
        if (r5 != 0) goto L6;
    L11:
        String r7 = ".txt";
    L12:
        StringBuilder r1 = new StringBuilder();
        r1.append(o());
        r1.append("DoraGLog_");
        r1.append(r0);
        r1.append('_');
        r1.append(m());
        r1.append('_');
        DoraDevice r2 = kj4.a.g().c();
        if (r2 == null) goto L16;
        String r3 = r2.hwVersion;
        if (r3 == null) goto L16;
    L17:
        r1.append(r3);
        r1.append('_');
        r1.append(r6);
        r1.append(r7);
        h = r1.toString();
        PolarisFileWrapper r8 = new PolarisFileWrapper(h);
        i = r8;
        if (r8.exists() == false) goto L20;
        return;
    L20:
        if (r8.createNewFile() == true) goto L24;
        g49.d.b("DoraGLogManager", "create log file " + h + " failed");
        return;
    L24:
        return;
    L16:
        r3 = "";
        goto L17
    L6:
        if (r5 != 1) goto L9;
        r7 = ".lzf";
        goto L12
    L9:
        if (r5 != 2) goto L11;
        r7 = ".log";
        goto L12
    }

    public final void r(boolean r3, String r4) {
        g49.d.d("DoraGLogManager", "notifyUploadGLogResult result:" + r3 + " msg:" + r4);
        v r0 = k;
        if (r0 == null) goto L6;
        r0.a(r3, r4);
        return;
    }

    public final void t(GLogType r4, long r5) {
        ((Keva) n.getValue()).storeLong(m() + "_log_offset_" + r4, r5);
    }

    public final void u(GLogType r4, long r5) {
        ((Keva) n.getValue()).storeLong(m() + "_log_size_" + r4.getType(), r5);
    }

    public final void q(boolean r3, GLogType r4, String r5) {
        g49.d.d("DoraGLogManager", "notifyGetGLogsResult result:" + r3 + " msg:" + r5 + " curLogType:" + r4);
        v(false);
    }

    public static void n(GLogType r14, long r15, long r17, long r110) {
        g49.d.d("DoraGLogManager", "getLogData type " + r14 + ", offset " + r15 + ", size " + r17 + ", count " + r110);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraGLogManager$getLogData$1(r14, r15, r17, r110, null), 3, null);
    }

    public static void p(byte r2, long r3, long r5, long r7) {
        g49.d.d("DoraGLogManager", "notifyGetGLogProgress type:" + r2 + " curOffset:" + r3 + " totalSize:" + r5 + ", duration:" + r7);
    }

    public final void g(int r13, byte r14, int r15, byte r16) {
        g49.d.d("DoraGLogManager", "onGetGLogInfo nid:" + r13 + " logType:" + r14 + " size:" + r15 + " logFormat:" + r16);
        if (r15 < 0) goto L5;
        b = 0;
        ScheduledFuture<?> r5 = m;
        if (r5 == null) goto L19;
        r5.cancel(true);
    L19:
        GLogType.Companion.getClass();
        GLogType[] r6 = GLogType.values();
        int r7 = r6.length;
        int r8 = 0;
    L21:
        if (r8 >= r7) goto L29;
        GLogType r10 = r6[r8];
        if (r10.getId() != r14) goto L25;
        boolean r11 = true;
    L26:
        if (r11 == true) goto L30;
        r8 = r8 + 1;
    L30:
        if (r10 != null) goto L32;
        return;
    L32:
        c = r10;
        long r1 = r15;
        d = r1;
        f = r16;
        u(r10, r1);
        k(c, r16);
        n(c, l(), 768, 16);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraGLogManager$onGetGLogInfo$1(null), 3, null);
        return;
    L25:
        r11 = false;
        goto L26
    L29:
        r10 = null;
        goto L30
    L5:
        if (r15 != (-3)) goto L7;
        String r2 = "the offset position exceeds the log range(offset >= total_size)";
    L14:
        g49.d.b("DoraGLogManager", "onGetGLogInfo size:" + r15 + ", msg:" + r2);
        q(false, c, r2);
        return;
    L7:
        if (r15 != (-2)) goto L9;
        r2 = "request packet size exceeds the range(maximum value 960)";
        goto L14
    L9:
        if (r15 == (-1)) goto L11;
        r2 = "NEMOS internal error";
        goto L14
    L11:
        r2 = "unknown log type";
        goto L14
    }

    public final void b(int r22, byte r23, long r24, int r26, byte[] r27) {
        g49.d.a("DoraGLogManager", "onGetGLogData nid:" + r22 + " logType:" + r23 + " index:" + r24 + " size:" + r26);
        StringBuilder r6 = new StringBuilder("buf:");
        if (r27 == null) goto L5;
        String r9 = Arrays.toString(r27);
    L6:
        r6.append(r9);
        g49.d.a("DoraGLogManager", r6.toString());
        if (r26 >= 0) goto L21;
        if (r26 != (-3)) goto L11;
        String r1 = "the offset position exceeds the log range(offset >= total_size)";
    L18:
        g49.d.b("DoraGLogManager", "onGetGLogData size:" + r26 + ", msg:" + r1);
        q(false, c, r1);
        return;
    L11:
        if (r26 != (-2)) goto L13;
        r1 = "request packet size exceeds the range(maximum value 960)";
        goto L18
    L13:
        if (r26 == (-1)) goto L15;
        r1 = "NEMOS internal error";
        goto L18
    L15:
        r1 = "unknown log type";
        goto L18
    L21:
        if (g != 0) goto L23;
        g = System.nanoTime();
    L24:
        b = 0;
        ScheduledFuture<?> r10 = m;
        if (r10 == null) goto L27;
        r10.cancel(true);
    L27:
        PolarisFileWrapper r11 = i;
        if (r11 != null) goto L30;
    L55:
        g49.d.b("DoraGLogManager", "logFile is null or not exist");
        q(false, c, "the log file is not exist");
        return;
    L30:
        if (r11.exists() != true) goto L32;
        boolean r12 = true;
    L33:
        if (r12 == false) goto L55;
        if (r27 == null) goto L39;
        PolarisFileWrapper r13 = i;
        if (r13 == null) goto L39;
        FilesKt.appendBytes(r13, r27);
    L39:
        e.set(l() + ((long) r26));
        t(c, l());
        int r4 = com.larus.dora.impl.log.g.a.a;
        com.larus.dora.impl.log.g.a.e = l();
        if (l() < d) goto L51;
        g49.d.d("DoraGLogManager", "log data transmission completed!");
        byte r14 = c.getId();
        long r16 = d;
        p(r14, r16, r16, System.nanoTime() - g);
        int r2 = kj4.a.g().c.d.i(4, 7, new byte[]{12, 1, r23});
        if (r2 == 0) goto L44;
        g49.d.b("DoraGLogManager", "getLogEnd failed, ret:" + r2);
        com.larus.dora.impl.log.g.a.a(1);
    L45:
        t(c, l());
        u(c, d);
        g49.d.d("DoraGLogManager", "get log end success, type:" + r23);
        g49.d.d("DoraGLogManager", "!!!all log upload done!!! type " + c);
        q(true, c, "get log success");
        LogResultType r3 = LogResultType.SUCCESS;
        Intrinsics.checkNotNullParameter(r3, "result");
        long r15 = System.currentTimeMillis() - com.larus.dora.impl.log.g.a.f;
        if (r15 <= 0) goto L48;
        double r17 = ((Math.abs(com.larus.dora.impl.log.g.a.e - com.larus.dora.impl.log.g.a.d) / r15) * ((double) 1000)) / ((double) 1024);
    L49:
        DoraBuryPointManager.J(DoraBuryPointManager.a, "log_get_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Integer.valueOf(r3.getId())), TuplesKt.to("type", Integer.valueOf(com.larus.dora.impl.log.g.a.a)), TuplesKt.to("trigger_type", "manual"), TuplesKt.to("duration", Long.valueOf(r15)), TuplesKt.to("total_size", Long.valueOf(com.larus.dora.impl.log.g.a.b)), TuplesKt.to("get_size", Long.valueOf(com.larus.dora.impl.log.g.a.e)), TuplesKt.to("offset_size", Long.valueOf(com.larus.dora.impl.log.g.a.d)), TuplesKt.to("append_size", Long.valueOf(com.larus.dora.impl.log.g.a.e - com.larus.dora.impl.log.g.a.d)), TuplesKt.to("batch_fetch_count", Long.valueOf(com.larus.dora.impl.log.g.a.c)), TuplesKt.to("pull_rate", String.format("%.1f KB/s", Arrays.copyOf(new Object[]{Double.valueOf(r17)}, 1)))}), false, 12);
        String r5 = h;
        byte r7 = c.getId();
        k = new a();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraGLogManager$startUploadLog$1(r5 + "", r7, null), 3, null);
        v(false);
        s();
        return;
    L48:
        r17 = 0.0d;
        goto L49
    L44:
        g49.d.d("DoraGLogManager", "getLogEnd success");
        com.larus.dora.impl.log.g.a.a(0);
        goto L45
    L51:
        if (r24 != 15) goto L53;
        g49.d.a("DoraGLogManager", "getLogData index:" + r24 + ", curLogOffset:" + l());
        n(c, l(), 768, 16);
        return;
    L53:
        g49.d.a("DoraGLogManager", "getLogData index:" + r24 + ", curLogOffset:" + l());
        return;
    L32:
        r12 = false;
        goto L33
    L23:
        long r18 = System.nanoTime();
        p(c.getId(), l(), d, r18 - g);
        g = r18;
        goto L24
    L5:
        r9 = null;
        goto L6
    }
}
