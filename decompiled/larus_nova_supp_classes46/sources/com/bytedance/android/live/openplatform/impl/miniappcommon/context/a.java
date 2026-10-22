package com.bytedance.android.live.openplatform.impl.miniappcommon.context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[OnMiniAppLifecycleChangeListener.MiniAppLifecycle.values().length];
        a = r0;
        r0[OnMiniAppLifecycleChangeListener.MiniAppLifecycle.OnCreate.ordinal()] = 1;
        r0[OnMiniAppLifecycleChangeListener.MiniAppLifecycle.OnResume.ordinal()] = 2;
        r0[OnMiniAppLifecycleChangeListener.MiniAppLifecycle.OnStop.ordinal()] = 3;
        r0[OnMiniAppLifecycleChangeListener.MiniAppLifecycle.OnDestroy.ordinal()] = 4;
        int[] r1 = new int[MiniAppContext.StopType.values().length];
        b = r1;
        r1[MiniAppContext.StopType.ON_APP_EXIT.ordinal()] = 1;
        r1[MiniAppContext.StopType.ON_MINI_APP_STOP.ordinal()] = 2;
    }
}
