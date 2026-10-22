package com.obric.oui.toast;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/toast/OPopupNotice$HideReason;", "", "<init>", "(Ljava/lang/String;I)V", "HIDE_AUTO", "HIDE_MANUAL", "HIDE_CONFLICT", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum OPopupNotice$HideReason extends Enum<OPopupNotice$HideReason> {
    private static final /* synthetic */ OPopupNotice$HideReason[] $VALUES = null;
    public static final OPopupNotice$HideReason HIDE_AUTO = null;
    public static final OPopupNotice$HideReason HIDE_CONFLICT = null;
    public static final OPopupNotice$HideReason HIDE_MANUAL = null;

    static {
        OPopupNotice$HideReason r10 = new OPopupNotice$HideReason("HIDE_AUTO", 0);
        HIDE_AUTO = r10;
        OPopupNotice$HideReason r11 = new OPopupNotice$HideReason("HIDE_MANUAL", 1);
        HIDE_MANUAL = r11;
        OPopupNotice$HideReason r12 = new OPopupNotice$HideReason("HIDE_CONFLICT", 2);
        HIDE_CONFLICT = r12;
        $VALUES = new OPopupNotice$HideReason[]{r10, r11, r12};
    }

    private OPopupNotice$HideReason(String r10, int r11) {
        super(r10, r11);
    }

    public static OPopupNotice$HideReason valueOf(String r10) {
        return (OPopupNotice$HideReason) Enum.valueOf(OPopupNotice$HideReason.class, r10);
    }

    public static OPopupNotice$HideReason[] values() {
        return (OPopupNotice$HideReason[]) $VALUES.clone();
    }
}
