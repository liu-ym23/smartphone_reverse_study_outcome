package com.bytedance.bdinstall.util;

import android.os.SystemProperties;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class SystemPropertiesProxy {
    private static volatile Object sSystemProperties;

    public SystemPropertiesProxy() {
    }

    private Object getSystemProperties() {
        if (sSystemProperties != null) goto L18;
        monitor-enter(SystemPropertiesProxy.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (sSystemProperties == null) goto L21;
    L12:
        monitor-exit(SystemPropertiesProxy.class);     // Catch: Throwable -> L14
        goto L18
    L21:
        sSystemProperties = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin").newInstance();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
    L18:
        return sSystemProperties;
    }

    public String get(String r7) {
        return SystemProperties.get(r7);
    L4:
        th = move-exception;
        th.printStackTrace();
        Object r6 = getSystemProperties();     // Catch: Throwable -> L8 IllegalArgumentException -> L10
    L16:
        return (String) ZeusTransformUtils.preCheckCast(r6.getClass().getMethod("get", new Class[]{String.class}).invoke(r6, new Object[]{r7}), String.class, "com.obric.memorydata.plugin");
    L10:
        e = move-exception;
        throw e;
    L8:
        return "";
    }

    public String get(String r8, String r9) {
        return SystemProperties.get(r8);
    L4:
        th = move-exception;
        th.printStackTrace();
        Object r7 = getSystemProperties();     // Catch: Throwable -> L11 IllegalArgumentException -> L9
        goto L16
    L8:
        return (String) ZeusTransformUtils.preCheckCast(r7.getClass().getMethod("get", new Class[]{String.class, String.class}).invoke(r7, new Object[]{r8, r9}), String.class, "com.obric.memorydata.plugin");
    L9:
        e = move-exception;
        throw e;
    L16:
        return r9;
    }

    public Boolean getBoolean(String r8, boolean r9) {
        return Boolean.valueOf(SystemProperties.getBoolean(r8, r9));
    L4:
        th = move-exception;
        th.printStackTrace();
        Boolean.valueOf(r9);
        Object r7 = getSystemProperties();     // Catch: Throwable -> L8 IllegalArgumentException -> L10
        goto L9
    L16:
        return (Boolean) ZeusTransformUtils.preCheckCast(r7.getClass().getMethod("getBoolean", new Class[]{String.class, Boolean.TYPE}).invoke(r7, new Object[]{r8, Boolean.valueOf(r9)}), Boolean.class, "com.obric.memorydata.plugin");
    L10:
        e = move-exception;
        throw e;
    L9:
        return Boolean.valueOf(r9);
    }

    public Integer getInt(String r8, int r9) {
        return Integer.valueOf(SystemProperties.getInt(r8, r9));
    L4:
        th = move-exception;
        th.printStackTrace();
        Integer.valueOf(r9);
        Object r7 = getSystemProperties();     // Catch: Throwable -> L8 IllegalArgumentException -> L10
        goto L9
    L16:
        return (Integer) ZeusTransformUtils.preCheckCast(r7.getClass().getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(r7, new Object[]{r8, Integer.valueOf(r9)}), Integer.class, "com.obric.memorydata.plugin");
    L10:
        e = move-exception;
        throw e;
    L9:
        return Integer.valueOf(r9);
    }

    public Long getLong(String r8, long r9) {
        return Long.valueOf(SystemProperties.getLong(r8, r9));
    L4:
        th = move-exception;
        th.printStackTrace();
        Object r7 = getSystemProperties();     // Catch: Throwable -> L8 IllegalArgumentException -> L10
        goto L9
    L16:
        return (Long) ZeusTransformUtils.preCheckCast(r7.getClass().getMethod("getLong", new Class[]{String.class, Integer.TYPE}).invoke(r7, new Object[]{r8, Long.valueOf(r9)}), Long.class, "com.obric.memorydata.plugin");
    L10:
        e = move-exception;
        throw e;
    L9:
        return Long.valueOf(r9);
    }
}
