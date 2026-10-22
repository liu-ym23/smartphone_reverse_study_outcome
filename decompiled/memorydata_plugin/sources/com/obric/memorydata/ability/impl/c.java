package com.obric.memorydata.ability.impl;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u001c\u0010\u0014\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003J\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/ability/impl/BluetoothDeviceAbility;", "Landroid/content/BroadcastReceiver;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "<init>", "()V", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "context", "Landroid/content/Context;", "onCreate", "", "iAbilityContext", "onSubscribe", "", "key", "", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "onUnsubscribe", "onDestroy", "onReceive", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "parseBluetoothDeviceDataBy", "Lcom/obric/memorydata/ability/data/BluetoothDeviceStandardData;", "state", "", "makeBluetoothDeviceDataBy", "bluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "parseBluetoothDeviceType", "bluetoothClass", "Landroid/bluetooth/BluetoothClass;", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends PluginBroadcastReceiver implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8370a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.ability.j f8371b;
    private Context c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ability/impl/BluetoothDeviceAbility$Companion;", "", "<init>", "()V", "TAG", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8370a = new a(null);
    }

    public c() {
    }

    private final com.obric.memorydata.ability.data.b a(int r11, BluetoothDevice r12) {
        String r0 = r12.getAddress();
        if (r0 == null) goto L19;
        int r3 = 1;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L21;
        String r2 = r12.getName();
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        String r7 = r2;
        String r8 = a(r12.getBluetoothClass());
        Object r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("bluetooth");
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        if (((BluetoothManager) ZeusTransformUtils.preCheckCast(r10, BluetoothManager.class, "com.obric.memorydata.plugin")).getAdapter().isEnabled() == true) goto L17;
        r3 = 2;
    L17:
        Locale r13 = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(r13, "ENGLISH");
        String r6 = r0.toUpperCase(r13);
        Intrinsics.checkNotNullExpressionValue(r6, "toUpperCase(...)");
        return new com.obric.memorydata.ability.data.b(r11, r6, r7, r8, r3);
    L21:
        return null;
    L7:
        r1 = false;
        goto L8
    L19:
        return null;
    }

    private final com.obric.memorydata.ability.data.b a(int r4, Intent r5) {
        BluetoothDevice r6 = (BluetoothDevice) ZeusTransformUtils.preCheckCast(r5.getParcelableExtra("android.bluetooth.device.extra.DEVICE", BluetoothDevice.class), BluetoothDevice.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        return null;
    L6:
        if (r6.getBondState() == 12) goto L9;
        return null;
    L9:
        return a(r4, r6);
    }

    private final String a(BluetoothClass r7) {
        if (r7 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothDeviceAbility", "parseBluetoothDeviceType bluetoothClass is null", null, 4, null);
        return "other";
    L6:
        int r1 = r7.getDeviceClass();
        int r8 = r7.getMajorDeviceClass();
        RunLog.INSTANCE.debug("BluetoothDeviceAbility", "parseBluetoothDeviceType: deviceClass: " + r1 + " majorDeviceClass: " + r8);
        if (r8 == 1024) goto L9;
    L21:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothDeviceAbility", "parseBluetoothDeviceType other type", false, 4, null);
        return "other";
    L9:
        if (r1 != 1028) goto L11;
    L19:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothDeviceAbility", "parseBluetoothDeviceType earphone type", false, 4, null);
        return "earphone";
    L11:
        if (r1 == 1048) goto L19;
        if (r1 != 1032) goto L15;
    L17:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothDeviceAbility", "parseBluetoothDeviceType car type", false, 4, null);
        return "car";
    L15:
        if (r1 == 1056) goto L17;
        goto L17
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
        Context r0 = this.c;
        Intrinsics.checkNotNull(r0);
        ZeusTransformUtils.unregisterReceiver(r0, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.c = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r4) {
        com.obric.memorydata.ability.j r5 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "iAbilityContext");
        this.f8371b = r5;
        this.c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        IntentFilter r6 = new IntentFilter();
        r6.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        r6.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        Context r0 = this.c;
        Intrinsics.checkNotNull(r0);
        ZeusTransformUtils.registerReceiver(r0, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r6, 2, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(com.obric.memorydata.ability.f r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(String r1, com.obric.memorydata.ability.f r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, TrackerImpl.PARAMS);
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean b(String r1, com.obric.memorydata.ability.f r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, TrackerImpl.PARAMS);
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r1, com.obric.memorydata.ability.f r2) {
        return i.a.a(this, r1, r2);
    }

    public void onReceive(Context r7, Intent r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L32;
        if (r8 != null) goto L7;
        return;
    L7:
        if (ContextCompat.checkSelfPermission(r9, "android.permission.BLUETOOTH_CONNECT") == 0) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothDeviceAbility", "BLUETOOTH_CONNECT permission denied", false, 4, null);
        return;
    L11:
        if (Intrinsics.areEqual("android.bluetooth.device.action.ACL_CONNECTED", r8.getAction()) == false) goto L16;
        com.obric.memorydata.ability.data.b r10 = a(1, r8);
        if (r10 == null) goto L33;
    L14:
        com.obric.memorydata.ability.j r6 = this.f8371b;
        Intrinsics.checkNotNull(r6);
        r6.a((com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        return;
    L33:
        return;
    L16:
        if (Intrinsics.areEqual("android.bluetooth.device.action.ACL_DISCONNECTED", r8.getAction()) == false) goto L21;
        r10 = a(2, r8);
        if (r10 != null) goto L14;
        return;
    L21:
        if (Intrinsics.areEqual(r8.getAction(), "android.bluetooth.adapter.action.STATE_CHANGED") == false) goto L30;
        int r11 = r8.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
        if (r11 != 10) goto L25;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        int r4 = 4;
        Object r5 = null;
        String r1 = "BluetoothDeviceAbility";
        String r2 = "bluetooth is off";
    L28:
        IRunLog.a.a(r0, r1, r2, r3, r4, r5);
        return;
    L25:
        if (r11 != 12) goto L38;
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r3 = false;
        r4 = 4;
        r5 = null;
        r1 = "BluetoothDeviceAbility";
        r2 = "bluetooth is on";
        goto L28
    L38:
        return;
    L30:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothDeviceAbility", "unprocessed action: " + r8.getAction(), null, 4, null);
        return;
    }
}
