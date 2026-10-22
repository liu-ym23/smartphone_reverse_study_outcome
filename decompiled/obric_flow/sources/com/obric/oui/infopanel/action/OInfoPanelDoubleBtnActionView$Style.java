package com.obric.oui.infopanel.action;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/obric/oui/infopanel/action/OInfoPanelDoubleBtnActionView$Style", "", "Lcom/obric/oui/infopanel/action/OInfoPanelDoubleBtnActionView$Style;", "PRIMARY_SECONDARY", "ONLY_SECONDARY", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OInfoPanelDoubleBtnActionView$Style extends Enum<OInfoPanelDoubleBtnActionView$Style> {
    public static final OInfoPanelDoubleBtnActionView$Style ONLY_SECONDARY = null;
    public static final OInfoPanelDoubleBtnActionView$Style PRIMARY_SECONDARY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OInfoPanelDoubleBtnActionView$Style[] f13520a = null;

    static {
        OInfoPanelDoubleBtnActionView$Style r5 = new OInfoPanelDoubleBtnActionView$Style("PRIMARY_SECONDARY", 0);
        PRIMARY_SECONDARY = r5;
        OInfoPanelDoubleBtnActionView$Style r10 = new OInfoPanelDoubleBtnActionView$Style("ONLY_SECONDARY", 1);
        ONLY_SECONDARY = r10;
        f13520a = new OInfoPanelDoubleBtnActionView$Style[]{r5, r10};
    }

    public static OInfoPanelDoubleBtnActionView$Style valueOf(String r5) {
        return (OInfoPanelDoubleBtnActionView$Style) Enum.valueOf(OInfoPanelDoubleBtnActionView$Style.class, r5);
    }

    public static OInfoPanelDoubleBtnActionView$Style[] values() {
        return (OInfoPanelDoubleBtnActionView$Style[]) f13520a.clone();
    }
}
