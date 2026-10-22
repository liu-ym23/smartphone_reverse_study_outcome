package org.openxmlformats.schemas.drawingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface STTextAutonumberScheme extends XmlToken {
    public static final Enum A = null;
    public static final Enum B = null;
    public static final Enum C = null;
    public static final Enum D = null;
    public static final Enum E = null;
    public static final Enum F = null;
    public static final Enum G = null;
    public static final Enum H = null;
    public static final Enum I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final Enum f18653J = null;
    public static final Enum K = null;
    public static final Enum L = null;
    public static final Enum M = null;
    public static final Enum N = null;
    public static final Enum O = null;
    public static final Enum P = null;
    public static final Enum Q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STTextAutonumberScheme> f18654a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18655b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;
    public static final Enum i = null;
    public static final Enum j = null;
    public static final Enum k = null;
    public static final Enum l = null;
    public static final Enum m = null;
    public static final Enum n = null;
    public static final Enum o = null;
    public static final Enum p = null;
    public static final Enum q = null;
    public static final Enum r = null;
    public static final Enum s = null;
    public static final Enum t = null;
    public static final Enum u = null;
    public static final Enum v = null;
    public static final Enum w = null;
    public static final Enum x = null;
    public static final Enum y = null;
    public static final Enum z = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ALPHA_LC_PAREN_BOTH = 1;
        static final int INT_ALPHA_LC_PAREN_R = 3;
        static final int INT_ALPHA_LC_PERIOD = 5;
        static final int INT_ALPHA_UC_PAREN_BOTH = 2;
        static final int INT_ALPHA_UC_PAREN_R = 4;
        static final int INT_ALPHA_UC_PERIOD = 6;
        static final int INT_ARABIC_1_MINUS = 29;
        static final int INT_ARABIC_2_MINUS = 30;
        static final int INT_ARABIC_DB_PERIOD = 20;
        static final int INT_ARABIC_DB_PLAIN = 21;
        static final int INT_ARABIC_PAREN_BOTH = 7;
        static final int INT_ARABIC_PAREN_R = 8;
        static final int INT_ARABIC_PERIOD = 9;
        static final int INT_ARABIC_PLAIN = 10;
        static final int INT_CIRCLE_NUM_DB_PLAIN = 17;
        static final int INT_CIRCLE_NUM_WD_BLACK_PLAIN = 18;
        static final int INT_CIRCLE_NUM_WD_WHITE_PLAIN = 19;
        static final int INT_EA_1_CHS_PERIOD = 22;
        static final int INT_EA_1_CHS_PLAIN = 23;
        static final int INT_EA_1_CHT_PERIOD = 24;
        static final int INT_EA_1_CHT_PLAIN = 25;
        static final int INT_EA_1_JPN_CHS_DB_PERIOD = 26;
        static final int INT_EA_1_JPN_KOR_PERIOD = 28;
        static final int INT_EA_1_JPN_KOR_PLAIN = 27;
        static final int INT_HEBREW_2_MINUS = 31;
        static final int INT_HINDI_ALPHA_1_PERIOD = 41;
        static final int INT_HINDI_ALPHA_PERIOD = 38;
        static final int INT_HINDI_NUM_PAREN_R = 40;
        static final int INT_HINDI_NUM_PERIOD = 39;
        static final int INT_ROMAN_LC_PAREN_BOTH = 11;
        static final int INT_ROMAN_LC_PAREN_R = 13;
        static final int INT_ROMAN_LC_PERIOD = 15;
        static final int INT_ROMAN_UC_PAREN_BOTH = 12;
        static final int INT_ROMAN_UC_PAREN_R = 14;
        static final int INT_ROMAN_UC_PERIOD = 16;
        static final int INT_THAI_ALPHA_PAREN_BOTH = 34;
        static final int INT_THAI_ALPHA_PAREN_R = 33;
        static final int INT_THAI_ALPHA_PERIOD = 32;
        static final int INT_THAI_NUM_PAREN_BOTH = 37;
        static final int INT_THAI_NUM_PAREN_R = 36;
        static final int INT_THAI_NUM_PERIOD = 35;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("alphaLcParenBoth", 1), new Enum("alphaUcParenBoth", 2), new Enum("alphaLcParenR", 3), new Enum("alphaUcParenR", 4), new Enum("alphaLcPeriod", 5), new Enum("alphaUcPeriod", 6), new Enum("arabicParenBoth", 7), new Enum("arabicParenR", 8), new Enum("arabicPeriod", 9), new Enum("arabicPlain", 10), new Enum("romanLcParenBoth", 11), new Enum("romanUcParenBoth", 12), new Enum("romanLcParenR", 13), new Enum("romanUcParenR", 14), new Enum("romanLcPeriod", 15), new Enum("romanUcPeriod", 16), new Enum("circleNumDbPlain", 17), new Enum("circleNumWdBlackPlain", 18), new Enum("circleNumWdWhitePlain", 19), new Enum("arabicDbPeriod", 20), new Enum("arabicDbPlain", 21), new Enum("ea1ChsPeriod", 22), new Enum("ea1ChsPlain", 23), new Enum("ea1ChtPeriod", 24), new Enum("ea1ChtPlain", 25), new Enum("ea1JpnChsDbPeriod", 26), new Enum("ea1JpnKorPlain", 27), new Enum("ea1JpnKorPeriod", 28), new Enum("arabic1Minus", 29), new Enum("arabic2Minus", 30), new Enum("hebrew2Minus", 31), new Enum("thaiAlphaPeriod", 32), new Enum("thaiAlphaParenR", 33), new Enum("thaiAlphaParenBoth", 34), new Enum("thaiNumPeriod", 35), new Enum("thaiNumParenR", 36), new Enum("thaiNumParenBoth", 37), new Enum("hindiAlphaPeriod", 38), new Enum("hindiNumPeriod", 39), new Enum("hindiNumParenR", 40), new Enum("hindiAlpha1Period", 41)});
        }

        private Enum(String r1, int r2) {
            super(r1, r2);
        }

        public static Enum forInt(int r2) {
            return (Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), Enum.class, "com.obric.memorydata.plugin");
        }

        public static Enum forString(String r2) {
            return (Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), Enum.class, "com.obric.memorydata.plugin");
        }

        private Object readResolve() {
            return forInt(intValue());
        }
    }

    static {
        SimpleTypeFactory<STTextAutonumberScheme> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "sttextautonumberschemed675type");
        f18654a = r0;
        f18655b = r0.getType();
        c = Enum.forString("alphaLcParenBoth");
        d = Enum.forString("alphaUcParenBoth");
        e = Enum.forString("alphaLcParenR");
        f = Enum.forString("alphaUcParenR");
        g = Enum.forString("alphaLcPeriod");
        h = Enum.forString("alphaUcPeriod");
        i = Enum.forString("arabicParenBoth");
        j = Enum.forString("arabicParenR");
        k = Enum.forString("arabicPeriod");
        l = Enum.forString("arabicPlain");
        m = Enum.forString("romanLcParenBoth");
        n = Enum.forString("romanUcParenBoth");
        o = Enum.forString("romanLcParenR");
        p = Enum.forString("romanUcParenR");
        q = Enum.forString("romanLcPeriod");
        r = Enum.forString("romanUcPeriod");
        s = Enum.forString("circleNumDbPlain");
        t = Enum.forString("circleNumWdBlackPlain");
        u = Enum.forString("circleNumWdWhitePlain");
        v = Enum.forString("arabicDbPeriod");
        w = Enum.forString("arabicDbPlain");
        x = Enum.forString("ea1ChsPeriod");
        y = Enum.forString("ea1ChsPlain");
        z = Enum.forString("ea1ChtPeriod");
        A = Enum.forString("ea1ChtPlain");
        B = Enum.forString("ea1JpnChsDbPeriod");
        C = Enum.forString("ea1JpnKorPlain");
        D = Enum.forString("ea1JpnKorPeriod");
        E = Enum.forString("arabic1Minus");
        F = Enum.forString("arabic2Minus");
        G = Enum.forString("hebrew2Minus");
        H = Enum.forString("thaiAlphaPeriod");
        I = Enum.forString("thaiAlphaParenR");
        f18653J = Enum.forString("thaiAlphaParenBoth");
        K = Enum.forString("thaiNumPeriod");
        L = Enum.forString("thaiNumParenR");
        M = Enum.forString("thaiNumParenBoth");
        N = Enum.forString("hindiAlphaPeriod");
        O = Enum.forString("hindiNumPeriod");
        P = Enum.forString("hindiNumParenR");
        Q = Enum.forString("hindiAlpha1Period");
    }
}
