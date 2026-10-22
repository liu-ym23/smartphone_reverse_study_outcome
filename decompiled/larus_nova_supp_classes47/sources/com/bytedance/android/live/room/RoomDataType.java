package com.bytedance.android.live.room;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/RoomDataType;", "", "PRELOAD", "FULL", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RoomDataType extends Enum<RoomDataType> {
    public static final RoomDataType FULL = null;
    public static final RoomDataType PRELOAD = null;
    public static final /* synthetic */ RoomDataType[] a = null;

    static {
        RoomDataType r1 = new RoomDataType("PRELOAD", 0);
        PRELOAD = r1;
        RoomDataType r2 = new RoomDataType("FULL", 1);
        FULL = r2;
        a = new RoomDataType[]{r1, r2};
    }

    public static RoomDataType valueOf(String r1) {
        return (RoomDataType) r27.a.a(RoomDataType.class, r1);
    }

    public static RoomDataType[] values() {
        return (RoomDataType[]) a.clone();
    }

    public RoomDataType(String r1, int r2) {
        super(r1, r2);
    }
}
