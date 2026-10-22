package io.reactivex.internal.functions;

import com.bytedance.sdk.xbridge.cn.auth.g;
import java.util.Comparator;
import java.util.concurrent.Callable;
import wc.f;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.ies.bullet.service.base.c f17617a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.android.anniex.worker.a f17618b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f17619c = null;
    public static final f d = null;
    public static final g e = null;
    public static final com.lynx.tasm.behavior.d f = null;
    public static final com.bytedance.frameworks.baselib.network.http.cronet.b g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f17620h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ca.d f17621i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final com.lynx.tasm.utils.c f17622j = null;

    static {
        f17617a = new com.bytedance.ies.bullet.service.base.c(11);
        f17618b = new com.bytedance.android.anniex.worker.a(22);
        f17619c = new b();
        d = new f(10);
        e = new g(11);
        f = new com.lynx.tasm.behavior.d(11);
        g = new com.bytedance.frameworks.baselib.network.http.cronet.b(11);
        f17620h = new d(0);
        f17621i = new ca.d(21);
        f17622j = new com.lynx.tasm.utils.c(11);
    }

    public static Callable a() {
        return Functions$HashSetCallable.INSTANCE;
    }

    public static boolean b(Object r5, Object r10) {
        if (r5 == r10) goto L8;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.equals(r10) == false) goto L7;
    L8:
        return true;
    }

    public static Comparator c() {
        return Functions$NaturalComparator.INSTANCE;
    }

    public static void d(Object r5, String r10) {
        if (r5 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r10);
    }

    public static void e(int r5, String r10) {
        if (r5 <= 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r10 + " > 0 required but it was " + r5);
    }

    public static void f(long r5, String r10) {
        if (r5 <= 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(r10 + " > 0 required but it was " + r5);
    }
}
