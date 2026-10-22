package org.apache.xmlbeans.impl.xb.xsdschema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface AllNNI extends XmlAnySimpleType {
    public static final SimpleTypeFactory<AllNNI> Factory = null;
    public static final SchemaType type = null;

    public interface Member extends XmlNMTOKEN {
        public static final ElementFactory<Member> Factory = null;
        public static final Enum UNBOUNDED = null;
        public static final SchemaType type = null;

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_UNBOUNDED = 1;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = null;

            static {
                table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("unbounded", 1)});
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
            ElementFactory<Member> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "anon0330type");
            Factory = r0;
            type = r0.getType();
            UNBOUNDED = Enum.forString("unbounded");
        }
    }

    static {
        SimpleTypeFactory<AllNNI> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "allnni78cbtype");
        Factory = r0;
        type = r0.getType();
    }
}
