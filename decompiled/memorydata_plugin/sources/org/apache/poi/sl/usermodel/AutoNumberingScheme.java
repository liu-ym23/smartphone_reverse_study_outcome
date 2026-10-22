package org.apache.poi.sl.usermodel;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.tom_roush.pdfbox.pdmodel.a.c.a;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public final enum AutoNumberingScheme extends Enum<AutoNumberingScheme> {
    private static final /* synthetic */ AutoNumberingScheme[] $VALUES = null;
    private static final String ALPHA_LIST = "abcdefghijklmnopqrstuvwxyz";
    private static final String ARABIC_LIST = "0123456789";
    private static final String CIRCLE_DB_LIST = "❶❷❸❹❺❻❼❽❾";
    private static final String WINGDINGS_BLACK_LIST = "\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094";
    private static final String WINGDINGS_WHITE_LIST = "\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089";
    public static final AutoNumberingScheme alphaLcParenBoth = null;
    public static final AutoNumberingScheme alphaLcParenRight = null;
    public static final AutoNumberingScheme alphaLcPeriod = null;
    public static final AutoNumberingScheme alphaUcParenBoth = null;
    public static final AutoNumberingScheme alphaUcParenRight = null;
    public static final AutoNumberingScheme alphaUcPeriod = null;
    public static final AutoNumberingScheme arabic1Minus = null;
    public static final AutoNumberingScheme arabic2Minus = null;
    public static final AutoNumberingScheme arabicDbPeriod = null;
    public static final AutoNumberingScheme arabicDbPlain = null;
    public static final AutoNumberingScheme arabicParenBoth = null;
    public static final AutoNumberingScheme arabicParenRight = null;
    public static final AutoNumberingScheme arabicPeriod = null;
    public static final AutoNumberingScheme arabicPlain = null;
    public static final AutoNumberingScheme circleNumDbPlain = null;
    public static final AutoNumberingScheme circleNumWdBlackPlain = null;
    public static final AutoNumberingScheme circleNumWdWhitePlain = null;
    public static final AutoNumberingScheme ea1ChsPeriod = null;
    public static final AutoNumberingScheme ea1ChsPlain = null;
    public static final AutoNumberingScheme ea1ChtPeriod = null;
    public static final AutoNumberingScheme ea1ChtPlain = null;
    public static final AutoNumberingScheme ea1JpnChsDbPeriod = null;
    public static final AutoNumberingScheme ea1JpnKorPeriod = null;
    public static final AutoNumberingScheme ea1JpnKorPlain = null;
    public static final AutoNumberingScheme hebrew2Minus = null;
    public static final AutoNumberingScheme hindiAlpha1Period = null;
    public static final AutoNumberingScheme hindiAlphaPeriod = null;
    public static final AutoNumberingScheme hindiNumParenRight = null;
    public static final AutoNumberingScheme hindiNumPeriod = null;
    public static final AutoNumberingScheme romanLcParenBoth = null;
    public static final AutoNumberingScheme romanLcParenRight = null;
    public static final AutoNumberingScheme romanLcPeriod = null;
    public static final AutoNumberingScheme romanUcParenBoth = null;
    public static final AutoNumberingScheme romanUcParenRight = null;
    public static final AutoNumberingScheme romanUcPeriod = null;
    public static final AutoNumberingScheme thaiAlphaParenBoth = null;
    public static final AutoNumberingScheme thaiAlphaParenRight = null;
    public static final AutoNumberingScheme thaiAlphaPeriod = null;
    public static final AutoNumberingScheme thaiNumParenBoth = null;
    public static final AutoNumberingScheme thaiNumParenRight = null;
    public static final AutoNumberingScheme thaiNumPeriod = null;
    public final int nativeId;
    public final int ooxmlId;

    /* JADX INFO: renamed from: org.apache.poi.sl.usermodel.AutoNumberingScheme$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme = null;

        static {
            int[] r0 = new int[AutoNumberingScheme.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme = r0;
            r0[AutoNumberingScheme.alphaLcPeriod.ordinal()] = 1;     // Catch: NoSuchFieldError -> L45
        L112:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.alphaUcPeriod.ordinal()] = 2;     // Catch: NoSuchFieldError -> L46
        L138:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.arabicParenRight.ordinal()] = 3;     // Catch: NoSuchFieldError -> L47
        L148:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.arabicPeriod.ordinal()] = 4;     // Catch: NoSuchFieldError -> L48
        L154:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.romanLcParenBoth.ordinal()] = 5;     // Catch: NoSuchFieldError -> L49
        L94:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.romanLcParenRight.ordinal()] = 6;     // Catch: NoSuchFieldError -> L50
        L100:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.romanLcPeriod.ordinal()] = 7;     // Catch: NoSuchFieldError -> L51
        L126:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.romanUcPeriod.ordinal()] = 8;     // Catch: NoSuchFieldError -> L52
        L132:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.alphaLcParenBoth.ordinal()] = 9;     // Catch: NoSuchFieldError -> L53
        L158:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.alphaLcParenRight.ordinal()] = 10;     // Catch: NoSuchFieldError -> L54
        L162:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.alphaUcParenBoth.ordinal()] = 11;     // Catch: NoSuchFieldError -> L55
        L104:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.alphaUcParenRight.ordinal()] = 12;     // Catch: NoSuchFieldError -> L56
        L110:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.arabicParenBoth.ordinal()] = 13;     // Catch: NoSuchFieldError -> L57
        L136:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.arabicPlain.ordinal()] = 14;     // Catch: NoSuchFieldError -> L58
        L142:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.romanUcParenBoth.ordinal()] = 15;     // Catch: NoSuchFieldError -> L59
        L166:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.romanUcParenRight.ordinal()] = 16;     // Catch: NoSuchFieldError -> L60
        L88:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.ea1ChsPlain.ordinal()] = 17;     // Catch: NoSuchFieldError -> L61
        L116:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.ea1ChsPeriod.ordinal()] = 18;     // Catch: NoSuchFieldError -> L62
        L120:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.circleNumDbPlain.ordinal()] = 19;     // Catch: NoSuchFieldError -> L63
        L146:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.circleNumWdWhitePlain.ordinal()] = 20;     // Catch: NoSuchFieldError -> L64
        L152:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.circleNumWdBlackPlain.ordinal()] = 21;     // Catch: NoSuchFieldError -> L65
        L92:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.ea1ChtPlain.ordinal()] = 22;     // Catch: NoSuchFieldError -> L66
        L98:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.ea1ChtPeriod.ordinal()] = 23;     // Catch: NoSuchFieldError -> L67
        L124:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.arabic1Minus.ordinal()] = 24;     // Catch: NoSuchFieldError -> L68
        L130:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.arabic2Minus.ordinal()] = 25;     // Catch: NoSuchFieldError -> L69
        L156:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.hebrew2Minus.ordinal()] = 26;     // Catch: NoSuchFieldError -> L70
        L160:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.ea1JpnKorPlain.ordinal()] = 27;     // Catch: NoSuchFieldError -> L71
        L102:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.ea1JpnKorPeriod.ordinal()] = 28;     // Catch: NoSuchFieldError -> L72
        L108:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.arabicDbPlain.ordinal()] = 29;     // Catch: NoSuchFieldError -> L73
        L134:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.arabicDbPeriod.ordinal()] = 30;     // Catch: NoSuchFieldError -> L74
        L140:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.thaiAlphaPeriod.ordinal()] = 31;     // Catch: NoSuchFieldError -> L75
        L164:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.thaiAlphaParenRight.ordinal()] = 32;     // Catch: NoSuchFieldError -> L76
        L86:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.thaiAlphaParenBoth.ordinal()] = 33;     // Catch: NoSuchFieldError -> L77
        L114:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.thaiNumPeriod.ordinal()] = 34;     // Catch: NoSuchFieldError -> L78
        L118:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.thaiNumParenRight.ordinal()] = 35;     // Catch: NoSuchFieldError -> L79
        L144:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.thaiNumParenBoth.ordinal()] = 36;     // Catch: NoSuchFieldError -> L80
        L150:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.hindiAlphaPeriod.ordinal()] = 37;     // Catch: NoSuchFieldError -> L81
        L90:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.hindiNumPeriod.ordinal()] = 38;     // Catch: NoSuchFieldError -> L82
        L96:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.ea1JpnChsDbPeriod.ordinal()] = 39;     // Catch: NoSuchFieldError -> L83
        L122:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.hindiNumParenRight.ordinal()] = 40;     // Catch: NoSuchFieldError -> L84
        L128:
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.hindiAlpha1Period.ordinal()] = 41;     // Catch: NoSuchFieldError -> L85
            return;
        }
    }

    static {
        AutoNumberingScheme r0 = new AutoNumberingScheme("alphaLcParenBoth", 0, 8, 1);
        alphaLcParenBoth = r0;
        AutoNumberingScheme r1 = new AutoNumberingScheme("alphaUcParenBoth", 1, 10, 2);
        alphaUcParenBoth = r1;
        AutoNumberingScheme r2 = new AutoNumberingScheme("alphaLcParenRight", 2, 9, 3);
        alphaLcParenRight = r2;
        AutoNumberingScheme r7 = new AutoNumberingScheme("alphaUcParenRight", 3, 11, 4);
        alphaUcParenRight = r7;
        AutoNumberingScheme r10 = new AutoNumberingScheme("alphaLcPeriod", 4, 0, 5);
        alphaLcPeriod = r10;
        AutoNumberingScheme r13 = new AutoNumberingScheme("alphaUcPeriod", 5, 1, 6);
        alphaUcPeriod = r13;
        AutoNumberingScheme r14 = new AutoNumberingScheme("arabicParenBoth", 6, 12, 7);
        arabicParenBoth = r14;
        AutoNumberingScheme r4 = new AutoNumberingScheme("arabicParenRight", 7, 2, 8);
        arabicParenRight = r4;
        AutoNumberingScheme r11 = new AutoNumberingScheme("arabicPeriod", 8, 3, 9);
        arabicPeriod = r11;
        AutoNumberingScheme r6 = new AutoNumberingScheme("arabicPlain", 9, 13, 10);
        arabicPlain = r6;
        AutoNumberingScheme r3 = new AutoNumberingScheme("romanLcParenBoth", 10, 4, 11);
        romanLcParenBoth = r3;
        AutoNumberingScheme r8 = new AutoNumberingScheme("romanUcParenBoth", 11, 14, 12);
        romanUcParenBoth = r8;
        AutoNumberingScheme r9 = new AutoNumberingScheme("romanLcParenRight", 12, 5, 13);
        romanLcParenRight = r9;
        AutoNumberingScheme r12 = new AutoNumberingScheme("romanUcParenRight", 13, 15, 14);
        romanUcParenRight = r12;
        AutoNumberingScheme r5 = new AutoNumberingScheme("romanLcPeriod", 14, 6, 15);
        romanLcPeriod = r5;
        AutoNumberingScheme r15 = new AutoNumberingScheme("romanUcPeriod", 15, 7, 16);
        romanUcPeriod = r15;
        AutoNumberingScheme r16 = new AutoNumberingScheme("circleNumDbPlain", 16, 18, 17);
        circleNumDbPlain = r16;
        AutoNumberingScheme r17 = new AutoNumberingScheme("circleNumWdBlackPlain", 17, 20, 18);
        circleNumWdBlackPlain = r17;
        AutoNumberingScheme r18 = new AutoNumberingScheme("circleNumWdWhitePlain", 18, 19, 19);
        circleNumWdWhitePlain = r18;
        AutoNumberingScheme r19 = new AutoNumberingScheme("arabicDbPeriod", 19, 29, 20);
        arabicDbPeriod = r19;
        AutoNumberingScheme r110 = new AutoNumberingScheme("arabicDbPlain", 20, 28, 21);
        arabicDbPlain = r110;
        AutoNumberingScheme r20 = new AutoNumberingScheme("ea1ChsPeriod", 21, 17, 22);
        ea1ChsPeriod = r20;
        AutoNumberingScheme r21 = new AutoNumberingScheme("ea1ChsPlain", 22, 16, 23);
        ea1ChsPlain = r21;
        AutoNumberingScheme r22 = new AutoNumberingScheme("ea1ChtPeriod", 23, 21, 24);
        ea1ChtPeriod = r22;
        AutoNumberingScheme r23 = new AutoNumberingScheme("ea1ChtPlain", 24, 20, 25);
        ea1ChtPlain = r23;
        AutoNumberingScheme r24 = new AutoNumberingScheme("ea1JpnChsDbPeriod", 25, 38, 26);
        ea1JpnChsDbPeriod = r24;
        AutoNumberingScheme r25 = new AutoNumberingScheme("ea1JpnKorPlain", 26, 26, 27);
        ea1JpnKorPlain = r25;
        AutoNumberingScheme r26 = new AutoNumberingScheme("ea1JpnKorPeriod", 27, 27, 28);
        ea1JpnKorPeriod = r26;
        AutoNumberingScheme r27 = new AutoNumberingScheme("arabic1Minus", 28, 23, 29);
        arabic1Minus = r27;
        AutoNumberingScheme r28 = new AutoNumberingScheme("arabic2Minus", 29, 24, 30);
        arabic2Minus = r28;
        AutoNumberingScheme r29 = new AutoNumberingScheme("hebrew2Minus", 30, 25, 31);
        hebrew2Minus = r29;
        AutoNumberingScheme r30 = new AutoNumberingScheme("thaiAlphaPeriod", 31, 30, 32);
        thaiAlphaPeriod = r30;
        AutoNumberingScheme r31 = new AutoNumberingScheme("thaiAlphaParenRight", 32, 31, 33);
        thaiAlphaParenRight = r31;
        AutoNumberingScheme r32 = new AutoNumberingScheme("thaiAlphaParenBoth", 33, 32, 34);
        thaiAlphaParenBoth = r32;
        AutoNumberingScheme r33 = new AutoNumberingScheme("thaiNumPeriod", 34, 33, 35);
        thaiNumPeriod = r33;
        AutoNumberingScheme r34 = new AutoNumberingScheme("thaiNumParenRight", 35, 34, 36);
        thaiNumParenRight = r34;
        AutoNumberingScheme r35 = new AutoNumberingScheme("thaiNumParenBoth", 36, 35, 37);
        thaiNumParenBoth = r35;
        AutoNumberingScheme r36 = new AutoNumberingScheme("hindiAlphaPeriod", 37, 36, 38);
        hindiAlphaPeriod = r36;
        AutoNumberingScheme r37 = new AutoNumberingScheme("hindiNumPeriod", 38, 37, 39);
        hindiNumPeriod = r37;
        AutoNumberingScheme r38 = new AutoNumberingScheme("hindiNumParenRight", 39, 39, 40);
        hindiNumParenRight = r38;
        AutoNumberingScheme r111 = new AutoNumberingScheme("hindiAlpha1Period", 40, 39, 41);
        hindiAlpha1Period = r111;
        $VALUES = new AutoNumberingScheme[]{r0, r1, r2, r7, r10, r13, r14, r4, r11, r6, r3, r8, r9, r12, r5, r15, r16, r17, r18, r19, r110, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r111};
    }

    private AutoNumberingScheme(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.nativeId = r3;
        this.ooxmlId = r4;
    }

    private static void addIndexedChar(int r2, String r3, boolean r4, StringBuilder r5) {
        if (r4 == false) goto L4;
        r2 = r2 - 1;
    L4:
        int r0 = r3.length();
        if (r2 < r0) goto L7;
        addIndexedChar(r2 / r0, r3, r4, r5);
    L7:
        r5.append(r3.charAt(r2 % r0));
    }

    public static AutoNumberingScheme forNativeID(int r5) {
        AutoNumberingScheme[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        AutoNumberingScheme r3 = r0[r2];
        if (r3.nativeId == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static AutoNumberingScheme forOoxmlID(int r5) {
        AutoNumberingScheme[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        AutoNumberingScheme r3 = r0[r2];
        if (r3.ooxmlId == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    private String formatCase(String r2) {
        String r1 = name().toLowerCase(Locale.ROOT);
        if (r1.contains("lc") == false) goto L7;
        return r2.toLowerCase(Locale.ROOT);
    L7:
        if (r1.contains("uc") == true) goto L9;
        return r2;
    L9:
        return r2.toUpperCase(Locale.ROOT);
    }

    private String formatIndex(int r5) {
        String r0 = name().toLowerCase(Locale.ROOT);
        if (r0.startsWith("roman") == false) goto L7;
        return formatRomanIndex(r5);
    L7:
        if (r0.startsWith("arabic") == false) goto L13;
        if (r0.contains("db") == true) goto L13;
        return getIndexedList(r5, ARABIC_LIST, false);
    L13:
        if (r0.startsWith("alpha") == false) goto L17;
        return getIndexedList(r5, ALPHA_LIST, true);
    L17:
        if (r0.contains("wdwhite") == false) goto L23;
        if (r5 != 10) goto L21;
        return "\u008a";
    L21:
        return getIndexedList(r5, WINGDINGS_WHITE_LIST, false);
    L23:
        if (r0.contains("wdblack") == false) goto L29;
        if (r5 != 10) goto L27;
        return "\u0095";
    L27:
        return getIndexedList(r5, WINGDINGS_BLACK_LIST, false);
    L29:
        if (r0.contains("numdb") == false) goto L34;
        if (r5 != 10) goto L33;
        return "❿";
    L33:
        return getIndexedList(r5, CIRCLE_DB_LIST, true);
    L34:
        return "?";
    }

    private String formatRomanIndex(int r15) {
        int[] r0 = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] r1 = {"M", "CM", a.f16161b, "CD", "C", "XC", i.u, "XL", "X", "IX", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "IV", "I"};
        String[][] r3 = {new String[]{"XLV", "VL"}, new String[]{"XCV", "VC"}, new String[]{"CDL", "LD"}, new String[]{"CML", "LM"}, new String[]{"CMVC", "LMVL"}, new String[]{"CDXC", "LDXL"}, new String[]{"CDVC", "LDVL"}, new String[]{"CMXC", "LMXL"}, new String[]{"XCIX", "VCIV"}, new String[]{"XLIX", "VLIV"}, new String[]{"XLIX", "IL"}, new String[]{"XCIX", "IC"}, new String[]{"CDXC", "XD"}, new String[]{"CDVC", "XDV"}, new String[]{"CDIC", "XDIX"}, new String[]{"LMVL", "XMV"}, new String[]{"CMIC", "XMIX"}, new String[]{"CMXC", "XM"}, new String[]{"XDV", "VD"}, new String[]{"XDIX", "VDIV"}, new String[]{"XMV", "VM"}, new String[]{"XMIX", "VMIV"}, new String[]{"VDIV", "ID"}, new String[]{"VMIV", "IM"}};
        StringBuilder r4 = new StringBuilder();
        int r7 = 0;
    L3:
        if (r7 >= 13) goto L8;
    L5:
        if (r15 < r0[r7]) goto L7;
        r15 = r15 - r0[r7];
        r4.append(r1[r7]);
        goto L5
    L7:
        r7 = r7 + 1;
        goto L3
    L8:
        String r14 = r4.toString();
        int r16 = 0;
    L9:
        if (r16 >= 24) goto L11;
        String[] r2 = r3[r16];
        r14 = r14.replace(r2[0], r2[1]);
        r16 = r16 + 1;
        goto L9
    L11:
        return r14;
    }

    private String formatSeperator(String r3) {
        String r2 = name().toLowerCase(Locale.ROOT);
        if (r2.contains("plain") == false) goto L6;
        return r3;
    L6:
        if (r2.contains("parenright") == false) goto L12;
        StringBuilder r4 = new StringBuilder();
    L8:
        StringBuilder r5 = r4.append(r3).append(")");
    L10:
        return r5.toString();
    L12:
        if (r2.contains("parenboth") == false) goto L15;
        r4 = new StringBuilder().append("(");
        goto L8
    L15:
        if (r2.contains(TypedValues.CycleType.S_WAVE_PERIOD) == false) goto L19;
        StringBuilder r6 = new StringBuilder().append(r3);
        String r7 = ".";
    L17:
        r5 = r6.append(r7);
        goto L10
    L19:
        if (r2.contains("minus") == false) goto L21;
        r6 = new StringBuilder().append(r3);
        r7 = "-";
        goto L17
    L21:
        return r3;
    }

    private static String getIndexedList(int r1, String r2, boolean r3) {
        StringBuilder r0 = new StringBuilder();
        addIndexedChar(r1, r2, r3, r0);
        return r0.toString();
    }

    public static AutoNumberingScheme valueOf(String r2) {
        return (AutoNumberingScheme) ZeusTransformUtils.preCheckCast(Enum.valueOf(AutoNumberingScheme.class, r2), AutoNumberingScheme.class, "com.obric.memorydata.plugin");
    }

    public static AutoNumberingScheme[] values() {
        return (AutoNumberingScheme[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AutoNumberingScheme[].class, "com.obric.memorydata.plugin");
    }

    public String format(int r1) {
        return formatSeperator(formatCase(formatIndex(r1)));
    }

    public String getDescription() {
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[ordinal()]) {
            case 1: goto L84;
            case 2: goto L82;
            case 3: goto L80;
            case 4: goto L78;
            case 5: goto L76;
            case 6: goto L74;
            case 7: goto L72;
            case 8: goto L70;
            case 9: goto L68;
            case 10: goto L66;
            case 11: goto L64;
            case 12: goto L62;
            case 13: goto L60;
            case 14: goto L58;
            case 15: goto L56;
            case 16: goto L54;
            case 17: goto L52;
            case 18: goto L50;
            case 19: goto L48;
            case 20: goto L46;
            case 21: goto L44;
            case 22: goto L42;
            case 23: goto L40;
            case 24: goto L38;
            case 25: goto L36;
            case 26: goto L34;
            case 27: goto L32;
            case 28: goto L30;
            case 29: goto L28;
            case 30: goto L26;
            case 31: goto L24;
            case 32: goto L22;
            case 33: goto L20;
            case 34: goto L18;
            case 35: goto L16;
            case 36: goto L14;
            case 37: goto L13;
            case 38: goto L11;
            case 39: goto L9;
            case 40: goto L7;
            case 41: goto L6;
            default: goto L4;
        };
    L4:
        return "Unknown Numbered Scheme";
    L6:
        return "Hindi alphabetic character followed by a period.";
    L7:
        return "Hindi numeric character followed by a closing parenthesis.";
    L9:
        return "Japanese with double-byte period.";
    L11:
        return "Hindi numeric character followed by a period.";
    L13:
        return "Hindi alphabetic character followed by a period.";
    L14:
        return "Thai numeral enclosed in parentheses.";
    L16:
        return "Thai numeral followed by a closing parenthesis.";
    L18:
        return "Thai numeral followed by a period.";
    L20:
        return "Thai alphabetic character enclosed by parentheses.";
    L22:
        return "Thai alphabetic character followed by a closing parenthesis.";
    L24:
        return "Thai alphabetic character followed by a period.";
    L26:
        return "Double-byte Arabic numbers with double-byte period.";
    L28:
        return "Double-byte Arabic numbers.";
    L30:
        return "Japanese/Korean with single-byte period.";
    L32:
        return "Japanese/Korean.";
    L34:
        return "Bidi Hebrew 2 with ANSI minus symbol.";
    L36:
        return "Bidi Arabic 2 (AraAbjad) with ANSI minus symbol.";
    L38:
        return "Bidi Arabic 1 (AraAlpha) with ANSI minus symbol.";
    L40:
        return "Traditional Chinese with single-byte period.";
    L42:
        return "Traditional Chinese.";
    L44:
        return "Wingdings black circle numbers.";
    L46:
        return "Wingdings white circle numbers.";
    L48:
        return "Double byte circle numbers.";
    L50:
        return "Simplified Chinese with single-byte period.";
    L52:
        return "Simplified Chinese.";
    L54:
        return "Uppercase Roman numeral followed by a closing parenthesis. Example: I), II), III), ...";
    L56:
        return "Uppercase Roman numeral enclosed in parentheses. Example: (I), (II), (III), ...";
    L58:
        return "Arabic numeral. Example: 1, 2, 3, ...";
    L60:
        return "Arabic numeral enclosed in parentheses. Example: (1), (2), (3), ...";
    L62:
        return "Uppercase alphabetic character followed by a closing parenthesis. Example: A), B), C), ...";
    L64:
        return "Uppercase alphabetic character enclosed in parentheses. Example: (A), (B), (C), ...";
    L66:
        return "Lowercase alphabetic character followed by a closing parenthesis. Example: a), b), c), ...";
    L68:
        return "Lowercase alphabetic character enclosed in parentheses. Example: (a), (b), (c), ...";
    L70:
        return "Uppercase Roman numeral followed by a period. Example: I., II., III., ...";
    L72:
        return "Lowercase Roman numeral followed by a period. Example: i., ii., iii., ...";
    L74:
        return "Lowercase Roman numeral followed by a closing parenthesis. Example: i), ii), iii), ...";
    L76:
        return "Lowercase Roman numeral enclosed in parentheses. Example: (i), (ii), (iii), ...";
    L78:
        return "Arabic numeral followed by a period. Example: 1., 2., 3., ...";
    L80:
        return "Arabic numeral followed by a closing parenthesis. Example: 1), 2), 3), ...";
    L82:
        return "Uppercase Latin character followed by a period. Example: A., B., C., ...";
    L84:
        return "Lowercase Latin character followed by a period. Example: a., b., c., ...";
    }
}
