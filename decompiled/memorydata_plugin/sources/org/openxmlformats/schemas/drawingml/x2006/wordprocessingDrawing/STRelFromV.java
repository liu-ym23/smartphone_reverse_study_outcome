package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STRelFromV extends XmlToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STRelFromV> f19058a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19059b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;
    public static final Enum i = null;
    public static final Enum j = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BOTTOM_MARGIN = 6;
        static final int INT_INSIDE_MARGIN = 7;
        static final int INT_LINE = 4;
        static final int INT_MARGIN = 1;
        static final int INT_OUTSIDE_MARGIN = 8;
        static final int INT_PAGE = 2;
        static final int INT_PARAGRAPH = 3;
        static final int INT_TOP_MARGIN = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("margin", 1), new Enum("page", 2), new Enum("paragraph", 3), new Enum("line", 4), new Enum("topMargin", 5), new Enum("bottomMargin", 6), new Enum("insideMargin", 7), new Enum("outsideMargin", 8)});
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
        SimpleTypeFactory<STRelFromV> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "strelfromv56dctype");
        f19058a = r0;
        f19059b = r0.getType();
        c = Enum.forString("margin");
        d = Enum.forString("page");
        e = Enum.forString("paragraph");
        f = Enum.forString("line");
        g = Enum.forString("topMargin");
        h = Enum.forString("bottomMargin");
        i = Enum.forString("insideMargin");
        j = Enum.forString("outsideMargin");
    }
}
