package com.lynx.component.svg.parser;

/* JADX INFO: loaded from: classes2.dex */
public final enum SVG$Style$LineCap extends Enum<SVG$Style$LineCap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SVG$Style$LineCap f9745a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SVG$Style$LineCap f9746b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SVG$Style$LineCap f9747c = null;
    public static final /* synthetic */ SVG$Style$LineCap[] d = null;

    static {
        SVG$Style$LineCap r5 = new SVG$Style$LineCap("Butt", 0);
        f9745a = r5;
        SVG$Style$LineCap r10 = new SVG$Style$LineCap("Round", 1);
        f9746b = r10;
        SVG$Style$LineCap r11 = new SVG$Style$LineCap("Square", 2);
        f9747c = r11;
        d = new SVG$Style$LineCap[]{r5, r10, r11};
    }

    public SVG$Style$LineCap(String r5, int r10) {
        super(r5, r10);
    }

    public static SVG$Style$LineCap valueOf(String r5) {
        return (SVG$Style$LineCap) Enum.valueOf(SVG$Style$LineCap.class, r5);
    }

    public static SVG$Style$LineCap[] values() {
        return (SVG$Style$LineCap[]) d.clone();
    }
}
