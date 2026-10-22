package com.bytedance.android.live.room.navi.userinfo.model;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final enum TabLabelType extends Enum<TabLabelType> {
    public static final TabLabelType AnchorIdentity = null;
    public static final TabLabelType BaseSelection = null;
    public static final TabLabelType BrandStore = null;
    public static final TabLabelType POI = null;
    public static final TabLabelType QualityGeek = null;
    public static final TabLabelType SecureBuy = null;
    public static final TabLabelType Undefined = null;
    public static final /* synthetic */ TabLabelType[] a = null;
    public final int value;

    static {
        TabLabelType r0 = new TabLabelType("Undefined", 0, 0);
        Undefined = r0;
        TabLabelType r1 = new TabLabelType("BaseSelection", 1, 101);
        BaseSelection = r1;
        TabLabelType r3 = new TabLabelType("BrandStore", 2, 106);
        BrandStore = r3;
        TabLabelType r4 = new TabLabelType("SecureBuy", 3, 109);
        SecureBuy = r4;
        TabLabelType r6 = new TabLabelType("QualityGeek", 4, 1013);
        QualityGeek = r6;
        TabLabelType r8 = new TabLabelType("AnchorIdentity", 5, 1015);
        AnchorIdentity = r8;
        TabLabelType r10 = new TabLabelType("POI", 6, 10001);
        POI = r10;
        a = new TabLabelType[]{r0, r1, r3, r4, r6, r8, r10};
    }

    public static TabLabelType[] values() {
        return (TabLabelType[]) a.clone();
    }

    public static TabLabelType valueOf(String r1) {
        return (TabLabelType) a.a(TabLabelType.class, r1);
    }

    public TabLabelType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
