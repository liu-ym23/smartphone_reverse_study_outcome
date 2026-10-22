package com.obric.capabilitykit.entity.enums;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/FileTypeEnum;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "FILE", "DIRECTORY", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final enum FileTypeEnum extends Enum<FileTypeEnum> {
    private static final /* synthetic */ FileTypeEnum[] $VALUES = null;
    public static final a Companion = null;
    public static final FileTypeEnum DIRECTORY = null;
    public static final FileTypeEnum FILE = null;

    private static final /* synthetic */ FileTypeEnum[] $values() {
        return new FileTypeEnum[]{FILE, DIRECTORY};
    }

    static {
        FILE = new FileTypeEnum("FILE", 0);
        DIRECTORY = new FileTypeEnum("DIRECTORY", 1);
        $VALUES = $values();
        Companion = new a();
    }

    private FileTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static FileTypeEnum valueOf(String r1) {
        return (FileTypeEnum) a.a(FileTypeEnum.class, r1);
    }

    public static FileTypeEnum[] values() {
        return (FileTypeEnum[]) $VALUES.clone();
    }
}
