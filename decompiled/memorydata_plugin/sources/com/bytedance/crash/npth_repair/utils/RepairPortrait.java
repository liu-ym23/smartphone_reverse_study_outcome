package com.bytedance.crash.npth_repair.utils;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class RepairPortrait {
    private String[] mApiLevels;
    private String[] mBrands;
    private JSONObject mCustomConfig;

    public RepairPortrait(JSONArray r8) {
        this.mApiLevels = r8.optString(0).split(",");     // Catch: Throwable -> L14
        this.mBrands = r8.optString(1).split(",");     // Catch: Throwable -> L14
        this.mCustomConfig = new JSONObject();     // Catch: Throwable -> L14
        int r3 = 2;
    L5:
        if (r3 >= r8.length()) goto L21;
        String r4 = r8.optString(r3);     // Catch: Throwable -> L14
        if ("".equals(r4) == true) goto L12;
        String[] r5 = r4.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);     // Catch: Throwable -> L14
        if (r5.length != 2) goto L12;
        this.mCustomConfig.putOpt(r5[0], r5[1]);     // Catch: Throwable -> L14
    L12:
        r3 = r3 + 1;
        goto L5
    L21:
        return;
    }

    private static boolean checkSupport(String[] r5, String r6) {
        if (r5 != null) goto L5;
    L19:
        return false;
    L5:
        if (r5.length == 0) goto L19;
        if ("none".equals(r5[0]) == false) goto L11;
        return false;
    L11:
        if (LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL.equals(r5[0]) == false) goto L13;
        return true;
    L13:
        int r1 = r5.length;
        int r3 = 0;
    L14:
        if (r3 >= r1) goto L19;
        if (r5[r3].equals(r6) == true) goto L17;
        r3 = r3 + 1;
        goto L14
    L17:
        return true;
    }

    public static RepairPortrait createRepairPortrait(JSONArray r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.length() >= 2) goto L7;
        return null;
    L7:
        return new RepairPortrait(r2);
    }

    public boolean checkApiLevel(int r1) {
        return checkSupport(this.mApiLevels, String.valueOf(r1));
    }

    public boolean checkBrand(String r1) {
        return checkSupport(this.mBrands, r1);
    }

    public boolean checkCustomConfig(String r1, String r2) {
        return getCustomConfig(r1).equals(r2);
    }

    public String getCustomConfig(String r3) {
        if (this.mCustomConfig == null) goto L10;
        if (r3 == null) goto L10;
        if ("".equals(r3) == true) goto L10;
        return this.mCustomConfig.optString(r3);
    L10:
        return "";
    }

    public JSONArray getCustomConfigArray(String r3) {
        if (this.mCustomConfig == null) goto L14;
        if (r3 != null) goto L6;
        return null;
    L6:
        if ("".equals(r3) == true) goto L16;
        return new JSONArray(this.mCustomConfig.optString(r3));
    L17:
        return null;
    L16:
        return null;
    L14:
        return null;
    }
}
