package com.bytedance.android.live.messagewindow.framework.ability;

import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ICardLifecycle.State.values().length];
        a = r0;
        r0[ICardLifecycle.State.Initialized.ordinal()] = 1;
        r0[ICardLifecycle.State.Destroyed.ordinal()] = 2;
        r0[ICardLifecycle.State.Created.ordinal()] = 3;
        r0[ICardLifecycle.State.Stored.ordinal()] = 4;
        r0[ICardLifecycle.State.Started.ordinal()] = 5;
        r0[ICardLifecycle.State.Showed.ordinal()] = 6;
        r0[ICardLifecycle.State.Hidden.ordinal()] = 7;
    }
}
