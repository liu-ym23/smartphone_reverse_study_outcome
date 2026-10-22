package com.bytedance.android.live.core.setting;

import android.widget.Toast;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class SettingUtil {
    public static final String KEY_SERVER_SETTING_VALUES = "key_ttlive_sdk_setting";
    public static final String KEY_TT_APP_SETTING = "TT_APP_SETTING";
    public static final String KEY_TT_USER_SETTING = "TT_USER_SETTING";
    private static Gson gson;
    private static boolean isLocalTest;
    private static boolean sDebugMode;
    public static c70.b sTestSettingCallback;

    static {
        gson = t6.a;
    }

    public static String getCacheRate() {
        v60.a r0 = v60.a.a;
        return SettingIncStrategy.a.a.f;
    }

    public static boolean isDebugMode() {
        if (sDebugMode == true) goto L8;
        int r0 = d6.a;
        wa1.a r1 = wa1.d.a;
        if (r1 == null) goto L7;
        r1.b();
    L7:
        return false;
    L8:
        return true;
    }

    private SettingUtil() {
    }

    public static Gson getGson() {
        return gson;
    }

    public static boolean isLocalTest() {
        return isLocalTest;
    }

    public static <T> T getDebugValue(SettingKey<T> r0) {
        return r0.getDebugValue();
    }

    public static <T> T getDefaultValue(SettingKey<T> r0) {
        return r0.getDefaultValue();
    }

    public static String getLocalValue(SettingKey r0) {
        return c7.c(r0);
    }

    public static String getServerValue(SettingKey r8) {
        int r0 = c7.a;
        return GsonProtectorUtils.toJson(t6.a, v60.a.a.k(r8.getName(), r8.getDefaultValue(), r8.getType(), r8.isSticky(), false, false));
    }

    public static String getSettingKeyDescription(SettingKey r0) {
        return r0.getDescription();
    }

    public static String getSettingKeyName(SettingKey r0) {
        return r0.getName();
    }

    public static String[] getSettingKeyOption(SettingKey r0) {
        return r0.getOption();
    }

    public static Type getSettingKeyType(SettingKey r0) {
        return r0.getType();
    }

    public static void setDebugMode(boolean r0) {
        sDebugMode = r0;
    }

    public static void setGson(Gson r0) {
        gson = r0;
    }

    public static void setLocalTest(boolean r0) {
        isLocalTest = r0;
    }

    public static String getLocalValue(String r1, String r2) {
        String r3 = c7.c(new SettingKey(r1, r2));
        if (r3 != null) goto L6;
        return r2;
    L6:
        return r3;
    }

    public static Object getRawValue(String r0, String r1) {
        return c7.d(r1);
    }

    public static boolean updateLocal(SettingKey r4, String r5) {
        int r0 = c7.a;
        v60.a r1 = v60.a.a;     // Catch: NumberFormatException -> L5
        return v60.a.l(r4.getName(), r5, r4.getType());
    L5:
        Toast.makeText(c7.getContext(), String.format(Locale.US, "Illegal value of %s : %s", new Object[]{r4.getName(), String.valueOf(r5)}), 0).show();
        return false;
    }

    public static <T> T getValue(String r0, String r1, Type r2, T r3) {
        return (T) c7.e(r1, r2, r3, false, false);
    }

    public static <T> T getValue(String r0, String r1, Type r2, T r3, boolean r4) {
        return (T) c7.e(r1, r2, r3, r4, false);
    }

    public static <T> T getValue(String r0, String r1, Type r2, T r3, T r4, boolean r5) {
        return (T) c7.e(r1, r2, r3, r5, false);
    }

    public static <T> T getValue(String r0, String r1, Type r2, T r3, T r4, boolean r5, boolean r6) {
        return (T) c7.e(r1, r2, r3, r5, r6);
    }

    public static <T> T getValue(String r7, String r8, Type r9, T r11, T r12, boolean r13, boolean r14, boolean r15) {
        int r16 = c7.a;
        if (r14 == false) goto L5;
        v60.a r17 = v60.a.a;
        int r18 = d6.a;
        return (T) v60.a.i(r8, r9, wa1.d.b);
    L5:
        v60.a r0 = v60.a.a;
        int r19 = d6.a;
        return (T) r0.k(r8, r11, r9, r13, wa1.d.b, r15);
    }
}
