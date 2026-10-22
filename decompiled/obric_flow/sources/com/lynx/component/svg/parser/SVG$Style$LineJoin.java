package com.lynx.component.svg.parser;

/* JADX INFO: loaded from: classes2.dex */
public final enum SVG$Style$LineJoin extends Enum<SVG$Style$LineJoin> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SVG$Style$LineJoin f9748a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SVG$Style$LineJoin f9749b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SVG$Style$LineJoin f9750c = null;
    public static final /* synthetic */ SVG$Style$LineJoin[] d = null;

    static {
        SVG$Style$LineJoin r5 = new SVG$Style$LineJoin("Miter", 0);
        f9748a = r5;
        SVG$Style$LineJoin r10 = new SVG$Style$LineJoin("Round", 1);
        f9749b = r10;
        SVG$Style$LineJoin r11 = new SVG$Style$LineJoin("Bevel", 2);
        f9750c = r11;
        d = new SVG$Style$LineJoin[]{r5, r10, r11};
    }

    public SVG$Style$LineJoin(String r5, int r10) {
        super(r5, r10);
    }

    public static SVG$Style$LineJoin valueOf(String r5) {
        return (SVG$Style$LineJoin) Enum.valueOf(SVG$Style$LineJoin.class, r5);
    }

    public static SVG$Style$LineJoin[] values() {
        return (SVG$Style$LineJoin[]) d.clone();
    }
}
