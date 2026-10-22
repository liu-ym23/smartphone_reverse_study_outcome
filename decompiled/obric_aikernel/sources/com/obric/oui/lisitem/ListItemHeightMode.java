package com.obric.oui.lisitem;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/lisitem/ListItemHeightMode;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "COMPACT", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum ListItemHeightMode extends Enum<ListItemHeightMode> {
    private static final /* synthetic */ ListItemHeightMode[] $VALUES = null;
    public static final ListItemHeightMode COMPACT = null;
    public static final ListItemHeightMode DEFAULT = null;

    static {
        ListItemHeightMode r10 = new ListItemHeightMode("DEFAULT", 0);
        DEFAULT = r10;
        ListItemHeightMode r11 = new ListItemHeightMode("COMPACT", 1);
        COMPACT = r11;
        $VALUES = new ListItemHeightMode[]{r10, r11};
    }

    private ListItemHeightMode(String r10, int r11) {
        super(r10, r11);
    }

    public static ListItemHeightMode valueOf(String r10) {
        return (ListItemHeightMode) Enum.valueOf(ListItemHeightMode.class, r10);
    }

    public static ListItemHeightMode[] values() {
        return (ListItemHeightMode[]) $VALUES.clone();
    }
}
