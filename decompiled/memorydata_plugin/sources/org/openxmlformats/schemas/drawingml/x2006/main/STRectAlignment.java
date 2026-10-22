package org.openxmlformats.schemas.drawingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface STRectAlignment extends XmlToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STRectAlignment> f18640a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18641b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;
    public static final Enum i = null;
    public static final Enum j = null;
    public static final Enum k = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_B = 8;
        static final int INT_BL = 7;
        static final int INT_BR = 9;
        static final int INT_CTR = 5;
        static final int INT_L = 4;
        static final int INT_R = 6;
        static final int INT_T = 2;
        static final int INT_TL = 1;
        static final int INT_TR = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("tl", 1), new Enum("t", 2), new Enum("tr", 3), new Enum("l", 4), new Enum("ctr", 5), new Enum("r", 6), new Enum("bl", 7), new Enum("b", 8), new Enum("br", 9)});
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
        SimpleTypeFactory<STRectAlignment> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "strectalignmentd400type");
        f18640a = r0;
        f18641b = r0.getType();
        c = Enum.forString("tl");
        d = Enum.forString("t");
        e = Enum.forString("tr");
        f = Enum.forString("l");
        g = Enum.forString("ctr");
        h = Enum.forString("r");
        i = Enum.forString("bl");
        j = Enum.forString("b");
        k = Enum.forString("br");
    }
}
