package com.obric.oui.selection;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/obric/oui/selection/OSelectionSheet$Companion$SelectionType", "", "Lcom/obric/oui/selection/OSelectionSheet$Companion$SelectionType;", "SINGLE", "MULTI", "NONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OSelectionSheet$Companion$SelectionType extends Enum<OSelectionSheet$Companion$SelectionType> {
    public static final OSelectionSheet$Companion$SelectionType MULTI = null;
    public static final OSelectionSheet$Companion$SelectionType NONE = null;
    public static final OSelectionSheet$Companion$SelectionType SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OSelectionSheet$Companion$SelectionType[] f14396a = null;

    static {
        OSelectionSheet$Companion$SelectionType r5 = new OSelectionSheet$Companion$SelectionType("SINGLE", 0);
        SINGLE = r5;
        OSelectionSheet$Companion$SelectionType r10 = new OSelectionSheet$Companion$SelectionType("MULTI", 1);
        MULTI = r10;
        OSelectionSheet$Companion$SelectionType r11 = new OSelectionSheet$Companion$SelectionType("NONE", 2);
        NONE = r11;
        f14396a = new OSelectionSheet$Companion$SelectionType[]{r5, r10, r11};
    }

    public static OSelectionSheet$Companion$SelectionType valueOf(String r5) {
        return (OSelectionSheet$Companion$SelectionType) Enum.valueOf(OSelectionSheet$Companion$SelectionType.class, r5);
    }

    public static OSelectionSheet$Companion$SelectionType[] values() {
        return (OSelectionSheet$Companion$SelectionType[]) f14396a.clone();
    }
}
