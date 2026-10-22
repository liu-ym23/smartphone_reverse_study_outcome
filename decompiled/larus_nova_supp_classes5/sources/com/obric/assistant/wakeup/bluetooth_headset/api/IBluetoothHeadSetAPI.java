package com.obric.assistant.wakeup.bluetooth_headset.api;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.obric.assistant.chat.b0;
import com.obric.assistant.session.lifecycle.c;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tha.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH&J$\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u0011H&J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&J.\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u0011H&J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&J.\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00070\u0011H&J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u001b\u001a\u00020\u001cH&J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J$\u0010 \u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070\u0011H&J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010#\u001a\u00020\fH&J\u0014\u0010$\u001a\u0004\u0018\u00010\u001c2\b\u0010%\u001a\u0004\u0018\u00010\u001cH&J\b\u0010&\u001a\u00020\u0003H&J\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u001eH&J\u0012\u0010*\u001a\u00020+2\b\u0010)\u001a\u0004\u0018\u00010\u001eH&J\b\u0010,\u001a\u00020\u0003H&J\b\u0010-\u001a\u00020\u0003H&¨\u0006."}, d2 = {"Lcom/obric/assistant/wakeup/bluetooth_headset/api/IBluetoothHeadSetAPI;", "", "start", "", "context", "Landroid/content/Context;", "stop", "", "isBluetoothHeadSetConnected", "isBluetoothA2dpConnected", "isScoConnected", "getBluetoothOrWiredHeadsetConnectState", "", "registerBluetoothScoStateChanged", "uuid", "Ljava/util/UUID;", "callback", "Lkotlin/Function1;", "Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueAudioScoState;", "unRegisterBluetoothScoStateChanged", "registerBluetoothDeviceStageChanged", "sticky", "Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueDeviceConnectState;", "unregisterBluetoothDeviceStageChanged", "registerBluetoothSwitchStateChanged", "Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueDeviceSwitchState;", "unregisterBluetoothSwitchStateChanged", "getConnectedBluetoothDeviceMacDigest", "", "getConnectedBluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "getConnectedBluetoothHeadsetDevice", "registerBluetoothActiveDeviceChanged", "Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueActiveDevice;", "unregisterBluetoothActiveDeviceChanged", "getConnectedBluetoothHeadsetDeviceCount", "getBluetoothDeviceMacDigestBySha256", "mac", "isActiveDeviceHasChanged", "getDeviceTypeBySmartModel", "Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueDeviceTypeEnum;", "device", "getProductIdBySmartModel", "Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueProductIdEnum;", "isSmartModelAvailable", "isSmartModelSupported", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBluetoothHeadSetAPI {
    boolean a();

    boolean b();

    void c(UUID r1);

    void d(UUID r1, b0 r2);

    BlueDeviceTypeEnum e(BluetoothDevice r1);

    void f(UUID r1);

    BluetoothDevice g();

    boolean h();

    boolean i();

    int j();

    void k(UUID r1);

    boolean l();

    void m(UUID r1, boolean r2, Function1<? super BlueDeviceConnectState, Unit> r3);

    BluetoothDevice n();

    void o(UUID r1, c r2);

    void p(UUID r1, Function1<? super a, Unit> r2);

    BlueProductIdEnum q(BluetoothDevice r1);

    String r();

    String s(String r1);

    boolean start(Context r1);

    void stop();
}
