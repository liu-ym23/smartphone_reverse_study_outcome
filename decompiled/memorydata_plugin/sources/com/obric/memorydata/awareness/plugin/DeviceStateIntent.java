package com.obric.memorydata.awareness.plugin;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Parcelable;
import android.provider.Settings;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseRCDeviceStateIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.memorydata.ability.data.b;
import com.obric.memorydata.ability.data.r;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.sdk.awareness.model.BluetoothDeviceInfo;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0002J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0002J\b\u0010 \u001a\u00020\u000fH\u0002J\b\u0010!\u001a\u00020\u000fH\u0002J\u0010\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010#H\u0002J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&H\u0002¨\u0006("}, d2 = {"Lcom/obric/memorydata/awareness/plugin/DeviceStateIntent;", "Lcom/obric/capabilitykit/common/intent/BaseRCDeviceStateIntent;", "<init>", "()V", "isBlock", "", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/intent/Empty;", TrackerImpl.PARAMS, "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/Empty;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectDeviceStates", "", "Lcom/obric/memorydata/awareness/plugin/DeviceState;", "()[Lcom/obric/memorydata/awareness/plugin/DeviceState;", "getBluetoothBatteryState", "getDeviceType", "", "device", "Lcom/obric/memorydata/sdk/awareness/model/BluetoothDeviceInfo;", "getBluetoothState", "getWifiState", "getCellularState", "getHotspotState", "getFindMyPhoneState", "getDoNotDisturbState", "getPowerSaveModeState", "getNightModeState", "getEyeProtectionState", "getAutoBrightnessState", "getScreenBrightnessState", "getBatteryState", "getVolumeState", "", "buildVibrationContent", "volumeValue", "Lcom/obric/memorydata/ability/data/StreamVolumeStandardData;", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeviceStateIntent extends BaseRCDeviceStateIntent {
    public static final a Companion = null;
    private static final String TAG = "DeviceStatusIntent";
    private static final int TYPE_ALARM_VOLUME = 116;
    private static final int TYPE_ASSISTANT_VOLUME = 117;
    private static final int TYPE_AUTO_BRIGHTNESS = 110;
    private static final int TYPE_BATTERY = 112;
    private static final int TYPE_BLUETOOTH = 101;
    private static final int TYPE_BLUETOOTH_BATTERY_MODE = 120;
    private static final int TYPE_CELLULAR = 103;
    private static final int TYPE_DO_NOT_DISTURB = 106;
    private static final int TYPE_EYE_PROTECTION = 109;
    private static final int TYPE_FIND_MY_PHONE = 105;
    private static final int TYPE_HOTSPOT = 104;
    private static final int TYPE_MEDIA_VOLUME = 113;
    private static final int TYPE_NIGHT_MODE = 108;
    private static final int TYPE_NOTIFICATION_VOLUME = 115;
    private static final int TYPE_POWER_SAVE_MODE = 107;
    private static final int TYPE_RING_VOLUME = 114;
    private static final int TYPE_SCREEN_BRIGHTNESS = 111;
    private static final int TYPE_SILENT_MODE = 119;
    private static final int TYPE_VIBRATION_ENABLE = 118;
    private static final int TYPE_WIFI = 102;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/awareness/plugin/DeviceStateIntent$Companion;", "", "<init>", "()V", "TAG", "", "TYPE_BLUETOOTH", "", "TYPE_WIFI", "TYPE_CELLULAR", "TYPE_HOTSPOT", "TYPE_FIND_MY_PHONE", "TYPE_DO_NOT_DISTURB", "TYPE_POWER_SAVE_MODE", "TYPE_NIGHT_MODE", "TYPE_EYE_PROTECTION", "TYPE_AUTO_BRIGHTNESS", "TYPE_SCREEN_BRIGHTNESS", "TYPE_BATTERY", "TYPE_MEDIA_VOLUME", "TYPE_RING_VOLUME", "TYPE_NOTIFICATION_VOLUME", "TYPE_ALARM_VOLUME", "TYPE_ASSISTANT_VOLUME", "TYPE_VIBRATION_ENABLE", "TYPE_SILENT_MODE", "TYPE_BLUETOOTH_BATTERY_MODE", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public DeviceStateIntent() {
    }

    private final String buildVibrationContent(r r4) {
        if (r4.g() != 1) goto L5;
        String r3 = "振动提醒已开启";
    L7:
        if (Settings.System.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "vibrate_when_ringing", 0) != 1) goto L9;
        String r5 = "开";
    L11:
        return r3 + "，响铃时振动状态为" + r5;
    L9:
        r5 = "关";
        goto L11
    L5:
        r3 = "振动提醒未开启";
        goto L7
    }

    private final DeviceState getAutoBrightnessState() {
        if (Intrinsics.areEqual(FeatureManager.INSTANCE.getFeature("device_auto_brightness"), 1) == false) goto L5;
        String r2 = "自动调整屏幕亮度已开启";
    L7:
        return new DeviceState(110, r2);
    L5:
        r2 = "自动调整屏幕亮度未开启";
        goto L7
    }

    private final DeviceState getBatteryState() {
        Object r10 = FeatureManager.INSTANCE.getFeature("device_battery");
        if (ZeusTransformUtils.instanceOf(r10, Number.class) == false) goto L20;
        Map<String, Object> r0 = FeatureManager.INSTANCE.getFeatureExtra("device_battery");
        if (r0 == null) goto L7;
        Object r1 = r0.get("battery_remaining_time");
    L9:
        if (ZeusTransformUtils.instanceOf(r1, Number.class) == false) goto L18;
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L18;
        int r2 = ((((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue() / 60) / 60) / 1000;
        int r3 = ((((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue() / 60) / 1000) % 60;
        StringBuilder r11 = new StringBuilder().append("当前电池电量为：").append(r10).append('%');
        if (r2 <= 0) goto L15;
        StringBuilder r4 = new StringBuilder().append("，剩余可用时长：").append(r2);
        String r5 = "小时";
    L21:
        return new DeviceState(112, r11.append(r4.append(r5).append(r3).append("分钟").toString()).toString());
    L15:
        r4 = new StringBuilder();
        r5 = "，剩余时间为：";
    L18:
        return new DeviceState(112, "当前电池电量为：" + r10 + '%');
    L7:
        r1 = null;
        goto L9
    L20:
        return new DeviceState(112, "当前电池电量未知");
    }

    private final DeviceState getBluetoothBatteryState() {
        Object r0 = FeatureManager.INSTANCE.getFeature("connect_bluetooth_devices");
        if (ZeusTransformUtils.instanceOf(r0, List.class) == false) goto L5;
        List r1 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L7:
        if (r1 == null) goto L28;
        StringBuilder r5 = new StringBuilder();
        if (r1.isEmpty() == false) goto L11;
        r5.append("无连接的音频设备");
    L25:
        String r2 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        return new DeviceState(120, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString());
    L11:
        r5.append("当前连接的蓝牙列表：\n");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r4 = 1;
    L13:
        if (r3.hasNext() == false) goto L25;
        Object r6 = r3.next();
        if (ZeusTransformUtils.instanceOf(r6, BluetoothDeviceInfo.class) == false) goto L17;
        BluetoothDeviceInfo r7 = (BluetoothDeviceInfo) ZeusTransformUtils.preCheckCast(r6, BluetoothDeviceInfo.class, "com.obric.memorydata.plugin");
    L18:
        if (r7 == null) goto L13;
        Integer r8 = r7.getBatteryLevel();
        if (r8 == null) goto L23;
        String r9 = new StringBuilder().append(((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue()).append('%').toString();
        if (r9 == null) goto L23;
    L24:
        r5.append(r4 + ". 蓝牙名称：" + r7.getName() + ", 设备类型：" + getDeviceType(r7) + ", 剩余电量：" + r9 + '\n');
        r4 = r4 + 1;
    L23:
        r9 = "未知";
        goto L24
    L17:
        r7 = null;
        goto L18
    L28:
        return new DeviceState(120, "无连接的音频设备");
    L5:
        r1 = null;
        goto L7
    }

    private final DeviceState getBluetoothState() {
        Object r5 = FeatureManager.INSTANCE.getFeature("device_bluetooth");
        String r2 = "蓝牙已开启";
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L5;
        if (r5 != null) goto L17;
        Object r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("bluetooth");
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        if (((BluetoothManager) ZeusTransformUtils.preCheckCast(r6, BluetoothManager.class, "com.obric.memorydata.plugin")).getAdapter().isEnabled() == true) goto L16;
        r2 = "蓝牙未开启";
    L16:
        return new DeviceState(101, r2);
    L17:
        return null;
    L5:
        if (((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin")).a() == 1) goto L9;
        r2 = "蓝牙未开启";
    L9:
        return new DeviceState(101, r2);
    }

    private final DeviceState getCellularState() {
        boolean r1 = false;
        if (Settings.Global.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "airplane_mode_on", 0) != 1) goto L6;
        r1 = true;
    L6:
        String r4 = "蜂窝数据未开启";
        if (r1 == true) goto L9;
        Object r2 = FeatureManager.INSTANCE.getFeature("device_cellular");
        if (Intrinsics.areEqual(r2, 1) == true) goto L21;
        if (Intrinsics.areEqual(r2, 3) == false) goto L17;
        r4 = "蜂窝数据已开启已连接";
        goto L21
    L17:
        if (Intrinsics.areEqual(r2, 2) == false) goto L19;
        r4 = "蜂窝数据已开启，未连接";
        goto L21
    L19:
        r4 = "蜂窝数据状态未知";
    L21:
        return new DeviceState(103, r4);
    L9:
        return new DeviceState(103, "蜂窝数据未开启");
    }

    private final String getDeviceType(BluetoothDeviceInfo r2) {
        if (r2.getDeviceClass() != 1056) goto L7;
        return "车机";
    L7:
        if (r2.getMajorDeviceClass() != 1024) goto L10;
        return "耳机/音箱";
    L10:
        return IRecommendSettings.ProfileTag.OTHER;
    }

    private final DeviceState getDoNotDisturbState() {
        if (Intrinsics.areEqual(FeatureManager.INSTANCE.getFeature("device_do_not_disturb"), 1) == false) goto L5;
        String r2 = "勿扰模式已开启";
    L7:
        return new DeviceState(106, r2);
    L5:
        r2 = "勿扰模式未开启";
        goto L7
    }

    private final DeviceState getEyeProtectionState() {
        if (Intrinsics.areEqual(FeatureManager.INSTANCE.getFeature("device_eye_protection"), 1) == false) goto L5;
        String r2 = "护眼模式已开启";
    L7:
        return new DeviceState(109, r2);
    L5:
        r2 = "护眼模式未开启";
        goto L7
    }

    private final DeviceState getFindMyPhoneState() {
        if (Intrinsics.areEqual(FeatureManager.INSTANCE.getFeature("device_find_my_phone"), 1) == false) goto L5;
        String r2 = "查找手机已开启";
    L7:
        return new DeviceState(105, r2);
    L5:
        r2 = "查找手机未开启";
        goto L7
    }

    private final DeviceState getHotspotState() {
        if (Intrinsics.areEqual(FeatureManager.INSTANCE.getFeature("device_hotspot"), 1) == false) goto L5;
        String r2 = "手机热点已开启";
    L7:
        return new DeviceState(104, r2);
    L5:
        r2 = "手机热点未开启";
        goto L7
    }

    private final DeviceState getNightModeState() {
        if (Intrinsics.areEqual(FeatureManager.INSTANCE.getFeature("device_night_mode"), 1) == false) goto L5;
        String r2 = "夜间模式已开启";
    L7:
        return new DeviceState(108, r2);
    L5:
        r2 = "夜间模式未开启";
        goto L7
    }

    private final DeviceState getPowerSaveModeState() {
        if (Intrinsics.areEqual(FeatureManager.INSTANCE.getFeature("device_is_power_save_mode"), true) == false) goto L5;
        String r2 = "省电模式已开启";
    L7:
        return new DeviceState(107, r2);
    L5:
        r2 = "省电模式未开启";
        goto L7
    }

    private final DeviceState getScreenBrightnessState() {
        Object r4 = FeatureManager.INSTANCE.getFeature("device_screen_brightness");
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L7;
        return new DeviceState(111, "屏幕亮度为：" + (((RangesKt.coerceIn(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue(), 0, 255) * 100) + 127) / 255) + '%');
    L7:
        return new DeviceState(111, "屏幕亮度未知");
    }

    private final List<DeviceState> getVolumeState() {
        Object r0 = FeatureManager.INSTANCE.getFeature("device_volume");
        if (ZeusTransformUtils.instanceOf(r0, r.class) == false) goto L12;
        DeviceState[] r1 = new DeviceState[7];
        r1[0] = new DeviceState(113, "媒体音量为：" + ((r) ZeusTransformUtils.preCheckCast(r0, r.class, "com.obric.memorydata.plugin")).b() + '%');
        r1[1] = new DeviceState(TYPE_RING_VOLUME, "来电铃声音量为：" + ((r) ZeusTransformUtils.preCheckCast(r0, r.class, "com.obric.memorydata.plugin")).a() + '%');
        r1[2] = new DeviceState(TYPE_NOTIFICATION_VOLUME, "通知和信息铃声音量：" + ((r) ZeusTransformUtils.preCheckCast(r0, r.class, "com.obric.memorydata.plugin")).d() + '%');
        r1[3] = new DeviceState(TYPE_ALARM_VOLUME, "闹钟音量为：" + ((r) ZeusTransformUtils.preCheckCast(r0, r.class, "com.obric.memorydata.plugin")).c() + '%');
        r1[4] = new DeviceState(TYPE_ASSISTANT_VOLUME, "助手音量为：" + ((r) ZeusTransformUtils.preCheckCast(r0, r.class, "com.obric.memorydata.plugin")).f() + '%');
        r1[5] = new DeviceState(TYPE_VIBRATION_ENABLE, buildVibrationContent((r) ZeusTransformUtils.preCheckCast(r0, r.class, "com.obric.memorydata.plugin")));
        if (((r) ZeusTransformUtils.preCheckCast(r0, r.class, "com.obric.memorydata.plugin")).e() != 0) goto L7;
    L10:
        String r2 = "静音模式已开启";
    L11:
        r1[6] = new DeviceState(119, r2);
        return CollectionsKt.listOf(r1);
    L7:
        if (((r) ZeusTransformUtils.preCheckCast(r0, r.class, "com.obric.memorydata.plugin")).e() == 1) goto L10;
        r2 = "静音模式未开启";
        goto L11
    L12:
        return null;
    }

    private final DeviceState getWifiState() {
        Object r4 = FeatureManager.INSTANCE.getFeature("device_wifi");
        String r2 = "Wi-Fi已开启，未连接";
        boolean r3 = true;
        if (Intrinsics.areEqual(r4, 3) == false) goto L18;
        Map<String, Object> r5 = FeatureManager.INSTANCE.getFeatureExtra("device_wifi");
        if (r5 == null) goto L7;
        Object r6 = r5.get("wifi_ssid");
    L9:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == true) goto L11;
    L16:
        r2 = "Wi-Fi已开启已连接";
    L28:
        return new DeviceState(102, r2);
    L11:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L14;
        r3 = false;
    L14:
        if (r3 == false) goto L16;
        r2 = "Wi-Fi已开启已连接，Wi-Fi 名称为：" + ((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin"));
        goto L28
    L7:
        r6 = null;
        goto L9
    L18:
        if (Intrinsics.areEqual(r4, 4) == true) goto L28;
        if (Intrinsics.areEqual(r4, 1) == true) goto L28;
        if (Intrinsics.areEqual(r4, 2) == false) goto L26;
        r2 = "Wi-Fi已关闭";
        goto L28
    L26:
        r2 = "Wi-Fi状态未知";
        goto L28
    }

    public final DeviceState[] collectDeviceStates() {
        ArrayList r0 = new ArrayList();
        DeviceState r1 = getBluetoothState();
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        r0.add(getWifiState());
        r0.add(getCellularState());
        r0.add(getHotspotState());
        r0.add(getFindMyPhoneState());
        r0.add(getDoNotDisturbState());
        r0.add(getPowerSaveModeState());
        r0.add(getNightModeState());
        r0.add(getEyeProtectionState());
        r0.add(getAutoBrightnessState());
        r0.add(getScreenBrightnessState());
        r0.add(getBluetoothBatteryState());
        r0.add(getBatteryState());
        List<DeviceState> r6 = getVolumeState();
        if (r6 != null) goto L9;
        r6 = CollectionsKt.emptyList();
    L9:
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin"));
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r7.hasNext() == false) goto L14;
        RunLog.INSTANCE.debug(TAG, "collectDeviceStates item: " + ((DeviceState) ZeusTransformUtils.preCheckCast(r7.next(), DeviceState.class, "com.obric.memorydata.plugin")));
        goto L11
    L14:
        return (DeviceState[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).toArray(new DeviceState[0]), DeviceState[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.capabilitykit.common.intent.BaseRCDeviceStateIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, Continuation<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        Continuation<? super IntentResult<Empty>> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return doAction((Empty) ZeusTransformUtils.preCheckCast(r6, Empty.class, "com.obric.memorydata.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseRCDeviceStateIntent
    public Object doAction(Empty r21, DispatchContext r22, Continuation<? super IntentResult<Empty>> r23) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "doAction", false, 4, null);
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "doAction, not agree privacy", false, 4, null);
        return new IntentResult(201, new Empty(), null, null, false, false, 256, null, null, null, 956, null);
    L6:
        String r7 = GsonUtil.INSTANCE.toJson(collectDeviceStates());
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deviceStatesJson = " + r7, false, 4, null);
        return new IntentResult(0, new Empty(), null, r7, false, false, 256, null, null, null, 948, null);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseRCDeviceStateIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return false;
    }
}
