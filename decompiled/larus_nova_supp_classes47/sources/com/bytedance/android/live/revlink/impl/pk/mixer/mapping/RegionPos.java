package com.bytedance.android.live.revlink.impl.pk.mixer.mapping;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/mixer/mapping/RegionPos;", "", "SELF", "OTHER", "GUEST1", "GUEST2", "O_GUEST1", "O_GUEST2", "OTHER_WITH_GUEST", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RegionPos extends Enum<RegionPos> {
    public static final RegionPos GUEST1 = null;
    public static final RegionPos GUEST2 = null;
    public static final RegionPos OTHER = null;
    public static final RegionPos OTHER_WITH_GUEST = null;
    public static final RegionPos O_GUEST1 = null;
    public static final RegionPos O_GUEST2 = null;
    public static final RegionPos SELF = null;
    public static final /* synthetic */ RegionPos[] a = null;

    static {
        RegionPos r1 = new RegionPos("SELF", 0);
        SELF = r1;
        RegionPos r2 = new RegionPos("OTHER", 1);
        OTHER = r2;
        RegionPos r3 = new RegionPos("GUEST1", 2);
        GUEST1 = r3;
        RegionPos r4 = new RegionPos("GUEST2", 3);
        GUEST2 = r4;
        RegionPos r5 = new RegionPos("O_GUEST1", 4);
        O_GUEST1 = r5;
        RegionPos r6 = new RegionPos("O_GUEST2", 5);
        O_GUEST2 = r6;
        RegionPos r7 = new RegionPos("OTHER_WITH_GUEST", 6);
        OTHER_WITH_GUEST = r7;
        a = new RegionPos[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static RegionPos valueOf(String r1) {
        return (RegionPos) a.a(RegionPos.class, r1);
    }

    public static RegionPos[] values() {
        return (RegionPos[]) a.clone();
    }

    public RegionPos(String r1, int r2) {
        super(r1, r2);
    }
}
