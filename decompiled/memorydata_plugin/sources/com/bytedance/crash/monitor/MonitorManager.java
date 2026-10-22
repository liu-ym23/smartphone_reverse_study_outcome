package com.bytedance.crash.monitor;

import android.content.Context;
import com.bytedance.crash.Flavor;
import com.bytedance.crash.Global;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.NpthCore;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class MonitorManager {
    private static AppMonitor sAppMonitor;
    private static EnsureDeliverer sDeliverer;

    public MonitorManager() {
    }

    public static AppMonitor createAppMonitor(Context r2, String r3, String r4, long r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Global.setContext(r6);
        monitor-enter(AppMonitor.class);
        AppMonitor r1 = sAppMonitor;     // Catch: Throwable -> L15
        if (r1 == null) goto L8;
        monitor-exit(AppMonitor.class);     // Catch: Throwable -> L15
        return r1;
    L8:
        AppMonitor r7 = new AppMonitor(r3, r4, r5);     // Catch: Throwable -> L15
        sAppMonitor = r7;     // Catch: Throwable -> L15
        monitor-exit(AppMonitor.class);     // Catch: Throwable -> L15
        EnsureDeliverer r8 = sDeliverer;
        if (r8 == null) goto L13;
        r8.setMonitor(r7);
    L13:
        Flavor.startAppMonitor(r6, sAppMonitor);
        return sAppMonitor;
    L15:
        th = move-exception;
        throw th;
    }

    public static synchronized EventMonitor createEventMonitor(Context r11, String r12, long r13, long r15, String r17) {
        monitor-enter(MonitorManager.class);
        Global.setContext((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
        final EventMonitor r0 = new EventMonitor(r12, r17, r13, r15, 0);     // Catch: Throwable -> L7
        NpthCore.initForEventMonitor();     // Catch: Throwable -> L7
        DefaultWorkThread.post(new AnonymousClass1(r0));     // Catch: Throwable -> L7
        monitor-exit(MonitorManager.class);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public static AppMonitor createInnerAppMonitor(Context r2, ICommonParams r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        ICommonParams r5 = (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r3, ICommonParams.class, "com.obric.memorydata.plugin");
        Global.setContext(r4);
        monitor-enter(AppMonitor.class);
        AppMonitor r1 = sAppMonitor;     // Catch: Throwable -> L15
        if (r1 == null) goto L8;
        monitor-exit(AppMonitor.class);     // Catch: Throwable -> L15
        return r1;
    L8:
        InnerAppMonitor r6 = new InnerAppMonitor(r5);     // Catch: Throwable -> L15
        sAppMonitor = r6;     // Catch: Throwable -> L15
        monitor-exit(AppMonitor.class);     // Catch: Throwable -> L15
        EnsureDeliverer r7 = sDeliverer;
        if (r7 == null) goto L13;
        r7.setMonitor(r6);
    L13:
        NpthCore.initForCrashMonitor(r4, Global.getRootDirectory(r4));
        return sAppMonitor;
    L15:
        th = move-exception;
        throw th;
    }

    public static SdkMonitor createSdkMonitor(Context r8, String r9, String r10, long r11, String[] r13, String[] r14) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Global.setContext(r12);
        SdkMonitor r7 = new SdkMonitor(r9, r10, r11, r13, r14);
        Flavor.startEventMonitor(r12, r7);
        return r7;
    }

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

    public static AppMonitor getAppMonitor() {
        return sAppMonitor;
    }

    public static String getAppMonitorAid() {
        AppMonitor r0 = sAppMonitor;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAppId();
    }

    public static UserDataCenter getAppMonitorUserDataCenter() {
        return AppMonitor.getDefaultUserDataCenter();
    }

    public static EventMonitor getCrashListenerByAid(String r0) {
        return CrashListener.getCrashListenerByAid(r0);
    }

    public static ArrayList<CrashListener> getCrashListenerList() {
        return CrashListener.getCrashListenerList();
    }
}
