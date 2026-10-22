package com.microsoft.schemas.office.office;

import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface STOLEType extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STOLEType> f5695a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5696b = null;
    public static final Enum c = null;
    public static final Enum d = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_EMBED = 1;
        static final int INT_LINK = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("Embed", 1), new Enum(i.L, 2)});
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
        SimpleTypeFactory<STOLEType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stoletype716btype");
        f5695a = r0;
        f5696b = r0.getType();
        c = Enum.forString("Embed");
        d = Enum.forString(i.L);
    }
}
