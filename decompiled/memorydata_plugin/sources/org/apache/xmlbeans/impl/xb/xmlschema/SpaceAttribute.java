package org.apache.xmlbeans.impl.xb.xmlschema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLLANG.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface SpaceAttribute extends XmlObject {
    public static final DocumentFactory<SpaceAttribute> Factory = null;
    public static final SchemaType type = null;

    public interface Space extends XmlNCName {
        public static final Enum DEFAULT = null;
        public static final ElementFactory<Space> Factory = null;
        public static final Enum PRESERVE = null;
        public static final SchemaType type = null;

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_DEFAULT = 1;
            static final int INT_PRESERVE = 2;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = null;

            static {
                table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("default", 1), new Enum("preserve", 2)});
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
            ElementFactory<Space> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "spaceb986attrtype");
            Factory = r0;
            type = r0.getType();
            DEFAULT = Enum.forString("default");
            PRESERVE = Enum.forString("preserve");
        }
    }

    static {
        DocumentFactory<SpaceAttribute> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "space9344attrtypetype");
        Factory = r0;
        type = r0.getType();
    }
}
