package com.bytedance.crash;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static MonitorCrash f4054b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MonitorCrash f4055a;

    public j(MonitorCrash r5) {
        this.f4055a = r5;
        z8.d.f23418a.add(this);
        o9.a.a();
        l9.o.e().c(com.bytedance.crash.upload.b.f4096h, 0);
    }

    public final String a() {
        return this.f4055a.mConfig.mAid;
    }

    public final JSONObject b(CrashType r5) {
        MonitorCrash r10 = this.f4055a;
        JSONObject r11 = new JSONObject();
        r11.put("header", c());     // Catch: Throwable -> L15
        if (r5 == null) goto L13;
        AttachUserData r12 = r10.mCustomData;     // Catch: Throwable -> L15
        if (r12 == null) goto L11;
        Map<? extends String, ? extends String> r13 = r12.getUserData(r5);     // Catch: Throwable -> L15
        if (r13 == null) goto L11;
        JSONObject r14 = new JSONObject(r13);     // Catch: Throwable -> L15
    L12:
        r11.put("custom", r14);     // Catch: Throwable -> L15
        r11.put("filters", new JSONObject(r10.mTagMap));     // Catch: Throwable -> L15
    L11:
        r14 = null;
    L13:
        r11.put("line_num", null);     // Catch: Throwable -> L15
    L14:
        return r11;
    }

    public final JSONObject c() {
        MonitorCrash r10 = this.f4055a;
        JSONObject r5 = new JSONObject();
        if (r10.mConfig.mPackageName != null) goto L14;
        Context r11 = n.f4057a;     // Catch: Throwable -> L28
        PackageInfo r12 = r11.getPackageManager().getPackageInfo(r11.getPackageName(), 128);     // Catch: Throwable -> L28
        if (r12 == null) goto L14;
        MonitorCrash.Config r13 = r10.mConfig;     // Catch: Throwable -> L28
        if (r13.mVersionInt != (-1)) goto L11;
        r13.mVersionInt = r12.versionCode;     // Catch: Throwable -> L28
    L11:
        if (r13.mVersionStr != null) goto L14;
        r13.mVersionStr = r12.versionName;     // Catch: Throwable -> L28
    L14:
        if (TextUtils.isEmpty(r10.mConfig.mDeviceId) == false) goto L31;
        r10.mConfig.mDeviceId = n.g().e();
    L31:
        r5.put(WsConstants.KEY_APP_ID, String.valueOf(r10.mConfig.mAid));     // Catch: JSONException -> L21
        r5.put("update_version_code", r10.mConfig.mVersionInt);     // Catch: JSONException -> L21
        r5.put("version_code", r10.mConfig.mVersionInt);     // Catch: JSONException -> L21
        r5.put("app_version", r10.mConfig.mVersionStr);     // Catch: JSONException -> L21
        r5.put(LynxMonitorService.KEY_CHANNEL, r10.mConfig.mChannel);     // Catch: JSONException -> L21
        r5.put("package", r10.mConfig.mPackageName);     // Catch: JSONException -> L21
        r5.put(WsConstants.KEY_DEVICE_ID, r10.mConfig.mDeviceId);     // Catch: JSONException -> L21
        r5.put("user_id", r10.mConfig.mUID);     // Catch: JSONException -> L21
        r5.put("os", "Android");     // Catch: JSONException -> L21
        if (r10.mConfig.mSoList == null) goto L24;
        JSONArray r14 = new JSONArray();     // Catch: JSONException -> L21
        String[] r15 = r10.mConfig.mSoList;     // Catch: JSONException -> L21
        int r16 = r15.length;     // Catch: JSONException -> L21
        int r17 = 0;
    L19:
        if (r17 >= r16) goto L23;
        r14.put(r15[r17]);     // Catch: JSONException -> L21
        r17 = r17 + 1;     // Catch: JSONException -> L21
        goto L19
    L23:
        r5.put("so_list", r14);     // Catch: JSONException -> L21
    L24:
        r5.put("single_upload", 0);     // Catch: JSONException -> L21
    L27:
        return r5;
    L21:
        e = move-exception;
        io.reactivex.exceptions.a.f(e);
        goto L27
    }

    public final JSONObject d(CrashType r5) {
        MonitorCrash r10 = this.f4055a;
        JSONObject r11 = new JSONObject();
        r11.put("header", c());     // Catch: Throwable -> L14
        if (r5 == null) goto L13;
        AttachUserData r12 = r10.mCustomData;     // Catch: Throwable -> L14
        if (r12 == null) goto L11;
        Map<? extends String, ? extends String> r13 = r12.getUserData(r5);     // Catch: Throwable -> L14
        if (r13 == null) goto L11;
        JSONObject r14 = new JSONObject(r13);     // Catch: Throwable -> L14
    L12:
        r11.put("custom", r14);     // Catch: Throwable -> L14
        r11.put("filters", new JSONObject(r10.mTagMap));     // Catch: Throwable -> L14
    L11:
        r14 = null;
    L13:
        return r11;
    }
}
