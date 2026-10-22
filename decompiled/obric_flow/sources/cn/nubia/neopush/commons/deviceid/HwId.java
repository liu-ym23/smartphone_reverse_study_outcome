package cn.nubia.neopush.commons.deviceid;

import ai.j0;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
class HwId {
    private static final String TAG = "HwId";
    private static ClassAccessor sCA;

    static {
        sCA = new ClassAccessor();
    }

    public HwId() {
    }

    private static void addMID(String r5, ArrayList<String> r10, ArrayList<String> r11) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        if (IdCodecer.allZeros(r5) == true) goto L33;
        int r12 = r5.length();
        if (r12 != 8) goto L9;
    L27:
        if (r11 != null) goto L29;
        return;
    L29:
        if (r11.contains(r5) == true) goto L42;
        r11.add(r5);
        return;
    L42:
        return;
    L9:
        if (r12 == 11) goto L27;
        if (r12 != 14) goto L13;
    L23:
        if (r11 != null) goto L25;
        return;
    L25:
        if (r11.contains(r5) == true) goto L39;
        r11.add(r5);
        return;
    L39:
        return;
    L13:
        if (r12 != 15) goto L15;
        if (r10 != null) goto L21;
        return;
    L21:
        if (r10.contains(r5) == true) goto L36;
        r10.add(r5);
        return;
    L36:
        return;
    L15:
        if (r12 == 18) goto L23;
        if (r12 == 19) goto L23;
        Log.w(TAG, "invalid mobile id format ".concat(r5));
        return;
    }

    public static String getSerial() {
        String r5 = (String) sCA.getFieldValue(Build.class, Build.class, "MANUFACTURER");
        String r10 = (String) sCA.getFieldValue(Build.class, Build.class, "MODEL");
        String r11 = (String) sCA.invokeMethod(Build.class, Build.class, "getSerial", null, null);
        if (TextUtils.isEmpty(r11) == false) goto L6;
        Class<?> r12 = sCA.loadClass("android.os.SystemProperties");
        r11 = (String) sCA.invokeMethod(r12, r12, "get", String.class, "ro.serialno");
    L6:
        if (TextUtils.isEmpty(r5) == false) goto L8;
        return null;
    L8:
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return null;
    L10:
        if (TextUtils.isEmpty(r11) == false) goto L12;
        return null;
    L12:
        return j0.q(new StringBuilder(String.valueOf(r5)), r10, r11);
    }

    public static void getTelephonyIds(Context r11, ArrayList<String> r12, ArrayList<String> r13) {
        if (r11 == null) goto L29;
        Object r14 = r11.getSystemService("phone");
        if (r14 == null) goto L33;
        Integer r5 = (Integer) sCA.invokeMethod(TelephonyManager.class, r14, "getPhoneCount", null, null);
        if (r5 == null) goto L9;
        int r10 = r5.intValue();
        if (r10 < 1) goto L9;
        int r15 = r10;
    L11:
        int r16 = 0;
        int r17 = 0;
    L12:
        if (r17 >= r15) goto L13;
        addMID((String) sCA.invokeMethod(TelephonyManager.class, r14, "getImei", Integer.TYPE, Integer.valueOf(r17)), r12, r13);
        r17 = r17 + 1;
        goto L12
    L13:
        addMID((String) sCA.invokeMethod(TelephonyManager.class, r14, "getImei", null, null), r12, r13);
        int r18 = 0;
    L14:
        if (r18 >= r15) goto L15;
        addMID((String) sCA.invokeMethod(TelephonyManager.class, r14, "getMeid", Integer.TYPE, Integer.valueOf(r18)), r12, r13);
        r18 = r18 + 1;
        goto L14
    L15:
        addMID((String) sCA.invokeMethod(TelephonyManager.class, r14, "getMeid", null, null), r12, r13);
    L16:
        if (r16 >= r15) goto L17;
        addMID((String) sCA.invokeMethod(TelephonyManager.class, r14, "getDeviceId", Integer.TYPE, Integer.valueOf(r16)), r12, r13);
        r16 = r16 + 1;
        goto L16
    L17:
        addMID((String) sCA.invokeMethod(TelephonyManager.class, r14, "getDeviceId", null, null), r12, r13);
        if (r12 != null) goto L20;
    L22:
        if (r13 != null) goto L24;
        return;
    L24:
        if (r13.size() <= 1) goto L35;
        Collections.sort(r13);
        return;
    L35:
        return;
    L20:
        if (r12.size() <= 1) goto L22;
        Collections.sort(r12);
    L9:
        r15 = 1;
        goto L11
    L33:
        return;
    }
}
