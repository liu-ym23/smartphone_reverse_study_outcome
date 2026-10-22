package com.larus.bmhome.upload.sdk.api.model;

import com.larus.bmhome.instruction.handler.InstructionHandlerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/UploadMediaType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", InstructionHandlerType.VIDEO, "FILE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UploadMediaType extends Enum<UploadMediaType> {
    public static final UploadMediaType FILE = null;
    public static final UploadMediaType IMAGE = null;
    public static final UploadMediaType VIDEO = null;
    public static final /* synthetic */ UploadMediaType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UploadMediaType> getEntries() {
        return b;
    }

    static {
        UploadMediaType r0 = new UploadMediaType("IMAGE", 0);
        IMAGE = r0;
        UploadMediaType r1 = new UploadMediaType(InstructionHandlerType.VIDEO, 1);
        VIDEO = r1;
        UploadMediaType r3 = new UploadMediaType("FILE", 2);
        FILE = r3;
        UploadMediaType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static UploadMediaType[] values() {
        return (UploadMediaType[]) a.clone();
    }

    public static UploadMediaType valueOf(String r1) {
        return (UploadMediaType) a.a(UploadMediaType.class, r1);
    }

    public UploadMediaType(String r1, int r2) {
        super(r1, r2);
    }
}
