package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum FilePreviewStage extends Enum<FilePreviewStage> implements WireEnum {
    private static final /* synthetic */ FilePreviewStage[] $VALUES = null;
    public static final ProtoAdapter<FilePreviewStage> ADAPTER = null;
    public static final FilePreviewStage Encrypted = null;
    public static final FilePreviewStage Normal = null;
    public static final FilePreviewStage NotSupportedSize = null;
    public static final FilePreviewStage NotSupportedType = null;
    public static final FilePreviewStage UnknownStage = null;
    private final int value;

    static {
        FilePreviewStage r0 = new FilePreviewStage("UnknownStage", 0, 0);
        UnknownStage = r0;
        FilePreviewStage r1 = new FilePreviewStage("Normal", 1, 1);
        Normal = r1;
        FilePreviewStage r3 = new FilePreviewStage("Encrypted", 2, 2);
        Encrypted = r3;
        FilePreviewStage r5 = new FilePreviewStage("NotSupportedType", 3, 3);
        NotSupportedType = r5;
        FilePreviewStage r7 = new FilePreviewStage("NotSupportedSize", 4, 4);
        NotSupportedSize = r7;
        $VALUES = new FilePreviewStage[]{r0, r1, r3, r5, r7};
        ADAPTER = ProtoAdapter.newEnumAdapter(FilePreviewStage.class);
    }

    public static FilePreviewStage[] values() {
        return (FilePreviewStage[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FilePreviewStage fromValue(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L14;
        return null;
    L14:
        return NotSupportedSize;
    L16:
        return NotSupportedType;
    L18:
        return Encrypted;
    L20:
        return Normal;
    L22:
        return UnknownStage;
    }

    public static FilePreviewStage valueOf(String r1) {
        return (FilePreviewStage) a.a(FilePreviewStage.class, r1);
    }

    private FilePreviewStage(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
