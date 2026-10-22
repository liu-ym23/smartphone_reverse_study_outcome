package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class ActivityRecreator {
    private static final String LOG_TAG = "ActivityRecreator";
    protected static final Class<?> activityThreadClass = null;
    private static final Handler mainHandler = null;
    protected static final Field mainThreadField = null;
    protected static final Method performStopActivity2ParamsMethod = null;
    protected static final Method performStopActivity3ParamsMethod = null;
    protected static final Method requestRelaunchActivityMethod = null;
    protected static final Field tokenField = null;

    /* JADX INFO: renamed from: androidx.core.app.ActivityRecreator$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ LifecycleCheckCallbacks val$callbacks;
        final /* synthetic */ Object val$token;

        public AnonymousClass1(LifecycleCheckCallbacks r5, Object r10) {
            this.val$callbacks = r5;
            this.val$token = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            LifecycleCheckCallbacks r5 = this.val$callbacks;
            r5.currentlyRecreatingToken = this.val$token;
        }
    }

    /* JADX INFO: renamed from: androidx.core.app.ActivityRecreator$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ Application val$application;
        final /* synthetic */ LifecycleCheckCallbacks val$callbacks;

        public AnonymousClass2(Application r5, LifecycleCheckCallbacks r10) {
            this.val$application = r5;
            this.val$callbacks = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$application.unregisterActivityLifecycleCallbacks(this.val$callbacks);
        }
    }

    public static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
        Object currentlyRecreatingToken;
        private Activity mActivity;
        private boolean mDestroyed;
        private final int mRecreatingHashCode;
        private boolean mStarted;
        private boolean mStopQueued;

        public LifecycleCheckCallbacks(@NonNull Activity r5) {
            this.mStarted = false;
            this.mDestroyed = false;
            this.mStopQueued = false;
            this.mActivity = r5;
            this.mRecreatingHashCode = r5.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r5, Bundle r10) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r5) {
            if (this.mActivity != r5) goto L6;
            this.mActivity = null;
            this.mDestroyed = true;
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r5) {
            if (this.mDestroyed == true) goto L5;
            return;
        L5:
            if (this.mStopQueued == false) goto L7;
            return;
        L7:
            if (this.mStarted == false) goto L9;
            return;
        L9:
            if (ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, this.mRecreatingHashCode, r5) == false) goto L15;
            this.mStopQueued = true;
            this.currentlyRecreatingToken = null;
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r5) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r5, Bundle r10) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r5) {
            if (this.mActivity != r5) goto L6;
            this.mStarted = true;
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r5) {
        }
    }

    static {
        mainHandler = new Handler(Looper.getMainLooper());
        Class<?> r5 = getActivityThreadClass();
        activityThreadClass = r5;
        mainThreadField = getMainThreadField();
        tokenField = getTokenField();
        performStopActivity3ParamsMethod = getPerformStopActivity3Params(r5);
        performStopActivity2ParamsMethod = getPerformStopActivity2Params(r5);
        requestRelaunchActivityMethod = getRequestRelaunchActivityMethod(r5);
    }

    private ActivityRecreator() {
    }

    private static Class<?> getActivityThreadClass() {
        return Class.forName("android.app.ActivityThread");
    L4:
        return null;
    }

    private static Field getMainThreadField() {
        Field r5 = Activity.class.getDeclaredField("mMainThread");     // Catch: Throwable -> L4
        r5.setAccessible(true);     // Catch: Throwable -> L4
        return r5;
    L4:
        return null;
    }

    private static Method getPerformStopActivity2Params(Class<?> r5) {
        if (r5 != null) goto L8;
        return null;
    L8:
        Method r10 = r5.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});     // Catch: Throwable -> L7
        r10.setAccessible(true);     // Catch: Throwable -> L7
        return r10;
    L7:
        return null;
    }

    private static Method getPerformStopActivity3Params(Class<?> r5) {
        if (r5 != null) goto L8;
        return null;
    L8:
        Method r10 = r5.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});     // Catch: Throwable -> L7
        r10.setAccessible(true);     // Catch: Throwable -> L7
        return r10;
    L7:
        return null;
    }

    private static Method getRequestRelaunchActivityMethod(Class<?> r11) {
        if (needsRelaunchCall() == false) goto L8;
        if (r11 == null) goto L8;
        Class r5 = Integer.TYPE;     // Catch: Throwable -> L9
        Class r10 = Boolean.TYPE;     // Catch: Throwable -> L9
        Method r12 = r11.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, r5, r10, Configuration.class, Configuration.class, r10, r10});     // Catch: Throwable -> L9
        r12.setAccessible(true);     // Catch: Throwable -> L9
        return r12;
    L8:
        return null;
    }

    private static Field getTokenField() {
        Field r5 = Activity.class.getDeclaredField("mToken");     // Catch: Throwable -> L4
        r5.setAccessible(true);     // Catch: Throwable -> L4
        return r5;
    L4:
        return null;
    }

    private static boolean needsRelaunchCall() {
        return false;
    }

    public static boolean queueOnStopIfNecessary(Object r5, int r10, Activity r11) {
        final Object r12 = tokenField.get(r11);     // Catch: Throwable -> L11
        if (r12 == r5) goto L6;
    L13:
        return false;
    L6:
        if (r11.hashCode() != r10) goto L13;
        final Object r13 = mainThreadField.get(r11);     // Catch: Throwable -> L11
        mainHandler.postAtFrontOfQueue(new AnonymousClass3(r13, r12));     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        Log.e(LOG_TAG, "Exception while fetching field values", th);
        return false;
    }

    public static boolean recreate(@NonNull Activity r5) {
        r5.recreate();
        return true;
    }
}
