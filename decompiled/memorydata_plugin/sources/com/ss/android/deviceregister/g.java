package com.ss.android.deviceregister;

import android.accounts.Account;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.ss.android.deviceregister.a.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.ss.android.deviceregister.b.a.a f15216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f15217b;
    private static Account c;

    public g() {
    }

    public static com.ss.android.deviceregister.b.a.a a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (f.c() == false) goto L35;
        if (f15216a != null) goto L33;
        monitor-enter(g.class);
    L29:
        th = move-exception;
        throw th;
    L9:
        if (f15216a != null) goto L27;
        if (r7 == null) goto L26;
        if (b(r7) == false) goto L21;
        if (com.ss.android.deviceregister.c.c.a(r7).b() == false) goto L36;
        com.ss.android.deviceregister.c.c.a(r7).c();     // Catch: Throwable -> L29
    L36:
        f15216a = (com.ss.android.deviceregister.b.a.a) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.ss.android.deviceregister.newuser.DeviceParamsProvider", "com.obric.memorydata.plugin").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r7}), com.ss.android.deviceregister.b.a.a.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L18 Throwable -> L29
        Logger.d("DRParameterFactory", "create new user device param provider success");     // Catch: Exception -> L18 Throwable -> L29
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L29
        Logger.w("DRParameterFactory", "class com.ss.android.deviceregister.newuser.DeviceParamsProvider not fount");     // Catch: Throwable -> L29
    L21:
        if (f15216a != null) goto L27;
        d r1 = new d(r7, f.i());     // Catch: Throwable -> L29
        f15216a = r1;     // Catch: Throwable -> L29
        if (c == null) goto L27;
        ((d) ZeusTransformUtils.preCheckCast(r1, d.class, "com.obric.memorydata.plugin")).a(c);     // Catch: Throwable -> L29
        goto L27
    L26:
        throw new IllegalArgumentException("context == null");     // Catch: Throwable -> L29
    L27:
        monitor-exit(g.class);     // Catch: Throwable -> L29
    L33:
        return f15216a;
    L35:
        throw new IllegalStateException("please init TeaAgent first");
    }

    static boolean a() {
        if (TextUtils.isEmpty(f15217b) == false) goto L6;
        f15217b = u.d();
    L6:
        return "local_test".equals(f15217b);
    }

    public static boolean b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L9:
        Logger.d("DRParameterFactory", "#isNewUserMode false. context=" + r3 + " isDebugChannel()=" + a());
        return false;
    L5:
        if (a() == false) goto L9;
        return com.ss.android.deviceregister.c.c.a(r3).a();
    }
}
