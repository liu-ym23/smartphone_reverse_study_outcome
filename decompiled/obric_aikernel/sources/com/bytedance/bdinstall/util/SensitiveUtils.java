package com.bytedance.bdinstall.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.ISstInfoProvider;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.SstInfoCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
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

    static /* synthetic */ String access$000(Context r10, InstallOptions r11) {
        return getDefaultImeiOrMeid(r10, r11);
    }

    private static JSONObject createJsonObjForId(String r10, int r11, String r12) {
        JSONObject r13 = new JSONObject();
        if (TextUtils.isEmpty(r10) == true) goto L5;
        r13.put(OaidModel.KEY_ID, r10);
        r13.put("slot_index", r11);
        r13.put(WsConstants.KEY_CONNECTION_TYPE, r12);
    L5:
        return r13;
    }

    public static String getCountry(InstallOptions r10) {
        return r10.getSensitiveInterceptor().getCountry();
    }

    @SuppressLint({"HardwareIds"})
    private static String getDefaultImeiOrMeid(Context r10, InstallOptions r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r11 == null) goto L9;
        if (r11.isCheckPermissionBeforeCallSensitiveApi() == true) goto L9;
    L12:
        return SstInfoCompat.getProvider(String.valueOf(r11.getAid())).getDefaultImeiOrMeid(r10, r11);
    L9:
        if (InstallPmsUtils.checkReadPhoneStatePermission(r10) == true) goto L12;
        return null;
    }

    public static String getDeviceIdWithCache(Context r10, InstallOptions r11) {
        return sDeviceId.get(new Object[]{r10, r11});
    }

    public static Pair<String, Boolean> getGoogleAdid(InstallOptions r10) {
        return new Pair("", Boolean.FALSE);
    }

    public static JSONArray getIPV6Address(Context r10, InstallOptions r11) {
        return sIPV6Address.get(new Object[]{r10, String.valueOf(r11.getAid()), r11});
    }

    @SuppressLint({"HardwareIds"})
    public static String getMacAddress(Context r10, InstallOptions r11) {
        return sWifiMacAddress.get(new Object[]{r10, String.valueOf(r11.getAid()), r11});
    }

    public static String getMediaId(InstallOptions r10) {
        return sMediaID.get(new Object[]{r10});
    }

    public static JSONArray getMultiImei(Context r10, InstallOptions r11) {
        return sMultiImei.get(new Object[]{r10, r11});
    }

    @NonNull
    public static JSONArray getMultiImeiWithCache(Context r10, InstallOptions r11) {
        JSONArray r12 = new JSONArray();
        if (r11 == null) goto L7;
        if (r11.isCheckPermissionBeforeCallSensitiveApi() == true) goto L7;
    L76:
    L66:
        th = move-exception;
        if ((th instanceof SecurityException) == false) goto L70;
        DrLog.e("读取imei没有权限");
    L71:
        return r12;
    L70:
        th.printStackTrace();
        goto L71
    L11:
        String r13 = null;
        if (Build.VERSION.SDK_INT >= 26) goto L79;
        ISstInfoProvider r14 = SstInfoCompat.getProvider(String.valueOf(r11.getAid()));     // Catch: Throwable -> L66
        if (r14 != null) goto L59;
        String r15 = null;
    L60:
        r12.put(createJsonObjForId(r15, 0, "unknown"));     // Catch: Throwable -> L66
        if (r14 == null) goto L64;
        r13 = r14.reflectGetDeviceIdWithSlotIndex(r10, 1);     // Catch: Throwable -> L66
    L64:
        r12.put(createJsonObjForId(r13, 1, "unknown"));     // Catch: Throwable -> L66
        goto L71
    L59:
        r15 = r14.reflectGetDeviceIdWithSlotIndex(r10, 0);     // Catch: Throwable -> L66
        goto L60
    L79:
        ISstInfoProvider r16 = SstInfoCompat.getProvider(String.valueOf(r11.getAid()));     // Catch: Exception -> L19 Throwable -> L66
        if (r16 == null) goto L16;
        String r17 = r16.getMeid(r10, 0, r11);     // Catch: Exception -> L19 Throwable -> L66
    L17:
        r12.put(createJsonObjForId(r17, 0, ID_TYPE_MEID));     // Catch: Exception -> L19 Throwable -> L66
    L72:
        ISstInfoProvider r18 = SstInfoCompat.getProvider(String.valueOf(r11.getAid()));     // Catch: Exception -> L30 Throwable -> L66
        if (r18 == null) goto L27;
        String r19 = r18.getMeid(r10, 1, r11);     // Catch: Exception -> L30 Throwable -> L66
    L28:
        r12.put(createJsonObjForId(r19, 1, ID_TYPE_MEID));     // Catch: Exception -> L30 Throwable -> L66
    L77:
        ISstInfoProvider r20 = SstInfoCompat.getProvider(String.valueOf(r11.getAid()));     // Catch: Exception -> L41 Throwable -> L66
        if (r20 == null) goto L38;
        String r21 = r20.getImei(r10, 0, r11);     // Catch: Exception -> L41 Throwable -> L66
    L39:
        r12.put(createJsonObjForId(r21, 0, ID_TYPE_IMEI));     // Catch: Exception -> L41 Throwable -> L66
    L74:
        ISstInfoProvider r22 = SstInfoCompat.getProvider(String.valueOf(r11.getAid()));     // Catch: Exception -> L51 Throwable -> L66
        if (r22 == null) goto L49;
        r13 = r22.getImei(r10, 1, r11);     // Catch: Exception -> L51 Throwable -> L66
    L49:
        r12.put(createJsonObjForId(r13, 1, ID_TYPE_IMEI));     // Catch: Exception -> L51 Throwable -> L66
    L51:
        e = move-exception;
        if ((e instanceof SecurityException) == false) goto L55;
        DrLog.e("读取imei没有权限");     // Catch: Throwable -> L66
        goto L71
    L55:
        e.printStackTrace();     // Catch: Throwable -> L66
        goto L71
    L38:
        r21 = null;
    L41:
        e = move-exception;
        if ((e instanceof SecurityException) == false) goto L45;
        DrLog.e("读取imei没有权限");     // Catch: Throwable -> L66
        goto L74
    L45:
        e.printStackTrace();     // Catch: Throwable -> L66
        goto L74
    L27:
        r19 = null;
    L30:
        e = move-exception;
        if ((e instanceof SecurityException) == false) goto L34;
        DrLog.e("读取imei没有权限");     // Catch: Throwable -> L66
        goto L77
    L34:
        e.printStackTrace();     // Catch: Throwable -> L66
        goto L77
    L16:
        r17 = null;
    L19:
        e = move-exception;
        if ((e instanceof SecurityException) == false) goto L23;
        DrLog.e("读取imei没有权限");     // Catch: Throwable -> L66
        goto L72
    L23:
        e.printStackTrace();     // Catch: Throwable -> L66
    L7:
        if (InstallPmsUtils.checkReadPhoneStatePermission(r10) == true) goto L76;
        return new JSONArray();
    }

    public static String getNetworkOperator(InstallOptions r10) {
        return r10.getSensitiveInterceptor().getNetworkOperator();
    }

    public static String getNetworkOperatorName(InstallOptions r10) {
        return r10.getSensitiveInterceptor().getNetworkOperatorName();
    }

    public static String getSerialNumber(Context r10, InstallOptions r11) {
        if (r11.isEnableLoadSN() == true) goto L5;
        return null;
    L5:
        return mSerialNumber.get(new Object[]{r10, r11});
    }

    @SuppressLint({"HardwareIds", "MissingPermission", "NewApi"})
    public static String getSerialNumberWithCache(Context r10, InstallOptions r11) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L16;
        if (r10.getApplicationInfo().targetSdkVersion < 26) goto L16;
        if (r11 == null) goto L13;
        if (r11.isCheckPermissionBeforeCallSensitiveApi() == false) goto L16;
    L13:
        if (InstallPmsUtils.checkReadPhoneStatePermission(r10) == true) goto L16;
        return null;
    L16:
        return SstInfoCompat.getProvider(String.valueOf(r11.getAid())).getSerial(r10, r11);
    }

    public static String getSimCountryIso(InstallOptions r10) {
        return r10.getSensitiveInterceptor().getSimCountryIso();
    }

    public static String[] getSimSerialNumbers(Context r10, InstallOptions r11) {
        return SimSerialNumbers.get(new Object[]{r10, r11});
    }

    @SuppressLint({"HardwareIds"})
    public static String[] getSimSerialNumbersWithCache(Context r10, InstallOptions r11) {
        if (r10 == null) goto L20;
        if (RomUtils.isAndroidROrHigher() == true) goto L20;
        if (r11 == null) goto L10;
        if (r11.isCheckPermissionBeforeCallSensitiveApi() == true) goto L10;
    L12:
        ISstInfoProvider r12 = SstInfoCompat.getProvider(String.valueOf(r11.getAid()));
        if (r12 == null) goto L18;
        String[] r13 = r12.getSimSerialNumbers(r10, r11);
        if (r13 == null) goto L18;
        return r13;
    L18:
        return new String[0];
    L10:
        if (InstallPmsUtils.checkReadPhoneStatePermission(r10) == true) goto L12;
    L20:
        return new String[0];
    }
}
