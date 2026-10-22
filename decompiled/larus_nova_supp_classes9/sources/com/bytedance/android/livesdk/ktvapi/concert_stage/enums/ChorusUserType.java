package com.bytedance.android.livesdk.ktvapi.concert_stage.enums;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/concert_stage/enums/ChorusUserType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "type", "I", "getType", "()I", "ChorusUserType_Unknow", "ChorusUserType_OnMic", "ChorusUserType_Silence", "ChorusUserType_Cdn", "ChorusUserType_Fallback", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ChorusUserType extends Enum<ChorusUserType> {
    public static final ChorusUserType ChorusUserType_Cdn = null;
    public static final ChorusUserType ChorusUserType_Fallback = null;
    public static final ChorusUserType ChorusUserType_OnMic = null;
    public static final ChorusUserType ChorusUserType_Silence = null;
    public static final ChorusUserType ChorusUserType_Unknow = null;
    public static final /* synthetic */ ChorusUserType[] a = null;
    private final int type;

    static {
        ChorusUserType r1 = new ChorusUserType("ChorusUserType_Unknow", 0, 0);
        ChorusUserType_Unknow = r1;
        ChorusUserType r2 = new ChorusUserType("ChorusUserType_OnMic", 1, 1);
        ChorusUserType_OnMic = r2;
        ChorusUserType r3 = new ChorusUserType("ChorusUserType_Silence", 2, 2);
        ChorusUserType_Silence = r3;
        ChorusUserType r4 = new ChorusUserType("ChorusUserType_Cdn", 3, 3);
        ChorusUserType_Cdn = r4;
        ChorusUserType r5 = new ChorusUserType("ChorusUserType_Fallback", 4, 4);
        ChorusUserType_Fallback = r5;
        a = new ChorusUserType[]{r1, r2, r3, r4, r5};
    }

    public static ChorusUserType valueOf(String r1) {
        return (ChorusUserType) a.a(ChorusUserType.class, r1);
    }

    public static ChorusUserType[] values() {
        return (ChorusUserType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ChorusUserType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
