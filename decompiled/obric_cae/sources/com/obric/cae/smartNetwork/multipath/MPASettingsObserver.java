package com.obric.cae.smartNetwork.multipath;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.provider.Settings;
import com.obric.cae.log.CaeLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MPASettingsObserver {
    private static final int CELL_LTE_RSRP_THRESHOLD = -115;
    private static final int CELL_LTE_RSRQ_THRESHOLD = -13;
    private static final int CELL_NR_RSRP_THRESHOLD = -120;
    private static final int CELL_NR_RSRQ_THRESHOLD = -13;
    private static final int MAX_RTT_TIMES = 5;
    private static final int MAX_WIFI_QOE_TIMES = 5;
    private static final int RTT_GOOD_CONTINUE_TIMES = 3;
    private static final int RTT_GOOD_THRESHOLD = 100;
    private static final int RTT_MIDDLE_TOTAL_TIMES = 3;
    private static final int RTT_POOR_THRESHOLD = 200;
    public static final String SETTING_CELL_LTE_RSRP_THRESHOLD = "cell_lte_rsrp_threshold";
    public static final String SETTING_CELL_LTE_RSRQ_THRESHOLD = "cell_lte_rsrq_threshold";
    public static final String SETTING_CELL_NR_RSRP_THRESHOLD = "cell_nr_rsrp_threshold";
    public static final String SETTING_CELL_NR_RSRQ_THRESHOLD = "cell_nr_rsrq_threshold";
    public static final String SETTING_MAX_RTT_TIMES = "max_rtt_check_times";
    public static final String SETTING_MAX_WIFI_QOE_TIMES = "max_wifi_qoe_times";
    public static final String SETTING_RTT_GOOD_CONTINUE_TIMES = "rtt_good_continue_times";
    public static final String SETTING_RTT_GOOD_THRESHOLD = "rtt_good_threshold";
    public static final String SETTING_RTT_MIDDLE_TOTAL_TIMES = "rtt_middle_total_times";
    public static final String SETTING_RTT_POOR_THRESHOLD = "rtt_poor_threshold";
    public static final String SETTING_WIFI_QOE_GOOD_CONTINUE_TIMES = "wifi_qoe_good_continue_times";
    public static final String SETTING_WLAN_24G_TPUT_GOOD_THRESHOLD = "wlan_24g_tput_good_threshold";
    public static final String SETTING_WLAN_24G_TPUT_POOR_THRESHOLD = "wlan_24g_tput_poor_threshold";
    public static final String SETTING_WLAN_5G_TPUT_GOOD_THRESHOLD = "wlan_5g_tput_good_threshold";
    public static final String SETTING_WLAN_5G_TPUT_POOR_THRESHOLD = "wlan_5g_tput_poor_threshold";
    private static final String TAG = "MPASettingsObserver";
    private static final int WIFI_QOE_GOOD_CONTINUE_TIMES = 3;
    private static final int WLAN_24G_TPUT_GOOD_THRESHOLD = 120;
    private static final int WLAN_24G_TPUT_POOR_THRESHOLD = 70;
    private static final int WLAN_5G_TPUT_GOOD_THRESHOLD = 120;
    private static final int WLAN_5G_TPUT_POOR_THRESHOLD = 70;
    private static volatile MPASettingsObserver sInstance;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private final SettingObserver mSettingObserver;
    private final List<Uri> mSettingUris;

    public class SettingObserver extends ContentObserver {
        final /* synthetic */ MPASettingsObserver this$0;

        public SettingObserver(MPASettingsObserver r8) {
            this.this$0 = r8;
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r8) {
            CaeLog.e(MPASettingsObserver.access$000(), "Should never be reached.");
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r8, Uri r10) {
            if (MPASettingsObserver.access$100(this.this$0).contains(r10) == true) goto L5;
            CaeLog.e(MPASettingsObserver.access$000(), "Unexpected settings observation: " + r10);
        L5:
            CaeLog.d(MPASettingsObserver.access$000(), "onChange: " + r10);
            this.this$0.dumpSettings();
        }
    }

    private MPASettingsObserver(Context r18) {
        this.mContext = r18;
        this.mContentResolver = r18.getContentResolver();
        this.mSettingUris = Arrays.asList(new Uri[]{Settings.Global.getUriFor(SETTING_MAX_RTT_TIMES), Settings.Global.getUriFor(SETTING_RTT_GOOD_CONTINUE_TIMES), Settings.Global.getUriFor(SETTING_RTT_MIDDLE_TOTAL_TIMES), Settings.Global.getUriFor(SETTING_MAX_WIFI_QOE_TIMES), Settings.Global.getUriFor(SETTING_WIFI_QOE_GOOD_CONTINUE_TIMES), Settings.Global.getUriFor(SETTING_RTT_POOR_THRESHOLD), Settings.Global.getUriFor(SETTING_RTT_GOOD_THRESHOLD), Settings.Global.getUriFor(SETTING_WLAN_24G_TPUT_POOR_THRESHOLD), Settings.Global.getUriFor(SETTING_WLAN_5G_TPUT_POOR_THRESHOLD), Settings.Global.getUriFor(SETTING_WLAN_24G_TPUT_GOOD_THRESHOLD), Settings.Global.getUriFor(SETTING_WLAN_5G_TPUT_GOOD_THRESHOLD), Settings.Global.getUriFor(SETTING_CELL_NR_RSRP_THRESHOLD), Settings.Global.getUriFor(SETTING_CELL_NR_RSRQ_THRESHOLD), Settings.Global.getUriFor(SETTING_CELL_LTE_RSRP_THRESHOLD), Settings.Global.getUriFor(SETTING_CELL_LTE_RSRQ_THRESHOLD)});
        this.mSettingObserver = new SettingObserver(this);
        startObserver();
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ List access$100(MPASettingsObserver r8) {
        return r8.mSettingUris;
    }

    public static MPASettingsObserver getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(MPASettingsObserver.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new MPASettingsObserver(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(MPASettingsObserver.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void setCellLteRSRPThreshold(int r8) {
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTING_CELL_LTE_RSRP_THRESHOLD, r8);
    }

    private void setCellLteRSRQThreshold(int r8) {
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTING_CELL_LTE_RSRQ_THRESHOLD, r8);
    }

    private void setCellNrRSRPThreshold(int r8) {
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTING_CELL_NR_RSRP_THRESHOLD, r8);
    }

    private void setCellNrRSRQThreshold(int r8) {
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTING_CELL_NR_RSRQ_THRESHOLD, r8);
    }

    private void setMaxRTTTimes(int r8) {
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTING_MAX_RTT_TIMES, r8);
    }

    private void setMaxWifiQOETimes(int r8) {
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTING_MAX_WIFI_QOE_TIMES, r8);
    }

    private void setRTTGoodContinueTimes(int r8) {
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTING_RTT_GOOD_CONTINUE_TIMES, r8);
    }

    private void setRTTGoodThreshold(int r8) {
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTING_RTT_GOOD_THRESHOLD, r8);
    }

    private void setRTTMiddleTotalTimes(int r8) {
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTING_RTT_MIDDLE_TOTAL_TIMES, r8);
    }

    private void setRTTPoorThreshold(int r8) {
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTING_RTT_POOR_THRESHOLD, r8);
    }

    private void setWLAN24GTputGoodThreshold(int r8) {
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTING_WLAN_24G_TPUT_GOOD_THRESHOLD, r8);
    }

    private void setWLAN24GTputPoorThreshold(int r8) {
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTING_WLAN_24G_TPUT_POOR_THRESHOLD, r8);
    }

    private void setWLAN5GTputGoodThreshold(int r8) {
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTING_WLAN_5G_TPUT_GOOD_THRESHOLD, r8);
    }

    private void setWLAN5GTputPoorThreshold(int r8) {
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTING_WLAN_5G_TPUT_POOR_THRESHOLD, r8);
    }

    private void setWifiQOEGoodContinueTimes(int r8) {
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTING_WIFI_QOE_GOOD_CONTINUE_TIMES, r8);
    }

    private void startObserver() {
        Iterator<Uri> r8 = this.mSettingUris.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Uri r10 = r8.next();
        this.mContentResolver.registerContentObserver(r10, false, this.mSettingObserver);
        goto L4
    }

    private void stopObserver() {
        this.mContentResolver.unregisterContentObserver(this.mSettingObserver);
    }

    public void dumpSettings() {
        CaeLog.d(TAG, "dumpSettings: maxRTTTimes=" + getMaxRTTTimes() + ", rttGoodContinueTimes=" + getRTTGoodContinueTimes() + ", rttMiddleTotalTimes=" + getRTTMiddleTotalTimes() + ", maxWifiQOETimes=" + getMaxWifiQOETimes() + ", wifiQOEGoodContinueTimes=" + getWifiQOEGoodContinueTimes() + ", rttPoorThreshold=" + getRTTPoorThreshold() + ", rttGoodThreshold=" + getRTTGoodThreshold() + ", wlan24GTputPoorThreshold=" + getWLAN24GTputPoorThreshold() + ", wlan5GTputPoorThreshold=" + getWLAN5GTputPoorThreshold() + ", wlan24GTputGoodThreshold=" + getWLAN24GTputGoodThreshold() + ", wlan5GTputGoodThreshold=" + getWLAN5GTputGoodThreshold() + ", cellNRRSRPThreshold=" + getCellNrRSRPThreshold() + ", cellNRRSRQThreshold=" + getCellNrRSRQThreshold() + ", cellLTERSRPThreshold=" + getCellLteRSRPThreshold() + ", cellLTERSRQThreshold=" + getCellLteRSRQThreshold());
    }

    public int getCellLteRSRPThreshold() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), SETTING_CELL_LTE_RSRP_THRESHOLD, -115);
    }

    public int getCellLteRSRQThreshold() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), SETTING_CELL_LTE_RSRQ_THRESHOLD, -13);
    }

    public int getCellNrRSRPThreshold() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), SETTING_CELL_NR_RSRP_THRESHOLD, -120);
    }

    public int getCellNrRSRQThreshold() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), SETTING_CELL_NR_RSRQ_THRESHOLD, -13);
    }

    public int getMaxRTTTimes() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), SETTING_MAX_RTT_TIMES, 5);
    }

    public int getMaxWifiQOETimes() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), SETTING_MAX_WIFI_QOE_TIMES, 5);
    }

    public int getRTTGoodContinueTimes() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), SETTING_RTT_GOOD_CONTINUE_TIMES, 3);
    }

    public int getRTTGoodThreshold() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), SETTING_RTT_GOOD_THRESHOLD, 100);
    }

    public int getRTTMiddleTotalTimes() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), SETTING_RTT_MIDDLE_TOTAL_TIMES, 3);
    }

    public int getRTTPoorThreshold() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), SETTING_RTT_POOR_THRESHOLD, 200);
    }

    public int getWLAN24GTputGoodThreshold() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), SETTING_WLAN_24G_TPUT_GOOD_THRESHOLD, 120);
    }

    public int getWLAN24GTputPoorThreshold() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), SETTING_WLAN_24G_TPUT_POOR_THRESHOLD, 70);
    }

    public int getWLAN5GTputGoodThreshold() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), SETTING_WLAN_5G_TPUT_GOOD_THRESHOLD, 120);
    }

    public int getWLAN5GTputPoorThreshold() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), SETTING_WLAN_5G_TPUT_POOR_THRESHOLD, 70);
    }

    public int getWifiQOEGoodContinueTimes() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), SETTING_WIFI_QOE_GOOD_CONTINUE_TIMES, 3);
    }

    public void updateMPASettings(String r8) {
        JSONObject r10 = new JSONObject(r8);     // Catch: Exception -> L4
        setMaxRTTTimes(r10.getInt(SETTING_MAX_RTT_TIMES));     // Catch: Exception -> L4
        setRTTGoodContinueTimes(r10.getInt(SETTING_RTT_GOOD_CONTINUE_TIMES));     // Catch: Exception -> L4
        setRTTMiddleTotalTimes(r10.getInt(SETTING_RTT_MIDDLE_TOTAL_TIMES));     // Catch: Exception -> L4
        setMaxWifiQOETimes(r10.getInt(SETTING_MAX_WIFI_QOE_TIMES));     // Catch: Exception -> L4
        setWifiQOEGoodContinueTimes(r10.getInt(SETTING_WIFI_QOE_GOOD_CONTINUE_TIMES));     // Catch: Exception -> L4
        setRTTPoorThreshold(r10.getInt(SETTING_RTT_POOR_THRESHOLD));     // Catch: Exception -> L4
        setRTTGoodThreshold(r10.getInt(SETTING_RTT_GOOD_THRESHOLD));     // Catch: Exception -> L4
        setWLAN24GTputPoorThreshold(r10.getInt(SETTING_WLAN_24G_TPUT_POOR_THRESHOLD));     // Catch: Exception -> L4
        setWLAN5GTputPoorThreshold(r10.getInt(SETTING_WLAN_5G_TPUT_POOR_THRESHOLD));     // Catch: Exception -> L4
        setWLAN24GTputGoodThreshold(r10.getInt(SETTING_WLAN_24G_TPUT_GOOD_THRESHOLD));     // Catch: Exception -> L4
        setWLAN5GTputGoodThreshold(r10.getInt(SETTING_WLAN_5G_TPUT_GOOD_THRESHOLD));     // Catch: Exception -> L4
        setCellNrRSRPThreshold(r10.getInt(SETTING_CELL_NR_RSRP_THRESHOLD));     // Catch: Exception -> L4
        setCellNrRSRQThreshold(r10.getInt(SETTING_CELL_NR_RSRQ_THRESHOLD));     // Catch: Exception -> L4
        setCellLteRSRPThreshold(r10.getInt(SETTING_CELL_LTE_RSRP_THRESHOLD));     // Catch: Exception -> L4
        setCellLteRSRQThreshold(r10.getInt(SETTING_CELL_LTE_RSRQ_THRESHOLD));     // Catch: Exception -> L4
    L6:
        dumpSettings();
        return;
    L4:
        e = move-exception;
        String r11 = TAG;
        defpackage.b.k(e, new StringBuilder("updateMPASettings error: "), r11);
        goto L6
    }
}
