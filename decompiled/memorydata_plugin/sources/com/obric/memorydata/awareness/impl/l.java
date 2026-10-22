package com.obric.memorydata.awareness.impl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0002J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0002J>\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0002J \u0010$\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0002J:\u0010%\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u0010'\u001a\u00020\u001c2\u0010\u0010!\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00050\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/memorydata/awareness/impl/SupportedFeatureListProvider;", "", "<init>", "()V", "TAG", "", "LEAVE_POI_MIN_COMMSENSE_AAR_VERSION", "KIND_FEATURE", "KIND_EVENT", "KEY_KIND", "KEY_NAME", "KEY_VALUE_TYPE", "KEY_ENUMS", "KEY_EXTRAS", "KEY_DEFAULT", "MESSAGE_RAW_TABLE", "ICS_PROTOCOL_RAW_TABLE", "PROACTIVE_OS_NOTIFICATION_TABLE", "AUTO_MEMORY_PRO_TABLE", "ALARM_RAW_TABLE", "SHORT_MEMORY_RAW_TABLE", "logger", "Lcom/obric/memorydata/middleware/api/logging/ModuleLogger;", "getSupportedFeatureList", "", "isLeavePoiSupported", "", "poiEventExtras", "Lorg/json/JSONObject;", "aoiEventExtras", "feature", ActivityLifecycle.NAME, "valueType", "enums", "", "extras", "event", WsConstants.KEY_EXTRA, "defaultValue", "toEnumJson", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f8716a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final o f8717b = null;

    static {
        f8716a = new l();
        f8717b = com.obric.memorydata.middleware.api.logging.b.f11611a.a("SupportedFeatureListProvider");
    }

    private l() {
    }

    static /* synthetic */ String a(l r1, String r2, String r3, Map r4, List r5, int r6, Object r7) {
        Map<?, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        List<? extends JSONObject> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r8 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r9 = CollectionsKt.emptyList();
    L9:
        return r1.a(r2, r3, r8, r9);
    }

    static /* synthetic */ String a(l r1, String r2, List r3, int r4, Object r5) {
        List<? extends JSONObject> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r6 = CollectionsKt.emptyList();
    L6:
        return r1.a(r2, r6);
    }

    private final String a(String r4, String r5, Map<?, String> r6, List<? extends JSONObject> r7) {
        Map<?, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        JSONObject r9 = new JSONObject();
        r9.put(MemoryInfoSectionEditActivity.EXTRA_KIND, "feature");
        r9.put(ActivityLifecycle.NAME, r4);
        r9.put("value_type", r5);
        if (r3 == null) goto L11;
        if ((!r3.isEmpty()) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L11;
        r9.put("enums", f8716a.a(r3));
    L11:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L14;
        r8 = null;
    L14:
        if (r8 == null) goto L16;
        r9.put("extras", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")));
    L16:
        String r10 = r9.toString();
        Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");
        return r10;
    }

    private final String a(String r4, List<? extends JSONObject> r5) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        JSONObject r6 = new JSONObject();
        r6.put(MemoryInfoSectionEditActivity.EXTRA_KIND, "event");
        r6.put(ActivityLifecycle.NAME, r4);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L6;
        r3 = null;
    L6:
        if (r3 == null) goto L8;
        r6.put("extras", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")));
    L8:
        String r7 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        return r7;
    }

    static /* synthetic */ JSONObject a(l r1, String r2, String r3, Map r4, Object r5, int r6, Object r7) {
        Map<?, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r8 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = null;
    L9:
        return r1.a(r2, r3, r8, r5);
    }

    private final JSONObject a(String r2, String r3, Map<?, String> r4, Object r5) {
        Map<?, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        JSONObject r6 = new JSONObject();
        r6.put(ActivityLifecycle.NAME, r2);
        r6.put("value_type", r3);
        if (r1 != null) goto L5;
    L10:
        if (r5 == null) goto L12;
        r6.put("default", r5);
    L12:
        return r6;
    L5:
        if ((!r1.isEmpty()) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        r6.put("enums", f8716a.a(r1));
        goto L10
    }

    private final JSONObject a(Map<?, String> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        JSONObject r6 = new JSONObject();
        Iterator r7 = r4.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r2 = r1.getKey();
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.memorydata.plugin");
        r6.put(String.valueOf(r2), r3);
        goto L4
    L6:
        return r6;
    }

    private final boolean b() {
        String r4 = com.obric.memorydata.awareness.cae.b.f8563a.e();
        if (r4 != null) goto L5;
        return false;
    L5:
        String r5 = StringsKt.substringBefore$default(r4, '-', null, 2, null);
        if (com.obric.memorydata.utils.d.f13204a.a(r5, "1.0.10.20") < 0) goto L9;
        return true;
    L9:
        return false;
    }

    private final List<JSONObject> c() {
        return CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(d(), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new JSONObject[]{a(this, "poi_id", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "poi_name", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "category_l1", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "category_l2", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "category_l3", TypedValues.Custom.S_STRING, null, null, 12, null)}), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private final List<JSONObject> d() {
        return CollectionsKt.listOf(new JSONObject[]{a(this, "aoi_id", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "aoi_name", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "aoi_type", TypedValues.Custom.S_STRING, null, null, 12, null)});
    }

    public final List<String> a() {
        List<String> r0 = CollectionsKt.listOf(new String[]{a(this, "har_activity_state", "int", MapsKt.mapOf(new Pair[]{TuplesKt.to(4, IRecommendSettings.ProfileTag.OTHER), TuplesKt.to(5, "地铁"), TuplesKt.to(6, "自行车"), TuplesKt.to(7, "电动车"), TuplesKt.to(8, "汽车")}), null, 8, null), a("precise_har_state", TypedValues.Custom.S_STRING, MapsKt.mapOf(new Pair[]{TuplesKt.to("PreciseWalking", "走路"), TuplesKt.to("PreciseRunning", "跑步"), TuplesKt.to("PreciseStill", "静止"), TuplesKt.to("", "未知")}), CollectionsKt.listOf(a(this, "total_exercise_duration", "map", MapsKt.mapOf(new Pair[]{TuplesKt.to("car", "car"), TuplesKt.to("bike", "bike"), TuplesKt.to("subway", "subway"), TuplesKt.to("still", "still"), TuplesKt.to("walk", "walk"), TuplesKt.to("run", "run")}), null, 8, null))), a(this, "location_home_gps", "double[]", null, null, 12, null), a(this, "HOME_GPS_FENCE_LIST", "object", null, null, 12, null), a(this, "location_company_gps", "double[]", null, null, 12, null), a(this, "ohr_hand", "int", MapsKt.mapOf(new Pair[]{TuplesKt.to(1, "左手"), TuplesKt.to(2, "右手"), TuplesKt.to(3, "无操作手")}), null, 8, null), a(this, "commute_state", TypedValues.Custom.S_STRING, MapsKt.mapOf(new Pair[]{TuplesKt.to("inactive", "当前未通勤"), TuplesKt.to("commuting_to_home", "正在通勤回家"), TuplesKt.to("commuting_to_company", "正在通勤去公司")}), null, 8, null), a(this, "commute_main_har_state_result", "object", null, null, 12, null), a(this, "wakeup_moment", "object", null, null, 12, null), a(this, "sleep_moment", "object", null, null, 12, null), a(this, "wake_sleep_state", TypedValues.Custom.S_STRING, MapsKt.mapOf(new Pair[]{TuplesKt.to("sleep", "入睡"), TuplesKt.to("wake", "清醒")}), null, 8, null), a(this, "commute_cluster_result", "object", null, null, 12, null), a("device_wifi", "int", MapsKt.mapOf(new Pair[]{TuplesKt.to(1, "Wi-Fi开"), TuplesKt.to(2, "Wi-Fi关"), TuplesKt.to(3, "已连接"), TuplesKt.to(4, "未连接")}), CollectionsKt.listOf(new JSONObject[]{a(this, "wifi_ssid", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "wifi_bssid", TypedValues.Custom.S_STRING, null, null, 12, null)})), a(this, "current_wifi_ssid", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "device_cellular", "int", MapsKt.mapOf(new Pair[]{TuplesKt.to(3, "已连接"), TuplesKt.to(2, "可用"), TuplesKt.to(1, "不可用")}), null, 8, null), a(this, "today_day_type", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "device_battery", "double", null, CollectionsKt.listOf(a(this, "battery_remaining_time", "long", null, null, 12, null)), 4, null), a(this, "battery_temperature", TypedValues.Custom.S_FLOAT, null, null, 12, null), a(this, "device_is_charge", "bool", null, null, 12, null), a(this, "device_is_power_save_mode", "bool", null, null, 12, null), a(this, "device_screen_state", "int", MapsKt.mapOf(new Pair[]{TuplesKt.to(0, "灭屏"), TuplesKt.to(1, "亮屏")}), null, 8, null), a(this, "device_screen_on_reason", TypedValues.Custom.S_STRING, MapsKt.mapOf(new Pair[]{TuplesKt.to("powerkey", "单击物理键"), TuplesKt.to("handup", "抬手"), TuplesKt.to("unknown", "不明确原因")}), null, 8, null), a(this, "device_screen_off_reason", TypedValues.Custom.S_STRING, MapsKt.mapOf(new Pair[]{TuplesKt.to("powerkey", "单击物理键"), TuplesKt.to(LocationMonitorConst.TIMEOUT, "自动熄屏"), TuplesKt.to("unknown", "不明确原因")}), null, 8, null), a(this, "device_foreground_app", TypedValues.Custom.S_STRING, null, CollectionsKt.listOf(a(this, Api.KEY_APP_NAME, TypedValues.Custom.S_STRING, null, null, 12, null)), 4, null), a(this, "storage_usage_percent", TypedValues.Custom.S_FLOAT, null, null, 12, null), a("current_location_type", TypedValues.Custom.S_STRING, MapsKt.mapOf(new Pair[]{TuplesKt.to("home", "家"), TuplesKt.to("company", "公司"), TuplesKt.to("none", "已判断，当前不属于已识别地点"), TuplesKt.to("airport", "机场"), TuplesKt.to("subway_station", "地铁站"), TuplesKt.to("railway_station", "火车站"), TuplesKt.to("mall", "商场"), TuplesKt.to("null", "未知、未初始化或暂无判断结果")}), CollectionsKt.listOf(new JSONObject[]{a(this, "airport_name", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "station_name", TypedValues.Custom.S_STRING, null, null, 12, null)})), a(this, "current_location_info", "object", null, null, 12, null), a(this, "current_geofences", "object[]", null, null, 12, null), a(EventNames.RECEIVE_NOTIFICATION, CollectionsKt.listOf(new JSONObject[]{a(this, "raw_table", TypedValues.Custom.S_STRING, null, "ProactiveOsNotification", 4, null), a(this, "package_name", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, Api.KEY_APP_NAME, TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "title", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, Params.CONTENT, TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "category_list", "string[]", EventNames.a.f12816b, null, 8, null), a(this, "timestamp", "long", null, null, 12, null), a(this, "raw_id", "long", null, null, 12, null)})), a(EventNames.RECORDING_SUMMARY_GENERATED, CollectionsKt.listOf(new JSONObject[]{a(this, "raw_table", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "raw_id", "long", null, null, 12, null), a(this, "package_name", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, Api.KEY_APP_NAME, TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "summary", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "create_time", "long", null, null, 12, null), a(this, "end_time", "long", null, null, 12, null), a(this, "current_time", "long", null, null, 12, null)})), a(EventNames.RECEIVE_SMS, CollectionsKt.listOf(new JSONObject[]{a(this, "raw_table", TypedValues.Custom.S_STRING, null, "RawMessageEntity", 4, null), a(this, "sender", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "contact_name", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, Params.CONTENT, TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "category_list", "string[]", EventNames.a.f12816b, null, 8, null), a(this, "timestamp", "long", null, null, 12, null), a(this, "raw_id", "long", null, null, 12, null)})), a(EventNames.BLUETOOTH_DEVICE_CONNECTED, CollectionsKt.listOf(new JSONObject[]{a(this, "device_name", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "device_address", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "battery_level", "int", null, null, 12, null)})), a(EventNames.SEND_SMS, CollectionsKt.listOf(new JSONObject[]{a(this, "raw_table", TypedValues.Custom.S_STRING, null, "RawMessageEntity", 4, null), a(this, "receiver", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "contact_name", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, Params.CONTENT, TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "timestamp", "long", null, null, 12, null), a(this, "raw_id", "long", null, null, 12, null)})), a(EventNames.CALENDAR_EVENT_CHANGED, CollectionsKt.listOf(new JSONObject[]{a(this, "raw_table", TypedValues.Custom.S_STRING, null, "RawICSProtocolEntity", 4, null), a(this, "raw_id", "long", null, null, 12, null), a(this, "operation", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "icalendar_event", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "old_icalendar_event", TypedValues.Custom.S_STRING, null, null, 12, null)})), a(EventNames.AUTO_MEMORY_CHANGED, CollectionsKt.listOf(new JSONObject[]{a(this, "raw_table", TypedValues.Custom.S_STRING, null, "AutoMemoryPro", 4, null), a(this, "raw_id", "long", null, null, 12, null), a(this, "rule_id", "long", null, null, 12, null), a(this, AILabCheckPermissionTask.KEY_SOURCE, TypedValues.Custom.S_STRING, null, AutoMemoryViewModel.SOURCE_AI_PROACTIVE, 4, null), a(this, "title", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, Params.CONTENT, TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "create_time", "long", null, null, 12, null), a(this, "timestamp", "long", null, null, 12, null)})), a(EventNames.ALARM_CHANGED, CollectionsKt.listOf(new JSONObject[]{a(this, "raw_table", TypedValues.Custom.S_STRING, null, "RawAlarmEntity", 4, null), a(this, "raw_id", "long", null, null, 12, null), a(this, "operation", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "package_name", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "alarm_name", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "ring_time", TypedValues.Custom.S_STRING, null, null, 12, null), a(this, "alarm_enabled", "bool", null, null, 12, null), a(this, "repeat_type", "int", null, null, 12, null), a(this, "repeat_day_of_week", "int[]", null, null, 12, null), a(this, "close_in_holiday", "bool", null, null, 12, null), a(this, "old_alarm", "object", null, null, 12, null)})), a(EventNames.EPISODIC_MEMORY_CHANGED, CollectionsKt.listOf(new JSONObject[]{a(this, "raw_table", TypedValues.Custom.S_STRING, null, "ShortMemory", 4, null), a(this, "raw_id", "long", null, null, 12, null), a(this, "operation", TypedValues.Custom.S_STRING, null, null, 12, null)})), a(this, EventNames.ARRIVE_HOME, null, 2, null), a(this, EventNames.LEAVE_HOME, null, 2, null), a(this, EventNames.ARRIVE_COMPANY, null, 2, null), a(this, EventNames.LEAVE_COMPANY, null, 2, null), a(this, EventNames.ARRIVE_HOME_ENTRANCE, null, 2, null), a(this, EventNames.LEAVE_HOME_ENTRANCE, null, 2, null), a(this, EventNames.ARRIVE_COMPANY_ENTRANCE, null, 2, null), a(this, EventNames.LEAVE_COMPANY_ENTRANCE, null, 2, null), a(EventNames.GEOFENCE_ENTERED, CollectionsKt.listOf(a(this, "fence_id", TypedValues.Custom.S_STRING, null, null, 12, null))), a(EventNames.GEOFENCE_EXITED, CollectionsKt.listOf(a(this, "fence_id", TypedValues.Custom.S_STRING, null, null, 12, null))), a(EventNames.ENTER_HOME_GEOFENCE, CollectionsKt.listOf(a(this, "fence_id", TypedValues.Custom.S_STRING, null, null, 12, null))), a(EventNames.EXIT_HOME_GEOFENCE, CollectionsKt.listOf(a(this, "fence_id", TypedValues.Custom.S_STRING, null, null, 12, null))), a(EventNames.ENTER_COMPANY_GEOFENCE, CollectionsKt.listOf(a(this, "fence_id", TypedValues.Custom.S_STRING, null, null, 12, null))), a(EventNames.EXIT_COMPANY_GEOFENCE, CollectionsKt.listOf(a(this, "fence_id", TypedValues.Custom.S_STRING, null, null, 12, null))), a(EventNames.ENTER_AIRPORT, d()), a(EventNames.EXIT_AIRPORT, d()), a(EventNames.ENTER_SUBWAY_STATION, d()), a(EventNames.EXIT_SUBWAY_STATION, d()), a(EventNames.ENTER_RAILWAY_STATION, d()), a(EventNames.EXIT_RAILWAY_STATION, d()), a(EventNames.ENTER_MALL, d()), a(EventNames.EXIT_MALL, d()), a(EventNames.ARRIVE_POI, c())});
        if (b() == false) goto L9;
        o r1 = f8717b;
        com.obric.memorydata.middleware.api.logging.e r2 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L8;
        com.obric.memorydata.middleware.api.logging.g r3 = new com.obric.memorydata.middleware.api.logging.g();
        Unit r4 = Unit.INSTANCE;
        r1.a("CommSenseAAR 支持 leave_poi，已加入支持事件列表", r2, r3.a());
    L8:
        return CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), a(EventNames.LEAVE_POI, c()));
    L9:
        return r0;
    }
}
