package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STObjects extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STObjects> f19369a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19370b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ALL = 1;
        static final int INT_NONE = 3;
        static final int INT_PLACEHOLDERS = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL, 1), new Enum("placeholders", 2), new Enum("none", 3)});
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
        SimpleTypeFactory<STObjects> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stobjects5c63type");
        f19369a = r0;
        f19370b = r0.getType();
        c = Enum.forString(LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL);
        d = Enum.forString("placeholders");
        e = Enum.forString("none");
    }
}
