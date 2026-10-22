package com.obric.cae.cloud.applog;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.utils.ByteIODebugHelper;
import i4.k;
import org.json.JSONObject;
import r3.a;
import r3.c;
import r3.g;
import r3.m;
import r3.n;
import x4.m0;
import x4.s;

/* JADX INFO: loaded from: classes.dex */
public class ByteIOUtils {
    public static final String APP_CHANNEL = "cae_release";
    public static final String APP_ID = "941134";
    public static final String APP_NAME = "CAE";
    private static final String TAG = "ByteIOUtils";
    private static String globalDid = "";
    private static String globalIid = "";
    private static boolean isInitialized = false;
    private static Application mApplication;
    private static Context mContext;

    public ByteIOUtils() {
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ String access$102(String r8) {
        globalDid = r8;
        return r8;
    }

    public static /* synthetic */ String access$202(String r8) {
        globalIid = r8;
        return r8;
    }

    public static /* synthetic */ Context access$300() {
        return mContext;
    }

    public static /* synthetic */ Application access$400() {
        return mApplication;
    }

    public static void addDataObserver(g r8) {
        if (r8 == null) goto L14;
        c r10 = a.f11390a;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r10.f11408p != null) goto L8;
        r10.f11408p = new v4.a();     // Catch: Throwable -> L11
    L8:
        r10.f11408p.f12719a.add(r8);     // Catch: Throwable -> L11
        monitor-exit(r10);
        CommSenseLog.d(TAG, "Added data observer");
        return;
    }

    public static g createDefaultDataObserver() {
        return new AnonymousClass1();
    }

    public static void flushEvents() {
        if (isInitialized == true) goto L21;
        CommSenseLog.w(TAG, "ByteIO not initialized, cannot flush events");
        return;
    L21:
        String r8 = TAG;     // Catch: Exception -> L18
        CommSenseLog.d(r8, "Attempting to flush events...");     // Catch: Exception -> L18
        c r10 = a.f11390a;     // Catch: Exception -> L18
        if (r10.f11413u == false) goto L13;
        if (r10.f11405m == null) goto L11;
        Handler r11 = r10.f11405m.f13947w;     // Catch: Exception -> L18
        r11.removeMessages(14);     // Catch: Exception -> L18
        r11.sendEmptyMessage(14);     // Catch: Exception -> L18
    L11:
        r10.f11417y.b(k.N, 1);     // Catch: Exception -> L18
    L16:
        CommSenseLog.d(r8, "Events flushed");     // Catch: Exception -> L18
        return;
    L13:
        if (r10.f11405m == null) goto L15;
        r10.f11405m.e(true, null);     // Catch: Exception -> L18
    L15:
        r10.f11417y.b(k.N, 1);     // Catch: Exception -> L18
    L18:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to flush events: " + e.getMessage());
    }

    public static String getGlobalDid() {
        return globalDid;
    }

    public static String getGlobalIid() {
        return globalIid;
    }

    public static void init(Context r8, Application r10, boolean r11) {
        mContext = r8;
        mApplication = r10;
        if (isInitialized == false) goto L11;
        CommSenseLog.d(TAG, "ByteIO already initialized");
        return;
    L11:
        String r12 = TAG;     // Catch: Exception -> L8
        CommSenseLog.d(r12, "Initializing ByteIO...");     // Catch: Exception -> L8
        m r13 = new m();     // Catch: Exception -> L8
        r13.f11429e = APP_NAME;     // Catch: Exception -> L8
        r13.f11438n = true;     // Catch: Exception -> L8
        long r14 = r8.getPackageManager().getPackageInfo(r8.getPackageName(), 0).getLongVersionCode();     // Catch: Exception -> L8
        r13.f11431g = r14;     // Catch: Exception -> L8
        r13.f11433i = r14;     // Catch: Exception -> L8
        r13.f11432h = r14;     // Catch: Exception -> L8
        n.a r15 = new n.a();     // Catch: Exception -> L8
        r15.f11448e = new s(m0.a("https://log-klink.zijieapi.com", false), false);     // Catch: Exception -> L8
        r15.f11444a = new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"};     // Catch: Exception -> L8
        r15.f11445b = new String[]{"https://rtlog.zijieapi.com/service/2/app_log/"};     // Catch: Exception -> L8
        r15.f11446c = "https://log.zijieapi.com/service/2/log_settings/";     // Catch: Exception -> L8
        r13.f11430f = new n(r15);     // Catch: Exception -> L8
        r13.f11434j = new AppLogNetworkClient();     // Catch: Exception -> L8
        r13.f11426b = true;     // Catch: Exception -> L8
        r13.f11436l = true;     // Catch: Exception -> L8
        r13.f11435k = true;     // Catch: Exception -> L8
        c r16 = a.f11390a;     // Catch: Exception -> L8
        r16.f11409q = false;     // Catch: Exception -> L8
        r16.f11417y.h(0, "encrypt_enable");     // Catch: Exception -> L8
        r16.f11414v = true;     // Catch: Exception -> L8
        addDataObserver(createDefaultDataObserver());     // Catch: Exception -> L8
        ByteIODebugHelper.initEventsSender(r8);     // Catch: Exception -> L8
        a.b(r8, r13);     // Catch: Exception -> L8
        isInitialized = true;     // Catch: Exception -> L8
        CommSenseLog.d(r12, "ByteIO initialization successful");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        CommSenseLog.e(TAG, "ByteIO initialization failed: " + e.getMessage());
        e.printStackTrace();
    }

    public static void initDevtools() {
        ByteIODebugHelper.initDevtools();
    }

    public static boolean isInitialized() {
        return isInitialized;
    }

    public static void refreshGlobalId() {
        globalDid = a.f11390a.c();     // Catch: Exception -> L5
        globalIid = a.a();     // Catch: Exception -> L5
        CommSenseLog.d(TAG, "Refreshed global ID - did: " + globalDid + ", iid: " + globalIid);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to refresh global ID: " + e.getMessage());
    }

    public static void removeDataObserver(g r8) {
        if (r8 == null) goto L8;
        v4.a r10 = a.f11390a.f11408p;
        if (r10 == null) goto L6;
        r10.f12719a.remove(r8);
    L6:
        CommSenseLog.d(TAG, "Removed data observer");
        return;
    }

    public static void trackEvent(String r8) {
        if (isInitialized == true) goto L11;
        CommSenseLog.w(TAG, "ByteIO not initialized, event not tracked: " + r8);
        return;
    L11:
        a.f11390a.j(r8, null);     // Catch: Exception -> L8
        CommSenseLog.d(TAG, "Tracked event: " + r8);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to track event: " + e.getMessage());
    }

    public static void trackEvent(String r8, String r10) {
        if (isInitialized == true) goto L11;
        CommSenseLog.w(TAG, "ByteIO not initialized, event not tracked: " + r8);
        return;
    L11:
        a.f11390a.j(r8, r10);     // Catch: Exception -> L8
        CommSenseLog.d(TAG, "Tracked event: " + r8 + " with params: " + r10);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to track event: " + e.getMessage());
    }

    public static void trackEvent(String r8, JSONObject r10) {
        if (isInitialized == true) goto L15;
        CommSenseLog.w(TAG, "ByteIO not initialized, event not tracked: " + r8);
        return;
    L15:
        a.f11390a.k(r8, r10);     // Catch: Exception -> L12
        String r11 = TAG;     // Catch: Exception -> L12
        StringBuilder r12 = new StringBuilder("Tracked event V3: ");     // Catch: Exception -> L12
        r12.append(r8);     // Catch: Exception -> L12
        r12.append(" with params: ");     // Catch: Exception -> L12
        if (r10 == null) goto L9;
        String r13 = r10.toString();     // Catch: Exception -> L12
    L10:
        r12.append(r13);     // Catch: Exception -> L12
        CommSenseLog.d(r11, r12.toString());     // Catch: Exception -> L12
        return;
    L9:
        r13 = "null";
    L12:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to track event V3: " + e.getMessage(), e);
    }
}
