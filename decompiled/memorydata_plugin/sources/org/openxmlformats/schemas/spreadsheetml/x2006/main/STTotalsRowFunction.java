package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STTotalsRowFunction extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STTotalsRowFunction> f19397a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19398b = null;
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
        static final int INT_AVERAGE = 5;
        static final int INT_COUNT = 6;
        static final int INT_COUNT_NUMS = 7;
        static final int INT_CUSTOM = 10;
        static final int INT_MAX = 4;
        static final int INT_MIN = 3;
        static final int INT_NONE = 1;
        static final int INT_STD_DEV = 8;
        static final int INT_SUM = 2;
        static final int INT_VAR = 9;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("sum", 2), new Enum("min", 3), new Enum("max", 4), new Enum("average", 5), new Enum(CommonConsts.COUNT_TYPE, 6), new Enum("countNums", 7), new Enum("stdDev", 8), new Enum("var", 9), new Enum("custom", 10)});
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
        SimpleTypeFactory<STTotalsRowFunction> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "sttotalsrowfunctioncb72type");
        f19397a = r0;
        f19398b = r0.getType();
        c = Enum.forString("none");
        d = Enum.forString("sum");
        e = Enum.forString("min");
        f = Enum.forString("max");
        g = Enum.forString("average");
        h = Enum.forString(CommonConsts.COUNT_TYPE);
        i = Enum.forString("countNums");
        j = Enum.forString("stdDev");
        k = Enum.forString("var");
        l = Enum.forString("custom");
    }
}
