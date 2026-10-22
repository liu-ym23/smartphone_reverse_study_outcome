package com.bytedance.android.live.broadcast.api.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/ConflictStrategy;", "", "PREEMPT", "COVER", "COEXIST", "livebroadcast-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ConflictStrategy extends Enum<ConflictStrategy> {
    public static final ConflictStrategy COEXIST = null;
    public static final ConflictStrategy COVER = null;
    public static final ConflictStrategy PREEMPT = null;
    public static final /* synthetic */ ConflictStrategy[] a = null;

    static {
        ConflictStrategy r1 = new ConflictStrategy("PREEMPT", 0);
        PREEMPT = r1;
        ConflictStrategy r2 = new ConflictStrategy("COVER", 1);
        COVER = r2;
        ConflictStrategy r3 = new ConflictStrategy("COEXIST", 2);
        COEXIST = r3;
        a = new ConflictStrategy[]{r1, r2, r3};
    }

    public static ConflictStrategy valueOf(String r1) {
        return (ConflictStrategy) r27.a.a(ConflictStrategy.class, r1);
    }

    public static ConflictStrategy[] values() {
        return (ConflictStrategy[]) a.clone();
    }

    public ConflictStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
