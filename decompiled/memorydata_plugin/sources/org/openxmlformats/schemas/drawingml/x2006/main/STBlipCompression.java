package org.openxmlformats.schemas.drawingml.x2006.main;

import androidx.core.app.NotificationCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface STBlipCompression extends XmlToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STBlipCompression> f18608a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18609b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_EMAIL = 1;
        static final int INT_HQPRINT = 4;
        static final int INT_NONE = 5;
        static final int INT_PRINT = 3;
        static final int INT_SCREEN = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(NotificationCompat.CATEGORY_EMAIL, 1), new Enum("screen", 2), new Enum("print", 3), new Enum("hqprint", 4), new Enum("none", 5)});
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
        SimpleTypeFactory<STBlipCompression> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stblipcompressionb216type");
        f18608a = r0;
        f18609b = r0.getType();
        c = Enum.forString(NotificationCompat.CATEGORY_EMAIL);
        d = Enum.forString("screen");
        e = Enum.forString("print");
        f = Enum.forString("hqprint");
        g = Enum.forString("none");
    }
}
