package org.apache.poi.util;

import java.awt.geom.Dimension2D;

/* JADX INFO: loaded from: classes7.dex */
public class Dimension2DDouble extends Dimension2D {
    double height;
    double width;

    public Dimension2DDouble() {
        this.width = 0.0d;
        this.height = 0.0d;
    }

    public Dimension2DDouble(double r1, double r3) {
        this.width = r1;
        this.height = r3;
    }
}
