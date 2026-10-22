package com.larus.platform.model.upload;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/platform/model/upload/UploadDataType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "FILE", "IMAGE", "VIDEO", "UNCLEAR", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum UploadDataType extends Enum<UploadDataType> {
    public static final a Companion = null;
    public static final UploadDataType FILE = null;
    public static final UploadDataType IMAGE = null;
    public static final UploadDataType UNCLEAR = null;
    public static final UploadDataType VIDEO = null;
    public static final /* synthetic */ UploadDataType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<UploadDataType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.platform.model.upload.UploadDataType$a] */
    static {
        UploadDataType r0 = new UploadDataType("FILE", 0, "file");
        FILE = r0;
        UploadDataType r1 = new UploadDataType("IMAGE", 1, "image");
        IMAGE = r1;
        UploadDataType r3 = new UploadDataType("VIDEO", 2, "video");
        VIDEO = r3;
        UploadDataType r5 = new UploadDataType("UNCLEAR", 3, "unclear");
        UNCLEAR = r5;
        UploadDataType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static UploadDataType[] values() {
        return (UploadDataType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static UploadDataType valueOf(String r1) {
        return (UploadDataType) r27.a.a(UploadDataType.class, r1);
    }

    public UploadDataType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
