package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketDrawStatus;", "", "JOINED", "UNREWARDED", "REWARDED", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RedPacketDrawStatus extends Enum<RedPacketDrawStatus> {
    public static final RedPacketDrawStatus JOINED = null;
    public static final RedPacketDrawStatus REWARDED = null;
    public static final RedPacketDrawStatus UNREWARDED = null;
    public static final /* synthetic */ RedPacketDrawStatus[] a = null;

    static {
        RedPacketDrawStatus r1 = new RedPacketDrawStatus("JOINED", 0);
        JOINED = r1;
        RedPacketDrawStatus r2 = new RedPacketDrawStatus("UNREWARDED", 1);
        UNREWARDED = r2;
        RedPacketDrawStatus r3 = new RedPacketDrawStatus("REWARDED", 2);
        REWARDED = r3;
        a = new RedPacketDrawStatus[]{r1, r2, r3};
    }

    public static RedPacketDrawStatus valueOf(String r1) {
        return (RedPacketDrawStatus) r27.a.a(RedPacketDrawStatus.class, r1);
    }

    public static RedPacketDrawStatus[] values() {
        return (RedPacketDrawStatus[]) a.clone();
    }

    public RedPacketDrawStatus(String r1, int r2) {
        super(r1, r2);
    }
}
