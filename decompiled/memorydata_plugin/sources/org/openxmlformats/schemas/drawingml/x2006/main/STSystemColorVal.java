package org.openxmlformats.schemas.drawingml.x2006.main;

import com.bytedance.bdlocation.trace.TraceCons;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface STSystemColorVal extends XmlToken {
    public static final Enum A = null;
    public static final Enum B = null;
    public static final Enum C = null;
    public static final Enum D = null;
    public static final Enum E = null;
    public static final Enum F = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STSystemColorVal> f18647a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18648b = null;
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
        static final int INT_ACTIVE_BORDER = 11;
        static final int INT_ACTIVE_CAPTION = 3;
        static final int INT_APP_WORKSPACE = 13;
        static final int INT_BACKGROUND = 2;
        static final int INT_BTN_FACE = 16;
        static final int INT_BTN_HIGHLIGHT = 21;
        static final int INT_BTN_SHADOW = 17;
        static final int INT_BTN_TEXT = 19;
        static final int INT_CAPTION_TEXT = 10;
        static final int INT_GRADIENT_ACTIVE_CAPTION = 27;
        static final int INT_GRADIENT_INACTIVE_CAPTION = 28;
        static final int INT_GRAY_TEXT = 18;
        static final int INT_HIGHLIGHT = 14;
        static final int INT_HIGHLIGHT_TEXT = 15;
        static final int INT_HOT_LIGHT = 26;
        static final int INT_INACTIVE_BORDER = 12;
        static final int INT_INACTIVE_CAPTION = 4;
        static final int INT_INACTIVE_CAPTION_TEXT = 20;
        static final int INT_INFO_BK = 25;
        static final int INT_INFO_TEXT = 24;
        static final int INT_MENU = 5;
        static final int INT_MENU_BAR = 30;
        static final int INT_MENU_HIGHLIGHT = 29;
        static final int INT_MENU_TEXT = 8;
        static final int INT_SCROLL_BAR = 1;
        static final int INT_WINDOW = 6;
        static final int INT_WINDOW_FRAME = 7;
        static final int INT_WINDOW_TEXT = 9;
        static final int INT_X_3_D_DK_SHADOW = 22;
        static final int INT_X_3_D_LIGHT = 23;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("scrollBar", 1), new Enum(TraceCons.METRIC_BACKGROUND, 2), new Enum("activeCaption", 3), new Enum("inactiveCaption", 4), new Enum("menu", 5), new Enum("window", 6), new Enum("windowFrame", 7), new Enum("menuText", 8), new Enum("windowText", 9), new Enum("captionText", 10), new Enum("activeBorder", 11), new Enum("inactiveBorder", 12), new Enum("appWorkspace", 13), new Enum("highlight", 14), new Enum("highlightText", 15), new Enum("btnFace", 16), new Enum("btnShadow", 17), new Enum("grayText", 18), new Enum("btnText", 19), new Enum("inactiveCaptionText", 20), new Enum("btnHighlight", 21), new Enum("3dDkShadow", 22), new Enum("3dLight", 23), new Enum("infoText", 24), new Enum("infoBk", 25), new Enum("hotLight", 26), new Enum("gradientActiveCaption", 27), new Enum("gradientInactiveCaption", 28), new Enum("menuHighlight", 29), new Enum("menuBar", 30)});
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
        SimpleTypeFactory<STSystemColorVal> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stsystemcolorvalf938type");
        f18647a = r0;
        f18648b = r0.getType();
        c = Enum.forString("scrollBar");
        d = Enum.forString(TraceCons.METRIC_BACKGROUND);
        e = Enum.forString("activeCaption");
        f = Enum.forString("inactiveCaption");
        g = Enum.forString("menu");
        h = Enum.forString("window");
        i = Enum.forString("windowFrame");
        j = Enum.forString("menuText");
        k = Enum.forString("windowText");
        l = Enum.forString("captionText");
        m = Enum.forString("activeBorder");
        n = Enum.forString("inactiveBorder");
        o = Enum.forString("appWorkspace");
        p = Enum.forString("highlight");
        q = Enum.forString("highlightText");
        r = Enum.forString("btnFace");
        s = Enum.forString("btnShadow");
        t = Enum.forString("grayText");
        u = Enum.forString("btnText");
        v = Enum.forString("inactiveCaptionText");
        w = Enum.forString("btnHighlight");
        x = Enum.forString("3dDkShadow");
        y = Enum.forString("3dLight");
        z = Enum.forString("infoText");
        A = Enum.forString("infoBk");
        B = Enum.forString("hotLight");
        C = Enum.forString("gradientActiveCaption");
        D = Enum.forString("gradientInactiveCaption");
        E = Enum.forString("menuHighlight");
        F = Enum.forString("menuBar");
    }
}
