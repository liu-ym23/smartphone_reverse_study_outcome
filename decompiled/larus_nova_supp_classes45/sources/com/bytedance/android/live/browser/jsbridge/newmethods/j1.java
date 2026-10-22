package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j1<T> implements Consumer {
    public final /* synthetic */ l1 a;

    public j1(l1 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        l1 r0 = this.a;
        r0.k((ICalendarManager.ErrorCode) r3, null);
    }
}
