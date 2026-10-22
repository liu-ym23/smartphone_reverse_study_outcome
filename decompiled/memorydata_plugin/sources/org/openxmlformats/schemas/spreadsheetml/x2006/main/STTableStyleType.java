package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STTableStyleType extends XmlString {
    public static final Enum A = null;
    public static final Enum B = null;
    public static final Enum C = null;
    public static final Enum D = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STTableStyleType> f19393a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19394b = null;
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
    public static final Enum u = null;
    public static final Enum v = null;
    public static final Enum w = null;
    public static final Enum x = null;
    public static final Enum y = null;
    public static final Enum z = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BLANK_ROW = 20;
        static final int INT_FIRST_COLUMN = 4;
        static final int INT_FIRST_COLUMN_STRIPE = 8;
        static final int INT_FIRST_COLUMN_SUBHEADING = 21;
        static final int INT_FIRST_HEADER_CELL = 10;
        static final int INT_FIRST_ROW_STRIPE = 6;
        static final int INT_FIRST_ROW_SUBHEADING = 24;
        static final int INT_FIRST_SUBTOTAL_COLUMN = 14;
        static final int INT_FIRST_SUBTOTAL_ROW = 17;
        static final int INT_FIRST_TOTAL_CELL = 12;
        static final int INT_HEADER_ROW = 2;
        static final int INT_LAST_COLUMN = 5;
        static final int INT_LAST_HEADER_CELL = 11;
        static final int INT_LAST_TOTAL_CELL = 13;
        static final int INT_PAGE_FIELD_LABELS = 27;
        static final int INT_PAGE_FIELD_VALUES = 28;
        static final int INT_SECOND_COLUMN_STRIPE = 9;
        static final int INT_SECOND_COLUMN_SUBHEADING = 22;
        static final int INT_SECOND_ROW_STRIPE = 7;
        static final int INT_SECOND_ROW_SUBHEADING = 25;
        static final int INT_SECOND_SUBTOTAL_COLUMN = 15;
        static final int INT_SECOND_SUBTOTAL_ROW = 18;
        static final int INT_THIRD_COLUMN_SUBHEADING = 23;
        static final int INT_THIRD_ROW_SUBHEADING = 26;
        static final int INT_THIRD_SUBTOTAL_COLUMN = 16;
        static final int INT_THIRD_SUBTOTAL_ROW = 19;
        static final int INT_TOTAL_ROW = 3;
        static final int INT_WHOLE_TABLE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("wholeTable", 1), new Enum("headerRow", 2), new Enum("totalRow", 3), new Enum("firstColumn", 4), new Enum("lastColumn", 5), new Enum("firstRowStripe", 6), new Enum("secondRowStripe", 7), new Enum("firstColumnStripe", 8), new Enum("secondColumnStripe", 9), new Enum("firstHeaderCell", 10), new Enum("lastHeaderCell", 11), new Enum("firstTotalCell", 12), new Enum("lastTotalCell", 13), new Enum("firstSubtotalColumn", 14), new Enum("secondSubtotalColumn", 15), new Enum("thirdSubtotalColumn", 16), new Enum("firstSubtotalRow", 17), new Enum("secondSubtotalRow", 18), new Enum("thirdSubtotalRow", 19), new Enum("blankRow", 20), new Enum("firstColumnSubheading", 21), new Enum("secondColumnSubheading", 22), new Enum("thirdColumnSubheading", 23), new Enum("firstRowSubheading", 24), new Enum("secondRowSubheading", 25), new Enum("thirdRowSubheading", 26), new Enum("pageFieldLabels", 27), new Enum("pageFieldValues", 28)});
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
        SimpleTypeFactory<STTableStyleType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "sttablestyletype9936type");
        f19393a = r0;
        f19394b = r0.getType();
        c = Enum.forString("wholeTable");
        d = Enum.forString("headerRow");
        e = Enum.forString("totalRow");
        f = Enum.forString("firstColumn");
        g = Enum.forString("lastColumn");
        h = Enum.forString("firstRowStripe");
        i = Enum.forString("secondRowStripe");
        j = Enum.forString("firstColumnStripe");
        k = Enum.forString("secondColumnStripe");
        l = Enum.forString("firstHeaderCell");
        m = Enum.forString("lastHeaderCell");
        n = Enum.forString("firstTotalCell");
        o = Enum.forString("lastTotalCell");
        p = Enum.forString("firstSubtotalColumn");
        q = Enum.forString("secondSubtotalColumn");
        r = Enum.forString("thirdSubtotalColumn");
        s = Enum.forString("firstSubtotalRow");
        t = Enum.forString("secondSubtotalRow");
        u = Enum.forString("thirdSubtotalRow");
        v = Enum.forString("blankRow");
        w = Enum.forString("firstColumnSubheading");
        x = Enum.forString("secondColumnSubheading");
        y = Enum.forString("thirdColumnSubheading");
        z = Enum.forString("firstRowSubheading");
        A = Enum.forString("secondRowSubheading");
        B = Enum.forString("thirdRowSubheading");
        C = Enum.forString("pageFieldLabels");
        D = Enum.forString("pageFieldValues");
    }
}
