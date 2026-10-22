package com.obric.cae.smartNetwork.trafficMonitor;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.provider.Settings;
import com.obric.cae.log.CaeLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TrafficThreshold {
    private static final String GLOBAL_SETTINGS_TRAFFIC_10MIN_THRESHOLD = "traffic_threshold_10min";
    private static final String GLOBAL_SETTINGS_TRAFFIC_1MIN_THRESHOLD = "traffic_threshold_1min";
    private static final String GLOBAL_SETTINGS_TRAFFIC_2H_THRESHOLD = "traffic_threshold_2h";
    private static final String GLOBAL_SETTINGS_TRAFFIC_30MIN_THRESHOLD = "traffic_threshold_30min";
    private static final String GLOBAL_SETTINGS_TRAFFIC_5MIN_THRESHOLD = "traffic_threshold_5min";
    public static final String TAG = "TrafficThreshold";
    private static volatile TrafficThreshold instance;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private final SettingObserver mSettingObserver;
    private final List<Uri> mSettingUris;

    public class SettingObserver extends ContentObserver {
        final /* synthetic */ TrafficThreshold this$0;

        public SettingObserver(TrafficThreshold r8) {
            this.this$0 = r8;
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r8) {
            CaeLog.e(TrafficThreshold.TAG, "Should never be reached.");
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r8, Uri r10) {
            if (TrafficThreshold.access$000(this.this$0).contains(r10) == true) goto L5;
            CaeLog.e(TrafficThreshold.TAG, "Unexpected settings observation: " + r10);
        L5:
            CaeLog.d(TrafficThreshold.TAG, "onChange: " + r10);
        }
    }

    private TrafficThreshold(Context r8) {
        this.mContext = r8;
        this.mContentResolver = r8.getContentResolver();
        this.mSettingObserver = new SettingObserver(this);
        List<Uri> r10 = Arrays.asList(new Uri[]{Settings.Global.getUriFor(GLOBAL_SETTINGS_TRAFFIC_1MIN_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_TRAFFIC_5MIN_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_TRAFFIC_10MIN_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_TRAFFIC_30MIN_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_TRAFFIC_2H_THRESHOLD)});
        this.mSettingUris = r10;
        Iterator<Uri> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Uri r12 = r11.next();
        this.mContentResolver.registerContentObserver(r12, false, this.mSettingObserver);
        goto L4
    L6:
        dumpSettings();
    }

    public static /* synthetic */ List access$000(TrafficThreshold r8) {
        return r8.mSettingUris;
    }

    private void dumpSettings() {
        CaeLog.d(TAG, "Mobile Traffic Monitor Threshold { 1min=" + getTrafficThreshold(1) + "MB, 5min=" + getTrafficThreshold(2) + "MB, 10min=" + getTrafficThreshold(3) + "MB, 30min=" + getTrafficThreshold(4) + "MB, 2h=" + getTrafficThreshold(5) + "MB }");
    }

    public static TrafficThreshold getInstance(Context r8) {
        if (instance != null) goto L15;
        monitor-enter(TrafficThreshold.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new TrafficThreshold(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(TrafficThreshold.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private void setTrafficThreshold(int r8, int r10) {
        if (r8 != 1) goto L5;
        ContentResolver r11 = this.mContentResolver;
        String r12 = GLOBAL_SETTINGS_TRAFFIC_1MIN_THRESHOLD;
    L18:
        Settings.Global.putInt(r11, r12, r10);
        return;
    L5:
        if (r8 != 2) goto L7;
        r11 = this.mContentResolver;
        r12 = GLOBAL_SETTINGS_TRAFFIC_5MIN_THRESHOLD;
        goto L18
    L7:
        if (r8 != 3) goto L9;
        r11 = this.mContentResolver;
        r12 = GLOBAL_SETTINGS_TRAFFIC_10MIN_THRESHOLD;
        goto L18
    L9:
        if (r8 != 4) goto L11;
        r11 = this.mContentResolver;
        r12 = GLOBAL_SETTINGS_TRAFFIC_30MIN_THRESHOLD;
        goto L18
    L11:
        if (r8 == 5) goto L13;
        android.aimedia.a.p("setTrafficThreshold: unknown type ", r8, TAG);
        return;
    L13:
        r11 = this.mContentResolver;
        r12 = GLOBAL_SETTINGS_TRAFFIC_2H_THRESHOLD;
        goto L18
    }

    public int getTrafficThreshold(int r8) {
        if (r8 == 1) goto L23;
        if (r8 == 2) goto L21;
        if (r8 == 3) goto L19;
        if (r8 == 4) goto L17;
        if (r8 == 5) goto L15;
        android.aimedia.a.p("getTrafficThreshold: unknown type ", r8, TAG);
        return Integer.MAX_VALUE;
    L15:
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_TRAFFIC_2H_THRESHOLD, TrafficMonitorUtil.THRESHOLD_5GB);
    L17:
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_TRAFFIC_30MIN_THRESHOLD, TrafficMonitorUtil.THRESHOLD_3GB);
    L19:
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_TRAFFIC_10MIN_THRESHOLD, 2048);
    L21:
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_TRAFFIC_5MIN_THRESHOLD, 1024);
    L23:
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_TRAFFIC_1MIN_THRESHOLD, 500);
    }

    public void updateThreshold(String r8) {
        JSONObject r10 = new JSONObject(r8);     // Catch: JSONException -> L4
        setTrafficThreshold(5, r10.getInt(GLOBAL_SETTINGS_TRAFFIC_2H_THRESHOLD));     // Catch: JSONException -> L4
        setTrafficThreshold(2, r10.getInt(GLOBAL_SETTINGS_TRAFFIC_5MIN_THRESHOLD));     // Catch: JSONException -> L4
        setTrafficThreshold(3, r10.getInt(GLOBAL_SETTINGS_TRAFFIC_10MIN_THRESHOLD));     // Catch: JSONException -> L4
        setTrafficThreshold(4, r10.getInt(GLOBAL_SETTINGS_TRAFFIC_30MIN_THRESHOLD));     // Catch: JSONException -> L4
        setTrafficThreshold(1, r10.getInt(GLOBAL_SETTINGS_TRAFFIC_1MIN_THRESHOLD));     // Catch: JSONException -> L4
    L6:
        dumpSettings();
        return;
    L4:
        e = move-exception;
        CaeLog.e(TAG, "updateSettings: " + e.getMessage());
        goto L6
    }
}
