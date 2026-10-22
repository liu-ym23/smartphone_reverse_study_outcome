package org.apache.poi.common.usermodel.fonts;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes4.dex */
public class FontHeader implements GenericRecord, FontInfo {
    private static final int[] FLAGS_MASKS = null;
    private static final String[] FLAGS_NAMES = null;
    private static final int[] FSTYPE_MASKS = null;
    private static final String[] FSTYPE_NAMES = null;
    private byte charset;
    private int checkSumAdjustment;
    private int codePageRange1;
    private int codePageRange2;
    private int eotSize;
    private String familyName;
    private int flags;
    private int fontDataSize;
    private int fsType;
    private String fullName;
    private byte italic;
    private int magic;
    private final byte[] panose;
    private String styleName;
    private int unicodeRange1;
    private int unicodeRange2;
    private int unicodeRange3;
    private int unicodeRange4;
    private int version;
    private String versionName;
    private int weight;

    /* JADX INFO: renamed from: org.apache.poi.common.usermodel.fonts.FontHeader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseSerif = null;

        static {
            int[] r0 = new int[PanoseSerif.values().length];
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseSerif = r0;
            r0[PanoseSerif.TRIANGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L36:
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseSerif[PanoseSerif.NORMAL_SANS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L44:
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseSerif[PanoseSerif.OBTUSE_SANS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L56:
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseSerif[PanoseSerif.PERP_SANS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L40:
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseSerif[PanoseSerif.FLARED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L46:
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseSerif[PanoseSerif.ROUNDED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L14:
            int[] r6 = new int[PanoseFamily.values().length];
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily = r6;
            r6[PanoseFamily.ANY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L50:
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily[PanoseFamily.NO_FIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L38:
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily[PanoseFamily.TEXT_DISPLAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L42:
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily[PanoseFamily.DECORATIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L52:
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily[PanoseFamily.SCRIPT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L34:
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily[PanoseFamily.PICTORIAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
            return;
        }
    }

    public static final enum PanoseArmStyle extends Enum<PanoseArmStyle> {
        private static final /* synthetic */ PanoseArmStyle[] $VALUES = null;
        public static final PanoseArmStyle ANY = null;
        public static final PanoseArmStyle BENT_ARMS_DOUBLE_SERIF = null;
        public static final PanoseArmStyle BENT_ARMS_HORZ = null;
        public static final PanoseArmStyle BENT_ARMS_SINGLE_SERIF = null;
        public static final PanoseArmStyle BENT_ARMS_VERT = null;
        public static final PanoseArmStyle BENT_ARMS_WEDGE = null;
        public static final PanoseArmStyle NO_FIT = null;
        public static final PanoseArmStyle STRAIGHT_ARMS_DOUBLE_SERIF = null;
        public static final PanoseArmStyle STRAIGHT_ARMS_HORZ = null;
        public static final PanoseArmStyle STRAIGHT_ARMS_SINGLE_SERIF = null;
        public static final PanoseArmStyle STRAIGHT_ARMS_VERT = null;
        public static final PanoseArmStyle STRAIGHT_ARMS_WEDGE = null;

        static {
            PanoseArmStyle r0 = new PanoseArmStyle("ANY", 0);
            ANY = r0;
            PanoseArmStyle r1 = new PanoseArmStyle("NO_FIT", 1);
            NO_FIT = r1;
            PanoseArmStyle r3 = new PanoseArmStyle("STRAIGHT_ARMS_HORZ", 2);
            STRAIGHT_ARMS_HORZ = r3;
            PanoseArmStyle r5 = new PanoseArmStyle("STRAIGHT_ARMS_WEDGE", 3);
            STRAIGHT_ARMS_WEDGE = r5;
            PanoseArmStyle r7 = new PanoseArmStyle("STRAIGHT_ARMS_VERT", 4);
            STRAIGHT_ARMS_VERT = r7;
            PanoseArmStyle r9 = new PanoseArmStyle("STRAIGHT_ARMS_SINGLE_SERIF", 5);
            STRAIGHT_ARMS_SINGLE_SERIF = r9;
            PanoseArmStyle r11 = new PanoseArmStyle("STRAIGHT_ARMS_DOUBLE_SERIF", 6);
            STRAIGHT_ARMS_DOUBLE_SERIF = r11;
            PanoseArmStyle r13 = new PanoseArmStyle("BENT_ARMS_HORZ", 7);
            BENT_ARMS_HORZ = r13;
            PanoseArmStyle r15 = new PanoseArmStyle("BENT_ARMS_WEDGE", 8);
            BENT_ARMS_WEDGE = r15;
            PanoseArmStyle r14 = new PanoseArmStyle("BENT_ARMS_VERT", 9);
            BENT_ARMS_VERT = r14;
            PanoseArmStyle r12 = new PanoseArmStyle("BENT_ARMS_SINGLE_SERIF", 10);
            BENT_ARMS_SINGLE_SERIF = r12;
            PanoseArmStyle r10 = new PanoseArmStyle("BENT_ARMS_DOUBLE_SERIF", 11);
            BENT_ARMS_DOUBLE_SERIF = r10;
            $VALUES = new PanoseArmStyle[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        }

        private PanoseArmStyle(String r1, int r2) {
            super(r1, r2);
        }

        public static PanoseArmStyle valueOf(String r2) {
            return (PanoseArmStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(PanoseArmStyle.class, r2), PanoseArmStyle.class, "com.obric.memorydata.plugin");
        }

        public static PanoseArmStyle[] values() {
            return (PanoseArmStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PanoseArmStyle[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum PanoseContrast extends Enum<PanoseContrast> {
        private static final /* synthetic */ PanoseContrast[] $VALUES = null;
        public static final PanoseContrast ANY = null;
        public static final PanoseContrast HIGH = null;
        public static final PanoseContrast LOW = null;
        public static final PanoseContrast MEDIUM = null;
        public static final PanoseContrast MEDIUM_HIGH = null;
        public static final PanoseContrast MEDIUM_LOW = null;
        public static final PanoseContrast NONE = null;
        public static final PanoseContrast NO_FIT = null;
        public static final PanoseContrast VERY_HIGH = null;
        public static final PanoseContrast VERY_LOW = null;

        static {
            PanoseContrast r0 = new PanoseContrast("ANY", 0);
            ANY = r0;
            PanoseContrast r1 = new PanoseContrast("NO_FIT", 1);
            NO_FIT = r1;
            PanoseContrast r3 = new PanoseContrast("NONE", 2);
            NONE = r3;
            PanoseContrast r5 = new PanoseContrast("VERY_LOW", 3);
            VERY_LOW = r5;
            PanoseContrast r7 = new PanoseContrast("LOW", 4);
            LOW = r7;
            PanoseContrast r9 = new PanoseContrast("MEDIUM_LOW", 5);
            MEDIUM_LOW = r9;
            PanoseContrast r11 = new PanoseContrast("MEDIUM", 6);
            MEDIUM = r11;
            PanoseContrast r13 = new PanoseContrast("MEDIUM_HIGH", 7);
            MEDIUM_HIGH = r13;
            PanoseContrast r15 = new PanoseContrast("HIGH", 8);
            HIGH = r15;
            PanoseContrast r14 = new PanoseContrast("VERY_HIGH", 9);
            VERY_HIGH = r14;
            $VALUES = new PanoseContrast[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        }

        private PanoseContrast(String r1, int r2) {
            super(r1, r2);
        }

        public static PanoseContrast valueOf(String r2) {
            return (PanoseContrast) ZeusTransformUtils.preCheckCast(Enum.valueOf(PanoseContrast.class, r2), PanoseContrast.class, "com.obric.memorydata.plugin");
        }

        public static PanoseContrast[] values() {
            return (PanoseContrast[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PanoseContrast[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum PanoseFamily extends Enum<PanoseFamily> {
        private static final /* synthetic */ PanoseFamily[] $VALUES = null;
        public static final PanoseFamily ANY = null;
        public static final PanoseFamily DECORATIVE = null;
        public static final PanoseFamily NO_FIT = null;
        public static final PanoseFamily PICTORIAL = null;
        public static final PanoseFamily SCRIPT = null;
        public static final PanoseFamily TEXT_DISPLAY = null;

        static {
            PanoseFamily r0 = new PanoseFamily("ANY", 0);
            ANY = r0;
            PanoseFamily r1 = new PanoseFamily("NO_FIT", 1);
            NO_FIT = r1;
            PanoseFamily r3 = new PanoseFamily("TEXT_DISPLAY", 2);
            TEXT_DISPLAY = r3;
            PanoseFamily r5 = new PanoseFamily("SCRIPT", 3);
            SCRIPT = r5;
            PanoseFamily r7 = new PanoseFamily("DECORATIVE", 4);
            DECORATIVE = r7;
            PanoseFamily r9 = new PanoseFamily("PICTORIAL", 5);
            PICTORIAL = r9;
            $VALUES = new PanoseFamily[]{r0, r1, r3, r5, r7, r9};
        }

        private PanoseFamily(String r1, int r2) {
            super(r1, r2);
        }

        public static PanoseFamily valueOf(String r2) {
            return (PanoseFamily) ZeusTransformUtils.preCheckCast(Enum.valueOf(PanoseFamily.class, r2), PanoseFamily.class, "com.obric.memorydata.plugin");
        }

        public static PanoseFamily[] values() {
            return (PanoseFamily[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PanoseFamily[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum PanoseLetterForm extends Enum<PanoseLetterForm> {
        private static final /* synthetic */ PanoseLetterForm[] $VALUES = null;
        public static final PanoseLetterForm ANY = null;
        public static final PanoseLetterForm NORMAL_BOXED = null;
        public static final PanoseLetterForm NORMAL_CONTACT = null;
        public static final PanoseLetterForm NORMAL_FLATTENED = null;
        public static final PanoseLetterForm NORMAL_OFF_CENTER = null;
        public static final PanoseLetterForm NORMAL_ROUNDED = null;
        public static final PanoseLetterForm NORMAL_SQUARE = null;
        public static final PanoseLetterForm NORMAL_WEIGHTED = null;
        public static final PanoseLetterForm NO_FIT = null;
        public static final PanoseLetterForm OBLIQUE_BOXED = null;
        public static final PanoseLetterForm OBLIQUE_CONTACT = null;
        public static final PanoseLetterForm OBLIQUE_FLATTENED = null;
        public static final PanoseLetterForm OBLIQUE_OFF_CENTER = null;
        public static final PanoseLetterForm OBLIQUE_ROUNDED = null;
        public static final PanoseLetterForm OBLIQUE_SQUARE = null;
        public static final PanoseLetterForm OBLIQUE_WEIGHTED = null;

        static {
            PanoseLetterForm r0 = new PanoseLetterForm("ANY", 0);
            ANY = r0;
            PanoseLetterForm r1 = new PanoseLetterForm("NO_FIT", 1);
            NO_FIT = r1;
            PanoseLetterForm r3 = new PanoseLetterForm("NORMAL_CONTACT", 2);
            NORMAL_CONTACT = r3;
            PanoseLetterForm r5 = new PanoseLetterForm("NORMAL_WEIGHTED", 3);
            NORMAL_WEIGHTED = r5;
            PanoseLetterForm r7 = new PanoseLetterForm("NORMAL_BOXED", 4);
            NORMAL_BOXED = r7;
            PanoseLetterForm r9 = new PanoseLetterForm("NORMAL_FLATTENED", 5);
            NORMAL_FLATTENED = r9;
            PanoseLetterForm r11 = new PanoseLetterForm("NORMAL_ROUNDED", 6);
            NORMAL_ROUNDED = r11;
            PanoseLetterForm r13 = new PanoseLetterForm("NORMAL_OFF_CENTER", 7);
            NORMAL_OFF_CENTER = r13;
            PanoseLetterForm r15 = new PanoseLetterForm("NORMAL_SQUARE", 8);
            NORMAL_SQUARE = r15;
            PanoseLetterForm r14 = new PanoseLetterForm("OBLIQUE_CONTACT", 9);
            OBLIQUE_CONTACT = r14;
            PanoseLetterForm r12 = new PanoseLetterForm("OBLIQUE_WEIGHTED", 10);
            OBLIQUE_WEIGHTED = r12;
            PanoseLetterForm r10 = new PanoseLetterForm("OBLIQUE_BOXED", 11);
            OBLIQUE_BOXED = r10;
            PanoseLetterForm r8 = new PanoseLetterForm("OBLIQUE_FLATTENED", 12);
            OBLIQUE_FLATTENED = r8;
            PanoseLetterForm r6 = new PanoseLetterForm("OBLIQUE_ROUNDED", 13);
            OBLIQUE_ROUNDED = r6;
            PanoseLetterForm r4 = new PanoseLetterForm("OBLIQUE_OFF_CENTER", 14);
            OBLIQUE_OFF_CENTER = r4;
            PanoseLetterForm r2 = new PanoseLetterForm("OBLIQUE_SQUARE", 15);
            OBLIQUE_SQUARE = r2;
            $VALUES = new PanoseLetterForm[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2};
        }

        private PanoseLetterForm(String r1, int r2) {
            super(r1, r2);
        }

        public static PanoseLetterForm valueOf(String r2) {
            return (PanoseLetterForm) ZeusTransformUtils.preCheckCast(Enum.valueOf(PanoseLetterForm.class, r2), PanoseLetterForm.class, "com.obric.memorydata.plugin");
        }

        public static PanoseLetterForm[] values() {
            return (PanoseLetterForm[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PanoseLetterForm[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum PanoseMidLine extends Enum<PanoseMidLine> {
        private static final /* synthetic */ PanoseMidLine[] $VALUES = null;
        public static final PanoseMidLine ANY = null;
        public static final PanoseMidLine CONSTANT_POINTED = null;
        public static final PanoseMidLine CONSTANT_SERIFED = null;
        public static final PanoseMidLine CONSTANT_TRIMMED = null;
        public static final PanoseMidLine HIGH_POINTED = null;
        public static final PanoseMidLine HIGH_SERIFED = null;
        public static final PanoseMidLine HIGH_TRIMMED = null;
        public static final PanoseMidLine LOW_POINTED = null;
        public static final PanoseMidLine LOW_SERIFED = null;
        public static final PanoseMidLine LOW_TRIMMED = null;
        public static final PanoseMidLine NO_FIT = null;
        public static final PanoseMidLine STANDARD_POINTED = null;
        public static final PanoseMidLine STANDARD_SERIFED = null;
        public static final PanoseMidLine STANDARD_TRIMMED = null;

        static {
            PanoseMidLine r0 = new PanoseMidLine("ANY", 0);
            ANY = r0;
            PanoseMidLine r1 = new PanoseMidLine("NO_FIT", 1);
            NO_FIT = r1;
            PanoseMidLine r3 = new PanoseMidLine("STANDARD_TRIMMED", 2);
            STANDARD_TRIMMED = r3;
            PanoseMidLine r5 = new PanoseMidLine("STANDARD_POINTED", 3);
            STANDARD_POINTED = r5;
            PanoseMidLine r7 = new PanoseMidLine("STANDARD_SERIFED", 4);
            STANDARD_SERIFED = r7;
            PanoseMidLine r9 = new PanoseMidLine("HIGH_TRIMMED", 5);
            HIGH_TRIMMED = r9;
            PanoseMidLine r11 = new PanoseMidLine("HIGH_POINTED", 6);
            HIGH_POINTED = r11;
            PanoseMidLine r13 = new PanoseMidLine("HIGH_SERIFED", 7);
            HIGH_SERIFED = r13;
            PanoseMidLine r15 = new PanoseMidLine("CONSTANT_TRIMMED", 8);
            CONSTANT_TRIMMED = r15;
            PanoseMidLine r14 = new PanoseMidLine("CONSTANT_POINTED", 9);
            CONSTANT_POINTED = r14;
            PanoseMidLine r12 = new PanoseMidLine("CONSTANT_SERIFED", 10);
            CONSTANT_SERIFED = r12;
            PanoseMidLine r10 = new PanoseMidLine("LOW_TRIMMED", 11);
            LOW_TRIMMED = r10;
            PanoseMidLine r8 = new PanoseMidLine("LOW_POINTED", 12);
            LOW_POINTED = r8;
            PanoseMidLine r6 = new PanoseMidLine("LOW_SERIFED", 13);
            LOW_SERIFED = r6;
            $VALUES = new PanoseMidLine[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6};
        }

        private PanoseMidLine(String r1, int r2) {
            super(r1, r2);
        }

        public static PanoseMidLine valueOf(String r2) {
            return (PanoseMidLine) ZeusTransformUtils.preCheckCast(Enum.valueOf(PanoseMidLine.class, r2), PanoseMidLine.class, "com.obric.memorydata.plugin");
        }

        public static PanoseMidLine[] values() {
            return (PanoseMidLine[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PanoseMidLine[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum PanoseProportion extends Enum<PanoseProportion> {
        private static final /* synthetic */ PanoseProportion[] $VALUES = null;
        public static final PanoseProportion ANY = null;
        public static final PanoseProportion CONDENSED = null;
        public static final PanoseProportion EVEN_WIDTH = null;
        public static final PanoseProportion EXPANDED = null;
        public static final PanoseProportion MODERN = null;
        public static final PanoseProportion MONOSPACED = null;
        public static final PanoseProportion NO_FIT = null;
        public static final PanoseProportion OLD_STYLE = null;
        public static final PanoseProportion VERY_CONDENSED = null;
        public static final PanoseProportion VERY_EXPANDED = null;

        static {
            PanoseProportion r0 = new PanoseProportion("ANY", 0);
            ANY = r0;
            PanoseProportion r1 = new PanoseProportion("NO_FIT", 1);
            NO_FIT = r1;
            PanoseProportion r3 = new PanoseProportion("OLD_STYLE", 2);
            OLD_STYLE = r3;
            PanoseProportion r5 = new PanoseProportion("MODERN", 3);
            MODERN = r5;
            PanoseProportion r7 = new PanoseProportion("EVEN_WIDTH", 4);
            EVEN_WIDTH = r7;
            PanoseProportion r9 = new PanoseProportion("EXPANDED", 5);
            EXPANDED = r9;
            PanoseProportion r11 = new PanoseProportion("CONDENSED", 6);
            CONDENSED = r11;
            PanoseProportion r13 = new PanoseProportion("VERY_EXPANDED", 7);
            VERY_EXPANDED = r13;
            PanoseProportion r15 = new PanoseProportion("VERY_CONDENSED", 8);
            VERY_CONDENSED = r15;
            PanoseProportion r14 = new PanoseProportion("MONOSPACED", 9);
            MONOSPACED = r14;
            $VALUES = new PanoseProportion[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        }

        private PanoseProportion(String r1, int r2) {
            super(r1, r2);
        }

        public static PanoseProportion valueOf(String r2) {
            return (PanoseProportion) ZeusTransformUtils.preCheckCast(Enum.valueOf(PanoseProportion.class, r2), PanoseProportion.class, "com.obric.memorydata.plugin");
        }

        public static PanoseProportion[] values() {
            return (PanoseProportion[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PanoseProportion[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum PanoseSerif extends Enum<PanoseSerif> {
        private static final /* synthetic */ PanoseSerif[] $VALUES = null;
        public static final PanoseSerif ANY = null;
        public static final PanoseSerif BONE = null;
        public static final PanoseSerif COVE = null;
        public static final PanoseSerif EXAGGERATED = null;
        public static final PanoseSerif FLARED = null;
        public static final PanoseSerif NORMAL_SANS = null;
        public static final PanoseSerif NO_FIT = null;
        public static final PanoseSerif OBTUSE_COVE = null;
        public static final PanoseSerif OBTUSE_SANS = null;
        public static final PanoseSerif OBTUSE_SQUARE_COVE = null;
        public static final PanoseSerif PERP_SANS = null;
        public static final PanoseSerif ROUNDED = null;
        public static final PanoseSerif SQUARE = null;
        public static final PanoseSerif SQUARE_COVE = null;
        public static final PanoseSerif THIN = null;
        public static final PanoseSerif TRIANGLE = null;

        static {
            PanoseSerif r0 = new PanoseSerif("ANY", 0);
            ANY = r0;
            PanoseSerif r1 = new PanoseSerif("NO_FIT", 1);
            NO_FIT = r1;
            PanoseSerif r3 = new PanoseSerif("COVE", 2);
            COVE = r3;
            PanoseSerif r5 = new PanoseSerif("OBTUSE_COVE", 3);
            OBTUSE_COVE = r5;
            PanoseSerif r7 = new PanoseSerif("SQUARE_COVE", 4);
            SQUARE_COVE = r7;
            PanoseSerif r9 = new PanoseSerif("OBTUSE_SQUARE_COVE", 5);
            OBTUSE_SQUARE_COVE = r9;
            PanoseSerif r11 = new PanoseSerif("SQUARE", 6);
            SQUARE = r11;
            PanoseSerif r13 = new PanoseSerif("THIN", 7);
            THIN = r13;
            PanoseSerif r15 = new PanoseSerif("BONE", 8);
            BONE = r15;
            PanoseSerif r14 = new PanoseSerif("EXAGGERATED", 9);
            EXAGGERATED = r14;
            PanoseSerif r12 = new PanoseSerif("TRIANGLE", 10);
            TRIANGLE = r12;
            PanoseSerif r10 = new PanoseSerif("NORMAL_SANS", 11);
            NORMAL_SANS = r10;
            PanoseSerif r8 = new PanoseSerif("OBTUSE_SANS", 12);
            OBTUSE_SANS = r8;
            PanoseSerif r6 = new PanoseSerif("PERP_SANS", 13);
            PERP_SANS = r6;
            PanoseSerif r4 = new PanoseSerif("FLARED", 14);
            FLARED = r4;
            PanoseSerif r2 = new PanoseSerif("ROUNDED", 15);
            ROUNDED = r2;
            $VALUES = new PanoseSerif[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2};
        }

        private PanoseSerif(String r1, int r2) {
            super(r1, r2);
        }

        public static PanoseSerif valueOf(String r2) {
            return (PanoseSerif) ZeusTransformUtils.preCheckCast(Enum.valueOf(PanoseSerif.class, r2), PanoseSerif.class, "com.obric.memorydata.plugin");
        }

        public static PanoseSerif[] values() {
            return (PanoseSerif[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PanoseSerif[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum PanoseStroke extends Enum<PanoseStroke> {
        private static final /* synthetic */ PanoseStroke[] $VALUES = null;
        public static final PanoseStroke ANY = null;
        public static final PanoseStroke GRADUAL_DIAG = null;
        public static final PanoseStroke GRADUAL_HORZ = null;
        public static final PanoseStroke GRADUAL_TRAN = null;
        public static final PanoseStroke GRADUAL_VERT = null;
        public static final PanoseStroke INSTANT_VERT = null;
        public static final PanoseStroke NO_FIT = null;
        public static final PanoseStroke RAPID_HORZ = null;
        public static final PanoseStroke RAPID_VERT = null;

        static {
            PanoseStroke r0 = new PanoseStroke("ANY", 0);
            ANY = r0;
            PanoseStroke r1 = new PanoseStroke("NO_FIT", 1);
            NO_FIT = r1;
            PanoseStroke r3 = new PanoseStroke("GRADUAL_DIAG", 2);
            GRADUAL_DIAG = r3;
            PanoseStroke r5 = new PanoseStroke("GRADUAL_TRAN", 3);
            GRADUAL_TRAN = r5;
            PanoseStroke r7 = new PanoseStroke("GRADUAL_VERT", 4);
            GRADUAL_VERT = r7;
            PanoseStroke r9 = new PanoseStroke("GRADUAL_HORZ", 5);
            GRADUAL_HORZ = r9;
            PanoseStroke r11 = new PanoseStroke("RAPID_VERT", 6);
            RAPID_VERT = r11;
            PanoseStroke r13 = new PanoseStroke("RAPID_HORZ", 7);
            RAPID_HORZ = r13;
            PanoseStroke r15 = new PanoseStroke("INSTANT_VERT", 8);
            INSTANT_VERT = r15;
            $VALUES = new PanoseStroke[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
        }

        private PanoseStroke(String r1, int r2) {
            super(r1, r2);
        }

        public static PanoseStroke valueOf(String r2) {
            return (PanoseStroke) ZeusTransformUtils.preCheckCast(Enum.valueOf(PanoseStroke.class, r2), PanoseStroke.class, "com.obric.memorydata.plugin");
        }

        public static PanoseStroke[] values() {
            return (PanoseStroke[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PanoseStroke[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum PanoseWeight extends Enum<PanoseWeight> {
        private static final /* synthetic */ PanoseWeight[] $VALUES = null;
        public static final PanoseWeight ANY = null;
        public static final PanoseWeight BLACK = null;
        public static final PanoseWeight BOLD = null;
        public static final PanoseWeight BOOK = null;
        public static final PanoseWeight DEMI = null;
        public static final PanoseWeight HEAVY = null;
        public static final PanoseWeight LIGHT = null;
        public static final PanoseWeight MEDIUM = null;
        public static final PanoseWeight NORD = null;
        public static final PanoseWeight NO_FIT = null;
        public static final PanoseWeight THIN = null;
        public static final PanoseWeight VERY_LIGHT = null;

        static {
            PanoseWeight r0 = new PanoseWeight("ANY", 0);
            ANY = r0;
            PanoseWeight r1 = new PanoseWeight("NO_FIT", 1);
            NO_FIT = r1;
            PanoseWeight r3 = new PanoseWeight("VERY_LIGHT", 2);
            VERY_LIGHT = r3;
            PanoseWeight r5 = new PanoseWeight("LIGHT", 3);
            LIGHT = r5;
            PanoseWeight r7 = new PanoseWeight("THIN", 4);
            THIN = r7;
            PanoseWeight r9 = new PanoseWeight("BOOK", 5);
            BOOK = r9;
            PanoseWeight r11 = new PanoseWeight("MEDIUM", 6);
            MEDIUM = r11;
            PanoseWeight r13 = new PanoseWeight("DEMI", 7);
            DEMI = r13;
            PanoseWeight r15 = new PanoseWeight("BOLD", 8);
            BOLD = r15;
            PanoseWeight r14 = new PanoseWeight("HEAVY", 9);
            HEAVY = r14;
            PanoseWeight r12 = new PanoseWeight("BLACK", 10);
            BLACK = r12;
            PanoseWeight r10 = new PanoseWeight("NORD", 11);
            NORD = r10;
            $VALUES = new PanoseWeight[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        }

        private PanoseWeight(String r1, int r2) {
            super(r1, r2);
        }

        public static PanoseWeight valueOf(String r2) {
            return (PanoseWeight) ZeusTransformUtils.preCheckCast(Enum.valueOf(PanoseWeight.class, r2), PanoseWeight.class, "com.obric.memorydata.plugin");
        }

        public static PanoseWeight[] values() {
            return (PanoseWeight[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PanoseWeight[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum PanoseXHeight extends Enum<PanoseXHeight> {
        private static final /* synthetic */ PanoseXHeight[] $VALUES = null;
        public static final PanoseXHeight ANY = null;
        public static final PanoseXHeight CONSTANT_LARGE = null;
        public static final PanoseXHeight CONSTANT_SMALL = null;
        public static final PanoseXHeight CONSTANT_STD = null;
        public static final PanoseXHeight DUCKING_LARGE = null;
        public static final PanoseXHeight DUCKING_SMALL = null;
        public static final PanoseXHeight DUCKING_STD = null;
        public static final PanoseXHeight NO_FIT = null;

        static {
            PanoseXHeight r0 = new PanoseXHeight("ANY", 0);
            ANY = r0;
            PanoseXHeight r1 = new PanoseXHeight("NO_FIT", 1);
            NO_FIT = r1;
            PanoseXHeight r3 = new PanoseXHeight("CONSTANT_SMALL", 2);
            CONSTANT_SMALL = r3;
            PanoseXHeight r5 = new PanoseXHeight("CONSTANT_STD", 3);
            CONSTANT_STD = r5;
            PanoseXHeight r7 = new PanoseXHeight("CONSTANT_LARGE", 4);
            CONSTANT_LARGE = r7;
            PanoseXHeight r9 = new PanoseXHeight("DUCKING_SMALL", 5);
            DUCKING_SMALL = r9;
            PanoseXHeight r11 = new PanoseXHeight("DUCKING_STD", 6);
            DUCKING_STD = r11;
            PanoseXHeight r13 = new PanoseXHeight("DUCKING_LARGE", 7);
            DUCKING_LARGE = r13;
            $VALUES = new PanoseXHeight[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private PanoseXHeight(String r1, int r2) {
            super(r1, r2);
        }

        public static PanoseXHeight valueOf(String r2) {
            return (PanoseXHeight) ZeusTransformUtils.preCheckCast(Enum.valueOf(PanoseXHeight.class, r2), PanoseXHeight.class, "com.obric.memorydata.plugin");
        }

        public static PanoseXHeight[] values() {
            return (PanoseXHeight[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PanoseXHeight[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        FLAGS_MASKS = new int[]{1, 4, 16, 32, 64, 128, SQLiteDatabase.CREATE_IF_NECESSARY};
        FLAGS_NAMES = new String[]{"SUBSET", "TTCOMPRESSED", "FAILIFVARIATIONSIMULATED", "EMBEDEUDC", "VALIDATIONTESTS", "WEBOBJECT", "XORENCRYPTDATA"};
        FSTYPE_MASKS = new int[]{0, 2, 4, 8, 256, 512};
        FSTYPE_NAMES = new String[]{"INSTALLABLE_EMBEDDING", "RESTRICTED_LICENSE_EMBEDDING", "PREVIEW_PRINT_EMBEDDING", "EDITABLE_EMBEDDING", "NO_SUBSETTING", "BITMAP_EMBEDDING_ONLY"};
    }

    public FontHeader() {
        this.panose = new byte[10];
    }

    private String readName(LittleEndianInput r4) {
        LittleEndianInput r3 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r4, LittleEndianInput.class, "com.obric.memorydata.plugin");
        r3.readShort();
        int r5 = r3.readUShort();
        byte[] r0 = IOUtils.safelyAllocate(r5, 1000);
        r3.readFully(r0);
        return new String(r0, 0, r5, StandardCharsets.UTF_16LE).trim();
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontCharset getCharset() {
        return FontCharset.valueOf(getCharsetByte());
    }

    public byte getCharsetByte() {
        return this.charset;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontFamily getFamily() {
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily[getPanoseFamily().ordinal()];
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L25;
        if (r0 == 3) goto L19;
        if (r0 == 5) goto L17;
        if (r0 == 6) goto L15;
        return FontFamily.FF_DECORATIVE;
    L15:
        return FontFamily.FF_MODERN;
    L17:
        return FontFamily.FF_SCRIPT;
    L19:
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseSerif[getPanoseSerif().ordinal()]) {
            case 1: goto L23;
            case 2: goto L23;
            case 3: goto L23;
            case 4: goto L23;
            case 5: goto L23;
            case 6: goto L23;
            default: goto L21;
        };
    L21:
        return FontFamily.FF_ROMAN;
    L23:
        return FontFamily.FF_SWISS;
    L25:
        return FontFamily.FF_DONTCARE;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public int getFlags() {
        return this.flags;
    }

    public String getFullName() {
        return this.fullName;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("eotSize", new $$Lambda$FontHeader$nmpwci18XSU30UcMv7nsY4a74rI(this));
        r0.put("fontDataSize", new $$Lambda$FontHeader$oq7dGPrPhxXWtPULg5BbDWicJXs(this));
        r0.put("version", new $$Lambda$FontHeader$dilOzT_iUsU1fbD0ygtJpiY0ro(this));
        r0.put("flags", GenericRecordUtil.getBitsAsString(new $$Lambda$4iX1SCFZMpg3cHeCWvln9Hyy7M(this), FLAGS_MASKS, FLAGS_NAMES));
        r0.put("panose.familyType", new $$Lambda$vVZw6u_dNBty5LvB_7Mxah5Ffc4(this));
        r0.put("panose.serifType", new $$Lambda$apcWIUYGkYzgok9zvdB71w4fck(this));
        r0.put("panose.weight", new $$Lambda$hvnLigvXv254Bmzq0Gyvl3DPtw(this));
        r0.put("panose.proportion", new $$Lambda$sI3diiBW4XrkZigS5laSGkwLhNk(this));
        r0.put("panose.contrast", new $$Lambda$aSthwYwAW6x62xnfJUOqDzsrFDw(this));
        r0.put("panose.stroke", new $$Lambda$5noLulXsxQLqArXUFsn8P5j5Um4(this));
        r0.put("panose.armStyle", new $$Lambda$N3cTCc01pKwB_uqB6XGIjoCmx_E(this));
        r0.put("panose.letterForm", new $$Lambda$Ix6jMLUbmqga4izMzk__FXpSRKM(this));
        r0.put("panose.midLine", new $$Lambda$b2qjJ3eNf55bIpJfvwgT3cZRyQ(this));
        r0.put("panose.xHeight", new $$Lambda$5k1RbjAAtd475cSgfdjdub7Q4Y(this));
        r0.put("charset", new $$Lambda$ER88ZQS6sLoI6MtiRDvvWlTcER8(this));
        r0.put("italic", new $$Lambda$VtRxli_O3TA06GxRdRBX3ElvMMg(this));
        r0.put("weight", new $$Lambda$CaNWHikAkxQt3XQBuhcFMCPU384(this));
        r0.put("fsType", GenericRecordUtil.getBitsAsString(new $$Lambda$FontHeader$7bnhmjOG3yDdea0GzSeL45vduBc(this), FSTYPE_MASKS, FSTYPE_NAMES));
        r0.put("unicodeRange1", new $$Lambda$FontHeader$CnPNZA1CIQX5uKZSlGx325bplGI(this));
        r0.put("unicodeRange2", new $$Lambda$FontHeader$PXhFqr0JU7BAITbp8ufzSqrjPl0(this));
        r0.put("unicodeRange3", new $$Lambda$FontHeader$unuz4fJ3dsrS44vNMmpgh3RFynw(this));
        r0.put("unicodeRange4", new $$Lambda$FontHeader$Yy2J1qnujOPaPzJ4wYO4I14u58(this));
        r0.put("codePageRange1", new $$Lambda$FontHeader$wXjNrBduVkQeyP4RkMwyeBAQ5vI(this));
        r0.put("codePageRange2", new $$Lambda$FontHeader$YLjQCb6tKVacgsEOVFraMQnXDY(this));
        r0.put("checkSumAdjustment", new $$Lambda$FontHeader$Zkz3m18Zf2E5uq7GUnJB2cbX0jo(this));
        r0.put("familyName", new $$Lambda$M6eb4_q6C4pEPyMIp9L7cbetSEM(this));
        r0.put("styleName", new $$Lambda$YT3zbHwzgtEUnncwSuAhwwJHzPM(this));
        r0.put("versionName", new $$Lambda$02mcvEjEQvhrJ_CeAiDbFArMPQo(this));
        r0.put("fullName", new $$Lambda$Ul0X91dsPtUrhJt566fUviH2_2U(this));
        return Collections.unmodifiableMap(r0);
    }

    public PanoseArmStyle getPanoseArmStyle() {
        return (PanoseArmStyle) ZeusTransformUtils.preCheckCast(GenericRecordUtil.safeEnum(PanoseArmStyle.values(), new $$Lambda$FontHeader$n7Dw2hvq1TXFmfPuqCBm56Z_9jA(this)).get(), PanoseArmStyle.class, "com.obric.memorydata.plugin");
    }

    public PanoseContrast getPanoseContrast() {
        return (PanoseContrast) ZeusTransformUtils.preCheckCast(GenericRecordUtil.safeEnum(PanoseContrast.values(), new $$Lambda$FontHeader$lCZyh0SHxDkPhHLEWGlfkFYAwOo(this)).get(), PanoseContrast.class, "com.obric.memorydata.plugin");
    }

    public PanoseFamily getPanoseFamily() {
        return (PanoseFamily) ZeusTransformUtils.preCheckCast(GenericRecordUtil.safeEnum(PanoseFamily.values(), new $$Lambda$FontHeader$OTUl30tGoj06TX6NHD3DDlqrfF8(this)).get(), PanoseFamily.class, "com.obric.memorydata.plugin");
    }

    public PanoseLetterForm getPanoseLetterForm() {
        return (PanoseLetterForm) ZeusTransformUtils.preCheckCast(GenericRecordUtil.safeEnum(PanoseLetterForm.values(), new $$Lambda$FontHeader$UVbjCjcTFzuwJtCaevVof1HmGwg(this)).get(), PanoseLetterForm.class, "com.obric.memorydata.plugin");
    }

    public PanoseMidLine getPanoseMidLine() {
        return (PanoseMidLine) ZeusTransformUtils.preCheckCast(GenericRecordUtil.safeEnum(PanoseMidLine.values(), new $$Lambda$FontHeader$gOKZ38TaFGbpK09mKi0Nr3vADkU(this)).get(), PanoseMidLine.class, "com.obric.memorydata.plugin");
    }

    public PanoseProportion getPanoseProportion() {
        return (PanoseProportion) ZeusTransformUtils.preCheckCast(GenericRecordUtil.safeEnum(PanoseProportion.values(), new $$Lambda$FontHeader$wPaB4vyYkGyTUhKsQQj1wFjdaQc(this)).get(), PanoseProportion.class, "com.obric.memorydata.plugin");
    }

    public PanoseSerif getPanoseSerif() {
        return (PanoseSerif) ZeusTransformUtils.preCheckCast(GenericRecordUtil.safeEnum(PanoseSerif.values(), new $$Lambda$FontHeader$dx6YsFsqf7YNNZBxYM6RHTLdE0I(this)).get(), PanoseSerif.class, "com.obric.memorydata.plugin");
    }

    public PanoseStroke getPanoseStroke() {
        return (PanoseStroke) ZeusTransformUtils.preCheckCast(GenericRecordUtil.safeEnum(PanoseStroke.values(), new $$Lambda$FontHeader$fCHoLe2uWLZ0BCXzHzXNBjluZnM(this)).get(), PanoseStroke.class, "com.obric.memorydata.plugin");
    }

    public PanoseWeight getPanoseWeight() {
        return (PanoseWeight) ZeusTransformUtils.preCheckCast(GenericRecordUtil.safeEnum(PanoseWeight.values(), new $$Lambda$FontHeader$hObed_IIpriTybRHw2bMig21LM(this)).get(), PanoseWeight.class, "com.obric.memorydata.plugin");
    }

    public PanoseXHeight getPanoseXHeight() {
        return (PanoseXHeight) ZeusTransformUtils.preCheckCast(GenericRecordUtil.safeEnum(PanoseXHeight.values(), new $$Lambda$FontHeader$PeLRWn2noQbT1KyOgF9777M0w(this)).get(), PanoseXHeight.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontPitch getPitch() {
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily[getPanoseFamily().ordinal()];
        if (r0 == 3) goto L18;
        if (r0 == 4) goto L18;
        if (r0 == 5) goto L13;
        if (r0 == 6) goto L13;
        return FontPitch.VARIABLE;
    L13:
        if (getPanoseProportion() != PanoseProportion.MODERN) goto L16;
        return FontPitch.FIXED;
    L16:
        return FontPitch.VARIABLE;
    L18:
        if (getPanoseProportion() != PanoseProportion.MONOSPACED) goto L21;
        return FontPitch.FIXED;
    L21:
        return FontPitch.VARIABLE;
    }

    public String getStyleName() {
        return this.styleName;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public String getTypeface() {
        return getFamilyName();
    }

    public String getVersionName() {
        return this.versionName;
    }

    public int getWeight() {
        return this.weight;
    }

    public void init(LittleEndianInput r4) {
        LittleEndianInput r5 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r4, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this.eotSize = r5.readInt();
        this.fontDataSize = r5.readInt();
        int r0 = r5.readInt();
        this.version = r0;
        if (r0 != 65536) goto L5;
    L11:
        this.flags = r5.readInt();
        r5.readFully(this.panose);
        this.charset = r5.readByte();
        this.italic = r5.readByte();
        this.weight = r5.readInt();
        this.fsType = r5.readUShort();
        int r1 = r5.readUShort();
        this.magic = r1;
        if (r1 != 20556) goto L16;
        this.unicodeRange1 = r5.readInt();
        this.unicodeRange2 = r5.readInt();
        this.unicodeRange3 = r5.readInt();
        this.unicodeRange4 = r5.readInt();
        this.codePageRange1 = r5.readInt();
        this.codePageRange2 = r5.readInt();
        this.checkSumAdjustment = r5.readInt();
        r5.readInt();
        r5.readInt();
        r5.readInt();
        r5.readInt();
        this.familyName = readName(r5);
        this.styleName = readName(r5);
        this.versionName = readName(r5);
        this.fullName = readName(r5);
        return;
    L16:
        throw new RuntimeException("not a EOT font data stream");
    L5:
        if (r0 == 131073) goto L11;
        if (r0 == 131074) goto L11;
        throw new RuntimeException("not a EOT font data stream");
    }

    public void init(byte[] r2, int r3, int r4) {
        init(new LittleEndianByteArrayInputStream(r2, r3, r4));
    }

    public boolean isItalic() {
        if (this.italic == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$FontHeader() {
        return Integer.valueOf(this.eotSize);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$FontHeader() {
        return Integer.valueOf(this.fontDataSize);
    }

    public /* synthetic */ Object lambda$getGenericProperties$10$FontHeader() {
        return Integer.valueOf(this.checkSumAdjustment);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$FontHeader() {
        return Integer.valueOf(this.version);
    }

    public /* synthetic */ Number lambda$getGenericProperties$3$FontHeader() {
        return Integer.valueOf(this.fsType);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$FontHeader() {
        return Integer.valueOf(this.unicodeRange1);
    }

    public /* synthetic */ Object lambda$getGenericProperties$5$FontHeader() {
        return Integer.valueOf(this.unicodeRange2);
    }

    public /* synthetic */ Object lambda$getGenericProperties$6$FontHeader() {
        return Integer.valueOf(this.unicodeRange3);
    }

    public /* synthetic */ Object lambda$getGenericProperties$7$FontHeader() {
        return Integer.valueOf(this.unicodeRange4);
    }

    public /* synthetic */ Object lambda$getGenericProperties$8$FontHeader() {
        return Integer.valueOf(this.codePageRange1);
    }

    public /* synthetic */ Object lambda$getGenericProperties$9$FontHeader() {
        return Integer.valueOf(this.codePageRange2);
    }

    public /* synthetic */ Number lambda$getPanoseArmStyle$17$FontHeader() {
        return Byte.valueOf(this.panose[6]);
    }

    public /* synthetic */ Number lambda$getPanoseContrast$15$FontHeader() {
        return Byte.valueOf(this.panose[4]);
    }

    public /* synthetic */ Number lambda$getPanoseFamily$11$FontHeader() {
        return Byte.valueOf(this.panose[0]);
    }

    public /* synthetic */ Number lambda$getPanoseLetterForm$18$FontHeader() {
        return Byte.valueOf(this.panose[7]);
    }

    public /* synthetic */ Number lambda$getPanoseMidLine$19$FontHeader() {
        return Byte.valueOf(this.panose[8]);
    }

    public /* synthetic */ Number lambda$getPanoseProportion$14$FontHeader() {
        return Byte.valueOf(this.panose[3]);
    }

    public /* synthetic */ Number lambda$getPanoseSerif$12$FontHeader() {
        return Byte.valueOf(this.panose[1]);
    }

    public /* synthetic */ Number lambda$getPanoseStroke$16$FontHeader() {
        return Byte.valueOf(this.panose[5]);
    }

    public /* synthetic */ Number lambda$getPanoseWeight$13$FontHeader() {
        return Byte.valueOf(this.panose[2]);
    }

    public /* synthetic */ Number lambda$getPanoseXHeight$20$FontHeader() {
        return Byte.valueOf(this.panose[9]);
    }
}
