package com.obric.cae.smartNetwork.qoe;

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
public class CellularQoeEvaluateObserver {
    public static final String CLOUD_CONFIG_CELLUAR_QOE_EVALUATE_SETTINGS = "cellular_qoe_evaluate_settings";
    private static final String GLOBAL_SETTINGS_PDCP_UP_LOSS_RATAE_HIGH_THRESHOLD = "pdcp_up_loss_rate_high_threshold";
    private static final String GLOBAL_SETTINGS_PDCP_UP_LOSS_RATAE_LOW_THRESHOLD = "pdcp_up_loss_rate_low_threshold";
    private static final String GLOBAL_SETTINGS_PDCP_UP_THROUGHPUT_THRESHOLD = "pdcp_up_throughput_threshold";
    private static final int PDCP_UP_LOSS_RATAE_HIGH_THRESHOLD = 20;
    private static final int PDCP_UP_LOSS_RATAE_LOW_THRESHOLD = 10;
    private static final int PDCP_UP_THROUGHPUT_THRESHOLD = 1250000;
    private static final String TAG = "CellularQoeEvaluateObserver";
    private static volatile CellularQoeEvaluateObserver instance;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private final SettingsObserver mSettingObserver;
    private final List<Uri> mSettingUris;

    public class SettingsObserver extends ContentObserver {
        final /* synthetic */ CellularQoeEvaluateObserver this$0;

        public SettingsObserver(CellularQoeEvaluateObserver r8) {
            this.this$0 = r8;
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r8, Uri r10) {
            if (CellularQoeEvaluateObserver.access$000(this.this$0).contains(r10) == true) goto L5;
            CaeLog.e(CellularQoeEvaluateObserver.access$100(), "Unexpected settings observation: " + r10);
        L5:
            CaeLog.d(CellularQoeEvaluateObserver.access$100(), "Configuration changed: " + r10);
        }
    }

    private CellularQoeEvaluateObserver(Context r8) {
        Context r10 = r8.getApplicationContext();
        this.mContext = r10;
        this.mContentResolver = r10.getContentResolver();
        this.mSettingObserver = new SettingsObserver(this);
        List<Uri> r11 = Arrays.asList(new Uri[]{Settings.Global.getUriFor(CLOUD_CONFIG_CELLUAR_QOE_EVALUATE_SETTINGS), Settings.Global.getUriFor(GLOBAL_SETTINGS_PDCP_UP_THROUGHPUT_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_PDCP_UP_LOSS_RATAE_HIGH_THRESHOLD)});
        this.mSettingUris = r11;
        Iterator<Uri> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Uri r13 = r12.next();
        this.mContentResolver.registerContentObserver(r13, false, this.mSettingObserver);
        goto L4
    L6:
        dumpSettings();
    }

    public static /* synthetic */ List access$000(CellularQoeEvaluateObserver r8) {
        return r8.mSettingUris;
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static CellularQoeEvaluateObserver getInstance(Context r8) {
        if (instance != null) goto L15;
        monitor-enter(CellularQoeEvaluateObserver.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new CellularQoeEvaluateObserver(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CellularQoeEvaluateObserver.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public void dumpSettings() {
        String r8 = TAG;
        CaeLog.d(r8, "dumpSettings: ");
        CaeLog.d(r8, "pdcp_up_throughput_threshold=" + getPdcpUpThroughputThreshold());
        CaeLog.d(r8, "pdcp_up_loss_rate_high_threshold=" + getPdcpUpLossRateHighThreshold());
        CaeLog.d(r8, "pdcp_up_loss_rate_low_threshold=" + getPdcpUpLossRateLowThreshold());
    }

    public int getPdcpUpLossRateHighThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_PDCP_UP_LOSS_RATAE_HIGH_THRESHOLD, 20);
    }

    public int getPdcpUpLossRateLowThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_PDCP_UP_LOSS_RATAE_LOW_THRESHOLD, 10);
    }

    public int getPdcpUpThroughputThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_PDCP_UP_THROUGHPUT_THRESHOLD, PDCP_UP_THROUGHPUT_THRESHOLD);
    }

    public void setPdcpUpLossRateHighThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_PDCP_UP_LOSS_RATAE_HIGH_THRESHOLD, r8);
    }

    public void setPdcpUpLossRateLowThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_PDCP_UP_LOSS_RATAE_LOW_THRESHOLD, r8);
    }

    public void setPdcpUpThroughputThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_PDCP_UP_THROUGHPUT_THRESHOLD, r8);
    }

    public void updateSettings(String r8) {
        JSONObject r10 = new JSONObject(r8);     // Catch: JSONException -> L4
        setPdcpUpThroughputThreshold(r10.optInt(GLOBAL_SETTINGS_PDCP_UP_THROUGHPUT_THRESHOLD, PDCP_UP_THROUGHPUT_THRESHOLD));     // Catch: JSONException -> L4
        setPdcpUpLossRateHighThreshold(r10.optInt(GLOBAL_SETTINGS_PDCP_UP_LOSS_RATAE_HIGH_THRESHOLD, 20));     // Catch: JSONException -> L4
        setPdcpUpLossRateLowThreshold(r10.optInt(GLOBAL_SETTINGS_PDCP_UP_LOSS_RATAE_LOW_THRESHOLD, 10));     // Catch: JSONException -> L4
    L6:
        dumpSettings();
        return;
    L4:
        e = move-exception;
        CaeLog.e(TAG, "Invalid JSON config: " + e.getMessage());
        goto L6
    }
}
