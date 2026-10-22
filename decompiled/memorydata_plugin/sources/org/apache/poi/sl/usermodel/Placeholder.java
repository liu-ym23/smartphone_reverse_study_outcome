package org.apache.poi.sl.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum Placeholder extends Enum<Placeholder> {
    private static final /* synthetic */ Placeholder[] $VALUES = null;
    public static final Placeholder BODY = null;
    public static final Placeholder CENTERED_TITLE = null;
    public static final Placeholder CHART = null;
    public static final Placeholder CLIP_ART = null;
    public static final Placeholder CONTENT = null;
    public static final Placeholder DATETIME = null;
    public static final Placeholder DGM = null;
    public static final Placeholder FOOTER = null;
    public static final Placeholder HEADER = null;
    public static final Placeholder MEDIA = null;
    public static final Placeholder NONE = null;
    public static final Placeholder PICTURE = null;
    public static final Placeholder SLIDE_IMAGE = null;
    public static final Placeholder SLIDE_NUMBER = null;
    public static final Placeholder SUBTITLE = null;
    public static final Placeholder TABLE = null;
    public static final Placeholder TITLE = null;
    public static final Placeholder VERTICAL_OBJECT = null;
    public static final Placeholder VERTICAL_TEXT_BODY = null;
    public static final Placeholder VERTICAL_TEXT_TITLE = null;
    public final int nativeNotesId;
    public final int nativeNotesMasterId;
    public final int nativeSlideId;
    public final int nativeSlideMasterId;
    public final int ooxmlId;

    static {
        Placeholder r8 = new Placeholder("NONE", 0, 0, 0, 0, 0, 0);
        NONE = r8;
        Placeholder r0 = new Placeholder("TITLE", 1, 13, 1, 1, 1, 1);
        TITLE = r0;
        Placeholder r1 = new Placeholder("BODY", 2, 14, 2, 12, 6, 2);
        BODY = r1;
        Placeholder r2 = new Placeholder("CENTERED_TITLE", 3, 15, 3, 3, 3, 3);
        CENTERED_TITLE = r2;
        Placeholder r3 = new Placeholder("SUBTITLE", 4, 16, 4, 4, 4, 4);
        SUBTITLE = r3;
        Placeholder r4 = new Placeholder("DATETIME", 5, 7, 7, 7, 7, 5);
        DATETIME = r4;
        Placeholder r5 = new Placeholder("SLIDE_NUMBER", 6, 8, 8, 8, 8, 6);
        SLIDE_NUMBER = r5;
        Placeholder r6 = new Placeholder("FOOTER", 7, 9, 9, 9, 9, 7);
        FOOTER = r6;
        Placeholder r7 = new Placeholder("HEADER", 8, 10, 10, 10, 10, 8);
        HEADER = r7;
        Placeholder r17 = new Placeholder("CONTENT", 9, 19, 19, 19, 19, 9);
        CONTENT = r17;
        Placeholder r9 = new Placeholder("CHART", 10, 20, 20, 20, 20, 10);
        CHART = r9;
        Placeholder r10 = new Placeholder("TABLE", 11, 21, 21, 21, 21, 11);
        TABLE = r10;
        Placeholder r11 = new Placeholder("CLIP_ART", 12, 22, 22, 22, 22, 12);
        CLIP_ART = r11;
        Placeholder r12 = new Placeholder("DGM", 13, 23, 23, 23, 23, 13);
        DGM = r12;
        Placeholder r13 = new Placeholder("MEDIA", 14, 24, 24, 24, 24, 14);
        MEDIA = r13;
        Placeholder r14 = new Placeholder("SLIDE_IMAGE", 15, 11, 11, 11, 5, 15);
        SLIDE_IMAGE = r14;
        Placeholder r15 = new Placeholder("PICTURE", 16, 26, 26, 26, 26, 16);
        PICTURE = r15;
        Placeholder r16 = new Placeholder("VERTICAL_OBJECT", 17, 25, 25, 25, 25, -2);
        VERTICAL_OBJECT = r16;
        Placeholder r26 = new Placeholder("VERTICAL_TEXT_TITLE", 18, 17, 17, 17, 17, -2);
        VERTICAL_TEXT_TITLE = r26;
        Placeholder r18 = new Placeholder("VERTICAL_TEXT_BODY", 19, 18, 18, 18, 18, -2);
        VERTICAL_TEXT_BODY = r18;
        $VALUES = new Placeholder[]{r8, r0, r1, r2, r3, r4, r5, r6, r7, r17, r9, r10, r11, r12, r13, r14, r15, r16, r26, r18};
    }

    private Placeholder(String r1, int r2, int r3, int r4, int r5, int r6, int r7) {
        super(r1, r2);
        this.nativeSlideId = r3;
        this.nativeSlideMasterId = r4;
        this.nativeNotesId = r5;
        this.nativeNotesMasterId = r6;
        this.ooxmlId = r7;
    }

    private static Placeholder lookupNative(int r5, int r6) {
        Placeholder[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L22;
        Placeholder r3 = r0[r2];
        if (r6 != 0) goto L9;
        if (r3.nativeSlideId != r5) goto L9;
    L20:
        return r3;
    L9:
        if (r6 != 1) goto L13;
        if (r3.nativeSlideMasterId == r5) goto L20;
    L13:
        if (r6 != 2) goto L17;
        if (r3.nativeNotesId == r5) goto L20;
    L17:
        if (r6 != 3) goto L21;
        if (r3.nativeNotesMasterId == r5) goto L20;
    L21:
        r2 = r2 + 1;
        goto L3
    L22:
        return null;
    }

    public static Placeholder lookupNativeNotes(int r1) {
        return lookupNative(r1, 2);
    }

    public static Placeholder lookupNativeNotesMaster(int r1) {
        return lookupNative(r1, 3);
    }

    public static Placeholder lookupNativeSlide(int r1) {
        return lookupNative(r1, 0);
    }

    public static Placeholder lookupNativeSlideMaster(int r1) {
        return lookupNative(r1, 1);
    }

    public static Placeholder lookupOoxml(int r5) {
        Placeholder[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        Placeholder r3 = r0[r2];
        if (r3.ooxmlId == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static Placeholder valueOf(String r2) {
        return (Placeholder) ZeusTransformUtils.preCheckCast(Enum.valueOf(Placeholder.class, r2), Placeholder.class, "com.obric.memorydata.plugin");
    }

    public static Placeholder[] values() {
        return (Placeholder[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Placeholder[].class, "com.obric.memorydata.plugin");
    }
}
