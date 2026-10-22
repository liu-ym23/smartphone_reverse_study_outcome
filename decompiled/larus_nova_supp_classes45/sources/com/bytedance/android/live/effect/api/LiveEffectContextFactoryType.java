package com.bytedance.android.live.effect.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryType;", "", "", "dbName", "Ljava/lang/String;", "getDbName", "()Ljava/lang/String;", "spName", "getSpName", "DEFAULT", "LINK", "GIFT", "DIGIT_AVATAR", "VR", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveEffectContextFactoryType extends Enum<LiveEffectContextFactoryType> {
    public static final LiveEffectContextFactoryType DEFAULT = null;
    public static final LiveEffectContextFactoryType DIGIT_AVATAR = null;
    public static final LiveEffectContextFactoryType GIFT = null;
    public static final LiveEffectContextFactoryType LINK = null;
    public static final LiveEffectContextFactoryType VR = null;
    public static final /* synthetic */ LiveEffectContextFactoryType[] a = null;
    private final String dbName;
    private final String spName;

    static {
        LiveEffectContextFactoryType r1 = new LiveEffectContextFactoryType("DEFAULT", 0, "live_composer.db", null);
        DEFAULT = r1;
        LiveEffectContextFactoryType r2 = new LiveEffectContextFactoryType("LINK", 1, "live_composer_link.db", "tt_live_sdk_effect_link");
        LINK = r2;
        LiveEffectContextFactoryType r3 = new LiveEffectContextFactoryType("GIFT", 2, "live_composer_gift.db", "ttlive_sdk_effect_gift");
        GIFT = r3;
        LiveEffectContextFactoryType r4 = new LiveEffectContextFactoryType("DIGIT_AVATAR", 3, "live_composer_digit_avatar.db", "ttlive_sdk_effect_digit_avatar");
        DIGIT_AVATAR = r4;
        LiveEffectContextFactoryType r5 = new LiveEffectContextFactoryType("VR", 4, "live_composer_vr.db", null);
        VR = r5;
        a = new LiveEffectContextFactoryType[]{r1, r2, r3, r4, r5};
    }

    public static LiveEffectContextFactoryType valueOf(String r1) {
        return (LiveEffectContextFactoryType) r27.a.a(LiveEffectContextFactoryType.class, r1);
    }

    public static LiveEffectContextFactoryType[] values() {
        return (LiveEffectContextFactoryType[]) a.clone();
    }

    public final String getDbName() {
        return this.dbName;
    }

    public final String getSpName() {
        return this.spName;
    }

    public LiveEffectContextFactoryType(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.dbName = r3;
        this.spName = r4;
    }
}
