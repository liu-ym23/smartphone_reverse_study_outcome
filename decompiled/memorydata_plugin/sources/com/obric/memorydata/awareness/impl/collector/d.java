package com.obric.memorydata.awareness.impl.collector;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.memorydata.ability.data.DeviceAudioStandardData;
import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.data.m;
import com.obric.memorydata.ability.data.o;
import com.obric.memorydata.ability.data.p;
import com.obric.memorydata.ability.data.r;
import com.obric.memorydata.ability.data.u;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J:\u0010\u0018\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J:\u0010\u001c\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020!H\u0002J\u001e\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001a2\u0006\u0010\u0016\u001a\u00020!H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u001eH\u0002J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J:\u0010&\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J:\u0010(\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J:\u0010*\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J:\u0010,\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010-\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J:\u0010.\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J:\u0010/\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u00100\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u00101\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J:\u00102\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u00103\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J:\u00104\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007¨\u00065"}, d2 = {"Lcom/obric/memorydata/awareness/impl/collector/DeviceFeatureCollectorFactory;", "", "<init>", "()V", "wifiFeatureCollector", "Lcom/obric/memorydata/awareness/impl/collector/AbilityFeatureCollector;", "getWifiFeatureCollector", "()Lcom/obric/memorydata/awareness/impl/collector/AbilityFeatureCollector;", "wifiFeatureCollector$delegate", "Lkotlin/Lazy;", "screenFeatureCollector", "getScreenFeatureCollector", "screenFeatureCollector$delegate", "batteryFeatureCollector", "getBatteryFeatureCollector", "batteryFeatureCollector$delegate", "createFeatureCollector", "Lcom/obric/memorydata/awareness/impl/collector/FeatureCollector;", "featureName", "", "networkProcess", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "networkQueryProcess", "Lkotlin/Pair;", "", "wifiProcess", "wifiQueryProcess", "getActiveNetwork", "Lcom/obric/memorydata/ability/data/NetworkStatusStandardData;", "getWifiFeatureValue", "", "Lcom/obric/memorydata/ability/data/WifiStandardData;", "getWifiFeatureExtra", "getCurrentWifiSsid", "getCellularFeatureValue", "bluetoothProcess", "bluetoothQueryProcess", "screenStateProcess", "screenStateQuery", "lockStateProcess", "lockStateQueryProcess", "batteryProcess", "batteryQueryProcess", "floatWindowProcess", "floatWindowQueryProcess", "audioQueryProcess", "audioProcess", "brightnessProcess", "brightnessQueryProcess", "volumeProcess", "volumeQueryProcess", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8643a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f8644b = null;
    private static final Lazy c = null;
    private static final Lazy d = null;

    static {
        f8643a = new d();
        f8644b = LazyKt.lazy($$Lambda$d$yHyRWMg6bAvRpz9sp8gOT1fIRO8.INSTANCE);
        c = LazyKt.lazy($$Lambda$d$gt6VzTx5PtXVKg26icyvo6zKk.INSTANCE);
        d = LazyKt.lazy($$Lambda$d$mPNjgLw5XdmeVqgRLoic_OMLFbY.INSTANCE);
    }

    private d() {
    }

    private final int a(u r4) {
        int r3 = r4.a();
        if (r3 == 1) goto L9;
        if (r3 == 2) goto L12;
        if (r3 != 3) goto L11;
        return 3;
    L11:
        return 4;
    L12:
        return 2;
    L9:
        return 1;
    }

    private final a a() {
        return (a) ZeusTransformUtils.preCheckCast(f8644b.getValue(), a.class, "com.obric.memorydata.plugin");
    }

    private final String a(m r3) {
        if ((r3.b() & 2) != 2) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return "WI-FI";
    L9:
        if ((r3.b() & 1) != 1) goto L11;
        return "cellular";
    L11:
        return "none";
    L5:
        r2 = false;
        goto L6
    }

    private final Pair<Object, Map<String, Object>> a(h r4, String r5) {
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, m.class) == true) goto L5;
    L12:
        return null;
    L5:
        if (Intrinsics.areEqual(r5, "device_active_network") == false) goto L10;
        Object r3 = a((m) ZeusTransformUtils.preCheckCast(r6, m.class, "com.obric.memorydata.plugin"));
    L8:
        return TuplesKt.to(r3, null);
    L10:
        if (Intrinsics.areEqual(r5, "device_cellular") == false) goto L12;
        r3 = Integer.valueOf(b((m) ZeusTransformUtils.preCheckCast(r6, m.class, "com.obric.memorydata.plugin")));
        goto L8
    }

    public static final /* synthetic */ Pair a(d r2, h r3, String r4) {
        return r2.a((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void a(h r9) {
        h r10 = (h) ZeusTransformUtils.wrapperContextForParams(r9, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, m.class) == false) goto L6;
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "device_active_network", a((m) ZeusTransformUtils.preCheckCast(r10, m.class, "com.obric.memorydata.plugin")), null, 4, null);
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "device_cellular", Integer.valueOf(b((m) ZeusTransformUtils.preCheckCast(r10, m.class, "com.obric.memorydata.plugin"))), null, 4, null);
        return;
    }

    public static final /* synthetic */ void a(d r2, h r3) {
        r2.a((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"));
    }

    private final int b(m r3) {
        boolean r1 = false;
        if ((r3.b() & 1) != 1) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return 3;
    L9:
        if ((r3.a() & 1) != 1) goto L11;
        r1 = true;
    L11:
        if (r1 == false) goto L15;
        return 2;
    L15:
        return 1;
    L5:
        r2 = false;
        goto L6
    }

    private final a b() {
        return (a) ZeusTransformUtils.preCheckCast(c.getValue(), a.class, "com.obric.memorydata.plugin");
    }

    private final Map<String, Object> b(u r4) {
        if (r4.a() == 3) goto L9;
        if (r4.a() == 4) goto L9;
        return MapsKt.emptyMap();
    L9:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("wifi_ssid", r4.c()), TuplesKt.to("wifi_bssid", r4.b())});
    }

    private final Pair<Object, Map<String, Object>> b(h r4, String r5) {
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, u.class) == true) goto L5;
    L12:
        return null;
    L5:
        if (Intrinsics.areEqual(r5, "device_wifi") == false) goto L9;
        return TuplesKt.to(Integer.valueOf(a((u) ZeusTransformUtils.preCheckCast(r6, u.class, "com.obric.memorydata.plugin"))), b((u) ZeusTransformUtils.preCheckCast(r6, u.class, "com.obric.memorydata.plugin")));
    L9:
        if (Intrinsics.areEqual(r5, "current_wifi_ssid") == false) goto L12;
        return TuplesKt.to(c((u) ZeusTransformUtils.preCheckCast(r6, u.class, "com.obric.memorydata.plugin")), null);
    }

    public static final /* synthetic */ Pair b(d r2, h r3, String r4) {
        return r2.e((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void b(h r9) {
        h r10 = (h) ZeusTransformUtils.wrapperContextForParams(r9, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, u.class) == false) goto L6;
        FeatureManager.INSTANCE.setFeature("device_wifi", Integer.valueOf(a((u) ZeusTransformUtils.preCheckCast(r10, u.class, "com.obric.memorydata.plugin"))), b((u) ZeusTransformUtils.preCheckCast(r10, u.class, "com.obric.memorydata.plugin")));
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "current_wifi_ssid", c((u) ZeusTransformUtils.preCheckCast(r10, u.class, "com.obric.memorydata.plugin")), null, 4, null);
        return;
    }

    public static final /* synthetic */ void b(d r2, h r3) {
        r2.e((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"));
    }

    private final a c() {
        return (a) ZeusTransformUtils.preCheckCast(d.getValue(), a.class, "com.obric.memorydata.plugin");
    }

    private final String c(u r3) {
        int r2 = r3.a();
        if (r2 != 2) goto L5;
        return null;
    L5:
        if (r2 == 3) goto L8;
        return null;
    L8:
        return r3.c();
    }

    private final Pair<Object, Map<String, Object>> c(h r1, String r2) {
        h r0 = (h) ZeusTransformUtils.wrapperContextForParams(r1, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.ability.data.b.class) == true) goto L5;
        return null;
    L5:
        return TuplesKt.to(r0, null);
    }

    public static final /* synthetic */ Pair c(d r2, h r3, String r4) {
        return r2.g((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void c(h r8) {
        h r3 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.ability.data.b.class) == false) goto L6;
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "device_bluetooth", r3, null, 4, null);
        return;
    }

    public static final /* synthetic */ void c(d r2, h r3) {
        r2.g((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"));
    }

    private static final a d() {
        com.obric.memorydata.ability.f r0 = new com.obric.memorydata.ability.f(100000002, MapsKt.emptyMap());
        d r3 = f8643a;
        return new a(r0, (Function1) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$wifiFeatureCollector$2$1(r3), Function1.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$wifiFeatureCollector$2$2(r3), Function2.class, "com.obric.memorydata.plugin"));
    }

    private final Pair<Object, Map<String, Object>> d(h r7, String r8) {
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r7, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, p.class) == false) goto L41;
        int r9 = r8.hashCode();
        if (r9 == (-1713672418)) goto L36;
        if (r9 == (-1500205497)) goto L23;
        if (r9 != (-1491789990)) goto L41;
        if (r8.equals("device_screen_on_reason") == false) goto L41;
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r6, p.class, "com.obric.memorydata.plugin")).a(), com.tom_roush.pdfbox.pdmodel.a.d.f.f) == false) goto L20;
    L16:
        Object r10 = ((p) ZeusTransformUtils.preCheckCast(r6, p.class, "com.obric.memorydata.plugin")).b();
    L18:
        return TuplesKt.to(r10, null);
    L20:
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r6, p.class, "com.obric.memorydata.plugin")).a(), "unlock") == false) goto L41;
        r10 = ((p) ZeusTransformUtils.preCheckCast(r6, p.class, "com.obric.memorydata.plugin")).c();
        goto L18
    L23:
        if (r8.equals("device_screen_state") == false) goto L41;
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r6, p.class, "com.obric.memorydata.plugin")).a(), com.tom_roush.pdfbox.pdmodel.a.d.f.f) == false) goto L28;
    L34:
        int r11 = 1;
    L33:
        r10 = Integer.valueOf(r11);
        goto L18
    L28:
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r6, p.class, "com.obric.memorydata.plugin")).a(), "unlock") == true) goto L34;
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r6, p.class, "com.obric.memorydata.plugin")).a(), com.tom_roush.pdfbox.pdmodel.a.d.f.g) == false) goto L41;
        r11 = 0;
        goto L33
    L36:
        if (r8.equals("device_screen_off_reason") == false) goto L41;
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r6, p.class, "com.obric.memorydata.plugin")).a(), com.tom_roush.pdfbox.pdmodel.a.d.f.g) == true) goto L16;
    L41:
        return null;
    }

    public static final /* synthetic */ Pair d(d r2, h r3, String r4) {
        return r2.h((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void d(h r8) {
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, p.class) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.memorydata.plugin")).a(), com.tom_roush.pdfbox.pdmodel.a.d.f.f) == false) goto L9;
        Map r4 = null;
        int r5 = 4;
        Object r6 = null;
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "device_screen_state", 1, null, 4, null);
        com.obric.memorydata.awareness.api.b r1 = (com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin");
        String r3 = ((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.memorydata.plugin")).b();
        String r2 = "device_screen_on_reason";
    L7:
        com.obric.memorydata.awareness.api.b.a.a(r1, r2, r3, r4, r5, r6);
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "device_screen_off_ts", Long.valueOf(((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.memorydata.plugin")).d()), r4, r5, r6);
        return;
    L9:
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.memorydata.plugin")).a(), com.tom_roush.pdfbox.pdmodel.a.d.f.g) == false) goto L13;
        r4 = null;
        r5 = 4;
        r6 = null;
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "device_screen_state", 0, null, 4, null);
        r1 = (com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin");
        r3 = ((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.memorydata.plugin")).b();
        r2 = "device_screen_off_reason";
        goto L7
    }

    public static final /* synthetic */ void d(d r2, h r3) {
        r2.h((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"));
    }

    private static final a e() {
        com.obric.memorydata.ability.f r0 = new com.obric.memorydata.ability.f(100000005, MapsKt.mapOf(TuplesKt.to("mode", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL)));
        d r3 = f8643a;
        return new a(r0, (Function1) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$screenFeatureCollector$2$1(r3), Function1.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$screenFeatureCollector$2$2(r3), Function2.class, "com.obric.memorydata.plugin"));
    }

    private final Pair<Object, Map<String, Object>> e(h r4, String r5) {
        h r3 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, p.class) == true) goto L5;
    L23:
        return null;
    L5:
        if (Intrinsics.areEqual(r5, "device_lock_state") == false) goto L19;
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.memorydata.plugin")).a(), com.tom_roush.pdfbox.pdmodel.a.d.f.g) == false) goto L9;
    L17:
        int r6 = 0;
    L14:
        Object r7 = Integer.valueOf(r6);
    L16:
        return TuplesKt.to(r7, null);
    L9:
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.memorydata.plugin")).a(), com.tom_roush.pdfbox.pdmodel.a.d.f.f) == true) goto L17;
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.memorydata.plugin")).a(), "unlock") == false) goto L23;
        r6 = 1;
        goto L14
    L19:
        if (Intrinsics.areEqual(r5, "device_screen_unlock_reason") == false) goto L23;
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.memorydata.plugin")).a(), "unlock") == false) goto L23;
        r7 = ((p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.memorydata.plugin")).b();
        goto L16
    }

    public static final /* synthetic */ Pair e(d r2, h r3, String r4) {
        return r2.c((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void e(h r8) {
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, p.class) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.memorydata.plugin")).a(), "unlock") == false) goto L8;
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "device_lock_state", 1, null, 4, null);
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "device_screen_unlock_reason", ((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.memorydata.plugin")).b(), null, 4, null);
        return;
    L8:
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.memorydata.plugin")).a(), com.tom_roush.pdfbox.pdmodel.a.d.f.g) == false) goto L13;
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "device_lock_state", 0, null, 4, null);
        return;
    }

    public static final /* synthetic */ void e(d r2, h r3) {
        r2.c((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"));
    }

    private static final a f() {
        com.obric.memorydata.ability.f r0 = new com.obric.memorydata.ability.f(100000010, MapsKt.emptyMap());
        d r3 = f8643a;
        return new a(r0, (Function1) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$batteryFeatureCollector$2$1(r3), Function1.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$batteryFeatureCollector$2$2(r3), Function2.class, "com.obric.memorydata.plugin"));
    }

    private final Pair<Object, Map<String, Object>> f(h r4, String r5) {
        h r3 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.ability.data.a.class) == true) goto L5;
    L27:
        return null;
    L5:
        switch(r5.hashCode()) {
            case -1439533888: goto L23;
            case -1410521534: goto L18;
            case -1142385697: goto L13;
            case 1648082212: goto L8;
            default: goto L27;
        };
    L8:
        if (r5.equals("device_battery") == false) goto L27;
        return TuplesKt.to(Double.valueOf(((com.obric.memorydata.ability.data.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.ability.data.a.class, "com.obric.memorydata.plugin")).a()), MapsKt.mapOf(TuplesKt.to("battery_remaining_time", Long.valueOf(((com.obric.memorydata.ability.data.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.ability.data.a.class, "com.obric.memorydata.plugin")).e()))));
    L13:
        if (r5.equals("device_is_power_save_mode") == false) goto L27;
        return TuplesKt.to(Boolean.valueOf(((com.obric.memorydata.ability.data.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.ability.data.a.class, "com.obric.memorydata.plugin")).d()), MapsKt.mapOf(TuplesKt.to("power", Double.valueOf(((com.obric.memorydata.ability.data.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.ability.data.a.class, "com.obric.memorydata.plugin")).a()))));
    L18:
        if (r5.equals("battery_temperature") == false) goto L27;
        return TuplesKt.to(Float.valueOf(((com.obric.memorydata.ability.data.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.ability.data.a.class, "com.obric.memorydata.plugin")).b() / 10.0f), null);
    L23:
        if (r5.equals("device_is_charge") == false) goto L27;
        return TuplesKt.to(Boolean.valueOf(((com.obric.memorydata.ability.data.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.ability.data.a.class, "com.obric.memorydata.plugin")).c()), MapsKt.mapOf(TuplesKt.to("power", Double.valueOf(((com.obric.memorydata.ability.data.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.ability.data.a.class, "com.obric.memorydata.plugin")).a()))));
    }

    public static final /* synthetic */ Pair f(d r2, h r3, String r4) {
        return r2.i((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void f(h r8) {
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, com.obric.memorydata.ability.data.a.class) == false) goto L6;
        FeatureManager.INSTANCE.setFeature("device_battery", Double.valueOf(((com.obric.memorydata.ability.data.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.ability.data.a.class, "com.obric.memorydata.plugin")).a()), MapsKt.mapOf(TuplesKt.to("battery_remaining_time", Long.valueOf(((com.obric.memorydata.ability.data.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.ability.data.a.class, "com.obric.memorydata.plugin")).e()))));
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "battery_temperature", Float.valueOf(((com.obric.memorydata.ability.data.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.ability.data.a.class, "com.obric.memorydata.plugin")).b() / 10.0f), null, 4, null);
        FeatureManager.INSTANCE.setFeature("device_is_charge", Boolean.valueOf(((com.obric.memorydata.ability.data.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.ability.data.a.class, "com.obric.memorydata.plugin")).c()), MapsKt.mapOf(TuplesKt.to("power", Double.valueOf(((com.obric.memorydata.ability.data.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.ability.data.a.class, "com.obric.memorydata.plugin")).a()))));
        FeatureManager.INSTANCE.setFeature("device_is_power_save_mode", Boolean.valueOf(((com.obric.memorydata.ability.data.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.ability.data.a.class, "com.obric.memorydata.plugin")).d()), MapsKt.mapOf(TuplesKt.to("power", Double.valueOf(((com.obric.memorydata.ability.data.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.ability.data.a.class, "com.obric.memorydata.plugin")).a()))));
        return;
    }

    public static final /* synthetic */ void f(d r2, h r3) {
        r2.i((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"));
    }

    private final Pair<Object, Map<String, Object>> g(h r3, String r4) {
        h r2 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.ability.data.f.class) == true) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(((com.obric.memorydata.ability.data.f) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.ability.data.f.class, "com.obric.memorydata.plugin")).a(), "show") == false) goto L7;
        String r5 = ((com.obric.memorydata.ability.data.f) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.ability.data.f.class, "com.obric.memorydata.plugin")).b();
    L9:
        return TuplesKt.to(r5, null);
    L7:
        r5 = "";
        goto L9
    }

    public static final /* synthetic */ Pair g(d r2, h r3, String r4) {
        return r2.j((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void g(h r8) {
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, com.obric.memorydata.ability.data.f.class) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(((com.obric.memorydata.ability.data.f) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.ability.data.f.class, "com.obric.memorydata.plugin")).a(), "show") == false) goto L7;
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "use_float_window_app", ((com.obric.memorydata.ability.data.f) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.ability.data.f.class, "com.obric.memorydata.plugin")).b(), null, 4, null);
        return;
    L7:
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "use_float_window_app", "", null, 4, null);
    }

    public static final /* synthetic */ void g(d r2, h r3) {
        r2.j((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"));
    }

    private final Pair<Object, Map<String, Object>> h(h r2, String r3) {
        h r1 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, DeviceAudioStandardData.class) == true) goto L5;
        return null;
    L5:
        return TuplesKt.to(com.obric.memorydata.utils.u.a(((DeviceAudioStandardData) ZeusTransformUtils.preCheckCast(r1, DeviceAudioStandardData.class, "com.obric.memorydata.plugin")).getAppList()), null);
    }

    public static final /* synthetic */ Pair h(d r2, h r3, String r4) {
        return r2.b((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void h(h r8) {
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, DeviceAudioStandardData.class) == false) goto L6;
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "device_active_audio", com.obric.memorydata.utils.u.a(((DeviceAudioStandardData) ZeusTransformUtils.preCheckCast(r7, DeviceAudioStandardData.class, "com.obric.memorydata.plugin")).getAppList()), null, 4, null);
        return;
    }

    public static final /* synthetic */ void h(d r2, h r3) {
        r2.b((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"));
    }

    private final Pair<Object, Map<String, Object>> i(h r2, String r3) {
        h r1 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, o.class) == true) goto L5;
        return null;
    L5:
        return TuplesKt.to(Integer.valueOf(((o) ZeusTransformUtils.preCheckCast(r1, o.class, "com.obric.memorydata.plugin")).a()), null);
    }

    public static final /* synthetic */ Pair i(d r2, h r3, String r4) {
        return r2.d((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void i(h r8) {
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, o.class) == false) goto L6;
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "device_screen_brightness", Integer.valueOf(((o) ZeusTransformUtils.preCheckCast(r7, o.class, "com.obric.memorydata.plugin")).a()), null, 4, null);
        return;
    }

    public static final /* synthetic */ void i(d r2, h r3) {
        r2.d((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"));
    }

    private final Pair<Object, Map<String, Object>> j(h r1, String r2) {
        h r0 = (h) ZeusTransformUtils.wrapperContextForParams(r1, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, r.class) == true) goto L5;
        return null;
    L5:
        return TuplesKt.to(r0, null);
    }

    public static final /* synthetic */ Pair j(d r2, h r3, String r4) {
        return r2.f((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void j(h r8) {
        h r3 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, r.class) == false) goto L6;
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "device_volume", r3, null, 4, null);
        return;
    }

    public static final /* synthetic */ void j(d r2, h r3) {
        r2.f((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: lambda$gt6VzTx-5PtXVKg-26icyvo6zKk, reason: not valid java name */
    public static /* synthetic */ a m509lambda$gt6VzTx5PtXVKg26icyvo6zKk() {
        return e();
    }

    public static /* synthetic */ a lambda$mPNjgLw5XdmeVqgRLoic_OMLFbY() {
        return f();
    }

    public static /* synthetic */ a lambda$yHyRWMg6bAvRpz9sp8gOT1fIRO8() {
        return d();
    }

    public final e a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "featureName");
        switch(r5.hashCode()) {
            case -1713672418: goto L121;
            case -1542795426: goto L116;
            case -1500205497: goto L113;
            case -1491789990: goto L110;
            case -1439533888: goto L105;
            case -1410521534: goto L102;
            case -1225903362: goto L97;
            case -1216041498: goto L92;
            case -1142385697: goto L89;
            case -1136580833: goto L86;
            case -924105673: goto L81;
            case -917051416: goto L78;
            case -885581533: goto L73;
            case -679072052: goto L68;
            case -222076173: goto L65;
            case -202120101: goto L60;
            case -120981277: goto L55;
            case 16640717: goto L50;
            case 26764976: goto L47;
            case 312847667: goto L44;
            case 560648750: goto L39;
            case 610953305: goto L36;
            case 719641786: goto L33;
            case 1208457464: goto L30;
            case 1362590392: goto L27;
            case 1426941957: goto L22;
            case 1587177638: goto L17;
            case 1614816774: goto L12;
            case 1648082212: goto L9;
            case 1888259925: goto L6;
            default: goto L125;
        };
    L125:
        return null;
    L6:
        if (r5.equals("device_screen_unlock_reason") == false) goto L127;
    L14:
        com.obric.memorydata.ability.f r4 = new com.obric.memorydata.ability.f(100000005, MapsKt.mapOf(TuplesKt.to("mode", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL)));
        d r2 = f8643a;
        return (e) ZeusTransformUtils.preCheckCast(new a(r4, (Function1) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$createFeatureCollector$3(r2), Function1.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$createFeatureCollector$4(r2), Function2.class, "com.obric.memorydata.plugin")), e.class, "com.obric.memorydata.plugin");
    L127:
        return null;
    L9:
        if (r5.equals("device_battery") == true) goto L108;
        return null;
    L108:
        return (e) ZeusTransformUtils.preCheckCast(c(), e.class, "com.obric.memorydata.plugin");
    L12:
        if (r5.equals("device_lock_state") == true) goto L14;
        return null;
    L17:
        if (r5.equals("device_active_audio") == false) goto L130;
        com.obric.memorydata.ability.f r6 = new com.obric.memorydata.ability.f(100001010, MapsKt.emptyMap());
        d r3 = f8643a;
        return (e) ZeusTransformUtils.preCheckCast(new a(r6, (Function1) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$createFeatureCollector$7(r3), Function1.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$createFeatureCollector$8(r3), Function2.class, "com.obric.memorydata.plugin")), e.class, "com.obric.memorydata.plugin");
    L130:
        return null;
    L22:
        if (r5.equals("device_bluetooth") == false) goto L131;
        com.obric.memorydata.ability.f r7 = new com.obric.memorydata.ability.f(100000007, MapsKt.emptyMap());
        d r8 = f8643a;
        return (e) ZeusTransformUtils.preCheckCast(new a(r7, (Function1) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$createFeatureCollector$9(r8), Function1.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$createFeatureCollector$10(r8), Function2.class, "com.obric.memorydata.plugin")), e.class, "com.obric.memorydata.plugin");
    L131:
        return null;
    L27:
        if (r5.equals("device_find_my_phone") == true) goto L95;
        return null;
    L95:
        return (e) ZeusTransformUtils.preCheckCast(c.f8642a, e.class, "com.obric.memorydata.plugin");
    L30:
        if (r5.equals("device_auto_brightness") == true) goto L95;
        return null;
    L33:
        if (r5.equals("device_assistant_wakeup_reason") == true) goto L71;
        return null;
    L71:
        return (e) ZeusTransformUtils.preCheckCast(new b(), e.class, "com.obric.memorydata.plugin");
    L36:
        if (r5.equals("device_screen_off_ts") == true) goto L124;
        return null;
    L124:
        return (e) ZeusTransformUtils.preCheckCast(b(), e.class, "com.obric.memorydata.plugin");
    L39:
        if (r5.equals("device_foreground_app") == true) goto L42;
        return null;
    L42:
        return (e) ZeusTransformUtils.preCheckCast(new f(), e.class, "com.obric.memorydata.plugin");
    L44:
        if (r5.equals("device_cellular") == false) goto L137;
    L99:
        com.obric.memorydata.ability.f r9 = new com.obric.memorydata.ability.f(100000012, MapsKt.emptyMap());
        d r10 = f8643a;
        return (e) ZeusTransformUtils.preCheckCast(new a(r9, (Function1) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$createFeatureCollector$1(r10), Function1.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$createFeatureCollector$2(r10), Function2.class, "com.obric.memorydata.plugin")), e.class, "com.obric.memorydata.plugin");
    L137:
        return null;
    L47:
        if (r5.equals("device_eye_protection") == true) goto L95;
        return null;
    L50:
        if (r5.equals("use_float_window_app") == false) goto L139;
        com.obric.memorydata.ability.f r11 = new com.obric.memorydata.ability.f(100000014, MapsKt.emptyMap());
        d r12 = f8643a;
        return (e) ZeusTransformUtils.preCheckCast(new a(r11, (Function1) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$createFeatureCollector$5(r12), Function1.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$createFeatureCollector$6(r12), Function2.class, "com.obric.memorydata.plugin")), e.class, "com.obric.memorydata.plugin");
    L139:
        return null;
    L55:
        if (r5.equals("storage_usage_percent") == true) goto L58;
        return null;
    L58:
        return (e) ZeusTransformUtils.preCheckCast(new g(), e.class, "com.obric.memorydata.plugin");
    L60:
        if (r5.equals("device_screen_brightness") == false) goto L141;
        com.obric.memorydata.ability.f r13 = new com.obric.memorydata.ability.f(100000008, MapsKt.emptyMap());
        d r14 = f8643a;
        return (e) ZeusTransformUtils.preCheckCast(new a(r13, (Function1) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$createFeatureCollector$11(r14), Function1.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$createFeatureCollector$12(r14), Function2.class, "com.obric.memorydata.plugin")), e.class, "com.obric.memorydata.plugin");
    L141:
        return null;
    L65:
        if (r5.equals("device_night_mode") == true) goto L95;
        return null;
    L68:
        if (r5.equals("device_is_assistant_wakeup") == true) goto L71;
        return null;
    L73:
        if (r5.equals("device_volume") == false) goto L144;
        com.obric.memorydata.ability.f r15 = new com.obric.memorydata.ability.f(100000011, MapsKt.emptyMap());
        d r16 = f8643a;
        return (e) ZeusTransformUtils.preCheckCast(new a(r15, (Function1) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$createFeatureCollector$13(r16), Function1.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DeviceFeatureCollectorFactory$createFeatureCollector$14(r16), Function2.class, "com.obric.memorydata.plugin")), e.class, "com.obric.memorydata.plugin");
    L144:
        return null;
    L78:
        if (r5.equals("device_do_not_disturb") == true) goto L95;
        return null;
    L81:
        if (r5.equals("connect_bluetooth_devices") == true) goto L84;
        return null;
    L84:
        return new e();
    L86:
        if (r5.equals("current_wifi_ssid") == true) goto L119;
        return null;
    L119:
        return (e) ZeusTransformUtils.preCheckCast(a(), e.class, "com.obric.memorydata.plugin");
    L89:
        if (r5.equals("device_is_power_save_mode") == true) goto L108;
        return null;
    L92:
        if (r5.equals("device_hotspot") == true) goto L95;
        return null;
    L97:
        if (r5.equals("device_active_network") == true) goto L99;
        return null;
    L102:
        if (r5.equals("battery_temperature") == true) goto L108;
        return null;
    L105:
        if (r5.equals("device_is_charge") == true) goto L108;
        return null;
    L110:
        if (r5.equals("device_screen_on_reason") == true) goto L124;
        return null;
    L113:
        if (r5.equals("device_screen_state") == true) goto L124;
        return null;
    L116:
        if (r5.equals("device_wifi") == true) goto L119;
        return null;
    L121:
        if (r5.equals("device_screen_off_reason") == true) goto L124;
        return null;
    }
}
