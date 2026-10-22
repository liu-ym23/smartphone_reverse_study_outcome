package com.lynx.component.svg.parser;

/* JADX INFO: loaded from: classes2.dex */
public final enum SVG$Style$RenderQuality extends Enum<SVG$Style$RenderQuality> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SVG$Style$RenderQuality f9751a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SVG$Style$RenderQuality f9752b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SVG$Style$RenderQuality f9753c = null;
    public static final /* synthetic */ SVG$Style$RenderQuality[] d = null;

    static {
        SVG$Style$RenderQuality r5 = new SVG$Style$RenderQuality("auto", 0);
        f9751a = r5;
        SVG$Style$RenderQuality r10 = new SVG$Style$RenderQuality("optimizeQuality", 1);
        f9752b = r10;
        SVG$Style$RenderQuality r11 = new SVG$Style$RenderQuality("optimizeSpeed", 2);
        f9753c = r11;
        d = new SVG$Style$RenderQuality[]{r5, r10, r11};
    }

    public SVG$Style$RenderQuality(String r5, int r10) {
        super(r5, r10);
    }

    public static SVG$Style$RenderQuality valueOf(String r5) {
        return (SVG$Style$RenderQuality) Enum.valueOf(SVG$Style$RenderQuality.class, r5);
    }

    public static SVG$Style$RenderQuality[] values() {
        return (SVG$Style$RenderQuality[]) d.clone();
    }
}
