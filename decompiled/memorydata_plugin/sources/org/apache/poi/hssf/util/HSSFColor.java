package org.apache.poi.hssf.util;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Color;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes7.dex */
public class HSSFColor {
    private static Map<HSSFColorPredefined, HSSFColor> enumList;
    private static Map<Integer, HSSFColor> indexHash;
    private final Color color;
    private final int index;
    private final int index2;

    public static final enum HSSFColorPredefined extends Enum<HSSFColorPredefined> {
        private static final /* synthetic */ HSSFColorPredefined[] $VALUES = null;
        public static final HSSFColorPredefined AQUA = null;
        public static final HSSFColorPredefined AUTOMATIC = null;
        public static final HSSFColorPredefined BLACK = null;
        public static final HSSFColorPredefined BLUE = null;
        public static final HSSFColorPredefined BLUE_GREY = null;
        public static final HSSFColorPredefined BRIGHT_GREEN = null;
        public static final HSSFColorPredefined BROWN = null;
        public static final HSSFColorPredefined CORAL = null;
        public static final HSSFColorPredefined CORNFLOWER_BLUE = null;
        public static final HSSFColorPredefined DARK_BLUE = null;
        public static final HSSFColorPredefined DARK_GREEN = null;
        public static final HSSFColorPredefined DARK_RED = null;
        public static final HSSFColorPredefined DARK_TEAL = null;
        public static final HSSFColorPredefined DARK_YELLOW = null;
        public static final HSSFColorPredefined GOLD = null;
        public static final HSSFColorPredefined GREEN = null;
        public static final HSSFColorPredefined GREY_25_PERCENT = null;
        public static final HSSFColorPredefined GREY_40_PERCENT = null;
        public static final HSSFColorPredefined GREY_50_PERCENT = null;
        public static final HSSFColorPredefined GREY_80_PERCENT = null;
        public static final HSSFColorPredefined INDIGO = null;
        public static final HSSFColorPredefined LAVENDER = null;
        public static final HSSFColorPredefined LEMON_CHIFFON = null;
        public static final HSSFColorPredefined LIGHT_BLUE = null;
        public static final HSSFColorPredefined LIGHT_CORNFLOWER_BLUE = null;
        public static final HSSFColorPredefined LIGHT_GREEN = null;
        public static final HSSFColorPredefined LIGHT_ORANGE = null;
        public static final HSSFColorPredefined LIGHT_TURQUOISE = null;
        public static final HSSFColorPredefined LIGHT_YELLOW = null;
        public static final HSSFColorPredefined LIME = null;
        public static final HSSFColorPredefined MAROON = null;
        public static final HSSFColorPredefined OLIVE_GREEN = null;
        public static final HSSFColorPredefined ORANGE = null;
        public static final HSSFColorPredefined ORCHID = null;
        public static final HSSFColorPredefined PALE_BLUE = null;
        public static final HSSFColorPredefined PINK = null;
        public static final HSSFColorPredefined PLUM = null;
        public static final HSSFColorPredefined RED = null;
        public static final HSSFColorPredefined ROSE = null;
        public static final HSSFColorPredefined ROYAL_BLUE = null;
        public static final HSSFColorPredefined SEA_GREEN = null;
        public static final HSSFColorPredefined SKY_BLUE = null;
        public static final HSSFColorPredefined TAN = null;
        public static final HSSFColorPredefined TEAL = null;
        public static final HSSFColorPredefined TURQUOISE = null;
        public static final HSSFColorPredefined VIOLET = null;
        public static final HSSFColorPredefined WHITE = null;
        public static final HSSFColorPredefined YELLOW = null;
        private final HSSFColor color;

        static {
            HSSFColorPredefined r6 = new HSSFColorPredefined("BLACK", 0, 8, -1, 0);
            BLACK = r6;
            HSSFColorPredefined r0 = new HSSFColorPredefined("BROWN", 1, 60, -1, 10040064);
            BROWN = r0;
            HSSFColorPredefined r1 = new HSSFColorPredefined("OLIVE_GREEN", 2, 59, -1, 3355392);
            OLIVE_GREEN = r1;
            HSSFColorPredefined r2 = new HSSFColorPredefined("DARK_GREEN", 3, 58, -1, 13056);
            DARK_GREEN = r2;
            HSSFColorPredefined r3 = new HSSFColorPredefined("DARK_TEAL", 4, 56, -1, 13158);
            DARK_TEAL = r3;
            HSSFColorPredefined r4 = new HSSFColorPredefined("DARK_BLUE", 5, 18, 32, 128);
            DARK_BLUE = r4;
            HSSFColorPredefined r5 = new HSSFColorPredefined("INDIGO", 6, 62, -1, 3355545);
            INDIGO = r5;
            HSSFColorPredefined r13 = new HSSFColorPredefined("GREY_80_PERCENT", 7, 63, -1, 3355443);
            GREY_80_PERCENT = r13;
            HSSFColorPredefined r7 = new HSSFColorPredefined("ORANGE", 8, 53, -1, 16737792);
            ORANGE = r7;
            HSSFColorPredefined r8 = new HSSFColorPredefined("DARK_YELLOW", 9, 19, -1, 8421376);
            DARK_YELLOW = r8;
            HSSFColorPredefined r9 = new HSSFColorPredefined("GREEN", 10, 17, -1, 32768);
            GREEN = r9;
            HSSFColorPredefined r10 = new HSSFColorPredefined("TEAL", 11, 21, 38, 32896);
            TEAL = r10;
            HSSFColorPredefined r11 = new HSSFColorPredefined("BLUE", 12, 12, 39, 255);
            BLUE = r11;
            HSSFColorPredefined r12 = new HSSFColorPredefined("BLUE_GREY", 13, 54, -1, 6710937);
            BLUE_GREY = r12;
            HSSFColorPredefined r20 = new HSSFColorPredefined("GREY_50_PERCENT", 14, 23, -1, 8421504);
            GREY_50_PERCENT = r20;
            HSSFColorPredefined r14 = new HSSFColorPredefined("RED", 15, 10, -1, 16711680);
            RED = r14;
            HSSFColorPredefined r15 = new HSSFColorPredefined("LIGHT_ORANGE", 16, 52, -1, 16750848);
            LIGHT_ORANGE = r15;
            HSSFColorPredefined r16 = new HSSFColorPredefined("LIME", 17, 50, -1, 10079232);
            LIME = r16;
            HSSFColorPredefined r17 = new HSSFColorPredefined("SEA_GREEN", 18, 57, -1, 3381606);
            SEA_GREEN = r17;
            HSSFColorPredefined r18 = new HSSFColorPredefined("AQUA", 19, 49, -1, 3394764);
            AQUA = r18;
            HSSFColorPredefined r19 = new HSSFColorPredefined("LIGHT_BLUE", 20, 48, -1, 3368703);
            LIGHT_BLUE = r19;
            HSSFColorPredefined r27 = new HSSFColorPredefined("VIOLET", 21, 20, 36, 8388736);
            VIOLET = r27;
            HSSFColorPredefined r21 = new HSSFColorPredefined("GREY_40_PERCENT", 22, 55, -1, 9868950);
            GREY_40_PERCENT = r21;
            HSSFColorPredefined r22 = new HSSFColorPredefined("PINK", 23, 14, 33, 16711935);
            PINK = r22;
            HSSFColorPredefined r23 = new HSSFColorPredefined("GOLD", 24, 51, -1, 16763904);
            GOLD = r23;
            HSSFColorPredefined r24 = new HSSFColorPredefined("YELLOW", 25, 13, 34, 16776960);
            YELLOW = r24;
            HSSFColorPredefined r25 = new HSSFColorPredefined("BRIGHT_GREEN", 26, 11, -1, MotionEventCompat.ACTION_POINTER_INDEX_MASK);
            BRIGHT_GREEN = r25;
            HSSFColorPredefined r26 = new HSSFColorPredefined("TURQUOISE", 27, 15, 35, 65535);
            TURQUOISE = r26;
            HSSFColorPredefined r34 = new HSSFColorPredefined("DARK_RED", 28, 16, 37, 8388608);
            DARK_RED = r34;
            HSSFColorPredefined r28 = new HSSFColorPredefined("SKY_BLUE", 29, 40, -1, 52479);
            SKY_BLUE = r28;
            HSSFColorPredefined r29 = new HSSFColorPredefined("PLUM", 30, 61, 25, 10040166);
            PLUM = r29;
            HSSFColorPredefined r30 = new HSSFColorPredefined("GREY_25_PERCENT", 31, 22, -1, 12632256);
            GREY_25_PERCENT = r30;
            HSSFColorPredefined r31 = new HSSFColorPredefined("ROSE", 32, 45, -1, 16751052);
            ROSE = r31;
            HSSFColorPredefined r32 = new HSSFColorPredefined("LIGHT_YELLOW", 33, 43, -1, 16777113);
            LIGHT_YELLOW = r32;
            HSSFColorPredefined r33 = new HSSFColorPredefined("LIGHT_GREEN", 34, 42, -1, 13434828);
            LIGHT_GREEN = r33;
            HSSFColorPredefined r41 = new HSSFColorPredefined("LIGHT_TURQUOISE", 35, 41, 27, 13434879);
            LIGHT_TURQUOISE = r41;
            HSSFColorPredefined r35 = new HSSFColorPredefined("PALE_BLUE", 36, 44, -1, 10079487);
            PALE_BLUE = r35;
            HSSFColorPredefined r36 = new HSSFColorPredefined("LAVENDER", 37, 46, -1, 13408767);
            LAVENDER = r36;
            HSSFColorPredefined r37 = new HSSFColorPredefined("WHITE", 38, 9, -1, ViewCompat.MEASURED_SIZE_MASK);
            WHITE = r37;
            HSSFColorPredefined r38 = new HSSFColorPredefined("CORNFLOWER_BLUE", 39, 24, -1, 10066431);
            CORNFLOWER_BLUE = r38;
            HSSFColorPredefined r39 = new HSSFColorPredefined("LEMON_CHIFFON", 40, 26, -1, 16777164);
            LEMON_CHIFFON = r39;
            HSSFColorPredefined r40 = new HSSFColorPredefined("MAROON", 41, 25, -1, 8323072);
            MAROON = r40;
            HSSFColorPredefined r48 = new HSSFColorPredefined("ORCHID", 42, 28, -1, 6684774);
            ORCHID = r48;
            HSSFColorPredefined r42 = new HSSFColorPredefined("CORAL", 43, 29, -1, 16744576);
            CORAL = r42;
            HSSFColorPredefined r43 = new HSSFColorPredefined("ROYAL_BLUE", 44, 30, -1, 26316);
            ROYAL_BLUE = r43;
            HSSFColorPredefined r44 = new HSSFColorPredefined("LIGHT_CORNFLOWER_BLUE", 45, 31, -1, 13421823);
            LIGHT_CORNFLOWER_BLUE = r44;
            HSSFColorPredefined r45 = new HSSFColorPredefined("TAN", 46, 47, -1, 16764057);
            TAN = r45;
            HSSFColorPredefined r46 = new HSSFColorPredefined("AUTOMATIC", 47, 64, -1, 0);
            AUTOMATIC = r46;
            $VALUES = new HSSFColorPredefined[]{r6, r0, r1, r2, r3, r4, r5, r13, r7, r8, r9, r10, r11, r12, r20, r14, r15, r16, r17, r18, r19, r27, r21, r22, r23, r24, r25, r26, r34, r28, r29, r30, r31, r32, r33, r41, r35, r36, r37, r38, r39, r40, r48, r42, r43, r44, r45, r46};
        }

        private HSSFColorPredefined(String r1, int r2, int r3, int r4, int r5) {
            super(r1, r2);
            this.color = new HSSFColor(r3, r4, new Color(r5));
        }

        public static HSSFColorPredefined valueOf(String r2) {
            return (HSSFColorPredefined) ZeusTransformUtils.preCheckCast(Enum.valueOf(HSSFColorPredefined.class, r2), HSSFColorPredefined.class, "com.obric.memorydata.plugin");
        }

        public static HSSFColorPredefined[] values() {
            return (HSSFColorPredefined[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HSSFColorPredefined[].class, "com.obric.memorydata.plugin");
        }

        public HSSFColor getColor() {
            return new HSSFColor(getIndex(), getIndex2(), HSSFColor.access$000(this.color));
        }

        public String getHexString() {
            return this.color.getHexString();
        }

        public short getIndex() {
            return this.color.getIndex();
        }

        public short getIndex2() {
            return this.color.getIndex2();
        }

        public short[] getTriplet() {
            return this.color.getTriplet();
        }
    }

    public HSSFColor() {
        this(64, -1, Color.BLACK);
    }

    public HSSFColor(int r3, int r4, Color r5) {
        Color r6 = (Color) ZeusTransformUtils.wrapperContextForParams(r5, Color.class, "com.obric.memorydata.plugin");
        this.index = r3;
        this.index2 = r4;
        this.color = r6;
    }

    static /* synthetic */ Color access$000(HSSFColor r0) {
        return r0.color;
    }

    private static void addHSSFColorPredefined(HSSFColorPredefined r2) {
        enumList.put(r2, r2.getColor());
    }

    private static Map<Integer, HSSFColor> createColorsByIndexMap() {
        Map<HSSFColorPredefined, HSSFColor> r0 = mapEnumToColorClass();
        HashMap r1 = new HashMap((r0.size() * 3) / 2);
        Iterator<Map.Entry<HSSFColorPredefined, HSSFColor>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Integer r4 = Integer.valueOf(((HSSFColorPredefined) ZeusTransformUtils.preCheckCast(r3.getKey(), HSSFColorPredefined.class, "com.obric.memorydata.plugin")).getIndex());
        if (r1.containsKey(r4) == true) goto L8;
        r1.put(r4, r3.getValue());
    L8:
        Integer r5 = Integer.valueOf(((HSSFColorPredefined) ZeusTransformUtils.preCheckCast(r3.getKey(), HSSFColorPredefined.class, "com.obric.memorydata.plugin")).getIndex2());
        if (r5.intValue() == (-1)) goto L4;
        if (r1.containsKey(r5) == true) goto L4;
        r1.put(r5, r3.getValue());
        goto L4
    L13:
        return r1;
    }

    public static synchronized Map<Integer, HSSFColor> getIndexHash() {
        monitor-enter(HSSFColor.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (indexHash != null) goto L7;
        indexHash = Collections.unmodifiableMap(createColorsByIndexMap());     // Catch: Throwable -> L10
    L7:
        Map<Integer, HSSFColor> r1 = indexHash;     // Catch: Throwable -> L10
        monitor-exit(HSSFColor.class);
        return r1;
    }

    private static synchronized Map<HSSFColorPredefined, HSSFColor> mapEnumToColorClass() {
        monitor-enter(HSSFColor.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (enumList != null) goto L7;
        enumList = new EnumMap(HSSFColorPredefined.class);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.BLACK);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.BROWN);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.OLIVE_GREEN);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.DARK_GREEN);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.DARK_TEAL);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.DARK_BLUE);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.INDIGO);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.GREY_80_PERCENT);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.ORANGE);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.DARK_YELLOW);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.GREEN);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.TEAL);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.BLUE);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.BLUE_GREY);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.GREY_50_PERCENT);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.RED);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.LIGHT_ORANGE);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.LIME);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.SEA_GREEN);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.AQUA);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.LIGHT_BLUE);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.VIOLET);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.GREY_40_PERCENT);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.PINK);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.GOLD);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.YELLOW);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.BRIGHT_GREEN);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.TURQUOISE);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.DARK_RED);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.SKY_BLUE);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.PLUM);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.GREY_25_PERCENT);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.ROSE);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.LIGHT_YELLOW);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.LIGHT_GREEN);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.LIGHT_TURQUOISE);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.PALE_BLUE);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.LAVENDER);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.WHITE);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.CORNFLOWER_BLUE);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.LEMON_CHIFFON);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.MAROON);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.ORCHID);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.CORAL);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.ROYAL_BLUE);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.LIGHT_CORNFLOWER_BLUE);     // Catch: Throwable -> L10
        addHSSFColorPredefined(HSSFColorPredefined.TAN);     // Catch: Throwable -> L10
    L7:
        Map<HSSFColorPredefined, HSSFColor> r1 = enumList;     // Catch: Throwable -> L10
        monitor-exit(HSSFColor.class);
        return r1;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L18:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L18;
        HSSFColor r5 = (HSSFColor) ZeusTransformUtils.preCheckCast(r4, HSSFColor.class, "com.obric.memorydata.plugin");
        if (this.index == r5.index) goto L14;
        return false;
    L14:
        if (this.index2 == r5.index2) goto L17;
        return false;
    L17:
        return Objects.equals(this.color, r5.color);
    }

    public String getHexString() {
        return (Integer.toHexString(this.color.getRed() * 257) + ParameterizedMessage.ERROR_MSG_SEPARATOR + Integer.toHexString(this.color.getGreen() * 257) + ParameterizedMessage.ERROR_MSG_SEPARATOR + Integer.toHexString(this.color.getBlue() * 257)).toUpperCase(Locale.ROOT);
    }

    public short getIndex() {
        return (short) this.index;
    }

    public short getIndex2() {
        return (short) this.index2;
    }

    public short[] getTriplet() {
        return new short[]{(short) this.color.getRed(), (short) this.color.getGreen(), (short) this.color.getBlue()};
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.color, Integer.valueOf(this.index), Integer.valueOf(this.index2)});
    }
}
