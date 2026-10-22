package com.bytedance.android.livesdk.gift.platform.business.effect.service;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/EffectGameStatus;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "Companion", "a", "IDLE", "RUNNING", "SETTING", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EffectGameStatus extends Enum<EffectGameStatus> {
    public static final a Companion = null;
    public static final EffectGameStatus IDLE = null;
    public static final EffectGameStatus RUNNING = null;
    public static final EffectGameStatus SETTING = null;
    public static final /* synthetic */ EffectGameStatus[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.gift.platform.business.effect.service.EffectGameStatus$a] */
    static {
        EffectGameStatus r1 = new EffectGameStatus("IDLE", 0, 0);
        IDLE = r1;
        EffectGameStatus r2 = new EffectGameStatus("RUNNING", 1, 1);
        RUNNING = r2;
        EffectGameStatus r3 = new EffectGameStatus("SETTING", 2, 2);
        SETTING = r3;
        a = new EffectGameStatus[]{r1, r2, r3};
        Companion = new a();
    }

    public static EffectGameStatus valueOf(String r1) {
        return (EffectGameStatus) r27.a.a(EffectGameStatus.class, r1);
    }

    public static EffectGameStatus[] values() {
        return (EffectGameStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public EffectGameStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
