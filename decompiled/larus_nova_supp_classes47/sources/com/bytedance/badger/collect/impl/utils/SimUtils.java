package com.bytedance.badger.collect.impl.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.telephony.SubscriptionManagerCompat;
import com.bytedance.badger.collect.impl.api.BadgerCollectApi;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.interfaces.ISimCardCompliance;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class SimUtils {
    public static final int SIM_TYPE_MOBILE = 1;
    public static final int SIM_TYPE_TELECOM = 2;
    public static final int SIM_TYPE_UNICOM = 3;
    public static final int SIM_TYPE_UNKNOWN = 0;

    public SimUtils() {
    }

    public static int getSimCardSlotId() {
        int r3 = Build.VERSION.SDK_INT;     // Catch: Exception -> L9
        if (r3 < 24) goto L7;
        int r2 = SubscriptionManager.getDefaultDataSubscriptionId();     // Catch: Exception -> L9
        int r4 = SubscriptionManagerCompat.getSlotIndex(r2);     // Catch: Exception -> L9
        KLog.i(Constants.TAGS.WORKER, "默认数据网络的ID=" + r2 + ", 物理卡槽slotIndex=" + r4);     // Catch: Exception -> L9
        return r4;
    L7:
        KLog.w(Constants.TAGS.WORKER, "当前Android版本过低，无法获取,版本=" + r3);     // Catch: Exception -> L9
        return Constants.StatusCode.ERROR_SDK_VERSION_LOW.intValue();
    L9:
        e = move-exception;
        KLog.e(Constants.TAGS.WORKER, e);
        return Constants.StatusCode.FAILED.intValue();
    }

    private static int com_bytedance_badger_collect_impl_utils_SimUtils_android_telephony_SubscriptionInfo_getSubscriptionId(SubscriptionInfo r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        b r12 = new b();
        a r2 = (a) ApiHookConfig.b.get(102134);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(102134, "android/telephony/SubscriptionInfo", "getSubscriptionId", r18, r10, "int", r12);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.getSubscriptionId();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static String getSimIccId(Context r6) {
    L28:
        e = move-exception;
        KLog.e(Constants.TAGS.INIT, e);
        return "";
    L4:
        if (CommonUtils.hasPermission(r6, "android.permission.READ_PHONE_STATE") == true) goto L6;
        return "";
    L6:
        ISimCardCompliance r1 = BadgerCollectApi.getSimCardCompliance();     // Catch: Exception -> L28
        if (r1 != null) goto L10;
        return "";
    L10:
        if (Build.VERSION.SDK_INT < 24) goto L27;
        SubscriptionManager r2 = (SubscriptionManager) r6.getApplicationContext().getSystemService("telephony_subscription_service");     // Catch: Exception -> L28
        if (r2 == null) goto L27;
        int r3 = SubscriptionManager.getDefaultDataSubscriptionId();     // Catch: Exception -> L28
        List r4 = r1.getActiveSubscriptionInfoList(r2);     // Catch: Exception -> L28
        if (r4 == null) goto L27;
        if (r4.size() <= 0) goto L27;
        Iterator r5 = r4.iterator();     // Catch: Exception -> L28
    L19:
        if (r5.hasNext() == false) goto L27;
        SubscriptionInfo r7 = (SubscriptionInfo) r5.next();     // Catch: Exception -> L28
        if (r7 == null) goto L19;
        if (com_bytedance_badger_collect_impl_utils_SimUtils_android_telephony_SubscriptionInfo_getSubscriptionId(r7) != r3) goto L19;
        return r1.getIccId(r7);
    L27:
        return r1.getSimSerialNumber((TelephonyManager) r6.getApplicationContext().getSystemService("phone"));
    }

    public static String getSimOperator(Context r3) {
        if (r3 != null) goto L17;
        KLog.e(Constants.TAGS.INIT, "getSimOperator:context == null");
        return "";
    L17:
        TelephonyManager r4 = (TelephonyManager) r3.getSystemService("phone");     // Catch: Exception -> L14
        if (r4 == null) goto L16;
        ISimCardCompliance r2 = BadgerCollectApi.getSimCardCompliance();     // Catch: Exception -> L14
        if (r2 != null) goto L13;
        KLog.e(Constants.TAGS.INIT, "sim error");     // Catch: Exception -> L14
        return "";
    L13:
        return r2.getSimOperator(r4);
    L16:
        return "";
    L14:
        e = move-exception;
        KLog.e(Constants.TAGS.INIT, e);
        goto L16
    }

    public static String getSimOperatorName(Context r1) {
        int r2 = getSimType(r1);
        if (r2 != 1) goto L5;
        return "中国移动";
    L5:
        if (r2 != 2) goto L7;
        return "中国电信";
    L7:
        if (r2 == 3) goto L10;
        return "UN_KNOW";
    L10:
        return "中国联通";
    }

    public static int getSimType(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return 0;
    L5:
        r6.getClass();
        byte r5 = -1;
        switch(r6.hashCode()) {
            case 49679470: goto L49;
            case 49679471: goto L45;
            case 49679472: goto L41;
            case 49679473: goto L37;
            case 49679474: goto L33;
            case 49679475: goto L29;
            case 49679476: goto L25;
            case 49679477: goto L21;
            case 49679478: goto L17;
            case 49679479: goto L13;
            case 49679502: goto L9;
            default: goto L52;
        };
    L52:
        switch(r5) {
            case 0: goto L56;
            case 1: goto L55;
            case 2: goto L56;
            case 3: goto L54;
            case 4: goto L56;
            case 5: goto L54;
            case 6: goto L55;
            case 7: goto L56;
            case 8: goto L56;
            case 9: goto L55;
            case 10: goto L54;
            default: goto L53;
        };
    L53:
        return 0;
    L54:
        return 2;
    L55:
        return 3;
    L56:
        return 1;
    L9:
        if (r6.equals("46011") == false) goto L52;
        r5 = 10;
        goto L52
    L13:
        if (r6.equals("46009") == false) goto L52;
        r5 = 9;
        goto L52
    L17:
        if (r6.equals("46008") == false) goto L52;
        r5 = 8;
        goto L52
    L21:
        if (r6.equals("46007") == false) goto L52;
        r5 = 7;
        goto L52
    L25:
        if (r6.equals("46006") == false) goto L52;
        r5 = 6;
        goto L52
    L29:
        if (r6.equals("46005") == false) goto L52;
        r5 = 5;
        goto L52
    L33:
        if (r6.equals("46004") == false) goto L52;
        r5 = 4;
        goto L52
    L37:
        if (r6.equals("46003") == false) goto L52;
        r5 = 3;
        goto L52
    L41:
        if (r6.equals("46002") == false) goto L52;
        r5 = 2;
        goto L52
    L45:
        if (r6.equals("46001") == false) goto L52;
        r5 = 1;
        goto L52
    L49:
        if (r6.equals("46000") == false) goto L52;
        r5 = 0;
        goto L52
    }

    public static int getSimType(Context r0) {
        return getSimType(getSimOperator(r0));
    }
}
