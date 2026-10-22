package com.obric.oui.banner;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/banner/BannerStyle;", "", "style", "", "(Ljava/lang/String;II)V", "getStyle", "()I", "FILL", "INDENT", "TRIPTYCH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum BannerStyle extends Enum<BannerStyle> {
    private static final /* synthetic */ BannerStyle[] $VALUES = null;
    public static final BannerStyle FILL = null;
    public static final BannerStyle INDENT = null;
    public static final BannerStyle TRIPTYCH = null;
    private final int style;

    private static final /* synthetic */ BannerStyle[] $values() {
        return new BannerStyle[]{FILL, INDENT, TRIPTYCH};
    }

    static {
        FILL = new BannerStyle("FILL", 0, 0);
        INDENT = new BannerStyle("INDENT", 1, 1);
        TRIPTYCH = new BannerStyle("TRIPTYCH", 2, 2);
        $VALUES = $values();
    }

    private BannerStyle(String r1, int r2, int r3) {
        super(r1, r2);
        this.style = r3;
    }

    public static BannerStyle valueOf(String r2) {
        return (BannerStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(BannerStyle.class, r2), BannerStyle.class, "com.obric.memorydata.plugin");
    }

    public static BannerStyle[] values() {
        return (BannerStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BannerStyle[].class, "com.obric.memorydata.plugin");
    }

    public final int getStyle() {
        return this.style;
    }
}
