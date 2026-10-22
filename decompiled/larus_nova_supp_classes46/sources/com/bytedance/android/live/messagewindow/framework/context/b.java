package com.bytedance.android.live.messagewindow.framework.context;

import com.bytedance.android.live.room.api.messagewindow.anim.CardAnimState;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[ICardLifecycle.State.values().length];
        a = r0;
        r0[ICardLifecycle.State.Created.ordinal()] = 1;
        r0[ICardLifecycle.State.Stored.ordinal()] = 2;
        r0[ICardLifecycle.State.Started.ordinal()] = 3;
        r0[ICardLifecycle.State.Showed.ordinal()] = 4;
        r0[ICardLifecycle.State.Hidden.ordinal()] = 5;
        r0[ICardLifecycle.State.Destroyed.ordinal()] = 6;
        int[] r1 = new int[CardAnimState.State.values().length];
        b = r1;
        r1[CardAnimState.State.START.ordinal()] = 1;
        r1[CardAnimState.State.END.ordinal()] = 2;
    }
}
