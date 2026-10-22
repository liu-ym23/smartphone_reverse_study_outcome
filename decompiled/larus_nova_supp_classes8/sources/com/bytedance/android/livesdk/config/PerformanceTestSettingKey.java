package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.setting.SettingUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class PerformanceTestSettingKey<T> extends SettingKey<T> {
    private T mDefaultValue;

    private T getDisableValue() {
        Class<?> r1 = this.mDefaultValue.getClass();     // Catch: Exception -> L42
        if (r1 == Boolean.class) goto L41;
        if (r1 == Boolean.TYPE) goto L41;
        if (r1 == Integer.class) goto L39;
        if (r1 == Integer.TYPE) goto L39;
        if (r1 == Long.class) goto L37;
        if (r1 == Long.TYPE) goto L37;
        if (r1 == Double.class) goto L35;
        if (r1 == Double.TYPE) goto L35;
        if (r1 == Float.class) goto L33;
        if (r1 == Float.TYPE) goto L33;
        if (r1 != String.class) goto L46;
        return "";
    L46:
        return null;
    L33:
        return (T) Float.valueOf(-1.0f);
    L35:
        return (T) Double.valueOf(-1.0d);
    L37:
        return (T) (-1L);
    L39:
        return (T) (-1);
    L41:
        return (T) Boolean.FALSE;
    L42:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public T getValue() {
        if (SettingUtil.isLocalTest() == true) goto L7;
        return getDisableValue();
    L7:
        return (T) super.getValue();
    }

    public PerformanceTestSettingKey(String r1, String r2, T r3, T r4) {
        super(r1, r2, r3, r4);
        this.mDefaultValue = r3;
    }
}
