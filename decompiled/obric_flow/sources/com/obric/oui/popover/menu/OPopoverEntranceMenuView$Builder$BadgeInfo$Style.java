package com.obric.oui.popover.menu;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo$Style", "", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo$Style;", "DOT", "NUMBER", "ELLIPSIS", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OPopoverEntranceMenuView$Builder$BadgeInfo$Style extends Enum<OPopoverEntranceMenuView$Builder$BadgeInfo$Style> {
    public static final OPopoverEntranceMenuView$Builder$BadgeInfo$Style DOT = null;
    public static final OPopoverEntranceMenuView$Builder$BadgeInfo$Style ELLIPSIS = null;
    public static final OPopoverEntranceMenuView$Builder$BadgeInfo$Style NUMBER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OPopoverEntranceMenuView$Builder$BadgeInfo$Style[] f14136a = null;

    static {
        OPopoverEntranceMenuView$Builder$BadgeInfo$Style r5 = new OPopoverEntranceMenuView$Builder$BadgeInfo$Style("DOT", 0);
        DOT = r5;
        OPopoverEntranceMenuView$Builder$BadgeInfo$Style r10 = new OPopoverEntranceMenuView$Builder$BadgeInfo$Style("NUMBER", 1);
        NUMBER = r10;
        OPopoverEntranceMenuView$Builder$BadgeInfo$Style r11 = new OPopoverEntranceMenuView$Builder$BadgeInfo$Style("ELLIPSIS", 2);
        ELLIPSIS = r11;
        f14136a = new OPopoverEntranceMenuView$Builder$BadgeInfo$Style[]{r5, r10, r11};
    }

    public static OPopoverEntranceMenuView$Builder$BadgeInfo$Style valueOf(String r5) {
        return (OPopoverEntranceMenuView$Builder$BadgeInfo$Style) Enum.valueOf(OPopoverEntranceMenuView$Builder$BadgeInfo$Style.class, r5);
    }

    public static OPopoverEntranceMenuView$Builder$BadgeInfo$Style[] values() {
        return (OPopoverEntranceMenuView$Builder$BadgeInfo$Style[]) f14136a.clone();
    }
}
