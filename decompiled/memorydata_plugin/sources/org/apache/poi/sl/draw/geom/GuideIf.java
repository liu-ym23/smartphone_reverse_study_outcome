package org.apache.poi.sl.draw.geom;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public interface GuideIf {
    public static final Pattern WHITESPACE = null;

    public static final enum Op extends Enum<Op> {
        private static final /* synthetic */ Op[] $VALUES = null;
        public static final Op abs = null;
        public static final Op adddiv = null;
        public static final Op addsub = null;
        public static final Op at2 = null;
        public static final Op cat2 = null;
        public static final Op cos = null;
        public static final Op ifelse = null;
        public static final Op max = null;
        public static final Op min = null;
        public static final Op mod = null;
        public static final Op muldiv = null;
        public static final Op pin = null;
        public static final Op sat2 = null;
        public static final Op sin = null;
        public static final Op sqrt = null;
        public static final Op tan = null;
        public static final Op val = null;

        static {
            Op r0 = new Op("muldiv", 0);
            muldiv = r0;
            Op r1 = new Op("addsub", 1);
            addsub = r1;
            Op r3 = new Op("adddiv", 2);
            adddiv = r3;
            Op r5 = new Op("ifelse", 3);
            ifelse = r5;
            Op r7 = new Op("val", 4);
            val = r7;
            Op r9 = new Op("abs", 5);
            abs = r9;
            Op r11 = new Op("sqrt", 6);
            sqrt = r11;
            Op r13 = new Op("max", 7);
            max = r13;
            Op r15 = new Op("min", 8);
            min = r15;
            Op r14 = new Op("at2", 9);
            at2 = r14;
            Op r12 = new Op("sin", 10);
            sin = r12;
            Op r10 = new Op("cos", 11);
            cos = r10;
            Op r8 = new Op("tan", 12);
            tan = r8;
            Op r6 = new Op("cat2", 13);
            cat2 = r6;
            Op r4 = new Op("sat2", 14);
            sat2 = r4;
            Op r2 = new Op("pin", 15);
            pin = r2;
            Op r16 = new Op("mod", 16);
            mod = r16;
            $VALUES = new Op[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16};
        }

        private Op(String r1, int r2) {
            super(r1, r2);
        }

        public static Op valueOf(String r2) {
            return (Op) ZeusTransformUtils.preCheckCast(Enum.valueOf(Op.class, r2), Op.class, "com.obric.memorydata.plugin");
        }

        public static Op[] values() {
            return (Op[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Op[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        WHITESPACE = Pattern.compile("\\s+");
    }
}
