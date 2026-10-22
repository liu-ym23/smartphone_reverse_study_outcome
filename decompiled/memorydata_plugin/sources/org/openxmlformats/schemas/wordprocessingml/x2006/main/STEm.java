package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STEm extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STEm> f19816a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19817b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CIRCLE = 4;
        static final int INT_COMMA = 3;
        static final int INT_DOT = 2;
        static final int INT_NONE = 1;
        static final int INT_UNDER_DOT = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("dot", 2), new Enum("comma", 3), new Enum("circle", 4), new Enum("underDot", 5)});
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
        SimpleTypeFactory<STEm> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stem5e70type");
        f19816a = r0;
        f19817b = r0.getType();
        c = Enum.forString("none");
        d = Enum.forString("dot");
        e = Enum.forString("comma");
        f = Enum.forString("circle");
        g = Enum.forString("underDot");
    }
}
