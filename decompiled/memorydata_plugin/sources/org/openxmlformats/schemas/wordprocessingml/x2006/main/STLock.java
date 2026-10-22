package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STLock extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STLock> f19842a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19843b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CONTENT_LOCKED = 2;
        static final int INT_SDT_CONTENT_LOCKED = 4;
        static final int INT_SDT_LOCKED = 1;
        static final int INT_UNLOCKED = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("sdtLocked", 1), new Enum("contentLocked", 2), new Enum("unlocked", 3), new Enum("sdtContentLocked", 4)});
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
        SimpleTypeFactory<STLock> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stlocke60dtype");
        f19842a = r0;
        f19843b = r0.getType();
        c = Enum.forString("sdtLocked");
        d = Enum.forString("contentLocked");
        e = Enum.forString("unlocked");
        f = Enum.forString("sdtContentLocked");
    }
}
