package com.bytedance.bdinstall.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.ISstInfoProvider;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.SstInfoCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SensitiveUtils {
    private static final String ID_TYPE_IMEI = "imei";
    private static final String ID_TYPE_MEID = "meid";
    private static final String ID_TYPE_UNKNOWN = "unknown";
    private static final Singleton<String[]> SimSerialNumbers = null;
    private static final Singleton<String> mSerialNumber = null;
    private static final Singleton<String> sDeviceId = null;
    private static final Singleton<JSONArray> sIPV6Address = null;
    private static final Singleton<String> sMediaID = null;
    private static final Singleton<JSONArray> sMultiImei = null;
    private static final Singleton<String> sWifiMacAddress = null;

    static {
        sDeviceId = new AnonymousClass1();
        SimSerialNumbers = new AnonymousClass2();
        sMultiImei = new AnonymousClass3();
        mSerialNumber = new AnonymousClass4();
        sWifiMacAddress = new AnonymousClass5();
        sIPV6Address = new AnonymousClass6();
        sMediaID = new AnonymousClass7();
    }

    public SensitiveUtils() {
    }

    static /* synthetic */ String access$000(Context r2, InstallOptions r3) {
        return getDefaultImeiOrMeid((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
    }

    private static JSONObject createJsonObjForId(String r2, int r3, String r4) {
        JSONObject r0 = new JSONObject();
        if (TextUtils.isEmpty(r2) == true) goto L5;
        r0.put(OaidModel.KEY_ID, r2);
        r0.put("slot_index", r3);
        r0.put("type", r4);
    L5:
        return r0;
    }

    public static String getCountry(InstallOptions r0) {
        return r0.getSensitiveInterceptor().getCountry();
    }

    private static String getDefaultImeiOrMeid(Context r2, InstallOptions r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r3 == null) goto L9;
        if (r3.isCheckPermissionBeforeCallSensitiveApi() == true) goto L9;
    L12:
        return SstInfoCompat.getProvider(String.valueOf(r3.getAid())).getDefaultImeiOrMeid(r4, r3);
    L9:
        if (InstallPmsUtils.checkReadPhoneStatePermission(r4) == true) goto L12;
        return null;
    }

    public static String getDeviceIdWithCache(Context r4, InstallOptions r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        return (String) ZeusTransformUtils.preCheckCast(sDeviceId.get(new Object[]{r6, r5}), String.class, "com.obric.memorydata.plugin");
    }

    public static Pair<String, Boolean> getGoogleAdid(InstallOptions r2) {
        return new Pair("", false);
    }

    public static JSONArray getIPV6Address(Context r4, InstallOptions r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        return (JSONArray) ZeusTransformUtils.preCheckCast(sIPV6Address.get(new Object[]{r6, String.valueOf(r5.getAid()), r5}), JSONArray.class, "com.obric.memorydata.plugin");
    }

    public static String getMacAddress(Context r4, InstallOptions r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        return (String) ZeusTransformUtils.preCheckCast(sWifiMacAddress.get(new Object[]{r6, String.valueOf(r5.getAid()), r5}), String.class, "com.obric.memorydata.plugin");
    }

    public static String getMediaId(InstallOptions r3) {
        return (String) ZeusTransformUtils.preCheckCast(sMediaID.get(new Object[]{r3}), String.class, "com.obric.memorydata.plugin");
    }

    public static JSONArray getMultiImei(Context r4, InstallOptions r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        return (JSONArray) ZeusTransformUtils.preCheckCast(sMultiImei.get(new Object[]{r6, r5}), JSONArray.class, "com.obric.memorydata.plugin");
    }

    public static JSONArray getMultiImeiWithCache(Context r10, InstallOptions r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        JSONArray r4 = new JSONArray();
        if (r11 == null) goto L7;
        if (r11.isCheckPermissionBeforeCallSensitiveApi() == true) goto L7;
    L78:
    L66:
        th = move-exception;
        if (ZeusTransformUtils.instanceOf(th, SecurityException.class) == false) goto L70;
        DrLog.e("读取imei没有权限");
    L71:
        return r4;
    L70:
        th.printStackTrace();
        goto L71
    L11:
        String r9 = null;
        if (Build.VERSION.SDK_INT >= 26) goto L79;
        ISstInfoProvider r13 = SstInfoCompat.getProvider(String.valueOf(r11.getAid()));     // Catch: Throwable -> L66
        if (r13 != null) goto L59;
        String r0 = null;
    L60:
        r4.put(createJsonObjForId(r0, 0, "unknown"));     // Catch: Throwable -> L66
        if (r13 == null) goto L64;
        r9 = r13.reflectGetDeviceIdWithSlotIndex(r12, 1);     // Catch: Throwable -> L66
    L64:
        r4.put(createJsonObjForId(r9, 1, "unknown"));     // Catch: Throwable -> L66
        goto L71
    L59:
        r0 = r13.reflectGetDeviceIdWithSlotIndex(r12, 0);     // Catch: Throwable -> L66
        goto L60
    L79:
        ISstInfoProvider r1 = SstInfoCompat.getProvider(String.valueOf(r11.getAid()));     // Catch: Exception -> L19 Throwable -> L66
        if (r1 == null) goto L16;
        String r2 = r1.getMeid(r12, 0, r11);     // Catch: Exception -> L19 Throwable -> L66
    L17:
        r4.put(createJsonObjForId(r2, 0, ID_TYPE_MEID));     // Catch: Exception -> L19 Throwable -> L66
    L72:
        ISstInfoProvider r3 = SstInfoCompat.getProvider(String.valueOf(r11.getAid()));     // Catch: Exception -> L30 Throwable -> L66
        if (r3 == null) goto L27;
        String r5 = r3.getMeid(r12, 1, r11);     // Catch: Exception -> L30 Throwable -> L66
    L28:
        r4.put(createJsonObjForId(r5, 1, ID_TYPE_MEID));     // Catch: Exception -> L30 Throwable -> L66
    L74:
        ISstInfoProvider r6 = SstInfoCompat.getProvider(String.valueOf(r11.getAid()));     // Catch: Exception -> L41 Throwable -> L66
        if (r6 == null) goto L38;
        String r7 = r6.getImei(r12, 0, r11);     // Catch: Exception -> L41 Throwable -> L66
    L39:
        r4.put(createJsonObjForId(r7, 0, ID_TYPE_IMEI));     // Catch: Exception -> L41 Throwable -> L66
    L76:
        ISstInfoProvider r8 = SstInfoCompat.getProvider(String.valueOf(r11.getAid()));     // Catch: Exception -> L51 Throwable -> L66
        if (r8 == null) goto L49;
        r9 = r8.getImei(r12, 1, r11);     // Catch: Exception -> L51 Throwable -> L66
    L49:
        r4.put(createJsonObjForId(r9, 1, ID_TYPE_IMEI));     // Catch: Exception -> L51 Throwable -> L66
    L51:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, SecurityException.class) == false) goto L55;
        DrLog.e("读取imei没有权限");     // Catch: Throwable -> L66
        goto L71
    L55:
        e.printStackTrace();     // Catch: Throwable -> L66
        goto L71
    L38:
        r7 = null;
    L41:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, SecurityException.class) == false) goto L45;
        DrLog.e("读取imei没有权限");     // Catch: Throwable -> L66
        goto L76
    L45:
        e.printStackTrace();     // Catch: Throwable -> L66
        goto L76
    L27:
        r5 = null;
    L30:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, SecurityException.class) == false) goto L34;
        DrLog.e("读取imei没有权限");     // Catch: Throwable -> L66
        goto L74
    L34:
        e.printStackTrace();     // Catch: Throwable -> L66
        goto L74
    L16:
        r2 = null;
    L19:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, SecurityException.class) == false) goto L23;
        DrLog.e("读取imei没有权限");     // Catch: Throwable -> L66
        goto L72
    L23:
        e.printStackTrace();     // Catch: Throwable -> L66
    L7:
        if (InstallPmsUtils.checkReadPhoneStatePermission(r12) == true) goto L78;
        return new JSONArray();
    }

    public static String getNetworkOperator(InstallOptions r0) {
        return r0.getSensitiveInterceptor().getNetworkOperator();
    }

    public static String getNetworkOperatorName(InstallOptions r0) {
        return r0.getSensitiveInterceptor().getNetworkOperatorName();
    }

    public static String getSerialNumber(Context r4, InstallOptions r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5.isEnableLoadSN() == true) goto L5;
        return null;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(mSerialNumber.get(new Object[]{r6, r5}), String.class, "com.obric.memorydata.plugin");
    }

    public static String getSerialNumberWithCache(Context r3, InstallOptions r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L16;
        if (r5.getApplicationInfo().targetSdkVersion < 26) goto L16;
        if (r4 == null) goto L13;
        if (r4.isCheckPermissionBeforeCallSensitiveApi() == false) goto L16;
    L13:
        if (InstallPmsUtils.checkReadPhoneStatePermission(r5) == true) goto L16;
        return null;
    L16:
        return SstInfoCompat.getProvider(String.valueOf(r4.getAid())).getSerial(r5, r4);
    }

    public static String getSimCountryIso(InstallOptions r0) {
        return r0.getSensitiveInterceptor().getSimCountryIso();
    }

    public static String[] getSimSerialNumbers(Context r4, InstallOptions r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        return (String[]) ZeusTransformUtils.preCheckCast(SimSerialNumbers.get(new Object[]{r6, r5}), String[].class, "com.obric.memorydata.plugin");
    }

    public static String[] getSimSerialNumbersWithCache(Context r2, InstallOptions r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L20;
        if (RomUtils.isAndroidROrHigher() == true) goto L20;
        if (r3 == null) goto L10;
        if (r3.isCheckPermissionBeforeCallSensitiveApi() == true) goto L10;
    L12:
        ISstInfoProvider r1 = SstInfoCompat.getProvider(String.valueOf(r3.getAid()));
        if (r1 == null) goto L18;
        String[] r5 = r1.getSimSerialNumbers(r4, r3);
        if (r5 == null) goto L18;
        return r5;
    L18:
        return new String[0];
    L10:
        if (InstallPmsUtils.checkReadPhoneStatePermission(r4) == true) goto L12;
    L20:
        return new String[0];
    }
}
