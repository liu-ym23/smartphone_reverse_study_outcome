package com.bytedance.android.live.broadcastgame.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/bytedance/android/live/broadcastgame/api/IGameManagerService$OpenPlatformAppState", "", "Lcom/bytedance/android/live/broadcastgame/api/IGameManagerService$OpenPlatformAppState;", "OpenPlatformAppStateUnusable", "OpenPlatformAppStateReady", "OpenPlatformAppStateInitializing", "OpenPlatformAppStateRunning", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IGameManagerService$OpenPlatformAppState extends Enum<IGameManagerService$OpenPlatformAppState> {
    public static final IGameManagerService$OpenPlatformAppState OpenPlatformAppStateInitializing = null;
    public static final IGameManagerService$OpenPlatformAppState OpenPlatformAppStateReady = null;
    public static final IGameManagerService$OpenPlatformAppState OpenPlatformAppStateRunning = null;
    public static final IGameManagerService$OpenPlatformAppState OpenPlatformAppStateUnusable = null;
    public static final /* synthetic */ IGameManagerService$OpenPlatformAppState[] a = null;

    static {
        IGameManagerService$OpenPlatformAppState r1 = new IGameManagerService$OpenPlatformAppState("OpenPlatformAppStateUnusable", 0);
        OpenPlatformAppStateUnusable = r1;
        IGameManagerService$OpenPlatformAppState r2 = new IGameManagerService$OpenPlatformAppState("OpenPlatformAppStateReady", 1);
        OpenPlatformAppStateReady = r2;
        IGameManagerService$OpenPlatformAppState r3 = new IGameManagerService$OpenPlatformAppState("OpenPlatformAppStateInitializing", 2);
        OpenPlatformAppStateInitializing = r3;
        IGameManagerService$OpenPlatformAppState r4 = new IGameManagerService$OpenPlatformAppState("OpenPlatformAppStateRunning", 3);
        OpenPlatformAppStateRunning = r4;
        a = new IGameManagerService$OpenPlatformAppState[]{r1, r2, r3, r4};
    }

    public static IGameManagerService$OpenPlatformAppState valueOf(String r1) {
        return (IGameManagerService$OpenPlatformAppState) r27.a.a(IGameManagerService$OpenPlatformAppState.class, r1);
    }

    public static IGameManagerService$OpenPlatformAppState[] values() {
        return (IGameManagerService$OpenPlatformAppState[]) a.clone();
    }

    public IGameManagerService$OpenPlatformAppState(String r1, int r2) {
        super(r1, r2);
    }
}
