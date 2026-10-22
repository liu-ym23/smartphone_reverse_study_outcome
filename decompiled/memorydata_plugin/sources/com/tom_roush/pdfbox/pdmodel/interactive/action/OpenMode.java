package com.tom_roush.pdfbox.pdmodel.interactive.action;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum OpenMode extends Enum<OpenMode> {
    private static final /* synthetic */ OpenMode[] $VALUES = null;
    public static final OpenMode NEW_WINDOW = null;
    public static final OpenMode SAME_WINDOW = null;
    public static final OpenMode USER_PREFERENCE = null;

    static {
        OpenMode r0 = new OpenMode("USER_PREFERENCE", 0);
        USER_PREFERENCE = r0;
        OpenMode r1 = new OpenMode("SAME_WINDOW", 1);
        SAME_WINDOW = r1;
        OpenMode r3 = new OpenMode("NEW_WINDOW", 2);
        NEW_WINDOW = r3;
        $VALUES = new OpenMode[]{r0, r1, r3};
    }

    private OpenMode(String r1, int r2) {
        super(r1, r2);
    }

    public static OpenMode valueOf(String r2) {
        return (OpenMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(OpenMode.class, r2), OpenMode.class, "com.obric.memorydata.plugin");
    }

    public static OpenMode[] values() {
        return (OpenMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OpenMode[].class, "com.obric.memorydata.plugin");
    }
}
