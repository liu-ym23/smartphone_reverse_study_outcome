package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.tencent.connect.api.QQAuthManage;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.avatar.QQAvatar;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.commonchannel.CommonChannelApi;
import com.tencent.connect.emotion.QQEmotion;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.SocialOperation;
import com.tencent.open.apireq.IApiCallback;
import com.tencent.open.b.b;
import com.tencent.open.im.IM;
import com.tencent.open.log.SLog;
import com.tencent.open.log.Tracer;
import com.tencent.open.miniapp.MiniApp;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;
    public static boolean USE_ONE_HOUR;
    private static Tencent c;
    private static boolean d;
    private final c a;
    private String b;

    public static boolean isPermissionNotGranted() {
        if (d == true) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.isEmpty(f.a().b()) == true) goto L8;
        return false;
    }

    public static void resetQQAppInfoCache() {
        k.a("com.tencent.mobileqq");
    }

    public static void resetTimAppInfoCache() {
        k.a("com.tencent.tim");
    }

    public String getAccessToken() {
        String r0 = this.a.b().getAccessToken();
        SLog.i("openSDK_LOG.Tencent", "getAccessToken() accessToken = " + r0);
        a("getAccessToken", new Object[0]);
        return r0;
    }

    public String getAppId() {
        String r0 = this.a.b().getAppId();
        SLog.i("openSDK_LOG.Tencent", "getAppId() appid =" + r0);
        a("getAppId", r0);
        return r0;
    }

    public long getExpiresIn() {
        long r0 = this.a.b().getExpireTimeInSecond();
        SLog.i("openSDK_LOG.Tencent", "getExpiresIn() expiresin= " + r0);
        a("getExpiresIn", Long.valueOf(r0));
        return r0;
    }

    public String getOpenId() {
        String r0 = this.a.b().getOpenId();
        SLog.i("openSDK_LOG.Tencent", "getOpenId() openid= " + r0);
        a("getOpenId", new Object[0]);
        return r0;
    }

    public QQToken getQQToken() {
        SLog.i("openSDK_LOG.Tencent", "getQQToken()");
        a("getQQToken", new Object[0]);
        return this.a.b();
    }

    public boolean isSessionValid() {
        boolean r0 = this.a.c();
        SLog.i("openSDK_LOG.Tencent", "isSessionValid() isvalid =" + r0);
        a("isSessionValid", Boolean.valueOf(r0));
        return r0;
    }

    public void reportDAU() {
        SLog.i("openSDK_LOG.Tencent", "reportDAU() ");
        a("reportDAU", new Object[0]);
        this.a.a();
    }

    public boolean isReady() {
        if (isSessionValid() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        SLog.i("openSDK_LOG.Tencent", "isReady() --ready=" + r0);
        a("isReady", Boolean.valueOf(r0));
        return r0;
    L5:
        if (getOpenId() == null) goto L7;
        r0 = true;
        goto L8
    }

    public static void resetTargetAppInfoCache() {
        k.a();
    }

    private static String a(Object... r4) {
        if (r4 != null) goto L5;
    L17:
        return BuildConfig.FLAVOR;
    L5:
        if (r4.length == 0) goto L17;
        if ((r4.length % 2) == 0) goto L10;
        return BuildConfig.FLAVOR;
    L10:
        StringBuilder r0 = new StringBuilder();
        int r1 = r4.length;
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L16;
        if (r2 <= 0) goto L14;
        r0.append('|');
    L14:
        r0.append(r4[r2]);
        r0.append(':');
        r0.append(r4[r2 + 1]);
        r2 = r2 + 2;
        goto L11
    L16:
        return r0.toString();
    }

    public static synchronized String getAuthorities(String r5) {
        monitor-enter(Tencent.class);
        a("getAuthorities", new Object[]{"appid", r5});     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r5) == false) goto L9;
        SLog.i("openSDK_LOG.Tencent", "TextUtils.isEmpty(appId)");     // Catch: Throwable -> L20
        monitor-exit(Tencent.class);
        return null;
    L9:
        Tencent r1 = c;     // Catch: Throwable -> L20
        if (r1 != null) goto L15;
        SLog.i("openSDK_LOG.Tencent", "sInstance == null");     // Catch: Throwable -> L20
        monitor-exit(Tencent.class);
        return null;
    L15:
        if (r5.equals(r1.getAppId()) == false) goto L17;
        String r6 = c.b;     // Catch: Throwable -> L20
    L18:
        monitor-exit(Tencent.class);
        return r6;
    L17:
        r6 = BuildConfig.FLAVOR;
    L20:
        th = move-exception;
        throw th;
    }

    public static boolean isSupportPushToQZone(Context r2) {
        if (k.c(r2, "5.9.5") >= 0) goto L5;
        boolean r3 = false;
    L6:
        SLog.i("openSDK_LOG.Tencent", "isSupportPushToQZone() support=" + r3);
        a("isSupportPushToQZone", Boolean.valueOf(r3));
        return r3;
    L5:
        r3 = true;
        goto L6
    }

    public static boolean isSupportShareToQQ(Context r4) {
        SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ()");
        boolean r3 = true;
        if (m.c(r4) == false) goto L9;
        if (k.a(r4, "com.tencent.minihd.qq") == null) goto L9;
        a("isSupportShareToQQ", Boolean.TRUE);
        return true;
    L9:
        if (k.c(r4, "4.1") < 0) goto L11;
    L13:
        SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ() support=" + r3);
        a("isSupportShareToQQ", Boolean.valueOf(r3));
        return r3;
    L11:
        if (k.a(r4, "com.tencent.tim") != null) goto L13;
        r3 = false;
        goto L13
    }

    public static Map<String, String> parseMiniParameters(Intent r9) {
        a("parseMiniParameters", new Object[0]);
        HashMap r3 = new HashMap();
        if (r9 != null) goto L34;
        SLog.e("openSDK_LOG.Tencent", "parseMiniParameters null == intent");
        return r3;
    L34:
        String r5 = r9.getStringExtra("appParameter");     // Catch: Exception -> L31
        if (TextUtils.isEmpty(r5) == true) goto L13;
        SLog.d("openSDK_LOG.Tencent", "parseMiniParameters appParameter=" + r5);     // Catch: Exception -> L31
        JSONObject r10 = new JSONObject(r5);     // Catch: Exception -> L31
        Iterator<String> r0 = r10.keys();     // Catch: Exception -> L31
    L10:
        if (r0.hasNext() == false) goto L12;
        String r1 = r0.next();     // Catch: Exception -> L31
        r3.put(r1, JSONObjectProtectorUtils.getString(r10, r1));     // Catch: Exception -> L31
        goto L10
    L12:
        return r3;
    L13:
        Uri r11 = r9.getData();     // Catch: Exception -> L31
        if (r11 != null) goto L17;
        SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uri==null");     // Catch: Exception -> L31
        return r3;
    L17:
        String r12 = r11.toString();     // Catch: Exception -> L31
        if (TextUtils.isEmpty(r12) == false) goto L21;
        SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriStr isEmpty");     // Catch: Exception -> L31
        return r3;
    L21:
        String r13 = r12.substring(r12.lastIndexOf(63) + 1);     // Catch: Exception -> L31
        if (TextUtils.isEmpty(r13) == false) goto L25;
        SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam is empty");     // Catch: Exception -> L31
        return r3;
    L25:
        SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam=" + r13);     // Catch: Exception -> L31
        String[] r14 = r13.split("&");     // Catch: Exception -> L31
        int r2 = r14.length;     // Catch: Exception -> L31
        int r4 = 0;
    L26:
        if (r4 >= r2) goto L33;
        String[] r6 = r14[r4].split("=");     // Catch: Exception -> L31
        if (r6.length != 2) goto L30;
        r3.put(r6[0], r6[1]);     // Catch: Exception -> L31
    L30:
        r4 = r4 + 1;
    L33:
        return r3;
    L31:
        e = move-exception;
        SLog.e("openSDK_LOG.Tencent", "parseMiniParameters Exception", e);
        goto L33
    }

    public static void setCustomLogger(Tracer r2) {
        SLog.i("openSDK_LOG.Tencent", "setCustomLogger");
        a("setCustomLogger", new Object[0]);
        SLog.getInstance().setCustomLogger(r2);
    }

    public static void setIsPermissionGranted(boolean r2) {
        if (r2 == false) goto L8;
        f.a().a(g.a());
        String r0 = f.a().b();
        if (r0 != null) goto L6;
    L7:
        r0 = Build.MODEL;
    L9:
        setIsPermissionGranted(r2, r0);
        return;
    L6:
        if (r0.isEmpty() == false) goto L9;
    L8:
        r0 = BuildConfig.FLAVOR;
        goto L9
    }

    public void checkLogin(IUiListener r3) {
        SLog.i("openSDK_LOG.Tencent", "checkLogin()");
        a("checkLogin", new Object[0]);
        this.a.a(r3);
    }

    public void initSessionCache(JSONObject r4) {
        a("initSessionCache", new Object[0]);
        String r0 = JSONObjectProtectorUtils.getString(r4, "access_token");     // Catch: Exception -> L12
        String r1 = JSONObjectProtectorUtils.getString(r4, "expires_in");     // Catch: Exception -> L12
        String r5 = JSONObjectProtectorUtils.getString(r4, "openid");     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r0) == false) goto L6;
    L10:
        SLog.i("openSDK_LOG.Tencent", "initSessionCache()");     // Catch: Exception -> L12
        return;
    L6:
        if (TextUtils.isEmpty(r1) == true) goto L10;
        if (TextUtils.isEmpty(r5) == true) goto L10;
        setAccessToken(r0, r1);     // Catch: Exception -> L12
        setOpenId(r5);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        SLog.i("QQToken", "initSessionCache " + e.toString());
    }

    public boolean isQQInstalled(Context r3) {
        boolean r4 = k.b(r3);
        SLog.i("openSDK_LOG.Tencent", "isQQInstalled() installed=" + r4);
        a("isQQInstalled", Boolean.valueOf(r4));
        return r4;
    }

    public boolean isSupportSSOLogin(Activity r5) {
        SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin()");
        boolean r3 = true;
        if (m.c(r5) == false) goto L9;
        if (k.a(r5, "com.tencent.minihd.qq") == null) goto L9;
        a("isSupportSSOLogin", Boolean.TRUE);
        return true;
    L9:
        if (k.c(r5, "4.1") < 0) goto L11;
    L13:
        SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin() support=" + r3);
        a("isSupportSSOLogin", Boolean.valueOf(r3));
        return r3;
    L11:
        if (k.d(r5, "1.1") >= 0) goto L13;
        r3 = false;
        goto L13
    }

    public JSONObject loadSession(String r5) {
        JSONObject r0 = this.a.b().loadSession(r5);
        StringBuilder r1 = new StringBuilder("loadSession() appid ");
        r1.append(r5);
        r1.append(", length=");
        if (r0 == null) goto L5;
        int r3 = r0.length();
    L6:
        r1.append(r3);
        SLog.i("openSDK_LOG.Tencent", r1.toString());
        a("loadSession", new Object[]{"appid", r5});
        return r0;
    L5:
        r3 = 0;
        goto L6
    }

    public void logout(Context r3) {
        SLog.i("openSDK_LOG.Tencent", "logout()");
        a("logout", new Object[0]);
        this.a.b().setAccessToken(null, DocTabPayload.DocType.UNKNOWN);
        this.a.b().setOpenId(null);
        this.a.b().removeSession(this.a.b().getAppId());
    }

    public void saveSession(JSONObject r4) {
        StringBuilder r0 = new StringBuilder("saveSession() length=");
        if (r4 == null) goto L5;
        int r2 = r4.length();
    L6:
        r0.append(r2);
        SLog.i("openSDK_LOG.Tencent", r0.toString());
        a("saveSession", new Object[0]);
        this.a.b().saveSession(r4);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public void setOpenId(String r4) {
        SLog.i("openSDK_LOG.Tencent", "setOpenId() --start");
        a("setOpenId", new Object[0]);
        this.a.b(g.a(), r4);
        SLog.i("openSDK_LOG.Tencent", "setOpenId() --end");
    }

    private Tencent(String r2, Context r3) {
        this.a = c.a(r2, r3);
        b.a().a(r2, r3);
        f.a().a(r3);
    }

    private static boolean a(Context r5, String r6) {
        r5.getPackageManager().getActivityInfo(new ComponentName(r5.getPackageName(), "com.tencent.tauth.AuthActivity"), 128);     // Catch: PackageManager.NameNotFoundException -> L9
        r5.getPackageManager().getActivityInfo(new ComponentName(r5.getPackageName(), "com.tencent.connect.common.AssistActivity"), 128);     // Catch: PackageManager.NameNotFoundException -> L7
        return true;
    L7:
        SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>");
        return false;
    L9:
        SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + (("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + r6 + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + r6 + "\" />\n</intent-filter>\n</activity>"));
        return false;
    }

    public static synchronized Tencent createInstance(String r5, Context r6) {
        monitor-enter(Tencent.class);
        g.a(r6.getApplicationContext());     // Catch: Throwable -> L22
        SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + r5);     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r5) == false) goto L9;
        SLog.e("openSDK_LOG.Tencent", "appId should not be empty!");     // Catch: Throwable -> L22
        monitor-exit(Tencent.class);
        return null;
    L9:
        Tencent r0 = c;     // Catch: Throwable -> L22
        if (r0 != null) goto L13;
        c = new Tencent(r5, r6);     // Catch: Throwable -> L22
    L16:
        if (a(r6, r5) == true) goto L19;
        monitor-exit(Tencent.class);
        return null;
    L19:
        a("createInstance", new Object[]{"appid", r5});     // Catch: Throwable -> L22
        com.tencent.open.a.f.a().a(i.a(r6, r5));     // Catch: Throwable -> L22
        SLog.i("openSDK_LOG.Tencent", "createInstance()  -- end");     // Catch: Throwable -> L22
        Tencent r7 = c;     // Catch: Throwable -> L22
        monitor-exit(Tencent.class);
        return r7;
    L13:
        if (r5.equals(r0.getAppId()) == true) goto L16;
        c.logout(r6);     // Catch: Throwable -> L22
        c = new Tencent(r5, r6);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public static void handleResultData(Intent r4, IUiListener r5) {
        StringBuilder r0 = new StringBuilder("handleResultData() data = null ? ");
        boolean r1 = true;
        if (r4 != null) goto L5;
        boolean r3 = true;
    L6:
        r0.append(r3);
        r0.append(", listener = null ? ");
        if (r5 == null) goto L10;
        r1 = false;
    L10:
        r0.append(r1);
        SLog.i("openSDK_LOG.Tencent", r0.toString());
        a("handleResultData", new Object[0]);
        UIListenerManager.getInstance().handleDataToListener(r4, r5);
        return;
    L5:
        r3 = false;
        goto L6
    }

    public static void setIsPermissionGranted(boolean r2, String r3) {
        if (r2 == false) goto L8;
        if (r3 != null) goto L6;
    L7:
        SLog.e("openSDK_LOG.Tencent", "setIsPermissionGranted error! model= [" + r3 + "]");
        r2 = false;
        goto L8
    L6:
        if (r3.trim().isEmpty() == true) goto L7;
    L9:
        d = r2;
        f.a().a(g.a(), r3);
        return;
    L8:
        r3 = null;
        goto L9
    }

    public void handleLoginData(Intent r5, IUiListener r6) {
        StringBuilder r0 = new StringBuilder("handleLoginData() data = null ? ");
        boolean r1 = true;
        if (r5 != null) goto L5;
        boolean r3 = true;
    L6:
        r0.append(r3);
        r0.append(", listener = null ? ");
        if (r6 == null) goto L10;
        r1 = false;
    L10:
        r0.append(r1);
        SLog.i("openSDK_LOG.Tencent", r0.toString());
        a("handleLoginData", new Object[0]);
        UIListenerManager.getInstance().handleDataToListener(r5, r6);
        return;
    L5:
        r3 = false;
        goto L6
    }

    public boolean isQQInstalled(Context r3, String r4) {
        if (k.c(r3, r4) < 0) goto L5;
        boolean r5 = true;
    L6:
        SLog.i("openSDK_LOG.Tencent", "isQQInstalled version[" + r4 + "] = " + r5);
        return r5;
    L5:
        r5 = false;
        goto L6
    }

    public void setAccessToken(String r3, String r4) {
        SLog.i("openSDK_LOG.Tencent", "setAccessToken(), expiresIn = " + r4 + BuildConfig.FLAVOR);
        a("setAccessToken", new Object[0]);
        this.a.a(r3, r4);
    }

    public void startAuthManagePage(Activity r4, IApiCallback r5) {
        SLog.i("openSDK_LOG.Tencent", "startAuthManagePage");
        new QQAuthManage(this.a, getQQToken()).gotoManagePage(r4, r5);
    }

    private static void a(String r1, Object... r2) {
        String r3 = a(r2);
        b.a().a(r1, r3);
    }

    private static void a(String r1, Object r2) {
        b.a().a(r1, r2);
    }

    public static synchronized Tencent createInstance(String r5, Context r6, String r7) {
        monitor-enter(Tencent.class);
        Tencent r8 = createInstance(r5, r6);     // Catch: Throwable -> L10
        SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + r5 + ", authorities=" + r7);     // Catch: Throwable -> L10
        a("createInstance_authority", new Object[]{"appid", r5, "authorities", r7});     // Catch: Throwable -> L10
        if (r8 == null) goto L7;
        r8.b = r7;     // Catch: Throwable -> L10
    L8:
        monitor-exit(Tencent.class);
        return r8;
    L7:
        SLog.i("openSDK_LOG.Tencent", "null == tencent set mAuthorities fail");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void callCommonChannelApi(Activity r4, Bundle r5, IUiListener r6) {
        c r1 = this.a;
        SLog.i("openSDK_LOG.Tencent", "callCommonChannelApi ret: " + new CommonChannelApi(r1, r1.b()).launchQQ(r4, r5, r6));
    }

    public void joinQQGroup(Activity r4, String r5, IUiListener r6) {
        SLog.i("openSDK_LOG.Tencent", "joinQQGroup()");
        a("joinQQGroup", new Object[]{"organizationId", r5});
        new SocialOperation(getQQToken()).joinGroup(r4, r5, r6);
    }

    public int login(Fragment r4, String r5, IUiListener r6) {
        SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + r5);
        a("login_fragment_scope", new Object[]{"scope", r5});
        return this.a.a(r4, r5, r6, BuildConfig.FLAVOR);
    }

    public int loginServerSide(Fragment r5, String r6, IUiListener r7) {
        SLog.i("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + r6 + ",server_side");
        a("loginServerSide_fragment", new Object[]{"scope", r6});
        return this.a.a(r5, r6 + ",server_side", r7, BuildConfig.FLAVOR);
    }

    public void publishToQzone(Activity r3, Bundle r4, IUiListener r5) {
        SLog.i("openSDK_LOG.Tencent", "publishToQzone()");
        a("publishToQzone", new Object[0]);
        new QzonePublish(r3, this.a.b()).publishToQzone(r3, r4, r5);
    }

    public int reAuth(Activity r4, String r5, IUiListener r6) {
        SLog.i("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + r5);
        a("reAuth", new Object[]{"scope", r5});
        return this.a.b(r4, r5, r6);
    }

    public JSONObject request(String r4, Bundle r5, String r6) throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
        SLog.i("openSDK_LOG.Tencent", "request()");
        a("request", new Object[]{"graphPath", r4, "httpMethod", r6});
        return HttpUtils.request(this.a.b(), g.a(), r4, r5, r6);
    }

    public void setAvatar(Activity r4, Bundle r5, IUiListener r6) {
        SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        a("setAvatar", new Object[0]);
        String r0 = r5.getString("picture");
        int r7 = r5.getInt("exitAnim");
        new QQAvatar(this.a.b()).setAvatar(r4, UriProtector.parse(r0), r6, r7);
    }

    public void setAvatarByQQ(Activity r3, Uri r4, IUiListener r5) {
        SLog.i("openSDK_LOG.Tencent", "setAvatarByQQ()");
        a("setAvatarByQQ", new Object[0]);
        new QQAvatar(this.a.b()).setAvatarByQQ(r3, r4, r5);
    }

    public void setDynamicAvatar(Activity r3, Uri r4, IUiListener r5) {
        SLog.i("openSDK_LOG.Tencent", "setDynamicAvatar()");
        a("setDynamicAvatar", new Object[0]);
        new QQAvatar(this.a.b()).setDynamicAvatar(r3, r4, r5);
    }

    public void setEmotions(Activity r3, ArrayList<Uri> r4, IUiListener r5) {
        SLog.i("openSDK_LOG.Tencent", "saveQQEmotions()");
        a("setEmotions", new Object[0]);
        new QQEmotion(this.a.b()).setEmotions(r3, r4, r5);
    }

    public void shareToQQ(Activity r3, Bundle r4, IUiListener r5) {
        SLog.i("openSDK_LOG.Tencent", "shareToQQ()");
        a("shareToQQ", new Object[0]);
        if (TextUtils.isEmpty(this.b) == false) goto L5;
        r5.onWarning(-19);
    L5:
        new QQShare(r3, this.a.b()).shareToQQ(r3, r4, r5);
    }

    public void shareToQzone(Activity r3, Bundle r4, IUiListener r5) {
        SLog.i("openSDK_LOG.Tencent", "shareToQzone()");
        a("shareToQzone", new Object[0]);
        new QzoneShare(r3, this.a.b()).shareToQzone(r3, r4, r5);
    }

    public int startIMAio(Activity r4, String r5, String r6) {
        SLog.i("openSDK_LOG.Tencent", "startIMAio()");
        a("startIMAio", new Object[]{"uin", r5, "pkg_name", r6});
        return startIMConversation(r4, "thirdparty2c", r5, r6);
    }

    public int startIMAudio(Activity r4, String r5, String r6) {
        SLog.i("openSDK_LOG.Tencent", "startIMAudio()");
        a("startIMAudio", new Object[]{"uin", r5, "pkg_name", r6});
        return startIMConversation(r4, "audio_chat", r5, r6);
    }

    public int startIMVideo(Activity r4, String r5, String r6) {
        SLog.i("openSDK_LOG.Tencent", "startIMVideo()");
        a("startIMVideo", new Object[]{"uin", r5, "pkg_name", r6});
        return startIMConversation(r4, "video_chat", r5, r6);
    }

    public void unBindQQGroup(Context r4, String r5, IUiListener r6) {
        SLog.i("openSDK_LOG.Tencent", "unBindQQGroup()");
        a("unBindQQGroup", new Object[]{"organizationId", r5});
        new SocialOperation(getQQToken()).unBindGroup(r4, r5, r6);
    }

    public int login(Activity r4, String r5, IUiListener r6) {
        SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + r5);
        a("login_scope", new Object[]{"scope", r5});
        return this.a.a(r4, r5, r6);
    }

    public int loginServerSide(Activity r5, String r6, IUiListener r7) {
        SLog.i("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + r6 + ",server_side");
        a("loginServerSide_activity", new Object[]{"scope", r6});
        return this.a.a(r5, r6 + ",server_side", r7);
    }

    public int login(Activity r3, IUiListener r4, Map<String, Object> r5) {
        SLog.i("openSDK_LOG.Tencent", "login activity with params");
        a("login_param", new Object[0]);
        return this.a.a(r3, r4, r5);
    }

    public static boolean onActivityResultData(int r4, int r5, Intent r6, IUiListener r7) {
        StringBuilder r0 = new StringBuilder("onActivityResultData() reqcode = ");
        r0.append(r4);
        r0.append(", resultcode = ");
        r0.append(r5);
        r0.append(", data = null ? ");
        if (r6 != null) goto L5;
        boolean r3 = true;
    L6:
        r0.append(r3);
        r0.append(", listener = null ? ");
        if (r7 != null) goto L9;
        boolean r8 = true;
    L10:
        r0.append(r8);
        SLog.i("openSDK_LOG.Tencent", r0.toString());
        a("onActivityResultData", new Object[]{"requestCode", Integer.valueOf(r4), "resultCode", Integer.valueOf(r5)});
        return UIListenerManager.getInstance().onActivityResult(r4, r5, r6, r7);
    L9:
        r8 = false;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    public void bindQQGroup(Activity r4, String r5, String r6, IUiListener r7) {
        SLog.i("openSDK_LOG.Tencent", "bindQQGroup()");
        a("bindQQGroup", new Object[]{"organizationId", r5, "organizationName", r6});
        new SocialOperation(getQQToken()).bindQQGroup(r4, r5, r6, r7);
    }

    public int login(Fragment r9, String r10, IUiListener r11, boolean r12) {
        SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + r10);
        a("login_fragment_scope_qrcode", new Object[]{"scope", r10, "qrcode", Boolean.valueOf(r12)});
        return this.a.a(r9, r10, r11, BuildConfig.FLAVOR, r12);
    }

    public void requestAsync(String r8, Bundle r9, String r10, IRequestListener r11) {
        SLog.i("openSDK_LOG.Tencent", "requestAsync()");
        a("requestAsync", new Object[]{"graphPath", r8, "httpMethod", r10});
        HttpUtils.requestAsync(this.a.b(), g.a(), r8, r9, r10, r11);
    }

    public int startIMConversation(Activity r4, String r5, String r6, String r7) {
        a("startIMConversation", new Object[]{"chatType", r5, "uin", r6, "pkg_name", r7});
        return new IM(getQQToken()).startIMConversation(r4, r5, r6, r7);
    }

    public int startMiniApp(Activity r10, String r11, String r12, String r13) {
        SLog.i("openSDK_LOG.Tencent", "startMiniApp()");
        a("startMiniApp", new Object[]{"miniAppId", r11, "miniAppPath", r12, "miniAppVersion", r13});
        return new MiniApp(getQQToken()).startMiniApp(r10, "mini_program_or_game", r11, "21", r12, r13);
    }

    public int login(Activity r4, String r5, IUiListener r6, boolean r7) {
        SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + r5);
        a("login_qrcode", new Object[]{"scope", r5, "qrcode", Boolean.valueOf(r7)});
        return this.a.a(r4, r5, r6, r7);
    }

    public void setAvatar(Activity r4, Bundle r5, IUiListener r6, int r7, int r8) {
        SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        a("setAvatar_anim", new Object[0]);
        r5.putInt("exitAnim", r8);
        r4.overridePendingTransition(r7, 0);
        setAvatar(r4, r5, r6);
    }

    public int loginWithOEM(Activity r10, String r11, IUiListener r12, boolean r13, String r14, String r15, String r16) {
        SLog.i("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + r11);
        a("loginWithOEM", new Object[]{"scope", r11, "qrcode", Boolean.valueOf(r13), "registerChannel", r14, "installChannel", r15, "businessId", r16});
        return this.a.a(r10, r11, r12, r13, r14, r15, r16);
    }
}
