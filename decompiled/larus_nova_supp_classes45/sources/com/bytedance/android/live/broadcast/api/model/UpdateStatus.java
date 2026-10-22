package com.bytedance.android.live.broadcast.api.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/UpdateStatus;", "", "", "value", "I", "getValue", "()I", "SUCCESS", "PARTIAL_FAILED", "REJECTED", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum UpdateStatus extends Enum<UpdateStatus> {
    public static final UpdateStatus PARTIAL_FAILED = null;
    public static final UpdateStatus REJECTED = null;
    public static final UpdateStatus SUCCESS = null;
    public static final /* synthetic */ UpdateStatus[] a = null;
    private final int value;

    static {
        UpdateStatus r1 = new UpdateStatus("SUCCESS", 0, 0);
        SUCCESS = r1;
        UpdateStatus r2 = new UpdateStatus("PARTIAL_FAILED", 1, 1);
        PARTIAL_FAILED = r2;
        UpdateStatus r3 = new UpdateStatus("REJECTED", 2, 2);
        REJECTED = r3;
        a = new UpdateStatus[]{r1, r2, r3};
    }

    public static UpdateStatus valueOf(String r1) {
        return (UpdateStatus) r27.a.a(UpdateStatus.class, r1);
    }

    public static UpdateStatus[] values() {
        return (UpdateStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public UpdateStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
