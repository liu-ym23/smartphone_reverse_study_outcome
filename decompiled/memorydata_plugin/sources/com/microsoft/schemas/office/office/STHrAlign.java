package com.microsoft.schemas.office.office;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface STHrAlign extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STHrAlign> f5689a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5690b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CENTER = 3;
        static final int INT_LEFT = 1;
        static final int INT_RIGHT = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("left", 1), new Enum("right", 2), new Enum("center", 3)});
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
        SimpleTypeFactory<STHrAlign> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "sthralignfb04type");
        f5689a = r0;
        f5690b = r0.getType();
        c = Enum.forString("left");
        d = Enum.forString("right");
        e = Enum.forString("center");
    }
}
