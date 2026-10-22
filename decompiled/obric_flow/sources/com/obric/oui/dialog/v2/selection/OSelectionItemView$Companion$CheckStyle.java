package com.obric.oui.dialog.v2.selection;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/obric/oui/dialog/v2/selection/OSelectionItemView$Companion$CheckStyle", "", "Lcom/obric/oui/dialog/v2/selection/OSelectionItemView$Companion$CheckStyle;", "NONE", "ICON", "CHECKBOX", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OSelectionItemView$Companion$CheckStyle extends Enum<OSelectionItemView$Companion$CheckStyle> {
    public static final OSelectionItemView$Companion$CheckStyle CHECKBOX = null;
    public static final OSelectionItemView$Companion$CheckStyle ICON = null;
    public static final OSelectionItemView$Companion$CheckStyle NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OSelectionItemView$Companion$CheckStyle[] f13180a = null;

    static {
        OSelectionItemView$Companion$CheckStyle r5 = new OSelectionItemView$Companion$CheckStyle("NONE", 0);
        NONE = r5;
        OSelectionItemView$Companion$CheckStyle r10 = new OSelectionItemView$Companion$CheckStyle("ICON", 1);
        ICON = r10;
        OSelectionItemView$Companion$CheckStyle r11 = new OSelectionItemView$Companion$CheckStyle("CHECKBOX", 2);
        CHECKBOX = r11;
        f13180a = new OSelectionItemView$Companion$CheckStyle[]{r5, r10, r11};
    }

    public static OSelectionItemView$Companion$CheckStyle valueOf(String r5) {
        return (OSelectionItemView$Companion$CheckStyle) Enum.valueOf(OSelectionItemView$Companion$CheckStyle.class, r5);
    }

    public static OSelectionItemView$Companion$CheckStyle[] values() {
        return (OSelectionItemView$Companion$CheckStyle[]) f13180a.clone();
    }
}
