package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STShd extends XmlString {
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
    public static final Enum f19865J = null;
    public static final Enum K = null;
    public static final Enum L = null;
    public static final Enum M = null;
    public static final Enum N = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STShd> f19866a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19867b = null;
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
        static final int INT_CLEAR = 2;
        static final int INT_DIAG_CROSS = 9;
        static final int INT_DIAG_STRIPE = 7;
        static final int INT_HORZ_CROSS = 8;
        static final int INT_HORZ_STRIPE = 4;
        static final int INT_NIL = 1;
        static final int INT_PCT_10 = 17;
        static final int INT_PCT_12 = 18;
        static final int INT_PCT_15 = 19;
        static final int INT_PCT_20 = 20;
        static final int INT_PCT_25 = 21;
        static final int INT_PCT_30 = 22;
        static final int INT_PCT_35 = 23;
        static final int INT_PCT_37 = 24;
        static final int INT_PCT_40 = 25;
        static final int INT_PCT_45 = 26;
        static final int INT_PCT_5 = 16;
        static final int INT_PCT_50 = 27;
        static final int INT_PCT_55 = 28;
        static final int INT_PCT_60 = 29;
        static final int INT_PCT_62 = 30;
        static final int INT_PCT_65 = 31;
        static final int INT_PCT_70 = 32;
        static final int INT_PCT_75 = 33;
        static final int INT_PCT_80 = 34;
        static final int INT_PCT_85 = 35;
        static final int INT_PCT_87 = 36;
        static final int INT_PCT_90 = 37;
        static final int INT_PCT_95 = 38;
        static final int INT_REVERSE_DIAG_STRIPE = 6;
        static final int INT_SOLID = 3;
        static final int INT_THIN_DIAG_CROSS = 15;
        static final int INT_THIN_DIAG_STRIPE = 13;
        static final int INT_THIN_HORZ_CROSS = 14;
        static final int INT_THIN_HORZ_STRIPE = 10;
        static final int INT_THIN_REVERSE_DIAG_STRIPE = 12;
        static final int INT_THIN_VERT_STRIPE = 11;
        static final int INT_VERT_STRIPE = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("nil", 1), new Enum("clear", 2), new Enum("solid", 3), new Enum("horzStripe", 4), new Enum("vertStripe", 5), new Enum("reverseDiagStripe", 6), new Enum("diagStripe", 7), new Enum("horzCross", 8), new Enum("diagCross", 9), new Enum("thinHorzStripe", 10), new Enum("thinVertStripe", 11), new Enum("thinReverseDiagStripe", 12), new Enum("thinDiagStripe", 13), new Enum("thinHorzCross", 14), new Enum("thinDiagCross", 15), new Enum("pct5", 16), new Enum("pct10", 17), new Enum("pct12", 18), new Enum("pct15", 19), new Enum("pct20", 20), new Enum("pct25", 21), new Enum("pct30", 22), new Enum("pct35", 23), new Enum("pct37", 24), new Enum("pct40", 25), new Enum("pct45", 26), new Enum("pct50", 27), new Enum("pct55", 28), new Enum("pct60", 29), new Enum("pct62", 30), new Enum("pct65", 31), new Enum("pct70", 32), new Enum("pct75", 33), new Enum("pct80", 34), new Enum("pct85", 35), new Enum("pct87", 36), new Enum("pct90", 37), new Enum("pct95", 38)});
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
        SimpleTypeFactory<STShd> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stshd14d3type");
        f19866a = r0;
        f19867b = r0.getType();
        c = Enum.forString("nil");
        d = Enum.forString("clear");
        e = Enum.forString("solid");
        f = Enum.forString("horzStripe");
        g = Enum.forString("vertStripe");
        h = Enum.forString("reverseDiagStripe");
        i = Enum.forString("diagStripe");
        j = Enum.forString("horzCross");
        k = Enum.forString("diagCross");
        l = Enum.forString("thinHorzStripe");
        m = Enum.forString("thinVertStripe");
        n = Enum.forString("thinReverseDiagStripe");
        o = Enum.forString("thinDiagStripe");
        p = Enum.forString("thinHorzCross");
        q = Enum.forString("thinDiagCross");
        r = Enum.forString("pct5");
        s = Enum.forString("pct10");
        t = Enum.forString("pct12");
        u = Enum.forString("pct15");
        v = Enum.forString("pct20");
        w = Enum.forString("pct25");
        x = Enum.forString("pct30");
        y = Enum.forString("pct35");
        z = Enum.forString("pct37");
        A = Enum.forString("pct40");
        B = Enum.forString("pct45");
        C = Enum.forString("pct50");
        D = Enum.forString("pct55");
        E = Enum.forString("pct60");
        F = Enum.forString("pct62");
        G = Enum.forString("pct65");
        H = Enum.forString("pct70");
        I = Enum.forString("pct75");
        f19865J = Enum.forString("pct80");
        K = Enum.forString("pct85");
        L = Enum.forString("pct87");
        M = Enum.forString("pct90");
        N = Enum.forString("pct95");
    }
}
