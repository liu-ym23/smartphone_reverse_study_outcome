package org.apache.poi.hwmf.draw;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.TexturePaint;
import java.awt.font.TextAttribute;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;
import java.util.function.BiConsumer;
import org.apache.poi.hwmf.record.HwmfBrushStyle;
import org.apache.poi.hwmf.record.HwmfMapMode;
import org.apache.poi.hwmf.record.HwmfMisc;
import org.apache.poi.hwmf.record.HwmfPenStyle;
import org.apache.poi.hwmf.record.HwmfTernaryRasterOp;
import org.apache.poi.hwmf.record.HwmfText;
import org.apache.poi.sl.draw.ImageRenderer;

/* JADX INFO: loaded from: classes7.dex */
public class HwmfGraphics {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Float[] WEIGHT_MAP = null;
    protected final Graphics2D graphicsCtx;
    protected HwmfDrawProperties prop;

    /* JADX INFO: renamed from: org.apache.poi.hwmf.draw.HwmfGraphics$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$hwmf$record$HwmfBrushStyle = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$hwmf$record$HwmfMapMode = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$hwmf$record$HwmfTernaryRasterOp = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextAlignment = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextVerticalAlignment = null;

        static {
            int[] r0 = new int[HwmfTernaryRasterOp.values().length];
            $SwitchMap$org$apache$poi$hwmf$record$HwmfTernaryRasterOp = r0;
            r0[HwmfTernaryRasterOp.SRCCOPY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L47
        L101:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfTernaryRasterOp[HwmfTernaryRasterOp.SRCINVERT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L48
        L119:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfTernaryRasterOp[HwmfTernaryRasterOp.SRCAND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L49
        L129:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfTernaryRasterOp[HwmfTernaryRasterOp.D.ordinal()] = 4;     // Catch: NoSuchFieldError -> L50
        L131:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfTernaryRasterOp[HwmfTernaryRasterOp.PATCOPY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L51
        L85:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfTernaryRasterOp[HwmfTernaryRasterOp.BLACKNESS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L52
        L91:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfTernaryRasterOp[HwmfTernaryRasterOp.WHITENESS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L53
        L16:
            int[] r7 = new int[HwmfText.HwmfTextVerticalAlignment.values().length];
            $SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextVerticalAlignment = r7;
            r7[HwmfText.HwmfTextVerticalAlignment.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L54
        L117:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextVerticalAlignment[HwmfText.HwmfTextVerticalAlignment.BASELINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L55
        L135:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextVerticalAlignment[HwmfText.HwmfTextVerticalAlignment.BOTTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L56
        L20:
            int[] r8 = new int[HwmfText.HwmfTextAlignment.values().length];
            $SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextAlignment = r8;
            r8[HwmfText.HwmfTextAlignment.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L57
        L89:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextAlignment[HwmfText.HwmfTextAlignment.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L58
        L103:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextAlignment[HwmfText.HwmfTextAlignment.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L59
        L24:
            int[] r9 = new int[HwmfMapMode.values().length];
            $SwitchMap$org$apache$poi$hwmf$record$HwmfMapMode = r9;
            r9[HwmfMapMode.MM_ANISOTROPIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L60
        L133:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfMapMode[HwmfMapMode.MM_ISOTROPIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L61
        L141:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfMapMode[HwmfMapMode.MM_LOMETRIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L62
        L79:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfMapMode[HwmfMapMode.MM_HIMETRIC.ordinal()] = 4;     // Catch: NoSuchFieldError -> L63
        L93:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfMapMode[HwmfMapMode.MM_LOENGLISH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L64
        L113:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfMapMode[HwmfMapMode.MM_HIENGLISH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L65
        L121:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfMapMode[HwmfMapMode.MM_TWIPS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L66
        L123:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfMapMode[HwmfMapMode.MM_TEXT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L67
        L34:
            int[] r10 = new int[HwmfBrushStyle.values().length];
            $SwitchMap$org$apache$poi$hwmf$record$HwmfBrushStyle = r10;
            r10[HwmfBrushStyle.BS_INDEXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L68
        L95:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfBrushStyle[HwmfBrushStyle.BS_PATTERN8X8.ordinal()] = 2;     // Catch: NoSuchFieldError -> L69
        L99:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfBrushStyle[HwmfBrushStyle.BS_DIBPATTERN8X8.ordinal()] = 3;     // Catch: NoSuchFieldError -> L70
        L111:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfBrushStyle[HwmfBrushStyle.BS_MONOPATTERN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L71
        L125:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfBrushStyle[HwmfBrushStyle.BS_NULL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L72
        L137:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfBrushStyle[HwmfBrushStyle.BS_PATTERN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L73
        L139:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfBrushStyle[HwmfBrushStyle.BS_DIBPATTERN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L74
        L81:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfBrushStyle[HwmfBrushStyle.BS_DIBPATTERNPT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L75
        L105:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfBrushStyle[HwmfBrushStyle.BS_SOLID.ordinal()] = 9;     // Catch: NoSuchFieldError -> L76
        L109:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfBrushStyle[HwmfBrushStyle.BS_HATCHED.ordinal()] = 10;     // Catch: NoSuchFieldError -> L77
        L127:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfBrushStyle[HwmfBrushStyle.BS_LINEAR_GRADIENT.ordinal()] = 11;     // Catch: NoSuchFieldError -> L78
            return;
        }
    }

    public static final enum FillDrawStyle extends Enum<FillDrawStyle> {
        private static final /* synthetic */ FillDrawStyle[] $VALUES = null;
        public static final FillDrawStyle DRAW = null;
        public static final FillDrawStyle FILL = null;
        public static final FillDrawStyle FILL_DRAW = null;
        public static final FillDrawStyle NONE = null;
        public final BiConsumer<HwmfGraphics, Shape> handler;

        static {
            FillDrawStyle r0 = new FillDrawStyle("NONE", 0, $$Lambda$HwmfGraphics$FillDrawStyle$hvxavnAlUcPcwGZcOeS16bww3Q.INSTANCE);
            NONE = r0;
            FillDrawStyle r1 = new FillDrawStyle("FILL", 1, $$Lambda$TvMhLq39n9A5VQ6hWVcvrOHs54M.INSTANCE);
            FILL = r1;
            FillDrawStyle r2 = new FillDrawStyle("DRAW", 2, $$Lambda$DmrE0yjjMQYHTirvL478qfu7Qk.INSTANCE);
            DRAW = r2;
            FillDrawStyle r4 = new FillDrawStyle("FILL_DRAW", 3, $$Lambda$HwmfGraphics$FillDrawStyle$2mA9mpH5yKFOKKsamA_sJHMM3Bw.INSTANCE);
            FILL_DRAW = r4;
            $VALUES = new FillDrawStyle[]{r0, r1, r2, r4};
        }

        private FillDrawStyle(String r3, int r4, BiConsumer r5) {
            BiConsumer<HwmfGraphics, Shape> r6 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r5, BiConsumer.class, "com.obric.memorydata.plugin");
            super(r3, r4);
            this.handler = r6;
        }

        private static void fillDraw(HwmfGraphics r2, Shape r3) {
            Shape r4 = (Shape) ZeusTransformUtils.wrapperContextForParams(r3, Shape.class, "com.obric.memorydata.plugin");
            r2.fill(r4);
            r2.draw(r4);
        }

        private static void fillNone(HwmfGraphics r1, Shape r2) {
            Shape r3 = (Shape) ZeusTransformUtils.wrapperContextForParams(r2, Shape.class, "com.obric.memorydata.plugin");
        }

        public static /* synthetic */ void lambda$2mA9mpH5yKFOKKsamA_sJHMM3Bw(HwmfGraphics r0, Shape r1) {
            fillDraw(r0, r1);
        }

        /* JADX INFO: renamed from: lambda$hvxavnAlUcPcwGZcOeS16bww-3Q, reason: not valid java name */
        public static /* synthetic */ void m3162lambda$hvxavnAlUcPcwGZcOeS16bww3Q(HwmfGraphics r0, Shape r1) {
            fillNone(r0, r1);
        }

        public static FillDrawStyle valueOf(String r2) {
            return (FillDrawStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(FillDrawStyle.class, r2), FillDrawStyle.class, "com.obric.memorydata.plugin");
        }

        public static FillDrawStyle[] values() {
            return (FillDrawStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FillDrawStyle[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        WEIGHT_MAP = new Float[]{Float.valueOf(900.0f), TextAttribute.WEIGHT_ULTRABOLD, Float.valueOf(800.0f), TextAttribute.WEIGHT_EXTRABOLD, Float.valueOf(750.0f), TextAttribute.WEIGHT_HEAVY, Float.valueOf(700.0f), TextAttribute.WEIGHT_BOLD, Float.valueOf(600.0f), TextAttribute.WEIGHT_DEMIBOLD, Float.valueOf(500.0f), TextAttribute.WEIGHT_MEDIUM, Float.valueOf(450.0f), TextAttribute.WEIGHT_SEMIBOLD, Float.valueOf(400.0f), TextAttribute.WEIGHT_REGULAR, Float.valueOf(300.0f), TextAttribute.WEIGHT_DEMILIGHT, Float.valueOf(200.0f), TextAttribute.WEIGHT_LIGHT, Float.valueOf(1.0f), TextAttribute.WEIGHT_EXTRA_LIGHT};
    }

    public static BufferedImage getPatternFromLong(long r9, Color r11, Color r12, boolean r13) {
        int r0 = 0;
        int[] r4 = {((Color) ZeusTransformUtils.wrapperContextForParams(r11, Color.class, "com.obric.memorydata.plugin")).getRGB(), ((Color) ZeusTransformUtils.wrapperContextForParams(r12, Color.class, "com.obric.memorydata.plugin")).getRGB()};
        if (r13 == false) goto L5;
        int r7 = 0;
    L6:
        BufferedImage r14 = new BufferedImage(8, 8, 13, new IndexColorModel(1, 2, r4, 0, r13, r7, 0));
        byte[] r6 = new byte[64];
    L7:
        if (r0 >= 64) goto L9;
        r6[r0] = (byte) ((r9 >>> r0) & 1);
        r0 = r0 + 1;
        goto L7
    L9:
        r14.getRaster().setDataElements(0, 0, 8, 8, r6);
        return r14;
    L5:
        r7 = -1;
        goto L6
    }

    public void draw(Shape r5) {
        Shape r6 = (Shape) ZeusTransformUtils.wrapperContextForParams(r5, Shape.class, "com.obric.memorydata.plugin");
        HwmfPenStyle r0 = getProperties().getPenStyle();
        if (r0 != null) goto L5;
        return;
    L5:
        HwmfPenStyle.HwmfLineDash r1 = r0.getLineDash();
        if (r1 != HwmfPenStyle.HwmfLineDash.NULL) goto L8;
        return;
    L8:
        BasicStroke r2 = getStroke();
        if (getProperties().getBkMode() == HwmfMisc.WmfSetBkMode.HwmfBkMode.OPAQUE) goto L11;
    L15:
        this.graphicsCtx.setStroke(r2);
        this.graphicsCtx.setColor(getProperties().getPenColor().getColor());
        this.graphicsCtx.draw(r6);
        return;
    L11:
        if (r1 == HwmfPenStyle.HwmfLineDash.SOLID) goto L15;
        if (r1 == HwmfPenStyle.HwmfLineDash.INSIDEFRAME) goto L15;
        this.graphicsCtx.setStroke(new BasicStroke(r2.getLineWidth()));
        this.graphicsCtx.setColor(getProperties().getBackgroundColor().getColor());
        this.graphicsCtx.draw(r6);
        goto L15
    }

    public void fill(Shape r4) {
        Shape r5 = (Shape) ZeusTransformUtils.wrapperContextForParams(r4, Shape.class, "com.obric.memorydata.plugin");
        if (getProperties().getBrushStyle() == HwmfBrushStyle.BS_NULL) goto L5;
        Composite r0 = this.graphicsCtx.getComposite();
        this.graphicsCtx.setComposite(AlphaComposite.getInstance(3));
        this.graphicsCtx.setPaint(getFill());
        this.graphicsCtx.fill(r5);
        this.graphicsCtx.setComposite(r0);
    L5:
        draw(r5);
    }

    public Paint getFill() {
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$hwmf$record$HwmfBrushStyle[getProperties().getBrushStyle().ordinal()]) {
            case 6: goto L13;
            case 7: goto L13;
            case 8: goto L13;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return getLinearGradient();
    L9:
        return getHatchedFill();
    L11:
        return getSolidFill();
    L13:
        return getPatternPaint();
    }

    public Paint getHatchedFill() {
        HwmfDrawProperties r6 = getProperties();
        long r0 = r6.getBrushHatch().getPattern();
        Color r2 = r6.getBackgroundColor().getColor();
        Color r3 = r6.getBrushColor().getColor();
        if (r6.getBkMode() != HwmfMisc.WmfSetBkMode.HwmfBkMode.TRANSPARENT) goto L5;
        boolean r7 = true;
    L7:
        return new TexturePaint(getPatternFromLong(r0, r2, r3, r7), new Rectangle(0, 0, 8, 8));
    L5:
        r7 = false;
        goto L7
    }

    public Paint getLinearGradient() {
        return null;
    }

    public Paint getPatternPaint() {
        HwmfDrawProperties r12 = getProperties();
        ImageRenderer r0 = r12.getBrushBitmap();
        if (r0 != null) goto L6;
        return null;
    L6:
        Dimension2D r1 = r0.getDimension();
        Rectangle2D.Double r11 = new Rectangle2D.Double(0.0d, 0.0d, r1.getWidth(), r1.getHeight());
        Rectangle2D r13 = r12.getBrushTransform().createTransformedShape(r11).getBounds2D();
        return new TexturePaint(r0.getImage(), r13);
    }

    public HwmfDrawProperties getProperties() {
        if (this.prop != null) goto L6;
        this.prop = newProperties(null);
    L6:
        return this.prop;
    }

    public Paint getSolidFill() {
        return getProperties().getBrushColor().getColor();
    }

    public BasicStroke getStroke() {
        HwmfDrawProperties r12 = getProperties();
        HwmfPenStyle r0 = r12.getPenStyle();
        float r1 = (float) r12.getPenWidth();
        float r2 = 0.0f;
        if (r1 != 0.0f) goto L5;
        float r6 = 1.0f;
    L6:
        int r7 = r0.getLineCap().awtFlag;
        int r8 = r0.getLineJoin().awtFlag;
        float r13 = (float) r12.getPenMiterLimit();
        float[] r10 = r0.getLineDashes();
        if (r0.isAlternateDash() == false) goto L13;
        if (r10 == null) goto L13;
        if (r10.length <= 1) goto L13;
        r2 = r10[0];
    L13:
        return new BasicStroke(r6, r7, r8, Math.max(1.0f, r13), r10, r2);
    L5:
        r6 = r1;
        goto L6
    }

    public HwmfDrawProperties newProperties(HwmfDrawProperties r1) {
        if (r1 != null) goto L5;
        HwmfDrawProperties r0 = new HwmfDrawProperties();
    L6:
        return r0;
    L5:
        r0 = new HwmfDrawProperties(r1);
        goto L6
    }
}
