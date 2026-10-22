package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketImageType;", "", "UNKNOWN", "PNG", "WEBP", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RedPacketImageType extends Enum<RedPacketImageType> {
    public static final RedPacketImageType PNG = null;
    public static final RedPacketImageType UNKNOWN = null;
    public static final RedPacketImageType WEBP = null;
    public static final /* synthetic */ RedPacketImageType[] a = null;

    static {
        RedPacketImageType r1 = new RedPacketImageType("UNKNOWN", 0);
        UNKNOWN = r1;
        RedPacketImageType r2 = new RedPacketImageType("PNG", 1);
        PNG = r2;
        RedPacketImageType r3 = new RedPacketImageType("WEBP", 2);
        WEBP = r3;
        a = new RedPacketImageType[]{r1, r2, r3};
    }

    public static RedPacketImageType valueOf(String r1) {
        return (RedPacketImageType) r27.a.a(RedPacketImageType.class, r1);
    }

    public static RedPacketImageType[] values() {
        return (RedPacketImageType[]) a.clone();
    }

    public RedPacketImageType(String r1, int r2) {
        super(r1, r2);
    }
}
