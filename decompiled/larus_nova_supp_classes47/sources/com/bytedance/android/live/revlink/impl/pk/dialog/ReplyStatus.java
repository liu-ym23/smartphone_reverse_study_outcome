package com.bytedance.android.live.revlink.impl.pk.dialog;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/ReplyStatus;", "", "", "value", "I", "getValue", "()I", "Undefined", "Accept", "Reject", "RefuseByTimeOut", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ReplyStatus extends Enum<ReplyStatus> {
    public static final ReplyStatus Accept = null;
    public static final ReplyStatus RefuseByTimeOut = null;
    public static final ReplyStatus Reject = null;
    public static final ReplyStatus Undefined = null;
    public static final /* synthetic */ ReplyStatus[] a = null;
    private final int value;

    static {
        ReplyStatus r1 = new ReplyStatus("Undefined", 0, 0);
        Undefined = r1;
        ReplyStatus r2 = new ReplyStatus("Accept", 1, 1);
        Accept = r2;
        ReplyStatus r3 = new ReplyStatus("Reject", 2, 2);
        Reject = r3;
        ReplyStatus r4 = new ReplyStatus("RefuseByTimeOut", 3, 5);
        RefuseByTimeOut = r4;
        a = new ReplyStatus[]{r1, r2, r3, r4};
    }

    public static ReplyStatus valueOf(String r1) {
        return (ReplyStatus) r27.a.a(ReplyStatus.class, r1);
    }

    public static ReplyStatus[] values() {
        return (ReplyStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ReplyStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
