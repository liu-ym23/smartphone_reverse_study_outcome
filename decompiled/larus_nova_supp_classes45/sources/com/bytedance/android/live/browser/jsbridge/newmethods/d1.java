package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d1<T> implements Consumer {
    public final /* synthetic */ l1 a;

    public d1(l1 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        this.a.k(ICalendarManager.ErrorCode.NoPermission, null);
    }
}
