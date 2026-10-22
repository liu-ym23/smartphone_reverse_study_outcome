package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STSourceType extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STSourceType> f19391a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19392b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CONSOLIDATION = 3;
        static final int INT_EXTERNAL = 2;
        static final int INT_SCENARIO = 4;
        static final int INT_WORKSHEET = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("worksheet", 1), new Enum("external", 2), new Enum("consolidation", 3), new Enum("scenario", 4)});
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
        SimpleTypeFactory<STSourceType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stsourcetype074etype");
        f19391a = r0;
        f19392b = r0.getType();
        c = Enum.forString("worksheet");
        d = Enum.forString("external");
        e = Enum.forString("consolidation");
        f = Enum.forString("scenario");
    }
}
