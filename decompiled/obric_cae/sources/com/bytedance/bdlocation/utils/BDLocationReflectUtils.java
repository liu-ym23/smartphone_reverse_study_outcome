package com.bytedance.bdlocation.utils;

import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationReflectUtils {
    private static final Method AWEME_INIT_LOCATION_METHOD = null;
    private static final Object COMPANION_OBJECT_IN_AWEME = null;
    public static final String TAG = "passive-init";

    static {
        Method r8 = null;
        Class<?> r10 = Class.forName("com.ss.android.ugc.aweme.location.SimpleLocationHelper");     // Catch: Throwable -> L8
        Logger.i(TAG, "reflectInvokeAwemeLocationInit: SimpleLocationHelperClass: " + r10);     // Catch: Throwable -> L8
        Field r11 = r10.getDeclaredField("Companion");     // Catch: Throwable -> L8
        r11.setAccessible(true);     // Catch: Throwable -> L8
        Logger.i(TAG, "reflectInvokeAwemeLocationInit: CompanionField: " + r11);     // Catch: Throwable -> L8
        Object r12 = r11.get(null);     // Catch: Throwable -> L8
        Class<?> r13 = r12.getClass();     // Catch: Throwable -> L6
        Logger.i(TAG, "reflectInvokeAwemeLocationInit: CompanionClass: " + r13);     // Catch: Throwable -> L6
        r8 = r13.getDeclaredMethod("weakEnsureLocationInitialized", new Class[0]);     // Catch: Throwable -> L6
        r8.setAccessible(true);     // Catch: Throwable -> L6
        Logger.i(TAG, "reflectInvokeAwemeLocationInit: initLocationMethod: " + r8);     // Catch: Throwable -> L6
    L11:
        AWEME_INIT_LOCATION_METHOD = r8;
        COMPANION_OBJECT_IN_AWEME = r12;
        return;
    L6:
        th = th;
    L10:
        th.printStackTrace();
        Logger.e(TAG, "reflectInvokeAwemeLocationInit: error", th);
    L8:
        th = th;
        r12 = null;
        goto L10
    }

    public BDLocationReflectUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v2 */
    public static void weakEnsureAwemeLocationInit() {
        ?? r8 = TAG;
        long r10 = SystemClock.uptimeMillis();
        String r11 = null;
        StringBuilder r12 = new StringBuilder("sdk weakEnsureAwemeLocationInit, mainThread: ");     // Catch: Throwable -> L14
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        boolean r13 = true;
    L7:
        r12.append(r13);     // Catch: Throwable -> L14
        r12.append(", threadName: ");     // Catch: Throwable -> L14
        r12.append(Thread.currentThread().getName());     // Catch: Throwable -> L14
        r12.append(", AWEME_INIT_LOCATION_METHOD: ");     // Catch: Throwable -> L14
        Method r14 = AWEME_INIT_LOCATION_METHOD;     // Catch: Throwable -> L14
        r12.append(r14);     // Catch: Throwable -> L14
        r12.append(", COMPANION_OBJECT_IN_AWEME_ILT: ");     // Catch: Throwable -> L14
        Object r15 = COMPANION_OBJECT_IN_AWEME;     // Catch: Throwable -> L14
        r12.append(r15);     // Catch: Throwable -> L14
        Logger.i(TAG, r12.toString());     // Catch: Throwable -> L14
        if (r14 == null) goto L11;
        if (r15 == null) goto L11;
        String r16 = (String) r14.invoke(r15, new Object[0]);     // Catch: Throwable -> L14
        r8 = 1;
        ?? r17 = r8;
    L13:
        ?? r18 = r17;
        Throwable r19 = null;
        r11 = r16;
    L17:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L19;
        boolean r20 = true;
    L20:
        long r21 = SystemClock.uptimeMillis() - r10;
        if (AWEME_INIT_LOCATION_METHOD == null) goto L23;
        boolean r110 = true;
    L25:
        if (COMPANION_OBJECT_IN_AWEME == null) goto L27;
        boolean r111 = true;
    L28:
        if (r11 != null) goto L30;
        String r112 = "error_result_null";
    L31:
        LocationMonitor.monitorPassiveInit(r20, r21, r110, r111, r18, r112, r19);
        return;
    L30:
        r112 = r11;
        goto L31
    L27:
        r111 = false;
        goto L28
    L23:
        r110 = false;
        goto L25
    L19:
        r20 = false;
    L11:
        r16 = "reflect_method_not_found";
        r17 = 0;
        goto L13
    L6:
        r13 = false;
    L14:
        th = move-exception;
        th.printStackTrace();
        Logger.e(r8, "weakEnsureAwemeLocationInit: error", th);
        r19 = th;
        r18 = 0;
        goto L17
    }
}
