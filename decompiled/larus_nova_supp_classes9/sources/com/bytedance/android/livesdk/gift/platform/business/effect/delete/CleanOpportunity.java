package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/delete/CleanOpportunity;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "UNKNOWN", "EXIT_THE_BACKGROUND", "EXIT_LIVE_ROOM", "IN_THE_LIVE_ROOM", "MANUAL_CLEAN_IN_ROOM", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CleanOpportunity extends Enum<CleanOpportunity> {
    public static final CleanOpportunity EXIT_LIVE_ROOM = null;
    public static final CleanOpportunity EXIT_THE_BACKGROUND = null;
    public static final CleanOpportunity IN_THE_LIVE_ROOM = null;
    public static final CleanOpportunity MANUAL_CLEAN_IN_ROOM = null;
    public static final CleanOpportunity UNKNOWN = null;
    public static final /* synthetic */ CleanOpportunity[] a = null;
    private final int value;

    static {
        CleanOpportunity r1 = new CleanOpportunity("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        CleanOpportunity r2 = new CleanOpportunity("EXIT_THE_BACKGROUND", 1, 1);
        EXIT_THE_BACKGROUND = r2;
        CleanOpportunity r3 = new CleanOpportunity("EXIT_LIVE_ROOM", 2, 2);
        EXIT_LIVE_ROOM = r3;
        CleanOpportunity r4 = new CleanOpportunity("IN_THE_LIVE_ROOM", 3, 3);
        IN_THE_LIVE_ROOM = r4;
        CleanOpportunity r5 = new CleanOpportunity("MANUAL_CLEAN_IN_ROOM", 4, 4);
        MANUAL_CLEAN_IN_ROOM = r5;
        a = new CleanOpportunity[]{r1, r2, r3, r4, r5};
    }

    public static CleanOpportunity valueOf(String r1) {
        return (CleanOpportunity) r27.a.a(CleanOpportunity.class, r1);
    }

    public static CleanOpportunity[] values() {
        return (CleanOpportunity[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CleanOpportunity(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
