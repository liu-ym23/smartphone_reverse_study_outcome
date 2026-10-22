package com.bytedance.android.live.core.utils;

import android.os.Build;
import com.bytedance.common.utility.StringUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f1 {
    public static Boolean a;

    public static Boolean a() {
        Boolean r0 = a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        boolean r1 = false;
        Method r2 = Build.class.getDeclaredMethod("getString", new Class[]{String.class});     // Catch: Throwable -> L13
        r2.setAccessible(true);     // Catch: Throwable -> L13
        Object r3 = r2.invoke(null, new Object[]{"ro.vivo.os.version"});     // Catch: Throwable -> L13
        if ((r3 instanceof String) == true) goto L9;
    L15:
        a = Boolean.valueOf(r1);
        return Boolean.valueOf(r1);
    L9:
        if (StringUtils.isEmpty((String) r3) == true) goto L15;
        if ("unknown".equals((String) r3) == true) goto L15;
        r1 = true;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    }
}
