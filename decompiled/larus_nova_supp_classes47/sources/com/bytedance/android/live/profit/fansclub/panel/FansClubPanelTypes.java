package com.bytedance.android.live.profit.fansclub.panel;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/panel/FansClubPanelTypes;", "", "Native", "Web", "Lynx", "Redirect", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FansClubPanelTypes extends Enum<FansClubPanelTypes> {
    public static final FansClubPanelTypes Lynx = null;
    public static final FansClubPanelTypes Native = null;
    public static final FansClubPanelTypes Redirect = null;
    public static final FansClubPanelTypes Web = null;
    public static final /* synthetic */ FansClubPanelTypes[] a = null;

    static {
        FansClubPanelTypes r1 = new FansClubPanelTypes("Native", 0);
        Native = r1;
        FansClubPanelTypes r2 = new FansClubPanelTypes("Web", 1);
        Web = r2;
        FansClubPanelTypes r3 = new FansClubPanelTypes("Lynx", 2);
        Lynx = r3;
        FansClubPanelTypes r4 = new FansClubPanelTypes("Redirect", 3);
        Redirect = r4;
        a = new FansClubPanelTypes[]{r1, r2, r3, r4};
    }

    public static FansClubPanelTypes valueOf(String r1) {
        return (FansClubPanelTypes) r27.a.a(FansClubPanelTypes.class, r1);
    }

    public static FansClubPanelTypes[] values() {
        return (FansClubPanelTypes[]) a.clone();
    }

    public FansClubPanelTypes(String r1, int r2) {
        super(r1, r2);
    }
}
