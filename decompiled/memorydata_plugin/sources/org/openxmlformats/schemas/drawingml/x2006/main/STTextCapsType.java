package org.openxmlformats.schemas.drawingml.x2006.main;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface STTextCapsType extends XmlToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STTextCapsType> f18656a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18657b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ALL = 3;
        static final int INT_NONE = 1;
        static final int INT_SMALL = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("small", 2), new Enum(LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL, 3)});
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
        SimpleTypeFactory<STTextCapsType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "sttextcapstyped233type");
        f18656a = r0;
        f18657b = r0.getType();
        c = Enum.forString("none");
        d = Enum.forString("small");
        e = Enum.forString(LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL);
    }
}
