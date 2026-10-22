package com.larus.dora.impl.file;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/larus/dora/impl/file/DoraFileType;", "", "code", "", "uploadType", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getUploadType", "()Ljava/lang/String;", "UNKNOWN", "CRASH", "PERFORMANCE", "LOG", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraFileType extends Enum<DoraFileType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DoraFileType[] $VALUES = null;
    public static final DoraFileType CRASH = null;
    public static final a Companion = null;
    public static final DoraFileType LOG = null;
    public static final DoraFileType PERFORMANCE = null;
    public static final DoraFileType UNKNOWN = null;
    private final int code;
    private final String uploadType;

    private static final /* synthetic */ DoraFileType[] $values() {
        return new DoraFileType[]{UNKNOWN, CRASH, PERFORMANCE, LOG};
    }

    public static EnumEntries<DoraFileType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.dora.impl.file.DoraFileType$a] */
    static {
        UNKNOWN = new DoraFileType("UNKNOWN", 0, 0, "unknown");
        CRASH = new DoraFileType("CRASH", 1, 1, "crash");
        PERFORMANCE = new DoraFileType("PERFORMANCE", 2, 2, "performance");
        LOG = new DoraFileType("LOG", 3, 3, "log");
        DoraFileType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new a();
    }

    public static DoraFileType[] values() {
        return (DoraFileType[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getUploadType() {
        return this.uploadType;
    }

    public static DoraFileType valueOf(String r1) {
        return (DoraFileType) r27.a.a(DoraFileType.class, r1);
    }

    private DoraFileType(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.code = r3;
        this.uploadType = r4;
    }
}
