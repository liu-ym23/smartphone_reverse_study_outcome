package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.sl.usermodel.FreeformShape;
import org.apache.poi.sl.usermodel.ShapeContainer;
import org.apache.poi.sl.usermodel.ShapeType;

/* JADX INFO: loaded from: classes7.dex */
public final class HSLFFreeformShape extends HSLFAutoShape implements FreeformShape<HSLFShape, HSLFTextParagraph> {
    private static final c LOG = null;

    static final enum ShapePath extends Enum<ShapePath> {
        private static final /* synthetic */ ShapePath[] $VALUES = null;
        public static final ShapePath COMPLEX = null;
        public static final ShapePath CURVES = null;
        public static final ShapePath CURVES_CLOSED = null;
        public static final ShapePath LINES = null;
        public static final ShapePath LINES_CLOSED = null;
        private final int flag;

        static {
            ShapePath r0 = new ShapePath("LINES", 0, 0);
            LINES = r0;
            ShapePath r1 = new ShapePath("LINES_CLOSED", 1, 1);
            LINES_CLOSED = r1;
            ShapePath r3 = new ShapePath("CURVES", 2, 2);
            CURVES = r3;
            ShapePath r5 = new ShapePath("CURVES_CLOSED", 3, 3);
            CURVES_CLOSED = r5;
            ShapePath r7 = new ShapePath("COMPLEX", 4, 4);
            COMPLEX = r7;
            $VALUES = new ShapePath[]{r0, r1, r3, r5, r7};
        }

        private ShapePath(String r1, int r2, int r3) {
            super(r1, r2);
            this.flag = r3;
        }

        static ShapePath valueOf(int r5) {
            ShapePath[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            ShapePath r3 = r0[r2];
            if (r3.flag == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static ShapePath valueOf(String r2) {
            return (ShapePath) ZeusTransformUtils.preCheckCast(Enum.valueOf(ShapePath.class, r2), ShapePath.class, "com.obric.memorydata.plugin");
        }

        public static ShapePath[] values() {
            return (ShapePath[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ShapePath[].class, "com.obric.memorydata.plugin");
        }

        public int getFlag() {
            return this.flag;
        }
    }

    static {
        LOG = b.a(HSLFFreeformShape.class);
    }

    public HSLFFreeformShape() {
        this(null);
    }

    public HSLFFreeformShape(EscherContainerRecord r3, ShapeContainer<HSLFShape, HSLFTextParagraph> r4) {
        super(r3, (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r4, ShapeContainer.class, "com.obric.memorydata.plugin"));
    }

    public HSLFFreeformShape(ShapeContainer<HSLFShape, HSLFTextParagraph> r4) {
        ShapeContainer r5 = (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r4, ShapeContainer.class, "com.obric.memorydata.plugin");
        super((EscherContainerRecord) ZeusTransformUtils.preCheckCast(null, EscherContainerRecord.class, "com.obric.memorydata.plugin"), r5);
        createSpContainer(ShapeType.NOT_PRIMITIVE, ZeusTransformUtils.instanceOf(r5, HSLFGroupShape.class));
    }
}
