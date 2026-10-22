package com.obric.oui.sheet;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/obric/oui/sheet/OInsetSheet$PanelWidth", "", "Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;", "NARROW_WIDTH", "BOARD_WIDTH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OInsetSheet$PanelWidth extends Enum<OInsetSheet$PanelWidth> {
    public static final OInsetSheet$PanelWidth BOARD_WIDTH = null;
    public static final OInsetSheet$PanelWidth NARROW_WIDTH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OInsetSheet$PanelWidth[] f14409a = null;

    static {
        OInsetSheet$PanelWidth r5 = new OInsetSheet$PanelWidth("NARROW_WIDTH", 0);
        NARROW_WIDTH = r5;
        OInsetSheet$PanelWidth r10 = new OInsetSheet$PanelWidth("BOARD_WIDTH", 1);
        BOARD_WIDTH = r10;
        f14409a = new OInsetSheet$PanelWidth[]{r5, r10};
    }

    public static OInsetSheet$PanelWidth valueOf(String r5) {
        return (OInsetSheet$PanelWidth) Enum.valueOf(OInsetSheet$PanelWidth.class, r5);
    }

    public static OInsetSheet$PanelWidth[] values() {
        return (OInsetSheet$PanelWidth[]) f14409a.clone();
    }
}
