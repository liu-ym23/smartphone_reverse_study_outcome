package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.os.Handler;
import android.os.Looper;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e {
    public static final e a = null;
    public static boolean b;
    public static final Set<Object> c = null;
    public static final CopyOnWriteArraySet<b> d = null;

    public e() {
    }

    static {
        a = new e();
        new Handler(Looper.getMainLooper());
        new c();
        c = new LinkedHashSet();
        d = new CopyOnWriteArraySet();
        new d();
    }
}
