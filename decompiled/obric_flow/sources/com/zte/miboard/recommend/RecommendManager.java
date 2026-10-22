package com.zte.miboard.recommend;

import android.content.Context;
import android.util.Log;
import com.zte.miboard.recommend.nubiapush.NubiaPushHelper;
import m.h;

/* JADX INFO: loaded from: classes3.dex */
public class RecommendManager {
    public static final int RCMD_TYPE_CLIP_AI_CMD_TRIP = 16;
    private static final String TAG = "Mi_R_RecommendManager";
    private static int gRecommendStatus = -1;

    public RecommendManager() {
    }

    public static void destroy() {
        Log.e(TAG, "destroy.");
        gRecommendStatus = 0;
        new NubiaPushHelper().unregisterPush(h.a());
    }

    public static void init(Context r5) {
        Log.e(TAG, "init. c=" + r5);
        gRecommendStatus = 1;
        if (r5 == null) goto L5;
        h.f19879a = r5.getApplicationContext();
    L5:
        new NubiaPushHelper().registerPush(h.a());
    }

    public static boolean isRecommendEnable() {
        boolean r5 = true;
        if (gRecommendStatus == 1) goto L6;
        r5 = false;
    L6:
        if (r5 == true) goto L8;
        Log.e(TAG, "isRecommendEnable false! gRecommendStatus=" + gRecommendStatus);
    L8:
        return r5;
    }
}
