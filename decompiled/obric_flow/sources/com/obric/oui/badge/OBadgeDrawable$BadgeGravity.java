package com.obric.oui.badge;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/obric/oui/badge/OBadgeDrawable$BadgeGravity", "", "Lcom/obric/oui/badge/OBadgeDrawable$BadgeGravity;", "TOP_START", "TOP_END", "CENTER", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OBadgeDrawable$BadgeGravity extends Enum<OBadgeDrawable$BadgeGravity> {
    public static final OBadgeDrawable$BadgeGravity CENTER = null;
    public static final OBadgeDrawable$BadgeGravity TOP_END = null;
    public static final OBadgeDrawable$BadgeGravity TOP_START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OBadgeDrawable$BadgeGravity[] f11974a = null;

    static {
        OBadgeDrawable$BadgeGravity r5 = new OBadgeDrawable$BadgeGravity("TOP_START", 0);
        TOP_START = r5;
        OBadgeDrawable$BadgeGravity r10 = new OBadgeDrawable$BadgeGravity("TOP_END", 1);
        TOP_END = r10;
        OBadgeDrawable$BadgeGravity r11 = new OBadgeDrawable$BadgeGravity("CENTER", 2);
        CENTER = r11;
        f11974a = new OBadgeDrawable$BadgeGravity[]{r5, r10, r11};
    }

    public static OBadgeDrawable$BadgeGravity valueOf(String r5) {
        return (OBadgeDrawable$BadgeGravity) Enum.valueOf(OBadgeDrawable$BadgeGravity.class, r5);
    }

    public static OBadgeDrawable$BadgeGravity[] values() {
        return (OBadgeDrawable$BadgeGravity[]) f11974a.clone();
    }
}
