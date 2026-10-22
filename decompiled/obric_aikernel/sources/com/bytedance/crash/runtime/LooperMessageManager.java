package com.bytedance.crash.runtime;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Printer;
import com.bytedance.crash.util.NpthLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class LooperMessageManager {
    private static final char END = '<';
    private static final long MESSAGE_WAIT_INTERVAL_MAX = 5000;
    private static final char START = '>';
    private static LooperMessageManager sInstance;
    private static Printer sOriginalPrinter;
    private static final Printer sPrinter = null;
    private final List<Printer> mEndRunnableList;
    private long mFinishDispatchTime;
    private boolean mIsStarted;
    private final List<Printer> mStartRunnableList;

    static {
        sPrinter = new AnonymousClass1();
    }

    private LooperMessageManager() {
        this.mFinishDispatchTime = -1;
        this.mStartRunnableList = new ArrayList();
        this.mEndRunnableList = new ArrayList();
    }

    static /* synthetic */ void access$000(LooperMessageManager r10, String r11) {
        r10.dispatching(r11);
    }

    static /* synthetic */ void access$100(LooperMessageManager r10, String r11) {
        r10.finished(r11);
    }

    static /* synthetic */ Printer access$200() {
        return sOriginalPrinter;
    }

    static /* synthetic */ Printer access$300() {
        return sPrinter;
    }

    private void dispatching(String r10) {
        this.mFinishDispatchTime = -1;
        invokeCallbackList(this.mStartRunnableList, r10);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        NpthLog.e(e);
    }

    private void finished(String r10) {
        this.mFinishDispatchTime = SystemClock.uptimeMillis();
        invokeCallbackList(this.mEndRunnableList, r10);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        NpthLog.w(e);
    }

    private Printer getCurrentPrinter() {
        Field r10 = Class.forName("android.os.Looper").getDeclaredField("mLogging");     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        return (Printer) r10.get(Looper.getMainLooper());
    L4:
        e = move-exception;
        NpthLog.w(e);
        return null;
    }

    public static LooperMessageManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(LooperMessageManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new LooperMessageManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LooperMessageManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private static void invokeCallbackList(List<? extends Printer> r10, String r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L22;
        int r12 = r10.size();     // Catch: Throwable -> L13
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L23;
        Printer r14 = r10.get(r13);     // Catch: Throwable -> L13
        if (r14 == null) goto L21;
        r14.println(r11);     // Catch: Throwable -> L13
        r13 = r13 + 1;
        goto L7
    L21:
        return;
    L23:
        return;
    L13:
        th = move-exception;
        NpthLog.e(th);
        return;
    }

    public boolean isStarted() {
        return this.mIsStarted;
    }

    public boolean noMessageDispatch() {
        if (this.mFinishDispatchTime != (-1)) goto L5;
    L7:
        return false;
    L5:
        if ((SystemClock.uptimeMillis() - this.mFinishDispatchTime) <= MESSAGE_WAIT_INTERVAL_MAX) goto L7;
        return true;
    }

    public void registerSyncEndPrinter(Printer r10) {
        this.mEndRunnableList.add(r10);
    }

    public synchronized void registerSyncStartPrinter(Printer r10) {
        monitor-enter(this);
        this.mStartRunnableList.add(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void start() {
        if (this.mIsStarted == false) goto L5;
        return;
    L5:
        this.mIsStarted = true;
        Printer r10 = getCurrentPrinter();
        sOriginalPrinter = r10;
        Printer r11 = sPrinter;
        if (r10 != r11) goto L8;
        sOriginalPrinter = null;
    L8:
        Looper.getMainLooper().setMessageLogging(r11);
    }

    public void stop() {
        if (this.mIsStarted == true) goto L5;
        return;
    L5:
        this.mIsStarted = false;
        if (getCurrentPrinter() == sPrinter) goto L8;
        return;
    L8:
        if (sOriginalPrinter == null) goto L12;
        Looper.getMainLooper().setMessageLogging(sOriginalPrinter);
        return;
    }
}
