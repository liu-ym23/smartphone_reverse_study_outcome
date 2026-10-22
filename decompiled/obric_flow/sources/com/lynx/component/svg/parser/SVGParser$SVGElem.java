package com.lynx.component.svg.parser;

import com.lynx.serval.svg.SVGRenderEngine;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
final enum SVGParser$SVGElem extends Enum<SVGParser$SVGElem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SVGParser$SVGElem f9763a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f9764b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ SVGParser$SVGElem[] f9765c = null;

    static {
        SVGParser$SVGElem r5 = new SVGParser$SVGElem(SVGRenderEngine.SVG, 0);
        SVGParser$SVGElem r10 = new SVGParser$SVGElem(SVGRenderEngine.CIRCLE, 1);
        SVGParser$SVGElem r11 = new SVGParser$SVGElem(SVGRenderEngine.CLIP_PATH, 2);
        SVGParser$SVGElem r12 = new SVGParser$SVGElem("defs", 3);
        SVGParser$SVGElem r13 = new SVGParser$SVGElem(SVGRenderEngine.ELLIPSE, 4);
        SVGParser$SVGElem r14 = new SVGParser$SVGElem("g", 5);
        SVGParser$SVGElem r15 = new SVGParser$SVGElem("image", 6);
        SVGParser$SVGElem r16 = new SVGParser$SVGElem(SVGRenderEngine.LINE, 7);
        SVGParser$SVGElem r17 = new SVGParser$SVGElem(SVGRenderEngine.LINEAR_GRADIENT, 8);
        SVGParser$SVGElem r18 = new SVGParser$SVGElem(SVGRenderEngine.PATH, 9);
        SVGParser$SVGElem r19 = new SVGParser$SVGElem("pattern", 10);
        SVGParser$SVGElem r110 = new SVGParser$SVGElem(SVGRenderEngine.POLYGON, 11);
        SVGParser$SVGElem r111 = new SVGParser$SVGElem(SVGRenderEngine.POLYLINE, 12);
        SVGParser$SVGElem r112 = new SVGParser$SVGElem(SVGRenderEngine.RADIAL_GRADIENT, 13);
        SVGParser$SVGElem r20 = new SVGParser$SVGElem(SVGRenderEngine.RECT, 14);
        SVGParser$SVGElem r21 = new SVGParser$SVGElem("solidColor", 15);
        SVGParser$SVGElem r22 = new SVGParser$SVGElem("stop", 16);
        SVGParser$SVGElem r23 = new SVGParser$SVGElem("use", 17);
        SVGParser$SVGElem r24 = new SVGParser$SVGElem("UNSUPPORTED", 18);
        f9763a = r24;
        f9765c = new SVGParser$SVGElem[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r20, r21, r22, r23, r24};
        f9764b = new HashMap();
        SVGParser$SVGElem[] r25 = values();
        int r26 = r25.length;
        int r113 = 0;
    L3:
        if (r113 >= r26) goto L8;
        SVGParser$SVGElem r27 = r25[r113];
        if (r27 == f9763a) goto L7;
        f9764b.put(r27.name(), r27);
    L7:
        r113 = r113 + 1;
        goto L3
    }

    public SVGParser$SVGElem(String r5, int r10) {
        super(r5, r10);
    }

    public static SVGParser$SVGElem valueOf(String r5) {
        return (SVGParser$SVGElem) Enum.valueOf(SVGParser$SVGElem.class, r5);
    }

    public static SVGParser$SVGElem[] values() {
        return (SVGParser$SVGElem[]) f9765c.clone();
    }
}
