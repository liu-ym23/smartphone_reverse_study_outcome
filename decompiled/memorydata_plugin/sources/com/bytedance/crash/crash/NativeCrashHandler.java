package com.bytedance.crash.crash;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.IPreCrashCallback;
import com.bytedance.crash.game.GameScriptStack;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.CrashListener;
import com.bytedance.crash.monitor.MonitorManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class NativeCrashHandler {
    public static volatile boolean isDumpHistoryMessage;
    public static volatile boolean isDumpViewTree;
    private static volatile boolean isEnableDumpAllThreadStack;
    private JSONArray mAllData;
    private final CrashDumper mCrashDumper;

    NativeCrashHandler(Context r3, CrashDumper r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mCrashDumper = r4;
        NativeBridge.loadLibrary();
        NativeBridge.startNativeCrashMonitor(r5, r4.getDirectory());
    }

    private void handleCallbacks(String r5) {
        Iterator<CrashListener> r0 = MonitorManager.getCrashListenerList().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        handleMonitorCallbacks((CrashListener) ZeusTransformUtils.preCheckCast(r0.next(), CrashListener.class, "com.obric.memorydata.plugin"), r5);
        goto L4
    }

    private void handleMonitorCallbacks(CrashListener r3, String r4) {
        if (r3 == null) goto L9;
        Iterator<ICrashCallback> r2 = r3.getUserDataCenter().getCrashCallback(CrashType.NATIVE).iterator();
    L5:
        if (r2.hasNext() == false) goto L16;
        ICrashCallback r5 = (ICrashCallback) ZeusTransformUtils.preCheckCast(r2.next(), ICrashCallback.class, "com.obric.memorydata.plugin");
        r5.onCrash(CrashType.NATIVE, r4, null);     // Catch: Throwable -> L10
        goto L5
    L16:
        return;
    }

    private void handlePreCallbacks(long r4) {
        AppMonitor r3 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L13
        if (r3 != null) goto L5;
        return;
    L5:
        Iterator<IPreCrashCallback> r5 = r3.getUserDataCenter().getPreCrashCallback(CrashType.NATIVE).iterator();     // Catch: Throwable -> L13
    L7:
        if (r5.hasNext() == false) goto L21;
        IPreCrashCallback r0 = (IPreCrashCallback) ZeusTransformUtils.preCheckCast(r5.next(), IPreCrashCallback.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        r0.onCrash(CrashType.NATIVE, r4);     // Catch: Throwable -> L12
        goto L7
    L21:
        return;
    }

    public static void setDumpAllThreadStackEnable(boolean r0) {
        isEnableDumpAllThreadStack = r0;
    }

    public static void setDumpHistoryMessageEnable(boolean r0) {
        isDumpHistoryMessage = r0;
    }

    public static void setDumpViewTreeEnable(boolean r0) {
        isDumpViewTree = r0;
    }

    void nativeDumperFinished(long r9, int r11) {
        if (r9 <= 0) goto L5;
        handlePreCallbacks(r9);
    L5:
        this.mCrashDumper.dumpJavaInfoAfterNative(r9, isEnableDumpAllThreadStack, isDumpViewTree, isDumpHistoryMessage, r11);
        if (r9 <= 0) goto L11;
        File r10 = this.mCrashDumper.getDirectory();
        GameScriptStack.dump(r10);
        String r12 = NativeBridge.loadNativeCrashBacktrace(r10.getAbsolutePath());
        if (TextUtils.isEmpty(r12) == true) goto L12;
        handleCallbacks(r12);
        return;
    L12:
        return;
    }
}
