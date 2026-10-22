package com.bytedance.android.live.room.api.messagewindow.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"com/bytedance/android/live/room/api/messagewindow/model/CommonCardConstant$Result", "", "Lcom/bytedance/android/live/room/api/messagewindow/model/CommonCardConstant$Result;", "", "value", "I", "getValue", "()I", "FAIL", "SUCCESS", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommonCardConstant$Result extends Enum<CommonCardConstant$Result> {
    public static final CommonCardConstant$Result FAIL = null;
    public static final CommonCardConstant$Result SUCCESS = null;
    public static final /* synthetic */ CommonCardConstant$Result[] a = null;
    private final int value;

    static {
        CommonCardConstant$Result r1 = new CommonCardConstant$Result("FAIL", 0, 0);
        FAIL = r1;
        CommonCardConstant$Result r2 = new CommonCardConstant$Result("SUCCESS", 1, 1);
        SUCCESS = r2;
        a = new CommonCardConstant$Result[]{r1, r2};
    }

    public static CommonCardConstant$Result valueOf(String r1) {
        return (CommonCardConstant$Result) a.a(CommonCardConstant$Result.class, r1);
    }

    public static CommonCardConstant$Result[] values() {
        return (CommonCardConstant$Result[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CommonCardConstant$Result(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
