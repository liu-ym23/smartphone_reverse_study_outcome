package com.ss.android.common.applog;

import kta.n;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class f {
    public static final String[] a = null;

    static {
        String[] r0 = {"mc", "build_serial", "aliyun_uuid", "udid", "serial_number", "sim_serial_number"};
        String[] r1 = AppLog.o0;
        String[] r2 = new String[r1.length + 6];
        a = r2;
        System.arraycopy(r1, 0, r2, 0, r1.length);
        System.arraycopy(r0, 0, r2, r1.length + 0, r0.length);
    }

    public static String a(n r13) throws JSONException {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", r13, r9, "java.lang.String", r10);
        if (r11.a == false) goto L6;
        r8.a(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", r13, r9, null, r10, false);
        return (String) r11.b;
    L6:
        String r12 = r13.b();
        r8.a(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", r13, r9, r12, r10, true);
        return r12;
    }
}
