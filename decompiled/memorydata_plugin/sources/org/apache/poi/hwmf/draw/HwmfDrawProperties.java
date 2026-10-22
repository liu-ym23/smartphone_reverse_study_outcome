package org.apache.poi.hwmf.draw;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import org.apache.poi.hwmf.record.HwmfBinaryRasterOp;
import org.apache.poi.hwmf.record.HwmfBrushStyle;
import org.apache.poi.hwmf.record.HwmfColorRef;
import org.apache.poi.hwmf.record.HwmfFill;
import org.apache.poi.hwmf.record.HwmfFont;
import org.apache.poi.hwmf.record.HwmfHatchStyle;
import org.apache.poi.hwmf.record.HwmfMapMode;
import org.apache.poi.hwmf.record.HwmfMisc;
import org.apache.poi.hwmf.record.HwmfPalette;
import org.apache.poi.hwmf.record.HwmfPenStyle;
import org.apache.poi.hwmf.record.HwmfTernaryRasterOp;
import org.apache.poi.hwmf.record.HwmfText;
import org.apache.poi.sl.draw.ImageRenderer;

/* JADX INFO: loaded from: classes7.dex */
public class HwmfDrawProperties {
    private HwmfColorRef backgroundColor;
    private HwmfMisc.WmfSetBkMode.HwmfBkMode bkMode;
    private ImageRenderer brushBitmap;
    private HwmfColorRef brushColor;
    private HwmfHatchStyle brushHatch;
    private HwmfBrushStyle brushStyle;
    private final AffineTransform brushTransform;
    protected Shape clip;
    private HwmfFont font;
    private final Point2D location;
    private HwmfMapMode mapMode;
    private List<HwmfPalette.PaletteEntry> palette;
    private int paletteOffset;
    private HwmfColorRef penColor;
    private double penMiterLimit;
    private HwmfPenStyle penStyle;
    private double penWidth;
    private HwmfFill.WmfSetPolyfillMode.HwmfPolyfillMode polyfillMode;
    private HwmfBinaryRasterOp rasterOp2;
    private HwmfTernaryRasterOp rasterOp3;
    private Shape region;
    private HwmfText.HwmfTextAlignment textAlignAsian;
    private HwmfText.HwmfTextAlignment textAlignLatin;
    private HwmfColorRef textColor;
    private HwmfText.HwmfTextVerticalAlignment textVAlignAsian;
    private HwmfText.HwmfTextVerticalAlignment textVAlignLatin;
    protected final AffineTransform transform;
    private Rectangle2D viewport;
    private final Rectangle2D window;

    public HwmfDrawProperties() {
        this.brushTransform = new AffineTransform();
        this.transform = new AffineTransform();
        this.window = new Rectangle2D.Double(0.0d, 0.0d, 1.0d, 1.0d);
        this.viewport = null;
        this.location = new Point2D.Double(0.0d, 0.0d);
        this.mapMode = HwmfMapMode.MM_ANISOTROPIC;
        this.backgroundColor = new HwmfColorRef(Color.BLACK);
        this.brushStyle = HwmfBrushStyle.BS_SOLID;
        this.brushColor = new HwmfColorRef(Color.BLACK);
        this.brushHatch = HwmfHatchStyle.HS_HORIZONTAL;
        this.penWidth = 1.0d;
        this.penStyle = HwmfPenStyle.valueOf(0);
        this.penColor = new HwmfColorRef(Color.BLACK);
        this.penMiterLimit = 10.0d;
        this.bkMode = HwmfMisc.WmfSetBkMode.HwmfBkMode.OPAQUE;
        this.polyfillMode = HwmfFill.WmfSetPolyfillMode.HwmfPolyfillMode.WINDING;
        this.textColor = new HwmfColorRef(Color.BLACK);
        this.textAlignLatin = HwmfText.HwmfTextAlignment.LEFT;
        this.textVAlignLatin = HwmfText.HwmfTextVerticalAlignment.TOP;
        this.textAlignAsian = HwmfText.HwmfTextAlignment.RIGHT;
        this.textVAlignAsian = HwmfText.HwmfTextVerticalAlignment.TOP;
        this.rasterOp2 = HwmfBinaryRasterOp.R2_COPYPEN;
        this.rasterOp3 = null;
        this.clip = null;
        HwmfFont r0 = new HwmfFont();
        this.font = r0;
        r0.initDefaults();
    }

    public HwmfDrawProperties(HwmfDrawProperties r7) {
        AffineTransform r0 = new AffineTransform();
        this.brushTransform = r0;
        AffineTransform r1 = new AffineTransform();
        this.transform = r1;
        Rectangle2D r2 = r7.window;
        HwmfColorRef r4 = null;
        if (r2 != null) goto L5;
        Rectangle2D r3 = null;
    L6:
        this.window = r3;
        Rectangle2D r5 = r7.viewport;
        if (r5 != null) goto L9;
        Rectangle2D r6 = null;
    L10:
        this.viewport = r6;
        this.location = (Point2D) ZeusTransformUtils.preCheckCast(r7.location.clone(), Point2D.class, "com.obric.memorydata.plugin");
        this.mapMode = r7.mapMode;
        HwmfColorRef r8 = r7.backgroundColor;
        if (r8 != null) goto L13;
        HwmfColorRef r9 = null;
    L14:
        this.backgroundColor = r9;
        this.brushStyle = r7.brushStyle;
        this.brushColor = r7.brushColor.copy();
        this.brushHatch = r7.brushHatch;
        this.brushBitmap = r7.brushBitmap;
        r0.setTransform(r7.brushTransform);
        this.penWidth = r7.penWidth;
        HwmfPenStyle r10 = r7.penStyle;
        if (r10 != null) goto L17;
        HwmfPenStyle r11 = null;
    L18:
        this.penStyle = r11;
        HwmfColorRef r12 = r7.penColor;
        if (r12 != null) goto L21;
        HwmfColorRef r13 = null;
    L22:
        this.penColor = r13;
        this.penMiterLimit = r7.penMiterLimit;
        this.bkMode = r7.bkMode;
        this.polyfillMode = r7.polyfillMode;
        if (ZeusTransformUtils.instanceOf(r7.region, Rectangle2D.class) == false) goto L27;
        Rectangle2D r14 = r7.region.getBounds2D();
    L25:
        this.region = r14;
    L29:
        this.palette = r7.palette;
        this.paletteOffset = r7.paletteOffset;
        this.font = r7.font;
        HwmfColorRef r15 = r7.textColor;
        if (r15 == null) goto L33;
        r4 = r15.copy();
    L33:
        this.textColor = r4;
        this.textAlignLatin = r7.textAlignLatin;
        this.textVAlignLatin = r7.textVAlignLatin;
        this.textAlignAsian = r7.textAlignAsian;
        this.textVAlignAsian = r7.textVAlignAsian;
        this.rasterOp2 = r7.rasterOp2;
        this.rasterOp3 = r7.rasterOp3;
        r1.setTransform(r7.transform);
        this.clip = r7.clip;
        return;
    L27:
        if (ZeusTransformUtils.instanceOf(r7.region, Area.class) == false) goto L29;
        r14 = new Area(r7.region);
        goto L25
    L21:
        r13 = r12.copy();
        goto L22
    L17:
        r11 = r10.copy();
        goto L18
    L13:
        r9 = r8.copy();
        goto L14
    L9:
        r6 = (Rectangle2D) ZeusTransformUtils.preCheckCast(r5.clone(), Rectangle2D.class, "com.obric.memorydata.plugin");
        goto L10
    L5:
        r3 = (Rectangle2D) ZeusTransformUtils.preCheckCast(r2.clone(), Rectangle2D.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public HwmfColorRef getBackgroundColor() {
        return this.backgroundColor;
    }

    public HwmfMisc.WmfSetBkMode.HwmfBkMode getBkMode() {
        return this.bkMode;
    }

    public ImageRenderer getBrushBitmap() {
        return this.brushBitmap;
    }

    public HwmfColorRef getBrushColor() {
        return this.brushColor;
    }

    public HwmfHatchStyle getBrushHatch() {
        return this.brushHatch;
    }

    public HwmfBrushStyle getBrushStyle() {
        return this.brushStyle;
    }

    public AffineTransform getBrushTransform() {
        return this.brushTransform;
    }

    public HwmfColorRef getPenColor() {
        return this.penColor;
    }

    public double getPenMiterLimit() {
        return this.penMiterLimit;
    }

    public HwmfPenStyle getPenStyle() {
        return this.penStyle;
    }

    public double getPenWidth() {
        return this.penWidth;
    }
}
