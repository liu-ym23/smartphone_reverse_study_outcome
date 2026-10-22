package com.bytedance.apm.block.trace;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.android.anniex.base.service.f;
import com.bytedance.apm.core.ActivityLifeObserver;
import d6.c;
import d6.d;
import d6.e;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import jg.a;
import jg.i;

/* JADX INFO: loaded from: classes2.dex */
public class MethodCollector {
    public static final int DEFAULT_STACK_DEPTH = 5;
    public static final int METHOD_ID_DISPATCH = 1048574;
    private static final int METHOD_ID_MAX = 1048575;
    private static final int STATUS_DEFAULT = Integer.MAX_VALUE;
    private static final int STATUS_EXPIRED_START = -2;
    private static final int STATUS_NO_PERMIT = -4;
    private static final int STATUS_OUT_RELEASE = -3;
    private static final int STATUS_READY = 1;
    private static final int STATUS_STARTED = 2;
    private static final int STATUS_STOPPED = -1;
    private static final String TAG = "MethodCollector";
    private static boolean assertIn;
    private static Runnable checkStartExpiredRunnable;
    private static boolean isPauseUpdateTime;
    private static a looperMonitorListener;
    private static long[] sBuffer;
    private static volatile long sCurrentDiffTime;
    private static volatile long sDiffTime;
    private static volatile boolean sDontRecord;
    private static Handler sHandler;
    private static int sIndex;
    private static e sIndexRecordHead;
    private static e sIndexRecordTail;
    private static MethodCollector sInstance;
    private static int sLastIndex;
    private static Thread sMainThread;
    private static volatile Runnable sReleaseOnMainThread;
    private static HandlerThread sTimerUpdateThread;
    private static Runnable sUpdateDiffTimeRunnable;
    private static volatile int status;
    private static final Object statusLock = null;
    private static Object updateTimeLock;

    static {
        sInstance = new MethodCollector();
        status = Integer.MAX_VALUE;
        sDontRecord = false;
        Object r5 = new Object();
        statusLock = r5;
        sBuffer = new long[600000];
        sIndex = 0;
        sLastIndex = -1;
        assertIn = false;
        sCurrentDiffTime = getCurrentTime();
        sDiffTime = sCurrentDiffTime;
        sMainThread = Looper.getMainLooper().getThread();
        sReleaseOnMainThread = null;
        sTimerUpdateThread = getTimerUpdateThread();
        sHandler = new Handler(sTimerUpdateThread.getLooper());
        updateTimeLock = new Object();
        isPauseUpdateTime = false;
        checkStartExpiredRunnable = null;
        looperMonitorListener = new d();
        sUpdateDiffTimeRunnable = new com.bytedance.android.anniex.worker.a(15);
        if (status != Integer.MAX_VALUE) goto L14;
        monitor-enter(r5);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (status != Integer.MAX_VALUE) goto L10;
        realExecute();     // Catch: Throwable -> L8
        status = 1;     // Catch: Throwable -> L8
    L10:
        monitor-exit(r5);     // Catch: Throwable -> L8
    L14:
        i(METHOD_ID_DISPATCH, 0);
        maskIndex("EvilMethodTracer#message_0", a.f18319b);
        sHandler.postDelayed(new com.bytedance.android.anniex.worker.a(16), 15000);
    }

    public MethodCollector() {
    }

    public static /* synthetic */ Runnable access$000() {
        return sReleaseOnMainThread;
    }

    public static /* synthetic */ Runnable access$002(Runnable r5) {
        sReleaseOnMainThread = r5;
        return r5;
    }

    public static /* synthetic */ int access$100() {
        return status;
    }

    public static /* synthetic */ Handler access$1000() {
        return sHandler;
    }

    public static /* synthetic */ int access$102(int r5) {
        status = r5;
        return r5;
    }

    public static /* synthetic */ a access$1100() {
        return looperMonitorListener;
    }

    public static /* synthetic */ HandlerThread access$1200() {
        return sTimerUpdateThread;
    }

    public static /* synthetic */ long[] access$1302(long[] r5) {
        sBuffer = r5;
        return r5;
    }

    public static /* synthetic */ Object access$1400() {
        return statusLock;
    }

    public static /* synthetic */ boolean access$1502(boolean r5) {
        sDontRecord = r5;
        return r5;
    }

    public static /* synthetic */ void access$200() {
        dispatchBegin();
    }

    public static /* synthetic */ void access$300() {
        dispatchEnd();
    }

    public static /* synthetic */ boolean access$400() {
        return isPauseUpdateTime;
    }

    public static /* synthetic */ long access$500() {
        return sCurrentDiffTime;
    }

    public static /* synthetic */ long access$502(long r5) {
        sCurrentDiffTime = r5;
        return r5;
    }

    public static /* synthetic */ long access$600() {
        return getCurrentTime();
    }

    public static /* synthetic */ long access$700() {
        return sDiffTime;
    }

    public static /* synthetic */ Object access$800() {
        return updateTimeLock;
    }

    public static /* synthetic */ void access$900() {
        realRelease();
    }

    private static void dispatchBegin() {
        sCurrentDiffTime = a.f18319b - sDiffTime;
        isPauseUpdateTime = false;
        Object r5 = updateTimeLock;
        monitor-enter(r5);
        updateTimeLock.notify();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void dispatchEnd() {
        isPauseUpdateTime = true;
    }

    public static long getCurrentDiffTime() {
        return sCurrentDiffTime;
    }

    private static long getCurrentTime() {
        return SystemClock.uptimeMillis();
    }

    public static long getDiffTime() {
        return sDiffTime;
    }

    public static MethodCollector getInstance() {
        return sInstance;
    }

    public static int getLastMethodIndex() {
        return sIndex - 1;
    }

    public static long getLastMethodTime() {
        return getTime(sBuffer[sIndex - 1]);
    }

    private static long getTime(long r5) {
        return r5 & 8796093022207L;
    }

    private static HandlerThread getTimerUpdateThread() {
        HandlerThread r5 = new HandlerThread("trace_time_update_thread");
        r5.start();
        return r5;
    }

    public static String getVisibleScene() {
        return ActivityLifeObserver.getInstance().getTopActivityClassName();
    }

    public static void i(int r5, long r10) {
        if (sDontRecord == false) goto L6;
        return;
    L6:
        if (r5 < METHOD_ID_MAX) goto L9;
        return;
    L9:
        if (Thread.currentThread() == sMainThread) goto L11;
        return;
    L11:
        if (assertIn == false) goto L13;
        return;
    L13:
        assertIn = true;
        if (r10 == 0) goto L16;
        sCurrentDiffTime = r10 - sDiffTime;
        sCurrentDiffTime &= 8796093022207L;
    L16:
        long r11 = ((((long) r5) << 43) | Long.MIN_VALUE) | sCurrentDiffTime;
        long[] r12 = sBuffer;
        int r13 = sIndex;
        r12[r13] = r11;
        int r14 = r13 + 1;
        sIndex = r14;
        if (r14 != 600000) goto L19;
        sIndex = 0;
    L19:
        assertIn = false;
        e r15 = sIndexRecordTail;
        if (r15 != null) goto L23;
        return;
    L23:
        if (r15.f16605a != sIndex) goto L30;
        e r16 = r15.d;
        sIndexRecordTail = r16;
        if (r16 == null) goto L27;
        r16.f16607c = null;
        return;
    L27:
        sIndexRecordHead = null;
        return;
    }

    public static boolean isRealTrace() {
        if (status >= 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static e maskIndex(String r5, long r10) {
        if (sIndexRecordHead != null) goto L9;
        e r11 = new e(sIndex);
        sIndexRecordHead = r11;
        if (r10 > 0) goto L7;
        r10 = SystemClock.uptimeMillis();
    L7:
        r11.f = r10;
        e r12 = sIndexRecordHead;
        r12.e = r5;
        sIndexRecordTail = r12;
        return r12;
    L9:
        int r13 = sIndex;
        e r14 = new e(r13);
        if (r10 > 0) goto L12;
        r10 = SystemClock.uptimeMillis();
    L12:
        r14.f = r10;
        r14.e = r5;
        e r15 = sIndexRecordHead;
        r14.f16607c = r15;
        r15.f16606b = r13 - 1;
        r15.d = r14;
        sIndexRecordHead = r14;
        return r14;
    }

    public static void o(int r5, long r10) {
        if (sDontRecord == false) goto L6;
        return;
    L6:
        if (r5 < METHOD_ID_MAX) goto L9;
        return;
    L9:
        if (Thread.currentThread() == sMainThread) goto L11;
        return;
    L11:
        if (r10 == 0) goto L13;
        sCurrentDiffTime = r10 - sDiffTime;
        sCurrentDiffTime &= 8796093022207L;
    L13:
        long r11 = (((long) r5) << 43) | sCurrentDiffTime;
        long[] r12 = sBuffer;
        int r13 = sIndex;
        r12[r13] = r11;
        int r14 = r13 + 1;
        sIndex = r14;
        if (r14 != 600000) goto L16;
        sIndex = 0;
    L16:
        e r15 = sIndexRecordTail;
        if (r15 != null) goto L19;
        return;
    L19:
        if (r15.f16605a != sIndex) goto L27;
        e r16 = r15.d;
        sIndexRecordTail = r16;
        if (r16 == null) goto L23;
        r16.f16607c = null;
        return;
    L23:
        sIndexRecordHead = null;
        return;
    }

    private static void realExecute() {
        sCurrentDiffTime = getCurrentTime() - sDiffTime;
        sHandler.removeCallbacksAndMessages(null);
        sHandler.postDelayed(sUpdateDiffTimeRunnable, 5);
        Handler r5 = sHandler;
        com.bytedance.android.anniex.worker.a r10 = new com.bytedance.android.anniex.worker.a(18);
        checkStartExpiredRunnable = r10;
        r5.postDelayed(r10, 15000);
        a r11 = looperMonitorListener;
        CopyOnWriteArrayList r12 = i.f18334c;
        monitor-enter(r12);
        if (r11 != null) goto L14;
    L10:
        monitor-exit(r12);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L14:
        if (r12.contains(r11) == true) goto L10;
        r12.add(r11);     // Catch: Throwable -> L8
        c.f16598k.getClass();     // Catch: Throwable -> L8
        goto L10
    }

    private static void realRelease() {
        Object r5 = statusLock;
        monitor-enter(r5);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (status != Integer.MAX_VALUE) goto L7;
    L11:
        status = -3;     // Catch: Throwable -> L9
        sDontRecord = true;     // Catch: Throwable -> L9
        sReleaseOnMainThread = new com.bytedance.android.anniex.worker.a(17);     // Catch: Throwable -> L9
    L12:
        monitor-exit(r5);     // Catch: Throwable -> L9
        return;
    L7:
        if (status != (-4)) goto L12;
        goto L12
    }

    public static void unRegisterListener() {
        a r5 = looperMonitorListener;
        if (r5 != null) goto L5;
        boolean r10 = i.f18332a;
        return;
    L5:
        CopyOnWriteArrayList r11 = i.f18334c;
        monitor-enter(r11);
        r11.remove(r5);     // Catch: Throwable -> L10
        c.f16598k.getClass();     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public long[] copyAllData() {
        e r5 = sIndexRecordHead;     // Catch: Throwable -> L15
        if (r5 == null) goto L14;
        e r10 = sIndexRecordTail;     // Catch: Throwable -> L15
        if (r10 == null) goto L14;
        if (r5 == r10) goto L14;
        int r11 = r5.f16606b;     // Catch: Throwable -> L15
        if (r11 != 0) goto L12;
        r11 = sIndex - 1;     // Catch: Throwable -> L15
    L12:
        return copyData(r10.f16605a, r11);
    L14:
        return null;
    }

    public long[] copyData(e r5) {
        return copyData(r5, new e(sIndex - 1));
    }

    public String evilMethodString(long[] r5, long r10) {
        if (r5 != null) goto L5;
        return "";
    L5:
        LinkedList r11 = new LinkedList();
        f.C(r5, r11, r10);
        ListIterator r12 = r11.listIterator(r11.size());
    L7:
        if (r12.hasPrevious() == false) goto L13;
        d6.f r13 = (d6.f) r12.previous();
        if (r13 == null) goto L7;
        if (r13.f16609b >= 1) goto L7;
        r12.remove();
        goto L7
    L13:
        StringBuilder r14 = new StringBuilder();
        f.B(r11, r14);
        return r14.toString();
    }

    public e getCurrentMethodIndex(String r5) {
        int r10 = sIndex - 1;
        e r11 = new e(r10);
        r11.e = r5;
        if (r10 < 0) goto L7;
        long[] r12 = sBuffer;
        if (r10 >= r12.length) goto L7;
        r11.f = getTime(r12[r10]);
    L7:
        return r11;
    }

    public String getEvilMethod(long r5, long r10) {
        long r11 = SystemClock.uptimeMillis();
        return evilMethodString(copyData(r5, r10), r11);
    }

    public boolean isAlive() {
        if (status < 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void onStart() {
        Object r5 = statusLock;
        monitor-enter(r5);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (status < 2) goto L7;
    L15:
        monitor-exit(r5);     // Catch: Throwable -> L11
        return;
    L7:
        if (status < (-2)) goto L15;
        sHandler.removeCallbacks(checkStartExpiredRunnable);     // Catch: Throwable -> L11
        if (sBuffer == null) goto L14;
        status = 2;     // Catch: Throwable -> L11
        sDontRecord = false;     // Catch: Throwable -> L11
        goto L15
    L14:
        throw new RuntimeException("MethodCollector sBuffer == null");     // Catch: Throwable -> L11
    }

    public void onStop() {
        Object r5 = statusLock;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (status != 2) goto L9;
        status = -1;     // Catch: Throwable -> L7
        sDontRecord = true;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r5);     // Catch: Throwable -> L7
    }

    public long[] copyData(e r5, e r10) {
        if (status != (-3)) goto L6;
        return null;
    L6:
        long[] r11 = new long[0];
        r5.getClass();     // Catch: OutOfMemoryError -> L9
        r10.getClass();     // Catch: OutOfMemoryError -> L9
        return copyData(r5.f16605a - 1, r10.f16605a);
    L9:
        return r11;
    }

    private long[] copyData(long r10, long r11) {
        e r5 = sIndexRecordHead;
        if (r5 == null) goto L19;
        e r12 = sIndexRecordTail;
        if (r12 == null) goto L28;
    L7:
        if (r5 == r12) goto L14;
        e r13 = r5.f16607c;
        if (r13.f > r11) goto L10;
        e r14 = r12.d;
        if (r14.f >= r10) goto L14;
        r12 = r14;
        goto L7
    L10:
        r5 = r13;
    L14:
        int r15 = r5.f16606b;
        if (r15 != 0) goto L18;
        r15 = sIndex - 1;
    L18:
        return copyData(r12.f16605a, r15);
    L28:
        return null;
    L19:
        return null;
    }

    public long[] copyData(int r5, int r10) {
        long[] r11 = new long[0];
        int r12 = Math.max(0, r5);
        int r13 = Math.max(0, r10);
        if (r13 <= r12) goto L5;
        int r14 = (r13 - r12) + 1;
        long[] r15 = new long[r14];
        System.arraycopy(sBuffer, r12, r15, 0, r14);
        return r15;
    L5:
        if (r13 >= r12) goto L9;
        int r16 = r13 + 1;
        long[] r17 = sBuffer;
        long[] r18 = new long[(r17.length - r12) + r16];
        System.arraycopy(r17, r12, r18, 0, r17.length - r12);
        long[] r19 = sBuffer;
        System.arraycopy(r19, 0, r18, r19.length - r12, r16);
        return r18;
    L9:
        return r11;
    }
}
