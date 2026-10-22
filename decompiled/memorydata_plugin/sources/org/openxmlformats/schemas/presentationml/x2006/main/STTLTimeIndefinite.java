package org.openxmlformats.schemas.presentationml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STTLTimeIndefinite extends XmlToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STTLTimeIndefinite> f19189a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19190b = null;
    public static final Enum c = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_INDEFINITE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("indefinite", 1)});
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
        SimpleTypeFactory<STTLTimeIndefinite> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "sttltimeindefinite369btype");
        f19189a = r0;
        f19190b = r0.getType();
        c = Enum.forString("indefinite");
    }
}
