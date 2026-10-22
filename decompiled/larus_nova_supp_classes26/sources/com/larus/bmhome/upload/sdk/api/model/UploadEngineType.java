package com.larus.bmhome.upload.sdk.api.model;

import com.larus.bmhome.instruction.handler.InstructionHandlerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/UploadEngineType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", InstructionHandlerType.VIDEO, "FILE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UploadEngineType extends Enum<UploadEngineType> {
    public static final UploadEngineType FILE = null;
    public static final UploadEngineType IMAGE = null;
    public static final UploadEngineType VIDEO = null;
    public static final /* synthetic */ UploadEngineType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UploadEngineType> getEntries() {
        return b;
    }

    static {
        UploadEngineType r0 = new UploadEngineType("IMAGE", 0);
        IMAGE = r0;
        UploadEngineType r1 = new UploadEngineType(InstructionHandlerType.VIDEO, 1);
        VIDEO = r1;
        UploadEngineType r3 = new UploadEngineType("FILE", 2);
        FILE = r3;
        UploadEngineType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static UploadEngineType[] values() {
        return (UploadEngineType[]) a.clone();
    }

    public static UploadEngineType valueOf(String r1) {
        return (UploadEngineType) a.a(UploadEngineType.class, r1);
    }

    public UploadEngineType(String r1, int r2) {
        super(r1, r2);
    }
}
