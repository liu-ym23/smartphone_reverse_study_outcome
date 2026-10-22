package com.obric.oui.panel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/obric/oui/panel/OBasicPanel$PadCompatConfig$CloseIconStyle", "", "Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig$CloseIconStyle;", "BLACK_NO_BG", "WHITE_WITH_BG", "BLACK_WITH_BG", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OBasicPanel$PadCompatConfig$CloseIconStyle extends Enum<OBasicPanel$PadCompatConfig$CloseIconStyle> {
    public static final OBasicPanel$PadCompatConfig$CloseIconStyle BLACK_NO_BG = null;
    public static final OBasicPanel$PadCompatConfig$CloseIconStyle BLACK_WITH_BG = null;
    public static final OBasicPanel$PadCompatConfig$CloseIconStyle WHITE_WITH_BG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OBasicPanel$PadCompatConfig$CloseIconStyle[] f13989a = null;

    static {
        OBasicPanel$PadCompatConfig$CloseIconStyle r5 = new OBasicPanel$PadCompatConfig$CloseIconStyle("BLACK_NO_BG", 0);
        BLACK_NO_BG = r5;
        OBasicPanel$PadCompatConfig$CloseIconStyle r10 = new OBasicPanel$PadCompatConfig$CloseIconStyle("WHITE_WITH_BG", 1);
        WHITE_WITH_BG = r10;
        OBasicPanel$PadCompatConfig$CloseIconStyle r11 = new OBasicPanel$PadCompatConfig$CloseIconStyle("BLACK_WITH_BG", 2);
        BLACK_WITH_BG = r11;
        f13989a = new OBasicPanel$PadCompatConfig$CloseIconStyle[]{r5, r10, r11};
    }

    public static OBasicPanel$PadCompatConfig$CloseIconStyle valueOf(String r5) {
        return (OBasicPanel$PadCompatConfig$CloseIconStyle) Enum.valueOf(OBasicPanel$PadCompatConfig$CloseIconStyle.class, r5);
    }

    public static OBasicPanel$PadCompatConfig$CloseIconStyle[] values() {
        return (OBasicPanel$PadCompatConfig$CloseIconStyle[]) f13989a.clone();
    }
}
