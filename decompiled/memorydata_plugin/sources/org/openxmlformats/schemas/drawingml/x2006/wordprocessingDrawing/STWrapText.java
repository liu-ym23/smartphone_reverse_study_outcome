package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STWrapText extends XmlToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STWrapText> f19060a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19061b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BOTH_SIDES = 1;
        static final int INT_LARGEST = 4;
        static final int INT_LEFT = 2;
        static final int INT_RIGHT = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("bothSides", 1), new Enum("left", 2), new Enum("right", 3), new Enum("largest", 4)});
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
        SimpleTypeFactory<STWrapText> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stwraptext4a98type");
        f19060a = r0;
        f19061b = r0.getType();
        c = Enum.forString("bothSides");
        d = Enum.forString("left");
        e = Enum.forString("right");
        f = Enum.forString("largest");
    }
}
