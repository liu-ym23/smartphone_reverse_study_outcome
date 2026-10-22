package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u0<T> implements Consumer {
    public final /* synthetic */ DiggWidget a;

    public u0(DiggWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        r71.e r5 = (r71.e) r4;
        if (r5.a.getPosition() == MsgWindowPosition.BOTTOM_RIGHT) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r5.a.j, CardTypeAndPriority.AssembledIntroduceCard.getType()) == false) goto L14;
        ICardLifecycle.State r6 = r5.b;
        if (r6 != ICardLifecycle.State.Showed) goto L11;
        this.a.T.e(cc2.i.c.c, true);
        this.a.getClass();
        ALogger.i("DiggHide", "digg view gone");
        return;
    L11:
        if (r6 != ICardLifecycle.State.Hidden) goto L16;
        this.a.T.e(cc2.i.c.c, false);
        this.a.getClass();
        ALogger.i("DiggHide", "digg view visible");
        return;
    L16:
        return;
    }
}
