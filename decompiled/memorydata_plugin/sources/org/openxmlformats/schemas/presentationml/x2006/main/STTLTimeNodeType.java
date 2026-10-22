package org.openxmlformats.schemas.presentationml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STTLTimeNodeType extends XmlToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STTLTimeNodeType> f19195a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19196b = null;
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
        static final int INT_AFTER_EFFECT = 3;
        static final int INT_AFTER_GROUP = 8;
        static final int INT_CLICK_EFFECT = 1;
        static final int INT_CLICK_PAR = 6;
        static final int INT_INTERACTIVE_SEQ = 5;
        static final int INT_MAIN_SEQ = 4;
        static final int INT_TM_ROOT = 9;
        static final int INT_WITH_EFFECT = 2;
        static final int INT_WITH_GROUP = 7;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("clickEffect", 1), new Enum("withEffect", 2), new Enum("afterEffect", 3), new Enum("mainSeq", 4), new Enum("interactiveSeq", 5), new Enum("clickPar", 6), new Enum("withGroup", 7), new Enum("afterGroup", 8), new Enum("tmRoot", 9)});
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
        SimpleTypeFactory<STTLTimeNodeType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "sttltimenodetypebbf4type");
        f19195a = r0;
        f19196b = r0.getType();
        c = Enum.forString("clickEffect");
        d = Enum.forString("withEffect");
        e = Enum.forString("afterEffect");
        f = Enum.forString("mainSeq");
        g = Enum.forString("interactiveSeq");
        h = Enum.forString("clickPar");
        i = Enum.forString("withGroup");
        j = Enum.forString("afterGroup");
        k = Enum.forString("tmRoot");
    }
}
