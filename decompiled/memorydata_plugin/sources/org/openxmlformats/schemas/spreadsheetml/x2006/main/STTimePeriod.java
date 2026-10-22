package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STTimePeriod extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STTimePeriod> f19395a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19396b = null;
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

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_LAST_7_DAYS = 4;
        static final int INT_LAST_MONTH = 6;
        static final int INT_LAST_WEEK = 9;
        static final int INT_NEXT_MONTH = 7;
        static final int INT_NEXT_WEEK = 10;
        static final int INT_THIS_MONTH = 5;
        static final int INT_THIS_WEEK = 8;
        static final int INT_TODAY = 1;
        static final int INT_TOMORROW = 3;
        static final int INT_YESTERDAY = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("today", 1), new Enum("yesterday", 2), new Enum("tomorrow", 3), new Enum("last7Days", 4), new Enum("thisMonth", 5), new Enum("lastMonth", 6), new Enum("nextMonth", 7), new Enum("thisWeek", 8), new Enum("lastWeek", 9), new Enum("nextWeek", 10)});
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
        SimpleTypeFactory<STTimePeriod> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "sttimeperiodef07type");
        f19395a = r0;
        f19396b = r0.getType();
        c = Enum.forString("today");
        d = Enum.forString("yesterday");
        e = Enum.forString("tomorrow");
        f = Enum.forString("last7Days");
        g = Enum.forString("thisMonth");
        h = Enum.forString("lastMonth");
        i = Enum.forString("nextMonth");
        j = Enum.forString("thisWeek");
        k = Enum.forString("lastWeek");
        l = Enum.forString("nextWeek");
    }
}
