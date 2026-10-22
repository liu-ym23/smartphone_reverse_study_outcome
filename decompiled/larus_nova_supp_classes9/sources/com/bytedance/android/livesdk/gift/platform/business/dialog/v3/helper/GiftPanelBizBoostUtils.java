package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftPanelBizBoostUtils {
    public static d0 A;
    public static final Lazy B = null;
    public static final Lazy C = null;
    public static final Lazy D = null;
    public static final GiftPanelBizBoostUtils E = null;
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;
    public static final ReadOnlyProperty g = null;
    public static final ReadOnlyProperty h = null;
    public static final ReadOnlyProperty i = null;
    public static final ReadOnlyProperty j = null;
    public static final ReadOnlyProperty k = null;
    public static final Lazy l = null;
    public static final Lazy m = null;
    public static final Lazy n = null;
    public static final Lazy o = null;
    public static final Lazy p = null;
    public static final Lazy q = null;
    public static final Lazy r = null;
    public static final Lazy s = null;
    public static final Lazy t = null;
    public static final Lazy u = null;
    public static final Lazy v = null;
    public static final Lazy w = null;
    public static final Lazy x = null;
    public static boolean y;
    public static final Lazy z = null;

    public GiftPanelBizBoostUtils() {
    }

    public static y b() {
        return (y) m.getValue();
    }

    public static boolean c() {
        return ((Boolean) t.getValue()).booleanValue();
    }

    public static b0 d() {
        return (b0) z.getValue();
    }

    public static boolean e() {
        return ((Boolean) u.getValue()).booleanValue();
    }

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PANEL_FREQUENT_CALL_OPT", "getGIFT_PANEL_FREQUENT_CALL_OPT()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelFrequentCallOpt;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PANEL_SYNC_LOAD_WIDGET", "getGIFT_PANEL_SYNC_LOAD_WIDGET()Z", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PANEL_INIT_STATE_OPT_CONFIG", "getGIFT_PANEL_INIT_STATE_OPT_CONFIG()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelInitStateOptConfig;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PANEL_ASYNC_LOAD_ANNIE_CARD", "getGIFT_PANEL_ASYNC_LOAD_ANNIE_CARD()Z", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PAGE_LIST_CACHE_ENABLE", "getGIFT_PAGE_LIST_CACHE_ENABLE()Z", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "RECHARGE_OPEN_GIFT_PANEL_NOT_REFRESH_LIST", "getRECHARGE_OPEN_GIFT_PANEL_NOT_REFRESH_LIST()Z", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PANEL_ASYNC_TASK_CONFIG", "getGIFT_PANEL_ASYNC_TASK_CONFIG()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelAsyncTaskConfig;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PANEL_MUTATE_EXTERNAL_OPT", "getGIFT_PANEL_MUTATE_EXTERNAL_OPT()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelMutateOpt;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PANEL_DEFAULT_SELECT_ANIMATION_OPT", "getGIFT_PANEL_DEFAULT_SELECT_ANIMATION_OPT()Z", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PANEL_OPEN_ANIMATION_OPT", "getGIFT_PANEL_OPEN_ANIMATION_OPT()Z", 0))};
        a = r0;
        GiftPanelBizBoostUtils r1 = new GiftPanelBizBoostUtils();
        E = r1;
        Class r13 = a0.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r14 = vh7.b.a;
        Object r15 = r14.get(r13);
        if (r15 != null) goto L12;
        r15 = r13.getConstructor(new Class[0]);
        if (r15 == null) goto L11;
        Object r16 = r14.putIfAbsent(r13, r15);
        if (r16 == null) goto L12;
        r15 = r16;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r17 = ((SerializableObjectJsonAdapterBase) ((Constructor) r15).newInstance(new Object[0])).createInstance();
        if (r17 == null) goto L59;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r18 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_frequent_call_opt", (a0) r17, a0.class, false);
        b = UltraSettingsManager.a().a(r18.a, r18.b, r18.getType(), r18.d, r0[0]);
        Boolean r19 = Boolean.FALSE;
        Class r110 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_sync_load_widget", r19, r110, false);
        ReadOnlyProperty r2 = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[1]);
        c = r2;
        Class r9 = b0.class.getAnnotation(JsonAdapter.class).value();
        Object r111 = r14.get(r9);
        if (r111 != null) goto L24;
        r111 = r9.getConstructor(new Class[0]);
        if (r111 == null) goto L23;
        Object r11 = r14.putIfAbsent(r9, r111);
        if (r11 == null) goto L24;
        r111 = r11;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r20 = ((SerializableObjectJsonAdapterBase) ((Constructor) r111).newInstance(new Object[0])).createInstance();
        if (r20 == null) goto L57;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r112 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_init_state_opt_config", (b0) r20, b0.class, false);
        d = UltraSettingsManager.a().a(r112.a, r112.b, r112.getType(), r112.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_async_load_annie_card", r19, r110, false);
        e = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_page_list_cache_enable", Boolean.TRUE, r110, false);
        f = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("recharge_open_gift_panel_not_refresh_list", r19, r110, false);
        g = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[5]);
        Class r6 = y.class.getAnnotation(JsonAdapter.class).value();
        Object r7 = r14.get(r6);
        if (r7 != null) goto L36;
        r7 = r6.getConstructor(new Class[0]);
        if (r7 == null) goto L35;
        Object r8 = r14.putIfAbsent(r6, r7);
        if (r8 == null) goto L36;
        r7 = r8;
        goto L36
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L36:
        Object r21 = ((SerializableObjectJsonAdapterBase) ((Constructor) r7).newInstance(new Object[0])).createInstance();
        if (r21 == null) goto L55;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r23 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_async_task_config", (y) r21, y.class, false);
        h = UltraSettingsManager.a().a(r23.a, r23.b, r23.getType(), r23.d, r0[6]);
        Class r24 = d0.class.getAnnotation(JsonAdapter.class).value();
        Object r25 = r14.get(r24);
        if (r25 != null) goto L48;
        r25 = r24.getConstructor(new Class[0]);
        if (r25 == null) goto L47;
        Object r26 = r14.putIfAbsent(r24, r25);
        if (r26 == null) goto L48;
        r25 = r26;
        goto L48
    L47:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L48:
        Object r27 = ((SerializableObjectJsonAdapterBase) ((Constructor) r25).newInstance(new Object[0])).createInstance();
        if (r27 == null) goto L53;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r28 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_mutate_external_opt", (d0) r27, d0.class, false);
        ReadOnlyProperty r29 = UltraSettingsManager.a().a(r28.a, r28.b, r28.getType(), r28.d, r0[7]);
        i = r29;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r30 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_default_select_animation_opt", r19, r110, false);
        j = UltraSettingsManager.a().a(r30.a, r30.b, r30.getType(), r30.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r31 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_open_animation_opt", r19, r110, false);
        k = UltraSettingsManager.a().a(r31.a, r31.b, r31.getType(), r31.d, r0[9]);
        l = LazyKt.lazy(GiftPanelBizBoostUtils$frequentCallOpt$2.INSTANCE);
        m = LazyKt.lazy(GiftPanelBizBoostUtils$asyncTaskConfig$2.INSTANCE);
        n = LazyKt.lazy(GiftPanelBizBoostUtils$bottomTextOpt$2.INSTANCE);
        o = LazyKt.lazy(GiftPanelBizBoostUtils$logGiftShowOpt$2.INSTANCE);
        p = LazyKt.lazy(GiftPanelBizBoostUtils$aLogOpt$2.INSTANCE);
        q = LazyKt.lazy(GiftPanelBizBoostUtils$wrapDialogIconModelOpt$2.INSTANCE);
        r = LazyKt.lazy(GiftPanelBizBoostUtils$settingReadOpt$2.INSTANCE);
        s = LazyKt.lazy(GiftPanelBizBoostUtils$resourceOpt$2.INSTANCE);
        t = LazyKt.lazy(GiftPanelBizBoostUtils$giftCardSpOpt$2.INSTANCE);
        u = LazyKt.lazy(GiftPanelBizBoostUtils$newListOpt$2.INSTANCE);
        v = LazyKt.lazy(GiftPanelBizBoostUtils$giftBuffShowNow$2.INSTANCE);
        w = LazyKt.lazy(GiftPanelBizBoostUtils$giftShowNowConfig$2.INSTANCE);
        x = LazyKt.lazy(GiftPanelBizBoostUtils$defaultSelectAnimationOpt$2.INSTANCE);
        y = ((Boolean) r2.getValue(r1, r0[1])).booleanValue();
        z = LazyKt.lazy(GiftPanelBizBoostUtils$initStateOpt$2.INSTANCE);
        A = (d0) r29.getValue(r1, r0[7]);
        B = LazyKt.lazy(GiftPanelBizBoostUtils$asyncLoadLynx$2.INSTANCE);
        C = LazyKt.lazy(GiftPanelBizBoostUtils$rechargeOpenGiftPanelNotRefreshList$2.INSTANCE);
        D = LazyKt.lazy(GiftPanelBizBoostUtils$giftPagesCache$2.INSTANCE);
        return;
    L53:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelMutateOpt");
    L55:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelAsyncTaskConfig");
    L57:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelInitStateOptConfig");
    L59:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelFrequentCallOpt");
    }

    public static final a0 a(GiftPanelBizBoostUtils r0) {
        r0.getClass();
        return (a0) l.getValue();
    }
}
