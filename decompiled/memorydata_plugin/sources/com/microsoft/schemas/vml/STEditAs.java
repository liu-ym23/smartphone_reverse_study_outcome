package com.microsoft.schemas.vml;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface STEditAs extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STEditAs> f5763a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5764b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;
    public static final Enum i = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BULLSEYE = 7;
        static final int INT_CANVAS = 1;
        static final int INT_CYCLE = 4;
        static final int INT_ORGCHART = 2;
        static final int INT_RADIAL = 3;
        static final int INT_STACKED = 5;
        static final int INT_VENN = 6;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("canvas", 1), new Enum("orgchart", 2), new Enum("radial", 3), new Enum("cycle", 4), new Enum("stacked", 5), new Enum("venn", 6), new Enum("bullseye", 7)});
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
        SimpleTypeFactory<STEditAs> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "steditas85aatype");
        f5763a = r0;
        f5764b = r0.getType();
        c = Enum.forString("canvas");
        d = Enum.forString("orgchart");
        e = Enum.forString("radial");
        f = Enum.forString("cycle");
        g = Enum.forString("stacked");
        h = Enum.forString("venn");
        i = Enum.forString("bullseye");
    }
}
