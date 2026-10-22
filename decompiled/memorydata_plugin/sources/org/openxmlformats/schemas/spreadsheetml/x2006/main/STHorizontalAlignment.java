package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STHorizontalAlignment extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STHorizontalAlignment> f19363a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19364b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;
    public static final Enum i = null;
    public static final Enum j = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CENTER = 3;
        static final int INT_CENTER_CONTINUOUS = 7;
        static final int INT_DISTRIBUTED = 8;
        static final int INT_FILL = 5;
        static final int INT_GENERAL = 1;
        static final int INT_JUSTIFY = 6;
        static final int INT_LEFT = 2;
        static final int INT_RIGHT = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(SlardarSettingsConstants.SETTING_GENERAL, 1), new Enum("left", 2), new Enum("center", 3), new Enum("right", 4), new Enum("fill", 5), new Enum("justify", 6), new Enum("centerContinuous", 7), new Enum("distributed", 8)});
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
        SimpleTypeFactory<STHorizontalAlignment> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "sthorizontalalignmentf92etype");
        f19363a = r0;
        f19364b = r0.getType();
        c = Enum.forString(SlardarSettingsConstants.SETTING_GENERAL);
        d = Enum.forString("left");
        e = Enum.forString("center");
        f = Enum.forString("right");
        g = Enum.forString("fill");
        h = Enum.forString("justify");
        i = Enum.forString("centerContinuous");
        j = Enum.forString("distributed");
    }
}
