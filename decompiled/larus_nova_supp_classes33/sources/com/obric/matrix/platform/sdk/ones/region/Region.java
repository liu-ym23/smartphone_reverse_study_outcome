package com.obric.matrix.platform.sdk.ones.region;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/region/Region;", "", "HK", "CN", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public final enum Region extends Enum<Region> {
    public static final Region CN = null;
    public static final Region HK = null;
    public static final /* synthetic */ Region[] a = null;

    public static Region valueOf(String r1) {
        return (Region) a.a(Region.class, r1);
    }

    public static Region[] values() {
        return (Region[]) a.clone();
    }

    static {
        Region r0 = new Region("HK", 0);
        HK = r0;
        Region r1 = new Region("CN", 1);
        CN = r1;
        a = new Region[]{r0, r1};
    }

    public Region(String r1, int r2) {
        super(r1, r2);
    }
}
