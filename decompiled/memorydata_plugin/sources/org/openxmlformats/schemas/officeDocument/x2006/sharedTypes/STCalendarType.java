package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes;

import androidx.core.text.util.LocalePreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STCalendarType extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STCalendarType> f19144a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19145b = null;
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
    public static final Enum o = null;
    public static final Enum p = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_GREGORIAN = 1;
        static final int INT_GREGORIAN_ARABIC = 4;
        static final int INT_GREGORIAN_ME_FRENCH = 3;
        static final int INT_GREGORIAN_US = 2;
        static final int INT_GREGORIAN_XLIT_ENGLISH = 12;
        static final int INT_GREGORIAN_XLIT_FRENCH = 13;
        static final int INT_HEBREW = 6;
        static final int INT_HIJRI = 5;
        static final int INT_JAPAN = 8;
        static final int INT_KOREA = 10;
        static final int INT_NONE = 14;
        static final int INT_SAKA = 11;
        static final int INT_TAIWAN = 7;
        static final int INT_THAI = 9;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(LocalePreferences.CalendarType.GREGORIAN, 1), new Enum("gregorianUs", 2), new Enum("gregorianMeFrench", 3), new Enum("gregorianArabic", 4), new Enum("hijri", 5), new Enum(LocalePreferences.CalendarType.HEBREW, 6), new Enum("taiwan", 7), new Enum("japan", 8), new Enum("thai", 9), new Enum("korea", 10), new Enum("saka", 11), new Enum("gregorianXlitEnglish", 12), new Enum("gregorianXlitFrench", 13), new Enum("none", 14)});
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
        SimpleTypeFactory<STCalendarType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stcalendartype8cd2type");
        f19144a = r0;
        f19145b = r0.getType();
        c = Enum.forString(LocalePreferences.CalendarType.GREGORIAN);
        d = Enum.forString("gregorianUs");
        e = Enum.forString("gregorianMeFrench");
        f = Enum.forString("gregorianArabic");
        g = Enum.forString("hijri");
        h = Enum.forString(LocalePreferences.CalendarType.HEBREW);
        i = Enum.forString("taiwan");
        j = Enum.forString("japan");
        k = Enum.forString("thai");
        l = Enum.forString("korea");
        m = Enum.forString("saka");
        n = Enum.forString("gregorianXlitEnglish");
        o = Enum.forString("gregorianXlitFrench");
        p = Enum.forString("none");
    }
}
