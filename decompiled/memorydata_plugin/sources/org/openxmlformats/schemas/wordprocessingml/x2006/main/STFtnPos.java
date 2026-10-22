package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STFtnPos extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STFtnPos> f19822a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19823b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BENEATH_TEXT = 2;
        static final int INT_DOC_END = 4;
        static final int INT_PAGE_BOTTOM = 1;
        static final int INT_SECT_END = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("pageBottom", 1), new Enum("beneathText", 2), new Enum("sectEnd", 3), new Enum("docEnd", 4)});
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
        SimpleTypeFactory<STFtnPos> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stftnposdc44type");
        f19822a = r0;
        f19823b = r0.getType();
        c = Enum.forString("pageBottom");
        d = Enum.forString("beneathText");
        e = Enum.forString("sectEnd");
        f = Enum.forString("docEnd");
    }
}
