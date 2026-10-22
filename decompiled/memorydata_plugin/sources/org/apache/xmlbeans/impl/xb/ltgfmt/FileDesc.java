package org.apache.xmlbeans.impl.xb.ltgfmt;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLTOOLS.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface FileDesc extends XmlObject {
    public static final DocumentFactory<FileDesc> Factory = null;
    public static final SchemaType type = null;

    public interface Role extends XmlToken {
        public static final ElementFactory<Role> Factory = null;
        public static final Enum INSTANCE = null;
        public static final Enum RESOURCE = null;
        public static final Enum SCHEMA = null;
        public static final SchemaType type = null;

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_INSTANCE = 2;
            static final int INT_RESOURCE = 3;
            static final int INT_SCHEMA = 1;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = null;

            static {
                table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("schema", 1), new Enum("instance", 2), new Enum("resource", 3)});
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
            ElementFactory<Role> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "role21a8attrtype");
            Factory = r0;
            type = r0.getType();
            SCHEMA = Enum.forString("schema");
            INSTANCE = Enum.forString("instance");
            RESOURCE = Enum.forString("resource");
        }
    }

    static {
        DocumentFactory<FileDesc> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "filedesc9392type");
        Factory = r0;
        type = r0.getType();
    }
}
