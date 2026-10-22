package com.bytedance.crypto.network;

import com.bytedance.crypto.utils.LogUtils;
import okhttp3.w;
import okhttp3.x;
import okhttp3.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ChallengeManager {
    private static final String GET_CHALLENGE_URL = "https://ocean-secret.oceancloudapi.com/api/auth/challenge";
    private static final String GET_CHALLENGE_URL_BOE = "https://ocean-secret-boe.bytedance.net/api/auth/challenge";
    private static final String JSON_TAG_CODE = "code";
    private static final String JSON_TAG_DATA = "data";
    private static final String JSON_TAG_NONCE = "nonce";
    private static final String TAG = "ChallengeManager";

    public ChallengeManager() {
    }

    private static String getChallenge(String r10) {
        return new JSONObject(new JSONObject(r10).getString("data")).getString(JSON_TAG_NONCE);
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getChallenge exception:" + e.getMessage());
        return "";
    }

    private static String getChallengeFromServer() {
        w r10 = new w();
        x r11 = new x.a().k(getRequestUrl()).c().b();
        String r12 = TAG;
        LogUtils.i(r12, "Request:" + r11.toString());
        LogUtils.d(r12, "Request body:" + r11.a());
        z r13 = r10.A(r11).execute();     // Catch: Exception -> L8
        if (r13.B() == false) goto L6;
        String r14 = r13.a().l();     // Catch: Exception -> L8
        LogUtils.i(r12, "response:" + r13.toString());     // Catch: Exception -> L8
        LogUtils.d(r12, "response body:" + r14);     // Catch: Exception -> L8
        return parseChallenge(r14);
    L6:
        LogUtils.i(r12, "newCall failed!! response:" + r13.toString());     // Catch: Exception -> L8
        LogUtils.i(r12, "newCall failed!! response body:" + r13.a().l());     // Catch: Exception -> L8
    L10:
        return "";
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    private static String getRequestUrl() {
        if (NetworkConfig.getInstance().isBoeEnv() == false) goto L6;
        return GET_CHALLENGE_URL_BOE;
    L6:
        return GET_CHALLENGE_URL;
    }

    private static int getResponseCode(String r10) {
        return new JSONObject(r10).getInt(JSON_TAG_CODE);
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getResponseCode exception:" + e.getMessage());
        return 400;
    }

    private static String parseChallenge(String r10) {
        int r11 = getResponseCode(r10);
        if (r11 >= 200) goto L5;
    L10:
        return "";
    L5:
        if (r11 >= 300) goto L10;
        return getChallenge(r10);
    L8:
        e = move-exception;
        LogUtils.e(TAG, "parseChallenge exception:" + e.getMessage());
        goto L10
    }

    public static String requestChallenge() {
        return getChallengeFromServer();
    }
}
