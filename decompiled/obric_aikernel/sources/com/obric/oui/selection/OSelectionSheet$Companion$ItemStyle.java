package com.obric.oui.selection;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheet$Companion$ItemStyle;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT_ONLY", "ICON_AND_TEXT", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum OSelectionSheet$Companion$ItemStyle extends Enum<OSelectionSheet$Companion$ItemStyle> {
    private static final /* synthetic */ OSelectionSheet$Companion$ItemStyle[] $VALUES = null;
    public static final OSelectionSheet$Companion$ItemStyle ICON_AND_TEXT = null;
    public static final OSelectionSheet$Companion$ItemStyle TEXT_ONLY = null;

    static {
        OSelectionSheet$Companion$ItemStyle r10 = new OSelectionSheet$Companion$ItemStyle("TEXT_ONLY", 0);
        TEXT_ONLY = r10;
        OSelectionSheet$Companion$ItemStyle r11 = new OSelectionSheet$Companion$ItemStyle("ICON_AND_TEXT", 1);
        ICON_AND_TEXT = r11;
        $VALUES = new OSelectionSheet$Companion$ItemStyle[]{r10, r11};
    }

    private OSelectionSheet$Companion$ItemStyle(String r10, int r11) {
        super(r10, r11);
    }

    public static OSelectionSheet$Companion$ItemStyle valueOf(String r10) {
        return (OSelectionSheet$Companion$ItemStyle) Enum.valueOf(OSelectionSheet$Companion$ItemStyle.class, r10);
    }

    public static OSelectionSheet$Companion$ItemStyle[] values() {
        return (OSelectionSheet$Companion$ItemStyle[]) $VALUES.clone();
    }
}
