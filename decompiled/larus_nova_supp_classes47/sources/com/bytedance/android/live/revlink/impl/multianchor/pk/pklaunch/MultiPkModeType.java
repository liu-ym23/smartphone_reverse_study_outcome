package com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/pk/pklaunch/MultiPkModeType;", "", "BOTH", "PERSONAL", "TEAM", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiPkModeType extends Enum<MultiPkModeType> {
    public static final MultiPkModeType BOTH = null;
    public static final MultiPkModeType PERSONAL = null;
    public static final MultiPkModeType TEAM = null;
    public static final /* synthetic */ MultiPkModeType[] a = null;

    static {
        MultiPkModeType r1 = new MultiPkModeType("BOTH", 0);
        BOTH = r1;
        MultiPkModeType r2 = new MultiPkModeType("PERSONAL", 1);
        PERSONAL = r2;
        MultiPkModeType r3 = new MultiPkModeType("TEAM", 2);
        TEAM = r3;
        a = new MultiPkModeType[]{r1, r2, r3};
    }

    public static MultiPkModeType valueOf(String r1) {
        return (MultiPkModeType) r27.a.a(MultiPkModeType.class, r1);
    }

    public static MultiPkModeType[] values() {
        return (MultiPkModeType[]) a.clone();
    }

    public MultiPkModeType(String r1, int r2) {
        super(r1, r2);
    }
}
