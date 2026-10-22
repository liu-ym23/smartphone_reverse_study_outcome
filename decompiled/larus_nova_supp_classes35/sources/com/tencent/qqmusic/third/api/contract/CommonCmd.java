package com.tencent.qqmusic.third.api.contract;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class CommonCmd {
    public static final String AIDL_PLATFORM_TYPE_CAR = "car";
    public static final String AIDL_PLATFORM_TYPE_PAD = "pad";
    public static final String AIDL_PLATFORM_TYPE_PHONE = "phone";
    public static final String AIDL_PLATFORM_TYPE_TV = "tv";
    public static final String AIDL_PLATFORM_TYPE_TV_FOR_THIRD = "tvForThird";
    public static final int SDK_VERSION = 10000;
    public static String platform = "phone";

    public final class RPCAction {
        public static final int RPC_ACTION_ONLY_START_PROCESS = 0;
        public static final int RPC_ACTION_START_AND_VERIFY = 1;
        final /* synthetic */ CommonCmd this$0;

        public RPCAction(CommonCmd r1) {
            this.this$0 = r1;
        }
    }

    public final class RPCRequest {
        public static final String RPC_REQUEST_LOGIN = "login";
        public static final String RPC_REQUEST_PARAMS_NEED_VERIFY_AFTER_LOGIN = "needVerifyAfterLogin";
        public static final String RPC_REQUEST_START_QQMUSIC_PROCESS = "start";
        public static final String RPC_REQUEST_VERIFY_CALLER_IDENTITY = "start";
        final /* synthetic */ CommonCmd this$0;

        public RPCRequest(CommonCmd r1) {
            this.this$0 = r1;
        }
    }

    public CommonCmd() {
    }

    private static String getPlatformPackageName() {
        String r0 = platform;
        r0.getClass();
        byte r2 = -1;
        switch(r0.hashCode()) {
            case 3714: goto L22;
            case 98260: goto L18;
            case 110739: goto L14;
            case 106642798: goto L10;
            case 663842496: goto L6;
            default: goto L25;
        };
    L25:
        switch(r2) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            default: goto L26;
        };
    L26:
        return BuildConfig.FLAVOR;
    L27:
        return "com.tencent.musictvForthird";
    L28:
        return "com.tencent.qqmusic";
    L29:
        return "com.tencent.qqmusicpad";
    L30:
        return "com.tencent.qqmusiccar";
    L31:
        return "com.tencent.qqmusictv";
    L6:
        if (r0.equals(AIDL_PLATFORM_TYPE_TV_FOR_THIRD) == false) goto L25;
        r2 = 4;
        goto L25
    L10:
        if (r0.equals(AIDL_PLATFORM_TYPE_PHONE) == false) goto L25;
        r2 = 3;
        goto L25
    L14:
        if (r0.equals(AIDL_PLATFORM_TYPE_PAD) == false) goto L25;
        r2 = 2;
        goto L25
    L18:
        if (r0.equals(AIDL_PLATFORM_TYPE_CAR) == false) goto L25;
        r2 = 1;
        goto L25
    L22:
        if (r0.equals(AIDL_PLATFORM_TYPE_TV) == false) goto L25;
        r2 = 0;
        goto L25
    }

    private static String getPlatformScheme() {
        String r0 = platform;
        r0.getClass();
        byte r2 = -1;
        switch(r0.hashCode()) {
            case 3714: goto L22;
            case 98260: goto L18;
            case 110739: goto L14;
            case 106642798: goto L10;
            case 663842496: goto L6;
            default: goto L25;
        };
    L25:
        switch(r2) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            default: goto L26;
        };
    L26:
        return BuildConfig.FLAVOR;
    L27:
        return "musictvForthird";
    L28:
        return "qqmusic";
    L29:
        return "qqmusicpad";
    L30:
        return "qqmusiccar";
    L31:
        return "musictv";
    L6:
        if (r0.equals(AIDL_PLATFORM_TYPE_TV_FOR_THIRD) == false) goto L25;
        r2 = 4;
        goto L25
    L10:
        if (r0.equals(AIDL_PLATFORM_TYPE_PHONE) == false) goto L25;
        r2 = 3;
        goto L25
    L14:
        if (r0.equals(AIDL_PLATFORM_TYPE_PAD) == false) goto L25;
        r2 = 2;
        goto L25
    L18:
        if (r0.equals(AIDL_PLATFORM_TYPE_CAR) == false) goto L25;
        r2 = 1;
        goto L25
    L22:
        if (r0.equals(AIDL_PLATFORM_TYPE_TV) == false) goto L25;
        r2 = 0;
        goto L25
    }

    public static void init(String r0) {
        platform = r0;
    }

    public static Bundle action(Context r3, Bundle r4) {
        Bundle r0 = new Bundle();
        if (r3 == null) goto L7;
        if (r4 == null) goto L7;
        sendSchema(r3, r4);     // Catch: Exception -> L9
        r0.putInt("code", 0);     // Catch: Exception -> L9
    L11:
        return r0;
    L7:
        r0.putInt("code", 4);     // Catch: Exception -> L9
        r0.putString(Keys.API_RETURN_KEY_ERROR, "context is null");     // Catch: Exception -> L9
        return r0;
    L9:
        e = move-exception;
        r0.putInt("code", 1);
        r0.putString(Keys.API_RETURN_KEY_ERROR, "UnKnow Exception " + e.getMessage());
        goto L11
    }

    public static boolean bindQQMusicApiService(Context r1, ServiceConnection r2) {
        return bindQQMusicApiService(r1, BuildConfig.FLAVOR, r2);
    }

    public static final Bundle openQQMusic(Context r5, String r6) {
        Bundle r1 = new Bundle();
        if (r5 == null) goto L5;
        sendSchema(r5, URLEncoder.encode("{\"cmd\":\"open\",\"callbackurl\": \"" + r6 + "\"}", "utf-8"));     // Catch: Exception -> L9
        r1.putInt("code", 0);     // Catch: Exception -> L9
    L11:
        return r1;
    L5:
        r1.putInt("code", 4);     // Catch: Exception -> L9
        r1.putString(Keys.API_RETURN_KEY_ERROR, "context is null");     // Catch: Exception -> L9
        return r1;
    L9:
        e = move-exception;
        r1.putInt("code", 1);
        r1.putString(Keys.API_RETURN_KEY_ERROR, "UnKnow Exception " + e.getMessage());
        goto L11
    }

    private static final void sendActiveSchema(Context r5, String r6) {
        String r1 = String.format("qqmusicactive://qq.com/aidl?p=%s", new Object[]{r6});
        if (platform.equals(AIDL_PLATFORM_TYPE_TV_FOR_THIRD) == false) goto L5;
        r1 = String.format("qqmusicactiveForthird://qq.com/aidl?p=%s", new Object[]{r6});
    L5:
        Intent r7 = new Intent();
        r7.addFlags(268435456);
        r7.setAction("android.intent.action.VIEW");
        r7.setData(UriProtector.parse(r1));
        String r0 = getPlatformPackageName();
        if (TextUtils.isEmpty(r0) == true) goto L8;
        r7.setPackage(r0);
    L8:
        r5.startActivity(r7);
    }

    private static void sendSchema(Context r5, Bundle r6) throws UnsupportedEncodingException {
        String r0 = getPlatformScheme();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        String r1 = String.format("%s://?", new Object[]{r0});
        StringBuilder r2 = new StringBuilder();
        r2.append(r1);
        if (r6.containsKey(Keys.API_PARAM_KEY_ACTION) == false) goto L9;
        r2.append("action=" + r6.getInt(Keys.API_PARAM_KEY_ACTION));
    L9:
        if (r6.containsKey(Keys.API_PARAM_KEY_PULL_FROM) == false) goto L12;
        r2.append("&pull_from=" + r6.getLong(Keys.API_PARAM_KEY_PULL_FROM));
    L12:
        if (r6.containsKey(Keys.API_PARAM_KEY_SEARCH_KEY) == false) goto L15;
        r2.append("&search_key=" + URLEncoder.encode(r6.getString(Keys.API_PARAM_KEY_SEARCH_KEY), "utf-8"));
    L15:
        if (r6.containsKey(Keys.API_PARAM_KEY_M0) == false) goto L18;
        r2.append("&m0=" + r6.getLong(Keys.API_PARAM_KEY_M0));
    L18:
        if (r6.containsKey(Keys.API_PARAM_KEY_M1) == false) goto L21;
        r2.append("&m1=" + r6.getBoolean(Keys.API_PARAM_KEY_M1));
    L21:
        if (r6.containsKey(Keys.API_PARAM_KEY_MB) == false) goto L24;
        r2.append("&mb=" + r6.getBoolean(Keys.API_PARAM_KEY_MB));
    L24:
        if (r6.containsKey(Keys.API_PARAM_KEY_M2) == false) goto L26;
        r2.append("&m2=" + r6.getBoolean(Keys.API_PARAM_KEY_M2));
    L26:
        Intent r7 = new Intent();
        r7.addFlags(268435456);
        r7.setAction("android.intent.action.VIEW");
        r7.setData(UriProtector.parse(r2.toString()));
        String r3 = getPlatformPackageName();
        if (TextUtils.isEmpty(r3) == true) goto L29;
        r7.setPackage(r3);
    L29:
        r5.startActivity(r7);
    }

    private static void sendSchema(Context r3, String r4) {
        String r0 = getPlatformScheme();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        String r5 = String.format("%s://qq.com/other/aidl?p=%s", new Object[]{r0, r4});
        Intent r1 = new Intent();
        r1.addFlags(268435456);
        r1.setAction("android.intent.action.VIEW");
        String r2 = getPlatformPackageName();
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r1.setPackage(r2);
    L8:
        r1.setData(UriProtector.parse(r5));
        r3.startActivity(r1);
    }

    public static boolean bindQQMusicApiService(Context r5, String r6, ServiceConnection r7) {
        String r0 = platform;
        r0.getClass();
        byte r4 = -1;
        switch(r0.hashCode()) {
            case 3714: goto L18;
            case 98260: goto L14;
            case 106642798: goto L10;
            case 663842496: goto L6;
            default: goto L21;
        };
    L21:
        switch(r4) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            default: goto L22;
        };
    L22:
        return false;
    L23:
        Intent r1 = new Intent("com.tencent.qqmusicthird.third.api.QQMusicApiService");
    L27:
        String r2 = getPlatformPackageName();
        if (TextUtils.isEmpty(r2) == true) goto L31;
        r1.setPackage(r2);
    L31:
        if (TextUtils.isEmpty(r6) == true) goto L34;
        r1.putExtra(Keys.CMD_BIND_PACKAGE_NAME, r6);
    L34:
        return r5.bindService(r1, r7, 1);
    L24:
        r1 = new Intent("com.tencent.qqmusic.third.api.QQMusicApiService");
        goto L27
    L25:
        r1 = new Intent("com.tencent.qqmusiccar.third.api.QQMusicApiService");
        goto L27
    L26:
        r1 = new Intent("com.tencent.qqmusictv.third.api.QQMusicApiService");
        goto L27
    L6:
        if (r0.equals(AIDL_PLATFORM_TYPE_TV_FOR_THIRD) == false) goto L21;
        r4 = 3;
        goto L21
    L10:
        if (r0.equals(AIDL_PLATFORM_TYPE_PHONE) == false) goto L21;
        r4 = 2;
        goto L21
    L14:
        if (r0.equals(AIDL_PLATFORM_TYPE_CAR) == false) goto L21;
        r4 = 1;
        goto L21
    L18:
        if (r0.equals(AIDL_PLATFORM_TYPE_TV) == false) goto L21;
        r4 = 0;
        goto L21
    }

    public static int startQQMusicProcess(Context r4, String r5, String r6) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L4:
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return -1;
    L6:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L8
        r1.put("cmd", "start");     // Catch: Exception -> L8
        r1.put(Keys.API_PARAM_KEY_ACTION, 0);     // Catch: Exception -> L8
        r1.put(Keys.API_RETURN_KEY_APP_ID, r6);     // Catch: Exception -> L8
        r1.put(Keys.CMD_BIND_PACKAGE_NAME, r5);     // Catch: Exception -> L8
        sendActiveSchema(r4, URLEncoder.encode(r1.toString(), "utf-8"));     // Catch: Exception -> L8
        return 0;
    }

    public static Bundle loginQQMusic(Context r6, String r7, String r8, String r9) {
        return loginQQMusic(r6, r7, r8, BuildConfig.FLAVOR, false, r9);
    }

    public static final int startProcessAndAuthForPrivacy(Context r4, String r5, String r6, String r7, String r8) {
    L13:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L4:
        if (TextUtils.isEmpty(r5) == false) goto L6;
    L12:
        return -1;
    L6:
        if (TextUtils.isEmpty(r6) == true) goto L12;
        if (TextUtils.isEmpty(r7) == true) goto L12;
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L13
        r1.put("cmd", "start");     // Catch: Exception -> L13
        r1.put(Keys.API_PARAM_KEY_ACTION, 0);     // Catch: Exception -> L13
        r1.put(Keys.API_RETURN_KEY_APP_ID, r5);     // Catch: Exception -> L13
        r1.put(Keys.CMD_BIND_PACKAGE_NAME, r6);     // Catch: Exception -> L13
        r1.put("callbackurl", r8);     // Catch: Exception -> L13
        r1.put(Keys.API_RETURN_KEY_ENCRYPT_STRING, r7);     // Catch: Exception -> L13
        sendActiveSchema(r4, URLEncoder.encode(r1.toString(), "utf-8"));     // Catch: Exception -> L13
        return 0;
    }

    public static final int verifyCallerIdentity(Context r4, String r5, String r6, String r7, String r8) {
    L13:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L4:
        if (TextUtils.isEmpty(r5) == false) goto L6;
    L12:
        return -1;
    L6:
        if (TextUtils.isEmpty(r6) == true) goto L12;
        if (TextUtils.isEmpty(r7) == true) goto L12;
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L13
        r1.put("cmd", "start");     // Catch: Exception -> L13
        r1.put(Keys.API_PARAM_KEY_ACTION, 1);     // Catch: Exception -> L13
        r1.put(Keys.API_RETURN_KEY_APP_ID, r5);     // Catch: Exception -> L13
        r1.put(Keys.CMD_BIND_PACKAGE_NAME, r6);     // Catch: Exception -> L13
        r1.put("callbackurl", r8);     // Catch: Exception -> L13
        r1.put(Keys.API_RETURN_KEY_ENCRYPT_STRING, r7);     // Catch: Exception -> L13
        sendSchema(r4, URLEncoder.encode(r1.toString(), "utf-8"));     // Catch: Exception -> L13
        return 0;
    }

    public static Bundle loginQQMusic(Context r6, String r7, String r8, String r9, boolean r10, String r11) {
        Bundle r0 = new Bundle();
        if (r6 == null) goto L5;
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L9
        r3.put("cmd", RPCRequest.RPC_REQUEST_LOGIN);     // Catch: Exception -> L9
        r3.put(Keys.CMD_BIND_PACKAGE_NAME, r7);     // Catch: Exception -> L9
        r3.put(Keys.API_RETURN_KEY_APP_ID, r8);     // Catch: Exception -> L9
        r3.put(Keys.API_RETURN_KEY_ENCRYPT_STRING, r9);     // Catch: Exception -> L9
        r3.put(RPCRequest.RPC_REQUEST_PARAMS_NEED_VERIFY_AFTER_LOGIN, r10);     // Catch: Exception -> L9
        r3.put("callbackurl", r11);     // Catch: Exception -> L9
        sendSchema(r6, URLEncoder.encode(r3.toString(), "utf-8"));     // Catch: Exception -> L9
        r0.putInt("code", 0);     // Catch: Exception -> L9
    L11:
        return r0;
    L5:
        r0.putInt("code", 4);     // Catch: Exception -> L9
        r0.putString(Keys.API_RETURN_KEY_ERROR, "context is null");     // Catch: Exception -> L9
        return r0;
    L9:
        e = move-exception;
        r0.putInt("code", 1);
        r0.putString(Keys.API_RETURN_KEY_ERROR, "UnKnow Exception " + e.getMessage());
        goto L11
    }
}
