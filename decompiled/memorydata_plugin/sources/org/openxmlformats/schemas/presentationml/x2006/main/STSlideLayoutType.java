package org.openxmlformats.schemas.presentationml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STSlideLayoutType extends XmlToken {
    public static final Enum A = null;
    public static final Enum B = null;
    public static final Enum C = null;
    public static final Enum D = null;
    public static final Enum E = null;
    public static final Enum F = null;
    public static final Enum G = null;
    public static final Enum H = null;
    public static final Enum I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final Enum f19184J = null;
    public static final Enum K = null;
    public static final Enum L = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STSlideLayoutType> f19185a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19186b = null;
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
    public static final Enum s = null;
    public static final Enum t = null;
    public static final Enum u = null;
    public static final Enum v = null;
    public static final Enum w = null;
    public static final Enum x = null;
    public static final Enum y = null;
    public static final Enum z = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BLANK = 12;
        static final int INT_CHART = 8;
        static final int INT_CHART_AND_TX = 6;
        static final int INT_CLIP_ART_AND_TX = 10;
        static final int INT_CLIP_ART_AND_VERT_TX = 26;
        static final int INT_CUST = 32;
        static final int INT_DGM = 7;
        static final int INT_FOUR_OBJ = 24;
        static final int INT_MEDIA_AND_TX = 18;
        static final int INT_OBJ = 16;
        static final int INT_OBJ_AND_TWO_OBJ = 30;
        static final int INT_OBJ_AND_TX = 14;
        static final int INT_OBJ_ONLY = 15;
        static final int INT_OBJ_OVER_TX = 19;
        static final int INT_OBJ_TX = 35;
        static final int INT_PIC_TX = 36;
        static final int INT_SEC_HEAD = 33;
        static final int INT_TBL = 4;
        static final int INT_TITLE = 1;
        static final int INT_TITLE_ONLY = 11;
        static final int INT_TWO_COL_TX = 3;
        static final int INT_TWO_OBJ = 29;
        static final int INT_TWO_OBJ_AND_OBJ = 31;
        static final int INT_TWO_OBJ_AND_TX = 22;
        static final int INT_TWO_OBJ_OVER_TX = 23;
        static final int INT_TWO_TX_TWO_OBJ = 34;
        static final int INT_TX = 2;
        static final int INT_TX_AND_CHART = 5;
        static final int INT_TX_AND_CLIP_ART = 9;
        static final int INT_TX_AND_MEDIA = 17;
        static final int INT_TX_AND_OBJ = 13;
        static final int INT_TX_AND_TWO_OBJ = 21;
        static final int INT_TX_OVER_OBJ = 20;
        static final int INT_VERT_TITLE_AND_TX = 27;
        static final int INT_VERT_TITLE_AND_TX_OVER_CHART = 28;
        static final int INT_VERT_TX = 25;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("title", 1), new Enum("tx", 2), new Enum("twoColTx", 3), new Enum("tbl", 4), new Enum("txAndChart", 5), new Enum("chartAndTx", 6), new Enum("dgm", 7), new Enum("chart", 8), new Enum("txAndClipArt", 9), new Enum("clipArtAndTx", 10), new Enum("titleOnly", 11), new Enum("blank", 12), new Enum("txAndObj", 13), new Enum("objAndTx", 14), new Enum("objOnly", 15), new Enum("obj", 16), new Enum("txAndMedia", 17), new Enum("mediaAndTx", 18), new Enum("objOverTx", 19), new Enum("txOverObj", 20), new Enum("txAndTwoObj", 21), new Enum("twoObjAndTx", 22), new Enum("twoObjOverTx", 23), new Enum("fourObj", 24), new Enum("vertTx", 25), new Enum("clipArtAndVertTx", 26), new Enum("vertTitleAndTx", 27), new Enum("vertTitleAndTxOverChart", 28), new Enum("twoObj", 29), new Enum("objAndTwoObj", 30), new Enum("twoObjAndObj", 31), new Enum("cust", 32), new Enum("secHead", 33), new Enum("twoTxTwoObj", 34), new Enum("objTx", 35), new Enum("picTx", 36)});
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
        SimpleTypeFactory<STSlideLayoutType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stslidelayouttype3aaatype");
        f19185a = r0;
        f19186b = r0.getType();
        c = Enum.forString("title");
        d = Enum.forString("tx");
        e = Enum.forString("twoColTx");
        f = Enum.forString("tbl");
        g = Enum.forString("txAndChart");
        h = Enum.forString("chartAndTx");
        i = Enum.forString("dgm");
        j = Enum.forString("chart");
        k = Enum.forString("txAndClipArt");
        l = Enum.forString("clipArtAndTx");
        m = Enum.forString("titleOnly");
        n = Enum.forString("blank");
        o = Enum.forString("txAndObj");
        p = Enum.forString("objAndTx");
        q = Enum.forString("objOnly");
        r = Enum.forString("obj");
        s = Enum.forString("txAndMedia");
        t = Enum.forString("mediaAndTx");
        u = Enum.forString("objOverTx");
        v = Enum.forString("txOverObj");
        w = Enum.forString("txAndTwoObj");
        x = Enum.forString("twoObjAndTx");
        y = Enum.forString("twoObjOverTx");
        z = Enum.forString("fourObj");
        A = Enum.forString("vertTx");
        B = Enum.forString("clipArtAndVertTx");
        C = Enum.forString("vertTitleAndTx");
        D = Enum.forString("vertTitleAndTxOverChart");
        E = Enum.forString("twoObj");
        F = Enum.forString("objAndTwoObj");
        G = Enum.forString("twoObjAndObj");
        H = Enum.forString("cust");
        I = Enum.forString("secHead");
        f19184J = Enum.forString("twoTxTwoObj");
        K = Enum.forString("objTx");
        L = Enum.forString("picTx");
    }
}
