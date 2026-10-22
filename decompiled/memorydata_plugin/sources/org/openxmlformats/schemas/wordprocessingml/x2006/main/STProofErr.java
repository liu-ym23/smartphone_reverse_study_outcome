package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STProofErr extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STProofErr> f19855a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19856b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_GRAM_END = 4;
        static final int INT_GRAM_START = 3;
        static final int INT_SPELL_END = 2;
        static final int INT_SPELL_START = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("spellStart", 1), new Enum("spellEnd", 2), new Enum("gramStart", 3), new Enum("gramEnd", 4)});
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
        SimpleTypeFactory<STProofErr> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stprooferr6bf7type");
        f19855a = r0;
        f19856b = r0.getType();
        c = Enum.forString("spellStart");
        d = Enum.forString("spellEnd");
        e = Enum.forString("gramStart");
        f = Enum.forString("gramEnd");
    }
}
