package com.bytedance.crash.monitor;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.Flavor;
import com.bytedance.crash.Global;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.NpthCore;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.runtime.DefaultWorkThread;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MonitorManager {
    private static AppMonitor sAppMonitor;
    private static EnsureDeliverer sDeliverer;

    public MonitorManager() {
    }

    public static AppMonitor createAppMonitor(@NonNull Context r10, @NonNull String r11, @NonNull String r12, long r13) {
        Global.setContext(r10);
        monitor-enter(AppMonitor.class);
        AppMonitor r14 = sAppMonitor;     // Catch: Throwable -> L15
        if (r14 == null) goto L8;
        monitor-exit(AppMonitor.class);     // Catch: Throwable -> L15
        return r14;
    L8:
        AppMonitor r15 = new AppMonitor(r11, r12, r13);     // Catch: Throwable -> L15
        sAppMonitor = r15;     // Catch: Throwable -> L15
        monitor-exit(AppMonitor.class);     // Catch: Throwable -> L15
        EnsureDeliverer r16 = sDeliverer;
        if (r16 == null) goto L13;
        r16.setMonitor(r15);
    L13:
        Flavor.startAppMonitor(r10, sAppMonitor);
        return sAppMonitor;
    L15:
        th = move-exception;
        throw th;
    }

    public static synchronized EventMonitor createEventMonitor(@NonNull Context r11, String r12, long r13, long r15, String r17) {
        monitor-enter(MonitorManager.class);
        Global.setContext(r11);     // Catch: Throwable -> L7
        final EventMonitor r10 = new EventMonitor(r12, r17, r13, r15, 0);     // Catch: Throwable -> L7
        NpthCore.initForEventMonitor();     // Catch: Throwable -> L7
        DefaultWorkThread.post(new AnonymousClass1(r10));     // Catch: Throwable -> L7
        monitor-exit(MonitorManager.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static AppMonitor createInnerAppMonitor(@NonNull Context r10, @NonNull ICommonParams r11) {
        Global.setContext(r10);
        monitor-enter(AppMonitor.class);
        AppMonitor r12 = sAppMonitor;     // Catch: Throwable -> L15
        if (r12 == null) goto L8;
        monitor-exit(AppMonitor.class);     // Catch: Throwable -> L15
        return r12;
    L8:
        InnerAppMonitor r13 = new InnerAppMonitor(r11);     // Catch: Throwable -> L15
        sAppMonitor = r13;     // Catch: Throwable -> L15
        monitor-exit(AppMonitor.class);     // Catch: Throwable -> L15
        EnsureDeliverer r14 = sDeliverer;
        if (r14 == null) goto L13;
        r14.setMonitor(r13);
    L13:
        NpthCore.initForCrashMonitor(r10, Global.getRootDirectory(r10));
        return sAppMonitor;
    L15:
        th = move-exception;
        throw th;
    }

    public static SdkMonitor createSdkMonitor(@NonNull Context r10, @NonNull String r11, @NonNull String r12, long r13, String[] r14, String[] r15) {
        Global.setContext(r10);
        SdkMonitor r16 = new SdkMonitor(r11, r12, r13, r14, r15);
        Flavor.startEventMonitor(r10, r16);
        return r16;
    }

    @NonNull
    public static EnsureDeliverer getAppEnsureManager() {
        if (sDeliverer != null) goto L15;
        monitor-enter(MonitorManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sDeliverer != null) goto L9;
        sDeliverer = new EnsureDeliverer(sAppMonitor);     // Catch: Throwable -> L11
    L9:
        monitor-exit(MonitorManager.class);     // Catch: Throwable -> L11
    L15:
        return sDeliverer;
    }

    @Nullable
    public static AppMonitor getAppMonitor() {
        return sAppMonitor;
    }

    @Nullable
    public static String getAppMonitorAid() {
        AppMonitor r10 = sAppMonitor;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getAppId();
    }

    @NonNull
    public static UserDataCenter getAppMonitorUserDataCenter() {
        return AppMonitor.getDefaultUserDataCenter();
    }

    @Nullable
    public static EventMonitor getCrashListenerByAid(String r10) {
        return CrashListener.getCrashListenerByAid(r10);
    }

    @NonNull
    public static ArrayList<CrashListener> getCrashListenerList() {
        return CrashListener.getCrashListenerList();
    }
}
