package org.apache.poi.xdgf.usermodel.section;

import com.microsoft.schemas.office.visio.x2012.main.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.xdgf.usermodel.XDGFSheet;

/* JADX INFO: loaded from: classes7.dex */
final enum XDGFSectionTypes extends Enum<XDGFSectionTypes> {
    private static final /* synthetic */ XDGFSectionTypes[] $VALUES = null;
    public static final XDGFSectionTypes ACTIONS = null;
    public static final XDGFSectionTypes ACTION_TAG = null;
    public static final XDGFSectionTypes ANNOTATION = null;
    public static final XDGFSectionTypes CHARACTER = null;
    public static final XDGFSectionTypes CONNECTION = null;
    public static final XDGFSectionTypes CONNECTION_ABCD = null;
    public static final XDGFSectionTypes CONTROL = null;
    public static final XDGFSectionTypes FIELD = null;
    public static final XDGFSectionTypes FILL_GRADIENT = null;
    public static final XDGFSectionTypes GEOMETRY = null;
    public static final XDGFSectionTypes HYPERLINK = null;
    public static final XDGFSectionTypes LAYER = null;
    public static final XDGFSectionTypes LINE_GRADIENT = null;
    private static final Map<String, XDGFSectionTypes> LOOKUP = null;
    public static final XDGFSectionTypes PARAGRAPH = null;
    public static final XDGFSectionTypes PROPERTY = null;
    public static final XDGFSectionTypes REVIEWER = null;
    public static final XDGFSectionTypes SCRATCH = null;
    public static final XDGFSectionTypes TABS = null;
    public static final XDGFSectionTypes USER = null;
    private final BiFunction<q, XDGFSheet, ? extends XDGFSection> constructor;
    private final String sectionType;

    static {
        XDGFSectionTypes r0 = new XDGFSectionTypes("LINE_GRADIENT", 0, "LineGradient", $$Lambda$EcRFHAWJHQSsgL78DJQfifKfOY.INSTANCE);
        LINE_GRADIENT = r0;
        XDGFSectionTypes r1 = new XDGFSectionTypes("FILL_GRADIENT", 1, "FillGradient", $$Lambda$EcRFHAWJHQSsgL78DJQfifKfOY.INSTANCE);
        FILL_GRADIENT = r1;
        XDGFSectionTypes r2 = new XDGFSectionTypes("CHARACTER", 2, "Character", $$Lambda$4pt9hhSX0qJ1DQFwZezBY4nnRbU.INSTANCE);
        CHARACTER = r2;
        XDGFSectionTypes r4 = new XDGFSectionTypes("PARAGRAPH", 3, "Paragraph", $$Lambda$EcRFHAWJHQSsgL78DJQfifKfOY.INSTANCE);
        PARAGRAPH = r4;
        XDGFSectionTypes r6 = new XDGFSectionTypes("TABS", 4, "Tabs", $$Lambda$EcRFHAWJHQSsgL78DJQfifKfOY.INSTANCE);
        TABS = r6;
        XDGFSectionTypes r8 = new XDGFSectionTypes("SCRATCH", 5, "Scratch", $$Lambda$EcRFHAWJHQSsgL78DJQfifKfOY.INSTANCE);
        SCRATCH = r8;
        XDGFSectionTypes r10 = new XDGFSectionTypes("CONNECTION", 6, "Connection", $$Lambda$EcRFHAWJHQSsgL78DJQfifKfOY.INSTANCE);
        CONNECTION = r10;
        XDGFSectionTypes r12 = new XDGFSectionTypes("CONNECTION_ABCD", 7, "ConnectionABCD", $$Lambda$EcRFHAWJHQSsgL78DJQfifKfOY.INSTANCE);
        CONNECTION_ABCD = r12;
        XDGFSectionTypes r11 = new XDGFSectionTypes("FIELD", 8, "Field", $$Lambda$EcRFHAWJHQSsgL78DJQfifKfOY.INSTANCE);
        FIELD = r11;
        XDGFSectionTypes r9 = new XDGFSectionTypes("CONTROL", 9, "Control", $$Lambda$EcRFHAWJHQSsgL78DJQfifKfOY.INSTANCE);
        CONTROL = r9;
        XDGFSectionTypes r7 = new XDGFSectionTypes("GEOMETRY", 10, "Geometry", $$Lambda$lNCrer5BowoE87MxTMRAxBKl9vE.INSTANCE);
        GEOMETRY = r7;
        XDGFSectionTypes r5 = new XDGFSectionTypes("ACTIONS", 11, "Actions", $$Lambda$EcRFHAWJHQSsgL78DJQfifKfOY.INSTANCE);
        ACTIONS = r5;
        XDGFSectionTypes r3 = new XDGFSectionTypes("LAYER", 12, "Layer", $$Lambda$EcRFHAWJHQSsgL78DJQfifKfOY.INSTANCE);
        LAYER = r3;
        XDGFSectionTypes r13 = new XDGFSectionTypes("USER", 13, "User", $$Lambda$EcRFHAWJHQSsgL78DJQfifKfOY.INSTANCE);
        USER = r13;
        XDGFSectionTypes r14 = new XDGFSectionTypes("PROPERTY", 14, "Property", $$Lambda$EcRFHAWJHQSsgL78DJQfifKfOY.INSTANCE);
        PROPERTY = r14;
        XDGFSectionTypes r15 = new XDGFSectionTypes("HYPERLINK", 15, "Hyperlink", $$Lambda$EcRFHAWJHQSsgL78DJQfifKfOY.INSTANCE);
        HYPERLINK = r15;
        XDGFSectionTypes r16 = new XDGFSectionTypes("REVIEWER", 16, "Reviewer", $$Lambda$EcRFHAWJHQSsgL78DJQfifKfOY.INSTANCE);
        REVIEWER = r16;
        XDGFSectionTypes r17 = new XDGFSectionTypes("ANNOTATION", 17, "Annotation", $$Lambda$EcRFHAWJHQSsgL78DJQfifKfOY.INSTANCE);
        ANNOTATION = r17;
        XDGFSectionTypes r18 = new XDGFSectionTypes("ACTION_TAG", 18, "ActionTag", $$Lambda$EcRFHAWJHQSsgL78DJQfifKfOY.INSTANCE);
        ACTION_TAG = r18;
        $VALUES = new XDGFSectionTypes[]{r0, r1, r2, r4, r6, r8, r10, r12, r11, r9, r7, r5, r3, r13, r14, r15, r16, r17, r18};
        LOOKUP = (Map) ZeusTransformUtils.preCheckCast(Stream.of(values()).collect(Collectors.toMap($$Lambda$ZkY6DmgO_RFVUUpMLIxraS3ywE.INSTANCE, Function.identity())), Map.class, "com.obric.memorydata.plugin");
    }

    private XDGFSectionTypes(String r3, int r4, String r5, BiFunction r6) {
        BiFunction<q, XDGFSheet, ? extends XDGFSection> r7 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r6, BiFunction.class, "com.obric.memorydata.plugin");
        super(r3, r4);
        this.sectionType = r5;
        this.constructor = r7;
    }

    public static XDGFSection load(q r4, XDGFSheet r5) {
        q r6 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.memorydata.plugin");
        String r0 = r6.getN();
        XDGFSectionTypes r2 = (XDGFSectionTypes) ZeusTransformUtils.preCheckCast(LOOKUP.get(r0), XDGFSectionTypes.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        return (XDGFSection) ZeusTransformUtils.preCheckCast(r2.constructor.apply(r6, r5), XDGFSection.class, "com.obric.memorydata.plugin");
    L7:
        throw new POIXMLException("Invalid '" + r6.schemaType().getName().getLocalPart() + "' name '" + r0 + "'");
    }

    public static XDGFSectionTypes valueOf(String r2) {
        return (XDGFSectionTypes) ZeusTransformUtils.preCheckCast(Enum.valueOf(XDGFSectionTypes.class, r2), XDGFSectionTypes.class, "com.obric.memorydata.plugin");
    }

    public static XDGFSectionTypes[] values() {
        return (XDGFSectionTypes[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), XDGFSectionTypes[].class, "com.obric.memorydata.plugin");
    }

    public String getSectionType() {
        return this.sectionType;
    }
}
