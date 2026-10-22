package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STTextDirection extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STTextDirection> f19882a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19883b = null;
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
        static final int INT_BT_LR = 7;
        static final int INT_LR = 3;
        static final int INT_LR_TB = 8;
        static final int INT_LR_TB_V = 9;
        static final int INT_LR_V = 6;
        static final int INT_RL = 2;
        static final int INT_RL_V = 5;
        static final int INT_TB = 1;
        static final int INT_TB_LR_V = 10;
        static final int INT_TB_RL = 11;
        static final int INT_TB_RL_V = 12;
        static final int INT_TB_V = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("tb", 1), new Enum("rl", 2), new Enum("lr", 3), new Enum("tbV", 4), new Enum("rlV", 5), new Enum("lrV", 6), new Enum("btLr", 7), new Enum("lrTb", 8), new Enum("lrTbV", 9), new Enum("tbLrV", 10), new Enum("tbRl", 11), new Enum("tbRlV", 12)});
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
        SimpleTypeFactory<STTextDirection> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "sttextdirectionf150type");
        f19882a = r0;
        f19883b = r0.getType();
        c = Enum.forString("tb");
        d = Enum.forString("rl");
        e = Enum.forString("lr");
        f = Enum.forString("tbV");
        g = Enum.forString("rlV");
        h = Enum.forString("lrV");
        i = Enum.forString("btLr");
        j = Enum.forString("lrTb");
        k = Enum.forString("lrTbV");
        l = Enum.forString("tbLrV");
        m = Enum.forString("tbRl");
        n = Enum.forString("tbRlV");
    }
}
