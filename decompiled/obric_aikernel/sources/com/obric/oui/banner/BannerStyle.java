package com.obric.oui.banner;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/oui/banner/BannerStyle;", "", "", "style", "I", "getStyle", "()I", "<init>", "(Ljava/lang/String;II)V", "FILL", "INDENT", "TRIPTYCH", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum BannerStyle extends Enum<BannerStyle> {
    private static final /* synthetic */ BannerStyle[] $VALUES = null;
    public static final BannerStyle FILL = null;
    public static final BannerStyle INDENT = null;
    public static final BannerStyle TRIPTYCH = null;
    private final int style;

    static {
        BannerStyle r10 = new BannerStyle("FILL", 0, 0);
        FILL = r10;
        BannerStyle r11 = new BannerStyle("INDENT", 1, 1);
        INDENT = r11;
        BannerStyle r12 = new BannerStyle("TRIPTYCH", 2, 2);
        TRIPTYCH = r12;
        $VALUES = new BannerStyle[]{r10, r11, r12};
    }

    private BannerStyle(String r10, int r11, int r12) {
        super(r10, r11);
        this.style = r12;
    }

    public static BannerStyle valueOf(String r10) {
        return (BannerStyle) Enum.valueOf(BannerStyle.class, r10);
    }

    public static BannerStyle[] values() {
        return (BannerStyle[]) $VALUES.clone();
    }

    public final int getStyle() {
        return this.style;
    }
}
