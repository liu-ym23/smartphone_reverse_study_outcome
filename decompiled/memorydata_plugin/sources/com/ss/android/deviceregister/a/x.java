package com.ss.android.deviceregister.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
final class x implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f15162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class<?> f15163b;
    private static Method c;

    static {
        Class<?> r0 = ZeusTransformUtils.forName("com.android.id.impl.IdProviderImpl", "com.obric.memorydata.plugin");     // Catch: Exception -> L4
        f15163b = r0;     // Catch: Exception -> L4
        f15162a = r0.newInstance();     // Catch: Exception -> L4
        c = f15163b.getMethod("getOAID", new Class[]{Context.class});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.ss.android.deviceregister.l.c(com.ss.android.deviceregister.l.f15219a, "Api#static reflect exception! " + e.getMessage());
    }

    x() {
    }

    private static String a(Context r4, Method r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Object r0 = f15162a;
        if (r0 == null) goto L10;
        if (r5 != null) goto L13;
        return null;
    L13:
        Object r7 = r5.invoke(r0, new Object[]{r6});     // Catch: Exception -> L12
        if (r7 == null) goto L16;
        return (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
    L16:
        return null;
    L17:
        return null;
    L10:
        return null;
    }

    static boolean a() {
        if (f15163b != null) goto L5;
    L9:
        return false;
    L5:
        if (f15162a == null) goto L9;
        if (c == null) goto L9;
        return true;
    }

    @Override // com.ss.android.deviceregister.a.n
    public boolean b(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return a();
    }

    @Override // com.ss.android.deviceregister.a.n
    public n.a c(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        n.a r3 = new n.a();     // Catch: Exception -> L5
        r3.f15141a = a(r1, c);     // Catch: Exception -> L5
        return r3;
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
