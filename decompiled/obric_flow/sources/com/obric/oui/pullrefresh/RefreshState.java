package com.obric.oui.pullrefresh;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/pullrefresh/RefreshState;", "", "IDLE", "PULL_TO_REFRESH", "RELEASE_TO_REFRESH", "REFRESHING", "FINISH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum RefreshState extends Enum<RefreshState> {
    public static final RefreshState FINISH = null;
    public static final RefreshState IDLE = null;
    public static final RefreshState PULL_TO_REFRESH = null;
    public static final RefreshState REFRESHING = null;
    public static final RefreshState RELEASE_TO_REFRESH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RefreshState[] f14244a = null;

    static {
        RefreshState r5 = new RefreshState("IDLE", 0);
        IDLE = r5;
        RefreshState r10 = new RefreshState("PULL_TO_REFRESH", 1);
        PULL_TO_REFRESH = r10;
        RefreshState r11 = new RefreshState("RELEASE_TO_REFRESH", 2);
        RELEASE_TO_REFRESH = r11;
        RefreshState r12 = new RefreshState("REFRESHING", 3);
        REFRESHING = r12;
        RefreshState r13 = new RefreshState("FINISH", 4);
        FINISH = r13;
        f14244a = new RefreshState[]{r5, r10, r11, r12, r13};
    }

    public static RefreshState valueOf(String r5) {
        return (RefreshState) Enum.valueOf(RefreshState.class, r5);
    }

    public static RefreshState[] values() {
        return (RefreshState[]) f14244a.clone();
    }
}
