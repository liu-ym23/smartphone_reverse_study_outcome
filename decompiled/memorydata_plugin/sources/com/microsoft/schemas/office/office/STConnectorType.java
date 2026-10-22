package com.microsoft.schemas.office.office;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface STConnectorType extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STConnectorType> f5687a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5688b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CURVED = 4;
        static final int INT_ELBOW = 3;
        static final int INT_NONE = 1;
        static final int INT_STRAIGHT = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("straight", 2), new Enum("elbow", 3), new Enum("curved", 4)});
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
        SimpleTypeFactory<STConnectorType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stconnectortypecbd0type");
        f5687a = r0;
        f5688b = r0.getType();
        c = Enum.forString("none");
        d = Enum.forString("straight");
        e = Enum.forString("elbow");
        f = Enum.forString("curved");
    }
}
