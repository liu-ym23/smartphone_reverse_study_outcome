package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(a.class, "stickerDialogContent", "getStickerDialogContent()Lcom/bytedance/android/livesdk/gift/platform/core/ui/configuration/StickerDialogTipContent;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "stickerCloseDialogContent", "getStickerCloseDialogContent()Lcom/bytedance/android/livesdk/gift/platform/core/ui/configuration/StickerDialogTipContent;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_EFFECT_INTRO_SCHEMA", "getLIVE_GIFT_EFFECT_INTRO_SCHEMA()Ljava/lang/String;", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("sticker_gift_information_popup_dialog_configuration", new q("人脸礼物说明", "人脸礼物是指跟随主播脸部/肢体的礼物，包括：1）墨镜/亲吻等礼物 ；2）装饰礼物；3）大多数互动礼物等。"), q.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("sticker_close_gift_information_popup_dialog_configuration", new q("关闭人脸礼物", "关闭后，观众将看不到赠送的人脸礼物特效，是否确认关闭？"), q.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_intro_schema", BuildConfig.FLAVOR, String.class, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
    }
}
