package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STRelFromH extends XmlToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STRelFromH> f19056a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19057b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;
    public static final Enum i = null;
    public static final Enum j = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CHARACTER = 4;
        static final int INT_COLUMN = 3;
        static final int INT_INSIDE_MARGIN = 7;
        static final int INT_LEFT_MARGIN = 5;
        static final int INT_MARGIN = 1;
        static final int INT_OUTSIDE_MARGIN = 8;
        static final int INT_PAGE = 2;
        static final int INT_RIGHT_MARGIN = 6;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("margin", 1), new Enum("page", 2), new Enum("column", 3), new Enum("character", 4), new Enum("leftMargin", 5), new Enum("rightMargin", 6), new Enum("insideMargin", 7), new Enum("outsideMargin", 8)});
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
        SimpleTypeFactory<STRelFromH> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "strelfromh72aatype");
        f19056a = r0;
        f19057b = r0.getType();
        c = Enum.forString("margin");
        d = Enum.forString("page");
        e = Enum.forString("column");
        f = Enum.forString("character");
        g = Enum.forString("leftMargin");
        h = Enum.forString("rightMargin");
        i = Enum.forString("insideMargin");
        j = Enum.forString("outsideMargin");
    }
}
