package com.bytedance.android.live.core.resources;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/core/resources/CleanStrategyType;", "", "", "value", "I", "getValue", "()I", "DEFAULT", "LRU", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CleanStrategyType extends Enum<CleanStrategyType> {
    public static final CleanStrategyType DEFAULT = null;
    public static final CleanStrategyType LRU = null;
    public static final /* synthetic */ CleanStrategyType[] a = null;
    private final int value;

    static {
        CleanStrategyType r1 = new CleanStrategyType("DEFAULT", 0, 0);
        DEFAULT = r1;
        CleanStrategyType r2 = new CleanStrategyType("LRU", 1, 1);
        LRU = r2;
        a = new CleanStrategyType[]{r1, r2};
    }

    public static CleanStrategyType valueOf(String r1) {
        return (CleanStrategyType) r27.a.a(CleanStrategyType.class, r1);
    }

    public static CleanStrategyType[] values() {
        return (CleanStrategyType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CleanStrategyType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
