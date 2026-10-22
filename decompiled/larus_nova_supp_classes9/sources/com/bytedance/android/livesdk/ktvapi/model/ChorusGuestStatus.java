package com.bytedance.android.livesdk.ktvapi.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/ChorusGuestStatus;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "STATUS_UNKNOWN", "STATUS_NORMAL", "STATUS_HOST", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ChorusGuestStatus extends Enum<ChorusGuestStatus> {
    public static final ChorusGuestStatus STATUS_HOST = null;
    public static final ChorusGuestStatus STATUS_NORMAL = null;
    public static final ChorusGuestStatus STATUS_UNKNOWN = null;
    public static final /* synthetic */ ChorusGuestStatus[] a = null;
    private final int value;

    static {
        ChorusGuestStatus r1 = new ChorusGuestStatus("STATUS_UNKNOWN", 0, 0);
        STATUS_UNKNOWN = r1;
        ChorusGuestStatus r2 = new ChorusGuestStatus("STATUS_NORMAL", 1, 1);
        STATUS_NORMAL = r2;
        ChorusGuestStatus r3 = new ChorusGuestStatus("STATUS_HOST", 2, 2);
        STATUS_HOST = r3;
        a = new ChorusGuestStatus[]{r1, r2, r3};
    }

    public static ChorusGuestStatus valueOf(String r1) {
        return (ChorusGuestStatus) a.a(ChorusGuestStatus.class, r1);
    }

    public static ChorusGuestStatus[] values() {
        return (ChorusGuestStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ChorusGuestStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
