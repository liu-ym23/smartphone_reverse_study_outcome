package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum NoteType extends Enum<NoteType> {
    private static final /* synthetic */ NoteType[] $VALUES = null;
    public static final NoteType ENDNOTE = null;
    public static final NoteType FOOTNOTE = null;
    private final int fibDescriptorsFieldIndex;
    private final int fibTextPositionsFieldIndex;

    static {
        NoteType r0 = new NoteType("ENDNOTE", 0, 46, 47);
        ENDNOTE = r0;
        NoteType r1 = new NoteType("FOOTNOTE", 1, 2, 3);
        FOOTNOTE = r1;
        $VALUES = new NoteType[]{r0, r1};
    }

    private NoteType(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.fibDescriptorsFieldIndex = r3;
        this.fibTextPositionsFieldIndex = r4;
    }

    public static NoteType valueOf(String r2) {
        return (NoteType) ZeusTransformUtils.preCheckCast(Enum.valueOf(NoteType.class, r2), NoteType.class, "com.obric.memorydata.plugin");
    }

    public static NoteType[] values() {
        return (NoteType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NoteType[].class, "com.obric.memorydata.plugin");
    }

    public int getFibDescriptorsFieldIndex() {
        return this.fibDescriptorsFieldIndex;
    }

    public int getFibTextPositionsFieldIndex() {
        return this.fibTextPositionsFieldIndex;
    }
}
