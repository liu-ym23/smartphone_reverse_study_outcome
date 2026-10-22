package com.bytedance.android.live.broadcastgame.xplay.singlecast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[IXplayGameCastService.IGameCastSession.Event.values().length];
        a = r0;
        r0[IXplayGameCastService.IGameCastSession.Event.CastStarted.ordinal()] = 1;
        r0[IXplayGameCastService.IGameCastSession.Event.CastStopped.ordinal()] = 2;
        r0[IXplayGameCastService.IGameCastSession.Event.CastMinimized.ordinal()] = 3;
        r0[IXplayGameCastService.IGameCastSession.Event.CastResumed.ordinal()] = 4;
        r0[IXplayGameCastService.IGameCastSession.Event.ResumeCastClicked.ordinal()] = 5;
    }
}
