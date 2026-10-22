package com.bytedance.crash.npth_repair.utils;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RepairPortrait {
    private String[] mApiLevels;
    private String[] mBrands;
    private JSONObject mCustomConfig;

    public RepairPortrait(JSONArray r10) {
        this.mApiLevels = r10.optString(0).split(",");     // Catch: Throwable -> L14
        this.mBrands = r10.optString(1).split(",");     // Catch: Throwable -> L14
        this.mCustomConfig = new JSONObject();     // Catch: Throwable -> L14
        int r11 = 2;
    L5:
        if (r11 >= r10.length()) goto L21;
        String r12 = r10.optString(r11);     // Catch: Throwable -> L14
        if ("".equals(r12) == true) goto L12;
        String[] r13 = r12.split(":");     // Catch: Throwable -> L14
        if (r13.length != 2) goto L12;
        this.mCustomConfig.putOpt(r13[0], r13[1]);     // Catch: Throwable -> L14
    L12:
        r11 = r11 + 1;
        goto L5
    L21:
        return;
    }

    private static boolean checkSupport(String[] r10, String r11) {
        if (r10 != null) goto L5;
    L19:
        return false;
    L5:
        if (r10.length == 0) goto L19;
        if ("none".equals(r10[0]) == false) goto L11;
        return false;
    L11:
        if ("all".equals(r10[0]) == false) goto L13;
        return true;
    L13:
        int r12 = r10.length;
        int r13 = 0;
    L14:
        if (r13 >= r12) goto L19;
        if (r10[r13].equals(r11) == true) goto L17;
        r13 = r13 + 1;
        goto L14
    L17:
        return true;
    }

    public static RepairPortrait createRepairPortrait(JSONArray r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.length() >= 2) goto L7;
        return null;
    L7:
        return new RepairPortrait(r10);
    }

    public boolean checkApiLevel(int r10) {
        return checkSupport(this.mApiLevels, String.valueOf(r10));
    }

    public boolean checkBrand(String r10) {
        return checkSupport(this.mBrands, r10);
    }

    public boolean checkCustomConfig(String r10, String r11) {
        return getCustomConfig(r10).equals(r11);
    }

    public String getCustomConfig(String r10) {
        if (this.mCustomConfig == null) goto L10;
        if (r10 == null) goto L10;
        if ("".equals(r10) == true) goto L10;
        return this.mCustomConfig.optString(r10);
    L10:
        return "";
    }

    public JSONArray getCustomConfigArray(String r10) {
        if (this.mCustomConfig == null) goto L14;
        if (r10 != null) goto L6;
        return null;
    L6:
        if ("".equals(r10) == true) goto L16;
        return new JSONArray(this.mCustomConfig.optString(r10));
    L17:
        return null;
    L16:
        return null;
    L14:
        return null;
    }
}
