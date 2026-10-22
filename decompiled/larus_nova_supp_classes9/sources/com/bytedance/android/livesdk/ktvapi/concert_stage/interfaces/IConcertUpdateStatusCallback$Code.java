package com.bytedance.android.livesdk.ktvapi.concert_stage.interfaces;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"com/bytedance/android/livesdk/ktvapi/concert_stage/interfaces/IConcertUpdateStatusCallback$Code", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/ktvapi/concert_stage/interfaces/IConcertUpdateStatusCallback$Code;", BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IConcertUpdateStatusCallback$Code extends Enum<IConcertUpdateStatusCallback$Code> {
    public static final IConcertUpdateStatusCallback$Code Failed = null;
    public static final IConcertUpdateStatusCallback$Code NOT_REGISTER = null;
    public static final IConcertUpdateStatusCallback$Code NO_PERMISSION = null;
    public static final IConcertUpdateStatusCallback$Code Success = null;
    public static final /* synthetic */ IConcertUpdateStatusCallback$Code[] a = null;
    private final int value;

    static {
        IConcertUpdateStatusCallback$Code r1 = new IConcertUpdateStatusCallback$Code("Success", 0, 1);
        Success = r1;
        IConcertUpdateStatusCallback$Code r2 = new IConcertUpdateStatusCallback$Code("Failed", 1, 0);
        Failed = r2;
        IConcertUpdateStatusCallback$Code r3 = new IConcertUpdateStatusCallback$Code("NO_PERMISSION", 2, -1);
        NO_PERMISSION = r3;
        IConcertUpdateStatusCallback$Code r4 = new IConcertUpdateStatusCallback$Code("NOT_REGISTER", 3, -2);
        NOT_REGISTER = r4;
        a = new IConcertUpdateStatusCallback$Code[]{r1, r2, r3, r4};
    }

    public static IConcertUpdateStatusCallback$Code valueOf(String r1) {
        return (IConcertUpdateStatusCallback$Code) a.a(IConcertUpdateStatusCallback$Code.class, r1);
    }

    public static IConcertUpdateStatusCallback$Code[] values() {
        return (IConcertUpdateStatusCallback$Code[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public IConcertUpdateStatusCallback$Code(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
