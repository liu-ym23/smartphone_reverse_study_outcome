package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.profile.monitor.DataType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/recharge/utils/ApiResult;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "RESPONSE_FAILD", "RESPONSE_SUCCESS", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ApiResult extends Enum<ApiResult> {
    public static final ApiResult RESPONSE_FAILD = null;
    public static final ApiResult RESPONSE_SUCCESS = null;
    public static final /* synthetic */ ApiResult[] a = null;
    private final String value;

    static {
        ApiResult r1 = new ApiResult("RESPONSE_FAILD", 0, DataType.FALSE);
        RESPONSE_FAILD = r1;
        ApiResult r2 = new ApiResult("RESPONSE_SUCCESS", 1, DataType.TRUE);
        RESPONSE_SUCCESS = r2;
        a = new ApiResult[]{r1, r2};
    }

    public static ApiResult valueOf(String r1) {
        return (ApiResult) r27.a.a(ApiResult.class, r1);
    }

    public static ApiResult[] values() {
        return (ApiResult[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ApiResult(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
