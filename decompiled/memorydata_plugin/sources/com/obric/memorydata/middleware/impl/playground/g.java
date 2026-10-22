package com.obric.memorydata.middleware.impl.playground;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0015J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0015J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001e\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/PendingRequest;", "", "messageId", "", "questionId", "initialMode", "Lcom/obric/memorydata/middleware/impl/playground/AppIntentResultMode;", "<init>", "(JJLcom/obric/memorydata/middleware/impl/playground/AppIntentResultMode;)V", "getMessageId", "()J", "getQuestionId", "latch", "Ljava/util/concurrent/CountDownLatch;", "completed", "Ljava/util/concurrent/atomic/AtomicBoolean;", EventBody.KEY_VALUE, "resultMode", "getResultMode", "()Lcom/obric/memorydata/middleware/impl/playground/AppIntentResultMode;", "result", "Lcom/obric/memorydata/middleware/impl/playground/DispatchIntentResult;", "asyncFinal", "Ljava/util/concurrent/atomic/AtomicReference;", "switchToAsync", "", "cacheAsyncFinal", "cachedAsyncFinal", "complete", "await", "timeoutMillis", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f11822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11823b;
    private final CountDownLatch c;
    private final AtomicBoolean d;
    private volatile AppIntentResultMode e;
    private volatile b f;
    private final AtomicReference<b> g;

    public g(long r2, long r4, AppIntentResultMode r6) {
        Intrinsics.checkNotNullParameter(r6, "initialMode");
        this.f11822a = r2;
        this.f11823b = r4;
        this.c = new CountDownLatch(1);
        this.d = new AtomicBoolean(false);
        this.e = r6;
        this.g = new AtomicReference();
    }

    public final long a() {
        return this.f11823b;
    }

    public final b a(long r3) {
        if (r3 > 0) goto L7;
        this.c.await();
        return this.f;
    L7:
        if (this.c.await(r3, TimeUnit.MILLISECONDS) == true) goto L11;
        return null;
    L11:
        return this.f;
    }

    public final void a(b r2) {
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
        this.g.set(r2);
        if (this.e != AppIntentResultMode.ASYNC_APP_INTENT) goto L8;
        b r3 = d();
        if (r3 == null) goto L9;
        b(r3);
        return;
    L9:
        return;
    }

    public final AppIntentResultMode b() {
        return this.e;
    }

    public final void b(b r26) {
        Intrinsics.checkNotNullParameter(r26, EventBody.KEY_VALUE);
        if (this.d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.f = b.a(r26, 0, 0, null, null, null, null, 0, 0, null, null, false, null, null, 0, null, false, this.e, 65535, null);
        this.c.countDown();
    }

    public final void c() {
        this.e = AppIntentResultMode.ASYNC_APP_INTENT;
        b r0 = d();
        if (r0 == null) goto L6;
        b(r0);
        return;
    }

    public final b d() {
        return (b) ZeusTransformUtils.preCheckCast(this.g.getAndSet(null), b.class, "com.obric.memorydata.plugin");
    }
}
