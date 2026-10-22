package org.apache.xmlbeans.impl.xb.xmlschema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLLANG.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface LangAttribute extends XmlObject {
    public static final DocumentFactory<LangAttribute> Factory = null;
    public static final SchemaType type = null;

    public interface Lang extends XmlAnySimpleType {
        public static final ElementFactory<Lang> Factory = null;
        public static final SchemaType type = null;

        public interface Member extends XmlString {
            public static final ElementFactory<Member> Factory = null;
            public static final Enum X = null;
            public static final SchemaType type = null;

            public static final class Enum extends StringEnumAbstractBase {
                static final int INT_X = 1;
                private static final long serialVersionUID = 1;
                public static final StringEnumAbstractBase.Table table = null;

                static {
                    table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("", 1)});
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
                ElementFactory<Member> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "anon695ftype");
                Factory = r0;
                type = r0.getType();
                X = Enum.forString("");
            }
        }

        static {
            ElementFactory<Lang> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "lang1224attrtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<LangAttribute> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "lange126attrtypetype");
        Factory = r0;
        type = r0.getType();
    }
}
