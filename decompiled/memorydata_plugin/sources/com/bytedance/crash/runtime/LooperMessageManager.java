package com.bytedance.crash.runtime;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Printer;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
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

    static /* synthetic */ void access$000(LooperMessageManager r0, String r1) {
        r0.dispatching(r1);
    }

    static /* synthetic */ void access$100(LooperMessageManager r0, String r1) {
        r0.finished(r1);
    }

    static /* synthetic */ Printer access$200() {
        return sOriginalPrinter;
    }

    static /* synthetic */ Printer access$300() {
        return sPrinter;
    }

    private void dispatching(String r3) {
        this.mFinishDispatchTime = -1;
        invokeCallbackList(this.mStartRunnableList, r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        NpthLog.e(e);
    }

    private void finished(String r3) {
        this.mFinishDispatchTime = SystemClock.uptimeMillis();
        invokeCallbackList(this.mEndRunnableList, r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        NpthLog.w(e);
    }

    private Printer getCurrentPrinter() {
        Field r0 = ZeusTransformUtils.forName("android.os.Looper", "com.obric.memorydata.plugin").getDeclaredField("mLogging");     // Catch: Exception -> L5
        r0.setAccessible(true);     // Catch: Exception -> L5
        return (Printer) ZeusTransformUtils.preCheckCast(r0.get(Looper.getMainLooper()), Printer.class, "com.obric.memorydata.plugin");
    L5:
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

    private static void invokeCallbackList(List<? extends Printer> r5, String r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.isEmpty() == true) goto L23;
        int r0 = r7.size();     // Catch: Throwable -> L14
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L24;
        Printer r3 = (Printer) ZeusTransformUtils.preCheckCast(r7.get(r2), Printer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r3 == null) goto L22;
        r3.println(r6);     // Catch: Throwable -> L14
        r2 = r2 + 1;
        goto L8
    L22:
        return;
    L24:
        return;
    L14:
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
        if ((SystemClock.uptimeMillis() - this.mFinishDispatchTime) <= 5000) goto L7;
        return true;
    }

    public void registerSyncEndPrinter(Printer r3) {
        Printer r4 = (Printer) ZeusTransformUtils.wrapperContextForParams(r3, Printer.class, "com.obric.memorydata.plugin");
        this.mEndRunnableList.add(r4);
    }

    public synchronized void registerSyncStartPrinter(Printer r3) {
        monitor-enter(this);
        Printer r4 = (Printer) ZeusTransformUtils.wrapperContextForParams(r3, Printer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        this.mStartRunnableList.add(r4);     // Catch: Throwable -> L6
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
        Printer r1 = getCurrentPrinter();
        sOriginalPrinter = r1;
        Printer r0 = sPrinter;
        if (r1 != r0) goto L8;
        sOriginalPrinter = null;
    L8:
        Looper.getMainLooper().setMessageLogging(r0);
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
