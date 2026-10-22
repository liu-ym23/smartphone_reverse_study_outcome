package com.bytedance.crash;

import ai.g0;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.h0;
import com.bytedance.apm.profiler.Profiler;
import com.bytedance.crash.gwpasan.GwpAsan;
import com.bytedance.crash.heaptracker.NativeHeapTracker;
import com.bytedance.crash.nativecrash.NativeImpl;
import com.bytedance.crash.npth_fd_track.FDNativeTools;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.crash.upload.s;
import com.bytedance.crash.util.ListMap;
import com.bytedance.crash.util.NativeTools;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class Npth {
    private static final boolean DEBUG = true;
    private static boolean sInit;

    public Npth() {
    }

    public static void addAttachLongUserData(AttachUserData r5, CrashType r10) {
        if (r5 == null) goto L5;
        n.f4063k.a(r5, r10);
        return;
    }

    public static void addAttachUserData(AttachUserData r5, CrashType r10) {
        if (r5 == null) goto L5;
        n.f4063k.a(r5, r10);
        return;
    }

    public static void addTag(String r5, String r10) {
        AppDataCenter r11 = n.f4063k;
        if (r10 != null) goto L5;
        r11.f4023a.remove(r5);
    L6:
        o9.a.a();
        return;
    L5:
        r11.f4023a.put(r5, r10);
        goto L6
    }

    public static void addTags(Map<? extends String, ? extends String> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isEmpty() == true) goto L8;
        n.f4063k.f4023a.putAll(r5);
        o9.a.a();
        return;
    }

    public static void addWhiteLogType(String r5) {
    }

    public static void customActivityName(k9.a r5) {
        m9.c.e().getClass();
    }

    public static void dumpHprof(String r5) {
        boolean r10 = p.f4081a;
        NativeTools.k().p(r5);
    }

    public static void enableALogCollector(String r5, v8.c r10, v8.d r11) {
        boolean r12 = p.f4081a;
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        if (new File(r5).exists() == false) goto L11;
        v8.a r13 = v8.a.d();
        r13.f22550a = r5;
        r13.f22551b = r11;
        if (r13.f22552c == true) goto L12;
        r13.f22552c = DEBUG;
        return;
    L12:
        return;
    }

    public static void enableGwpAsan(boolean r5) {
        if (NativeTools.k().E() == true) goto L6;
        io.reactivex.exceptions.a.c("[XAsan]is 32 app.");
        return;
    }

    public static ConfigManager getConfigManager() {
        return n.f4062j;
    }

    public static long getFileSize(String r5) {
        NativeTools.k().getClass();
        return NativeTools.B(r5);
    }

    public static long getFolderSize(String r5) {
        NativeTools.k().getClass();
        return NativeTools.D(r5);
    }

    public static boolean hasCrash() {
        return p.e();
    }

    public static boolean hasCrashWhenJavaCrash() {
        boolean r5 = p.f4081a;
        Boolean r10 = (Boolean) d9.b.f16614i.get();
        if (r10 == null) goto L8;
        if (r10.booleanValue() == false) goto L8;
        return DEBUG;
    L8:
        if (NativeImpl.j() == false) goto L11;
        return DEBUG;
    L11:
        return false;
    }

    public static boolean hasCrashWhenNativeCrash() {
        boolean r5 = p.f4081a;
        return d9.b.f16613h;
    }

    public static synchronized void init(@NonNull Context r5, @NonNull ICommonParams r10) {
        monitor-enter(Npth.class);
        init(r5, r10, DEBUG, false, false);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized void initMiniApp(@NonNull Context r10, @NonNull ICommonParams r11) {
        monitor-enter(Npth.class);
        n.f = DEBUG;     // Catch: Throwable -> L8
        init(r10, r11, DEBUG, false, DEBUG, DEBUG);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static boolean isANREnable() {
        return p.f4083c;
    }

    public static boolean isInit() {
        return sInit;
    }

    public static boolean isJavaCrashEnable() {
        return p.f4082b;
    }

    public static boolean isNativeCrashEnable() {
        return p.d;
    }

    public static boolean isRunning() {
        boolean r5 = p.f4081a;
        if ((SystemClock.uptimeMillis() - h0.f) > 15000) goto L6;
        return DEBUG;
    L6:
        return false;
    }

    public static boolean isStopUpload() {
        return p.f4084h;
    }

    public static void openANRMonitor() {
        if (p.f4081a == false) goto L14;
        w8.b r5 = (w8.b) w8.f.c(n.f4057a).f22816a;
        if (r5.f22769c == true) goto L12;
        r5.f22767a = new h0(r5);
        if (a.a.d == true) goto L11;
        a.a.d = DEBUG;
    L11:
        r5.d = n.f4059c;
        r5.f22769c = DEBUG;
    L12:
        p.f4083c = DEBUG;
        return;
    }

    public static void openJavaCrashMonitor() {
        if (p.f4081a == true) goto L5;
        return;
    L5:
        if (p.f4082b == true) goto L12;
        Context r5 = n.f4057a;
        if (d9.b.g != null) goto L9;
        d9.b.g = new d9.b();
    L9:
        d9.b r10 = d9.b.g;
        r10.f16617b = new h0(r5, DEBUG);
        r10.f16618c = new h0(r5, false);
        return;
    }

    public static boolean openNativeCrashMonitor() {
        if (p.f4081a == false) goto L10;
        if (p.d == true) goto L10;
        boolean r5 = NativeImpl.k(n.f4057a);
        p.d = r5;
        if (r5 == true) goto L10;
        p.e = DEBUG;
    L10:
        return p.d;
    }

    public static void registerANRCallback(d r5) {
        ((CopyOnWriteArrayList) p.f.g).add(r5);
    }

    public static void registerCrashCallback(ICrashCallback r5, CrashType r10) {
        g0 r11 = p.f;
        ListMap r12 = (ListMap) r11.f209a;
        monitor-enter(r12);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (r10 != CrashType.ALL) goto L9;
        ((ListMap) r11.f209a).a(r5, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});     // Catch: Throwable -> L7
    L10:
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L9:
        ((ListMap) r11.f209a).a(r10).add(r5);     // Catch: Throwable -> L7
        goto L10
    }

    public static void registerCrashCallbackEx(a r5, CrashType r10) {
        g0 r11 = p.f;
        r11.getClass();
        CrashType r12 = CrashType.ALL;
        ListMap r13 = (ListMap) r11.f210b;
        if (r10 != r12) goto L6;
        r13.a(r5, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});
        return;
    L6:
        r13.a(r10).add(r5);
    }

    public static void registerCrashCallbackOnDrop(a r5, CrashType r10) {
        g0 r11 = p.f;
        r11.getClass();
        CrashType r12 = CrashType.ALL;
        ListMap r13 = (ListMap) r11.e;
        if (r10 != r12) goto L6;
        r13.a(r5, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});
        return;
    L6:
        r13.a(r10).add(r5);
    }

    public static void registerCrashInfoCallback(b r5, CrashType r10) {
        g0 r11 = p.f;
        r11.getClass();
        CrashType r12 = CrashType.ALL;
        ListMap r13 = (ListMap) r11.f211c;
        if (r10 != r12) goto L6;
        r13.a(r5, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});
        return;
    L6:
        r13.a(r10).add(r5);
    }

    public static void registerHprofCallback(IOOMCallback r5) {
        ((CopyOnWriteArrayList) p.f.f).add(r5);
    }

    public static void registerOOMCallback(IOOMCallback r5) {
        ((CopyOnWriteArrayList) p.f.d).add(r5);
    }

    public static void registerSdk(int r5, String r10) {
        if (n.f4064l == null) goto L5;
    L15:
        n.f4064l.put(Integer.valueOf(r5), r10);
        return;
    L5:
        monitor-enter(n.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (n.f4064l != null) goto L11;
        n.f4064l = new ConcurrentHashMap();     // Catch: Throwable -> L9
    L11:
        monitor-exit(n.class);     // Catch: Throwable -> L9
        goto L15
    }

    public static void removeAttachLongUserData(AttachUserData r5, CrashType r10) {
        if (r5 == null) goto L5;
        n.f4063k.a(r10, r5);
        return;
    }

    public static void removeAttachUserData(AttachUserData r5, CrashType r10) {
        if (r5 == null) goto L5;
        n.f4063k.a(r10, r5);
        return;
    }

    public static void removeTag(String r5) {
        n.f4063k.f4023a.remove(r5);
        o9.a.a();
    }

    public static void reportDartError(String r5) {
        boolean r10 = p.f4081a;
        if (TextUtils.isEmpty(r5) == true) goto L6;
        com.lynx.tasm.utils.e.f(null, null, r5);
        return;
    }

    @Deprecated
    public static void reportError(@NonNull Throwable r5) {
        boolean r10 = p.f4081a;
        if (n.f4062j.isReportErrorEnable() == true) goto L5;
        return;
    L5:
        d9.b r11 = d9.b.g;
        if (r5 == null) goto L10;
        l9.o.e().b(new com.bytedance.apm.util.b(1, r5));
        return;
    }

    public static void reportGameException(String r5, String r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L10;
        if (TextUtils.isEmpty(r5) == false) goto L10;
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return;
    L10:
        if (s.m(null, CrashType.GAME) == true) goto L15;
        l9.o.e().b(new a9.a(r5, r10, r11, 0));
        return;
    }

    public static void scanNativeCrash(Context r10, a r11, String[] r12) {
        long r5 = SystemClock.uptimeMillis();     // Catch: Throwable -> L27
        File[] r13 = new File(com.bytedance.crash.util.g.h(r10), x8.a.d).listFiles();     // Catch: Throwable -> L27
        io.reactivex.exceptions.a.i("scanNativeCrash begin");     // Catch: Throwable -> L27
        if (r13 != null) goto L6;
    L47:
        io.reactivex.exceptions.a.i("no native crash");     // Catch: Throwable -> L27
        return;
    L6:
        if (r13.length == 0) goto L47;
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L27
        int r15 = 0;
        int r16 = 0;
    L10:
        if (r16 >= r13.length) goto L32;
        if (r16 >= 50) goto L32;
        File r17 = r13[r16];     // Catch: Throwable -> L27
        io.reactivex.exceptions.a.i("dir:" + r17.getAbsolutePath());     // Catch: Throwable -> L27
        if (r17.isDirectory() == true) goto L16;
    L30:
        io.reactivex.exceptions.a.i("duplicated");     // Catch: Throwable -> L27
    L31:
        r16 = r16 + 1;     // Catch: Throwable -> L27
        goto L10
    L16:
        if (r17.getName().contains("deleted") == true) goto L30;
        if (new File(r17, "deleted").exists() == true) goto L30;
        if (r17.getName().endsWith("G") == false) goto L31;
        String r18 = r17.getName();     // Catch: Throwable -> L27
        if (r12 != null) goto L25;
    L29:
        io.reactivex.exceptions.a.i("create CrashOneStart uuid:" + r18);     // Catch: Throwable -> L27
        com.bytedance.crash.upload.f r19 = new com.bytedance.crash.upload.f(r18);     // Catch: Throwable -> L27
        r14.add(r19);     // Catch: Throwable -> L27
        r19.f4111c.add(new com.bytedance.crash.upload.e(r17, CrashType.NATIVE));     // Catch: Throwable -> L27
        goto L31
    L25:
        if (new HashSet(Arrays.asList(r12)).contains(r18) == false) goto L29;
        io.reactivex.exceptions.a.i("drop uuid:" + r18);     // Catch: Throwable -> L27
    L32:
        int r20 = r14.size();     // Catch: Throwable -> L27
        com.bytedance.crash.upload.f[] r110 = new com.bytedance.crash.upload.f[r20];     // Catch: Throwable -> L27
        r14.toArray(r110);     // Catch: Throwable -> L27
        Arrays.sort(r110, new ca.d(5));     // Catch: Throwable -> L27
        NativeImpl.m();     // Catch: Throwable -> L27
        s6.c r111 = new s6.c(false);     // Catch: Throwable -> L27
    L33:
        if (r15 >= r20) goto L46;
        if (r15 >= 5) goto L46;
        Iterator r21 = r110[r15].f4111c.iterator();     // Catch: Throwable -> L27
    L38:
        if (r21.hasNext() == false) goto L45;
        File r22 = ((com.bytedance.crash.upload.e) r21.next()).f4105a;     // Catch: Throwable -> L27
        io.reactivex.exceptions.a.i("parse CrashInfo dir=" + r22.getAbsolutePath());     // Catch: Throwable -> L27
        r111.f21828b = new i4.a(r22, 1);     // Catch: Throwable -> L27
        r22.getName();     // Catch: Throwable -> L27
        r111.m();     // Catch: Throwable -> L27
        r111.r();     // Catch: Throwable -> L27
        r111.o();     // Catch: Throwable -> L27
        w8.f r23 = (w8.f) ((i4.a) r111.f21828b).f17503c;     // Catch: Throwable -> L27
        HashMap r24 = (HashMap) r23.f22816a;     // Catch: Throwable -> L27
        if (r24 == null) goto L38;
        if (r24.isEmpty() == true) goto L38;
        String r25 = (String) ((HashMap) r23.f22816a).get("process_name");     // Catch: Throwable -> L27
        goto L38
    L45:
        r15 = r15 + 1;     // Catch: Throwable -> L27
    L46:
        io.reactivex.exceptions.a.c("scanNativeCrash cost:" + (SystemClock.uptimeMillis() - r5) + "ms");     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    }

    public static void setANRCheckEnable(boolean r5) {
        n.f4060h = r5;
    }

    public static void setAlogFlushAddr(long r5) {
        boolean r10 = p.f4081a;
    }

    public static void setAlogFlushV2Addr(long r5) {
        boolean r10 = p.f4081a;
        NativeImpl.f(r5);
    }

    public static void setAlogLogDirAddr(long r5) {
        boolean r10 = p.f4081a;
    }

    public static void setAlogWriteAddr(long r5) {
    }

    public static void setAnrInfoFileObserver(String r5, f r10) {
        boolean r11 = p.f4081a;
        l9.o.e().b(new ab.b(6, r5, r10));
    }

    public static void setApplication(Application r5) {
        if (r5 == null) goto L5;
        n.f4058b = r5;
        return;
    L5:
        Context r10 = n.f4057a;
    }

    @Deprecated
    public static void setAttachUserData(AttachUserData r5, CrashType r10) {
        if (r5 == null) goto L5;
        n.f4063k.a(r5, r10);
        return;
    }

    public static void setBusiness(String r5) {
        if (r5 == null) goto L5;
        n.e = r5;
        return;
    }

    public static void setCrashFilter(ICrashFilter r5) {
        n.f4063k.f4024b = r5;
    }

    public static void setCurProcessName(String r5) {
        ym.m.f23304a = r5;
    }

    public static void setDebuggerConnectedStopUpload(boolean r5) {
        p.f4086j = r5;
    }

    public static void setEncryptImpl(@NonNull e r5) {
        boolean r10 = p.f4081a;
        n.f4062j.setEncryptImpl(r5);
    }

    public static void setEnsureOpt(boolean r5) {
        n.f4074w = r5;
    }

    public static void setFixDumpStack(boolean r5) {
        n.f4075x = r5;
    }

    public static void setLogcatImpl(l9.j r5) {
        boolean r10 = p.f4081a;
    }

    public static void setMaxCacheSize(int r5) {
        com.bytedance.crash.upload.b.f4099k = r5;
        com.bytedance.crash.upload.n.e = r5;
    }

    public static void setNpthStartEventDelayTime(long r5) {
        n.f4071t = r5;
    }

    public static void setOpenNewAnrMonitor(boolean r5) {
        n.g = r5;
    }

    public static void setQueueLimitSize(int r5) {
        com.bytedance.crash.upload.n.d = r5;
    }

    public static void setRequestIntercept(com.bytedance.crash.upload.o r5) {
        boolean r10 = p.f4081a;
    }

    public static void setRequestPermission(com.bytedance.crash.upload.p r5) {
        boolean r10 = p.f4081a;
    }

    public static void setScriptStackCallback(g r5) {
    }

    public static void setTerminateMonitorDelayTime(long r5) {
        p.g = r5;
    }

    public static void startFdTracker() {
        Context r5 = n.f4057a;
        ym.m.o(r5);
        String r10 = n.f();
        String r11 = com.bytedance.crash.util.g.f4181a;
        j9.b r12 = new j9.b(new File(com.bytedance.crash.util.g.h(r5), td.d.b("npth/FDTracker/", r10)), r5);
        io.reactivex.exceptions.a.d("[NpthFdTracker]: ", "begin execute");
        boolean r13 = Profiler.f3896a;
        w6.a.f22746a.a();
        if (r12.f18292c == false) goto L5;
        io.reactivex.exceptions.a.d("[NpthFdTracker]: ", "already is running");
        return;
    L5:
        Context r14 = r12.f18290a;
        io.reactivex.exceptions.a.d("[FDNativeTools]: ", "loadLibrary");
        if (FDNativeTools.f4079a == true) goto L9;
        io.reactivex.exceptions.a.p(r14, "npth_fd_tracker");     // Catch: Throwable -> L19
        FDNativeTools.f4079a = DEBUG;     // Catch: Throwable -> L19
    L9:
        if (FDNativeTools.f4079a == true) goto L12;
        io.reactivex.exceptions.a.d("[NpthFdTracker]: ", "load library fail");
        return;
    L12:
        if (r12.f18291b == 0) goto L14;
        io.reactivex.exceptions.a.d("[NpthFdTracker]: ", "invalid state");
        return;
    L14:
        String r15 = String.valueOf(r12.g);
        String r16 = String.valueOf(Build.VERSION.SDK_INT);
        String r17 = String.valueOf(r12.f18295j);
        if (FDNativeTools.c(new String[]{r12.f18293h, r15, r12.f18294i, r16, r17}) != 0) goto L17;
        r12.f18291b = 1;
        r12.f18292c = DEBUG;
        new j9.a(r12, 0).start();
        return;
    L17:
        io.reactivex.exceptions.a.d("[NpthFdTracker]: ", "init native params err");
    }

    public static void startGwpAsan(boolean r12) {
        Context r5 = n.f4057a;
        String r10 = com.bytedance.crash.util.g.f4181a;
        if (r5 != null) goto L5;
        Context r11 = n.f4057a;
    L6:
        String r13 = com.bytedance.crash.util.g.h(r11);
        String r14 = com.bytedance.crash.util.g.f4182b;
        File r15 = new File(r13, r14);
        JSONArray r16 = mh.e.f(l9.c.e(), new String[]{"custom_event_settings", "npth_simple_setting", "gwp_asan_set_init_param"});
        GwpAsan r17 = new GwpAsan();
        if (r5 != null) goto L9;
        r5 = n.f4057a;
    L9:
        GwpAsan.f4032h = r12;
        GwpAsan.f4038n = r5;
        GwpAsan.f4037m = r15;
        GwpAsan.f4030b = r16;
        GwpAsan.f4035k = false;
        GwpAsan.f4036l = false;
        if (GwpAsan.f4033i == false) goto L12;
        io.reactivex.exceptions.a.d("XASAN", "execute() Already running!");
        return;
    L12:
        File r18 = new File(com.bytedance.crash.util.g.h(n.f4057a), com.bytedance.crash.util.g.f4181a);
        if (r18.exists() == true) goto L15;
    L19:
        GwpAsan.f4034j = false;
        if (n.h() == false) goto L22;
    L51:
        io.reactivex.exceptions.a.d("XASAN", "offline Test Mode");
        GwpAsan.f4034j = DEBUG;
    L52:
        new b9.a(r17).start();
        return;
    L22:
        if ("true".equals(null) == true) goto L51;
        File r19 = new File(com.bytedance.crash.util.g.h(n.f4057a), r14);
        if (r19.exists() == true) goto L27;
    L28:
        r19.mkdirs();
    L29:
        long r20 = System.currentTimeMillis() / 1000;
        if (GwpAsan.d(r19, "gwpfile") == false) goto L52;
        long r21 = Long.parseLong(cl.a.c(-1, GwpAsan.f4039o, "\n"));     // Catch: Throwable -> L45
        int r22 = 7;
        int r110 = mh.e.c(l9.c.e(), 7, new String[]{"custom_event_settings", "npth_simple_setting", "coredump_gwpasan_check_time"});     // Catch: Throwable -> L45
        if (r110 > 7) goto L36;
        r22 = r110;
    L36:
        if (r20 >= r21) goto L38;
    L40:
        if (r20 < r21) goto L48;
        if ((r20 - r21) < (r22 * 86400)) goto L48;
        cl.a.C(GwpAsan.f4039o);     // Catch: Throwable -> L45
    L48:
        if (r21 <= r20) goto L52;
    L49:
        io.reactivex.exceptions.a.d("XASAN", "xasan check time");
        return;
    L38:
        if ((r20 - r21) >= (r22 * 86400)) goto L40;
    L45:
        th = move-exception;
        c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L52
    L27:
        if (r19.isDirectory() == true) goto L29;
    L15:
        if (r18.isDirectory() == false) goto L19;
        if (GwpAsan.d(r18, "cfgclose") == false) goto L19;
        return;
    L5:
        r11 = r5;
        goto L6
    }

    public static void startNativeHeapTracker(JSONArray r10) {
        Context r5 = n.f4057a;
        String r11 = ym.m.o(r5);
        String r12 = com.bytedance.crash.util.g.f4181a;
        new NativeHeapTracker(r10, r11, new File(com.bytedance.crash.util.g.h(r5), "npth/NativeHeapTracker"), r5).j();
    }

    public static void stopAnr() {
        if (p.f4081a == false) goto L17;
        w8.b r5 = (w8.b) w8.f.c(n.f4057a).f22816a;
        if (r5.f22769c == false) goto L15;
        r5.f22769c = false;
        h0 r10 = r5.f22767a;
        if (r10 == null) goto L11;
        r10.f1510a = DEBUG;
    L11:
        if (a.a.d == false) goto L14;
        a.a.d = false;
    L14:
        r5.f22767a = null;
    L15:
        p.f4083c = false;
        return;
    }

    public static void stopEnsure() {
        p.f4085i = DEBUG;
    }

    public static void stopUpload() {
        p.f4084h = DEBUG;
    }

    public static void unregisterCrashCallback(ICrashCallback r5, CrashType r10) {
        g0 r11 = p.f;
        ListMap r12 = (ListMap) r11.f209a;
        monitor-enter(r12);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r10 != CrashType.ALL) goto L12;
        Iterator r13 = ((ListMap) r11.f209a).values().iterator();     // Catch: Throwable -> L10
    L8:
        if (r13.hasNext() == false) goto L13;
        ((List) r13.next()).remove(r5);     // Catch: Throwable -> L10
    L13:
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L12:
        ((ListMap) r11.f209a).a(r10).remove(r5);     // Catch: Throwable -> L10
        goto L13
    }

    public static void unregisterHprofCallback(IOOMCallback r5, CrashType r10) {
        ((CopyOnWriteArrayList) p.f.f).remove(r5);
    }

    public static void unregisterOOMCallback(IOOMCallback r5, CrashType r10) {
        ((CopyOnWriteArrayList) p.f.d).remove(r5);
    }

    public static synchronized void init(@NonNull Context r10, @NonNull ICommonParams r11, boolean r12, boolean r13, boolean r14) {
        monitor-enter(Npth.class);
        init(r10, r11, r12, r12, r13, r14);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(@NonNull Context r10, @NonNull ICommonParams r11, boolean r12, boolean r13, boolean r14, boolean r15) {
        monitor-enter(Npth.class);
        init(r10, r11, r12, r13, r14, r15, 0);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized void initMiniApp(@NonNull Context r10, @NonNull ICommonParams r11, int r12, String r13) {
        monitor-enter(Npth.class);
        n.f = DEBUG;     // Catch: Throwable -> L8
        n.f4069q = r12;     // Catch: Throwable -> L8
        n.f4070r = r13;     // Catch: Throwable -> L8
        init(r10, r11, DEBUG, DEBUG, DEBUG, DEBUG);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(@NonNull Context r12, @NonNull ICommonParams r13, boolean r14, boolean r15, boolean r16, boolean r17, long r18) {
        Context r5 = r12;
        monitor-enter(Npth.class);
        Application r10 = n.f4058b;     // Catch: Throwable -> L14
        if (r10 == null) goto L8;
    L21:
        init(r10, r5, r13, r14, r15, r16, r17, r18);     // Catch: Throwable -> L14
        monitor-exit(Npth.class);
        return;
    L8:
        if ((r5 instanceof Application) == false) goto L31;
        r10 = (Application) r5;     // Catch: Throwable -> L14
        if (r10.getBaseContext() != null) goto L21;
        throw new IllegalArgumentException("Param 'application' have not called 'super.attachBaseContext()', please using 'baseContext' param and invoking 'Npth.setApplication(Application)' before init");     // Catch: Throwable -> L14
    L31:
        r10 = (Application) r12.getApplicationContext();     // Catch: Throwable -> L26
        if (r10 == null) goto L25;
        if (r10.getBaseContext() == null) goto L21;
        r5 = r10.getBaseContext();     // Catch: Throwable -> L14
        goto L21
    L25:
        throw new IllegalArgumentException("Couldn't obtain Application instance before 'super.attachBaseContext()', please invoking 'Npth.setApplication(Application)' before init.");     // Catch: Throwable -> L14
    L27:
        throw new IllegalArgumentException("Couldn't obtain Application instance before 'super.attachBaseContext()', please invoking 'Npth.setApplication(Application)' before init.");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static void reportDartError(String r5, @Nullable Map<? extends String, ? extends String> r10, @Nullable Map<String, String> r11, @Nullable h r12) {
        boolean r13 = p.f4081a;
        if (TextUtils.isEmpty(r5) == true) goto L6;
        com.lynx.tasm.utils.e.f(r10, r11, r5);
        return;
    }

    @Deprecated
    public static void reportError(String r5) {
        boolean r10 = p.f4081a;
        if (n.f4062j.isReportErrorEnable() == true) goto L5;
        return;
    L5:
        d9.b r11 = d9.b.g;
        if (r5 == null) goto L10;
        l9.o.e().b(new com.bytedance.apm.d(r5, 4));
        return;
    }

    public static void registerSdk(String r5, String r10) {
        mh.e.g(r10, r5, n.f4065m);
    }

    public static synchronized void init(@NonNull Application r10, @NonNull Context r11, @NonNull ICommonParams r12, boolean r13, boolean r14, boolean r15, boolean r16, long r17) {
        monitor-enter(Npth.class);
        SystemClock.uptimeMillis();     // Catch: Throwable -> L17
        if (sInit == false) goto L9;
        monitor-exit(Npth.class);
        return;
    L9:
        sInit = DEBUG;     // Catch: Throwable -> L17
        if (n.f4072u == false) goto L13;
    L21:
        p.b(r10, r11, r13, r14, r15, r16);     // Catch: Throwable -> L17
        l9.o.e().b(new l(r11));     // Catch: Throwable -> L17
        p.f4087k = new r9.c(4);     // Catch: Throwable -> L17
        p.f4088l = new s6.b(4);     // Catch: Throwable -> L17
        p.f4089m = new sj.e();     // Catch: Throwable -> L17
        monitor-exit(Npth.class);
        return;
    L13:
        if (n.f4058b != null) goto L15;
    L19:
        n.f4059c = System.currentTimeMillis();     // Catch: Throwable -> L17
        n.d = SystemClock.uptimeMillis();     // Catch: Throwable -> L17
        n.f4057a = r11;     // Catch: Throwable -> L17
        n.f4058b = r10;     // Catch: Throwable -> L17
        n.f4067o = n.f();     // Catch: Throwable -> L17
    L20:
        n.f4061i = new i4.a(n.f4057a, r12, n.d());     // Catch: Throwable -> L17
        n.f4072u = DEBUG;     // Catch: Throwable -> L17
        goto L21
    L15:
        if (n.f4057a != null) goto L20;
    L17:
        th = move-exception;
        throw th;
    }
}
