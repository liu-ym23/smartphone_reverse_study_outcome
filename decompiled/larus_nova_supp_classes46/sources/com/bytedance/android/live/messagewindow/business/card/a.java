package com.bytedance.android.live.messagewindow.business.card;

import com.bytedance.android.live.messagewindow.business.presenter.JsEventType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[JsEventType.values().length];
        a = r0;
        r0[JsEventType.CLOSE_CARD.ordinal()] = 1;
        r0[JsEventType.HIDE_CARD.ordinal()] = 2;
        r0[JsEventType.SHOW_CARD.ordinal()] = 3;
    }
}
