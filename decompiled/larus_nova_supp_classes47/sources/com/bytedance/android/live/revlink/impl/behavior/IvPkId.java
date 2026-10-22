package com.bytedance.android.live.revlink.impl.behavior;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/behavior/IvPkId;", "", "MAIN", "BAK", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IvPkId extends Enum<IvPkId> {
    public static final IvPkId BAK = null;
    public static final IvPkId MAIN = null;
    public static final /* synthetic */ IvPkId[] a = null;

    static {
        IvPkId r1 = new IvPkId("MAIN", 0);
        MAIN = r1;
        IvPkId r2 = new IvPkId("BAK", 1);
        BAK = r2;
        a = new IvPkId[]{r1, r2};
    }

    public static IvPkId valueOf(String r1) {
        return (IvPkId) r27.a.a(IvPkId.class, r1);
    }

    public static IvPkId[] values() {
        return (IvPkId[]) a.clone();
    }

    public IvPkId(String r1, int r2) {
        super(r1, r2);
    }
}
