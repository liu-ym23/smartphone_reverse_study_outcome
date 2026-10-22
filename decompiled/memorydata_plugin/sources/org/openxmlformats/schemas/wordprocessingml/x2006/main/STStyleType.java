package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STStyleType extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STStyleType> f19868a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19869b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CHARACTER = 2;
        static final int INT_NUMBERING = 4;
        static final int INT_PARAGRAPH = 1;
        static final int INT_TABLE = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("paragraph", 1), new Enum("character", 2), new Enum("table", 3), new Enum("numbering", 4)});
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
        SimpleTypeFactory<STStyleType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "ststyletypec2b7type");
        f19868a = r0;
        f19869b = r0.getType();
        c = Enum.forString("paragraph");
        d = Enum.forString("character");
        e = Enum.forString("table");
        f = Enum.forString("numbering");
    }
}
