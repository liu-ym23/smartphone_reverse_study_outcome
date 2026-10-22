package com.bytedance.android.live.openplatform.impl.minigamecommon.context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[OnMiniGameLifecycleChangeListener.MiniGameLifecycle.values().length];
        a = r0;
        r0[OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnCreate.ordinal()] = 1;
        r0[OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnResume.ordinal()] = 2;
        r0[OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnStop.ordinal()] = 3;
        r0[OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnExit.ordinal()] = 4;
        r0[OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnDestroy.ordinal()] = 5;
        int[] r1 = new int[MiniGameContext.StopType.values().length];
        b = r1;
        r1[MiniGameContext.StopType.ON_GAME_EXIT.ordinal()] = 1;
        r1[MiniGameContext.StopType.ON_MINI_GAME_STOP.ordinal()] = 2;
    }
}
