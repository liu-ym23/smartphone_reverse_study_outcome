package com.obric.matrix.platform.sdk.ones.account;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile AtomicBoolean f11894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CountDownLatch f11895b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f11896c = null;
    public static final g d = null;
    public static final Lazy e = null;

    static {
        f11894a = new AtomicBoolean(false);
        f11895b = new CountDownLatch(1);
        f11896c = new Handler(Looper.getMainLooper());
        d = new g();
        e = LazyKt.lazy(OAccount$defaultErrorMsg$2.INSTANCE);
    }
}
