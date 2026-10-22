package com.bytedance.android.live.recharge.deal;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/deal/Entrance;", "", "", "value", "I", "getValue", "()I", "Unknown", "Wallet", "Recharge", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum Entrance extends Enum<Entrance> {
    public static final Entrance Recharge = null;
    public static final Entrance Unknown = null;
    public static final Entrance Wallet = null;
    public static final /* synthetic */ Entrance[] a = null;
    private final int value;

    static {
        Entrance r1 = new Entrance("Unknown", 0, 0);
        Unknown = r1;
        Entrance r2 = new Entrance("Wallet", 1, 1);
        Wallet = r2;
        Entrance r3 = new Entrance("Recharge", 2, 2);
        Recharge = r3;
        a = new Entrance[]{r1, r2, r3};
    }

    public static Entrance valueOf(String r1) {
        return (Entrance) r27.a.a(Entrance.class, r1);
    }

    public static Entrance[] values() {
        return (Entrance[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public Entrance(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
