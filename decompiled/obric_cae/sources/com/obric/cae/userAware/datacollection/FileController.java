package com.obric.cae.userAware.datacollection;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import androidx.work.d;
import androidx.work.e;
import androidx.work.f;
import androidx.work.g;
import androidx.work.n;
import androidx.work.o;
import androidx.work.r;
import androidx.work.v;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.utils.UserAwareUtil;
import defpackage.a;
import defpackage.b;
import j1.b0;
import j1.u;
import java.io.File;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import s1.c;
import yd.i;

/* JADX INFO: loaded from: classes2.dex */
public class FileController {
    public static final int DEFAULT_RUN_MODE = -1;
    public static final String ONE_TIME_TAG = null;
    public static final int ONE_TIME_UPLOAD_TASKS_MODE = 0;
    private static final String PERIODIC_TAG = null;
    public static final int PERIODIC_UPLOAD_TASKS_MODE = 1;
    private static final int REPEAT_INTERVAL_MINUTES = 1;
    private static final String TAG = "FileController";
    private static final int UPLOAD_HOUR = 24;
    private static final int UPLOAD_MINUTE = 0;
    private static final int UPLOAD_SECOND = 0;
    private static final String UPLOAD_WORKER_TAG = "com.obric.cae.userAware.datacollection.UploadWorker";

    @SuppressLint({"StaticFieldLeak"})
    private static FileController instance;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private ConnectivityManager.NetworkCallback mWifiNetworkCallback;

    /* JADX INFO: renamed from: com.obric.cae.userAware.datacollection.FileController$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class TaskStatusInfo {
        UUID activeTaskId;
        int blockedTaskCount;
        boolean hasActiveTask;

        private TaskStatusInfo() {
            this.hasActiveTask = false;
            this.blockedTaskCount = 0;
            this.activeTaskId = null;
        }

        public /* synthetic */ TaskStatusInfo(AnonymousClass1 r8) {
            this();
        }
    }

    static {
        PERIODIC_TAG = a.e("FileController", "_periodic");
        ONE_TIME_TAG = a.e("FileController", "_one_time");
    }

    private FileController(Context r8) {
        if (r8 == null) goto L7;
        this.mContext = r8;
        this.mConnectivityManager = (ConnectivityManager) r8.getSystemService("connectivity");
        return;
    L7:
        throw new IllegalArgumentException("Context and deviceId cannot be null");
    }

    private long calculateInitialDelay() {
        Calendar r8 = Calendar.getInstance();
        r8.set(11, 24);
        r8.set(12, 0);
        r8.set(13, 0);
        if (r8.getTimeInMillis() >= System.currentTimeMillis()) goto L6;
        r8.add(6, 1);
    L6:
        return r8.getTimeInMillis() - System.currentTimeMillis();
    }

    private void cleanupAllPeriodicTasks() {
        b0 r8 = b0.f(this.mContext);
        String r10 = PERIODIC_TAG;     // Catch: Exception -> L5
        r8.getClass();     // Catch: Exception -> L5
        c r11 = new c(r8, r10);     // Catch: Exception -> L5
        r8.f8454d.a(r11);     // Catch: Exception -> L5
        c r12 = new c(r8, UPLOAD_WORKER_TAG);     // Catch: Exception -> L5
        r8.f8454d.a(r12);     // Catch: Exception -> L5
        CaeLog.i(TAG, "Immediate cleanup of all periodic tasks initiated");     // Catch: Exception -> L5
    L7:
        CaeLog.i(TAG, "Immediate cleanup of all periodic tasks initiated");
        return;
    L5:
        e = move-exception;
        String r13 = TAG;
        b.k(e, new StringBuilder("Error during cleanup: "), r13);
        goto L7
    }

    private r createUploadWorkRequest(long r16) {
        File r8 = UserAwareUtil.getNearbyLogPathFile(this.mContext.getApplicationContext());
        d.a r10 = new d.a();
        r10.f2816a = n.f2934m;
        Set r14 = i.o1(r10.f2819d);
        long r11 = r10.f2817b;
        long r12 = r10.f2818c;
        d r13 = new d(r10.f2816a, false, false, false, false, r11, r12, r14);
        e.a r15 = new e.a();
        String r17 = r8.getAbsolutePath();
        Objects.requireNonNull(r17);
        r15.c("DirectoryPath", r17);
        r15.c("DeviceId", UserAwareUtil.getDeviceIMEI(this.mContext));
        e r18 = r15.a();
        r.a r19 = new r.a(TimeUnit.DAYS).d(r16, TimeUnit.MILLISECONDS);
        r19.f2964b.f11348j = r13;
        r19.f2964b.f11343e = r18;
        String r20 = PERIODIC_TAG;
        he.i.f(r20, LocationMonitorConst.TAG);
        r19.f2965c.add(r20);
        return r19.a();
    }

    public static synchronized FileController getInstance(Context r8) {
        monitor-enter(FileController.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (instance != null) goto L7;
        instance = new FileController(r8);     // Catch: Throwable -> L10
    L7:
        FileController r10 = instance;     // Catch: Throwable -> L10
        monitor-exit(FileController.class);
        return r10;
    }

    private void startPeriodicUpload() {
        long r8 = calculateInitialDelay();     // Catch: Exception -> L5
        cleanupAllPeriodicTasks();     // Catch: Exception -> L5
        String r10 = TAG;     // Catch: Exception -> L5
        CaeLog.d(r10, "Initial delay for upload task: " + r8 + " ms");     // Catch: Exception -> L5
        r r11 = createUploadWorkRequest(r8);     // Catch: Exception -> L5
        b0 r12 = b0.f(this.mContext);     // Catch: Exception -> L5
        String r13 = PERIODIC_TAG;     // Catch: Exception -> L5
        f[] r14 = f.f2826a;     // Catch: Exception -> L5
        r12.getClass();     // Catch: Exception -> L5
        new u(r12, r13, g.f2827a, Collections.singletonList(r11)).z();     // Catch: Exception -> L5
        CaeLog.d(r10, "Upload work request enqueued with unique work, Initial delay for upload task: " + r8 + " ms");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "Failed to schedule upload task", e);
    }

    public TaskStatusInfo checkAndCleanOneTimeTasks() {
        b0 r10 = v.c(this.mContext);
        AnonymousClass1 r8 = null;
        List r11 = (List) r10.h(ONE_TIME_TAG).get();     // Catch: Throwable -> L19
        TaskStatusInfo r12 = new TaskStatusInfo(r8);     // Catch: Throwable -> L19
        Iterator r13 = r11.iterator();     // Catch: Throwable -> L19
    L4:
        if (r13.hasNext() == false) goto L18;
        androidx.work.u r14 = (androidx.work.u) r13.next();     // Catch: Throwable -> L19
        androidx.work.u.a r15 = r14.b();     // Catch: Throwable -> L19
        if (r15 == androidx.work.u.a.f2953b) goto L9;
        if (r15 == androidx.work.u.a.f2952a) goto L15;
        if (r15 != androidx.work.u.a.f2956o) goto L4;
    L15:
        r12.blockedTaskCount++;     // Catch: Throwable -> L19 Throwable -> L19
        r10.d(r14.a());     // Catch: Throwable -> L19 Throwable -> L19
        String r16 = TAG;     // Catch: Throwable -> L19 Throwable -> L19
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L19 Throwable -> L19
        r17.append("Cancelled stuck task: ");     // Catch: Throwable -> L19 Throwable -> L19
        r17.append(r14.a());     // Catch: Throwable -> L19 Throwable -> L19
        r17.append(" state: ");     // Catch: Throwable -> L19 Throwable -> L19
        r17.append(r15);     // Catch: Throwable -> L19 Throwable -> L19
    L16:
        CaeLog.d(r16, r17.toString());     // Catch: Throwable -> L19 Throwable -> L19
        goto L4
    L9:
        r12.hasActiveTask = true;     // Catch: Throwable -> L19 Throwable -> L19
        r12.activeTaskId = r14.a();     // Catch: Throwable -> L19 Throwable -> L19
        r16 = TAG;     // Catch: Throwable -> L19 Throwable -> L19
        r17 = new StringBuilder();     // Catch: Throwable -> L19 Throwable -> L19
        r17.append("Found active task: ");     // Catch: Throwable -> L19 Throwable -> L19
        r17.append(r14.a());     // Catch: Throwable -> L19 Throwable -> L19
        r17.append(" state: ");     // Catch: Throwable -> L19 Throwable -> L19
        r17.append(r15);     // Catch: Throwable -> L19 Throwable -> L19
        goto L16
    L18:
        return r12;
    L19:
        e = move-exception;
        CaeLog.e(TAG, "Error checking task status", e);
        return new TaskStatusInfo(r8);
    }

    public void cleanup() {
        b0 r8 = b0.f(this.mContext);     // Catch: Exception -> L9
        String r10 = TAG;     // Catch: Exception -> L9
        r8.getClass();     // Catch: Exception -> L9
        c r11 = new c(r8, r10);     // Catch: Exception -> L9
        r8.f8454d.a(r11);     // Catch: Exception -> L9
        ConnectivityManager r12 = this.mConnectivityManager;     // Catch: Exception -> L9
        if (r12 == null) goto L7;
        ConnectivityManager.NetworkCallback r13 = this.mWifiNetworkCallback;     // Catch: Exception -> L9
        if (r13 == null) goto L7;
        r12.unregisterNetworkCallback(r13);     // Catch: Exception -> L9
        this.mWifiNetworkCallback = null;     // Catch: Exception -> L9
    L7:
        CaeLog.d(r10, "All work tasks cancelled during cleanup");     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        CaeLog.e(TAG, "Error during cleanup", e);
    }

    public o createOneTimeUploadWorkRequest(long r16) {
        File r8 = UserAwareUtil.getNearbyLogPathFile(this.mContext.getApplicationContext());
        CaeLog.d(TAG, "createOneTimeUploadWorkRequest and file path is " + r8.getAbsolutePath());
        d.a r10 = new d.a();
        r10.f2816a = n.f2934m;
        Set r14 = i.o1(r10.f2819d);
        d r11 = new d(r10.f2816a, false, false, false, false, r10.f2817b, r10.f2818c, r14);
        e.a r12 = new e.a();
        String r13 = r8.getAbsolutePath();
        Objects.requireNonNull(r13);
        r12.c("DirectoryPath", r13);
        r12.c("DeviceId", UserAwareUtil.getDeviceIMEI(this.mContext));
        e r15 = r12.a();
        o.a r17 = new o.a(UploadWorker.class).d(r16, TimeUnit.MILLISECONDS);
        r17.f2964b.f11348j = r11;
        r17.f2964b.f11343e = r15;
        String r18 = ONE_TIME_TAG;
        he.i.f(r18, LocationMonitorConst.TAG);
        r17.f2965c.add(r18);
        return r17.a();
    }

    public boolean isOneTimeTaskRunning() {
        TaskStatusInfo r8 = checkAndCleanOneTimeTasks();
        if (r8.hasActiveTask == false) goto L5;
    L8:
        boolean r10 = true;
    L9:
        String r11 = TAG;
        StringBuilder r12 = android.aimedia.a.l("OneTime task running status: ", r10, " (active: ");
        r12.append(r8.hasActiveTask);
        r12.append(", blocked: ");
        r12.append(r8.blockedTaskCount);
        r12.append(")");
        CaeLog.d(r11, r12.toString());
        return r10;
    L5:
        if (r8.blockedTaskCount > 0) goto L8;
        r10 = false;
        goto L9
    }

    public void setRunMode(int r8) {
        if (r8 != 0) goto L4;
        startOneTimeUpload();
        return;
    L4:
        if (r8 != 1) goto L10;
        startPeriodicUpload();
        return;
    }

    public String startOneTimeUpload() {
        if (checkAndCleanOneTimeTasks().hasActiveTask == false) goto L5;
        CaeLog.d(TAG, "Existing active task running, skip new task creation");
        checkAndCleanOneTimeTasks();
    L5:
        o r8 = createOneTimeUploadWorkRequest(0);
        b0 r10 = b0.f(this.mContext);
        String r11 = ONE_TIME_TAG;
        g r12 = g.f2827a;
        r10.getClass();
        r10.b(r11, Collections.singletonList(r8));
        CaeLog.d(TAG, "Started new one-time upload task with ID: " + r8.f2960a);
        return r8.f2960a.toString();
    }
}
