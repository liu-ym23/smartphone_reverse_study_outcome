package com.bytedance.iesgurd.update;

import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/iesgurd/update/ErrorCode;", "", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum ErrorCode extends Enum<ErrorCode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ErrorCode f6701b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ErrorCode f6702c = null;
    public static final ErrorCode d = null;
    public static final ErrorCode e = null;
    public static final ErrorCode f = null;
    public static final ErrorCode g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ErrorCode f6703h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ErrorCode f6704i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ErrorCode f6705j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ErrorCode f6706k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ErrorCode f6707l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ErrorCode f6708m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ErrorCode f6709n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ ErrorCode[] f6710o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6711a;

    static {
        ErrorCode r5 = new ErrorCode("UNEXPECTED", 0, -999);
        f6701b = r5;
        ErrorCode r10 = new ErrorCode("DOWNLOAD", 1, 100);
        f6702c = r10;
        ErrorCode r11 = new ErrorCode("DOWNLOAD_CHECK", 2, 101);
        d = r11;
        ErrorCode r12 = new ErrorCode("DOWNLOAD_OTHER", 3, 102);
        ErrorCode r13 = new ErrorCode("UNZIP", 4, 200);
        e = r13;
        ErrorCode r14 = new ErrorCode("MERGE_PATCH", 5, 300);
        f = r14;
        ErrorCode r15 = new ErrorCode("MERGE_PATCH_CHECK", 6, LynxErrorCode.LYNX_ERROR_CODE_RESOURCE);
        g = r15;
        ErrorCode r16 = new ErrorCode("MERGE_PATCH_LOCK", 7, LynxErrorCode.LYNX_ERROR_CODE_COMPONENT_NOT_EXIST);
        f6703h = r16;
        ErrorCode r17 = new ErrorCode("MERGE_PATCH_NO_LOCAL", 8, 303);
        f6704i = r17;
        ErrorCode r18 = new ErrorCode("BYTE_PATCH_LOCK", 9, 310);
        f6705j = r18;
        ErrorCode r19 = new ErrorCode("DECOMPRESS_ZSTD", 10, 400);
        f6706k = r19;
        ErrorCode r110 = new ErrorCode("DECOMPRESS_ZSTD_CHECK", 11, LynxErrorCode.LYNX_ERROR_CODE_UPDATE);
        f6707l = r110;
        ErrorCode r111 = new ErrorCode("RENAME_SINGLE", 12, 410);
        f6708m = r111;
        ErrorCode r112 = new ErrorCode("RENAME", 13, 500);
        f6709n = r112;
        f6710o = new ErrorCode[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112};
    }

    public ErrorCode(String r5, int r10, int r11) {
        super(r5, r10);
        this.f6711a = r11;
    }

    public static ErrorCode valueOf(String r5) {
        return (ErrorCode) Enum.valueOf(ErrorCode.class, r5);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) f6710o.clone();
    }
}
