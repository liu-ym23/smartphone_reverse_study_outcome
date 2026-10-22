package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STTabJc extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STTabJc> f19870a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19871b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;
    public static final Enum i = null;
    public static final Enum j = null;
    public static final Enum k = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BAR = 6;
        static final int INT_CENTER = 3;
        static final int INT_CLEAR = 1;
        static final int INT_DECIMAL = 5;
        static final int INT_END = 4;
        static final int INT_LEFT = 8;
        static final int INT_NUM = 7;
        static final int INT_RIGHT = 9;
        static final int INT_START = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("clear", 1), new Enum(CommonConsts.APM_INNER_EVENT_COST_START, 2), new Enum("center", 3), new Enum("end", 4), new Enum("decimal", 5), new Enum("bar", 6), new Enum("num", 7), new Enum("left", 8), new Enum("right", 9)});
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
        SimpleTypeFactory<STTabJc> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "sttabjc10f4type");
        f19870a = r0;
        f19871b = r0.getType();
        c = Enum.forString("clear");
        d = Enum.forString(CommonConsts.APM_INNER_EVENT_COST_START);
        e = Enum.forString("center");
        f = Enum.forString("end");
        g = Enum.forString("decimal");
        h = Enum.forString("bar");
        i = Enum.forString("num");
        j = Enum.forString("left");
        k = Enum.forString("right");
    }
}
