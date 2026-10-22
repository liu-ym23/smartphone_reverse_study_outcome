package com.bytedance.android.live.link.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/link/data/RevPkResult;", "", "UNFINISHED", "LEFT_WON", "RIGHT_WON", "EVEN", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevPkResult extends Enum<RevPkResult> {
    public static final RevPkResult EVEN = null;
    public static final RevPkResult LEFT_WON = null;
    public static final RevPkResult RIGHT_WON = null;
    public static final RevPkResult UNFINISHED = null;
    public static final /* synthetic */ RevPkResult[] a = null;

    static {
        RevPkResult r1 = new RevPkResult("UNFINISHED", 0);
        UNFINISHED = r1;
        RevPkResult r2 = new RevPkResult("LEFT_WON", 1);
        LEFT_WON = r2;
        RevPkResult r3 = new RevPkResult("RIGHT_WON", 2);
        RIGHT_WON = r3;
        RevPkResult r4 = new RevPkResult("EVEN", 3);
        EVEN = r4;
        a = new RevPkResult[]{r1, r2, r3, r4};
    }

    public static RevPkResult valueOf(String r1) {
        return (RevPkResult) a.a(RevPkResult.class, r1);
    }

    public static RevPkResult[] values() {
        return (RevPkResult[]) a.clone();
    }

    public RevPkResult(String r1, int r2) {
        super(r1, r2);
    }
}
