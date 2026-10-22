package com.bytedance.crash.crash;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.IPreCrashCallback;
import com.bytedance.crash.game.GameScriptStack;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.CrashListener;
import com.bytedance.crash.monitor.MonitorManager;
import java.io.File;
import java.util.Iterator;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class NativeCrashHandler {
    public static volatile boolean isDumpHistoryMessage;
    public static volatile boolean isDumpViewTree;
    private static volatile boolean isEnableDumpAllThreadStack;
    private JSONArray mAllData;
    private final CrashDumper mCrashDumper;

    NativeCrashHandler(@NonNull Context r10, @NonNull CrashDumper r11) {
        this.mCrashDumper = r11;
        NativeBridge.loadLibrary();
        NativeBridge.startNativeCrashMonitor(r10, r11.getDirectory());
    }

    private void handleCallbacks(String r10) {
        Iterator<CrashListener> r11 = MonitorManager.getCrashListenerList().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        handleMonitorCallbacks(r11.next(), r10);
        goto L4
    }

    private void handleMonitorCallbacks(CrashListener r10, String r11) {
        if (r10 == null) goto L9;
        Iterator<ICrashCallback> r12 = r10.getUserDataCenter().getCrashCallback(CrashType.NATIVE).iterator();
    L5:
        if (r12.hasNext() == false) goto L16;
        ICrashCallback r13 = r12.next();
        r13.onCrash(CrashType.NATIVE, r11, null);     // Catch: Throwable -> L10
        goto L5
    L16:
        return;
    }

    private void handlePreCallbacks(long r10) {
        AppMonitor r11 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L13
        if (r11 != null) goto L5;
        return;
    L5:
        Iterator<IPreCrashCallback> r12 = r11.getUserDataCenter().getPreCrashCallback(CrashType.NATIVE).iterator();     // Catch: Throwable -> L13
    L7:
        if (r12.hasNext() == false) goto L21;
        IPreCrashCallback r13 = r12.next();     // Catch: Throwable -> L13
        r13.onCrash(CrashType.NATIVE, r10);     // Catch: Throwable -> L12
        goto L7
    L21:
        return;
    }

    public static void setDumpAllThreadStackEnable(boolean r10) {
        isEnableDumpAllThreadStack = r10;
    }

    public static void setDumpHistoryMessageEnable(boolean r10) {
        isDumpHistoryMessage = r10;
    }

    public static void setDumpViewTreeEnable(boolean r10) {
        isDumpViewTree = r10;
    }

    void nativeDumperFinished(long r10, int r11) {
        if (r10 <= 0) goto L5;
        handlePreCallbacks(r10);
    L5:
        this.mCrashDumper.dumpJavaInfoAfterNative(r10, isEnableDumpAllThreadStack, isDumpViewTree, isDumpHistoryMessage, r11);
        if (r10 <= 0) goto L11;
        File r12 = this.mCrashDumper.getDirectory();
        GameScriptStack.dump(r12);
        String r13 = NativeBridge.loadNativeCrashBacktrace(r12.getAbsolutePath());
        if (TextUtils.isEmpty(r13) == true) goto L12;
        handleCallbacks(r13);
        return;
    L12:
        return;
    }
}
