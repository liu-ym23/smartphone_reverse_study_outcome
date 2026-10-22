package com.obric.oui.sheet.v2;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/obric/oui/sheet/v2/OSheet$HeightMode", "", "Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "FULL_HEIGHT", "WRAP_HEIGHT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OSheet$HeightMode extends Enum<OSheet$HeightMode> {
    public static final OSheet$HeightMode FULL_HEIGHT = null;
    public static final OSheet$HeightMode WRAP_HEIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OSheet$HeightMode[] f14434a = null;

    static {
        OSheet$HeightMode r5 = new OSheet$HeightMode("FULL_HEIGHT", 0);
        FULL_HEIGHT = r5;
        OSheet$HeightMode r10 = new OSheet$HeightMode("WRAP_HEIGHT", 1);
        WRAP_HEIGHT = r10;
        f14434a = new OSheet$HeightMode[]{r5, r10};
    }

    public static OSheet$HeightMode valueOf(String r5) {
        return (OSheet$HeightMode) Enum.valueOf(OSheet$HeightMode.class, r5);
    }

    public static OSheet$HeightMode[] values() {
        return (OSheet$HeightMode[]) f14434a.clone();
    }
}
