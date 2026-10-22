package org.apache.poi.sl.draw;

import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import org.apache.poi.util.Dimension2DDouble;

/* JADX INFO: loaded from: classes7.dex */
public interface ImageRenderer {
    Rectangle2D getBounds();

    default Dimension2D getDimension() {
        Rectangle2D r5 = getBounds();
        return new Dimension2DDouble(Math.abs(r5.getWidth()), Math.abs(r5.getHeight()));
    }

    BufferedImage getImage();
}
