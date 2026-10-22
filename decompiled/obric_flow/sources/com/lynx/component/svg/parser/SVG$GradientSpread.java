package com.lynx.component.svg.parser;

/* JADX INFO: loaded from: classes2.dex */
final enum SVG$GradientSpread extends Enum<SVG$GradientSpread> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SVG$GradientSpread f9739a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SVG$GradientSpread f9740b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ SVG$GradientSpread[] f9741c = null;

    static {
        SVG$GradientSpread r5 = new SVG$GradientSpread("pad", 0);
        SVG$GradientSpread r10 = new SVG$GradientSpread("reflect", 1);
        f9739a = r10;
        SVG$GradientSpread r11 = new SVG$GradientSpread("repeat", 2);
        f9740b = r11;
        f9741c = new SVG$GradientSpread[]{r5, r10, r11};
    }

    public SVG$GradientSpread(String r5, int r10) {
        super(r5, r10);
    }

    public static SVG$GradientSpread valueOf(String r5) {
        return (SVG$GradientSpread) Enum.valueOf(SVG$GradientSpread.class, r5);
    }

    public static SVG$GradientSpread[] values() {
        return (SVG$GradientSpread[]) f9741c.clone();
    }
}
