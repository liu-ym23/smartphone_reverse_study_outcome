package com.obric.memorydata.memory.ui.automemory.memorylist;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0015B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/FeedbackPreviewExportGate;", "", "executor", "Ljava/util/concurrent/ExecutorService;", "<init>", "(Ljava/util/concurrent/ExecutorService;)V", "activeClaim", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/FeedbackPreviewExportGate$Claim;", "run", ExifInterface.GPS_DIRECTION_TRUE, "timeoutMs", "", "block", "Lkotlin/Function0;", "(JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "cancelAndReleaseAfterWorkerStops", "", "claim", "future", "Ljava/util/concurrent/Future;", "Claim", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f10708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<a> f10709b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/FeedbackPreviewExportGate$Claim;", "", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public i(ExecutorService r3) {
        ExecutorService r4 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "executor");
        this.f10708a = r4;
        this.f10709b = new AtomicReference(null);
    }

    public /* synthetic */ i(ExecutorService r2, int r3, DefaultConstructorMarker r4) {
        ExecutorService r5 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = Executors.newSingleThreadExecutor($$Lambda$i$CwLJlIBkIEEcIDAfTxWkygLTmN0.INSTANCE);
    L5:
        this(r5);
    }

    private static final Object a(Function0 r2, i r3, a r4) {
        Object r5 = ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();     // Catch: Throwable -> L6
        r3.f10709b.compareAndSet(r4, null);
        return r5;
    L6:
        th = move-exception;
        r3.f10709b.compareAndSet(r4, null);
        throw th;
    }

    private static final Thread a(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "auto-memory-feedback-preview");
        r0.setDaemon(true);
        return r0;
    }

    private final void a(final a r3, Future<?> r4) {
        ((Future) ZeusTransformUtils.wrapperContextForParams(r4, Future.class, "com.obric.memorydata.plugin")).cancel(true);
        this.f10708a.execute(new $$Lambda$i$CePdupHbt0kRA1KaMvCCwCdpJ4(this, r3));     // Catch: RejectedExecutionException -> L5
        return;
    }

    private static final void a(i r1, a r2) {
        r1.f10709b.compareAndSet(r2, null);
    }

    public static /* synthetic */ Object lambda$0pmIzbDsPQ9TdtEBjhKo3ICgOdo(Function0 r0, i r1, a r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$CePdupH-bt0kRA1KaMvCCwCdpJ4, reason: not valid java name */
    public static /* synthetic */ void m815lambda$CePdupHbt0kRA1KaMvCCwCdpJ4(i r0, a r1) {
        a(r0, r1);
    }

    public static /* synthetic */ Thread lambda$CwLJlIBkIEEcIDAfTxWkygLTmN0(Runnable r0) {
        return a(r0);
    }

    public final <T> T a(long r5, Function0<? extends T> r7) {
        final Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "block");
        final a r0 = new a();
        if (this.f10709b.compareAndSet(null, r0) == true) goto L14;
        return null;
    L14:
        Future<?> r9 = this.f10708a.submit(new $$Lambda$i$0pmIzbDsPQ9TdtEBjhKo3ICgOdo(r8, this, r0));     // Catch: RejectedExecutionException -> L11
        goto L20
    L19:
        return (T) r9.get(r5, TimeUnit.MILLISECONDS);
    L8:
        Intrinsics.checkNotNull(r9);
        a(r0, r9);
        Thread.currentThread().interrupt();
        return null;
    L9:
        Intrinsics.checkNotNull(r9);
        a(r0, r9);
        return null;
    L20:
        return null;
    L11:
        this.f10709b.compareAndSet(r0, null);
        return null;
    }
}
