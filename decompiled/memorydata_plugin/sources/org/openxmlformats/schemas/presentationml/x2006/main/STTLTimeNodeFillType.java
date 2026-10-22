package org.openxmlformats.schemas.presentationml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STTLTimeNodeFillType extends XmlToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STTLTimeNodeFillType> f19191a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19192b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_FREEZE = 2;
        static final int INT_HOLD = 3;
        static final int INT_REMOVE = 1;
        static final int INT_TRANSITION = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("remove", 1), new Enum("freeze", 2), new Enum("hold", 3), new Enum("transition", 4)});
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
        SimpleTypeFactory<STTLTimeNodeFillType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "sttltimenodefilltypeb7f1type");
        f19191a = r0;
        f19192b = r0.getType();
        c = Enum.forString("remove");
        d = Enum.forString("freeze");
        e = Enum.forString("hold");
        f = Enum.forString("transition");
    }
}
