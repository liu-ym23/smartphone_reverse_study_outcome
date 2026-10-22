package com.bytedance.badger.z;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataULong;
import com.bytedance.badger.module.BadgerModuleBase;
import kotlin.ULong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0 extends u0 {
    public c0() {
    }

    public static String c(TelephonyManager r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        f06.d r12 = r8.b(102021, "android/telephony/TelephonyManager", "getSimOperator", r13, r9, "java.lang.String", r10);
        if (r12.a == false) goto L6;
        r8.a(102021, "android/telephony/TelephonyManager", "getSimOperator", r13, r9, null, r10, false);
        return (String) r12.b;
    L6:
        String r14 = r13.getSimOperator();
        r8.a(102021, "android/telephony/TelephonyManager", "getSimOperator", r13, r9, r14, r10, true);
        return r14;
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r12, BadgerModuleBase.BadgerRequestData r13) {
        String r14 = Constants.NetworkOperator.OTHERS_OPERATOR;
        if (r12 != null) goto L111;
    L11:
        boolean r1 = false;
    L13:
        if (r1 == true) goto L16;
        r14 = Constants.NetworkOperator.SIM_CARD_NOT_READY;
    L86:
        int r15 = r14.hashCode();
        long r9 = 0;
        if (r15 == (-2037477446)) goto L102;
        if (r15 == (-278955830)) goto L99;
        if (r15 == (-50643271)) goto L96;
        if (r15 != 1582678639) goto L106;
        if (r14.equals(Constants.NetworkOperator.TELECOM_OPERATOR) == false) goto L106;
        long r16 = 4;
    L104:
        r9 = ULong.constructor-impl(ULong.constructor-impl(r16) | 0);
    L106:
        return new BadgerResult.Success(new DataULong(r9, null));
    L96:
        if (r14.equals(Constants.NetworkOperator.UNICOM_OPERATOR) == false) goto L106;
        r16 = 2;
        goto L104
    L99:
        if (r14.equals(Constants.NetworkOperator.MOBILE_OPERATOR) == false) goto L106;
        r16 = 1;
        goto L104
    L102:
        if (r14.equals(Constants.NetworkOperator.UNKNOWN_OPERATOR) == false) goto L106;
        r16 = 128;
        goto L104
    L16:
        if (r12 != null) goto L109;
    L23:
        String r17 = "";
    L113:
        int r0 = r17.hashCode();     // Catch: Exception -> L84
        if (r0 == 49679502) goto L59;
        switch(r0) {
            case 49679470: goto L56;
            case 49679471: goto L53;
            case 49679472: goto L50;
            case 49679473: goto L47;
            case 49679474: goto L44;
            case 49679475: goto L41;
            case 49679476: goto L38;
            case 49679477: goto L35;
            case 49679478: goto L32;
            case 49679479: goto L29;
            default: goto L61;
        };     // Catch: Exception -> L84
    L61:
        String r18 = "";
    L62:
        int r2 = r18.hashCode();     // Catch: Exception -> L84
        if (r2 == (-1300183871)) goto L82;
        if (r2 == (-278955830)) goto L79;
        if (r2 == (-50643271)) goto L76;
        if (r2 == 0) goto L73;
        if (r2 != 1582678639) goto L85;
        if (r18.equals(Constants.NetworkOperator.TELECOM_OPERATOR) == false) goto L85;
        r14 = Constants.NetworkOperator.TELECOM_OPERATOR;
        goto L86
    L73:
        if (r18.equals("") == false) goto L85;
        r14 = Constants.NetworkOperator.UNKNOWN_OPERATOR;
        goto L86
    L76:
        if (r18.equals(Constants.NetworkOperator.UNICOM_OPERATOR) == false) goto L85;
        r14 = Constants.NetworkOperator.UNICOM_OPERATOR;
        goto L86
    L79:
        if (r18.equals(Constants.NetworkOperator.MOBILE_OPERATOR) == false) goto L85;
        r14 = Constants.NetworkOperator.MOBILE_OPERATOR;
        goto L86
    L82:
        if (r18.equals(Constants.NetworkOperator.OTHERS_OPERATOR) == false) goto L85;
    L29:
        if (r17.equals("46009") == false) goto L61;
    L54:
        r18 = Constants.NetworkOperator.UNICOM_OPERATOR;
        goto L62
    L32:
        if (r17.equals("46008") == false) goto L61;
    L57:
        r18 = Constants.NetworkOperator.MOBILE_OPERATOR;
        goto L62
    L35:
        if (r17.equals("46007") == false) goto L61;
    L38:
        if (r17.equals("46006") == false) goto L61;
    L41:
        if (r17.equals("46005") == false) goto L61;
    L60:
        r18 = Constants.NetworkOperator.TELECOM_OPERATOR;
        goto L62
    L44:
        if (r17.equals("46004") == false) goto L61;
    L47:
        if (r17.equals("46003") == false) goto L61;
    L50:
        if (r17.equals("46002") == false) goto L61;
    L53:
        if (r17.equals("46001") == false) goto L61;
    L56:
        if (r17.equals("46000") == false) goto L61;
    L59:
        if (r17.equals("46011") == false) goto L61;
    L85:
        r14 = "";
        goto L86
    L109:
        TelephonyManager r19 = (TelephonyManager) r12.getSystemService("phone");     // Catch: Throwable -> L107
        if (r19 == null) goto L23;
        r17 = c(r19);     // Catch: Throwable -> L107
    L111:
        TelephonyManager r3 = (TelephonyManager) r12.getSystemService("phone");     // Catch: Exception -> L108
        if (r3 == null) goto L11;
        if (r3.getSimState() != 5) goto L11;
        r1 = true;
        goto L13
    }
}
