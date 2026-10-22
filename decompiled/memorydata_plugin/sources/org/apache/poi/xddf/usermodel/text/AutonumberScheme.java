package org.apache.poi.xddf.usermodel.text;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAutonumberScheme;

/* JADX INFO: loaded from: classes7.dex */
public final enum AutonumberScheme extends Enum<AutonumberScheme> {
    private static final /* synthetic */ AutonumberScheme[] $VALUES = null;
    public static final AutonumberScheme ALPHABETIC_LOWERCASE_PARENTHESES_BOTH = null;
    public static final AutonumberScheme ALPHABETIC_LOWERCASE_PARENTHESIS_RIGHT = null;
    public static final AutonumberScheme ALPHABETIC_LOWERCASE_PERIOD = null;
    public static final AutonumberScheme ALPHABETIC_UPPERCASE_PARENTHESES_BOTH = null;
    public static final AutonumberScheme ALPHABETIC_UPPERCASE_PARENTHESIS_RIGHT = null;
    public static final AutonumberScheme ALPHABETIC_UPPERCASE_PERIOD = null;
    public static final AutonumberScheme ARABIC_1_MINUS = null;
    public static final AutonumberScheme ARABIC_2_MINUS = null;
    public static final AutonumberScheme ARABIC_DOUBLE_BYTE_PERIOD = null;
    public static final AutonumberScheme ARABIC_DOUBLE_BYTE_PLAIN = null;
    public static final AutonumberScheme ARABIC_PARENTHESES_BOTH = null;
    public static final AutonumberScheme ARABIC_PARENTHESIS_RIGHT = null;
    public static final AutonumberScheme ARABIC_PERIOD = null;
    public static final AutonumberScheme ARABIC_PLAIN = null;
    public static final AutonumberScheme CIRCLE_NUMBER_DOUBLE_BYTE_PLAIN = null;
    public static final AutonumberScheme CIRCLE_NUMBER_WINGDINGS_BLACK_PLAIN = null;
    public static final AutonumberScheme CIRCLE_NUMBER_WINGDINGS_WHITE_PLAIN = null;
    public static final AutonumberScheme EAST_ASIAN_CHINESE_SIMPLIFIED_PERIOD = null;
    public static final AutonumberScheme EAST_ASIAN_CHINESE_SIMPLIFIED_PLAIN = null;
    public static final AutonumberScheme EAST_ASIAN_CHINESE_TRADITIONAL_PERIOD = null;
    public static final AutonumberScheme EAST_ASIAN_CHINESE_TRADITIONAL_PLAIN = null;
    public static final AutonumberScheme EAST_ASIAN_JAPANESE_DOUBLE_BYTE_PERIOD = null;
    public static final AutonumberScheme EAST_ASIAN_JAPANESE_KOREAN_PERIOD = null;
    public static final AutonumberScheme EAST_ASIAN_JAPANESE_KOREAN_PLAIN = null;
    public static final AutonumberScheme HEBREW_2_MINUS = null;
    public static final AutonumberScheme HINDI_ALPHA_1_PERIOD = null;
    public static final AutonumberScheme HINDI_ALPHA_PERIOD = null;
    public static final AutonumberScheme HINDI_NUMBER_PARENTHESIS_RIGHT = null;
    public static final AutonumberScheme HINDI_NUMBER_PERIOD = null;
    public static final AutonumberScheme ROMAN_LOWERCASE_PARENTHESES_BOTH = null;
    public static final AutonumberScheme ROMAN_LOWERCASE_PARENTHESIS_RIGHT = null;
    public static final AutonumberScheme ROMAN_LOWERCASE_PERIOD = null;
    public static final AutonumberScheme ROMAN_UPPERCASE_PARENTHESES_BOTH = null;
    public static final AutonumberScheme ROMAN_UPPERCASE_PARENTHESIS_RIGHT = null;
    public static final AutonumberScheme ROMAN_UPPERCASE_PERIOD = null;
    public static final AutonumberScheme THAI_ALPHABETIC_PARENTHESES_BOTH = null;
    public static final AutonumberScheme THAI_ALPHABETIC_PARENTHESIS_RIGHT = null;
    public static final AutonumberScheme THAI_ALPHABETIC_PERIOD = null;
    public static final AutonumberScheme THAI_NUMBER_PARENTHESES_BOTH = null;
    public static final AutonumberScheme THAI_NUMBER_PARENTHESIS_RIGHT = null;
    public static final AutonumberScheme THAI_NUMBER_PERIOD = null;
    private static final HashMap<STTextAutonumberScheme.Enum, AutonumberScheme> reverse = null;
    final STTextAutonumberScheme.Enum underlying;

    static {
        AutonumberScheme r0 = new AutonumberScheme("ALPHABETIC_LOWERCASE_PARENTHESES_BOTH", 0, STTextAutonumberScheme.c);
        ALPHABETIC_LOWERCASE_PARENTHESES_BOTH = r0;
        AutonumberScheme r1 = new AutonumberScheme("ALPHABETIC_LOWERCASE_PARENTHESIS_RIGHT", 1, STTextAutonumberScheme.e);
        ALPHABETIC_LOWERCASE_PARENTHESIS_RIGHT = r1;
        AutonumberScheme r2 = new AutonumberScheme("ALPHABETIC_LOWERCASE_PERIOD", 2, STTextAutonumberScheme.g);
        ALPHABETIC_LOWERCASE_PERIOD = r2;
        AutonumberScheme r4 = new AutonumberScheme("ALPHABETIC_UPPERCASE_PARENTHESES_BOTH", 3, STTextAutonumberScheme.d);
        ALPHABETIC_UPPERCASE_PARENTHESES_BOTH = r4;
        AutonumberScheme r6 = new AutonumberScheme("ALPHABETIC_UPPERCASE_PARENTHESIS_RIGHT", 4, STTextAutonumberScheme.f);
        ALPHABETIC_UPPERCASE_PARENTHESIS_RIGHT = r6;
        AutonumberScheme r8 = new AutonumberScheme("ALPHABETIC_UPPERCASE_PERIOD", 5, STTextAutonumberScheme.h);
        ALPHABETIC_UPPERCASE_PERIOD = r8;
        AutonumberScheme r10 = new AutonumberScheme("ARABIC_1_MINUS", 6, STTextAutonumberScheme.E);
        ARABIC_1_MINUS = r10;
        AutonumberScheme r12 = new AutonumberScheme("ARABIC_2_MINUS", 7, STTextAutonumberScheme.F);
        ARABIC_2_MINUS = r12;
        AutonumberScheme r14 = new AutonumberScheme("ARABIC_DOUBLE_BYTE_PERIOD", 8, STTextAutonumberScheme.v);
        ARABIC_DOUBLE_BYTE_PERIOD = r14;
        AutonumberScheme r13 = new AutonumberScheme("ARABIC_DOUBLE_BYTE_PLAIN", 9, STTextAutonumberScheme.w);
        ARABIC_DOUBLE_BYTE_PLAIN = r13;
        AutonumberScheme r11 = new AutonumberScheme("ARABIC_PARENTHESES_BOTH", 10, STTextAutonumberScheme.i);
        ARABIC_PARENTHESES_BOTH = r11;
        AutonumberScheme r9 = new AutonumberScheme("ARABIC_PARENTHESIS_RIGHT", 11, STTextAutonumberScheme.j);
        ARABIC_PARENTHESIS_RIGHT = r9;
        AutonumberScheme r7 = new AutonumberScheme("ARABIC_PERIOD", 12, STTextAutonumberScheme.k);
        ARABIC_PERIOD = r7;
        AutonumberScheme r5 = new AutonumberScheme("ARABIC_PLAIN", 13, STTextAutonumberScheme.l);
        ARABIC_PLAIN = r5;
        AutonumberScheme r3 = new AutonumberScheme("CIRCLE_NUMBER_DOUBLE_BYTE_PLAIN", 14, STTextAutonumberScheme.s);
        CIRCLE_NUMBER_DOUBLE_BYTE_PLAIN = r3;
        AutonumberScheme r15 = new AutonumberScheme("CIRCLE_NUMBER_WINGDINGS_BLACK_PLAIN", 15, STTextAutonumberScheme.t);
        CIRCLE_NUMBER_WINGDINGS_BLACK_PLAIN = r15;
        AutonumberScheme r16 = new AutonumberScheme("CIRCLE_NUMBER_WINGDINGS_WHITE_PLAIN", 16, STTextAutonumberScheme.u);
        CIRCLE_NUMBER_WINGDINGS_WHITE_PLAIN = r16;
        AutonumberScheme r17 = new AutonumberScheme("EAST_ASIAN_CHINESE_SIMPLIFIED_PERIOD", 17, STTextAutonumberScheme.x);
        EAST_ASIAN_CHINESE_SIMPLIFIED_PERIOD = r17;
        AutonumberScheme r18 = new AutonumberScheme("EAST_ASIAN_CHINESE_SIMPLIFIED_PLAIN", 18, STTextAutonumberScheme.y);
        EAST_ASIAN_CHINESE_SIMPLIFIED_PLAIN = r18;
        AutonumberScheme r19 = new AutonumberScheme("EAST_ASIAN_CHINESE_TRADITIONAL_PERIOD", 19, STTextAutonumberScheme.z);
        EAST_ASIAN_CHINESE_TRADITIONAL_PERIOD = r19;
        AutonumberScheme r20 = new AutonumberScheme("EAST_ASIAN_CHINESE_TRADITIONAL_PLAIN", 20, STTextAutonumberScheme.A);
        EAST_ASIAN_CHINESE_TRADITIONAL_PLAIN = r20;
        AutonumberScheme r21 = new AutonumberScheme("EAST_ASIAN_JAPANESE_DOUBLE_BYTE_PERIOD", 21, STTextAutonumberScheme.B);
        EAST_ASIAN_JAPANESE_DOUBLE_BYTE_PERIOD = r21;
        AutonumberScheme r22 = new AutonumberScheme("EAST_ASIAN_JAPANESE_KOREAN_PERIOD", 22, STTextAutonumberScheme.D);
        EAST_ASIAN_JAPANESE_KOREAN_PERIOD = r22;
        AutonumberScheme r23 = new AutonumberScheme("EAST_ASIAN_JAPANESE_KOREAN_PLAIN", 23, STTextAutonumberScheme.C);
        EAST_ASIAN_JAPANESE_KOREAN_PLAIN = r23;
        AutonumberScheme r24 = new AutonumberScheme("HEBREW_2_MINUS", 24, STTextAutonumberScheme.G);
        HEBREW_2_MINUS = r24;
        AutonumberScheme r25 = new AutonumberScheme("HINDI_ALPHA_1_PERIOD", 25, STTextAutonumberScheme.Q);
        HINDI_ALPHA_1_PERIOD = r25;
        AutonumberScheme r26 = new AutonumberScheme("HINDI_ALPHA_PERIOD", 26, STTextAutonumberScheme.N);
        HINDI_ALPHA_PERIOD = r26;
        AutonumberScheme r27 = new AutonumberScheme("HINDI_NUMBER_PARENTHESIS_RIGHT", 27, STTextAutonumberScheme.P);
        HINDI_NUMBER_PARENTHESIS_RIGHT = r27;
        AutonumberScheme r28 = new AutonumberScheme("HINDI_NUMBER_PERIOD", 28, STTextAutonumberScheme.O);
        HINDI_NUMBER_PERIOD = r28;
        AutonumberScheme r29 = new AutonumberScheme("ROMAN_LOWERCASE_PARENTHESES_BOTH", 29, STTextAutonumberScheme.m);
        ROMAN_LOWERCASE_PARENTHESES_BOTH = r29;
        AutonumberScheme r30 = new AutonumberScheme("ROMAN_LOWERCASE_PARENTHESIS_RIGHT", 30, STTextAutonumberScheme.o);
        ROMAN_LOWERCASE_PARENTHESIS_RIGHT = r30;
        AutonumberScheme r31 = new AutonumberScheme("ROMAN_LOWERCASE_PERIOD", 31, STTextAutonumberScheme.q);
        ROMAN_LOWERCASE_PERIOD = r31;
        AutonumberScheme r32 = new AutonumberScheme("ROMAN_UPPERCASE_PARENTHESES_BOTH", 32, STTextAutonumberScheme.n);
        ROMAN_UPPERCASE_PARENTHESES_BOTH = r32;
        AutonumberScheme r33 = new AutonumberScheme("ROMAN_UPPERCASE_PARENTHESIS_RIGHT", 33, STTextAutonumberScheme.p);
        ROMAN_UPPERCASE_PARENTHESIS_RIGHT = r33;
        AutonumberScheme r34 = new AutonumberScheme("ROMAN_UPPERCASE_PERIOD", 34, STTextAutonumberScheme.r);
        ROMAN_UPPERCASE_PERIOD = r34;
        AutonumberScheme r35 = new AutonumberScheme("THAI_ALPHABETIC_PARENTHESES_BOTH", 35, STTextAutonumberScheme.f18653J);
        THAI_ALPHABETIC_PARENTHESES_BOTH = r35;
        AutonumberScheme r36 = new AutonumberScheme("THAI_ALPHABETIC_PARENTHESIS_RIGHT", 36, STTextAutonumberScheme.I);
        THAI_ALPHABETIC_PARENTHESIS_RIGHT = r36;
        AutonumberScheme r37 = new AutonumberScheme("THAI_ALPHABETIC_PERIOD", 37, STTextAutonumberScheme.H);
        THAI_ALPHABETIC_PERIOD = r37;
        AutonumberScheme r38 = new AutonumberScheme("THAI_NUMBER_PARENTHESES_BOTH", 38, STTextAutonumberScheme.M);
        THAI_NUMBER_PARENTHESES_BOTH = r38;
        AutonumberScheme r39 = new AutonumberScheme("THAI_NUMBER_PARENTHESIS_RIGHT", 39, STTextAutonumberScheme.L);
        THAI_NUMBER_PARENTHESIS_RIGHT = r39;
        AutonumberScheme r40 = new AutonumberScheme("THAI_NUMBER_PERIOD", 40, STTextAutonumberScheme.K);
        THAI_NUMBER_PERIOD = r40;
        $VALUES = new AutonumberScheme[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40};
        reverse = new HashMap();
        AutonumberScheme[] r41 = values();
        int r42 = r41.length;
        int r43 = 0;
    L3:
        if (r43 >= r42) goto L5;
        AutonumberScheme r44 = r41[r43];
        reverse.put(r44.underlying, r44);
        r43 = r43 + 1;
        goto L3
    }

    private AutonumberScheme(String r1, int r2, STTextAutonumberScheme.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static AutonumberScheme valueOf(String r2) {
        return (AutonumberScheme) ZeusTransformUtils.preCheckCast(Enum.valueOf(AutonumberScheme.class, r2), AutonumberScheme.class, "com.obric.memorydata.plugin");
    }

    static AutonumberScheme valueOf(STTextAutonumberScheme.Enum r2) {
        return (AutonumberScheme) ZeusTransformUtils.preCheckCast(reverse.get(r2), AutonumberScheme.class, "com.obric.memorydata.plugin");
    }

    public static AutonumberScheme[] values() {
        return (AutonumberScheme[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AutonumberScheme[].class, "com.obric.memorydata.plugin");
    }
}
