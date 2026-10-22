package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes;

import com.obric.cae.userAware.utils.UserAwareUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STYAlign extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STYAlign> f19158a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19159b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BOTTOM = 4;
        static final int INT_CENTER = 3;
        static final int INT_INLINE = 1;
        static final int INT_INSIDE = 5;
        static final int INT_OUTSIDE = 6;
        static final int INT_TOP = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("inline", 1), new Enum("top", 2), new Enum("center", 3), new Enum("bottom", 4), new Enum("inside", 5), new Enum(UserAwareUtil.STATE_OUTSIDE, 6)});
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
        SimpleTypeFactory<STYAlign> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "styalign3606type");
        f19158a = r0;
        f19159b = r0.getType();
        c = Enum.forString("inline");
        d = Enum.forString("top");
        e = Enum.forString("center");
        f = Enum.forString("bottom");
        g = Enum.forString("inside");
        h = Enum.forString(UserAwareUtil.STATE_OUTSIDE);
    }
}
