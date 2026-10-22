package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STSheetViewType extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STSheetViewType> f19389a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19390b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_NORMAL = 1;
        static final int INT_PAGE_BREAK_PREVIEW = 2;
        static final int INT_PAGE_LAYOUT = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("normal", 1), new Enum("pageBreakPreview", 2), new Enum("pageLayout", 3)});
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
        SimpleTypeFactory<STSheetViewType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stsheetviewtype988dtype");
        f19389a = r0;
        f19390b = r0.getType();
        c = Enum.forString("normal");
        d = Enum.forString("pageBreakPreview");
        e = Enum.forString("pageLayout");
    }
}
