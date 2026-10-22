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
public interface BlockSet extends XmlAnySimpleType {
    public static final SimpleTypeFactory<BlockSet> Factory = null;
    public static final SchemaType type = null;

    public interface Member extends XmlToken {
        public static final Enum ALL = null;
        public static final ElementFactory<Member> Factory = null;
        public static final SchemaType type = null;

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_ALL = 1;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = null;

            static {
                table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("#all", 1)});
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
            ElementFactory<Member> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "anon0683type");
            Factory = r0;
            type = r0.getType();
            ALL = Enum.forString("#all");
        }
    }

    public interface Member2 extends XmlAnySimpleType {

        public interface Item extends DerivationControl {
        }
    }

    static {
        SimpleTypeFactory<BlockSet> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "blockset815etype");
        Factory = r0;
        type = r0.getType();
    }
}
