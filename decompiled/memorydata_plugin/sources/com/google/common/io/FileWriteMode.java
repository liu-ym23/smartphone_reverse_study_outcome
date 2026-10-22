package com.google.common.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum FileWriteMode extends Enum<FileWriteMode> {
    private static final /* synthetic */ FileWriteMode[] $VALUES = null;
    public static final FileWriteMode APPEND = null;

    private static /* synthetic */ FileWriteMode[] $values() {
        return new FileWriteMode[]{APPEND};
    }

    static {
        APPEND = new FileWriteMode("APPEND", 0);
        $VALUES = $values();
    }

    private FileWriteMode(String r1, int r2) {
        super(r1, r2);
    }

    public static FileWriteMode valueOf(String r2) {
        return (FileWriteMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(FileWriteMode.class, r2), FileWriteMode.class, "com.obric.memorydata.plugin");
    }

    public static FileWriteMode[] values() {
        return (FileWriteMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FileWriteMode[].class, "com.obric.memorydata.plugin");
    }
}
