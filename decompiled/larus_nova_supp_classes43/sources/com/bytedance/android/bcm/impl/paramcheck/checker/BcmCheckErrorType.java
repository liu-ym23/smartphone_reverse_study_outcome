package com.bytedance.android.bcm.impl.paramcheck.checker;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/bcm/impl/paramcheck/checker/BcmCheckErrorType;", "", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "errorTip", "getErrorTip", "UNNEEDED_PARAM", "MISS_PARAM", "TYPE_ERROR", "VALUE_ERROR", "bcm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final enum BcmCheckErrorType extends Enum<BcmCheckErrorType> {
    public static final BcmCheckErrorType MISS_PARAM = null;
    public static final BcmCheckErrorType TYPE_ERROR = null;
    public static final BcmCheckErrorType UNNEEDED_PARAM = null;
    public static final BcmCheckErrorType VALUE_ERROR = null;
    public static final /* synthetic */ BcmCheckErrorType[] a = null;
    private final String errorTip;
    private final String value;

    static {
        BcmCheckErrorType r1 = new BcmCheckErrorType("UNNEEDED_PARAM", 0, "unneeded_param", "多传");
        UNNEEDED_PARAM = r1;
        BcmCheckErrorType r10 = new BcmCheckErrorType("MISS_PARAM", 1, "miss_param", "少传");
        MISS_PARAM = r10;
        BcmCheckErrorType r11 = new BcmCheckErrorType("TYPE_ERROR", 2, "illegal_type", "类型错误");
        TYPE_ERROR = r11;
        BcmCheckErrorType r12 = new BcmCheckErrorType("VALUE_ERROR", 3, "illegal_value", "值错误");
        VALUE_ERROR = r12;
        a = new BcmCheckErrorType[]{r1, r10, r11, r12};
    }

    public static BcmCheckErrorType valueOf(String r1) {
        return (BcmCheckErrorType) r27.a.a(BcmCheckErrorType.class, r1);
    }

    public static BcmCheckErrorType[] values() {
        return (BcmCheckErrorType[]) a.clone();
    }

    public final String getErrorTip() {
        return this.errorTip;
    }

    public final String getValue() {
        return this.value;
    }

    public BcmCheckErrorType(String r1, int r10, String r11, String r12) {
        super(r1, r10);
        this.value = r11;
        this.errorTip = r12;
    }
}
