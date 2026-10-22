package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/ui/configuration/ClickType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "NormalGiftEffectSwitch", "StickerGiftEffectSwitch", "EffectGame", "RoleSkill", "GiftVoice", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ClickType extends Enum<ClickType> {
    public static final ClickType EffectGame = null;
    public static final ClickType GiftVoice = null;
    public static final ClickType NormalGiftEffectSwitch = null;
    public static final ClickType RoleSkill = null;
    public static final ClickType StickerGiftEffectSwitch = null;
    public static final /* synthetic */ ClickType[] a = null;
    private final String value;

    static {
        ClickType r1 = new ClickType("NormalGiftEffectSwitch", 0, "common_gift");
        NormalGiftEffectSwitch = r1;
        ClickType r2 = new ClickType("StickerGiftEffectSwitch", 1, "face_gift");
        StickerGiftEffectSwitch = r2;
        ClickType r3 = new ClickType("EffectGame", 2, "game_gift");
        EffectGame = r3;
        ClickType r4 = new ClickType("RoleSkill", 3, "role_gift");
        RoleSkill = r4;
        ClickType r5 = new ClickType("GiftVoice", 4, "gift_voice");
        GiftVoice = r5;
        a = new ClickType[]{r1, r2, r3, r4, r5};
    }

    public static ClickType valueOf(String r1) {
        return (ClickType) r27.a.a(ClickType.class, r1);
    }

    public static ClickType[] values() {
        return (ClickType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ClickType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
