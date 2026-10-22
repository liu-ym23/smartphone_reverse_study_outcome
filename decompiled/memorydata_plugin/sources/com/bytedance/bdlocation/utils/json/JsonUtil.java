package com.bytedance.bdlocation.utils.json;

import android.location.Location;
import android.text.TextUtils;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.BaseStation;
import com.bytedance.bdlocation.network.model.BssInfo;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.utils.json.deserializer.BDLocationDeserializer;
import com.bytedance.bdlocation.utils.json.deserializer.LocationDeserializer;
import com.bytedance.bdlocation.utils.json.serializer.BDLocationSerializer;
import com.bytedance.bdlocation.utils.json.serializer.LocationSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JsonUtil {
    public static Gson sGson;

    static {
        sGson = new GsonBuilder().addDeserializationExclusionStrategy(new SuperclassExclusionStrategy()).addSerializationExclusionStrategy(new SuperclassExclusionStrategy()).registerTypeHierarchyAdapter(Location.class, new LocationSerializer()).registerTypeHierarchyAdapter(Location.class, new LocationDeserializer()).registerTypeHierarchyAdapter(BDLocation.class, new BDLocationSerializer()).registerTypeHierarchyAdapter(BDLocation.class, new BDLocationDeserializer()).create();
    }

    private JsonUtil() {
    }

    public static void convertBssInfoToJSON(JSONObject r4, BaseStation r5, boolean r6) {
        if (r5 != null) goto L22;
        return;
    L22:
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L19
        if (r5.current == null) goto L7;
        r0.put("current", getBssInfoJson(r5.current));     // Catch: JSONException -> L19
    L7:
        if (r6 == true) goto L9;
    L17:
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L19
        r7.put("base_station", r0);     // Catch: JSONException -> L19
        r4.put("location", r7);     // Catch: JSONException -> L19
        r4.put("upload_source", "cold_boot_get_base_station");     // Catch: JSONException -> L19
        r4.put("timestamp", System.currentTimeMillis() / 1000);     // Catch: JSONException -> L19
        return;
    L9:
        if (r5.neighboring == null) goto L17;
        if (r5.neighboring.isEmpty() == true) goto L17;
        JSONArray r8 = new JSONArray();     // Catch: JSONException -> L19
        Iterator<BssInfo> r9 = r5.neighboring.iterator();     // Catch: JSONException -> L19
    L14:
        if (r9.hasNext() == false) goto L16;
        r8.put(getBssInfoJson((BssInfo) ZeusTransformUtils.preCheckCast(r9.next(), BssInfo.class, "com.obric.memorydata.plugin")));     // Catch: JSONException -> L19
        goto L14
    L16:
        r0.put("neighboring", r8);     // Catch: JSONException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    public static void convertWifiInfoToJSON(JSONObject r7, List<WifiInfo> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L16;
        return;
    L16:
        JSONArray r0 = new JSONArray();     // Catch: JSONException -> L13
        Iterator r10 = r9.iterator();     // Catch: JSONException -> L13
    L7:
        if (r10.hasNext() == false) goto L11;
        WifiInfo r2 = (WifiInfo) ZeusTransformUtils.preCheckCast(r10.next(), WifiInfo.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L13
        if (r2 == null) goto L7;
        JSONObject r3 = new JSONObject();     // Catch: JSONException -> L13
        r3.put("frequency", r2.frequency);     // Catch: JSONException -> L13
        r3.put("is_current", r2.isCurrent);     // Catch: JSONException -> L13
        r3.put("rssi", r2.rssi);     // Catch: JSONException -> L13
        r3.put("Timestamp", r2.timeStamp);     // Catch: JSONException -> L13
        r3.put("wifi_mac", r2.wifiMac);     // Catch: JSONException -> L13
        r3.put("wifi_name", r2.wifiName);     // Catch: JSONException -> L13
        r0.put(r3);     // Catch: JSONException -> L13
        goto L7
    L11:
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L13
        r11.put("wifi_info_list", r0);     // Catch: JSONException -> L13
        r7.put("location", r11);     // Catch: JSONException -> L13
        r7.put("upload_source", "cold_boot_get_wifi_cache_list");     // Catch: JSONException -> L13
        r7.put("timestamp", System.currentTimeMillis() / 1000);     // Catch: JSONException -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    private static JSONObject getBssInfoJson(BssInfo r4) {
        if (r4 == null) goto L4;
        JSONObject r0 = new JSONObject();
        r0.put("bid", r4.bid);     // Catch: JSONException -> L8
        r0.put("bsss", r4.bsss);     // Catch: JSONException -> L8
        r0.put("bw", r4.bw);     // Catch: JSONException -> L8
        r0.put("ci", r4.ci);     // Catch: JSONException -> L8
        r0.put("cid", r4.cid);     // Catch: JSONException -> L8
        r0.put("cpid", r4.cpid);     // Catch: JSONException -> L8
        r0.put("earfcn", r4.earfcn);     // Catch: JSONException -> L8
        r0.put("is_registered", r4.isRegistered);     // Catch: JSONException -> L8
        r0.put("lac", r4.lac);     // Catch: JSONException -> L8
        r0.put("lat", r4.lat);     // Catch: JSONException -> L8
        r0.put("longi", r4.longi);     // Catch: JSONException -> L8
        r0.put("mcc", r4.mcc);     // Catch: JSONException -> L8
        r0.put("mnc", r4.mnc);     // Catch: JSONException -> L8
        r0.put("nci", r4.nci);     // Catch: JSONException -> L8
        r0.put("nid", r4.nid);     // Catch: JSONException -> L8
        r0.put("pci", r4.pci);     // Catch: JSONException -> L8
        r0.put("psc", r4.psc);     // Catch: JSONException -> L8
        r0.put("rssi", r4.rssi);     // Catch: JSONException -> L8
        r0.put("sid", r4.sid);     // Catch: JSONException -> L8
        r0.put("tac", r4.tac);     // Catch: JSONException -> L8
        r0.put("timestamp", r4.timestamp);     // Catch: JSONException -> L8
        r0.put("radio_type", r4.radioType);     // Catch: JSONException -> L8
    L7:
        return r0;
    L4:
        return new JSONObject();
    }

    public static int safeOptInt(JSONObject r1, String r2, int r3) {
        if (r1 != null) goto L4;
        return r3;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        return r1.optInt(r2);
    L8:
        th = move-exception;
        th.printStackTrace();
        return r3;
    L14:
        return r3;
    }

    public static long safeOptLong(JSONObject r1, String r2, long r3) {
        if (r1 != null) goto L4;
        return r3;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        return r1.optLong(r2, r3);
    L8:
        th = move-exception;
        th.printStackTrace();
        return r3;
    L14:
        return r3;
    }

    public static String safeOptString(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L4;
        return r3;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        return r1.optString(r2);
    L8:
        th = move-exception;
        th.printStackTrace();
        return r3;
    L14:
        return r3;
    }

    public static void safePutBoolean(JSONObject r1, String r2, boolean r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r1.put(r2, r3);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutDouble(JSONObject r1, String r2, double r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r1.put(r2, r3);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutInt(JSONObject r1, String r2, int r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r1.put(r2, r3);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutLong(JSONObject r1, String r2, long r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r1.put(r2, r3);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutObject(JSONObject r1, String r2, Object r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r1.put(r2, r3);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutString(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r1.put(r2, r3);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static JsonElement safeToJsonTree(Object r2) {
        return sGson.toJsonTree(r2);
    L4:
        th = move-exception;
        Logger.d("BDLocation", "Util#safeToJsonTree occurs exception that " + th.getMessage());
        th.printStackTrace();
        return null;
    }

    public static JsonElement toJsonTreeSafely(Object r1) {
        return new Gson().toJsonTree(r1);
    L4:
        return null;
    }

    public static JsonElement toJsonTreeSafely(Object r2, Type r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        return new Gson().toJsonTree(r2, r4);
    L5:
        return null;
    }
}
