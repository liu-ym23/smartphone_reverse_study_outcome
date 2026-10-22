package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/utils/recorder/ErrorNo;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "errCode", "I", "getErrCode", "()I", "setErrCode", "(I)V", "NORMAL_ERROR", "POLICY_ERROR", "CONSUME_TIMEOUT", "OBJECT_NULL", "NO_CONSUMER", "RESOURCE_ERROR", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ErrorNo extends Enum<ErrorNo> {
    public static final ErrorNo CONSUME_TIMEOUT = null;
    public static final ErrorNo NORMAL_ERROR = null;
    public static final ErrorNo NO_CONSUMER = null;
    public static final ErrorNo OBJECT_NULL = null;
    public static final ErrorNo POLICY_ERROR = null;
    public static final ErrorNo RESOURCE_ERROR = null;
    public static final /* synthetic */ ErrorNo[] a = null;
    private int errCode;

    static {
        ErrorNo r1 = new ErrorNo("NORMAL_ERROR", 0, 300001);
        NORMAL_ERROR = r1;
        ErrorNo r2 = new ErrorNo("POLICY_ERROR", 1, 300002);
        POLICY_ERROR = r2;
        ErrorNo r3 = new ErrorNo("CONSUME_TIMEOUT", 2, 400001);
        CONSUME_TIMEOUT = r3;
        ErrorNo r4 = new ErrorNo("OBJECT_NULL", 3, 400002);
        OBJECT_NULL = r4;
        ErrorNo r5 = new ErrorNo("NO_CONSUMER", 4, 400003);
        NO_CONSUMER = r5;
        ErrorNo r6 = new ErrorNo("RESOURCE_ERROR", 5, 400004);
        RESOURCE_ERROR = r6;
        a = new ErrorNo[]{r1, r2, r3, r4, r5, r6};
    }

    public static ErrorNo valueOf(String r1) {
        return (ErrorNo) r27.a.a(ErrorNo.class, r1);
    }

    public static ErrorNo[] values() {
        return (ErrorNo[]) a.clone();
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final void setErrCode(int r1) {
        this.errCode = r1;
    }

    public ErrorNo(String r1, int r2, int r3) {
        super(r1, r2);
        this.errCode = r3;
    }
}
