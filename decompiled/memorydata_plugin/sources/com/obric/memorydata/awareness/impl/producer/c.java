package com.obric.memorydata.awareness.impl.producer;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.AppSettingsManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J2\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0016H\u0016J\u001e\u0010\u0017\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J2\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0016H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\tj\b\u0012\u0004\u0012\u00020\u0006`\nX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00060\tj\b\u0012\u0004\u0012\u00020\u0006`\nX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/awareness/impl/producer/DeviceFeatureProducer;", "Lcom/obric/memorydata/awareness/impl/producer/AbstractFeatureProducer;", "<init>", "()V", "featureCollects", "", "", "Lcom/obric/memorydata/awareness/impl/collector/FeatureCollector;", "features", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getFeatures", "()Ljava/util/HashSet;", "needCacheFeatures", "getNeedCacheFeatures", "getFeature", "", "featureName", "setFeature", "", EventBody.KEY_VALUE, WsConstants.KEY_EXTRA, "", "collectFeatures", "featureNames", "", "collect", "", "getFeatureCollect", "dispatchWifiDisconnectIfSsidChanged", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends com.obric.memorydata.awareness.impl.producer.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8746b = null;
    private final Map<String, com.obric.memorydata.awareness.impl.collector.e> c;
    private final HashSet<String> d;
    private final HashSet<String> e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/awareness/impl/producer/DeviceFeatureProducer$Companion;", "", "<init>", "()V", "TAG", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8746b = new a(null);
    }

    public c() {
        this.c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.d = SetsKt.hashSetOf(new String[]{"device_active_network", "device_wifi", "current_wifi_ssid", "device_cellular", "device_battery", "battery_temperature", "device_is_charge", "device_is_power_save_mode", "device_screen_state", "device_lock_state", "device_foreground_app", "storage_usage_percent", "device_screen_on_reason", "device_screen_off_reason", "device_screen_unlock_reason", "device_is_assistant_wakeup", "device_assistant_wakeup_reason", "use_float_window_app", "device_active_audio", "device_screen_off_ts", "device_bluetooth", "connect_bluetooth_devices", "device_hotspot", "device_find_my_phone", "device_do_not_disturb", "device_night_mode", "device_eye_protection", "device_auto_brightness", "device_screen_brightness", "device_volume"});
        this.e = SetsKt.hashSetOf(new String[]{"device_is_charge", "device_is_power_save_mode", "device_screen_state", "device_lock_state", "device_foreground_app", "storage_usage_percent", "battery_temperature", "device_screen_on_reason", "device_screen_off_reason", "device_screen_unlock_reason", "device_is_assistant_wakeup", "device_assistant_wakeup_reason", "use_float_window_app", "device_active_audio", "device_screen_off_ts", "device_bluetooth", "connect_bluetooth_devices"});
        List<String> r1 = (List) ZeusTransformUtils.preCheckCast(AppSettingsManager.INSTANCE.getFeatureProducerSetting().getDefaultCollectMap().get("device"), List.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == true) goto L12;
        RunLog.INSTANCE.debug("DeviceFeature", "collectFeatures from settings " + r1);
    L13:
        collectFeatures(r1, true);
        return;
    L12:
        RunLog.INSTANCE.debug("DeviceFeature", "default collect all Features");
        r1 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(c(), Iterable.class, "com.obric.memorydata.plugin"));
        goto L13
    L5:
        if (r2.isEmpty() == true) goto L8;
        r3 = false;
        goto L10
    }

    private final com.obric.memorydata.awareness.impl.collector.e a(String r11) {
        if (this.c.containsKey(r11) == true) goto L5;
        com.obric.memorydata.awareness.impl.collector.e r0 = com.obric.memorydata.awareness.impl.collector.d.f8643a.a(r11);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DeviceFeature", "create " + r11 + " collector " + r0, false, 4, null);
        if (r0 == null) goto L9;
        this.c.put(r11, r0);
    L10:
        return r0;
    L9:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DeviceFeature", "create " + r11 + " collector failed", null, 4, null);
        goto L10
    L5:
        return (com.obric.memorydata.awareness.impl.collector.e) ZeusTransformUtils.preCheckCast(this.c.get(r11), com.obric.memorydata.awareness.impl.collector.e.class, "com.obric.memorydata.plugin");
    }

    private final void a(String r11, Object r12, Map<String, ? extends Object> r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r11, "device_wifi") == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r12, 3) == false) goto L44;
        Object r15 = a().get("device_wifi");
        if (ZeusTransformUtils.instanceOf(r15, Integer.class) == false) goto L10;
        Integer r16 = (Integer) ZeusTransformUtils.preCheckCast(r15, Integer.class, "com.obric.memorydata.plugin");
    L11:
        if (r16 != null) goto L13;
        return;
    L13:
        if (r16.intValue() == 3) goto L15;
        return;
    L15:
        Object r17 = a().get("current_wifi_ssid");
        if (ZeusTransformUtils.instanceOf(r17, String.class) == false) goto L18;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.memorydata.plugin");
    L19:
        if (r18 != null) goto L22;
        return;
    L22:
        if (r14 == null) goto L24;
        Object r19 = r14.get("wifi_ssid");
    L26:
        if (ZeusTransformUtils.instanceOf(r19, String.class) == false) goto L28;
        String r110 = (String) ZeusTransformUtils.preCheckCast(r19, String.class, "com.obric.memorydata.plugin");
    L29:
        if (r110 != null) goto L32;
        return;
    L32:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L34;
        return;
    L34:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r110, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L36;
        return;
    L36:
        if (Intrinsics.areEqual(r18, r110) == true) goto L45;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DeviceFeature", "dispatch wifi disconnect before ssid changed", false, 4, null);
        super.setFeature("device_wifi", 4, MapsKt.mapOf(new Pair[]{TuplesKt.to("wifi_ssid", ""), TuplesKt.to("wifi_bssid", "")}));
        super.setFeature("current_wifi_ssid", null, null);
        return;
    L45:
        return;
    L28:
        r110 = null;
        goto L29
    L24:
        r19 = null;
        goto L26
    L18:
        r18 = null;
        goto L19
    L10:
        r16 = null;
        goto L11
    }

    @Override // com.obric.memorydata.awareness.impl.producer.a
    public /* synthetic */ Set b() {
        return (Set) ZeusTransformUtils.preCheckCast(c(), Set.class, "com.obric.memorydata.plugin");
    }

    public HashSet<String> c() {
        return this.d;
    }

    @Override // com.obric.memorydata.awareness.impl.producer.a, com.obric.memorydata.awareness.api.b
    public void collectFeatures(List<String> r4, boolean r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "featureNames");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L15;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        if (c().contains(r0) == false) goto L4;
        com.obric.memorydata.awareness.impl.collector.e r1 = a(r0);
        if (r1 == null) goto L4;
        boolean r2 = r1.d();
        if (r5 == true) goto L11;
        if (r2 == false) goto L4;
        r1.c();
        goto L4
    L11:
        if (r2 == true) goto L4;
        r1.b();
        goto L4
    }

    public HashSet<String> d() {
        return this.e;
    }

    @Override // com.obric.memorydata.awareness.impl.producer.a, com.obric.memorydata.awareness.api.b
    public Object getFeature(String r7) {
        Intrinsics.checkNotNullParameter(r7, "featureName");
        if (c().contains(r7) == true) goto L6;
        RunLog.INSTANCE.debug("DeviceFeature", "getFeature not define");
        return null;
    L6:
        com.obric.memorydata.awareness.impl.collector.e r0 = a(r7);
        if (r0 != null) goto L10;
        return null;
    L10:
        if (r0.d() == true) goto L12;
    L17:
        Pair<Object, Map<String, Object>> r1 = r0.a(r7);
        RunLog.INSTANCE.debug("DeviceFeature", "getFeature name " + r7 + " from collector value " + r1);
        if (r1 == null) goto L20;
        Object r2 = r1.getFirst();
    L21:
        if (r1 == null) goto L23;
        Map<String, ? extends Object> r3 = (Map) ZeusTransformUtils.preCheckCast(r1.getSecond(), Map.class, "com.obric.memorydata.plugin");
    L24:
        setFeature(r7, r2, r3);
        if (r1 != null) goto L27;
        return null;
    L27:
        return r1.getFirst();
    L23:
        r3 = null;
        goto L24
    L20:
        r2 = null;
        goto L21
    L12:
        if (d().contains(r7) == false) goto L17;
        Object r4 = super.getFeature(r7);
        if (r4 == null) goto L17;
        RunLog.INSTANCE.debug("DeviceFeature", "getFeature name " + r7 + " from cached value " + r4);
        return r4;
    }

    @Override // com.obric.memorydata.awareness.impl.producer.a, com.obric.memorydata.awareness.api.b
    public void setFeature(String r3, Object r4, Map<String, ? extends Object> r5) {
        Map<String, ? extends Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "featureName");
        a(r3, r4, r6);
        super.setFeature(r3, r4, r6);
    }
}
