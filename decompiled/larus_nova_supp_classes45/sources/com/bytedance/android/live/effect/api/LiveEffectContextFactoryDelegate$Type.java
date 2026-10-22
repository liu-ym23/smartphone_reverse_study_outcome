package com.bytedance.android.live.effect.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"com/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type", "", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "Lcom/bytedance/android/live/effect/api/h;", "", "dbName", "Ljava/lang/String;", "getDbName", "()Ljava/lang/String;", "spName", "getSpName", "DEFAULT", "LINK", "GIFT", "DIGIT_AVATAR", "VR", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveEffectContextFactoryDelegate$Type extends Enum<LiveEffectContextFactoryDelegate$Type> implements h {
    public static final LiveEffectContextFactoryDelegate$Type DEFAULT = null;
    public static final LiveEffectContextFactoryDelegate$Type DIGIT_AVATAR = null;
    public static final LiveEffectContextFactoryDelegate$Type GIFT = null;
    public static final LiveEffectContextFactoryDelegate$Type LINK = null;
    public static final LiveEffectContextFactoryDelegate$Type VR = null;
    public static final /* synthetic */ LiveEffectContextFactoryDelegate$Type[] a = null;
    private final String dbName;
    private final String spName;

    static {
        LiveEffectContextFactoryDelegate$Type r1 = new LiveEffectContextFactoryDelegate$Type("DEFAULT", 0, "live_composer.db", null);
        DEFAULT = r1;
        LiveEffectContextFactoryDelegate$Type r2 = new LiveEffectContextFactoryDelegate$Type("LINK", 1, "live_composer_link.db", "tt_live_sdk_effect_link");
        LINK = r2;
        LiveEffectContextFactoryDelegate$Type r3 = new LiveEffectContextFactoryDelegate$Type("GIFT", 2, "live_composer_gift.db", "ttlive_sdk_effect_gift");
        GIFT = r3;
        LiveEffectContextFactoryDelegate$Type r4 = new LiveEffectContextFactoryDelegate$Type("DIGIT_AVATAR", 3, "live_composer_digit_avatar.db", "ttlive_sdk_effect_digit_avatar");
        DIGIT_AVATAR = r4;
        LiveEffectContextFactoryDelegate$Type r5 = new LiveEffectContextFactoryDelegate$Type("VR", 4, "live_composer_vr.db", null);
        VR = r5;
        a = new LiveEffectContextFactoryDelegate$Type[]{r1, r2, r3, r4, r5};
    }

    public static LiveEffectContextFactoryDelegate$Type valueOf(String r1) {
        return (LiveEffectContextFactoryDelegate$Type) r27.a.a(LiveEffectContextFactoryDelegate$Type.class, r1);
    }

    public static LiveEffectContextFactoryDelegate$Type[] values() {
        return (LiveEffectContextFactoryDelegate$Type[]) a.clone();
    }

    public final String getDbName() {
        return this.dbName;
    }

    public final String getSpName() {
        return this.spName;
    }

    public LiveEffectContextFactoryDelegate$Type(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.dbName = r3;
        this.spName = r4;
    }
}
