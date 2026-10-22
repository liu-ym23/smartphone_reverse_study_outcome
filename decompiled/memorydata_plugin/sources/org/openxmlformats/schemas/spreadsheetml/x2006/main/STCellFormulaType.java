package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STCellFormulaType extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STCellFormulaType> f19341a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19342b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ARRAY = 2;
        static final int INT_DATA_TABLE = 3;
        static final int INT_NORMAL = 1;
        static final int INT_SHARED = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("normal", 1), new Enum("array", 2), new Enum("dataTable", 3), new Enum("shared", 4)});
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
        SimpleTypeFactory<STCellFormulaType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stcellformulatypee2cdtype");
        f19341a = r0;
        f19342b = r0.getType();
        c = Enum.forString("normal");
        d = Enum.forString("array");
        e = Enum.forString("dataTable");
        f = Enum.forString("shared");
    }
}
