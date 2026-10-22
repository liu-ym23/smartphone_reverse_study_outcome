package org.openxmlformats.schemas.presentationml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STPlaceholderType extends XmlToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STPlaceholderType> f19182a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19183b = null;
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
    public static final Enum q = null;
    public static final Enum r = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BODY = 2;
        static final int INT_CHART = 10;
        static final int INT_CLIP_ART = 12;
        static final int INT_CTR_TITLE = 3;
        static final int INT_DGM = 13;
        static final int INT_DT = 5;
        static final int INT_FTR = 7;
        static final int INT_HDR = 8;
        static final int INT_MEDIA = 14;
        static final int INT_OBJ = 9;
        static final int INT_PIC = 16;
        static final int INT_SLD_IMG = 15;
        static final int INT_SLD_NUM = 6;
        static final int INT_SUB_TITLE = 4;
        static final int INT_TBL = 11;
        static final int INT_TITLE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("title", 1), new Enum("body", 2), new Enum("ctrTitle", 3), new Enum("subTitle", 4), new Enum("dt", 5), new Enum("sldNum", 6), new Enum("ftr", 7), new Enum("hdr", 8), new Enum("obj", 9), new Enum("chart", 10), new Enum("tbl", 11), new Enum("clipArt", 12), new Enum("dgm", 13), new Enum("media", 14), new Enum("sldImg", 15), new Enum("pic", 16)});
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
        SimpleTypeFactory<STPlaceholderType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stplaceholdertypeca72type");
        f19182a = r0;
        f19183b = r0.getType();
        c = Enum.forString("title");
        d = Enum.forString("body");
        e = Enum.forString("ctrTitle");
        f = Enum.forString("subTitle");
        g = Enum.forString("dt");
        h = Enum.forString("sldNum");
        i = Enum.forString("ftr");
        j = Enum.forString("hdr");
        k = Enum.forString("obj");
        l = Enum.forString("chart");
        m = Enum.forString("tbl");
        n = Enum.forString("clipArt");
        o = Enum.forString("dgm");
        p = Enum.forString("media");
        q = Enum.forString("sldImg");
        r = Enum.forString("pic");
    }
}
