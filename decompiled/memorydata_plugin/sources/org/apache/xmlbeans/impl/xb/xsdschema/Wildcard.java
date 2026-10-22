package org.apache.xmlbeans.impl.xb.xsdschema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface Wildcard extends Annotated {
    public static final DocumentFactory<Wildcard> Factory = null;
    public static final SchemaType type = null;

    public interface ProcessContents extends XmlNMTOKEN {
        public static final ElementFactory<ProcessContents> Factory = null;
        public static final Enum LAX = null;
        public static final Enum SKIP = null;
        public static final Enum STRICT = null;
        public static final SchemaType type = null;

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_LAX = 2;
            static final int INT_SKIP = 1;
            static final int INT_STRICT = 3;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = null;

            static {
                table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("skip", 1), new Enum("lax", 2), new Enum("strict", 3)});
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
            ElementFactory<ProcessContents> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "processcontents864aattrtype");
            Factory = r0;
            type = r0.getType();
            SKIP = Enum.forString("skip");
            LAX = Enum.forString("lax");
            STRICT = Enum.forString("strict");
        }
    }

    static {
        DocumentFactory<Wildcard> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "wildcarde0b9type");
        Factory = r0;
        type = r0.getType();
    }
}
