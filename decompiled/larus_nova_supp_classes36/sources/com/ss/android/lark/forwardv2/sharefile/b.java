package com.ss.android.lark.forwardv2.sharefile;

import com.ss.android.lark.forwardv2.e;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import hib.d;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b<T> implements RxScheduledExecutor.Consumer {
    public static final b<T> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void consume(Object r3) {
        File r4 = (File) r3;
        Log.i("FileShareEnhancedView", "click open local preview file");
        d r0 = e.a;
        com.ss.android.lark.forwardv2.a r1 = e.a.a().g();
        Intrinsics.checkNotNull(r4);
        r1.a(r4);
    }
}
