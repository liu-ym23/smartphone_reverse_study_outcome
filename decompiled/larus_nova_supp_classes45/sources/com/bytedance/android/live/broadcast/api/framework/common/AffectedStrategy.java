package com.bytedance.android.live.broadcast.api.framework.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/common/AffectedStrategy;", "", "", "value", "I", "getValue", "()I", "AUTO", "NONE", "ALL", "CUSTOM", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AffectedStrategy extends Enum<AffectedStrategy> {
    public static final AffectedStrategy ALL = null;
    public static final AffectedStrategy AUTO = null;
    public static final AffectedStrategy CUSTOM = null;
    public static final AffectedStrategy NONE = null;
    public static final /* synthetic */ AffectedStrategy[] a = null;
    private final int value;

    static {
        AffectedStrategy r1 = new AffectedStrategy("AUTO", 0, 0);
        AUTO = r1;
        AffectedStrategy r2 = new AffectedStrategy("NONE", 1, 1);
        NONE = r2;
        AffectedStrategy r3 = new AffectedStrategy("ALL", 2, 2);
        ALL = r3;
        AffectedStrategy r4 = new AffectedStrategy("CUSTOM", 3, 3);
        CUSTOM = r4;
        a = new AffectedStrategy[]{r1, r2, r3, r4};
    }

    public static AffectedStrategy valueOf(String r1) {
        return (AffectedStrategy) r27.a.a(AffectedStrategy.class, r1);
    }

    public static AffectedStrategy[] values() {
        return (AffectedStrategy[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public AffectedStrategy(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
