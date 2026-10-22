package com.bytedance.platform.godzilla.a;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Field> f2979a = null;

    static {
        f2979a = new HashMap();
    }

    public static Field a(Class<?> r6, String r7) {
        Class<?> r8 = (Class) ZeusTransformUtils.preCheckCast(d.a(r6, "The class must not be null"), Class.class, "com.obric.memorydata.plugin");
        d.a(!TextUtils.isEmpty(r7), "The field name must not be blank");
        String r0 = b(r8, r7);
        Map<String, Field> r2 = f2979a;
        monitor-enter(r2);
        Field r3 = (Field) ZeusTransformUtils.preCheckCast(r2.get(r0), Field.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        monitor-exit(r2);     // Catch: Throwable -> L35
        if (r3 != null) goto L8;
    L11:
        if (r8 == null) goto L33;
    L32:
        r8 = r8.getSuperclass();
        goto L11
    L13:
        if (c.a() == true) goto L15;
    L18:
        Field r4 = r8.getDeclaredField(r7);     // Catch: NoSuchFieldException -> L32
    L19:
        if (r4 == null) goto L31;
        if (r4.isAccessible() == true) goto L23;
        r4.setAccessible(true);     // Catch: NoSuchFieldException -> L32
    L23:
        Map<String, Field> r5 = f2979a;     // Catch: NoSuchFieldException -> L32
        monitor-enter(r5);     // Catch: NoSuchFieldException -> L32
        r5.put(r0, r4);     // Catch: Throwable -> L28
        monitor-exit(r5);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L32
    L31:
        return r4;
    L15:
        if (b.a() == null) goto L18;
        r4 = b.a().a(r8, r7);     // Catch: NoSuchFieldException -> L32
        if (r4 != null) goto L19;
    L33:
        return null;
    L8:
        if (r3.isAccessible() == true) goto L10;
        r3.setAccessible(true);
    L10:
        return r3;
    L35:
        th = move-exception;
        throw th;
    }

    private static String b(Class<?> r2, String r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2.toString()).append("#").append(r3);
        return r0.toString();
    }
}
