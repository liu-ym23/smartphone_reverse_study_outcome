package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STAlgClass extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STAlgClass> f19140a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19141b = null;
    public static final Enum c = null;
    public static final Enum d = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CUSTOM = 2;
        static final int INT_HASH = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("hash", 1), new Enum("custom", 2)});
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
        SimpleTypeFactory<STAlgClass> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stalgclassc7f6type");
        f19140a = r0;
        f19141b = r0.getType();
        c = Enum.forString("hash");
        d = Enum.forString("custom");
    }
}
