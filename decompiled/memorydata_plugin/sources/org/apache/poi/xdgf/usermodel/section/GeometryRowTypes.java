package org.apache.poi.xdgf.usermodel.section;

import com.microsoft.schemas.office.visio.x2012.main.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow;

/* JADX INFO: loaded from: classes7.dex */
final enum GeometryRowTypes extends Enum<GeometryRowTypes> {
    private static final /* synthetic */ GeometryRowTypes[] $VALUES = null;
    public static final GeometryRowTypes ARC_TO = null;
    public static final GeometryRowTypes ELLIPSE = null;
    public static final GeometryRowTypes ELLIPTICAL_ARC_TO = null;
    public static final GeometryRowTypes INFINITE_LINE = null;
    public static final GeometryRowTypes LINE_TO = null;
    private static final Map<String, GeometryRowTypes> LOOKUP = null;
    public static final GeometryRowTypes MOVE_TO = null;
    public static final GeometryRowTypes NURBS_TO = null;
    public static final GeometryRowTypes POLYLINE_TO = null;
    public static final GeometryRowTypes REL_CUB_BEZ_TO = null;
    public static final GeometryRowTypes REL_ELLIPTICAL_ARC_TO = null;
    public static final GeometryRowTypes REL_LINE_TO = null;
    public static final GeometryRowTypes REL_MOVE_TO = null;
    public static final GeometryRowTypes REL_QUAD_BEZ_TO = null;
    public static final GeometryRowTypes SPLINE_KNOT = null;
    public static final GeometryRowTypes SPLINE_START = null;
    private final Function<p, ? extends GeometryRow> constructor;
    private final String rowType;

    static {
        GeometryRowTypes r0 = new GeometryRowTypes("ARC_TO", 0, "ArcTo", $$Lambda$uJoTWpQWtCiwasyhQbHpxJyoczM.INSTANCE);
        ARC_TO = r0;
        GeometryRowTypes r1 = new GeometryRowTypes("ELLIPSE", 1, "Ellipse", $$Lambda$5jG7bTtPv_cUJDts2bpXItjSNH4.INSTANCE);
        ELLIPSE = r1;
        GeometryRowTypes r2 = new GeometryRowTypes("ELLIPTICAL_ARC_TO", 2, "EllipticalArcTo", $$Lambda$yeSLIwOR1ri3cIEOL2RUg47abvI.INSTANCE);
        ELLIPTICAL_ARC_TO = r2;
        GeometryRowTypes r4 = new GeometryRowTypes("INFINITE_LINE", 3, "InfiniteLine", $$Lambda$0UkrYAauVeim0Gf2GTPTjB4zs.INSTANCE);
        INFINITE_LINE = r4;
        GeometryRowTypes r6 = new GeometryRowTypes("LINE_TO", 4, "LineTo", $$Lambda$PKE1FmvMpznUC9DlxkJRl0S6y0M.INSTANCE);
        LINE_TO = r6;
        GeometryRowTypes r8 = new GeometryRowTypes("MOVE_TO", 5, "MoveTo", $$Lambda$0DT1YFiLAWueD1hu73si14DCkU.INSTANCE);
        MOVE_TO = r8;
        GeometryRowTypes r10 = new GeometryRowTypes("NURBS_TO", 6, "NURBSTo", $$Lambda$bl1IaTBSyj9wyPfYTHYoeWdO4WQ.INSTANCE);
        NURBS_TO = r10;
        GeometryRowTypes r12 = new GeometryRowTypes("POLYLINE_TO", 7, "PolylineTo", $$Lambda$tQAaQhN_kx9uF6upckioxIIP7ig.INSTANCE);
        POLYLINE_TO = r12;
        GeometryRowTypes r11 = new GeometryRowTypes("REL_CUB_BEZ_TO", 8, "RelCubBezTo", $$Lambda$8R1sreJm3FY4i1JMnzDEGb9fOVI.INSTANCE);
        REL_CUB_BEZ_TO = r11;
        GeometryRowTypes r9 = new GeometryRowTypes("REL_ELLIPTICAL_ARC_TO", 9, "RelEllipticalArcTo", $$Lambda$fbDuHauPRwG2Gu8rF2gfEadDdsE.INSTANCE);
        REL_ELLIPTICAL_ARC_TO = r9;
        GeometryRowTypes r7 = new GeometryRowTypes("REL_LINE_TO", 10, "RelLineTo", $$Lambda$qqJiOQciNvwgBaMrq3z8NcgyvtQ.INSTANCE);
        REL_LINE_TO = r7;
        GeometryRowTypes r5 = new GeometryRowTypes("REL_MOVE_TO", 11, "RelMoveTo", $$Lambda$BqbOGMyl1ZZ3HG6eD0lQTrkJ1zE.INSTANCE);
        REL_MOVE_TO = r5;
        GeometryRowTypes r3 = new GeometryRowTypes("REL_QUAD_BEZ_TO", 12, "RelQuadBezTo", $$Lambda$UFxyPjdmtDdiFCh3rhyET5GqyM.INSTANCE);
        REL_QUAD_BEZ_TO = r3;
        GeometryRowTypes r13 = new GeometryRowTypes("SPLINE_KNOT", 13, "SplineKnot", $$Lambda$8ecDx8wS8YBnXwALpA3t8J4Szw.INSTANCE);
        SPLINE_KNOT = r13;
        GeometryRowTypes r14 = new GeometryRowTypes("SPLINE_START", 14, "SplineStart", $$Lambda$068YoyFjNqr27IjQTar0SuUiu6k.INSTANCE);
        SPLINE_START = r14;
        $VALUES = new GeometryRowTypes[]{r0, r1, r2, r4, r6, r8, r10, r12, r11, r9, r7, r5, r3, r13, r14};
        LOOKUP = (Map) ZeusTransformUtils.preCheckCast(Stream.of(values()).collect(Collectors.toMap($$Lambda$wJ3wGs5HmPBG41_mFCop7ExpwM.INSTANCE, Function.identity())), Map.class, "com.obric.memorydata.plugin");
    }

    private GeometryRowTypes(String r3, int r4, String r5, Function r6) {
        Function<p, ? extends GeometryRow> r7 = (Function) ZeusTransformUtils.wrapperContextForParams(r6, Function.class, "com.obric.memorydata.plugin");
        super(r3, r4);
        this.rowType = r5;
        this.constructor = r7;
    }

    public static GeometryRow load(p r4) {
        p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.memorydata.plugin");
        String r0 = r5.getT();
        GeometryRowTypes r2 = (GeometryRowTypes) ZeusTransformUtils.preCheckCast(LOOKUP.get(r0), GeometryRowTypes.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        return (GeometryRow) ZeusTransformUtils.preCheckCast(r2.constructor.apply(r5), GeometryRow.class, "com.obric.memorydata.plugin");
    L7:
        throw new POIXMLException("Invalid '" + r5.schemaType().getName().getLocalPart() + "' name '" + r0 + "'");
    }

    public static GeometryRowTypes valueOf(String r2) {
        return (GeometryRowTypes) ZeusTransformUtils.preCheckCast(Enum.valueOf(GeometryRowTypes.class, r2), GeometryRowTypes.class, "com.obric.memorydata.plugin");
    }

    public static GeometryRowTypes[] values() {
        return (GeometryRowTypes[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GeometryRowTypes[].class, "com.obric.memorydata.plugin");
    }

    public String getRowType() {
        return this.rowType;
    }
}
