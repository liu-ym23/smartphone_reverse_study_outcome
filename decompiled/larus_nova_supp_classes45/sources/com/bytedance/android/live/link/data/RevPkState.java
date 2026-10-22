package com.bytedance.android.live.link.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/link/data/RevPkState;", "", "DISABLE", "PK", "PENAL", "FINISHED", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevPkState extends Enum<RevPkState> {
    public static final RevPkState DISABLE = null;
    public static final RevPkState FINISHED = null;
    public static final RevPkState PENAL = null;
    public static final RevPkState PK = null;
    public static final /* synthetic */ RevPkState[] a = null;

    static {
        RevPkState r1 = new RevPkState("DISABLE", 0);
        DISABLE = r1;
        RevPkState r2 = new RevPkState("PK", 1);
        PK = r2;
        RevPkState r3 = new RevPkState("PENAL", 2);
        PENAL = r3;
        RevPkState r4 = new RevPkState("FINISHED", 3);
        FINISHED = r4;
        a = new RevPkState[]{r1, r2, r3, r4};
    }

    public static RevPkState valueOf(String r1) {
        return (RevPkState) a.a(RevPkState.class, r1);
    }

    public static RevPkState[] values() {
        return (RevPkState[]) a.clone();
    }

    public RevPkState(String r1, int r2) {
        super(r1, r2);
    }
}
