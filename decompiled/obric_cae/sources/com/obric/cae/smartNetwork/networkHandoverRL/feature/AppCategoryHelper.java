package com.obric.cae.smartNetwork.networkHandoverRL.feature;

import android.content.Context;
import android.content.res.Resources;
import com.obric.cae.log.CaeLog;
import defpackage.b;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AppCategoryHelper {
    private static final String JSON_FILE_NAME = "app_categories";
    private static final String TAG = "AppCategoryHelper";
    private static AppCategoryHelper sInstance;
    private final Context mContext;
    private final Map<String, Integer> mPackageCategoryMap;

    private AppCategoryHelper(Context r8) {
        this.mContext = r8.getApplicationContext();
        this.mPackageCategoryMap = new HashMap();
        initialize();
    }

    private void addPackageListToMap(JSONArray r8, int r10) {
        int r11 = 0;
    L4:
        if (r11 >= r8.length()) goto L11;
        String r12 = r8.getString(r11);
        if (r12 == null) goto L10;
        if (r12.isEmpty() == true) goto L10;
        this.mPackageCategoryMap.put(r12, Integer.valueOf(r10));
    L10:
        r11 = r11 + 1;
        goto L4
    }

    public static synchronized AppCategoryHelper getInstance(Context r8) {
        monitor-enter(AppCategoryHelper.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new AppCategoryHelper(r8.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        AppCategoryHelper r10 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(AppCategoryHelper.class);
        return r10;
    }

    private void initialize() {
        Resources r8 = this.mContext.getResources();     // Catch: Exception -> L28
        int r10 = r8.getIdentifier(JSON_FILE_NAME, "raw", this.mContext.getPackageName());     // Catch: Exception -> L28
        if (r10 != 0) goto L32;
        CaeLog.e(TAG, "Cannot find app_categories in raw resources");     // Catch: Exception -> L28
        return;
    L32:
        BufferedReader r11 = new BufferedReader(new InputStreamReader(r8.openRawResource(r10)));     // Catch: Throwable -> L25 Exception -> L28
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L25 Exception -> L28
    L8:
        String r13 = r11.readLine();     // Catch: Throwable -> L25 Exception -> L28
        if (r13 == null) goto L11;
        r12.append(r13);     // Catch: Throwable -> L25 Exception -> L28
        goto L8
    L11:
        JSONObject r14 = new JSONObject(r12.toString());     // Catch: Throwable -> L25 Exception -> L28
        if (r14.has("video") == false) goto L15;
        addPackageListToMap(r14.getJSONArray("video"), 1);     // Catch: Throwable -> L25 Exception -> L28
    L15:
        if (r14.has("social") == false) goto L18;
        addPackageListToMap(r14.getJSONArray("social"), 2);     // Catch: Throwable -> L25 Exception -> L28
    L18:
        if (r14.has("news") == false) goto L21;
        addPackageListToMap(r14.getJSONArray("news"), 3);     // Catch: Throwable -> L25 Exception -> L28
    L21:
        if (r14.has("game") == false) goto L23;
        addPackageListToMap(r14.getJSONArray("game"), 4);     // Catch: Throwable -> L25 Exception -> L28
    L23:
        CaeLog.d(TAG, "Successfully parsed app categories, total packages: " + this.mPackageCategoryMap.size());     // Catch: Throwable -> L25 Exception -> L28
    L35:
        return;
    L25:
        e = move-exception;
        CaeLog.e(TAG, "Error parsing JSON file: " + e.getMessage());     // Catch: Exception -> L28
        return;
    L28:
        e = move-exception;
        b.k(e, new StringBuilder("Failed to initialize app category helper: "), TAG);
    }

    public int getAppCategory(String r8) {
        if (r8 != null) goto L5;
        return 0;
    L5:
        if (r8.isEmpty() == true) goto L13;
        Integer r10 = this.mPackageCategoryMap.get(r8);
        if (r10 != null) goto L10;
        return 0;
    L10:
        return r10.intValue();
    L13:
        return 0;
    }

    public String getCategoryName(int r8) {
        if (r8 != 1) goto L5;
        return "video";
    L5:
        if (r8 != 2) goto L7;
        return "social";
    L7:
        if (r8 != 3) goto L9;
        return "news";
    L9:
        if (r8 == 4) goto L12;
        return "other";
    L12:
        return "game";
    }
}
