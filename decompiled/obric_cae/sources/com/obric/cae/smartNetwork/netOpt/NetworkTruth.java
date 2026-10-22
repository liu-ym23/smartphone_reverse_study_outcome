package com.obric.cae.smartNetwork.netOpt;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.NetworkAccelerate.VipStrategyReport;
import com.obric.cae.smartNetwork.trafficMonitor.TrafficMonitorUtil;
import com.obric.cae.wifi.WiFiDBHelper;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkTruth {
    private static final String TAG = "NetworkTruth";
    private final ConcurrentLinkedQueue<CellularQoE> CellularQoEQueue;
    private final ConcurrentLinkedQueue<L4QoE> L4QoEQueue;
    private NetworkInfo defaultNetworkInfo;
    private boolean isIdleMode;
    private boolean isPowerSaveMode;
    private boolean isSleepMode;
    private int maxBaseQueueSize;
    private final ConcurrentLinkedQueue<NetworkChangedEvent> networkChangedEvents;
    private final ConcurrentLinkedQueue<PowerModeChangedEvent> powerModeChangedEvents;
    private final ConcurrentLinkedQueue<WifiQoE> wifiQoEQueue;

    public static class BaseCapability {
        public BaseCapability() {
        }
    }

    public static class CellularInfo extends BaseCapability {
        private long cellId;
        private int rsrp;
        private int sinr;
        private int subId;
        private int type;

        public CellularInfo() {
        }

        public CellularInfo(CellularInfo r8) {
            this.subId = r8.subId;
            this.type = r8.type;
            this.cellId = r8.cellId;
            this.rsrp = r8.rsrp;
            this.sinr = r8.sinr;
        }

        public static /* synthetic */ int access$2200(CellularInfo r8) {
            return r8.subId;
        }

        public static /* synthetic */ int access$2300(CellularInfo r8) {
            return r8.type;
        }

        public static /* synthetic */ long access$2400(CellularInfo r8) {
            return r8.cellId;
        }

        public static /* synthetic */ int access$2500(CellularInfo r8) {
            return r8.rsrp;
        }

        public static /* synthetic */ int access$2600(CellularInfo r8) {
            return r8.sinr;
        }

        public CellularInfo setCellId(long r8) {
            this.cellId = r8;
            return this;
        }

        public CellularInfo setRsrp(int r8) {
            this.rsrp = r8;
            return this;
        }

        public CellularInfo setSinr(int r8) {
            this.sinr = r8;
            return this;
        }

        public CellularInfo setSubId(int r8) {
            this.subId = r8;
            return this;
        }

        public CellularInfo setType(int r8) {
            this.type = r8;
            return this;
        }
    }

    public static class CellularQoE {
        private int errBitMap;
        private int slotId;
        private long timestamp;

        public CellularQoE() {
        }

        public static /* synthetic */ int access$1100(CellularQoE r8) {
            return r8.slotId;
        }

        public static /* synthetic */ int access$1200(CellularQoE r8) {
            return r8.errBitMap;
        }

        public static /* synthetic */ long access$1300(CellularQoE r8) {
            return r8.timestamp;
        }

        public CellularQoE setErrBitMap(int r8) {
            this.errBitMap = r8;
            return this;
        }

        public CellularQoE setSlotId(int r8) {
            this.slotId = r8;
            return this;
        }

        public CellularQoE setTimestamp(long r8) {
            this.timestamp = r8;
            return this;
        }
    }

    public static class EthernetInfo extends BaseCapability {
        public EthernetInfo() {
        }
    }

    public static class L4QoE {
        private L4NetEvaluate.L4NetStats l4NetStats;
        private long timestamp;

        public L4QoE() {
        }

        public static /* synthetic */ L4NetEvaluate.L4NetStats access$1000(L4QoE r8) {
            return r8.l4NetStats;
        }

        public static /* synthetic */ long access$900(L4QoE r8) {
            return r8.timestamp;
        }

        public L4QoE setL4NetStats(L4NetEvaluate.L4NetStats r8) {
            this.l4NetStats = r8;
            return this;
        }

        public L4QoE setTimestamp(long r8) {
            this.timestamp = r8;
            return this;
        }
    }

    public static class NetworkChangedEvent {
        public static final int EVENT_TYPE_DEFAULT_NETWORK_CHANGED = 3;
        public static final int EVENT_TYPE_NETWORK_AVAILABLE = 1;
        public static final int EVENT_TYPE_NETWORK_LOST = 2;
        private NetworkInfo networkInfo;
        private long timestamp;
        private int type;

        public NetworkChangedEvent() {
        }

        public static /* synthetic */ int access$000(NetworkChangedEvent r8) {
            return r8.type;
        }

        public static /* synthetic */ long access$100(NetworkChangedEvent r8) {
            return r8.timestamp;
        }

        public static /* synthetic */ NetworkInfo access$200(NetworkChangedEvent r8) {
            return r8.networkInfo;
        }

        public NetworkChangedEvent setNetworkInfo(NetworkInfo r8) {
            this.networkInfo = r8;
            return this;
        }

        public NetworkChangedEvent setTimestamp(long r8) {
            this.timestamp = r8;
            return this;
        }

        public NetworkChangedEvent setType(int r8) {
            this.type = r8;
            return this;
        }
    }

    public static class NetworkInfo {
        private BaseCapability capability;
        private String netId;

        public NetworkInfo() {
        }

        public NetworkInfo(NetworkInfo r8) {
            if (r8 == null) goto L6;
            this.netId = r8.netId;
            this.capability = r8.capability;
            return;
        }

        public static /* synthetic */ String access$1400(NetworkInfo r8) {
            return r8.netId;
        }

        public static /* synthetic */ BaseCapability access$1500(NetworkInfo r8) {
            return r8.capability;
        }

        public NetworkInfo setCapability(BaseCapability r8) {
            this.capability = r8;
            return this;
        }

        public NetworkInfo setNetId(String r8) {
            this.netId = r8;
            return this;
        }
    }

    public static class OtherInfo extends BaseCapability {
        public OtherInfo() {
        }
    }

    public static class PowerModeChangedEvent {
        protected static final int EVENT_TYPE_DEVICE_IDLE_MODE_OFF = 4;
        protected static final int EVENT_TYPE_DEVICE_IDLE_MODE_ON = 3;
        protected static final int EVENT_TYPE_POWER_SAVE_MODE_OFF = 2;
        protected static final int EVENT_TYPE_POWER_SAVE_MODE_ON = 1;
        protected static final int EVENT_TYPE_SLEEP_MODE_OFF = 6;
        protected static final int EVENT_TYPE_SLEEP_MODE_ON = 5;
        private int mode;
        private long timestamp;

        public PowerModeChangedEvent() {
        }

        public static /* synthetic */ int access$300(PowerModeChangedEvent r8) {
            return r8.mode;
        }

        public static /* synthetic */ long access$400(PowerModeChangedEvent r8) {
            return r8.timestamp;
        }

        public PowerModeChangedEvent setMode(int r8) {
            this.mode = r8;
            return this;
        }

        public PowerModeChangedEvent setTimestamp(long r8) {
            this.timestamp = r8;
            return this;
        }
    }

    public static class WifiInfo extends BaseCapability {
        private String bssid;
        private int freq;
        private int linkspeed;
        private int rssi;
        private int rxLinkspeed;
        private String ssid;

        public WifiInfo() {
        }

        public WifiInfo(WifiInfo r8) {
            this.ssid = r8.ssid;
            this.bssid = r8.bssid;
            this.freq = r8.freq;
            this.rssi = r8.rssi;
            this.linkspeed = r8.linkspeed;
            this.rxLinkspeed = r8.rxLinkspeed;
        }

        public static /* synthetic */ String access$1600(WifiInfo r8) {
            return r8.ssid;
        }

        public static /* synthetic */ String access$1700(WifiInfo r8) {
            return r8.bssid;
        }

        public static /* synthetic */ int access$1800(WifiInfo r8) {
            return r8.freq;
        }

        public static /* synthetic */ int access$1900(WifiInfo r8) {
            return r8.rssi;
        }

        public static /* synthetic */ int access$2000(WifiInfo r8) {
            return r8.linkspeed;
        }

        public static /* synthetic */ int access$2100(WifiInfo r8) {
            return r8.rxLinkspeed;
        }

        public WifiInfo setBssid(String r8) {
            this.bssid = r8;
            return this;
        }

        public WifiInfo setFreq(int r8) {
            this.freq = r8;
            return this;
        }

        public WifiInfo setLinkspeed(int r8) {
            this.linkspeed = r8;
            return this;
        }

        public WifiInfo setRssi(int r8) {
            this.rssi = r8;
            return this;
        }

        public WifiInfo setRxLinkspeed(int r8) {
            this.rxLinkspeed = r8;
            return this;
        }

        public WifiInfo setSsid(String r8) {
            this.ssid = r8;
            return this;
        }
    }

    public static class WifiQoE {
        private int band;
        private int rxThroughput;
        private long timestamp;
        private int txThroughput;

        public WifiQoE() {
        }

        public static /* synthetic */ int access$500(WifiQoE r8) {
            return r8.band;
        }

        public static /* synthetic */ int access$600(WifiQoE r8) {
            return r8.rxThroughput;
        }

        public static /* synthetic */ int access$700(WifiQoE r8) {
            return r8.txThroughput;
        }

        public static /* synthetic */ long access$800(WifiQoE r8) {
            return r8.timestamp;
        }

        public WifiQoE setBand(int r8) {
            this.band = r8;
            return this;
        }

        public WifiQoE setRxThroughput(int r8) {
            this.rxThroughput = r8;
            return this;
        }

        public WifiQoE setTimestamp(long r8) {
            this.timestamp = r8;
            return this;
        }

        public WifiQoE setTxThroughput(int r8) {
            this.txThroughput = r8;
            return this;
        }
    }

    public NetworkTruth() {
        this.maxBaseQueueSize = 30;
        this.isIdleMode = false;
        this.isPowerSaveMode = false;
        this.isSleepMode = false;
        this.networkChangedEvents = new ConcurrentLinkedQueue();
        this.powerModeChangedEvents = new ConcurrentLinkedQueue();
        this.wifiQoEQueue = new ConcurrentLinkedQueue();
        this.L4QoEQueue = new ConcurrentLinkedQueue();
        this.CellularQoEQueue = new ConcurrentLinkedQueue();
    }

    private JSONObject convertCellularInfoToJson(CellularInfo r8) {
        JSONObject r10 = new JSONObject();
        r10.put(TrafficMonitorUtil.EXTRA_SUB_ID, CellularInfo.access$2200(r8));
        r10.put("type", CellularInfo.access$2300(r8));
        r10.put("cellId", CellularInfo.access$2400(r8));
        r10.put("rsrp", CellularInfo.access$2500(r8));
        r10.put("sinr", CellularInfo.access$2600(r8));
        return r10;
    }

    private JSONObject convertCellularQoEToJson(CellularQoE r8) {
        JSONObject r10 = new JSONObject();
        r10.put("slotId", CellularQoE.access$1100(r8));
        r10.put("errBitMap", CellularQoE.access$1200(r8));
        r10.put("timestamp", CellularQoE.access$1300(r8));
        return r10;
    }

    private JSONObject convertL4QoEToJson(L4QoE r8) {
        JSONObject r10 = new JSONObject();
        r10.put("timestamp", L4QoE.access$900(r8));
        r10.put("l4NetStats", L4QoE.access$1000(r8).toString());
        return r10;
    }

    private JSONObject convertNetworkChangedEventToJson(NetworkChangedEvent r8) {
        JSONObject r10 = new JSONObject();
        r10.put("type", NetworkChangedEvent.access$000(r8));
        r10.put("timestamp", NetworkChangedEvent.access$100(r8));
        if (NetworkChangedEvent.access$200(r8) == null) goto L5;
        r10.put("networkInfo", convertNetworkInfoToJson(NetworkChangedEvent.access$200(r8)));
    L5:
        return r10;
    }

    private JSONObject convertPowerModeChangedEventToJson(PowerModeChangedEvent r8) {
        JSONObject r10 = new JSONObject();
        r10.put("mode", PowerModeChangedEvent.access$300(r8));
        r10.put("timestamp", PowerModeChangedEvent.access$400(r8));
        return r10;
    }

    private JSONObject convertWifiInfoToJson(WifiInfo r8) {
        JSONObject r10 = new JSONObject();
        r10.put("ssid", WifiInfo.access$1600(r8));
        r10.put(WiFiDBHelper.COL_BSSID, WifiInfo.access$1700(r8));
        r10.put("freq", WifiInfo.access$1800(r8));
        r10.put(WiFiDBHelper.COL_RSSI, WifiInfo.access$1900(r8));
        r10.put("linkspeed", WifiInfo.access$2000(r8));
        r10.put("rxLinkspeed", WifiInfo.access$2100(r8));
        return r10;
    }

    private JSONObject convertWifiQoEToJson(WifiQoE r8) {
        JSONObject r10 = new JSONObject();
        r10.put(BdimCategoryConstants.NAME_BAND, WifiQoE.access$500(r8));
        r10.put("rxThroughput", WifiQoE.access$600(r8));
        r10.put("txThroughput", WifiQoE.access$700(r8));
        r10.put("timestamp", WifiQoE.access$800(r8));
        return r10;
    }

    public JSONObject convertNetworkInfoToJson(NetworkInfo r8) {
        JSONObject r10 = new JSONObject();
        r10.put("netId", NetworkInfo.access$1400(r8));
        if (NetworkInfo.access$1500(r8) != null) goto L5;
    L18:
        return r10;
    L5:
        if ((NetworkInfo.access$1500(r8) instanceof WifiInfo) == false) goto L9;
        r10.put("capabilityType", "wifi");
        JSONObject r11 = convertWifiInfoToJson((WifiInfo) NetworkInfo.access$1500(r8));
    L7:
        r10.put(QesdkUtils.TAGS.JSON_TAG_CAPABILITY, r11);
        goto L18
    L9:
        if ((NetworkInfo.access$1500(r8) instanceof CellularInfo) == false) goto L12;
        r10.put("capabilityType", "cellular");
        r11 = convertCellularInfoToJson((CellularInfo) NetworkInfo.access$1500(r8));
        goto L7
    L12:
        if ((NetworkInfo.access$1500(r8) instanceof EthernetInfo) == false) goto L16;
        String r12 = "ethernet";
    L14:
        r10.put("capabilityType", r12);
        goto L18
    L16:
        if ((NetworkInfo.access$1500(r8) instanceof OtherInfo) == false) goto L18;
        r12 = "other";
        goto L14
    }

    public void enqueueCellularQoE(CellularQoE r8) {
        this.CellularQoEQueue.offer(r8);
        if (this.CellularQoEQueue.size() <= this.maxBaseQueueSize) goto L6;
        this.CellularQoEQueue.poll();
        return;
    }

    public void enqueueL4QoE(L4QoE r8) {
        this.L4QoEQueue.offer(r8);
        if (this.L4QoEQueue.size() <= (this.maxBaseQueueSize * 3)) goto L6;
        this.L4QoEQueue.poll();
        return;
    }

    public void enqueueNetworkChangedEvent(NetworkChangedEvent r8) {
        this.networkChangedEvents.offer(r8);
        if (this.networkChangedEvents.size() <= this.maxBaseQueueSize) goto L6;
        this.networkChangedEvents.poll();
        return;
    }

    public void enqueuePowerModeChangedEvent(PowerModeChangedEvent r8) {
        this.powerModeChangedEvents.offer(r8);
        if (this.powerModeChangedEvents.size() <= this.maxBaseQueueSize) goto L6;
        this.powerModeChangedEvents.poll();
        return;
    }

    public void enqueueWifiQoE(WifiQoE r8) {
        this.wifiQoEQueue.offer(r8);
        if (this.wifiQoEQueue.size() <= (this.maxBaseQueueSize * 2)) goto L6;
        this.wifiQoEQueue.poll();
        return;
    }

    public NetworkInfo getDefaultNetworkInfo() {
        return this.defaultNetworkInfo;
    }

    public void setDefaultNetworkInfo(NetworkInfo r8) {
        this.defaultNetworkInfo = r8;
    }

    public void setIdleMode(boolean r8) {
        this.isIdleMode = r8;
    }

    public void setPowerSaveMode(boolean r8) {
        this.isPowerSaveMode = r8;
    }

    public void setSleepMode(boolean r8) {
        this.isSleepMode = r8;
    }

    public String toJsonString() {
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L27
        JSONArray r10 = new JSONArray();     // Catch: JSONException -> L27
        Iterator<NetworkChangedEvent> r11 = this.networkChangedEvents.iterator();     // Catch: JSONException -> L27
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.put(convertNetworkChangedEventToJson(r11.next()));     // Catch: JSONException -> L27
        goto L4
    L6:
        r8.put("networkChangedEvents", r10);     // Catch: JSONException -> L27
        JSONArray r12 = new JSONArray();     // Catch: JSONException -> L27
        Iterator<PowerModeChangedEvent> r13 = this.powerModeChangedEvents.iterator();     // Catch: JSONException -> L27
    L8:
        if (r13.hasNext() == false) goto L10;
        r12.put(convertPowerModeChangedEventToJson(r13.next()));     // Catch: JSONException -> L27
        goto L8
    L10:
        r8.put("powerModeChangedEvents", r12);     // Catch: JSONException -> L27
        JSONArray r14 = new JSONArray();     // Catch: JSONException -> L27
        Iterator<WifiQoE> r15 = this.wifiQoEQueue.iterator();     // Catch: JSONException -> L27
    L12:
        if (r15.hasNext() == false) goto L14;
        r14.put(convertWifiQoEToJson(r15.next()));     // Catch: JSONException -> L27
        goto L12
    L14:
        r8.put("wifiQoEQueue", r14);     // Catch: JSONException -> L27
        JSONArray r16 = new JSONArray();     // Catch: JSONException -> L27
        Iterator<L4QoE> r17 = this.L4QoEQueue.iterator();     // Catch: JSONException -> L27
    L16:
        if (r17.hasNext() == false) goto L18;
        r16.put(convertL4QoEToJson(r17.next()));     // Catch: JSONException -> L27
        goto L16
    L18:
        r8.put("L4QoEQueue", r16);     // Catch: JSONException -> L27
        JSONArray r18 = new JSONArray();     // Catch: JSONException -> L27
        Iterator<CellularQoE> r19 = this.CellularQoEQueue.iterator();     // Catch: JSONException -> L27
    L20:
        if (r19.hasNext() == false) goto L22;
        r18.put(convertCellularQoEToJson(r19.next()));     // Catch: JSONException -> L27
        goto L20
    L22:
        r8.put("CellularQoEQueue", r18);     // Catch: JSONException -> L27
        NetworkInfo r20 = this.defaultNetworkInfo;     // Catch: JSONException -> L27
        if (r20 == null) goto L25;
        r8.put("defaultNetworkInfo", convertNetworkInfoToJson(r20));     // Catch: JSONException -> L27
    L25:
        r8.put("vipStrategyReport", VipStrategyReport.getInstance().convertVipStrategyReportToJson());     // Catch: JSONException -> L27
        r8.put("isIdleMode", this.isIdleMode);     // Catch: JSONException -> L27
        r8.put("isPowerSaveMode", this.isPowerSaveMode);     // Catch: JSONException -> L27
        r8.put("isSleepMode", this.isSleepMode);     // Catch: JSONException -> L27
        return r8.toString();
    L27:
        e = move-exception;
        e.printStackTrace();
        return "{\"error\":\"Failed to convert to JSON\"}";
    }
}
