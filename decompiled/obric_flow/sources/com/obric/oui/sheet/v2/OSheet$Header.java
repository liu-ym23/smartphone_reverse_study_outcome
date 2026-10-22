package com.obric.oui.sheet.v2;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"com/obric/oui/sheet/v2/OSheet$Header", "", "Lcom/obric/oui/sheet/v2/OSheet$Header;", "CUSTOM", "PAGE", "ACTION", "MODAL", "ONLY_TITLE", "PAGE_WITH_CLOSE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OSheet$Header extends Enum<OSheet$Header> {
    public static final OSheet$Header ACTION = null;
    public static final OSheet$Header CUSTOM = null;
    public static final OSheet$Header MODAL = null;
    public static final OSheet$Header ONLY_TITLE = null;
    public static final OSheet$Header PAGE = null;
    public static final OSheet$Header PAGE_WITH_CLOSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OSheet$Header[] f14433a = null;

    static {
        OSheet$Header r5 = new OSheet$Header("CUSTOM", 0);
        CUSTOM = r5;
        OSheet$Header r10 = new OSheet$Header("PAGE", 1);
        PAGE = r10;
        OSheet$Header r11 = new OSheet$Header("ACTION", 2);
        ACTION = r11;
        OSheet$Header r12 = new OSheet$Header("MODAL", 3);
        MODAL = r12;
        OSheet$Header r13 = new OSheet$Header("ONLY_TITLE", 4);
        ONLY_TITLE = r13;
        OSheet$Header r14 = new OSheet$Header("PAGE_WITH_CLOSE", 5);
        PAGE_WITH_CLOSE = r14;
        f14433a = new OSheet$Header[]{r5, r10, r11, r12, r13, r14};
    }

    public static OSheet$Header valueOf(String r5) {
        return (OSheet$Header) Enum.valueOf(OSheet$Header.class, r5);
    }

    public static OSheet$Header[] values() {
        return (OSheet$Header[]) f14433a.clone();
    }
}
