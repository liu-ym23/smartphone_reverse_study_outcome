package io.reactivex.internal.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class c {
    public static void a() {
        if (io.reactivex.d.a.a() == true) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(Thread.currentThread(), io.reactivex.internal.schedulers.g.class) == true) goto L10;
        if (io.reactivex.d.a.b() == true) goto L10;
        return;
    L10:
        throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
    }
}
