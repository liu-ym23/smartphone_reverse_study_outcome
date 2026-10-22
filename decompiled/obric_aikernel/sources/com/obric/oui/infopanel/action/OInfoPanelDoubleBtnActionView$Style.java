package com.obric.oui.infopanel.action;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/infopanel/action/OInfoPanelDoubleBtnActionView$Style;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMARY_SECONDARY", "ONLY_SECONDARY", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum OInfoPanelDoubleBtnActionView$Style extends Enum<OInfoPanelDoubleBtnActionView$Style> {
    private static final /* synthetic */ OInfoPanelDoubleBtnActionView$Style[] $VALUES = null;
    public static final OInfoPanelDoubleBtnActionView$Style ONLY_SECONDARY = null;
    public static final OInfoPanelDoubleBtnActionView$Style PRIMARY_SECONDARY = null;

    static {
        OInfoPanelDoubleBtnActionView$Style r10 = new OInfoPanelDoubleBtnActionView$Style("PRIMARY_SECONDARY", 0);
        PRIMARY_SECONDARY = r10;
        OInfoPanelDoubleBtnActionView$Style r11 = new OInfoPanelDoubleBtnActionView$Style("ONLY_SECONDARY", 1);
        ONLY_SECONDARY = r11;
        $VALUES = new OInfoPanelDoubleBtnActionView$Style[]{r10, r11};
    }

    private OInfoPanelDoubleBtnActionView$Style(String r10, int r11) {
        super(r10, r11);
    }

    public static OInfoPanelDoubleBtnActionView$Style valueOf(String r10) {
        return (OInfoPanelDoubleBtnActionView$Style) Enum.valueOf(OInfoPanelDoubleBtnActionView$Style.class, r10);
    }

    public static OInfoPanelDoubleBtnActionView$Style[] values() {
        return (OInfoPanelDoubleBtnActionView$Style[]) $VALUES.clone();
    }
}
