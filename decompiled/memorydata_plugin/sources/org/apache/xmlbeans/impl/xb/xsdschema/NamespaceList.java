package org.apache.xmlbeans.impl.xb.xsdschema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface NamespaceList extends XmlAnySimpleType {
    public static final SimpleTypeFactory<NamespaceList> Factory = null;
    public static final SchemaType type = null;

    public interface Member extends XmlToken {
        public static final Enum ANY = null;
        public static final ElementFactory<Member> Factory = null;
        public static final Enum OTHER = null;
        public static final SchemaType type = null;

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_ANY = 1;
            static final int INT_OTHER = 2;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = null;

            static {
                table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("##any", 1), new Enum("##other", 2)});
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
            ElementFactory<Member> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "anonfac7type");
            Factory = r0;
            type = r0.getType();
            ANY = Enum.forString("##any");
            OTHER = Enum.forString("##other");
        }
    }

    public interface Member2 extends XmlAnySimpleType {
        public static final ElementFactory<Member2> Factory = null;
        public static final SchemaType type = null;

        public interface Item extends XmlAnySimpleType {
            public static final ElementFactory<Item> Factory = null;
            public static final SchemaType type = null;

            public interface Member extends XmlToken {
                public static final ElementFactory<Member> Factory = null;
                public static final Enum LOCAL = null;
                public static final Enum TARGET_NAMESPACE = null;
                public static final SchemaType type = null;

                public static final class Enum extends StringEnumAbstractBase {
                    static final int INT_LOCAL = 2;
                    static final int INT_TARGET_NAMESPACE = 1;
                    private static final long serialVersionUID = 1;
                    public static final StringEnumAbstractBase.Table table = null;

                    static {
                        table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("##targetNamespace", 1), new Enum("##local", 2)});
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
                    ElementFactory<Member> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "anon0c73type");
                    Factory = r0;
                    type = r0.getType();
                    TARGET_NAMESPACE = Enum.forString("##targetNamespace");
                    LOCAL = Enum.forString("##local");
                }
            }

            static {
                ElementFactory<Item> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "anon16cetype");
                Factory = r0;
                type = r0.getType();
            }
        }

        static {
            ElementFactory<Member2> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "anona0e6type");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        SimpleTypeFactory<NamespaceList> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "namespacelist10cctype");
        Factory = r0;
        type = r0.getType();
    }
}
