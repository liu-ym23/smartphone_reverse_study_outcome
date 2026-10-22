package com.obric.oui.infopanel.action;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/obric/oui/infopanel/action/OInfoPanelSingleBtnActionView$Style", "", "Lcom/obric/oui/infopanel/action/OInfoPanelSingleBtnActionView$Style;", "PRIMARY", "SECONDARY", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OInfoPanelSingleBtnActionView$Style extends Enum<OInfoPanelSingleBtnActionView$Style> {
    public static final OInfoPanelSingleBtnActionView$Style PRIMARY = null;
    public static final OInfoPanelSingleBtnActionView$Style SECONDARY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OInfoPanelSingleBtnActionView$Style[] f13521a = null;

    static {
        OInfoPanelSingleBtnActionView$Style r5 = new OInfoPanelSingleBtnActionView$Style("PRIMARY", 0);
        PRIMARY = r5;
        OInfoPanelSingleBtnActionView$Style r10 = new OInfoPanelSingleBtnActionView$Style("SECONDARY", 1);
        SECONDARY = r10;
        f13521a = new OInfoPanelSingleBtnActionView$Style[]{r5, r10};
    }

    public static OInfoPanelSingleBtnActionView$Style valueOf(String r5) {
        return (OInfoPanelSingleBtnActionView$Style) Enum.valueOf(OInfoPanelSingleBtnActionView$Style.class, r5);
    }

    public static OInfoPanelSingleBtnActionView$Style[] values() {
        return (OInfoPanelSingleBtnActionView$Style[]) f13521a.clone();
    }
}
