package com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseResult;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "NOT_FINISH", "WIN", "LOSE", "EVEN", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PkBaseResult extends Enum<PkBaseResult> {
    public static final PkBaseResult EVEN = null;
    public static final PkBaseResult LOSE = null;
    public static final PkBaseResult NOT_FINISH = null;
    public static final PkBaseResult WIN = null;
    public static final /* synthetic */ PkBaseResult[] a = null;
    private final String type;

    static {
        PkBaseResult r1 = new PkBaseResult("NOT_FINISH", 0, "not_finish");
        NOT_FINISH = r1;
        PkBaseResult r2 = new PkBaseResult("WIN", 1, "win");
        WIN = r2;
        PkBaseResult r3 = new PkBaseResult("LOSE", 2, "lose");
        LOSE = r3;
        PkBaseResult r4 = new PkBaseResult("EVEN", 3, "even");
        EVEN = r4;
        a = new PkBaseResult[]{r1, r2, r3, r4};
    }

    public static PkBaseResult valueOf(String r1) {
        return (PkBaseResult) r27.a.a(PkBaseResult.class, r1);
    }

    public static PkBaseResult[] values() {
        return (PkBaseResult[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public PkBaseResult(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
