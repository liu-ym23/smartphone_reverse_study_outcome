package com.obric.cae.smartNetwork.L4NetEvaluate;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.provider.Settings;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.NetworkAccelerate.VipStrategyReport;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class L4NetEvaluateObserver {
    public static final String CLOUD_CONFIG_L4NET_EVALUATE_SETTINGS = "l4net_evaluate_settings";
    private static final int FOREGROUND_APP_NO_DOWNLOAD_ERR_TIMES_THRESHOLD = 3;
    private static final int FOREGROUND_APP_NO_DOWNLOAD_ERR_TIME_PERIOD = 6;
    private static final String GLOBAL_SETTINGS_ACCELERATE_APP_WHITELIST = "accelerate_app_whitelist";
    private static final String GLOBAL_SETTINGS_FOREGROUND_APP_NO_DOWNLOAD_ERR_TIMES_THRESHOLD = "foreground_app_no_download_err_times_threshold";
    private static final String GLOBAL_SETTINGS_FOREGROUND_APP_NO_DOWNLOAD_ERR_TIME_PERIOD = "foreground_app_no_download_err_time_period";
    private static final String GLOBAL_SETTINGS_IGNORE_DOWNLOAD_ERR_THROUGHPUT_THRESHOLD = "ignore_download_err_throughput_threshold";
    private static final String GLOBAL_SETTINGS_IGNORE_ERR_THROUGHPUT_THRESHOLD = "ignore_err_throughput_threshold";
    private static final String GLOBAL_SETTINGS_NO_DOWNLOAD_ERR_TIMES_THRESHOLD = "no_download_err_times_threshold";
    private static final String GLOBAL_SETTINGS_NO_DOWNLOAD_ERR_TIME_PERIOD = "no_download_err_time_period";
    private static final String GLOBAL_SETTINGS_QOS_BAD_ERR_RECV_RETRANS_THRESHOLD = "qos_bad_err_recv_retrans_threshold";
    private static final String GLOBAL_SETTINGS_QOS_BAD_ERR_RTT_THRESHOLD = "qos_bad_err_rtt_threshold";
    private static final String GLOBAL_SETTINGS_QOS_BAD_ERR_SEND_RETRANS_THRESHOLD = "qos_bad_err_send_retrans_threshold";
    private static final String GLOBAL_SETTINGS_QOS_BAD_ERR_TIMES_THRESHOLD = "qos_bad_err_times_threshold";
    private static final String GLOBAL_SETTINGS_QOS_BAD_ERR_TIME_PERIOD = "qos_bad_err_time_period";
    private static final String GLOBAL_SETTINGS_QOS_BAD_ERR_TX_RX_PKT_NUM_THRESHOLD = "qos_bad_err_tx_rx_pkt_num_threshold";
    private static final String GLOBAL_SETTINGS_RETRANS_ERR_HIGH_PKT_NUM_THRESHOLD = "retrans_err_high_pkt_num_threshold";
    private static final String GLOBAL_SETTINGS_RETRANS_ERR_HIGH_RETRANS_THRESHOLD = "retrans_err_high_retrans_threshold";
    private static final String GLOBAL_SETTINGS_RETRANS_ERR_LOW_PKT_NUM_THRESHOLD = "retrans_err_low_pkt_num_threshold";
    private static final String GLOBAL_SETTINGS_RETRANS_ERR_LOW_RETRANS_THRESHOLD = "retrans_err_low_retrans_threshold";
    private static final String GLOBAL_SETTINGS_RETRANS_ERR_RX_HIGH_RETRANS_THRESHOLD = "retrans_err_rx_high_retrans_threshold";
    private static final String GLOBAL_SETTINGS_RETRANS_ERR_RX_LOW_RETRANS_THRESHOLD = "retrans_err_rx_low_retrans_threshold";
    private static final String GLOBAL_SETTINGS_RETRANS_ERR_TIMES_THRESHOLD = "retrans_err_times_threshold";
    private static final String GLOBAL_SETTINGS_RETRANS_ERR_TIME_PERIOD = "retrans_err_time_period";
    private static final String GLOBAL_SETTINGS_RTT_ERR_RATE_THRESHOLD = "rtt_err_rate_threshold";
    private static final String GLOBAL_SETTINGS_RTT_ERR_RTT_THRESHOLD = "rtt_err_rtt_threshold";
    private static final String GLOBAL_SETTINGS_TICKET_GRABBING_WHITE_LIST = "ticket_grabbing_white_list";
    private static final String GLOBAL_SETTINGS_UP_RETRANS_ERR_SEND_RETRANS_THRESHOLD = "up_retrans_err_send_retrans_threshold";
    private static final String GLOBAL_SETTINGS_UP_RETRANS_ERR_TIMES_THRESHOLD = "up_retrans_err_times_threshold";
    private static final String GLOBAL_SETTINGS_UP_RETRANS_ERR_TIME_PERIOD = "up_retrans_err_time_period";
    private static final String GLOBAL_SETTINGS_UP_RETRANS_ERR_TX_RX_PKT_NUM_THRESHOLD = "up_retrans_err_tx_rx_pkt_num_threshold";
    private static final String GLOBAL_SETTINGS_UP_RETRANS_ERR_UNACKED_THRESHOLD = "up_retrans_err_unacked_threshold";
    private static final String GLOBAL_SETTINGS_VIP_NETWORK_ENABLE = "vip_network_enable";
    private static final String GLOBAL_SETTINGS_VIP_STRATEGY_BLACK_LIST = "black_list";
    private static final String GLOBAL_SETTINGS_WHITE_LIST = "white_list";
    private static final String GLOBAL_SETTINGS_WIFI_MSC_SET_VALUE = "wifi_msc_set_value";
    private static final int IGNORE_DOWNLOAD_ERR_THROUGHPUT_THRESHOLD = 102400;
    private static final int IGNORE_ERR_THROUGHPUT_THRESHOLD = 2097152;
    private static final int NO_DOWNLOAD_ERR_TIMES_THRESHOLD = 4;
    private static final int NO_DOWNLOAD_ERR_TIME_PERIOD = 8;
    private static final int QOS_BAD_ERR_RECV_RETRANS_THRESHOLD = 50;
    private static final int QOS_BAD_ERR_RTT_THRESHOLD = 750;
    private static final int QOS_BAD_ERR_SEND_RETRANS_THRESHOLD = 30;
    private static final int QOS_BAD_ERR_TIMES_THRESHOLD = 3;
    private static final int QOS_BAD_ERR_TIME_PERIOD = 3;
    private static final int QOS_BAD_ERR_TX_RX_PKT_NUM_THRESHOLD = 10;
    private static final int RETRANS_ERR_HIGH_PKT_NUM_THRESHOLD = 20;
    private static final int RETRANS_ERR_HIGH_RETRANS_THRESHOLD = 50;
    private static final int RETRANS_ERR_LOW_PKT_NUM_THRESHOLD = 10;
    private static final int RETRANS_ERR_LOW_RETRANS_THRESHOLD = 20;
    private static final int RETRANS_ERR_RX_HIGH_RETRANS_THRESHOLD = 70;
    private static final int RETRANS_ERR_RX_LOW_RETRANS_THRESHOLD = 50;
    private static final int RETRANS_ERR_TIMES_THRESHOLD = 3;
    private static final int RETRANS_ERR_TIME_PERIOD = 5;
    private static final int RTT_ERR_RATE_THRESHOLD = 128000;
    private static final int RTT_ERR_RTT_THRESHOLD = 700;
    private static final String TAG = "L4NetEvaluateObserver";
    private static final String TICKET_GRABBING_WHITE_LIST = "[\"cn.damai\",\"com.MobileTicket\",]";
    private static final int UP_RETRANS_ERR_SEND_RETRANS_THRESHOLD = 10;
    private static final int UP_RETRANS_ERR_TIMES_THRESHOLD = 3;
    private static final int UP_RETRANS_ERR_TIME_PERIOD = 3;
    private static final int UP_RETRANS_ERR_TX_RX_PKT_NUM_THRESHOLD = 10;
    private static final int UP_RETRANS_ERR_UNACKED_THRESHOLD = 12;
    private static final String VIP_STRATEGY_BLACK_LIST = "[\"com.baidu.netdisk\",\"com.xunlei.downloadprovider\"]";
    private static final String VIP_STRATEGY_SETTINGS_KEY = "vip_strategy_settings";
    private static final String WHITE_LIST = "[\"com.ss.android.ugc.aweme\",\"com.ss.android.lark\",\"com.ss.android.article.news\",\"com.larus.nova\",\"com.ss.android.article.video\",\"com.ss.android.auto\",\"com.luna.music\",\"com.tencent.mm\",\"com.qiyi.video\",\"com.dianping.v1\",\"com.autonavi.minimap\",\"ctrip.android.view\",\"cn.damai\",\"com.MobileTicket\",]";
    private static volatile L4NetEvaluateObserver instance;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private final SettingsObserver mSettingObserver;
    private final List<Uri> mSettingUris;

    public class SettingsObserver extends ContentObserver {
        final /* synthetic */ L4NetEvaluateObserver this$0;

        public SettingsObserver(L4NetEvaluateObserver r8) {
            this.this$0 = r8;
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r8, Uri r10) {
            if (L4NetEvaluateObserver.access$000(this.this$0).contains(r10) == true) goto L5;
            CaeLog.e(L4NetEvaluateObserver.access$100(), "Unexpected settings observation: " + r10);
        L5:
            CaeLog.d(L4NetEvaluateObserver.access$100(), "Configuration changed: " + r10);
        }
    }

    private L4NetEvaluateObserver(Context r35) {
        Context r8 = r35.getApplicationContext();
        this.mContext = r8;
        this.mContentResolver = r8.getContentResolver();
        this.mSettingObserver = new SettingsObserver(this);
        List<Uri> r10 = Arrays.asList(new Uri[]{Settings.Global.getUriFor(GLOBAL_SETTINGS_UP_RETRANS_ERR_TIME_PERIOD), Settings.Global.getUriFor(GLOBAL_SETTINGS_UP_RETRANS_ERR_TIMES_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_UP_RETRANS_ERR_SEND_RETRANS_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_UP_RETRANS_ERR_TX_RX_PKT_NUM_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_UP_RETRANS_ERR_UNACKED_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_RETRANS_ERR_TIME_PERIOD), Settings.Global.getUriFor(GLOBAL_SETTINGS_RETRANS_ERR_TIMES_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_RETRANS_ERR_LOW_RETRANS_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_RETRANS_ERR_HIGH_RETRANS_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_RETRANS_ERR_RX_LOW_RETRANS_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_RETRANS_ERR_RX_HIGH_RETRANS_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_RETRANS_ERR_LOW_PKT_NUM_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_RETRANS_ERR_HIGH_PKT_NUM_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_FOREGROUND_APP_NO_DOWNLOAD_ERR_TIME_PERIOD), Settings.Global.getUriFor(GLOBAL_SETTINGS_FOREGROUND_APP_NO_DOWNLOAD_ERR_TIMES_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_RTT_ERR_RTT_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_RTT_ERR_RATE_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_NO_DOWNLOAD_ERR_TIME_PERIOD), Settings.Global.getUriFor(GLOBAL_SETTINGS_NO_DOWNLOAD_ERR_TIMES_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_QOS_BAD_ERR_TIME_PERIOD), Settings.Global.getUriFor(GLOBAL_SETTINGS_QOS_BAD_ERR_TIMES_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_QOS_BAD_ERR_RTT_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_QOS_BAD_ERR_RECV_RETRANS_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_QOS_BAD_ERR_SEND_RETRANS_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_QOS_BAD_ERR_TX_RX_PKT_NUM_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_IGNORE_ERR_THROUGHPUT_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_IGNORE_DOWNLOAD_ERR_THROUGHPUT_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_WHITE_LIST), Settings.Global.getUriFor(GLOBAL_SETTINGS_ACCELERATE_APP_WHITELIST), Settings.Global.getUriFor(GLOBAL_SETTINGS_VIP_NETWORK_ENABLE), Settings.Global.getUriFor(GLOBAL_SETTINGS_WIFI_MSC_SET_VALUE), Settings.Global.getUriFor(GLOBAL_SETTINGS_VIP_STRATEGY_BLACK_LIST)});
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

    public static /* synthetic */ List access$000(L4NetEvaluateObserver r8) {
        return r8.mSettingUris;
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static L4NetEvaluateObserver getInstance(Context r8) {
        if (instance != null) goto L15;
        monitor-enter(L4NetEvaluateObserver.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new L4NetEvaluateObserver(r8);     // Catch: Throwable -> L11
        VipStrategyReport.getInstance().setL4NetEvaluateObserver(instance);     // Catch: Throwable -> L11
    L9:
        monitor-exit(L4NetEvaluateObserver.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private void setAccelerateAppWhitelistJson(String r8) {
        Settings.Global.putString(this.mContentResolver, GLOBAL_SETTINGS_ACCELERATE_APP_WHITELIST, r8);
    }

    private void setBlackList(String r8) {
        Settings.Global.putString(this.mContentResolver, GLOBAL_SETTINGS_VIP_STRATEGY_BLACK_LIST, r8);
    }

    private void setForegroundAppNoDownloadErrTimePeriod(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_FOREGROUND_APP_NO_DOWNLOAD_ERR_TIME_PERIOD, r8);
    }

    private void setForegroundAppNoDownloadErrTimesThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_FOREGROUND_APP_NO_DOWNLOAD_ERR_TIMES_THRESHOLD, r8);
    }

    private void setIgnoreDownloadErrThroughputThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_IGNORE_DOWNLOAD_ERR_THROUGHPUT_THRESHOLD, r8);
    }

    private void setIgnoreErrThroughputThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_IGNORE_ERR_THROUGHPUT_THRESHOLD, r8);
    }

    private void setNoDownloadErrTimePeriod(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_NO_DOWNLOAD_ERR_TIME_PERIOD, r8);
    }

    private void setNoDownloadErrTimesThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_NO_DOWNLOAD_ERR_TIMES_THRESHOLD, r8);
    }

    private void setQosBadErrRecvRetransThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_QOS_BAD_ERR_RECV_RETRANS_THRESHOLD, r8);
    }

    private void setQosBadErrRttThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_QOS_BAD_ERR_RTT_THRESHOLD, r8);
    }

    private void setQosBadErrSendRetransThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_QOS_BAD_ERR_SEND_RETRANS_THRESHOLD, r8);
    }

    private void setQosBadErrTimePeriod(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_QOS_BAD_ERR_TIME_PERIOD, r8);
    }

    private void setQosBadErrTimesThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_QOS_BAD_ERR_TIMES_THRESHOLD, r8);
    }

    private void setQosBadErrTxRxPktNumThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_QOS_BAD_ERR_TX_RX_PKT_NUM_THRESHOLD, r8);
    }

    private void setRetransErrHighPktNumThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_RETRANS_ERR_HIGH_PKT_NUM_THRESHOLD, r8);
    }

    private void setRetransErrHighRetransThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_RETRANS_ERR_HIGH_RETRANS_THRESHOLD, r8);
    }

    private void setRetransErrLowPktNumThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_RETRANS_ERR_LOW_PKT_NUM_THRESHOLD, r8);
    }

    private void setRetransErrLowRetransThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_RETRANS_ERR_LOW_RETRANS_THRESHOLD, r8);
    }

    private void setRetransErrRxHighRetransThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_RETRANS_ERR_RX_HIGH_RETRANS_THRESHOLD, r8);
    }

    private void setRetransErrRxLowRetransThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_RETRANS_ERR_RX_LOW_RETRANS_THRESHOLD, r8);
    }

    private void setRetransErrTimePeriod(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_RETRANS_ERR_TIME_PERIOD, r8);
    }

    private void setRetransErrTimesThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_RETRANS_ERR_TIMES_THRESHOLD, r8);
    }

    private void setRttErrRateThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_RTT_ERR_RATE_THRESHOLD, r8);
    }

    private void setRttErrRttThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_RTT_ERR_RTT_THRESHOLD, r8);
    }

    private void setTicketGrabbingWhiteList(String r8) {
        Settings.Global.putString(this.mContentResolver, GLOBAL_SETTINGS_TICKET_GRABBING_WHITE_LIST, r8);
    }

    private void setUpRetransErrSendRetransThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_UP_RETRANS_ERR_SEND_RETRANS_THRESHOLD, r8);
    }

    private void setUpRetransErrTimePeriod(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_UP_RETRANS_ERR_TIME_PERIOD, r8);
    }

    private void setUpRetransErrTimesThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_UP_RETRANS_ERR_TIMES_THRESHOLD, r8);
    }

    private void setUpRetransErrTxRxPktNumThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_UP_RETRANS_ERR_TX_RX_PKT_NUM_THRESHOLD, r8);
    }

    private void setUpRetransErrUnackedThreshold(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_UP_RETRANS_ERR_UNACKED_THRESHOLD, r8);
    }

    private void setVipNetworkEnable(boolean r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_VIP_NETWORK_ENABLE, r8 ? 1 : 0);
        VipStrategyReport.getInstance().setVipNetworkFeatureEnabled(r8);
    }

    private void setWhiteList(String r8) {
        Settings.Global.putString(this.mContentResolver, GLOBAL_SETTINGS_WHITE_LIST, r8);
    }

    private void setWifiMscSetValue(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_WIFI_MSC_SET_VALUE, r8);
    }

    public void dumpSettings() {
        String r8 = TAG;
        CaeLog.d(r8, "dumpSettings:");
        CaeLog.d(r8, "up_retrans_err_time_period=" + getUpRetransErrTimePeriod());
        CaeLog.d(r8, "up_retrans_err_times_threshold=" + getUpRetransErrTimesThreshold());
        CaeLog.d(r8, "up_retrans_err_send_retrans_threshold=" + getUpRetransErrSendRetransThreshold());
        CaeLog.d(r8, "up_retrans_err_tx_rx_pkt_num_threshold=" + getUpRetransErrTxRxPktNumThreshold());
        CaeLog.d(r8, "up_retrans_err_unacked_threshold=" + getUpRetransErrUnackedThreshold());
        CaeLog.d(r8, "retrans_err_time_period=" + getRetransErrTimePeriod());
        CaeLog.d(r8, "retrans_err_times_threshold=" + getRetransErrTimesThreshold());
        CaeLog.d(r8, "retrans_err_low_retrans_threshold=" + getRetransErrLowRetransThreshold());
        CaeLog.d(r8, "retrans_err_high_retrans_threshold=" + getRetransErrHighRetransThreshold());
        CaeLog.d(r8, "retrans_err_rx_low_retrans_threshold=" + getRetransErrRxLowRetransThreshold());
        CaeLog.d(r8, "retrans_err_rx_high_retrans_threshold=" + getRetransErrRxHighRetransThreshold());
        CaeLog.d(r8, "retrans_err_low_pkt_num_threshold=" + getRetransErrLowPktNumThreshold());
        CaeLog.d(r8, "retrans_err_high_pkt_num_threshold=" + getRetransErrHighPktNumThreshold());
        CaeLog.d(r8, "foreground_app_no_download_err_time_period=" + getForegroundAppNoDownloadErrTimePeriod());
        CaeLog.d(r8, "foreground_app_no_download_err_times_threshold=" + getForegroundAppNoDownloadErrTimesThreshold());
        CaeLog.d(r8, "rtt_err_rtt_threshold=" + getRttErrRttThreshold());
        CaeLog.d(r8, "rtt_err_rate_threshold=" + getRttErrRateThreshold());
        CaeLog.d(r8, "no_download_err_time_period=" + getNoDownloadErrTimePeriod());
        CaeLog.d(r8, "no_download_err_times_threshold=" + getNoDownloadErrTimesThreshold());
        CaeLog.d(r8, "qos_bad_err_time_period=" + getQosBadErrTimePeriod());
        CaeLog.d(r8, "qos_bad_err_times_threshold=" + getQosBadErrTimesThreshold());
        CaeLog.d(r8, "qos_bad_err_rtt_threshold=" + getQosBadErrRttThreshold());
        CaeLog.d(r8, "qos_bad_err_recv_retrans_threshold=" + getQosBadErrRecvRetransThreshold());
        CaeLog.d(r8, "qos_bad_err_send_retrans_threshold=" + getQosBadErrSendRetransThreshold());
        CaeLog.d(r8, "qos_bad_err_tx_rx_pkt_num_threshold=" + getQosBadErrTxRxPktNumThreshold());
        CaeLog.d(r8, "ignore_err_throughput_threshold=" + getIgnoreErrThroughputThreshold());
        CaeLog.d(r8, "ignore_download_err_throughput_threshold=" + getIgnoreDownloadErrThroughputThreshold());
        CaeLog.d(r8, "white_list=" + getWhiteList());
        CaeLog.d(r8, "ticket_grabbing_white_list=" + getTicketGrabbingWhiteList());
        String r10 = getAccelerateAppWhitelistJson();
        StringBuilder r11 = new StringBuilder("accelerate_app_whitelist=len:");
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        r11.append(r12);
        CaeLog.d(r8, r11.toString());
        CaeLog.d(r8, "vip_network_enable=" + getVipNetworkEnable());
        CaeLog.d(r8, "wifi_msc_set_value=" + getWifiMscSetValue());
        CaeLog.d(r8, "black_list=" + getBlackList());
        return;
    L5:
        r12 = r10.length();
        goto L6
    }

    public String getAccelerateAppWhitelistJson() {
        String r8 = Settings.Global.getString(this.mContentResolver, GLOBAL_SETTINGS_ACCELERATE_APP_WHITELIST);
        if (r8 != null) goto L5;
    L17:
        InputStream r10 = this.mContext.getResources().openRawResource(R.raw.accelerate_app_whitelist);     // Catch: Throwable -> L14
        InputStreamReader r11 = new InputStreamReader(r10, StandardCharsets.UTF_8);     // Catch: Throwable -> L14
        Scanner r12 = new Scanner(r11).useDelimiter("\\A");     // Catch: Throwable -> L14
        if (r12.hasNext() == false) goto L11;
        String r13 = r12.next();     // Catch: Throwable -> L14
    L12:
        r11.close();     // Catch: Throwable -> L14
        r10.close();     // Catch: Throwable -> L14
        CaeLog.i(TAG, "read accelerate_app_whitelist from raw file");     // Catch: Throwable -> L14
        return r13;
    L11:
        r13 = "";
    L14:
        th = move-exception;
        CaeLog.e(TAG, "read accelerate_app_whitelist failed: " + th);
        return "";
    L5:
        if (r8.isEmpty() == true) goto L17;
        CaeLog.i(TAG, "get accelerate app whitelist from cloud");
        return r8;
    }

    public String getBlackList() {
        String r8 = Settings.Global.getString(this.mContentResolver, GLOBAL_SETTINGS_VIP_STRATEGY_BLACK_LIST);
        if (r8 != null) goto L6;
        return VIP_STRATEGY_BLACK_LIST;
    L6:
        return r8;
    }

    public int getForegroundAppNoDownloadErrTimePeriod() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_FOREGROUND_APP_NO_DOWNLOAD_ERR_TIME_PERIOD, 6);
    }

    public int getForegroundAppNoDownloadErrTimesThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_FOREGROUND_APP_NO_DOWNLOAD_ERR_TIMES_THRESHOLD, 3);
    }

    public int getIgnoreDownloadErrThroughputThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_IGNORE_DOWNLOAD_ERR_THROUGHPUT_THRESHOLD, IGNORE_DOWNLOAD_ERR_THROUGHPUT_THRESHOLD);
    }

    public int getIgnoreErrThroughputThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_IGNORE_ERR_THROUGHPUT_THRESHOLD, 2097152);
    }

    public int getNoDownloadErrTimePeriod() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_NO_DOWNLOAD_ERR_TIME_PERIOD, 8);
    }

    public int getNoDownloadErrTimesThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_NO_DOWNLOAD_ERR_TIMES_THRESHOLD, 4);
    }

    public int getQosBadErrRecvRetransThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_QOS_BAD_ERR_RECV_RETRANS_THRESHOLD, 50);
    }

    public int getQosBadErrRttThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_QOS_BAD_ERR_RTT_THRESHOLD, QOS_BAD_ERR_RTT_THRESHOLD);
    }

    public int getQosBadErrSendRetransThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_QOS_BAD_ERR_SEND_RETRANS_THRESHOLD, 30);
    }

    public int getQosBadErrTimePeriod() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_QOS_BAD_ERR_TIME_PERIOD, 3);
    }

    public int getQosBadErrTimesThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_QOS_BAD_ERR_TIMES_THRESHOLD, 3);
    }

    public int getQosBadErrTxRxPktNumThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_QOS_BAD_ERR_TX_RX_PKT_NUM_THRESHOLD, 10);
    }

    public int getRetransErrHighPktNumThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_RETRANS_ERR_HIGH_PKT_NUM_THRESHOLD, 20);
    }

    public int getRetransErrHighRetransThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_RETRANS_ERR_HIGH_RETRANS_THRESHOLD, 50);
    }

    public int getRetransErrLowPktNumThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_RETRANS_ERR_LOW_PKT_NUM_THRESHOLD, 10);
    }

    public int getRetransErrLowRetransThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_RETRANS_ERR_LOW_RETRANS_THRESHOLD, 20);
    }

    public int getRetransErrRxHighRetransThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_RETRANS_ERR_RX_HIGH_RETRANS_THRESHOLD, RETRANS_ERR_RX_HIGH_RETRANS_THRESHOLD);
    }

    public int getRetransErrRxLowRetransThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_RETRANS_ERR_RX_LOW_RETRANS_THRESHOLD, 50);
    }

    public int getRetransErrTimePeriod() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_RETRANS_ERR_TIME_PERIOD, 5);
    }

    public int getRetransErrTimesThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_RETRANS_ERR_TIMES_THRESHOLD, 3);
    }

    public int getRttErrRateThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_RTT_ERR_RATE_THRESHOLD, RTT_ERR_RATE_THRESHOLD);
    }

    public int getRttErrRttThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_RTT_ERR_RTT_THRESHOLD, RTT_ERR_RTT_THRESHOLD);
    }

    public String getTicketGrabbingWhiteList() {
        String r8 = Settings.Global.getString(this.mContentResolver, GLOBAL_SETTINGS_TICKET_GRABBING_WHITE_LIST);
        if (r8 != null) goto L6;
        return TICKET_GRABBING_WHITE_LIST;
    L6:
        return r8;
    }

    public int getUpRetransErrSendRetransThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_UP_RETRANS_ERR_SEND_RETRANS_THRESHOLD, 10);
    }

    public int getUpRetransErrTimePeriod() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_UP_RETRANS_ERR_TIME_PERIOD, 3);
    }

    public int getUpRetransErrTimesThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_UP_RETRANS_ERR_TIMES_THRESHOLD, 3);
    }

    public int getUpRetransErrTxRxPktNumThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_UP_RETRANS_ERR_TX_RX_PKT_NUM_THRESHOLD, 10);
    }

    public int getUpRetransErrUnackedThreshold() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_UP_RETRANS_ERR_UNACKED_THRESHOLD, 12);
    }

    public boolean getVipNetworkEnable() {
        if (Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_VIP_NETWORK_ENABLE, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String getWhiteList() {
        String r8 = Settings.Global.getString(this.mContentResolver, GLOBAL_SETTINGS_WHITE_LIST);
        if (r8 != null) goto L6;
        return WHITE_LIST;
    L6:
        return r8;
    }

    public int getWifiMscSetValue() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_WIFI_MSC_SET_VALUE, 7);
    }

    public void updateSettings(String r10) {
        JSONObject r8 = new JSONObject(r10);     // Catch: JSONException -> L13
        setUpRetransErrTimePeriod(r8.optInt(GLOBAL_SETTINGS_UP_RETRANS_ERR_TIME_PERIOD, 3));     // Catch: JSONException -> L13
        setUpRetransErrTimesThreshold(r8.optInt(GLOBAL_SETTINGS_UP_RETRANS_ERR_TIMES_THRESHOLD, 3));     // Catch: JSONException -> L13
        setUpRetransErrSendRetransThreshold(r8.optInt(GLOBAL_SETTINGS_UP_RETRANS_ERR_SEND_RETRANS_THRESHOLD, 10));     // Catch: JSONException -> L13
        setUpRetransErrTxRxPktNumThreshold(r8.optInt(GLOBAL_SETTINGS_UP_RETRANS_ERR_TX_RX_PKT_NUM_THRESHOLD, 10));     // Catch: JSONException -> L13
        setUpRetransErrUnackedThreshold(r8.optInt(GLOBAL_SETTINGS_UP_RETRANS_ERR_UNACKED_THRESHOLD, 12));     // Catch: JSONException -> L13
        setRetransErrTimePeriod(r8.optInt(GLOBAL_SETTINGS_RETRANS_ERR_TIME_PERIOD, 5));     // Catch: JSONException -> L13
        setRetransErrTimesThreshold(r8.optInt(GLOBAL_SETTINGS_RETRANS_ERR_TIMES_THRESHOLD, 3));     // Catch: JSONException -> L13
        setRetransErrLowRetransThreshold(r8.optInt(GLOBAL_SETTINGS_RETRANS_ERR_LOW_RETRANS_THRESHOLD, 20));     // Catch: JSONException -> L13
        setRetransErrHighRetransThreshold(r8.optInt(GLOBAL_SETTINGS_RETRANS_ERR_HIGH_RETRANS_THRESHOLD, 50));     // Catch: JSONException -> L13
        setRetransErrRxLowRetransThreshold(r8.optInt(GLOBAL_SETTINGS_RETRANS_ERR_RX_LOW_RETRANS_THRESHOLD, 50));     // Catch: JSONException -> L13
        setRetransErrRxHighRetransThreshold(r8.optInt(GLOBAL_SETTINGS_RETRANS_ERR_RX_HIGH_RETRANS_THRESHOLD, RETRANS_ERR_RX_HIGH_RETRANS_THRESHOLD));     // Catch: JSONException -> L13
        setRetransErrLowPktNumThreshold(r8.optInt(GLOBAL_SETTINGS_RETRANS_ERR_LOW_PKT_NUM_THRESHOLD, 10));     // Catch: JSONException -> L13
        setRetransErrHighPktNumThreshold(r8.optInt(GLOBAL_SETTINGS_RETRANS_ERR_HIGH_PKT_NUM_THRESHOLD, 20));     // Catch: JSONException -> L13
        setForegroundAppNoDownloadErrTimePeriod(r8.optInt(GLOBAL_SETTINGS_FOREGROUND_APP_NO_DOWNLOAD_ERR_TIME_PERIOD, 6));     // Catch: JSONException -> L13
        setForegroundAppNoDownloadErrTimesThreshold(r8.optInt(GLOBAL_SETTINGS_FOREGROUND_APP_NO_DOWNLOAD_ERR_TIMES_THRESHOLD, 3));     // Catch: JSONException -> L13
        setRttErrRttThreshold(r8.optInt(GLOBAL_SETTINGS_RTT_ERR_RTT_THRESHOLD, RTT_ERR_RTT_THRESHOLD));     // Catch: JSONException -> L13
        setRttErrRateThreshold(r8.optInt(GLOBAL_SETTINGS_RTT_ERR_RATE_THRESHOLD, RTT_ERR_RATE_THRESHOLD));     // Catch: JSONException -> L13
        setNoDownloadErrTimePeriod(r8.optInt(GLOBAL_SETTINGS_NO_DOWNLOAD_ERR_TIME_PERIOD, 8));     // Catch: JSONException -> L13
        setNoDownloadErrTimesThreshold(r8.optInt(GLOBAL_SETTINGS_NO_DOWNLOAD_ERR_TIMES_THRESHOLD, 4));     // Catch: JSONException -> L13
        setQosBadErrTimePeriod(r8.optInt(GLOBAL_SETTINGS_QOS_BAD_ERR_TIME_PERIOD, 3));     // Catch: JSONException -> L13
        setQosBadErrTimesThreshold(r8.optInt(GLOBAL_SETTINGS_QOS_BAD_ERR_TIMES_THRESHOLD, 3));     // Catch: JSONException -> L13
        setQosBadErrRttThreshold(r8.optInt(GLOBAL_SETTINGS_QOS_BAD_ERR_RTT_THRESHOLD, QOS_BAD_ERR_RTT_THRESHOLD));     // Catch: JSONException -> L13
        setQosBadErrRecvRetransThreshold(r8.optInt(GLOBAL_SETTINGS_QOS_BAD_ERR_RECV_RETRANS_THRESHOLD, 50));     // Catch: JSONException -> L13
        setQosBadErrSendRetransThreshold(r8.optInt(GLOBAL_SETTINGS_QOS_BAD_ERR_SEND_RETRANS_THRESHOLD, 30));     // Catch: JSONException -> L13
        setQosBadErrTxRxPktNumThreshold(r8.optInt(GLOBAL_SETTINGS_QOS_BAD_ERR_TX_RX_PKT_NUM_THRESHOLD, 10));     // Catch: JSONException -> L13
        setIgnoreErrThroughputThreshold(r8.optInt(GLOBAL_SETTINGS_IGNORE_ERR_THROUGHPUT_THRESHOLD, 2097152));     // Catch: JSONException -> L13
        setIgnoreDownloadErrThroughputThreshold(r8.optInt(GLOBAL_SETTINGS_IGNORE_DOWNLOAD_ERR_THROUGHPUT_THRESHOLD, IGNORE_DOWNLOAD_ERR_THROUGHPUT_THRESHOLD));     // Catch: JSONException -> L13
        setWhiteList(r8.optString(GLOBAL_SETTINGS_WHITE_LIST, WHITE_LIST));     // Catch: JSONException -> L13
        setTicketGrabbingWhiteList(r8.optString(GLOBAL_SETTINGS_TICKET_GRABBING_WHITE_LIST, TICKET_GRABBING_WHITE_LIST));     // Catch: JSONException -> L13
        if (r8.has(GLOBAL_SETTINGS_ACCELERATE_APP_WHITELIST) == false) goto L8;
        JSONArray r11 = r8.getJSONArray(GLOBAL_SETTINGS_ACCELERATE_APP_WHITELIST);     // Catch: JSONException -> L17
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L17
        r12.put(GLOBAL_SETTINGS_ACCELERATE_APP_WHITELIST, r11);     // Catch: JSONException -> L17
        setAccelerateAppWhitelistJson(r12.toString());     // Catch: JSONException -> L17
    L8:
        if (r8.has(VIP_STRATEGY_SETTINGS_KEY) == true) goto L19;
        setVipNetworkEnable(true);     // Catch: JSONException -> L13
        setWifiMscSetValue(7);     // Catch: JSONException -> L13
        setBlackList(VIP_STRATEGY_BLACK_LIST);     // Catch: JSONException -> L13
    L15:
        dumpSettings();
        return;
    L19:
        JSONObject r13 = r8.getJSONObject(VIP_STRATEGY_SETTINGS_KEY);     // Catch: JSONException -> L18
        setVipNetworkEnable(r13.optBoolean(GLOBAL_SETTINGS_VIP_NETWORK_ENABLE, true));     // Catch: JSONException -> L18
        setWifiMscSetValue(r13.optInt(GLOBAL_SETTINGS_WIFI_MSC_SET_VALUE, 7));     // Catch: JSONException -> L18
        setBlackList(r13.optString(GLOBAL_SETTINGS_VIP_STRATEGY_BLACK_LIST, VIP_STRATEGY_BLACK_LIST));     // Catch: JSONException -> L18
    L13:
        e = move-exception;
        CaeLog.e(TAG, "Invalid JSON config: " + e.getMessage());
        goto L15
    }
}
