package com.lynx.component.svg.parser;

import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l extends g0 implements e0 {
    public ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f9829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Matrix f9830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SVG$GradientSpread f9831j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f9832k;

    public l() {
        this.g = new ArrayList();
    }

    @Override // com.lynx.component.svg.parser.e0
    public final void a(g0 r5) {
        if ((r5 instanceof a0) == false) goto L7;
        this.g.add(r5);
        return;
    L7:
        throw new SVGParseException("Gradient elements cannot contain " + r5 + " elements.");
    }

    @Override // com.lynx.component.svg.parser.e0
    public final List getChildren() {
        return this.g;
    }
}
