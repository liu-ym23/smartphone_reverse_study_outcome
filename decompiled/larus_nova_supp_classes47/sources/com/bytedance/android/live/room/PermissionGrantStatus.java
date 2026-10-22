package com.bytedance.android.live.room;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/room/PermissionGrantStatus;", "", "", "value", "I", "getValue", "()I", "GRANT_DONE", "GRANT_DOING", "GRANT_SUCCESS", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PermissionGrantStatus extends Enum<PermissionGrantStatus> {
    public static final PermissionGrantStatus GRANT_DOING = null;
    public static final PermissionGrantStatus GRANT_DONE = null;
    public static final PermissionGrantStatus GRANT_SUCCESS = null;
    public static final /* synthetic */ PermissionGrantStatus[] a = null;
    private final int value;

    static {
        PermissionGrantStatus r1 = new PermissionGrantStatus("GRANT_DONE", 0, 0);
        GRANT_DONE = r1;
        PermissionGrantStatus r2 = new PermissionGrantStatus("GRANT_DOING", 1, 1);
        GRANT_DOING = r2;
        PermissionGrantStatus r3 = new PermissionGrantStatus("GRANT_SUCCESS", 2, 2);
        GRANT_SUCCESS = r3;
        a = new PermissionGrantStatus[]{r1, r2, r3};
    }

    public static PermissionGrantStatus valueOf(String r1) {
        return (PermissionGrantStatus) r27.a.a(PermissionGrantStatus.class, r1);
    }

    public static PermissionGrantStatus[] values() {
        return (PermissionGrantStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PermissionGrantStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
