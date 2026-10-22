package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w0<V> implements Callable {
    public final /* synthetic */ l1 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public w0(l1 r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.util.concurrent.Callable
    public final ICalendarManager.ErrorCode call() {
        ICalendarManager r0 = this.a.b;
        Intrinsics.checkNotNull(r0);
        return r0.remove(this.b, this.c);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
