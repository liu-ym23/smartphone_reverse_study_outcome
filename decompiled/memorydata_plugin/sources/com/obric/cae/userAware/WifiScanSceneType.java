package com.obric.cae.userAware;

/* JADX INFO: loaded from: classes3.dex */
public final class WifiScanSceneType {
    public static final int COLLECTION_BEGIN = 300;
    public static final int COLLECTION_END = 399;
    public static final int COLLECTION_WIFI_RECORD = 301;
    public static final int COMPANY_RSSI_DROP_10S_GT_10DB = 7;
    public static final int CONNECTED_ACTIVE = 5;
    public static final int DISCONNECTED_ACTIVE = 4;
    public static final int ELEVATOR_BEGIN = 200;
    public static final int ELEVATOR_END = 299;
    public static final int ELEVATOR_NEAR_ELEVATOR_WIFI = 202;
    public static final int ELEVATOR_OUT_ELEVATOR_WIFI = 201;
    public static final int GEO_BEGIN = 400;
    public static final int GEO_END = 499;
    public static final int GEO_NORMAL = 401;
    public static final int GEO_TRAINING = 402;
    public static final int HAR_BEGIN = 100;
    public static final int HAR_END = 199;
    public static final int HAR_LEVEL2_WIFI = 101;
    public static final int HOME_COMPANY_AWARE_END = 99;
    public static final int HOME_RSSI_CHANGE_2S_GT_9DB = 6;
    public static final int HOME_RSSI_DROP_5S_GT_17DB = 8;
    public static final int INVALID = -1;
    public static final int[] RSSI_FLUCTUATION_SCENE_IDS = null;
    public static final int WIFI_FENCE_ACTIVE = 3;

    static {
        RSSI_FLUCTUATION_SCENE_IDS = new int[]{6, 7, 8};
    }

    private WifiScanSceneType() {
    }

    public static boolean isCollectionScene(int r1) {
        if (r1 > 300) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 399) goto L7;
        return true;
    }

    public static boolean isElevatorScene(int r1) {
        if (r1 > 200) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 299) goto L7;
        return true;
    }

    public static boolean isGeoScene(int r1) {
        if (r1 > 400) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 499) goto L7;
        return true;
    }

    public static boolean isHarScene(int r1) {
        if (r1 > 100) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 199) goto L7;
        return true;
    }

    public static boolean isHomeCompanyAwareScene(int r1) {
        if (r1 >= 3) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 99) goto L7;
        return true;
    }

    public static boolean isWifiScanCountScene(int r1) {
        if (r1 >= 3) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 99) goto L7;
        return true;
    }

    public static int sceneIdOf(String r8) {
        if (r8 != null) goto L5;
        return -1;
    L5:
        r8.hashCode();
        switch(r8.hashCode()) {
            case -1870679328: goto L53;
            case -1443861660: goto L49;
            case -980148258: goto L45;
            case -976335110: goto L41;
            case -916930912: goto L37;
            case -689859204: goto L33;
            case -325422710: goto L29;
            case -262745675: goto L25;
            case 380372252: goto L21;
            case 648945192: goto L17;
            case 1868024701: goto L13;
            case 2117238938: goto L9;
            default: goto L7;
        };
    L7:
        byte r9 = -1;
    L56:
        switch(r9) {
            case 0: goto L74;
            case 1: goto L72;
            case 2: goto L71;
            case 3: goto L70;
            case 4: goto L68;
            case 5: goto L67;
            case 6: goto L66;
            case 7: goto L64;
            case 8: goto L63;
            case 9: goto L61;
            case 10: goto L60;
            case 11: goto L58;
            default: goto L57;
        };
    L57:
        return -1;
    L58:
        return 301;
    L60:
        return 8;
    L61:
        return 402;
    L63:
        return 5;
    L64:
        return 401;
    L66:
        return 4;
    L67:
        return 6;
    L68:
        return 101;
    L70:
        return 7;
    L71:
        return 3;
    L72:
        return 201;
    L74:
        return 202;
    L9:
        if (r8.equals("COLLECTION_WIFI_RECORD") == false) goto L76;
        r9 = 11;
        goto L56
    L76:
        r9 = -1;
        goto L56
    L13:
        if (r8.equals("HOME_RSSI_DROP_5S_GT_17DB") == false) goto L77;
        r9 = 10;
        goto L56
    L77:
        r9 = -1;
        goto L56
    L17:
        if (r8.equals("GEO_TRAINING") == false) goto L78;
        r9 = 9;
        goto L56
    L78:
        r9 = -1;
        goto L56
    L21:
        if (r8.equals("CONNECTED_ACTIVE") == false) goto L79;
        r9 = 8;
        goto L56
    L79:
        r9 = -1;
        goto L56
    L25:
        if (r8.equals("GEO_NORMAL") == false) goto L80;
        r9 = 7;
        goto L56
    L80:
        r9 = -1;
        goto L56
    L29:
        if (r8.equals("DISCONNECTED_ACTIVE") == false) goto L81;
        r9 = 6;
        goto L56
    L81:
        r9 = -1;
        goto L56
    L33:
        if (r8.equals("HOME_RSSI_CHANGE_2S_GT_9DB") == false) goto L82;
        r9 = 5;
        goto L56
    L82:
        r9 = -1;
        goto L56
    L37:
        if (r8.equals("HAR_LEVEL2_WIFI") == false) goto L83;
        r9 = 4;
        goto L56
    L83:
        r9 = -1;
        goto L56
    L41:
        if (r8.equals("COMPANY_RSSI_DROP_10S_GT_10DB") == false) goto L84;
        r9 = 3;
        goto L56
    L84:
        r9 = -1;
        goto L56
    L45:
        if (r8.equals("WIFI_FENCE_ACTIVE") == false) goto L85;
        r9 = 2;
        goto L56
    L85:
        r9 = -1;
        goto L56
    L49:
        if (r8.equals("ELEVATOR_OUT_ELEVATOR_WIFI") == false) goto L86;
        r9 = 1;
        goto L56
    L86:
        r9 = -1;
        goto L56
    L53:
        if (r8.equals("ELEVATOR_NEAR_ELEVATOR_WIFI") == false) goto L87;
        r9 = 0;
        goto L56
    L87:
        r9 = -1;
        goto L56
    }

    public static String sceneNameOf(int r1) {
        if (r1 != 101) goto L5;
        return "HAR_LEVEL2_WIFI";
    L5:
        if (r1 != 301) goto L7;
        return "COLLECTION_WIFI_RECORD";
    L7:
        if (r1 != 201) goto L9;
        return "ELEVATOR_OUT_ELEVATOR_WIFI";
    L9:
        if (r1 != 202) goto L11;
        return "ELEVATOR_NEAR_ELEVATOR_WIFI";
    L11:
        if (r1 != 401) goto L13;
        return "GEO_NORMAL";
    L13:
        if (r1 == 402) goto L29;
        switch(r1) {
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L23;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L17;
            default: goto L15;
        };
    L15:
        return null;
    L17:
        return "HOME_RSSI_DROP_5S_GT_17DB";
    L19:
        return "COMPANY_RSSI_DROP_10S_GT_10DB";
    L21:
        return "HOME_RSSI_CHANGE_2S_GT_9DB";
    L23:
        return "CONNECTED_ACTIVE";
    L25:
        return "DISCONNECTED_ACTIVE";
    L27:
        return "WIFI_FENCE_ACTIVE";
    L29:
        return "GEO_TRAINING";
    }
}
