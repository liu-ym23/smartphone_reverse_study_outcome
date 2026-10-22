package com.obric.oui.banner;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/banner/BannerStyle;", "", "", "style", "I", "getStyle", "()I", "FILL", "INDENT", "TRIPTYCH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final enum BannerStyle extends Enum<BannerStyle> {
    public static final BannerStyle FILL = null;
    public static final BannerStyle INDENT = null;
    public static final BannerStyle TRIPTYCH = null;
    public static final /* synthetic */ BannerStyle[] a = null;
    private final int style;

    public static BannerStyle valueOf(String r1) {
        return (BannerStyle) r27.a.a(BannerStyle.class, r1);
    }

    public static BannerStyle[] values() {
        return (BannerStyle[]) a.clone();
    }

    static {
        BannerStyle r0 = new BannerStyle("FILL", 0, 0);
        FILL = r0;
        BannerStyle r1 = new BannerStyle("INDENT", 1, 1);
        INDENT = r1;
        BannerStyle r3 = new BannerStyle("TRIPTYCH", 2, 2);
        TRIPTYCH = r3;
        a = new BannerStyle[]{r0, r1, r3};
    }

    public final int getStyle() {
        return this.style;
    }

    public BannerStyle(String r1, int r2, int r3) {
        super(r1, r2);
        this.style = r3;
    }
}
