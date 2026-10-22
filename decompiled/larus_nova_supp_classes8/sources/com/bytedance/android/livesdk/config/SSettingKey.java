package com.bytedance.android.livesdk.config;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.live.strategy.api.StrategyMutableLiveData;
import com.bytedance.android.livesdkapi.strategy.StrategyConvertHelper;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class SSettingKey<T> extends SettingKey<T> {
    static StrategyMutableLiveData<Object> NOT_SET;
    static Boolean enable;
    static volatile IStrategyService strategyService;

    public T getValue() {
        return getValue(true, true);
    }

    static {
        NOT_SET = new StrategyMutableLiveData();
    }

    public SSettingKey(String r1, Class<T> r2) {
        super(r1, r2);
    }

    public T getValue(boolean r4, boolean r5) {
        T r0 = (T) super.getValue();
        if (isSticky() == false) goto L6;
        return r0;
    L6:
        if (enable != null) goto L9;
        enable = (Boolean) com.bytedance.android.livesdk.t7.a.getValue();
    L9:
        if (enable.booleanValue() == true) goto L12;
        return r0;
    L12:
        if (jc1.k.h(IStrategyService.class) == true) goto L15;
        return r0;
    L15:
        if (strategyService != null) goto L18;
        strategyService = jc1.k.f(IStrategyService.class);
    L18:
        if (enable.booleanValue() == true) goto L20;
    L46:
        return r0;
    L20:
        if (strategyService == null) goto L46;
        if (strategyService.isStrategyFactor(getName()) == true) goto L24;
        return r0;
    L24:
        Class<?> r1 = r0.getClass();
        if (r1.isPrimitive() == false) goto L27;
    L38:
        LiveData r6 = strategyService.getFactor(getName(), r0, r4, r5);
        if (r6 == null) goto L41;
        T r7 = (T) r6.getValue();
    L42:
        if (r7 == null) goto L46;
        if (r7 == NOT_SET.getValue()) goto L46;
        return r7;
    L41:
        r7 = null;
        goto L42
    L27:
        if (r1 == Boolean.class) goto L38;
        if (r1 == Integer.class) goto L38;
        if (r1 == String.class) goto L38;
        if (r1 == Float.class) goto L38;
        if (r1 == Double.class) goto L38;
        r7 = (T) StrategyConvertHelper.getObjectStrategyValue(getName(), r0, r4, r5);
        goto L42
    }

    public SSettingKey(String r1, T r2) {
        super(r1, r2);
    }

    public SSettingKey(String r1, Class<T> r2, String r3) {
        super(r1, r2, r3);
    }

    public SSettingKey(String r1, T r2, String r3) {
        super(r1, r2, r3);
    }

    public SSettingKey(String r1, Type r2, T r3) {
        super(r1, r2, r3);
    }

    public SSettingKey(String r1, Class<T> r2, String r3, boolean r4) {
        super(r1, r2, r3, r4);
    }

    public SSettingKey(String r1, T r2, String r3, String... r4) {
        super(r1, r2, r3, r4);
    }

    public SSettingKey(String r1, String r2, T r3, T r4) {
        super(r1, r2, r3, r4);
    }

    public SSettingKey(String r1, Class<T> r2, String r3, T r4, T r5) {
        super(r1, r2, r3, r4, r5);
    }

    public SSettingKey(String r1, String r2, T r3, T r4, boolean r5) {
        super(r1, r2, r3, r4, r5);
    }

    public SSettingKey(String r1, String r2, T r3, T r4, String... r5) {
        super(r1, r2, r3, r4, r5);
    }

    public SSettingKey(String r7, String r8, T r9, T r10, T r11, boolean r12) {
        super(r7, r8, r10, r11, r12);
    }

    public SSettingKey(String r1, Class<T> r2, String r3, T r4, T r5, boolean r6) {
        super(r1, r2, r3, r4, r5, r6);
    }

    public SSettingKey(String r1, String r2, T r3, T r4, boolean r5, String... r6) {
        super(r1, r2, r3, r4, r5, r6);
    }

    public SSettingKey(String r1, String r2, T r3, Type r4, boolean r5, boolean r6) {
        super(r1, r2, r3, r4, r5, r6);
    }

    public SSettingKey(String r1, String r2, T r3, Type r4, boolean r5, boolean r6, boolean r7) {
        super(r1, r2, r3, r4, r5, r6, r7);
    }
}
