package com.obric.assistant.wakeup.bluetooth_headset.impl;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.RemoteException;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.b0;
import com.obric.assistant.common.utils.FunctionsKt;
import com.obric.assistant.state.api.multitask.ObricInteractionProjectionDelegate;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueAudioScoState;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueDeviceConnectState;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueDeviceSwitchState;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueDeviceTypeEnum;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueProductIdEnum;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.obric.cae.libs.bluetooth.BtDeviceInfoExtEvent;
import com.obric.cae.libs.bluetooth.CaeBluetoothDeviceManager;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00050\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J,\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\t2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00050\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J,\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\t2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00050\u0017H\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\n\u0010$\u001a\u0004\u0018\u00010#H\u0016J\b\u0010%\u001a\u00020\u0012H\u0016J$\u0010&\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00050\u0017H\u0016J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0014\u0010)\u001a\u0004\u0018\u00010\u00072\b\u0010*\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010+\u001a\u00020\tH\u0016J\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010/\u001a\u0002002\b\u0010.\u001a\u0004\u0018\u00010#H\u0016J\b\u00101\u001a\u00020\tH\u0016J\b\u00102\u001a\u00020\tH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/assistant/wakeup/bluetooth_headset/impl/BluetoothHeadSetImpl;", "Lcom/obric/assistant/wakeup/bluetooth_headset/api/IBluetoothHeadSetAPI;", "<init>", "()V", "log", "", "msg", "", "hasStarted", "", "start", "context", "Landroid/content/Context;", "stop", "isBluetoothHeadSetConnected", "isBluetoothA2dpConnected", "isScoConnected", "getBluetoothOrWiredHeadsetConnectState", "", "registerBluetoothScoStateChanged", "uuid", "Ljava/util/UUID;", "callback", "Lkotlin/Function1;", "Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueAudioScoState;", "unRegisterBluetoothScoStateChanged", "registerBluetoothDeviceStageChanged", "sticky", "Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueDeviceConnectState;", "unregisterBluetoothDeviceStageChanged", "registerBluetoothSwitchStateChanged", "Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueDeviceSwitchState;", "unregisterBluetoothSwitchStateChanged", "getConnectedBluetoothDeviceMacDigest", "getConnectedBluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "getConnectedBluetoothHeadsetDevice", "getConnectedBluetoothHeadsetDeviceCount", "registerBluetoothActiveDeviceChanged", "Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueActiveDevice;", "unregisterBluetoothActiveDeviceChanged", "getBluetoothDeviceMacDigestBySha256", "mac", "isActiveDeviceHasChanged", "getDeviceTypeBySmartModel", "Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueDeviceTypeEnum;", "device", "getProductIdBySmartModel", "Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueProductIdEnum;", "isSmartModelAvailable", "isSmartModelSupported", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BluetoothHeadSetImpl implements IBluetoothHeadSetAPI {
    public static final /* synthetic */ int b = 0;
    public volatile boolean a;

    public static final class a {
    }

    static {
    }

    public BluetoothHeadSetImpl() {
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final boolean a() {
        ObricBluetoothAudioManager r0 = ObricBluetoothAudioManager.a;
        if (ObricBluetoothAudioManager.c() != 2) goto L5;
        boolean r1 = true;
    L6:
        FLogger.a.w("Obric-BluetoothAudioManager", "isBluetoothHeadsetConnected : " + r1);
        t("isHeadSetConnected : " + r1);
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final boolean b() {
        ObricBluetoothDeviceManager r0 = ObricBluetoothDeviceManager.a;
        return ObricBluetoothDeviceManager.x.get();
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final BluetoothDevice g() {
        ObricBluetoothDeviceManager r0 = ObricBluetoothDeviceManager.a;
        FLogger r1 = FLogger.a;
        r1.i("Obric-BluetoothDeviceManager", "wrappedBluetoothHeadsetDevice ===> hfp " + ObricBluetoothDeviceManager.g + " a2dp " + ObricBluetoothDeviceManager.h);
        StringBuilder r2 = new StringBuilder("wrappedBluetoothHeadsetDevice ===> dump cache -> ");
        LruCache<String, String> r3 = ObricBluetoothDeviceManager.b;
        r2.append(r3.snapshot());
        r1.i("Obric-BluetoothDeviceManager", r2.toString());
        BluetoothDevice r4 = ObricBluetoothDeviceManager.g;
        if (r4 != null) goto L15;
        BluetoothDevice r5 = ObricBluetoothDeviceManager.h;
        if (r5 == null) goto L14;
        Intrinsics.checkNotNull(r5);
        String r6 = r5.getAddress();
        Intrinsics.checkNotNull(r6);
        String r7 = (String) r3.get(r6);
        boolean r8 = false;
        if (r7 != null) goto L10;
    L12:
        if (r8 == false) goto L14;
        r4 = ObricBluetoothDeviceManager.h;
        goto L15
    L10:
        if (StringsKt.contains$default(r7, "hfp", false, 2, null) != true) goto L12;
        r8 = true;
    L14:
        r4 = null;
    L15:
        r1.i("Obric-BluetoothDeviceManager", "getConnectedBluetoothHeadsetDevice " + r4 + ' ');
        return r4;
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final boolean h() {
        ObricBluetoothAudioManager r0 = ObricBluetoothAudioManager.a;
        BluetoothAdapter r1 = BluetoothAdapter.getDefaultAdapter();
        int r2 = -2;
        boolean r3 = true;
        if (r1 != null) goto L6;
    L23:
        if (r2 == 2) goto L26;
        r3 = false;
    L26:
        FLogger.a.w("Obric-BluetoothAudioManager", "isBluetoothA2dpConnected : " + r3);
        t("isBluetoothA2dpConnected : " + r3);
        return r3;
    L6:
        if (r1.isEnabled() == true) goto L8;
    L12:
        int r4 = -2;
    L13:
        if (r4 == (-2)) goto L15;
    L17:
        FLogger.a.i("Obric-BluetoothAudioManager", "getA2dpStatus result " + r4 + " a2dpDevice " + ObricBluetoothDeviceManager.h);
        if (r4 == 2) goto L20;
    L22:
        r2 = r4;
        goto L23
    L20:
        if (ObricBluetoothDeviceManager.h != null) goto L22;
    L15:
        if (ObricBluetoothAudioManager.d().isWiredHeadsetOn() == false) goto L17;
        r4 = 1;
        goto L17
    L8:
        if (((Boolean) ObricBluetoothAudioManager.i.getValue()).booleanValue() == false) goto L12;
        if (r1.getProfileConnectionState(2) != 2) goto L12;
        r4 = 2;
        goto L13
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final boolean i() {
        ObricBluetoothAudioManager r0 = ObricBluetoothAudioManager.a;
        ObricBluetoothDeviceManager r1 = ObricBluetoothDeviceManager.a;
        boolean r2 = ObricBluetoothDeviceManager.h();
        FLogger.a.w("Obric-BluetoothAudioManager", "isBluetoothScoOn : " + r2);
        t("isScoConnected : " + r2);
        return r2;
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final int j() {
        ObricBluetoothDeviceManager r0 = ObricBluetoothDeviceManager.a;
        BluetoothHeadset r1 = ObricBluetoothDeviceManager.j;
        if (r1 != null) goto L5;
        return 0;
    L5:
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.BLUETOOTH_CONNECT") != 0) goto L44;
        List<BluetoothDevice> r2 = r1.getConnectedDevices();
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L35;
        Object r5 = r4.next();
        BluetoothDevice r6 = (BluetoothDevice) r5;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L13
        Object r8 = Result.constructor-impl(Integer.valueOf(r1.getConnectionState(r6)));     // Catch: Throwable -> L13
    L16:
        if (Result.isSuccess-impl(r8) == false) goto L18;
        ((Number) r8).intValue();
    L18:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L22;
        FLogger.a.w("Obric-BluetoothHeadSetImpl", "isDeviceConnected failed " + r9.getMessage());
    L22:
        if (Result.isFailure-impl(r8) == false) goto L24;
        r8 = null;
    L24:
        Integer r10 = (Integer) r8;
        if (r10 == null) goto L27;
        int r11 = r10.intValue();
    L29:
        if (r11 != 2) goto L31;
        boolean r12 = true;
    L32:
        if (r12 == false) goto L9;
        r3.add(r5);
        goto L9
    L31:
        r12 = false;
        goto L32
    L27:
        r11 = 0;
    L13:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L35:
        return r3.size();
    L44:
        return 0;
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final boolean l() {
        ObricBluetoothDeviceManager r0 = ObricBluetoothDeviceManager.a;
        boolean r1 = ObricBluetoothDeviceManager.i();
        FLogger r2 = FLogger.a;
        r2.i("Obric-BluetoothHeadSetImpl", "isSmartModelSupported " + r1);
        boolean r3 = false;
        if (r1 == true) goto L5;
        return false;
    L5:
        p0 r4 = ObricBluetoothDeviceManager.v;
        if (r4 == null) goto L10;
        r2.i("Obric-SmartBluetoothBinderClient", "isActive " + r4.d);
        if (r4.d != true) goto L10;
        r3 = true;
    L10:
        r2.i("Obric-BluetoothHeadSetImpl", "isSmartModelAvailable " + r3);
        return r3;
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final BluetoothDevice n() {
        ObricBluetoothDeviceManager r0 = ObricBluetoothDeviceManager.a;
        return ObricBluetoothDeviceManager.g();
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final String r() {
        ObricBluetoothDeviceManager r0 = ObricBluetoothDeviceManager.a;
        if (r0.getContext() != null) goto L5;
        return "";
    L5:
        Context r1 = r0.getContext();
        Intrinsics.checkNotNull(r1);
        if (ContextCompat.checkSelfPermission(r1, "android.permission.BLUETOOTH") == 0) goto L8;
        return "";
    L8:
        BluetoothDevice r2 = ObricBluetoothDeviceManager.g();
        if (r2 == null) goto L12;
        String r3 = r2.getAddress();
        if (r3 == null) goto L12;
    L14:
        if (r3.length() != 0) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == true) goto L21;
        String r5 = FunctionsKt.b(r3);
        t("Digest of BT device: " + r5);
        return r5;
    L21:
        return "";
    L16:
        r4 = false;
    L12:
        r3 = "";
        goto L14
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final void stop() {
        t("stop");
        ObricBluetoothDeviceManager r0 = ObricBluetoothDeviceManager.a;
        FLogger.a.w("Obric-BluetoothDeviceManager", "stop... ");
        if (ObricBluetoothDeviceManager.c == true) goto L38;
    L23:
        ObricBluetoothDeviceManager.c = false;
        ObricInteractionProjectionDelegate.b.c(r0);
        p0 r1 = ObricBluetoothDeviceManager.v;
        if (r1 == null) goto L34;
        r1.c();
    L34:
    L30:
        th = move-exception;
        FLogger.a.w("Obric-BluetoothAudioManager", "unregisterHeadset error", th);
    L32:
        ObricBluetoothAudioManager.d = false;
        this.a = false;
        return;
    L27:
        if (ObricBluetoothAudioManager.d == false) goto L32;
        ObricBluetoothAudioManager.b(AppHost.a.getApplication(), ObricBluetoothAudioManager.l);     // Catch: Throwable -> L30
        goto L32
    L38:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
        Context r3 = ObricBluetoothDeviceManager.f;     // Catch: Throwable -> L21
        if (r3 == null) goto L18;
        ObricBluetoothDeviceManager$intentReceiver$1 r4 = ObricBluetoothDeviceManager.B;     // Catch: Throwable -> L21
        ReceiverRegisterLancet.loge(r4, false);     // Catch: Throwable -> L21
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L36;
        r3.unregisterReceiver(r4);     // Catch: Throwable -> L21
    L17:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L19:
        Result.constructor-impl(r5);     // Catch: Throwable -> L21
        goto L23
    L36:
    L12:
        e = move-exception;
        if (r4 == null) goto L15;
        Npth.addTag("unregisterReceiver", r4.toString());     // Catch: Throwable -> L21
    L15:
        e.printStackTrace();     // Catch: Throwable -> L21
        goto L17
    L9:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r4, r3) == false) goto L17;
        r3.unregisterReceiver(r4);     // Catch: Exception -> L12 Throwable -> L21
    L18:
        r5 = null;
    L21:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }

    public static void t(String r2) {
        FLogger.a.i("Obric-BluetoothHeadSetImpl", r2);
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final void c(UUID r3) {
        Intrinsics.checkNotNullParameter(r3, "uuid");
        ObricBluetoothDeviceManager r0 = ObricBluetoothDeviceManager.a;
        ConcurrentHashMap<UUID, Function1<BlueDeviceConnectState, Unit>> r1 = ObricBluetoothDeviceManager.y;
        if (r1.contains(r3) == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L9;
        Function1<BlueDeviceConnectState, Unit> r4 = r1.remove(r3);
        return;
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final BlueDeviceTypeEnum e(BluetoothDevice r5) {
        if (r5 == null) goto L4;
        ObricBluetoothDeviceManager r0 = ObricBluetoothDeviceManager.a;
        Intrinsics.checkNotNullParameter(r5, "device");
        p0 r1 = ObricBluetoothDeviceManager.v;
        if (r1 == null) goto L17;
        FLogger.a.i("Obric-SmartBluetoothBinderClient", "getDeviceType: from " + r5 + " ,and bound " + r1.d);
        CaeBluetoothDeviceManager r2 = r1.c;
        if (r2 == null) goto L17;
        if (r1.d == false) goto L17;
        BtDeviceInfoExtEvent r6 = r2.getDeviceType(r5);     // Catch: RemoteException -> L15
        if (r6 == null) goto L17;
        int r7 = r6.getDeviceType();     // Catch: RemoteException -> L15
    L18:
        BlueDeviceTypeEnum.Companion.getClass();
        BlueDeviceTypeEnum r8 = BlueDeviceTypeEnum.a.a(r7);
        FLogger.a.i("Obric-BluetoothHeadSetImpl", "getDeviceTypeBySmartModel is " + r8);
        return r8;
    L15:
        e = move-exception;
        FLogger.a.e("Obric-SmartBluetoothBinderClient", "" + e);
    L17:
        r7 = 0;
        goto L18
    L4:
        return BlueDeviceTypeEnum.TYPE_UNKNOWN;
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final void f(UUID r3) {
        Intrinsics.checkNotNullParameter(r3, "uuid");
        ObricBluetoothAudioManager r0 = ObricBluetoothAudioManager.a;
        Map<UUID, Function1<BlueAudioScoState, Unit>> r1 = ObricBluetoothAudioManager.h;
        if (r1.containsKey(r3) == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L9;
        Function1<BlueAudioScoState, Unit> r4 = r1.remove(r3);
        return;
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final void k(UUID r3) {
        Intrinsics.checkNotNullParameter(r3, "uuid");
        ObricBluetoothDeviceManager r0 = ObricBluetoothDeviceManager.a;
        ConcurrentHashMap<UUID, Function1<tha.a, Unit>> r1 = ObricBluetoothDeviceManager.A;
        if (r1.contains(r3) == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L9;
        Function1<tha.a, Unit> r4 = r1.remove(r3);
        return;
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final BlueProductIdEnum q(BluetoothDevice r5) {
        if (r5 == null) goto L4;
        ObricBluetoothDeviceManager r0 = ObricBluetoothDeviceManager.a;
        Intrinsics.checkNotNullParameter(r5, "device");
        p0 r1 = ObricBluetoothDeviceManager.v;
        if (r1 == null) goto L15;
        FLogger.a.i("Obric-SmartBluetoothBinderClient", "getProductId: from " + r5 + " ,and bound " + r1.d);
        CaeBluetoothDeviceManager r2 = r1.c;
        if (r2 == null) goto L15;
        if (r1.d == false) goto L15;
        int r6 = r2.getProductId(r5);     // Catch: Exception -> L13
    L16:
        BlueProductIdEnum.Companion.getClass();
        BlueProductIdEnum r7 = BlueProductIdEnum.a.a(r6);
        FLogger.a.i("Obric-BluetoothHeadSetImpl", "getProductIdBySmartModel is " + r7);
        return r7;
    L13:
        e = move-exception;
        FLogger.a.e("Obric-SmartBluetoothBinderClient", "", e);
    L15:
        r6 = 0;
        goto L16
    L4:
        return BlueProductIdEnum.TYPE_UNKNOWN;
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final String s(String r12) {
        if (r12 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L14;
        return null;
    L14:
        byte[] r2 = MessageDigest.getInstance("SHA-256").digest(r12.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r2);     // Catch: Exception -> L13
        return ArraysKt.joinToString$default(r2, "", null, null, 0, null, new com.obric.assistant.wakeup.bluetooth_headset.impl.a(), 30, null);
    L16:
        return null;
    L4:
        if (r12.length() == 0) goto L7;
        r0 = false;
        goto L9
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final boolean start(Context r25) {
        Intrinsics.checkNotNullParameter(r25, "context");
        t("start...");
        if (this.a == false) goto L6;
        t("hasStarted");
        return true;
    L6:
        ObricBluetoothDeviceManager r3 = ObricBluetoothDeviceManager.a;
        Intrinsics.checkNotNullParameter(r25, "context");
        FLogger r2 = FLogger.a;
        r2.w("Obric-BluetoothDeviceManager", "init... ");
        ObricBluetoothDeviceManager.f = r25;
        Integer r7 = null;
        if (ObricBluetoothDeviceManager.i() == false) goto L9;
        p0 r6 = new p0(r25);
    L10:
        ObricBluetoothDeviceManager.v = r6;
        if (ContextCompat.checkSelfPermission(r25, "android.permission.BLUETOOTH_CONNECT") == 0) goto L13;
        boolean r4 = false;
    L20:
        if (r4 == false) goto L48;
        r2.w("Obric-BluetoothDeviceManager", "start... ");
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        r0.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        r0.addAction("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED");
        r0.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        r0.addAction("android.bluetooth.a2dp.profile.action.ACTIVE_DEVICE_CHANGED");
        if (ObricBluetoothDeviceManager.c == false) goto L50;
    L32:
        ObricBluetoothDeviceManager.e();
        ObricBluetoothDeviceManager.d();
        Context r1 = ObricBluetoothDeviceManager.f;
        if (r1 != null) goto L35;
    L41:
        p0 r5 = ObricBluetoothDeviceManager.v;
        if (r5 == null) goto L45;
        r5.b();
    L45:
        if (ObricBluetoothAudioManager.d == true) goto L48;
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
        ObricBluetoothAudioManager.a(AppHost.a.getApplication(), ObricBluetoothAudioManager.l, r8);
        ObricBluetoothAudioManager.d = true;
        goto L48
    L35:
        if (ContextCompat.checkSelfPermission(r1, "android.permission.BLUETOOTH_CONNECT") != 0) goto L45;
        ObricBluetoothDeviceManager r9 = ObricBluetoothDeviceManager.a;
        Set<BluetoothDevice> r10 = ObricBluetoothDeviceManager.f().getBondedDevices();
        FLogger r11 = FLogger.a;
        StringBuilder r12 = new StringBuilder("start... bonded devices size is ");
        if (r10 == null) goto L40;
        r7 = Integer.valueOf(r10.size());
    L40:
        r12.append(r7);
        r12.append(' ');
        r11.w("Obric-BluetoothDeviceManager", r12.toString());
        goto L41
    L50:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L29
        Context r14 = ObricBluetoothDeviceManager.f;     // Catch: Throwable -> L29
        if (r14 == null) goto L26;
        Intent r15 = ObricBluetoothDeviceManager.b(r14, ObricBluetoothDeviceManager.B, r0);     // Catch: Throwable -> L29
    L27:
        Result.constructor-impl(r15);     // Catch: Throwable -> L29
    L31:
        ObricBluetoothDeviceManager.c = true;
        goto L32
    L26:
        r15 = null;
    L29:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L48:
        this.a = r4;
        t("start...: " + r4);
        return r4;
    L13:
        int r17 = ObricBluetoothDeviceManager.f().getProfileConnectionState(1);
        int r18 = ObricBluetoothDeviceManager.f().getProfileConnectionState(2);
        r2.i("Obric-BluetoothDeviceManager", "init state hfp and a2dp -> " + r17 + ' ' + r18);
        if (r17 == 2) goto L18;
        if (r18 == 2) goto L18;
        BuildersKt.launch$default(ObricBluetoothDeviceManager.o, null, null, new ObricBluetoothDeviceManager$init$2(null), 3, null);
    L19:
        BuildersKt.launch$default(ObricBluetoothDeviceManager.p, null, null, new ObricBluetoothDeviceManager$init$3(null), 3, null);
        ObricInteractionProjectionDelegate.b.b(null, r3);
        r4 = true;
    L18:
        BuildersKt.launch$default(ObricBluetoothDeviceManager.o, null, null, new ObricBluetoothDeviceManager.init.1(null), 3, null);
        goto L19
    L9:
        r6 = null;
        goto L10
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final void d(UUID r3, b0 r4) {
        Intrinsics.checkNotNullParameter(r3, "uuid");
        Intrinsics.checkNotNullParameter(r4, "callback");
        ConcurrentHashMap<UUID, Function1<BlueDeviceSwitchState, Unit>> r0 = ObricBluetoothDeviceManager.z;
        if ((!r0.contains(r3)) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L9;
        Function1<BlueDeviceSwitchState, Unit> r5 = r0.put(r3, r4);
    L9:
        if (((Boolean) ObricBluetoothDeviceManager.m.getValue()).booleanValue() == false) goto L11;
        BlueDeviceSwitchState r6 = BlueDeviceSwitchState.ON;
    L12:
        r4.invoke(r6);
        return;
    L11:
        r6 = BlueDeviceSwitchState.OFF;
        goto L12
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final void o(UUID r3, com.obric.assistant.session.lifecycle.c r4) {
        Intrinsics.checkNotNullParameter(r3, "uuid");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Map<UUID, Function1<BlueAudioScoState, Unit>> r0 = ObricBluetoothAudioManager.h;
        if ((!r0.containsKey(r3)) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L9;
        Function1<BlueAudioScoState, Unit> r5 = r0.put(r3, r4);
        return;
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final void p(UUID r3, Function1<? super tha.a, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "uuid");
        Intrinsics.checkNotNullParameter(r4, "callback");
        ConcurrentHashMap<UUID, Function1<tha.a, Unit>> r0 = ObricBluetoothDeviceManager.A;
        if ((!r0.contains(r3)) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L9;
        Function1<tha.a, Unit> r5 = r0.put(r3, r4);
        return;
    }

    @Override // com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI
    public final void m(UUID r3, boolean r4, Function1<? super BlueDeviceConnectState, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "uuid");
        Intrinsics.checkNotNullParameter(r5, "callback");
        ConcurrentHashMap<UUID, Function1<BlueDeviceConnectState, Unit>> r0 = ObricBluetoothDeviceManager.y;
        if ((!r0.contains(r3)) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L8;
        Function1<BlueDeviceConnectState, Unit> r6 = r0.put(r3, r5);
    L8:
        if (r4 == false) goto L11;
        r5.invoke(ObricBluetoothDeviceManager.l.getValue());
        return;
    }
}
