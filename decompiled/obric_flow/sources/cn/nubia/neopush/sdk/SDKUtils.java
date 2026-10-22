package cn.nubia.neopush.sdk;

import ai.j0;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.a;
import cn.nubia.neopush.commons.AppUtil;
import cn.nubia.neopush.commons.Constant;
import cn.nubia.neopush.commons.NeoLog;
import cn.nubia.neopush.protocol.utils.CommonUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class SDKUtils {
    public SDKUtils() {
    }

    public static void checkNull(Object r5, String r10) {
        if (r5 == null) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(j0.k("param ", r10, " is not nullable"));
    }

    public static boolean checkRegId(Context r5, String r10, String r11) {
        boolean r12 = TextUtils.isEmpty(r11);
        if (r12 == false) goto L5;
        onPushUnRegistered(r5, r10);
    L5:
        return r12;
    }

    public static void checkTopicList(List<String> r5) {
        int r10 = 0;
    L4:
        if (r10 >= r5.size()) goto L5;
        if (TextUtils.isEmpty(r5.get(r10)) == true) goto L10;
        r10 = r10 + 1;
        goto L4
    L10:
        throw new IllegalArgumentException("topic item is not nullable");
    }

    public static String generateRegId(Context r5, String r10, String r11) {
    L15:
        return CommonUtils.getHmacSHA1(a.p("deviceid=", getSDKDeviceId(r5), "&appid=", r10), r11);
    L5:
        e = move-exception;
        e.printStackTrace();
    L11:
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static String generateTopicListToJSON(List<String> r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.size() == 0) goto L23;
        JSONArray r10 = new JSONArray();
        int r11 = 0;
    L8:
        if (r11 >= r5.size()) goto L10;
        r10.put(r11, r5.get(r11));     // Catch: JSONException -> L13
    L15:
        r11 = r11 + 1;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L10:
        return r10.toString();
    L23:
        return null;
    }

    private static int getMessageType(String r5) {
        NeoLog.i("CommandMessageHandler getMessageType = " + r5);
        if (Constant.ClientMessageType.GET_TOPICS.equals(r5) == false) goto L7;
        return 13;
    L7:
        if ("unset_topic".equals(r5) == false) goto L11;
        return 17;
    L11:
        if ("set_alias".equals(r5) == false) goto L15;
        return 19;
    L15:
        if ("unregister_app".equals(r5) == false) goto L19;
        return 23;
    L19:
        if ("set_topic".equals(r5) == false) goto L22;
        return 15;
    L22:
        return -1;
    }

    public static String getSDKDeviceId(Context r5) {
        AppUtil.addWhiteList();
        if (AppUtil.isHasSDKDeviceID(r5) == false) goto L6;
        String r10 = AppUtil.getHasSavedSDKDeviceID(r5);
        NeoLog.i("luzhi", "sdk has device id " + r10);
        AppUtil.resumeWhiteList();
        return r10;
    L6:
        String r11 = AppUtil.getDeviceId(r5);
        AppUtil.saveDeviceID_InSDK(r5, r11);
        AppUtil.resumeWhiteList();
        return r11;
    }

    public static void onPushUnRegistered(Context r5, String r10) {
        NeoLog.i("CommandMessageHandler onPushUnRegistered packageName=" + r5.getPackageName());     // Catch: Exception -> L4
        Intent r11 = new Intent(Constant.RECEIVE_MESSAGE_ACTION);     // Catch: Exception -> L4
        r11.setComponent(new ComponentName(r5.getPackageName(), "cn.nubia.neopush.sdk.PushMessageHandler"));     // Catch: Exception -> L4
        Bundle r12 = new Bundle();     // Catch: Exception -> L4
        r12.putInt(Constant.MESSAGE_TYPE, getMessageType(r10));     // Catch: Exception -> L4
        r12.putString(Constant.PACKAGE_NAME, r5.getPackageName());     // Catch: Exception -> L4
        r12.putString("reason", "you must register before send command");     // Catch: Exception -> L4
        r12.putInt("result_code", -1000);     // Catch: Exception -> L4
        r11.putExtras(r12);     // Catch: Exception -> L4
        r5.startService(r11);     // Catch: Exception -> L4
        return;
    }

    public static List<String> parseTopicJSONToList(String r5) {
        ArrayList r10 = null;
        JSONArray r11 = new JSONArray(r5);     // Catch: Exception -> L13
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L13
        int r13 = 0;
    L16:
    L10:
        r10 = r12;
        goto L12
    L6:
        if (r13 >= r11.length()) goto L19;
        r12.add(r11.getString(r13));     // Catch: Exception -> L10
        r13 = r13 + 1;
        goto L16
    L19:
        return r12;
    L12:
        return r10;
    }
}
