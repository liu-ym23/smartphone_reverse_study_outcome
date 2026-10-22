package org.apache.poi.sl.draw.geom;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.loc.o;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.xml.stream.e;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.sl.usermodel.PaintStyle;

/* JADX INFO: loaded from: classes7.dex */
class PresetParser {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final c LOG = null;
    private CustomGeometry customGeometry;
    private final Map<String, CustomGeometry> geom;
    private Mode mode;
    private Path path;
    private boolean useAdjustValue;

    static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode AH_LST = null;
        public static final Mode CXN_LST = null;
        public static final Mode FILE = null;
        public static final Mode GUIDE_LST = null;
        public static final Mode PATH = null;
        public static final Mode PATH_LST = null;
        public static final Mode SHAPE = null;
        public static final Mode SHAPE_LST = null;
        final Handler handler;

        interface Handler {
            void update(PresetParser r1, e r2);
        }

        static {
            Mode r0 = new Mode("FILE", 0, $$Lambda$PresetParser$Mode$s63THOn52bURJLjgnS7pCqglXDw.INSTANCE);
            FILE = r0;
            Mode r1 = new Mode("SHAPE_LST", 1, $$Lambda$PresetParser$Mode$O1X893_h8WBJdUHpHeEyzc6PhM.INSTANCE);
            SHAPE_LST = r1;
            Mode r2 = new Mode("SHAPE", 2, $$Lambda$PresetParser$Mode$DVdofg7JiTfhArDbFZw14n2N5qY.INSTANCE);
            SHAPE = r2;
            Mode r4 = new Mode("GUIDE_LST", 3, $$Lambda$PresetParser$Mode$kyzWZDnzIxc47W0v3oBDzCYkKY.INSTANCE);
            GUIDE_LST = r4;
            Mode r6 = new Mode("AH_LST", 4, $$Lambda$PresetParser$Mode$sf7IkYVyeTOqG2SAYezCFlrdqr0.INSTANCE);
            AH_LST = r6;
            Mode r8 = new Mode("CXN_LST", 5, $$Lambda$PresetParser$Mode$Wzs6EFkSbjjI2f74hyG3VDcCmUs.INSTANCE);
            CXN_LST = r8;
            Mode r10 = new Mode("PATH_LST", 6, $$Lambda$PresetParser$Mode$6Xft6mPD5rAkDqfxNqLG4NcuZKc.INSTANCE);
            PATH_LST = r10;
            Mode r12 = new Mode("PATH", 7, $$Lambda$PresetParser$Mode$3fQKgf__w_XwiEp8iDOLyRLGc.INSTANCE);
            PATH = r12;
            $VALUES = new Mode[]{r0, r1, r2, r4, r6, r8, r10, r12};
        }

        private Mode(String r3, int r4, Handler r5) {
            Handler r6 = (Handler) ZeusTransformUtils.wrapperContextForParams(r5, Handler.class, "com.obric.memorydata.plugin");
            super(r3, r4);
            this.handler = r6;
        }

        static /* synthetic */ void lambda$static$0(PresetParser r2, e r3) {
            PresetParser.access$700(r2, (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
        }

        static /* synthetic */ void lambda$static$1(PresetParser r2, e r3) {
            PresetParser.access$600(r2, (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
        }

        static /* synthetic */ void lambda$static$2(PresetParser r2, e r3) {
            PresetParser.access$500(r2, (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
        }

        static /* synthetic */ void lambda$static$3(PresetParser r2, e r3) {
            PresetParser.access$400(r2, (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
        }

        static /* synthetic */ void lambda$static$4(PresetParser r2, e r3) {
            PresetParser.access$300(r2, (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
        }

        static /* synthetic */ void lambda$static$5(PresetParser r2, e r3) {
            PresetParser.access$200(r2, (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
        }

        static /* synthetic */ void lambda$static$6(PresetParser r2, e r3) {
            PresetParser.access$100(r2, (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
        }

        static /* synthetic */ void lambda$static$7(PresetParser r2, e r3) {
            PresetParser.access$000(r2, (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
        }

        public static Mode valueOf(String r2) {
            return (Mode) ZeusTransformUtils.preCheckCast(Enum.valueOf(Mode.class, r2), Mode.class, "com.obric.memorydata.plugin");
        }

        public static Mode[] values() {
            return (Mode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Mode[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        LOG = b.a(PresetParser.class);
    }

    static /* synthetic */ void access$000(PresetParser r2, e r3) {
        r2.updatePath((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void access$100(PresetParser r2, e r3) {
        r2.updatePathLst((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void access$200(PresetParser r2, e r3) {
        r2.updateCxnList((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void access$300(PresetParser r2, e r3) {
        r2.updateAhList((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void access$400(PresetParser r2, e r3) {
        r2.updateGuideList((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void access$500(PresetParser r2, e r3) {
        r2.updateShape((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void access$600(PresetParser r2, e r3) {
        r2.updateShapeList((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void access$700(PresetParser r2, e r3) {
        r2.updateFile((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
    }

    private void addPolar(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        final PolarAdjustHandle r0 = new PolarAdjustHandle();
        this.customGeometry.addAdjustHandle(r0);
        parseAttributes(r4, new $$Lambda$PresetParser$K15fs71pDh_RkSOGXGLwVhTCngA(r0));
        r0.setPos(parsePosPoint(r4));
    }

    private void addRectangle(e r6) {
        e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r6, e.class, "com.obric.memorydata.plugin");
        final String[] r0 = new String[4];
        parseAttributes(r7, new $$Lambda$PresetParser$yREsumFVGFDYbyI7N451slE5v4Q(r0));
        this.customGeometry.setTextBounds(r0[0], r0[1], r0[2], r0[3]);
        nextTag(r7);
    }

    private void addXY(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        final XYAdjustHandle r0 = new XYAdjustHandle();
        this.customGeometry.addAdjustHandle(r0);
        parseAttributes(r4, new $$Lambda$PresetParser$8kBbX4nVTNBLIhAsrnxh4nzZAj4(r0));
        r0.setPos(parsePosPoint(r4));
    }

    private void arcTo(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        final ArcToCommand r0 = new ArcToCommand();
        this.path.addCommand(r0);
        parseAttributes(r4, new $$Lambda$PresetParser$NJ0O_PDFC2VMblj_qKLri2cr_UQ(r0));
        nextTag(r4);
    }

    private void closePath(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        this.path.addCommand(new ClosePathCommand());
        nextTag(r4);
    }

    private static String collapseString(String r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        int r0 = r8.length();
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        if (isWhiteSpace(r8.charAt(r2)) == true) goto L11;
        r2 = r2 + 1;
    L11:
        if (r2 != r0) goto L13;
        return r8;
    L13:
        StringBuilder r3 = new StringBuilder(r0);
        if (r2 == 0) goto L18;
    L15:
        if (r1 >= r2) goto L17;
        r3.append(r8.charAt(r1));
        r1 = r1 + 1;
        goto L15
    L17:
        r3.append(' ');
    L18:
        int r4 = r2 + 1;
        boolean r5 = true;
    L19:
        if (r4 >= r0) goto L28;
        char r6 = r8.charAt(r4);
        boolean r7 = isWhiteSpace(r6);
        if (r5 == false) goto L24;
        if (r7 == false) goto L24;
    L27:
        r4 = r4 + 1;
    L24:
        if (r7 == false) goto L26;
        r6 = ' ';
    L26:
        r3.append(r6);
        r5 = r7;
        goto L27
    L28:
        int r9 = r3.length();
        if (r9 <= 0) goto L34;
        int r10 = r9 - 1;
        if (r3.charAt(r10) != ' ') goto L34;
        r3.setLength(r10);
    L34:
        return r3.toString();
    }

    private void cubicBezTo(e r5) {
        e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
        CurveToCommand r0 = new CurveToCommand();
        this.path.addCommand(r0);
        AdjustPoint r2 = parsePtPoint(r6, false);
        AdjustPoint r1 = parsePtPoint(r6, false);
        AdjustPoint r4 = parsePtPoint(r6, true);
        r0.setPt1(r2);
        r0.setPt2(r1);
        r0.setPt3(r4);
    }

    private static boolean isWhiteSpace(char r1) {
        if (r1 != '\t') goto L5;
    L12:
        return true;
    L5:
        if (r1 == '\n') goto L12;
        if (r1 == '\r') goto L12;
        if (r1 == ' ') goto L12;
        return false;
    }

    static /* synthetic */ void lambda$addPolar$2(PolarAdjustHandle r2, String r3, String r4) {
        r3.hashCode();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -1251269476: goto L26;
            case -1081167402: goto L22;
            case -1074077144: goto L18;
            case 3344238: goto L14;
            case 3351616: goto L10;
            case 120863620: goto L6;
            default: goto L29;
        };
    L29:
        switch(r1) {
            case 0: goto L36;
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            default: goto L43;
        };
    L31:
        r2.setGdRefAng(collapseString(r4));
        return;
    L32:
        r2.setMinR(r4);
        return;
    L33:
        r2.setMaxR(r4);
        return;
    L34:
        r2.setMinAng(r4);
        return;
    L35:
        r2.setMaxAng(r4);
        return;
    L36:
        r2.setGdRefR(collapseString(r4));
        return;
    L43:
        return;
    L6:
        if (r3.equals("gdRefAng") == false) goto L29;
        r1 = 5;
        goto L29
    L10:
        if (r3.equals("minR") == false) goto L29;
        r1 = 4;
        goto L29
    L14:
        if (r3.equals("maxR") == false) goto L29;
        r1 = 3;
        goto L29
    L18:
        if (r3.equals("minAng") == false) goto L29;
        r1 = 2;
        goto L29
    L22:
        if (r3.equals("maxAng") == false) goto L29;
        r1 = 1;
        goto L29
    L26:
        if (r3.equals("gdRefR") == false) goto L29;
        r1 = 0;
        goto L29
    }

    static /* synthetic */ void lambda$addRectangle$6(String[] r6, String r7, String r8) {
        r7.hashCode();
        byte r5 = -1;
        switch(r7.hashCode()) {
            case 98: goto L18;
            case 108: goto L14;
            case 114: goto L10;
            case 116: goto L6;
            default: goto L21;
        };
    L21:
        switch(r5) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            default: goto L31;
        };
    L23:
        r6[1] = r8;
        return;
    L24:
        r6[2] = r8;
        return;
    L25:
        r6[0] = r8;
        return;
    L26:
        r6[3] = r8;
        return;
    L31:
        return;
    L6:
        if (r7.equals("t") == false) goto L21;
        r5 = 3;
        goto L21
    L10:
        if (r7.equals("r") == false) goto L21;
        r5 = 2;
        goto L21
    L14:
        if (r7.equals("l") == false) goto L21;
        r5 = 1;
        goto L21
    L18:
        if (r7.equals("b") == false) goto L21;
        r5 = 0;
        goto L21
    }

    static /* synthetic */ void lambda$addXY$1(XYAdjustHandle r2, String r3, String r4) {
        r3.hashCode();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -1251269470: goto L26;
            case -1251269469: goto L22;
            case 3344244: goto L18;
            case 3344245: goto L14;
            case 3351622: goto L10;
            case 3351623: goto L6;
            default: goto L29;
        };
    L29:
        switch(r1) {
            case 0: goto L36;
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            default: goto L43;
        };
    L31:
        r2.setMinY(r4);
        return;
    L32:
        r2.setMinX(r4);
        return;
    L33:
        r2.setMaxY(r4);
        return;
    L34:
        r2.setMaxX(r4);
        return;
    L35:
        r2.setGdRefY(collapseString(r4));
        return;
    L36:
        r2.setGdRefX(collapseString(r4));
        return;
    L43:
        return;
    L6:
        if (r3.equals("minY") == false) goto L29;
        r1 = 5;
        goto L29
    L10:
        if (r3.equals("minX") == false) goto L29;
        r1 = 4;
        goto L29
    L14:
        if (r3.equals("maxY") == false) goto L29;
        r1 = 3;
        goto L29
    L18:
        if (r3.equals("maxX") == false) goto L29;
        r1 = 2;
        goto L29
    L22:
        if (r3.equals("gdRefY") == false) goto L29;
        r1 = 1;
        goto L29
    L26:
        if (r3.equals("gdRefX") == false) goto L29;
        r1 = 0;
        goto L29
    }

    static /* synthetic */ void lambda$arcTo$5(ArcToCommand r2, String r3, String r4) {
        r3.hashCode();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case 3306: goto L18;
            case 3771: goto L14;
            case 109726649: goto L10;
            case 109816022: goto L6;
            default: goto L21;
        };
    L21:
        switch(r1) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            default: goto L31;
        };
    L23:
        r2.setSwAng(r4);
        return;
    L24:
        r2.setStAng(r4);
        return;
    L25:
        r2.setWR(r4);
        return;
    L26:
        r2.setHR(r4);
        return;
    L31:
        return;
    L6:
        if (r3.equals("swAng") == false) goto L21;
        r1 = 3;
        goto L21
    L10:
        if (r3.equals("stAng") == false) goto L21;
        r1 = 2;
        goto L21
    L14:
        if (r3.equals("wR") == false) goto L21;
        r1 = 1;
        goto L21
    L18:
        if (r3.equals("hR") == false) goto L21;
        r1 = 0;
        goto L21
    }

    static /* synthetic */ void lambda$parseAdjPoint$7(AdjustPoint r1, String r2, String r3) {
        r2.hashCode();
        if (r2.equals("x") == false) goto L5;
        r1.setX(r3);
        return;
    L5:
        if (r2.equals("y") == false) goto L11;
        r1.setY(r3);
        return;
    }

    static /* synthetic */ void lambda$updateCxnList$3(ConnectionSite r1, String r2, String r3) {
        if ("ang".equals(r2) == false) goto L6;
        r1.setAng(r3);
        return;
    }

    static /* synthetic */ void lambda$updateGuideList$0(Guide r1, String r2, String r3) {
        r2.hashCode();
        if (r2.equals("fmla") == false) goto L5;
        r1.setFmla(r3);
        return;
    L5:
        if (r2.equals(ActivityLifecycle.NAME) == false) goto L11;
        r1.setName(collapseString(r3));
        return;
    }

    private void lineTo(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        LineToCommand r0 = new LineToCommand();
        this.path.addCommand(r0);
        r0.setPt(parsePtPoint(r4, true));
    }

    private static PaintStyle.PaintModifier mapFill(String r6) {
        switch(r6.hashCode()) {
            case -2005126536: goto L21;
            case -1414880040: goto L18;
            case -1338968417: goto L15;
            case 3387192: goto L12;
            case 3387324: goto L9;
            case 170546239: goto L6;
            default: goto L23;
        };
    L23:
        byte r7 = -1;
    L24:
        if (r7 == 2) goto L40;
        if (r7 == 3) goto L38;
        if (r7 == 4) goto L36;
        if (r7 == 5) goto L34;
        if (r7 == 6) goto L32;
        return PaintStyle.PaintModifier.NONE;
    L32:
        return PaintStyle.PaintModifier.DARKEN_LESS;
    L34:
        return PaintStyle.PaintModifier.DARKEN;
    L36:
        return PaintStyle.PaintModifier.LIGHTEN_LESS;
    L38:
        return PaintStyle.PaintModifier.LIGHTEN;
    L40:
        return PaintStyle.PaintModifier.NORM;
    L6:
        if (r6.equals("lighten") == false) goto L23;
        r7 = 3;
        goto L24
    L9:
        if (r6.equals("norm") == false) goto L23;
        r7 = 2;
        goto L24
    L12:
        if (r6.equals("none") == false) goto L23;
        r7 = 1;
        goto L24
    L15:
        if (r6.equals("darken") == false) goto L23;
        r7 = 5;
        goto L24
    L18:
        if (r6.equals("darkenLess") == false) goto L23;
        r7 = 6;
        goto L24
    L21:
        if (r6.equals("lightenLess") == false) goto L23;
        r7 = 4;
        goto L24
    }

    private void moveTo(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        MoveToCommand r0 = new MoveToCommand();
        this.path.addCommand(r0);
        r0.setPt(parsePtPoint(r4, true));
    }

    private static int nextTag(e r2) {
        e r3 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
    L3:
        int r0 = r3.next();
        if (r0 == 1) goto L9;
        if (r0 == 2) goto L9;
        if (r0 != 8) goto L3;
    L9:
        return r0;
    }

    private AdjustPoint parseAdjPoint(e r2, boolean r3, String r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
        if (nextTag(r5) != 2) goto L6;
        return null;
    L6:
        final AdjustPoint r6 = new AdjustPoint();
        parseAttributes(r5, new $$Lambda$PresetParser$Ctgh6mbMultNW541sOKy85FzyUo(r6));
        nextTag(r5);
        if (r3 == false) goto L9;
        nextTag(r5);
    L9:
        return r6;
    }

    private void parseAttributes(e r3, BiConsumer<String, String> r4) {
        e r2 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        BiConsumer r5 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r4, BiConsumer.class, "com.obric.memorydata.plugin");
        int r6 = 0;
    L4:
        if (r6 >= r2.getAttributeCount()) goto L6;
        r5.accept(r2.getAttributeLocalName(r6), r2.getAttributeValue(r6));
        r6 = r6 + 1;
        goto L4
    }

    private AdjustPoint parsePosPoint(e r3) {
        return parseAdjPoint((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"), true, "pos");
    }

    private AdjustPoint parsePtPoint(e r3, boolean r4) {
        return parseAdjPoint((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"), r4, "pt");
    }

    private void quadBezTo(e r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
        QuadToCommand r0 = new QuadToCommand();
        this.path.addCommand(r0);
        AdjustPoint r1 = parsePtPoint(r5, false);
        AdjustPoint r3 = parsePtPoint(r5, true);
        r0.setPt1(r1);
        r0.setPt2(r3);
    }

    private void updateAhList(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        String r0 = r4.getLocalName();
        r0.hashCode();
        if (r0.equals("ahPolar") == false) goto L5;
        addPolar(r4);
        return;
    L5:
        if (r0.equals("ahXY") == false) goto L11;
        addXY(r4);
        return;
    }

    private void updateCxnList(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        r4.getLocalName();
        final ConnectionSite r0 = new ConnectionSite();
        this.customGeometry.addConnectionSite(r0);
        parseAttributes(r4, new $$Lambda$PresetParser$qGzNtoYgRtg7pICla9KlWRYeDoE(r0));
        r0.setPos(parsePosPoint(r4));
    }

    private void updateFile(e r3) {
        ((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin")).getLocalName();
        this.mode = Mode.SHAPE_LST;
    }

    private void updateGuideList(e r6) {
        e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r6, e.class, "com.obric.memorydata.plugin");
        r7.getLocalName();
        if (this.useAdjustValue == false) goto L5;
        CustomGeometry r0 = this.customGeometry;
        final Guide r2 = new AdjustValue();
        r0.addAdjustGuide((AdjustValue) ZeusTransformUtils.preCheckCast((AdjustValue) ZeusTransformUtils.preCheckCast(r2, AdjustValue.class, "com.obric.memorydata.plugin"), AdjustValue.class, "com.obric.memorydata.plugin"));
    L6:
        parseAttributes(r7, new $$Lambda$PresetParser$ev3U_ZgrzsnulLXZxicAbYmMIlE(r2));
        nextTag(r7);
        return;
    L5:
        CustomGeometry r1 = this.customGeometry;
        r2 = new Guide();
        r1.addGeomGuide(r2);
        goto L6
    }

    private void updatePath(e r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
        String r0 = r5.getLocalName();
        r0.hashCode();
        byte r2 = -1;
        switch(r0.hashCode()) {
            case -1513004949: goto L26;
            case -1068263892: goto L22;
            case 3325853: goto L18;
            case 93075565: goto L14;
            case 94756344: goto L10;
            case 1594918984: goto L6;
            default: goto L29;
        };
    L29:
        switch(r2) {
            case 0: goto L36;
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            default: goto L43;
        };
    L31:
        cubicBezTo(r5);
        return;
    L32:
        closePath(r5);
        return;
    L33:
        arcTo(r5);
        return;
    L34:
        lineTo(r5);
        return;
    L35:
        moveTo(r5);
        return;
    L36:
        quadBezTo(r5);
        return;
    L43:
        return;
    L6:
        if (r0.equals("cubicBezTo") == false) goto L29;
        r2 = 5;
        goto L29
    L10:
        if (r0.equals(IslandSession.REOPEN_VALUE_CLOSE) == false) goto L29;
        r2 = 4;
        goto L29
    L14:
        if (r0.equals("arcTo") == false) goto L29;
        r2 = 3;
        goto L29
    L18:
        if (r0.equals("lnTo") == false) goto L29;
        r2 = 2;
        goto L29
    L22:
        if (r0.equals("moveTo") == false) goto L29;
        r2 = 1;
        goto L29
    L26:
        if (r0.equals("quadBezTo") == false) goto L29;
        r2 = 0;
        goto L29
    }

    private void updatePathLst(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        r4.getLocalName();
        Path r0 = new Path();
        this.path = r0;
        this.customGeometry.addPath(r0);
        parseAttributes(r4, new $$Lambda$PresetParser$h0wnYeILqmpbdACxAkENXr3nEno(this));
        this.mode = Mode.PATH;
    }

    private void updateShape(e r6) {
        e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r6, e.class, "com.obric.memorydata.plugin");
        String r0 = r7.getLocalName();
        r0.hashCode();
        byte r4 = -1;
        switch(r0.hashCode()) {
            case -1346505100: goto L26;
            case -791471768: goto L22;
            case 3496420: goto L18;
            case 92756518: goto L14;
            case 93173592: goto L10;
            case 98178480: goto L6;
            default: goto L29;
        };
    L29:
        switch(r4) {
            case 0: goto L38;
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L32;
            case 5: goto L31;
            default: goto L41;
        };
    L31:
        this.useAdjustValue = false;
    L33:
        Mode r8 = Mode.GUIDE_LST;
    L34:
        this.mode = r8;
        return;
    L32:
        this.useAdjustValue = true;
        goto L33
    L35:
        r8 = Mode.AH_LST;
        goto L34
    L36:
        addRectangle(r7);
        return;
    L37:
        r8 = Mode.PATH_LST;
        goto L34
    L38:
        r8 = Mode.CXN_LST;
        goto L34
    L41:
        return;
    L6:
        if (r0.equals("gdLst") == false) goto L29;
        r4 = 5;
        goto L29
    L10:
        if (r0.equals("avLst") == false) goto L29;
        r4 = 4;
        goto L29
    L14:
        if (r0.equals("ahLst") == false) goto L29;
        r4 = 3;
        goto L29
    L18:
        if (r0.equals("rect") == false) goto L29;
        r4 = 2;
        goto L29
    L22:
        if (r0.equals("pathLst") == false) goto L29;
        r4 = 1;
        goto L29
    L26:
        if (r0.equals("cxnLst") == false) goto L29;
        r4 = 0;
        goto L29
    }

    private void updateShapeList(e r3) {
        String r4 = ((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin")).getLocalName();
        this.customGeometry = new CustomGeometry();
        if (this.geom.containsKey(r4) == false) goto L5;
        LOG.atWarn().a("Duplicate definition of {}", r4);
    L5:
        this.geom.put(r4, this.customGeometry);
        this.mode = Mode.SHAPE;
    }

    public /* synthetic */ void lambda$updatePathLst$4$PresetParser(String r3, String r4) {
        r3.hashCode();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -1453197163: goto L22;
            case -891980232: goto L18;
            case 104: goto L14;
            case 119: goto L10;
            case 3143043: goto L6;
            default: goto L25;
        };
    L25:
        switch(r1) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            default: goto L37;
        };
    L27:
        this.path.setFill(mapFill(r4));
        return;
    L28:
        this.path.setW(Long.parseLong(r4));
        return;
    L29:
        this.path.setH(Long.parseLong(r4));
        return;
    L30:
        this.path.setStroke(Boolean.parseBoolean(r4));
        return;
    L31:
        this.path.setExtrusionOk(Boolean.parseBoolean(r4));
        return;
    L37:
        return;
    L6:
        if (r3.equals("fill") == false) goto L25;
        r1 = 4;
        goto L25
    L10:
        if (r3.equals("w") == false) goto L25;
        r1 = 3;
        goto L25
    L14:
        if (r3.equals(o.g) == false) goto L25;
        r1 = 2;
        goto L25
    L18:
        if (r3.equals("stroke") == false) goto L25;
        r1 = 1;
        goto L25
    L22:
        if (r3.equals("extrusionOk") == false) goto L25;
        r1 = 0;
        goto L25
    }
}
