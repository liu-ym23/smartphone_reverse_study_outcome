package com.obric.cae.utils;

import android.os.Bundle;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetTracker;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class AppPerformanceManger {
    private static final String TAG = "AppPerformanceManger";
    L4NetTracker mL4NetTracker;
    int mLastStartPerformancePid;

    public AppPerformanceManger(L4NetTracker r8) {
        this.mLastStartPerformancePid = -1;
        this.mL4NetTracker = r8;
    }

    public void disablePerformanceSchedMode() {
        int r8 = this.mLastStartPerformancePid;
        if (r8 != (-1)) goto L5;
        return;
    L5:
        inovkeStartPerformanceSchedMode(false, r8);
        this.mLastStartPerformancePid = -1;
    }

    public void enablePerformanceSchedMode(int r8) {
        int r10 = this.mLastStartPerformancePid;
        if (r10 != r8) goto L6;
        return;
    L6:
        if (r10 == (-1)) goto L8;
        disablePerformanceSchedMode();
    L8:
        inovkeStartPerformanceSchedMode(true, r8);
        this.mLastStartPerformancePid = r8;
    }

    public void foregroundAppManage(L4NetEvaluate.L4NetForegroundApp r8) {
        if (r8.strategy == L4NetEvaluate.ForegroundAppStrategy.TICKET_GRABBING) goto L8;
        int r10 = this.mLastStartPerformancePid;
        if (r10 == (-1)) goto L15;
        inovkeStartPerformanceSchedMode(false, r10);
        this.mLastStartPerformancePid = -1;
        return;
    L15:
        return;
    L8:
        int r11 = this.mLastStartPerformancePid;
        if (r11 != r8.pid) goto L11;
        return;
    L11:
        if (r11 == (-1)) goto L13;
        inovkeStartPerformanceSchedMode(false, r11);
    L13:
        int r12 = r8.pid;
        this.mLastStartPerformancePid = r12;
        inovkeStartPerformanceSchedMode(true, r12);
    }

    public void inovkeStartPerformanceSchedMode(boolean r8, int r10) {
        CommSenseLog.i(TAG, "inovkeStartPerformanceSchedMode, enable " + r8 + " pid " + r10);
        Class<?> r11 = Class.forName("android.app.CollaborationManager");     // Catch: Exception -> L5
        Class<?> r12 = Class.forName("android.app.PerformanceSchedModeConfig");     // Catch: Exception -> L5
        Object r13 = r12.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L5
        r12.getField("enable").setBoolean(r13, r8);     // Catch: Exception -> L5
        r12.getField("pid").setInt(r13, r10);     // Catch: Exception -> L5
        r12.getField("timeout").setInt(r13, 30000);     // Catch: Exception -> L5
        r12.getField("cpu").setInt(r13, 1);     // Catch: Exception -> L5
        r12.getField("gpu").setInt(r13, 1);     // Catch: Exception -> L5
        r12.getField("type").setInt(r13, r12.getField("TYPE_TOP_APP").getInt(null));     // Catch: Exception -> L5
        Bundle r14 = new Bundle();     // Catch: Exception -> L5
        r14.putBoolean("uclamp", true);     // Catch: Exception -> L5
        r12.getField("extras").set(r13, r14);     // Catch: Exception -> L5
        CommSenseLog.i(TAG, "inovke startPerformanceSchedMode, ret " + ((Integer) r11.getMethod("startPerformanceSchedMode", new Class[]{r12}).invoke(null, new Object[]{r13})));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "inovke startPerformanceSchedMode failed", e);
        if ((e instanceof InvocationTargetException) == false) goto L12;
        CommSenseLog.e(TAG, "inovke startPerformanceSchedMode exception realcause:", ((InvocationTargetException) e).getCause());
        return;
    }
}
