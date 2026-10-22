package com.microsoft.schemas.vml;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface STFillType extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STFillType> f5769a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5770b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_FRAME = 6;
        static final int INT_GRADIENT = 2;
        static final int INT_GRADIENT_RADIAL = 3;
        static final int INT_PATTERN = 5;
        static final int INT_SOLID = 1;
        static final int INT_TILE = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("solid", 1), new Enum("gradient", 2), new Enum("gradientRadial", 3), new Enum("tile", 4), new Enum(XSDatatype.FACET_PATTERN, 5), new Enum(TypedValues.AttributesType.S_FRAME, 6)});
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
        SimpleTypeFactory<STFillType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stfilltype382btype");
        f5769a = r0;
        f5770b = r0.getType();
        c = Enum.forString("solid");
        d = Enum.forString("gradient");
        e = Enum.forString("gradientRadial");
        f = Enum.forString("tile");
        g = Enum.forString(XSDatatype.FACET_PATTERN);
        h = Enum.forString(TypedValues.AttributesType.S_FRAME);
    }
}
