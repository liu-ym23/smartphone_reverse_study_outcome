package com.obric.oui.banner;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/banner/BannerStyle;", "", "", "style", "I", "getStyle", "()I", "FILL", "INDENT", "TRIPTYCH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum BannerStyle extends Enum<BannerStyle> {
    public static final BannerStyle FILL = null;
    public static final BannerStyle INDENT = null;
    public static final BannerStyle TRIPTYCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BannerStyle[] f12002a = null;
    private final int style;

    static {
        BannerStyle r5 = new BannerStyle("FILL", 0, 0);
        FILL = r5;
        BannerStyle r10 = new BannerStyle("INDENT", 1, 1);
        INDENT = r10;
        BannerStyle r11 = new BannerStyle("TRIPTYCH", 2, 2);
        TRIPTYCH = r11;
        f12002a = new BannerStyle[]{r5, r10, r11};
    }

    public BannerStyle(String r5, int r10, int r11) {
        super(r5, r10);
        this.style = r11;
    }

    public static BannerStyle valueOf(String r5) {
        return (BannerStyle) Enum.valueOf(BannerStyle.class, r5);
    }

    public static BannerStyle[] values() {
        return (BannerStyle[]) f12002a.clone();
    }

    public final int getStyle() {
        return this.style;
    }
}
