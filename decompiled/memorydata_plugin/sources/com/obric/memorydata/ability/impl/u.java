package com.obric.memorydata.ability.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\b\u0010 \u001a\u00020\u0018H\u0002J\u001c\u0010!\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\b\u0010)\u001a\u00020\u0015H\u0002J\b\u0010*\u001a\u00020\u0015H\u0002J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/memorydata/ability/impl/WifiAbility;", "Landroid/content/BroadcastReceiver;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "<init>", "()V", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "context", "Landroid/content/Context;", "wifiManager", "Landroid/net/wifi/WifiManager;", "preConnectBssid", "", "lastWifiScanTime", "", "lastWifiSsid", "lastWifiBssid", "subscribeKey2Type", "Ljava/util/concurrent/ConcurrentHashMap;", "", "onCreate", "", "iAbilityContext", "onSubscribe", "", "key", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "onUnsubscribe", "onQuery", "onDestroy", "registerWifiSwitchListener", "registerWifiStateListener", "onReceive", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "getWifiStateData", "Lcom/obric/memorydata/ability/data/WifiStandardData;", "isConnectWifiInfo", "wifiInfo", "Landroid/net/wifi/WifiInfo;", "publishSwitchOn", "publishSwitchOff", "isWifiEnabled", "isWifiConnected", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class u extends PluginBroadcastReceiver implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8418a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.ability.j f8419b;
    private Context c;
    private WifiManager d;
    private String e;
    private long f;
    private String g;
    private String h;
    private final ConcurrentHashMap<String, Integer> i;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/ability/impl/WifiAbility$Companion;", "", "<init>", "()V", "TAG", "", "ACTION_ALL", "", "ACTION_SWITCH_ON", "ACTION_SWITCH_OFF", "ACTION_ON_CONNECT", "ACTION_ON_DISCONNECT", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8420a = null;

        static {
            int[] r0 = new int[NetworkInfo.DetailedState.values().length];
            r0[NetworkInfo.DetailedState.CONNECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[NetworkInfo.DetailedState.DISCONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f8420a = r0;
        }
    }

    static {
        f8418a = new a(null);
    }

    public u() {
        this.i = new ConcurrentHashMap();
    }

    private final boolean a(Context r2) {
        Object r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        return ((WifiManager) ZeusTransformUtils.preCheckCast(r1, WifiManager.class, "com.obric.memorydata.plugin")).isWifiEnabled();
    }

    private final boolean a(WifiInfo r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        RunLog.INSTANCE.debug("WifiAbility", "isConnectWifi networkId: " + r4.getNetworkId() + " supplicantState: " + r4.getSupplicantState());
        if (r4.getNetworkId() != (-1)) goto L8;
        return false;
    L8:
        if (r4.getSupplicantState() != SupplicantState.COMPLETED) goto L12;
        return true;
    L12:
        return false;
    }

    private final boolean b() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        Context r1 = this.c;
        Intrinsics.checkNotNull(r1);
        ZeusTransformUtils.registerReceiver(r1, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r0, 2, "com.obric.memorydata.plugin");
        return true;
    }

    private final boolean b(Context r2) {
        Object r1 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager r3 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r1, ConnectivityManager.class, "com.obric.memorydata.plugin");
        Network r4 = r3.getActiveNetwork();
        if (r4 != null) goto L5;
        return false;
    L5:
        NetworkCapabilities r5 = r3.getNetworkCapabilities(r4);
        if (r5 != null) goto L9;
        return false;
    L9:
        return r5.hasTransport(1);
    }

    private final boolean c() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.wifi.STATE_CHANGE");
        Context r1 = this.c;
        Intrinsics.checkNotNull(r1);
        ZeusTransformUtils.registerReceiver(r1, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r0, 2, "com.obric.memorydata.plugin");
        return true;
    }

    private final com.obric.memorydata.ability.data.u d() {
        WifiManager r1 = this.d;
        Intrinsics.checkNotNull(r1);
        WifiInfo r2 = r1.getConnectionInfo();
        RunLog.INSTANCE.debug("WifiAbility", "getWifiStateData wifiInfo bssid: " + r2.getBSSID() + " ssid: " + r2.getSSID() + " rssi: " + r2.getRssi());
        if (a(r2) == false) goto L9;
        String r3 = r2.getBSSID();
        if (r3 != null) goto L7;
        r3 = "00:00:00:00:00:00";
    L7:
        String r7 = r2.getSSID();
        Intrinsics.checkNotNullExpressionValue(r7, "getSSID(...)");
        return new com.obric.memorydata.ability.data.u(3, r3, r7, WifiManager.calculateSignalLevel(r2.getRssi(), 5), r2.getRssi(), null, 32, null);
    L9:
        if (b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L12;
        return new com.obric.memorydata.ability.data.u(3, "00:00:00:00:00:00", "", WifiManager.calculateSignalLevel(r2.getRssi(), 5), r2.getRssi(), null, 32, null);
    L12:
        if (a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L15;
        return new com.obric.memorydata.ability.data.u(4, null, null, 0, 0, null, 62, null);
    L15:
        return new com.obric.memorydata.ability.data.u(2, null, null, 0, 0, null, 62, null);
    }

    private final void e() {
        Context r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        WifiManager r1 = this.d;
        if (r1 == null) goto L8;
        WifiInfo r2 = r1.getConnectionInfo();
    L10:
        if (v.a(a(r2), b(r0)) == true) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "WifiAbility", "WiFi 仍处于连接态，忽略开关已开启事件", false, 4, null);
        return;
    L13:
        Iterator r3 = ((Map) ZeusTransformUtils.preCheckCast(this.i, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L15:
        if (r3.hasNext() == false) goto L21;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin");
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r4.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r6 == 0) goto L20;
        if (1 != r6) goto L15;
    L20:
        com.obric.memorydata.ability.j r7 = this.f8419b;
        Intrinsics.checkNotNull(r7);
        r7.a(r5, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.ability.data.u(1, null, null, 0, 0, null, 62, null), com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        goto L15
    L21:
        return;
    L8:
        r2 = null;
        goto L10
    }

    private final void f() {
        Iterator r0 = ((Map) ZeusTransformUtils.preCheckCast(this.i, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r1.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r2 == 0) goto L9;
        if (2 != r2) goto L4;
    L9:
        com.obric.memorydata.ability.j r4 = this.f8419b;
        Intrinsics.checkNotNull(r4);
        r4.a(r3, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.ability.data.u(2, null, null, 0, 0, null, 62, null), com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
        this.d = null;
        this.c = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r4) {
        com.obric.memorydata.ability.j r5 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "iAbilityContext");
        this.f8419b = r5;
        this.c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        Object r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        this.d = (WifiManager) ZeusTransformUtils.preCheckCast(r6, WifiManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(com.obric.memorydata.ability.f r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(String r6, com.obric.memorydata.ability.f r7) {
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r7, TrackerImpl.PARAMS);
        Object r8 = r7.b().getOrDefault("action", 0);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Int");
        int r9 = ((Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (this.i.containsKey(r6) == false) goto L5;
        RunLog.INSTANCE.debug("WifiAbility", "onSubscribe: key: " + r6 + " is already subscribed.");
        return false;
    L5:
        RunLog.INSTANCE.debug("WifiAbility", "onSubscribe: register wifiSwitch listener, key: " + r6);
        if (this.i.isEmpty() == false) goto L8;
        b();
        c();
    L8:
        ((Map) ZeusTransformUtils.preCheckCast(this.i, Map.class, "com.obric.memorydata.plugin")).put(r6, Integer.valueOf(r9));
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean b(String r2, com.obric.memorydata.ability.f r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        this.i.remove(r2);
        if (this.i.isEmpty() == false) goto L7;
        Context r4 = this.c;
        Intrinsics.checkNotNull(r4);
        ZeusTransformUtils.unregisterReceiver(r4, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.e = null;
        return true;
    L7:
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r5, com.obric.memorydata.ability.f r6) {
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, TrackerImpl.PARAMS);
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
        RunLog.INSTANCE.debug("WifiAbility", "onQuery before user agree privacy");
        return false;
    L6:
        com.obric.memorydata.ability.data.u r7 = d();
        RunLog.INSTANCE.debug("WifiAbility", "onQuery " + r5 + " wifiStandardData: " + r7);
        com.obric.memorydata.ability.j r4 = this.f8419b;
        Intrinsics.checkNotNull(r4);
        r4.a(r5, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        return true;
    }

    public void onReceive(Context r13, Intent r14) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin")) == null) goto L61;
        if (r14 != null) goto L7;
        return;
    L7:
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L11;
        RunLog r12 = RunLog.INSTANCE;
        StringBuilder r15 = new StringBuilder().append("onReceive before user agree privacy, ignore wifi broadcast, action: ").append(r14.getAction());
    L9:
        r12.debug("WifiAbility", r15.toString());
        return;
    L11:
        RunLog r16 = RunLog.INSTANCE;
        StringBuilder r2 = new StringBuilder().append("onReceive: ").append(r14.getAction()).append(" connect info ");
        WifiManager r3 = this.d;
        if (r3 == null) goto L16;
        WifiInfo r4 = r3.getConnectionInfo();
        if (r4 == null) goto L16;
        String r5 = com.obric.memorydata.utils.u.a(r4);
    L17:
        r16.debug("WifiAbility", r2.append(r5).toString());
        boolean r6 = false;
        if (Intrinsics.areEqual("android.net.wifi.WIFI_STATE_CHANGED", r14.getAction()) == false) goto L26;
        int r17 = r14.getIntExtra("wifi_state", 0);
        if (r17 == 1) goto L24;
        if (r17 == 3) goto L23;
        RunLog.INSTANCE.debug("WifiAbility", "wifi switch: " + r17);
        return;
    L23:
        RunLog.INSTANCE.debug("WifiAbility", "wifi switch enabled");
        e();
        return;
    L24:
        RunLog.INSTANCE.debug("WifiAbility", "wifi switch disabled");
        f();
        return;
    L26:
        if (Intrinsics.areEqual("android.net.wifi.STATE_CHANGE", r14.getAction()) == false) goto L71;
        NetworkInfo r18 = (NetworkInfo) ZeusTransformUtils.preCheckCast(r14.getParcelableExtra("networkInfo"), NetworkInfo.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L30;
        return;
    L30:
        int r19 = b.f8420a[r18.getDetailedState().ordinal()];
        if (r19 != 1) goto L33;
        WifiManager r110 = this.d;
        Intrinsics.checkNotNull(r110);
        WifiInfo r111 = r110.getConnectionInfo();
        this.g = r111.getSSID();
        this.h = r111.getBSSID();
        CharSequence r112 = (CharSequence) ZeusTransformUtils.preCheckCast(r111.getBSSID(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r112 != null) goto L39;
    L40:
        r6 = true;
    L41:
        if (r6 == false) goto L43;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "WifiAbility", "[code=wifi_bssid_empty] wifi connected but bssid is empty", null, 4, null);
        String r113 = "00:00:00:00:00:00";
    L44:
        String r7 = r113;
        Intrinsics.checkNotNull(r7);
        String r8 = r111.getSSID();
        Intrinsics.checkNotNullExpressionValue(r8, "getSSID(...)");
        com.obric.memorydata.ability.data.u r114 = new com.obric.memorydata.ability.data.u(3, r7, r8, WifiManager.calculateSignalLevel(r111.getRssi(), 5), r111.getRssi(), null, 32, null);
    L45:
        RunLog.INSTANCE.debug("WifiAbility", "wifiChange " + r114);
        if (r114.a() == 3) goto L48;
    L53:
        this.e = r114.b();
        Iterator r115 = ((Map) ZeusTransformUtils.preCheckCast(this.i, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L55:
        if (r115.hasNext() == false) goto L73;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r115.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.memorydata.plugin");
        int r11 = ((Number) ZeusTransformUtils.preCheckCast(r9.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r11 == 0) goto L60;
        if (r114.a() != r11) goto L55;
    L60:
        RunLog.INSTANCE.debug("WifiAbility", "publishToReceiver key:" + r10 + ' ' + r114);
        com.obric.memorydata.ability.j r20 = this.f8419b;
        Intrinsics.checkNotNull(r20);
        r20.a(r10, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r114, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        goto L55
    L73:
        return;
    L48:
        if ((System.currentTimeMillis() - this.f) <= 600000) goto L53;
        WifiManager r116 = this.d;
        if (r116 == null) goto L52;
        r116.startScan();
    L52:
        this.f = System.currentTimeMillis();
        goto L53
    L43:
        r113 = r111.getBSSID();
        goto L44
    L39:
        if (r112.length() != 0) goto L41;
    L33:
        if (r19 == 2) goto L35;
        r12 = RunLog.INSTANCE;
        r15 = new StringBuilder().append("wifiChange state: ").append(r18.getDetailedState());
        goto L9
    L35:
        r114 = new com.obric.memorydata.ability.data.u(4, null, null, 0, 0, this.g, 30, null);
        goto L45
    L71:
        return;
    L16:
        r5 = null;
        goto L17
    }
}
