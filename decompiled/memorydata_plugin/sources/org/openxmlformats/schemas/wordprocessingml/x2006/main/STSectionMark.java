package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STSectionMark extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STSectionMark> f19863a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19864b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CONTINUOUS = 3;
        static final int INT_EVEN_PAGE = 4;
        static final int INT_NEXT_COLUMN = 2;
        static final int INT_NEXT_PAGE = 1;
        static final int INT_ODD_PAGE = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("nextPage", 1), new Enum("nextColumn", 2), new Enum(LocationInfoConst.CONTINUE, 3), new Enum("evenPage", 4), new Enum("oddPage", 5)});
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
        SimpleTypeFactory<STSectionMark> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stsectionmark2010type");
        f19863a = r0;
        f19864b = r0.getType();
        c = Enum.forString("nextPage");
        d = Enum.forString("nextColumn");
        e = Enum.forString(LocationInfoConst.CONTINUE);
        f = Enum.forString("evenPage");
        g = Enum.forString("oddPage");
    }
}
