package com.bytedance.watson.assist.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f3392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f3393b;
    private static Method c;
    private static Method d;

    static {
        Method[] r0 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin").getMethods();     // Catch: ClassNotFoundException -> L17
        int r1 = r0.length;     // Catch: ClassNotFoundException -> L17
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L28;
        Method r3 = r0[r2];     // Catch: ClassNotFoundException -> L17
        String r4 = r3.getName();     // Catch: ClassNotFoundException -> L17
        if (r4.equals("get") == false) goto L8;
        f3392a = r3;     // Catch: ClassNotFoundException -> L17
    L16:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r4.equals("set") == false) goto L11;
        d = r3;     // Catch: ClassNotFoundException -> L17
        goto L16
    L11:
        if (r4.equals("getLong") == false) goto L14;
        f3393b = r3;     // Catch: ClassNotFoundException -> L17
        goto L16
    L14:
        if (r4.equals("getInt") == false) goto L16;
        c = r3;     // Catch: ClassNotFoundException -> L17
        goto L16
    L28:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    public static String a(String r4, String r5) {
        Method r0 = f3392a;
        if (r0 != null) goto L15;
        return r5;
    L15:
        return (String) ZeusTransformUtils.preCheckCast(r0.invoke(null, new Object[]{r4, r5}), String.class, "com.obric.memorydata.plugin");
    L10:
        e = move-exception;
        e.printStackTrace();
    L14:
        return r5;
    L12:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
