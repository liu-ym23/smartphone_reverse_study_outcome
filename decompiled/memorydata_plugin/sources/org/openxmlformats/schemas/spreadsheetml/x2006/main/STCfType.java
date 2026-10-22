package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STCfType extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STCfType> f19345a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19346b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;
    public static final Enum i = null;
    public static final Enum j = null;
    public static final Enum k = null;
    public static final Enum l = null;
    public static final Enum m = null;
    public static final Enum n = null;
    public static final Enum o = null;
    public static final Enum p = null;
    public static final Enum q = null;
    public static final Enum r = null;
    public static final Enum s = null;
    public static final Enum t = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ABOVE_AVERAGE = 18;
        static final int INT_BEGINS_WITH = 11;
        static final int INT_CELL_IS = 2;
        static final int INT_COLOR_SCALE = 3;
        static final int INT_CONTAINS_BLANKS = 13;
        static final int INT_CONTAINS_ERRORS = 15;
        static final int INT_CONTAINS_TEXT = 9;
        static final int INT_DATA_BAR = 4;
        static final int INT_DUPLICATE_VALUES = 8;
        static final int INT_ENDS_WITH = 12;
        static final int INT_EXPRESSION = 1;
        static final int INT_ICON_SET = 5;
        static final int INT_NOT_CONTAINS_BLANKS = 14;
        static final int INT_NOT_CONTAINS_ERRORS = 16;
        static final int INT_NOT_CONTAINS_TEXT = 10;
        static final int INT_TIME_PERIOD = 17;
        static final int INT_TOP_10 = 6;
        static final int INT_UNIQUE_VALUES = 7;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("expression", 1), new Enum("cellIs", 2), new Enum("colorScale", 3), new Enum("dataBar", 4), new Enum("iconSet", 5), new Enum("top10", 6), new Enum("uniqueValues", 7), new Enum("duplicateValues", 8), new Enum("containsText", 9), new Enum("notContainsText", 10), new Enum("beginsWith", 11), new Enum("endsWith", 12), new Enum("containsBlanks", 13), new Enum("notContainsBlanks", 14), new Enum("containsErrors", 15), new Enum("notContainsErrors", 16), new Enum("timePeriod", 17), new Enum("aboveAverage", 18)});
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
        SimpleTypeFactory<STCfType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stcftype8016type");
        f19345a = r0;
        f19346b = r0.getType();
        c = Enum.forString("expression");
        d = Enum.forString("cellIs");
        e = Enum.forString("colorScale");
        f = Enum.forString("dataBar");
        g = Enum.forString("iconSet");
        h = Enum.forString("top10");
        i = Enum.forString("uniqueValues");
        j = Enum.forString("duplicateValues");
        k = Enum.forString("containsText");
        l = Enum.forString("notContainsText");
        m = Enum.forString("beginsWith");
        n = Enum.forString("endsWith");
        o = Enum.forString("containsBlanks");
        p = Enum.forString("notContainsBlanks");
        q = Enum.forString("containsErrors");
        r = Enum.forString("notContainsErrors");
        s = Enum.forString("timePeriod");
        t = Enum.forString("aboveAverage");
    }
}
