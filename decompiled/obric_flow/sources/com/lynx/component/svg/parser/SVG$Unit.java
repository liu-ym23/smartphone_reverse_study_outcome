package com.lynx.component.svg.parser;

/* JADX INFO: loaded from: classes2.dex */
final enum SVG$Unit extends Enum<SVG$Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SVG$Unit f9757a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SVG$Unit f9758b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SVG$Unit f9759c = null;
    public static final SVG$Unit d = null;
    public static final SVG$Unit e = null;
    public static final SVG$Unit f = null;
    public static final /* synthetic */ SVG$Unit[] g = null;

    static {
        SVG$Unit r5 = new SVG$Unit("px", 0);
        f9757a = r5;
        SVG$Unit r10 = new SVG$Unit("em", 1);
        f9758b = r10;
        SVG$Unit r11 = new SVG$Unit("ex", 2);
        f9759c = r11;
        SVG$Unit r12 = new SVG$Unit("in", 3);
        SVG$Unit r13 = new SVG$Unit("cm", 4);
        SVG$Unit r14 = new SVG$Unit("mm", 5);
        SVG$Unit r15 = new SVG$Unit("pt", 6);
        SVG$Unit r16 = new SVG$Unit("pc", 7);
        SVG$Unit r17 = new SVG$Unit("percent", 8);
        d = r17;
        SVG$Unit r18 = new SVG$Unit("rpx", 9);
        e = r18;
        SVG$Unit r19 = new SVG$Unit("rem", 10);
        f = r19;
        g = new SVG$Unit[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
    }

    public SVG$Unit(String r5, int r10) {
        super(r5, r10);
    }

    public static SVG$Unit valueOf(String r5) {
        return (SVG$Unit) Enum.valueOf(SVG$Unit.class, r5);
    }

    public static SVG$Unit[] values() {
        return (SVG$Unit[]) g.clone();
    }
}
