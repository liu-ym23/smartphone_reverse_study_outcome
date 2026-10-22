package com.bytedance.bdlocation.utils;

import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationReflectUtils {
    private static final Method AWEME_INIT_LOCATION_METHOD = null;
    private static final Object COMPANION_OBJECT_IN_AWEME = null;
    public static final String TAG = "passive-init";

    static {
        Method r1 = null;
        Class r2 = ZeusTransformUtils.forName("com.ss.android.ugc.aweme.location.SimpleLocationHelper", "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Logger.i(TAG, "reflectInvokeAwemeLocationInit: SimpleLocationHelperClass: " + r2);     // Catch: Throwable -> L8
        Field r3 = r2.getDeclaredField("Companion");     // Catch: Throwable -> L8
        r3.setAccessible(true);     // Catch: Throwable -> L8
        Logger.i(TAG, "reflectInvokeAwemeLocationInit: CompanionField: " + r3);     // Catch: Throwable -> L8
        Object r4 = r3.get(null);     // Catch: Throwable -> L8
        Class<?> r5 = r4.getClass();     // Catch: Throwable -> L6
        Logger.i(TAG, "reflectInvokeAwemeLocationInit: CompanionClass: " + r5);     // Catch: Throwable -> L6
        r1 = r5.getDeclaredMethod("weakEnsureLocationInitialized", new Class[0]);     // Catch: Throwable -> L6
        r1.setAccessible(true);     // Catch: Throwable -> L6
        Logger.i(TAG, "reflectInvokeAwemeLocationInit: initLocationMethod: " + r1);     // Catch: Throwable -> L6
    L11:
        AWEME_INIT_LOCATION_METHOD = r1;
        COMPANION_OBJECT_IN_AWEME = r4;
        return;
    L6:
        th = th;
    L10:
        th.printStackTrace();
        Logger.e(TAG, "reflectInvokeAwemeLocationInit: error", th);
    L8:
        th = th;
        r4 = null;
        goto L10
    }

    public BDLocationReflectUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v2 */
    public static void weakEnsureAwemeLocationInit() {
        ?? r0 = TAG;
        long r1 = SystemClock.uptimeMillis();
        String r3 = null;
        StringBuilder r6 = new StringBuilder().append("sdk weakEnsureAwemeLocationInit, mainThread: ");     // Catch: Throwable -> L14
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        boolean r7 = true;
    L7:
        StringBuilder r8 = r6.append(r7).append(", threadName: ").append(Thread.currentThread().getName()).append(", AWEME_INIT_LOCATION_METHOD: ");     // Catch: Throwable -> L14
        Method r9 = AWEME_INIT_LOCATION_METHOD;     // Catch: Throwable -> L14
        StringBuilder r10 = r8.append(r9).append(", COMPANION_OBJECT_IN_AWEME_ILT: ");     // Catch: Throwable -> L14
        Object r11 = COMPANION_OBJECT_IN_AWEME;     // Catch: Throwable -> L14
        Logger.i(TAG, r10.append(r11).toString());     // Catch: Throwable -> L14
        if (r9 == null) goto L11;
        if (r11 == null) goto L11;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r9.invoke(r11, new Object[0]), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        r0 = 1;
        ?? r2 = r0;
    L13:
        ?? r13 = r2;
        Throwable r15 = null;
        r3 = r12;
    L17:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L19;
        boolean r14 = true;
    L20:
        long r16 = SystemClock.uptimeMillis() - r1;
        if (AWEME_INIT_LOCATION_METHOD == null) goto L23;
        boolean r17 = true;
    L25:
        if (COMPANION_OBJECT_IN_AWEME == null) goto L27;
        boolean r18 = true;
    L28:
        if (r3 != null) goto L30;
        String r19 = "error_result_null";
    L31:
        LocationMonitor.monitorPassiveInit(r14, r16, r17, r18, r13, r19, r15);
        return;
    L30:
        r19 = r3;
        goto L31
    L27:
        r18 = false;
        goto L28
    L23:
        r17 = false;
        goto L25
    L19:
        r14 = false;
    L11:
        r12 = "reflect_method_not_found";
        r2 = 0;
        goto L13
    L6:
        r7 = false;
    L14:
        th = move-exception;
        th.printStackTrace();
        Logger.e(r0, "weakEnsureAwemeLocationInit: error", th);
        r13 = 0;
        r15 = th;
        goto L17
    }
}
