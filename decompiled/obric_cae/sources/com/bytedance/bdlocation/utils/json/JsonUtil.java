package com.bytedance.bdlocation.utils.json;

import android.location.Location;
import android.text.TextUtils;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.BaseStation;
import com.bytedance.bdlocation.network.model.BssInfo;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.utils.json.deserializer.BDLocationDeserializer;
import com.bytedance.bdlocation.utils.json.deserializer.LocationDeserializer;
import com.bytedance.bdlocation.utils.json.serializer.BDLocationSerializer;
import com.bytedance.bdlocation.utils.json.serializer.LocationSerializer;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;
import com.obric.cae.location.database.StarCellDbManager;
import com.obric.cae.wifi.WiFiDBHelper;
import ha.j;
import ha.k;
import ha.p;
import ha.r;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import ka.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JsonUtil {
    public static j sGson;

    static {
        k r8 = new k();
        SuperclassExclusionStrategy r10 = new SuperclassExclusionStrategy();
        r8.f7986a = r8.f7986a.f(r10, false, true);
        SuperclassExclusionStrategy r11 = new SuperclassExclusionStrategy();
        r8.f7986a = r8.f7986a.f(r11, true, false);
        r8.b(Location.class, new LocationSerializer());
        r8.b(Location.class, new LocationDeserializer());
        r8.b(BDLocation.class, new BDLocationSerializer());
        r8.b(BDLocation.class, new BDLocationDeserializer());
        sGson = r8.a();
    }

    private JsonUtil() {
    }

    public static void convertBssInfoToJSON(JSONObject r8, BaseStation r10, boolean r11) {
        if (r10 != null) goto L22;
        return;
    L22:
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L19
        BssInfo r13 = r10.current;     // Catch: JSONException -> L19
        if (r13 == null) goto L7;
        r12.put("current", getBssInfoJson(r13));     // Catch: JSONException -> L19
    L7:
        if (r11 == false) goto L17;
        List<BssInfo> r14 = r10.neighboring;     // Catch: JSONException -> L19
        if (r14 == null) goto L17;
        if (r14.isEmpty() == true) goto L17;
        JSONArray r15 = new JSONArray();     // Catch: JSONException -> L19
        Iterator<BssInfo> r16 = r10.neighboring.iterator();     // Catch: JSONException -> L19
    L14:
        if (r16.hasNext() == false) goto L16;
        r15.put(getBssInfoJson(r16.next()));     // Catch: JSONException -> L19
        goto L14
    L16:
        r12.put("neighboring", r15);     // Catch: JSONException -> L19
    L17:
        JSONObject r17 = new JSONObject();     // Catch: JSONException -> L19
        r17.put("base_station", r12);     // Catch: JSONException -> L19
        r8.put(LocationMonitorConst.LOCATION, r17);     // Catch: JSONException -> L19
        r8.put("upload_source", "cold_boot_get_base_station");     // Catch: JSONException -> L19
        r8.put("timestamp", System.currentTimeMillis() / 1000);     // Catch: JSONException -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    public static void convertWifiInfoToJSON(JSONObject r8, List<WifiInfo> r10) {
        if (r10 != null) goto L15;
        return;
    L15:
        JSONArray r11 = new JSONArray();     // Catch: JSONException -> L12
        Iterator<WifiInfo> r12 = r10.iterator();     // Catch: JSONException -> L12
    L6:
        if (r12.hasNext() == false) goto L10;
        WifiInfo r13 = r12.next();     // Catch: JSONException -> L12
        if (r13 == null) goto L6;
        JSONObject r14 = new JSONObject();     // Catch: JSONException -> L12
        r14.put("frequency", r13.frequency);     // Catch: JSONException -> L12
        r14.put("is_current", r13.isCurrent);     // Catch: JSONException -> L12
        r14.put(WiFiDBHelper.COL_RSSI, r13.rssi);     // Catch: JSONException -> L12
        r14.put(BwdlDropProvider.BwdlDropEntry.TIMESTAMP, r13.timeStamp);     // Catch: JSONException -> L12
        r14.put("wifi_mac", r13.wifiMac);     // Catch: JSONException -> L12
        r14.put("wifi_name", r13.wifiName);     // Catch: JSONException -> L12
        r11.put(r14);     // Catch: JSONException -> L12
        goto L6
    L10:
        JSONObject r15 = new JSONObject();     // Catch: JSONException -> L12
        r15.put("wifi_info_list", r11);     // Catch: JSONException -> L12
        r8.put(LocationMonitorConst.LOCATION, r15);     // Catch: JSONException -> L12
        r8.put("upload_source", "cold_boot_get_wifi_cache_list");     // Catch: JSONException -> L12
        r8.put("timestamp", System.currentTimeMillis() / 1000);     // Catch: JSONException -> L12
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    }

    private static JSONObject getBssInfoJson(BssInfo r8) {
        if (r8 == null) goto L4;
        JSONObject r10 = new JSONObject();
        r10.put("bid", r8.bid);     // Catch: JSONException -> L8
        r10.put("bsss", r8.bsss);     // Catch: JSONException -> L8
        r10.put("bw", r8.bw);     // Catch: JSONException -> L8
        r10.put("ci", r8.ci);     // Catch: JSONException -> L8
        r10.put(StarCellDbManager.CellInfoEntry.CID, r8.cid);     // Catch: JSONException -> L8
        r10.put("cpid", r8.cpid);     // Catch: JSONException -> L8
        r10.put("earfcn", r8.earfcn);     // Catch: JSONException -> L8
        r10.put("is_registered", r8.isRegistered);     // Catch: JSONException -> L8
        r10.put(StarCellDbManager.CellInfoEntry.LAC, r8.lac);     // Catch: JSONException -> L8
        r10.put("lat", r8.lat);     // Catch: JSONException -> L8
        r10.put("longi", r8.longi);     // Catch: JSONException -> L8
        r10.put(StarCellDbManager.CellInfoEntry.MCC, r8.mcc);     // Catch: JSONException -> L8
        r10.put(StarCellDbManager.CellInfoEntry.MNC, r8.mnc);     // Catch: JSONException -> L8
        r10.put("nci", r8.nci);     // Catch: JSONException -> L8
        r10.put("nid", r8.nid);     // Catch: JSONException -> L8
        r10.put("pci", r8.pci);     // Catch: JSONException -> L8
        r10.put("psc", r8.psc);     // Catch: JSONException -> L8
        r10.put(WiFiDBHelper.COL_RSSI, r8.rssi);     // Catch: JSONException -> L8
        r10.put(WsConstants.KEY_SESSION_ID, r8.sid);     // Catch: JSONException -> L8
        r10.put("tac", r8.tac);     // Catch: JSONException -> L8
        r10.put("timestamp", r8.timestamp);     // Catch: JSONException -> L8
        r10.put("radio_type", r8.radioType);     // Catch: JSONException -> L8
    L7:
        return r10;
    L4:
        return new JSONObject();
    }

    public static int safeOptInt(JSONObject r8, String r10, int r11) {
        if (r8 != null) goto L4;
        return r11;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L14;
        return r8.optInt(r10);
    L8:
        th = move-exception;
        th.printStackTrace();
        return r11;
    L14:
        return r11;
    }

    public static long safeOptLong(JSONObject r8, String r10, long r11) {
        if (r8 != null) goto L4;
        return r11;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L14;
        return r8.optLong(r10, r11);
    L8:
        th = move-exception;
        th.printStackTrace();
        return r11;
    L14:
        return r11;
    }

    public static String safeOptString(JSONObject r8, String r10, String r11) {
        if (r8 != null) goto L4;
        return r11;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L14;
        return r8.optString(r10);
    L8:
        th = move-exception;
        th.printStackTrace();
        return r11;
    L14:
        return r11;
    }

    public static void safePutBoolean(JSONObject r8, String r10, boolean r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L14;
        r8.put(r10, r11);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutDouble(JSONObject r8, String r10, double r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L14;
        r8.put(r10, r11);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutInt(JSONObject r8, String r10, int r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L14;
        r8.put(r10, r11);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutLong(JSONObject r8, String r10, long r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L14;
        r8.put(r10, r11);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutObject(JSONObject r8, String r10, Object r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L14;
        r8.put(r10, r11);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutString(JSONObject r8, String r10, String r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L14;
        r8.put(r10, r11);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static p safeToJsonTree(Object r8) {
        j r10 = sGson;     // Catch: Throwable -> L7
        r10.getClass();     // Catch: Throwable -> L7
        if (r8 != null) goto L5;
        p r11 = r.f8002a;     // Catch: Throwable -> L7
    L10:
        return r11;
    L5:
        Class<?> r12 = r8.getClass();     // Catch: Throwable -> L7
        g r13 = new g();     // Catch: Throwable -> L7
        r10.l(r8, r12, r13);     // Catch: Throwable -> L7
        r11 = r13.K();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Logger.d("BDLocation", "Util#safeToJsonTree occurs exception that " + th.getMessage());
        th.printStackTrace();
        return null;
    }

    public static p toJsonTreeSafely(Object r8) {
        j r10 = new j();     // Catch: Throwable -> L7
        if (r8 != null) goto L5;
        p r11 = r.f8002a;     // Catch: Throwable -> L7
    L9:
        return r11;
    L5:
        Class<?> r12 = r8.getClass();     // Catch: Throwable -> L7
        g r13 = new g();     // Catch: Throwable -> L7
        r10.l(r8, r12, r13);     // Catch: Throwable -> L7
        r11 = r13.K();     // Catch: Throwable -> L7
    L7:
        return null;
    }

    public static p toJsonTreeSafely(Object r8, Type r10) {
        j r11 = new j();     // Catch: Throwable -> L4
        g r12 = new g();     // Catch: Throwable -> L4
        r11.l(r8, r10, r12);     // Catch: Throwable -> L4
        return r12.K();
    L4:
        return null;
    }
}
