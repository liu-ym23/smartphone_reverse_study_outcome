package com.microsoft.schemas.vml;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface STStrokeArrowType extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STStrokeArrowType> f5773a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5774b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BLOCK = 2;
        static final int INT_CLASSIC = 3;
        static final int INT_DIAMOND = 5;
        static final int INT_NONE = 1;
        static final int INT_OPEN = 6;
        static final int INT_OVAL = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("block", 2), new Enum("classic", 3), new Enum("oval", 4), new Enum("diamond", 5), new Enum("open", 6)});
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
        SimpleTypeFactory<STStrokeArrowType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "ststrokearrowtype7b4ftype");
        f5773a = r0;
        f5774b = r0.getType();
        c = Enum.forString("none");
        d = Enum.forString("block");
        e = Enum.forString("classic");
        f = Enum.forString("oval");
        g = Enum.forString("diamond");
        h = Enum.forString("open");
    }
}
