package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class SlideAtomLayout implements GenericRecord {
    private SlideLayoutType geometry;
    private byte[] placeholderIDs;

    public static final enum SlideLayoutType extends Enum<SlideLayoutType> {
        private static final /* synthetic */ SlideLayoutType[] $VALUES = null;
        public static final SlideLayoutType BIG_OBJECT = null;
        public static final SlideLayoutType BLANK_SLIDE = null;
        public static final SlideLayoutType COLUMN_TWO_ROWS = null;
        public static final SlideLayoutType FOUR_OBJECTS = null;
        public static final SlideLayoutType HANDOUT = null;
        public static final SlideLayoutType MASTER_NOTES = null;
        public static final SlideLayoutType MASTER_SLIDE = null;
        public static final SlideLayoutType MASTER_TITLE = null;
        public static final SlideLayoutType NOTES_TITLE_BODY = null;
        public static final SlideLayoutType TITLE_2_ROW_BOTTOM_2_COLUMN_BODY = null;
        public static final SlideLayoutType TITLE_BODY = null;
        public static final SlideLayoutType TITLE_ONLY = null;
        public static final SlideLayoutType TITLE_SLIDE = null;
        public static final SlideLayoutType TWO_COLUMNS = null;
        public static final SlideLayoutType TWO_COLUMNS_ROW = null;
        public static final SlideLayoutType TWO_ROWS = null;
        public static final SlideLayoutType TWO_ROWS_COLUMN = null;
        public static final SlideLayoutType VERTICAL_TITLE_BODY = null;
        public static final SlideLayoutType VERTICAL_TWO_ROWS = null;
        private int nativeId;

        static {
            SlideLayoutType r0 = new SlideLayoutType("TITLE_SLIDE", 0, 0);
            TITLE_SLIDE = r0;
            SlideLayoutType r1 = new SlideLayoutType("TITLE_BODY", 1, 1);
            TITLE_BODY = r1;
            SlideLayoutType r3 = new SlideLayoutType("MASTER_TITLE", 2, 2);
            MASTER_TITLE = r3;
            SlideLayoutType r5 = new SlideLayoutType("MASTER_SLIDE", 3, 3);
            MASTER_SLIDE = r5;
            SlideLayoutType r7 = new SlideLayoutType("MASTER_NOTES", 4, 4);
            MASTER_NOTES = r7;
            SlideLayoutType r9 = new SlideLayoutType("NOTES_TITLE_BODY", 5, 5);
            NOTES_TITLE_BODY = r9;
            SlideLayoutType r11 = new SlideLayoutType("HANDOUT", 6, 6);
            HANDOUT = r11;
            SlideLayoutType r13 = new SlideLayoutType("TITLE_ONLY", 7, 7);
            TITLE_ONLY = r13;
            SlideLayoutType r15 = new SlideLayoutType("TWO_COLUMNS", 8, 8);
            TWO_COLUMNS = r15;
            SlideLayoutType r14 = new SlideLayoutType("TWO_ROWS", 9, 9);
            TWO_ROWS = r14;
            SlideLayoutType r12 = new SlideLayoutType("COLUMN_TWO_ROWS", 10, 10);
            COLUMN_TWO_ROWS = r12;
            SlideLayoutType r10 = new SlideLayoutType("TWO_ROWS_COLUMN", 11, 11);
            TWO_ROWS_COLUMN = r10;
            SlideLayoutType r8 = new SlideLayoutType("TITLE_2_ROW_BOTTOM_2_COLUMN_BODY", 12, 12);
            TITLE_2_ROW_BOTTOM_2_COLUMN_BODY = r8;
            SlideLayoutType r6 = new SlideLayoutType("TWO_COLUMNS_ROW", 13, 13);
            TWO_COLUMNS_ROW = r6;
            SlideLayoutType r4 = new SlideLayoutType("FOUR_OBJECTS", 14, 14);
            FOUR_OBJECTS = r4;
            SlideLayoutType r2 = new SlideLayoutType("BIG_OBJECT", 15, 15);
            BIG_OBJECT = r2;
            SlideLayoutType r16 = new SlideLayoutType("BLANK_SLIDE", 16, 16);
            BLANK_SLIDE = r16;
            SlideLayoutType r17 = new SlideLayoutType("VERTICAL_TITLE_BODY", 17, 17);
            VERTICAL_TITLE_BODY = r17;
            SlideLayoutType r18 = new SlideLayoutType("VERTICAL_TWO_ROWS", 18, 18);
            VERTICAL_TWO_ROWS = r18;
            $VALUES = new SlideLayoutType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18};
        }

        private SlideLayoutType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeId = r3;
        }

        public static SlideLayoutType forNativeID(int r5) {
            SlideLayoutType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            SlideLayoutType r3 = r0[r2];
            if (r3.nativeId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static SlideLayoutType valueOf(String r2) {
            return (SlideLayoutType) ZeusTransformUtils.preCheckCast(Enum.valueOf(SlideLayoutType.class, r2), SlideLayoutType.class, "com.obric.memorydata.plugin");
        }

        public static SlideLayoutType[] values() {
            return (SlideLayoutType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SlideLayoutType[].class, "com.obric.memorydata.plugin");
        }

        public int getNativeId() {
            return this.nativeId;
        }
    }

    public SlideAtomLayout(byte[] r3) {
        if (r3.length != 12) goto L7;
        this.geometry = SlideLayoutType.forNativeID(LittleEndian.getInt(r3, 0));
        this.placeholderIDs = Arrays.copyOfRange(r3, 4, 12);
        return;
    L7:
        throw new HSLFException("SSlideLayoutAtom created with byte array not 12 bytes long - was " + r3.length + " bytes in size");
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("geometry", new $$Lambda$cw2_cCvGzzIa0YLXXvP7wX6vTEA(this), "placeholderIDs", new $$Lambda$SlideAtomLayout$vtmIlZlqhjV0F3XXg0Gr1kM3LpM(this));
    }

    public SlideLayoutType getGeometryType() {
        return this.geometry;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$SlideAtomLayout() {
        return this.placeholderIDs;
    }

    public void setGeometryType(SlideLayoutType r1) {
        this.geometry = r1;
    }

    public void writeOut(OutputStream r4) {
        byte[] r0 = new byte[4];
        LittleEndian.putInt(r0, 0, this.geometry.getNativeId());
        r4.write(r0);
        r4.write(this.placeholderIDs);
    }
}
