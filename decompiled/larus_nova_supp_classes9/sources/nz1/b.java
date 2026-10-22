package nz1;

import com.bytedance.android.livesdk.gift.configmodel.o0;
import com.bytedance.android.livesdk.gift.configmodel.v0;
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
public final class b {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_LIST_PAGING_CONFIG", "getLIVE_GIFT_LIST_PAGING_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftListPagingConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_BUFF_AND_DIY_CARD_CONFIG", "getLIVE_GIFT_BUFF_AND_DIY_CARD_CONFIG()Lcom/bytedance/android/livesdk/gift/platform/business/config/BuffAndDiyCardConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "GROUP_SHOW_II", "getGROUP_SHOW_II()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_RECEIVER_ENTRANCE_OPTIMIZE", "getLIVE_GIFT_RECEIVER_ENTRANCE_OPTIMIZE()Lcom/bytedance/android/livesdk/gift/configmodel/GiftPanelReceiverOptimizeConfig;", 1))};
        a = r0;
        Class r6 = o0.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r7 = vh7.b.a;
        Object r8 = r7.get(r6);
        if (r8 != null) goto L12;
        r8 = r6.getConstructor(new Class[0]);
        if (r8 == null) goto L11;
        Object r9 = r7.putIfAbsent(r6, r8);
        if (r9 == null) goto L12;
        r8 = r9;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r10 = ((SerializableObjectJsonAdapterBase) ((Constructor) r8).newInstance(new Object[0])).createInstance();
        if (r10 == null) goto L45;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_list_paging_config", (o0) r10, o0.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Class r11 = com.bytedance.android.livesdk.gift.platform.business.config.a.class.getAnnotation(JsonAdapter.class).value();
        Object r13 = r7.get(r11);
        if (r13 != null) goto L24;
        r13 = r11.getConstructor(new Class[0]);
        if (r13 == null) goto L23;
        Object r14 = r7.putIfAbsent(r11, r13);
        if (r14 == null) goto L24;
        r13 = r14;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r15 = ((SerializableObjectJsonAdapterBase) ((Constructor) r13).newInstance(new Object[0])).createInstance();
        if (r15 == null) goto L43;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_buff_and_diy_card_config", (com.bytedance.android.livesdk.gift.platform.business.config.a) r15, com.bytedance.android.livesdk.gift.platform.business.config.a.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("group_show_II", 0, Integer.TYPE, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        Class r4 = v0.class.getAnnotation(JsonAdapter.class).value();
        Object r5 = r7.get(r4);
        if (r5 != null) goto L36;
        r5 = r4.getConstructor(new Class[0]);
        if (r5 == null) goto L35;
        Object r16 = r7.putIfAbsent(r4, r5);
        if (r16 == null) goto L36;
        r5 = r16;
        goto L36
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L36:
        Object r17 = ((SerializableObjectJsonAdapterBase) ((Constructor) r5).newInstance(new Object[0])).createInstance();
        if (r17 == null) goto L41;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r18 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_receiver_experience_optimize_config", (v0) r17, v0.class, false);
        e = UltraSettingsManager.a().a(r18.a, r18.b, r18.getType(), r18.d, r0[3]);
        return;
    L41:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.GiftPanelReceiverOptimizeConfig");
    L43:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.config.BuffAndDiyCardConfig");
    L45:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.GiftListPagingConfig");
    }

    public static final com.bytedance.android.livesdk.gift.platform.business.config.a a() {
        return (com.bytedance.android.livesdk.gift.platform.business.config.a) c.getValue(null, a[1]);
    }
}
