package com.obric.oui.selection;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/obric/oui/selection/OSelectionSheet$Companion$ItemStyle", "", "Lcom/obric/oui/selection/OSelectionSheet$Companion$ItemStyle;", "TEXT_ONLY", "ICON_AND_TEXT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OSelectionSheet$Companion$ItemStyle extends Enum<OSelectionSheet$Companion$ItemStyle> {
    public static final OSelectionSheet$Companion$ItemStyle ICON_AND_TEXT = null;
    public static final OSelectionSheet$Companion$ItemStyle TEXT_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OSelectionSheet$Companion$ItemStyle[] f14395a = null;

    static {
        OSelectionSheet$Companion$ItemStyle r5 = new OSelectionSheet$Companion$ItemStyle("TEXT_ONLY", 0);
        TEXT_ONLY = r5;
        OSelectionSheet$Companion$ItemStyle r10 = new OSelectionSheet$Companion$ItemStyle("ICON_AND_TEXT", 1);
        ICON_AND_TEXT = r10;
        f14395a = new OSelectionSheet$Companion$ItemStyle[]{r5, r10};
    }

    public static OSelectionSheet$Companion$ItemStyle valueOf(String r5) {
        return (OSelectionSheet$Companion$ItemStyle) Enum.valueOf(OSelectionSheet$Companion$ItemStyle.class, r5);
    }

    public static OSelectionSheet$Companion$ItemStyle[] values() {
        return (OSelectionSheet$Companion$ItemStyle[]) f14395a.clone();
    }
}
