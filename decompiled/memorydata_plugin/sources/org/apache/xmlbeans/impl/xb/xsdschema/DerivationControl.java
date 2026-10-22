package org.apache.xmlbeans.impl.xb.xsdschema;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface DerivationControl extends XmlNMTOKEN {
    public static final Enum EXTENSION = null;
    public static final SimpleTypeFactory<DerivationControl> Factory = null;
    public static final Enum LIST = null;
    public static final Enum RESTRICTION = null;
    public static final Enum SUBSTITUTION = null;
    public static final Enum UNION = null;
    public static final SchemaType type = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_EXTENSION = 2;
        static final int INT_LIST = 4;
        static final int INT_RESTRICTION = 3;
        static final int INT_SUBSTITUTION = 1;
        static final int INT_UNION = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("substitution", 1), new Enum("extension", 2), new Enum("restriction", 3), new Enum(Constants.KEY_LIST, 4), new Enum("union", 5)});
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
        SimpleTypeFactory<DerivationControl> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "derivationcontrola5dftype");
        Factory = r0;
        type = r0.getType();
        SUBSTITUTION = Enum.forString("substitution");
        EXTENSION = Enum.forString("extension");
        RESTRICTION = Enum.forString("restriction");
        LIST = Enum.forString(Constants.KEY_LIST);
        UNION = Enum.forString("union");
    }
}
