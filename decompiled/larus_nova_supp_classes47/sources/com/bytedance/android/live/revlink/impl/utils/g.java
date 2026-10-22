package com.bytedance.android.live.revlink.impl.utils;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Context r7) {
        if (r7 != null) goto L98;
        r7 = jc1.a.b();
    L98:
        Object r1 = r7.getSystemService("activity");     // Catch: Throwable -> L95
        if (r1 == null) goto L94;
        Iterator<T> r2 = ((ActivityManager) r1).getHistoricalProcessExitReasons(r7.getPackageName(), 0, 5).iterator();     // Catch: Throwable -> L95
    L8:
        Integer r3 = null;
        if (r2.hasNext() == false) goto L13;
        Object r4 = r2.next();     // Catch: Throwable -> L95
        if (Intrinsics.areEqual(((ApplicationExitInfo) r4).getProcessName(), r7.getPackageName()) == false) goto L8;
    L14:
        ApplicationExitInfo r5 = (ApplicationExitInfo) r4;     // Catch: Throwable -> L95
        if (r5 == null) goto L17;
        r3 = Integer.valueOf(r5.getReason());     // Catch: Throwable -> L95
    L17:
        if (r3 != null) goto L20;
    L22:
        if (r3 != null) goto L25;
    L27:
        if (r3 != null) goto L30;
    L32:
        if (r3 != null) goto L35;
    L37:
        if (r3 != null) goto L40;
    L42:
        if (r3 != null) goto L45;
    L47:
        if (r3 != null) goto L50;
    L52:
        if (r3 != null) goto L55;
    L57:
        if (r3 != null) goto L60;
    L62:
        if (r3 != null) goto L65;
    L67:
        if (r3 != null) goto L70;
    L72:
        if (r3 != null) goto L75;
    L77:
        if (r3 != null) goto L80;
    L82:
        if (r3 != null) goto L85;
    L87:
        if (r5 == null) goto L116;
        String r8 = String.valueOf(r5.getReason());     // Catch: Throwable -> L95
        if (r8 != null) goto L92;
        return "unknown";
    L92:
        return r8;
    L116:
        return "unknown";
    L85:
        if (r3.intValue() != 7) goto L87;
        return "initial failure";
    L80:
        if (r3.intValue() != 2) goto L82;
        return "signal";
    L75:
        if (r3.intValue() != 1) goto L77;
        return "exit self";
    L70:
        if (r3.intValue() != 13) goto L72;
        return "other";
    L65:
        if (r3.intValue() != 12) goto L67;
        return "dependency died";
    L60:
        if (r3.intValue() != 11) goto L62;
        return "user stopped";
    L55:
        if (r3.intValue() != 9) goto L57;
        return "excessive resource usage";
    L50:
        if (r3.intValue() != 8) goto L52;
        return "permission change";
    L45:
        if (r3.intValue() != 10) goto L47;
        return "user request";
    L40:
        if (r3.intValue() != 6) goto L42;
        return "anr";
    L35:
        if (r3.intValue() != 5) goto L37;
        return "native crash";
    L30:
        if (r3.intValue() != 4) goto L32;
        return "crash";
    L25:
        if (r3.intValue() != 3) goto L27;
        return "low memory";
    L20:
        if (r3.intValue() != 0) goto L22;
        return "unknown";
    L13:
        r4 = null;
        goto L14
    L94:
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L95
    L95:
        th = move-exception;
        ALogger.e("LinkCrashUtils", th);
        return "unknown";
    }
}
