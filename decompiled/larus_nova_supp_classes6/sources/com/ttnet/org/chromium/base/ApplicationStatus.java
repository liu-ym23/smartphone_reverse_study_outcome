package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.view.Window;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@JNINamespace("base::android")
public class ApplicationStatus {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TOOLBAR_CALLBACK_WRAPPER_CLASS = "androidx.appcompat.app.ToolbarActionBar$ToolbarCallbackWrapper";
    private static Activity sActivity;
    private static final Map<Activity, ActivityInfo> sActivityInfo = null;
    private static ObserverList<ApplicationStateListener> sApplicationStateListeners;
    private static int sCurrentApplicationState;
    private static ObserverList<ActivityStateListener> sGeneralActivityStateListeners;
    private static ApplicationStateListener sNativeApplicationStateListener;
    private static ObserverList<WindowFocusChangedListener> sWindowFocusListeners;

    public interface ApplicationStateListener {
        void onApplicationStateChange(int r1);
    }

    private ApplicationStatus() {
    }

    static {
        sActivityInfo = Collections.synchronizedMap(new HashMap());
        sCurrentApplicationState = 0;
    }

    public static void destroyForJUnitTests() {
        Map<Activity, ActivityInfo> r0 = sActivityInfo;
        monitor-enter(r0);
        ObserverList<ApplicationStateListener> r1 = sApplicationStateListeners;     // Catch: Throwable -> L16
        if (r1 == null) goto L7;
        r1.clear();     // Catch: Throwable -> L16
    L7:
        ObserverList<ActivityStateListener> r2 = sGeneralActivityStateListeners;     // Catch: Throwable -> L16
        if (r2 == null) goto L10;
        r2.clear();     // Catch: Throwable -> L16
    L10:
        r0.clear();     // Catch: Throwable -> L16
        ObserverList<WindowFocusChangedListener> r3 = sWindowFocusListeners;     // Catch: Throwable -> L16
        if (r3 == null) goto L13;
        r3.clear();     // Catch: Throwable -> L16
    L13:
        sCurrentApplicationState = 0;     // Catch: Throwable -> L16
        sActivity = null;     // Catch: Throwable -> L16
        sNativeApplicationStateListener = null;     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private static int determineApplicationStateLocked() {
        Iterator<ActivityInfo> r0 = sActivityInfo.values().iterator();
        boolean r1 = false;
        boolean r2 = false;
    L4:
        if (r0.hasNext() == false) goto L15;
        int r3 = r0.next().getStatus();
        if (r3 == 4) goto L11;
        if (r3 == 5) goto L11;
        if (r3 == 6) goto L11;
        return 1;
    L11:
        if (r3 == 4) goto L12;
        if (r3 != 5) goto L4;
        r2 = true;
        goto L4
    L12:
        r1 = true;
        goto L4
    L15:
        if (r1 == false) goto L18;
        return 2;
    L18:
        if (r2 == false) goto L21;
        return 3;
    L21:
        return 4;
    }

    public static List<Activity> getRunningActivities() {
        Map<Activity, ActivityInfo> r0 = sActivityInfo;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(r0.keySet());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static int getStateForApplication() {
        Map<Activity, ActivityInfo> r0 = sActivityInfo;
        monitor-enter(r0);
        int r1 = sCurrentApplicationState;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean isEveryActivityDestroyed() {
        return sActivityInfo.isEmpty();
    }

    public static boolean isInitialized() {
        Map<Activity, ActivityInfo> r0 = sActivityInfo;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sCurrentApplicationState == 0) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new 3());
    }

    public static void resetActivitiesForInstrumentationTests() {
        Map<Activity, ActivityInfo> r0 = sActivityInfo;
        monitor-enter(r0);
        Iterator r1 = new HashSet(r0.keySet()).iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        onStateChangeForTesting((Activity) r1.next(), 6);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static boolean hasVisibleActivities() {
        int r0 = getStateForApplication();
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public static /* synthetic */ ObserverList access$000() {
        return sWindowFocusListeners;
    }

    public static /* synthetic */ Activity access$100() {
        return sActivity;
    }

    public static /* synthetic */ ApplicationStateListener access$400() {
        return sNativeApplicationStateListener;
    }

    public static Activity getLastTrackedFocusedActivity() {
        return sActivity;
    }

    public static /* synthetic */ Activity access$102(Activity r0) {
        sActivity = r0;
        return r0;
    }

    public static /* synthetic */ ApplicationStateListener access$402(ApplicationStateListener r0) {
        sNativeApplicationStateListener = r0;
        return r0;
    }

    public static int getStateForActivity(Activity r2) {
        if (r2 != null) goto L5;
        return 6;
    L5:
        ActivityInfo r3 = sActivityInfo.get(r2);
        if (r3 != null) goto L8;
        return 6;
    L8:
        return r3.getStatus();
    }

    public static void initialize(Application r2) {
        Map<Activity, ActivityInfo> r0 = sActivityInfo;
        monitor-enter(r0);
        sCurrentApplicationState = 4;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        registerWindowFocusChangedListener(new 1());
        r2.registerActivityLifecycleCallbacks(new 2());
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static boolean reachesWindowCallback(Window.Callback r9) {
        if (r9 != null) goto L6;
        return false;
    L6:
        if (r9.getClass().getName().equals(TOOLBAR_CALLBACK_WRAPPER_CLASS) == false) goto L9;
        return true;
    L9:
        if (Proxy.isProxyClass(r9.getClass()) == true) goto L11;
        Class<?> r1 = r9.getClass();
    L14:
        if (r1 == Object.class) goto L30;
        Field[] r3 = r1.getDeclaredFields();
        int r4 = r3.length;
        int r5 = 0;
    L16:
        if (r5 >= r4) goto L29;
        Field r6 = r3[r5];
        if (r6.getType().isAssignableFrom(Window.Callback.class) == false) goto L28;
        boolean r7 = r6.isAccessible();
        r6.setAccessible(true);
        Window.Callback r8 = (Window.Callback) r6.get(r9);     // Catch: Throwable -> L24 IllegalAccessException -> L27
        r6.setAccessible(r7);
        if (reachesWindowCallback(r8) == false) goto L28;
        return true;
    L27:
        r6.setAccessible(r7);
    L24:
        th = move-exception;
        r6.setAccessible(r7);
        throw th;
    L28:
        r5 = r5 + 1;
        goto L16
    L29:
        r1 = r1.getSuperclass();
        goto L14
    L30:
        return false;
    L11:
        return Proxy.getInvocationHandler(r9) instanceof WindowCallbackProxy;
    }

    public static void registerApplicationStateListener(ApplicationStateListener r1) {
        if (sApplicationStateListeners != null) goto L5;
        sApplicationStateListeners = new ObserverList();
    L5:
        sApplicationStateListeners.addObserver(r1);
    }

    public static void registerStateListenerForAllActivities(ActivityStateListener r1) {
        if (sGeneralActivityStateListeners != null) goto L5;
        sGeneralActivityStateListeners = new ObserverList();
    L5:
        sGeneralActivityStateListeners.addObserver(r1);
    }

    public static void registerWindowFocusChangedListener(WindowFocusChangedListener r1) {
        if (sWindowFocusListeners != null) goto L5;
        sWindowFocusListeners = new ObserverList();
    L5:
        sWindowFocusListeners.addObserver(r1);
    }

    public static void unregisterActivityStateListener(ActivityStateListener r3) {
        ObserverList<ActivityStateListener> r0 = sGeneralActivityStateListeners;
        if (r0 == null) goto L5;
        r0.removeObserver(r3);
    L5:
        Map<Activity, ActivityInfo> r1 = sActivityInfo;
        monitor-enter(r1);
        Iterator<ActivityInfo> r2 = r1.values().iterator();     // Catch: Throwable -> L13
    L9:
        if (r2.hasNext() == false) goto L11;
        r2.next().getListeners().removeObserver(r3);     // Catch: Throwable -> L13
        goto L9
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static void unregisterApplicationStateListener(ApplicationStateListener r1) {
        ObserverList<ApplicationStateListener> r0 = sApplicationStateListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeObserver(r1);
    }

    public static void unregisterWindowFocusChangedListener(WindowFocusChangedListener r1) {
        ObserverList<WindowFocusChangedListener> r0 = sWindowFocusListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeObserver(r1);
    }

    public static /* synthetic */ void access$200(Activity r0, int r1) {
        onStateChange(r0, r1);
    }

    public static Window.Callback createWindowCallbackProxy(Activity r4, Window.Callback r5) {
        return (Window.Callback) Proxy.newProxyInstance(Window.Callback.class.getClassLoader(), new Class[]{Window.Callback.class}, new WindowCallbackProxy(r4, r5));
    }

    private static void onStateChange(Activity r5, int r6) {
        if (r5 == null) goto L47;
        if (sActivity != null) goto L6;
    L11:
        sActivity = r5;
    L12:
        int r0 = getStateForApplication();
        Map<Activity, ActivityInfo> r1 = sActivityInfo;
        monitor-enter(r1);
    L43:
        th = move-exception;
        throw th;
    L15:
        if (r1.containsKey(r5) == true) goto L17;
        r1.put(r5, new ActivityInfo(null));     // Catch: Throwable -> L43
    L17:
        ActivityInfo r2 = r1.get(r5);     // Catch: Throwable -> L43
        r2.setStatus(r6);     // Catch: Throwable -> L43
        if (r6 != 6) goto L22;
        r1.remove(r5);     // Catch: Throwable -> L43
        if (r5 != sActivity) goto L22;
        sActivity = null;     // Catch: Throwable -> L43
    L22:
        sCurrentApplicationState = determineApplicationStateLocked();     // Catch: Throwable -> L43
        monitor-exit(r1);     // Catch: Throwable -> L43
        Iterator r3 = r2.getListeners().iterator();
    L26:
        if (r3.hasNext() == false) goto L28;
        ((ActivityStateListener) r3.next()).onActivityStateChange(r5, r6);
        goto L26
    L28:
        ObserverList<ActivityStateListener> r4 = sGeneralActivityStateListeners;
        if (r4 == null) goto L34;
        Iterator r7 = r4.iterator();
    L32:
        if (r7.hasNext() == false) goto L34;
        ((ActivityStateListener) r7.next()).onActivityStateChange(r5, r6);
    L34:
        int r8 = getStateForApplication();
        if (r8 == r0) goto L42;
        ObserverList<ApplicationStateListener> r9 = sApplicationStateListeners;
        if (r9 == null) goto L53;
        Iterator r10 = r9.iterator();
    L40:
        if (r10.hasNext() == false) goto L54;
        ((ApplicationStateListener) r10.next()).onApplicationStateChange(r8);
        goto L40
    L54:
        return;
    L53:
        return;
    L42:
        return;
    L6:
        if (r6 == 1) goto L11;
        if (r6 == 3) goto L11;
        if (r6 != 2) goto L12;
    L47:
        throw new IllegalArgumentException("null activity is not supported");
    }

    public static void onStateChangeForTesting(Activity r0, int r1) {
        onStateChange(r0, r1);
    }

    public static void registerStateListenerForActivity(ActivityStateListener r1, Activity r2) {
        sActivityInfo.get(r2).getListeners().addObserver(r1);
    }
}
