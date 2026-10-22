package com.bytedance.android.live.room.incentiveinfo.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/model/BizStatus;", "", "", "value", "J", "getValue", "()J", "UNKNOW", "START", "END", "UPDATE", "NEW_ORDER", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BizStatus extends Enum<BizStatus> {
    public static final BizStatus END = null;
    public static final BizStatus NEW_ORDER = null;
    public static final BizStatus START = null;
    public static final BizStatus UNKNOW = null;
    public static final BizStatus UPDATE = null;
    public static final /* synthetic */ BizStatus[] a = null;
    private final long value;

    static {
        BizStatus r1 = new BizStatus("UNKNOW", 0, 0);
        UNKNOW = r1;
        BizStatus r2 = new BizStatus("START", 1, 1);
        START = r2;
        BizStatus r3 = new BizStatus("END", 2, 2);
        END = r3;
        BizStatus r4 = new BizStatus("UPDATE", 3, 3);
        UPDATE = r4;
        BizStatus r5 = new BizStatus("NEW_ORDER", 4, 4);
        NEW_ORDER = r5;
        a = new BizStatus[]{r1, r2, r3, r4, r5};
    }

    public static BizStatus valueOf(String r1) {
        return (BizStatus) a.a(BizStatus.class, r1);
    }

    public static BizStatus[] values() {
        return (BizStatus[]) a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public BizStatus(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
