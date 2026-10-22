package com.bytedance.android.live.broadcast.api.framework.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/common/LiveAVResourceType;", "", "", "value", "I", "getValue", "()I", "VIDEO", "AUDIO", "ALL", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveAVResourceType extends Enum<LiveAVResourceType> {
    public static final LiveAVResourceType ALL = null;
    public static final LiveAVResourceType AUDIO = null;
    public static final LiveAVResourceType VIDEO = null;
    public static final /* synthetic */ LiveAVResourceType[] a = null;
    private final int value;

    static {
        LiveAVResourceType r1 = new LiveAVResourceType("VIDEO", 0, 0);
        VIDEO = r1;
        LiveAVResourceType r2 = new LiveAVResourceType("AUDIO", 1, 1);
        AUDIO = r2;
        LiveAVResourceType r3 = new LiveAVResourceType("ALL", 2, 2);
        ALL = r3;
        a = new LiveAVResourceType[]{r1, r2, r3};
    }

    public static LiveAVResourceType valueOf(String r1) {
        return (LiveAVResourceType) r27.a.a(LiveAVResourceType.class, r1);
    }

    public static LiveAVResourceType[] values() {
        return (LiveAVResourceType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveAVResourceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
