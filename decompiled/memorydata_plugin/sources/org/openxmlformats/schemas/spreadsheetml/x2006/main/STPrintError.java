package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STPrintError extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STPrintError> f19383a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19384b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BLANK = 2;
        static final int INT_DASH = 3;
        static final int INT_DISPLAYED = 1;
        static final int INT_NA = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("displayed", 1), new Enum("blank", 2), new Enum("dash", 3), new Enum("NA", 4)});
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
        SimpleTypeFactory<STPrintError> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stprinterror4934type");
        f19383a = r0;
        f19384b = r0.getType();
        c = Enum.forString("displayed");
        d = Enum.forString("blank");
        e = Enum.forString("dash");
        f = Enum.forString("NA");
    }
}
