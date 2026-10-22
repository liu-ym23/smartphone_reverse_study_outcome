package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STJc extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STJc> f19836a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19837b = null;
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
        static final int INT_BOTH = 4;
        static final int INT_CENTER = 2;
        static final int INT_DISTRIBUTE = 6;
        static final int INT_END = 3;
        static final int INT_HIGH_KASHIDA = 8;
        static final int INT_LEFT = 11;
        static final int INT_LOW_KASHIDA = 9;
        static final int INT_MEDIUM_KASHIDA = 5;
        static final int INT_NUM_TAB = 7;
        static final int INT_RIGHT = 12;
        static final int INT_START = 1;
        static final int INT_THAI_DISTRIBUTE = 10;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(CommonConsts.APM_INNER_EVENT_COST_START, 1), new Enum("center", 2), new Enum("end", 3), new Enum("both", 4), new Enum("mediumKashida", 5), new Enum("distribute", 6), new Enum("numTab", 7), new Enum("highKashida", 8), new Enum("lowKashida", 9), new Enum("thaiDistribute", 10), new Enum("left", 11), new Enum("right", 12)});
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
        SimpleTypeFactory<STJc> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stjc977ftype");
        f19836a = r0;
        f19837b = r0.getType();
        c = Enum.forString(CommonConsts.APM_INNER_EVENT_COST_START);
        d = Enum.forString("center");
        e = Enum.forString("end");
        f = Enum.forString("both");
        g = Enum.forString("mediumKashida");
        h = Enum.forString("distribute");
        i = Enum.forString("numTab");
        j = Enum.forString("highKashida");
        k = Enum.forString("lowKashida");
        l = Enum.forString("thaiDistribute");
        m = Enum.forString("left");
        n = Enum.forString("right");
    }
}
