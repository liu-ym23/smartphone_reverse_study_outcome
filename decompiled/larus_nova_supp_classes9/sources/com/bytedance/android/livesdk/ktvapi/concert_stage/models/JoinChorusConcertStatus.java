package com.bytedance.android.livesdk.ktvapi.concert_stage.models;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/concert_stage/models/JoinChorusConcertStatus;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "NOT_JOINED", "JOINING", "JOINED", "LEAVING", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum JoinChorusConcertStatus extends Enum<JoinChorusConcertStatus> {
    public static final JoinChorusConcertStatus JOINED = null;
    public static final JoinChorusConcertStatus JOINING = null;
    public static final JoinChorusConcertStatus LEAVING = null;
    public static final JoinChorusConcertStatus NOT_JOINED = null;
    public static final /* synthetic */ JoinChorusConcertStatus[] a = null;
    private final int value;

    static {
        JoinChorusConcertStatus r1 = new JoinChorusConcertStatus("NOT_JOINED", 0, 0);
        NOT_JOINED = r1;
        JoinChorusConcertStatus r2 = new JoinChorusConcertStatus("JOINING", 1, 1);
        JOINING = r2;
        JoinChorusConcertStatus r3 = new JoinChorusConcertStatus("JOINED", 2, 2);
        JOINED = r3;
        JoinChorusConcertStatus r4 = new JoinChorusConcertStatus("LEAVING", 3, 3);
        LEAVING = r4;
        a = new JoinChorusConcertStatus[]{r1, r2, r3, r4};
    }

    public static JoinChorusConcertStatus valueOf(String r1) {
        return (JoinChorusConcertStatus) a.a(JoinChorusConcertStatus.class, r1);
    }

    public static JoinChorusConcertStatus[] values() {
        return (JoinChorusConcertStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public JoinChorusConcertStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
