package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STConditionalFormattingOperator extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STConditionalFormattingOperator> f19349a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19350b = null;
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

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BEGINS_WITH = 11;
        static final int INT_BETWEEN = 7;
        static final int INT_CONTAINS_TEXT = 9;
        static final int INT_ENDS_WITH = 12;
        static final int INT_EQUAL = 3;
        static final int INT_GREATER_THAN = 6;
        static final int INT_GREATER_THAN_OR_EQUAL = 5;
        static final int INT_LESS_THAN = 1;
        static final int INT_LESS_THAN_OR_EQUAL = 2;
        static final int INT_NOT_BETWEEN = 8;
        static final int INT_NOT_CONTAINS = 10;
        static final int INT_NOT_EQUAL = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("lessThan", 1), new Enum("lessThanOrEqual", 2), new Enum("equal", 3), new Enum("notEqual", 4), new Enum("greaterThanOrEqual", 5), new Enum("greaterThan", 6), new Enum("between", 7), new Enum("notBetween", 8), new Enum("containsText", 9), new Enum("notContains", 10), new Enum("beginsWith", 11), new Enum("endsWith", 12)});
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
        SimpleTypeFactory<STConditionalFormattingOperator> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stconditionalformattingoperatora99etype");
        f19349a = r0;
        f19350b = r0.getType();
        c = Enum.forString("lessThan");
        d = Enum.forString("lessThanOrEqual");
        e = Enum.forString("equal");
        f = Enum.forString("notEqual");
        g = Enum.forString("greaterThanOrEqual");
        h = Enum.forString("greaterThan");
        i = Enum.forString("between");
        j = Enum.forString("notBetween");
        k = Enum.forString("containsText");
        l = Enum.forString("notContains");
        m = Enum.forString("beginsWith");
        n = Enum.forString("endsWith");
    }
}
