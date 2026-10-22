package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STPageBorderOffset extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STPageBorderOffset> f19851a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19852b = null;
    public static final Enum c = null;
    public static final Enum d = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_PAGE = 1;
        static final int INT_TEXT = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("page", 1), new Enum(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, 2)});
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
        SimpleTypeFactory<STPageBorderOffset> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stpageborderoffset518atype");
        f19851a = r0;
        f19852b = r0.getType();
        c = Enum.forString("page");
        d = Enum.forString(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
    }
}
