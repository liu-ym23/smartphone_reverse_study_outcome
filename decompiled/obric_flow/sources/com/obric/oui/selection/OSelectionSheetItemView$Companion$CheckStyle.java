package com.obric.oui.selection;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/obric/oui/selection/OSelectionSheetItemView$Companion$CheckStyle", "", "Lcom/obric/oui/selection/OSelectionSheetItemView$Companion$CheckStyle;", "NONE", "ICON", "CHECKBOX", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OSelectionSheetItemView$Companion$CheckStyle extends Enum<OSelectionSheetItemView$Companion$CheckStyle> {
    public static final OSelectionSheetItemView$Companion$CheckStyle CHECKBOX = null;
    public static final OSelectionSheetItemView$Companion$CheckStyle ICON = null;
    public static final OSelectionSheetItemView$Companion$CheckStyle NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OSelectionSheetItemView$Companion$CheckStyle[] f14398a = null;

    static {
        OSelectionSheetItemView$Companion$CheckStyle r5 = new OSelectionSheetItemView$Companion$CheckStyle("NONE", 0);
        NONE = r5;
        OSelectionSheetItemView$Companion$CheckStyle r10 = new OSelectionSheetItemView$Companion$CheckStyle("ICON", 1);
        ICON = r10;
        OSelectionSheetItemView$Companion$CheckStyle r11 = new OSelectionSheetItemView$Companion$CheckStyle("CHECKBOX", 2);
        CHECKBOX = r11;
        f14398a = new OSelectionSheetItemView$Companion$CheckStyle[]{r5, r10, r11};
    }

    public static OSelectionSheetItemView$Companion$CheckStyle valueOf(String r5) {
        return (OSelectionSheetItemView$Companion$CheckStyle) Enum.valueOf(OSelectionSheetItemView$Companion$CheckStyle.class, r5);
    }

    public static OSelectionSheetItemView$Companion$CheckStyle[] values() {
        return (OSelectionSheetItemView$Companion$CheckStyle[]) f14398a.clone();
    }
}
