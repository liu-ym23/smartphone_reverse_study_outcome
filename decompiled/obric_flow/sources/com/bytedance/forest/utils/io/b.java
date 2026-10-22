package com.bytedance.forest.utils.io;

import ai.j0;
import android.os.AsyncTask;
import com.bytedance.forest.model.ForestBuffer;
import com.bytedance.forest.model.q;
import com.bytedance.forest.model.w;
import com.bytedance.forest.utils.g;
import com.bytedance.forest.utils.p;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public class b extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile InputStream f4634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile a f4635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f4636c;
    public final AtomicBoolean d;
    public volatile Throwable e;
    public final al.a f;
    public com.bytedance.forest.utils.e g;

    public b(com.bytedance.forest.model.a r5, com.bytedance.forest.utils.e r10) {
        super(r5);
        this.f4636c = new AtomicInteger(0);
        this.d = new AtomicBoolean(false);
        com.bytedance.forest.utils.d r11 = r10.g;
        al.a r12 = new al.a();
        r12.f314b = r11;
        this.f = r12;
        this.g = r10;
    }

    public static final void b(b r11) {
        a r5 = r11.f4635b;
        if (r5 == null) goto L5;
        r5.b();
    L5:
        com.bytedance.forest.utils.d.b(r11.g.g, 3, "Concurrent", j0.q(new StringBuilder("ForestConcurrentBuffer@"), super.toString(), " load finished"), false, null, null, 56);
        al.a r10 = r11.f;
        r10.getClass();
        monitor-enter(r10);
        com.bytedance.forest.utils.d.b((com.bytedance.forest.utils.d) r10.f314b, 3, "Concurrent", "#loadFinished, force set reference to:(" + r10.f313a + " -> 0), stack=" + Arrays.toString(Thread.currentThread().getStackTrace()), false, null, null, 56);     // Catch: Throwable -> L11
        r10.f313a = 0;     // Catch: Throwable -> L11
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r10);
        r11.clear(true);
        r11.onFulFilled();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void clear(boolean r10) {
        InputStream r5 = this.f4634a;     // Catch: Throwable -> L7
        if (r5 == null) goto L9;
        r5.close();     // Catch: Throwable -> L7
    L9:
        this.f4634a = null;
        if (isCacheReady$forest_release() == true) goto L23;
        com.bytedance.forest.utils.d.b(this.g.g, 5, "Concurrent", "clear meta cause not ready", true, null, null, 48);
        a r11 = this.f4635b;
        if (r11 == null) goto L24;
        r11.close();
        return;
    L24:
        return;
    L23:
        return;
    L7:
        th = move-exception;
        if (r10 == true) goto L9;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.f4634a = null;
        throw th;
    }

    public final void close(boolean r10) {
        if (isCacheReady$forest_release() == false) goto L6;
        return;
    L6:
        if (this.f.b("close") > 0) goto L25;
        al.a r5 = this.f;
        monitor-enter(r5);
        int r11 = r5.f313a;     // Catch: Throwable -> L22
        monitor-exit(r5);
        if (r11 >= 0) goto L20;
        com.bytedance.forest.utils.d r12 = this.g.g;
        StringBuilder r13 = new StringBuilder("unexpected reference count:");
        al.a r14 = this.f;
        monitor-enter(r14);
        int r15 = r14.f313a;     // Catch: Throwable -> L17
        monitor-exit(r14);
        r13.append(r15);
        com.bytedance.forest.utils.d.b(r12, 5, "Concurrent", r13.toString(), false, null, null, 56);
    L17:
        th = move-exception;
        throw th;
    L20:
        clear(r10);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public final void d() {
        if (isCacheReady$forest_release() == false) goto L5;
        return;
    L5:
        al.a r11 = this.f;
        r11.getClass();
        monitor-enter(r11);
        int r5 = r11.f313a + 1;     // Catch: Throwable -> L10
        r11.f313a = r5;     // Catch: Throwable -> L10
        com.bytedance.forest.utils.d.b((com.bytedance.forest.utils.d) r11.f314b, 3, "Concurrent", "#provideInputStream, increment reference to:" + r5 + ", stack=" + Arrays.toString(Thread.currentThread().getStackTrace()), false, null, null, 56);     // Catch: Throwable -> L10
        monitor-exit(r11);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.forest.model.q
    public final int getBytesAtRange$forest_release(int r10, byte[] r11, int r12, int r13, w r14) {
        if (isCacheClear$forest_release() == false) goto L6;
        return -1;
    L6:
        tryLoadToMemory$forest_release(r14);
        com.bytedance.forest.utils.d.b(this.g.g, 3, "Concurrent", "getBytesAtRange, meta=" + this.f4635b, false, null, null, 56);
        a r15 = this.f4635b;
        if (r15 != null) goto L9;
        return 0;
    L9:
        return r15.a(r10, r11, r12, r13);
    }

    @Override // com.bytedance.forest.model.p
    public final com.bytedance.forest.utils.e getContext$forest_release() {
        return this.g;
    }

    @Override // com.bytedance.forest.model.q
    public final boolean initCache$forest_release(Integer r10) {
        if (isCacheProvided$forest_release() == false) goto L49;
        return true;
    L49:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L15
        if (isCacheClear$forest_release() == true) goto L27;
        if (this.f4634a != null) goto L25;
        InputStream r11 = getBytesProvider().a();     // Catch: Throwable -> L15
        if (r11 == null) goto L23;
        this.f4634a = r11;     // Catch: Throwable -> L15
        if (r10 == null) goto L17;
        int r12 = r10.intValue();     // Catch: Throwable -> L15
    L21:
        this.f4635b = new a(r12, this.g.g, this.f4636c);     // Catch: Throwable -> L15
        Object r13 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L29:
        Throwable r14 = Result.m127exceptionOrNullimpl(r13);
        if (r14 == null) goto L46;
        a r15 = this.f4635b;
        if (r15 == null) goto L47;
        r15.close();
    L47:
        InputStream r16 = this.f4634a;     // Catch: Throwable -> L38
        if (r16 == null) goto L40;
        r16.close();     // Catch: Throwable -> L38
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L38
    L41:
        Result.m124constructorimpl(r17);     // Catch: Throwable -> L38
    L44:
        this.f4634a = null;
        com.bytedance.forest.utils.d.b(this.g.g, 6, ForestBuffer.TAG, androidx.room.jarjarred.org.antlr.runtime.a.x(r14, new StringBuilder("initCacheBuffer failed cause by ")), true, r14, null, 32);
        goto L46
    L40:
        r17 = null;
    L38:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L46:
        return Result.m131isSuccessimpl(r13);
    L17:
        InputStream r19 = this.f4634a;     // Catch: Throwable -> L15
        if (r19 != null) goto L20;
        Intrinsics.throwNpe();     // Catch: Throwable -> L15
    L20:
        r12 = RangesKt.coerceAtLeast(r19.available(), 4096);     // Catch: Throwable -> L15
        goto L21
    L23:
        throw new IllegalStateException("InputStream from " + getBytesProvider() + " is NULL");     // Catch: Throwable -> L15
    L25:
        throw new IllegalStateException("originInputStream except NULL but receive " + this.f4634a);     // Catch: Throwable -> L15
    L27:
        throw new IllegalStateException("current buffer can use cause cleared");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L29
    }

    @Override // com.bytedance.forest.model.p
    public final boolean isCacheClear$forest_release() {
        a r5 = this.f4635b;
        if (r5 == null) goto L9;
        AtomicBoolean r10 = r5.f4632b;
        if (r10 != null) goto L7;
        return false;
    L7:
        if (r10.get() != true) goto L12;
        return true;
    L12:
        return false;
    L9:
        return false;
    }

    @Override // com.bytedance.forest.model.p
    public final boolean isCacheProvided$forest_release() {
        a r5 = this.f4635b;
        if (r5 == null) goto L10;
        AtomicBoolean r10 = r5.f4632b;
        if (r10 != null) goto L7;
        return false;
    L7:
        if (r10.get() == true) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    @Override // com.bytedance.forest.model.p
    public final boolean isCacheReady$forest_release() {
        a r5 = this.f4635b;
        if (r5 == null) goto L15;
        AtomicBoolean r10 = r5.f4631a;
        if (r10 != null) goto L7;
        return false;
    L7:
        if (r10.get() != true) goto L18;
        a r11 = this.f4635b;
        if (r11 == null) goto L19;
        AtomicBoolean r12 = r11.f4632b;
        if (r12 != null) goto L13;
        return false;
    L13:
        if (r12.get() == true) goto L21;
        return true;
    L21:
        return false;
    L19:
        return false;
    L18:
        return false;
    L15:
        return false;
    }

    @Override // com.bytedance.forest.model.p
    public final byte[] provideBytes() {
        if (isCacheReady$forest_release() == false) goto L9;
        a r10 = this.f4635b;
        if (r10 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        return r10.d();
    L9:
        com.bytedance.forest.utils.d.b(this.g.g, 3, "Concurrent", "wait for meta fulfill finish by #provideBytes", false, null, null, 56);
        a r5 = this.f4635b;
        if (r5 == null) goto L12;
        r5.f4633c.await();
    L12:
        com.bytedance.forest.utils.d.b(this.g.g, 3, "Concurrent", "meta fulfill finished by #provideBytes", false, null, null, 56);
        Throwable r11 = this.e;
        if (r11 != null) goto L20;
        a r12 = this.f4635b;
        if (r12 != null) goto L17;
        return null;
    L17:
        return r12.d();
    L20:
        throw r11;
    }

    @Override // com.bytedance.forest.model.p
    public InputStream provideInputStream(w r10) {
        d();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        tryLoadToMemory$forest_release(r10);     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl(new c(this, r10));     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.m127exceptionOrNullimpl(r11);
        if (r12 == null) goto L11;
        com.bytedance.forest.utils.d.b(this.g.g, 6, "Concurrent", androidx.room.jarjarred.org.antlr.runtime.a.x(r12, new StringBuilder("provideInputStream failed, cause by ")), true, r12, null, 32);
        this.f.b("provideInputStream");
    L11:
        if (Result.m130isFailureimpl(r11) == false) goto L14;
        r11 = null;
    L14:
        return (InputStream) r11;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.forest.model.p
    public final void setContext$forest_release(com.bytedance.forest.utils.e r5) {
        a r10 = this.f4635b;
        if (r10 == null) goto L5;
        r10.e = r5.g;
    L5:
        al.a r11 = this.f;
        com.bytedance.forest.utils.d r12 = r5.g;
        r11.getClass();
        r11.f314b = r12;
        this.g = r5;
    }

    @Override // com.bytedance.forest.model.p
    public final int size() {
        a r5 = this.f4635b;
        if (r5 == null) goto L5;
        int r10 = r5.e();
    L6:
        com.bytedance.forest.utils.d.b(this.g.g, 3, "Concurrent", com.lynx.jsbridge.a.d(r10, "readable size="), false, null, null, 56);
        return r10;
    L5:
        r10 = 0;
        goto L6
    }

    @Override // com.bytedance.forest.model.p
    public final boolean supportReuse() {
        return true;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ForestConcurrentBuffer@");
        r5.append(super.toString());
        r5.append("(inputStreamProvider=");
        r5.append(getBytesProvider());
        r5.append(", originInputStream=");
        r5.append(this.f4634a);
        r5.append(", meta=");
        r5.append(this.f4635b);
        r5.append(", inFulFilling=");
        r5.append(this.d.get());
        r5.append(", referenceCount=");
        al.a r10 = this.f;
        monitor-enter(r10);
        int r11 = r10.f313a;     // Catch: Throwable -> L8
        monitor-exit(r10);
        return j0.n(r5, r11, ')');
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [T, java.util.concurrent.CountDownLatch] */
    @Override // com.bytedance.forest.model.p
    public final void tryLoadToMemory$forest_release(w r12) {
        if (this.d.compareAndSet(false, true) == true) goto L7;
        com.bytedance.forest.utils.d.b(this.g.g, 4, "Concurrent", "already have a loadToMemory task performed", false, null, null, 56);
        return;
    L7:
        if (isCacheClear$forest_release() == false) goto L9;
    L28:
        com.bytedance.forest.utils.d.b(this.g.g, 4, "Concurrent", "no need to perform loadToMemory task, isCacheClear:" + isCacheClear$forest_release() + ", isCacheReady:" + isCacheReady$forest_release(), false, null, null, 56);
        return;
    L9:
        if (isCacheReady$forest_release() == true) goto L28;
        if (q.initCache$forest_release$default(this, null, 1, null) == false) goto L26;
        final InputStream r5 = this.f4634a;
        if (r5 == null) goto L24;
        com.bytedance.forest.utils.d.b(this.g.g, 4, "Concurrent", "start to perform loadToMemory task", false, null, null, 56);
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        r13.element = null;
        if (this.g.f4620b == true) goto L18;
    L20:
        g r10 = com.bytedance.forest.utils.q.f4656a;
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new p(new ForestConcurrentBuffer$tryLoadToMemory$1(this, r5, r13)));
        CountDownLatch r11 = (CountDownLatch) r13.element;
        if (r11 == null) goto L30;
        r11.await();
        return;
    L30:
        return;
    L18:
        if (com.bytedance.forest.utils.q.b() == true) goto L20;
        com.bytedance.forest.utils.d.b(this.g.g, 4, "Concurrent", "need firstReadLock", true, null, null, 48);
        r13.element = new CountDownLatch(1);
        goto L20
    L24:
        com.bytedance.forest.utils.d.b(this.g.g, 6, ForestBuffer.TAG, "response: " + r12.f4442r + ", " + r12.A + ", " + r12.f4443t + ", meta:" + this.f4635b, true, new IOException("origin input stream is null"), null, 32);
        throw new IOException("origin input stream is null");
    L26:
        com.bytedance.forest.utils.d.b(this.g.g, 6, "Concurrent", "init cache buffer failed when load to memory", true, null, null, 48);
        throw new IOException("init cache buffer failed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        close(false);
    }
}
