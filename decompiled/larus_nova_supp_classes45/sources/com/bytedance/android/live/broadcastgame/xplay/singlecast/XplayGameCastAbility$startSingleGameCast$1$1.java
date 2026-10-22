package com.bytedance.android.live.broadcastgame.xplay.singlecast;

import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/broadcastgame/xplay/singlecast/IXplayGameCastService$IGameCastSession$Event;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class XplayGameCastAbility$startSingleGameCast$1$1 extends FunctionReferenceImpl implements Function1<IXplayGameCastService.IGameCastSession.Event, Unit> {
    public XplayGameCastAbility$startSingleGameCast$1$1(XplayGameCastAbility r8) {
        super(1, r8, XplayGameCastAbility.class, "onCastingStateChanged", "onCastingStateChanged(Lcom/bytedance/android/live/broadcastgame/xplay/singlecast/IXplayGameCastService$IGameCastSession$Event;)V", 0);
    }

    public final void invoke(IXplayGameCastService.IGameCastSession.Event r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        XplayGameCastAbility r0 = (XplayGameCastAbility) ((CallableReference) this).receiver;
        int r1 = XplayGameCastAbility.j;
        r0.getClass();
        int r2 = XplayLog.a;
        XplayLog.c("XplayGameCastAbility", "casting state changed: " + r4);
        if (a.a[r4.ordinal()] != 2) goto L10;
        XplayLog.c("XplayGameCastAbility", "IGameCastAbility.stopSingleGameCast requested, currentSession=" + r0.b);
        IXplayGameCastService.IGameCastSession r5 = r0.b;
        if (r5 == null) goto L11;
        r0.b = null;
        XplayGameCastAbility.c(false, null);
        r5.stop();
        return;
    L11:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((IXplayGameCastService.IGameCastSession.Event) r1);
        return Unit.INSTANCE;
    }
}
