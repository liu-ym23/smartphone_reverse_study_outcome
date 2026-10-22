package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STItemType extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STItemType> f19367a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19368b = null;
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

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AVG = 5;
        static final int INT_BLANK = 15;
        static final int INT_COUNT = 9;
        static final int INT_COUNT_A = 4;
        static final int INT_DATA = 1;
        static final int INT_DEFAULT = 2;
        static final int INT_GRAND = 14;
        static final int INT_MAX = 6;
        static final int INT_MIN = 7;
        static final int INT_PRODUCT = 8;
        static final int INT_STD_DEV = 10;
        static final int INT_STD_DEV_P = 11;
        static final int INT_SUM = 3;
        static final int INT_VAR = 12;
        static final int INT_VAR_P = 13;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("data", 1), new Enum("default", 2), new Enum("sum", 3), new Enum("countA", 4), new Enum("avg", 5), new Enum("max", 6), new Enum("min", 7), new Enum("product", 8), new Enum(CommonConsts.COUNT_TYPE, 9), new Enum("stdDev", 10), new Enum("stdDevP", 11), new Enum("var", 12), new Enum("varP", 13), new Enum("grand", 14), new Enum("blank", 15)});
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
        SimpleTypeFactory<STItemType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stitemtype6186type");
        f19367a = r0;
        f19368b = r0.getType();
        c = Enum.forString("data");
        d = Enum.forString("default");
        e = Enum.forString("sum");
        f = Enum.forString("countA");
        g = Enum.forString("avg");
        h = Enum.forString("max");
        i = Enum.forString("min");
        j = Enum.forString("product");
        k = Enum.forString(CommonConsts.COUNT_TYPE);
        l = Enum.forString("stdDev");
        m = Enum.forString("stdDevP");
        n = Enum.forString("var");
        o = Enum.forString("varP");
        p = Enum.forString("grand");
        q = Enum.forString("blank");
    }
}
