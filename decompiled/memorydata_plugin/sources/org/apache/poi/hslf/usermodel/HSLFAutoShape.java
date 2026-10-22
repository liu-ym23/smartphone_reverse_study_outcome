package org.apache.poi.hslf.usermodel;

import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.sl.usermodel.AutoShape;
import org.apache.poi.sl.usermodel.ShapeContainer;
import org.apache.poi.sl.usermodel.ShapeType;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;

/* JADX INFO: loaded from: classes7.dex */
public class HSLFAutoShape extends HSLFTextShape implements AutoShape<HSLFShape, HSLFTextParagraph> {
    private static final BitField ESCAPE_INFO = null;
    private static final c LOG = null;
    private static final BitField PATH_INFO = null;
    static final byte[] SEGMENTINFO_CLOSE = null;
    static final byte[] SEGMENTINFO_CUBICTO = null;
    static final byte[] SEGMENTINFO_END = null;
    static final byte[] SEGMENTINFO_ESCAPE = null;
    static final byte[] SEGMENTINFO_ESCAPE2 = null;
    static final byte[] SEGMENTINFO_LINETO = null;
    static final byte[] SEGMENTINFO_MOVETO = null;

    static final enum EscapeInfo extends Enum<EscapeInfo> {
        private static final /* synthetic */ EscapeInfo[] $VALUES = null;
        public static final EscapeInfo ANGLE_ELLIPSE = null;
        public static final EscapeInfo ANGLE_ELLIPSE_TO = null;
        public static final EscapeInfo ARC = null;
        public static final EscapeInfo ARC_TO = null;
        public static final EscapeInfo AUTO_CURVE = null;
        public static final EscapeInfo AUTO_LINE = null;
        public static final EscapeInfo CLOCKWISE_ARC = null;
        public static final EscapeInfo CLOCKWISE_ARC_TO = null;
        public static final EscapeInfo CORNER_CURVE = null;
        public static final EscapeInfo CORNER_LINE = null;
        public static final EscapeInfo ELLIPTICAL_QUADRANT_X = null;
        public static final EscapeInfo ELLIPTICAL_QUADRANT_Y = null;
        public static final EscapeInfo EXTENSION = null;
        public static final EscapeInfo FILL_COLOR = null;
        public static final EscapeInfo FREEFORM = null;
        public static final EscapeInfo LINE_COLOR = null;
        public static final EscapeInfo NO_FILL = null;
        public static final EscapeInfo NO_LINE = null;
        public static final EscapeInfo QUADRATIC_BEZIER = null;
        public static final EscapeInfo SMOOTH_CURVE = null;
        public static final EscapeInfo SMOOTH_LINE = null;
        public static final EscapeInfo SYMMETRIC_CURVE = null;
        public static final EscapeInfo SYMMETRIC_LINE = null;
        private final int flag;

        static {
            EscapeInfo r0 = new EscapeInfo("EXTENSION", 0, 0);
            EXTENSION = r0;
            EscapeInfo r1 = new EscapeInfo("ANGLE_ELLIPSE_TO", 1, 1);
            ANGLE_ELLIPSE_TO = r1;
            EscapeInfo r3 = new EscapeInfo("ANGLE_ELLIPSE", 2, 2);
            ANGLE_ELLIPSE = r3;
            EscapeInfo r5 = new EscapeInfo("ARC_TO", 3, 3);
            ARC_TO = r5;
            EscapeInfo r7 = new EscapeInfo("ARC", 4, 4);
            ARC = r7;
            EscapeInfo r9 = new EscapeInfo("CLOCKWISE_ARC_TO", 5, 5);
            CLOCKWISE_ARC_TO = r9;
            EscapeInfo r11 = new EscapeInfo("CLOCKWISE_ARC", 6, 6);
            CLOCKWISE_ARC = r11;
            EscapeInfo r13 = new EscapeInfo("ELLIPTICAL_QUADRANT_X", 7, 7);
            ELLIPTICAL_QUADRANT_X = r13;
            EscapeInfo r15 = new EscapeInfo("ELLIPTICAL_QUADRANT_Y", 8, 8);
            ELLIPTICAL_QUADRANT_Y = r15;
            EscapeInfo r14 = new EscapeInfo("QUADRATIC_BEZIER", 9, 9);
            QUADRATIC_BEZIER = r14;
            EscapeInfo r12 = new EscapeInfo("NO_FILL", 10, 10);
            NO_FILL = r12;
            EscapeInfo r10 = new EscapeInfo("NO_LINE", 11, 11);
            NO_LINE = r10;
            EscapeInfo r8 = new EscapeInfo("AUTO_LINE", 12, 12);
            AUTO_LINE = r8;
            EscapeInfo r6 = new EscapeInfo("AUTO_CURVE", 13, 13);
            AUTO_CURVE = r6;
            EscapeInfo r4 = new EscapeInfo("CORNER_LINE", 14, 14);
            CORNER_LINE = r4;
            EscapeInfo r2 = new EscapeInfo("CORNER_CURVE", 15, 15);
            CORNER_CURVE = r2;
            EscapeInfo r16 = new EscapeInfo("SMOOTH_LINE", 16, 16);
            SMOOTH_LINE = r16;
            EscapeInfo r17 = new EscapeInfo("SMOOTH_CURVE", 17, 17);
            SMOOTH_CURVE = r17;
            EscapeInfo r18 = new EscapeInfo("SYMMETRIC_LINE", 18, 18);
            SYMMETRIC_LINE = r18;
            EscapeInfo r19 = new EscapeInfo("SYMMETRIC_CURVE", 19, 19);
            SYMMETRIC_CURVE = r19;
            EscapeInfo r20 = new EscapeInfo("FREEFORM", 20, 20);
            FREEFORM = r20;
            EscapeInfo r21 = new EscapeInfo("FILL_COLOR", 21, 21);
            FILL_COLOR = r21;
            EscapeInfo r22 = new EscapeInfo("LINE_COLOR", 22, 22);
            LINE_COLOR = r22;
            $VALUES = new EscapeInfo[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22};
        }

        private EscapeInfo(String r1, int r2, int r3) {
            super(r1, r2);
            this.flag = r3;
        }

        static EscapeInfo valueOf(int r5) {
            EscapeInfo[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EscapeInfo r3 = r0[r2];
            if (r3.flag == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EscapeInfo valueOf(String r2) {
            return (EscapeInfo) ZeusTransformUtils.preCheckCast(Enum.valueOf(EscapeInfo.class, r2), EscapeInfo.class, "com.obric.memorydata.plugin");
        }

        public static EscapeInfo[] values() {
            return (EscapeInfo[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EscapeInfo[].class, "com.obric.memorydata.plugin");
        }

        public int getFlag() {
            return this.flag;
        }
    }

    static final enum PathInfo extends Enum<PathInfo> {
        private static final /* synthetic */ PathInfo[] $VALUES = null;
        public static final PathInfo clientEscape = null;
        public static final PathInfo close = null;
        public static final PathInfo curveTo = null;
        public static final PathInfo end = null;
        public static final PathInfo escape = null;
        public static final PathInfo lineTo = null;
        public static final PathInfo moveTo = null;
        private final int flag;

        static {
            PathInfo r0 = new PathInfo("lineTo", 0, 0);
            lineTo = r0;
            PathInfo r1 = new PathInfo("curveTo", 1, 1);
            curveTo = r1;
            PathInfo r3 = new PathInfo("moveTo", 2, 2);
            moveTo = r3;
            PathInfo r5 = new PathInfo(IslandSession.REOPEN_VALUE_CLOSE, 3, 3);
            close = r5;
            PathInfo r7 = new PathInfo("end", 4, 4);
            end = r7;
            PathInfo r9 = new PathInfo("escape", 5, 5);
            escape = r9;
            PathInfo r11 = new PathInfo("clientEscape", 6, 6);
            clientEscape = r11;
            $VALUES = new PathInfo[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private PathInfo(String r1, int r2, int r3) {
            super(r1, r2);
            this.flag = r3;
        }

        static PathInfo valueOf(int r5) {
            PathInfo[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            PathInfo r3 = r0[r2];
            if (r3.flag == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static PathInfo valueOf(String r2) {
            return (PathInfo) ZeusTransformUtils.preCheckCast(Enum.valueOf(PathInfo.class, r2), PathInfo.class, "com.obric.memorydata.plugin");
        }

        public static PathInfo[] values() {
            return (PathInfo[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PathInfo[].class, "com.obric.memorydata.plugin");
        }

        public int getFlag() {
            return this.flag;
        }
    }

    static {
        LOG = b.a(HSLFAutoShape.class);
        SEGMENTINFO_MOVETO = new byte[]{0, 64};
        SEGMENTINFO_LINETO = new byte[]{0, -84};
        SEGMENTINFO_ESCAPE = new byte[]{1, 0};
        SEGMENTINFO_ESCAPE2 = new byte[]{1, 32};
        SEGMENTINFO_CUBICTO = new byte[]{0, -83};
        SEGMENTINFO_CLOSE = new byte[]{1, 96};
        SEGMENTINFO_END = new byte[]{0, -128};
        PATH_INFO = BitFieldFactory.getInstance(57344);
        ESCAPE_INFO = BitFieldFactory.getInstance(7936);
    }

    public HSLFAutoShape(EscherContainerRecord r3, ShapeContainer<HSLFShape, HSLFTextParagraph> r4) {
        super(r3, (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r4, ShapeContainer.class, "com.obric.memorydata.plugin"));
    }

    public EscherContainerRecord createSpContainer(ShapeType r2, boolean r3) {
        EscherContainerRecord r4 = super.createSpContainer(r3);
        setShapeType(r2);
        setEscherProperty(EscherPropertyTypes.PROTECTION__LOCKAGAINSTGROUPING, 262144);
        setEscherProperty(EscherPropertyTypes.FILL__FILLCOLOR, 134217732);
        setEscherProperty(EscherPropertyTypes.FILL__FILLCOLOR, 134217732);
        setEscherProperty(EscherPropertyTypes.FILL__FILLBACKCOLOR, 134217728);
        setEscherProperty(EscherPropertyTypes.FILL__NOFILLHITTEST, 1048592);
        setEscherProperty(EscherPropertyTypes.LINESTYLE__COLOR, 134217729);
        setEscherProperty(EscherPropertyTypes.LINESTYLE__NOLINEDRAWDASH, 524296);
        setEscherProperty(EscherPropertyTypes.SHADOWSTYLE__COLOR, 134217730);
        return r4;
    }
}
