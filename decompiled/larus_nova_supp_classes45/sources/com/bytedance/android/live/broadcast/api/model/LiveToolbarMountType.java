package com.bytedance.android.live.broadcast.api.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/LiveToolbarMountType;", "", "", "value", "I", "getValue", "()I", "MANUAL", "AUTO", "MANUAL_AND_AUTO", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveToolbarMountType extends Enum<LiveToolbarMountType> {
    public static final LiveToolbarMountType AUTO = null;
    public static final LiveToolbarMountType MANUAL = null;
    public static final LiveToolbarMountType MANUAL_AND_AUTO = null;
    public static final /* synthetic */ LiveToolbarMountType[] a = null;
    private final int value;

    static {
        LiveToolbarMountType r2 = new LiveToolbarMountType("MANUAL", 0, 1);
        MANUAL = r2;
        LiveToolbarMountType r3 = new LiveToolbarMountType("AUTO", 1, 2);
        AUTO = r3;
        LiveToolbarMountType r4 = new LiveToolbarMountType("MANUAL_AND_AUTO", 2, 3);
        MANUAL_AND_AUTO = r4;
        a = new LiveToolbarMountType[]{r2, r3, r4};
    }

    public static LiveToolbarMountType valueOf(String r1) {
        return (LiveToolbarMountType) r27.a.a(LiveToolbarMountType.class, r1);
    }

    public static LiveToolbarMountType[] values() {
        return (LiveToolbarMountType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveToolbarMountType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
