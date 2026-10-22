package com.ss.android.lark.chameleon.container.webcontainer.report;

import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.idependency.StatisticService;
import com.ss.android.lark.chameleon.util.AppInfoUtils;
import com.ss.android.lark.chameleon.util.NetworkCheck;
import com.ss.android.lark.chameleon.util.NetworkType;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonReport;", BuildConfig.FLAVOR, "()V", "Chameleon_DEV_DOWNLOAD_DURATION", BuildConfig.FLAVOR, "TAG", "reportChameleonDownload", BuildConfig.FLAVOR, "appName", "channel", "duration", BuildConfig.FLAVOR, ChameleonOpenTracker.OpenResult.SUCCESS, BuildConfig.FLAVOR, "msg", "trackEventExt", "eventName", "param", "Lorg/json/JSONObject;", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonReport {
    private static final String Chameleon_DEV_DOWNLOAD_DURATION = "Chameleon_gecko_download_duration_dev";
    public static final ChameleonReport INSTANCE = null;
    public static final String TAG = "CML_TAG_ChameleonReport";

    static {
        INSTANCE = new ChameleonReport();
    }

    private ChameleonReport() {
    }

    public final void trackEventExt(String r3, JSONObject r4) {
        if (AppInfoUtils.isApkInDebug(Env.getApplication()) == false) goto L5;
        Log.d(TAG, "trackEventExt, eventName = " + r3 + " param is " + r4);
        return;
    L5:
        if (r3 == null) goto L10;
        if (r4 == null) goto L11;
        StatisticService.sendEvent(r3, r4);
        return;
    L11:
        return;
    }

    public final void reportChameleonDownload(String r6, String r7, long r8, boolean r10, String r11) {
        JSONObject r2 = new JSONObject();
        NetworkType r3 = NetworkCheck.getNetworkState(Env.getApplication());
        r2.put("duration_ms", r8);     // Catch: JSONException -> L15
        if (r6 != null) goto L7;
        r6 = BuildConfig.FLAVOR;
    L7:
        r2.put(ChameleonOpenTracker.ParamKey.APP_NAME, r6);     // Catch: JSONException -> L15
        r2.put("is_success", r10);     // Catch: JSONException -> L15
        if (r11 != null) goto L10;
        r11 = BuildConfig.FLAVOR;
    L10:
        r2.put(ChameleonOpenTracker.ParamKey.ERRORMSG, r11);     // Catch: JSONException -> L15
        if (r7 != null) goto L13;
        r7 = BuildConfig.FLAVOR;
    L13:
        r2.put("channel", r7);     // Catch: JSONException -> L15
        r2.put("downloader", "gecko");     // Catch: JSONException -> L15
        r2.put("network_status", r3);     // Catch: JSONException -> L15
        Log.d(TAG, "reportChameleonDownload, params = " + r2);     // Catch: JSONException -> L15
    L17:
        trackEventExt(Chameleon_DEV_DOWNLOAD_DURATION, r2);
        return;
    L15:
        e = move-exception;
        Log.e(TAG, "reportChameleonDownload failed", e);
        goto L17
    }
}
