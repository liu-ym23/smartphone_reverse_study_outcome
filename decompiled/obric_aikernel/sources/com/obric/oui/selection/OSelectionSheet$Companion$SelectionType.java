package com.obric.oui.selection;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheet$Companion$SelectionType;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE", "MULTI", "NONE", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum OSelectionSheet$Companion$SelectionType extends Enum<OSelectionSheet$Companion$SelectionType> {
    private static final /* synthetic */ OSelectionSheet$Companion$SelectionType[] $VALUES = null;
    public static final OSelectionSheet$Companion$SelectionType MULTI = null;
    public static final OSelectionSheet$Companion$SelectionType NONE = null;
    public static final OSelectionSheet$Companion$SelectionType SINGLE = null;

    static {
        OSelectionSheet$Companion$SelectionType r10 = new OSelectionSheet$Companion$SelectionType("SINGLE", 0);
        SINGLE = r10;
        OSelectionSheet$Companion$SelectionType r11 = new OSelectionSheet$Companion$SelectionType("MULTI", 1);
        MULTI = r11;
        OSelectionSheet$Companion$SelectionType r12 = new OSelectionSheet$Companion$SelectionType("NONE", 2);
        NONE = r12;
        $VALUES = new OSelectionSheet$Companion$SelectionType[]{r10, r11, r12};
    }

    private OSelectionSheet$Companion$SelectionType(String r10, int r11) {
        super(r10, r11);
    }

    public static OSelectionSheet$Companion$SelectionType valueOf(String r10) {
        return (OSelectionSheet$Companion$SelectionType) Enum.valueOf(OSelectionSheet$Companion$SelectionType.class, r10);
    }

    public static OSelectionSheet$Companion$SelectionType[] values() {
        return (OSelectionSheet$Companion$SelectionType[]) $VALUES.clone();
    }
}
