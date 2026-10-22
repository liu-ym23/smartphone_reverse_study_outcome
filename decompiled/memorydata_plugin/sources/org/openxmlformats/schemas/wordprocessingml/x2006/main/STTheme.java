package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STTheme extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STTheme> f19884a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19885b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;
    public static final Enum i = null;
    public static final Enum j = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_MAJOR_ASCII = 3;
        static final int INT_MAJOR_BIDI = 2;
        static final int INT_MAJOR_EAST_ASIA = 1;
        static final int INT_MAJOR_H_ANSI = 4;
        static final int INT_MINOR_ASCII = 7;
        static final int INT_MINOR_BIDI = 6;
        static final int INT_MINOR_EAST_ASIA = 5;
        static final int INT_MINOR_H_ANSI = 8;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("majorEastAsia", 1), new Enum("majorBidi", 2), new Enum("majorAscii", 3), new Enum("majorHAnsi", 4), new Enum("minorEastAsia", 5), new Enum("minorBidi", 6), new Enum("minorAscii", 7), new Enum("minorHAnsi", 8)});
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
        SimpleTypeFactory<STTheme> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "sttheme58b9type");
        f19884a = r0;
        f19885b = r0.getType();
        c = Enum.forString("majorEastAsia");
        d = Enum.forString("majorBidi");
        e = Enum.forString("majorAscii");
        f = Enum.forString("majorHAnsi");
        g = Enum.forString("minorEastAsia");
        h = Enum.forString("minorBidi");
        i = Enum.forString("minorAscii");
        j = Enum.forString("minorHAnsi");
    }
}
