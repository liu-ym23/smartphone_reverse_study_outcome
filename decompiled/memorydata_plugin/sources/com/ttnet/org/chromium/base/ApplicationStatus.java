package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.view.Window;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes6.dex */
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

    private static class ActivityInfo {
        private ObserverList<ActivityStateListener> mListeners;
        private int mStatus;

        private ActivityInfo() {
            this.mStatus = 6;
            this.mListeners = new ObserverList();
        }

        /* synthetic */ ActivityInfo(AnonymousClass1 r1) {
            this();
        }

        public ObserverList<ActivityStateListener> getListeners() {
            return this.mListeners;
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setStatus(int r1) {
            this.mStatus = r1;
        }
    }

    public interface ActivityStateListener {
        void onActivityStateChange(Activity r1, int r2);
    }

    public interface ApplicationStateListener {
        void onApplicationStateChange(int r1);
    }

    interface Natives {
        void onApplicationStateChange(int r1);
    }

    static class WindowCallbackProxy implements InvocationHandler {
        private final Activity mActivity;
        private final Window.Callback mCallback;

        public WindowCallbackProxy(Activity r3, Window.Callback r4) {
            Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
            this.mCallback = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r4, Window.Callback.class, "com.obric.memorydata.plugin");
            this.mActivity = ZeusTransformUtils.wrapperContext2Activity(r5, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r3, Method r4, Object[] r5) {
            if (r4.getName().equals("onWindowFocusChanged") == true) goto L5;
        L18:
            return r4.invoke(this.mCallback, r5);
        L12:
            e = move-exception;
            if (ZeusTransformUtils.instanceOf(e.getCause(), AbstractMethodError.class) == true) goto L16;
            throw e;
        L16:
            throw e.getCause();
        L5:
            if (r5.length != 1) goto L18;
            if (ZeusTransformUtils.instanceOf(r5[0], Boolean.class) == false) goto L18;
            onWindowFocusChanged(((Boolean) ZeusTransformUtils.preCheckCast(r5[0], Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
            return null;
        }

        public void onWindowFocusChanged(boolean r5) {
            this.mCallback.onWindowFocusChanged(r5);
            if (ApplicationStatus.access$000() == null) goto L8;
            Iterator r0 = ApplicationStatus.access$000().iterator();
        L6:
            if (r0.hasNext() == false) goto L10;
            ((WindowFocusChangedListener) ZeusTransformUtils.preCheckCast(r0.next(), WindowFocusChangedListener.class, "com.obric.memorydata.plugin")).onWindowFocusChanged(this.mActivity, r5);
            goto L6
        L10:
            return;
        }
    }

    public interface WindowFocusChangedListener {
        void onWindowFocusChanged(Activity r1, boolean r2);
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

    static /* synthetic */ Activity access$102(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        sActivity = r3;
        return r3;
    }

    static /* synthetic */ void access$200(Activity r2, int r3) {
        onStateChange((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), r3);
    }

    static /* synthetic */ ApplicationStateListener access$400() {
        return sNativeApplicationStateListener;
    }

    static /* synthetic */ ApplicationStateListener access$402(ApplicationStateListener r2) {
        ApplicationStateListener r3 = (ApplicationStateListener) ZeusTransformUtils.wrapperContextForParams(r2, ApplicationStateListener.class, "com.obric.memorydata.plugin");
        sNativeApplicationStateListener = r3;
        return r3;
    }

    static Window.Callback createWindowCallbackProxy(Activity r5, Window.Callback r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.memorydata.plugin");
        Window.Callback r8 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r6, Window.Callback.class, "com.obric.memorydata.plugin");
        return (Window.Callback) ZeusTransformUtils.preCheckCast(Proxy.newProxyInstance(Window.Callback.class.getClassLoader(), new Class[]{Window.Callback.class}, new WindowCallbackProxy(r7, r8)), Window.Callback.class, "com.obric.memorydata.plugin");
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
        int r3 = ((ActivityInfo) ZeusTransformUtils.preCheckCast(r0.next(), ActivityInfo.class, "com.obric.memorydata.plugin")).getStatus();
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

    public static Activity getLastTrackedFocusedActivity() {
        return sActivity;
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

    public static int getStateForActivity(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return 6;
    L5:
        ActivityInfo r5 = (ActivityInfo) ZeusTransformUtils.preCheckCast(sActivityInfo.get(r4), ActivityInfo.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L8;
        return 6;
    L8:
        return r5.getStatus();
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

    public static void initialize(Application r2) {
        Application r3 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.memorydata.plugin");
        Map<Activity, ActivityInfo> r0 = sActivityInfo;
        monitor-enter(r0);
        sCurrentApplicationState = 4;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        registerWindowFocusChangedListener(new AnonymousClass1());
        r3.registerActivityLifecycleCallbacks(new AnonymousClass2());
        return;
    L9:
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

    private static void onStateChange(Activity r6, int r7) {
        Activity r8 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L48;
        if (sActivity != null) goto L7;
    L12:
        sActivity = r8;
    L13:
        int r0 = getStateForApplication();
        Map<Activity, ActivityInfo> r1 = sActivityInfo;
        monitor-enter(r1);
        AnonymousClass1 r3 = null;
        if (r1.containsKey(r8) == true) goto L18;
        r1.put(r8, new ActivityInfo(r3));     // Catch: Throwable -> L44
    L18:
        ActivityInfo r2 = (ActivityInfo) ZeusTransformUtils.preCheckCast(r1.get(r8), ActivityInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        r2.setStatus(r7);     // Catch: Throwable -> L44
        if (r7 != 6) goto L23;
        r1.remove(r8);     // Catch: Throwable -> L44
        if (r8 != sActivity) goto L23;
        sActivity = null;     // Catch: Throwable -> L44
    L23:
        sCurrentApplicationState = determineApplicationStateLocked();     // Catch: Throwable -> L44
        monitor-exit(r1);     // Catch: Throwable -> L44
        Iterator<ActivityStateListener> r4 = r2.getListeners().iterator();
    L27:
        if (r4.hasNext() == false) goto L29;
        ((ActivityStateListener) ZeusTransformUtils.preCheckCast(r4.next(), ActivityStateListener.class, "com.obric.memorydata.plugin")).onActivityStateChange(r8, r7);
        goto L27
    L29:
        ObserverList<ActivityStateListener> r5 = sGeneralActivityStateListeners;
        if (r5 == null) goto L35;
        Iterator<ActivityStateListener> r9 = r5.iterator();
    L33:
        if (r9.hasNext() == false) goto L35;
        ((ActivityStateListener) ZeusTransformUtils.preCheckCast(r9.next(), ActivityStateListener.class, "com.obric.memorydata.plugin")).onActivityStateChange(r8, r7);
    L35:
        int r10 = getStateForApplication();
        if (r10 == r0) goto L43;
        ObserverList<ApplicationStateListener> r11 = sApplicationStateListeners;
        if (r11 == null) goto L54;
        Iterator<ApplicationStateListener> r12 = r11.iterator();
    L41:
        if (r12.hasNext() == false) goto L55;
        ((ApplicationStateListener) ZeusTransformUtils.preCheckCast(r12.next(), ApplicationStateListener.class, "com.obric.memorydata.plugin")).onApplicationStateChange(r10);
        goto L41
    L55:
        return;
    L54:
        return;
    L43:
        return;
    L44:
        th = move-exception;
        throw th;
    L7:
        if (r7 == 1) goto L12;
        if (r7 == 3) goto L12;
        if (r7 != 2) goto L13;
    L48:
        throw new IllegalArgumentException("null activity is not supported");
    }

    public static void onStateChangeForTesting(Activity r2, int r3) {
        onStateChange((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), r3);
    }

    static boolean reachesWindowCallback(Window.Callback r11) {
        Window.Callback r12 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r11, Window.Callback.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L6;
        return false;
    L6:
        if (r12.getClass().getName().equals(TOOLBAR_CALLBACK_WRAPPER_CLASS) == false) goto L9;
        return true;
    L9:
        if (Proxy.isProxyClass(r12.getClass()) == true) goto L11;
        Class<?> r2 = r12.getClass();
    L14:
        if (r2 == Object.class) goto L30;
        Field[] r4 = r2.getDeclaredFields();
        int r5 = r4.length;
        int r6 = 0;
    L16:
        if (r6 >= r5) goto L29;
        Field r7 = r4[r6];
        if (r7.getType().isAssignableFrom(Window.Callback.class) == false) goto L28;
        boolean r8 = r7.isAccessible();
        r7.setAccessible(true);
        Window.Callback r9 = (Window.Callback) ZeusTransformUtils.preCheckCast(r7.get(r12), Window.Callback.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24 IllegalAccessException -> L27
        r7.setAccessible(r8);
        if (reachesWindowCallback(r9) == false) goto L28;
        return true;
    L27:
        r7.setAccessible(r8);
    L24:
        th = move-exception;
        r7.setAccessible(r8);
        throw th;
    L28:
        r6 = r6 + 1;
        goto L16
    L29:
        r2 = r2.getSuperclass();
        goto L14
    L30:
        return false;
    L11:
        return ZeusTransformUtils.instanceOf(Proxy.getInvocationHandler(r12), WindowCallbackProxy.class);
    }

    public static void registerApplicationStateListener(ApplicationStateListener r2) {
        ApplicationStateListener r3 = (ApplicationStateListener) ZeusTransformUtils.wrapperContextForParams(r2, ApplicationStateListener.class, "com.obric.memorydata.plugin");
        if (sApplicationStateListeners != null) goto L5;
        sApplicationStateListeners = new ObserverList();
    L5:
        sApplicationStateListeners.addObserver(r3);
    }

    public static void registerStateListenerForActivity(ActivityStateListener r2, Activity r3) {
        ActivityStateListener r4 = (ActivityStateListener) ZeusTransformUtils.wrapperContextForParams(r2, ActivityStateListener.class, "com.obric.memorydata.plugin");
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        ((ActivityInfo) ZeusTransformUtils.preCheckCast(sActivityInfo.get(r5), ActivityInfo.class, "com.obric.memorydata.plugin")).getListeners().addObserver(r4);
    }

    public static void registerStateListenerForAllActivities(ActivityStateListener r2) {
        ActivityStateListener r3 = (ActivityStateListener) ZeusTransformUtils.wrapperContextForParams(r2, ActivityStateListener.class, "com.obric.memorydata.plugin");
        if (sGeneralActivityStateListeners != null) goto L5;
        sGeneralActivityStateListeners = new ObserverList();
    L5:
        sGeneralActivityStateListeners.addObserver(r3);
    }

    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new AnonymousClass3());
    }

    public static void registerWindowFocusChangedListener(WindowFocusChangedListener r2) {
        WindowFocusChangedListener r3 = (WindowFocusChangedListener) ZeusTransformUtils.wrapperContextForParams(r2, WindowFocusChangedListener.class, "com.obric.memorydata.plugin");
        if (sWindowFocusListeners != null) goto L5;
        sWindowFocusListeners = new ObserverList();
    L5:
        sWindowFocusListeners.addObserver(r3);
    }

    public static void resetActivitiesForInstrumentationTests() {
        Map<Activity, ActivityInfo> r0 = sActivityInfo;
        monitor-enter(r0);
        Iterator r1 = new HashSet(r0.keySet()).iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        onStateChangeForTesting((Activity) ZeusTransformUtils.preCheckCast(r1.next(), Activity.class, "com.obric.memorydata.plugin"), 6);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void unregisterActivityStateListener(ActivityStateListener r5) {
        ActivityStateListener r6 = (ActivityStateListener) ZeusTransformUtils.wrapperContextForParams(r5, ActivityStateListener.class, "com.obric.memorydata.plugin");
        ObserverList<ActivityStateListener> r0 = sGeneralActivityStateListeners;
        if (r0 == null) goto L5;
        r0.removeObserver(r6);
    L5:
        Map<Activity, ActivityInfo> r1 = sActivityInfo;
        monitor-enter(r1);
        Iterator<ActivityInfo> r2 = r1.values().iterator();     // Catch: Throwable -> L13
    L9:
        if (r2.hasNext() == false) goto L11;
        ((ActivityInfo) ZeusTransformUtils.preCheckCast(r2.next(), ActivityInfo.class, "com.obric.memorydata.plugin")).getListeners().removeObserver(r6);     // Catch: Throwable -> L13
        goto L9
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static void unregisterApplicationStateListener(ApplicationStateListener r2) {
        ApplicationStateListener r3 = (ApplicationStateListener) ZeusTransformUtils.wrapperContextForParams(r2, ApplicationStateListener.class, "com.obric.memorydata.plugin");
        ObserverList<ApplicationStateListener> r0 = sApplicationStateListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeObserver(r3);
    }

    public static void unregisterWindowFocusChangedListener(WindowFocusChangedListener r2) {
        WindowFocusChangedListener r3 = (WindowFocusChangedListener) ZeusTransformUtils.wrapperContextForParams(r2, WindowFocusChangedListener.class, "com.obric.memorydata.plugin");
        ObserverList<WindowFocusChangedListener> r0 = sWindowFocusListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeObserver(r3);
    }
}
