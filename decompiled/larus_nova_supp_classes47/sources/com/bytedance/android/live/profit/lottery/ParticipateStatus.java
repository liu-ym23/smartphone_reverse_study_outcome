package com.bytedance.android.live.profit.lottery;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/ParticipateStatus;", "", "", "status", "I", "getStatus", "()I", "UNKNOWN", "NOTPARTICIPATED", "PARTICIPATEINSUCCESS", "ISLUCKY", "PARTICIPATED", "CHOOSEING", "CHOOSEEND", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ParticipateStatus extends Enum<ParticipateStatus> {
    public static final ParticipateStatus CHOOSEEND = null;
    public static final ParticipateStatus CHOOSEING = null;
    public static final ParticipateStatus ISLUCKY = null;
    public static final ParticipateStatus NOTPARTICIPATED = null;
    public static final ParticipateStatus PARTICIPATED = null;
    public static final ParticipateStatus PARTICIPATEINSUCCESS = null;
    public static final ParticipateStatus UNKNOWN = null;
    public static final /* synthetic */ ParticipateStatus[] a = null;
    private final int status;

    static {
        ParticipateStatus r1 = new ParticipateStatus("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        ParticipateStatus r2 = new ParticipateStatus("NOTPARTICIPATED", 1, 1);
        NOTPARTICIPATED = r2;
        ParticipateStatus r3 = new ParticipateStatus("PARTICIPATEINSUCCESS", 2, 2);
        PARTICIPATEINSUCCESS = r3;
        ParticipateStatus r4 = new ParticipateStatus("ISLUCKY", 3, 3);
        ISLUCKY = r4;
        ParticipateStatus r5 = new ParticipateStatus("PARTICIPATED", 4, 4);
        PARTICIPATED = r5;
        ParticipateStatus r6 = new ParticipateStatus("CHOOSEING", 5, 5);
        CHOOSEING = r6;
        ParticipateStatus r7 = new ParticipateStatus("CHOOSEEND", 6, 6);
        CHOOSEEND = r7;
        a = new ParticipateStatus[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static ParticipateStatus valueOf(String r1) {
        return (ParticipateStatus) r27.a.a(ParticipateStatus.class, r1);
    }

    public static ParticipateStatus[] values() {
        return (ParticipateStatus[]) a.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public ParticipateStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.status = r3;
    }
}
