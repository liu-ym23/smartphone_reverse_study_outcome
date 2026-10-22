package com.obric.memorydata.aikernelcore.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/aikernelcore/utils/OcrErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "FILE_AUTHORITY_ERROR", "LOAD_SCRIPT_MODEL_ERROR", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum OcrErrorCode extends Enum<OcrErrorCode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OcrErrorCode[] $VALUES = null;
    public static final OcrErrorCode FILE_AUTHORITY_ERROR = null;
    public static final OcrErrorCode LOAD_SCRIPT_MODEL_ERROR = null;
    private final int code;

    private static final /* synthetic */ OcrErrorCode[] $values() {
        return new OcrErrorCode[]{FILE_AUTHORITY_ERROR, LOAD_SCRIPT_MODEL_ERROR};
    }

    static {
        FILE_AUTHORITY_ERROR = new OcrErrorCode("FILE_AUTHORITY_ERROR", 0, -1001);
        LOAD_SCRIPT_MODEL_ERROR = new OcrErrorCode("LOAD_SCRIPT_MODEL_ERROR", 1, -1002);
        OcrErrorCode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private OcrErrorCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }

    public static EnumEntries<OcrErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static OcrErrorCode valueOf(String r2) {
        return (OcrErrorCode) ZeusTransformUtils.preCheckCast(Enum.valueOf(OcrErrorCode.class, r2), OcrErrorCode.class, "com.obric.memorydata.plugin");
    }

    public static OcrErrorCode[] values() {
        return (OcrErrorCode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OcrErrorCode[].class, "com.obric.memorydata.plugin");
    }

    public final int getCode() {
        return this.code;
    }
}
