package com.bytedance.android.live.revlink.impl.pk.feedview.frame;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/feedview/frame/ModeType;", "", "PK", "Vote", "BreakThough", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ModeType extends Enum<ModeType> {
    public static final ModeType BreakThough = null;
    public static final ModeType PK = null;
    public static final ModeType Vote = null;
    public static final /* synthetic */ ModeType[] a = null;

    static {
        ModeType r1 = new ModeType("PK", 0);
        PK = r1;
        ModeType r2 = new ModeType("Vote", 1);
        Vote = r2;
        ModeType r3 = new ModeType("BreakThough", 2);
        BreakThough = r3;
        a = new ModeType[]{r1, r2, r3};
    }

    public static ModeType valueOf(String r1) {
        return (ModeType) a.a(ModeType.class, r1);
    }

    public static ModeType[] values() {
        return (ModeType[]) a.clone();
    }

    public ModeType(String r1, int r2) {
        super(r1, r2);
    }
}
