package com.bytedance.android.livesdk.ktvapi.concert_stage.enums;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/concert_stage/enums/ChorusLeaveType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "type", "I", "getType", "()I", "ChorusLeaveType_Unknow", "ChorusLeaveType_Mid", "ChorusLeaveType_End", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ChorusLeaveType extends Enum<ChorusLeaveType> {
    public static final ChorusLeaveType ChorusLeaveType_End = null;
    public static final ChorusLeaveType ChorusLeaveType_Mid = null;
    public static final ChorusLeaveType ChorusLeaveType_Unknow = null;
    public static final /* synthetic */ ChorusLeaveType[] a = null;
    private final int type;

    static {
        ChorusLeaveType r1 = new ChorusLeaveType("ChorusLeaveType_Unknow", 0, 0);
        ChorusLeaveType_Unknow = r1;
        ChorusLeaveType r2 = new ChorusLeaveType("ChorusLeaveType_Mid", 1, 1);
        ChorusLeaveType_Mid = r2;
        ChorusLeaveType r3 = new ChorusLeaveType("ChorusLeaveType_End", 2, 2);
        ChorusLeaveType_End = r3;
        a = new ChorusLeaveType[]{r1, r2, r3};
    }

    public static ChorusLeaveType valueOf(String r1) {
        return (ChorusLeaveType) a.a(ChorusLeaveType.class, r1);
    }

    public static ChorusLeaveType[] values() {
        return (ChorusLeaveType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ChorusLeaveType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
