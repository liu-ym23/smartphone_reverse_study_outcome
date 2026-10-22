package org.openxmlformats.schemas.drawingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface STOnOffStyleType extends XmlToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STOnOffStyleType> f18624a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18625b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DEF = 3;
        static final int INT_OFF = 2;
        static final int INT_ON = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(com.tom_roush.pdfbox.pdmodel.a.d.f.f, 1), new Enum(com.tom_roush.pdfbox.pdmodel.a.d.f.g, 2), new Enum("def", 3)});
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
        SimpleTypeFactory<STOnOffStyleType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stonoffstyletype4606type");
        f18624a = r0;
        f18625b = r0.getType();
        c = Enum.forString(com.tom_roush.pdfbox.pdmodel.a.d.f.f);
        d = Enum.forString(com.tom_roush.pdfbox.pdmodel.a.d.f.g);
        e = Enum.forString("def");
    }
}
