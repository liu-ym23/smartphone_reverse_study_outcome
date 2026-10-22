package org.openxmlformats.schemas.presentationml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STSlideSizeType extends XmlToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STSlideSizeType> f19187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19188b = null;
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

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_A_3 = 9;
        static final int INT_A_4 = 3;
        static final int INT_BANNER = 6;
        static final int INT_B_4_ISO = 10;
        static final int INT_B_4_JIS = 12;
        static final int INT_B_5_ISO = 11;
        static final int INT_B_5_JIS = 13;
        static final int INT_CUSTOM = 7;
        static final int INT_HAGAKI_CARD = 14;
        static final int INT_LEDGER = 8;
        static final int INT_LETTER = 2;
        static final int INT_OVERHEAD = 5;
        static final int INT_SCREEN_16_X_10 = 16;
        static final int INT_SCREEN_16_X_9 = 15;
        static final int INT_SCREEN_4_X_3 = 1;
        static final int INT_X_35_MM = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("screen4x3", 1), new Enum("letter", 2), new Enum("A4", 3), new Enum("35mm", 4), new Enum("overhead", 5), new Enum("banner", 6), new Enum("custom", 7), new Enum("ledger", 8), new Enum("A3", 9), new Enum("B4ISO", 10), new Enum("B5ISO", 11), new Enum("B4JIS", 12), new Enum("B5JIS", 13), new Enum("hagakiCard", 14), new Enum("screen16x9", 15), new Enum("screen16x10", 16)});
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
        SimpleTypeFactory<STSlideSizeType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stslidesizetypeb7f3type");
        f19187a = r0;
        f19188b = r0.getType();
        c = Enum.forString("screen4x3");
        d = Enum.forString("letter");
        e = Enum.forString("A4");
        f = Enum.forString("35mm");
        g = Enum.forString("overhead");
        h = Enum.forString("banner");
        i = Enum.forString("custom");
        j = Enum.forString("ledger");
        k = Enum.forString("A3");
        l = Enum.forString("B4ISO");
        m = Enum.forString("B5ISO");
        n = Enum.forString("B4JIS");
        o = Enum.forString("B5JIS");
        p = Enum.forString("hagakiCard");
        q = Enum.forString("screen16x9");
        r = Enum.forString("screen16x10");
    }
}
