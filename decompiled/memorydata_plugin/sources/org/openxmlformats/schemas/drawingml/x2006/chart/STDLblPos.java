package org.openxmlformats.schemas.drawingml.x2006.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface STDLblPos extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STDLblPos> f18344a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18345b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;
    public static final Enum i = null;
    public static final Enum j = null;
    public static final Enum k = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_B = 2;
        static final int INT_BEST_FIT = 1;
        static final int INT_CTR = 3;
        static final int INT_IN_BASE = 4;
        static final int INT_IN_END = 5;
        static final int INT_L = 6;
        static final int INT_OUT_END = 7;
        static final int INT_R = 8;
        static final int INT_T = 9;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("bestFit", 1), new Enum("b", 2), new Enum("ctr", 3), new Enum("inBase", 4), new Enum("inEnd", 5), new Enum("l", 6), new Enum("outEnd", 7), new Enum("r", 8), new Enum("t", 9)});
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
        SimpleTypeFactory<STDLblPos> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stdlblpos1cf4type");
        f18344a = r0;
        f18345b = r0.getType();
        c = Enum.forString("bestFit");
        d = Enum.forString("b");
        e = Enum.forString("ctr");
        f = Enum.forString("inBase");
        g = Enum.forString("inEnd");
        h = Enum.forString("l");
        i = Enum.forString("outEnd");
        j = Enum.forString("r");
        k = Enum.forString("t");
    }
}
