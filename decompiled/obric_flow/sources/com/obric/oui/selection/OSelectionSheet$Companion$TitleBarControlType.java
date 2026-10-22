package com.obric.oui.selection;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/obric/oui/selection/OSelectionSheet$Companion$TitleBarControlType", "", "Lcom/obric/oui/selection/OSelectionSheet$Companion$TitleBarControlType;", "CLOSE_ONLY", "CLOSE_AND_CONFIRM", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OSelectionSheet$Companion$TitleBarControlType extends Enum<OSelectionSheet$Companion$TitleBarControlType> {
    public static final OSelectionSheet$Companion$TitleBarControlType CLOSE_AND_CONFIRM = null;
    public static final OSelectionSheet$Companion$TitleBarControlType CLOSE_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OSelectionSheet$Companion$TitleBarControlType[] f14397a = null;

    static {
        OSelectionSheet$Companion$TitleBarControlType r5 = new OSelectionSheet$Companion$TitleBarControlType("CLOSE_ONLY", 0);
        CLOSE_ONLY = r5;
        OSelectionSheet$Companion$TitleBarControlType r10 = new OSelectionSheet$Companion$TitleBarControlType("CLOSE_AND_CONFIRM", 1);
        CLOSE_AND_CONFIRM = r10;
        f14397a = new OSelectionSheet$Companion$TitleBarControlType[]{r5, r10};
    }

    public static OSelectionSheet$Companion$TitleBarControlType valueOf(String r5) {
        return (OSelectionSheet$Companion$TitleBarControlType) Enum.valueOf(OSelectionSheet$Companion$TitleBarControlType.class, r5);
    }

    public static OSelectionSheet$Companion$TitleBarControlType[] values() {
        return (OSelectionSheet$Companion$TitleBarControlType[]) f14397a.clone();
    }
}
