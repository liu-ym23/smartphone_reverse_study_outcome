package com.bytedance.android.live.core.setting;

import com.bytedance.android.live.core.log.ALogger;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g7 {
    public static final Map<String, JSONObject> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static Object a(String r4, Type r5, Object r6) {
        Intrinsics.checkNotNullParameter(SettingUtil.KEY_TT_APP_SETTING, "key");
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, "clazz");
        if (r5 != Boolean.TYPE) goto L13;
        if (r6 == null) goto L11;
        boolean r7 = ((Boolean) r6).booleanValue();
        Intrinsics.checkNotNullParameter(SettingUtil.KEY_TT_APP_SETTING, "key");
        Intrinsics.checkNotNullParameter(r4, "name");
        JSONObject r8 = (JSONObject) ((LinkedHashMap) a).get(SettingUtil.KEY_TT_APP_SETTING);
        if (r8 == null) goto L86;
        r7 = r8.optBoolean(r4, r7);
    L86:
        return Boolean.valueOf(r7);
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L13:
        if (r5 != Integer.TYPE) goto L15;
    L75:
        if (r6 == null) goto L83;
        int r9 = ((Integer) r6).intValue();
        Intrinsics.checkNotNullParameter(SettingUtil.KEY_TT_APP_SETTING, "key");
        Intrinsics.checkNotNullParameter(r4, "name");
        JSONObject r11 = (JSONObject) ((LinkedHashMap) a).get(SettingUtil.KEY_TT_APP_SETTING);
        if (r11 == null) goto L81;
        r9 = r11.optInt(r4, r9);
    L81:
        return Integer.valueOf(r9);
    L83:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L15:
        if (r5 == Short.TYPE) goto L75;
        if (r5 != Float.TYPE) goto L27;
        if (r6 == null) goto L25;
        float r12 = ((Float) r6).floatValue();
        Intrinsics.checkNotNullParameter(SettingUtil.KEY_TT_APP_SETTING, "key");
        Intrinsics.checkNotNullParameter(r4, "name");
        JSONObject r13 = (JSONObject) ((LinkedHashMap) a).get(SettingUtil.KEY_TT_APP_SETTING);
        if (r13 == null) goto L87;
        r12 = (float) r13.optDouble(r4, r12);
    L87:
        return Float.valueOf(r12);
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L27:
        if (r5 != Long.TYPE) goto L37;
        if (r6 == null) goto L35;
        long r14 = ((Long) r6).longValue();
        Intrinsics.checkNotNullParameter(SettingUtil.KEY_TT_APP_SETTING, "key");
        Intrinsics.checkNotNullParameter(r4, "name");
        JSONObject r0 = (JSONObject) ((LinkedHashMap) a).get(SettingUtil.KEY_TT_APP_SETTING);
        if (r0 == null) goto L88;
        r14 = r0.optLong(r4, r14);
    L88:
        return Long.valueOf(r14);
    L35:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L37:
        if (r5 != Double.TYPE) goto L47;
        if (r6 == null) goto L45;
        double r15 = ((Double) r6).doubleValue();
        Intrinsics.checkNotNullParameter(SettingUtil.KEY_TT_APP_SETTING, "key");
        Intrinsics.checkNotNullParameter(r4, "name");
        JSONObject r1 = (JSONObject) ((LinkedHashMap) a).get(SettingUtil.KEY_TT_APP_SETTING);
        if (r1 == null) goto L89;
        r15 = r1.optDouble(r4, r15);
    L89:
        return Double.valueOf(r15);
    L45:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L47:
        if (r5 != String.class) goto L55;
        if (r6 == null) goto L54;
        String r16 = (String) r6;
        Intrinsics.checkNotNullParameter(SettingUtil.KEY_TT_APP_SETTING, "key");
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r16, "defaultValue");
        JSONObject r17 = (JSONObject) ((LinkedHashMap) a).get(SettingUtil.KEY_TT_APP_SETTING);
        Object r18 = r16;
        if (r17 == null) goto L91;
        return r17.optString(r4, r16);
    L91:
        return r18;
    L54:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L55:
        if (r6 == null) goto L74;
        Intrinsics.checkNotNullParameter(SettingUtil.KEY_TT_APP_SETTING, "key");
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, "typeOfT");
        LinkedHashMap r2 = (LinkedHashMap) a;
        r18 = r6;
        if (((JSONObject) r2.get(SettingUtil.KEY_TT_APP_SETTING)) == null) goto L91;
        String r3 = "";
        if (r2.get(SettingUtil.KEY_TT_APP_SETTING) == null) goto L84;
        Object r19 = r2.get(SettingUtil.KEY_TT_APP_SETTING);
        Intrinsics.checkNotNull(r19);
        r3 = ((JSONObject) r19).optString(r4, "");
    L84:
        Object r21 = SettingUtil.getGson().fromJson(r3, r5);     // Catch: Exception -> L67
        r18 = r6;
        if (r21 == null) goto L91;
        r18 = r21;
    L67:
        e = move-exception;
        if (SettingUtil.isLocalTest() == true) goto L72;
        ALogger.e("TTHostSettingCache", "getObj error:key:TT_APP_SETTING, name:" + r4 + ",type:" + r5 + ", \n error:" + e);
        r18 = r6;
        goto L91
    L72:
        throw e;
    L74:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    }
}
