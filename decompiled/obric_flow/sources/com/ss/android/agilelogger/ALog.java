package com.ss.android.agilelogger;

import ai.j0;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.alog.Alog;
import com.lynx.tasm.ui.image.f0;
import com.ss.android.agilelogger.utils.FormatUtils$TYPE;
import ct.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import l9.p;
import sj.g;
import xs.b;
import xs.c;
import xs.d;
import xs.e;

/* JADX INFO: loaded from: classes3.dex */
public class ALog {
    private static volatile Set<String> mBlockTagSet = null;
    private static Alog mainThreadRef = null;
    private static int prio = 3;
    public static b sConfig = null;
    private static volatile boolean sDebug = false;
    private static volatile c sILogCacheCallback = null;
    private static volatile List<d> sINativeFuncAddrCallbackList = null;
    private static volatile boolean sInitSuccess = false;
    private static ScheduledExecutorService sOuterExecutorService;

    static {
        sINativeFuncAddrCallbackList = new ArrayList();
        sOuterExecutorService = null;
        mainThreadRef = null;
    }

    public ALog() {
    }

    public static /* synthetic */ void access$000(Queue r5) {
        writeCachedItems(r5);
    }

    public static /* synthetic */ c access$100() {
        return null;
    }

    public static /* synthetic */ void access$200(String r5, String r10) {
        removeLegacyFiles(r5, r10);
    }

    public static void addNativeFuncAddrCallback(d r5) {
        sINativeFuncAddrCallbackList.add(r5);
    }

    public static void asyncFlush() {
        Alog r5 = mainThreadRef;
        if (r5 == null) goto L6;
        r5.a();
        return;
    }

    public static void bundle(int r5, String r10, Bundle r11) {
        if (checkPrioAndTag(r5, r10) == false) goto L10;
        int r12 = level2AlogCoreLevel(r5);
        FormatUtils$TYPE r13 = FormatUtils$TYPE.BUNDLE;
        ((a) ((ys.a) gt.a.f17226a.get(r13))).getClass();
        String r14 = g.p(r11);
        if (mainThreadRef != null) goto L7;
        return;
    L7:
        if (f0.t() == false) goto L12;
        mainThreadRef.g(r12, r10, r14);
        return;
    L12:
        return;
    }

    public static void changeLevel(int r5) {
        prio = r5;
        level2AlogCoreLevel(r5);
        Alog r10 = mainThreadRef;
        if (r10 == null) goto L6;
        r10.c(level2AlogCoreLevel(r5));
        return;
    }

    private static boolean checkPrioAndTag(int r5, String r10) {
        if (r5 >= prio) goto L6;
        return false;
    L6:
        if (mBlockTagSet != null) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return true;
    L10:
        if (mBlockTagSet.contains(r10) == false) goto L15;
        return false;
    L15:
        return true;
    }

    public static void d(String r5, String r10) {
        if (checkPrioAndTag(3, r5) == true) goto L5;
        return;
    L5:
        if (mainThreadRef != null) goto L7;
        return;
    L7:
        if (f0.t() == false) goto L12;
        mainThreadRef.g(1, r5, r10);
        return;
    }

    public static void destroy() {
        throw null;
    }

    public static void e(String r5, String r10) {
        if (checkPrioAndTag(6, r5) == true) goto L5;
        return;
    L5:
        if (mainThreadRef != null) goto L7;
        return;
    L7:
        if (f0.t() == false) goto L12;
        mainThreadRef.g(4, r5, r10);
        return;
    }

    @Deprecated
    public static void flush() {
        Alog r5 = mainThreadRef;
        if (r5 == null) goto L6;
        r5.a();
        return;
    }

    @Deprecated
    public static void forceLogSharding() {
    }

    public static List<String> getALogFiles(long r5, long r10) {
        return new ArrayList();
    }

    public static long getALogWriteFuncAddr() {
        return 0;
    }

    public static long getAlogNativeFlushV2FuncAddr() {
        return 0;
    }

    public static long getAlogNativeLogStoreDirFuncAddr() {
        return 0;
    }

    public static Set<String> getBlockTagSet() {
        return mBlockTagSet;
    }

    public static List<d> getNativeFuncAddrCallbackList() {
        return sINativeFuncAddrCallbackList;
    }

    public static String getStatus() {
        return "default log instance is null";
    }

    private static void handleItemMsg(e r5) {
        int[] r10 = xs.a.f23221a;
        throw null;
    }

    public static void header(int r5, String r10, String r11) {
        if (checkPrioAndTag(r5, r10) == false) goto L10;
        int r12 = level2AlogCoreLevel(r5);
        String r13 = gt.a.a(FormatUtils$TYPE.BORDER, r11);
        if (mainThreadRef != null) goto L7;
        return;
    L7:
        if (f0.t() == false) goto L12;
        mainThreadRef.g(r12, r10, r13);
        return;
    L12:
        return;
    }

    public static void i(String r5, String r10) {
        if (checkPrioAndTag(4, r5) == true) goto L5;
        return;
    L5:
        if (mainThreadRef != null) goto L7;
        return;
    L7:
        if (f0.t() == false) goto L12;
        mainThreadRef.g(2, r5, r10);
        return;
    }

    public static boolean init(b r5) {
        return false;
    }

    public static void intent(int r5, String r10, Intent r11) {
        if (checkPrioAndTag(r5, r10) == false) goto L10;
        int r12 = level2AlogCoreLevel(r5);
        FormatUtils$TYPE r13 = FormatUtils$TYPE.INTENT;
        ((ct.b) ((ys.a) gt.a.f17226a.get(r13))).getClass();
        String r14 = ct.b.b(r11);
        if (mainThreadRef != null) goto L7;
        return;
    L7:
        if (f0.t() == false) goto L12;
        mainThreadRef.g(r12, r10, r14);
        return;
    L12:
        return;
    }

    public static boolean isInitSuccess() {
        return sInitSuccess;
    }

    public static void json(int r5, String r10, String r11) {
        if (checkPrioAndTag(r5, r10) == false) goto L10;
        int r12 = level2AlogCoreLevel(r5);
        String r13 = gt.a.a(FormatUtils$TYPE.JSON, r11);
        if (mainThreadRef != null) goto L7;
        return;
    L7:
        if (f0.t() == false) goto L12;
        mainThreadRef.g(r12, r10, r13);
        return;
    L12:
        return;
    }

    private static int level2AlogCoreLevel(int r5) {
        return r5 - 2;
    }

    public static void println(int r5, String r10, Object r11, FormatUtils$TYPE r12) {
        if (checkPrioAndTag(r5, r10) == false) goto L22;
        int r13 = level2AlogCoreLevel(r5);
        switch(xs.a.f23221a[r12.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L6:
        String r14 = "";
    L17:
        if (mainThreadRef != null) goto L19;
        return;
    L19:
        if (f0.t() == false) goto L24;
        mainThreadRef.g(r13, r10, r14);
        return;
    L24:
        return;
    L7:
        FormatUtils$TYPE r15 = FormatUtils$TYPE.STACKTRACE;
        ys.a r16 = (ys.a) gt.a.f17226a.get(r15);
        r14 = r16.a((StackTraceElement[]) r11);
        goto L17
    L8:
        FormatUtils$TYPE r17 = FormatUtils$TYPE.THREAD;
        ys.a r18 = (ys.a) gt.a.f17226a.get(r17);
        r14 = r18.a((Thread) r11);
        goto L17
    L9:
        FormatUtils$TYPE r19 = FormatUtils$TYPE.THROWABLE;
        ys.a r20 = (ys.a) gt.a.f17226a.get(r19);
        r14 = r20.a((Throwable) r11);
        goto L17
    L10:
        FormatUtils$TYPE r21 = FormatUtils$TYPE.INTENT;
        ((ct.b) ((ys.a) gt.a.f17226a.get(r21))).getClass();
        r14 = ct.b.b((Intent) r11);
        goto L17
    L11:
        FormatUtils$TYPE r22 = FormatUtils$TYPE.BUNDLE;
        ((a) ((ys.a) gt.a.f17226a.get(r22))).getClass();
        r14 = g.p((Bundle) r11);
        goto L17
    L12:
        r14 = gt.a.a(FormatUtils$TYPE.JSON, (String) r11);
        goto L17
    L13:
        r14 = gt.a.a(FormatUtils$TYPE.BORDER, (String) r11);
        goto L17
    L14:
        r14 = sk.a.h((Throwable) r11);
        goto L17
    L15:
        r14 = (String) r11;
        goto L17
    }

    public static void release() {
        throw null;
    }

    private static void removeLegacyFiles(String r5, String r10) {
        File r11 = new File(r5);
        int r12 = 0;
        if (r11.exists() == false) goto L9;
        File[] r13 = r11.listFiles(new p(4));
        if (r13 == null) goto L9;
        int r14 = r13.length;
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L9;
        r13[r15].delete();
        r15 = r15 + 1;
    L9:
        File r16 = new File(r10);
        if (r16.exists() == false) goto L16;
        File[] r17 = r16.listFiles(new p(5));
        if (r17 == null) goto L19;
        int r18 = r17.length;
    L14:
        if (r12 >= r18) goto L20;
        r17[r12].delete();
        r12 = r12 + 1;
        goto L14
    L20:
        return;
    L19:
        return;
    }

    public static void setBlockTagSet(Set<String> r5) {
        mBlockTagSet = Collections.unmodifiableSet(r5);
    }

    public static void setDebug(boolean r5) {
        sDebug = r5;
        Alog r10 = mainThreadRef;
        if (r10 == null) goto L6;
        r10.d(sDebug);
        return;
    }

    public static void setILogCacheCallback(c r5) {
    }

    public static void setOuterExecutorService(ScheduledExecutorService r5) {
        sOuterExecutorService = r5;
    }

    @Deprecated
    public static void setPrintStackTrace(boolean r5) {
    }

    @Deprecated
    public static void setsPackageClassName(String r5) {
    }

    public static void stacktrace(int r5, String r10, StackTraceElement[] r11) {
        if (checkPrioAndTag(r5, r10) == false) goto L10;
        int r12 = level2AlogCoreLevel(r5);
        FormatUtils$TYPE r13 = FormatUtils$TYPE.STACKTRACE;
        String r14 = ((ys.a) gt.a.f17226a.get(r13)).a(r11);
        if (mainThreadRef != null) goto L7;
        return;
    L7:
        if (f0.t() == false) goto L12;
        mainThreadRef.g(r12, r10, r14);
        return;
    L12:
        return;
    }

    public static void statcktrace(int r5, String r10, StackTraceElement[] r11) {
        stacktrace(r5, r10, r11);
    }

    public static void syncFlush() {
        Alog r5 = mainThreadRef;
        if (r5 == null) goto L6;
        r5.e();
        return;
    }

    public static void thread(int r5, String r10, Thread r11) {
        if (checkPrioAndTag(r5, r10) == false) goto L10;
        int r12 = level2AlogCoreLevel(r5);
        FormatUtils$TYPE r13 = FormatUtils$TYPE.THREAD;
        String r14 = ((ys.a) gt.a.f17226a.get(r13)).a(r11);
        if (mainThreadRef != null) goto L7;
        return;
    L7:
        if (f0.t() == false) goto L12;
        mainThreadRef.g(r12, r10, r14);
        return;
    L12:
        return;
    }

    public static void throwable(int r5, String r10, Throwable r11) {
        if (checkPrioAndTag(r5, r10) == false) goto L10;
        int r12 = level2AlogCoreLevel(r5);
        FormatUtils$TYPE r13 = FormatUtils$TYPE.THROWABLE;
        String r14 = ((ys.a) gt.a.f17226a.get(r13)).a(r11);
        if (mainThreadRef != null) goto L7;
        return;
    L7:
        if (f0.t() == false) goto L12;
        mainThreadRef.g(r12, r10, r14);
        return;
    L12:
        return;
    }

    public static void timedSyncFlush(int r5) {
        Alog r10 = mainThreadRef;
        if (r10 == null) goto L6;
        r10.f(r5);
        return;
    }

    public static void v(String r5, String r10) {
        if (checkPrioAndTag(2, r5) == true) goto L5;
        return;
    L5:
        if (mainThreadRef != null) goto L7;
        return;
    L7:
        if (f0.t() == false) goto L12;
        mainThreadRef.g(0, r5, r10);
        return;
    }

    public static void w(String r5, String r10) {
        if (checkPrioAndTag(5, r5) == true) goto L5;
        return;
    L5:
        if (mainThreadRef != null) goto L7;
        return;
    L7:
        if (f0.t() == false) goto L12;
        mainThreadRef.g(3, r5, r10);
        return;
    }

    private static void writeCachedItems(Queue<e> r5) {
        Iterator<e> r10 = r5.iterator();
        if (r10.hasNext() == true) goto L5;
        return;
    L5:
        j0.A(r10.next());
        throw null;
    }

    public static List<String> getALogFiles(String r5, String r10, long r11, long r12) {
        return new ArrayList();
    }

    public static void e(String r5, String r10, Throwable r11) {
        if (checkPrioAndTag(6, r5) == false) goto L10;
        StringBuilder r12 = j0.w(r10, "\n");
        r12.append(sk.a.h(r11));
        String r13 = r12.toString();
        if (mainThreadRef != null) goto L7;
        return;
    L7:
        if (f0.t() == false) goto L12;
        mainThreadRef.g(4, r5, r13);
        return;
    L12:
        return;
    }

    public static void w(String r5, String r10, Throwable r11) {
        if (checkPrioAndTag(5, r5) == false) goto L10;
        StringBuilder r12 = j0.w(r10, "\n");
        r12.append(sk.a.h(r11));
        String r13 = r12.toString();
        if (mainThreadRef != null) goto L7;
        return;
    L7:
        if (f0.t() == false) goto L12;
        mainThreadRef.g(3, r5, r13);
        return;
    L12:
        return;
    }

    public static void e(String r5, Throwable r10) {
        if (checkPrioAndTag(6, r5) == false) goto L10;
        String r11 = sk.a.h(r10);
        if (mainThreadRef != null) goto L7;
        return;
    L7:
        if (f0.t() == false) goto L12;
        mainThreadRef.g(4, r5, r11);
        return;
    L12:
        return;
    }

    public static void w(String r5, Throwable r10) {
        if (checkPrioAndTag(5, r5) == false) goto L10;
        String r11 = sk.a.h(r10);
        if (mainThreadRef != null) goto L7;
        return;
    L7:
        if (f0.t() == false) goto L12;
        mainThreadRef.g(3, r5, r11);
        return;
    L12:
        return;
    }
}
