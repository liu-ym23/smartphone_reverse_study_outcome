package com.obric.cae.smartNetwork.networkHandoverRL.feature;

import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes2.dex */
public class FeatureUtil {
    public static final String BROADCAST_TRAFFIC_QUERY = "com.android.internal.telephony.sms.TRAFFIC_QUERY";
    public static final String BROADCAST_TRAFFIC_QUERY_RESPONSE = "com.android.internal.telephony.sms.TRAFFIC_QUERY_RESPONSE";
    public static final int CATEGORY_GAME = 4;
    public static final int CATEGORY_NEWS = 3;
    public static final int CATEGORY_OTHER = 0;
    public static final int CATEGORY_SOCIAL = 2;
    public static final int CATEGORY_VIDEO = 1;
    public static final String KEY_REMAINING_TRAFFIC = "remaining_traffic";
    public static final String KEY_USED_TRAFFIC = "used_traffic";
    public static final int LOCATION_COMPANY_DOOR = 4;
    public static final int LOCATION_COMPANY_INDOOR = 2;
    public static final int LOCATION_HOME_DOOR = 3;
    public static final int LOCATION_HOME_INDOOR = 1;
    public static final int LOCATION_OUTSIDE = 5;
    public static final int LOCATION_UNKNOWN = 0;
    public static final String PREF_NAME = "traffic_query_prefs";
    public static final int QOE_LEVEL_BAD = 0;
    public static final int QOE_LEVEL_GOOD = 1;

    public FeatureUtil() {
    }

    public static int getCurrentLocation(String r8) {
        r8.getClass();
        byte r10 = -1;
        switch(r8.hashCode()) {
            case -1106037339: goto L22;
            case -527125069: goto L18;
            case -406175659: goto L14;
            case 1429595696: goto L10;
            case 2117737230: goto L6;
            default: goto L25;
        };
    L25:
        switch(r10) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            default: goto L26;
        };
    L26:
        return 0;
    L27:
        return 3;
    L28:
        return 4;
    L29:
        return 2;
    L30:
        return 1;
    L31:
        return 5;
    L6:
        if (r8.equals("home_door") == false) goto L25;
        r10 = 4;
        goto L25
    L10:
        if (r8.equals("company_door") == false) goto L25;
        r10 = 3;
        goto L25
    L14:
        if (r8.equals("company_indoor") == false) goto L25;
        r10 = 2;
        goto L25
    L18:
        if (r8.equals("home_indoor") == false) goto L25;
        r10 = 1;
        goto L25
    L22:
        if (r8.equals("outside") == false) goto L25;
        r10 = 0;
        goto L25
    }

    public static float parseTrafficToMB(String r11) {
        if (r11 != null) goto L5;
    L44:
        return 0.0f;
    L5:
        if (r11.trim().isEmpty() == true) goto L44;
        String r8 = r11.trim().toUpperCase();     // Catch: Exception -> L42
        StringBuilder r10 = new StringBuilder();     // Catch: Exception -> L42
        char[] r12 = r8.toCharArray();     // Catch: Exception -> L42
        int r13 = r12.length;     // Catch: Exception -> L42
        int r14 = 0;
        boolean r15 = false;
        boolean r16 = false;
    L8:
        if (r14 >= r13) goto L20;
        char r17 = r12[r14];     // Catch: Exception -> L42
        if (Character.isDigit(r17) == false) goto L13;
        r10.append(r17);     // Catch: Exception -> L42
        r16 = true;
    L18:
        r14 = r14 + 1;     // Catch: Exception -> L42
        goto L8
    L13:
        if (r17 != '.') goto L16;
        if (r15 == true) goto L16;
        r10.append(r17);     // Catch: Exception -> L42
        r15 = true;
    L16:
        if (r16 == false) goto L18;
    L20:
        if (r10.length() != 0) goto L22;
        return 0.0f;
    L22:
        float r18 = Float.parseFloat(r10.toString());     // Catch: Exception -> L42
        if (r8.contains("GB") == true) goto L41;
        if (r8.contains("G") == true) goto L41;
        if (r8.contains("KB") == true) goto L39;
        if (r8.contains("K") == true) goto L39;
        if (r8.contains("MB") == false) goto L35;
    L37:
        return r18;
    L35:
        if (r8.contains("M") == true) goto L37;
        r8.contains("B");     // Catch: Exception -> L42
    L39:
        return r18 / 1024.0f;
    L41:
        return r18 * 1024.0f;
    L42:
        e = move-exception;
        CaeLog.e("FeatureUtil", "Failed to parse traffic string: ".concat(r11), e);
        goto L44
    }
}
