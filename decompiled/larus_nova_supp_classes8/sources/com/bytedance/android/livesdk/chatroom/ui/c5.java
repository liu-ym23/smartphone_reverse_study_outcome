package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c5<T> implements Consumer {
    public final /* synthetic */ g5 a;

    public c5(g5 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Boolean r4 = (Boolean) r3;
        if (vm2.h.Q() == false) goto L13;
        g5 r0 = this.a;
        if (r0 == null) goto L7;
        DataCenter r1 = ((AbsInteractionFragment) r0).W;
    L8:
        if (r1 == null) goto L14;
        LayerEventDispatcher r2 = o70.c.a(Integer.valueOf(r1.hashCode()));
        if (r2 == null) goto L15;
        Intrinsics.checkNotNull(r4);
        r2.b(new zg1.u0(r4.booleanValue()));
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r1 = null;
        goto L8
    }
}
