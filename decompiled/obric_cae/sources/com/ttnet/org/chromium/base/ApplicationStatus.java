package com.ttnet.org.chromium.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.view.Window;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class ApplicationStatus {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TOOLBAR_CALLBACK_INTERNAL_WRAPPER_CLASS = "androidx.appcompat.internal.app.ToolbarActionBar$ToolbarCallbackWrapper";
    private static final String TOOLBAR_CALLBACK_WRAPPER_CLASS = "androidx.appcompat.app.ToolbarActionBar$ToolbarCallbackWrapper";
    private static final String WINDOW_PROFILER_CALLBACK = "com.android.tools.profiler.support.event.WindowProfilerCallback";

    @SuppressLint({"StaticFieldLeak"})
    private static Activity sActivity;
    private static final Map<Activity, ActivityInfo> sActivityInfo = null;
    private static final ObserverList<ApplicationStateListener> sApplicationStateListeners = null;

    @GuardedBy("sActivityInfo")
    @SuppressLint({"SupportAnnotationUsage"})
    private static int sCurrentApplicationState;
    private static final ObserverList<ActivityStateListener> sGeneralActivityStateListeners = null;
    private static ApplicationStateListener sNativeApplicationStateListener;
    private static final ObserverList<WindowFocusChangedListener> sWindowFocusListeners = null;

    public static class ActivityInfo {
        private ObserverList<ActivityStateListener> mListeners;
        private int mStatus;

        private ActivityInfo() {
            this.mStatus = 6;
            this.mListeners = new ObserverList();
        }

        public ObserverList<ActivityStateListener> getListeners() {
            return this.mListeners;
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setStatus(int r8) {
            this.mStatus = r8;
        }

        public /* synthetic */ ActivityInfo(AnonymousClass1 r8) {
            this();
        }
    }

    public interface ActivityStateListener {
        void onActivityStateChange(Activity r8, int r10);
    }

    public interface ApplicationStateListener {
        void onApplicationStateChange(int r8);
    }

    public static class WindowCallbackProxy implements InvocationHandler {
        private final Activity mActivity;
        private final Window.Callback mCallback;

        public WindowCallbackProxy(Activity r8, Window.Callback r10) {
            this.mCallback = r10;
            this.mActivity = r8;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r8, Method r10, Object[] r11) {
            if (r10.getName().equals("onWindowFocusChanged") == true) goto L5;
        L18:
            return r10.invoke(this.mCallback, r11);
        L12:
            e = move-exception;
            if ((e.getCause() instanceof AbstractMethodError) == true) goto L16;
            throw e;
        L16:
            throw e.getCause();
        L5:
            if (r11.length != 1) goto L18;
            Object r12 = r11[0];
            if ((r12 instanceof Boolean) == false) goto L18;
            onWindowFocusChanged(((Boolean) r12).booleanValue());
            return null;
        }

        public void onWindowFocusChanged(boolean r8) {
            this.mCallback.onWindowFocusChanged(r8);
            Iterator r10 = ApplicationStatus.access$000().iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            ((WindowFocusChangedListener) r10.next()).onWindowFocusChanged(this.mActivity, r8);
            goto L4
        }
    }

    public interface WindowFocusChangedListener {
        void onWindowFocusChanged(Activity r8, boolean r10);
    }

    static {
        sActivityInfo = Collections.synchronizedMap(new HashMap());
        sCurrentApplicationState = 0;
        sGeneralActivityStateListeners = new ObserverList();
        sApplicationStateListeners = new ObserverList();
        sWindowFocusListeners = new ObserverList();
    }

    private ApplicationStatus() {
    }

    public static /* synthetic */ ObserverList access$000() {
        return sWindowFocusListeners;
    }

    public static /* synthetic */ Activity access$100() {
        return sActivity;
    }

    public static /* synthetic */ Activity access$102(Activity r8) {
        sActivity = r8;
        return r8;
    }

    public static /* synthetic */ void access$200(Activity r8, int r10) {
        onStateChange(r8, r10);
    }

    public static /* synthetic */ ApplicationStateListener access$400() {
        return sNativeApplicationStateListener;
    }

    public static /* synthetic */ ApplicationStateListener access$402(ApplicationStateListener r8) {
        sNativeApplicationStateListener = r8;
        return r8;
    }

    public static /* synthetic */ void access$500(int r8) {
        nativeOnApplicationStateChange(r8);
    }

    public static void destroyForJUnitTests() {
        Map<Activity, ActivityInfo> r8 = sActivityInfo;
        monitor-enter(r8);
        sApplicationStateListeners.clear();     // Catch: Throwable -> L7
        sGeneralActivityStateListeners.clear();     // Catch: Throwable -> L7
        r8.clear();     // Catch: Throwable -> L7
        sWindowFocusListeners.clear();     // Catch: Throwable -> L7
        sCurrentApplicationState = 0;     // Catch: Throwable -> L7
        sActivity = null;     // Catch: Throwable -> L7
        sNativeApplicationStateListener = null;     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @GuardedBy("sActivityInfo")
    private static int determineApplicationStateLocked() {
        Iterator<ActivityInfo> r8 = sActivityInfo.values().iterator();
        boolean r10 = false;
        boolean r11 = false;
    L4:
        if (r8.hasNext() == false) goto L15;
        int r12 = r8.next().getStatus();
        if (r12 == 4) goto L11;
        if (r12 == 5) goto L11;
        if (r12 == 6) goto L11;
        return 1;
    L11:
        if (r12 == 4) goto L12;
        if (r12 != 5) goto L4;
        r11 = true;
        goto L4
    L12:
        r10 = true;
        goto L4
    L15:
        if (r10 == false) goto L18;
        return 2;
    L18:
        if (r11 == false) goto L21;
        return 3;
    L21:
        return 4;
    }

    public static Activity getLastTrackedFocusedActivity() {
        return sActivity;
    }

    public static List<Activity> getRunningActivities() {
        Map<Activity, ActivityInfo> r8 = sActivityInfo;
        monitor-enter(r8);
        ArrayList r10 = new ArrayList(r8.keySet());     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static int getStateForActivity(Activity r8) {
        if (r8 != null) goto L5;
        return 6;
    L5:
        ActivityInfo r10 = sActivityInfo.get(r8);
        if (r10 != null) goto L8;
        return 6;
    L8:
        return r10.getStatus();
    }

    @CalledByNative
    public static int getStateForApplication() {
        Map<Activity, ActivityInfo> r8 = sActivityInfo;
        monitor-enter(r8);
        int r10 = sCurrentApplicationState;     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean hasVisibleActivities() {
        int r8 = getStateForApplication();
        if (r8 != 1) goto L5;
        return true;
    L5:
        if (r8 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public static void initialize(Application r8) {
        Map<Activity, ActivityInfo> r10 = sActivityInfo;
        monitor-enter(r10);
        sCurrentApplicationState = 4;     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        registerWindowFocusChangedListener(new AnonymousClass1());
        r8.registerActivityLifecycleCallbacks(new AnonymousClass2());
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static boolean isEveryActivityDestroyed() {
        return sActivityInfo.isEmpty();
    }

    public static boolean isInitialized() {
        Map<Activity, ActivityInfo> r8 = sActivityInfo;
        monitor-enter(r8);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sCurrentApplicationState == 0) goto L7;
        boolean r10 = true;
    L8:
        monitor-exit(r8);     // Catch: Throwable -> L10
        return r10;
    L7:
        r10 = false;
        goto L8
    }

    private static native void nativeOnApplicationStateChange(int r8);

    private static void onStateChange(Activity r8, int r10) {
        if (r8 == null) goto L43;
        if (sActivity != null) goto L6;
    L11:
        sActivity = r8;
    L12:
        int r11 = getStateForApplication();
        Map<Activity, ActivityInfo> r12 = sActivityInfo;
        monitor-enter(r12);
        AnonymousClass1 r13 = null;
        if (r12.containsKey(r8) == true) goto L17;
        r12.put(r8, new ActivityInfo(r13));     // Catch: Throwable -> L39
    L17:
        ActivityInfo r14 = r12.get(r8);     // Catch: Throwable -> L39
        r14.setStatus(r10);     // Catch: Throwable -> L39
        if (r10 != 6) goto L22;
        r12.remove(r8);     // Catch: Throwable -> L39
        if (r8 != sActivity) goto L22;
        sActivity = null;     // Catch: Throwable -> L39
    L22:
        sCurrentApplicationState = determineApplicationStateLocked();     // Catch: Throwable -> L39
        monitor-exit(r12);     // Catch: Throwable -> L39
        Iterator<ActivityStateListener> r15 = r14.getListeners().iterator();
    L26:
        if (r15.hasNext() == false) goto L28;
        r15.next().onActivityStateChange(r8, r10);
        goto L26
    L28:
        Iterator<ActivityStateListener> r16 = sGeneralActivityStateListeners.iterator();
    L30:
        if (r16.hasNext() == false) goto L32;
        r16.next().onActivityStateChange(r8, r10);
        goto L30
    L32:
        int r17 = getStateForApplication();
        if (r17 == r11) goto L38;
        Iterator<ApplicationStateListener> r18 = sApplicationStateListeners.iterator();
    L36:
        if (r18.hasNext() == false) goto L49;
        r18.next().onApplicationStateChange(r17);
        goto L36
    L49:
        return;
    L38:
        return;
    L39:
        th = move-exception;
        throw th;
    L6:
        if (r10 == 1) goto L11;
        if (r10 == 3) goto L11;
        if (r10 != 2) goto L12;
    L43:
        throw new IllegalArgumentException("null activity is not supported");
    }

    @VisibleForTesting
    public static void onStateChangeForTesting(Activity r8, int r10) {
        onStateChange(r8, r10);
    }

    public static void registerApplicationStateListener(ApplicationStateListener r8) {
        sApplicationStateListeners.addObserver(r8);
    }

    @SuppressLint({"NewApi"})
    public static void registerStateListenerForActivity(ActivityStateListener r8, Activity r10) {
        sActivityInfo.get(r10).getListeners().addObserver(r8);
    }

    public static void registerStateListenerForAllActivities(ActivityStateListener r8) {
        sGeneralActivityStateListeners.addObserver(r8);
    }

    @CalledByNative
    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new AnonymousClass3());
    }

    public static void registerWindowFocusChangedListener(WindowFocusChangedListener r8) {
        sWindowFocusListeners.addObserver(r8);
    }

    public static void unregisterActivityStateListener(ActivityStateListener r8) {
        sGeneralActivityStateListeners.removeObserver(r8);
        Map<Activity, ActivityInfo> r10 = sActivityInfo;
        monitor-enter(r10);
        Iterator<ActivityInfo> r11 = r10.values().iterator();     // Catch: Throwable -> L10
    L6:
        if (r11.hasNext() == false) goto L8;
        r11.next().getListeners().removeObserver(r8);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void unregisterApplicationStateListener(ApplicationStateListener r8) {
        sApplicationStateListeners.removeObserver(r8);
    }

    public static void unregisterWindowFocusChangedListener(WindowFocusChangedListener r8) {
        sWindowFocusListeners.removeObserver(r8);
    }
}
