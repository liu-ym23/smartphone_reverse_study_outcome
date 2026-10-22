package cn.nubia.neopush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.nubia.neopush.commons.AppUtil;
import cn.nubia.neopush.commons.BuildConfig;
import cn.nubia.neopush.commons.Constant;
import cn.nubia.neopush.commons.NeoLog;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SDKPrefEditor {
    public SDKPrefEditor() {
    }

    public static long aliasSetTime(Context r5) {
        LocalRecoder r10 = getLocalRecoder(r5);
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getAliasSetTime();
    }

    public static long appRegisterTime(Context r5) {
        LocalRecoder r10 = getLocalRecoder(r5);
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getRegisterTime();
    }

    public static void clearTicket(Context r5) {
        SharedPreferences.Editor r10 = r5.getSharedPreferences(Constant.SAVE_TICKET_INFO, 4).edit();
        r10.putString(Constant.TICKET_CONTENT, "");
        r10.putLong(Constant.TICKET_TIME, 0);
        r10.apply();
    }

    public static String getAppId(Context r5) {
        LocalRecoder r10 = getLocalRecoder(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getAppId();
    }

    public static String getAppKey(Context r5) {
        LocalRecoder r10 = getLocalRecoder(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getAppKey();
    }

    public static String getLastAlias(Context r5) {
        LocalRecoder r10 = getLocalRecoder(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.getAliasSetTime() > 0) goto L7;
        return null;
    L7:
        return r10.getAlias();
    }

    public static long getLastRegRequestTime(Context r5, String r10) {
        LocalRecoder r11 = getLocalRecoder(r5);
        if (r11 != null) goto L7;
        return -1;
    L7:
        return r11.getRegisterTime();
    }

    public static List<String> getLastTopic(Context r5) {
        LocalRecoder r10 = getLocalRecoder(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.getTopicSetTime() > 0) goto L7;
        return null;
    L7:
        return r10.getTopics();
    }

    public static LocalRecoder getLocalRecoder(Context r5) {
        AppUtil.addWhiteList();
        String r10 = r5.getSharedPreferences(Constant.SP_FILE_NAME, 0).getString(r5.getPackageName(), "");
        AppUtil.resumeWhiteList();
        if (TextUtils.isEmpty(r10) == false) goto L6;
        NeoLog.i("getLocalRecoder = null");
        return null;
    L6:
        LocalRecoder r11 = LocalRecoder.parserFromSp(r10);
        if (r11 == null) goto L9;
        NeoLog.i("getLocalRecoder =" + r11.toString());
    L9:
        return r11;
    }

    public static String getRegId(Context r5) {
        LocalRecoder r10 = getLocalRecoder(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getRegId();
    }

    public static String getTicket(Context r5) {
        AppUtil.addWhiteList();
        String r10 = r5.getSharedPreferences(Constant.SAVE_TICKET_INFO, 4).getString(Constant.TICKET_CONTENT, "");
        AppUtil.resumeWhiteList();
        return r10;
    }

    public static long getTicketTime(Context r5) {
        return r5.getSharedPreferences(Constant.SAVE_TICKET_INFO, 4).getLong(Constant.TICKET_TIME, 0);
    }

    public static void getTopics(Context r5) {
        LocalRecoder r10 = getLocalRecoder(r5);
        if (r10 == null) goto L6;
        r10.setLastTopicGetTime(-1);
        saveLocalRecoderInfo(r5, r10);
        return;
    }

    public static String isDebugTicket(Context r5) {
        AppUtil.addWhiteList();
        String r10 = r5.getSharedPreferences(Constant.SAVE_TICKET_INFO, 4).getString(Constant.IFDEBUG, "");
        AppUtil.resumeWhiteList();
        return r10;
    }

    public static void registerApp(Context r5, String r10, String r11, String r12) {
        LocalRecoder r13 = getLocalRecoder(r5);
        if (r13 != null) goto L5;
        r13 = new LocalRecoder();
    L5:
        r13.setAppId(r10);
        r13.setPackageName(r5.getPackageName());
        r13.setRegId(r11);
        r13.setAppKey(r12);
        r13.setRegisterTime(System.currentTimeMillis());
        saveLocalRecoderInfo(r5, r13);
    }

    private static synchronized void saveLocalRecoderInfo(Context r5, LocalRecoder r10) {
        monitor-enter(SDKPrefEditor.class);
        SharedPreferences.Editor r11 = r5.getSharedPreferences(Constant.SP_FILE_NAME, 0).edit();     // Catch: Throwable -> L7
        String r12 = r5.getPackageName();     // Catch: Throwable -> L7
        if (r10 != null) goto L9;
        r11.putString(r12, "");     // Catch: Throwable -> L7
        NeoLog.i("saveLocalRecoderInfo null");     // Catch: Throwable -> L7
    L10:
        r11.apply();     // Catch: Throwable -> L7
        monitor-exit(SDKPrefEditor.class);
        return;
    L9:
        String r13 = r10.buildToSp();     // Catch: Throwable -> L7
        NeoLog.i("saveLocalRecoderInfo =" + r13);     // Catch: Throwable -> L7
        r11.putString(r12, r13);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public static void saveTicket(Context r5, String r10) {
        SharedPreferences.Editor r11 = r5.getSharedPreferences(Constant.SAVE_TICKET_INFO, 4).edit();
        r11.putString(Constant.TICKET_CONTENT, r10);
        if (BuildConfig.isDebug() == false) goto L5;
        r11.putString(Constant.IFDEBUG, "yes");
        NeoLog.i("luzhi", "save ticket debug yes");
    L6:
        r11.commit();
        return;
    L5:
        r11.putString(Constant.IFDEBUG, "no");
        NeoLog.i("luzhi", "save ticket debug no");
        goto L6
    }

    public static boolean saveTicketIsDebug(Context r5) {
        AppUtil.addWhiteList();
        SharedPreferences.Editor r10 = r5.getSharedPreferences(Constant.SAVE_TICKET_INFO, 4).edit();
        if (BuildConfig.isDebug() == false) goto L5;
        r10.putString(Constant.IFDEBUG, "yes");
        NeoLog.i("luzhi", "save ticket debug yes");
    L6:
        boolean r11 = r10.commit();
        AppUtil.resumeWhiteList();
        return r11;
    L5:
        r10.putString(Constant.IFDEBUG, "no");
        NeoLog.i("luzhi", "save ticket debug no");
        goto L6
    }

    public static void saveTicketTime(Context r5, long r10) {
        SharedPreferences.Editor r11 = r5.getSharedPreferences(Constant.SAVE_TICKET_INFO, 4).edit();
        r11.putLong(Constant.TICKET_TIME, r10);
        r11.commit();
    }

    public static void setAlias(Context r5, String r10) {
        LocalRecoder r11 = getLocalRecoder(r5);
        if (r11 == null) goto L6;
        r11.setAliasSetTime(System.currentTimeMillis());
        r11.setAlias(r10);
        saveLocalRecoderInfo(r5, r11);
        return;
    }

    public static void setTopic(Context r5, List<String> r10) {
        LocalRecoder r11 = getLocalRecoder(r5);
        if (r11 == null) goto L6;
        r11.setTopicSetTime(System.currentTimeMillis());
        r11.setTopics(r10);
        saveLocalRecoderInfo(r5, r11);
        return;
    }

    public static long topicGetTime(Context r5) {
        LocalRecoder r10 = getLocalRecoder(r5);
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getLastTopicGetTime();
    }

    public static long topicSubscribeTime(Context r5) {
        LocalRecoder r10 = getLocalRecoder(r5);
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getTopicSetTime();
    }

    public static void unregisterPush(Context r5) {
        SharedPreferences.Editor r10 = r5.getSharedPreferences(Constant.SP_FILE_NAME, 0).edit();
        r10.putString(r5.getPackageName(), "");
        r10.commit();
    }

    public static void unsetAlias(Context r5) {
        LocalRecoder r10 = getLocalRecoder(r5);
        if (r10 == null) goto L6;
        r10.setAliasSetTime(-1);
        r10.setAlias(null);
        saveLocalRecoderInfo(r5, r10);
        return;
    }

    public static void unsetTopic(Context r5, List<String> r10) {
        LocalRecoder r11 = getLocalRecoder(r5);
        if (r11 == null) goto L6;
        r11.setTopicSetTime(-1);
        r11.setTopics(null);
        saveLocalRecoderInfo(r5, r11);
        return;
    }
}
