package com.obric.cae.smartNetwork.networkHandover;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import androidx.activity.j;
import com.bytedance.keva.KevaImpl;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.SmartBluetoothBinderClient;
import com.obric.cae.smartBluetooth.SmartBluetoothManager;
import com.obric.cae.smartNetwork.NetworkAccelerate.VipAppManager;
import com.obric.cae.smartNetwork.networkHandoverRL.ModelSettingObserver;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.ttnet.org.chromium.net.NetError;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class HandoverParameterManager {
    private static final String KEY_APP_DATA_STALL_TIMES = "app_data_stall_times";
    private static final String KEY_AWARE_RECOVER_TIMEOUT = "aware_recover_timeout";
    private static final String KEY_BACKGROUND_APP_UNBIND_TIMEOUT = "background_app_unbind_timeout";
    private static final String KEY_BACKOFF_DETECT_PERIOD = "backoff_detect_period";
    private static final String KEY_BASE_QOE_GOOD_TIMEOUT = "base_qoe_good_timeout";
    private static final String KEY_CELL_DNS_PRERESOLVE_THRESHOLD = "cell_dns_preresolve_threshold";
    private static final String KEY_CELL_LTE_RSRP_THRESHOLD = "cell_lte_rsrp_threshold";
    private static final String KEY_CELL_LTE_RSRQ_THRESHOLD = "cell_lte_rsrq_threshold";
    private static final String KEY_CELL_NR_RSRP_THRESHOLD = "cell_nr_rsrp_threshold";
    private static final String KEY_CELL_NR_RSRQ_THRESHOLD = "cell_nr_rsrq_threshold";
    private static final String KEY_CELL_QOS_CHECK_BAD_TIMES = "cell_qos_check_bad_times";
    private static final String KEY_CELL_QOS_CHECK_GOOD_TIMES = "cell_qos_check_good_times";
    private static final String KEY_CELL_QOS_CHECK_MIDDLE_TIMES = "cell_qos_check_middle_times";
    private static final String KEY_CELL_QOS_CHECK_TIMES = "cell_qos_check_times";
    private static final String KEY_CYCLE_DETECT_PERIOD = "cycle_detect_period";
    private static final String KEY_ELEVATOR_RECOVER_TIMEOUT = "elevator_recover_timeout";
    private static final String KEY_HANDOVER_LIMIT_TIMEOUT = "handover_limit_timeout";
    private static final String KEY_HANDOVER_LIMIT_TIMES = "handover_limit_times";
    private static final String KEY_MAX_DETECT_PERIOD = "max_detect_period";
    private static final String KEY_MAX_QOE_GOOD_TIMEOUT = "max_qoe_good_timeout";
    private static final String KEY_NETWORK_L4_QOE_BAD_THRESHOLD = "network_l4_qoe_bad_threshold";
    private static final String KEY_NETWORK_L4_QOE_CHECK_COUNTS = "network_l4_qoe_check_counts";
    private static final String KEY_NETWORK_L4_QOE_GOOD_THRESHOLD = "network_l4_qoe_good_threshold";
    private static final String KEY_TRAFFIC_STATS_LONG_INTERVAL = "traffic_stats_long_interval";
    private static final String KEY_TRAFFIC_STATS_LONG_NORMAL_THRESHOLD = "traffic_stats_long_normal_threshold";
    private static final String KEY_TRAFFIC_STATS_LONG_WARNING_THRESHOLD = "traffic_stats_long_warning_threshold";
    private static final String KEY_TRAFFIC_STATS_SHORT_INTERVAL = "traffic_stats_short_interval";
    private static final String KEY_TRAFFIC_STATS_SHORT_NORMAL_THRESHOLD = "traffic_stats_short_normal_threshold";
    private static final String KEY_TRAFFIC_STATS_SHORT_WARNING_THRESHOLD = "traffic_stats_short_warning_threshold";
    private static final String KEY_UNSWITCH_DELAY_TIMEOUT = "unswitch_delay_timeout";
    private static final String KEY_WIFI_24G_BAD_TPUT_THRESHOLD = "wifi_24g_bad_tput_threshold";
    private static final String KEY_WIFI_24G_GOOD_TPUT_THRESHOLD = "wifi_24g_good_tput_threshold";
    private static final String KEY_WIFI_24G_UNSWITCH_WEAK_RSSI_THRESHOLD = "wifi_24g_unswitch_weak_rssi_threshold";
    private static final String KEY_WIFI_24G_VERY_BAD_TPUT_THRESHOLD = "wifi_24g_very_bad_tput_threshold";
    private static final String KEY_WIFI_5G_BAD_TPUT_THRESHOLD = "wifi_5g_bad_tput_threshold";
    private static final String KEY_WIFI_5G_GOOD_TPUT_THRESHOLD = "wifi_5g_good_tput_threshold";
    private static final String KEY_WIFI_5G_UNSWITCH_WEAK_RSSI_THRESHOLD = "wifi_5g_unswitch_weak_rssi_threshold";
    private static final String KEY_WIFI_5G_VERY_BAD_TPUT_THRESHOLD = "wifi_5g_very_bad_tput_threshold";
    private static final String KEY_WIFI_QOS_CHECK_BAD_TIMES = "wifi_qos_check_bad_times";
    private static final String KEY_WIFI_QOS_CHECK_GOOD_TIMES = "wifi_qos_check_good_times";
    private static final String KEY_WIFI_QOS_CHECK_TIMES = "wifi_qos_check_times";
    private static final String KEY_WIFI_QOS_CHECK_VERY_BAD_TIMES = "wifi_qos_check_very_bad_times";
    private static final String KEY_YIELD_MAX_PROBE_RTT = "yield_max_probe_rtt";
    private static final String NETWORK_ACC_APP_WHITELIST = "network_acc_app_whitelist";
    private static final String NETWORK_HANDOVER_APP_BLACKLIST = "network_handover_app_blacklist";
    public static final String SCENARIO_AGGRESSIVE = "network_handover_aggressive";
    public static final String SCENARIO_CLUSTER_0 = "network_handover_cluster_0";
    public static final String SCENARIO_CLUSTER_1 = "network_handover_cluster_1";
    public static final String SCENARIO_CLUSTER_2 = "network_handover_cluster_2";
    public static final String SCENARIO_CONSERVATIVE = "network_handover_conservative";
    private static final String SETTINGS_GLOBAL_USER_LOCATION_CHANGE = "user_location_state_change";
    private static final String TAG = "HandoverParameterManager";
    private static final Object[][] aggressiveParameter = null;
    private static final String[] appNetworkAccWhiteList = null;
    private static final String[] appNetworkHandoverBlackList = null;
    private static final Object[][] cluster0Parameter = null;
    private static final Object[][] cluster1Parameter = null;
    private static final Object[][] cluster2Parameter = null;
    private static final Object[][] conservativeParameter = null;
    private static String mClusterScenario;
    private static String mCurrentScenario;
    private static volatile HandoverParameterManager sInstance;
    private final ContentResolver contentResolver;
    private final LocationChangeObserver locationChangeObserver;
    private final Context mContext;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final ModelSettingObserver mModelSettingObserver;
    private final BroadcastReceiver mReceiver;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.networkHandover.HandoverParameterManager$1, reason: invalid class name */
    public class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ HandoverParameterManager this$0;

        public AnonymousClass1(HandoverParameterManager r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(AnonymousClass1 r8) {
            r8.lambda$onReceive$0();
        }

        private /* synthetic */ void lambda$onReceive$0() {
            CaeLog.i(HandoverParameterManager.TAG, "elevator recover timeout, reset mCurrentScenario to " + HandoverParameterManager.access$500());
            HandoverParameterManager.access$100(this.this$0).setPredictFastHandoverNum(5);
            HandoverParameterManager.access$202(HandoverParameterManager.access$500());
            HandoverParameterManager.access$300(this.this$0, HandoverParameterManager.access$200());
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            if (r10.getAction().equals(NetworkUtil.ACTION_CAE_NEAR_ELEVATOR) == false) goto L6;
            CaeLog.i(HandoverParameterManager.TAG, "set mCurrentScenario to SCENARIO_AGGRESSIVE because of into elevator area");
            HandoverParameterManager.access$100(this.this$0).setPredictFastHandoverNum(3);
            HandoverParameterManager.access$202(HandoverParameterManager.SCENARIO_AGGRESSIVE);
            HandoverParameterManager.access$300(this.this$0, HandoverParameterManager.access$200());
            HandoverParameterManager.access$400(this.this$0).removeCallbacksAndMessages(null);
            HandoverParameterManager.access$400(this.this$0).postDelayed(new a(this), this.this$0.getElevatorRecoverTimeout());
            return;
        }
    }

    public class LocationChangeObserver extends ContentObserver {
        final /* synthetic */ HandoverParameterManager this$0;

        public LocationChangeObserver(HandoverParameterManager r8) {
            this.this$0 = r8;
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r8, Uri r10) {
            super.onChange(r8, r10);
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.equals(Settings.Global.getUriFor("user_location_state_change")) == false) goto L9;
            HandoverParameterManager.access$000(this.this$0);
            return;
        }
    }

    static {
        Object[] r8 = {KEY_WIFI_QOS_CHECK_TIMES, 5};
        Object[] r10 = {KEY_WIFI_QOS_CHECK_GOOD_TIMES, 3};
        Object[] r11 = {KEY_WIFI_QOS_CHECK_BAD_TIMES, 3};
        Object[] r12 = {KEY_WIFI_QOS_CHECK_VERY_BAD_TIMES, 2};
        Integer r13 = Integer.valueOf(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        conservativeParameter = new Object[][]{r8, r10, r11, r12, new Object[]{KEY_WIFI_24G_GOOD_TPUT_THRESHOLD, r13}, new Object[]{KEY_WIFI_24G_BAD_TPUT_THRESHOLD, 5000}, new Object[]{KEY_WIFI_24G_VERY_BAD_TPUT_THRESHOLD, 1000}, new Object[]{KEY_WIFI_5G_GOOD_TPUT_THRESHOLD, r13}, new Object[]{KEY_WIFI_5G_BAD_TPUT_THRESHOLD, 5000}, new Object[]{KEY_WIFI_5G_VERY_BAD_TPUT_THRESHOLD, 1000}, new Object[]{KEY_CELL_QOS_CHECK_TIMES, 8}, new Object[]{KEY_CELL_QOS_CHECK_GOOD_TIMES, 3}, new Object[]{KEY_CELL_QOS_CHECK_MIDDLE_TIMES, 4}, new Object[]{KEY_CELL_QOS_CHECK_BAD_TIMES, 3}, new Object[]{"cell_nr_rsrp_threshold", Integer.valueOf(NetError.ERR_SOCKS_CONNECTION_FAILED)}, new Object[]{"cell_nr_rsrq_threshold", -18}, new Object[]{"cell_lte_rsrp_threshold", Integer.valueOf(NetError.ERR_CONNECTION_TIMED_OUT)}, new Object[]{"cell_lte_rsrq_threshold", -18}, new Object[]{KEY_NETWORK_L4_QOE_CHECK_COUNTS, 5}, new Object[]{KEY_NETWORK_L4_QOE_GOOD_THRESHOLD, 60}, new Object[]{KEY_NETWORK_L4_QOE_BAD_THRESHOLD, Integer.valueOf(AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD)}, new Object[]{KEY_APP_DATA_STALL_TIMES, 4}, new Object[]{KEY_HANDOVER_LIMIT_TIMES, 5}, new Object[]{KEY_HANDOVER_LIMIT_TIMEOUT, 60000}, new Object[]{KEY_MAX_DETECT_PERIOD, 160000}, new Object[]{KEY_BACKOFF_DETECT_PERIOD, 20000}, new Object[]{KEY_CYCLE_DETECT_PERIOD, 20000}, new Object[]{KEY_YIELD_MAX_PROBE_RTT, 1000}, new Object[]{KEY_BASE_QOE_GOOD_TIMEOUT, 60000}, new Object[]{KEY_MAX_QOE_GOOD_TIMEOUT, 240000}, new Object[]{KEY_BACKGROUND_APP_UNBIND_TIMEOUT, 30000}, new Object[]{KEY_TRAFFIC_STATS_SHORT_INTERVAL, 20000}, new Object[]{KEY_TRAFFIC_STATS_SHORT_WARNING_THRESHOLD, 100}, new Object[]{KEY_TRAFFIC_STATS_SHORT_NORMAL_THRESHOLD, 40}, new Object[]{KEY_TRAFFIC_STATS_LONG_INTERVAL, 60000}, new Object[]{KEY_TRAFFIC_STATS_LONG_WARNING_THRESHOLD, 300}, new Object[]{KEY_TRAFFIC_STATS_LONG_NORMAL_THRESHOLD, 120}, new Object[]{KEY_AWARE_RECOVER_TIMEOUT, 120000}, new Object[]{KEY_ELEVATOR_RECOVER_TIMEOUT, 120000}, new Object[]{KEY_UNSWITCH_DELAY_TIMEOUT, 60000}, new Object[]{KEY_WIFI_24G_UNSWITCH_WEAK_RSSI_THRESHOLD, -73}, new Object[]{KEY_WIFI_5G_UNSWITCH_WEAK_RSSI_THRESHOLD, -80}, new Object[]{KEY_CELL_DNS_PRERESOLVE_THRESHOLD, 20}};
        aggressiveParameter = new Object[][]{new Object[]{KEY_WIFI_QOS_CHECK_TIMES, 8}, new Object[]{KEY_WIFI_QOS_CHECK_GOOD_TIMES, 6}, new Object[]{KEY_WIFI_QOS_CHECK_BAD_TIMES, 2}, new Object[]{KEY_WIFI_QOS_CHECK_VERY_BAD_TIMES, 1}, new Object[]{KEY_WIFI_24G_GOOD_TPUT_THRESHOLD, 50000}, new Object[]{KEY_WIFI_24G_BAD_TPUT_THRESHOLD, 20000}, new Object[]{KEY_WIFI_24G_VERY_BAD_TPUT_THRESHOLD, r13}, new Object[]{KEY_WIFI_5G_GOOD_TPUT_THRESHOLD, 50000}, new Object[]{KEY_WIFI_5G_BAD_TPUT_THRESHOLD, 20000}, new Object[]{KEY_WIFI_5G_VERY_BAD_TPUT_THRESHOLD, r13}, new Object[]{KEY_CELL_QOS_CHECK_TIMES, 8}, new Object[]{KEY_CELL_QOS_CHECK_GOOD_TIMES, 3}, new Object[]{KEY_CELL_QOS_CHECK_MIDDLE_TIMES, 4}, new Object[]{KEY_CELL_QOS_CHECK_BAD_TIMES, 3}, new Object[]{"cell_nr_rsrp_threshold", Integer.valueOf(NetError.ERR_SOCKS_CONNECTION_FAILED)}, new Object[]{"cell_nr_rsrq_threshold", -18}, new Object[]{"cell_lte_rsrp_threshold", Integer.valueOf(NetError.ERR_CONNECTION_TIMED_OUT)}, new Object[]{"cell_lte_rsrq_threshold", -18}, new Object[]{KEY_NETWORK_L4_QOE_CHECK_COUNTS, 5}, new Object[]{KEY_NETWORK_L4_QOE_GOOD_THRESHOLD, 60}, new Object[]{KEY_NETWORK_L4_QOE_BAD_THRESHOLD, 100}, new Object[]{KEY_APP_DATA_STALL_TIMES, 2}, new Object[]{KEY_HANDOVER_LIMIT_TIMES, 5}, new Object[]{KEY_HANDOVER_LIMIT_TIMEOUT, 60000}, new Object[]{KEY_MAX_DETECT_PERIOD, 160000}, new Object[]{KEY_BACKOFF_DETECT_PERIOD, 20000}, new Object[]{KEY_CYCLE_DETECT_PERIOD, 20000}, new Object[]{KEY_YIELD_MAX_PROBE_RTT, 1000}, new Object[]{KEY_BASE_QOE_GOOD_TIMEOUT, 60000}, new Object[]{KEY_MAX_QOE_GOOD_TIMEOUT, 240000}, new Object[]{KEY_BACKGROUND_APP_UNBIND_TIMEOUT, 30000}, new Object[]{KEY_TRAFFIC_STATS_SHORT_INTERVAL, 20000}, new Object[]{KEY_TRAFFIC_STATS_SHORT_WARNING_THRESHOLD, 100}, new Object[]{KEY_TRAFFIC_STATS_SHORT_NORMAL_THRESHOLD, 40}, new Object[]{KEY_TRAFFIC_STATS_LONG_INTERVAL, 60000}, new Object[]{KEY_TRAFFIC_STATS_LONG_WARNING_THRESHOLD, 300}, new Object[]{KEY_TRAFFIC_STATS_LONG_NORMAL_THRESHOLD, 120}, new Object[]{KEY_AWARE_RECOVER_TIMEOUT, 120000}, new Object[]{KEY_ELEVATOR_RECOVER_TIMEOUT, 120000}, new Object[]{KEY_UNSWITCH_DELAY_TIMEOUT, 60000}, new Object[]{KEY_WIFI_24G_UNSWITCH_WEAK_RSSI_THRESHOLD, -73}, new Object[]{KEY_WIFI_5G_UNSWITCH_WEAK_RSSI_THRESHOLD, -80}, new Object[]{KEY_CELL_DNS_PRERESOLVE_THRESHOLD, 20}};
        cluster0Parameter = new Object[][]{new Object[]{KEY_WIFI_QOS_CHECK_TIMES, 5}, new Object[]{KEY_WIFI_QOS_CHECK_GOOD_TIMES, 4}, new Object[]{KEY_WIFI_QOS_CHECK_BAD_TIMES, 2}, new Object[]{KEY_WIFI_QOS_CHECK_VERY_BAD_TIMES, 2}, new Object[]{KEY_WIFI_24G_GOOD_TPUT_THRESHOLD, 12000}, new Object[]{KEY_WIFI_24G_BAD_TPUT_THRESHOLD, 6000}, new Object[]{KEY_WIFI_24G_VERY_BAD_TPUT_THRESHOLD, 1000}, new Object[]{KEY_WIFI_5G_GOOD_TPUT_THRESHOLD, 12000}, new Object[]{KEY_WIFI_5G_BAD_TPUT_THRESHOLD, 6000}, new Object[]{KEY_WIFI_5G_VERY_BAD_TPUT_THRESHOLD, 1000}, new Object[]{KEY_CELL_QOS_CHECK_TIMES, 8}, new Object[]{KEY_CELL_QOS_CHECK_GOOD_TIMES, 3}, new Object[]{KEY_CELL_QOS_CHECK_MIDDLE_TIMES, 4}, new Object[]{KEY_CELL_QOS_CHECK_BAD_TIMES, 3}, new Object[]{"cell_nr_rsrp_threshold", Integer.valueOf(NetError.ERR_SOCKS_CONNECTION_FAILED)}, new Object[]{"cell_nr_rsrq_threshold", -18}, new Object[]{"cell_lte_rsrp_threshold", Integer.valueOf(NetError.ERR_CONNECTION_TIMED_OUT)}, new Object[]{"cell_lte_rsrq_threshold", -18}, new Object[]{KEY_NETWORK_L4_QOE_CHECK_COUNTS, 5}, new Object[]{KEY_NETWORK_L4_QOE_GOOD_THRESHOLD, 60}, new Object[]{KEY_NETWORK_L4_QOE_BAD_THRESHOLD, 100}, new Object[]{KEY_APP_DATA_STALL_TIMES, 4}, new Object[]{KEY_HANDOVER_LIMIT_TIMES, 5}, new Object[]{KEY_HANDOVER_LIMIT_TIMEOUT, 60000}, new Object[]{KEY_MAX_DETECT_PERIOD, 160000}, new Object[]{KEY_BACKOFF_DETECT_PERIOD, 20000}, new Object[]{KEY_CYCLE_DETECT_PERIOD, 20000}, new Object[]{KEY_YIELD_MAX_PROBE_RTT, 1000}, new Object[]{KEY_BASE_QOE_GOOD_TIMEOUT, 60000}, new Object[]{KEY_MAX_QOE_GOOD_TIMEOUT, 240000}, new Object[]{KEY_BACKGROUND_APP_UNBIND_TIMEOUT, 30000}, new Object[]{KEY_TRAFFIC_STATS_SHORT_INTERVAL, 20000}, new Object[]{KEY_TRAFFIC_STATS_SHORT_WARNING_THRESHOLD, 100}, new Object[]{KEY_TRAFFIC_STATS_SHORT_NORMAL_THRESHOLD, 40}, new Object[]{KEY_TRAFFIC_STATS_LONG_INTERVAL, 60000}, new Object[]{KEY_TRAFFIC_STATS_LONG_WARNING_THRESHOLD, 300}, new Object[]{KEY_TRAFFIC_STATS_LONG_NORMAL_THRESHOLD, 120}, new Object[]{KEY_AWARE_RECOVER_TIMEOUT, 120000}, new Object[]{KEY_UNSWITCH_DELAY_TIMEOUT, 60000}, new Object[]{KEY_WIFI_24G_UNSWITCH_WEAK_RSSI_THRESHOLD, -73}, new Object[]{KEY_WIFI_5G_UNSWITCH_WEAK_RSSI_THRESHOLD, -80}, new Object[]{KEY_CELL_DNS_PRERESOLVE_THRESHOLD, 20}};
        cluster1Parameter = new Object[][]{new Object[]{KEY_WIFI_QOS_CHECK_TIMES, 5}, new Object[]{KEY_WIFI_QOS_CHECK_GOOD_TIMES, 3}, new Object[]{KEY_WIFI_QOS_CHECK_BAD_TIMES, 3}, new Object[]{KEY_WIFI_QOS_CHECK_VERY_BAD_TIMES, 2}, new Object[]{KEY_WIFI_24G_GOOD_TPUT_THRESHOLD, r13}, new Object[]{KEY_WIFI_24G_BAD_TPUT_THRESHOLD, 5000}, new Object[]{KEY_WIFI_24G_VERY_BAD_TPUT_THRESHOLD, 1000}, new Object[]{KEY_WIFI_5G_GOOD_TPUT_THRESHOLD, r13}, new Object[]{KEY_WIFI_5G_BAD_TPUT_THRESHOLD, 5000}, new Object[]{KEY_WIFI_5G_VERY_BAD_TPUT_THRESHOLD, 1000}, new Object[]{KEY_CELL_QOS_CHECK_TIMES, 8}, new Object[]{KEY_CELL_QOS_CHECK_GOOD_TIMES, 3}, new Object[]{KEY_CELL_QOS_CHECK_MIDDLE_TIMES, 4}, new Object[]{KEY_CELL_QOS_CHECK_BAD_TIMES, 3}, new Object[]{"cell_nr_rsrp_threshold", Integer.valueOf(NetError.ERR_SOCKS_CONNECTION_FAILED)}, new Object[]{"cell_nr_rsrq_threshold", -18}, new Object[]{"cell_lte_rsrp_threshold", Integer.valueOf(NetError.ERR_CONNECTION_TIMED_OUT)}, new Object[]{"cell_lte_rsrq_threshold", -18}, new Object[]{KEY_NETWORK_L4_QOE_CHECK_COUNTS, 5}, new Object[]{KEY_NETWORK_L4_QOE_GOOD_THRESHOLD, 60}, new Object[]{KEY_NETWORK_L4_QOE_BAD_THRESHOLD, Integer.valueOf(AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD)}, new Object[]{KEY_APP_DATA_STALL_TIMES, 4}, new Object[]{KEY_HANDOVER_LIMIT_TIMES, 5}, new Object[]{KEY_HANDOVER_LIMIT_TIMEOUT, 60000}, new Object[]{KEY_MAX_DETECT_PERIOD, 160000}, new Object[]{KEY_BACKOFF_DETECT_PERIOD, 20000}, new Object[]{KEY_CYCLE_DETECT_PERIOD, 20000}, new Object[]{KEY_YIELD_MAX_PROBE_RTT, 1000}, new Object[]{KEY_BASE_QOE_GOOD_TIMEOUT, 60000}, new Object[]{KEY_MAX_QOE_GOOD_TIMEOUT, 240000}, new Object[]{KEY_BACKGROUND_APP_UNBIND_TIMEOUT, 30000}, new Object[]{KEY_TRAFFIC_STATS_SHORT_INTERVAL, 20000}, new Object[]{KEY_TRAFFIC_STATS_SHORT_WARNING_THRESHOLD, 100}, new Object[]{KEY_TRAFFIC_STATS_SHORT_NORMAL_THRESHOLD, 40}, new Object[]{KEY_TRAFFIC_STATS_LONG_INTERVAL, 60000}, new Object[]{KEY_TRAFFIC_STATS_LONG_WARNING_THRESHOLD, 300}, new Object[]{KEY_TRAFFIC_STATS_LONG_NORMAL_THRESHOLD, 120}, new Object[]{KEY_AWARE_RECOVER_TIMEOUT, 120000}, new Object[]{KEY_UNSWITCH_DELAY_TIMEOUT, 60000}, new Object[]{KEY_WIFI_24G_UNSWITCH_WEAK_RSSI_THRESHOLD, -73}, new Object[]{KEY_WIFI_5G_UNSWITCH_WEAK_RSSI_THRESHOLD, -80}, new Object[]{KEY_CELL_DNS_PRERESOLVE_THRESHOLD, 20}};
        cluster2Parameter = new Object[][]{new Object[]{KEY_WIFI_QOS_CHECK_TIMES, 5}, new Object[]{KEY_WIFI_QOS_CHECK_GOOD_TIMES, 3}, new Object[]{KEY_WIFI_QOS_CHECK_BAD_TIMES, 3}, new Object[]{KEY_WIFI_QOS_CHECK_VERY_BAD_TIMES, 2}, new Object[]{KEY_WIFI_24G_GOOD_TPUT_THRESHOLD, 12000}, new Object[]{KEY_WIFI_24G_BAD_TPUT_THRESHOLD, 6000}, new Object[]{KEY_WIFI_24G_VERY_BAD_TPUT_THRESHOLD, 1000}, new Object[]{KEY_WIFI_5G_GOOD_TPUT_THRESHOLD, 12000}, new Object[]{KEY_WIFI_5G_BAD_TPUT_THRESHOLD, 6000}, new Object[]{KEY_WIFI_5G_VERY_BAD_TPUT_THRESHOLD, 1000}, new Object[]{KEY_CELL_QOS_CHECK_TIMES, 8}, new Object[]{KEY_CELL_QOS_CHECK_GOOD_TIMES, 3}, new Object[]{KEY_CELL_QOS_CHECK_MIDDLE_TIMES, 4}, new Object[]{KEY_CELL_QOS_CHECK_BAD_TIMES, 3}, new Object[]{"cell_nr_rsrp_threshold", Integer.valueOf(NetError.ERR_SOCKS_CONNECTION_FAILED)}, new Object[]{"cell_nr_rsrq_threshold", -18}, new Object[]{"cell_lte_rsrp_threshold", Integer.valueOf(NetError.ERR_CONNECTION_TIMED_OUT)}, new Object[]{"cell_lte_rsrq_threshold", -18}, new Object[]{KEY_NETWORK_L4_QOE_CHECK_COUNTS, 5}, new Object[]{KEY_NETWORK_L4_QOE_GOOD_THRESHOLD, 60}, new Object[]{KEY_NETWORK_L4_QOE_BAD_THRESHOLD, Integer.valueOf(ApWakeEvent.ACCELERATING_START)}, new Object[]{KEY_APP_DATA_STALL_TIMES, 4}, new Object[]{KEY_HANDOVER_LIMIT_TIMES, 5}, new Object[]{KEY_HANDOVER_LIMIT_TIMEOUT, 60000}, new Object[]{KEY_MAX_DETECT_PERIOD, 160000}, new Object[]{KEY_BACKOFF_DETECT_PERIOD, 20000}, new Object[]{KEY_CYCLE_DETECT_PERIOD, 20000}, new Object[]{KEY_YIELD_MAX_PROBE_RTT, 1000}, new Object[]{KEY_BASE_QOE_GOOD_TIMEOUT, 60000}, new Object[]{KEY_MAX_QOE_GOOD_TIMEOUT, 240000}, new Object[]{KEY_BACKGROUND_APP_UNBIND_TIMEOUT, 30000}, new Object[]{KEY_TRAFFIC_STATS_SHORT_INTERVAL, 20000}, new Object[]{KEY_TRAFFIC_STATS_SHORT_WARNING_THRESHOLD, 100}, new Object[]{KEY_TRAFFIC_STATS_SHORT_NORMAL_THRESHOLD, 40}, new Object[]{KEY_TRAFFIC_STATS_LONG_INTERVAL, 60000}, new Object[]{KEY_TRAFFIC_STATS_LONG_WARNING_THRESHOLD, 300}, new Object[]{KEY_TRAFFIC_STATS_LONG_NORMAL_THRESHOLD, 120}, new Object[]{KEY_AWARE_RECOVER_TIMEOUT, 120000}, new Object[]{KEY_UNSWITCH_DELAY_TIMEOUT, 60000}, new Object[]{KEY_WIFI_24G_UNSWITCH_WEAK_RSSI_THRESHOLD, -73}, new Object[]{KEY_WIFI_5G_UNSWITCH_WEAK_RSSI_THRESHOLD, -80}, new Object[]{KEY_CELL_DNS_PRERESOLVE_THRESHOLD, 20}};
        appNetworkAccWhiteList = new String[0];
        appNetworkHandoverBlackList = new String[]{"com.android.settings", VipAppManager.PACKAGE_NAME_APPSTORE, "com.obric.updater", "com.obric.feedback", "com.baidu.netdisk", "com.xunlei.downloadprovider", "com.quark.browser", "com.alicloud.databox", "com.qq.qcloud", "com.chinamobile.mcloud", "zte.com.market", "com.zte.quickgame", "com.android.launcher3", "com.android.mms", "com.obric.appletapp", "com.obric.clock", "com.obric.notes", "com.obric.filemanager", "com.obric.security", "com.android.camera", "com.android.contacts", "com.zte.remotecontroller", "cuuca.sendfiles.Activity", "com.obric.recorder", "com.obric.compass", "com.obric.calculator"};
        mCurrentScenario = SCENARIO_CONSERVATIVE;
        mClusterScenario = SCENARIO_CONSERVATIVE;
    }

    private HandoverParameterManager(Context r8) {
        AnonymousClass1 r10 = new AnonymousClass1(this);
        this.mReceiver = r10;
        this.mContext = r8;
        this.mModelSettingObserver = ModelSettingObserver.getInstance(r8);
        HandlerThread r11 = new HandlerThread(TAG);
        this.mHandlerThread = r11;
        r11.start();
        this.mHandler = new Handler(r11.getLooper());
        LocationChangeObserver r12 = new LocationChangeObserver(this);
        this.locationChangeObserver = r12;
        ContentResolver r13 = r8.getContentResolver();
        this.contentResolver = r13;
        r13.registerContentObserver(Settings.Global.getUriFor("user_location_state_change"), false, r12);
        r8.registerReceiver(r10, new IntentFilter(NetworkUtil.ACTION_CAE_NEAR_ELEVATOR), NetworkUtil.ACTION_CAE_NEAR_ELEVATOR_PERMISSION, null, 4);
        saveHandoverParameterFromArray(SCENARIO_CONSERVATIVE);
        saveHandoverParameterFromArray(SCENARIO_AGGRESSIVE);
        saveHandoverParameterFromArray(SCENARIO_CLUSTER_0);
        saveHandoverParameterFromArray(SCENARIO_CLUSTER_1);
        saveHandoverParameterFromArray(SCENARIO_CLUSTER_2);
        saveAppListFromArray(NETWORK_ACC_APP_WHITELIST);
        saveAppListFromArray(NETWORK_HANDOVER_APP_BLACKLIST);
    }

    public static /* synthetic */ void a(HandoverParameterManager r8) {
        r8.lambda$handleUserLocationStateChange$0();
    }

    public static /* synthetic */ void access$000(HandoverParameterManager r8) {
        r8.handleUserLocationStateChange();
    }

    public static /* synthetic */ ModelSettingObserver access$100(HandoverParameterManager r8) {
        return r8.mModelSettingObserver;
    }

    public static /* synthetic */ String access$200() {
        return mCurrentScenario;
    }

    public static /* synthetic */ String access$202(String r8) {
        mCurrentScenario = r8;
        return r8;
    }

    public static /* synthetic */ void access$300(HandoverParameterManager r8, String r10) {
        r8.dumpHandoverParameter(r10);
    }

    public static /* synthetic */ Handler access$400(HandoverParameterManager r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ String access$500() {
        return mClusterScenario;
    }

    private void dumpAppNameList(String r8) {
        StringBuilder r10 = new StringBuilder();
        Iterator<Map.Entry<String, ?>> r11 = getHandoverPreferences(r8).getAll().entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<String, ?> r12 = r11.next();
        String r13 = r12.getKey();
        ((Integer) r12.getValue()).intValue();
        r10.append(r13);
        r10.append(", ");
        goto L4
    L6:
        StringBuilder r14 = android.aimedia.a.k(r8, ": ");
        r14.append(r10.toString());
        CaeLog.d(TAG, r14.toString());
    }

    private void dumpHandoverParameter(String r10) {
        StringBuilder r8 = new StringBuilder();
        SharedPreferences r11 = getHandoverPreferences(r10);
        int r12 = r10.hashCode();
        if (r12 == (-1625628561)) goto L21;
        if (r12 == 209367000) goto L18;
        switch(r12) {
            case 611043680: goto L15;
            case 611043681: goto L12;
            case 611043682: goto L9;
            default: goto L23;
        };
    L23:
        byte r13 = -1;
    L24:
        if (r13 == 0) goto L32;
        if (r13 == 1) goto L31;
        if (r13 == 2) goto L30;
        if (r13 == 3) goto L29;
        Object[][] r14 = conservativeParameter;
    L33:
        int r15 = r14.length;
        int r16 = 0;
    L35:
        if (r16 >= r15) goto L37;
        String r17 = (String) r14[r16][0];
        int r18 = r11.getInt(r17, 0);
        r8.append(r17);
        r8.append(": ");
        r8.append(r18);
        r8.append(", ");
        r16 = r16 + 1;
        goto L35
    L37:
        StringBuilder r19 = android.aimedia.a.k(r10, ": ");
        r19.append(r8.toString());
        CaeLog.i(TAG, r19.toString());
        return;
    L29:
        r14 = cluster2Parameter;
        goto L33
    L30:
        r14 = cluster1Parameter;
        goto L33
    L31:
        r14 = cluster0Parameter;
        goto L33
    L32:
        r14 = aggressiveParameter;
        goto L33
    L9:
        if (r10.equals(SCENARIO_CLUSTER_2) == false) goto L23;
        r13 = 3;
        goto L24
    L12:
        if (r10.equals(SCENARIO_CLUSTER_1) == false) goto L23;
        r13 = 2;
        goto L24
    L15:
        if (r10.equals(SCENARIO_CLUSTER_0) == false) goto L23;
        r13 = 1;
        goto L24
    L18:
        if (r10.equals(SCENARIO_CONSERVATIVE) == false) goto L23;
        r13 = 4;
        goto L24
    L21:
        if (r10.equals(SCENARIO_AGGRESSIVE) == false) goto L23;
        r13 = 0;
        goto L24
    }

    private SharedPreferences getHandoverPreferences(String r8) {
        return this.mContext.getSharedPreferences(r8, 0);
    }

    public static HandoverParameterManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(HandoverParameterManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new HandoverParameterManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(HandoverParameterManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void handleUserLocationStateChange() {
        String r8 = Settings.Global.getString(this.contentResolver, "user_location_state_change");
        if (r8 != null) goto L7;
        CaeLog.e(TAG, "handleUserLocationStateChange: mLocationStateChangeValue is null");
        return;
    L7:
        switch(r8.hashCode()) {
            case -498341474: goto L19;
            case 54091568: goto L16;
            case 687039628: goto L13;
            case 771441502: goto L10;
            default: goto L21;
        };
    L21:
        byte r10 = -1;
    L22:
        if (r10 == 0) goto L25;
        if (r10 == 1) goto L25;
    L26:
        SmartBluetoothBinderClient r11 = SmartBluetoothManager.getInstance(this.mContext).getBluetoothBinderClient();
        if (r11 == null) goto L30;
        r11.setLoctionState(r8);
        return;
    L30:
        return;
    L25:
        CaeLog.i(TAG, "set mCurrentScenario to SCENARIO_AGGRESSIVE because of out home or out company");
        this.mModelSettingObserver.setPredictFastHandoverNum(3);
        mCurrentScenario = SCENARIO_AGGRESSIVE;
        dumpHandoverParameter(SCENARIO_AGGRESSIVE);
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.postDelayed(new j(this, 23), getAwareRecoverTimeout());
        goto L26
    L10:
        if (r8.equals("into_home") == false) goto L21;
        r10 = 2;
        goto L22
    L13:
        if (r8.equals("out_company") == false) goto L21;
        r10 = 1;
        goto L22
    L16:
        if (r8.equals("out_home") == false) goto L21;
        r10 = 0;
        goto L22
    L19:
        if (r8.equals("into_company") == false) goto L21;
        r10 = 3;
        goto L22
    }

    private boolean isEmptyPreference(String r8) {
        return getHandoverPreferences(r8).getAll().isEmpty();
    }

    private /* synthetic */ void lambda$handleUserLocationStateChange$0() {
        android.aimedia.a.r(new StringBuilder("out home or company timeout, reset mCurrentScenario to "), mClusterScenario, TAG);
        this.mModelSettingObserver.setPredictFastHandoverNum(5);
        String r8 = mClusterScenario;
        mCurrentScenario = r8;
        dumpHandoverParameter(r8);
    }

    private void saveAppListFromArray(String r8) {
        SharedPreferences.Editor r10 = getHandoverPreferences(r8).edit();
        r10.clear();
        r8.getClass();
        int r11 = 0;
        if (r8.equals(NETWORK_HANDOVER_APP_BLACKLIST) == false) goto L5;
        String[] r12 = appNetworkHandoverBlackList;
        int r13 = r12.length;
    L11:
        if (r11 >= r13) goto L13;
        r10.putInt(r12[r11], 1);
        r11 = r11 + 1;
    L13:
        r10.apply();
        return;
    L5:
        if (r8.equals(NETWORK_ACC_APP_WHITELIST) == false) goto L13;
        String[] r14 = appNetworkAccWhiteList;
        int r15 = r14.length;
    L8:
        if (r11 >= r15) goto L13;
        r10.putInt(r14[r11], 1);
        r11 = r11 + 1;
        goto L8
    }

    private void saveAppListFromJson(String r8, JSONArray r10) {
        SharedPreferences.Editor r11 = getHandoverPreferences(r8).edit();
        r11.clear();
        if (r10 != null) goto L5;
    L16:
        CaeLog.e(TAG, r8 + " appList is empty.");
        saveAppListFromArray(r8);
        return;
    L5:
        if (r10.length() == 0) goto L16;
        int r12 = 0;
    L9:
        if (r12 >= r10.length()) goto L14;
        r11.putInt(r10.getString(r12), 1);     // Catch: JSONException -> L12
        r12 = r12 + 1;
    L12:
        CaeLog.e(TAG, r8 + " appList is invalid.");
        return;
    L14:
        r11.apply();
    }

    private void saveHandoverParameterFromArray(String r8) {
        SharedPreferences.Editor r10 = getHandoverPreferences(r8).edit();
        r10.clear();
        int r11 = r8.hashCode();
        if (r11 == (-1625628561)) goto L21;
        if (r11 == 209367000) goto L18;
        switch(r11) {
            case 611043680: goto L15;
            case 611043681: goto L12;
            case 611043682: goto L9;
            default: goto L23;
        };
    L23:
        byte r12 = -1;
    L24:
        if (r12 == 0) goto L32;
        if (r12 == 1) goto L31;
        if (r12 == 2) goto L30;
        if (r12 == 3) goto L29;
        Object[][] r13 = conservativeParameter;
    L33:
        int r14 = r13.length;
        int r15 = 0;
    L34:
        if (r15 >= r14) goto L36;
        Object[] r16 = r13[r15];
        r10.putInt((String) r16[0], ((Integer) r16[1]).intValue());
        r15 = r15 + 1;
        goto L34
    L36:
        r10.apply();
        return;
    L29:
        r13 = cluster2Parameter;
        goto L33
    L30:
        r13 = cluster1Parameter;
        goto L33
    L31:
        r13 = cluster0Parameter;
        goto L33
    L32:
        r13 = aggressiveParameter;
        goto L33
    L9:
        if (r8.equals(SCENARIO_CLUSTER_2) == false) goto L23;
        r12 = 3;
        goto L24
    L12:
        if (r8.equals(SCENARIO_CLUSTER_1) == false) goto L23;
        r12 = 2;
        goto L24
    L15:
        if (r8.equals(SCENARIO_CLUSTER_0) == false) goto L23;
        r12 = 1;
        goto L24
    L18:
        if (r8.equals(SCENARIO_CONSERVATIVE) == false) goto L23;
        r12 = 4;
        goto L24
    L21:
        if (r8.equals(SCENARIO_AGGRESSIVE) == false) goto L23;
        r12 = 0;
        goto L24
    }

    private void saveHandoverParameterFromJson(String r8, JSONObject r10) {
        SharedPreferences.Editor r11 = getHandoverPreferences(r8).edit();
        int r12 = r8.hashCode();
        if (r12 == (-1625628561)) goto L21;
        if (r12 == 209367000) goto L18;
        switch(r12) {
            case 611043680: goto L15;
            case 611043681: goto L12;
            case 611043682: goto L9;
            default: goto L23;
        };
    L23:
        byte r13 = -1;
    L24:
        if (r13 == 0) goto L32;
        if (r13 == 1) goto L31;
        if (r13 == 2) goto L30;
        if (r13 == 3) goto L29;
        Object[][] r14 = conservativeParameter;
    L41:
        int r15 = r14.length;     // Catch: JSONException -> L37
        int r16 = 0;
    L34:
        if (r16 >= r15) goto L39;
        String r17 = (String) r14[r16][0];     // Catch: JSONException -> L37
        r11.putInt(r17, r10.getInt(r17));     // Catch: JSONException -> L37
        r16 = r16 + 1;
    L39:
        r11.apply();
        return;
    L37:
        e = move-exception;
        CaeLog.e(TAG, "saveHandoverParameterFromJson error: " + e.getMessage());
        saveHandoverParameterFromArray(r8);
        goto L39
    L29:
        r14 = cluster2Parameter;
        goto L41
    L30:
        r14 = cluster1Parameter;
        goto L41
    L31:
        r14 = cluster0Parameter;
        goto L41
    L32:
        r14 = aggressiveParameter;
        goto L41
    L9:
        if (r8.equals(SCENARIO_CLUSTER_2) == false) goto L23;
        r13 = 3;
        goto L24
    L12:
        if (r8.equals(SCENARIO_CLUSTER_1) == false) goto L23;
        r13 = 2;
        goto L24
    L15:
        if (r8.equals(SCENARIO_CLUSTER_0) == false) goto L23;
        r13 = 1;
        goto L24
    L18:
        if (r8.equals(SCENARIO_CONSERVATIVE) == false) goto L23;
        r13 = 4;
        goto L24
    L21:
        if (r8.equals(SCENARIO_AGGRESSIVE) == false) goto L23;
        r13 = 0;
        goto L24
    }

    public int getAppDataStallTimes() {
        return getHandoverParameter(KEY_APP_DATA_STALL_TIMES);
    }

    public int getAwareRecoverTimeout() {
        return getHandoverParameter(KEY_AWARE_RECOVER_TIMEOUT);
    }

    public int getBackgroundAppUnbindTimeout() {
        return getHandoverParameter(KEY_BACKGROUND_APP_UNBIND_TIMEOUT);
    }

    public int getBackoffDetectPeriod() {
        return getHandoverParameter(KEY_BACKOFF_DETECT_PERIOD);
    }

    public int getBaseQoeGoodTimeout() {
        return getHandoverParameter(KEY_BASE_QOE_GOOD_TIMEOUT);
    }

    public int getCellDnsPreresolveThreshold() {
        return getHandoverParameter(KEY_CELL_DNS_PRERESOLVE_THRESHOLD);
    }

    public int getCellLteRsrpThreshold() {
        return getHandoverParameter("cell_lte_rsrp_threshold");
    }

    public int getCellLteRsrqThreshold() {
        return getHandoverParameter("cell_lte_rsrq_threshold");
    }

    public int getCellNrRsrpThreshold() {
        return getHandoverParameter("cell_nr_rsrp_threshold");
    }

    public int getCellNrRsrqThreshold() {
        return getHandoverParameter("cell_nr_rsrq_threshold");
    }

    public int getCellQosCheckBadTimes() {
        return getHandoverParameter(KEY_CELL_QOS_CHECK_BAD_TIMES);
    }

    public int getCellQosCheckGoodTimes() {
        return getHandoverParameter(KEY_CELL_QOS_CHECK_GOOD_TIMES);
    }

    public int getCellQosCheckMiddleTimes() {
        return getHandoverParameter(KEY_CELL_QOS_CHECK_MIDDLE_TIMES);
    }

    public int getCellQosCheckTimes() {
        return getHandoverParameter(KEY_CELL_QOS_CHECK_TIMES);
    }

    public String getCurrentScenario() {
        return mCurrentScenario;
    }

    public int getCycleDetectPeriod() {
        return getHandoverParameter(KEY_CYCLE_DETECT_PERIOD);
    }

    public int getElevatorRecoverTimeout() {
        return getHandoverParameter(KEY_ELEVATOR_RECOVER_TIMEOUT);
    }

    public int getHandoverLimitTimeout() {
        return getHandoverParameter(KEY_HANDOVER_LIMIT_TIMEOUT);
    }

    public int getHandoverLimitTimes() {
        return getHandoverParameter(KEY_HANDOVER_LIMIT_TIMES);
    }

    public int getHandoverParameter(String r8) {
        SharedPreferences r10 = getHandoverPreferences(mCurrentScenario);
        if (r10.contains(r8) == true) goto L5;
        String r11 = mCurrentScenario;
        int r12 = r11.hashCode();
        if (r12 == (-1625628561)) goto L25;
        if (r12 == 209367000) goto L22;
        switch(r12) {
            case 611043680: goto L19;
            case 611043681: goto L16;
            case 611043682: goto L13;
            default: goto L27;
        };
    L27:
        byte r13 = -1;
    L28:
        if (r13 == 0) goto L36;
        if (r13 == 1) goto L35;
        if (r13 == 2) goto L34;
        if (r13 == 3) goto L33;
        Object[][] r14 = conservativeParameter;
    L37:
        int r15 = r14.length;
        int r16 = 0;
    L38:
        if (r16 >= r15) goto L44;
        Object[] r17 = r14[r16];
        if (r8.equals(r17[0]) == true) goto L42;
        r16 = r16 + 1;
        goto L38
    L42:
        return ((Integer) r17[1]).intValue();
    L44:
        return Integer.MAX_VALUE;
    L33:
        r14 = cluster2Parameter;
        goto L37
    L34:
        r14 = cluster1Parameter;
        goto L37
    L35:
        r14 = cluster0Parameter;
        goto L37
    L36:
        r14 = aggressiveParameter;
        goto L37
    L13:
        if (r11.equals(SCENARIO_CLUSTER_2) == false) goto L27;
        r13 = 3;
        goto L28
    L16:
        if (r11.equals(SCENARIO_CLUSTER_1) == false) goto L27;
        r13 = 2;
        goto L28
    L19:
        if (r11.equals(SCENARIO_CLUSTER_0) == false) goto L27;
        r13 = 1;
        goto L28
    L22:
        if (r11.equals(SCENARIO_CONSERVATIVE) == false) goto L27;
        r13 = 4;
        goto L28
    L25:
        if (r11.equals(SCENARIO_AGGRESSIVE) == false) goto L27;
        r13 = 0;
        goto L28
    L5:
        return r10.getInt(r8, Integer.MAX_VALUE);
    }

    public int getMaxDetectPeriod() {
        return getHandoverParameter(KEY_MAX_DETECT_PERIOD);
    }

    public int getMaxQoeGoodTimeout() {
        return getHandoverParameter(KEY_MAX_QOE_GOOD_TIMEOUT);
    }

    public int getNetworkL4QoeBadThreshold() {
        return getHandoverParameter(KEY_NETWORK_L4_QOE_BAD_THRESHOLD);
    }

    public int getNetworkL4QoeCheckCounts() {
        return getHandoverParameter(KEY_NETWORK_L4_QOE_CHECK_COUNTS);
    }

    public int getNetworkL4QoeGoodThreshold() {
        return getHandoverParameter(KEY_NETWORK_L4_QOE_GOOD_THRESHOLD);
    }

    public int getTrafficStatsLongInterval() {
        return getHandoverParameter(KEY_TRAFFIC_STATS_LONG_INTERVAL);
    }

    public int getTrafficStatsLongNormalThreshold() {
        return getHandoverParameter(KEY_TRAFFIC_STATS_LONG_NORMAL_THRESHOLD);
    }

    public int getTrafficStatsLongWarningThreshold() {
        return getHandoverParameter(KEY_TRAFFIC_STATS_LONG_WARNING_THRESHOLD);
    }

    public int getTrafficStatsShortInterval() {
        return getHandoverParameter(KEY_TRAFFIC_STATS_SHORT_INTERVAL);
    }

    public int getTrafficStatsShortNormalThreshold() {
        return getHandoverParameter(KEY_TRAFFIC_STATS_SHORT_NORMAL_THRESHOLD);
    }

    public int getTrafficStatsShortWarningThreshold() {
        return getHandoverParameter(KEY_TRAFFIC_STATS_SHORT_WARNING_THRESHOLD);
    }

    public int getUnswitchDelayTimeout() {
        return getHandoverParameter(KEY_UNSWITCH_DELAY_TIMEOUT);
    }

    public int getWifi24GBadTputThreshold() {
        return getHandoverParameter(KEY_WIFI_24G_BAD_TPUT_THRESHOLD);
    }

    public int getWifi24GGoodTputThreshold() {
        return getHandoverParameter(KEY_WIFI_24G_GOOD_TPUT_THRESHOLD);
    }

    public int getWifi24GUnswitchWeakRssiThreshold() {
        return getHandoverParameter(KEY_WIFI_24G_UNSWITCH_WEAK_RSSI_THRESHOLD);
    }

    public int getWifi24GVeryBadTputThreshold() {
        return getHandoverParameter(KEY_WIFI_24G_VERY_BAD_TPUT_THRESHOLD);
    }

    public int getWifi5GBadTputThreshold() {
        return getHandoverParameter(KEY_WIFI_5G_BAD_TPUT_THRESHOLD);
    }

    public int getWifi5GGoodTputThreshold() {
        return getHandoverParameter(KEY_WIFI_5G_GOOD_TPUT_THRESHOLD);
    }

    public int getWifi5GUnswitchWeakRssiThreshold() {
        return getHandoverParameter(KEY_WIFI_5G_UNSWITCH_WEAK_RSSI_THRESHOLD);
    }

    public int getWifi5GVeryBadTputThreshold() {
        return getHandoverParameter(KEY_WIFI_5G_VERY_BAD_TPUT_THRESHOLD);
    }

    public int getWifiQosCheckBadTimes() {
        return getHandoverParameter(KEY_WIFI_QOS_CHECK_BAD_TIMES);
    }

    public int getWifiQosCheckGoodTimes() {
        return getHandoverParameter(KEY_WIFI_QOS_CHECK_GOOD_TIMES);
    }

    public int getWifiQosCheckTimes() {
        return getHandoverParameter(KEY_WIFI_QOS_CHECK_TIMES);
    }

    public int getWifiQosCheckVeryBadTimes() {
        return getHandoverParameter(KEY_WIFI_QOS_CHECK_VERY_BAD_TIMES);
    }

    public int getYieldMaxProbeRtt() {
        return getHandoverParameter(KEY_YIELD_MAX_PROBE_RTT);
    }

    public boolean isAppInAccWhiteList(String r8) {
        SharedPreferences r10 = getHandoverPreferences(NETWORK_ACC_APP_WHITELIST);
        if (r10.contains(r8) == true) goto L5;
        return false;
    L5:
        if (r10.getInt(r8, 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isAppInHandoverBlackList(String r8) {
        SharedPreferences r10 = getHandoverPreferences(NETWORK_HANDOVER_APP_BLACKLIST);
        if (r10.contains(r8) == true) goto L5;
        return false;
    L5:
        if (r10.getInt(r8, 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void updateParameter(JSONObject r14) {
        JSONObject r8 = r14.getJSONObject(SCENARIO_CONSERVATIVE);     // Catch: JSONException -> L5
        JSONObject r10 = r14.getJSONObject(SCENARIO_AGGRESSIVE);     // Catch: JSONException -> L5
        JSONObject r11 = r14.getJSONObject(SCENARIO_CLUSTER_0);     // Catch: JSONException -> L5
        JSONObject r12 = r14.getJSONObject(SCENARIO_CLUSTER_1);     // Catch: JSONException -> L5
        JSONObject r13 = r14.getJSONObject(SCENARIO_CLUSTER_2);     // Catch: JSONException -> L5
        JSONArray r15 = r14.getJSONArray(NETWORK_ACC_APP_WHITELIST);     // Catch: JSONException -> L5
        JSONArray r16 = r14.getJSONArray(NETWORK_HANDOVER_APP_BLACKLIST);     // Catch: JSONException -> L5
        saveHandoverParameterFromJson(SCENARIO_CONSERVATIVE, r8);     // Catch: JSONException -> L5
        saveHandoverParameterFromJson(SCENARIO_AGGRESSIVE, r10);     // Catch: JSONException -> L5
        saveHandoverParameterFromJson(SCENARIO_CLUSTER_0, r11);     // Catch: JSONException -> L5
        saveHandoverParameterFromJson(SCENARIO_CLUSTER_1, r12);     // Catch: JSONException -> L5
        saveHandoverParameterFromJson(SCENARIO_CLUSTER_2, r13);     // Catch: JSONException -> L5
        saveAppListFromJson(NETWORK_ACC_APP_WHITELIST, r15);     // Catch: JSONException -> L5
        saveAppListFromJson(NETWORK_HANDOVER_APP_BLACKLIST, r16);     // Catch: JSONException -> L5
        dumpHandoverParameter(SCENARIO_CONSERVATIVE);     // Catch: JSONException -> L5
        dumpHandoverParameter(SCENARIO_AGGRESSIVE);     // Catch: JSONException -> L5
        dumpHandoverParameter(SCENARIO_CLUSTER_0);     // Catch: JSONException -> L5
        dumpHandoverParameter(SCENARIO_CLUSTER_1);     // Catch: JSONException -> L5
        dumpHandoverParameter(SCENARIO_CLUSTER_2);     // Catch: JSONException -> L5
        dumpAppNameList(NETWORK_ACC_APP_WHITELIST);     // Catch: JSONException -> L5
        dumpAppNameList(NETWORK_HANDOVER_APP_BLACKLIST);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "updateParameter error", e);
    }

    public void updateScenario(String r8) {
        CaeLog.i(TAG, "update network handover Scenario: " + r8);
        mCurrentScenario = r8;
        mClusterScenario = r8;
        dumpHandoverParameter(r8);
    }
}
