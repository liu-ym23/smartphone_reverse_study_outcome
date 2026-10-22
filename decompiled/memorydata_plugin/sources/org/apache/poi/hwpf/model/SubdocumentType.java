package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final enum SubdocumentType extends Enum<SubdocumentType> {
    private static final /* synthetic */ SubdocumentType[] $VALUES = null;
    public static final SubdocumentType ANNOTATION = null;
    public static final SubdocumentType ENDNOTE = null;
    public static final SubdocumentType FOOTNOTE = null;
    public static final SubdocumentType HEADER = null;
    public static final SubdocumentType HEADER_TEXTBOX = null;

    @Deprecated
    public static final SubdocumentType MACRO = null;
    public static final SubdocumentType MAIN = null;
    public static final List<SubdocumentType> ORDERED = null;
    public static final SubdocumentType TEXTBOX = null;

    static {
        SubdocumentType r0 = new SubdocumentType("MAIN", 0);
        MAIN = r0;
        SubdocumentType r1 = new SubdocumentType("FOOTNOTE", 1);
        FOOTNOTE = r1;
        SubdocumentType r3 = new SubdocumentType("HEADER", 2);
        HEADER = r3;
        SubdocumentType r5 = new SubdocumentType("MACRO", 3);
        MACRO = r5;
        SubdocumentType r7 = new SubdocumentType("ANNOTATION", 4);
        ANNOTATION = r7;
        SubdocumentType r9 = new SubdocumentType("ENDNOTE", 5);
        ENDNOTE = r9;
        SubdocumentType r11 = new SubdocumentType("TEXTBOX", 6);
        TEXTBOX = r11;
        SubdocumentType r13 = new SubdocumentType("HEADER_TEXTBOX", 7);
        HEADER_TEXTBOX = r13;
        $VALUES = new SubdocumentType[]{r0, r1, r3, r5, r7, r9, r11, r13};
        ORDERED = Collections.unmodifiableList(Arrays.asList(new SubdocumentType[]{r0, r1, r3, r5, r7, r9, r11, r13}));
    }

    private SubdocumentType(String r1, int r2) {
        super(r1, r2);
    }

    public static SubdocumentType valueOf(String r2) {
        return (SubdocumentType) ZeusTransformUtils.preCheckCast(Enum.valueOf(SubdocumentType.class, r2), SubdocumentType.class, "com.obric.memorydata.plugin");
    }

    public static SubdocumentType[] values() {
        return (SubdocumentType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SubdocumentType[].class, "com.obric.memorydata.plugin");
    }
}
