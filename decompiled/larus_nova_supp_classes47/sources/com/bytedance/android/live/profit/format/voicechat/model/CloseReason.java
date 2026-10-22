package com.bytedance.android.live.profit.format.voicechat.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/model/CloseReason;", "", "", "type", "I", "getType", "()I", "UNKNOWN", "COUNT_DOWN", "USER_CLOSE", "OTHER", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CloseReason extends Enum<CloseReason> {
    public static final CloseReason COUNT_DOWN = null;
    public static final CloseReason OTHER = null;
    public static final CloseReason UNKNOWN = null;
    public static final CloseReason USER_CLOSE = null;
    public static final /* synthetic */ CloseReason[] a = null;
    private final int type;

    static {
        CloseReason r1 = new CloseReason("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        CloseReason r2 = new CloseReason("COUNT_DOWN", 1, 1);
        COUNT_DOWN = r2;
        CloseReason r3 = new CloseReason("USER_CLOSE", 2, 2);
        USER_CLOSE = r3;
        CloseReason r4 = new CloseReason("OTHER", 3, 3);
        OTHER = r4;
        a = new CloseReason[]{r1, r2, r3, r4};
    }

    public static CloseReason valueOf(String r1) {
        return (CloseReason) r27.a.a(CloseReason.class, r1);
    }

    public static CloseReason[] values() {
        return (CloseReason[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public CloseReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
