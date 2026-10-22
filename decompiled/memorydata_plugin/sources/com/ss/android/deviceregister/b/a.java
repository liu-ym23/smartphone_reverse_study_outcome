package com.ss.android.deviceregister.b;

import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.common.utility.h;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f15168a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String[] f15169b = null;
    private static InterfaceC0808a c = null;
    private static String d = "ib.snssdk.com";
    private static boolean e = false;

    /* JADX INFO: renamed from: com.ss.android.deviceregister.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0808a {
        boolean a();
    }

    static {
    }

    public static void a(boolean r0) {
        e = r0;
    }

    public static String[] a() {
        String[] r0 = f15169b;
        if (r0 == null) goto L11;
        if (r0.length <= 0) goto L11;
        if (h.a(r0[0]) == true) goto L11;
        return f15169b;
    L11:
        return new String[]{ReportConsts.HTTPS + d + Constants.PATH_REGISTER, ReportConsts.HTTPS + d + Constants.PATH_REGISTER};
    }

    public static boolean b() {
        return e;
    }

    public static boolean c() {
        InterfaceC0808a r0 = c;
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.a();
    }
}
