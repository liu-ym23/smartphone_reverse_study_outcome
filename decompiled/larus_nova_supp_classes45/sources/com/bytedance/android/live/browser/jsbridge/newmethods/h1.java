package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h1<T> implements Consumer {
    public final /* synthetic */ l1 a;
    public final /* synthetic */ Gson b;

    public h1(l1 r1, Gson r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Pair r5 = (Pair) r4;
        this.a.k((ICalendarManager.ErrorCode) r5.getFirst(), GsonProtectorUtils.toJsonTree(this.b, r5.getSecond()));
    }
}
