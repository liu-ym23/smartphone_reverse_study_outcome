package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveDrawerOperationType;", "", "", "value", "I", "getValue", "()I", "BANNER", "SINGLE_LIVE", "POLY_LIVE", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveDrawerOperationType extends Enum<LiveDrawerOperationType> {
    public static final LiveDrawerOperationType BANNER = null;
    public static final LiveDrawerOperationType POLY_LIVE = null;
    public static final LiveDrawerOperationType SINGLE_LIVE = null;
    public static final /* synthetic */ LiveDrawerOperationType[] a = null;
    private final int value;

    static {
        LiveDrawerOperationType r2 = new LiveDrawerOperationType("BANNER", 0, 1);
        BANNER = r2;
        LiveDrawerOperationType r3 = new LiveDrawerOperationType("SINGLE_LIVE", 1, 2);
        SINGLE_LIVE = r3;
        LiveDrawerOperationType r4 = new LiveDrawerOperationType("POLY_LIVE", 2, 3);
        POLY_LIVE = r4;
        a = new LiveDrawerOperationType[]{r2, r3, r4};
    }

    public static LiveDrawerOperationType valueOf(String r1) {
        return (LiveDrawerOperationType) r27.a.a(LiveDrawerOperationType.class, r1);
    }

    public static LiveDrawerOperationType[] values() {
        return (LiveDrawerOperationType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveDrawerOperationType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
