package com.bytedance.android.live.revlink.impl.settings.live;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final d e = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(d.class, "roomLoadOptConfig", "getRoomLoadOptConfig()Lcom/bytedance/android/live/revlink/impl/settings/live/model/RevLinkRoomLoadOptConfig;", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "linkAnchorProfilePreciseExperiment", "getLinkAnchorProfilePreciseExperiment()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "linkAnchorProfileOptConsumeLevel", "getLinkAnchorProfileOptConsumeLevel()I", 0))};
        a = r0;
        e = new d();
        Class r4 = w41.b.class.getAnnotation(JsonAdapter.class).value();
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
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revlink_room_load_opt_config", (w41.b) r8, w41.b.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_anchor_profile_precise_experiment", Boolean.FALSE, Boolean.TYPE, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_anchor_profile_opt_consume_level", -100, Integer.TYPE, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.live.model.RevLinkRoomLoadOptConfig");
    }

    public d() {
    }
}
