package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketCurState;", "", "", "stateName", "Ljava/lang/String;", "getStateName", "()Ljava/lang/String;", "Waiting", "Available", "Rushed", "Expired", "Empty", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RedPacketCurState extends Enum<RedPacketCurState> {
    public static final RedPacketCurState Available = null;
    public static final RedPacketCurState Empty = null;
    public static final RedPacketCurState Expired = null;
    public static final RedPacketCurState Rushed = null;
    public static final RedPacketCurState Waiting = null;
    public static final /* synthetic */ RedPacketCurState[] a = null;
    private final String stateName;

    static {
        RedPacketCurState r1 = new RedPacketCurState("Waiting", 0, "countdown");
        Waiting = r1;
        RedPacketCurState r2 = new RedPacketCurState("Available", 1, "grabbing");
        Available = r2;
        RedPacketCurState r3 = new RedPacketCurState("Rushed", 2, "grabbed");
        Rushed = r3;
        RedPacketCurState r4 = new RedPacketCurState("Expired", 3, "expired");
        Expired = r4;
        RedPacketCurState r5 = new RedPacketCurState("Empty", 4, "finished");
        Empty = r5;
        a = new RedPacketCurState[]{r1, r2, r3, r4, r5};
    }

    public static RedPacketCurState valueOf(String r1) {
        return (RedPacketCurState) r27.a.a(RedPacketCurState.class, r1);
    }

    public static RedPacketCurState[] values() {
        return (RedPacketCurState[]) a.clone();
    }

    public final String getStateName() {
        return this.stateName;
    }

    public RedPacketCurState(String r1, int r2, String r3) {
        super(r1, r2);
        this.stateName = r3;
    }
}
