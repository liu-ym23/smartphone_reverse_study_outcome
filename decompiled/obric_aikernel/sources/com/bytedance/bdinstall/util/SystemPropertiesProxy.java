package com.bytedance.bdinstall.util;

import android.os.SystemProperties;

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
        if (sSystemProperties == null) goto L19;
    L12:
        monitor-exit(SystemPropertiesProxy.class);     // Catch: Throwable -> L14
        goto L18
    L19:
        sSystemProperties = Class.forName("android.os.SystemProperties").newInstance();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
    L18:
        return sSystemProperties;
    }

    public String get(String r10) {
        return SystemProperties.get(r10);
    L4:
        th = move-exception;
        th.printStackTrace();
        Object r11 = getSystemProperties();     // Catch: Throwable -> L8 IllegalArgumentException -> L10
    L16:
        return (String) r11.getClass().getMethod("get", new Class[]{String.class}).invoke(r11, new Object[]{r10});
    L10:
        e = move-exception;
        throw e;
    L8:
        return "";
    }

    public String get(String r10, String r11) {
        return SystemProperties.get(r10);
    L5:
        th = move-exception;
        th.printStackTrace();
        Object r12 = getSystemProperties();     // Catch: Throwable -> L12 IllegalArgumentException -> L10
        goto L17
    L9:
        return (String) r12.getClass().getMethod("get", new Class[]{String.class, String.class}).invoke(r12, new Object[]{r10, r11});
    L10:
        e = move-exception;
        throw e;
    L17:
        return r11;
    }

    public Boolean getBoolean(String r10, boolean r11) {
        return Boolean.valueOf(SystemProperties.getBoolean(r10, r11));
    L4:
        th = move-exception;
        th.printStackTrace();
        Object r12 = getSystemProperties();     // Catch: Throwable -> L8 IllegalArgumentException -> L10
        goto L9
    L16:
        return (Boolean) r12.getClass().getMethod("getBoolean", new Class[]{String.class, Boolean.TYPE}).invoke(r12, new Object[]{r10, Boolean.valueOf(r11)});
    L10:
        e = move-exception;
        throw e;
    L9:
        return Boolean.valueOf(r11);
    }

    public Integer getInt(String r10, int r11) {
        return Integer.valueOf(SystemProperties.getInt(r10, r11));
    L4:
        th = move-exception;
        th.printStackTrace();
        Object r12 = getSystemProperties();     // Catch: Throwable -> L8 IllegalArgumentException -> L10
        goto L9
    L16:
        return (Integer) r12.getClass().getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(r12, new Object[]{r10, Integer.valueOf(r11)});
    L10:
        e = move-exception;
        throw e;
    L9:
        return Integer.valueOf(r11);
    }

    public Long getLong(String r10, long r11) {
        return Long.valueOf(SystemProperties.getLong(r10, r11));
    L4:
        th = move-exception;
        th.printStackTrace();
        Object r12 = getSystemProperties();     // Catch: Throwable -> L8 IllegalArgumentException -> L10
        goto L9
    L16:
        return (Long) r12.getClass().getMethod("getLong", new Class[]{String.class, Integer.TYPE}).invoke(r12, new Object[]{r10, Long.valueOf(r11)});
    L10:
        e = move-exception;
        throw e;
    L9:
        return Long.valueOf(r11);
    }
}
