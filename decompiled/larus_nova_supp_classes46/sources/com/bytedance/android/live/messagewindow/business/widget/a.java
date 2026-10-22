package com.bytedance.android.live.messagewindow.business.widget;

import com.bytedance.android.live.room.api.messagewindow.state.CardAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[CardAction.values().length];
        a = r0;
        r0[CardAction.REFRESH.ordinal()] = 1;
        r0[CardAction.HIDE.ordinal()] = 2;
        r0[CardAction.DESTROY.ordinal()] = 3;
        r0[CardAction.DESTROY_WITHOUT_DESTROY.ordinal()] = 4;
    }
}
