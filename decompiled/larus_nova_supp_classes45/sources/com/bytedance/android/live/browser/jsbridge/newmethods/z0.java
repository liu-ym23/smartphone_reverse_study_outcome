package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z0<V> implements Callable {
    public final /* synthetic */ l1 a;
    public final /* synthetic */ String b;

    public z0(l1 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.util.concurrent.Callable
    public final Pair<ICalendarManager.ErrorCode, ICalendarManager.EventRecord> call() {
        ICalendarManager r0 = this.a.b;
        Intrinsics.checkNotNull(r0);
        return r0.get(this.b);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
