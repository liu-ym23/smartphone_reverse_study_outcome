package org.apache.poi.hemf.draw;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import org.apache.poi.hemf.record.emfplus.HemfPlusBrush;
import org.apache.poi.hwmf.draw.HwmfDrawProperties;
import org.apache.poi.sl.draw.ImageRenderer;

/* JADX INFO: loaded from: classes6.dex */
public class HemfDrawProperties extends HwmfDrawProperties {
    private List<? extends Map.Entry<Float, Color>> brushColorsH;
    private List<? extends Map.Entry<Float, Color>> brushColorsV;
    private Rectangle2D brushRect;
    private HemfPlusBrush.EmfPlusHatchStyle emfPlusBrushHatch;
    private ImageRenderer emfPlusImage;
    protected Path2D path;
    private final List<TransOperand> transOper;
    private final List<AffineTransform> transXForm;
    protected boolean usePathBracket;

    static final enum TransOperand extends Enum<TransOperand> {
        private static final /* synthetic */ TransOperand[] $VALUES = null;
        public static final TransOperand left = null;
        public static final TransOperand right = null;
        BiConsumer<AffineTransform, AffineTransform> fun;

        static {
            TransOperand r0 = new TransOperand("left", 0, $$Lambda$HemfDrawProperties$TransOperand$aZFuPFAordDxlfqZG0d1VW7vDyg.INSTANCE);
            left = r0;
            TransOperand r1 = new TransOperand("right", 1, $$Lambda$HemfDrawProperties$TransOperand$j82mBTNvy27bqqDjviVlNMfje_I.INSTANCE);
            right = r1;
            $VALUES = new TransOperand[]{r0, r1};
        }

        private TransOperand(String r3, int r4, BiConsumer r5) {
            BiConsumer<AffineTransform, AffineTransform> r6 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r5, BiConsumer.class, "com.obric.memorydata.plugin");
            super(r3, r4);
            this.fun = r6;
        }

        public static /* synthetic */ void lambda$aZFuPFAordDxlfqZG0d1VW7vDyg(AffineTransform r0, AffineTransform r1) {
            r0.concatenate(r1);
        }

        public static /* synthetic */ void lambda$j82mBTNvy27bqqDjviVlNMfje_I(AffineTransform r0, AffineTransform r1) {
            r0.preConcatenate(r1);
        }

        public static TransOperand valueOf(String r2) {
            return (TransOperand) ZeusTransformUtils.preCheckCast(Enum.valueOf(TransOperand.class, r2), TransOperand.class, "com.obric.memorydata.plugin");
        }

        public static TransOperand[] values() {
            return (TransOperand[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TransOperand[].class, "com.obric.memorydata.plugin");
        }
    }

    public HemfDrawProperties() {
        this.path = null;
        this.usePathBracket = false;
        this.transXForm = new ArrayList();
        this.transOper = new ArrayList();
    }

    public HemfDrawProperties(HemfDrawProperties r6) {
        super(r6);
        Path2D r0 = null;
        this.path = null;
        this.usePathBracket = false;
        ArrayList r1 = new ArrayList();
        this.transXForm = r1;
        ArrayList r2 = new ArrayList();
        this.transOper = r2;
        Path2D r3 = r6.path;
        if (r3 == null) goto L5;
        r0 = (Path2D) ZeusTransformUtils.preCheckCast(r3.clone(), Path2D.class, "com.obric.memorydata.plugin");
    L5:
        this.path = r0;
        this.usePathBracket = r6.usePathBracket;
        this.emfPlusBrushHatch = r6.emfPlusBrushHatch;
        this.clip = r6.clip;
        this.emfPlusImage = r6.emfPlusImage;
        r1.addAll(r6.transXForm);
        r2.addAll(r6.transOper);
        Rectangle2D r4 = r6.brushRect;
        if (r4 == null) goto L9;
        this.brushRect = (Rectangle2D) ZeusTransformUtils.preCheckCast(r4.clone(), Rectangle2D.class, "com.obric.memorydata.plugin");
    L9:
        if (r6.brushColorsV == null) goto L12;
        this.brushColorsV = new ArrayList(r6.brushColorsV);
    L12:
        if (r6.brushColorsH == null) goto L15;
        this.brushColorsH = new ArrayList(r6.brushColorsH);
        return;
    }

    public List<? extends Map.Entry<Float, Color>> getBrushColorsH() {
        return this.brushColorsH;
    }

    public Rectangle2D getBrushRect() {
        return this.brushRect;
    }
}
