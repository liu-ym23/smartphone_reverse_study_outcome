package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.content.Context;
import com.bytedance.android.live.revenue.common.ToastUtil;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftEffectConfigurationCommonItemKt {
    public static final void b(boolean r1) {
        if (r1 == true) goto L5;
        ToastUtil.a(2131917168, 0);
        return;
    L5:
        ToastUtil.a(2131917169, 0);
    }

    public static final i a(Context r9, boolean r10, final Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        final GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$1 r0 = new GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$1(r10);
        final GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$3 r13 = new GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$3(r10, new GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$2(r9, r10));
        if (r10 == false) goto L5;
        String r14 = "主播侧播放礼物声音/震动";
    L6:
        GiftEffectSwitchConfigType r2 = GiftEffectSwitchConfigType.SoundAndVibrationSwitch;
        return new i(r2, r14, new GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$4(r0), new GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$5(r13), true, new GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$6(r11), "礼物声音/震动功能说明");
    L5:
        r14 = "礼物声音/震动";
        goto L6
    }
}
