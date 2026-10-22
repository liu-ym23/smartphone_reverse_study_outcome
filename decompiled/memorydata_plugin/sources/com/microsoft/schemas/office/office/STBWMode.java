package com.microsoft.schemas.office.office;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface STBWMode extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STBWMode> f5683a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5684b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;
    public static final Enum i = null;
    public static final Enum j = null;
    public static final Enum k = null;
    public static final Enum l = null;
    public static final Enum m = null;
    public static final Enum n = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AUTO = 2;
        static final int INT_BLACK = 8;
        static final int INT_BLACK_TEXT_AND_LINES = 12;
        static final int INT_COLOR = 1;
        static final int INT_GRAY_OUTLINE = 6;
        static final int INT_GRAY_SCALE = 3;
        static final int INT_HIDE = 10;
        static final int INT_HIGH_CONTRAST = 7;
        static final int INT_INVERSE_GRAY = 5;
        static final int INT_LIGHT_GRAYSCALE = 4;
        static final int INT_UNDRAWN = 11;
        static final int INT_WHITE = 9;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(TypedValues.Custom.S_COLOR, 1), new Enum("auto", 2), new Enum("grayScale", 3), new Enum("lightGrayscale", 4), new Enum("inverseGray", 5), new Enum("grayOutline", 6), new Enum("highContrast", 7), new Enum("black", 8), new Enum("white", 9), new Enum("hide", 10), new Enum("undrawn", 11), new Enum("blackTextAndLines", 12)});
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
        SimpleTypeFactory<STBWMode> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stbwmode77abtype");
        f5683a = r0;
        f5684b = r0.getType();
        c = Enum.forString(TypedValues.Custom.S_COLOR);
        d = Enum.forString("auto");
        e = Enum.forString("grayScale");
        f = Enum.forString("lightGrayscale");
        g = Enum.forString("inverseGray");
        h = Enum.forString("grayOutline");
        i = Enum.forString("highContrast");
        j = Enum.forString("black");
        k = Enum.forString("white");
        l = Enum.forString("hide");
        m = Enum.forString("undrawn");
        n = Enum.forString("blackTextAndLines");
    }
}
