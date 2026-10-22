package com.obric.oui.toast;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/obric/oui/toast/OPopupNotice$HideReason", "", "Lcom/obric/oui/toast/OPopupNotice$HideReason;", "HIDE_AUTO", "HIDE_MANUAL", "HIDE_CONFLICT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OPopupNotice$HideReason extends Enum<OPopupNotice$HideReason> {
    public static final OPopupNotice$HideReason HIDE_AUTO = null;
    public static final OPopupNotice$HideReason HIDE_CONFLICT = null;
    public static final OPopupNotice$HideReason HIDE_MANUAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OPopupNotice$HideReason[] f14877a = null;

    static {
        OPopupNotice$HideReason r5 = new OPopupNotice$HideReason("HIDE_AUTO", 0);
        HIDE_AUTO = r5;
        OPopupNotice$HideReason r10 = new OPopupNotice$HideReason("HIDE_MANUAL", 1);
        HIDE_MANUAL = r10;
        OPopupNotice$HideReason r11 = new OPopupNotice$HideReason("HIDE_CONFLICT", 2);
        HIDE_CONFLICT = r11;
        f14877a = new OPopupNotice$HideReason[]{r5, r10, r11};
    }

    public static OPopupNotice$HideReason valueOf(String r5) {
        return (OPopupNotice$HideReason) Enum.valueOf(OPopupNotice$HideReason.class, r5);
    }

    public static OPopupNotice$HideReason[] values() {
        return (OPopupNotice$HideReason[]) f14877a.clone();
    }
}
