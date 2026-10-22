package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum FileType extends Enum<FileType> implements WireEnum {
    private static final /* synthetic */ FileType[] $VALUES = null;
    public static final ProtoAdapter<FileType> ADAPTER = null;
    public static final FileType FILE_AUDIO = null;
    public static final FileType FILE_IMAGE = null;
    public static final FileType FILE_OTHER = null;
    public static final FileType FILE_PDF = null;
    public static final FileType FILE_VIDEO = null;
    private final int value;

    static {
        FileType r0 = new FileType("FILE_VIDEO", 0, 1);
        FILE_VIDEO = r0;
        FileType r1 = new FileType("FILE_AUDIO", 1, 2);
        FILE_AUDIO = r1;
        FileType r4 = new FileType("FILE_IMAGE", 2, 3);
        FILE_IMAGE = r4;
        FileType r6 = new FileType("FILE_PDF", 3, 4);
        FILE_PDF = r6;
        FileType r8 = new FileType("FILE_OTHER", 4, 99);
        FILE_OTHER = r8;
        $VALUES = new FileType[]{r0, r1, r4, r6, r8};
        ADAPTER = ProtoAdapter.newEnumAdapter(FileType.class);
    }

    public static FileType[] values() {
        return (FileType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FileType fromValue(int r1) {
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        if (r1 == 4) goto L17;
        if (r1 == 99) goto L15;
        return null;
    L15:
        return FILE_OTHER;
    L17:
        return FILE_PDF;
    L19:
        return FILE_IMAGE;
    L21:
        return FILE_AUDIO;
    L23:
        return FILE_VIDEO;
    }

    public static FileType valueOf(String r1) {
        return (FileType) a.a(FileType.class, r1);
    }

    private FileType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
