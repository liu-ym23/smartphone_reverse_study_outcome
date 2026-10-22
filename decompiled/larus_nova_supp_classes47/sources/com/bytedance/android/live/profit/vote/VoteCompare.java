package com.bytedance.android.live.profit.vote;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/vote/VoteCompare;", "", "Draw", "LeftWin", "RightWin", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum VoteCompare extends Enum<VoteCompare> {
    public static final VoteCompare Draw = null;
    public static final VoteCompare LeftWin = null;
    public static final VoteCompare RightWin = null;
    public static final /* synthetic */ VoteCompare[] a = null;

    static {
        VoteCompare r1 = new VoteCompare("Draw", 0);
        Draw = r1;
        VoteCompare r2 = new VoteCompare("LeftWin", 1);
        LeftWin = r2;
        VoteCompare r3 = new VoteCompare("RightWin", 2);
        RightWin = r3;
        a = new VoteCompare[]{r1, r2, r3};
    }

    public static VoteCompare valueOf(String r1) {
        return (VoteCompare) r27.a.a(VoteCompare.class, r1);
    }

    public static VoteCompare[] values() {
        return (VoteCompare[]) a.clone();
    }

    public VoteCompare(String r1, int r2) {
        super(r1, r2);
    }
}
