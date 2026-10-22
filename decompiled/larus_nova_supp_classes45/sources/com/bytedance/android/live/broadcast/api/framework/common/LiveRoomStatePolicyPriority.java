package com.bytedance.android.live.broadcast.api.framework.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/common/LiveRoomStatePolicyPriority;", "", "", "value", "I", "getValue", "()I", "PlatformDefault", "BusinessCustom", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveRoomStatePolicyPriority extends Enum<LiveRoomStatePolicyPriority> {
    public static final LiveRoomStatePolicyPriority BusinessCustom = null;
    public static final LiveRoomStatePolicyPriority PlatformDefault = null;
    public static final /* synthetic */ LiveRoomStatePolicyPriority[] a = null;
    private final int value;

    static {
        LiveRoomStatePolicyPriority r1 = new LiveRoomStatePolicyPriority("PlatformDefault", 0, 0);
        PlatformDefault = r1;
        LiveRoomStatePolicyPriority r2 = new LiveRoomStatePolicyPriority("BusinessCustom", 1, 1);
        BusinessCustom = r2;
        a = new LiveRoomStatePolicyPriority[]{r1, r2};
    }

    public static LiveRoomStatePolicyPriority valueOf(String r1) {
        return (LiveRoomStatePolicyPriority) r27.a.a(LiveRoomStatePolicyPriority.class, r1);
    }

    public static LiveRoomStatePolicyPriority[] values() {
        return (LiveRoomStatePolicyPriority[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveRoomStatePolicyPriority(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
