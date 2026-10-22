package com.obric.oui.coachmark;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/obric/oui/coachmark/OCoachmark$Type", "", "Lcom/obric/oui/coachmark/OCoachmark$Type;", "PILL", "CARD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OCoachmark$Type extends Enum<OCoachmark$Type> {
    public static final OCoachmark$Type CARD = null;
    public static final OCoachmark$Type PILL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OCoachmark$Type[] f12349a = null;

    static {
        OCoachmark$Type r5 = new OCoachmark$Type("PILL", 0);
        PILL = r5;
        OCoachmark$Type r10 = new OCoachmark$Type("CARD", 1);
        CARD = r10;
        f12349a = new OCoachmark$Type[]{r5, r10};
    }

    public static OCoachmark$Type valueOf(String r5) {
        return (OCoachmark$Type) Enum.valueOf(OCoachmark$Type.class, r5);
    }

    public static OCoachmark$Type[] values() {
        return (OCoachmark$Type[]) f12349a.clone();
    }
}
