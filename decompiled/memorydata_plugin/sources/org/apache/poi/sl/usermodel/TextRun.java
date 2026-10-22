package org.apache.poi.sl.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface TextRun {

    public static final enum FieldType extends Enum<FieldType> {
        private static final /* synthetic */ FieldType[] $VALUES = null;
        public static final FieldType DATE_TIME = null;
        public static final FieldType SLIDE_NUMBER = null;

        static {
            FieldType r0 = new FieldType("SLIDE_NUMBER", 0);
            SLIDE_NUMBER = r0;
            FieldType r1 = new FieldType("DATE_TIME", 1);
            DATE_TIME = r1;
            $VALUES = new FieldType[]{r0, r1};
        }

        private FieldType(String r1, int r2) {
            super(r1, r2);
        }

        public static FieldType valueOf(String r2) {
            return (FieldType) ZeusTransformUtils.preCheckCast(Enum.valueOf(FieldType.class, r2), FieldType.class, "com.obric.memorydata.plugin");
        }

        public static FieldType[] values() {
            return (FieldType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FieldType[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum TextCap extends Enum<TextCap> {
        private static final /* synthetic */ TextCap[] $VALUES = null;
        public static final TextCap ALL = null;
        public static final TextCap NONE = null;
        public static final TextCap SMALL = null;

        static {
            TextCap r0 = new TextCap("NONE", 0);
            NONE = r0;
            TextCap r1 = new TextCap("SMALL", 1);
            SMALL = r1;
            TextCap r3 = new TextCap("ALL", 2);
            ALL = r3;
            $VALUES = new TextCap[]{r0, r1, r3};
        }

        private TextCap(String r1, int r2) {
            super(r1, r2);
        }

        public static TextCap valueOf(String r2) {
            return (TextCap) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextCap.class, r2), TextCap.class, "com.obric.memorydata.plugin");
        }

        public static TextCap[] values() {
            return (TextCap[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextCap[].class, "com.obric.memorydata.plugin");
        }
    }
}
