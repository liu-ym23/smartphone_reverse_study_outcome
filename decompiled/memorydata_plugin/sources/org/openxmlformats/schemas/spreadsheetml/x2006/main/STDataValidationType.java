package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STDataValidationType extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STDataValidationType> f19357a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19358b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;
    public static final Enum i = null;
    public static final Enum j = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CUSTOM = 8;
        static final int INT_DATE = 5;
        static final int INT_DECIMAL = 3;
        static final int INT_LIST = 4;
        static final int INT_NONE = 1;
        static final int INT_TEXT_LENGTH = 7;
        static final int INT_TIME = 6;
        static final int INT_WHOLE = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("whole", 2), new Enum("decimal", 3), new Enum(Constants.KEY_LIST, 4), new Enum("date", 5), new Enum(OaidModel.KEY_TIME, 6), new Enum("textLength", 7), new Enum("custom", 8)});
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
        SimpleTypeFactory<STDataValidationType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stdatavalidationtypeabf6type");
        f19357a = r0;
        f19358b = r0.getType();
        c = Enum.forString("none");
        d = Enum.forString("whole");
        e = Enum.forString("decimal");
        f = Enum.forString(Constants.KEY_LIST);
        g = Enum.forString("date");
        h = Enum.forString(OaidModel.KEY_TIME);
        i = Enum.forString("textLength");
        j = Enum.forString("custom");
    }
}
