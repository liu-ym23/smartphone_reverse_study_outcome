package com.bytedance.android.live.core.setting;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class SettingKey<T> {
    private final T debugValue;
    private final T defaultValue;
    private final String description;
    private boolean isOnlyRemote;
    private boolean isPreloadCache;
    private final String name;
    private final String[] option;
    private final boolean sticky;
    private final Type type;
    private T value;

    public T getSpValue() {
        String r0 = SettingUtil.KEY_SERVER_SETTING_VALUES;
        T r1 = (T) SettingUtil.getValue("key_ttlive_sdk_setting", this.name, this.type, this.defaultValue, this.value, this.sticky, this.isOnlyRemote, this.isPreloadCache);
        this.value = r1;
        return r1;
    }

    private T getWarlockSpValue() {
        if (SettingUtil.isDebugMode() == true) goto L5;
        long r0 = System.nanoTime();
        this.value = (T) SettingUtil.getValue("key_ttlive_sdk_setting", this.name, this.type, this.defaultValue, this.value, this.sticky, this.isOnlyRemote, this.isPreloadCache);
        TimeUnit.MICROSECONDS.convert(System.nanoTime() - r0, TimeUnit.NANOSECONDS);
        int r1 = d6.a;
        if (wa1.d.b == true) goto L11;
        return this.value;
    L11:
        throw null;
    L5:
        return this.debugValue;
    }

    public T getValue() {
        return getSpValue();
    }

    public T getDebugValue() {
        return this.debugValue;
    }

    public T getDefaultValue() {
        return this.defaultValue;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String[] getOption() {
        return this.option;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isOnlyRemote() {
        return this.isOnlyRemote;
    }

    public boolean isSticky() {
        return this.sticky;
    }

    public SettingKey<T> setPreloadCache(boolean r1) {
        this.isPreloadCache = r1;
        return this;
    }

    public SettingKey(String r2, Class<T> r3) {
        this(r2, r3, "");
    }

    public SettingKey(String r2, T r3) {
        this(r2, r3, "");
    }

    public SettingKey(String r2, Type r3, T r4) {
        this.isOnlyRemote = false;
        this.isPreloadCache = false;
        this.name = r2;
        this.defaultValue = r4;
        this.debugValue = r4;
        this.type = r3;
        this.description = null;
        this.option = null;
        this.sticky = false;
    }

    public SettingKey(String r7, Class<T> r8, String r9) {
        this(r7, r8, r9, null, null);
    }

    public SettingKey(String r1, T r2, String r3) {
        this(r1, r3, r2, r2);
    }

    public SettingKey(String r1, Class<T> r2, String r3, boolean r4) {
        this.name = r1;
        this.description = r3;
        this.isOnlyRemote = r4;
        this.type = r2;
        this.defaultValue = null;
        this.debugValue = null;
        this.option = null;
        this.sticky = false;
        this.isPreloadCache = false;
    }

    public SettingKey(String r9, String r11, T r12, T r13) {
        this(r9, r12.getClass(), r11, r12, r13, false, null);
    }

    public SettingKey(String r7, T r8, String r9, String... r11) {
        this(r7, r9, r8, r8, r11);
    }

    public SettingKey(String r9, String r11, T r12, T r13, boolean r14) {
        this(r9, r12.getClass(), r11, r12, r13, r14, null);
    }

    public SettingKey(String r9, String r11, T r12, T r13, String... r14) {
        this(r9, r12.getClass(), r11, r12, r13, false, r14);
    }

    public SettingKey(String r9, Class<T> r11, String r12, T r13, T r14) {
        this(r9, r11, r12, r13, r14, false, null);
    }

    public SettingKey(String r1, String r2, T r3, Type r4, boolean r5, boolean r6) {
        this.name = r1;
        this.description = r2;
        this.isOnlyRemote = r5;
        this.type = r4;
        this.defaultValue = r3;
        this.debugValue = null;
        this.option = null;
        this.sticky = r6;
        this.isPreloadCache = false;
    }

    public SettingKey(String r9, String r11, T r12, T r13, boolean r14, String... r15) {
        this(r9, r12.getClass(), r11, r12, r13, r14, r15);
    }

    public SettingKey(String r9, Class<T> r11, String r12, T r13, T r14, boolean r15) {
        this(r9, r11, r12, r13, r14, r15, null);
    }

    private SettingKey(String r2, Class<T> r3, String r4, T r5, T r6, boolean r7, String[] r8) {
        this.isOnlyRemote = false;
        this.isPreloadCache = false;
        this.name = r2;
        this.description = r4;
        this.defaultValue = r5;
        this.debugValue = r6;
        this.type = r3;
        this.option = r8;
        this.sticky = r7;
    }

    public SettingKey(String r1, String r2, T r3, Type r4, boolean r5, boolean r6, boolean r7) {
        this.name = r1;
        this.description = r2;
        this.isOnlyRemote = r5;
        this.type = r4;
        this.defaultValue = r3;
        this.debugValue = null;
        this.option = null;
        this.sticky = r6;
        this.isPreloadCache = r7;
    }
}
