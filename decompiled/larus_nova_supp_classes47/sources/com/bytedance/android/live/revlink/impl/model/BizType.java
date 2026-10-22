package com.bytedance.android.live.revlink.impl.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/model/BizType;", "", "None", "OpenGame", "PK", "AnchorLink", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum BizType extends Enum<BizType> {
    public static final BizType AnchorLink = null;
    public static final BizType None = null;
    public static final BizType OpenGame = null;
    public static final BizType PK = null;
    public static final /* synthetic */ BizType[] a = null;

    static {
        BizType r1 = new BizType("None", 0);
        None = r1;
        BizType r2 = new BizType("OpenGame", 1);
        OpenGame = r2;
        BizType r3 = new BizType("PK", 2);
        PK = r3;
        BizType r4 = new BizType("AnchorLink", 3);
        AnchorLink = r4;
        a = new BizType[]{r1, r2, r3, r4};
    }

    public static BizType valueOf(String r1) {
        return (BizType) a.a(BizType.class, r1);
    }

    public static BizType[] values() {
        return (BizType[]) a.clone();
    }

    public BizType(String r1, int r2) {
        super(r1, r2);
    }
}
