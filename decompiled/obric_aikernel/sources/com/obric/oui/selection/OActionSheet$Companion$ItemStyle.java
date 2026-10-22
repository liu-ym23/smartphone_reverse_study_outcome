package com.obric.oui.selection;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/selection/OActionSheet$Companion$ItemStyle;", "", "<init>", "(Ljava/lang/String;I)V", "LIST_BUTTON", "LIST_TEXT_ONLY", "LIST_ICON_AND_TEXT", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum OActionSheet$Companion$ItemStyle extends Enum<OActionSheet$Companion$ItemStyle> {
    private static final /* synthetic */ OActionSheet$Companion$ItemStyle[] $VALUES = null;
    public static final OActionSheet$Companion$ItemStyle LIST_BUTTON = null;
    public static final OActionSheet$Companion$ItemStyle LIST_ICON_AND_TEXT = null;
    public static final OActionSheet$Companion$ItemStyle LIST_TEXT_ONLY = null;

    static {
        OActionSheet$Companion$ItemStyle r10 = new OActionSheet$Companion$ItemStyle("LIST_BUTTON", 0);
        LIST_BUTTON = r10;
        OActionSheet$Companion$ItemStyle r11 = new OActionSheet$Companion$ItemStyle("LIST_TEXT_ONLY", 1);
        LIST_TEXT_ONLY = r11;
        OActionSheet$Companion$ItemStyle r12 = new OActionSheet$Companion$ItemStyle("LIST_ICON_AND_TEXT", 2);
        LIST_ICON_AND_TEXT = r12;
        $VALUES = new OActionSheet$Companion$ItemStyle[]{r10, r11, r12};
    }

    private OActionSheet$Companion$ItemStyle(String r10, int r11) {
        super(r10, r11);
    }

    public static OActionSheet$Companion$ItemStyle valueOf(String r10) {
        return (OActionSheet$Companion$ItemStyle) Enum.valueOf(OActionSheet$Companion$ItemStyle.class, r10);
    }

    public static OActionSheet$Companion$ItemStyle[] values() {
        return (OActionSheet$Companion$ItemStyle[]) $VALUES.clone();
    }
}
