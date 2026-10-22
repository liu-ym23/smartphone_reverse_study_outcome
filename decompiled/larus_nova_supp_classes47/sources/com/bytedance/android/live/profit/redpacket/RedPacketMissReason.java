package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketMissReason;", "", "", "reasonString", "Ljava/lang/String;", "getReasonString", "()Ljava/lang/String;", "Empty", "Expired", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RedPacketMissReason extends Enum<RedPacketMissReason> {
    public static final RedPacketMissReason Empty = null;
    public static final RedPacketMissReason Expired = null;
    public static final /* synthetic */ RedPacketMissReason[] a = null;
    private final String reasonString;

    static {
        RedPacketMissReason r1 = new RedPacketMissReason("Empty", 0, "grab_over");
        Empty = r1;
        RedPacketMissReason r2 = new RedPacketMissReason("Expired", 1, "disappear");
        Expired = r2;
        a = new RedPacketMissReason[]{r1, r2};
    }

    public static RedPacketMissReason valueOf(String r1) {
        return (RedPacketMissReason) r27.a.a(RedPacketMissReason.class, r1);
    }

    public static RedPacketMissReason[] values() {
        return (RedPacketMissReason[]) a.clone();
    }

    public final String getReasonString() {
        return this.reasonString;
    }

    public RedPacketMissReason(String r1, int r2, String r3) {
        super(r1, r2);
        this.reasonString = r3;
    }
}
