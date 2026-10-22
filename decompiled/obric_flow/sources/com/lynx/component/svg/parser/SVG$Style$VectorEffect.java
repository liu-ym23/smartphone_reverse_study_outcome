package com.lynx.component.svg.parser;

/* JADX INFO: loaded from: classes2.dex */
public final enum SVG$Style$VectorEffect extends Enum<SVG$Style$VectorEffect> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SVG$Style$VectorEffect f9754a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SVG$Style$VectorEffect f9755b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ SVG$Style$VectorEffect[] f9756c = null;

    static {
        SVG$Style$VectorEffect r5 = new SVG$Style$VectorEffect("None", 0);
        f9754a = r5;
        SVG$Style$VectorEffect r10 = new SVG$Style$VectorEffect("NonScalingStroke", 1);
        f9755b = r10;
        f9756c = new SVG$Style$VectorEffect[]{r5, r10};
    }

    public SVG$Style$VectorEffect(String r5, int r10) {
        super(r5, r10);
    }

    public static SVG$Style$VectorEffect valueOf(String r5) {
        return (SVG$Style$VectorEffect) Enum.valueOf(SVG$Style$VectorEffect.class, r5);
    }

    public static SVG$Style$VectorEffect[] values() {
        return (SVG$Style$VectorEffect[]) f9756c.clone();
    }
}
