package com.obric.memorydata.ability.impl;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
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
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\u001c\u0010\u001e\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020 H\u0002J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020 H\u0002J\b\u0010(\u001a\u00020\u000eH\u0003J\u0010\u0010)\u001a\u00020*2\u0006\u0010(\u001a\u00020\u000eH\u0002J\u0010\u0010+\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020 H\u0002J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020 H\u0002J\n\u0010-\u001a\u0004\u0018\u00010 H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/memorydata/ability/impl/BatteryStateAbility;", "Landroid/content/BroadcastReceiver;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "<init>", "()V", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "context", "Landroid/content/Context;", "mode2Keys", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "", "", "onCreate", "", "iAbilityContext", "onSubscribe", "key", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "onUnsubscribe", "onQuery", "onDestroy", "subscribeEventBy", "mode", "unsubscribeEventBy", "registerPowerReceiver", "unregisterPowerReceiver", "onReceive", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "publishStateData", "data", "Lcom/obric/memorydata/ability/data/BatteryStateStandardData;", "getLevelFrom", "", "batteryStatus", "getTemperatureFrom", "isSaveMode", "batteryTimeRemaining", "", "getPluggedFrom", "isPowerConnect", "getCurrentBattery", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends PluginBroadcastReceiver implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8368a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.ability.j f8369b;
    private Context c;
    private final ConcurrentHashMap<Integer, ConcurrentHashMap.KeySetView<String, Boolean>> d;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/ability/impl/BatteryStateAbility$Companion;", "", "<init>", "()V", "TAG", "", "CHARGE_ON", "", "CHARGE_OFF", "BATTERY_CHANGE", "SAVE_MODE", "ONLY_STATE", "BATTERY_PLUGGED_AC", "BATTERY_PLUGGED_USB", "BATTERY_PLUGGED_WIRELESS", "ACTION_POWER_SAVE_MODE_CHANGED", "LOW_POWER_MODE", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8368a = new a(null);
    }

    public b() {
        this.d = new ConcurrentHashMap();
    }

    private final double a(Intent r3) {
        int r2 = r3.getIntExtra("level", -1);
        return ((double) (r2 * 100)) / ((double) r3.getIntExtra("scale", -1));
    }

    private final long a(boolean r1) {
        return com.obric.memorydata.utils.d.a.f13205a.a(r1);
    }

    private final void a(int r5, com.obric.memorydata.ability.data.a r6) {
        ConcurrentHashMap.KeySetView r7 = (ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(this.d.get(Integer.valueOf(r5)), ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L8;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r8.hasNext() == false) goto L10;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.ability.j r2 = this.f8369b;
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNull(r0);
        r2.a(r0, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        goto L6
    L10:
        return;
    }

    private final boolean a(int r6, String r7) {
        if (this.d.isEmpty() == false) goto L6;
        boolean r0 = true;
        Integer r2 = Integer.valueOf(r6);
        ((Map) ZeusTransformUtils.preCheckCast(this.d, Map.class, "com.obric.memorydata.plugin")).put(r2, ConcurrentHashMap.newKeySet());
    L9:
        ConcurrentHashMap.KeySetView<String, Boolean> r5 = this.d.get(Integer.valueOf(r6));
        Intrinsics.checkNotNull(r5);
        ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r5, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).add(r7);
        return r0;
    L6:
        if (this.d.get(Integer.valueOf(r6)) != null) goto L8;
        Integer r1 = Integer.valueOf(r6);
        ((Map) ZeusTransformUtils.preCheckCast(this.d, Map.class, "com.obric.memorydata.plugin")).put(r1, ConcurrentHashMap.newKeySet());
    L8:
        r0 = false;
        goto L9
    }

    private final int b(Intent r2) {
        return r2.getIntExtra("temperature", -1);
    }

    private final void b() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        r0.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        r0.addAction("android.intent.action.BATTERY_CHANGED");
        r0.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        Context r1 = this.c;
        Intrinsics.checkNotNull(r1);
        ZeusTransformUtils.registerReceiver(r1, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r0, 2, "com.obric.memorydata.plugin");
    }

    private final boolean b(int r4, String r5) {
        if (this.d.get(Integer.valueOf(r4)) == null) goto L10;
        ConcurrentHashMap.KeySetView<String, Boolean> r0 = this.d.get(Integer.valueOf(r4));
        Intrinsics.checkNotNull(r0);
        if (((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r0, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).contains(r5) == false) goto L10;
        ConcurrentHashMap.KeySetView<String, Boolean> r1 = this.d.get(Integer.valueOf(r4));
        Intrinsics.checkNotNull(r1);
        ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r1, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).remove(r5);
        ConcurrentHashMap.KeySetView<String, Boolean> r6 = this.d.get(Integer.valueOf(r4));
        Intrinsics.checkNotNull(r6);
        if (((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r6, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
        this.d.remove(Integer.valueOf(r4));
    L10:
        return this.d.isEmpty();
    }

    private final int c(Intent r3) {
        int r2 = r3.getIntExtra("plugged", -1);
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L13;
        if (r2 != 4) goto L14;
        return 3;
    L14:
        return -1;
    L13:
        return 2;
    L11:
        return 1;
    }

    private final void c() {
        Context r0 = this.c;
        Intrinsics.checkNotNull(r0);
        ZeusTransformUtils.unregisterReceiver(r0, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    private final boolean d() {
        Context r2 = this.c;
        if (r2 == null) goto L5;
        ContentResolver r3 = r2.getContentResolver();
    L7:
        if (Settings.Global.getInt(r3, "low_power", 0) == 0) goto L10;
        return true;
    L10:
        return false;
    L5:
        r3 = null;
        goto L7
    }

    private final boolean d(Intent r2) {
        if (r2.getIntExtra("plugged", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private final Intent e() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.BATTERY_CHANGED");
        Context r4 = this.c;
        Intrinsics.checkNotNull(r4);
        return ZeusTransformUtils.registerReceiver(r4, null, r0, 2, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
        this.f8369b = null;
        this.c = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r3) {
        com.obric.memorydata.ability.j r4 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "iAbilityContext");
        this.f8369b = r4;
        this.c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(com.obric.memorydata.ability.f r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(String r8, com.obric.memorydata.ability.f r9) {
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r9, TrackerImpl.PARAMS);
        Object r10 = r9.b().getOrDefault("mode", 0);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Int");
        int r11 = ((Integer) ZeusTransformUtils.preCheckCast(r10, Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r11 == 0) goto L13;
        if (r11 == 1) goto L11;
        if (r11 == 2) goto L11;
        if (r11 == 3) goto L11;
        if (r11 == 4) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BatteryStateAbility", "onSubscribe unSupport mode : " + r11, null, 4, null);
        return false;
    L11:
        if (a(r11, r8) == true) goto L18;
    L19:
        return true;
    L18:
        b();
        goto L19
    L13:
        boolean r12 = a(1, r8);
        boolean r0 = a(2, r8);
        boolean r2 = a(3, r8);
        boolean r13 = a(4, r8);
        if (r12 == true) goto L18;
        if (r0 == true) goto L18;
        if (r2 == true) goto L18;
        if (r13 == false) goto L19;
        goto L18
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean b(String r8, com.obric.memorydata.ability.f r9) {
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r9, TrackerImpl.PARAMS);
        Object r10 = r9.b().getOrDefault("mode", 0);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Int");
        int r11 = ((Integer) ZeusTransformUtils.preCheckCast(r10, Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r11 == 0) goto L16;
        if (r11 == 1) goto L13;
        if (r11 == 2) goto L13;
        if (r11 == 3) goto L13;
        if (r11 == 4) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BatteryStateAbility", "onUnsubscribe unSupport mode : " + r11, null, 4, null);
        return false;
    L13:
        if (b(r11, r8) == true) goto L19;
    L20:
        return true;
    L19:
        c();
        goto L20
    L16:
        if (b(1, r8) == true) goto L19;
        if (b(2, r8) == false) goto L20;
        goto L19
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r13, com.obric.memorydata.ability.f r14) {
        Intrinsics.checkNotNullParameter(r13, "key");
        Intrinsics.checkNotNullParameter(r14, TrackerImpl.PARAMS);
        Intent r15 = e();
        if (r15 == null) goto L6;
        boolean r7 = d();
        com.obric.memorydata.ability.j r10 = this.f8369b;
        Intrinsics.checkNotNull(r10);
        r10.a(r13, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.ability.data.a(3, c(r15), a(r15), b(r15), d(r15), r7, a(r7)), com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        return true;
    L6:
        return false;
    }

    public void onReceive(Context r12, Intent r13) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin")) == null) goto L27;
        if (r13 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual("android.intent.action.ACTION_POWER_CONNECTED", r13.getAction()) == false) goto L13;
        Intent r14 = e();
        if (r14 == null) goto L28;
        boolean r7 = d();
        int r15 = 1;
        com.obric.memorydata.ability.data.a r10 = new com.obric.memorydata.ability.data.a(1, c(r14), a(r14), b(r14), true, r7, a(r7));
    L11:
        a(r15, r10);
        return;
    L28:
        return;
    L13:
        if (Intrinsics.areEqual("android.intent.action.ACTION_POWER_DISCONNECTED", r13.getAction()) == false) goto L18;
        Intent r16 = e();
        if (r16 == null) goto L30;
        boolean r8 = d();
        r15 = 2;
        r10 = new com.obric.memorydata.ability.data.a(2, c(r16), a(r16), b(r16), false, r8, a(r8));
        goto L11
    L30:
        return;
    L18:
        if (Intrinsics.areEqual("android.os.action.POWER_SAVE_MODE_CHANGED", r13.getAction()) == false) goto L23;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BatteryStateAbility", "onReceive ACTION_POWER_SAVE_MODE_CHANGED", false, 4, null);
        Intent r17 = e();
        if (r17 == null) goto L31;
        boolean r9 = d();
        r15 = 4;
        r10 = new com.obric.memorydata.ability.data.a(3, c(r17), a(r17), b(r17), d(r17), r9, a(r9));
        goto L11
    L31:
        return;
    L23:
        if (Intrinsics.areEqual("android.intent.action.BATTERY_CHANGED", r13.getAction()) == false) goto L32;
        Intent r18 = e();
        if (r18 == null) goto L33;
        boolean r11 = d();
        r15 = 3;
        r10 = new com.obric.memorydata.ability.data.a(3, c(r18), a(r18), b(r18), d(r18), r11, a(r11));
        goto L11
    L33:
        return;
    L32:
        return;
    }
}
