package com.bytedance.android.livesdk.gift.platform.business;

import com.bytedance.android.livesdk.gift.configmodel.w2;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_GIFT_TRAY_SPECIAL_COMBO_RANGE", "getLIVE_GIFT_TRAY_SPECIAL_COMBO_RANGE()Lcom/bytedance/android/livesdk/gift/configmodel/TraySpecialComboRangeConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_GIFT_TRAY_UNIQUEPREKEY_SUPPORT_TOUSER", "getLIVE_GIFT_TRAY_UNIQUEPREKEY_SUPPORT_TOUSER()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_GIFT_TRAY_GROUP_MODE_SERVER_CONTROL", "getLIVE_GIFT_TRAY_GROUP_MODE_SERVER_CONTROL()Z", 1))};
        a = r0;
        Class r4 = w2.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r6 = vh7.b.a;
        Object r7 = r6.get(r4);
        if (r7 != null) goto L12;
        r7 = r4.getConstructor(new Class[0]);
        if (r7 == null) goto L11;
        Object r5 = r6.putIfAbsent(r4, r7);
        if (r5 == null) goto L12;
        r7 = r5;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r8 = ((SerializableObjectJsonAdapterBase) ((Constructor) r7).newInstance(new Object[0])).createInstance();
        if (r8 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_new_combo_and_tray_style_config", (w2) r8, w2.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r9 = Boolean.TRUE;
        Class r10 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_uniqueprekey_support_touser", r9, r10, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_group_mode_server_control", Boolean.FALSE, r10, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.TraySpecialComboRangeConfig");
    }

    public static final boolean a() {
        return ((Boolean) d.getValue(null, a[2])).booleanValue();
    }

    public static final w2 b() {
        return (w2) b.getValue(null, a[0]);
    }
}
