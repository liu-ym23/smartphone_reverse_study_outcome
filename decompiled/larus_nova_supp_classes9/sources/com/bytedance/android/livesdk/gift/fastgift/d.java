package com.bytedance.android.livesdk.gift.fastgift;

import com.bytedance.android.livesdkapi.depend.model.LiveStartRoomOptConfig;
import com.bytedance.android.livesdkapi.depend.model.NewSendGiftConfig;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;
    public static final ReadOnlyProperty g = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_START_ROOM_OPT_SWITCH", "getLIVE_START_ROOM_OPT_SWITCH()Lcom/bytedance/android/livesdkapi/depend/model/LiveStartRoomOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_NEW_SEND_GIFT_BG_STYLE", "getLIVE_NEW_SEND_GIFT_BG_STYLE()Lcom/bytedance/android/livesdkapi/depend/model/NewSendGiftConfig;", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_HIDE_REMIND_WHEN_FAST_GIFT_PRICE_NOT_CHANGED", "getLIVE_HIDE_REMIND_WHEN_FAST_GIFT_PRICE_NOT_CHANGED()Z", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_GIFT_TOOLBAR_OPTIMIZE", "getLIVE_GIFT_TOOLBAR_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_FAST_GIFT_DIALOG_CONFIG", "getLIVE_FAST_GIFT_DIALOG_CONFIG()Lcom/bytedance/android/livesdk/gift/fastgift/config/FastGiftDialogConfig;", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "GIFT_REPEAT_SEND_TIMEOUT", "getGIFT_REPEAT_SEND_TIMEOUT()I", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_start_room_opt_switch", new LiveStartRoomOptConfig(), LiveStartRoomOptConfig.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_new_send_gift_bg_style", new NewSendGiftConfig(), NewSendGiftConfig.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Boolean r5 = Boolean.FALSE;
        Class r8 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_hide_remind_when_fast_gift_price_not_changed", r5, r8, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_toolbar_optimize", Boolean.TRUE, r8, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_fast_gift_dialog_config", new ky1.a(), ky1.a.class, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_repeat_timeout", 3, Integer.TYPE, false);
        g = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[5]);
    }

    public static final ky1.a a() {
        return (ky1.a) f.getValue(null, a[4]);
    }

    public static final LiveStartRoomOptConfig b() {
        return (LiveStartRoomOptConfig) b.getValue(null, a[0]);
    }
}
