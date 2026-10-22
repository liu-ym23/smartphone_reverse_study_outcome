package com.obric.oui.selection;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/obric/oui/selection/OActionSheet$Companion$ItemStyle", "", "Lcom/obric/oui/selection/OActionSheet$Companion$ItemStyle;", "LIST_BUTTON", "LIST_TEXT_ONLY", "LIST_ICON_AND_TEXT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OActionSheet$Companion$ItemStyle extends Enum<OActionSheet$Companion$ItemStyle> {
    public static final OActionSheet$Companion$ItemStyle LIST_BUTTON = null;
    public static final OActionSheet$Companion$ItemStyle LIST_ICON_AND_TEXT = null;
    public static final OActionSheet$Companion$ItemStyle LIST_TEXT_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OActionSheet$Companion$ItemStyle[] f14380a = null;

    static {
        OActionSheet$Companion$ItemStyle r5 = new OActionSheet$Companion$ItemStyle("LIST_BUTTON", 0);
        LIST_BUTTON = r5;
        OActionSheet$Companion$ItemStyle r10 = new OActionSheet$Companion$ItemStyle("LIST_TEXT_ONLY", 1);
        LIST_TEXT_ONLY = r10;
        OActionSheet$Companion$ItemStyle r11 = new OActionSheet$Companion$ItemStyle("LIST_ICON_AND_TEXT", 2);
        LIST_ICON_AND_TEXT = r11;
        f14380a = new OActionSheet$Companion$ItemStyle[]{r5, r10, r11};
    }

    public static OActionSheet$Companion$ItemStyle valueOf(String r5) {
        return (OActionSheet$Companion$ItemStyle) Enum.valueOf(OActionSheet$Companion$ItemStyle.class, r5);
    }

    public static OActionSheet$Companion$ItemStyle[] values() {
        return (OActionSheet$Companion$ItemStyle[]) f14380a.clone();
    }
}
