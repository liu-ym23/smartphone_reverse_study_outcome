package com.obric.oui.popover.menu;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo$Style;", "", "<init>", "(Ljava/lang/String;I)V", "DOT", "NUMBER", "ELLIPSIS", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum OPopoverEntranceMenuView$Builder$BadgeInfo$Style extends Enum<OPopoverEntranceMenuView$Builder$BadgeInfo$Style> {
    private static final /* synthetic */ OPopoverEntranceMenuView$Builder$BadgeInfo$Style[] $VALUES = null;
    public static final OPopoverEntranceMenuView$Builder$BadgeInfo$Style DOT = null;
    public static final OPopoverEntranceMenuView$Builder$BadgeInfo$Style ELLIPSIS = null;
    public static final OPopoverEntranceMenuView$Builder$BadgeInfo$Style NUMBER = null;

    static {
        OPopoverEntranceMenuView$Builder$BadgeInfo$Style r10 = new OPopoverEntranceMenuView$Builder$BadgeInfo$Style("DOT", 0);
        DOT = r10;
        OPopoverEntranceMenuView$Builder$BadgeInfo$Style r11 = new OPopoverEntranceMenuView$Builder$BadgeInfo$Style("NUMBER", 1);
        NUMBER = r11;
        OPopoverEntranceMenuView$Builder$BadgeInfo$Style r12 = new OPopoverEntranceMenuView$Builder$BadgeInfo$Style("ELLIPSIS", 2);
        ELLIPSIS = r12;
        $VALUES = new OPopoverEntranceMenuView$Builder$BadgeInfo$Style[]{r10, r11, r12};
    }

    private OPopoverEntranceMenuView$Builder$BadgeInfo$Style(String r10, int r11) {
        super(r10, r11);
    }

    public static OPopoverEntranceMenuView$Builder$BadgeInfo$Style valueOf(String r10) {
        return (OPopoverEntranceMenuView$Builder$BadgeInfo$Style) Enum.valueOf(OPopoverEntranceMenuView$Builder$BadgeInfo$Style.class, r10);
    }

    public static OPopoverEntranceMenuView$Builder$BadgeInfo$Style[] values() {
        return (OPopoverEntranceMenuView$Builder$BadgeInfo$Style[]) $VALUES.clone();
    }
}
