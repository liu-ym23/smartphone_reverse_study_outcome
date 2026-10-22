package cn.nubia.neopush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import cn.nubia.neopush.commons.AppUtil;
import cn.nubia.neopush.commons.Constant;
import cn.nubia.neopush.commons.NeoLog;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class NeoPushClient {
    private static final long INTERVAL = 20000;
    private static final long MAXCOUNT = 50;
    private static long SetAliasCount;
    private static long getSubscribeTopicsCount;
    static ExecutorService mExecutorService;
    private static final Uri mUri = null;
    private static long setTopicCount;

    static {
        mUri = Uri.parse("content://cn.nubia.neopush.fanIconAck");
        mExecutorService = Executors.newSingleThreadExecutor();
    }

    public NeoPushClient() {
    }

    private static void StopMyService(Context r5, String r10, String r11, List<String> r12, String r13) {
        Intent r14 = new Intent(Constant.COMMAND_STOP);     // Catch: Exception -> L4
        r14.setComponent(new ComponentName(r5.getPackageName(), "cn.nubia.neopush.service.NeoPushService"));     // Catch: Exception -> L4
        NeoLog.i("luzhi", "StopMySelf");     // Catch: Exception -> L4
        r5.getApplicationContext().startService(r14);     // Catch: Exception -> L4
        return;
    }

    public static /* synthetic */ void access$0(Context r5, boolean r10) {
        setIsDebug(r5, r10);
    }

    public static /* synthetic */ int access$1(Context r5, String r10) {
        return getPackageCode(r5, r10);
    }

    public static boolean getNotifySwitch(Context r10) {
        if (r10 != null) goto L15;
        Log.e("NeoPushClient", "getNotifySwitch context is not null");
        return true;
    L15:
        Bundle r5 = new Bundle();     // Catch: Exception -> L14
        String r11 = r10.getPackageName();     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r11) == false) goto L10;
        Log.e("NeoPushClient", "context pckname is empty");     // Catch: Exception -> L14
        return true;
    L10:
        r5.putString("pkgname", r11);     // Catch: Exception -> L14
        if (r10.getContentResolver().call(mUri, "notifyAction", "getswitch", r5).getInt(NotificationCompat.CATEGORY_STATUS, 1) != 0) goto L16;
        return false;
    L16:
        return true;
    L17:
        return true;
    }

    private static int getPackageCode(Context r5, String r10) {
        int r11 = 0;
        PackageInfo r12 = r5.getPackageManager().getPackageInfo(r10, 16384);     // Catch: PackageManager.NameNotFoundException -> L5
        r11 = r12.versionCode;     // Catch: PackageManager.NameNotFoundException -> L5
        NeoLog.i("luzhi", "neopush packageinfo  " + r12.versionCode + "   " + r12.packageName);     // Catch: PackageManager.NameNotFoundException -> L5
        return r11;
    L5:
        e = move-exception;
        e.printStackTrace();
        return r11;
    }

    public static String getRegId(Context r5) {
        if (r5 != null) goto L8;
        return null;
    L8:
        return SDKPrefEditor.getRegId(r5);
    L10:
        return null;
    }

    public static int getSubscribeTopics(Context r10) {
        boolean r5 = AppUtil.shouldUseZtePush(r10);     // Catch: Exception -> L27
        boolean r11 = AppUtil.shouldUseNubiaPush(r10);     // Catch: Exception -> L27
        boolean r12 = AppUtil.shouldUseNewZtePush(r10);     // Catch: Exception -> L27
        if (r5 == false) goto L9;
        if (r11 == true) goto L9;
        if (r12 == true) goto L9;
        Log.d("neopush", "not getTopic");     // Catch: Exception -> L27
        return -1;
    L9:
        AppUtil.addWhiteList();     // Catch: Exception -> L27
        SDKUtils.checkNull(r10, "context");     // Catch: Exception -> L27
        String r13 = SDKPrefEditor.getRegId(r10);     // Catch: Exception -> L27
        if (SDKUtils.checkRegId(r10, Constant.ClientMessageType.GET_TOPICS, r13) == false) goto L14;
        AppUtil.resumeWhiteList();     // Catch: Exception -> L27
        return -1;
    L14:
        if ((System.currentTimeMillis() - SDKPrefEditor.topicGetTime(r10)) > INTERVAL) goto L21;
        if (getSubscribeTopicsCount < MAXCOUNT) goto L21;
        AppUtil.resumeWhiteList();     // Catch: Exception -> L27
        return 1;
    L21:
        if ((System.currentTimeMillis() - SDKPrefEditor.topicGetTime(r10)) >= INTERVAL) goto L23;
        getSubscribeTopicsCount++;     // Catch: Exception -> L27
    L24:
        Context r14 = r10.getApplicationContext();     // Catch: Exception -> L27
        Intent r15 = new Intent(Constant.SEND_COMMAND);     // Catch: Exception -> L27
        r15.setComponent(AppUtil.getPushServiceComponentName(r14));     // Catch: Exception -> L27
        Bundle r16 = new Bundle();     // Catch: Exception -> L27
        r16.putString(Constant.COMMAND, Constant.ClientMessageType.GET_TOPICS);     // Catch: Exception -> L27
        r16.putString(Constant.PACKAGE_NAME, r10.getPackageName());     // Catch: Exception -> L27
        r16.putString(Constant.REG_ID, r13);     // Catch: Exception -> L27
        r15.putExtras(r16);     // Catch: Exception -> L27
        r14.startService(r15);     // Catch: Exception -> L27
        SDKPrefEditor.getTopics(r10);     // Catch: Exception -> L27
        AppUtil.resumeWhiteList();     // Catch: Exception -> L27
        return 0;
    L23:
        getSubscribeTopicsCount = 0;     // Catch: Exception -> L27
    L27:
        AppUtil.resumeWhiteList();
        return 2;
    }

    public static void makePushActive(Context r5) {
        if (r5 == null) goto L8;
        Intent r10 = new Intent(Constant.SEND_PING);     // Catch: Exception -> L5
        r10.setComponent(AppUtil.getPushServiceComponentName(r5.getApplicationContext()));     // Catch: Exception -> L5
        r5.startService(r10);     // Catch: Exception -> L5
        return;
    L9:
        return;
    }

    public static void onPassThroughMessageClick(Context r5, long r10) {
        SDKUtils.checkNull(r5, "context");     // Catch: Exception -> L4
        Bundle r11 = new Bundle();     // Catch: Exception -> L4
        r11.putString(Constant.PACKAGE_NAME, r5.getPackageName());     // Catch: Exception -> L4
        r11.putLong("message_id", r10);     // Catch: Exception -> L4
        Intent r12 = new Intent(Constant.SEND_COMMAND);     // Catch: Exception -> L4
        r12.setComponent(AppUtil.getPushServiceComponentName(r5.getApplicationContext()));     // Catch: Exception -> L4
        Bundle r13 = new Bundle();     // Catch: Exception -> L4
        r13.putString(Constant.COMMAND, Constant.ClientMessageType.SEND_CLECK);     // Catch: Exception -> L4
        r13.putAll(r11);     // Catch: Exception -> L4
        r12.putExtras(r13);     // Catch: Exception -> L4
        r5.startService(r12);     // Catch: Exception -> L4
        return;
    L4:
        NeoLog.e("luzhi", "Illegal param………………………………………………");
    }

    private static void register(final Context r10, final String r11, final String r12, final List<String> r13, final String r14, final boolean r15) {
        SDKUtils.checkNull(r10, "context");
        SDKUtils.checkNull(r11, Constant.APPID);
        SDKUtils.checkNull(r12, Constant.APPKEY);
        final Context r5 = r10.getApplicationContext();
        StopMyService(r10, r11, r12, r13, r14);
        new Handler(r10.getMainLooper()).postDelayed(new AnonymousClass1(r5, r15, r11, r12, r10, r14, r13), 30);
    }

    public static void registerPush(Context r20, String r21, String r22, List<String> r23, String r24) {
        AppUtil.addWhiteList();
        uploadAppInfo(r20);     // Catch: Throwable -> L28
        boolean r5 = AppUtil.shouldUseZtePush(r20);     // Catch: Throwable -> L28
        boolean r10 = AppUtil.shouldUseNubiaPush(r20);     // Catch: Throwable -> L28
        boolean r11 = AppUtil.shouldUseNewZtePush(r20);     // Catch: Throwable -> L28
        if (r5 == false) goto L9;
        if (r10 == true) goto L9;
        if (r11 == true) goto L9;
        Log.d("neopush", "not registerPush");     // Catch: Throwable -> L28
        return;
    L9:
        requestUpgrade(r20);     // Catch: Throwable -> L28
        if (r10 == true) goto L20;
        if (r11 == true) goto L20;
        SDKUtils.checkNull(r20, "context");     // Catch: Throwable -> L28 Throwable -> L28
        SDKUtils.checkNull(r21, Constant.APPID);     // Catch: Throwable -> L28 Throwable -> L28
        SDKUtils.checkNull(r22, Constant.APPKEY);     // Catch: Throwable -> L28 Throwable -> L28
        Context r12 = r20.getApplicationContext();     // Catch: Throwable -> L28 Throwable -> L28
        String r13 = r20.getSharedPreferences(Constant.SaveReg, 0).getString("RegID", "");     // Catch: Throwable -> L28 Throwable -> L28
        if (r13 != null) goto L17;
    L19:
        register(r20, r21, r22, r23, r24);     // Catch: Throwable -> L28 Throwable -> L28
        goto L26
    L17:
        if (r13.equals("") == true) goto L19;
        StopMyService(r20, r21, r22, r23, r24);     // Catch: Throwable -> L28 Throwable -> L28
        Intent r14 = new Intent(Constant.SEND_COMMAND);     // Catch: Throwable -> L28 Throwable -> L28
        r14.setComponent(AppUtil.getPushServiceComponentName(r12));     // Catch: Throwable -> L28 Throwable -> L28
        Bundle r15 = new Bundle();     // Catch: Throwable -> L28 Throwable -> L28
        r15.putString(Constant.COMMAND, Constant.ClientMessageType.ACTIVE);     // Catch: Throwable -> L28 Throwable -> L28
        r15.putString(Constant.PACKAGE_NAME, r20.getPackageName());     // Catch: Throwable -> L28 Throwable -> L28
        r15.putString(Constant.REG_ID, r13);     // Catch: Throwable -> L28 Throwable -> L28
        r15.putString(Constant.APPID, r21);     // Catch: Throwable -> L28 Throwable -> L28
        r15.putString(Constant.APPKEY, r22);     // Catch: Throwable -> L28 Throwable -> L28
        r15.putString(Constant.ALIAS, r24);     // Catch: Throwable -> L28 Throwable -> L28
        r15.putString(Constant.TOPICS, SDKUtils.generateTopicListToJSON(r23));     // Catch: Throwable -> L28 Throwable -> L28
        r15.putInt(r20.getPackageName(), Constant.SDK_VERSION);     // Catch: Throwable -> L28 Throwable -> L28
        r14.putExtras(r15);     // Catch: Throwable -> L28 Throwable -> L28
        NeoLog.i("SendActive push = " + r14.getComponent().getPackageName() + "   regid  " + r13);     // Catch: Throwable -> L28 Throwable -> L28
        r12.startService(r14);     // Catch: Throwable -> L28 Throwable -> L28
    L20:
        SDKUtils.checkNull(r20, "context");     // Catch: Throwable -> L28 Throwable -> L28
        SDKUtils.checkNull(r21, Constant.APPID);     // Catch: Throwable -> L28 Throwable -> L28
        SDKUtils.checkNull(r22, Constant.APPKEY);     // Catch: Throwable -> L28 Throwable -> L28
        Context r16 = r20.getApplicationContext();     // Catch: Throwable -> L28 Throwable -> L28
        String r17 = r20.getSharedPreferences(Constant.SaveReg, 0).getString("RegID", "");     // Catch: Throwable -> L28 Throwable -> L28
        if (r17 != null) goto L23;
    L25:
        register(r20, r21, r22, r23, r24);     // Catch: Throwable -> L28 Throwable -> L28
        goto L26
    L23:
        if (r17.equals("") == true) goto L25;
        StopMyService(r20, r21, r22, r23, r24);     // Catch: Throwable -> L28 Throwable -> L28
        Intent r18 = new Intent(Constant.SEND_COMMAND);     // Catch: Throwable -> L28 Throwable -> L28
        r18.setComponent(AppUtil.getPushServiceComponentName(r16));     // Catch: Throwable -> L28 Throwable -> L28
        Bundle r19 = new Bundle();     // Catch: Throwable -> L28 Throwable -> L28
        r19.putString(Constant.COMMAND, Constant.ClientMessageType.ACTIVE);     // Catch: Throwable -> L28 Throwable -> L28
        r19.putString(Constant.PACKAGE_NAME, r20.getPackageName());     // Catch: Throwable -> L28 Throwable -> L28
        r19.putString(Constant.REG_ID, r17);     // Catch: Throwable -> L28 Throwable -> L28
        r19.putString(Constant.APPID, r21);     // Catch: Throwable -> L28 Throwable -> L28
        r19.putString(Constant.APPKEY, r22);     // Catch: Throwable -> L28 Throwable -> L28
        r19.putString(Constant.ALIAS, r24);     // Catch: Throwable -> L28 Throwable -> L28
        r19.putString(Constant.TOPICS, SDKUtils.generateTopicListToJSON(r23));     // Catch: Throwable -> L28 Throwable -> L28
        r19.putInt(r20.getPackageName(), Constant.SDK_VERSION);     // Catch: Throwable -> L28 Throwable -> L28
        r18.putExtras(r19);     // Catch: Throwable -> L28 Throwable -> L28
        NeoLog.i("SendActive push = " + r18.getComponent().getPackageName() + "   regid  " + r17);     // Catch: Throwable -> L28 Throwable -> L28
        r16.startService(r18);     // Catch: Throwable -> L28 Throwable -> L28
    L26:
        AppUtil.resumeWhiteList();
    }

    private static void requestUpgrade(final Context r5) {
        if (r5 == null) goto L13;
        int r10 = getPackageCode(r5, Constant.CONTROL_APP_PACKAGES_NAME);
        if (r10 <= 155) goto L6;
        return;
    L6:
        if (r10 >= 119) goto L8;
        return;
    L8:
        if (r10 != 152) goto L10;
        return;
    L10:
        if ((System.currentTimeMillis() - AppUtil.getLastRequestUpdateTime(r5)) <= 604800000) goto L17;
        AppUtil.setRequestUpdateTime(r5);
        new Handler(r5.getMainLooper()).postDelayed(new AnonymousClass4(r5), 60000);
        return;
    L17:
        return;
    }

    public static void sendShowMessage(Context r5, long r10) {
        Bundle r11 = new Bundle();     // Catch: Exception -> L4
        r11.putLong("message_id", r10);     // Catch: Exception -> L4
        r11.putString(Constant.PACKAGE_NAME, r5.getPackageName());     // Catch: Exception -> L4
        Intent r12 = new Intent(Constant.SEND_COMMAND);     // Catch: Exception -> L4
        r12.setComponent(AppUtil.getPushServiceComponentName(r5.getApplicationContext()));     // Catch: Exception -> L4
        Bundle r13 = new Bundle();     // Catch: Exception -> L4
        r13.putString(Constant.COMMAND, Constant.ClientMessageType.SHOW);     // Catch: Exception -> L4
        r13.putAll(r11);     // Catch: Exception -> L4
        r12.putExtras(r13);     // Catch: Exception -> L4
        r5.startService(r12);     // Catch: Exception -> L4
        return;
    }

    public static int setAlias(Context r12, String r13) {
        boolean r5 = AppUtil.shouldUseZtePush(r12);     // Catch: Exception -> L27 IllegalArgumentException -> L29
        boolean r10 = AppUtil.shouldUseNubiaPush(r12);     // Catch: Exception -> L27 IllegalArgumentException -> L29
        boolean r11 = AppUtil.shouldUseNewZtePush(r12);     // Catch: Exception -> L27 IllegalArgumentException -> L29
        if (r5 == false) goto L9;
        if (r10 == true) goto L9;
        if (r11 == true) goto L9;
        Log.d("neopush", "not setAlias");     // Catch: Exception -> L27 IllegalArgumentException -> L29
        return -1;
    L9:
        AppUtil.addWhiteList();     // Catch: Exception -> L27 IllegalArgumentException -> L29
        SDKUtils.checkNull(r12, "context");     // Catch: Exception -> L27 IllegalArgumentException -> L29
        SDKUtils.checkNull(r13, Constant.ALIAS);     // Catch: Exception -> L27 IllegalArgumentException -> L29
        String r14 = SDKPrefEditor.getRegId(r12);     // Catch: Exception -> L27 IllegalArgumentException -> L29
        if (SDKUtils.checkRegId(r12, "set_alias", r14) == false) goto L14;
        AppUtil.resumeWhiteList();     // Catch: Exception -> L27 IllegalArgumentException -> L29
        return -1;
    L14:
        if ((System.currentTimeMillis() - SDKPrefEditor.aliasSetTime(r12)) > INTERVAL) goto L21;
        if (SetAliasCount < MAXCOUNT) goto L21;
        AppUtil.resumeWhiteList();     // Catch: Exception -> L27 IllegalArgumentException -> L29
        return 1;
    L21:
        if ((System.currentTimeMillis() - SDKPrefEditor.aliasSetTime(r12)) >= INTERVAL) goto L23;
        SetAliasCount++;     // Catch: Exception -> L27 IllegalArgumentException -> L29
    L24:
        Context r15 = r12.getApplicationContext();     // Catch: Exception -> L27 IllegalArgumentException -> L29
        Intent r16 = new Intent(Constant.SEND_COMMAND);     // Catch: Exception -> L27 IllegalArgumentException -> L29
        r16.setComponent(AppUtil.getPushServiceComponentName(r15));     // Catch: Exception -> L27 IllegalArgumentException -> L29
        Bundle r17 = new Bundle();     // Catch: Exception -> L27 IllegalArgumentException -> L29
        r17.putString(Constant.COMMAND, "set_alias");     // Catch: Exception -> L27 IllegalArgumentException -> L29
        r17.putString(Constant.PACKAGE_NAME, r12.getPackageName());     // Catch: Exception -> L27 IllegalArgumentException -> L29
        r17.putString(Constant.ALIAS, r13);     // Catch: Exception -> L27 IllegalArgumentException -> L29
        r17.putString(Constant.REG_ID, r14);     // Catch: Exception -> L27 IllegalArgumentException -> L29
        r16.putExtras(r17);     // Catch: Exception -> L27 IllegalArgumentException -> L29
        r15.startService(r16);     // Catch: Exception -> L27 IllegalArgumentException -> L29
        SDKPrefEditor.setAlias(r12, r13);     // Catch: Exception -> L27 IllegalArgumentException -> L29
        AppUtil.resumeWhiteList();     // Catch: Exception -> L27 IllegalArgumentException -> L29
        return 0;
    L23:
        SetAliasCount = 0;     // Catch: Exception -> L27 IllegalArgumentException -> L29
    L29:
        NeoLog.e("luzhi", "Illegal param………………………………………………");
        AppUtil.resumeWhiteList();
        return 2;
    L27:
        NeoLog.e("luzhi", "Illegal param………………………………………………");
        AppUtil.resumeWhiteList();
        return 2;
    }

    private static void setIsDebug(Context r5, boolean r10) {
        Intent r11 = new Intent(Constant.SET_ISDEBUG);     // Catch: Exception -> L4
        r11.putExtra(Constant.IS_DEBUG, r10);     // Catch: Exception -> L4
        r11.setComponent(new ComponentName(r5.getPackageName(), "cn.nubia.neopush.service.NeoPushService"));     // Catch: Exception -> L4
        r5.getApplicationContext().startService(r11);     // Catch: Exception -> L4
        return;
    }

    public static void setNotifySwitch(Context r5, boolean r10) {
        if (r5 != null) goto L13;
        Log.e("NeoPushClient", "setNotifySwitch context is not null");
        return;
    L13:
        Bundle r11 = new Bundle();     // Catch: Exception -> L12
        String r12 = r5.getPackageName();     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r12) == false) goto L10;
        Log.e("NeoPushClient", "context pckname is empty");     // Catch: Exception -> L12
        return;
    L10:
        r11.putString("pkgname", r12);     // Catch: Exception -> L12
        r11.putInt(NotificationCompat.CATEGORY_STATUS, r10 ? 1 : 0);     // Catch: Exception -> L12
        r5.getContentResolver().call(mUri, "notifyAction", "setswitch", r11);     // Catch: Exception -> L12
        return;
    }

    public static int setTopic(Context r10, List<String> r11) {
        boolean r5 = AppUtil.shouldUseZtePush(r10);     // Catch: Exception -> L28 IllegalArgumentException -> L30
        boolean r12 = AppUtil.shouldUseNubiaPush(r10);     // Catch: Exception -> L28 IllegalArgumentException -> L30
        boolean r13 = AppUtil.shouldUseNewZtePush(r10);     // Catch: Exception -> L28 IllegalArgumentException -> L30
        if (r5 == false) goto L9;
        if (r12 == true) goto L9;
        if (r13 == true) goto L9;
        Log.d("neopush", "not setTopic");     // Catch: Exception -> L28 IllegalArgumentException -> L30
        return -1;
    L9:
        AppUtil.addWhiteList();     // Catch: Exception -> L28 IllegalArgumentException -> L30
        SDKUtils.checkNull(r10, "context");     // Catch: Exception -> L28 IllegalArgumentException -> L30
        SDKUtils.checkNull(r11, "topic");     // Catch: Exception -> L28 IllegalArgumentException -> L30
        SDKUtils.checkTopicList(r11);     // Catch: Exception -> L28 IllegalArgumentException -> L30
        if (SDKUtils.checkRegId(r10, "set_topic", SDKPrefEditor.getRegId(r10)) == false) goto L14;
        AppUtil.resumeWhiteList();     // Catch: Exception -> L28 IllegalArgumentException -> L30
        return -1;
    L14:
        if ((System.currentTimeMillis() - SDKPrefEditor.topicSubscribeTime(r10)) > INTERVAL) goto L18;
        if (setTopicCount < MAXCOUNT) goto L18;
    L25:
        AppUtil.resumeWhiteList();     // Catch: Exception -> L28 IllegalArgumentException -> L30
        return 1;
    L18:
        if (r11.size() <= 0) goto L25;
        if ((System.currentTimeMillis() - SDKPrefEditor.topicSubscribeTime(r10)) >= INTERVAL) goto L22;
        setTopicCount++;     // Catch: Exception -> L28 IllegalArgumentException -> L30
    L23:
        Context r14 = r10.getApplicationContext();     // Catch: Exception -> L28 IllegalArgumentException -> L30
        String r15 = SDKUtils.generateTopicListToJSON(r11);     // Catch: Exception -> L28 IllegalArgumentException -> L30
        Intent r16 = new Intent(Constant.SEND_COMMAND);     // Catch: Exception -> L28 IllegalArgumentException -> L30
        r16.setComponent(AppUtil.getPushServiceComponentName(r14));     // Catch: Exception -> L28 IllegalArgumentException -> L30
        Bundle r17 = new Bundle();     // Catch: Exception -> L28 IllegalArgumentException -> L30
        r17.putString(Constant.COMMAND, "set_topic");     // Catch: Exception -> L28 IllegalArgumentException -> L30
        r17.putString(Constant.PACKAGE_NAME, r10.getPackageName());     // Catch: Exception -> L28 IllegalArgumentException -> L30
        r17.putString(Constant.TOPICS, r15);     // Catch: Exception -> L28 IllegalArgumentException -> L30
        r17.putString(Constant.REG_ID, SDKPrefEditor.getRegId(r10));     // Catch: Exception -> L28 IllegalArgumentException -> L30
        r16.putExtras(r17);     // Catch: Exception -> L28 IllegalArgumentException -> L30
        r14.startService(r16);     // Catch: Exception -> L28 IllegalArgumentException -> L30
        SDKPrefEditor.setTopic(r10, r11);     // Catch: Exception -> L28 IllegalArgumentException -> L30
        AppUtil.resumeWhiteList();     // Catch: Exception -> L28 IllegalArgumentException -> L30
        return 0;
    L22:
        setTopicCount = 0;     // Catch: Exception -> L28 IllegalArgumentException -> L30
    L30:
        NeoLog.e("luzhi", "Illegal param………………………………………………");
        AppUtil.resumeWhiteList();
        return 2;
    L28:
        NeoLog.e("luzhi", "Illegal param………………………………………………");
        AppUtil.resumeWhiteList();
        return 2;
    }

    private static boolean shouldSendRegRequest(Context r5, String r10) {
        NeoLog.i("luzhi", "当前时间" + System.currentTimeMillis() + "       上次注册时间" + SDKPrefEditor.getLastRegRequestTime(r5, r10));
        if (Math.abs(System.currentTimeMillis() - SDKPrefEditor.getLastRegRequestTime(r5, r10)) <= 10000) goto L6;
        return true;
    L6:
        return false;
    }

    public static void unRegisterPush(final Context r5) {
        mExecutorService.execute(new AnonymousClass3(r5));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static int unsetTopic(Context r10, List<String> r11) {
        boolean r5 = AppUtil.shouldUseZtePush(r10);     // Catch: Exception -> L24 IllegalArgumentException -> L26
        boolean r12 = AppUtil.shouldUseNubiaPush(r10);     // Catch: Exception -> L24 IllegalArgumentException -> L26
        boolean r13 = AppUtil.shouldUseNewZtePush(r10);     // Catch: Exception -> L24 IllegalArgumentException -> L26
        if (r5 == false) goto L9;
        if (r12 == true) goto L9;
        if (r13 == true) goto L9;
        Log.d("neopush", "not unsetTopic");     // Catch: Exception -> L24 IllegalArgumentException -> L26
        return -1;
    L9:
        AppUtil.addWhiteList();     // Catch: Exception -> L24 IllegalArgumentException -> L26
        SDKUtils.checkNull(r10, "context");     // Catch: Exception -> L24 IllegalArgumentException -> L26
        SDKUtils.checkNull(r11, "topic");     // Catch: Exception -> L24 IllegalArgumentException -> L26
        SDKUtils.checkTopicList(r11);     // Catch: Exception -> L24 IllegalArgumentException -> L26
        String r14 = SDKPrefEditor.getRegId(r10);     // Catch: Exception -> L24 IllegalArgumentException -> L26
        if (SDKUtils.checkRegId(r10, "unset_topic", r14) == false) goto L14;
        AppUtil.resumeWhiteList();     // Catch: Exception -> L24 IllegalArgumentException -> L26
        return -1;
    L14:
        if (SDKPrefEditor.topicSubscribeTime(r10) > 0) goto L18;
        if (SDKPrefEditor.topicGetTime(r10) < 0) goto L18;
    L21:
        AppUtil.resumeWhiteList();     // Catch: Exception -> L24 IllegalArgumentException -> L26
        return 1;
    L18:
        if (r11.size() <= 0) goto L21;
        Context r15 = r10.getApplicationContext();     // Catch: Exception -> L24 IllegalArgumentException -> L26
        String r16 = SDKUtils.generateTopicListToJSON(r11);     // Catch: Exception -> L24 IllegalArgumentException -> L26
        Intent r17 = new Intent(Constant.SEND_COMMAND);     // Catch: Exception -> L24 IllegalArgumentException -> L26
        r17.setComponent(AppUtil.getPushServiceComponentName(r15));     // Catch: Exception -> L24 IllegalArgumentException -> L26
        Bundle r18 = new Bundle();     // Catch: Exception -> L24 IllegalArgumentException -> L26
        r18.putString(Constant.COMMAND, "unset_topic");     // Catch: Exception -> L24 IllegalArgumentException -> L26
        r18.putString(Constant.PACKAGE_NAME, r10.getPackageName());     // Catch: Exception -> L24 IllegalArgumentException -> L26
        r18.putString(Constant.TOPICS, r16);     // Catch: Exception -> L24 IllegalArgumentException -> L26
        r18.putString(Constant.REG_ID, r14);     // Catch: Exception -> L24 IllegalArgumentException -> L26
        r17.putExtras(r18);     // Catch: Exception -> L24 IllegalArgumentException -> L26
        r15.startService(r17);     // Catch: Exception -> L24 IllegalArgumentException -> L26
        SDKPrefEditor.unsetTopic(r10, r11);     // Catch: Exception -> L24 IllegalArgumentException -> L26
        AppUtil.resumeWhiteList();     // Catch: Exception -> L24 IllegalArgumentException -> L26
        return 0;
    L26:
        NeoLog.e("luzhi", "Illegal param………………………………………………");
        AppUtil.resumeWhiteList();
        return 2;
    L24:
        NeoLog.e("luzhi", "Illegal param………………………………………………");
        AppUtil.resumeWhiteList();
        return 2;
    }

    private static void uploadAppInfo(Context r5) {
        AppUtil.UploadVersion(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private static void register(final Context r10, final String r11, final String r12, final List<String> r13, final String r14) {
        SDKUtils.checkNull(r10, "context");
        SDKUtils.checkNull(r11, Constant.APPID);
        SDKUtils.checkNull(r12, Constant.APPKEY);
        final Context r5 = r10.getApplicationContext();
        StopMyService(r10, r11, r12, r13, r14);
        new Handler(r10.getMainLooper()).postDelayed(new AnonymousClass2(r5, r11, r12, r10, r14, r13), 30);
    }

    public static void sendShowMessage(Context r5, long r10, String r11) {
        Bundle r12 = new Bundle();     // Catch: Exception -> L4
        r12.putLong("message_id", r10);     // Catch: Exception -> L4
        r12.putString(Constant.ZTE_MESSAGE_ID, r11);     // Catch: Exception -> L4
        r12.putString(Constant.PACKAGE_NAME, r5.getPackageName());     // Catch: Exception -> L4
        Intent r13 = new Intent(Constant.SEND_COMMAND);     // Catch: Exception -> L4
        r13.setComponent(AppUtil.getPushServiceComponentName(r5.getApplicationContext()));     // Catch: Exception -> L4
        Bundle r14 = new Bundle();     // Catch: Exception -> L4
        r14.putString(Constant.COMMAND, Constant.ClientMessageType.SHOW);     // Catch: Exception -> L4
        r14.putAll(r12);     // Catch: Exception -> L4
        r13.putExtras(r14);     // Catch: Exception -> L4
        r5.startService(r13);     // Catch: Exception -> L4
        return;
    }

    public static void onPassThroughMessageClick(Context r5, long r10, String r11) {
        SDKUtils.checkNull(r5, "context");     // Catch: Exception -> L5 IllegalArgumentException -> L6
        Bundle r12 = new Bundle();     // Catch: Exception -> L5 IllegalArgumentException -> L6
        r12.putString(Constant.PACKAGE_NAME, r5.getPackageName());     // Catch: Exception -> L5 IllegalArgumentException -> L6
        r12.putLong("message_id", r10);     // Catch: Exception -> L5 IllegalArgumentException -> L6
        r12.putString(Constant.ZTE_MESSAGE_ID, r11);     // Catch: Exception -> L5 IllegalArgumentException -> L6
        Intent r13 = new Intent(Constant.SEND_COMMAND);     // Catch: Exception -> L5 IllegalArgumentException -> L6
        r13.setComponent(AppUtil.getPushServiceComponentName(r5.getApplicationContext()));     // Catch: Exception -> L5 IllegalArgumentException -> L6
        Bundle r14 = new Bundle();     // Catch: Exception -> L5 IllegalArgumentException -> L6
        r14.putString(Constant.COMMAND, Constant.ClientMessageType.SEND_CLECK);     // Catch: Exception -> L5 IllegalArgumentException -> L6
        r14.putAll(r12);     // Catch: Exception -> L5 IllegalArgumentException -> L6
        r13.putExtras(r14);     // Catch: Exception -> L5 IllegalArgumentException -> L6
        r5.startService(r13);     // Catch: Exception -> L5 IllegalArgumentException -> L6
    L11:
        return;
    L6:
        NeoLog.e("luzhi", "Illegal param………………………………………………");
        return;
    L5:
        NeoLog.e("luzhi", "Illegal param………………………………………………");
    }
}
