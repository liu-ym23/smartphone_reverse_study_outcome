package com.bytedance.android.live.core.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/core/utils/AnimationStatus;", "", "", "status", "I", "getStatus", "()I", "IDLE", "START", "ANIMATION", "FAIL", "END", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnimationStatus extends Enum<AnimationStatus> {
    public static final AnimationStatus ANIMATION = null;
    public static final AnimationStatus END = null;
    public static final AnimationStatus FAIL = null;
    public static final AnimationStatus IDLE = null;
    public static final AnimationStatus START = null;
    public static final /* synthetic */ AnimationStatus[] a = null;
    private final int status;

    static {
        AnimationStatus r1 = new AnimationStatus("IDLE", 0, 0);
        IDLE = r1;
        AnimationStatus r2 = new AnimationStatus("START", 1, 1);
        START = r2;
        AnimationStatus r3 = new AnimationStatus("ANIMATION", 2, 2);
        ANIMATION = r3;
        AnimationStatus r4 = new AnimationStatus("FAIL", 3, 3);
        FAIL = r4;
        AnimationStatus r5 = new AnimationStatus("END", 4, 4);
        END = r5;
        a = new AnimationStatus[]{r1, r2, r3, r4, r5};
    }

    public static AnimationStatus valueOf(String r1) {
        return (AnimationStatus) r27.a.a(AnimationStatus.class, r1);
    }

    public static AnimationStatus[] values() {
        return (AnimationStatus[]) a.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public AnimationStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.status = r3;
    }
}
