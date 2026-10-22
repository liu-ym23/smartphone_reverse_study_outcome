package com.ttnet.org.chromium.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.view.Window;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class ApplicationStatus {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TOOLBAR_CALLBACK_WRAPPER_CLASS = "androidx.appcompat.app.ToolbarActionBar$ToolbarCallbackWrapper";

    @SuppressLint({"StaticFieldLeak"})
    private static Activity sActivity;
    private static final Map<Activity, ActivityInfo> sActivityInfo = null;
    private static ObserverList<ApplicationStateListener> sApplicationStateListeners;

    @SuppressLint({"SupportAnnotationUsage"})
    private static int sCurrentApplicationState;
    private static ObserverList<ActivityStateListener> sGeneralActivityStateListeners;
    private static ApplicationStateListener sNativeApplicationStateListener;
    private static ObserverList<WindowFocusChangedListener> sWindowFocusListeners;

    private static class ActivityInfo {
        private ObserverList<ActivityStateListener> mListeners;
        private int mStatus;

        private ActivityInfo() {
            this.mStatus = 6;
            this.mListeners = new ObserverList();
        }

        /* synthetic */ ActivityInfo(AnonymousClass1 r10) {
            this();
        }

        public ObserverList<ActivityStateListener> getListeners() {
            return this.mListeners;
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setStatus(int r10) {
            this.mStatus = r10;
        }
    }

    public interface ActivityStateListener {
        void onActivityStateChange(Activity r10, int r11);
    }

    public interface ApplicationStateListener {
        void onApplicationStateChange(int r10);
    }

    interface Natives {
        void onApplicationStateChange(int r10);
    }

    @VisibleForTesting
    static class WindowCallbackProxy implements InvocationHandler {
        private final Activity mActivity;
        private final Window.Callback mCallback;

        public WindowCallbackProxy(Activity r10, Window.Callback r11) {
            this.mCallback = r11;
            this.mActivity = r10;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r10, Method r11, Object[] r12) {
            if (r11.getName().equals("onWindowFocusChanged") == true) goto L5;
        L18:
            return r11.invoke(this.mCallback, r12);
        L12:
            e = move-exception;
            if ((e.getCause() instanceof AbstractMethodError) == true) goto L16;
            throw e;
        L16:
            throw e.getCause();
        L5:
            if (r12.length != 1) goto L18;
            if ((r12[0] instanceof Boolean) == false) goto L18;
            onWindowFocusChanged(((Boolean) r12[0]).booleanValue());
            return null;
        }

        public void onWindowFocusChanged(boolean r10) {
            this.mCallback.onWindowFocusChanged(r10);
            if (ApplicationStatus.access$000() == null) goto L8;
            Iterator r11 = ApplicationStatus.access$000().iterator();
        L6:
            if (r11.hasNext() == false) goto L10;
            ((WindowFocusChangedListener) r11.next()).onWindowFocusChanged(this.mActivity, r10);
            goto L6
        L10:
            return;
        }
    }

    public interface WindowFocusChangedListener {
        void onWindowFocusChanged(Activity r10, boolean r11);
    }

    static {
        sActivityInfo = Collections.synchronizedMap(new HashMap());
        sCurrentApplicationState = 0;
    }

    private ApplicationStatus() {
    }

    static /* synthetic */ ObserverList access$000() {
        return sWindowFocusListeners;
    }

    static /* synthetic */ Activity access$100() {
        return sActivity;
    }

    static /* synthetic */ Activity access$102(Activity r10) {
        sActivity = r10;
        return r10;
    }

    static /* synthetic */ void access$200(Activity r10, int r11) {
        onStateChange(r10, r11);
    }

    static /* synthetic */ ApplicationStateListener access$400() {
        return sNativeApplicationStateListener;
    }

    static /* synthetic */ ApplicationStateListener access$402(ApplicationStateListener r10) {
        sNativeApplicationStateListener = r10;
        return r10;
    }

    @VisibleForTesting
    static Window.Callback createWindowCallbackProxy(Activity r10, Window.Callback r11) {
        return (Window.Callback) Proxy.newProxyInstance(Window.Callback.class.getClassLoader(), new Class[]{Window.Callback.class}, new WindowCallbackProxy(r10, r11));
    }

    @MainThread
    public static void destroyForJUnitTests() {
        Map<Activity, ActivityInfo> r10 = sActivityInfo;
        monitor-enter(r10);
        ObserverList<ApplicationStateListener> r11 = sApplicationStateListeners;     // Catch: Throwable -> L16
        if (r11 == null) goto L7;
        r11.clear();     // Catch: Throwable -> L16
    L7:
        ObserverList<ActivityStateListener> r12 = sGeneralActivityStateListeners;     // Catch: Throwable -> L16
        if (r12 == null) goto L10;
        r12.clear();     // Catch: Throwable -> L16
    L10:
        r10.clear();     // Catch: Throwable -> L16
        ObserverList<WindowFocusChangedListener> r13 = sWindowFocusListeners;     // Catch: Throwable -> L16
        if (r13 == null) goto L13;
        r13.clear();     // Catch: Throwable -> L16
    L13:
        sCurrentApplicationState = 0;     // Catch: Throwable -> L16
        sActivity = null;     // Catch: Throwable -> L16
        sNativeApplicationStateListener = null;     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private static int determineApplicationStateLocked() {
        Iterator<ActivityInfo> r10 = sActivityInfo.values().iterator();
        boolean r11 = false;
        boolean r12 = false;
    L4:
        if (r10.hasNext() == false) goto L15;
        int r13 = r10.next().getStatus();
        if (r13 == 4) goto L11;
        if (r13 == 5) goto L11;
        if (r13 == 6) goto L11;
        return 1;
    L11:
        if (r13 == 4) goto L12;
        if (r13 != 5) goto L4;
        r12 = true;
        goto L4
    L12:
        r11 = true;
        goto L4
    L15:
        if (r11 == false) goto L18;
        return 2;
    L18:
        if (r12 == false) goto L21;
        return 3;
    L21:
        return 4;
    }

    @MainThread
    public static Activity getLastTrackedFocusedActivity() {
        return sActivity;
    }

    @AnyThread
    public static List<Activity> getRunningActivities() {
        Map<Activity, ActivityInfo> r10 = sActivityInfo;
        monitor-enter(r10);
        ArrayList r11 = new ArrayList(r10.keySet());     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @AnyThread
    public static int getStateForActivity(@Nullable Activity r10) {
        if (r10 != null) goto L5;
        return 6;
    L5:
        ActivityInfo r11 = sActivityInfo.get(r10);
        if (r11 != null) goto L8;
        return 6;
    L8:
        return r11.getStatus();
    }

    @AnyThread
    @CalledByNative
    public static int getStateForApplication() {
        Map<Activity, ActivityInfo> r10 = sActivityInfo;
        monitor-enter(r10);
        int r11 = sCurrentApplicationState;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @AnyThread
    @CalledByNative
    public static boolean hasVisibleActivities() {
        int r10 = getStateForApplication();
        if (r10 != 1) goto L5;
        return true;
    L5:
        if (r10 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    @MainThread
    public static void initialize(Application r10) {
        Map<Activity, ActivityInfo> r11 = sActivityInfo;
        monitor-enter(r11);
        sCurrentApplicationState = 4;     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        registerWindowFocusChangedListener(new AnonymousClass1());
        r10.registerActivityLifecycleCallbacks(new AnonymousClass2());
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @AnyThread
    public static boolean isEveryActivityDestroyed() {
        return sActivityInfo.isEmpty();
    }

    public static boolean isInitialized() {
        Map<Activity, ActivityInfo> r10 = sActivityInfo;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sCurrentApplicationState == 0) goto L7;
        boolean r11 = true;
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    L7:
        r11 = false;
        goto L8
    }

    private static void onStateChange(Activity r10, int r11) {
        if (r10 == null) goto L47;
        if (sActivity != null) goto L6;
    L11:
        sActivity = r10;
    L12:
        int r12 = getStateForApplication();
        Map<Activity, ActivityInfo> r13 = sActivityInfo;
        monitor-enter(r13);
        AnonymousClass1 r14 = null;
        if (r13.containsKey(r10) == true) goto L17;
        r13.put(r10, new ActivityInfo(r14));     // Catch: Throwable -> L43
    L17:
        ActivityInfo r15 = r13.get(r10);     // Catch: Throwable -> L43
        r15.setStatus(r11);     // Catch: Throwable -> L43
        if (r11 != 6) goto L22;
        r13.remove(r10);     // Catch: Throwable -> L43
        if (r10 != sActivity) goto L22;
        sActivity = null;     // Catch: Throwable -> L43
    L22:
        sCurrentApplicationState = determineApplicationStateLocked();     // Catch: Throwable -> L43
        monitor-exit(r13);     // Catch: Throwable -> L43
        Iterator<ActivityStateListener> r16 = r15.getListeners().iterator();
    L26:
        if (r16.hasNext() == false) goto L28;
        r16.next().onActivityStateChange(r10, r11);
        goto L26
    L28:
        ObserverList<ActivityStateListener> r17 = sGeneralActivityStateListeners;
        if (r17 == null) goto L34;
        Iterator<ActivityStateListener> r18 = r17.iterator();
    L32:
        if (r18.hasNext() == false) goto L34;
        r18.next().onActivityStateChange(r10, r11);
    L34:
        int r19 = getStateForApplication();
        if (r19 == r12) goto L42;
        ObserverList<ApplicationStateListener> r20 = sApplicationStateListeners;
        if (r20 == null) goto L53;
        Iterator<ApplicationStateListener> r21 = r20.iterator();
    L40:
        if (r21.hasNext() == false) goto L54;
        r21.next().onApplicationStateChange(r19);
        goto L40
    L54:
        return;
    L53:
        return;
    L42:
        return;
    L43:
        th = move-exception;
        throw th;
    L6:
        if (r11 == 1) goto L11;
        if (r11 == 3) goto L11;
        if (r11 != 2) goto L12;
    L47:
        throw new IllegalArgumentException("null activity is not supported");
    }

    @MainThread
    @VisibleForTesting
    public static void onStateChangeForTesting(Activity r10, int r11) {
        onStateChange(r10, r11);
    }

    @VisibleForTesting
    static boolean reachesWindowCallback(@Nullable Window.Callback r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.getClass().getName().equals(TOOLBAR_CALLBACK_WRAPPER_CLASS) == false) goto L9;
        return true;
    L9:
        if (Proxy.isProxyClass(r10.getClass()) == true) goto L11;
        Class<?> r11 = r10.getClass();
    L14:
        if (r11 == Object.class) goto L30;
        Field[] r12 = r11.getDeclaredFields();
        int r13 = r12.length;
        int r14 = 0;
    L16:
        if (r14 >= r13) goto L29;
        Field r15 = r12[r14];
        if (r15.getType().isAssignableFrom(Window.Callback.class) == false) goto L28;
        boolean r16 = r15.isAccessible();
        r15.setAccessible(true);
        Window.Callback r17 = (Window.Callback) r15.get(r10);     // Catch: Throwable -> L24 IllegalAccessException -> L27
        r15.setAccessible(r16);
        if (reachesWindowCallback(r17) == false) goto L28;
        return true;
    L27:
        r15.setAccessible(r16);
    L24:
        th = move-exception;
        r15.setAccessible(r16);
        throw th;
    L28:
        r14 = r14 + 1;
        goto L16
    L29:
        r11 = r11.getSuperclass();
        goto L14
    L30:
        return false;
    L11:
        return Proxy.getInvocationHandler(r10) instanceof WindowCallbackProxy;
    }

    @MainThread
    public static void registerApplicationStateListener(ApplicationStateListener r10) {
        if (sApplicationStateListeners != null) goto L5;
        sApplicationStateListeners = new ObserverList();
    L5:
        sApplicationStateListeners.addObserver(r10);
    }

    @SuppressLint({"NewApi"})
    @MainThread
    public static void registerStateListenerForActivity(ActivityStateListener r10, Activity r11) {
        sActivityInfo.get(r11).getListeners().addObserver(r10);
    }

    @MainThread
    public static void registerStateListenerForAllActivities(ActivityStateListener r10) {
        if (sGeneralActivityStateListeners != null) goto L5;
        sGeneralActivityStateListeners = new ObserverList();
    L5:
        sGeneralActivityStateListeners.addObserver(r10);
    }

    @CalledByNative
    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new AnonymousClass3());
    }

    @MainThread
    public static void registerWindowFocusChangedListener(WindowFocusChangedListener r10) {
        if (sWindowFocusListeners != null) goto L5;
        sWindowFocusListeners = new ObserverList();
    L5:
        sWindowFocusListeners.addObserver(r10);
    }

    @MainThread
    public static void resetActivitiesForInstrumentationTests() {
        Map<Activity, ActivityInfo> r10 = sActivityInfo;
        monitor-enter(r10);
        Iterator r11 = new HashSet(r10.keySet()).iterator();     // Catch: Throwable -> L10
    L6:
        if (r11.hasNext() == false) goto L8;
        onStateChangeForTesting((Activity) r11.next(), 6);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @MainThread
    public static void unregisterActivityStateListener(ActivityStateListener r10) {
        ObserverList<ActivityStateListener> r11 = sGeneralActivityStateListeners;
        if (r11 == null) goto L5;
        r11.removeObserver(r10);
    L5:
        Map<Activity, ActivityInfo> r12 = sActivityInfo;
        monitor-enter(r12);
        Iterator<ActivityInfo> r13 = r12.values().iterator();     // Catch: Throwable -> L13
    L9:
        if (r13.hasNext() == false) goto L11;
        r13.next().getListeners().removeObserver(r10);     // Catch: Throwable -> L13
        goto L9
    L11:
        monitor-exit(r12);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @MainThread
    public static void unregisterApplicationStateListener(ApplicationStateListener r10) {
        ObserverList<ApplicationStateListener> r11 = sApplicationStateListeners;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.removeObserver(r10);
    }

    @MainThread
    public static void unregisterWindowFocusChangedListener(WindowFocusChangedListener r10) {
        ObserverList<WindowFocusChangedListener> r11 = sWindowFocusListeners;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.removeObserver(r10);
    }
}
