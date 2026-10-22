package io.reactivex.disposables;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes6.dex */
public final class c {
    public static b a() {
        return EmptyDisposable.INSTANCE;
    }

    public static b a(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r3, "run is null");
        return new RunnableDisposable(r3);
    }
}
