package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STJcTable extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STJcTable> f19838a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19839b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CENTER = 1;
        static final int INT_END = 2;
        static final int INT_LEFT = 3;
        static final int INT_RIGHT = 4;
        static final int INT_START = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("center", 1), new Enum("end", 2), new Enum("left", 3), new Enum("right", 4), new Enum(CommonConsts.APM_INNER_EVENT_COST_START, 5)});
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
        SimpleTypeFactory<STJcTable> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stjctable2eadtype");
        f19838a = r0;
        f19839b = r0.getType();
        c = Enum.forString("center");
        d = Enum.forString("end");
        e = Enum.forString("left");
        f = Enum.forString("right");
        g = Enum.forString(CommonConsts.APM_INNER_EVENT_COST_START);
    }
}
