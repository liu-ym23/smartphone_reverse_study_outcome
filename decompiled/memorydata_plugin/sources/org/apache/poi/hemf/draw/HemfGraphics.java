package org.apache.poi.hemf.draw;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.apache.poi.hwmf.draw.HwmfDrawProperties;
import org.apache.poi.hwmf.draw.HwmfGraphics;
import org.apache.poi.hwmf.record.HwmfBrushStyle;
import org.apache.poi.hwmf.record.HwmfColorRef;

/* JADX INFO: loaded from: classes6.dex */
public class HemfGraphics extends HwmfGraphics {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final HwmfColorRef BLACK = null;
    private static final HwmfColorRef DKGRAY = null;
    private static final HwmfColorRef GRAY = null;
    private static final HwmfColorRef LTGRAY = null;
    private static final HwmfColorRef WHITE = null;

    public static final enum EmfRenderState extends Enum<EmfRenderState> {
        private static final /* synthetic */ EmfRenderState[] $VALUES = null;
        public static final EmfRenderState EMFPLUS_ONLY = null;
        public static final EmfRenderState EMF_DCONTEXT = null;
        public static final EmfRenderState EMF_ONLY = null;
        public static final EmfRenderState INITIAL = null;

        static {
            EmfRenderState r0 = new EmfRenderState("INITIAL", 0);
            INITIAL = r0;
            EmfRenderState r1 = new EmfRenderState("EMF_ONLY", 1);
            EMF_ONLY = r1;
            EmfRenderState r3 = new EmfRenderState("EMFPLUS_ONLY", 2);
            EMFPLUS_ONLY = r3;
            EmfRenderState r5 = new EmfRenderState("EMF_DCONTEXT", 3);
            EMF_DCONTEXT = r5;
            $VALUES = new EmfRenderState[]{r0, r1, r3, r5};
        }

        private EmfRenderState(String r1, int r2) {
            super(r1, r2);
        }

        public static EmfRenderState valueOf(String r2) {
            return (EmfRenderState) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfRenderState.class, r2), EmfRenderState.class, "com.obric.memorydata.plugin");
        }

        public static EmfRenderState[] values() {
            return (EmfRenderState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfRenderState[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        WHITE = new HwmfColorRef(Color.WHITE);
        LTGRAY = new HwmfColorRef(new Color(12632256));
        GRAY = new HwmfColorRef(new Color(8421504));
        DKGRAY = new HwmfColorRef(new Color(4210752));
        BLACK = new HwmfColorRef(Color.BLACK);
    }

    static /* synthetic */ Color[] lambda$getLinearGradient$1(int r0) {
        return new Color[r0];
    }

    static /* synthetic */ void lambda$toArray$2(float[] r3, int[] r4, Number r5) {
        int r1 = r4[0];
        r4[0] = r1 + 1;
        r3[r1] = r5.floatValue();
    }

    private static float[] toArray(Stream<? extends Number> r2, int r3) {
        final float[] r4 = new float[r3];
        final int[] r0 = {0};
        ((Stream) ZeusTransformUtils.wrapperContextForParams(r2, Stream.class, "com.obric.memorydata.plugin")).forEach(new $$Lambda$HemfGraphics$iZVIluUNfiR05aNFnTf89ikx9xQ(r4, r0));
        return r4;
    }

    @Override // org.apache.poi.hwmf.draw.HwmfGraphics
    public void fill(Shape r4) {
        Shape r5 = (Shape) ZeusTransformUtils.wrapperContextForParams(r4, Shape.class, "com.obric.memorydata.plugin");
        if (getProperties().getBrushStyle() != HwmfBrushStyle.BS_NULL) goto L5;
        return;
    L5:
        Composite r0 = this.graphicsCtx.getComposite();
        this.graphicsCtx.setComposite(AlphaComposite.getInstance(3));
        this.graphicsCtx.setPaint(getFill());
        this.graphicsCtx.fill(r5);
        this.graphicsCtx.setComposite(r0);
    }

    @Override // org.apache.poi.hwmf.draw.HwmfGraphics
    public Paint getHatchedFill() {
        return super.getHatchedFill();
    }

    @Override // org.apache.poi.hwmf.draw.HwmfGraphics
    public Paint getLinearGradient() {
        HemfDrawProperties r11 = getProperties();
        Rectangle2D r0 = r11.getBrushRect();
        List<? extends Map.Entry<Float, Color>> r1 = r11.getBrushColorsH();
        return new LinearGradientPaint(new Point2D.Double(r0.getMinX(), r0.getCenterY()), new Point2D.Double(r0.getMaxX(), r0.getCenterY()), toArray(r1.stream().map($$Lambda$qWW5qenB_8QGqTMC2z07Ra_u8fc.INSTANCE), r1.size()), (Color[]) ZeusTransformUtils.preCheckCast(r1.stream().map($$Lambda$iKpKzCtvjxtCdk5FW_gxCQseg70.INSTANCE).toArray($$Lambda$HemfGraphics$mjwEBHQJIPO33ZlfqnWxzKt6mP0.INSTANCE), Color[].class, "com.obric.memorydata.plugin"), MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, r11.getBrushTransform());
    }

    @Override // org.apache.poi.hwmf.draw.HwmfGraphics
    public HemfDrawProperties getProperties() {
        return (HemfDrawProperties) ZeusTransformUtils.preCheckCast(super.getProperties(), HemfDrawProperties.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.hwmf.draw.HwmfGraphics
    public /* bridge */ /* synthetic */ HwmfDrawProperties getProperties() {
        return getProperties();
    }

    @Override // org.apache.poi.hwmf.draw.HwmfGraphics
    public HemfDrawProperties newProperties(HwmfDrawProperties r3) {
        if (r3 != null) goto L5;
        HemfDrawProperties r2 = new HemfDrawProperties();
    L6:
        return r2;
    L5:
        r2 = new HemfDrawProperties((HemfDrawProperties) ZeusTransformUtils.preCheckCast(r3, HemfDrawProperties.class, "com.obric.memorydata.plugin"));
        goto L6
    }

    @Override // org.apache.poi.hwmf.draw.HwmfGraphics
    public /* bridge */ /* synthetic */ HwmfDrawProperties newProperties(HwmfDrawProperties r1) {
        return newProperties(r1);
    }
}
