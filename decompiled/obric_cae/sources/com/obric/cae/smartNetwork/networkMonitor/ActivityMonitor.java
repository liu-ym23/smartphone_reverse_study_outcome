package com.obric.cae.smartNetwork.networkMonitor;

import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.app.TaskStackListener;
import android.content.ComponentName;
import android.content.Context;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityMonitor {
    private static final String DESKTOP_ACTIVITY = "com.android.launcher3";
    private static final String TAG = "ActivityMonitor";
    private static volatile ActivityMonitor sInstance;
    private final ActivityTaskManager mActivityTaskManager;
    private String mClassName;
    private final Set<ActivityMonitorListener> mListeners;
    private String mPackageName;
    private final TaskStackListener mTaskStackListener;

    public interface ActivityMonitorListener {
        void onActivityChanged(String r8, boolean r10);

        void onActivityPinned(String r8);

        void onActivityUnpinned();
    }

    public interface ActivityMonitorListenerEx extends ActivityMonitorListener {
        void onActivityChangedWithDetails(String r8, String r10, boolean r11);
    }

    public static abstract class DefaultActivityMonitorListener implements ActivityMonitorListener {
        public DefaultActivityMonitorListener() {
        }

        @Override // com.obric.cae.smartNetwork.networkMonitor.ActivityMonitor.ActivityMonitorListener
        public void onActivityChanged(String r8, boolean r10) {
        }

        @Override // com.obric.cae.smartNetwork.networkMonitor.ActivityMonitor.ActivityMonitorListener
        public void onActivityPinned(String r8) {
        }

        @Override // com.obric.cae.smartNetwork.networkMonitor.ActivityMonitor.ActivityMonitorListener
        public void onActivityUnpinned() {
        }
    }

    public static abstract class DefaultActivityMonitorListenerEx extends DefaultActivityMonitorListener implements ActivityMonitorListenerEx {
        public DefaultActivityMonitorListenerEx() {
        }

        @Override // com.obric.cae.smartNetwork.networkMonitor.ActivityMonitor.ActivityMonitorListenerEx
        public void onActivityChangedWithDetails(String r8, String r10, boolean r11) {
        }
    }

    private ActivityMonitor(Context r8) {
        this.mListeners = Collections.synchronizedSet(new HashSet());
        this.mPackageName = "";
        this.mClassName = "";
        TaskStackListener r10 = new AnonymousClass1(this);
        this.mTaskStackListener = r10;
        ActivityTaskManager r11 = ActivityTaskManager.getInstance();
        this.mActivityTaskManager = r11;
        r11.registerTaskStackListener(r10);
        this.mPackageName = getForegroundPackageName();
    }

    public static /* synthetic */ void access$000(ActivityMonitor r8) {
        r8.notifyActivityChanged();
    }

    public static /* synthetic */ Set access$100(ActivityMonitor r8) {
        return r8.mListeners;
    }

    private String getForegroundPackageName() {
        List r8 = this.mActivityTaskManager.getTasks(1);
        if (r8 != null) goto L5;
    L11:
        return "";
    L5:
        if (r8.isEmpty() == true) goto L11;
        ComponentName r10 = ((ActivityManager.RunningTaskInfo) r8.get(0)).topActivity;
        if (r10 == null) goto L11;
        return r10.getPackageName();
    }

    public static ActivityMonitor getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(ActivityMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ActivityMonitor(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ActivityMonitor.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void notifyActivityChanged() {
        List r8 = this.mActivityTaskManager.getTasks(1);
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.isEmpty() == true) goto L37;
        ComponentName r10 = ((ActivityManager.RunningTaskInfo) r8.get(0)).topActivity;
        if (r10 == null) goto L35;
        String r11 = r10.getPackageName();
        String r12 = r10.getClassName();
        if (r11.equals(this.mPackageName) == true) goto L12;
    L14:
        this.mPackageName = r11;
        this.mClassName = r12;
        boolean r13 = true ^ r11.equals(DESKTOP_ACTIVITY);
        Set<ActivityMonitorListener> r14 = this.mListeners;
        monitor-enter(r14);
        Iterator<ActivityMonitorListener> r15 = this.mListeners.iterator();     // Catch: Throwable -> L24
    L18:
        if (r15.hasNext() == false) goto L22;
        ActivityMonitorListener r16 = r15.next();     // Catch: Throwable -> L24
        r16.onActivityChanged(r11, r13);     // Catch: Throwable -> L24
        if ((r16 instanceof ActivityMonitorListenerEx) == false) goto L18;
        ((ActivityMonitorListenerEx) r16).onActivityChangedWithDetails(r11, r12, r13);     // Catch: Throwable -> L24
        goto L18
    L22:
        monitor-exit(r14);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    L12:
        if (r12.equals(this.mClassName) == false) goto L14;
        return;
    L35:
        return;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public void registerActivityListener(ActivityMonitorListener r8) {
        Set<ActivityMonitorListener> r10 = this.mListeners;
        monitor-enter(r10);
        this.mListeners.add(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unregisterActivityListener(ActivityMonitorListener r8) {
        Set<ActivityMonitorListener> r10 = this.mListeners;
        monitor-enter(r10);
        this.mListeners.remove(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
