package com.bytedance.android.livesdk.ktvapi.concert_stage.enums;

import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/concert_stage/enums/ConcertBizIdType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", "a", "LINK_SERVICE", "TUNING", "CHORUS", "UNKNOWN", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ConcertBizIdType extends Enum<ConcertBizIdType> {
    public static final ConcertBizIdType CHORUS = null;
    public static final a Companion = null;
    public static final ConcertBizIdType LINK_SERVICE = null;
    public static final ConcertBizIdType TUNING = null;
    public static final ConcertBizIdType UNKNOWN = null;
    public static final /* synthetic */ ConcertBizIdType[] a = null;
    private final String value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.ktvapi.concert_stage.enums.ConcertBizIdType$a] */
    static {
        ConcertBizIdType r1 = new ConcertBizIdType("LINK_SERVICE", 0, "link_service");
        LINK_SERVICE = r1;
        ConcertBizIdType r2 = new ConcertBizIdType("TUNING", 1, "tuning");
        TUNING = r2;
        ConcertBizIdType r3 = new ConcertBizIdType("CHORUS", 2, "chorus");
        CHORUS = r3;
        ConcertBizIdType r4 = new ConcertBizIdType("UNKNOWN", 3, CardLockInfo.sUNKNOWN);
        UNKNOWN = r4;
        a = new ConcertBizIdType[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static ConcertBizIdType valueOf(String r1) {
        return (ConcertBizIdType) r27.a.a(ConcertBizIdType.class, r1);
    }

    public static ConcertBizIdType[] values() {
        return (ConcertBizIdType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ConcertBizIdType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
