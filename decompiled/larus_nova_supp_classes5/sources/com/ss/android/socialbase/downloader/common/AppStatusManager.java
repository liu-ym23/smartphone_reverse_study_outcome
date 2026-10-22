package com.ss.android.socialbase.downloader.common;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class AppStatusManager {
    private static final int STATUS_BACKGROUND = 0;
    private static final int STATUS_FOREGROUND = 1;
    private static final int STATUS_UNKNOWN = -1;
    private volatile boolean isActivityOnPause;
    private volatile int mAppStatus;
    private final List<AppStatusChangeListener> mAppStatusChangeListeners;
    private Application mApplication;
    private final Application.ActivityLifecycleCallbacks mCallbacks;
    private WeakReference<Activity> mTopActivity;
    private int mTopActivityHashCode;

    public static class Holder {
        private static final AppStatusManager INSTANCE = null;

        private Holder() {
        }

        static {
            INSTANCE = new AppStatusManager(null);
        }

        public static /* synthetic */ AppStatusManager access$000() {
            return INSTANCE;
        }
    }

    private boolean checkAppForeground() {
        Application r1 = this.mApplication;     // Catch: Throwable -> L20
        if (r1 != null) goto L6;
        return false;
    L6:
        ActivityManager r2 = (ActivityManager) r1.getSystemService("activity");     // Catch: Throwable -> L20
        String r3 = r1.getPackageName();     // Catch: Throwable -> L20
        List<ActivityManager.RunningAppProcessInfo> r4 = r2.getRunningAppProcesses();     // Catch: Throwable -> L20
        if (r4 != null) goto L9;
        return false;
    L9:
        if (r4.isEmpty() == true) goto L32;
        Iterator<ActivityManager.RunningAppProcessInfo> r5 = r4.iterator();     // Catch: Throwable -> L20
    L13:
        if (r5.hasNext() == false) goto L33;
        ActivityManager.RunningAppProcessInfo r6 = r5.next();     // Catch: Throwable -> L20
        if (r6.importance != 100) goto L13;
        if (TextUtils.equals(r6.processName, r3) == false) goto L13;
        return true;
    L33:
        return false;
    L32:
        return false;
    L20:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    private void dispatchAppBackground() {
        int r0 = 0;
        this.mAppStatus = 0;
        Object[] r1 = collectAppSwitchListeners();
        if (r1 == null) goto L7;
        int r2 = r1.length;
    L5:
        if (r0 >= r2) goto L9;
        ((AppStatusChangeListener) r1[r0]).onAppBackground();
        r0 = r0 + 1;
        goto L5
    L9:
        return;
    }

    private void dispatchAppForeground() {
        this.mAppStatus = 1;
        Object[] r0 = collectAppSwitchListeners();
        if (r0 == null) goto L7;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L9;
        ((AppStatusChangeListener) r0[r2]).onAppForeground();
        r2 = r2 + 1;
        goto L5
    L9:
        return;
    }

    public void setInnerAppStatusChangeCaller(InnerAppStatusChangeCaller r1) {
    }

    private Object[] collectAppSwitchListeners() {
        List<AppStatusChangeListener> r0 = this.mAppStatusChangeListeners;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mAppStatusChangeListeners.size() <= 0) goto L7;
        Object[] r1 = this.mAppStatusChangeListeners.toArray();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = null;
        goto L8
    }

    private int getRealStatus() {
        int r0 = this.mAppStatus;
        if (r0 != (-1)) goto L6;
        boolean r1 = checkAppForeground();
        this.mAppStatus = r1 ? 1 : 0;
        return r1 ? 1 : 0;
    L6:
        return r0;
    }

    public Activity getTopActivity() {
        WeakReference<Activity> r0 = this.mTopActivity;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get();
    }

    private AppStatusManager() {
        this.mAppStatusChangeListeners = new ArrayList();
        this.mAppStatus = -1;
        this.isActivityOnPause = false;
        this.mCallbacks = new AnonymousClass1(this);
    }

    public static AppStatusManager getInstance() {
        return Holder.access$000();
    }

    public boolean isAppBackground() {
        if (getRealStatus() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isAppFocus() {
        if (isAppForeground() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.isActivityOnPause == true) goto L7;
        return true;
    }

    public boolean isAppForeground() {
        if (getRealStatus() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public /* synthetic */ AppStatusManager(AnonymousClass1 r1) {
        this();
    }

    public static /* synthetic */ int access$300(AppStatusManager r0) {
        return r0.mTopActivityHashCode;
    }

    public static /* synthetic */ void access$500(AppStatusManager r0) {
        r0.dispatchAppForeground();
    }

    public static /* synthetic */ void access$600(AppStatusManager r0) {
        r0.dispatchAppBackground();
    }

    public void init(Context r2) {
        if (this.mApplication == null) goto L5;
        return;
    L5:
        if ((r2 instanceof Application) == false) goto L18;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mApplication != null) goto L10;
        Application r3 = (Application) r2;     // Catch: Throwable -> L12
        this.mApplication = r3;     // Catch: Throwable -> L12
        r3.registerActivityLifecycleCallbacks(this.mCallbacks);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    }

    public void registerAppSwitchListener(AppStatusChangeListener r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        List<AppStatusChangeListener> r0 = this.mAppStatusChangeListeners;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mAppStatusChangeListeners.contains(r3) == true) goto L9;
        this.mAppStatusChangeListeners.add(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void unregisterAppSwitchListener(AppStatusChangeListener r3) {
        List<AppStatusChangeListener> r0 = this.mAppStatusChangeListeners;
        monitor-enter(r0);
        this.mAppStatusChangeListeners.remove(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ WeakReference access$202(AppStatusManager r0, WeakReference r1) {
        r0.mTopActivity = r1;
        return r1;
    }

    public static /* synthetic */ int access$302(AppStatusManager r0, int r1) {
        r0.mTopActivityHashCode = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$402(AppStatusManager r0, boolean r1) {
        r0.isActivityOnPause = r1;
        return r1;
    }
}
