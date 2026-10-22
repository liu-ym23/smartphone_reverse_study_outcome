package com.obric.oui.selection;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheet$Companion$TitleBarControlType;", "", "<init>", "(Ljava/lang/String;I)V", "CLOSE_ONLY", "CLOSE_AND_CONFIRM", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum OSelectionSheet$Companion$TitleBarControlType extends Enum<OSelectionSheet$Companion$TitleBarControlType> {
    private static final /* synthetic */ OSelectionSheet$Companion$TitleBarControlType[] $VALUES = null;
    public static final OSelectionSheet$Companion$TitleBarControlType CLOSE_AND_CONFIRM = null;
    public static final OSelectionSheet$Companion$TitleBarControlType CLOSE_ONLY = null;

    static {
        OSelectionSheet$Companion$TitleBarControlType r10 = new OSelectionSheet$Companion$TitleBarControlType("CLOSE_ONLY", 0);
        CLOSE_ONLY = r10;
        OSelectionSheet$Companion$TitleBarControlType r11 = new OSelectionSheet$Companion$TitleBarControlType("CLOSE_AND_CONFIRM", 1);
        CLOSE_AND_CONFIRM = r11;
        $VALUES = new OSelectionSheet$Companion$TitleBarControlType[]{r10, r11};
    }

    private OSelectionSheet$Companion$TitleBarControlType(String r10, int r11) {
        super(r10, r11);
    }

    public static OSelectionSheet$Companion$TitleBarControlType valueOf(String r10) {
        return (OSelectionSheet$Companion$TitleBarControlType) Enum.valueOf(OSelectionSheet$Companion$TitleBarControlType.class, r10);
    }

    public static OSelectionSheet$Companion$TitleBarControlType[] values() {
        return (OSelectionSheet$Companion$TitleBarControlType[]) $VALUES.clone();
    }
}
