package com.lynx.component.svg.parser;

/* JADX INFO: loaded from: classes2.dex */
public final enum SVG$Style$FillRule extends Enum<SVG$Style$FillRule> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SVG$Style$FillRule f9742a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SVG$Style$FillRule f9743b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ SVG$Style$FillRule[] f9744c = null;

    static {
        SVG$Style$FillRule r5 = new SVG$Style$FillRule("NonZero", 0);
        f9742a = r5;
        SVG$Style$FillRule r10 = new SVG$Style$FillRule("EvenOdd", 1);
        f9743b = r10;
        f9744c = new SVG$Style$FillRule[]{r5, r10};
    }

    public SVG$Style$FillRule(String r5, int r10) {
        super(r5, r10);
    }

    public static SVG$Style$FillRule valueOf(String r5) {
        return (SVG$Style$FillRule) Enum.valueOf(SVG$Style$FillRule.class, r5);
    }

    public static SVG$Style$FillRule[] values() {
        return (SVG$Style$FillRule[]) f9744c.clone();
    }
}
