package com.bytedance.android.livesdk.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/LiveRightCardOptType;", "", "", "value", "I", "getValue", "()I", "ONLINE", "ALL_POST", "ALL_DIRECT", "NOT_GONE", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveRightCardOptType extends Enum<LiveRightCardOptType> {
    public static final LiveRightCardOptType ALL_DIRECT = null;
    public static final LiveRightCardOptType ALL_POST = null;
    public static final LiveRightCardOptType NOT_GONE = null;
    public static final LiveRightCardOptType ONLINE = null;
    public static final /* synthetic */ LiveRightCardOptType[] a = null;
    private final int value;

    static {
        LiveRightCardOptType r1 = new LiveRightCardOptType("ONLINE", 0, 0);
        ONLINE = r1;
        LiveRightCardOptType r2 = new LiveRightCardOptType("ALL_POST", 1, 1);
        ALL_POST = r2;
        LiveRightCardOptType r3 = new LiveRightCardOptType("ALL_DIRECT", 2, 2);
        ALL_DIRECT = r3;
        LiveRightCardOptType r4 = new LiveRightCardOptType("NOT_GONE", 3, 3);
        NOT_GONE = r4;
        a = new LiveRightCardOptType[]{r1, r2, r3, r4};
    }

    public static LiveRightCardOptType valueOf(String r1) {
        return (LiveRightCardOptType) r27.a.a(LiveRightCardOptType.class, r1);
    }

    public static LiveRightCardOptType[] values() {
        return (LiveRightCardOptType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveRightCardOptType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
