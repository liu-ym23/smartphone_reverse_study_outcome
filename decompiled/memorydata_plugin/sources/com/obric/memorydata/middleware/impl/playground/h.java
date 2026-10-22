package com.obric.memorydata.middleware.impl.playground;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/QuestionIdGenerator;", "", "<init>", "()V", "nextId", "Ljava/util/concurrent/atomic/AtomicLong;", "next", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f11824a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicLong f11825b = null;

    static {
        f11824a = new h();
        f11825b = new AtomicLong(SystemClock.uptimeMillis());
    }

    private h() {
    }

    public final long a() {
        return f11825b.incrementAndGet();
    }
}
