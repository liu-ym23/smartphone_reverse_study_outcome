package com.bytedance.android.live.profit.fansclub;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/GuardStatus;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "NoGuard", "NotParticipateGuard", "ActiveGuard", "InactiveGuard", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GuardStatus extends Enum<GuardStatus> {
    public static final GuardStatus ActiveGuard = null;
    public static final a Companion = null;
    public static final GuardStatus InactiveGuard = null;
    public static final GuardStatus NoGuard = null;
    public static final GuardStatus NotParticipateGuard = null;
    public static final /* synthetic */ GuardStatus[] a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    static {
        GuardStatus r1 = new GuardStatus("NoGuard", 0, -1);
        NoGuard = r1;
        GuardStatus r2 = new GuardStatus("NotParticipateGuard", 1, 0);
        NotParticipateGuard = r2;
        GuardStatus r3 = new GuardStatus("ActiveGuard", 2, 1);
        ActiveGuard = r3;
        GuardStatus r4 = new GuardStatus("InactiveGuard", 3, 2);
        InactiveGuard = r4;
        a = new GuardStatus[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static GuardStatus valueOf(String r1) {
        return (GuardStatus) r27.a.a(GuardStatus.class, r1);
    }

    public static GuardStatus[] values() {
        return (GuardStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public GuardStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
