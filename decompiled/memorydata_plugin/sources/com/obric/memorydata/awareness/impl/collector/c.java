package com.obric.memorydata.awareness.impl.collector;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0007\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/awareness/impl/collector/DeviceFeatureCollector;", "Lcom/obric/memorydata/awareness/impl/collector/FeatureCollector;", "<init>", "()V", "queryFeatureAndExtra", "Lkotlin/Pair;", "", "", "", "featureName", "queryFeature", "isHotspotEnabled", "", "isFindMyPhoneEnabled", "isDoNotDisturbEnabled", "isDarkModeEnabled", "isEyeComfortEnabled", "isAutoBrightnessEnabled", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8642a = null;

    static {
        f8642a = new c();
    }

    private c() {
    }

    private final boolean a() {
        Object r8 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        WifiManager r9 = (WifiManager) ZeusTransformUtils.preCheckCast(r8, WifiManager.class, "com.obric.memorydata.plugin");
        Method r2 = r9.getClass().getDeclaredMethod("isWifiApEnabled", new Class[0]);     // Catch: Exception -> L5
        r2.setAccessible(true);     // Catch: Exception -> L5
        Object r10 = r2.invoke(r9, new Object[0]);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L5
        return ((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DeviceFeatureCollector", "Failed to check hotspot status: " + e.getMessage(), null, 4, null);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object b(String r2) {
        switch(r2.hashCode()) {
            case -1216041498: goto L26;
            case -917051416: goto L22;
            case -222076173: goto L18;
            case 26764976: goto L14;
            case 1208457464: goto L10;
            case 1362590392: goto L6;
            default: goto L30;
        };
    L30:
        return null;
    L6:
        if (r2.equals("device_find_my_phone") == false) goto L30;
        int r1 = e();
    L32:
        return Integer.valueOf(r1);
    L10:
        if (r2.equals("device_auto_brightness") == false) goto L30;
        r1 = i();
        goto L32
    L14:
        if (r2.equals("device_eye_protection") == false) goto L30;
        r1 = h();
        goto L32
    L18:
        if (r2.equals("device_night_mode") == false) goto L30;
        r1 = g();
        goto L32
    L22:
        if (r2.equals("device_do_not_disturb") == false) goto L30;
        r1 = f();
        goto L32
    L26:
        if (r2.equals("device_hotspot") == false) goto L30;
        r1 = a();
        goto L32
    }

    private final boolean e() {
        if (Intrinsics.areEqual(DeviceInfoState.INSTANCE.getDeviceModel(), "Genesis-R") == false) goto L8;
        if (Settings.Global.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "finddevice_offlinefind_enabled", 0) != 1) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (Settings.Secure.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "obric_find_device_switch", 0) != 1) goto L11;
        return true;
    }

    private final boolean f() {
        if (Intrinsics.areEqual(DeviceInfoState.INSTANCE.getDeviceModel(), "Genesis-R") == false) goto L8;
        if (Settings.Global.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "zen_mode", 0) != 1) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (Settings.Secure.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "NoDisturbOn", 0) != 1) goto L11;
        return true;
    }

    private final boolean g() {
        if ((ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean h() {
        if (Intrinsics.areEqual(DeviceInfoState.INSTANCE.getDeviceModel(), "Genesis-R") == false) goto L8;
        if (Settings.System.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "screen_paper_mode_enabled", 0) != 1) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (Settings.Secure.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "night_display_activated", 0) != 1) goto L11;
        return true;
    }

    private final boolean i() {
        if (Settings.System.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "screen_brightness_mode") == 1) goto L7;
        return false;
    L7:
        return true;
    L12:
        return false;
    }

    @Override // com.obric.memorydata.awareness.impl.collector.e
    public Pair<Object, Map<String, Object>> a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        return TuplesKt.to(b(r2), null);
    }
}
