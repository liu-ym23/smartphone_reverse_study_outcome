package com.bytedance.android.livesdk.ktvapi.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/KtvRoomStatus;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "UNKNOWN", "WAITING", "PLAYING", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum KtvRoomStatus extends Enum<KtvRoomStatus> {
    public static final KtvRoomStatus PLAYING = null;
    public static final KtvRoomStatus UNKNOWN = null;
    public static final KtvRoomStatus WAITING = null;
    public static final /* synthetic */ KtvRoomStatus[] a = null;
    private final int value;

    static {
        KtvRoomStatus r1 = new KtvRoomStatus("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        KtvRoomStatus r2 = new KtvRoomStatus("WAITING", 1, 1);
        WAITING = r2;
        KtvRoomStatus r3 = new KtvRoomStatus("PLAYING", 2, 2);
        PLAYING = r3;
        a = new KtvRoomStatus[]{r1, r2, r3};
    }

    public static KtvRoomStatus valueOf(String r1) {
        return (KtvRoomStatus) a.a(KtvRoomStatus.class, r1);
    }

    public static KtvRoomStatus[] values() {
        return (KtvRoomStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public KtvRoomStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
