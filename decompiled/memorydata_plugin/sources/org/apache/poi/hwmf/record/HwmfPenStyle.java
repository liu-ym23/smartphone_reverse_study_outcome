package org.apache.poi.hwmf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HwmfPenStyle implements GenericRecord {
    protected static final BitField SUBSECTION_ALTERNATE = null;
    protected static final BitField SUBSECTION_DASH = null;
    protected static final BitField SUBSECTION_ENDCAP = null;
    protected static final BitField SUBSECTION_GEOMETRIC = null;
    protected static final BitField SUBSECTION_JOIN = null;
    protected int flag;

    public static final enum HwmfLineCap extends Enum<HwmfLineCap> {
        private static final /* synthetic */ HwmfLineCap[] $VALUES = null;
        public static final HwmfLineCap FLAT = null;
        public static final HwmfLineCap ROUND = null;
        public static final HwmfLineCap SQUARE = null;
        public final int awtFlag;
        public final int wmfFlag;

        static {
            HwmfLineCap r0 = new HwmfLineCap("ROUND", 0, 0, 1);
            ROUND = r0;
            HwmfLineCap r1 = new HwmfLineCap("SQUARE", 1, 1, 2);
            SQUARE = r1;
            HwmfLineCap r4 = new HwmfLineCap("FLAT", 2, 2, 0);
            FLAT = r4;
            $VALUES = new HwmfLineCap[]{r0, r1, r4};
        }

        private HwmfLineCap(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.wmfFlag = r3;
            this.awtFlag = r4;
        }

        static HwmfLineCap valueOf(int r5) {
            HwmfLineCap[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            HwmfLineCap r3 = r0[r2];
            if (r3.wmfFlag == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static HwmfLineCap valueOf(String r2) {
            return (HwmfLineCap) ZeusTransformUtils.preCheckCast(Enum.valueOf(HwmfLineCap.class, r2), HwmfLineCap.class, "com.obric.memorydata.plugin");
        }

        public static HwmfLineCap[] values() {
            return (HwmfLineCap[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HwmfLineCap[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum HwmfLineDash extends Enum<HwmfLineDash> {
        private static final /* synthetic */ HwmfLineDash[] $VALUES = null;
        public static final HwmfLineDash DASH = null;
        public static final HwmfLineDash DASHDOT = null;
        public static final HwmfLineDash DASHDOTDOT = null;
        public static final HwmfLineDash DOT = null;
        public static final HwmfLineDash INSIDEFRAME = null;
        public static final HwmfLineDash NULL = null;
        public static final HwmfLineDash SOLID = null;
        public static final HwmfLineDash USERSTYLE = null;
        public final float[] dashes;
        public final int wmfFlag;

        static {
            HwmfLineDash r0 = new HwmfLineDash("SOLID", 0, 0, null);
            SOLID = r0;
            HwmfLineDash r1 = new HwmfLineDash("DASH", 1, 1, new float[]{10.0f, 8.0f});
            DASH = r1;
            HwmfLineDash r5 = new HwmfLineDash("DOT", 2, 2, new float[]{2.0f, 4.0f});
            DOT = r5;
            HwmfLineDash r6 = new HwmfLineDash("DASHDOT", 3, 3, new float[]{10.0f, 8.0f, 2.0f, 8.0f});
            DASHDOT = r6;
            HwmfLineDash r9 = new HwmfLineDash("DASHDOTDOT", 4, 4, new float[]{10.0f, 4.0f, 2.0f, 4.0f, 2.0f, 4.0f});
            DASHDOTDOT = r9;
            HwmfLineDash r12 = new HwmfLineDash("NULL", 5, 5, null);
            NULL = r12;
            HwmfLineDash r13 = new HwmfLineDash("INSIDEFRAME", 6, 6, null);
            INSIDEFRAME = r13;
            HwmfLineDash r15 = new HwmfLineDash("USERSTYLE", 7, 7, null);
            USERSTYLE = r15;
            $VALUES = new HwmfLineDash[]{r0, r1, r5, r6, r9, r12, r13, r15};
        }

        private HwmfLineDash(String r1, int r2, int r3, float... r4) {
            super(r1, r2);
            this.wmfFlag = r3;
            this.dashes = r4;
        }

        static HwmfLineDash valueOf(int r5) {
            HwmfLineDash[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            HwmfLineDash r3 = r0[r2];
            if (r3.wmfFlag == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static HwmfLineDash valueOf(String r2) {
            return (HwmfLineDash) ZeusTransformUtils.preCheckCast(Enum.valueOf(HwmfLineDash.class, r2), HwmfLineDash.class, "com.obric.memorydata.plugin");
        }

        public static HwmfLineDash[] values() {
            return (HwmfLineDash[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HwmfLineDash[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum HwmfLineJoin extends Enum<HwmfLineJoin> {
        private static final /* synthetic */ HwmfLineJoin[] $VALUES = null;
        public static final HwmfLineJoin BEVEL = null;
        public static final HwmfLineJoin MITER = null;
        public static final HwmfLineJoin ROUND = null;
        public final int awtFlag;
        public final int wmfFlag;

        static {
            HwmfLineJoin r0 = new HwmfLineJoin("ROUND", 0, 0, 1);
            ROUND = r0;
            HwmfLineJoin r1 = new HwmfLineJoin("BEVEL", 1, 1, 2);
            BEVEL = r1;
            HwmfLineJoin r4 = new HwmfLineJoin("MITER", 2, 2, 0);
            MITER = r4;
            $VALUES = new HwmfLineJoin[]{r0, r1, r4};
        }

        private HwmfLineJoin(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.wmfFlag = r3;
            this.awtFlag = r4;
        }

        static HwmfLineJoin valueOf(int r5) {
            HwmfLineJoin[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            HwmfLineJoin r3 = r0[r2];
            if (r3.wmfFlag == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static HwmfLineJoin valueOf(String r2) {
            return (HwmfLineJoin) ZeusTransformUtils.preCheckCast(Enum.valueOf(HwmfLineJoin.class, r2), HwmfLineJoin.class, "com.obric.memorydata.plugin");
        }

        public static HwmfLineJoin[] values() {
            return (HwmfLineJoin[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HwmfLineJoin[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        SUBSECTION_DASH = BitFieldFactory.getInstance(7);
        SUBSECTION_ALTERNATE = BitFieldFactory.getInstance(8);
        SUBSECTION_ENDCAP = BitFieldFactory.getInstance(768);
        SUBSECTION_JOIN = BitFieldFactory.getInstance(12288);
        SUBSECTION_GEOMETRIC = BitFieldFactory.getInstance(65536);
    }

    public HwmfPenStyle(int r1) {
        this.flag = r1;
    }

    public HwmfPenStyle(HwmfPenStyle r1) {
        this.flag = r1.flag;
    }

    public static HwmfPenStyle valueOf(int r1) {
        return new HwmfPenStyle(r1);
    }

    public HwmfPenStyle copy() {
        return new HwmfPenStyle(this);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("lineCap", new $$Lambda$m39i2Vuu1OtelRnPq5eBMGhdy78(this), "lineJoin", new $$Lambda$Z8xV3Pe8n2_mZzJo9vg3k1aHKxU(this), "lineDash", new $$Lambda$1sXLytcdWXdaHhjvfkbFw2X04ts(this), "lineDashes", new $$Lambda$EPuAnc4qcKLuzjmwSNRPaJB_oE(this), "alternateDash", new $$Lambda$34BvkBGPmSmWfn3SpboBENLljc(this), "geometric", new $$Lambda$_SSDC0y9W658Q4D8ij59eB9DbeA(this));
    }

    public HwmfLineCap getLineCap() {
        return HwmfLineCap.valueOf(SUBSECTION_ENDCAP.getValue(this.flag));
    }

    public HwmfLineDash getLineDash() {
        return HwmfLineDash.valueOf(SUBSECTION_DASH.getValue(this.flag));
    }

    public float[] getLineDashes() {
        return getLineDash().dashes;
    }

    public HwmfLineJoin getLineJoin() {
        return HwmfLineJoin.valueOf(SUBSECTION_JOIN.getValue(this.flag));
    }

    public boolean isAlternateDash() {
        return SUBSECTION_ALTERNATE.isSet(this.flag);
    }

    public boolean isGeometric() {
        return SUBSECTION_GEOMETRIC.isSet(this.flag);
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
