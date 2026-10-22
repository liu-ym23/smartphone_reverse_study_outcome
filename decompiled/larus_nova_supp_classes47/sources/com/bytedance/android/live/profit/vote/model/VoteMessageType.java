package com.bytedance.android.live.profit.vote.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/profit/vote/model/VoteMessageType;", "", "", "value", "J", "getValue", "()J", "Update", "Finish", "Create", "Pause", "Resume", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum VoteMessageType extends Enum<VoteMessageType> {
    public static final VoteMessageType Create = null;
    public static final VoteMessageType Finish = null;
    public static final VoteMessageType Pause = null;
    public static final VoteMessageType Resume = null;
    public static final VoteMessageType Update = null;
    public static final /* synthetic */ VoteMessageType[] a = null;
    private final long value;

    static {
        VoteMessageType r1 = new VoteMessageType("Update", 0, 1);
        Update = r1;
        VoteMessageType r2 = new VoteMessageType("Finish", 1, 2);
        Finish = r2;
        VoteMessageType r3 = new VoteMessageType("Create", 2, 3);
        Create = r3;
        VoteMessageType r4 = new VoteMessageType("Pause", 3, 4);
        Pause = r4;
        VoteMessageType r5 = new VoteMessageType("Resume", 4, 5);
        Resume = r5;
        a = new VoteMessageType[]{r1, r2, r3, r4, r5};
    }

    public static VoteMessageType valueOf(String r1) {
        return (VoteMessageType) r27.a.a(VoteMessageType.class, r1);
    }

    public static VoteMessageType[] values() {
        return (VoteMessageType[]) a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public VoteMessageType(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
