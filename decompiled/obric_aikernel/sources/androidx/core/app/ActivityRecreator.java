package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
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

    private static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
        Object currentlyRecreatingToken;
        private Activity mActivity;
        private boolean mDestroyed;
        private final int mRecreatingHashCode;
        private boolean mStarted;
        private boolean mStopQueued;

        LifecycleCheckCallbacks(@NonNull Activity r10) {
            this.mStarted = false;
            this.mDestroyed = false;
            this.mStopQueued = false;
            this.mActivity = r10;
            this.mRecreatingHashCode = r10.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r10, Bundle r11) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r10) {
            if (this.mActivity != r10) goto L6;
            this.mActivity = null;
            this.mDestroyed = true;
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r10) {
            if (this.mDestroyed == true) goto L5;
            return;
        L5:
            if (this.mStopQueued == false) goto L7;
            return;
        L7:
            if (this.mStarted == false) goto L9;
            return;
        L9:
            if (ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, this.mRecreatingHashCode, r10) == false) goto L15;
            this.mStopQueued = true;
            this.currentlyRecreatingToken = null;
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r10) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r10) {
            if (this.mActivity != r10) goto L6;
            this.mStarted = true;
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r10) {
        }
    }

    static {
        mainHandler = new Handler(Looper.getMainLooper());
        Class<?> r10 = getActivityThreadClass();
        activityThreadClass = r10;
        mainThreadField = getMainThreadField();
        tokenField = getTokenField();
        performStopActivity3ParamsMethod = getPerformStopActivity3Params(r10);
        performStopActivity2ParamsMethod = getPerformStopActivity2Params(r10);
        requestRelaunchActivityMethod = getRequestRelaunchActivityMethod(r10);
    }

    private ActivityRecreator() {
    }

    private static Class<?> getActivityThreadClass() {
        return Class.forName("android.app.ActivityThread");
    L4:
        return null;
    }

    private static Field getMainThreadField() {
        Field r10 = Activity.class.getDeclaredField("mMainThread");     // Catch: Throwable -> L4
        r10.setAccessible(true);     // Catch: Throwable -> L4
        return r10;
    L4:
        return null;
    }

    private static Method getPerformStopActivity2Params(Class<?> r10) {
        if (r10 != null) goto L8;
        return null;
    L8:
        Method r11 = r10.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});     // Catch: Throwable -> L7
        r11.setAccessible(true);     // Catch: Throwable -> L7
        return r11;
    L7:
        return null;
    }

    private static Method getPerformStopActivity3Params(Class<?> r10) {
        if (r10 != null) goto L8;
        return null;
    L8:
        Method r11 = r10.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});     // Catch: Throwable -> L7
        r11.setAccessible(true);     // Catch: Throwable -> L7
        return r11;
    L7:
        return null;
    }

    private static Method getRequestRelaunchActivityMethod(Class<?> r10) {
        if (needsRelaunchCall() == false) goto L8;
        if (r10 == null) goto L8;
        Class<?> r11 = Boolean.TYPE;     // Catch: Throwable -> L9
        Method r12 = r10.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, Integer.TYPE, r11, Configuration.class, Configuration.class, r11, r11});     // Catch: Throwable -> L9
        r12.setAccessible(true);     // Catch: Throwable -> L9
        return r12;
    L8:
        return null;
    }

    private static Field getTokenField() {
        Field r10 = Activity.class.getDeclaredField("mToken");     // Catch: Throwable -> L4
        r10.setAccessible(true);     // Catch: Throwable -> L4
        return r10;
    L4:
        return null;
    }

    private static boolean needsRelaunchCall() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 != 26) goto L5;
    L8:
        return true;
    L5:
        if (r10 == 27) goto L8;
        return false;
    }

    protected static boolean queueOnStopIfNecessary(Object r10, int r11, Activity r12) {
        final Object r13 = tokenField.get(r12);     // Catch: Throwable -> L12
        if (r13 == r10) goto L6;
    L11:
        return false;
    L6:
        if (r12.hashCode() != r11) goto L11;
        final Object r14 = mainThreadField.get(r12);     // Catch: Throwable -> L12
        mainHandler.postAtFrontOfQueue(new AnonymousClass3(r14, r13));     // Catch: Throwable -> L12
        return true;
    L12:
        th = move-exception;
        Log.e(LOG_TAG, "Exception while fetching field values", th);
        return false;
    }

    static boolean recreate(@NonNull Activity r10) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        r10.recreate();
        return true;
    L7:
        if (needsRelaunchCall() == false) goto L12;
        if (requestRelaunchActivityMethod != null) goto L12;
        return false;
    L12:
        if (performStopActivity2ParamsMethod == null) goto L14;
    L33:
        final Object r11 = tokenField.get(r10);     // Catch: Throwable -> L32
        if (r11 != null) goto L19;
        return false;
    L19:
        Object r12 = mainThreadField.get(r10);     // Catch: Throwable -> L32
        if (r12 != null) goto L22;
        return false;
    L22:
        final Application r13 = r10.getApplication();     // Catch: Throwable -> L32
        final LifecycleCheckCallbacks r14 = new LifecycleCheckCallbacks(r10);     // Catch: Throwable -> L32
        r13.registerActivityLifecycleCallbacks(r14);     // Catch: Throwable -> L32
        Handler r15 = mainHandler;     // Catch: Throwable -> L32
        r15.post(new AnonymousClass1(r14, r11));     // Catch: Throwable -> L32
    L29:
        th = move-exception;
        mainHandler.post(new AnonymousClass2(r13, r14));     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L24:
        if (needsRelaunchCall() == false) goto L26;
        Method r16 = requestRelaunchActivityMethod;     // Catch: Throwable -> L29
        Boolean r17 = Boolean.FALSE;     // Catch: Throwable -> L29
        r16.invoke(r12, new Object[]{r11, null, null, 0, r17, null, null, r17, r17});     // Catch: Throwable -> L29
    L27:
        r15.post(new AnonymousClass2(r13, r14));     // Catch: Throwable -> L32
        return true;
    L26:
        r10.recreate();     // Catch: Throwable -> L29
    L32:
        return false;
    L14:
        if (performStopActivity3ParamsMethod != null) goto L33;
        return false;
    }
}
