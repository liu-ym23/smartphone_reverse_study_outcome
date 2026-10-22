package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/ui/configuration/GiftEffectSwitchConfigType;", BuildConfig.FLAVOR, "NormalGiftSwitch", "StickerGiftSwitch", "SoundAndVibrationSwitch", "EffectGame", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GiftEffectSwitchConfigType extends Enum<GiftEffectSwitchConfigType> {
    public static final GiftEffectSwitchConfigType EffectGame = null;
    public static final GiftEffectSwitchConfigType NormalGiftSwitch = null;
    public static final GiftEffectSwitchConfigType SoundAndVibrationSwitch = null;
    public static final GiftEffectSwitchConfigType StickerGiftSwitch = null;
    public static final /* synthetic */ GiftEffectSwitchConfigType[] a = null;

    static {
        GiftEffectSwitchConfigType r1 = new GiftEffectSwitchConfigType("NormalGiftSwitch", 0);
        NormalGiftSwitch = r1;
        GiftEffectSwitchConfigType r2 = new GiftEffectSwitchConfigType("StickerGiftSwitch", 1);
        StickerGiftSwitch = r2;
        GiftEffectSwitchConfigType r3 = new GiftEffectSwitchConfigType("SoundAndVibrationSwitch", 2);
        SoundAndVibrationSwitch = r3;
        GiftEffectSwitchConfigType r4 = new GiftEffectSwitchConfigType("EffectGame", 3);
        EffectGame = r4;
        a = new GiftEffectSwitchConfigType[]{r1, r2, r3, r4};
    }

    public static GiftEffectSwitchConfigType valueOf(String r1) {
        return (GiftEffectSwitchConfigType) r27.a.a(GiftEffectSwitchConfigType.class, r1);
    }

    public static GiftEffectSwitchConfigType[] values() {
        return (GiftEffectSwitchConfigType[]) a.clone();
    }

    public GiftEffectSwitchConfigType(String r1, int r2) {
        super(r1, r2);
    }
}
