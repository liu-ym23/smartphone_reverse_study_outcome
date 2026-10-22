package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum FieldsDocumentPart extends Enum<FieldsDocumentPart> {
    private static final /* synthetic */ FieldsDocumentPart[] $VALUES = null;
    public static final FieldsDocumentPart ANNOTATIONS = null;
    public static final FieldsDocumentPart ENDNOTES = null;
    public static final FieldsDocumentPart FOOTNOTES = null;
    public static final FieldsDocumentPart HEADER = null;
    public static final FieldsDocumentPart HEADER_TEXTBOX = null;
    public static final FieldsDocumentPart MAIN = null;
    public static final FieldsDocumentPart TEXTBOX = null;
    private final int fibFieldsField;

    static {
        FieldsDocumentPart r0 = new FieldsDocumentPart("ANNOTATIONS", 0, 19);
        ANNOTATIONS = r0;
        FieldsDocumentPart r1 = new FieldsDocumentPart("ENDNOTES", 1, 48);
        ENDNOTES = r1;
        FieldsDocumentPart r3 = new FieldsDocumentPart("FOOTNOTES", 2, 18);
        FOOTNOTES = r3;
        FieldsDocumentPart r5 = new FieldsDocumentPart("HEADER", 3, 17);
        HEADER = r5;
        FieldsDocumentPart r7 = new FieldsDocumentPart("HEADER_TEXTBOX", 4, 59);
        HEADER_TEXTBOX = r7;
        FieldsDocumentPart r9 = new FieldsDocumentPart("MAIN", 5, 16);
        MAIN = r9;
        FieldsDocumentPart r11 = new FieldsDocumentPart("TEXTBOX", 6, 57);
        TEXTBOX = r11;
        $VALUES = new FieldsDocumentPart[]{r0, r1, r3, r5, r7, r9, r11};
    }

    private FieldsDocumentPart(String r1, int r2, int r3) {
        super(r1, r2);
        this.fibFieldsField = r3;
    }

    public static FieldsDocumentPart valueOf(String r2) {
        return (FieldsDocumentPart) ZeusTransformUtils.preCheckCast(Enum.valueOf(FieldsDocumentPart.class, r2), FieldsDocumentPart.class, "com.obric.memorydata.plugin");
    }

    public static FieldsDocumentPart[] values() {
        return (FieldsDocumentPart[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FieldsDocumentPart[].class, "com.obric.memorydata.plugin");
    }

    public int getFibFieldsField() {
        return this.fibFieldsField;
    }
}
