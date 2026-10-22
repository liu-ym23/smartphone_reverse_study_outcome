package com.bytedance.android.ec.core.address;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final ConcurrentHashMap<String, Disposable> a;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.address.a$a, reason: collision with other inner class name */
    public static final class C0124a {
    }

    static {
    }

    public a() {
        this.a = new ConcurrentHashMap();
    }

    public final void a(String r10, Disposable r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "disposable");
        Intrinsics.checkNotNullParameter(r10, "key");
        Disposable r0 = this.a.remove(r10);
        if (r0 != null) goto L5;
    L7:
        this.a.put(r10, r11);
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }
}
