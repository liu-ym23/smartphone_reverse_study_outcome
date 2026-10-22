package org.apache.poi.hemf.record.emf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hwmf.record.HwmfFont;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HemfFont extends HwmfFont {
    protected LogFontDetails details;
    protected String fullname;
    protected String script;
    protected String style;

    protected interface LogFontDetails {
    }

    protected static class LogFontPanose implements GenericRecord, LogFontDetails {
        protected ArmStyle armStyle;
        protected Contrast contrast;
        protected int culture;
        protected FamilyType familyType;
        protected Letterform letterform;
        protected MidLine midLine;
        protected Proportion proportion;
        protected SerifType serifStyle;
        protected StrokeVariation strokeVariation;
        protected int styleSize;
        protected int vendorId;
        protected FontWeight weight;
        protected XHeight xHeight;

        static final enum ArmStyle extends Enum<ArmStyle> {
            private static final /* synthetic */ ArmStyle[] $VALUES = null;
            public static final ArmStyle PAN_ANY = null;
            public static final ArmStyle PAN_BENT_ARMS_DOUBLE_SERIF = null;
            public static final ArmStyle PAN_BENT_ARMS_HORZ = null;
            public static final ArmStyle PAN_BENT_ARMS_SINGLE_SERIF = null;
            public static final ArmStyle PAN_BENT_ARMS_VERT = null;
            public static final ArmStyle PAN_BENT_ARMS_WEDGE = null;
            public static final ArmStyle PAN_NO_FIT = null;
            public static final ArmStyle PAN_STRAIGHT_ARMS_DOUBLE_SERIF = null;
            public static final ArmStyle PAN_STRAIGHT_ARMS_HORZ = null;
            public static final ArmStyle PAN_STRAIGHT_ARMS_SINGLE_SERIF = null;
            public static final ArmStyle PAN_STRAIGHT_ARMS_VERT = null;
            public static final ArmStyle PAN_STRAIGHT_ARMS_WEDGE = null;

            static {
                ArmStyle r0 = new ArmStyle("PAN_ANY", 0);
                PAN_ANY = r0;
                ArmStyle r1 = new ArmStyle("PAN_NO_FIT", 1);
                PAN_NO_FIT = r1;
                ArmStyle r3 = new ArmStyle("PAN_STRAIGHT_ARMS_HORZ", 2);
                PAN_STRAIGHT_ARMS_HORZ = r3;
                ArmStyle r5 = new ArmStyle("PAN_STRAIGHT_ARMS_WEDGE", 3);
                PAN_STRAIGHT_ARMS_WEDGE = r5;
                ArmStyle r7 = new ArmStyle("PAN_STRAIGHT_ARMS_VERT", 4);
                PAN_STRAIGHT_ARMS_VERT = r7;
                ArmStyle r9 = new ArmStyle("PAN_STRAIGHT_ARMS_SINGLE_SERIF", 5);
                PAN_STRAIGHT_ARMS_SINGLE_SERIF = r9;
                ArmStyle r11 = new ArmStyle("PAN_STRAIGHT_ARMS_DOUBLE_SERIF", 6);
                PAN_STRAIGHT_ARMS_DOUBLE_SERIF = r11;
                ArmStyle r13 = new ArmStyle("PAN_BENT_ARMS_HORZ", 7);
                PAN_BENT_ARMS_HORZ = r13;
                ArmStyle r15 = new ArmStyle("PAN_BENT_ARMS_WEDGE", 8);
                PAN_BENT_ARMS_WEDGE = r15;
                ArmStyle r14 = new ArmStyle("PAN_BENT_ARMS_VERT", 9);
                PAN_BENT_ARMS_VERT = r14;
                ArmStyle r12 = new ArmStyle("PAN_BENT_ARMS_SINGLE_SERIF", 10);
                PAN_BENT_ARMS_SINGLE_SERIF = r12;
                ArmStyle r10 = new ArmStyle("PAN_BENT_ARMS_DOUBLE_SERIF", 11);
                PAN_BENT_ARMS_DOUBLE_SERIF = r10;
                $VALUES = new ArmStyle[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
            }

            private ArmStyle(String r1, int r2) {
                super(r1, r2);
            }

            public static ArmStyle valueOf(String r2) {
                return (ArmStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(ArmStyle.class, r2), ArmStyle.class, "com.obric.memorydata.plugin");
            }

            public static ArmStyle[] values() {
                return (ArmStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ArmStyle[].class, "com.obric.memorydata.plugin");
            }
        }

        static final enum Contrast extends Enum<Contrast> {
            private static final /* synthetic */ Contrast[] $VALUES = null;
            public static final Contrast PAN_ANY = null;
            public static final Contrast PAN_CONTRAST_HIGH = null;
            public static final Contrast PAN_CONTRAST_LOW = null;
            public static final Contrast PAN_CONTRAST_MEDIUM = null;
            public static final Contrast PAN_CONTRAST_MEDIUM_HIGH = null;
            public static final Contrast PAN_CONTRAST_MEDIUM_LOW = null;
            public static final Contrast PAN_CONTRAST_NONE = null;
            public static final Contrast PAN_CONTRAST_VERY_HIGH = null;
            public static final Contrast PAN_CONTRAST_VERY_LOW = null;
            public static final Contrast PAN_NO_FIT = null;

            static {
                Contrast r0 = new Contrast("PAN_ANY", 0);
                PAN_ANY = r0;
                Contrast r1 = new Contrast("PAN_NO_FIT", 1);
                PAN_NO_FIT = r1;
                Contrast r3 = new Contrast("PAN_CONTRAST_NONE", 2);
                PAN_CONTRAST_NONE = r3;
                Contrast r5 = new Contrast("PAN_CONTRAST_VERY_LOW", 3);
                PAN_CONTRAST_VERY_LOW = r5;
                Contrast r7 = new Contrast("PAN_CONTRAST_LOW", 4);
                PAN_CONTRAST_LOW = r7;
                Contrast r9 = new Contrast("PAN_CONTRAST_MEDIUM_LOW", 5);
                PAN_CONTRAST_MEDIUM_LOW = r9;
                Contrast r11 = new Contrast("PAN_CONTRAST_MEDIUM", 6);
                PAN_CONTRAST_MEDIUM = r11;
                Contrast r13 = new Contrast("PAN_CONTRAST_MEDIUM_HIGH", 7);
                PAN_CONTRAST_MEDIUM_HIGH = r13;
                Contrast r15 = new Contrast("PAN_CONTRAST_HIGH", 8);
                PAN_CONTRAST_HIGH = r15;
                Contrast r14 = new Contrast("PAN_CONTRAST_VERY_HIGH", 9);
                PAN_CONTRAST_VERY_HIGH = r14;
                $VALUES = new Contrast[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
            }

            private Contrast(String r1, int r2) {
                super(r1, r2);
            }

            public static Contrast valueOf(String r2) {
                return (Contrast) ZeusTransformUtils.preCheckCast(Enum.valueOf(Contrast.class, r2), Contrast.class, "com.obric.memorydata.plugin");
            }

            public static Contrast[] values() {
                return (Contrast[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Contrast[].class, "com.obric.memorydata.plugin");
            }
        }

        static final enum FamilyType extends Enum<FamilyType> {
            private static final /* synthetic */ FamilyType[] $VALUES = null;
            public static final FamilyType PAN_ANY = null;
            public static final FamilyType PAN_FAMILY_DECORATIVE = null;
            public static final FamilyType PAN_FAMILY_PICTORIAL = null;
            public static final FamilyType PAN_FAMILY_SCRIPT = null;
            public static final FamilyType PAN_FAMILY_TEXT_DISPLAY = null;
            public static final FamilyType PAN_NO_FIT = null;

            static {
                FamilyType r0 = new FamilyType("PAN_ANY", 0);
                PAN_ANY = r0;
                FamilyType r1 = new FamilyType("PAN_NO_FIT", 1);
                PAN_NO_FIT = r1;
                FamilyType r3 = new FamilyType("PAN_FAMILY_TEXT_DISPLAY", 2);
                PAN_FAMILY_TEXT_DISPLAY = r3;
                FamilyType r5 = new FamilyType("PAN_FAMILY_SCRIPT", 3);
                PAN_FAMILY_SCRIPT = r5;
                FamilyType r7 = new FamilyType("PAN_FAMILY_DECORATIVE", 4);
                PAN_FAMILY_DECORATIVE = r7;
                FamilyType r9 = new FamilyType("PAN_FAMILY_PICTORIAL", 5);
                PAN_FAMILY_PICTORIAL = r9;
                $VALUES = new FamilyType[]{r0, r1, r3, r5, r7, r9};
            }

            private FamilyType(String r1, int r2) {
                super(r1, r2);
            }

            public static FamilyType valueOf(String r2) {
                return (FamilyType) ZeusTransformUtils.preCheckCast(Enum.valueOf(FamilyType.class, r2), FamilyType.class, "com.obric.memorydata.plugin");
            }

            public static FamilyType[] values() {
                return (FamilyType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FamilyType[].class, "com.obric.memorydata.plugin");
            }
        }

        static final enum FontWeight extends Enum<FontWeight> {
            private static final /* synthetic */ FontWeight[] $VALUES = null;
            public static final FontWeight PAN_ANY = null;
            public static final FontWeight PAN_NO_FIT = null;
            public static final FontWeight PAN_WEIGHT_BLACK = null;
            public static final FontWeight PAN_WEIGHT_BOLD = null;
            public static final FontWeight PAN_WEIGHT_BOOK = null;
            public static final FontWeight PAN_WEIGHT_DEMI = null;
            public static final FontWeight PAN_WEIGHT_HEAVY = null;
            public static final FontWeight PAN_WEIGHT_LIGHT = null;
            public static final FontWeight PAN_WEIGHT_MEDIUM = null;
            public static final FontWeight PAN_WEIGHT_NORD = null;
            public static final FontWeight PAN_WEIGHT_THIN = null;
            public static final FontWeight PAN_WEIGHT_VERY_LIGHT = null;

            static {
                FontWeight r0 = new FontWeight("PAN_ANY", 0);
                PAN_ANY = r0;
                FontWeight r1 = new FontWeight("PAN_NO_FIT", 1);
                PAN_NO_FIT = r1;
                FontWeight r3 = new FontWeight("PAN_WEIGHT_VERY_LIGHT", 2);
                PAN_WEIGHT_VERY_LIGHT = r3;
                FontWeight r5 = new FontWeight("PAN_WEIGHT_LIGHT", 3);
                PAN_WEIGHT_LIGHT = r5;
                FontWeight r7 = new FontWeight("PAN_WEIGHT_THIN", 4);
                PAN_WEIGHT_THIN = r7;
                FontWeight r9 = new FontWeight("PAN_WEIGHT_BOOK", 5);
                PAN_WEIGHT_BOOK = r9;
                FontWeight r11 = new FontWeight("PAN_WEIGHT_MEDIUM", 6);
                PAN_WEIGHT_MEDIUM = r11;
                FontWeight r13 = new FontWeight("PAN_WEIGHT_DEMI", 7);
                PAN_WEIGHT_DEMI = r13;
                FontWeight r15 = new FontWeight("PAN_WEIGHT_BOLD", 8);
                PAN_WEIGHT_BOLD = r15;
                FontWeight r14 = new FontWeight("PAN_WEIGHT_HEAVY", 9);
                PAN_WEIGHT_HEAVY = r14;
                FontWeight r12 = new FontWeight("PAN_WEIGHT_BLACK", 10);
                PAN_WEIGHT_BLACK = r12;
                FontWeight r10 = new FontWeight("PAN_WEIGHT_NORD", 11);
                PAN_WEIGHT_NORD = r10;
                $VALUES = new FontWeight[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
            }

            private FontWeight(String r1, int r2) {
                super(r1, r2);
            }

            public static FontWeight valueOf(String r2) {
                return (FontWeight) ZeusTransformUtils.preCheckCast(Enum.valueOf(FontWeight.class, r2), FontWeight.class, "com.obric.memorydata.plugin");
            }

            public static FontWeight[] values() {
                return (FontWeight[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FontWeight[].class, "com.obric.memorydata.plugin");
            }
        }

        static final enum Letterform extends Enum<Letterform> {
            private static final /* synthetic */ Letterform[] $VALUES = null;
            public static final Letterform PAN_ANY = null;
            public static final Letterform PAN_LETT_NORMAL_BOXED = null;
            public static final Letterform PAN_LETT_NORMAL_CONTACT = null;
            public static final Letterform PAN_LETT_NORMAL_FLATTENED = null;
            public static final Letterform PAN_LETT_NORMAL_OFF_CENTER = null;
            public static final Letterform PAN_LETT_NORMAL_ROUNDED = null;
            public static final Letterform PAN_LETT_NORMAL_SQUARE = null;
            public static final Letterform PAN_LETT_NORMAL_WEIGHTED = null;
            public static final Letterform PAN_LETT_OBLIQUE_BOXED = null;
            public static final Letterform PAN_LETT_OBLIQUE_CONTACT = null;
            public static final Letterform PAN_LETT_OBLIQUE_FLATTENED = null;
            public static final Letterform PAN_LETT_OBLIQUE_OFF_CENTER = null;
            public static final Letterform PAN_LETT_OBLIQUE_ROUNDED = null;
            public static final Letterform PAN_LETT_OBLIQUE_SQUARE = null;
            public static final Letterform PAN_LETT_OBLIQUE_WEIGHTED = null;
            public static final Letterform PAN_NO_FIT = null;

            static {
                Letterform r0 = new Letterform("PAN_ANY", 0);
                PAN_ANY = r0;
                Letterform r1 = new Letterform("PAN_NO_FIT", 1);
                PAN_NO_FIT = r1;
                Letterform r3 = new Letterform("PAN_LETT_NORMAL_CONTACT", 2);
                PAN_LETT_NORMAL_CONTACT = r3;
                Letterform r5 = new Letterform("PAN_LETT_NORMAL_WEIGHTED", 3);
                PAN_LETT_NORMAL_WEIGHTED = r5;
                Letterform r7 = new Letterform("PAN_LETT_NORMAL_BOXED", 4);
                PAN_LETT_NORMAL_BOXED = r7;
                Letterform r9 = new Letterform("PAN_LETT_NORMAL_FLATTENED", 5);
                PAN_LETT_NORMAL_FLATTENED = r9;
                Letterform r11 = new Letterform("PAN_LETT_NORMAL_ROUNDED", 6);
                PAN_LETT_NORMAL_ROUNDED = r11;
                Letterform r13 = new Letterform("PAN_LETT_NORMAL_OFF_CENTER", 7);
                PAN_LETT_NORMAL_OFF_CENTER = r13;
                Letterform r15 = new Letterform("PAN_LETT_NORMAL_SQUARE", 8);
                PAN_LETT_NORMAL_SQUARE = r15;
                Letterform r14 = new Letterform("PAN_LETT_OBLIQUE_CONTACT", 9);
                PAN_LETT_OBLIQUE_CONTACT = r14;
                Letterform r12 = new Letterform("PAN_LETT_OBLIQUE_WEIGHTED", 10);
                PAN_LETT_OBLIQUE_WEIGHTED = r12;
                Letterform r10 = new Letterform("PAN_LETT_OBLIQUE_BOXED", 11);
                PAN_LETT_OBLIQUE_BOXED = r10;
                Letterform r8 = new Letterform("PAN_LETT_OBLIQUE_FLATTENED", 12);
                PAN_LETT_OBLIQUE_FLATTENED = r8;
                Letterform r6 = new Letterform("PAN_LETT_OBLIQUE_ROUNDED", 13);
                PAN_LETT_OBLIQUE_ROUNDED = r6;
                Letterform r4 = new Letterform("PAN_LETT_OBLIQUE_OFF_CENTER", 14);
                PAN_LETT_OBLIQUE_OFF_CENTER = r4;
                Letterform r2 = new Letterform("PAN_LETT_OBLIQUE_SQUARE", 15);
                PAN_LETT_OBLIQUE_SQUARE = r2;
                $VALUES = new Letterform[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2};
            }

            private Letterform(String r1, int r2) {
                super(r1, r2);
            }

            public static Letterform valueOf(String r2) {
                return (Letterform) ZeusTransformUtils.preCheckCast(Enum.valueOf(Letterform.class, r2), Letterform.class, "com.obric.memorydata.plugin");
            }

            public static Letterform[] values() {
                return (Letterform[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Letterform[].class, "com.obric.memorydata.plugin");
            }
        }

        static final enum MidLine extends Enum<MidLine> {
            private static final /* synthetic */ MidLine[] $VALUES = null;
            public static final MidLine PAN_ANY = null;
            public static final MidLine PAN_MIDLINE_CONSTANT_POINTED = null;
            public static final MidLine PAN_MIDLINE_CONSTANT_SERIFED = null;
            public static final MidLine PAN_MIDLINE_CONSTANT_TRIMMED = null;
            public static final MidLine PAN_MIDLINE_HIGH_POINTED = null;
            public static final MidLine PAN_MIDLINE_HIGH_SERIFED = null;
            public static final MidLine PAN_MIDLINE_HIGH_TRIMMED = null;
            public static final MidLine PAN_MIDLINE_LOW_POINTED = null;
            public static final MidLine PAN_MIDLINE_LOW_SERIFED = null;
            public static final MidLine PAN_MIDLINE_LOW_TRIMMED = null;
            public static final MidLine PAN_MIDLINE_STANDARD_POINTED = null;
            public static final MidLine PAN_MIDLINE_STANDARD_SERIFED = null;
            public static final MidLine PAN_MIDLINE_STANDARD_TRIMMED = null;
            public static final MidLine PAN_NO_FIT = null;

            static {
                MidLine r0 = new MidLine("PAN_ANY", 0);
                PAN_ANY = r0;
                MidLine r1 = new MidLine("PAN_NO_FIT", 1);
                PAN_NO_FIT = r1;
                MidLine r3 = new MidLine("PAN_MIDLINE_STANDARD_TRIMMED", 2);
                PAN_MIDLINE_STANDARD_TRIMMED = r3;
                MidLine r5 = new MidLine("PAN_MIDLINE_STANDARD_POINTED", 3);
                PAN_MIDLINE_STANDARD_POINTED = r5;
                MidLine r7 = new MidLine("PAN_MIDLINE_STANDARD_SERIFED", 4);
                PAN_MIDLINE_STANDARD_SERIFED = r7;
                MidLine r9 = new MidLine("PAN_MIDLINE_HIGH_TRIMMED", 5);
                PAN_MIDLINE_HIGH_TRIMMED = r9;
                MidLine r11 = new MidLine("PAN_MIDLINE_HIGH_POINTED", 6);
                PAN_MIDLINE_HIGH_POINTED = r11;
                MidLine r13 = new MidLine("PAN_MIDLINE_HIGH_SERIFED", 7);
                PAN_MIDLINE_HIGH_SERIFED = r13;
                MidLine r15 = new MidLine("PAN_MIDLINE_CONSTANT_TRIMMED", 8);
                PAN_MIDLINE_CONSTANT_TRIMMED = r15;
                MidLine r14 = new MidLine("PAN_MIDLINE_CONSTANT_POINTED", 9);
                PAN_MIDLINE_CONSTANT_POINTED = r14;
                MidLine r12 = new MidLine("PAN_MIDLINE_CONSTANT_SERIFED", 10);
                PAN_MIDLINE_CONSTANT_SERIFED = r12;
                MidLine r10 = new MidLine("PAN_MIDLINE_LOW_TRIMMED", 11);
                PAN_MIDLINE_LOW_TRIMMED = r10;
                MidLine r8 = new MidLine("PAN_MIDLINE_LOW_POINTED", 12);
                PAN_MIDLINE_LOW_POINTED = r8;
                MidLine r6 = new MidLine("PAN_MIDLINE_LOW_SERIFED", 13);
                PAN_MIDLINE_LOW_SERIFED = r6;
                $VALUES = new MidLine[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6};
            }

            private MidLine(String r1, int r2) {
                super(r1, r2);
            }

            public static MidLine valueOf(String r2) {
                return (MidLine) ZeusTransformUtils.preCheckCast(Enum.valueOf(MidLine.class, r2), MidLine.class, "com.obric.memorydata.plugin");
            }

            public static MidLine[] values() {
                return (MidLine[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MidLine[].class, "com.obric.memorydata.plugin");
            }
        }

        static final enum Proportion extends Enum<Proportion> {
            private static final /* synthetic */ Proportion[] $VALUES = null;
            public static final Proportion PAN_ANY = null;
            public static final Proportion PAN_NO_FIT = null;
            public static final Proportion PAN_PROP_CONDENSED = null;
            public static final Proportion PAN_PROP_EVEN_WIDTH = null;
            public static final Proportion PAN_PROP_EXPANDED = null;
            public static final Proportion PAN_PROP_MODERN = null;
            public static final Proportion PAN_PROP_MONOSPACED = null;
            public static final Proportion PAN_PROP_OLD_STYLE = null;
            public static final Proportion PAN_PROP_VERY_CONDENSED = null;
            public static final Proportion PAN_PROP_VERY_EXPANDED = null;

            static {
                Proportion r0 = new Proportion("PAN_ANY", 0);
                PAN_ANY = r0;
                Proportion r1 = new Proportion("PAN_NO_FIT", 1);
                PAN_NO_FIT = r1;
                Proportion r3 = new Proportion("PAN_PROP_OLD_STYLE", 2);
                PAN_PROP_OLD_STYLE = r3;
                Proportion r5 = new Proportion("PAN_PROP_MODERN", 3);
                PAN_PROP_MODERN = r5;
                Proportion r7 = new Proportion("PAN_PROP_EVEN_WIDTH", 4);
                PAN_PROP_EVEN_WIDTH = r7;
                Proportion r9 = new Proportion("PAN_PROP_EXPANDED", 5);
                PAN_PROP_EXPANDED = r9;
                Proportion r11 = new Proportion("PAN_PROP_CONDENSED", 6);
                PAN_PROP_CONDENSED = r11;
                Proportion r13 = new Proportion("PAN_PROP_VERY_EXPANDED", 7);
                PAN_PROP_VERY_EXPANDED = r13;
                Proportion r15 = new Proportion("PAN_PROP_VERY_CONDENSED", 8);
                PAN_PROP_VERY_CONDENSED = r15;
                Proportion r14 = new Proportion("PAN_PROP_MONOSPACED", 9);
                PAN_PROP_MONOSPACED = r14;
                $VALUES = new Proportion[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
            }

            private Proportion(String r1, int r2) {
                super(r1, r2);
            }

            public static Proportion valueOf(String r2) {
                return (Proportion) ZeusTransformUtils.preCheckCast(Enum.valueOf(Proportion.class, r2), Proportion.class, "com.obric.memorydata.plugin");
            }

            public static Proportion[] values() {
                return (Proportion[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Proportion[].class, "com.obric.memorydata.plugin");
            }
        }

        static final enum SerifType extends Enum<SerifType> {
            private static final /* synthetic */ SerifType[] $VALUES = null;
            public static final SerifType PAN_ANY = null;
            public static final SerifType PAN_NO_FIT = null;
            public static final SerifType PAN_SERIF_BONE = null;
            public static final SerifType PAN_SERIF_COVE = null;
            public static final SerifType PAN_SERIF_EXAGGERATED = null;
            public static final SerifType PAN_SERIF_FLARED = null;
            public static final SerifType PAN_SERIF_NORMAL_SANS = null;
            public static final SerifType PAN_SERIF_OBTUSE_COVE = null;
            public static final SerifType PAN_SERIF_OBTUSE_SANS = null;
            public static final SerifType PAN_SERIF_OBTUSE_SQUARE_COVE = null;
            public static final SerifType PAN_SERIF_PERP_SANS = null;
            public static final SerifType PAN_SERIF_ROUNDED = null;
            public static final SerifType PAN_SERIF_SQUARE = null;
            public static final SerifType PAN_SERIF_SQUARE_COVE = null;
            public static final SerifType PAN_SERIF_THIN = null;
            public static final SerifType PAN_SERIF_TRIANGLE = null;

            static {
                SerifType r0 = new SerifType("PAN_ANY", 0);
                PAN_ANY = r0;
                SerifType r1 = new SerifType("PAN_NO_FIT", 1);
                PAN_NO_FIT = r1;
                SerifType r3 = new SerifType("PAN_SERIF_COVE", 2);
                PAN_SERIF_COVE = r3;
                SerifType r5 = new SerifType("PAN_SERIF_OBTUSE_COVE", 3);
                PAN_SERIF_OBTUSE_COVE = r5;
                SerifType r7 = new SerifType("PAN_SERIF_SQUARE_COVE", 4);
                PAN_SERIF_SQUARE_COVE = r7;
                SerifType r9 = new SerifType("PAN_SERIF_OBTUSE_SQUARE_COVE", 5);
                PAN_SERIF_OBTUSE_SQUARE_COVE = r9;
                SerifType r11 = new SerifType("PAN_SERIF_SQUARE", 6);
                PAN_SERIF_SQUARE = r11;
                SerifType r13 = new SerifType("PAN_SERIF_THIN", 7);
                PAN_SERIF_THIN = r13;
                SerifType r15 = new SerifType("PAN_SERIF_BONE", 8);
                PAN_SERIF_BONE = r15;
                SerifType r14 = new SerifType("PAN_SERIF_EXAGGERATED", 9);
                PAN_SERIF_EXAGGERATED = r14;
                SerifType r12 = new SerifType("PAN_SERIF_TRIANGLE", 10);
                PAN_SERIF_TRIANGLE = r12;
                SerifType r10 = new SerifType("PAN_SERIF_NORMAL_SANS", 11);
                PAN_SERIF_NORMAL_SANS = r10;
                SerifType r8 = new SerifType("PAN_SERIF_OBTUSE_SANS", 12);
                PAN_SERIF_OBTUSE_SANS = r8;
                SerifType r6 = new SerifType("PAN_SERIF_PERP_SANS", 13);
                PAN_SERIF_PERP_SANS = r6;
                SerifType r4 = new SerifType("PAN_SERIF_FLARED", 14);
                PAN_SERIF_FLARED = r4;
                SerifType r2 = new SerifType("PAN_SERIF_ROUNDED", 15);
                PAN_SERIF_ROUNDED = r2;
                $VALUES = new SerifType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2};
            }

            private SerifType(String r1, int r2) {
                super(r1, r2);
            }

            public static SerifType valueOf(String r2) {
                return (SerifType) ZeusTransformUtils.preCheckCast(Enum.valueOf(SerifType.class, r2), SerifType.class, "com.obric.memorydata.plugin");
            }

            public static SerifType[] values() {
                return (SerifType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SerifType[].class, "com.obric.memorydata.plugin");
            }
        }

        static final enum StrokeVariation extends Enum<StrokeVariation> {
            private static final /* synthetic */ StrokeVariation[] $VALUES = null;
            public static final StrokeVariation PAN_ANY = null;
            public static final StrokeVariation PAN_NO_FIT = null;
            public static final StrokeVariation PAN_STROKE_GRADUAL_DIAG = null;
            public static final StrokeVariation PAN_STROKE_GRADUAL_HORZ = null;
            public static final StrokeVariation PAN_STROKE_GRADUAL_TRAN = null;
            public static final StrokeVariation PAN_STROKE_GRADUAL_VERT = null;
            public static final StrokeVariation PAN_STROKE_INSTANT_VERT = null;
            public static final StrokeVariation PAN_STROKE_RAPID_HORZ = null;
            public static final StrokeVariation PAN_STROKE_RAPID_VERT = null;

            static {
                StrokeVariation r0 = new StrokeVariation("PAN_ANY", 0);
                PAN_ANY = r0;
                StrokeVariation r1 = new StrokeVariation("PAN_NO_FIT", 1);
                PAN_NO_FIT = r1;
                StrokeVariation r3 = new StrokeVariation("PAN_STROKE_GRADUAL_DIAG", 2);
                PAN_STROKE_GRADUAL_DIAG = r3;
                StrokeVariation r5 = new StrokeVariation("PAN_STROKE_GRADUAL_TRAN", 3);
                PAN_STROKE_GRADUAL_TRAN = r5;
                StrokeVariation r7 = new StrokeVariation("PAN_STROKE_GRADUAL_VERT", 4);
                PAN_STROKE_GRADUAL_VERT = r7;
                StrokeVariation r9 = new StrokeVariation("PAN_STROKE_GRADUAL_HORZ", 5);
                PAN_STROKE_GRADUAL_HORZ = r9;
                StrokeVariation r11 = new StrokeVariation("PAN_STROKE_RAPID_VERT", 6);
                PAN_STROKE_RAPID_VERT = r11;
                StrokeVariation r13 = new StrokeVariation("PAN_STROKE_RAPID_HORZ", 7);
                PAN_STROKE_RAPID_HORZ = r13;
                StrokeVariation r15 = new StrokeVariation("PAN_STROKE_INSTANT_VERT", 8);
                PAN_STROKE_INSTANT_VERT = r15;
                $VALUES = new StrokeVariation[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
            }

            private StrokeVariation(String r1, int r2) {
                super(r1, r2);
            }

            public static StrokeVariation valueOf(String r2) {
                return (StrokeVariation) ZeusTransformUtils.preCheckCast(Enum.valueOf(StrokeVariation.class, r2), StrokeVariation.class, "com.obric.memorydata.plugin");
            }

            public static StrokeVariation[] values() {
                return (StrokeVariation[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StrokeVariation[].class, "com.obric.memorydata.plugin");
            }
        }

        static final enum XHeight extends Enum<XHeight> {
            private static final /* synthetic */ XHeight[] $VALUES = null;
            public static final XHeight PAN_ANY = null;
            public static final XHeight PAN_NO_FIT = null;
            public static final XHeight PAN_XHEIGHT_CONSTANT_LARGE = null;
            public static final XHeight PAN_XHEIGHT_CONSTANT_SMALL = null;
            public static final XHeight PAN_XHEIGHT_CONSTANT_STD = null;
            public static final XHeight PAN_XHEIGHT_DUCKING_LARGE = null;
            public static final XHeight PAN_XHEIGHT_DUCKING_SMALL = null;
            public static final XHeight PAN_XHEIGHT_DUCKING_STD = null;

            static {
                XHeight r0 = new XHeight("PAN_ANY", 0);
                PAN_ANY = r0;
                XHeight r1 = new XHeight("PAN_NO_FIT", 1);
                PAN_NO_FIT = r1;
                XHeight r3 = new XHeight("PAN_XHEIGHT_CONSTANT_SMALL", 2);
                PAN_XHEIGHT_CONSTANT_SMALL = r3;
                XHeight r5 = new XHeight("PAN_XHEIGHT_CONSTANT_STD", 3);
                PAN_XHEIGHT_CONSTANT_STD = r5;
                XHeight r7 = new XHeight("PAN_XHEIGHT_CONSTANT_LARGE", 4);
                PAN_XHEIGHT_CONSTANT_LARGE = r7;
                XHeight r9 = new XHeight("PAN_XHEIGHT_DUCKING_SMALL", 5);
                PAN_XHEIGHT_DUCKING_SMALL = r9;
                XHeight r11 = new XHeight("PAN_XHEIGHT_DUCKING_STD", 6);
                PAN_XHEIGHT_DUCKING_STD = r11;
                XHeight r13 = new XHeight("PAN_XHEIGHT_DUCKING_LARGE", 7);
                PAN_XHEIGHT_DUCKING_LARGE = r13;
                $VALUES = new XHeight[]{r0, r1, r3, r5, r7, r9, r11, r13};
            }

            private XHeight(String r1, int r2) {
                super(r1, r2);
            }

            public static XHeight valueOf(String r2) {
                return (XHeight) ZeusTransformUtils.preCheckCast(Enum.valueOf(XHeight.class, r2), XHeight.class, "com.obric.memorydata.plugin");
            }

            public static XHeight[] values() {
                return (XHeight[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), XHeight[].class, "com.obric.memorydata.plugin");
            }
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            LinkedHashMap r0 = new LinkedHashMap();
            r0.put("styleSize", new $$Lambda$HemfFont$LogFontPanose$NMaIsRyhnx9ZItxN51vsuAwTrd8(this));
            r0.put("vendorId", new $$Lambda$HemfFont$LogFontPanose$m2ASNm64pRTv7zJTq8092a5wNmg(this));
            r0.put("culture", new $$Lambda$HemfFont$LogFontPanose$g8hqY_q987PLk9pApqeRFuXQZqc(this));
            r0.put("familyType", new $$Lambda$HemfFont$LogFontPanose$Xywajsx6Vqrx4h7RH9PlikTTW2g(this));
            r0.put("serifStyle", new $$Lambda$HemfFont$LogFontPanose$KTspxvHydzKajG_ynQLpj8pVE(this));
            r0.put("weight", new $$Lambda$HemfFont$LogFontPanose$3uDVuUOc9LDOzLLNxoK4_ovRCs8(this));
            r0.put("proportion", new $$Lambda$HemfFont$LogFontPanose$72mnDKuV8m3LOx1WKt4tQSEkM_0(this));
            r0.put("contrast", new $$Lambda$HemfFont$LogFontPanose$uuJOaK512ogVZ1vp1g2buGbvjE(this));
            r0.put("strokeVariation", new $$Lambda$HemfFont$LogFontPanose$pXGiPTmu2pRyNX7cP_cRHh9RVc(this));
            r0.put("armStyle", new $$Lambda$HemfFont$LogFontPanose$qVKqGLtY2JcoHYhRxGegd5QRFY(this));
            r0.put("letterform", new $$Lambda$HemfFont$LogFontPanose$7CL_jEiDiBnpx_1KwXroAGWhdQE(this));
            r0.put("midLine", new $$Lambda$HemfFont$LogFontPanose$HcCRpINtFfuAXdS8uEnipz0N1mc(this));
            r0.put("xHeight", new $$Lambda$HemfFont$LogFontPanose$gAHkIAw2ENPudBIi0RdPRIMo4Fk(this));
            return Collections.unmodifiableMap(r0);
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfFont$LogFontPanose() {
            return Integer.valueOf(this.styleSize);
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HemfFont$LogFontPanose() {
            return Integer.valueOf(this.vendorId);
        }

        public /* synthetic */ Object lambda$getGenericProperties$10$HemfFont$LogFontPanose() {
            return this.letterform;
        }

        public /* synthetic */ Object lambda$getGenericProperties$11$HemfFont$LogFontPanose() {
            return this.midLine;
        }

        public /* synthetic */ Object lambda$getGenericProperties$12$HemfFont$LogFontPanose() {
            return this.xHeight;
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$HemfFont$LogFontPanose() {
            return Integer.valueOf(this.culture);
        }

        public /* synthetic */ Object lambda$getGenericProperties$3$HemfFont$LogFontPanose() {
            return this.familyType;
        }

        public /* synthetic */ Object lambda$getGenericProperties$4$HemfFont$LogFontPanose() {
            return this.serifStyle;
        }

        public /* synthetic */ Object lambda$getGenericProperties$5$HemfFont$LogFontPanose() {
            return this.weight;
        }

        public /* synthetic */ Object lambda$getGenericProperties$6$HemfFont$LogFontPanose() {
            return this.proportion;
        }

        public /* synthetic */ Object lambda$getGenericProperties$7$HemfFont$LogFontPanose() {
            return this.contrast;
        }

        public /* synthetic */ Object lambda$getGenericProperties$8$HemfFont$LogFontPanose() {
            return this.strokeVariation;
        }

        public /* synthetic */ Object lambda$getGenericProperties$9$HemfFont$LogFontPanose() {
            return this.armStyle;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public HemfFont() {
    }

    @Override // org.apache.poi.hwmf.record.HwmfFont, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfFont$TSYUWjOt6jl4as_ejbXqv7g2B9c(this), "fullname", new $$Lambda$HemfFont$o8FkqupiAB17yfL0d1kYxJgDOF4(this), "style", new $$Lambda$HemfFont$gqpBTkzl0LMqo7uvJw4MRTl46nc(this), "script", new $$Lambda$HemfFont$zKsgEJHGnPgD8GEeQJOpYamKog(this), "details", new $$Lambda$HemfFont$TNYsGNqHENwQO8LwZYx9DfsSknQ(this));
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$HemfFont() {
        return super.getGenericProperties();
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$HemfFont() {
        return this.fullname;
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$HemfFont() {
        return this.style;
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$HemfFont() {
        return this.script;
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$HemfFont() {
        return this.details;
    }

    @Override // org.apache.poi.hwmf.record.HwmfFont
    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
